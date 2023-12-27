/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.organizer;

public class ProfileInfo {
    public int num;
    public String name;
    public long homeId;
    public String pairingCode;
    public boolean publicProfileVisibility;

    public ProfileInfo() {
        this.num = 0;
        this.name = null;
        this.homeId = 0L;
        this.pairingCode = null;
        this.publicProfileVisibility = false;
    }

    public ProfileInfo(int n, String string, long l, String string2, boolean bl) {
        this.num = n;
        this.name = string;
        this.homeId = l;
        this.pairingCode = string2;
        this.publicProfileVisibility = bl;
    }

    public int getNum() {
        return this.num;
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

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(350);
        stringBuffer.append("ProfileInfo");
        stringBuffer.append('(');
        stringBuffer.append("num");
        stringBuffer.append('=');
        stringBuffer.append(this.num);
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

