/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carkombi;

public class BCStatisticsConfig {
    public boolean statisticsTimeState;
    public boolean statisticsDistanceState;
    public boolean statisticsPeriodState;
    public boolean statisticsIntervalState;
    public int statisticsPeriodValue;
    public float statisticsIntervalValue;

    public BCStatisticsConfig() {
        this.statisticsTimeState = false;
        this.statisticsDistanceState = false;
        this.statisticsPeriodState = false;
        this.statisticsIntervalState = false;
        this.statisticsPeriodValue = 0;
        this.statisticsIntervalValue = 0.0f;
    }

    public BCStatisticsConfig(boolean bl, boolean bl2, boolean bl3, boolean bl4, int n, float f2) {
        this.statisticsTimeState = bl;
        this.statisticsDistanceState = bl2;
        this.statisticsPeriodState = bl3;
        this.statisticsIntervalState = bl4;
        this.statisticsPeriodValue = n;
        this.statisticsIntervalValue = f2;
    }

    public boolean isStatisticsTimeState() {
        return this.statisticsTimeState;
    }

    public boolean isStatisticsDistanceState() {
        return this.statisticsDistanceState;
    }

    public boolean isStatisticsPeriodState() {
        return this.statisticsPeriodState;
    }

    public boolean isStatisticsIntervalState() {
        return this.statisticsIntervalState;
    }

    public int getStatisticsPeriodValue() {
        return this.statisticsPeriodValue;
    }

    public float getStatisticsIntervalValue() {
        return this.statisticsIntervalValue;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(400);
        stringBuffer.append("BCStatisticsConfig");
        stringBuffer.append('(');
        stringBuffer.append("statisticsTimeState");
        stringBuffer.append('=');
        stringBuffer.append(this.statisticsTimeState);
        stringBuffer.append(',');
        stringBuffer.append("statisticsDistanceState");
        stringBuffer.append('=');
        stringBuffer.append(this.statisticsDistanceState);
        stringBuffer.append(',');
        stringBuffer.append("statisticsPeriodState");
        stringBuffer.append('=');
        stringBuffer.append(this.statisticsPeriodState);
        stringBuffer.append(',');
        stringBuffer.append("statisticsIntervalState");
        stringBuffer.append('=');
        stringBuffer.append(this.statisticsIntervalState);
        stringBuffer.append(',');
        stringBuffer.append("statisticsPeriodValue");
        stringBuffer.append('=');
        stringBuffer.append(this.statisticsPeriodValue);
        stringBuffer.append(',');
        stringBuffer.append("statisticsIntervalValue");
        stringBuffer.append('=');
        stringBuffer.append(this.statisticsIntervalValue);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

