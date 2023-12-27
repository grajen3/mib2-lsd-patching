/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.connectedradio;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.connectedradio.RadioStation;

public interface DSIOnlineRadio
extends DSIBase {
    public static final String VERSION;
    public static final int ATTR_PROFILESTATE;
    public static final int RP_GETSTREAMURLRESULT;
    public static final int RP_GETRADIOSTATIONLOGORESULT;
    public static final int RP_GETMETAINFORMATIONRESULT;
    public static final int RP_CANCELDOWNLOADDATABASERESULT;
    public static final int RP_DOWNLOADDATABASERESULT;
    public static final int RP_PROFILECHANGED;
    public static final int RP_PROFILECOPIED;
    public static final int RP_PROFILERESET;
    public static final int RP_PROFILERESETALL;
    public static final int RT_GETRADIOSTATIONLOGO;
    public static final int RT_GETSTREAMURL;
    public static final int RT_GETMETAINFORMATION;
    public static final int RT_DOWNLOADDATABASE;
    public static final int RT_CANCELDOWNLOADDATABASE;
    public static final int RT_PROFILECHANGE;
    public static final int RT_PROFILECOPY;
    public static final int RT_PROFILERESET;
    public static final int RT_PROFILERESETALL;

    default public void getRadioStationLogo(int n, RadioStation radioStation, int n2) {
    }

    default public void getStreamUrl(int n, RadioStation radioStation) {
    }

    default public void getMetaInformation(int n, RadioStation radioStation) {
    }

    default public void downloadDatabase(int n) {
    }

    default public void cancelDownloadDatabase(int n) {
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

