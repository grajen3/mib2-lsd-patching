/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.climate;

import de.vw.mib.asl.api.system.content.AbstractStageContentRequest;
import de.vw.mib.asl.internal.car.climate.HsmTargetCarClimate;

class HsmTargetCarClimate$1
extends AbstractStageContentRequest {
    private final /* synthetic */ HsmTargetCarClimate this$0;

    HsmTargetCarClimate$1(HsmTargetCarClimate hsmTargetCarClimate, String string) {
        this.this$0 = hsmTargetCarClimate;
        super(string);
    }

    @Override
    public void onSuccess() {
        this.this$0.isClimateDesktopActive = true;
        this.this$0.sendSleepAgainEvent();
    }

    @Override
    public void onFailure() {
        this.this$0.leavingClimateContext();
        this.this$0.sendSleepAgainEvent();
    }
}

