/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.spellerx.handler;

import de.vw.mib.asl.api.navigation.locationinput.ISpellerContext;
import de.vw.mib.asl.api.navigation.locationinput.SpellerHandler;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.internal.navigation.spellerx.handler.HandlerLogUtil;
import org.dsi.ifc.global.NavLocation;

public class MapInputHandler
implements SpellerHandler {
    private String className = super.getClass().getName();
    private HandlerLogUtil logUtil = new HandlerLogUtil();

    @Override
    public void onActivated(ISpellerContext iSpellerContext) {
        NavLocation navLocation = ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getMapInputLocation();
        this.logUtil.logTraceWLocation(this.className, " onActivated: activating location: ", navLocation);
        iSpellerContext.setLocation(navLocation);
    }

    @Override
    public void onLocationDiscarded(ISpellerContext iSpellerContext) {
        this.logUtil.logTrace(super.getClass().getName(), " onLocationDiscarded: discarding location");
    }

    @Override
    public void onLocationSaved(ISpellerContext iSpellerContext) {
        NavLocation navLocation = iSpellerContext.getLocation();
        NavLocation navLocation2 = ASLNavigationUtilFactory.getNavigationUtilApi().cloneLocation(navLocation);
        ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setMapInputLocation(navLocation2);
        this.logUtil.logTraceWLocation(this.className, " onLocationSaved: saving location: ", navLocation2);
    }

    @Override
    public void onContext(ISpellerContext iSpellerContext) {
        NavLocation navLocation = ASLNavigationUtilFactory.getNavigationUtilApi().cloneLocation(iSpellerContext.getLocation());
        if (navLocation != null && navLocation.isPositionValid()) {
            ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setSpellerLocation(ASLNavigationUtilFactory.getNavigationUtilApi().cloneLocation(navLocation));
            ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setDestInputLocation(ASLNavigationUtilFactory.getNavigationUtilApi().cloneLocation(navLocation));
            this.logUtil.logTraceWLocation(this.className, " onContext: location changed, storing location in DP", navLocation);
        } else {
            this.logUtil.logTraceWLocation(this.className, " onContext: location NOT CHANGED in DP ", navLocation);
        }
    }
}

