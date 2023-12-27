/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.connectedradio;

import org.dsi.ifc.connectedradio.RadioStation;

public interface DSIHybridRadioReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void getOnlineRadioAvailabilityResult(int n, int n2, RadioStation[] radioStationArray) {
    }

    default public void getRadioStationLogoResult(int n, int n2, RadioStation[] radioStationArray, int n3) {
    }

    default public void indicateRadioStationLogoResult(int n, int n2, RadioStation[] radioStationArray, int n3) {
    }

    default public void getStreamResult(int n, int n2, RadioStation radioStation) {
    }

    default public void startSlideshowResult(int n, int n2, RadioStation radioStation) {
    }

    default public void stopSlideshowResult(int n, int n2, RadioStation radioStation) {
    }

    default public void updateSlideshow(int n, RadioStation radioStation, int n2) {
    }

    default public void updateRadioText(int n, RadioStation radioStation, int n2) {
    }

    default public void cancelGetRadioStationLogoResult(int n, int n2) {
    }

    default public void updateProfileState(int n, int n2, int n3) {
    }

    default public void profileChanged(int n, int n2) {
    }

    default public void profileCopied(int n, int n2, int n3) {
    }

    default public void profileReset(int n, int n2) {
    }

    default public void profileResetAll(int n) {
    }

    default public void asyncException(int n, String string, int n2) {
    }

    default public void yyIndication(String string, String string2) {
    }
}

