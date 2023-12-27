/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navigation;

import org.dsi.ifc.base.DSIBase;

public interface DSICombinedRouteList
extends DSIBase {
    public static final String VERSION;
    public static final int COMBINEDROUTELISTELEMENTTYPE_LIST_END;
    public static final int COMBINEDROUTELISTELEMENTTYPE_LIST_START;
    public static final int COMBINEDROUTELISTELEMENTTYPE_ROAD_SEGMENT;
    public static final int COMBINEDROUTELISTELEMENTTYPE_POINT;
    public static final int COMBINEDROUTELISTELEMENTTYPE_MANEUVER;
    public static final int COMBINEDROUTELISTELEMENTTYPE_TRAFFIC_EVENT;
    public static final int COMBINEDROUTELISTELEMENTTYPE_POI;
    public static final int COMBINEDROUTELISTELEMENTTYPE_STOPOVER;
    public static final int COMBINEDROUTELISTELEMENTTYPE_JUNCTION;
    public static final int COMBINEDROUTELISTELEMENTTYPE_FERRYSEGMENT;
    public static final int COMBINEDROUTELISTELEMENTTYPE_SLOPESEGMENT;
    public static final int COMBINEDROUTELISTELEMENTTYPE_TUNNELSEGMENT;
    public static final int COMBINEDROUTELISTELEMENTTYPE_COUNTRYCHANGE;
    public static final int COMBINEDROUTELISTELEMENTTYPE_STATECHANGE;
    public static final int COMBINEDROUTELISTELEMENTTYPE_PROVINCECHANGE;
    public static final int COMBINEDROUTELISTELEMENTTYPE_OFFROAD_SEGMENT;
    public static final int COMBINEDROUTELISTELEMENTTYPE_OFFROAD;
    public static final int COMBINEDROUTELISTELEMENTTYPE_HOVLANE;
    public static final int COMBINEDROUTELISTELEMENTTYPE_TOLLSTATION;
    public static final int COMBINEDROUTELISTELEMENTTYPE_CARTRAIN;
    public static final int CHANGEINDICATOR_WINDOWCHANGED;
    public static final int CHANGEINDICATOR_RGSTOPPED;
    public static final int CHANGEINDICATOR_RGSTARTED;
    public static final int LISTCONTENT_TOPLEVELNODES;
    public static final int LISTCONTENT_LEAFNODES;
    public static final int LISTCONTENT_ALLNODES;
    public static final int RT_REQUESTCOMBINEDROUTELISTWINDOW;
    public static final int RT_REQUESTTRAFFICINFORMATION;
    public static final int RT_REQUESTPOIINFORMATION;
    public static final int RT_GETBOUNDINGRECTANGLEOFCOMBINEDROUTELISTELEMENTS;
    public static final int RT_REQUESTPRICEINFO;
    public static final int RP_COMBINEDROUTELISTRESULT;
    public static final int RP_TRAFFICINFORMATIONRESULT;
    public static final int RP_POIINFORMATIONRESULT;
    public static final int RP_GETBOUNDINGRECTANGLEOFCOMBINEDROUTELISTELEMENTSRESULT;
    public static final int RP_REQUESTPRICEINFORESULT;
    public static final int IN_WINDOWCHANGED;
    public static final int ATTR_ELEMENTSTOTAL;

    default public void requestCombinedRouteListWindow(int n, int n2, long[] lArray, long l) {
    }

    default public void requestTrafficInformation(long l) {
    }

    default public void requestPOIInformation(long l) {
    }

    default public void getBoundingRectangleOfCombinedRouteListElements(long[] lArray) {
    }

    default public void requestPriceInfo(long l) {
    }
}

