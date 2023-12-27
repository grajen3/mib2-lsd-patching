/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.carplay;

import de.vw.mib.bap.mqbab2.common.api.carplay.CarPlayService;

public interface CarPlayServiceListener {
    public static final int CAR_PLAY_SERVICE__CAR_PLAY_ACTIVE;
    public static final int CAR_PLAY_SERVICE__DEVICE_STATE;
    public static final int CAR_PLAY_SERVICE__ROUTE_GUIDANCE_ACTIVATION;
    public static final int CAR_PLAY_SERVICE__CAR_PLAY_CALLS;

    default public void updateCarPlayData(CarPlayService carPlayService, int n) {
    }
}

