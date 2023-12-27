/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.connectedradio;

import org.dsi.ifc.connectedradio.RadioStation;

public interface DSIHybridRadioC {
    default public void getOnlineRadioAvailability(int n, RadioStation[] radioStationArray) {
    }

    default public void getRadioStationLogo(int n, RadioStation[] radioStationArray, int n2) {
    }

    default public void cancelGetRadioStationLogo(int n) {
    }

    default public void getStream(int n, RadioStation radioStation) {
    }

    default public void startSlideshow(int n, RadioStation radioStation, int n2, int n3) {
    }

    default public void stopSlideshow(int n, RadioStation radioStation) {
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

