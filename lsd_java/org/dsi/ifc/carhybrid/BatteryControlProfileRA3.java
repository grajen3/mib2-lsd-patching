/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carhybrid;

public class BatteryControlProfileRA3 {
    public int pos;
    public String name;

    public BatteryControlProfileRA3() {
        this.pos = 0;
        this.name = null;
    }

    public BatteryControlProfileRA3(int n, String string) {
        this.pos = n;
        this.name = string;
    }

    public int getPos() {
        return this.pos;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("BatteryControlProfileRA3");
        stringBuffer.append('(');
        stringBuffer.append("pos");
        stringBuffer.append('=');
        stringBuffer.append(this.pos);
        stringBuffer.append(',');
        stringBuffer.append("name");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.name);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

