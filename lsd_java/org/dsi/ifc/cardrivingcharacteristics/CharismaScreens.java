/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.cardrivingcharacteristics;

public class CharismaScreens {
    public boolean profiledcc;
    public boolean profile;
    public boolean dcc;
    public boolean airSuspension;
    public boolean hybrid;
    public boolean offroad;

    public CharismaScreens() {
        this.profiledcc = false;
        this.profile = false;
        this.dcc = false;
        this.airSuspension = false;
        this.hybrid = false;
        this.offroad = false;
    }

    public CharismaScreens(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6) {
        this.profiledcc = bl;
        this.profile = bl2;
        this.dcc = bl3;
        this.airSuspension = bl4;
        this.hybrid = bl5;
        this.offroad = bl6;
    }

    public boolean isProfiledcc() {
        return this.profiledcc;
    }

    public boolean isProfile() {
        return this.profile;
    }

    public boolean isDcc() {
        return this.dcc;
    }

    public boolean isAirSuspension() {
        return this.airSuspension;
    }

    public boolean isHybrid() {
        return this.hybrid;
    }

    public boolean isOffroad() {
        return this.offroad;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(250);
        stringBuffer.append("CharismaScreens");
        stringBuffer.append('(');
        stringBuffer.append("profiledcc");
        stringBuffer.append('=');
        stringBuffer.append(this.profiledcc);
        stringBuffer.append(',');
        stringBuffer.append("profile");
        stringBuffer.append('=');
        stringBuffer.append(this.profile);
        stringBuffer.append(',');
        stringBuffer.append("dcc");
        stringBuffer.append('=');
        stringBuffer.append(this.dcc);
        stringBuffer.append(',');
        stringBuffer.append("airSuspension");
        stringBuffer.append('=');
        stringBuffer.append(this.airSuspension);
        stringBuffer.append(',');
        stringBuffer.append("hybrid");
        stringBuffer.append('=');
        stringBuffer.append(this.hybrid);
        stringBuffer.append(',');
        stringBuffer.append("offroad");
        stringBuffer.append('=');
        stringBuffer.append(this.offroad);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

