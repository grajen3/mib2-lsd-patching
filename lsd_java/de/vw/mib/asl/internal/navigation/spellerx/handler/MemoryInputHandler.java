/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.spellerx.handler;

import de.vw.mib.asl.api.navigation.locationinput.ISpellerContext;
import de.vw.mib.asl.api.navigation.locationinput.SpellerHandler;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.INavigationDP;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.spellerx.handler.HandlerLogUtil;
import de.vw.mib.genericevents.EventGeneric;
import org.dsi.ifc.global.NavLocation;

public class MemoryInputHandler
implements SpellerHandler {
    private String className = super.getClass().getName();
    private HandlerLogUtil logUtil = new HandlerLogUtil();

    @Override
    public void onActivated(ISpellerContext iSpellerContext) {
        NavLocation navLocation = ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getMemoryLocation();
        this.logUtil.logTraceWLocation(this.className, " onActivated: activating location ", navLocation);
        iSpellerContext.setLocation(navLocation);
    }

    @Override
    public void onLocationDiscarded(ISpellerContext iSpellerContext) {
        this.logUtil.logTrace(super.getClass().getName(), " onLocationDiscarded: discarding location");
    }

    @Override
    public void onLocationSaved(ISpellerContext iSpellerContext) {
        NavLocation navLocation = ASLNavigationUtilFactory.getNavigationUtilApi().cloneLocation(iSpellerContext.getLocation());
        this.logUtil.logTraceWLocation(this.className, " onLocationSaved: saving location: ", navLocation);
        INavigationDP iNavigationDP = ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp();
        iNavigationDP.setMemoryLocation(ASLNavigationUtilFactory.getNavigationUtilApi().cloneLocation(navLocation));
        iNavigationDP.setDestInputLocation(ASLNavigationUtilFactory.getNavigationUtilApi().cloneLocation(navLocation));
        EventGeneric eventGeneric = ServiceManager.eventMain.getEventFactory().newEvent(-1, 2068517888, 1963065408);
        ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
    }

    @Override
    public void onContext(ISpellerContext iSpellerContext) {
        NavLocation navLocation = ASLNavigationUtilFactory.getNavigationUtilApi().cloneLocation(iSpellerContext.getLocation());
        if (navLocation != null && navLocation.isPositionValid()) {
            ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setSpellerLocation(ASLNavigationUtilFactory.getNavigationUtilApi().cloneLocation(navLocation));
        }
        this.logUtil.logTraceWLocation(this.className, " onContext: changing DP location: ", navLocation);
        ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setMemoryLocation(ASLNavigationUtilFactory.getNavigationUtilApi().cloneLocation(navLocation));
        ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setDestInputLocation(ASLNavigationUtilFactory.getNavigationUtilApi().cloneLocation(navLocation));
    }
}

