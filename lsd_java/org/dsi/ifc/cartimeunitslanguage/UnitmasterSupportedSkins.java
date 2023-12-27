/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.cartimeunitslanguage;

public class UnitmasterSupportedSkins {
    public boolean skin1;
    public boolean skin2;
    public boolean skin3;

    public UnitmasterSupportedSkins() {
        this.skin1 = false;
        this.skin2 = false;
        this.skin3 = false;
    }

    public UnitmasterSupportedSkins(boolean bl, boolean bl2, boolean bl3) {
        this.skin1 = bl;
        this.skin2 = bl2;
        this.skin3 = bl3;
    }

    public boolean isSkin1() {
        return this.skin1;
    }

    public boolean isSkin2() {
        return this.skin2;
    }

    public boolean isSkin3() {
        return this.skin3;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("UnitmasterSupportedSkins");
        stringBuffer.append('(');
        stringBuffer.append("skin1");
        stringBuffer.append('=');
        stringBuffer.append(this.skin1);
        stringBuffer.append(',');
        stringBuffer.append("skin2");
        stringBuffer.append('=');
        stringBuffer.append(this.skin2);
        stringBuffer.append(',');
        stringBuffer.append("skin3");
        stringBuffer.append('=');
        stringBuffer.append(this.skin3);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

