/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.radio;

import org.dsi.ifc.base.DSIBase;

public interface DSIAMFMTuner
extends DSIBase {
    public static final String VERSION;
    public static final int ATTR_SELECTEDSTATION;
    public static final int ATTR_STATIONLIST;
    public static final int ATTR_STATIONLISTMW;
    public static final int ATTR_STATIONLISTLW;
    public static final int ATTR_WAVEBANDINFOLIST;
    public static final int ATTR_RADIOTEXT;
    public static final int ATTR_AFSWITCHSTATUS;
    public static final int ATTR_REGSWITCHSTATUS;
    public static final int ATTR_LINKINGUSAGESTATUS;
    public static final int ATTR_DETECTEDDEVICE;
    public static final int ATTR_RADIOTEXTPLUS;
    public static final int ATTR_PIIGNORESWITCHSTATUS;
    public static final int ATTR_RDSIGNORESWITCHSTATUS;
    public static final int ATTR_MESWITCHSTATUS;
    public static final int ATTR_HDSTATUS;
    public static final int ATTR_HDMODE;
    public static final int ATTR_HDSTATIONINFO;
    public static final int ATTR_AVAILABILITY;
    public static final int ATTR_ELECTRONICSERIALCODE;
    public static final int ATTR_SELECTEDSTATIONHD;
    public static final int ATTR_PROFILESTATE;
    public static final int WAVEBAND_UNDEFINED;
    public static final int WAVEBAND_FM;
    public static final int WAVEBAND_SW;
    public static final int WAVEBAND_MW;
    public static final int WAVEBAND_LW;
    public static final int SEEKSTATIONMODE_UNDEFINED;
    public static final int SEEKSTATIONMODE_UP;
    public static final int SEEKSTATIONMODE_DOWN;
    public static final int SEEKSTATIONMODE_ABORT;
    public static final int SEEKSTATIONMODE_STOP;
    public static final int SEEKSTATIONMODE_UP_NO_STOP;
    public static final int SEEKSTATIONMODE_DOWN_NO_STOP;
    public static final int DEVICESTATUS_UNDEFINED;
    public static final int DEVICESTATUS_NOT_READY;
    public static final int DEVICESTATUS_READY;
    public static final int REGSTATUS_UNDEFINED;
    public static final int REGSTATUS_ON;
    public static final int REGSTATUS_OFF;
    public static final int REGSTATUS_AUTO;
    public static final int TUNEFREQUENCYSTEPSSTATUS_UNDEFINED;
    public static final int TUNEFREQUENCYSTEPSSTATUS_RUNNING;
    public static final int TUNEFREQUENCYSTEPSSTATUS_DONE;
    public static final int TUNEFREQUENCYSTEPSSTATUS_ABORTED;
    public static final int TUNEFREQUENCYSTEPSSTATUS_FAILURE;
    public static final int SELECTSTATIONSTATUS_UNDEFINED;
    public static final int SELECTSTATIONSTATUS_RUNNING;
    public static final int SELECTSTATIONSTATUS_DONE;
    public static final int SELECTSTATIONSTATUS_ABORTED;
    public static final int SELECTSTATIONSTATUS_FAILURE;
    public static final int PREPARETUNINGSTATUS_UNDEFINED;
    public static final int PREPARETUNINGSTATUS_RUNNING;
    public static final int PREPARETUNINGSTATUS_DONE;
    public static final int PREPARETUNINGSTATUS_ABORTED;
    public static final int PREPARETUNINGSTATUS_FAILURE;
    public static final int SEEKSTATIONSTATUS_UNDEFINED;
    public static final int SEEKSTATIONSTATUS_RUNNING;
    public static final int SEEKSTATIONSTATUS_DONE;
    public static final int SEEKSTATIONSTATUS_ABORTED;
    public static final int SEEKSTATIONSTATUS_STOPPED;
    public static final int SEEKSTATIONSTATUS_FAILURE;
    public static final int LINKINGDEVICEUSAGE_UNDEFINED;
    public static final int LINKINGDEVICEUSAGE_DEVICE_AVAILABLE;
    public static final int LINKINGDEVICEUSAGE_DEVICE_USED;
    public static final int LINKINGUSEDTYPE_UNDEFINED;
    public static final int LINKINGUSEDTYPE_FOLLOWING_MASTER;
    public static final int LINKINGUSEDTYPE_EXTERNAL_REQUEST;
    public static final int LINKINGUSEDTYPE_PTY31;
    public static final int LINKINGUSEDTYPE_TA;
    public static final int LINKINGUSEDTYPE_OTHER_ANNOUNCEMENT;
    public static final int LINKINGUSEDTYPE_TIM;
    public static final int DEVICETYPE_UNDEFINED;
    public static final int DEVICETYPE_NONE;
    public static final int DEVICETYPE_UNKNOWN;
    public static final int DEVICETYPE_RU;
    public static final int DEVICETYPE_RU_HD;
    public static final int RESETTYPE_UNDEFINED;
    public static final int RESETTYPE_TO_DEFAULT;
    public static final int RESETTYPE_ANONYMIZE;
    public static final int SELECTFREQUENCYSTATUS_UNDEFINED;
    public static final int SELECTFREQUENCYSTATUS_RUNNING;
    public static final int SELECTFREQUENCYSTATUS_DONE;
    public static final int SELECTFREQUENCYSTATUS_ABORTED;
    public static final int SELECTFREQUENCYSTATUS_FAILURE;
    public static final int SETAMBANDRANGESTATUS_UNDEFINED;
    public static final int SETAMBANDRANGESTATUS_RUNNING;
    public static final int SETAMBANDRANGESTATUS_DONE;
    public static final int SETAMBANDRANGESTATUS_ABORTED;
    public static final int SETAMBANDRANGESTATUS_FAILURE;
    public static final int AMBANDRANGE_UNDEFINED;
    public static final int AMBANDRANGE_EU;
    public static final int AMBANDRANGE_NAR;
    public static final int AMBANDRANGE_JP;
    public static final int AMBANDRANGE_EU_GER;
    public static final int AMBANDRANGE_AUS;
    public static final int UPDATEMODE_UNDEFINED;
    public static final int UPDATEMODE_START;
    public static final int UPDATEMODE_ABORT;
    public static final int FORCEUPDATESTATUS_UNDEFINED;
    public static final int FORCEUPDATESTATUS_RUNNING;
    public static final int FORCEUPDATESTATUS_DONE;
    public static final int FORCEUPDATESTATUS_ABORTED;
    public static final int FORCEUPDATESTATUS_FAILURE;
    public static final int SERVICE_NONE;
    public static final int SERVICE_MPS;
    public static final int SERVICE_SPS2;
    public static final int SERVICE_SPS3;
    public static final int SERVICE_SPS4;
    public static final int SERVICE_SPS5;
    public static final int SERVICE_SPS6;
    public static final int SERVICE_SPS7;
    public static final int SERVICE_SPS8;
    public static final int HDSTATUS_UNKNOWN;
    public static final int HDSTATUS_ANALOG;
    public static final int HDSTATUS_DIGITAL;
    public static final int HDSTATUS_MUTE;
    public static final int HDSTATUS_BGM;
    public static final int HDMODE_UNDEF;
    public static final int HDMODE_AUTOMATIC;
    public static final int HDMODE_ANALOG;
    public static final int HDMODE_DIGITAL;
    public static final int HDMODE_BGM_OVERRIDE;
    public static final int HDMODE_AM_OFF_FM_ON;
    public static final int HDMODE_AM_ON_FM_OFF;
    public static final int SUBSCRIPTION_UNDEFINED;
    public static final int SUBSCRIPTION_UNSUBSCRIBED;
    public static final int SUBSCRIPTION_SUBSCRIBED;
    public static final int SUBSCRIPTION_FREE;
    public static final int RT_TUNEFREQUENCYSTEPS;
    public static final int RT_SELECTSTATION;
    public static final int RT_SEEKSTATION;
    public static final int RT_SWITCHAF;
    public static final int RT_SWITCHREG;
    public static final int RT_SWITCHLINKINGDEVICEUSAGE;
    public static final int RT_RESET;
    public static final int RT_SETAMBANDRANGE;
    public static final int RT_PREPARETUNING;
    public static final int RT_SELECTFREQUENCY;
    public static final int RT_ISONPRESET;
    public static final int RT_FORCEFMUPDATE;
    public static final int RT_SWITCHPIIGNORE;
    public static final int RT_FREEPRESET;
    public static final int RT_FORCEAMUPDATE;
    public static final int RT_SWITCHRDSIGNORE;
    public static final int RT_SWITCHME;
    public static final int RT_ENABLERADIOTEXTPLUS;
    public static final int RT_SETMODEHD;
    public static final int RT_SETERTPREFERED;
    public static final int RT_SETERTDISPLAYABLE;
    public static final int RT_PROFILECHANGE;
    public static final int RT_PROFILECOPY;
    public static final int RT_PROFILERESET;
    public static final int RT_PROFILERESETALL;
    public static final int RP_TUNEFREQUENCYSTEPSSTATUS;
    public static final int RP_SELECTSTATIONSTATUS;
    public static final int RP_SEEKSTATIONSTATUS;
    public static final int RP_PREPARETUNINGSTATUS;
    public static final int RP_SELECTFREQUENCYSTATUS;
    public static final int RP_SETAMBANDRANGESTATUS;
    public static final int RP_FORCEFMUPDATESTATUS;
    public static final int RP_FORCEAMUPDATESTATUS;
    public static final int RP_PROFILECHANGED;
    public static final int RP_PROFILECOPIED;
    public static final int RP_PROFILERESET;
    public static final int RP_PROFILERESETALL;

    default public void tuneFrequencySteps(int n) {
    }

    default public void selectStation(int n, int n2, int n3) {
    }

    default public void prepareTuning(int n, int n2, int n3) {
    }

    default public void seekStation(int n) {
    }

    default public void switchAF(boolean bl) {
    }

    default public void switchME(boolean bl) {
    }

    default public void switchREG(int n) {
    }

    default public void switchLinkingDeviceUsage(int n) {
    }

    default public void reset(int n) {
    }

    default public void selectFrequency(int n) {
    }

    default public void setAMBandRange(int n) {
    }

    default public void isOnPreset(int n, int n2, int n3, String string) {
    }

    default public void forceFMUpdate(int n) {
    }

    default public void switchPiIgnore(boolean bl) {
    }

    default public void freePreset(int n) {
    }

    default public void forceAMUpdate(int n) {
    }

    default public void switchRDSIgnore(boolean bl) {
    }

    default public void enableRadiotextPlus(int[] nArray) {
    }

    default public void setModeHD(int n) {
    }

    default public void setERTPrefered(boolean bl) {
    }

    default public void setERTDisplayable(boolean bl) {
    }

    default public void profileChange(int n) {
    }

    default public void profileCopy(int n, int n2) {
    }

    default public void profileReset(int n) {
    }

    default public void profileResetAll() {
    }
}

