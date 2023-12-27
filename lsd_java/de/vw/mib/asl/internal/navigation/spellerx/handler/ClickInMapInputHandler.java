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

public class ClickInMapInputHandler
implements SpellerHandler {
    private boolean isHigh = ServiceManager.configManagerDiag.isFeatureFlagSet(70);
    private boolean isChnEnabled = ServiceManager.configManagerDiag.getNaviLocationOptionDefaultBoolean(1);
    private boolean isJpInput = ServiceManager.configManagerDiag.isFeatureFlagSet(75);
    private String className = super.getClass().getName();
    private HandlerLogUtil logUtil = new HandlerLogUtil();

    @Override
    public void onActivated(ISpellerContext iSpellerContext) {
        NavLocation navLocation = ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getClickInMapLocation();
        this.logUtil.logTraceWLocation(this.className, " onActivated: activating location: ", navLocation);
        iSpellerContext.setLocation(navLocation);
    }

    @Override
    public void onLocationDiscarded(ISpellerContext iSpellerContext) {
        this.logUtil.logTrace(super.getClass().getName(), " onLocationDiscarded: discarding not implemented");
    }

    @Override
    public void onLocationSaved(ISpellerContext iSpellerContext) {
        this.logUtil.logTraceWLocation(this.className, " onLocationSaved: saving location: ", iSpellerContext.getLocation());
        ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setClickInMapLocation(iSpellerContext.getLocation());
    }

    @Override
    public void onContext(ISpellerContext iSpellerContext) {
        if (this.isHigh && (this.isChnEnabled || this.isJpInput)) {
            this.logUtil.logTrace(this.className, " onContext: location is not stored on high targets with china features");
        } else {
            NavLocation navLocation = iSpellerContext.getLocation();
            if (navLocation != null && navLocation.isPositionValid()) {
                this.logUtil.logTraceWLocation(this.className, " onContext: location is: ", navLocation);
                ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setSpellerLocation(ASLNavigationUtilFactory.getNavigationUtilApi().cloneLocation(navLocation));
                ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setClickInMapLocation(iSpellerContext.getLocation());
                ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setDestInputLocation(iSpellerContext.getLocation());
            } else {
                this.logUtil.logTraceWLocation(this.className, " onContext: Location not persisted because it is either null or position not valid.: ", navLocation);
            }
        }
    }
}

