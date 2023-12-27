/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.cartimeunitslanguage;

public class UTCOffset {
    public int offset;
    public boolean algebraicSign;
    public byte state;

    public UTCOffset() {
        this.offset = -1;
        this.algebraicSign = false;
        this.state = 0;
    }

    public UTCOffset(int n, boolean bl, byte by) {
        this.offset = n;
        this.algebraicSign = bl;
        this.state = by;
    }

    public int getOffset() {
        return this.offset;
    }

    public boolean isAlgebraicSign() {
        return this.algebraicSign;
    }

    public byte getState() {
        return this.state;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("UTCOffset");
        stringBuffer.append('(');
        stringBuffer.append("offset");
        stringBuffer.append('=');
        stringBuffer.append(this.offset);
        stringBuffer.append(',');
        stringBuffer.append("algebraicSign");
        stringBuffer.append('=');
        stringBuffer.append(this.algebraicSign);
        stringBuffer.append(',');
        stringBuffer.append("state");
        stringBuffer.append('=');
        stringBuffer.append(this.state);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

