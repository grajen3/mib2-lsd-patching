/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.kombipictureserver;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.global.ResourceLocator;

public interface DSIKombiPictureServer
extends DSIBase {
    public static final String VERSION;
    public static final int SOURCETYPE_NOSOURCE;
    public static final int SOURCETYPE_FM;
    public static final int SOURCETYPE_AM;
    public static final int SOURCETYPE_DAB;
    public static final int SOURCETYPE_SDARS_XM;
    public static final int SOURCETYPE_SDARS_SIRIUS;
    public static final int SOURCETYPE_CD;
    public static final int SOURCETYPE_CD_CHANGER;
    public static final int SOURCETYPE_DVD;
    public static final int SOURCETYPE_TV;
    public static final int SOURCETYPE_HDD;
    public static final int SOURCETYPE_SD;
    public static final int SOURCETYPE_TPMEMO_TIM;
    public static final int SOURCETYPE_AUX_IN_AUDIO;
    public static final int SOURCETYPE_AUX_IN_VIDEO;
    public static final int SOURCETYPE_PORTABLE_DEVICE;
    public static final int SOURCETYPE_GENERIC_PLAYER;
    public static final int SOURCETYPE_AM_TI;
    public static final int SOURCETYPE_DVD_CHANGER;
    public static final int SOURCETYPE_USB;
    public static final int SOURCETYPE_JUKEBOX;
    public static final int SOURCETYPE_BT_STREAM;
    public static final int SOURCETYPE_BT_RCP;
    public static final int SOURCETYPE_DVB_VIDEO;
    public static final int SOURCETYPE_DVB_AUDIO;
    public static final int SOURCETYPE_FLASHMEMORY;
    public static final int SOURCETYPE_AUX_IN_VIDEO_TV;
    public static final int SOURCETYPE_HDMI;
    public static final int SOURCETYPE_ONLINE_MASS_STORAGE;
    public static final int SOURCETYPE_ONLINE_RADIO;
    public static final int SOURCETYPE_UNKNOWN;
    public static final int COVERARTTYPE_NOPICTURE;
    public static final int COVERARTTYPE_NORMAL;
    public static final int COVERARTTYPE_DEFAULT;
    public static final int ICONTYPE_ACTIVESOURCE;
    public static final int ICONTYPE_SOURCELIST;
    public static final int PHONEINSTANCE_MAIN;
    public static final int PHONEINSTANCE_FIRST;
    public static final int PHONEINSTANCE_SECOND;
    public static final int PHONEINSTANCE_THIRD;
    public static final int ID_INVALID;
    public static final int ID_UNKNOWN;
    public static final int ADDRESSTYPE_BAP;
    public static final int ADDRESSTYPE_MOST;
    public static final int IDTYPE_COVERART;
    public static final int IDTYPE_ADDRESSBOOKCONTACT;
    public static final int IDTYPE_STATIONART;
    public static final int CALLID_NOCALL;
    public static final int CALLID_UNKNOWN;
    public static final int ACTIVECALLPICTURETYPE_NOPICTURE;
    public static final int ACTIVECALLPICTURETYPE_CONTACT;
    public static final int ACTIVECALLPICTURETYPE_INFO;
    public static final int ACTIVECALLPICTURETYPE_SERVICE;
    public static final int ACTIVECALLPICTURETYPE_EMERGENCY;
    public static final int ACTIVECALLPICTURETYPE_CONFERENCE;
    public static final int ACTIVECALLPICTURETYPE_DEFAULT;
    public static final int ADBCONTACTPICTURETYPES_NOPICTURE;
    public static final int ADBCONTACTPICTURETYPES_CONTACT;
    public static final int ADBCONTACTPICTURETYPES_DEFAULT;
    public static final int STATIONARTTYPE_NOPICTURE;
    public static final int STATIONARTTYPE_NORMAL;
    public static final int STATIONARTTYPE_DEFAULT;
    public static final int RT_SETKOMBIHMIREADY;
    public static final int RT_RESPONSECOVERART;
    public static final int RT_RESPONSESTATIONART;
    public static final int RT_RESPONSEACTIVECALLPICTURE;
    public static final int RT_RESPONSEADBCONTACTPICTURE;
    public static final int RT_RESPONSEINTERNALADDRESSID;
    public static final int RT_RESPONSEPICTURESERVERABILITIES;
    public static final int RT_RESPONSEPICTURESTREAM;
    public static final int RT_RESPONSEACTIVECALLPICTUREINSTANCE;
    public static final int RT_RESPONSEDYNAMICICON;
    public static final int IN_INDICATIONCOVERART;
    public static final int IN_INDICATIONSTATIONART;
    public static final int IN_INDICATIONACTIVECALLPICTURE;
    public static final int IN_INDICATIONINTERNALADDRESSID;
    public static final int IN_INDICATIONADBCONTACTPICTURE;
    public static final int IN_INDICATIONPICTURESTREAMABILITIES;
    public static final int IN_INDICATIONPICTURESTREAM;
    public static final int IN_INDICATIONACTIVECALLPICTUREINSTANCE;
    public static final int IN_INDICATIONDYNAMICICON;
    public static final int AVAILABLEPICTURESOURCES_ONLINEAVAILABLE;
    public static final int AVAILABLEPICTURESOURCES_AUDIOAVAILABLE;
    public static final int AVAILABLEPICTURESOURCES_NAVIGATIONAVAILABLE;
    public static final int AVAILABLEPICTURESOURCES_TELEPHONEAVAILABLE;
    public static final int AVAILABLEPICTURESOURCES_PICNAVAVAILABLE;
    public static final int AVAILABLEPICTURESOURCES_BRANDINGAVAILABLE;
    public static final int LISTPOSTYPE_ARBITRARY;
    public static final int LISTPOSTYPE_8BYTE;
    public static final int PSSOURCETYPE_ONLINE;
    public static final int PSSOURCETYPE_AUDIO;
    public static final int PSSOURCETYPE_NAVIGATION;
    public static final int PSSOURCETYPE_TELEPHONE;
    public static final int PSSOURCETYPE_PICNAV;
    public static final int PSSOURCETYPE_BRANDING;

    default public void setKombiHmiReady() {
    }

    default public void responseCoverArt(long l, int n, int n2, int n3, ResourceLocator resourceLocator) {
    }

    default public void responseStationArt(long l, int n, int n2, int n3, ResourceLocator resourceLocator) {
    }

    default public void responseActiveCallPicture(int n, int n2, ResourceLocator resourceLocator) {
    }

    default public void responseActiveCallPictureInstance(int n, int n2, int n3, ResourceLocator resourceLocator) {
    }

    default public void responseDynamicIcon(int n, int n2, boolean bl, ResourceLocator resourceLocator) {
    }

    default public void responseAdbContactPicture(long l, int n, int n2, ResourceLocator resourceLocator) {
    }

    default public void responseInternalAddressID(long l, int n, int n2) {
    }

    default public void responsePictureServerAbilities(int n) {
    }

    default public void responsePictureStream(int n, short s, short s2, int n2, int n3, byte[] byArray) {
    }
}

