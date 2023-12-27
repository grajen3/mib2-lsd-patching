/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.cardrivingcharacteristics;

public class SuspensionControlDRCProfiles {
    public boolean profile1;
    public boolean profile2;
    public boolean profile3;
    public boolean profile4;

    public SuspensionControlDRCProfiles() {
        this.profile1 = false;
        this.profile2 = false;
        this.profile3 = false;
        this.profile4 = false;
    }

    public SuspensionControlDRCProfiles(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        this.profile1 = bl;
        this.profile2 = bl2;
        this.profile3 = bl3;
        this.profile4 = bl4;
    }

    public boolean isProfile1() {
        return this.profile1;
    }

    public boolean isProfile2() {
        return this.profile2;
    }

    public boolean isProfile3() {
        return this.profile3;
    }

    public boolean isProfile4() {
        return this.profile4;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("SuspensionControlDRCProfiles");
        stringBuffer.append('(');
        stringBuffer.append("profile1");
        stringBuffer.append('=');
        stringBuffer.append(this.profile1);
        stringBuffer.append(',');
        stringBuffer.append("profile2");
        stringBuffer.append('=');
        stringBuffer.append(this.profile2);
        stringBuffer.append(',');
        stringBuffer.append("profile3");
        stringBuffer.append('=');
        stringBuffer.append(this.profile3);
        stringBuffer.append(',');
        stringBuffer.append("profile4");
        stringBuffer.append('=');
        stringBuffer.append(this.profile4);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

