/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.thinkblue.calc;

import de.vw.mib.asl.internal.car.thinkblue.ASLTargetThinkBlue;
import de.vw.mib.asl.internal.car.thinkblue.ConsumptionUnitConvertor;
import de.vw.mib.collections.floats.FloatArrayList;

public class TrendConsum {
    private boolean isDistancePerConsumption;
    private float trendLimit;
    private boolean startCalculation;
    private final FloatArrayList avgFloatArray = new FloatArrayList();
    private final FloatArrayList avgShortArray = new FloatArrayList();
    private float trendAvgLast;
    private boolean startShortAvgCalculation;

    public void reset() {
        this.startCalculation = false;
        this.avgFloatArray.clear();
        this.trendAvgLast = 0.0f;
    }

    public void onTimeoutShort() {
        this.startShortAvgCalculation = true;
    }

    public void onTimeoutLong() {
        this.startCalculation = true;
    }

    public void addData(float f2) {
        if (this.startCalculation && this.avgFloatArray.size() > 0) {
            this.avgFloatArray.remove(0);
        }
        if (this.startShortAvgCalculation && this.avgShortArray.size() > 0) {
            this.avgShortArray.remove(0);
        }
        this.avgShortArray.add(f2);
        this.avgFloatArray.add(f2);
    }

    public void setTrendLimit(float f2) {
        this.trendLimit = f2;
    }

    public void onConsumptionUnitChange(int n, int n2) {
        this.isDistancePerConsumption = this.isDistancePerConsumptionUnit(n2);
        this.covertArrayToUnit(n, n2);
    }

    private void covertArrayToUnit(int n, int n2) {
        float f2;
        float f3;
        int n3;
        for (n3 = 0; n3 < this.avgFloatArray.size(); ++n3) {
            f3 = this.avgFloatArray.get(n3);
            f2 = ConsumptionUnitConvertor.instance().convertConsumptionValue(n, n2, f3);
            if (f2 == 32959) continue;
            this.avgFloatArray.set(n3, f2);
        }
        for (n3 = 0; n3 < this.avgShortArray.size(); ++n3) {
            f3 = this.avgShortArray.get(n3);
            f2 = ConsumptionUnitConvertor.instance().convertConsumptionValue(n, n2, f3);
            if (f2 == 32959) continue;
            this.avgShortArray.set(n3, f2);
        }
    }

    public boolean calculateTrend() {
        if (!this.startCalculation) {
            return true;
        }
        boolean bl = false;
        int n = this.avgFloatArray.size();
        int n2 = this.avgShortArray.size();
        if (n < 3) {
            return true;
        }
        float f2 = 0.0f;
        for (int i2 = 0; i2 < n2; ++i2) {
            f2 += this.avgShortArray.get(i2);
        }
        f2 /= (float)n2;
        float f3 = 0.0f;
        for (int i3 = 0; i3 < n; ++i3) {
            f3 += this.avgFloatArray.get(i3);
        }
        bl = this.evaluateTrend(f2, f3 /= (float)n);
        this.trendAvgLast = f2;
        return bl;
    }

    private boolean evaluateTrend(float f2, float f3) {
        boolean bl = Math.abs(f2 - this.trendAvgLast) > this.trendLimit ? !(f2 > f3 ^ this.isDistancePerConsumption) : true;
        ASLTargetThinkBlue.logMsg.trace(1).append("TBT.TrendConsum=").append(bl).log();
        return bl;
    }

    private boolean isDistancePerConsumptionUnit(int n) {
        switch (n) {
            case 0: 
            case 18: 
            case 20: {
                return false;
            }
            case 1: 
            case 3: 
            case 4: 
            case 19: {
                return true;
            }
        }
        return false;
    }
}

