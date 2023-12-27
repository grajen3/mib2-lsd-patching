/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.tvtunertiles.listener;

import de.vw.mib.asl.api.tvtuner.tile.TVTunerTileListenerAdapter;
import generated.de.vw.mib.appadapter.tvtunertiles.TVTunerModelApiCallback;

public class TVTunerTileSListener
extends TVTunerTileListenerAdapter {
    private TVTunerModelApiCallback modelCallback;

    public TVTunerTileSListener(TVTunerModelApiCallback tVTunerModelApiCallback) {
        this.modelCallback = tVTunerModelApiCallback;
    }

    @Override
    public void updateCurrentStationName(String string) {
        this.modelCallback._update_getCurrentStationName(string);
    }

    @Override
    public void updateDisclaimerTunerNotAvailableVisible(boolean bl) {
        this.modelCallback._update_isTVTunerNotAvailableDisclaimerVisible(bl);
    }

    @Override
    public void updateDisclaimerTunerStartingVisible(boolean bl) {
        this.modelCallback._update_isTVTunerStartingDisclaimerVisible(bl);
    }

    @Override
    public void updateDisclaimerCasVisible(boolean bl) {
        this.modelCallback._update_isCASDisclaimerVisible(bl);
    }

    @Override
    public void updateActiveSource(int n) {
        this.modelCallback._update_getActiveSource(n);
    }

    @Override
    public void updateTVVideoFormat(int n) {
    }

    @Override
    public void updateAVVideoFormat(int n) {
    }

    @Override
    public void updateTVMuteIconVisible(boolean bl) {
        this.modelCallback._update_isTVMuteIconVisible(bl);
    }

    @Override
    public void updateDisclaimerRadioVisible(boolean bl) {
    }

    public void updateSlideshowVisible(boolean bl) {
    }

    @Override
    public void updateProgramInfo(String string, int n, int n2, int n3, int n4) {
        this.modelCallback._update_getCurrentProgramName(string);
    }

    @Override
    public void updateSourceAvAvailable(boolean bl) {
        this.modelCallback._update_isAVAvailable(bl);
    }
}

