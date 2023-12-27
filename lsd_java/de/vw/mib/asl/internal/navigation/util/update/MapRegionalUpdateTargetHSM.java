/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.util.update;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.AbstractResettableAslHsmTarget;
import de.vw.mib.asl.internal.navigation.util.update.MapRegionalUpdateNotifierModel;
import de.vw.mib.asl.internal.navigation.util.update.MapRegionalUpdateStateIdle;
import de.vw.mib.asl.internal.navigation.util.update.MapRegionalUpdateStateIntegrationFinished;
import de.vw.mib.asl.internal.navigation.util.update.MapRegionalUpdateStateIntegrationInProgress;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import java.util.HashMap;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.navigation.DSINavigation;

public class MapRegionalUpdateTargetHSM
extends AbstractResettableAslHsmTarget
implements DSIServiceStateListener {
    private static final int[] DSI_NOTIFICATION_NAV = new int[]{103, 102};
    private static final int[] ASL_OBSERVER = new int[]{1758007360};
    private final MapRegionalUpdateStateIdle stateMapIntegrationIdle;
    private final MapRegionalUpdateStateIntegrationInProgress stateMapIntegrationInProgress;
    private final MapRegionalUpdateStateIntegrationFinished stateMapIntegrationFinished;
    private IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(16384, "[MapRegionalUpdateTargetHSM]");
    private DSIListener dsiNavigationListener;
    private DSINavigation dsiNavigation;
    public MapRegionalUpdateNotifierModel notifierModel;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigation;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigationListener;

    public MapRegionalUpdateTargetHSM(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
        this.stateMapIntegrationIdle = new MapRegionalUpdateStateIdle(this, "stateMapIntegrationIdle", this.getWorkStateParent());
        this.stateMapIntegrationInProgress = new MapRegionalUpdateStateIntegrationInProgress(this, "stateMapIntegrationInProgress", this.getWorkStateParent());
        this.stateMapIntegrationFinished = new MapRegionalUpdateStateIntegrationFinished(this, "stateMapIntegrationFinished", this.getWorkStateParent());
        this.notifierModel = new MapRegionalUpdateNotifierModel();
        this.addServiceStateListener();
    }

    @Override
    protected HsmState getDefaultState() {
        return this.stateMapIntegrationIdle;
    }

    private void addServiceStateListener() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        dSIProxy.addServiceStateListener(class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = MapRegionalUpdateTargetHSM.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation, this);
    }

    @Override
    public void registered(String string, int n) {
        if (string.intern() == (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = MapRegionalUpdateTargetHSM.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName().intern() && !this.isFirstStartupDone) {
            this.isFirstStartupDone = true;
            this.initDsiNavigation();
        }
    }

    private void initDsiNavigation() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.dsiNavigation = (DSINavigation)dSIProxy.getService(this, class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = MapRegionalUpdateTargetHSM.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation);
        this.dsiNavigationListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this.getHsm(), class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = MapRegionalUpdateTargetHSM.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener);
        this.dsiNavigation.setNotification(DSI_NOTIFICATION_NAV, this.dsiNavigationListener);
        dSIProxy.addResponseListener(this, class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = MapRegionalUpdateTargetHSM.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener, this.dsiNavigationListener);
    }

    @Override
    public void unregistered(String string, int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("MapRegionalUpdateTargetHSM tries to unregister from ").append(string).append("...").log();
        }
        try {
            DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
            if (dSIProxy == null) {
                this.trace().append("DSIProxy was null!");
                return;
            }
            if (string.intern() == (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = MapRegionalUpdateTargetHSM.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName().intern()) {
                this.unregisterDsiNavigation(string, dSIProxy);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleDsiError(exception);
        }
    }

    private void unregisterDsiNavigation(String string, DSIProxy dSIProxy) {
        if (this.dsiNavigationListener != null) {
            dSIProxy.removeResponseListener(this, class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = MapRegionalUpdateTargetHSM.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener, this.dsiNavigationListener);
        }
        if (this.isTraceEnabled()) {
            this.trace().append("MapRegionalUpdateTargetHSM unregistered from ").append(string).log();
        }
    }

    public void transStateMapIntegrationInProgress() {
        this.transStateSave(this.stateMapIntegrationInProgress);
    }

    public void transStateMapIntegrationFinished() {
        this.transStateSave(this.stateMapIntegrationFinished);
    }

    public void transStateMapIntegrationIdle() {
        this.transStateSave(this.stateMapIntegrationIdle);
    }

    private void transStateSave(HsmState hsmState) {
        try {
            this.logger.trace(new StringBuffer().append("Transition to state ").append(hsmState.getName()).toString());
            this.getHsm().trans(hsmState);
            this.getHsm().activateTransition();
        }
        catch (Exception exception) {
            this.logger.error(new StringBuffer().append("Error occured during state transition: ").append(exception.getMessage()).toString());
        }
    }

    public void handleNavigationRestartRequest() {
        this.logger.trace("Handle restart request. Restarting navigation using call on southside etcTriggerNavigationRestart(RESTARTREASON_MAPINTEGRATION)");
        this.dsiNavigation.etcTriggerNavigationRestart(1);
    }

    public void handleNavigationRestartRequestResult(int n, int n2) {
        if (n == 1) {
            if (n2 == 0) {
                this.logger.trace("Result of Navigation Restart was OK");
            } else {
                this.logger.warn("Result of Navigation Restart was NOK!!");
            }
        } else {
            this.logger.trace(new StringBuffer().append("Mismatch in restart reason != RESTARTREASON_MAPINTEGRATION. Reason-ID is ").append(n).toString());
        }
        if (!this.getHsm().getState().equals(this.stateMapIntegrationIdle)) {
            this.transStateMapIntegrationIdle();
        }
    }

    public void addObserver() {
        this.addObservers(ASL_OBSERVER);
    }

    @Override
    public void reset(HashMap hashMap) {
        boolean bl = this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = MapRegionalUpdateTargetHSM.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName(), 0);
        if (bl) {
            if (this.isTraceEnabled()) {
                this.trace("HsmTargetProfileChange: resetting values after DSI restart");
            }
            this.resetHsmToState(this.stateMapIntegrationIdle);
            this.initDsiNavigation();
        } else if (this.isTraceEnabled()) {
            this.trace("HsmTargetProfileChange: no reset necessary because restarted DSI(s) is/are not used in target");
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

