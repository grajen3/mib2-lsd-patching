/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.radio;

public interface DSIDABTuner$Consts {
    public static final String VERSION;
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
    public static final String DEVICE_NAME;
    public static final String DEVICE_INSTANCE;
}

