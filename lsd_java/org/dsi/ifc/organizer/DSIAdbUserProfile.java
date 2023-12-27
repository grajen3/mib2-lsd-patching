/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.organizer;

import org.dsi.ifc.base.DSIBase;

public interface DSIAdbUserProfile
extends DSIBase {
    public static final String VERSION;
    public static final int RT_DOWNLOADTOPROFILE;
    public static final int RT_RESTARTDOWNLOAD;
    public static final int RT_SETPROFILENAME;
    public static final int RT_DELETEPROFILES;
    public static final int RT_COMMONENTRYCOUNT;
    public static final int RT_ENTRYMETER;
    public static final int RT_SETPAIRINGCODE;
    public static final int RT_SETHOMEID;
    public static final int RT_SETSOSBUTTON;
    public static final int ATTR_PROFILEINFO;
    public static final int ATTR_DEVICECONNECTED;
    public static final int ATTR_DOWNLOADCOUNTSIM;
    public static final int ATTR_DOWNLOADCOUNTME;
    public static final int ATTR_DOWNLOADCOUNTOPP;
    public static final int ATTR_DOWNLOADSTATE;
    public static final int ATTR_DOWNLOADSTATE2NDPHONE;
    public static final int ATTR_SOSBUTTON;
    public static final int RP_DOWNLOADTOPROFILERESULT;
    public static final int RP_RESTARTDOWNLOADRESULT;
    public static final int RP_SETPROFILENAMERESULT;
    public static final int RP_DELETEPROFILESRESULT;
    public static final int RP_COMMONENTRYCOUNTRESULT;
    public static final int RP_ENTRYMETERRESULT;
    public static final int RP_SETPAIRINGCODERESULT;
    public static final int RP_SETHOMEIDRESULT;
    public static final int RP_SETSOSBUTTONRESULT;
    public static final int IN_NEWDEVICECONNECTED;
    public static final int IN_PROFILEDELETED;

    default public void downloadToProfile(int n) {
    }

    default public void restartDownload() {
    }

    default public void setProfileName(String string) {
    }

    default public void deleteProfiles(int[] nArray) {
    }

    default public void commonEntryCount() {
    }

    default public void entryMeter() {
    }

    default public void setPairingCode(String string) {
    }

    default public void setHomeId(long l) {
    }

    default public void setSOSButton(boolean bl) {
    }
}

