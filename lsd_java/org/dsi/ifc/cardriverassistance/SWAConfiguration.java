/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.cardriverassistance;

public class SWAConfiguration {
    public int system;

    public SWAConfiguration() {
        this.system = 0;
    }

    public SWAConfiguration(int n) {
        this.system = n;
    }

    public int getSystem() {
        return this.system;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(50);
        stringBuffer.append("SWAConfiguration");
        stringBuffer.append('(');
        stringBuffer.append("system");
        stringBuffer.append('=');
        stringBuffer.append(this.system);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

