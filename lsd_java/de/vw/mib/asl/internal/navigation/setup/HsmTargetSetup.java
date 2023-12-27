/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.setup;

import de.vw.mib.asl.api.navigation.guidance.ASLNavigationGuidanceFactory;
import de.vw.mib.asl.api.navigation.guidance.IPersistedDestInputSetup;
import de.vw.mib.asl.api.navigation.guidance.IPersistedGuidanceSetup;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.ReloadPersistedDataListener;
import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.AbstractResettableAslHsmTarget;
import de.vw.mib.asl.internal.navigation.setup.StateSetupInitPersistence;
import de.vw.mib.asl.internal.navigation.setup.StateSetupMain;
import de.vw.mib.asl.internal.navigation.setup.StateSetupResetFactorySettings;
import de.vw.mib.asl.internal.navigation.setup.StateSetupWork;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.log4mib.LogMessage;
import java.util.HashMap;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.map.DSIMapViewerManeuverView;
import org.dsi.ifc.navigation.DSIBlocking;
import org.dsi.ifc.navigation.DSINavigation;
import org.dsi.ifc.navigation.NavDataBase;
import org.dsi.ifc.organizer.DSIAdbEdit;
import org.dsi.ifc.organizer.DSIAdbSetup;
import org.dsi.ifc.organizer.DSIAdbUserProfile;
import org.dsi.ifc.search.DSISearch;
import org.dsi.ifc.tmc.DSITmcOnRoute;
import org.dsi.ifc.trafficregulation.DSITrafficRegulation;

