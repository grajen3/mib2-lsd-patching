/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.setup.trafficmap;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.api.online.ASLOnlineCoreServices;
import de.vw.mib.asl.api.online.ASLOnlineFactory;
import de.vw.mib.asl.api.online.ASLOnlineServiceListener;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.map.dsi.DSIMapViewerControlVW;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.DSIMapViewerControlFactoryVW;
import de.vw.mib.asl.internal.navigation.map.setup.trafficmap.TrafficMapSetupHsmTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public class TrafficMapSetupStateInit
extends AbstractHsmState
implements ASLOnlineServiceListener {
    private static final int[] ASL_OBSERVER = new int[]{-1962213312, -1945436096, -1928658880, -32964544, -838205376, -711065600, 1774784576, 107230464};
    private static final int[] ATTRIBUTES_TRAFFIC_MAP_SETUP = new int[0];
    private final IExtLogger logger;
    private final TrafficMapSetupHsmTarget target;
    private boolean onlineServiceAvailable = false;
    private boolean onlineServiceFirstUpdate = true;
    private final ASLOnlineCoreServices onlineCoreServices = ASLOnlineFactory.getOnlineCoreServices();

    public TrafficMapSetupStateInit(TrafficMapSetupHsmTarget trafficMapSetupHsmTarget, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[TrafficMapSetupStateInit]");
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
            case 40661: {
                this.target.handleSDARSTrafficSubscriptionState(eventGeneric);
                break;
            }
            case 1073744382: {
                this.target.handleSDARSShowSpeedAndFlowData(eventGeneric);
                break;
            }
            default: {
                this.handleDefault(eventGeneric);
                return this.myParent;
            }
        }
        return null;
    }

    private void handleServiceOnlineTrafficAvailable() {
        this.target.setMainMapShowSpeedAndFlow(true, true);
        this.target.datapool.setOnlineTrafficServiceAvailable(true);
        this.target.datapool.setOnlineTrafficLicenseValid(true);
        this.target.notifierModel.notifyOnlineTrafficVisible();
        this.target.notifierModel.notifySpeedAndFlowButtonEnabled();
        this.target.configureVisibleTrafficInformationDSI();
        this.target.transStateWork();
    }

    private void handleServiceOnlineTrafficNotAvailable() {
        if (!(TrafficMapSetupHsmTarget.isSDARSFeatureSet() || TrafficMapSetupHsmTarget.isCHN() || TrafficMapSetupHsmTarget.isJP())) {
            this.target.setMainMapShowSpeedAndFlow(false, true);
            this.target.notifierModel.notifySpeedAndFlowButtonDisabled();
        }
        this.target.datapool.setOnlineTrafficServiceAvailable(false);
        this.target.datapool.setOnlineTrafficLicenseValid(false);
        this.target.notifierModel.notifyOnlineTrafficInvisible();
        this.target.configureVisibleTrafficInformationDSI();
        this.target.transStateWork();
    }

    private void handleDefault(EventGeneric eventGeneric) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleDefault() ").append(eventGeneric).log();
        }
    }

    private void handleEntry() {
        this.logger.trace("handleEntry()");
        this.onlineCoreServices.registerForServiceUpdate(this.onlineCoreServices.getServiceIDWithNumericServiceID(1), this);
    }

    private void handleExit() {
        this.logger.trace("handleExit()");
        this.onlineCoreServices.unRegisterForServiceUpdate(this.onlineCoreServices.getServiceIDWithNumericServiceID(1), this);
    }

    private void handleStart() {
        this.logger.trace("handleStart()");
        DSIMapViewerControlVW dSIMapViewerControlVW = DSIMapViewerControlFactoryVW.createMapViewerMain(this.target, ATTRIBUTES_TRAFFIC_MAP_SETUP);
        this.target.notifierDSI.setMapViewerControl(dSIMapViewerControlVW);
        this.onlineServiceFirstUpdate = true;
        this.target.addObservers(ASL_OBSERVER);
        if (TrafficMapSetupHsmTarget.isSDARSFeatureSet()) {
            this.target.transStateWork();
        } else if (TrafficMapSetupHsmTarget.isCHN() || TrafficMapSetupHsmTarget.isJP()) {
            boolean bl = this.target.datapool.isTrafficShowFreeFlow();
            this.target.notifierModel.notifyShowTrafficFreeFlow(bl);
            boolean bl2 = this.target.datapool.isTrafficShowCongestion();
            this.target.notifierModel.notifyShowTrafficCongestions(bl2);
            boolean bl3 = this.target.datapool.isTrafficShowIncidents();
            this.target.notifierDSI.setTrafficShowIncidents(bl3);
            this.target.notifierModel.notifyShowTrafficIncidents(bl3);
            if (ServiceManager.configManagerDiag.isFeatureFlagSet(472)) {
                this.target.notifierModel.notifySpeedAndFlowRoadClass(this.target.datapool.getSpeedAndFlowRoadClass());
                this.target.notifierDSI.setSpeedAndFlowRoadClass(this.target.datapool.getSpeedAndFlowRoadClassDSI());
            }
            if (!this.target.datapool.isMainMapShowSpeedAndFlow()) {
                this.target.notifierModel.notifySpeedAndFlowButtonEnabled();
            } else {
                this.target.notifierModel.notifySpeedAndFlowButtonDisabled();
                this.target.notifierModel.notifyOnlineTrafficVisible();
            }
            this.target.transStateWork();
        } else {
            boolean bl = this.target.datapool.isTrafficShowFreeFlow();
            this.target.notifierModel.notifyShowTrafficFreeFlow(bl);
            boolean bl4 = this.target.datapool.isTrafficShowCongestion();
            this.target.notifierModel.notifyShowTrafficCongestions(bl4);
            boolean bl5 = this.target.datapool.isTrafficShowIncidents();
            this.target.notifierDSI.setTrafficShowIncidents(bl5);
            this.target.notifierModel.notifyShowTrafficIncidents(bl5);
            if (!this.target.datapool.isMainMapShowSpeedAndFlow()) {
                this.target.notifierModel.notifySpeedAndFlowButtonEnabled();
                this.target.transStateWork();
            } else {
                this.target.notifierModel.notifySpeedAndFlowButtonDisabled();
                this.target.notifierModel.notifyOnlineTrafficVisible();
            }
        }
    }

    @Override
    public void updateServiceStatusOnChange(int n) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("updateServiceStatusOnChange:: result=").append(n).log();
        }
        switch (n) {
            case 0: 
            case 7: {
                if (this.onlineServiceAvailable && !this.onlineServiceFirstUpdate) break;
                this.onlineServiceFirstUpdate = false;
                this.onlineServiceAvailable = true;
                this.target.datapool.setOnlineTrafficServiceAvailable(true);
                try {
                    this.handleServiceOnlineTrafficAvailable();
                }
                catch (Exception exception) {
                    ServiceManager.errorHandler.handleError(exception);
                }
                break;
            }
            default: {
                if (!this.onlineServiceAvailable && !this.onlineServiceFirstUpdate) break;
                this.onlineServiceFirstUpdate = false;
                this.onlineServiceAvailable = false;
                try {
                    this.handleServiceOnlineTrafficNotAvailable();
                    break;
                }
                catch (Exception exception) {
                    ServiceManager.errorHandler.handleError(exception);
                }
            }
        }
    }
}

