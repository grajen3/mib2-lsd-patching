/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.browser;

import org.dsi.ifc.global.DateTime;

public class TimePeriod {
    public DateTime from;
    public DateTime to;

    public TimePeriod(DateTime dateTime, DateTime dateTime2) {
        this.from = dateTime;
        this.to = dateTime2;
    }

    public TimePeriod() {
        this.from = null;
        this.to = null;
    }

    public DateTime getFrom() {
        return this.from;
    }

    public DateTime getTo() {
        return this.to;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(2050);
        stringBuffer.append("TimePeriod");
        stringBuffer.append('(');
        stringBuffer.append("from");
        stringBuffer.append('=');
        stringBuffer.append(this.from);
        stringBuffer.append(',');
        stringBuffer.append("to");
        stringBuffer.append('=');
        stringBuffer.append(this.to);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

