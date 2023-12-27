/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.setup.trafficmap;

import de.vw.mib.asl.api.navigation.map.ASLNavigationMapFactory;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.api.navigation.util.ReloadPersistedDataListener;
import de.vw.mib.asl.api.online.ASLOnlineCoreServices;
import de.vw.mib.asl.api.online.ASLOnlineFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.AbstractResettableAslHsmTarget;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.DSIMapViewerControlFactoryVW;
import de.vw.mib.asl.internal.navigation.map.setup.trafficmap.TrafficMapSetupDatapool;
import de.vw.mib.asl.internal.navigation.map.setup.trafficmap.TrafficMapSetupHsmTarget$1;
import de.vw.mib.asl.internal.navigation.map.setup.trafficmap.TrafficMapSetupNotifierDSI;
import de.vw.mib.asl.internal.navigation.map.setup.trafficmap.TrafficMapSetupNotifierModel;
import de.vw.mib.asl.internal.navigation.map.setup.trafficmap.TrafficMapSetupStateInit;
import de.vw.mib.asl.internal.navigation.map.setup.trafficmap.TrafficMapSetupStateRestart;
import de.vw.mib.asl.internal.navigation.map.setup.trafficmap.TrafficMapSetupStateWork;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import java.util.HashMap;

public class TrafficMapSetupHsmTarget
extends AbstractResettableAslHsmTarget
implements ReloadPersistedDataListener {
    protected final ASLOnlineCoreServices aslOnlineCoreServices;
    final TrafficMapSetupDatapool datapool;
    protected final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[TrafficMapSetupHsmTarget]");
    final TrafficMapSetupNotifierDSI notifierDSI;
    final TrafficMapSetupNotifierModel notifierModel;
    private final HsmState stateInit;
    private final HsmState stateWork;
    private HsmState stateRestart;
    static /* synthetic */ Class class$org$dsi$ifc$map$DSIMapViewerControl;

    public TrafficMapSetupHsmTarget(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
        this.aslOnlineCoreServices = ASLOnlineFactory.getOnlineCoreServices();
        this.datapool = new TrafficMapSetupDatapool();
        this.notifierDSI = new TrafficMapSetupNotifierDSI();
        this.notifierModel = new TrafficMapSetupNotifierModel();
        this.stateInit = new TrafficMapSetupStateInit(this, this.hsm, "stateInit", this.getWorkStateParent());
        this.stateWork = new TrafficMapSetupStateWork(this, this.hsm, "stateWork", this.stateInit);
        this.stateRestart = new TrafficMapSetupStateRestart(this, this.hsm, "stateRestart", this.stateWork);
        ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().addReloadPersistedDataListener(this);
    }

    protected void configureVisibleTrafficInformationDSI() {
        boolean bl;
        this.logger.trace("configureVisibleTrafficInformationDSI()");
        if (!this.datapool.isMainMapShowSpeedAndFlow()) {
            this.notifierDSI.dsiMapViewerMainSetTrafficMapStyleFalse();
            this.notifierDSI.setTrafficShowCongestion(false);
            this.notifierDSI.setTrafficShowFreeFlow(false);
            ASLNavigationMapFactory.getNavigationMapApi().sendEvMapForwardTrafficVisibilityToKombi(false, false);
            return;
        }
        boolean bl2 = this.datapool.isTrafficShowCongestion();
        boolean bl3 = this.datapool.isTrafficShowFreeFlow();
        boolean bl4 = bl = bl2 || bl3;
        if (bl) {
            this.notifierDSI.dsiMapViewerMainSetTrafficMapStyleTrue();
        } else {
            this.notifierDSI.dsiMapViewerMainSetTrafficMapStyleFalse();
        }
        this.notifierDSI.setTrafficShowCongestion(bl2);
        this.notifierDSI.setTrafficShowFreeFlow(bl3);
        ASLNavigationMapFactory.getNavigationMapApi().sendEvMapForwardTrafficVisibilityToKombi(bl2, bl3);
    }

    @Override
    protected HsmState getDefaultState() {
        return this.stateInit;
    }

    protected void handleSDARSShowSpeedAndFlowData(EventGeneric eventGeneric) {
        boolean bl = eventGeneric.getBoolean(0);
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleSDARSShowSpeedAndFlowData(visible=").append(bl).append(")").log();
        }
        this.setSDARSTrafficVisibility(bl);
    }

    protected void handleSDARSTrafficSubscriptionState(EventGeneric eventGeneric) {
        try {
            int n = eventGeneric.getInt(0);
            if (this.logger.isTraceEnabled()) {
                this.logger.makeTrace().append("handleSDARSTrafficSubscriptionState(status=").append(n).append(")").log();
            }
            switch (n) {
                case 2: {
                    this.datapool.setSDARSTrafficLicenseValid(true);
                    this.notifierModel.notifyTrafficSDARSSubscribed(true);
                    this.notifierModel.notifyTrafficSDARSAvailable(true);
                    this.setSDARSTrafficVisibility(this.datapool.isMainMapShowSpeedAndFlow());
                    break;
                }
                case 3: {
                    this.datapool.setSDARSTrafficLicenseValid(false);
                    this.notifierModel.notifyTrafficSDARSSubscribed(false);
                    this.notifierModel.notifyTrafficSDARSAvailable(true);
                    this.setSDARSTrafficVisibility(false);
                    break;
                }
                case 4: {
                    this.datapool.setSDARSTrafficLicenseValid(false);
                    this.notifierModel.notifyTrafficSDARSAvailable(false);
                    this.setSDARSTrafficVisibility(this.datapool.isMainMapShowSpeedAndFlow());
                    break;
                }
                default: {
                    this.logger.error("SDARS Traffic Subscription: Wrong argument value!");
                    break;
                }
            }
        }
        catch (Exception exception) {
            this.logger.error(exception.toString());
        }
    }

    protected void setSDARSTrafficVisibility(boolean bl) {
        this.notifierDSI.setTrafficShowIncidents(bl);
        this.notifierDSI.setTrafficShowCongestion(bl);
        this.notifierDSI.setTrafficShowFreeFlow(bl);
        this.forwardValuesToKombi(bl, bl, bl);
        if (bl) {
            this.notifierModel.notifyTrafficSDARSVisible();
        } else {
            this.notifierModel.notifyTrafficSDARSInvisible();
        }
        this.setMainMapShowSpeedAndFlow(bl, false);
    }

    protected void transStateWork() {
        this.logger.trace("transStateWork()");
        this.getHsm().trans(this.stateWork);
        this.getHsm().activateTransition();
    }

    protected void onlineTrafficButtonActivate() {
        this.logger.trace("onlineTrafficButtonActivate()");
        this.configureVisibleTrafficInformationDSI();
        this.notifierModel.notifySpeedAndFlowButtonEnabled();
        this.transStateWork();
    }

    protected void onlineTrafficButtonUncheckAndActivate() {
        this.logger.trace("onlineTrafficButtonUncheckAndActivate()");
        this.notifierDSI.dsiMapViewerMainSetTrafficMapStyleFalse();
        this.notifierDSI.setTrafficShowCongestion(false);
        this.notifierDSI.setTrafficShowFreeFlow(false);
        ASLNavigationMapFactory.getNavigationMapApi().sendEvMapForwardTrafficVisibilityToKombi(false, false);
        this.notifierModel.notifyOnlineTrafficInvisible();
        this.notifierModel.notifySpeedAndFlowButtonEnabled();
        this.transStateWork();
    }

    protected void licenseCheck() {
        int n;
        this.logger.info("licenseCheck()");
        int n2 = this.datapool.getMainMapMapTypeLast();
        if (n2 == 1 && (n = DSIMapViewerControlFactoryVW.getMapViewerInstanceIdCurrentMain()) != n2) {
            this.logger.info("licenseCheck() - can't check the license until google earth is active");
            return;
        }
        String string = this.aslOnlineCoreServices.getServiceIDWithNumericServiceID(1);
        boolean bl = this.aslOnlineCoreServices.isServiceAvailable(string);
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleASLOnlineCoreServiceApplicationState(appId=").append(string).append(", configured=").append(bl).append(")").log();
        }
        if (bl) {
            this.aslOnlineCoreServices.checkOnlineServiceStatus(string, new TrafficMapSetupHsmTarget$1(this));
        } else {
            this.handleOnlineTrafficServiceNotAvailable();
        }
    }

    protected void handleOnlineTrafficServiceNotAvailable() {
        this.logger.info("licenseCheck() - the online traffic license is invalid");
        this.setMainMapShowSpeedAndFlow(false, true);
        this.datapool.setOnlineTrafficLicenseValid(false);
        try {
            this.onlineTrafficButtonUncheckAndActivate();
        }
        catch (Exception exception) {
            this.logger.error("can't switch to stateWork");
        }
    }

    protected void handleOnlineTrafficServiceAvailable() {
        this.logger.info("licenseCheck() - the online traffic license is valid");
        this.datapool.setOnlineTrafficLicenseValid(true);
        try {
            this.onlineTrafficButtonActivate();
        }
        catch (Exception exception) {
            this.logger.error("can't switch to stateWork");
        }
    }

    @Override
    public void reloadPersistedData() {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("reloadPersistedData").log();
        }
        if (TrafficMapSetupHsmTarget.isSDARSFeatureSet()) {
            this.setSDARSTrafficVisibility(this.datapool.isMainMapShowSpeedAndFlow());
        } else {
            boolean bl = this.datapool.isTrafficShowCongestion();
            this.notifierModel.notifyShowTrafficCongestions(bl);
            this.notifierDSI.setTrafficShowCongestion(bl);
            boolean bl2 = this.datapool.isTrafficShowFreeFlow();
            this.notifierModel.notifyShowTrafficFreeFlow(bl2);
            this.notifierDSI.setTrafficShowFreeFlow(bl2);
            boolean bl3 = this.datapool.isTrafficShowIncidents();
            this.notifierModel.notifyShowTrafficIncidents(bl3);
            this.notifierDSI.setTrafficShowIncidents(bl3);
            if (ServiceManager.configManagerDiag.isFeatureFlagSet(472)) {
                this.notifierModel.notifySpeedAndFlowRoadClass(this.datapool.getSpeedAndFlowRoadClass());
                this.notifierDSI.setSpeedAndFlowRoadClass(this.datapool.getSpeedAndFlowRoadClassDSI());
            }
            this.forwardValuesToKombi(bl, bl2, bl3);
        }
    }

    public void forwardValuesToKombi(boolean bl, boolean bl2, boolean bl3) {
        ASLNavigationMapFactory.getNavigationMapApi().sendEvMapForwardTrafficVisibilityToKombi(bl, bl2);
        ASLNavigationMapFactory.getNavigationMapApi().sendEvMapForwardTrafficIncidentVisibilityToKombi(bl3);
    }

    protected static boolean isSDARSFeatureSet() {
        return ServiceManager.configManagerDiag.isFeatureFlagSet(238);
    }

    protected static boolean isJP() {
        return ServiceManager.configManagerDiag.isFeatureFlagSet(75);
    }

    protected static boolean isCHN() {
        return ServiceManager.configManagerDiag.isFeatureFlagSet(26);
    }

    protected void setMainMapShowSpeedAndFlow(boolean bl, boolean bl2) {
        boolean bl3;
        boolean bl4 = bl2 && !TrafficMapSetupHsmTarget.isSDARSFeatureSet() && !TrafficMapSetupHsmTarget.isCHN() && !TrafficMapSetupHsmTarget.isJP();
        boolean bl5 = !bl2 && TrafficMapSetupHsmTarget.isSDARSFeatureSet() && !TrafficMapSetupHsmTarget.isCHN() && !TrafficMapSetupHsmTarget.isJP();
        boolean bl6 = !bl2 && !TrafficMapSetupHsmTarget.isSDARSFeatureSet() && TrafficMapSetupHsmTarget.isCHN() && !TrafficMapSetupHsmTarget.isJP();
        boolean bl7 = bl3 = !bl2 && !TrafficMapSetupHsmTarget.isSDARSFeatureSet() && !TrafficMapSetupHsmTarget.isCHN() && TrafficMapSetupHsmTarget.isJP();
        if (bl) {
            this.datapool.setMainMapShowSpeedAndFlow(true);
            this.logger.trace("setMainMapShowSpeedAndFlow() = true");
        } else if (bl4 || bl5 || bl6 || bl3) {
            this.datapool.setMainMapShowSpeedAndFlow(false);
            this.logger.trace(new StringBuffer().append("isOnlineCall = ").append(bl4).append(" isSDARSCall = ").append(bl5).append(" isCHNCall = ").append(bl6).append(" isJPNCall= ").append(bl3).toString());
            this.logger.trace("setMainMapShowSpeedAndFlow() = false");
        }
    }

    @Override
    public void reset(HashMap hashMap) {
        if (this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$map$DSIMapViewerControl == null ? (class$org$dsi$ifc$map$DSIMapViewerControl = TrafficMapSetupHsmTarget.class$("org.dsi.ifc.map.DSIMapViewerControl")) : class$org$dsi$ifc$map$DSIMapViewerControl).getName(), 0)) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("resetting values after DSI restart");
            }
            this.resetHsmToState(this.stateRestart);
        } else if (this.logger.isTraceEnabled()) {
            this.logger.trace("no reset necessary because restarted DSI(s) is/are not used in target");
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

