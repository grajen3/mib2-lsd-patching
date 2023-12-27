/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.thinkblue;

import de.vw.mib.asl.internal.car.thinkblue.ConsumptionUnitConvertor;

class ConsumptionUnitConvertor$Factor {
    float factor;
    boolean isDistancePerVolume;
    private final /* synthetic */ ConsumptionUnitConvertor this$0;

    public ConsumptionUnitConvertor$Factor(ConsumptionUnitConvertor consumptionUnitConvertor, float f2, boolean bl) {
        this.this$0 = consumptionUnitConvertor;
        this.factor = f2;
        this.isDistancePerVolume = bl;
    }

    public float getFactor() {
        return this.factor;
    }

    public void setFactor(float f2) {
        this.factor = f2;
    }

    public boolean isDistancePerVolume() {
        return this.isDistancePerVolume;
    }

    public void setDistancePerVolume(boolean bl) {
        this.isDistancePerVolume = bl;
    }
}

