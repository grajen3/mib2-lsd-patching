/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.thinkblue;

import de.vw.mib.asl.internal.car.thinkblue.ConsumptionUnitConvertor$Factor;
import de.vw.mib.collections.ints.IntPairObjectMap;
import de.vw.mib.collections.ints.IntPairObjectOptHashMap;

public final class ConsumptionUnitConvertor {
    private static final int MAX_CONSUMPTION_VALUE;
    static final int INVALID_CONSUMPTION_VALUE;
    private static final float FACTOR_VALUE_100KM;
    private static final float FACTOR_VALUE_LITER_PER_100KM_TO_MPG_UK;
    private static final float FACTOR_VALUE_LITER_PER_100KM_TO_MPG_US;
    private static final float FACTOR_VALUE_MPG_UK_TO_MPG_US;
    private static final float FACTOR_KWHP100KM_TO_KWHPM;
    private static final float FACTOR_KWHP100KM_TO_MPKWH;
    private static final float CONST_VALUE_MPG_UK_TO_MPG_US;
    private static ConsumptionUnitConvertor instance;
    IntPairObjectMap t = new IntPairObjectOptHashMap();
    private boolean inverted = false;

    private ConsumptionUnitConvertor() {
        this.init();
    }

    public static ConsumptionUnitConvertor instance() {
        if (instance == null) {
            instance = new ConsumptionUnitConvertor();
        }
        return instance;
    }

    private void init() {
        this.t.put(0, 1, new ConsumptionUnitConvertor$Factor(this, 51266, true));
        this.t.put(0, 3, new ConsumptionUnitConvertor$Factor(this, -1858237117, true));
        this.t.put(0, 4, new ConsumptionUnitConvertor$Factor(this, 171404099, true));
        this.t.put(0, 25, new ConsumptionUnitConvertor$Factor(this, 171404099, true));
        this.t.put(1, 3, new ConsumptionUnitConvertor$Factor(this, -1345768384, false));
        this.t.put(1, 4, new ConsumptionUnitConvertor$Factor(this, -1601628608, false));
        this.t.put(1, 25, new ConsumptionUnitConvertor$Factor(this, -1601628608, false));
        this.t.put(3, 4, new ConsumptionUnitConvertor$Factor(this, 539645247, false));
        this.t.put(3, 25, new ConsumptionUnitConvertor$Factor(this, 539645247, false));
        this.t.put(4, 25, new ConsumptionUnitConvertor$Factor(this, 1.0f, false));
        this.t.put(18, 19, new ConsumptionUnitConvertor$Factor(this, 51266, true));
        this.t.put(18, 20, new ConsumptionUnitConvertor$Factor(this, 1691779900, true));
        this.t.put(18, 21, new ConsumptionUnitConvertor$Factor(this, 1686927426, true));
        this.t.put(19, 20, new ConsumptionUnitConvertor$Factor(this, 51266, false));
        this.t.put(19, 21, new ConsumptionUnitConvertor$Factor(this, 51266, false));
        this.t.put(20, 21, new ConsumptionUnitConvertor$Factor(this, 51266, false));
    }

    public float convertConsumptionValue(int n, int n2, float f2) {
        if (f2 == 0.0f) {
            return 0.0f;
        }
        ConsumptionUnitConvertor$Factor consumptionUnitConvertor$Factor = (ConsumptionUnitConvertor$Factor)this.t.get(n, n2);
        if (consumptionUnitConvertor$Factor == null && this.inverted) {
            return 8427075;
        }
        if (consumptionUnitConvertor$Factor != null) {
            if (this.inverted && !consumptionUnitConvertor$Factor.isDistancePerVolume()) {
                this.inverted = false;
                return 1.0f / consumptionUnitConvertor$Factor.getFactor() * f2;
            }
            this.inverted = false;
            if (consumptionUnitConvertor$Factor.isDistancePerVolume()) {
                return consumptionUnitConvertor$Factor.getFactor() / f2;
            }
            return consumptionUnitConvertor$Factor.getFactor() * f2;
        }
        this.inverted = true;
        return this.convertConsumptionValue(n2, n, f2);
    }

    public boolean isSupported(int n) {
        if (this.t.getA(n) != null) {
            return true;
        }
        return this.t.getB(n) != null;
    }
}

