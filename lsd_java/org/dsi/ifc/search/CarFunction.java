/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.search;

public class CarFunction {
    public int id;
    public boolean enabled;

    public CarFunction() {
        this.id = -1;
        this.enabled = false;
    }

    public CarFunction(int n, boolean bl) {
        this.id = n;
        this.enabled = bl;
    }

    public int getId() {
        return this.id;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("CarFunction");
        stringBuffer.append('(');
        stringBuffer.append("id");
        stringBuffer.append('=');
        stringBuffer.append(this.id);
        stringBuffer.append(',');
        stringBuffer.append("enabled");
        stringBuffer.append('=');
        stringBuffer.append(this.enabled);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

