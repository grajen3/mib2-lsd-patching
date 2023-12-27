/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carcomfort;

public class RGSBeltPretensionData {
    public boolean left;
    public boolean right;

    public RGSBeltPretensionData() {
        this.left = false;
        this.right = false;
    }

    public RGSBeltPretensionData(boolean bl, boolean bl2) {
        this.left = bl;
        this.right = bl2;
    }

    public boolean isLeft() {
        return this.left;
    }

    public boolean isRight() {
        return this.right;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("RGSBeltPretensionData");
        stringBuffer.append('(');
        stringBuffer.append("left");
        stringBuffer.append('=');
        stringBuffer.append(this.left);
        stringBuffer.append(',');
        stringBuffer.append("right");
        stringBuffer.append('=');
        stringBuffer.append(this.right);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

