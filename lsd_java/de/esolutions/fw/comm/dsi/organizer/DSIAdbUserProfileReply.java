/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.organizer;

import org.dsi.ifc.organizer.DownloadInfo;
import org.dsi.ifc.organizer.EntryMeter;
import org.dsi.ifc.organizer.ProfileInfo;

public interface DSIAdbUserProfileReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void updateProfileInfo(ProfileInfo[] profileInfoArray, int n, int n2) {
    }

    default public void updateDeviceConnected(boolean bl, int n) {
    }

    default public void updateDownloadCountSim(DownloadInfo downloadInfo, int n) {
    }

    default public void updateDownloadCountMe(DownloadInfo downloadInfo, int n) {
    }

    default public void updateDownloadCountOpp(DownloadInfo downloadInfo, int n) {
    }

    default public void updateDownloadState(int n, int n2, int n3) {
    }

    default public void newDeviceConnected(String string) {
    }

    default public void downloadToProfileResult(int n) {
    }

    default public void restartDownloadResult(int n) {
    }

    default public void profileDeleted(int n) {
    }

    default public void setProfileNameResult(int n) {
    }

    default public void deleteProfilesResult(int n) {
    }

    default public void commonEntryCountResult(int n, int n2) {
    }

    default public void entryMeterResult(int n, EntryMeter[] entryMeterArray) {
    }

    default public void setPairingCodeResult(int n) {
    }

    default public void setHomeIdResult(int n) {
    }

    default public void updateDownloadState2ndPhone(int n, int n2, int n3) {
    }

    default public void setSOSButtonResult(int n) {
    }

    default public void updateSOSButton(boolean bl, int n) {
    }

    default public void asyncException(int n, String string, int n2) {
    }

    default public void yyIndication(String string, String string2) {
    }
}

