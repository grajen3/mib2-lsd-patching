/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.calendar;

public class ProfileInfo {
    public int numProfile;
    public String name;
    public long homeId = 0L;
    public String pairingCode;
    public boolean publicProfileVisibility = false;

    public int getNumProfile() {
        return this.numProfile;
    }

    public String getName() {
        return this.name;
    }

    public long getHomeId() {
        return this.homeId;
    }

    public String getPairingCode() {
        return this.pairingCode;
    }

    public boolean isPublicProfileVisibility() {
        return this.publicProfileVisibility;
    }

    public ProfileInfo(int n, String string, long l, String string2, boolean bl) {
        this.numProfile = n;
        this.name = string;
        this.homeId = l;
        this.pairingCode = string2;
        this.publicProfileVisibility = bl;
    }

    public ProfileInfo() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(350);
        stringBuffer.append("ProfileInfo");
        stringBuffer.append('(');
        stringBuffer.append("numProfile");
        stringBuffer.append('=');
        stringBuffer.append(this.numProfile);
        stringBuffer.append(',');
        stringBuffer.append("name");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.name);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("homeId");
        stringBuffer.append('=');
        stringBuffer.append(this.homeId);
        stringBuffer.append(',');
        stringBuffer.append("pairingCode");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.pairingCode);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("publicProfileVisibility");
        stringBuffer.append('=');
        stringBuffer.append(this.publicProfileVisibility);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

