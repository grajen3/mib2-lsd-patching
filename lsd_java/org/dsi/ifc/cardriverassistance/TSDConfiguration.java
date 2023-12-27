/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.cardriverassistance;

public class TSDConfiguration {
    public int type;

    public TSDConfiguration() {
        this.type = 0;
    }

    public TSDConfiguration(int n) {
        this.type = n;
    }

    public int getType() {
        return this.type;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(50);
        stringBuffer.append("TSDConfiguration");
        stringBuffer.append('(');
        stringBuffer.append("type");
        stringBuffer.append('=');
        stringBuffer.append(this.type);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

