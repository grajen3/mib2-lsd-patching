/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navmaptile;

import de.vw.mib.asl.api.navigation.ASLNavigationFactory;
import de.vw.mib.asl.api.navigation.IGuidanceLaneGuidance;
import de.vw.mib.asl.api.navigation.IGuidanceVZAVZEIcons;
import de.vw.mib.asl.api.navigation.INavServiceStateListener;
import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.api.navigation.guidance.NavigationGuidanceService;
import de.vw.mib.asl.api.navigation.map.NavigationMapService;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navmaptile.NavMapTileDatapool;
import de.vw.mib.asl.internal.navmaptile.NavMapTileNotifierModel;
import de.vw.mib.asl.internal.navmaptile.NavMapTileStateInit;
import de.vw.mib.asl.internal.navmaptile.NavMapTileStateMain;
import de.vw.mib.asl.internal.navmaptile.NavMapTileStateMainInactive;
import de.vw.mib.asl.internal.navmaptile.NavMapTileStateMainSpeechActive;
import de.vw.mib.asl.internal.navmaptile.listener.NavigationGuidanceListenerImpl;
import de.vw.mib.asl.internal.navmaptile.listener.NavigationMapListenerImpl;
import de.vw.mib.asl.internal.navmaptile.transformer.NavMapTileGuidanceVZEVZAIconsCollector;
import de.vw.mib.asl.internal.navmaptile.util.MapTileLogger;
import de.vw.mib.asl.internal.navmaptile.variant.NineTwoInchVariant;
import de.vw.mib.asl.internal.navmaptile.variant.PremiumVariant;
import de.vw.mib.asl.internal.navmaptile.variant.VariantConstants;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventException;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import generated.de.vw.mib.asl.internal.ListManager;
import org.dsi.ifc.map.Rect;

