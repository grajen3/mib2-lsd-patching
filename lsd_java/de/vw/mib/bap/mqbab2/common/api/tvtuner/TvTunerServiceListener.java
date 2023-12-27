/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.tvtuner;

import de.vw.mib.bap.mqbab2.common.api.tvtuner.TvTunerService;

public interface TvTunerServiceListener {
    public static final int TV_TUNER_SERVICE__CURRENT_STATION_NAME;
    public static final int TV_TUNER_SERVICE__ACTIVE_SOURCE;
    public static final int TV_TUNER_SERVICE__TV_MUTE_STATE;
    public static final int TV_TUNER_SERVICE__SCOPE_OF_ARROW_KEY_MODE;
    public static final int TV_TUNER_SERVICE__PRESET_LIST;

    default public void updateTvTunerData(TvTunerService tvTunerService, int n) {
    }
}

