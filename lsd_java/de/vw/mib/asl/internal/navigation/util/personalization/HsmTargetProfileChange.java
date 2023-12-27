/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.util.personalization;

import de.vw.mib.asl.api.navigation.guidance.ASLNavigationGuidanceAPI;
import de.vw.mib.asl.api.navigation.guidance.ASLNavigationGuidanceFactory;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.AbstractResettableAslHsmTarget;
import de.vw.mib.asl.internal.navigation.util.NaviHelper;
import de.vw.mib.asl.internal.navigation.util.personalization.NavProfileChangeHandler;
import de.vw.mib.asl.internal.navigation.util.personalization.StateIdle;
import de.vw.mib.asl.internal.navigation.util.personalization.StatePostDsiForProfileChange;
import de.vw.mib.asl.internal.navigation.util.personalization.StatePrepareForProfileChange;
import de.vw.mib.asl.internal.navigation.util.personalization.StateProfileChangeRunning;
import de.vw.mib.asl.internal.navigation.util.personalization.StateWork;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import java.util.HashMap;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.navigation.Route;
import org.dsi.ifc.predictivenavigation.DSIPredictiveNavigation;

public class HsmTargetProfileChange
extends AbstractResettableAslHsmTarget
implements DSIServiceStateListener {
    DSIPredictiveNavigation dsiPredictiveNavigation;
    private DSIListener predictiveNavigationListener;
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(16384, "[HsmTargetProfileChange]");
    Route previousRoute = null;
    ASLNavigationGuidanceAPI navGuidanceApi;
    int currentPnavOperationMode = 0;
    private static final int[] DSI_NOTIFICATION_PNAV = new int[]{1};
    public static final int EV_INTERNAL_CHANGE_PROFILE_PREPARE_FOR_PROFILE_CHANGE;
    public static final int EV_INTERNAL_CHANGE_PROFILE_PREPARE_FOR_PROFILE_CHANGE_P0_PROFILE_HANDLER;
    public static final int EV_INTERNAL_CHANGE_PROFILE_POST_DSI;
    public static final int EV_PREPARE_TIMEOUT;
    private StateWork stateWork = new StateWork(this, "stateWork", this.getWorkStateParent());
    private StateIdle stateIdle = new StateIdle(this, "stateIdle", (HsmState)this.stateWork);
    private StatePrepareForProfileChange statePrepareForProfileChange = new StatePrepareForProfileChange(this, "statePrepareForProfileChange", (HsmState)this.stateWork);
    private StateProfileChangeRunning stateProfileChangeRunning = new StateProfileChangeRunning(this, "stateProfileChangeRunning", (HsmState)this.stateWork);
    private StatePostDsiForProfileChange statePostDsiForProfileChange = new StatePostDsiForProfileChange(this, "statePostDsiForProfileChange", (HsmState)this.stateWork);
    public NavProfileChangeHandler profileChangeHandler;
    static /* synthetic */ Class class$org$dsi$ifc$predictivenavigation$DSIPredictiveNavigation;
    static /* synthetic */ Class class$org$dsi$ifc$predictivenavigation$DSIPredictiveNavigationListener;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigation;

    public HsmTargetProfileChange(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("target created");
        }
    }

    @Override
    public int getSubClassifier() {
        return 16384;
    }

    void init() {
        this.navGuidanceApi = ASLNavigationGuidanceFactory.getNavigationGuidanceApi();
        this.resetProfileChangeParameters();
    }

    void resetProfileChangeParameters() {
        this.previousRoute = null;
    }

    void addServiceStateListener() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        dSIProxy.addServiceStateListener(class$org$dsi$ifc$predictivenavigation$DSIPredictiveNavigation == null ? (class$org$dsi$ifc$predictivenavigation$DSIPredictiveNavigation = HsmTargetProfileChange.class$("org.dsi.ifc.predictivenavigation.DSIPredictiveNavigation")) : class$org$dsi$ifc$predictivenavigation$DSIPredictiveNavigation, this);
    }

    @Override
    public void registered(String string, int n) {
        if (string.intern() == (class$org$dsi$ifc$predictivenavigation$DSIPredictiveNavigation == null ? (class$org$dsi$ifc$predictivenavigation$DSIPredictiveNavigation = HsmTargetProfileChange.class$("org.dsi.ifc.predictivenavigation.DSIPredictiveNavigation")) : class$org$dsi$ifc$predictivenavigation$DSIPredictiveNavigation).getName().intern() && !this.isFirstStartupDone) {
            this.isFirstStartupDone = true;
            this.initDsiPredictiveNavigation();
        }
    }

    private void initDsiPredictiveNavigation() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.dsiPredictiveNavigation = (DSIPredictiveNavigation)dSIProxy.getService(this, class$org$dsi$ifc$predictivenavigation$DSIPredictiveNavigation == null ? (class$org$dsi$ifc$predictivenavigation$DSIPredictiveNavigation = HsmTargetProfileChange.class$("org.dsi.ifc.predictivenavigation.DSIPredictiveNavigation")) : class$org$dsi$ifc$predictivenavigation$DSIPredictiveNavigation);
        this.predictiveNavigationListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this.getHsm(), class$org$dsi$ifc$predictivenavigation$DSIPredictiveNavigationListener == null ? (class$org$dsi$ifc$predictivenavigation$DSIPredictiveNavigationListener = HsmTargetProfileChange.class$("org.dsi.ifc.predictivenavigation.DSIPredictiveNavigationListener")) : class$org$dsi$ifc$predictivenavigation$DSIPredictiveNavigationListener);
        this.dsiPredictiveNavigation.setNotification(DSI_NOTIFICATION_PNAV, this.predictiveNavigationListener);
        dSIProxy.addResponseListener(this, class$org$dsi$ifc$predictivenavigation$DSIPredictiveNavigationListener == null ? (class$org$dsi$ifc$predictivenavigation$DSIPredictiveNavigationListener = HsmTargetProfileChange.class$("org.dsi.ifc.predictivenavigation.DSIPredictiveNavigationListener")) : class$org$dsi$ifc$predictivenavigation$DSIPredictiveNavigationListener, this.predictiveNavigationListener);
    }

    @Override
    public void unregistered(String string, int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("TargetProfileChange tries to unregister from ").append(string).append("...").log();
        }
        try {
            DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
            if (dSIProxy == null) {
                this.trace().append("DSIProxy was null!");
                return;
            }
            if (string.intern() == (class$org$dsi$ifc$predictivenavigation$DSIPredictiveNavigation == null ? (class$org$dsi$ifc$predictivenavigation$DSIPredictiveNavigation = HsmTargetProfileChange.class$("org.dsi.ifc.predictivenavigation.DSIPredictiveNavigation")) : class$org$dsi$ifc$predictivenavigation$DSIPredictiveNavigation).getName().intern()) {
                this.unregisterDsiPredictiveNavigation(string, dSIProxy);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleDsiError(exception);
        }
    }

    private void unregisterDsiPredictiveNavigation(String string, DSIProxy dSIProxy) {
        if (this.predictiveNavigationListener != null) {
            dSIProxy.removeResponseListener(this, class$org$dsi$ifc$predictivenavigation$DSIPredictiveNavigationListener == null ? (class$org$dsi$ifc$predictivenavigation$DSIPredictiveNavigationListener = HsmTargetProfileChange.class$("org.dsi.ifc.predictivenavigation.DSIPredictiveNavigationListener")) : class$org$dsi$ifc$predictivenavigation$DSIPredictiveNavigationListener, this.predictiveNavigationListener);
        }
        this.traceUnregisterDone(string);
    }

    private void traceUnregisterDone(String string) {
        if (this.isTraceEnabled()) {
            this.trace().append("TargetProfileChange unregistered from ").append(string).log();
        }
    }

    @Override
    protected HsmState getDefaultState() {
        return this.stateWork;
    }

    public void transStateIdle() {
        this.logger.trace("transStateIdle()");
        this.getHsm().trans(this.stateIdle);
    }

    public void transStatePrepareForProfileChange() {
        this.logger.trace("transStatePrepareForProfileChange()");
        ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().lockPersitence();
        this.getHsm().trans(this.statePrepareForProfileChange);
    }

    public void transStateProfileChangeRunning() {
        this.logger.trace("transStateProfileChangeRunning()");
        this.profileChangeHandler.notifyTaskDone(true);
        this.getHsm().trans(this.stateProfileChangeRunning);
    }

    public void transStatePostDsiForProfileChange() {
        this.logger.trace("transStatePostDsiForProfileChange()");
        this.getHsm().trans(this.statePostDsiForProfileChange);
    }

    public void startGuidanceOfPreviousRoute() {
        int n = this.navGuidanceApi.getRouteOptionsSetup().getRouteCalculationType();
        this.logger.trace(new StringBuffer().append("startGuidanceOfPreviousRoute(): Starting guidance of calculated route with calculation type ").append(n).toString());
        this.navGuidanceApi.startGuidanceCalculatedRoute(n);
    }

    public boolean isPreviousRoutePresent() {
        return this.previousRoute != null;
    }

    public void recalculatePreviousRoute() {
        this.logger.trace("recalculatePreviousRoute(): Start calculation of previous route after profile change");
        this.navGuidanceApi.recalculateRoute(this.previousRoute, this.navGuidanceApi.isDemomodeActive());
    }

    public void cacheCurrentRouteAndStopGuidance() {
        this.previousRoute = NaviHelper.getInstance().copyRoute(this.navGuidanceApi.getCurrentRoute());
        this.stopGuidance();
    }

    public void stopGuidance() {
        this.navGuidanceApi.stopGuidance();
    }

    @Override
    public void reset(HashMap hashMap) {
        boolean bl = this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$predictivenavigation$DSIPredictiveNavigation == null ? (class$org$dsi$ifc$predictivenavigation$DSIPredictiveNavigation = HsmTargetProfileChange.class$("org.dsi.ifc.predictivenavigation.DSIPredictiveNavigation")) : class$org$dsi$ifc$predictivenavigation$DSIPredictiveNavigation).getName(), 0);
        boolean bl2 = this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = HsmTargetProfileChange.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName(), 0);
        if (bl || bl2) {
            if (this.isTraceEnabled()) {
                this.trace("HsmTargetProfileChange: resetting values after DSI restart");
            }
            this.initLocalVariables();
            this.resetHsmToState(this.stateIdle);
            if (bl) {
                this.currentPnavOperationMode = 0;
                this.initDsiPredictiveNavigation();
            }
        } else if (this.isTraceEnabled()) {
            this.trace("HsmTargetProfileChange: no reset necessary because restarted DSI(s) is/are not used in target");
        }
    }

    private void initLocalVariables() {
        this.resetProfileChangeParameters();
        if (this.profileChangeHandler != null) {
            this.profileChangeHandler.notifyTaskDone(false);
            this.profileChangeHandler = null;
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