public final class HsmTargetSetup
extends AbstractResettableAslHsmTarget
implements DSIServiceStateListener,
ReloadPersistedDataListener {
    final IPersistedGuidanceSetup GUIDANCE_OPTIONS = ASLNavigationGuidanceFactory.getNavigationGuidanceApi().getGuidanceSetup();
    final IPersistedDestInputSetup PERS_DESTINPUT_SETUP = ASLNavigationGuidanceFactory.getNavigationGuidanceApi().getDestInputSetup();
    NavDataBase[] currentlyInstalledPPois = null;
    public DSINavigation dsiNavigationService = null;
    public DSIBlocking dsiBlockingService = null;
    public DSITmcOnRoute dsiTmcOnRouteService = null;
    public DSITrafficRegulation dsiTrafficRegulationService = null;
    public DSIAdbUserProfile dsiAdbUserProfileService = null;
    public DSIAdbSetup dsiAdbSetupService = null;
    public DSIAdbEdit dsiAdbEditService = null;
    public DSISearch dsiSearchService = null;
    private DSIMapViewerManeuverView dsiMapViewerManeuverView;
    private DSIListener dsiNavigationListener;
    private DSIListener dsiBlockingListener;
    private DSIListener dsiAdbSetupListener;
    private DSIListener dsiSearchListener;
    public static final int EV_NAVI_SETUP_WAIT_FOR_PERSISTENCE_LOOP;
    public static final int EV_NAVI_SETUP_WAIT_FOR_BLOCKING_DELETED;
    public static final int LOOP_COUNTER_MAX;
    public static final int LOOP_DELAY_MILISECONDS;
    private static final int[] OBSERVERS;
    private final int[] ASL_SERVICES = new int[]{727463168, 1063007488};
    private static final int[] ATTRIBUTES_NAVIGATION;
    public static final int EV_NAVI_SETUP_ASL_SETLOCATION_P0_LOCATIONTYPE;
    public static final int EV_NAVI_SETUP_ASL_SETLOCATION_P1_LOCATION;
    final StateSetupWork stateSetupWork = new StateSetupWork(this, this.hsm, "stateSetupWork", this.getWorkStateParent());
    final StateSetupMain stateSetupMain = new StateSetupMain(this, this.hsm, "stateSetupMain", this.stateSetupWork);
    final StateSetupInitPersistence stateSetupInitPersistence = new StateSetupInitPersistence(this, this.hsm, "stateSetupInitPersistence", this.stateSetupWork);
    final StateSetupResetFactorySettings stateSetupResetFactorySettings = new StateSetupResetFactorySettings(this, this.hsm, "stateSetupResetFactorySettings", this.stateSetupWork);
    private boolean isServiceStateListenerAdded = false;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigation;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSIBlocking;
    static /* synthetic */ Class class$org$dsi$ifc$tmc$DSITmcOnRoute;
    static /* synthetic */ Class class$org$dsi$ifc$trafficregulation$DSITrafficRegulation;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbUserProfile;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbSetup;
    static /* synthetic */ Class class$org$dsi$ifc$map$DSIMapViewerManeuverView;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbEdit;
    static /* synthetic */ Class class$org$dsi$ifc$search$DSISearch;
    static /* synthetic */ Class class$org$dsi$ifc$search$DSISearchListener;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbSetupListener;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSIBlockingListener;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigationListener;

    public HsmTargetSetup(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
        ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().addReloadPersistedDataListener(this);
    }

    @Override
    public void registered(String string, int n) {
        if (string.intern() == (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = HsmTargetSetup.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName().intern()) {
            if (!this.isFirstStartupDone) {
                if (this.isTraceEnabled()) {
                    this.trace().append("HsmTargetSetup tries to register to ").append(string).append("...").log();
                }
                this.initDsiNavigation();
                if (this.isTraceEnabled()) {
                    this.trace().append("HsmTargetSetup registered to ").append(string).log();
                }
            }
        } else if (string.intern() == (class$org$dsi$ifc$navigation$DSIBlocking == null ? (class$org$dsi$ifc$navigation$DSIBlocking = HsmTargetSetup.class$("org.dsi.ifc.navigation.DSIBlocking")) : class$org$dsi$ifc$navigation$DSIBlocking).getName().intern()) {
            if (!this.isFirstStartupDone) {
                if (this.isTraceEnabled()) {
                    this.trace().append("HsmTargetSetup tries to register to ").append(string).append("...").log();
                }
                this.initDsiBlocking();
                if (this.isTraceEnabled()) {
                    this.trace().append("HsmTargetSetup registered to ").append(string).log();
                }
            }
        } else if (string.intern() == (class$org$dsi$ifc$tmc$DSITmcOnRoute == null ? (class$org$dsi$ifc$tmc$DSITmcOnRoute = HsmTargetSetup.class$("org.dsi.ifc.tmc.DSITmcOnRoute")) : class$org$dsi$ifc$tmc$DSITmcOnRoute).getName().intern()) {
            if (!this.isFirstStartupDone) {
                if (this.isTraceEnabled()) {
                    this.trace().append("HsmTargetSetup tries to register to ").append(string).append("...").log();
                }
                this.initDsiTmcOnRoute();
                if (this.isTraceEnabled()) {
                    this.trace().append("HsmTargetSetup registered to ").append(string).log();
                }
            }
        } else if (string.intern() == (class$org$dsi$ifc$trafficregulation$DSITrafficRegulation == null ? (class$org$dsi$ifc$trafficregulation$DSITrafficRegulation = HsmTargetSetup.class$("org.dsi.ifc.trafficregulation.DSITrafficRegulation")) : class$org$dsi$ifc$trafficregulation$DSITrafficRegulation).getName().intern()) {
            if (!this.isFirstStartupDone) {
                if (this.isTraceEnabled()) {
                    this.trace().append("HsmTargetSetup tries to register to ").append(string).append("...").log();
                }
                this.initDsiTrafficRegulation();
                if (this.isTraceEnabled()) {
                    this.trace().append("HsmTargetSetup registered to ").append(string).log();
                }
            }
        } else if (string.intern() == (class$org$dsi$ifc$organizer$DSIAdbUserProfile == null ? (class$org$dsi$ifc$organizer$DSIAdbUserProfile = HsmTargetSetup.class$("org.dsi.ifc.organizer.DSIAdbUserProfile")) : class$org$dsi$ifc$organizer$DSIAdbUserProfile).getName().intern()) {
            if (!this.isFirstStartupDone) {
                if (this.isTraceEnabled()) {
                    this.trace().append("HsmTargetSetup tries to register to ").append(string).append("...").log();
                }
                this.initDsiAdbUserProfile();
                if (this.isTraceEnabled()) {
                    this.trace().append("HsmTargetSetup registered to ").append(string).log();
                }
            }
        } else if (string.intern() == (class$org$dsi$ifc$organizer$DSIAdbSetup == null ? (class$org$dsi$ifc$organizer$DSIAdbSetup = HsmTargetSetup.class$("org.dsi.ifc.organizer.DSIAdbSetup")) : class$org$dsi$ifc$organizer$DSIAdbSetup).getName().intern()) {
            if (!this.isFirstStartupDone) {
                if (this.isTraceEnabled()) {
                    this.trace().append("HsmTargetSetup tries to register to ").append(string).append("...").log();
                }
                this.initDsiAdbSetup();
                if (this.isTraceEnabled()) {
                    this.trace().append("HsmTargetSetup registered to ").append(string).log();
                }
            }
        } else if (string.intern() == (class$org$dsi$ifc$map$DSIMapViewerManeuverView == null ? (class$org$dsi$ifc$map$DSIMapViewerManeuverView = HsmTargetSetup.class$("org.dsi.ifc.map.DSIMapViewerManeuverView")) : class$org$dsi$ifc$map$DSIMapViewerManeuverView).getName().intern()) {
            if (!this.isFirstStartupDone) {
                if (this.isTraceEnabled()) {
                    this.trace().append("HsmTargetSetup tries to register to ").append(string).append("...").log();
                }
                this.initDsiMapViewerManeuverView();
                if (this.isTraceEnabled()) {
                    this.trace().append("HsmTargetSetup registered to ").append(string).log();
                }
            }
        } else if (string.intern() == (class$org$dsi$ifc$organizer$DSIAdbEdit == null ? (class$org$dsi$ifc$organizer$DSIAdbEdit = HsmTargetSetup.class$("org.dsi.ifc.organizer.DSIAdbEdit")) : class$org$dsi$ifc$organizer$DSIAdbEdit).getName().intern()) {
            if (!this.isFirstStartupDone) {
                if (this.isTraceEnabled()) {
                    this.trace().append("HsmTargetSetup tries to register to ").append(string).append("...").log();
                }
                this.initDsiAdbEdit();
                if (this.isTraceEnabled()) {
                    this.trace().append("HsmTargetSetup registered to ").append(string).log();
                }
            }
        } else if (string.intern() == (class$org$dsi$ifc$search$DSISearch == null ? (class$org$dsi$ifc$search$DSISearch = HsmTargetSetup.class$("org.dsi.ifc.search.DSISearch")) : class$org$dsi$ifc$search$DSISearch).getName().intern() && !this.isFirstStartupDone) {
            if (this.isTraceEnabled()) {
                this.trace().append("HsmTargetSetup tries to register to ").append(string).append("...").log();
            }
            this.initDsiSearch();
            if (this.isTraceEnabled()) {
                this.trace().append("HsmTargetSetup registered to ").append(string).log();
            }
        }
        if (this.dsiSearchService != null && this.dsiAdbEditService != null && this.dsiMapViewerManeuverView != null && this.dsiAdbSetupService != null && this.dsiAdbUserProfileService != null && this.dsiTrafficRegulationService != null && this.dsiTmcOnRouteService != null && this.dsiBlockingService != null && this.dsiNavigationService != null) {
            this.isFirstStartupDone = true;
        }
    }

    private void initDsiSearch() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.dsiSearchService = (DSISearch)dSIProxy.getService(this, class$org$dsi$ifc$search$DSISearch == null ? (class$org$dsi$ifc$search$DSISearch = HsmTargetSetup.class$("org.dsi.ifc.search.DSISearch")) : class$org$dsi$ifc$search$DSISearch);
        this.dsiSearchListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this.getHsm(), class$org$dsi$ifc$search$DSISearchListener == null ? (class$org$dsi$ifc$search$DSISearchListener = HsmTargetSetup.class$("org.dsi.ifc.search.DSISearchListener")) : class$org$dsi$ifc$search$DSISearchListener);
        dSIProxy.addResponseListener(this, class$org$dsi$ifc$search$DSISearchListener == null ? (class$org$dsi$ifc$search$DSISearchListener = HsmTargetSetup.class$("org.dsi.ifc.search.DSISearchListener")) : class$org$dsi$ifc$search$DSISearchListener, this.dsiSearchListener);
    }

    private void initDsiAdbEdit() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.dsiAdbEditService = (DSIAdbEdit)dSIProxy.getService(this, class$org$dsi$ifc$organizer$DSIAdbEdit == null ? (class$org$dsi$ifc$organizer$DSIAdbEdit = HsmTargetSetup.class$("org.dsi.ifc.organizer.DSIAdbEdit")) : class$org$dsi$ifc$organizer$DSIAdbEdit, 2);
    }

    private void initDsiMapViewerManeuverView() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.dsiMapViewerManeuverView = (DSIMapViewerManeuverView)dSIProxy.getService(this, class$org$dsi$ifc$map$DSIMapViewerManeuverView == null ? (class$org$dsi$ifc$map$DSIMapViewerManeuverView = HsmTargetSetup.class$("org.dsi.ifc.map.DSIMapViewerManeuverView")) : class$org$dsi$ifc$map$DSIMapViewerManeuverView);
    }

    private void initDsiAdbSetup() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.dsiAdbSetupService = (DSIAdbSetup)dSIProxy.getService(this, class$org$dsi$ifc$organizer$DSIAdbSetup == null ? (class$org$dsi$ifc$organizer$DSIAdbSetup = HsmTargetSetup.class$("org.dsi.ifc.organizer.DSIAdbSetup")) : class$org$dsi$ifc$organizer$DSIAdbSetup);
        this.dsiAdbSetupListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this.getHsm(), class$org$dsi$ifc$organizer$DSIAdbSetupListener == null ? (class$org$dsi$ifc$organizer$DSIAdbSetupListener = HsmTargetSetup.class$("org.dsi.ifc.organizer.DSIAdbSetupListener")) : class$org$dsi$ifc$organizer$DSIAdbSetupListener);
        this.dsiAdbSetupService.setNotification(2, this.dsiAdbSetupListener);
    }

    private void initDsiAdbUserProfile() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.dsiAdbUserProfileService = (DSIAdbUserProfile)dSIProxy.getService(this, class$org$dsi$ifc$organizer$DSIAdbUserProfile == null ? (class$org$dsi$ifc$organizer$DSIAdbUserProfile = HsmTargetSetup.class$("org.dsi.ifc.organizer.DSIAdbUserProfile")) : class$org$dsi$ifc$organizer$DSIAdbUserProfile);
    }

    private void initDsiTrafficRegulation() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.dsiTrafficRegulationService = (DSITrafficRegulation)dSIProxy.getService(this, class$org$dsi$ifc$trafficregulation$DSITrafficRegulation == null ? (class$org$dsi$ifc$trafficregulation$DSITrafficRegulation = HsmTargetSetup.class$("org.dsi.ifc.trafficregulation.DSITrafficRegulation")) : class$org$dsi$ifc$trafficregulation$DSITrafficRegulation);
    }

    private void initDsiTmcOnRoute() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.dsiTmcOnRouteService = (DSITmcOnRoute)dSIProxy.getService(this, class$org$dsi$ifc$tmc$DSITmcOnRoute == null ? (class$org$dsi$ifc$tmc$DSITmcOnRoute = HsmTargetSetup.class$("org.dsi.ifc.tmc.DSITmcOnRoute")) : class$org$dsi$ifc$tmc$DSITmcOnRoute);
    }

    private void initDsiBlocking() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.dsiBlockingService = (DSIBlocking)dSIProxy.getService(this, class$org$dsi$ifc$navigation$DSIBlocking == null ? (class$org$dsi$ifc$navigation$DSIBlocking = HsmTargetSetup.class$("org.dsi.ifc.navigation.DSIBlocking")) : class$org$dsi$ifc$navigation$DSIBlocking);
        this.dsiBlockingListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this.getHsm(), class$org$dsi$ifc$navigation$DSIBlockingListener == null ? (class$org$dsi$ifc$navigation$DSIBlockingListener = HsmTargetSetup.class$("org.dsi.ifc.navigation.DSIBlockingListener")) : class$org$dsi$ifc$navigation$DSIBlockingListener);
        dSIProxy.addResponseListener(this, class$org$dsi$ifc$navigation$DSIBlockingListener == null ? (class$org$dsi$ifc$navigation$DSIBlockingListener = HsmTargetSetup.class$("org.dsi.ifc.navigation.DSIBlockingListener")) : class$org$dsi$ifc$navigation$DSIBlockingListener, this.dsiBlockingListener);
    }

    private void initDsiNavigation() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.dsiNavigationService = (DSINavigation)dSIProxy.getService(this, class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = HsmTargetSetup.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation);
        this.dsiNavigationListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this.getHsm(), class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = HsmTargetSetup.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener);
        dSIProxy.addResponseListener(this, class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = HsmTargetSetup.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener, this.dsiNavigationListener);
        this.dsiNavigationService.setNotification(ATTRIBUTES_NAVIGATION, this.dsiNavigationListener);
    }

    @Override
    public void unregistered(String string, int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("HsmTargetSetup tries to unregister from ").append(string).append("...").log();
        }
        try {
            DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
            if (dSIProxy == null) {
                this.trace().append("DSIProxy was null!");
                return;
            }
            if (string.intern() == (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = HsmTargetSetup.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName().intern()) {
                this.unregisterDSINavigation(string, dSIProxy);
            } else if (string.intern() == (class$org$dsi$ifc$navigation$DSIBlocking == null ? (class$org$dsi$ifc$navigation$DSIBlocking = HsmTargetSetup.class$("org.dsi.ifc.navigation.DSIBlocking")) : class$org$dsi$ifc$navigation$DSIBlocking).getName().intern()) {
                this.unregisterDSIBlocking(string, dSIProxy);
            } else if (string.intern() == (class$org$dsi$ifc$organizer$DSIAdbSetup == null ? (class$org$dsi$ifc$organizer$DSIAdbSetup = HsmTargetSetup.class$("org.dsi.ifc.organizer.DSIAdbSetup")) : class$org$dsi$ifc$organizer$DSIAdbSetup).getName().intern()) {
                this.unregisterDSIAdbSetup(string);
            } else if (string.intern() == (class$org$dsi$ifc$search$DSISearch == null ? (class$org$dsi$ifc$search$DSISearch = HsmTargetSetup.class$("org.dsi.ifc.search.DSISearch")) : class$org$dsi$ifc$search$DSISearch).getName().intern()) {
                this.unregisterDSISearch(string, dSIProxy);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleDsiError(exception);
        }
    }

    private void unregisterDSISearch(String string, DSIProxy dSIProxy) {
        if (this.dsiSearchListener != null) {
            dSIProxy.removeResponseListener(this, class$org$dsi$ifc$search$DSISearchListener == null ? (class$org$dsi$ifc$search$DSISearchListener = HsmTargetSetup.class$("org.dsi.ifc.search.DSISearchListener")) : class$org$dsi$ifc$search$DSISearchListener, this.dsiSearchListener);
            this.dsiSearchListener = null;
        }
        this.traceUnregisterDone(string);
    }

    private void unregisterDSIAdbSetup(String string) {
        this.dsiAdbSetupListener = null;
        this.traceUnregisterDone(string);
    }

    private void unregisterDSIBlocking(String string, DSIProxy dSIProxy) {
        if (this.dsiBlockingListener != null) {
            dSIProxy.removeResponseListener(this, class$org$dsi$ifc$navigation$DSIBlockingListener == null ? (class$org$dsi$ifc$navigation$DSIBlockingListener = HsmTargetSetup.class$("org.dsi.ifc.navigation.DSIBlockingListener")) : class$org$dsi$ifc$navigation$DSIBlockingListener, this.dsiBlockingListener);
            this.dsiBlockingListener = null;
        }
        this.traceUnregisterDone(string);
    }

    private void unregisterDSINavigation(String string, DSIProxy dSIProxy) {
        if (this.dsiNavigationListener != null) {
            dSIProxy.removeResponseListener(this, class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = HsmTargetSetup.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener, this.dsiNavigationListener);
            this.dsiNavigationListener = null;
        }
        this.traceUnregisterDone(string);
    }

    private void traceUnregisterDone(String string) {
        if (this.isTraceEnabled()) {
            this.trace().append("HsmTargetSetup unregistered from ").append(string).log();
        }
    }

    void registerDsiStateChangeListener() {
        if (!this.isServiceStateListenerAdded) {
            this.isServiceStateListenerAdded = true;
            ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = HsmTargetSetup.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation, this);
            ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$navigation$DSIBlocking == null ? (class$org$dsi$ifc$navigation$DSIBlocking = HsmTargetSetup.class$("org.dsi.ifc.navigation.DSIBlocking")) : class$org$dsi$ifc$navigation$DSIBlocking, this);
            ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$tmc$DSITmcOnRoute == null ? (class$org$dsi$ifc$tmc$DSITmcOnRoute = HsmTargetSetup.class$("org.dsi.ifc.tmc.DSITmcOnRoute")) : class$org$dsi$ifc$tmc$DSITmcOnRoute, this);
            ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$trafficregulation$DSITrafficRegulation == null ? (class$org$dsi$ifc$trafficregulation$DSITrafficRegulation = HsmTargetSetup.class$("org.dsi.ifc.trafficregulation.DSITrafficRegulation")) : class$org$dsi$ifc$trafficregulation$DSITrafficRegulation, this);
            ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$organizer$DSIAdbUserProfile == null ? (class$org$dsi$ifc$organizer$DSIAdbUserProfile = HsmTargetSetup.class$("org.dsi.ifc.organizer.DSIAdbUserProfile")) : class$org$dsi$ifc$organizer$DSIAdbUserProfile, this);
            ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$organizer$DSIAdbSetup == null ? (class$org$dsi$ifc$organizer$DSIAdbSetup = HsmTargetSetup.class$("org.dsi.ifc.organizer.DSIAdbSetup")) : class$org$dsi$ifc$organizer$DSIAdbSetup, this);
            ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$map$DSIMapViewerManeuverView == null ? (class$org$dsi$ifc$map$DSIMapViewerManeuverView = HsmTargetSetup.class$("org.dsi.ifc.map.DSIMapViewerManeuverView")) : class$org$dsi$ifc$map$DSIMapViewerManeuverView, this);
            ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$organizer$DSIAdbEdit == null ? (class$org$dsi$ifc$organizer$DSIAdbEdit = HsmTargetSetup.class$("org.dsi.ifc.organizer.DSIAdbEdit")) : class$org$dsi$ifc$organizer$DSIAdbEdit, 2, this);
            ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$search$DSISearch == null ? (class$org$dsi$ifc$search$DSISearch = HsmTargetSetup.class$("org.dsi.ifc.search.DSISearch")) : class$org$dsi$ifc$search$DSISearch, this);
        }
    }

    protected void registerObservers() {
        this.addObservers(OBSERVERS);
    }

    void removeObservers() {
        this.removeObservers(OBSERVERS);
    }

    void registerASLServices() {
        this.registerServices(this.ASL_SERVICES, false);
    }

    @Override
    protected HsmState getDefaultState() {
        return this.stateSetupWork;
    }

    @Override
    public int getSubClassifier() {
        return 16384;
    }

    public void traceState(HsmState hsmState, String string) {
        if (ServiceManager.logger.isTraceEnabled(this.getSubClassifier())) {
            LogMessage logMessage = ServiceManager.logger.trace(this.getSubClassifier());
            logMessage.append(super.getClass());
            logMessage.append(".");
            logMessage.append(super.getClass());
            logMessage.append(": ");
            logMessage.append(string);
            logMessage.log();
        }
    }

    public void setAudioVoiceAnnnouncementType(int n, boolean bl) {
        if (bl) {
            this.GUIDANCE_OPTIONS.setHmiAudioAnnouncementType(n);
        }
        int n2 = this.GUIDANCE_OPTIONS.getHmiAudioAnnouncementTypeDatapoolGetter();
        ServiceManager.aslPropertyManager.valueChangedInteger(981, n2);
        ServiceManager.aslPropertyManager.valueChangedInteger(736, this.GUIDANCE_OPTIONS.getBapAudioAnnouncentTypeDatapoolGetter());
        int n3 = this.GUIDANCE_OPTIONS.getDsiAudioAnnouncementType();
        if (this.GUIDANCE_OPTIONS.isSoundOn()) {
            this.dsiNavigationService.rgSetRouteGuidanceMode(n3);
        } else {
            this.dsiNavigationService.rgSetRouteGuidanceMode(3);
        }
    }

    public void setDsiDistanceUnit(int n) {
        int n2;
        switch (n) {
            case 0: {
                n2 = 2;
                break;
            }
            case 1: {
                if (ServiceManager.configManagerDiag.isFeatureFlagSet(155)) {
                    n2 = 3;
                    break;
                }
                n2 = 4;
                break;
            }
            default: {
                n2 = 1;
            }
        }
        this.dsiNavigationService.etcSetMetricSystem(n2);
    }

    public void setDSICurrentPPOIApproachWarningStatus() {
        this.trace("PPOIAW: HsmTargetSetup:  setDSICurrentPPOIApproachWarningStatus");
        boolean bl = this.isCHNSpeedCameraWarning() ? this.GUIDANCE_OPTIONS.isSpeedCameraWarning() : this.GUIDANCE_OPTIONS.isAudibleApproachPPOIHint();
        int[] nArray = this.setCategoryUid();
        boolean[] blArray = new boolean[]{bl};
        this.dsiNavigationService.ehSetCategoryMonitoring(nArray, blArray);
    }

    public int[] setCategoryUid() {
        int[] nArray;
        if (this.isCHNSpeedCameraWarning()) {
            this.trace("Camera Warning: HsmTargetSetup: STD2Nav CHN");
            nArray = new int[]{130};
        } else if (this.isPPOIAWFeature()) {
            this.trace("PPOIAW: HsmTargetSetup: HIGH2 EU");
            nArray = new int[]{-2};
        } else {
            this.trace("PPOIAW: HsmTargetSetup:  NONE!!");
            nArray = null;
        }
        return nArray;
    }

    public boolean isCHNSpeedCameraWarning() {
        return ServiceManager.configManagerDiag.isFeatureFlagSet(158);
    }

    public boolean isPPOIAWFeature() {
        return ServiceManager.configManagerDiag.isFeatureFlagSet(148);
    }

    public void deleteMemoryWaypointMemory() {
        this.dsiNavigationService.trDeleteAllTraces();
    }

    public void deleteMemoryBlocking() {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this.getTargetId(), -2008345600, 92733696);
        eventGeneric.setSenderEventId(143065344);
        this.send(eventGeneric);
    }

    public void deleteMemoryFlagDestination() {
        this.dsiNavigationService.dmFlagDestinationRemove();
    }

    public void deleteMemoryHomeLocation() {
        ServiceManager.aslPropertyManager.valueChangedBoolean(836, false);
        this.PERS_DESTINPUT_SETUP.setHomeDest(null, true);
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(151650368);
        eventGeneric.setBoolean(0, false);
        this.send(eventGeneric);
    }

    public void deleteMemoryLastCitiesAndStreets() {
        this.dsiNavigationService.liLastCityHistoryDeleteAll();
        this.dsiNavigationService.liLastStreetHistoryDeleteAll();
    }

    public void deleteMemoryLastDestinations() {
        this.dsiNavigationService.dmLastDestinationsDeleteAll();
        this.PERS_DESTINPUT_SETUP.setDemoDest(ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getDefaultLocation());
        this.PERS_DESTINPUT_SETUP.setLastDest(null);
        ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setSpellerLocation(null);
        ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setDestInputLocation(null);
        ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setMemoryLocation(null);
    }

    public void deleteMemoryTour() {
        this.dsiNavigationService.rmRouteDeleteAll(1);
    }

    public void deleteShieldHistory() {
        if (this.dsiSearchService != null) {
            this.dsiSearchService.removeAllFromHistory();
        }
    }

    public void deleteNavInternalData() {
        this.dsiNavigationService.setNavInternalDataToFactorySettings();
    }

    public void getAllCategories() {
        this.dsiNavigationService.ehGetAllCategories(0);
    }

    public void setCategoryAudioWarning(int[] nArray, boolean[] blArray) {
        this.dsiNavigationService.ehSetCategoryAudioWarning(0, nArray, blArray);
    }

    public void disableManeuverViewGeneration(boolean bl) {
        this.trace("HsmTargetSetup: disableManeuverViewGeneration");
        this.dsiMapViewerManeuverView.disableManeuverViewGeneration(bl);
    }

    @Override
    public void reloadPersistedData() {
        int n = this.GUIDANCE_OPTIONS.getHmiAudioAnnouncementTypeDatapoolGetter();
        ServiceManager.aslPropertyManager.valueChangedInteger(981, n);
        ServiceManager.aslPropertyManager.valueChangedInteger(736, this.GUIDANCE_OPTIONS.getBapAudioAnnouncentTypeDatapoolGetter());
        int n2 = this.GUIDANCE_OPTIONS.getDsiAudioAnnouncementType();
        if (this.dsiNavigationService != null) {
            if (this.GUIDANCE_OPTIONS.isSoundOn()) {
                this.dsiNavigationService.rgSetRouteGuidanceMode(n2);
            } else {
                this.dsiNavigationService.rgSetRouteGuidanceMode(3);
            }
        }
        this.setSpeedCameraWarning(this.GUIDANCE_OPTIONS.isSpeedCameraWarning());
        this.setApproachPPOIHint(this.GUIDANCE_OPTIONS.isAudibleApproachPPOIHint());
        ServiceManager.aslPropertyManager.valueChangedInteger(-1024454656, this.PERS_DESTINPUT_SETUP.getLastInputMode());
    }

    public void setSpeedCameraWarning(boolean bl) {
        this.trace(new StringBuffer("SCW: StateSetupMain:  setSpeedCameraWarning: ").append(bl).toString());
        this.GUIDANCE_OPTIONS.setSpeedCameraWarning(bl);
        this.setCategoryMonitoring(bl);
    }

    public void setCategoryMonitoring(boolean bl) {
        int[] nArray = this.setCategoryUid();
        boolean[] blArray = new boolean[]{bl};
        if (this.dsiNavigationService != null) {
            this.dsiNavigationService.ehSetCategoryMonitoring(nArray, blArray);
        }
    }

    public void setApproachPPOIHint(boolean bl) {
        this.trace(new StringBuffer("PPOIAW: StateSetupMain:  setApproachPPOIHint: ").append(bl).toString());
        this.GUIDANCE_OPTIONS.setAudibleApproachPPOIHint(bl);
        this.setCategoryMonitoring(bl);
    }

    void resetDestInputMode() {
        int n = HsmTargetSetup.getLastModeDestinationInputDefault();
        this.PERS_DESTINPUT_SETUP.setLastInputMode(n);
        ServiceManager.aslPropertyManager.valueChangedInteger(-1024454656, n);
    }

    public static int getLastModeDestinationInputDefault() {
        boolean bl = ServiceManager.configManagerDiag.isFeatureFlagSet(125);
        return bl ? 1 : 0;
    }

    @Override
    public void reset(HashMap hashMap) {
        boolean bl = this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = HsmTargetSetup.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName(), 0);
        boolean bl2 = this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$organizer$DSIAdbEdit == null ? (class$org$dsi$ifc$organizer$DSIAdbEdit = HsmTargetSetup.class$("org.dsi.ifc.organizer.DSIAdbEdit")) : class$org$dsi$ifc$organizer$DSIAdbEdit).getName(), 2);
        boolean bl3 = this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$search$DSISearch == null ? (class$org$dsi$ifc$search$DSISearch = HsmTargetSetup.class$("org.dsi.ifc.search.DSISearch")) : class$org$dsi$ifc$search$DSISearch).getName(), 0);
        boolean bl4 = this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$map$DSIMapViewerManeuverView == null ? (class$org$dsi$ifc$map$DSIMapViewerManeuverView = HsmTargetSetup.class$("org.dsi.ifc.map.DSIMapViewerManeuverView")) : class$org$dsi$ifc$map$DSIMapViewerManeuverView).getName(), 0);
        boolean bl5 = this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$organizer$DSIAdbSetup == null ? (class$org$dsi$ifc$organizer$DSIAdbSetup = HsmTargetSetup.class$("org.dsi.ifc.organizer.DSIAdbSetup")) : class$org$dsi$ifc$organizer$DSIAdbSetup).getName(), 0);
        boolean bl6 = this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$organizer$DSIAdbUserProfile == null ? (class$org$dsi$ifc$organizer$DSIAdbUserProfile = HsmTargetSetup.class$("org.dsi.ifc.organizer.DSIAdbUserProfile")) : class$org$dsi$ifc$organizer$DSIAdbUserProfile).getName(), 0);
        boolean bl7 = this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$trafficregulation$DSITrafficRegulation == null ? (class$org$dsi$ifc$trafficregulation$DSITrafficRegulation = HsmTargetSetup.class$("org.dsi.ifc.trafficregulation.DSITrafficRegulation")) : class$org$dsi$ifc$trafficregulation$DSITrafficRegulation).getName(), 0);
        boolean bl8 = this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$tmc$DSITmcOnRoute == null ? (class$org$dsi$ifc$tmc$DSITmcOnRoute = HsmTargetSetup.class$("org.dsi.ifc.tmc.DSITmcOnRoute")) : class$org$dsi$ifc$tmc$DSITmcOnRoute).getName(), 0);
        boolean bl9 = this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$navigation$DSIBlocking == null ? (class$org$dsi$ifc$navigation$DSIBlocking = HsmTargetSetup.class$("org.dsi.ifc.navigation.DSIBlocking")) : class$org$dsi$ifc$navigation$DSIBlocking).getName(), 0);
        if (bl || bl2 || bl3 || bl4 || bl5 || bl6 || bl7 || bl8 || bl9) {
            if (this.isTraceEnabled()) {
                this.trace("HsmTargetSetup: resetting values after DSI restart");
            }
            this.initLocalVariables();
            this.resetHsmToState(this.stateSetupMain);
            if (bl2) {
                this.initDsiAdbEdit();
            }
            if (bl5) {
                this.initDsiAdbSetup();
            }
            if (bl6) {
                this.initDsiAdbUserProfile();
            }
            if (bl9) {
                this.initDsiBlocking();
            }
            if (bl4) {
                this.initDsiMapViewerManeuverView();
                this.reinitDsiMapViewerManeuverViewSettings();
            }
            if (bl) {
                this.initDsiNavigation();
                this.reinitDsiNavigationSettings();
            }
            if (bl3) {
                this.initDsiSearch();
            }
            if (bl8) {
                this.initDsiTmcOnRoute();
                this.reinitDsiTmcOnRouteSettings();
            }
            if (bl7) {
                this.initDsiTrafficRegulation();
            }
        } else if (this.isTraceEnabled()) {
            this.trace("HsmTargetSetup: no reset necessary because restarted DSI(s) is/are not used in target");
        }
    }

    private void reinitDsiTmcOnRouteSettings() {
        this.dsiTmcOnRouteService.setTmcWarningMode(this.GUIDANCE_OPTIONS.getDsiAcousticTrafficJamWarning());
    }

    private void reinitDsiNavigationSettings() {
        int n = this.GUIDANCE_OPTIONS.getHmiAudioAnnouncementType();
        this.setAudioVoiceAnnnouncementType(n, false);
        this.dsiNavigationService.etcSetDemoMode(false);
        int n2 = ASLSystemFactory.getSystemApi().getConfiguredDistanceUnit();
        this.setDsiDistanceUnit(n2);
    }

    private void reinitDsiMapViewerManeuverViewSettings() {
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(70)) {
            this.disableManeuverViewGeneration(false);
        }
    }

    private void initLocalVariables() {
        this.currentlyInstalledPPois = null;
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
        OBSERVERS = new int[]{-821952448, -805175232, -754843584, -738066368, -788398016, -771620800, -721289152, 1120473152, 1103695936, -1073610688, -620625856, -587071424, -503185344, -486408128, -469630912, -419299264, 550047808, -385744832, -368967616, -855506880, -1040121792, 302186560, 33882176, -972554176, 278741248, 10305792};
        ATTRIBUTES_NAVIGATION = new int[]{34, 65, 91};
    }
}

