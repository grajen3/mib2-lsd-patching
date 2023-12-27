/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.cardriverassistance;

public class AWVConfiguration {
    public int systemMode;

    public AWVConfiguration() {
        this.systemMode = 0;
    }

    public AWVConfiguration(int n) {
        this.systemMode = n;
    }

    public int getSystemMode() {
        return this.systemMode;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("AWVConfiguration");
        stringBuffer.append('(');
        stringBuffer.append("systemMode");
        stringBuffer.append('=');
        stringBuffer.append(this.systemMode);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

