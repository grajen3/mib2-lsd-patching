/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carcomfort;

public class DoorLockingUserProfileOnOff {
    public boolean handling;
    public boolean autoKeyAssignment;
    public boolean temporaryKeyAssignment;
    public boolean atneInMotion;

    public DoorLockingUserProfileOnOff() {
        this.handling = false;
        this.autoKeyAssignment = false;
        this.temporaryKeyAssignment = false;
        this.atneInMotion = false;
    }

    public DoorLockingUserProfileOnOff(boolean bl, boolean bl2, boolean bl3) {
        this.handling = bl;
        this.autoKeyAssignment = bl2;
        this.temporaryKeyAssignment = bl3;
        this.atneInMotion = false;
    }

    public DoorLockingUserProfileOnOff(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        this.handling = bl;
        this.autoKeyAssignment = bl2;
        this.temporaryKeyAssignment = bl3;
        this.atneInMotion = bl4;
    }

    public boolean isHandling() {
        return this.handling;
    }

    public boolean isAutoKeyAssignment() {
        return this.autoKeyAssignment;
    }

    public boolean isTemporaryKeyAssignment() {
        return this.temporaryKeyAssignment;
    }

    public boolean isAtneInMotion() {
        return this.atneInMotion;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("DoorLockingUserProfileOnOff");
        stringBuffer.append('(');
        stringBuffer.append("handling");
        stringBuffer.append('=');
        stringBuffer.append(this.handling);
        stringBuffer.append(',');
        stringBuffer.append("autoKeyAssignment");
        stringBuffer.append('=');
        stringBuffer.append(this.autoKeyAssignment);
        stringBuffer.append(',');
        stringBuffer.append("temporaryKeyAssignment");
        stringBuffer.append('=');
        stringBuffer.append(this.temporaryKeyAssignment);
        stringBuffer.append(',');
        stringBuffer.append("atneInMotion");
        stringBuffer.append('=');
        stringBuffer.append(this.atneInMotion);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

