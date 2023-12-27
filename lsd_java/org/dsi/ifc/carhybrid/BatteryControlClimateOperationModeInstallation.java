/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carhybrid;

public class BatteryControlClimateOperationModeInstallation {
    public boolean operationModeImmediatly;
    public boolean operationModeTimer1;
    public boolean operationModeTimer2;
    public boolean operationModeTimer3;
    public boolean operationModeTimer4;

    public BatteryControlClimateOperationModeInstallation() {
        this.operationModeImmediatly = false;
        this.operationModeTimer1 = false;
        this.operationModeTimer2 = false;
        this.operationModeTimer3 = false;
        this.operationModeTimer4 = false;
    }

    public BatteryControlClimateOperationModeInstallation(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5) {
        this.operationModeImmediatly = bl;
        this.operationModeTimer1 = bl2;
        this.operationModeTimer2 = bl3;
        this.operationModeTimer3 = bl4;
        this.operationModeTimer4 = bl5;
    }

    public boolean isOperationModeImmediatly() {
        return this.operationModeImmediatly;
    }

    public boolean isOperationModeTimer1() {
        return this.operationModeTimer1;
    }

    public boolean isOperationModeTimer2() {
        return this.operationModeTimer2;
    }

    public boolean isOperationModeTimer3() {
        return this.operationModeTimer3;
    }

    public boolean isOperationModeTimer4() {
        return this.operationModeTimer4;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(300);
        stringBuffer.append("BatteryControlClimateOperationModeInstallation");
        stringBuffer.append('(');
        stringBuffer.append("operationModeImmediatly");
        stringBuffer.append('=');
        stringBuffer.append(this.operationModeImmediatly);
        stringBuffer.append(',');
        stringBuffer.append("operationModeTimer1");
        stringBuffer.append('=');
        stringBuffer.append(this.operationModeTimer1);
        stringBuffer.append(',');
        stringBuffer.append("operationModeTimer2");
        stringBuffer.append('=');
        stringBuffer.append(this.operationModeTimer2);
        stringBuffer.append(',');
        stringBuffer.append("operationModeTimer3");
        stringBuffer.append('=');
        stringBuffer.append(this.operationModeTimer3);
        stringBuffer.append(',');
        stringBuffer.append("operationModeTimer4");
        stringBuffer.append('=');
        stringBuffer.append(this.operationModeTimer4);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

