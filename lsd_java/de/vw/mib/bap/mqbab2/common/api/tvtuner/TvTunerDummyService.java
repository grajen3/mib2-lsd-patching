/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.tvtuner;

import de.vw.mib.bap.mqbab2.common.api.asl.datatypes.iterator.DummyIterator;
import de.vw.mib.bap.mqbab2.common.api.tvtuner.TvTunerService;
import de.vw.mib.bap.mqbab2.common.api.tvtuner.TvTunerServiceListener;
import java.util.Iterator;

public class TvTunerDummyService
implements TvTunerService {
    @Override
    public void addTvTunerServiceListener(TvTunerServiceListener tvTunerServiceListener, int[] nArray) {
    }

    @Override
    public void removeTvTunerServiceListener(TvTunerServiceListener tvTunerServiceListener, int[] nArray) {
    }

    @Override
    public String getCurrentTvTunerStationName() {
        return "";
    }

    @Override
    public int getCurrentTvTunerSource() {
        return 1;
    }

    @Override
    public int getCurrentTvMuteState() {
        return 0;
    }

    @Override
    public int getTvScopeOfArrowKeyMode() {
        return 1;
    }

    @Override
    public Iterator getTvTunerPresetList() {
        return new DummyIterator();
    }

    @Override
    public void activateNextTvTunerStation() {
    }

    @Override
    public void activatePreviousTvTunerStation() {
    }

    @Override
    public void activateTvTunerPreset(int n) {
    }
}

