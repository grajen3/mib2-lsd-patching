/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.spellerx.handler;

import de.vw.mib.asl.api.navigation.guidance.ASLNavigationGuidanceFactory;
import de.vw.mib.asl.api.navigation.locationinput.ISpellerContext;
import de.vw.mib.asl.api.navigation.locationinput.SpellerHandler;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.ILocationFormatter;
import de.vw.mib.asl.internal.navigation.spellerx.handler.HandlerLogUtil;
import de.vw.mib.asl.internal.navigation.spellerx.model.ModelUpdater;
import org.dsi.ifc.global.NavLocation;

public class HomeInputHandler
implements SpellerHandler {
    private String className = super.getClass().getName();
    private HandlerLogUtil logUtil = new HandlerLogUtil();

    @Override
    public void onActivated(ISpellerContext iSpellerContext) {
        NavLocation navLocation = ASLNavigationGuidanceFactory.getNavigationGuidanceApi().getDestInputSetup().getHomeLocation();
        this.logUtil.logTraceWLocation(this.className, " onActivated: activating location: ", navLocation);
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
        this.setHomeLocation(navLocation);
    }

    private void setHomeLocation(NavLocation navLocation) {
        ILocationFormatter iLocationFormatter = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationFormatter();
        iLocationFormatter.fillHomeAddressGetter(navLocation);
        ASLNavigationGuidanceFactory.getNavigationGuidanceApi().getDestInputSetup().setHomeDest(navLocation, true);
        ModelUpdater.updateLocationInputActionResult(true);
    }

    @Override
    public void onContext(ISpellerContext iSpellerContext) {
        NavLocation navLocation = ASLNavigationUtilFactory.getNavigationUtilApi().cloneLocation(iSpellerContext.getLocation());
        if (navLocation != null && navLocation.isPositionValid()) {
            this.logUtil.logTraceWLocation(this.className, " onContext: location is: ", navLocation);
            ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setSpellerLocation(ASLNavigationUtilFactory.getNavigationUtilApi().cloneLocation(navLocation));
        } else {
            this.logUtil.logTraceWLocation(this.className, " onContext: Location not persisted because it is either null or position not valid.: ", navLocation);
        }
    }
}

