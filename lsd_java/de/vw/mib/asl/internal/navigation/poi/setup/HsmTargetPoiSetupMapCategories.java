/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.setup;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.AbstractResettableAslHsmTarget;
import de.vw.mib.asl.internal.navigation.poi.setup.StatePoiSetupMapCategoriesWork;
import de.vw.mib.genericevents.AbstractTarget;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import java.util.HashMap;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.navigation.DSINavigation;

public class HsmTargetPoiSetupMapCategories
extends AbstractResettableAslHsmTarget {
    public static final int MAX_NUMBER_OF_SELECTED_CATEGORIES;
    DSINavigation dsiNavigation;
    private static final int[] ATTRIBUTES_NAVIGATION;
    private static final int[] ASL_OBSERVER;
    final HsmState statePoiSetupWork;
    private DSIListener navigationListener;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigation;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigationListener;

    public HsmTargetPoiSetupMapCategories(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
        this.statePoiSetupWork = new StatePoiSetupMapCategoriesWork(this, this.hsm, "statePoiSetupWork", this.getWorkStateParent());
    }

    static void addObserver(AbstractTarget abstractTarget) {
        abstractTarget.addObservers(ASL_OBSERVER);
    }

    static void removeObserver(AbstractTarget abstractTarget) {
        abstractTarget.removeObservers(ASL_OBSERVER);
    }

    void registerDsiStateChangeListeners(String string, int n) {
        if (string.intern() == (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = HsmTargetPoiSetupMapCategories.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName().intern() && !this.isFirstStartupDone) {
            if (this.isTraceEnabled()) {
                this.trace().append("HsmTargetPoiSetupMapCategories tries to register to ").append(string).append("...").log();
            }
            this.initDSINavigation();
            this.isFirstStartupDone = true;
            if (this.isTraceEnabled()) {
                this.trace().append("HsmTargetPoiSetupMapCategories registered to ").append(string).log();
            }
        }
    }

    private void initDSINavigation() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.dsiNavigation = (DSINavigation)dSIProxy.getService(this, class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = HsmTargetPoiSetupMapCategories.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation);
        this.navigationListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this.getHsm(), class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = HsmTargetPoiSetupMapCategories.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener);
        dSIProxy.addResponseListener(this, class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = HsmTargetPoiSetupMapCategories.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener, this.navigationListener);
        this.dsiNavigation.setNotification(ATTRIBUTES_NAVIGATION, this.navigationListener);
    }

    void unregisterDsiStateChangeListeners(String string, int n) {
        if (string.intern() == (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = HsmTargetPoiSetupMapCategories.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName().intern()) {
            if (this.isTraceEnabled()) {
                this.trace().append("HsmTargetPoiSetupMapCategories tries to unregister from ").append(string).append("...").log();
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
            dSIProxy.removeResponseListener(this, class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = HsmTargetPoiSetupMapCategories.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener, this.navigationListener);
            this.navigationListener = null;
        }
        this.traceUnregisteredDone(string);
    }

    private void traceUnregisteredDone(String string) {
        if (this.isTraceEnabled()) {
            this.trace().append("HsmTargetPoiSetupMapCategories unregistered from ").append(string).log();
        }
    }

    @Override
    protected HsmState getDefaultState() {
        return this.statePoiSetupWork;
    }

    @Override
    public int getSubClassifier() {
        return 512;
    }

    @Override
    public void reset(HashMap hashMap) {
        if (this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = HsmTargetPoiSetupMapCategories.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName(), 0)) {
            if (this.isTraceEnabled()) {
                this.trace("HsmTargetPoiSetupMapcategories: resetting values after DSI restart");
            }
            this.resetHsmToState(this.getDefaultState());
            this.initDSINavigation();
        } else if (this.isTraceEnabled()) {
            this.trace("HsmTargetPoiSetupMapcategories: no reset necessary because restarted DSI(s) is/are not used in target");
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

    static {
        ATTRIBUTES_NAVIGATION = new int[0];
        ASL_OBSERVER = new int[]{-1040056256, -1090387904, -1056833472, 308557056};
    }
}

