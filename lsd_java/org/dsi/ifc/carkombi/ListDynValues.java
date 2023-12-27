/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carkombi;

public class ListDynValues {
    public int pos;
    public String dynValue;

    public ListDynValues() {
        this.pos = 0;
        this.dynValue = "";
    }

    public ListDynValues(int n, String string) {
        this.pos = n;
        this.dynValue = string;
    }

    public int getPos() {
        return this.pos;
    }

    public String getDynValue() {
        return this.dynValue;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("ListDynValues");
        stringBuffer.append('(');
        stringBuffer.append("pos");
        stringBuffer.append('=');
        stringBuffer.append(this.pos);
        stringBuffer.append(',');
        stringBuffer.append("dynValue");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.dynValue);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

