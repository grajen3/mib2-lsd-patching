/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.cardriverassistance;

public class AWVEmergencyBrake {
    public boolean targetBrake;
    public boolean autoBrake;

    public AWVEmergencyBrake() {
        this.targetBrake = false;
        this.autoBrake = false;
    }

    public AWVEmergencyBrake(boolean bl, boolean bl2) {
        this.targetBrake = bl;
        this.autoBrake = bl2;
    }

    public boolean isTargetBrake() {
        return this.targetBrake;
    }

    public boolean isAutoBrake() {
        return this.autoBrake;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("AWVEmergencyBrake");
        stringBuffer.append('(');
        stringBuffer.append("targetBrake");
        stringBuffer.append('=');
        stringBuffer.append(this.targetBrake);
        stringBuffer.append(',');
        stringBuffer.append("autoBrake");
        stringBuffer.append('=');
        stringBuffer.append(this.autoBrake);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

