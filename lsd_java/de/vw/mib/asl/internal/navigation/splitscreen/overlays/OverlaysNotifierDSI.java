/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.splitscreen.overlays;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.splitscreen.overlays.OverlaysTargetHSM;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.map.DSIMapViewerManeuverView;
import org.dsi.ifc.navigation.DSINavigation;

public class OverlaysNotifierDSI
implements DSIServiceStateListener {
    private DSINavigation dsiNavigation;
    private DSIListener navigationListener;
    protected DSIMapViewerManeuverView dsiMapViewerManeuverView;
    DSIListener mapManeuverViewListener;
    private OverlaysTargetHSM target;
    private boolean isServiceStateListenerAdded = false;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigation;
    static /* synthetic */ Class class$org$dsi$ifc$map$DSIMapViewerManeuverView;
    static /* synthetic */ Class class$org$dsi$ifc$map$DSIMapViewerManeuverViewListener;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigationListener;

    public OverlaysNotifierDSI(OverlaysTargetHSM overlaysTargetHSM) {
        this.target = overlaysTargetHSM;
    }

    public void registerDSI() {
        if (!this.isServiceStateListenerAdded) {
            this.isServiceStateListenerAdded = true;
            ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = OverlaysNotifierDSI.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation, this);
            ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$map$DSIMapViewerManeuverView == null ? (class$org$dsi$ifc$map$DSIMapViewerManeuverView = OverlaysNotifierDSI.class$("org.dsi.ifc.map.DSIMapViewerManeuverView")) : class$org$dsi$ifc$map$DSIMapViewerManeuverView, this);
        }
    }

    public void hideManoeuvreView() {
        this.dsiMapViewerManeuverView.hideManoeuvreView();
    }

    public void selectManoeuvreView(int n, boolean bl) {
        this.dsiMapViewerManeuverView.selectManoeuvreView(n, bl);
    }

    public void enableRgMotorwayInfo(boolean bl) {
        this.dsiNavigation.setVirtualRouteGuidance(bl);
    }

    @Override
    public void registered(String string, int n) {
        if (this.target.isFirstStartupDone) {
            return;
        }
        if (string.intern() == (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = OverlaysNotifierDSI.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName().intern()) {
            this.initDsiNavigation();
        } else if (string.intern() == (class$org$dsi$ifc$map$DSIMapViewerManeuverView == null ? (class$org$dsi$ifc$map$DSIMapViewerManeuverView = OverlaysNotifierDSI.class$("org.dsi.ifc.map.DSIMapViewerManeuverView")) : class$org$dsi$ifc$map$DSIMapViewerManeuverView).getName().intern()) {
            this.initDsiMapManeuverView();
        }
        if (this.dsiNavigation != null && this.dsiMapViewerManeuverView != null) {
            this.target.isFirstStartupDone = true;
        }
    }

    void initDsiMapManeuverView() {
        if (this.target.isTraceEnabled()) {
            this.target.trace().append("DsiMapManeuverView registered").log();
        }
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.dsiMapViewerManeuverView = (DSIMapViewerManeuverView)dSIProxy.getService(this.target, class$org$dsi$ifc$map$DSIMapViewerManeuverView == null ? (class$org$dsi$ifc$map$DSIMapViewerManeuverView = OverlaysNotifierDSI.class$("org.dsi.ifc.map.DSIMapViewerManeuverView")) : class$org$dsi$ifc$map$DSIMapViewerManeuverView);
        this.mapManeuverViewListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this.target.getHsm(), class$org$dsi$ifc$map$DSIMapViewerManeuverViewListener == null ? (class$org$dsi$ifc$map$DSIMapViewerManeuverViewListener = OverlaysNotifierDSI.class$("org.dsi.ifc.map.DSIMapViewerManeuverViewListener")) : class$org$dsi$ifc$map$DSIMapViewerManeuverViewListener);
        dSIProxy.addResponseListener(this.target, class$org$dsi$ifc$map$DSIMapViewerManeuverViewListener == null ? (class$org$dsi$ifc$map$DSIMapViewerManeuverViewListener = OverlaysNotifierDSI.class$("org.dsi.ifc.map.DSIMapViewerManeuverViewListener")) : class$org$dsi$ifc$map$DSIMapViewerManeuverViewListener, this.mapManeuverViewListener);
        this.dsiMapViewerManeuverView.setNotification(new int[]{1, 2}, this.mapManeuverViewListener);
    }

    void initDsiNavigation() {
        if (this.target.isTraceEnabled()) {
            this.target.trace().append("DsiNavigation registered").log();
        }
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.dsiNavigation = (DSINavigation)dSIProxy.getService(this.target, class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = OverlaysNotifierDSI.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation);
        this.navigationListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this.target.getHsm(), class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = OverlaysNotifierDSI.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener);
        dSIProxy.addResponseListener(this.target, class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = OverlaysNotifierDSI.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener, this.navigationListener);
        this.dsiNavigation.setNotification(new int[]{11, 54, 25, 75, 85, 23, 13}, this.navigationListener);
    }

    @Override
    public void unregistered(String string, int n) {
        try {
            DSIProxy dSIProxy;
            if (this.target.isTraceEnabled()) {
                this.target.trace().append("OverlaysNotifierDSI tries to unregistered from ").append(string).append("...").log();
            }
            if ((dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy()) == null) {
                this.target.trace().append("DSIProxy was null!");
                return;
            }
            if (string.intern() == (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = OverlaysNotifierDSI.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName().intern()) {
                this.unregisterDsiNavigation(string, dSIProxy);
            } else if (string.intern() == (class$org$dsi$ifc$map$DSIMapViewerManeuverView == null ? (class$org$dsi$ifc$map$DSIMapViewerManeuverView = OverlaysNotifierDSI.class$("org.dsi.ifc.map.DSIMapViewerManeuverView")) : class$org$dsi$ifc$map$DSIMapViewerManeuverView).getName().intern()) {
                this.unregisterDsiMapViewerManeuverView(string, dSIProxy);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleDsiError(exception);
        }
    }

    private void unregisterDsiMapViewerManeuverView(String string, DSIProxy dSIProxy) {
        if (this.mapManeuverViewListener != null) {
            dSIProxy.removeResponseListener(this.target, class$org$dsi$ifc$map$DSIMapViewerManeuverViewListener == null ? (class$org$dsi$ifc$map$DSIMapViewerManeuverViewListener = OverlaysNotifierDSI.class$("org.dsi.ifc.map.DSIMapViewerManeuverViewListener")) : class$org$dsi$ifc$map$DSIMapViewerManeuverViewListener, this.mapManeuverViewListener);
            this.mapManeuverViewListener = null;
        }
        this.traceUnregisteredDone(string);
    }

    private void unregisterDsiNavigation(String string, DSIProxy dSIProxy) {
        if (this.navigationListener != null) {
            dSIProxy.removeResponseListener(this.target, class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = OverlaysNotifierDSI.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener, this.navigationListener);
            this.navigationListener = null;
        }
        this.traceUnregisteredDone(string);
    }

    private void traceUnregisteredDone(String string) {
        if (this.target.isTraceEnabled()) {
            this.target.trace().append("OverlaysNotifierDSI unregistered from ").append(string).log();
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

