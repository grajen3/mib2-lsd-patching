/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.spellerx.handler;

import de.vw.mib.asl.api.navigation.locationinput.ISpellerContext;
import de.vw.mib.asl.api.navigation.locationinput.SpellerHandler;
import de.vw.mib.asl.api.navigation.poi.ASLNavigationPoiFactory;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.internal.navigation.spellerx.handler.HandlerLogUtil;
import org.dsi.ifc.global.NavLocation;

public class PoiMapInputHandler
implements SpellerHandler {
    private String className = super.getClass().getName();
    private HandlerLogUtil logUtil = new HandlerLogUtil();

    @Override
    public void onActivated(ISpellerContext iSpellerContext) {
        NavLocation navLocation = ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPoiSearchLocation();
        this.logUtil.logTraceWLocation(this.className, " onActivated: activating location: ", navLocation);
        ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setMapInputLocation(ASLNavigationUtilFactory.getNavigationUtilApi().cloneLocation(navLocation));
    }

    @Override
    public void onLocationDiscarded(ISpellerContext iSpellerContext) {
        this.logUtil.logTrace(super.getClass().getName(), " onLocationDiscarded: discarding location");
    }

    @Override
    public void onLocationSaved(ISpellerContext iSpellerContext) {
        NavLocation navLocation = ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getMapInputLocation();
        ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setPoiSearchLocation(ASLNavigationUtilFactory.getNavigationUtilApi().cloneLocation(navLocation));
        ASLNavigationPoiFactory.getNavigationPoiApi().getPoiSetup().setLocationForSearchAreaMap(ASLNavigationUtilFactory.getNavigationUtilApi().cloneLocation(navLocation));
    }

    @Override
    public void onContext(ISpellerContext iSpellerContext) {
    }
}

