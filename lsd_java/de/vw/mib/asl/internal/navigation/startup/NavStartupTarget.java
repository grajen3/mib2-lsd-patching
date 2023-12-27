/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.startup;

import de.vw.mib.asl.api.navigation.map.ASLNavigationMapFactory;
import de.vw.mib.asl.api.navigation.poi.ASLNavigationPoiFactory;
import de.vw.mib.asl.api.navigation.startup.ASLNavigationStartupFactory;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.framework.api.startupv7r.ASLStartupv7rFactory;
import de.vw.mib.asl.framework.api.startupv7r.startupstate.StartupStateListener;
import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.startup.NavStartupTarget$DSIMapServiceStateListener;
import de.vw.mib.asl.internal.navigation.startup.StartupGroupManager;
import de.vw.mib.asl.internal.navigation.startup.TargetResetManager;
import de.vw.mib.asl.internal.navigation.startup.knowledge.KnowledgeBase;
import de.vw.mib.asl.internal.navigation.startup.knowledge.KnowledgeBaseObserver;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventException;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.ServiceRegister;
import de.vw.mib.log4mib.LogMessage;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.navigation.DSINavigation;
import org.dsi.ifc.navigation.DSINavigationListener;
import org.dsi.ifc.startup.DSIStartup;
import org.dsi.ifc.startup.DSIStartupListener;

