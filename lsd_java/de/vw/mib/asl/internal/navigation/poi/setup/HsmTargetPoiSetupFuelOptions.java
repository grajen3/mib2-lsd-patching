/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.setup;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.AbstractResettableAslHsmTarget;
import de.vw.mib.asl.internal.navigation.poi.setup.StatePoiSetupFuelOptionsWork;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import java.util.HashMap;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.navigation.DSINavigation;

public final class HsmTargetPoiSetupFuelOptions
extends AbstractResettableAslHsmTarget {
    private static final int[] OBSERVERS = new int[]{-570294208, -570294208, -452853696, -436076480, 134873152, 151650368, 537526336, 308557056};
    private static final int[] ATTRIBUTES_NAVIGATION = new int[0];
    final StatePoiSetupFuelOptionsWork stateFuelOptionsWork;
    private DSINavigation dsiNavigation;
    EventGeneric blockedGoOnEvent;
    private DSIListener navigationListener;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigation;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigationListener;

    public HsmTargetPoiSetupFuelOptions(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
        this.stateFuelOptionsWork = new StatePoiSetupFuelOptionsWork(this, this.hsm, "stateFuelOptionsWork", this.getWorkStateParent());
        this.blockedGoOnEvent = null;
    }

    void removeObservers() {
        this.removeObservers(OBSERVERS);
    }

    void registerObservers() {
        this.addObservers(OBSERVERS);
    }

    void registerDsiStateChangeListeners(String string, int n) {
        if (string.intern() == (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = HsmTargetPoiSetupFuelOptions.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName().intern() && !this.isFirstStartupDone) {
            if (this.isTraceEnabled()) {
                this.trace().append("HsmTargetPoiSetupFuelOptions tries to register to ").append(string).append("...").log();
            }
            this.initDSINavigation();
            this.isFirstStartupDone = true;
            if (this.isTraceEnabled()) {
                this.trace().append("HsmTargetPoiSetupFuelOptions registered to ").append(string).log();
            }
        }
    }

    private void initDSINavigation() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.dsiNavigation = (DSINavigation)dSIProxy.getService(this, class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = HsmTargetPoiSetupFuelOptions.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation);
        this.navigationListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this.getHsm(), class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = HsmTargetPoiSetupFuelOptions.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener);
        dSIProxy.addResponseListener(this, class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = HsmTargetPoiSetupFuelOptions.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener, this.navigationListener);
        this.dsiNavigation.setNotification(ATTRIBUTES_NAVIGATION, this.navigationListener);
    }

    void unregisterDsiStateChangeListeners(String string, int n) {
        if (string.intern() == (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = HsmTargetPoiSetupFuelOptions.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName().intern()) {
            if (this.isTraceEnabled()) {
                this.trace().append("HsmTargetPoiSetupFuelOptions tries to unregister from ").append(string).append("...").log();
            }
            try {
                DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
                if (dSIProxy == null) {
                    this.trace().append("DSIProxy was null!");
                    return;
                }
                this.unregisterDsiNavigation(string, dSIProxy);
            }
            catch (Exception exception) {
                ServiceManager.errorHandler.handleDsiError(exception);
            }
        }
    }

    private void unregisterDsiNavigation(String string, DSIProxy dSIProxy) {
        if (this.navigationListener != null) {
            dSIProxy.removeResponseListener(this, class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = HsmTargetPoiSetupFuelOptions.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener, this.navigationListener);
            this.navigationListener = null;
        }
        this.traceUnregisteredDpone(string);
    }

    private void traceUnregisteredDpone(String string) {
        if (this.isTraceEnabled()) {
            this.trace().append("HsmTargetPoiSetupFuelOptions unregistered from ").append(string).log();
        }
    }

    @Override
    protected HsmState getDefaultState() {
        return this.stateFuelOptionsWork;
    }

    @Override
    public int getSubClassifier() {
        return 16384;
    }

    public DSINavigation getDsiNavigation() {
        return this.dsiNavigation;
    }

    @Override
    public void reset(HashMap hashMap) {
        if (this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = HsmTargetPoiSetupFuelOptions.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName(), 0)) {
            if (this.isTraceEnabled()) {
                this.trace("PoiHsmTarget: resetting values after DSI restart");
            }
            this.resetHsmToState(this.getDefaultState());
            this.initLocalVariables();
            this.initDSINavigation();
        } else if (this.isTraceEnabled()) {
            this.trace("PoiHsmTarget: no reset necessary because restarted DSI(s) is/are not used in target");
        }
    }

    private void initLocalVariables() {
        this.blockedGoOnEvent = null;
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

