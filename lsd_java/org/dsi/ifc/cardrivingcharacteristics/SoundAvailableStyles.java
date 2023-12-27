/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.cardrivingcharacteristics;

public class SoundAvailableStyles {
    public boolean style1;
    public boolean style2;
    public boolean style3;
    public boolean style4;
    public boolean style5;
    public boolean style6;
    public boolean style7;
    public boolean style8;

    public SoundAvailableStyles() {
        this.style1 = false;
        this.style2 = false;
        this.style3 = false;
        this.style4 = false;
        this.style5 = false;
        this.style6 = false;
        this.style7 = false;
        this.style8 = false;
    }

    public SoundAvailableStyles(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, boolean bl8) {
        this.style1 = bl;
        this.style2 = bl2;
        this.style3 = bl3;
        this.style4 = bl4;
        this.style5 = bl5;
        this.style6 = bl6;
        this.style7 = bl7;
        this.style8 = bl8;
    }

    public boolean isStyle1() {
        return this.style1;
    }

    public boolean isStyle2() {
        return this.style2;
    }

    public boolean isStyle3() {
        return this.style3;
    }

    public boolean isStyle4() {
        return this.style4;
    }

    public boolean isStyle5() {
        return this.style5;
    }

    public boolean isStyle6() {
        return this.style6;
    }

    public boolean isStyle7() {
        return this.style7;
    }

    public boolean isStyle8() {
        return this.style8;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(300);
        stringBuffer.append("SoundAvailableStyles");
        stringBuffer.append('(');
        stringBuffer.append("style1");
        stringBuffer.append('=');
        stringBuffer.append(this.style1);
        stringBuffer.append(',');
        stringBuffer.append("style2");
        stringBuffer.append('=');
        stringBuffer.append(this.style2);
        stringBuffer.append(',');
        stringBuffer.append("style3");
        stringBuffer.append('=');
        stringBuffer.append(this.style3);
        stringBuffer.append(',');
        stringBuffer.append("style4");
        stringBuffer.append('=');
        stringBuffer.append(this.style4);
        stringBuffer.append(',');
        stringBuffer.append("style5");
        stringBuffer.append('=');
        stringBuffer.append(this.style5);
        stringBuffer.append(',');
        stringBuffer.append("style6");
        stringBuffer.append('=');
        stringBuffer.append(this.style6);
        stringBuffer.append(',');
        stringBuffer.append("style7");
        stringBuffer.append('=');
        stringBuffer.append(this.style7);
        stringBuffer.append(',');
        stringBuffer.append("style8");
        stringBuffer.append('=');
        stringBuffer.append(this.style8);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

