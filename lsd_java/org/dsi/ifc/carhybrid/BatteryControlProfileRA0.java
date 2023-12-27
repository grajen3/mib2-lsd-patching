/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carhybrid;

import org.dsi.ifc.carhybrid.BatteryControlProfileOperation;
import org.dsi.ifc.carhybrid.BatteryControlProfileOperation2;

public class BatteryControlProfileRA0 {
    public int pos;
    public BatteryControlProfileOperation profileOperation;
    public BatteryControlProfileOperation2 profileOperation2;
    public int maxCurrent;
    public int minChargeLevel;
    public int minRange;
    public int targetChargeLevel;
    public int targetChargeDuration;
    public int targetChargeRange;
    public int unitRange;
    public boolean rangeCalculationSetup;
    public int temperature;
    public int temperatureUnit;
    public int leadTime;
    public int holdingTimePlug;
    public int holdingTimeBattery;
    public int providerDataId;
    public String name;

    public BatteryControlProfileRA0() {
        this.pos = 0;
        this.profileOperation = null;
        this.profileOperation2 = null;
        this.maxCurrent = 0;
        this.minChargeLevel = 0;
        this.minRange = 0;
        this.targetChargeLevel = 0;
        this.targetChargeDuration = 0;
        this.targetChargeRange = 0;
        this.unitRange = 0;
        this.rangeCalculationSetup = false;
        this.temperature = 0;
        this.temperatureUnit = 0;
        this.leadTime = 0;
        this.holdingTimePlug = 0;
        this.holdingTimeBattery = 0;
        this.providerDataId = 0;
        this.name = null;
    }

    public BatteryControlProfileRA0(int n, BatteryControlProfileOperation batteryControlProfileOperation, BatteryControlProfileOperation2 batteryControlProfileOperation2, int n2, int n3, int n4, int n5, int n6, int n7, int n8, boolean bl, int n9, int n10, int n11, int n12, int n13, int n14, String string) {
        this.pos = n;
        this.profileOperation = batteryControlProfileOperation;
        this.profileOperation2 = batteryControlProfileOperation2;
        this.maxCurrent = n2;
        this.minChargeLevel = n3;
        this.minRange = n4;
        this.targetChargeLevel = n5;
        this.targetChargeDuration = n6;
        this.targetChargeRange = n7;
        this.unitRange = n8;
        this.rangeCalculationSetup = bl;
        this.temperature = n9;
        this.temperatureUnit = n10;
        this.leadTime = n11;
        this.holdingTimePlug = n12;
        this.holdingTimeBattery = n13;
        this.providerDataId = n14;
        this.name = string;
    }

    public int getPos() {
        return this.pos;
    }

    public BatteryControlProfileOperation getProfileOperation() {
        return this.profileOperation;
    }

    public BatteryControlProfileOperation2 getProfileOperation2() {
        return this.profileOperation2;
    }

    public int getMaxCurrent() {
        return this.maxCurrent;
    }

    public int getMinChargeLevel() {
        return this.minChargeLevel;
    }

    public int getMinRange() {
        return this.minRange;
    }

    public int getTargetChargeLevel() {
        return this.targetChargeLevel;
    }

    public int getTargetChargeDuration() {
        return this.targetChargeDuration;
    }

    public int getTargetChargeRange() {
        return this.targetChargeRange;
    }

    public int getUnitRange() {
        return this.unitRange;
    }

    public boolean isRangeCalculationSetup() {
        return this.rangeCalculationSetup;
    }

    public int getTemperature() {
        return this.temperature;
    }

    public int getTemperatureUnit() {
        return this.temperatureUnit;
    }

    public int getLeadTime() {
        return this.leadTime;
    }

    public int getHoldingTimePlug() {
        return this.holdingTimePlug;
    }

    public int getHoldingTimeBattery() {
        return this.holdingTimeBattery;
    }

    public int getProviderDataId() {
        return this.providerDataId;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(3050);
        stringBuffer.append("BatteryControlProfileRA0");
        stringBuffer.append('(');
        stringBuffer.append("pos");
        stringBuffer.append('=');
        stringBuffer.append(this.pos);
        stringBuffer.append(',');
        stringBuffer.append("profileOperation");
        stringBuffer.append('=');
        stringBuffer.append(this.profileOperation);
        stringBuffer.append(',');
        stringBuffer.append("profileOperation2");
        stringBuffer.append('=');
        stringBuffer.append(this.profileOperation2);
        stringBuffer.append(',');
        stringBuffer.append("maxCurrent");
        stringBuffer.append('=');
        stringBuffer.append(this.maxCurrent);
        stringBuffer.append(',');
        stringBuffer.append("minChargeLevel");
        stringBuffer.append('=');
        stringBuffer.append(this.minChargeLevel);
        stringBuffer.append(',');
        stringBuffer.append("minRange");
        stringBuffer.append('=');
        stringBuffer.append(this.minRange);
        stringBuffer.append(',');
        stringBuffer.append("targetChargeLevel");
        stringBuffer.append('=');
        stringBuffer.append(this.targetChargeLevel);
        stringBuffer.append(',');
        stringBuffer.append("targetChargeDuration");
        stringBuffer.append('=');
        stringBuffer.append(this.targetChargeDuration);
        stringBuffer.append(',');
        stringBuffer.append("targetChargeRange");
        stringBuffer.append('=');
        stringBuffer.append(this.targetChargeRange);
        stringBuffer.append(',');
        stringBuffer.append("unitRange");
        stringBuffer.append('=');
        stringBuffer.append(this.unitRange);
        stringBuffer.append(',');
        stringBuffer.append("rangeCalculationSetup");
        stringBuffer.append('=');
        stringBuffer.append(this.rangeCalculationSetup);
        stringBuffer.append(',');
        stringBuffer.append("temperature");
        stringBuffer.append('=');
        stringBuffer.append(this.temperature);
        stringBuffer.append(',');
        stringBuffer.append("temperatureUnit");
        stringBuffer.append('=');
        stringBuffer.append(this.temperatureUnit);
        stringBuffer.append(',');
        stringBuffer.append("leadTime");
        stringBuffer.append('=');
        stringBuffer.append(this.leadTime);
        stringBuffer.append(',');
        stringBuffer.append("holdingTimePlug");
        stringBuffer.append('=');
        stringBuffer.append(this.holdingTimePlug);
        stringBuffer.append(',');
        stringBuffer.append("holdingTimeBattery");
        stringBuffer.append('=');
        stringBuffer.append(this.holdingTimeBattery);
        stringBuffer.append(',');
        stringBuffer.append("providerDataId");
        stringBuffer.append('=');
        stringBuffer.append(this.providerDataId);
        stringBuffer.append(',');
        stringBuffer.append("name");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.name);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

