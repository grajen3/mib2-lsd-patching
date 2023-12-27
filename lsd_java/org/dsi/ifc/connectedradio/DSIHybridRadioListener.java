/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.connectedradio;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.connectedradio.RadioStation;

public interface DSIHybridRadioListener
extends DSIListener {
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
}

