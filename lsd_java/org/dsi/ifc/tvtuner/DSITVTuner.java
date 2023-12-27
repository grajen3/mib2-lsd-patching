/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.tvtuner;

import org.dsi.ifc.base.DSIBase;

public interface DSITVTuner
extends DSIBase {
    public static final String VERSION;
    public static final int ATTR_TUNERSTATE;
    public static final int ATTR_SELECTEDSOURCE;
    public static final int ATTR_SERVICELIST;
    public static final int ATTR_SELECTEDSERVICE;
    public static final int ATTR_MUTESTATE;
    public static final int ATTR_INFOTEXTSTATE;
    public static final int ATTR_AUDIOCHANNEL;
    public static final int ATTR_SERVICELINKING;
    public static final int ATTR_SUBTITLE;
    public static final int ATTR_AVNORM;
    public static final int ATTR_TVNORMAREA;
    public static final int ATTR_TVNORMLIST;
    public static final int ATTR_TVNORMAREASUBLIST;
    public static final int ATTR_TERMINALMODE;
    public static final int ATTR_EWSINFOLIST;
    public static final int ATTR_STARTUPMUCONFIG;
    public static final int ATTR_MESSAGESERVICE;
    public static final int ATTR_TUNESTATUS;
    public static final int ATTR_CASINFO;
    public static final int ATTR_TMTVKEYPANEL;
    public static final int ATTR_LOGOLIST;
    public static final int ATTR_BROWSERLISTSORT;
    public static final int TUNERSTATE_INACTIVE;
    public static final int TUNERSTATE_ACTIVE;
    public static final int RESPONSERESULT_FAILURE;
    public static final int RESPONSERESULT_SUCCESS;
    public static final int SOURCETYPE_TV;
    public static final int SOURCETYPE_AV;
    public static final int SEEKDIRECTION_UP;
    public static final int SEEKDIRECTION_DOWN;
    public static final int SEEKMODE_CHANNEL;
    public static final int SEEKMODE_AUTO;
    public static final int STYPE_UNKNOWN;
    public static final int STYPE_DTV;
    public static final int STYPE_DTV_HDTV;
    public static final int STYPE_AUDIO;
    public static final int STYPE_DATA;
    public static final int STYPE_CAS_PAYTV;
    public static final int STYPE_VISUAL_AUDIO;
    public static final int STYPE_ISDB_SUBSERVICE_1;
    public static final int STYPE_ISDB_SUBSERVICE_2;
    public static final int STYPE_CMMB;
    public static final int STYPE_CMMB_AUDIO;
    public static final int STYPE_DTV_SUBSERVICE_2;
    public static final int STYPE_DTV_SUBSERVICE_3;
    public static final int STYPE_DTV_SUBSERVICE_4;
    public static final int STYPE_DTV_SUBSERVICE_5;
    public static final int STYPE_DUMMY;
    public static final int MUTESTATE_AUDIO_GOOD;
    public static final int MUTESTATE_DROP_OUT;
    public static final int MUTESTATE_NO_RECEPTION;
    public static final int MUTESTATE_NO_AUDIO_SERVICE;
    public static final int SERVICEFLAG_NOT_AVAILABLE;
    public static final int SERVICEFLAG_LOADING;
    public static final int SERVICEFLAG_FULL_AVAILABLE;
    public static final int AVNORM_AUTO;
    public static final int AVNORM_PAL;
    public static final int AVNORM_NTSC;
    public static final int TERMINALMODE_OFF_TV_AV_MODE;
    public static final int TERMINALMODE_TELETEXT;
    public static final int TERMINALMODE_DB_DVB;
    public static final int TERMINALMODE_DB_ISDB;
    public static final int TERMINALMODE_DB_DTMB_CMMB;
    public static final int TERMINALMODE_DB_DMB;
    public static final int TERMINALMODE_DB_ATSC;
    public static final int TERMINALMODE_DB1;
    public static final int TERMINALMODE_DB2;
    public static final int TERMINALMODE_BWS;
    public static final int TERMINALMODE_SLS_DLS;
    public static final int TERMINALMODE_TXT;
    public static final int TERMINALMODE_CAS;
    public static final int TERMINALMODE_EPG;
    public static final int TERMINALMODE_VISUAL_AUDIO;
    public static final int TERMINALMODE_TV_ENGINEERING;
    public static final int SCREENMODE_MU_SPEED_DISCLAIMER_OFF;
    public static final int SCREENMODE_MU_SPEED_DISCLAIMER_ON;
    public static final int TMTOUCHPADBEHAVIOUR_NO_COORD;
    public static final int TMTOUCHPADBEHAVIOUR_COORD;
    public static final int TMTOUCHPADBEHAVIOUR_MAP_TO_JOYSTICK;
    public static final int RT_SWITCHSOURCE;
    public static final int RT_SELECTNEXTSERVICE;
    public static final int RT_SELECTSERVICE;
    public static final int RT_SETAUDIOCHANNEL;
    public static final int RT_ENABLESERVICELINKING;
    public static final int RT_ENABLESUBTITLE;
    public static final int RT_SETAVNORM;
    public static final int RT_SETNORMAREA;
    public static final int RT_SETNORMAREASUBLIST;
    public static final int RT_SETTERMINALMODE;
    public static final int RT_INCMOVED;
    public static final int RT_SETCOORDINATEREL;
    public static final int RT_SETTMTVKEYPANEL;
    public static final int RT_ABORTSEEK;
    public static final int RT_SETBROWSERLISTSORT;
    public static final int RP_SWITCHSOURCE;
    public static final int RP_SELECTNEXTSERVICE;
    public static final int RP_SELECTSERVICE;
    public static final int RP_ABORTSEEK;

    default public void selectService(long l, int n, int n2) {
    }

    default public void selectNextService(int n, int n2) {
    }

    default public void abortSeek() {
    }

    default public void switchSource(int n) {
    }

    default public void setAudioChannel(int n) {
    }

    default public void setNormArea(int n) {
    }

    default public void enableServiceLinking(boolean bl) {
    }

    default public void setTerminalMode(int n, int n2) {
    }

    default public void setNormAreaSubList(int[] nArray) {
    }

    default public void setAVNorm(int n) {
    }

    default public void incMoved(byte by) {
    }

    default public void setCoordinateRel(short s, short s2, short s3) {
    }

    default public void setTMTVKeyPanel(short s, short s2) {
    }

    default public void enableSubtitle(boolean bl) {
    }

    default public void setBrowserListSort(int n) {
    }
}

