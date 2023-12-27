/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.spellerx.handler;

import de.vw.mib.asl.api.navigation.locationinput.ISpellerContext;
import de.vw.mib.asl.api.navigation.locationinput.SpellerHandler;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.spellerx.handler.HandlerLogUtil;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.DSINavigation;

public class DemoInputHandler
implements SpellerHandler {
    private DSINavigation dsiNavigation;
    private HandlerLogUtil logUtil = new HandlerLogUtil();
    private String className = super.getClass().getName();
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigation;

    @Override
    public void onActivated(ISpellerContext iSpellerContext) {
        NavLocation navLocation = ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getDemoLocation();
        this.printTraceWithLocation(" onActivated: activating with location ", navLocation);
        iSpellerContext.setLocation(navLocation);
    }

    @Override
    public void onLocationDiscarded(ISpellerContext iSpellerContext) {
        this.logUtil.logTrace(super.getClass().getName(), " onLocationDiscarded: discarding location");
    }

    @Override
    public void onLocationSaved(ISpellerContext iSpellerContext) {
        NavLocation navLocation = ASLNavigationUtilFactory.getNavigationUtilApi().cloneLocation(iSpellerContext.getLocation());
        this.printTraceWithLocation(" onLocationSaved: saving location ", navLocation);
        ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setDemoLocation(navLocation);
        this.setDemoAddress(iSpellerContext, navLocation);
    }

    @Override
    public void onContext(ISpellerContext iSpellerContext) {
        NavLocation navLocation = ASLNavigationUtilFactory.getNavigationUtilApi().cloneLocation(iSpellerContext.getLocation());
        if (navLocation != null && navLocation.isPositionValid()) {
            ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setSpellerLocation(ASLNavigationUtilFactory.getNavigationUtilApi().cloneLocation(navLocation));
        } else {
            this.printTraceWithLocation(" onContext: Don't save the location because it is either null or inValid: ", navLocation);
        }
    }

    private void setDemoAddress(ISpellerContext iSpellerContext, NavLocation navLocation) {
        if (this.dsiNavigation == null) {
            DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
            this.dsiNavigation = (DSINavigation)dSIProxy.getService(iSpellerContext.getTarget(), class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = DemoInputHandler.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation);
        }
        this.dsiNavigation.rgSetPosition(navLocation);
    }

    private void printTraceWithLocation(String string, NavLocation navLocation) {
        if (ServiceManager.logger.isTraceEnabled(16384)) {
            this.logUtil.logTraceWLocation(this.className, string, navLocation);
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

