/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carhybrid;

public class BatteryControlEngineInstallation {
    public boolean rangeAdjustmentElectricEngine;
    public boolean rangeAdjustmentCombination;

    public BatteryControlEngineInstallation() {
        this.rangeAdjustmentElectricEngine = false;
        this.rangeAdjustmentCombination = false;
    }

    public BatteryControlEngineInstallation(boolean bl, boolean bl2) {
        this.rangeAdjustmentElectricEngine = bl;
        this.rangeAdjustmentCombination = bl2;
    }

    public boolean isRangeAdjustmentElectricEngine() {
        return this.rangeAdjustmentElectricEngine;
    }

    public boolean isRangeAdjustmentCombination() {
        return this.rangeAdjustmentCombination;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("BatteryControlEngineInstallation");
        stringBuffer.append('(');
        stringBuffer.append("rangeAdjustmentElectricEngine");
        stringBuffer.append('=');
        stringBuffer.append(this.rangeAdjustmentElectricEngine);
        stringBuffer.append(',');
        stringBuffer.append("rangeAdjustmentCombination");
        stringBuffer.append('=');
        stringBuffer.append(this.rangeAdjustmentCombination);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