public class NavStartupTarget
extends AbstractASLTarget
implements KnowledgeBaseObserver,
DSIServiceStateListener,
StartupStateListener {
    public static final int EV_ASL_STARTUP_NAV_COMPLETELY_READY_FALLBACK;
    private static final int NAV_COMPLETELY_READY_FALLBACK_TIMEOUT;
    public static final int NAVI_TARGET_SLOT0_OLD_TRAFFIC_LIGHT_STATE_INT;
    public static final int NAVI_TARGET_SLOT1_NEW_TRAFFIC_LIGHT_STATE_INT;
    private static final int[] OBSERVERS;
    private boolean informedModelAboutNaviReady;
    private boolean informedNavigationAboutAslReady;
    private boolean isPoweredOn;
    protected final KnowledgeBase knowledgeBase = KnowledgeBase.getInstance();
    private boolean navCompletelyReadySendedBackToAslStartup;
    private int lastNaviStatus = 0;
    protected DSINavigation navigationService;
    protected DSINavigationListener navigationListener;
    private boolean wasServiceStateListenerRegistered = false;
    private StartupGroupManager startupGroupManager;
    private TargetResetManager targetResetManager;
    boolean isNaviVisable = false;
    private boolean sendGuidanceContinue = false;
    private DSIStartupListener startupListener;
    static /* synthetic */ Class class$org$dsi$ifc$map$DSIMapViewerStreetViewCtrl;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigation;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigationListener;
    static /* synthetic */ Class class$org$dsi$ifc$map$DSIMapViewerControl;
    static /* synthetic */ Class class$org$dsi$ifc$startup$DSIStartup;
    static /* synthetic */ Class class$org$dsi$ifc$startup$DSIStartupListener;

    public NavStartupTarget(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
        this.init();
    }

    public NavStartupTarget(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
        this.init();
    }

    private void init() {
        this.startupGroupManager = new StartupGroupManager(this.knowledgeBase);
        this.targetResetManager = new TargetResetManager(this.startupGroupManager);
        this.knowledgeBase.registerObserver(this);
        ASLStartupv7rFactory.getStartupv7rApi().getStartupStateService().addListener(this);
    }

    private void addAslObservers() {
        this.addObservers(OBSERVERS);
        ServiceRegister serviceRegister = ServiceManager.eventMain.getServiceRegister();
        serviceRegister.registerService(392443136, 1783305216, 392443136, true);
    }

    private void registerOnlineServices() {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this.getTargetId(), -1001712640, -1953890048);
        EventGeneric eventGeneric2 = ServiceManager.mGenericEventFactory.newEvent(this.getTargetId(), -1001712640, -1987444480);
        try {
            this.send(eventGeneric);
            this.send(eventGeneric2);
        }
        catch (GenericEventException genericEventException) {
            this.getTextLogger().error(16384).attachThrowable(genericEventException).log();
        }
    }

    @Override
    public void changed(KnowledgeBase knowledgeBase) {
        if (!knowledgeBase.isFirstStartupDone() && knowledgeBase.getNavStateOfOperation() == 3) {
            this.info("NAVI-STARTUP: First startup is not done and NAVSTATEOFOPERATION_DISKREQUEST_EJECT came. Continuing ASL startup.");
            this.sendNavCompletelyReadyToAslStartup();
            this.registerOnlineServices();
        }
        if (knowledgeBase.isFirstStartupDone() && knowledgeBase.getNavStateOfOperation() == 3) {
            this.notifyLscDeregisterNavi();
        }
        if (knowledgeBase.isFirstStartupDone() && knowledgeBase.getNavStateOfOperation() != 5) {
            this.info("NAVI-STARTUP: Navi southside is not fully op anymore after the first navi startup is done. (NavDB eject)");
            this.informedModelAboutNaviReady = false;
        }
        if (knowledgeBase.isNaviRunning() && knowledgeBase.getNavStateOfOperation() == 5 && knowledgeBase.isMainMapReady() && knowledgeBase.isFirstStartupDone() && knowledgeBase.isMainMapDrawn()) {
            if (!this.informedModelAboutNaviReady) {
                this.informedModelAboutNaviReady = true;
                this.setNavStateDatapoolValues(true, 0, 1);
                this.info("NAVI-STARTUP CONTEXT NAVIGATION IS READY AND RUNNING!!");
                if (ServiceManager.perfService != null) {
                    ServiceManager.perfService.performanceLogMsgByID(13);
                }
                this.send(1917522944, -813235968, 0);
            } else if (this.isTraceEnabled()) {
                this.trace("NAVI-STARTUP: Model is not again notified, because it already was notified about fully op.");
            }
        }
        if (knowledgeBase.isNaviRunning() && knowledgeBase.getNavStateOfOperation() == 5 && knowledgeBase.isMainMapReady() && !knowledgeBase.isFirstStartupDone()) {
            this.info("NAVI-STARTUP: Notifying other parts of the system, that navi is running.");
            this.notifySystem();
            this.notifyLscRegisterNavi();
            this.sendNavCompletelyReadyToAslStartup();
            knowledgeBase.setFirstStartupDone(true);
        }
        if (knowledgeBase.isFirstStartupDone() && knowledgeBase.isAslStartupDone() && !this.informedNavigationAboutAslReady) {
            this.informedNavigationAboutAslReady = true;
            this.notifyPostAslStartup();
        }
    }

    public void dsiNavigationUpdateNavstateOfOperation(int n, int n2) {
        if (this.isTraceEnabled()) {
            this.trace("NAVI-STARTUP entered DSINAVIGATION_UPDATENAVSTATEOFOPERATION.");
        }
        if (n2 != 1) {
            if (this.isTraceEnabled()) {
                this.trace("NAVI-STARTUP entered DSINAVIGATION_UPDATENAVSTATEOFOPERATION with non valid flag");
            }
            return;
        }
        this.knowledgeBase.setNavStateOfOperation(n);
        this.onStateOfOperationUpdateTrigger(n);
        switch (n) {
            case 5: {
                if (!this.isTraceEnabled()) break;
                this.trace("NAVI-STARTUP NAVSTATEOFOPERATION_FULLY_OPERABLE");
                break;
            }
            case 3: {
                if (this.isTraceEnabled()) {
                    this.trace("NAVI-STARTUP NAVSTATEOFOPERATION_DISKREQUEST_EJECT");
                }
                this.setNavStateDatapoolValues(true, 4, 1);
                break;
            }
            case 2: {
                if (this.isTraceEnabled()) {
                    this.trace("NAVI-STARTUP NAVSTATEOFOPERATION_DISKREQUEST_DAMAGED");
                }
                this.setNavStateDatapoolValues(true, 2, 1);
                break;
            }
            case 4: {
                if (this.isTraceEnabled()) {
                    this.trace("NAVI-STARTUP NAVSTATEOFOPERATION_DISKREQUEST_DISKERROR");
                }
                this.setNavStateDatapoolValues(true, 2, 1);
                break;
            }
            case 6: {
                if (this.isTraceEnabled()) {
                    this.trace("NAVI-STARTUP NAVSTATEOFOPERATION_NOT_COMPATIBLE");
                }
                this.setNavStateDatapoolValues(true, 2, 1);
                break;
            }
            case 9: {
                this.info("NAVI-STARTUP NAVSTATEOFOPERATION_NO_COMPLETE_DATA Continuing ASL Startup.");
                this.setNavStateDatapoolValues(true, 2, 1);
                this.sendNavCompletelyReadyToAslStartup();
                break;
            }
            case 1: {
                this.info("NAVI-STARTUP NAVSTATEOFOPERATION_DISKREQUEST_NOT_ACTIVATED Continuing ASL Startup.");
                this.setNavStateDatapoolValues(true, 3, 1);
                this.sendNavCompletelyReadyToAslStartup();
                break;
            }
            case 10: {
                if (this.isTraceEnabled()) {
                    this.trace("NAVI-STARTUP NAVSTATEOFOPERATION_REINITIALISATION");
                }
                this.setNavStateDatapoolValues(true, 1, 1);
                break;
            }
            case 8: {
                if (this.isTraceEnabled()) {
                    this.trace("NAVI-STARTUP NAVSTATEOFOPERATION_CHECKING_MEDIUM");
                }
                if (this.knowledgeBase.isFirstStartupDone()) {
                    this.info("NAVI-STARTUP NAVSTATEOFOPERATION_CHECKING_MEDIUM came after navi startup is done. Showing popup.");
                    this.setNavStateDatapoolValues(true, 1, 1);
                    break;
                }
                if (this.navCompletelyReadySendedBackToAslStartup) {
                    this.info("NAVI-STARTUP NAVSTATEOFOPERATION_CHECKING_MEDIUM came, but first startup is not done, but navCompletelyReadySendedBackToAslStartup was sended back to ASL startup. This happens, when the system starts without SD card and the SD card is inserted afterwards. Showing popup.");
                    this.setNavStateDatapoolValues(true, 1, 1);
                    break;
                }
                this.info("NAVI-STARTUP NAVSTATEOFOPERATION_CHECKING_MEDIUM came while navi startup is still ongoing. Not showing Popup.");
                break;
            }
            case 11: {
                this.info("NAVI-STARTUP NAVSTATEOFOPERATION_LOCKED Continuing ASL Startup.");
                this.setNavStateDatapoolValues(true, 3, 1);
                this.sendNavCompletelyReadyToAslStartup();
                break;
            }
            case 12: {
                this.info("NAVI-STARTUP NAVSTATEOFOPERATION_READY4NAV Continuing ASL Startup.");
                this.setNavStateDatapoolValues(true, 3, 3);
                this.info("Navi is not unlocked on system. If Navi is nevertheless starting now something went wrong and TOP POIs could be empty!");
                this.sendNavCompletelyReadyToAslStartup();
                break;
            }
            case 7: {
                if (this.isTraceEnabled()) {
                    this.trace("NAVI-STARTUP NAVSTATEOFOPERATION_NOT_IDENTICAL_MEDIUM");
                }
                this.setNavStateDatapoolValues(true, 3, 1);
                break;
            }
            case 13: {
                if (!this.isTraceEnabled()) break;
                this.trace("NAVI-STARTUP NAVSTATEOFOPERATION_GLOVE_BOX_OPEN");
                this.trace("Target Navigation - These NavStates are not handled and should not happen on a VW target.");
                break;
            }
            case 14: {
                if (this.isTraceEnabled()) {
                    this.trace("NAVI-STARTUP NAVSTATEOFOPERATION_REINIT_CUSTOMERUPDATE");
                }
                this.setNavStateDatapoolValues(true, 5, 1);
                break;
            }
            case 0: {
                if (!this.isTraceEnabled()) break;
                this.trace("NAVI-STARTUP NAVSTATEOFOPERATION_UNKNOWN");
                this.trace("Target Navigation - These NavStates are not handled and should not happen on a VW target.");
                break;
            }
        }
    }

    private void onStateOfOperationUpdateTrigger(int n) {
        if (n != this.lastNaviStatus) {
            if (n == 5) {
                ASLNavigationStartupFactory.getNavigationStartupApi().sendEvNaviStatusChange(true);
            } else {
                ASLNavigationStartupFactory.getNavigationStartupApi().sendEvNaviStatusChange(false);
            }
            this.lastNaviStatus = n;
        }
    }

    public void dsiStartupUpdateDomainStatusNav(int n, int n2) {
        if (n2 == 1) {
            switch (n) {
                case 4: 
                case 8: 
                case 16: {
                    if (this.isPoweredOn) break;
                    this.triggerMe(106);
                    break;
                }
                case 0: 
                case 1: {
                    if (!this.isPoweredOn) break;
                    this.triggerMe(107);
                    break;
                }
            }
        }
    }

    @Override
    public int getClassifier() {
        return 1;
    }

    @Override
    public int getSubClassifier() {
        return 16384;
    }

    private void goEventPowerOff() {
        if (this.isTraceEnabled()) {
            this.trace("NAVI-STARTUP received IdEvent.POWER_OFF");
        }
        this.isPoweredOn = false;
        this.knowledgeBase.resetKnowledgeBase();
        this.setNavStateDatapoolValues(false, 4, 1);
        this.navCompletelyReadySendedBackToAslStartup = false;
        this.informedNavigationAboutAslReady = false;
        this.informedModelAboutNaviReady = false;
    }

    private void goEventPowerOn() {
        ASLNavigationUtilFactory.getNavigationUtilApi().getDebugFlags().initNavDebugFlags();
        if (this.isTraceEnabled()) {
            this.trace("NAVI-STARTUP received IdEvent.POWER_ON");
        }
        this.isPoweredOn = true;
        ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().loadPersistables();
        this.knowledgeBase.setNavDomainState(4);
        this.initDSIServiceStateListener();
        this.notifyDisplayManagementMapDisplayableReady();
        this.addAslObservers();
        this.startTimerAslStartupNavCompletlyReadyFallback();
    }

    void googleStreetViewAvaiable() {
        ServiceManager.aslPropertyManager.valueChangedBoolean(3714, true);
    }

    void googleStreetViewNotAvaiable() {
        ServiceManager.aslPropertyManager.valueChangedBoolean(3714, false);
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                this.goEventPowerOn();
                break;
            }
            case 107: {
                this.goEventPowerOff();
                break;
            }
            case 100001: {
                this.gotEventAslStartupNavCompletlyReadyFallback();
                break;
            }
            case 1073742285: {
                this.gotEventModelResetDone();
                break;
            }
            case 1073744063: {
                this.gotEventControlBarPoiIsPushupOpened();
                break;
            }
            case 3499014: {
                this.gotEventMainMapReady();
                break;
            }
            case 3499015: {
                this.gotEventMainMapNotReady();
                break;
            }
            case 3499012: 
            case 3499016: {
                this.gotEventMapInMapReady();
                break;
            }
            case 3499046: {
                this.gotEventMapMainDrawn();
                break;
            }
            case 3499013: 
            case 3499017: {
                this.gotEventMapInMapNotReady();
                break;
            }
        }
    }

    private void gotEventMapMainDrawn() {
        if (this.isTraceEnabled()) {
            this.trace("gotEventMapMainDrawn()");
        }
        this.knowledgeBase.setMainMapDrawn(true);
    }

    private void gotEventMapInMapNotReady() {
        if (this.isTraceEnabled()) {
            this.trace("gotEventMapInMapNotReady()");
        }
        this.knowledgeBase.setMapInMapReady(false);
    }

    private void gotEventMainMapNotReady() {
        if (this.isTraceEnabled()) {
            this.trace("gotEventMainMapNotReady()");
        }
        this.knowledgeBase.setMainMapReady(false);
    }

    private void gotEventMainMapReady() {
        if (this.isTraceEnabled()) {
            this.trace("gotEventMainMapReady()");
        }
        this.knowledgeBase.setMainMapReady(true);
    }

    private void gotEventMapInMapReady() {
        if (this.isTraceEnabled()) {
            this.trace("gotEventMapInMapReady()");
        }
        this.knowledgeBase.setMapInMapReady(true);
    }

    private void gotEventAslStartupNavCompletlyReadyFallback() {
        LogMessage logMessage = this.error();
        logMessage.append("Target Navigation entered EV_ASL_STARTUP_NAV_COMPLETELY_READY_FALLBACK. A TIMEOUT occured in Navi-Startup. The hole ASL STARTUP was delayed by ");
        logMessage.append(1354956800);
        logMessage.append(" ms");
        logMessage.log();
        this.sendNavCompletelyReadyToAslStartup();
    }

    private void gotEventControlBarPoiIsPushupOpened() {
        if (this.isTraceEnabled()) {
            this.trace("Target Navigation entered ASL_NAVIGATION_CONTROL_BAR_POI_IS_PUSH_UP_OPENED.");
        }
        if (!ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().isTopPoisHaveBeenLoadedSuccessfully()) {
            this.error("User clicked on TOP POIs, but TOP POIs are not loaded yet. Timing issue on startup happened. Loading TOP POIs again.");
            this.loadTopPois();
        }
    }

    private void gotEventModelResetDone() {
        if (this.isTraceEnabled()) {
            this.trace("Target Navigation entered ASL_NAVIGATION_MODEL_RESET_DONE.");
        }
        ServiceManager.aslPropertyManager.valueChangedBoolean(756, false);
    }

    private void initDsiServicesNavigation() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.navigationService = (DSINavigation)dSIProxy.getService(this, class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = NavStartupTarget.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation);
        this.navigationListener = (DSINavigationListener)dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = NavStartupTarget.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener);
        dSIProxy.addResponseListener(this, class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = NavStartupTarget.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener, this.navigationListener);
        this.navigationService.setNotification(52, (DSIListener)this.navigationListener);
    }

    private void unregisterDsiServicesNavigation() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        if (dSIProxy != null && this.navigationListener != null) {
            dSIProxy.removeResponseListener(this, class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = NavStartupTarget.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener, this.navigationListener);
        }
        this.navigationListener = null;
    }

    private void initDSIServiceStateListener() {
        if (!this.wasServiceStateListenerRegistered) {
            NavStartupTarget$DSIMapServiceStateListener navStartupTarget$DSIMapServiceStateListener = new NavStartupTarget$DSIMapServiceStateListener(this);
            DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
            dSIProxy.addServiceStateListener(class$org$dsi$ifc$map$DSIMapViewerControl == null ? (class$org$dsi$ifc$map$DSIMapViewerControl = NavStartupTarget.class$("org.dsi.ifc.map.DSIMapViewerControl")) : class$org$dsi$ifc$map$DSIMapViewerControl, 1, navStartupTarget$DSIMapServiceStateListener);
            dSIProxy.addServiceStateListener(class$org$dsi$ifc$map$DSIMapViewerStreetViewCtrl == null ? (class$org$dsi$ifc$map$DSIMapViewerStreetViewCtrl = NavStartupTarget.class$("org.dsi.ifc.map.DSIMapViewerStreetViewCtrl")) : class$org$dsi$ifc$map$DSIMapViewerStreetViewCtrl, navStartupTarget$DSIMapServiceStateListener);
            dSIProxy.addServiceStateListener(class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = NavStartupTarget.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation, this);
            dSIProxy.addServiceStateListener(class$org$dsi$ifc$startup$DSIStartup == null ? (class$org$dsi$ifc$startup$DSIStartup = NavStartupTarget.class$("org.dsi.ifc.startup.DSIStartup")) : class$org$dsi$ifc$startup$DSIStartup, this);
            this.wasServiceStateListenerRegistered = true;
        }
    }

    private void initDsiServivesStartupService() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        DSIStartup dSIStartup = (DSIStartup)dSIProxy.getService(this, class$org$dsi$ifc$startup$DSIStartup == null ? (class$org$dsi$ifc$startup$DSIStartup = NavStartupTarget.class$("org.dsi.ifc.startup.DSIStartup")) : class$org$dsi$ifc$startup$DSIStartup);
        this.startupListener = (DSIStartupListener)dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$startup$DSIStartupListener == null ? (class$org$dsi$ifc$startup$DSIStartupListener = NavStartupTarget.class$("org.dsi.ifc.startup.DSIStartupListener")) : class$org$dsi$ifc$startup$DSIStartupListener);
        dSIStartup.setNotification(6, (DSIListener)this.startupListener);
    }

    private void unregisterDsiServivesStartupService() {
        this.startupListener = null;
    }

    private void loadTopPois() {
        if (this.isTraceEnabled()) {
            this.trace("STARTPOISPELLER because user clicked on TOP POIs and list was not successfully loaded yet.");
        }
        ASLNavigationPoiFactory.getNavigationPoiApi().reloadTopPois(this.getTargetId());
    }

    private void notifyDisplayManagementMapDisplayableReady() {
        this.triggerObserver(618009344, null);
    }

    private void notifyLscDeregisterNavi() {
        EventGeneric eventGeneric = ServiceManager.eventMain.getEventFactory().newEvent(this.getTargetId(), 5150, 1117519872);
        eventGeneric.setInt(0, 2034963456);
        this.send(eventGeneric);
    }

    private void notifyLscRegisterNavi() {
        if (this.isTraceEnabled()) {
            this.trace("Notifying Bullhorn(LSC), that we are ready.");
        }
        try {
            EventGeneric eventGeneric = ServiceManager.eventMain.getEventFactory().newEvent(this.getTargetId(), 5150, 1083965440);
            eventGeneric.setInt(0, 2034963456);
            eventGeneric.setInt(1, 6);
            eventGeneric.setString(2, ASLNavigationUtilFactory.getNavigationUtilApi().getNavGateway().getLanguage());
            this.send(eventGeneric);
        }
        catch (GenericEventException genericEventException) {
            this.warn("Target Navigation - failed to notify LSC that navigation context is up.");
        }
    }

    private void notifyPostAslStartup() {
        ASLNavigationMapFactory.getNavigationMapApi().sendEvNaviPostStartup();
    }

    private void notifySystem() {
        if (this.isTraceEnabled()) {
            this.trace("Notifying System, that we are ready.");
        }
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(1498092544, 5602, 5);
        this.getEventDispatcher().send(eventGeneric);
    }

    @Override
    public void registered(String string, int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("NavStartupTarget registered ").append(string).log();
        }
        if (string.intern() == (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = NavStartupTarget.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName().intern()) {
            this.initDsiServicesNavigation();
        } else if (string.intern() == (class$org$dsi$ifc$startup$DSIStartup == null ? (class$org$dsi$ifc$startup$DSIStartup = NavStartupTarget.class$("org.dsi.ifc.startup.DSIStartup")) : class$org$dsi$ifc$startup$DSIStartup).getName().intern()) {
            this.initDsiServivesStartupService();
        }
    }

    private void sendNavCompletelyReadyToAslStartup() {
        if (!this.navCompletelyReadySendedBackToAslStartup) {
            this.navCompletelyReadySendedBackToAslStartup = true;
            if (this.isTraceEnabled()) {
                this.trace("NAVI-STARTUP: Sending EV_NAV_IS_COMPLETELY_READY event to ASL Startup.");
            }
            this.stopTimer(-1585053440);
            this.send(5900, -813235968, 0);
        } else if (this.isTraceEnabled()) {
            this.trace("NAVI-STARTUP: Not sending EV_NAV_IS_COMPLETELY_READY event back to ASL Startup, because it already was sended back.");
        }
    }

    private void setNavOperationStateForBap(boolean bl, int n) {
        int n2;
        int n3 = bl ? 1 : 0;
        switch (n) {
            case 0: {
                n2 = 0;
                break;
            }
            case 1: {
                n2 = 1;
                n3 = 0;
                break;
            }
            case 2: 
            case 3: {
                n2 = 2;
                break;
            }
            case 4: {
                n2 = 1;
                break;
            }
            default: {
                n2 = 0;
            }
        }
        ServiceManager.aslPropertyManager.valueChangedInteger(735, n3);
        ServiceManager.aslPropertyManager.valueChangedInteger(733, n2);
    }

    private void setNavStateDatapoolValues(boolean bl, int n, int n2) {
        boolean bl2;
        ServiceManager.aslPropertyManager.valueChangedBoolean(758, bl);
        ServiceManager.aslPropertyManager.valueChangedInteger(757, n);
        ServiceManager.aslPropertyManager.valueChangedInteger(1676, n2);
        this.setNavOperationStateForBap(bl, n);
        boolean bl3 = bl2 = bl && n == 0 && 1 == n2;
        if (this.isNaviVisable != bl2 && !bl2) {
            if (this.isTraceEnabled()) {
                this.trace("NAVI-STARTUP: Navstate of operation has changed -> Reset model. Only when we LOOSE FULLY_OPERABLE.");
            }
            ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().resetNavigationModel();
            this.isNaviVisable = bl2;
            this.sendGuidanceContinue = true;
        }
        if (this.isTraceEnabled()) {
            LogMessage logMessage = this.trace();
            logMessage.append("Navi-Startup: Changing NavState Datapool State: Loaded / DatabaseValid / DomainState: ");
            logMessage.append(bl);
            logMessage.append(" / ");
            logMessage.append(n);
            logMessage.append(" / ");
            logMessage.append(n2);
            logMessage.log();
        }
    }

    private void startTimerAslStartupNavCompletlyReadyFallback() {
        this.startTimer(-1585053440, (long)0, false);
    }

    @Override
    public void unregistered(String string, int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("NavStartupTarget tries to unregister from ").append(string).log();
        }
        try {
            if (string.intern() == (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = NavStartupTarget.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName().intern()) {
                this.unregisterDsiServicesNavigation();
            } else if (string.intern() == (class$org$dsi$ifc$startup$DSIStartup == null ? (class$org$dsi$ifc$startup$DSIStartup = NavStartupTarget.class$("org.dsi.ifc.startup.DSIStartup")) : class$org$dsi$ifc$startup$DSIStartup).getName().intern()) {
                this.unregisterDsiServivesStartupService();
            }
            if (this.isTraceEnabled()) {
                this.trace().append("NavStartupTarget unregistered from ").append(string).log();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleDsiError(exception);
        }
    }

    @Override
    public int getDefaultTargetId() {
        return 1783305216;
    }

    @Override
    public void onStartupStateChanged(int n) {
        switch (n) {
            case 1: {
                break;
            }
            case 0: {
                break;
            }
            case 2: {
                try {
                    this.handleStartupIsDone();
                }
                catch (Exception exception) {
                    ServiceManager.errorHandler.handleStartupError(exception);
                }
                break;
            }
        }
    }

    private void handleStartupIsDone() {
        if (this.isTraceEnabled()) {
            this.trace("Target Navigation entered ASL_STARTUP_IS_DONE.");
        }
        this.knowledgeBase.setAslStartupDone(true);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        OBSERVERS = new int[]{-855572416, -1089994688, 107230464, 124007680, 140784896, 157562112, 73676032, 90453248};
    }
}

