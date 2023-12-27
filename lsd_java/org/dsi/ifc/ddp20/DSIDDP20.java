/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.ddp20;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.ddp20.DisplayRequest;
import org.dsi.ifc.ddp20.UpdateRequest;

public interface DSIDDP20
extends DSIBase {
    public static final String VERSION;
    public static final int ATTR_VERSIONINFO;
    public static final int ATTR_POWERSTATUS;
    public static final int ATTR_DISPLAYSTATUS;
    public static final int ATTR_BUFFERSTATUS;
    public static final int CONTEXT_UNSPECIFIED;
    public static final int CONTEXT_PHONE;
    public static final int CONTEXT_MEDIA;
    public static final int CONTEXT_NAVI;
    public static final int POWERSTATE_UNDEFINED;
    public static final int POWERSTATE_OFF;
    public static final int POWERSTATE_STANDBY;
    public static final int POWERSTATE_ON;
    public static final int BUFFERSTATE_UNDEFINED;
    public static final int BUFFERSTATE_OKAY;
    public static final int BUFFERSTATE_CRITICAL;
    public static final int MANUFACTURER_UNDEFINED;
    public static final int MANUFACTURER_BOSCH;
    public static final int MANUFACTURER_BOSCH_OEM;
    public static final int MANUFACTURER_HARMAN_BECKER;
    public static final int MANUFACTURER_VDO;
    public static final int MANUFACTURER_MOTO;
    public static final int MANUFACTURER_NOKIA;
    public static final int MANUFACTURER_MMARELLI;
    public static final int BRAND_UNDEFINED;
    public static final int BRAND_VW;
    public static final int BRAND_AU;
    public static final int BRAND_SE;
    public static final int BRAND_SK;
    public static final int BRAND_VWN;
    public static final int BRAND_BG;
    public static final int BRAND_LB;
    public static final int BRAND_BE;
    public static final int BRAND_RR;
    public static final int BRAND_PS;
    public static final int BRAND_FD;
    public static final int CLASS_UNDEFINED;
    public static final int CLASS_A000;
    public static final int CLASS_A00;
    public static final int CLASS_A0;
    public static final int CLASS_A;
    public static final int CLASS_B;
    public static final int CLASS_C;
    public static final int CLASS_D;
    public static final int CLASS_EM;
    public static final int CLASS_EP;
    public static final int GENERATION_UNDEFINED;
    public static final int GENERATION_0;
    public static final int GENERATION_1;
    public static final int GENERATION_2;
    public static final int GENERATION_3;
    public static final int GENERATION_5;
    public static final int GENERATION_6;
    public static final int GENERATION_7;
    public static final int GENERATION_8;
    public static final int GENERATION_9;
    public static final int GENERATION_10;
    public static final int DERIVATE_0;
    public static final int DERIVATE_1;
    public static final int DERIVATE_2;
    public static final int DERIVATE_3;
    public static final int DERIVATE_4;
    public static final int DERIVATE_5;
    public static final int DERIVATE_6;
    public static final int DERIVATE_7;
    public static final int DERIVATE_8;
    public static final int DERIVATE_9;
    public static final int INFO_NONE;
    public static final int INFO_SERIES;
    public static final int INFO_PA;
    public static final int INFO_GPA;
    public static final int DISPLAY_MONO1;
    public static final int DISPLAY_MONO2;
    public static final int DISPLAY_MONO3;
    public static final int DISPLAY_MONO4;
    public static final int DISPLAY_MONO5;
    public static final int DISPLAY_MONO6;
    public static final int DISPLAY_COLOR1;
    public static final int DISPLAY_COLOR2;
    public static final int DISPLAY_COLOR3;
    public static final int MMISTATE_INVALID;
    public static final int MMISTATE_STANDBY;
    public static final int MMISTATE_ON;
    public static final int DISPLAYSTATE_INVALID;
    public static final int DISPLAYSTATE_OFF;
    public static final int DISPLAYSTATE_ON;
    public static final int AUDIOSTATE_INVALID;
    public static final int AUDIOSTATE_OFF;
    public static final int AUDIOSTATE_ON;
    public static final int NAVISTATE_INVALID;
    public static final int NAVISTATE_NOT_INSTALLED;
    public static final int NAVISTATE_INIT;
    public static final int NAVISTATE_READY;
    public static final int RGUIDESTATE_INVALID;
    public static final int RGUIDESTATE_NOT_ACTIVE;
    public static final int RGUIDESTATE_CALCULATION;
    public static final int RGUIDESTATE_NEW_CALCULATION;
    public static final int RGUIDESTATE_OFFMAP;
    public static final int RGUIDESTATE_OFFROAD;
    public static final int RGUIDESTATE_ACTIVE;
    public static final int MEDIASTATE_INVALID;
    public static final int MEDIASTATE_NOT_INSTALLED;
    public static final int MEDIASTATE_INIT;
    public static final int MEDIASTATE_READY;
    public static final int PHONESTATE_INVALID;
    public static final int PHONESTATE_NOT_INSTALLED;
    public static final int PHONESTATE_INIT;
    public static final int PHONESTATE_READY;
    public static final int CALLSTATE_INVALID;
    public static final int CALLSTATE_NO_CALL;
    public static final int CALLSTATE_BUILD_CONNECTION;
    public static final int CALLSTATE_INCOMING_CALL;
    public static final int CALLSTATE_ACTIVE_CALL;
    public static final int CALLTYPE_NO_CALL;
    public static final int CALLTYPE_NORMAL_CALL;
    public static final int CALLTYPE_CONFERENCE_CALL;
    public static final int CALLTYPE_EMERGENCY_CALL;
    public static final int FRAME_INVALID;
    public static final int FRAME_STATUSLINE;
    public static final int FRAME_LIST;
    public static final int FRAME_RGI;
    public static final int FRAME_TAB;
    public static final int FRAME_RGI_EXT;
    public static final int FRAME_CROSSING_ZOOM;
    public static final int FRAME_COMPASS;
    public static final int FRAME_LANE_GUIDANCE;
    public static final int FRAME_NAVI_LIST;
    public static final int FRAME_NAVI_SUBMENU;
    public static final int FRAME_MEDIA_LIST;
    public static final int FRAME_MEDIA_SUBMENU;
    public static final int FRAME_PHONE_LIST;
    public static final int FRAME_PHONE_SUBMENU;
    public static final int FRAME_PHONE_POPUP;
    public static final int FRAME_TRAFFIC_SIGN;
    public static final int FRAME_MEDIA_FASTSCROLL_POPUP;
    public static final int FRAME_PHONE_FASTSCROLL_POPUP;
    public static final int FRAME_NAVI_FASTSCROLL_POPUP;
    public static final int FRAME_MMI_INFO;
    public static final int RT_GETDISPLAYSTATUS;
    public static final int RT_SETHMISTATE;
    public static final int RT_SETNAVISTATE;
    public static final int RT_SETMEDIASTATE;
    public static final int RT_SETPHONESTATE;
    public static final int RT_SETFRAMESTATUS;
    public static final int RT_SETFRAMEUPDATE;
    public static final int RT_SETMANEUVER;
    public static final int RT_SETCOMPASS;
    public static final int RT_SETDISTANCEBAR;
    public static final int RT_SETDEVIATIONBAR;
    public static final int RT_SETTEXT;
    public static final int RT_SETTEXTSTYLE;
    public static final int RT_SETCOLOR;
    public static final int RT_SETCURSOR;
    public static final int RT_SETTRAFFICSIGN;
    public static final int RT_SETLANEGUIDANCEHEADER;
    public static final int RT_SETLANEGUIDANCEDATA;
    public static final int RT_SETCODEPAGE;

    default public void getDisplayStatus() {
    }

    default public void setHMIState(int n, int n2, int n3) {
    }

    default public void setNaviState(int n, int n2) {
    }

    default public void setMediaState(int n) {
    }

    default public void setPhoneState(int n, int n2, int n3) {
    }

    default public void setFrameStatus(DisplayRequest displayRequest) {
    }

    default public void setFrameUpdate(UpdateRequest updateRequest) {
    }

    default public void setManeuver(int n, short[] sArray, boolean bl) {
    }

    default public void setCompass(int n, short[] sArray, boolean bl) {
    }

    default public void setDistanceBar(int n, int n2, boolean bl, boolean bl2) {
    }

    default public void setDeviationBar(int n, int n2, boolean bl, boolean bl2) {
    }

    default public void setText(int n, int n2, String string, int n3, boolean bl) {
    }

    default public void setTextStyle(int n, int n2, int n3, int n4, boolean bl) {
    }

    default public void setColor(int n, int n2, int[] nArray, boolean bl) {
    }

    default public void setCursor(int n, int n2, int n3, int n4, int n5, boolean bl) {
    }

    default public void setTrafficSign(int n, int n2, int n3, int n4, boolean bl) {
    }

    default public void setLaneGuidanceHeader(int n, int n2, int n3, int n4, int n5, boolean bl) {
    }

    default public void setLaneGuidanceData(int n, int n2, int n3, int n4, short[] sArray, boolean bl) {
    }

    default public void setCodePage(int n) {
    }
}

