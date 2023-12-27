/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.tvtuner;

import de.vw.mib.bap.mqbab2.common.api.tvtuner.TvTunerServiceListener;
import java.util.Iterator;

public interface TvTunerService {
    default public void addTvTunerServiceListener(TvTunerServiceListener tvTunerServiceListener, int[] nArray) {
    }

    default public void removeTvTunerServiceListener(TvTunerServiceListener tvTunerServiceListener, int[] nArray) {
    }

    default public String getCurrentTvTunerStationName() {
    }

    default public int getCurrentTvTunerSource() {
    }

    default public int getCurrentTvMuteState() {
    }

    default public int getTvScopeOfArrowKeyMode() {
    }

    default public Iterator getTvTunerPresetList() {
    }

    default public void activateNextTvTunerStation() {
    }

    default public void activatePreviousTvTunerStation() {
    }

    default public void activateTvTunerPreset(int n) {
    }
}

