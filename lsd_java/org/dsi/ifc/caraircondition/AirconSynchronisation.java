/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.caraircondition;

public class AirconSynchronisation {
    public int master;
    public boolean slaveZL1R;
    public boolean slaveZR1R;
    public boolean slaveZL2R;
    public boolean slaveZR2R;
    public boolean slaveZL3R;
    public boolean slaveZR3R;

    public AirconSynchronisation() {
        this.master = 0;
        this.slaveZL1R = false;
        this.slaveZR1R = false;
        this.slaveZL2R = false;
        this.slaveZR2R = false;
        this.slaveZL3R = false;
        this.slaveZR3R = false;
    }

    public AirconSynchronisation(int n, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6) {
        this.master = n;
        this.slaveZL1R = bl;
        this.slaveZR1R = bl2;
        this.slaveZL2R = bl3;
        this.slaveZR2R = bl4;
        this.slaveZL3R = bl5;
        this.slaveZR3R = bl6;
    }

    public int getMaster() {
        return this.master;
    }

    public boolean isSlaveZL1R() {
        return this.slaveZL1R;
    }

    public boolean isSlaveZR1R() {
        return this.slaveZR1R;
    }

    public boolean isSlaveZL2R() {
        return this.slaveZL2R;
    }

    public boolean isSlaveZR2R() {
        return this.slaveZR2R;
    }

    public boolean isSlaveZL3R() {
        return this.slaveZL3R;
    }

    public boolean isSlaveZR3R() {
        return this.slaveZR3R;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(300);
        stringBuffer.append("AirconSynchronisation");
        stringBuffer.append('(');
        stringBuffer.append("master");
        stringBuffer.append('=');
        stringBuffer.append(this.master);
        stringBuffer.append(',');
        stringBuffer.append("slaveZL1R");
        stringBuffer.append('=');
        stringBuffer.append(this.slaveZL1R);
        stringBuffer.append(',');
        stringBuffer.append("slaveZR1R");
        stringBuffer.append('=');
        stringBuffer.append(this.slaveZR1R);
        stringBuffer.append(',');
        stringBuffer.append("slaveZL2R");
        stringBuffer.append('=');
        stringBuffer.append(this.slaveZL2R);
        stringBuffer.append(',');
        stringBuffer.append("slaveZR2R");
        stringBuffer.append('=');
        stringBuffer.append(this.slaveZR2R);
        stringBuffer.append(',');
        stringBuffer.append("slaveZL3R");
        stringBuffer.append('=');
        stringBuffer.append(this.slaveZL3R);
        stringBuffer.append(',');
        stringBuffer.append("slaveZR3R");
        stringBuffer.append('=');
        stringBuffer.append(this.slaveZR3R);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

