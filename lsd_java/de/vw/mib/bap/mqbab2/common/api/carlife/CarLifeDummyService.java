/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.carlife;

import de.vw.mib.bap.mqbab2.common.api.carlife.CarLifeService;
import de.vw.mib.bap.mqbab2.common.api.carlife.CarLifeServiceListener;

public class CarLifeDummyService
implements CarLifeService {
    @Override
    public void addCarLifeServiceListener(CarLifeServiceListener carLifeServiceListener, int[] nArray) {
    }

    @Override
    public void removeCarLifeServiceListener(CarLifeServiceListener carLifeServiceListener, int[] nArray) {
    }

    @Override
    public boolean isCarLifeRouteGuidanceActive() {
        return false;
    }
}

