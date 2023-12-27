/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.cartimeunitslanguage;

import org.dsi.ifc.cartimeunitslanguage.ClockDate;
import org.dsi.ifc.cartimeunitslanguage.ClockTime;

public class ClockGPSSyncData {
    public ClockTime time;
    public ClockDate date;

    public ClockGPSSyncData() {
        this.time = null;
        this.date = null;
    }

    public ClockGPSSyncData(ClockTime clockTime, ClockDate clockDate) {
        this.time = clockTime;
        this.date = clockDate;
    }

    public ClockTime getTime() {
        return this.time;
    }

    public ClockDate getDate() {
        return this.date;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(2050);
        stringBuffer.append("ClockGPSSyncData");
        stringBuffer.append('(');
        stringBuffer.append("time");
        stringBuffer.append('=');
        stringBuffer.append(this.time);
        stringBuffer.append(',');
        stringBuffer.append("date");
        stringBuffer.append('=');
        stringBuffer.append(this.date);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

