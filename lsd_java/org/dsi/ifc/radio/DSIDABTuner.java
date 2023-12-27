/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.radio;

import org.dsi.ifc.base.DSIBase;

public interface DSIDABTuner
extends DSIBase {
    public static final String VERSION;
    public static final int ATTR_SELECTEDENSEMBLE;
    public static final int ATTR_SELECTEDSERVICE;
    public static final int ATTR_SELECTEDCOMPONENT;
    public static final int ATTR_SELECTEDFREQUENCY;
    public static final int ATTR_ENSEMBLELIST;
    public static final int ATTR_SERVICELIST;
    public static final int ATTR_COMPONENTLIST;
    public static final int ATTR_DATASERVICELIST;
    public static final int ATTR_FREQUENCYLIST;
    public static final int ATTR_RADIOTEXT;
    public static final int ATTR_SYNCSTATUS;
    public static final int ATTR_QUALITY;
    public static final int ATTR_DRCSWITCHSTATUS;
    public static final int ATTR_LINKINGSWITCHSTATUS;
    public static final int ATTR_FREQUENCYTABLESWITCHSTATUS;
    public static final int ATTR_LINKINGSTATUS;
    public static final int ATTR_LINKINGUSAGESTATUS;
    public static final int ATTR_AUDIOSTATUS;
    public static final int ATTR_DETECTEDDEVICE;
    public static final int ATTR_QUALITYINFO;
    public static final int ATTR_DECODEDDATASERVICE;
    public static final int ATTR_EPGLOGO;
    public static final int ATTR_AVAILABILITY;
    public static final int ATTR_INTELLITEXT;
    public static final int ATTR_EPGLISTDATA;
    public static final int ATTR_EPGDETAILDATA;
    public static final int ATTR_EPGMODE;
    public static final int ATTR_SLIDESHOWINFO;
    public static final int ATTR_RADIOTEXTPLUSINFO;
    public static final int ATTR_EPGLOGOLIST;
    public static final int ATTR_PROFILESTATE;
    public static final int SELECTSERVICEMODE_UNDEFINED;
    public static final int SELECTSERVICEMODE_SID;
    public static final int SELECTSERVICEMODE_SID_AND_ENSID;
    public static final int SELECTSERVICEMODE_SCIDI;
    public static final int SELECTSERVICEMODE_INDEX;
    public static final int SELECTSERVICEMODE_ABORT;
    public static final int SELECTSERVICEMODE_SID_AND_FREQUENCY;
    public static final int SEEKSERVICEMODE_UNDEFINED;
    public static final int SEEKSERVICEMODE_AUTO_UP;
    public static final int SEEKSERVICEMODE_AUTO_DOWN;
    public static final int SEEKSERVICEMODE_SCAN_UP;
    public static final int SEEKSERVICEMODE_ABORT;
    public static final int SEEKSERVICEMODE_SCAN_UP_5_SECONDS;
    public static final int SEEKSERVICEMODE_ENSEMBLE_UP;
    public static final int SEEKSERVICEMODE_ENSEMBLE_DOWN;
    public static final int SEEKSERVICEMODE_ENSEMBLE_JUMP_LM_UP_NO_SERVICE_SELECT;
    public static final int SEEKSERVICEMODE_ENSEMBLE_JUMP_LM_DOWN_NO_SERVICE_SELECT;
    public static final int SEEKSERVICEMODE_ENSEMBLE_UP_NO_SERVICE_SELECT;
    public static final int SEEKSERVICEMODE_ENSEMBLE_DOWN_NO_SERVICE_SELECT;
    public static final int TUNEENSEMBLEMODE_UNDEFINED;
    public static final int TUNEENSEMBLEMODE_ENSID;
    public static final int TUNEENSEMBLEMODE_FREQUENCY;
    public static final int TUNEENSEMBLEMODE_ABORT;
    public static final int EPGMODE_UNDEFINED;
    public static final int EPGMODE_OFF;
    public static final int EPGMODE_LOGO;
    public static final int EPGMODE_TEXT;
    public static final int EPGMODE_FULL;
    public static final int SLIDESHOWMODE_OFF;
    public static final int SLIDESHOWMODE_ON;
    public static final int INTELLITEXTMODE_OFF;
    public static final int INTELLITEXTMODE_ON;
    public static final int SELECTSERVICESTATUS_UNDEFINED;
    public static final int SELECTSERVICESTATUS_RUNNING;
    public static final int SELECTSERVICESTATUS_ABORTED;
    public static final int SELECTSERVICESTATUS_DONE;
    public static final int SELECTSERVICESTATUS_SERVICE_INVALID;
    public static final int SELECTSERVICESTATUS_NO_SERVICE;
    public static final int SELECTSERVICESTATUS_NO_ENSEMBLE_TUNED;
    public static final int SELECTSERVICESTATUS_INDEX_INVALID;
    public static final int SEEKSERVICESTATUS_UNDEFINED;
    public static final int SEEKSERVICESTATUS_RUNNING;
    public static final int SEEKSERVICESTATUS_ABORTED;
    public static final int SEEKSERVICESTATUS_FINISHED;
    public static final int SEEKSERVICESTATUS_FAILURE;
    public static final int TUNEENSEMBLESTATUS_UNDEFINED;
    public static final int TUNEENSEMBLESTATUS_RUNNING;
    public static final int TUNEENSEMBLESTATUS_ABORTED;
    public static final int TUNEENSEMBLESTATUS_FINISHED;
    public static final int TUNEENSEMBLESTATUS_WRONG_FREQUENCY;
    public static final int TUNEENSEMBLESTATUS_WRONG_FREQUENCYLABEL;
    public static final int TUNEENSEMBLESTATUS_FAILURE;
    public static final int SELECTDATASERVICESTATUS_UNDEFINED;
    public static final int SELECTDATASERVICESTATUS_RUNNING;
    public static final int SELECTDATASERVICESTATUS_ABORTED;
    public static final int SELECTDATASERVICESTATUS_DONE;
    public static final int SELECTDATASERVICESTATUS_SERVICE_INVALID;
    public static final int SELECTDATASERVICESTATUS_NO_SERVICE;
    public static final int SYNCSTATUS_UNDEFINED;
    public static final int SYNCSTATUS_SYNC_LOST;
    public static final int SYNCSTATUS_MUTE_ENSEMBLE;
    public static final int SYNCSTATUS_MUTE_SERVICE;
    public static final int SYNCSTATUS_MUTE_OFF;
    public static final int FREQUENCYTABLE_UNDEFINED;
    public static final int FREQUENCYTABLE_AUTO;
    public static final int FREQUENCYTABLE_EUROPE;
    public static final int FREQUENCYTABLE_EUROPE_LBAND;
    public static final int FREQUENCYTABLE_EUROPE_VHFBAND;
    public static final int FREQUENCYTABLE_CANADA;
    public static final int FREQUENCYTABLE_KOREA;
    public static final int FREQUENCYTABLE_NEWZEALAND;
    public static final int FREQUENCYTABLE_AUTO_LBAND_OFF;
    public static final int LINKINGSTATUS_UNDEFINED;
    public static final int LINKINGSTATUS_OFF;
    public static final int LINKINGSTATUS_RDS;
    public static final int LINKINGSTATUS_DRM;
    public static final int LINKINGMODE_UNDEFINED;
    public static final int LINKINGMODE_OFF;
    public static final int LINKINGMODE_DAB_ONLY;
    public static final int LINKINGMODE_ON;
    public static final int LINKINGMODE_FM;
    public static final int LINKINGMODE_DAB;
    public static final int LINKINGMODE_DAB_ONLY_SOFT;
    public static final int LINKINGMODE_ON_SOFT;
    public static final int LINKINGMODE_FM_SOFT;
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
    public static final int DRCSTATUS_UNDEFINED;
    public static final int DRCSTATUS_NOT_AVAILABLE;
    public static final int DRCSTATUS_AVAILABLE;
    public static final int MUSICSPEECH_UNDEFINED;
    public static final int MUSICSPEECH_MUSIC;
    public static final int MUSICSPEECH_SPEECH;
    public static final int AUDIOMODE_UNDEFINED;
    public static final int AUDIOMODE_STEREO;
    public static final int AUDIOMODE_JOINED_STEREO;
    public static final int AUDIOMODE_DUAL_CHANNEL;
    public static final int AUDIOMODE_MONO;
    public static final int AUDIOMODE_TOGGLING_STEREO;
    public static final int DECODINGALGORITHM_UNDEFINED;
    public static final int DECODINGALGORITHM_MPEG1;
    public static final int DECODINGALGORITHM_MPEG2;
    public static final int ORIGINALSTATUS_UNDEFINED;
    public static final int ORIGINALSTATUS_FLAG_NOT_SET;
    public static final int ORIGINALSTATUS_FLAG_SET;
    public static final int COPYRIGHTSTATUS_UNDEFINED;
    public static final int COPYRIGHTSTATUS_FLAG_NOT_SET;
    public static final int COPYRIGHTSTATUS_FLAG_SET;
    public static final int SAMPLINGRATE_UNDEFINED;
    public static final int SAMPLINGRATE_24KHZ;
    public static final int SAMPLINGRATE_48KHZ;
    public static final int DEVICETYPE_UNDEFINED;
    public static final int DEVICETYPE_NONE;
    public static final int DEVICETYPE_UNKNOWN;
    public static final int DEVICETYPE_RU;
    public static final int DEVICETYPE_KENWOOD;
    public static final int SLIDESHOWIMAGE_CATEGORY_INVALID;
    public static final int SLIDESHOWIMAGE_CATEGORY_UNKNOWN;
    public static final int SLIDESHOWIMAGE_CATEGORY_STATIONLOGO;
    public static final int DATASERVICETYPE_UNDEFINED;
    public static final int DATASERVICETYPE_UNKNOWN;
    public static final int DATASERVICETYPE_SLIDE_SHOW;
    public static final int DATASERVICETYPE_BWS;
    public static final int RESETTYPE_UNDEFINED;
    public static final int RESETTYPE_TO_DEFAULT;
    public static final int RESETTYPE_ANONYMIZE;
    public static final int UPDATEMODE_UNDEFINED;
    public static final int UPDATEMODE_START;
    public static final int UPDATEMODE_ABORT;
    public static final int UPDATEMODE_DELETE_LEARNMEMORY;
    public static final int FORCELMUPDATESTATUS_UNDEFINED;
    public static final int FORCELMUPDATESTATUS_RUNNING;
    public static final int FORCELMUPDATESTATUS_DONE;
    public static final int FORCELMUPDATESTATUS_ABORTED;
    public static final int FORCELMUPDATESTATUS_FAILURE;
    public static final int PREPARETUNINGSTATUS_UNDEFINED;
    public static final int PREPARETUNINGSTATUS_RUNNING;
    public static final int PREPARETUNINGSTATUS_DONE;
    public static final int PREPARETUNINGSTATUS_ABORTED;
    public static final int PREPARETUNINGSTATUS_FAILURE;
    public static final int RT_SELECTSERVICE;
    public static final int RT_SEEKSERVICE;
    public static final int RT_TUNEENSEMBLE;
    public static final int RT_SELECTDATASERVICE;
    public static final int RT_SWITCHDRC;
    public static final int RT_SWITCHLINKING;
    public static final int RT_SWITCHLINKINGDEVICEUSAGE;
    public static final int RT_SWITCHFREQUENCYTABLE;
    public static final int RT_RESET;
    public static final int RT_FORCELMUPDATE;
    public static final int RT_PREPARETUNING;
    public static final int RT_ENABLERADIOTEXTPLUS;
    public static final int RT_SETEPGMODE;
    public static final int RT_SETSLIDESHOWMODE;
    public static final int RT_SETINTELLITEXTMODE;
    public static final int RT_GETEPGDETAILDATA;
    public static final int RT_PROFILECHANGE;
    public static final int RT_PROFILECOPY;
    public static final int RT_PROFILERESET;
    public static final int RT_PROFILERESETALL;
    public static final int RP_SELECTSERVICESTATUS;
    public static final int RP_SEEKSERVICESTATUS;
    public static final int RP_TUNEENSEMBLESTATUS;
    public static final int RP_SELECTDATASERVICESTATUS;
    public static final int RP_FORCELMUPDATESTATUS;
    public static final int RP_PREPARETUNINGSTATUS;
    public static final int RP_PROFILECHANGED;
    public static final int RP_PROFILECOPIED;
    public static final int RP_PROFILERESET;
    public static final int RP_PROFILERESETALL;

    default public void selectService(int n, long l, int n2, int n3, int n4, int n5, long l2) {
    }

    default public void seekService(int n) {
    }

    default public void tuneEnsemble(int n, int n2, int n3, long l) {
    }

    default public void selectDataService(int n, int n2, long l, int n3) {
    }

    default public void switchDRC(boolean bl) {
    }

    default public void switchLinking(int n) {
    }

    default public void switchLinkingDeviceUsage(int n) {
    }

    default public void switchFrequencyTable(int n) {
    }

    default public void reset(int n) {
    }

    default public void forceLMUpdate(int n) {
    }

    default public void prepareTuning(int n, long l, int n2, int n3, int n4, int n5) {
    }

    default public void enableRadioTextPlus(int[] nArray) {
    }

    default public void setEpgMode(int n) {
    }

    default public void setSlideShowMode(int n) {
    }

    default public void setIntellitextMode(int n) {
    }

    default public void getEPGDetailData(int n, int n2, long l, int n3) {
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

