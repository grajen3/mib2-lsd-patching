/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carparkingsystem;

public class PDCManeuverAssist {
    public boolean braking;
    public boolean steering;

    public PDCManeuverAssist() {
        this.braking = false;
        this.steering = false;
    }

    public PDCManeuverAssist(boolean bl, boolean bl2) {
        this.braking = bl;
        this.steering = bl2;
    }

    public boolean isBraking() {
        return this.braking;
    }

    public boolean isSteering() {
        return this.steering;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("PDCManeuverAssist");
        stringBuffer.append('(');
        stringBuffer.append("braking");
        stringBuffer.append('=');
        stringBuffer.append(this.braking);
        stringBuffer.append(',');
        stringBuffer.append("steering");
        stringBuffer.append('=');
        stringBuffer.append(this.steering);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

