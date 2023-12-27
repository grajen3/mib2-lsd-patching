/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.spellerx.handler;

import de.vw.mib.asl.api.navigation.locationinput.ISpellerContext;
import de.vw.mib.asl.api.navigation.locationinput.SpellerHandler;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.spellerx.handler.HandlerLogUtil;
import org.dsi.ifc.global.NavLocation;

public class TourModeInputHandler
implements SpellerHandler {
    private String className = super.getClass().getName();
    private HandlerLogUtil logUtil = new HandlerLogUtil();

    @Override
    public void onActivated(ISpellerContext iSpellerContext) {
        NavLocation navLocation = ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getTourmodeLocation();
        this.logUtil.logTraceWLocation(this.className, " onActivated: activating location: ", navLocation);
        iSpellerContext.setLocation(navLocation);
    }

    @Override
    public void onLocationDiscarded(ISpellerContext iSpellerContext) {
        this.logUtil.logTrace(super.getClass().getName(), " onLocationDiscarded: discarding location");
        ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setTourmodeLocation(null);
    }

    @Override
    public void onLocationSaved(ISpellerContext iSpellerContext) {
        this.logUtil.logTraceWLocation(this.className, " onLocationSaved: saving location: ", iSpellerContext.getLocation());
        ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setTourmodeLocation(iSpellerContext.getLocation());
    }

    @Override
    public void onContext(ISpellerContext iSpellerContext) {
        NavLocation navLocation;
        if (ServiceManager.logger.isTraceEnabled(16384)) {
            ServiceManager.logger.trace(16384, "TourModeInputHandler: on context");
        }
        if ((navLocation = iSpellerContext.getLocation()) != null && navLocation.isPositionValid()) {
            this.logUtil.logTraceWLocation(this.className, " onContext: location is: ", navLocation);
            ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setSpellerLocation(ASLNavigationUtilFactory.getNavigationUtilApi().cloneLocation(navLocation));
            ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setTourmodeLocation(iSpellerContext.getLocation());
        } else {
            this.logUtil.logTraceWLocation(this.className, " onContext: Location not persisted because it is either null or position not valid.: ", navLocation);
        }
    }
}

