/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carhybrid;

public class BatteryControlPlug {
    public int lockSetup;
    public int lockState;
    public int supplyState;
    public int plugState;

    public BatteryControlPlug() {
        this.lockSetup = 15;
        this.lockState = 15;
        this.supplyState = 15;
        this.plugState = 15;
    }

    public BatteryControlPlug(int n, int n2, int n3, int n4) {
        this.lockSetup = n;
        this.lockState = n2;
        this.supplyState = n3;
        this.plugState = n4;
    }

    public int getLockSetup() {
        return this.lockSetup;
    }

    public int getLockState() {
        return this.lockState;
    }

    public int getSupplyState() {
        return this.supplyState;
    }

    public int getPlugState() {
        return this.plugState;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(250);
        stringBuffer.append("BatteryControlPlug");
        stringBuffer.append('(');
        stringBuffer.append("lockSetup");
        stringBuffer.append('=');
        stringBuffer.append(this.lockSetup);
        stringBuffer.append(',');
        stringBuffer.append("lockState");
        stringBuffer.append('=');
        stringBuffer.append(this.lockState);
        stringBuffer.append(',');
        stringBuffer.append("supplyState");
        stringBuffer.append('=');
        stringBuffer.append(this.supplyState);
        stringBuffer.append(',');
        stringBuffer.append("plugState");
        stringBuffer.append('=');
        stringBuffer.append(this.plugState);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

