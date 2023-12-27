/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.setup.trafficmap;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.api.navigation.util.factoryreset.FactoryResetParticipantWithCallback;
import de.vw.mib.asl.api.navigation.util.factoryreset.TargetForResetNavigation;
import de.vw.mib.asl.api.online.ASLOnlineCoreServices;
import de.vw.mib.asl.api.online.ASLOnlineFactory;
import de.vw.mib.asl.api.online.ASLOnlineServiceListener;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.map.setup.trafficmap.PersistedTrafficSetup;
import de.vw.mib.asl.internal.navigation.map.setup.trafficmap.TrafficMapSetupHsmTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public class TrafficMapSetupStateWork
extends AbstractHsmState
implements TargetForResetNavigation,
ASLOnlineServiceListener {
    private final IExtLogger logger;
    final TrafficMapSetupHsmTarget target;
    private FactoryResetParticipantWithCallback navigationResetParticipant;
    private boolean onlineServiceAvailable = false;
    private boolean onlineServiceFirstUpdate = true;
    private final ASLOnlineCoreServices onlineCoreServices = ASLOnlineFactory.getOnlineCoreServices();

    public TrafficMapSetupStateWork(TrafficMapSetupHsmTarget trafficMapSetupHsmTarget, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[TrafficMapSetupStateWork]");
        this.target = trafficMapSetupHsmTarget;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.handleEntry();
                break;
            }
            case 4: {
                this.handleExit();
                break;
            }
            case 3: {
                this.handleStart();
                break;
            }
            case 1073744779: {
                this.handleShowTrafficFreeFlow(eventGeneric);
                break;
            }
            case 1073744780: {
                this.handleShowTrafficCongestions(eventGeneric);
                break;
            }
            case 1073744781: {
                this.handleShowTrafficIncidents(eventGeneric);
                break;
            }
            case 1073744590: {
                this.handleSetOnlineTrafficVisible(eventGeneric);
                break;
            }
            case 1073744382: {
                this.target.handleSDARSShowSpeedAndFlowData(eventGeneric);
                break;
            }
            case 40661: {
                this.target.handleSDARSTrafficSubscriptionState(eventGeneric);
                break;
            }
            case 1074841961: {
                this.handleSetVICSTrafficFlowType(eventGeneric);
                break;
            }
            default: {
                this.handleDefault(eventGeneric);
                return this.myParent;
            }
        }
        return null;
    }

    private void handleSetVICSTrafficFlowType(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleSetVICSTrafficFlowType(").append(n).append(")").log();
        }
        this.target.datapool.setSpeedAndFlowRoadClass(n);
        switch (n) {
            case 0: {
                this.target.notifierDSI.setSpeedAndFlowRoadClass(4);
                this.target.notifierModel.notifyVicsTrafficFlowTypeAllRoads();
                break;
            }
            case 1: {
                this.target.notifierDSI.setSpeedAndFlowRoadClass(1);
                this.target.notifierModel.notifyVicsTrafficFlowTypeHighways();
                break;
            }
            case 2: {
                this.target.notifierDSI.setSpeedAndFlowRoadClass(2);
                this.target.notifierModel.notifyVicsTrafficFlowTypeNormalRoads();
                break;
            }
            case 3: {
                this.target.notifierDSI.setSpeedAndFlowRoadClass(3);
                this.target.notifierModel.notifyVicsTrafficFlowTypeAutomatic();
                break;
            }
            default: {
                this.target.notifierDSI.setSpeedAndFlowRoadClass(3);
                this.target.notifierModel.notifyVicsTrafficFlowTypeAutomatic();
            }
        }
    }

    private void handleSetOnlineTrafficVisible(EventGeneric eventGeneric) {
        boolean bl = eventGeneric.getBoolean(0);
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleSetOnlineTrafficVisible(").append(bl).append(")").log();
        }
        this.target.setMainMapShowSpeedAndFlow(bl, true);
        this.target.configureVisibleTrafficInformationDSI();
        if (bl) {
            this.target.notifierModel.notifyOnlineTrafficVisible();
        } else {
            this.target.notifierModel.notifyOnlineTrafficInvisible();
        }
    }

    protected void handleServiceOnlineTrafficAvailable() {
        this.target.notifierModel.notifySpeedAndFlowButtonEnabled();
        this.target.datapool.setOnlineTrafficLicenseValid(true);
        this.target.datapool.setOnlineTrafficServiceAvailable(true);
        this.target.notifierModel.notifyOnlineTrafficVisible();
        this.target.setMainMapShowSpeedAndFlow(true, true);
        this.target.configureVisibleTrafficInformationDSI();
    }

    protected void handleServiceOnlineTrafficNotAvailable() {
        if (!(TrafficMapSetupHsmTarget.isSDARSFeatureSet() || TrafficMapSetupHsmTarget.isCHN() || TrafficMapSetupHsmTarget.isJP())) {
            this.target.setMainMapShowSpeedAndFlow(false, true);
            this.target.notifierModel.notifySpeedAndFlowButtonDisabled();
        }
        this.target.datapool.setOnlineTrafficLicenseValid(false);
        this.target.datapool.setOnlineTrafficServiceAvailable(false);
    }

    private void handleDefault(EventGeneric eventGeneric) {
        this.logger.trace("handleDefault()");
    }

    private void handleEntry() {
        this.logger.trace("handleEntry()");
        this.onlineCoreServices.registerForServiceUpdate(this.onlineCoreServices.getServiceIDWithNumericServiceID(1), this);
        if (this.navigationResetParticipant == null) {
            this.navigationResetParticipant = ASLNavigationUtilFactory.getNavigationUtilApi().createFactoryResetParticipantForNavigationDomainAndAddToService(this);
        }
    }

    private void handleExit() {
        this.logger.trace("handleExit()");
        this.onlineCoreServices.unRegisterForServiceUpdate(this.onlineCoreServices.getServiceIDWithNumericServiceID(1), this);
        if (this.navigationResetParticipant != null) {
            ASLNavigationUtilFactory.getNavigationUtilApi().removeNavigationResetParticipantFromService(this.navigationResetParticipant);
            this.navigationResetParticipant = null;
        }
    }

    private void handleShowTrafficCongestions(EventGeneric eventGeneric) {
        this.logger.trace("handleShowTrafficCongestions()");
        boolean bl = eventGeneric.getBoolean(0);
        this.target.datapool.setTrafficShowCongestion(bl);
        this.target.setMainMapShowSpeedAndFlow(true, false);
        this.target.configureVisibleTrafficInformationDSI();
        this.target.notifierModel.notifyShowTrafficCongestions(bl);
    }

    private void handleShowTrafficFreeFlow(EventGeneric eventGeneric) {
        this.logger.trace("handleShowTrafficFreeFlow()");
        boolean bl = eventGeneric.getBoolean(0);
        this.target.datapool.setTrafficShowFreeFlow(bl);
        this.target.setMainMapShowSpeedAndFlow(true, false);
        this.target.configureVisibleTrafficInformationDSI();
        this.target.notifierModel.notifyShowTrafficFreeFlow(bl);
    }

    private void handleShowTrafficIncidents(EventGeneric eventGeneric) {
        this.logger.trace("handleShowTrafficIncidents()");
        boolean bl = eventGeneric.getBoolean(0);
        this.target.datapool.setTrafficShowIncidents(bl);
        this.target.notifierDSI.setTrafficShowIncidents(bl);
        this.target.notifierModel.notifyShowTrafficIncidents(bl);
    }

    private void handleStart() {
        this.logger.trace("handleStart()");
        this.onlineServiceFirstUpdate = true;
        this.configureVisibleTrafficInformation();
    }

    private void configureVisibleTrafficInformation() {
        this.logger.trace("configureVisibleTrafficInformations()");
        this.target.configureVisibleTrafficInformationDSI();
        boolean bl = this.target.datapool.isMainMapShowSpeedAndFlow();
        if (bl) {
            this.target.notifierModel.notifyOnlineTrafficVisible();
        } else {
            this.target.notifierModel.notifyOnlineTrafficInvisible();
        }
    }

    @Override
    public void handleNavigationSettingsReset() {
        this.logger.trace("handleResetNavigationSettings()");
        PersistedTrafficSetup.getInstance().clear();
        if (!TrafficMapSetupHsmTarget.isSDARSFeatureSet()) {
            boolean bl = this.target.datapool.isTrafficShowFreeFlow();
            this.target.notifierModel.notifyShowTrafficFreeFlow(bl);
            boolean bl2 = this.target.datapool.isTrafficShowCongestion();
            this.target.notifierModel.notifyShowTrafficCongestions(bl2);
            boolean bl3 = this.target.datapool.isTrafficShowIncidents();
            this.target.notifierDSI.setTrafficShowIncidents(bl3);
            this.target.notifierModel.notifyShowTrafficIncidents(bl3);
            if (ServiceManager.configManagerDiag.isFeatureFlagSet(472)) {
                this.target.notifierModel.notifyVicsTrafficFlowTypeAutomatic();
                this.target.notifierDSI.setSpeedAndFlowRoadClass(3);
            }
            this.target.forwardValuesToKombi(bl2, bl, bl3);
            if (this.target.datapool.isMainMapShowSpeedAndFlow() && !TrafficMapSetupHsmTarget.isCHN() && !TrafficMapSetupHsmTarget.isJP()) {
                this.target.notifierModel.notifySpeedAndFlowButtonEnabled();
                if (this.target.datapool.isOnlineTrafficServiceAvailable() && this.target.datapool.isOnlineTrafficLicenseValid()) {
                    this.target.notifierModel.notifyOnlineTrafficVisible();
                } else {
                    this.target.setMainMapShowSpeedAndFlow(false, false);
                    this.target.notifierModel.notifyOnlineTrafficInvisible();
                }
                this.target.configureVisibleTrafficInformationDSI();
            } else {
                this.configureVisibleTrafficInformation();
            }
        } else if (this.target.datapool.isSDARSTrafficLicenseValid()) {
            this.target.notifierModel.notifyTrafficSDARSSubscribed(true);
            this.target.notifierModel.notifyTrafficSDARSAvailable(true);
            this.target.setSDARSTrafficVisibility(this.target.datapool.isMainMapShowSpeedAndFlow());
        } else {
            this.target.notifierModel.notifyTrafficSDARSSubscribed(false);
            this.target.notifierModel.notifyTrafficSDARSAvailable(true);
            this.target.setSDARSTrafficVisibility(false);
        }
        this.navigationResetParticipant.notifyResetDone();
    }

    @Override
    public void updateServiceStatusOnChange(int n) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("updateServiceStatusOnChange:: result=").append(n).log();
        }
        switch (n) {
            case 0: 
            case 7: {
                this.target.datapool.setOnlineTrafficServiceAvailable(true);
                if (this.onlineServiceAvailable && !this.onlineServiceFirstUpdate) break;
                this.onlineServiceFirstUpdate = false;
                this.onlineServiceAvailable = true;
                this.handleServiceOnlineTrafficAvailable();
                break;
            }
            default: {
                if (!this.onlineServiceAvailable && !this.onlineServiceFirstUpdate) break;
                this.onlineServiceFirstUpdate = false;
                this.onlineServiceAvailable = false;
                this.handleServiceOnlineTrafficNotAvailable();
            }
        }
    }
}