public class NavMapTileTargetHSM
extends AbstractASLHsmTarget
implements INavServiceStateListener {
    protected NavigationMapService navMapService;
    protected NavigationGuidanceService navGuidanceService;
    protected final NavigationMapListenerImpl navMapListener;
    protected final NavigationGuidanceListenerImpl navGuidanceListener;
    protected final NavMapTileNotifierModel notifierModel;
    private static final int[] ASL_OBSERVER = new int[]{1216370752, 1132484672, 1233147968, 1115707456, 1098930240, 34765312, 51542528, 68319744, 85096960, 101874176};
    protected final NavMapTileDatapool datapool;
    private final NavMapTileStateInit stateInit;
    private final NavMapTileStateMain stateMain;
    private final NavMapTileStateMainInactive stateMainInactive;
    private VariantConstants variant;
    public MapTileLogger logger = new MapTileLogger(256, "[NavMapTileTargetHSM]");
    private final NavMapTileStateMainSpeechActive stateMainSpeechActive;

    public NavMapTileTargetHSM(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
        boolean bl = ServiceManager.configManagerDiag.getPureVariant().startsWith("PREMIUM");
        this.variant = bl ? new PremiumVariant() : new NineTwoInchVariant();
        this.navMapListener = new NavigationMapListenerImpl(this);
        this.notifierModel = new NavMapTileNotifierModel();
        this.navGuidanceListener = new NavigationGuidanceListenerImpl(this);
        this.datapool = new NavMapTileDatapool(this.variant);
        this.stateInit = new NavMapTileStateInit(this, this.hsm, "stateInit", this.getWorkStateParent());
        this.stateMain = new NavMapTileStateMain(this, this.hsm, "stateMain", this.getWorkStateParent());
        this.stateMainSpeechActive = new NavMapTileStateMainSpeechActive(this, this.hsm, "stateMainSpeechActive", this.stateMain);
        this.stateMainInactive = new NavMapTileStateMainInactive(this, this.hsm, "stateInactive", this.stateMain);
    }

    public int getMainmapZoomLevel() {
        return this.navMapService.getMainMapZoomLevel();
    }

    @Override
    public int getSubClassifier() {
        return 256;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                this.logger.trace("handleNaviTargetGoOn()");
                this.notifierModel.notifyNavNotReady();
                this.initEmptyVZEVZAList();
                ASLNavigationFactory.getNavigationApi().registerNavServiceStateListener(this);
                this.addObservers(ASL_OBSERVER);
                break;
            }
        }
        super.gotEvent(eventGeneric);
    }

    @Override
    public void navServiceStateChanged() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(new StringBuffer().append("navServiceStateChanged(navState= ").append(ASLNavigationFactory.getNavigationApi().getNavigationServiceState()).append(")").toString());
        }
        if (ASLNavigationFactory.getNavigationApi().getNavigationServiceState() == 100) {
            try {
                this.triggerMe(17988096);
            }
            catch (GenericEventException genericEventException) {}
        } else {
            try {
                this.transStateInit();
                this.getHsm().activateTransition();
            }
            catch (Exception exception) {
                ServiceManager.errorHandler.handleError(exception);
            }
            this.notifierModel.notifyNavNotReady();
        }
    }

    public void notifyAltitudeValueChanged(int n) {
        this.notifierModel.notifyAltitudeValueChanged(n);
    }

    public void notifyMapTypeChanged(int n) {
        this.notifierModel.notifyMapTypeChanged(n);
    }

    public void notifyLastMapTypeChanged(int n) {
        this.notifierModel.notifyLastMapTypeChanged(n);
    }

    public void notifySpeedCameraWarning(boolean bl) {
        this.notifierModel.notifySpeedCameraWarning(bl);
    }

    public void setAutoozoom(boolean bl) {
        this.logger.trace("setAutozoom()");
        this.datapool.setAutozoomActivated(bl);
        this.notifierModel.notifyAutozoom(bl);
    }

    public void transStateMain() {
        this.logger.trace("transStateMain()");
        this.getHsm().trans(this.stateMain);
    }

    public void transStateInit() {
        this.logger.trace("transStateInit()");
        this.getHsm().trans(this.stateInit);
    }

    public void transStateMainInactive() {
        this.logger.trace("transStateMainInactive()");
        this.getHsm().trans(this.stateMainInactive);
    }

    public void updateCollectorLaneGuidance(IGuidanceLaneGuidance[] iGuidanceLaneGuidanceArray) {
        this.notifierModel.updateCollectorLaneGuidance(iGuidanceLaneGuidanceArray);
    }

    public void updateCollectorVZAVZEIcons(IGuidanceVZAVZEIcons[] iGuidanceVZAVZEIconsArray) {
        this.notifierModel.updateCollectorVZAVZEIcons(iGuidanceVZAVZEIconsArray);
    }

    public void updateHeadingValue(int n) {
        this.logger.trace("updateHeadingValue()");
        this.notifierModel.notifyHeadingValueChanged(n);
    }

    public void updateOrientation(int n) {
        this.logger.trace("updateOrientation()");
        this.datapool.setOrientation(n);
    }

    public void updateViewType(int n) {
        this.logger.trace("updateViewType()");
        this.datapool.setViewType(n);
    }

    public void updateZoomValue(int n) {
        EventGeneric eventGeneric = ServiceManager.eventMain.getEventFactory().newEvent(34765312);
        eventGeneric.setInt(0, n);
        this.triggerMe(eventGeneric, eventGeneric.getReceiverEventId());
    }

    @Override
    protected HsmState getDefaultState() {
        return this.stateInit;
    }

    Rect getZoomArea(EventGeneric eventGeneric) {
        Rect rect = new Rect(eventGeneric.getInt(1), eventGeneric.getInt(2), eventGeneric.getInt(4), eventGeneric.getInt(3));
        return rect;
    }

    void initEmptyVZEVZAList() {
        ListManager.getGenericASLList(1571248128).updateList(new NavMapTileGuidanceVZEVZAIconsCollector[]{new NavMapTileGuidanceVZEVZAIconsCollector(), new NavMapTileGuidanceVZEVZAIconsCollector(), new NavMapTileGuidanceVZEVZAIconsCollector()});
    }

    void initServices() {
        if (this.navMapService == null && this.navGuidanceService == null) {
            this.navMapService = ASLNavigationFactory.getNavigationApi().getNavigationMapService(this.navMapListener);
            this.navGuidanceService = ASLNavigationFactory.getNavigationApi().getNavigationGuidanceService(this.navGuidanceListener);
            if (this.navMapService == null) {
                throw new NavigationServiceException("NavigationMapService is null after initialization. Was EV_NAV_SERVICE_READY send to early? Will not go to Main state.");
            }
            if (this.navGuidanceService == null) {
                throw new NavigationServiceException("NavigationGuidanceService is null after initialization. Was EV_NAV_SERVICE_READY send to early? Will not go to Main state.");
            }
        }
    }

    void setManeuverViewStyle(boolean bl) {
        if (bl) {
            this.navMapService.setManeuverViewStyle(this.variant.getManeuverViewStyleHome());
        } else {
            this.navMapService.setManeuverViewStyle(this.variant.getManeuverViewStyleMain());
        }
    }

    public void updateModel(int n) {
        if (n == 3) {
            this.notifierModel.notifyOverviewOn();
        } else {
            this.notifierModel.notifyOverviewOff();
        }
        this.notifierModel.notifyPerspectiveChanged(n);
    }

    public void setMapPerspective(int n) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(new StringBuffer().append("setMapPerspective(").append(n).append(")").toString());
        }
        this.datapool.setPerspectiveCurrent(n);
        if (n != 99) {
            if (this.isPerspectiveNoGuidanceValid(n)) {
                this.datapool.setPerspectiveNoGuidance(n);
            }
            this.datapool.setPerspective(n);
            this.updateModel(n);
        }
    }

    public boolean isPerspectiveNoGuidanceValid(int n) {
        return n != 3 && n != 1 && n != 2;
    }

    public void notifySetupTrafficSignMode(int n) {
        if (n == 0) {
            this.notifierModel.notifyTrafficSignAnnouncementOff();
        } else {
            this.notifierModel.notifyTrafficSignAnnouncementOn();
        }
    }

    public void reinitMapView() {
        EventGeneric eventGeneric = ServiceManager.eventMain.getEventFactory().newEvent(51542528);
        this.triggerMe(eventGeneric, eventGeneric.getReceiverEventId());
    }

    public void updateMapViewerUsedBy(Object object) {
        EventGeneric eventGeneric = ServiceManager.eventMain.getEventFactory().newEvent(68319744);
        this.triggerMe(eventGeneric, eventGeneric.getReceiverEventId());
    }

    public void transStateMainSpeechActive() {
        this.logger.trace("transStateMainSpeechActive()");
        this.getHsm().trans(this.stateMainSpeechActive);
    }

    public void updateGoogleEarthDataStatus(int n) {
        this.notifierModel.notifyGoogleEarthDataStatusChanged(n);
    }

    public void updateMapViewerSwitchRunning(boolean bl) {
        this.notifierModel.notifyMapSwitchRunningChanged(bl);
    }

    public void updateMapMode(int n) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(new StringBuffer().append("setMapMode(mapMode = ").append(n).append(")").toString());
        }
        EventGeneric eventGeneric = ServiceManager.eventMain.getEventFactory().newEvent(85096960);
        eventGeneric.setInt(0, n);
        this.triggerMe(eventGeneric, eventGeneric.getReceiverEventId());
    }

    public void updateGuidanceState(int n, int n2) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(new StringBuffer().append("updateGuidanceState(guidanceMode = ").append(n).append(" guidanceState = ").append(n2).append(")").toString());
        }
        if (n2 == 1) {
            this.datapool.setGuidanceActive(true);
        } else {
            this.datapool.setGuidanceActive(false);
        }
        EventGeneric eventGeneric = ServiceManager.eventMain.getEventFactory().newEvent(101874176);
        eventGeneric.setInt(0, n2);
        this.triggerMe(eventGeneric, eventGeneric.getReceiverEventId());
    }
}

