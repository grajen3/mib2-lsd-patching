/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carparkingsystem;

public class PDCManeuverAssistState {
    public boolean activity;
    public boolean steeringIntervention;
    public boolean brakingIntervention;
    public boolean availability;

    public PDCManeuverAssistState() {
        this.activity = false;
        this.steeringIntervention = false;
        this.brakingIntervention = false;
        this.availability = false;
    }

    public PDCManeuverAssistState(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        this.activity = bl;
        this.steeringIntervention = bl2;
        this.brakingIntervention = bl3;
        this.availability = bl4;
    }

    public boolean isActivity() {
        return this.activity;
    }

    public boolean isSteeringIntervention() {
        return this.steeringIntervention;
    }

    public boolean isBrakingIntervention() {
        return this.brakingIntervention;
    }

    public boolean isAvailability() {
        return this.availability;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("PDCManeuverAssistState");
        stringBuffer.append('(');
        stringBuffer.append("activity");
        stringBuffer.append('=');
        stringBuffer.append(this.activity);
        stringBuffer.append(',');
        stringBuffer.append("steeringIntervention");
        stringBuffer.append('=');
        stringBuffer.append(this.steeringIntervention);
        stringBuffer.append(',');
        stringBuffer.append("brakingIntervention");
        stringBuffer.append('=');
        stringBuffer.append(this.brakingIntervention);
        stringBuffer.append(',');
        stringBuffer.append("availability");
        stringBuffer.append('=');
        stringBuffer.append(this.availability);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

