/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navigation;

public class LIExtData {
    public int type;
    public String data;

    public LIExtData() {
        this.type = 0;
        this.data = null;
    }

    public LIExtData(int n, String string) {
        this.type = n;
        this.data = string;
    }

    public int getType() {
        return this.type;
    }

    public String getData() {
        return this.data;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("LIExtData");
        stringBuffer.append('(');
        stringBuffer.append("type");
        stringBuffer.append('=');
        stringBuffer.append(this.type);
        stringBuffer.append(',');
        stringBuffer.append("data");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.data);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

