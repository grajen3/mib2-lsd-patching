/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.careco;

public class RangeDataConfiguration {
    public int primaryEngineType;
    public int secondaryEngineType;

    public RangeDataConfiguration() {
        this.primaryEngineType = 0;
        this.secondaryEngineType = 0;
    }

    public RangeDataConfiguration(int n, int n2) {
        this.primaryEngineType = n;
        this.secondaryEngineType = n2;
    }

    public int getPrimaryEngineType() {
        return this.primaryEngineType;
    }

    public int getSecondaryEngineType() {
        return this.secondaryEngineType;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("RangeDataConfiguration");
        stringBuffer.append('(');
        stringBuffer.append("primaryEngineType");
        stringBuffer.append('=');
        stringBuffer.append(this.primaryEngineType);
        stringBuffer.append(',');
        stringBuffer.append("secondaryEngineType");
        stringBuffer.append('=');
        stringBuffer.append(this.secondaryEngineType);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

