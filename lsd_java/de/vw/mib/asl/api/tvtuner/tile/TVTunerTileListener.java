/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.tvtuner.tile;

public interface TVTunerTileListener {
    default public void updateCurrentStationName(String string) {
    }

    default public void updateDisclaimerTunerNotAvailableVisible(boolean bl) {
    }

    default public void updateDisclaimerTunerStartingVisible(boolean bl) {
    }

    default public void updateDisclaimerCasVisible(boolean bl) {
    }

    default public void updateActiveSource(int n) {
    }

    default public void updateProgramInfo(String string, int n, int n2, int n3, int n4) {
    }

    default public void updateTVVideoFormat(int n) {
    }

    default public void updateAVVideoFormat(int n) {
    }

    default public void updateTVMuteIconVisible(boolean bl) {
    }

    default public void updateDisclaimerRadioVisible(boolean bl) {
    }

    default public void updateSourceAvAvailable(boolean bl) {
    }
}

