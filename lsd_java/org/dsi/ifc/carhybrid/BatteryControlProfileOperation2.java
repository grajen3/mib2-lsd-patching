/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carhybrid;

public class BatteryControlProfileOperation2 {
    public boolean windowHeaterFront;
    public boolean windowHeaterRear;
    public boolean parkHeater;
    public boolean parkHeaterAutomatic;

    public BatteryControlProfileOperation2() {
        this.windowHeaterFront = false;
        this.windowHeaterRear = false;
        this.parkHeater = false;
        this.parkHeaterAutomatic = false;
    }

    public BatteryControlProfileOperation2(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        this.windowHeaterFront = bl;
        this.windowHeaterRear = bl2;
        this.parkHeater = bl3;
        this.parkHeaterAutomatic = bl4;
    }

    public boolean isWindowHeaterFront() {
        return this.windowHeaterFront;
    }

    public boolean isWindowHeaterRear() {
        return this.windowHeaterRear;
    }

    public boolean isParkHeater() {
        return this.parkHeater;
    }

    public boolean isParkHeaterAutomatic() {
        return this.parkHeaterAutomatic;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(250);
        stringBuffer.append("BatteryControlProfileOperation2");
        stringBuffer.append('(');
        stringBuffer.append("windowHeaterFront");
        stringBuffer.append('=');
        stringBuffer.append(this.windowHeaterFront);
        stringBuffer.append(',');
        stringBuffer.append("windowHeaterRear");
        stringBuffer.append('=');
        stringBuffer.append(this.windowHeaterRear);
        stringBuffer.append(',');
        stringBuffer.append("parkHeater");
        stringBuffer.append('=');
        stringBuffer.append(this.parkHeater);
        stringBuffer.append(',');
        stringBuffer.append("parkHeaterAutomatic");
        stringBuffer.append('=');
        stringBuffer.append(this.parkHeaterAutomatic);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

