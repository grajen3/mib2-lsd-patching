/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.media;

import org.dsi.ifc.base.DSIBase;

public interface DSIMediaBase
extends DSIBase {
    public static final String VERSION;
    public static final int ATTR_PARENTALML;
    public static final int ATTR_PREFERREDLANGUAGE;
    public static final int ATTR_MEDIALIST;
    public static final int ATTR_DEVICELIST;
    public static final int ATTR_CUSTOMERUPDATE;
    public static final int ATTR_APPLICATIONVERSION;
    public static final int ATTR_METADATADBVERSION;
    public static final int ATTR_PROFILESTATE;
    public static final int RT_SETPREFERREDLANGUAGE;
    public static final int RT_SETPARENTALML;
    public static final int RT_EJECTMEDIUM;
    public static final int RT_REQUESTRESETFACTORYSETTINGS;
    public static final int RT_LAUNCHAPP;
    public static final int RT_PROFILECHANGE;
    public static final int RT_PROFILECOPY;
    public static final int RT_PROFILERESET;
    public static final int RT_PROFILERESETALL;
    public static final int RP_RESPONSERESETFACTORYSETTINGS;
    public static final int RP_LAUNCHAPPRESULT;
    public static final int RP_PROFILECHANGED;
    public static final int RP_PROFILECOPIED;
    public static final int RP_PROFILERESET;
    public static final int RP_PROFILERESETALL;
    public static final int DEVICETYPE_JUKEBOX;
    public static final int DEVICETYPE_SD;
    public static final int DEVICETYPE_USB;
    public static final int DEVICETYPE_DVDINT;
    public static final int DEVICETYPE_CDINT;
    public static final int DEVICETYPE_CDC;
    public static final int DEVICETYPE_DVDC;
    public static final int DEVICETYPE_AUX;
    public static final int DEVICETYPE_WLAN;
    public static final int DEVICETYPE_BT;
    public static final int DEVICETYPE_FILEPLAYER;
    public static final int DEVICETYPE_BDINT;
    public static final int DEVICEFLAGS_COOPERATIVE;
    public static final int DEVICEFLAGS_EXCLUSIVE;
    public static final int DEVICEFLAGS_ERROR;
    public static final int DEVICEFLAGS_UNAVAILABLE;
    public static final int DEVICEFLAGS_OVERTEMP;
    public static final int DEVICEFLAGS_UNDERTEMP;
    public static final int DEVICEFLAGS_OVERCURRENT;
    public static final int DEVICEFLAGS_LIMITED_FUNCTIONALITY;
    public static final int MEDIAFLAG_NOPLAYABLEFILES;
    public static final int MEDIAFLAG_PASS_ALL_COMPLETED;
    public static final int MEDIAFLAG_IMPORT_RUNNING;
    public static final int MEDIAFLAG_INVALID_REGIONCODE;
    public static final int MEDIAFLAG_PML_BLOCKED;
    public static final int MEDIAFLAG_PML_RESTRICTED;
    public static final int MEDIAFLAG_PLAYBACK;
    public static final int MEDIAFLAG_NO_CONTENT;
    public static final int MEDIAFLAG_COPY_PROTECTED;
    public static final int MEDIAFLAG_READ_ONLY;
    public static final int MEDIAFLAG_READY_FOR_RECORDER;
    public static final int MEDIAFLAG_FIRMWARE_NOT_SUPPORTED;
    public static final int MEDIAFLAG_PASS_FILESYSTEM_COMPLETED;
    public static final int MEDIAFLAG_PASS_METADATA_COMPLETED;
    public static final int MEDIAFLAG_PASS_COVERART_COMPLETED;
    public static final int MEDIAFLAG_PASS_EXTERNAL_METADATA_COMPLETED;
    public static final int MEDIAFLAG_DELETION_RUNNING;
    public static final int MEDIAFLAG_LAST_PLAYSELECTION_VALID;
    public static final int MEDIAFLAG_INTERNATIONALIZABLE;
    public static final int MEDIAFLAG_CORRUPTED_PARTITION;
    public static final int MEDIAFLAG_CHARGING;
    public static final int MEDIAFLAG_DATABASE_FULL;
    public static final int MEDIAFLAG_READY_FOR_ALBUMBROWSER;
    public static final int MEDIATYPE_UNKNOWN;
    public static final int MEDIATYPE_CDAUDIO;
    public static final int MEDIATYPE_DVDAUDIO;
    public static final int MEDIATYPE_DVDVIDEO;
    public static final int MEDIATYPE_CDROM;
    public static final int MEDIATYPE_DVDROM;
    public static final int MEDIATYPE_FILESYSTEM;
    public static final int MEDIATYPE_RAW;
    public static final int MEDIATYPE_RCP;
    public static final int MEDIATYPE_EMPTY;
    public static final int MEDIATYPE_UNREADABLE;
    public static final int MEDIATYPE_LOADING;
    public static final int MEDIATYPE_AUTOMATIC_RELOAD;
    public static final int MEDIATYPE_UNSUPPORTED;
    public static final int MEDIATYPE_UPDATE;
    public static final int MEDIATYPE_FILEPLAYER;
    public static final int MEDIATYPE_NAVIGATIONDATABASE;
    public static final int MEDIATYPE_IPOD;
    public static final int MEDIATYPE_BLURAY;
    public static final int MEDIATYPE_BOARDBOOK;
    public static final int RESETMODE_FACTORYSETTINGS;
    public static final int RESETMODE_DATABASE;
    public static final int RESETMODE_JUKEBOX;
    public static final int RESETMODE_CUSTOMERUPDATE;
    public static final int CUSTOMERUPDATE_UNKNOWN;
    public static final int CUSTOMERUPDATE_NOT_AVAILABLE;
    public static final int CUSTOMERUPDATE_AVAILABLE;

    default public void setPreferredLanguage(String string) {
    }

    default public void setParentalML(int n) {
    }

    default public void ejectMedium(long l, long l2) {
    }

    default public void requestResetFactorySettings(int n) {
    }

    default public void launchApp(long l, long l2, String string) {
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

