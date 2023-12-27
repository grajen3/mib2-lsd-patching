/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.global;

public class DateTime {
    public long time;

    public DateTime() {
        this(System.currentTimeMillis());
    }

    public DateTime(long l) {
        this.time = l;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long l) {
        this.time = l;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("DateTime");
        stringBuffer.append('(');
        stringBuffer.append("time");
        stringBuffer.append('=');
        stringBuffer.append(this.time);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

