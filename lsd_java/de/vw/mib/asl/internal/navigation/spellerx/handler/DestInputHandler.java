/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.spellerx.handler;

import de.vw.mib.asl.api.navigation.guidance.ASLNavigationGuidanceFactory;
import de.vw.mib.asl.api.navigation.locationinput.ISpellerContext;
import de.vw.mib.asl.api.navigation.locationinput.SpellerHandler;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.internal.navigation.spellerx.handler.HandlerLogUtil;
import org.dsi.ifc.global.NavLocation;

public class DestInputHandler
implements SpellerHandler {
    private String className = super.getClass().getName();
    private HandlerLogUtil logUtil = new HandlerLogUtil();

    @Override
    public void onActivated(ISpellerContext iSpellerContext) {
        NavLocation navLocation = ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getDestInputLocation();
        this.logUtil.logTraceWLocation(this.className, " activated. Location: ", navLocation);
        iSpellerContext.setLocation(navLocation);
    }

    @Override
    public void onLocationDiscarded(ISpellerContext iSpellerContext) {
        this.logUtil.logTrace(super.getClass().getName(), " onLocationDiscarded: discarding location");
    }

    @Override
    public void onLocationSaved(ISpellerContext iSpellerContext) {
        NavLocation navLocation = ASLNavigationUtilFactory.getNavigationUtilApi().cloneLocation(iSpellerContext.getLocation());
        this.logUtil.logTraceWLocation(this.className, " onLocationSaved: location saved, storing location: ", navLocation);
        ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setDestInputLocation(navLocation, true);
        ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setMemoryLocation(navLocation);
        ASLNavigationGuidanceFactory.getNavigationGuidanceApi().getDestInputSetup().setLastDest(navLocation);
    }

    @Override
    public void onContext(ISpellerContext iSpellerContext) {
        NavLocation navLocation = ASLNavigationUtilFactory.getNavigationUtilApi().cloneLocation(iSpellerContext.getLocation());
        if (navLocation != null && navLocation.isPositionValid()) {
            ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setSpellerLocation(ASLNavigationUtilFactory.getNavigationUtilApi().cloneLocation(navLocation));
            ASLNavigationGuidanceFactory.getNavigationGuidanceApi().getDestInputSetup().setLastDest(navLocation);
            this.logUtil.logTraceWLocation(this.className, " onContext: location changed, storing location in DP", navLocation);
        } else {
            this.logUtil.logTraceWLocation(this.className, " onContext: location NOT CHANGED in DP ", navLocation);
        }
        ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setDestInputLocation(ASLNavigationUtilFactory.getNavigationUtilApi().cloneLocation(navLocation), false);
    }
}

