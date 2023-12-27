/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.common.reset;

import de.vw.mib.asl.api.system.factoryreset.FactoryResetCallback;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetParticipant;
import de.vw.mib.asl.internal.car.common.reset.CarFactoryReset;

class CarFactoryReset$1
implements FactoryResetParticipant {
    private final /* synthetic */ CarFactoryReset this$0;

    CarFactoryReset$1(CarFactoryReset carFactoryReset) {
        this.this$0 = carFactoryReset;
    }

    @Override
    public void reset(FactoryResetCallback factoryResetCallback, int n) {
        this.this$0.resetListeners();
    }

    @Override
    public long getTimeout() {
        return 0L;
    }
}

