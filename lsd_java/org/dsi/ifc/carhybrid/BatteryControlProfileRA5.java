/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carhybrid;

import org.dsi.ifc.carhybrid.BatteryControlProfileOperation;
import org.dsi.ifc.carhybrid.BatteryControlProfileOperation2;

public class BatteryControlProfileRA5 {
    public int pos;
    public BatteryControlProfileOperation profileOperation;
    public BatteryControlProfileOperation2 profileOperation2;
    public int maxCurrent;
    public int targetChargeLevel;
    public int providerDataId;
    public String name;

    public BatteryControlProfileRA5() {
        this.pos = 0;
        this.profileOperation = null;
        this.profileOperation2 = null;
        this.maxCurrent = 0;
        this.targetChargeLevel = 0;
        this.providerDataId = 0;
        this.name = null;
    }

    public BatteryControlProfileRA5(int n, BatteryControlProfileOperation batteryControlProfileOperation, BatteryControlProfileOperation2 batteryControlProfileOperation2, int n2, int n3, int n4, String string) {
        this.pos = n;
        this.profileOperation = batteryControlProfileOperation;
        this.profileOperation2 = batteryControlProfileOperation2;
        this.maxCurrent = n2;
        this.targetChargeLevel = n3;
        this.providerDataId = n4;
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

    public int getTargetChargeLevel() {
        return this.targetChargeLevel;
    }

    public int getProviderDataId() {
        return this.providerDataId;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(2400);
        stringBuffer.append("BatteryControlProfileRA5");
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
        stringBuffer.append("targetChargeLevel");
        stringBuffer.append('=');
        stringBuffer.append(this.targetChargeLevel);
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

