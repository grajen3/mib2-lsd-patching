/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.tmc;

import org.dsi.ifc.base.DSIBase;

public interface DSITmc
extends DSIBase {
    public static final String VERSION;
    public static final int ATTR_EVENTSONROUTE;
    public static final int ATTR_EVENTSTOTAL;
    public static final int ATTR_TMCSTATE;
    public static final int ATTR_ISENGINEERINGMODE;
    public static final int ATTR_CURRENTLANGUAGE;
    public static final int ATTR_ISTMCPROAVAILABLE;
    public static final int ATTR_ACTIVETRAFFICSOURCES;
    public static final int ATTR_AREAWARNING;
    public static final int ATTR_AREAWARNINGS;
    public static final int ATTR_LOCALHAZARDINFORMATION;
    public static final int ATTR_TRAFFICFLOWSTATISTICSSTATUS;
    public static final int ATTR_TRAFFICSOURCEINFORMATION;
    public static final int LISTCONTENT_TOPLEVELNODES;
    public static final int LISTCONTENT_LEAFNODES;
    public static final int LISTCONTENT_ALLNODES;
    public static final int LISTCONTENT_COMBINEDNODES;
    public static final int TMCSTATE_NOT_AVAILABLE;
    public static final int TMCSTATE_AVAILABLE_NOT_VALID;
    public static final int TMCSTATE_AVAILABLE_AND_VALID;
    public static final int TMCSTATE_NAR_AVAILABLE_AND_UNLOCKED;
    public static final int TMCSTATE_NAR_NOT_AVAILABLE_AND_UNLOCKED;
    public static final int TMCSTATE_NAR_LOCKED;
    public static final int TMCSTATE_TLT_NOT_AVAILABLE;
    public static final int TMCSTATE_DEACTIVATED;
    public static final int TMCMESSAGEROUTESTATE_MESSAGE_ON_ROUTE;
    public static final int TMCMESSAGEROUTESTATE_MESSAGE_NOT_ON_ROUTE;
    public static final int TMCMESSAGEROUTESTATE_MESSAGE_BYPASSED;
    public static final int TMCMESSAGEROUTESTATE_MESSAGE_BYPASSED_DISAPPEARS;
    public static final int TMCLISTELEMENTTYPE_UNDEFINED;
    public static final int TMCLISTELEMENTTYPE_NODE;
    public static final int TMCLISTELEMENTTYPE_MSG;
    public static final int TMCMESSAGEFILTER_ALL;
    public static final int TMCMESSAGEFILTER_ONROAD;
    public static final int TMCMESSAGEFILTER_URGENT;
    public static final int TRAFFICSOURCE_UNDEFINED;
    public static final int TRAFFICSOURCE_TMC;
    public static final int TRAFFICSOURCE_TMC_PRO;
    public static final int TRAFFICSOURCE_TPEG;
    public static final int TRAFFICSOURCE_ONLINE;
    public static final int TRAFFICSOURCE_CAR2X;
    public static final int TRAFFICSOURCE_VICS;
    public static final int TRAFFICSOURCESTATE_UNDEFINED;
    public static final int TRAFFICSOURCESTATE_NODATA;
    public static final int TRAFFICSOURCESTATE_ACTIVE;
    public static final int ROUTEDEVIATIONINDICATION_TI_NOEFFECT;
    public static final int ROUTEDEVIATIONINDICATION_TI_CAUSED_ROUTE_DEVIATION;
    public static final int ROUTEDEVIATIONINDICATION_VANISHED_TI_CAUSED_ROUTE_DEVIATION;
    public static final int AREAWARNINGTYPE_UNDEFINED;
    public static final int AREAWARNINGTYPE_FOG;
    public static final int AREAWARNINGTYPE_SLIPPERINESS;
    public static final int LOCALHAZARDWARNINGEVENTTYPE_NOEVENT;
    public static final int LOCALHAZARDWARNINGEVENTTYPE_ACCIDENT;
    public static final int LOCALHAZARDWARNINGEVENTTYPE_REDUCEDVISIBILITY;
    public static final int LOCALHAZARDWARNINGEVENTTYPE_BREAKDOWN;
    public static final int LOCALHAZARDWARNINGEVENTTYPE_TRACTIONLOSS;
    public static final int TMCEVENTTYPE_UNKNOWN;
    public static final int TMCEVENTTYPE_NATURALCATASTROPHE;
    public static final int TMCEVENTTYPE_OTHER;
    public static final int RT_SETMESSAGEFILTER;
    public static final int RT_REQUESTTMCWINDOW;
    public static final int RT_GETMESSAGEIDSFORLISTELEMENT;
    public static final int RT_GETBOUNDINGRECTANGLEFORTRAFFICMESSAGES;
    public static final int RT_ENABLEAREAWARNINGS;
    public static final int RT_ENABLETRAFFICFLOWSTATISTICS;
    public static final int RP_SETMESSAGEFILTERRESULT;
    public static final int RP_TMCWINDOWRESULT;
    public static final int RP_GETMESSAGEIDSFORLISTELEMENTRESULT;
    public static final int RP_GETBOUNDINGRECTANGLEFORTRAFFICMESSAGESRESULT;
    public static final int IN_WINDOWCHANGE;

    default public void requestTmcWindow(int n, int n2, int n3, int[] nArray, int n4) {
    }

    default public void setMessageFilter(int n, int n2) {
    }

    default public void getMessageIdsForListElement(long l) {
    }

    default public void getBoundingRectangleForTrafficMessages(long[] lArray) {
    }

    default public void enableAreaWarnings(boolean bl) {
    }

    default public void enableTrafficFlowStatistics(boolean bl) {
    }
}

