/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.traffic;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.internal.navigation.traffic.TrafficTargetHSM;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.navigation.DSINavigation;
import org.dsi.ifc.navigation.DSINavigationListener;
import org.dsi.ifc.tmc.DSITmc;
import org.dsi.ifc.tmc.DSITmcListener;
import org.dsi.ifc.tmc.DSITmcOnRoute;
import org.dsi.ifc.tmc.DSITmcOnRouteListener;

public class TrafficEvents {
    private static final int[] ATTRIBUTES_NAVIGATION = new int[]{43};
    private static final DSIProxy PROXY = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
    private static final int[] ATTRIBUTES_TMC = new int[]{5, 2, 1, 6, 8, 11};
    private static final int[] ATTRIBUTES_TMCONROUTE = new int[]{2};
    static final int EV_NAVIGATION_TMC_TRAFFIC_TIMEROUT_FOR_REQUESTTMCMESSAGE;
    static final int EV_NAVIGATION_TMC_TRAFFIC_TIMEROUT_FOR_REQUESTTMCWINDOW;
    static final int EV_NAVIGATION_TMC_TRAFFIC_TIMEROUT_FOR_OVERVIEW_LIST_POPUP;
    private static TrafficTargetHSM target;
    private static final int[] OBSERVERS;
    static /* synthetic */ Class class$org$dsi$ifc$tmc$DSITmc;
    static /* synthetic */ Class class$org$dsi$ifc$tmc$DSITmcListener;
    static /* synthetic */ Class class$org$dsi$ifc$tmc$DSITmcOnRoute;
    static /* synthetic */ Class class$org$dsi$ifc$tmc$DSITmcOnRouteListener;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigation;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigationListener;

    static void addObservers(TrafficTargetHSM trafficTargetHSM) {
        target = trafficTargetHSM;
        trafficTargetHSM.registerServices(new int[]{1138832128}, false);
        trafficTargetHSM.addObservers(OBSERVERS);
        TrafficEvents.initDsiNavigation();
        TrafficEvents.initDsiTMC();
        TrafficEvents.initDsiTMCOnRoute();
        TrafficEvents.initSDARS();
    }

    static void removeObservers(TrafficTargetHSM trafficTargetHSM) {
        trafficTargetHSM.removeObservers(OBSERVERS);
    }

    protected static void initDsiTMC() {
        if (target.isTraceEnabled()) {
            target.trace().append("TrafficEvents tries to register to ").append("DSITmc...").log();
        }
        TrafficEvents.target.dsiNotifier.dsiTmc = (DSITmc)PROXY.getService(target, class$org$dsi$ifc$tmc$DSITmc == null ? (class$org$dsi$ifc$tmc$DSITmc = TrafficEvents.class$("org.dsi.ifc.tmc.DSITmc")) : class$org$dsi$ifc$tmc$DSITmc);
        DSITmcListener dSITmcListener = (DSITmcListener)PROXY.getAdapterFactory().createDSIListenerMethodAdapter(target.getHsm(), class$org$dsi$ifc$tmc$DSITmcListener == null ? (class$org$dsi$ifc$tmc$DSITmcListener = TrafficEvents.class$("org.dsi.ifc.tmc.DSITmcListener")) : class$org$dsi$ifc$tmc$DSITmcListener);
        PROXY.addResponseListener(target, class$org$dsi$ifc$tmc$DSITmcListener == null ? (class$org$dsi$ifc$tmc$DSITmcListener = TrafficEvents.class$("org.dsi.ifc.tmc.DSITmcListener")) : class$org$dsi$ifc$tmc$DSITmcListener, dSITmcListener);
        TrafficEvents.target.dsiNotifier.dsiTmc.setNotification(ATTRIBUTES_TMC, (DSIListener)dSITmcListener);
        if (target.isTraceEnabled()) {
            target.trace().append("TrafficEvents registered to ").append("DSITmc").log();
        }
    }

    protected static void initDsiTMCOnRoute() {
        if (target.isTraceEnabled()) {
            target.trace().append("TrafficEvents tries to register to ").append("DSITmcOnRoute...").log();
        }
        TrafficEvents.target.dsiNotifier.dsiTmcOnRoute = (DSITmcOnRoute)PROXY.getService(target, class$org$dsi$ifc$tmc$DSITmcOnRoute == null ? (class$org$dsi$ifc$tmc$DSITmcOnRoute = TrafficEvents.class$("org.dsi.ifc.tmc.DSITmcOnRoute")) : class$org$dsi$ifc$tmc$DSITmcOnRoute);
        DSITmcOnRouteListener dSITmcOnRouteListener = (DSITmcOnRouteListener)PROXY.getAdapterFactory().createDSIListenerMethodAdapter(target.getHsm(), class$org$dsi$ifc$tmc$DSITmcOnRouteListener == null ? (class$org$dsi$ifc$tmc$DSITmcOnRouteListener = TrafficEvents.class$("org.dsi.ifc.tmc.DSITmcOnRouteListener")) : class$org$dsi$ifc$tmc$DSITmcOnRouteListener);
        PROXY.addResponseListener(target, class$org$dsi$ifc$tmc$DSITmcOnRouteListener == null ? (class$org$dsi$ifc$tmc$DSITmcOnRouteListener = TrafficEvents.class$("org.dsi.ifc.tmc.DSITmcOnRouteListener")) : class$org$dsi$ifc$tmc$DSITmcOnRouteListener, dSITmcOnRouteListener);
        TrafficEvents.target.dsiNotifier.dsiTmcOnRoute.setNotification(ATTRIBUTES_TMCONROUTE, (DSIListener)dSITmcOnRouteListener);
        if (target.isTraceEnabled()) {
            target.trace().append("TrafficEvents registered to ").append("DSITmcOnRoute").log();
        }
    }

    protected static void initDsiNavigation() {
        if (target.isTraceEnabled()) {
            target.trace().append("TrafficEvents tries to register to ").append("DSINavigation...").log();
        }
        DSINavigation dSINavigation = (DSINavigation)PROXY.getService(target, class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = TrafficEvents.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation);
        DSINavigationListener dSINavigationListener = (DSINavigationListener)PROXY.getAdapterFactory().createDSIListenerMethodAdapter(target.getHsm(), class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = TrafficEvents.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener);
        PROXY.addResponseListener(target, class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = TrafficEvents.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener, dSINavigationListener);
        dSINavigation.setNotification(ATTRIBUTES_NAVIGATION, (DSIListener)dSINavigationListener);
        if (target.isTraceEnabled()) {
            target.trace().append("TrafficEvents registered to ").append("DSINavigation").log();
        }
    }

    protected static void initSDARS() {
        target.getServiceRegister().registerService(1256272640, target.getTargetId());
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
        target = null;
        OBSERVERS = new int[]{771883072, 1138832128, 151191616, 167968832, 201523264, 235077696, 218300480, 251854912, 268632128, 285409344, 318963776, -1056899008, 134414400};
    }
}

