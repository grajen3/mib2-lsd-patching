/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.connectedradio;

import org.dsi.ifc.connectedradio.RadioStation;

public interface DSIOnlineRadioC {
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

    default public void setNotification(int[] nArray) {
    }

    default public void setNotification(int n) {
    }

    default public void setNotification() {
    }

    default public void clearNotification(int[] nArray) {
    }

    default public void clearNotification(int n) {
    }

    default public void clearNotification() {
    }

    default public void yySet(String string, String string2) {
    }
}

