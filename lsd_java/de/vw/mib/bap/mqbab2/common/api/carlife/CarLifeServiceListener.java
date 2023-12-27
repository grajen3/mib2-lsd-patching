/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.carlife;

import de.vw.mib.bap.mqbab2.common.api.carlife.CarLifeService;

public interface CarLifeServiceListener {
    public static final int CARLIFE_SERVICE__CARLIFE_ROUTE_GUIDANCE_ACTIVE;

    default public void updateCarLifeData(CarLifeService carLifeService, int n) {
    }
}

