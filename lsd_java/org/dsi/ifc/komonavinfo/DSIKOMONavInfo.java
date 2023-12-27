/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.komonavinfo;

import org.dsi.ifc.base.DSIBase;

public interface DSIKOMONavInfo
extends DSIBase {
    public static final String VERSION;
    public static final int RP_SETCURRENTSTREETRESULT;
    public static final int RP_SETTURNTOSTREETRESULT;
    public static final int RP_SETCITYNAMERESULT;
    public static final int RP_SETSEMIDYNROUTERESULT;
    public static final int RP_SETTRAFFICOFFSETRESULT;
    public static final int RP_SETRGSELECTRESULT;
    public static final int RP_SETCAPABILITIESRESULT;
    public static final int RP_SETMAPSCALERESULT;
    public static final int RT_SETDISTANCETONEXTMANEUVER;
    public static final int RT_SETETA;
    public static final int RT_SETCURRENTSTREET;
    public static final int RT_SETTURNTOSTREET;
    public static final int RT_SETCITYNAME;
    public static final int RT_SETDISTANCETODESTINATION;
    public static final int RT_SETSEMIDYNROUTE;
    public static final int RT_SETTRAFFICOFFSET;
    public static final int RT_SETRTT;
    public static final int RT_SETRGSELECT;
    public static final int RT_SETCAPABILITIES;
    public static final int RT_SETMAPSCALE;
    public static final int RT_SETMAPSCALERESULT;
    public static final int IN_SETMAPSCALE;
    public static final int DISTANCEUNIT_MILES;
    public static final int DISTANCEUNIT_METERS;
    public static final int DISTANCEUNIT_KILOMETERS;
    public static final int DISTANCEUNIT_YARDS;
    public static final int DISTANCEUNIT_FEEDS;
    public static final int DISTANCEUNIT_QUARTERMILE;
    public static final int TIMEFORMAT_24HFORMAT;
    public static final int TIMEFORMAT_12HFORMAT;
    public static final int RGMODE_RGI;
    public static final int RGMODE_KDK;
    public static final int RGMODE_COMPASS;
    public static final int RGMODE_MAP;
    public static final int NAVINFORESULTCODE_OK;
    public static final int NAVINFORESULTCODE_ERROR;
    public static final int NAVINFORESULTCODE_UNSUPPORTED;
    public static final int AUTOZOOM_OFF;
    public static final int AUTOZOOM_ON;
    public static final int AUTOZOOM_ONINTERSECTION;
    public static final int AUTOZOOM_NOTSUPPORTED;
    public static final int SCALE_INVALID;
    public static final int SCALE_MINIMUM;
    public static final int SCALE_MAXIMUM;
    public static final int SCALE_INNIT_UNKNOWN;
    public static final int MAPSCALEUNIT_METER;
    public static final int MAPSCALEUNIT_KILOMETER;
    public static final int MAPSCALEUNIT_YARD;
    public static final int MAPSCALEUNIT_FEET;
    public static final int MAPSCALEUNIT_MILE_UK_US;
    public static final int MAPSCALEUNIT_QUARTERMILE;
    public static final int MAPSCALEUNIT_KILOMETER_HUNDREDTHSTEPS;
    public static final int MAPSCALEUNIT_MILE_HUNDREDTHSTEPS;
    public static final int MAPSCALEUNIT_NOTSUPPORTED_NOINFO;

    default public void setDistanceToNextManeuver(long l, int n, boolean bl) {
    }

    default public void setETA(int n, short s, short s2, short s3, boolean bl, boolean bl2) {
    }

    default public void setCurrentStreet(String string) {
    }

    default public void setTurnToStreet(String string, String string2) {
    }

    default public void setCityName(String string) {
    }

    default public void setDistanceToDestination(long l, int n, boolean bl) {
    }

    default public void setSemiDynRoute(boolean bl) {
    }

    default public void setTrafficOffset(int n, short s, short s2, short s3, boolean bl) {
    }

    default public void setRTT(short s, short s2, boolean bl) {
    }

    default public void setRgSelect(int n) {
    }

    default public void setCapabilities(boolean[] blArray) {
    }

    default public void setMapScale(int n, int n2, boolean[] blArray, int n3, int n4, int n5) {
    }

    default public void setMapScaleResult(int n, int n2, boolean[] blArray, int n3, int n4, boolean[] blArray2, boolean bl) {
    }
}

