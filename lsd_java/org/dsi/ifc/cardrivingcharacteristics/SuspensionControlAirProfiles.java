/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.cardrivingcharacteristics;

public class SuspensionControlAirProfiles {
    public boolean profile1;
    public boolean profile2;
    public boolean profile3;
    public boolean profile4;
    public boolean profile5;
    public boolean profile6;
    public boolean profile7;

    public SuspensionControlAirProfiles() {
        this.profile1 = false;
        this.profile2 = false;
        this.profile3 = false;
        this.profile4 = false;
        this.profile5 = false;
        this.profile6 = false;
        this.profile7 = false;
    }

    public SuspensionControlAirProfiles(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7) {
        this.profile1 = bl;
        this.profile2 = bl2;
        this.profile3 = bl3;
        this.profile4 = bl4;
        this.profile5 = bl5;
        this.profile6 = bl6;
        this.profile7 = bl7;
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

    public boolean isProfile5() {
        return this.profile5;
    }

    public boolean isProfile6() {
        return this.profile6;
    }

    public boolean isProfile7() {
        return this.profile7;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(300);
        stringBuffer.append("SuspensionControlAirProfiles");
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
        stringBuffer.append(',');
        stringBuffer.append("profile5");
        stringBuffer.append('=');
        stringBuffer.append(this.profile5);
        stringBuffer.append(',');
        stringBuffer.append("profile6");
        stringBuffer.append('=');
        stringBuffer.append(this.profile6);
        stringBuffer.append(',');
        stringBuffer.append("profile7");
        stringBuffer.append('=');
        stringBuffer.append(this.profile7);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

