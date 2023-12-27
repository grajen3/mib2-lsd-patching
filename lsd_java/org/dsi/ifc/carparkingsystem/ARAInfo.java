/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carparkingsystem;

public class ARAInfo {
    public int message;
    public boolean automaticSteering;
    public boolean deactivationProhibited;

    public ARAInfo() {
        this.message = 0;
        this.automaticSteering = false;
        this.deactivationProhibited = false;
    }

    public ARAInfo(int n, boolean bl, boolean bl2) {
        this.message = n;
        this.automaticSteering = bl;
        this.deactivationProhibited = bl2;
    }

    public int getMessage() {
        return this.message;
    }

    public boolean isAutomaticSteering() {
        return this.automaticSteering;
    }

    public boolean isDeactivationProhibited() {
        return this.deactivationProhibited;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("ARAInfo");
        stringBuffer.append('(');
        stringBuffer.append("message");
        stringBuffer.append('=');
        stringBuffer.append(this.message);
        stringBuffer.append(',');
        stringBuffer.append("automaticSteering");
        stringBuffer.append('=');
        stringBuffer.append(this.automaticSteering);
        stringBuffer.append(',');
        stringBuffer.append("deactivationProhibited");
        stringBuffer.append('=');
        stringBuffer.append(this.deactivationProhibited);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

