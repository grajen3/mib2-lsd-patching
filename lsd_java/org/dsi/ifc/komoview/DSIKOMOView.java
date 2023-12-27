/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.komoview;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.komoview.RouteInfoElement;

public interface DSIKOMOView
extends DSIBase {
    public static final String VERSION;
    public static final int ROUTEINFOELEMENTTYPE_RIE_NONE;
    public static final int ROUTEINFOELEMENTTYPE_RIE_POI;
    public static final int ROUTEINFOELEMENTTYPE_RIE_TMC;
    public static final int ROUTEINFOELEMENTTYPE_RIE_MANEUVER;
    public static final int ROUTEINFOELEMENTTYPE_RIE_CALC;
    public static final int KOMOVIEWSTYLE_VARIANT1;
    public static final int KOMOVIEWSTYLE_VARIANT2;
    public static final int KOMOVIEWSTYLE_VARIANT3;
    public static final int KOMOVIEWSTYLE_VARIANT4;
    public static final int KOMOVIEWSTYLE_VARIANT5;
    public static final int KOMOVIEWSTYLE_VARIANT6;
    public static final int KOMOVIEWSTYLE_VARIANT7;
    public static final int KOMOVIEWSTYLE_NOKOMOVIEW;
    public static final int KOMOVIEWRESULT_OK;
    public static final int KOMOVIEWRESULT_NOT_OPERABLE;
    public static final int KOMOVIEWRESULT_ERROR;
    public static final int KOMOVIEWRESULT_UNSUPPORTED;
    public static final int KOMOVIEWTYPE_UNDEFINED;
    public static final int KOMOVIEWTYPE_MANEUVERVIEW;
    public static final int KOMOVIEWTYPE_ROUTEINFO;
    public static final int ATTR_KOMOVIEWENABLED;
    public static final int ATTR_VISIBILITY;
    public static final int ATTR_CURRENTKOMOVIEWTYPE;
    public static final int RT_ENABLEKOMOVIEW;
    public static final int RT_NOTIFYVISIBILITY;
    public static final int RT_SETROUTEINFOELEMENT;
    public static final int RT_SETKOMOVIEWSTYLE;
    public static final int RT_SETROUTEINFO;
    public static final int RP_KOMOVIEWRESULT;

    default public void enableKomoView(boolean bl) {
    }

    default public void notifyVisibility(boolean bl) {
    }

    default public void setRouteInfoElement(RouteInfoElement routeInfoElement) {
    }

    default public void setRouteInfo(RouteInfoElement[] routeInfoElementArray) {
    }

    default public void setKomoViewStyle(int n) {
    }
}

