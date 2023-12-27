/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.thinkblue.calc;

import de.vw.mib.asl.internal.car.thinkblue.ASLTargetThinkBlue;
import de.vw.mib.collections.ints.IntArrayList;

public class Trend {
    private static final int TRENDLIMFALSE;
    private boolean startCalculation;
    private final IntArrayList avgLongArray = new IntArrayList();
    private int trendAvgLast;

    public void reset() {
        this.startCalculation = false;
        this.avgLongArray.clear();
        this.trendAvgLast = 0;
    }

    public void onTimeoutLong() {
        this.startCalculation = true;
    }

    public void addData(int n) {
        if (this.startCalculation && this.avgLongArray.size() > 0) {
            this.avgLongArray.remove(0);
        }
        this.avgLongArray.add(n);
    }

    public boolean calculateTrend() {
        if (!this.startCalculation) {
            return true;
        }
        boolean bl = false;
        int n = this.avgLongArray.size();
        if (n < 3) {
            return true;
        }
        int n2 = Math.round((this.avgLongArray.get(n - 1) + this.avgLongArray.get(n - 2) + this.avgLongArray.get(n - 3)) / 3);
        int n3 = 0;
        for (int i2 = 0; i2 < n; ++i2) {
            n3 += this.avgLongArray.get(i2);
        }
        n3 = Math.round(n3 / n);
        bl = this.evaluateTrend(n2, n3);
        this.trendAvgLast = n2;
        return bl;
    }

    private boolean evaluateTrend(int n, int n2) {
        boolean bl = Math.abs(n - this.trendAvgLast) > 2 ? n >= n2 : true;
        ASLTargetThinkBlue.logMsg.trace(1).append("TBT.Trend=").append(bl).log();
        return bl;
    }
}

