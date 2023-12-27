/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.networking;

import org.dsi.ifc.global.DateTime;

public class CPacketCounter {
    public int connectionDuration;
    public long rxBytes;
    public long rxBytesSinceReset;
    public long txBytes;
    public long txBytesSinceReset;
    public DateTime lastResetDate;

    public CPacketCounter() {
        this.connectionDuration = 0;
        this.rxBytes = 0L;
        this.rxBytesSinceReset = 0L;
        this.txBytes = 0L;
        this.txBytesSinceReset = 0L;
        this.lastResetDate = null;
    }

    public CPacketCounter(int n, long l, long l2, long l3, long l4, DateTime dateTime) {
        this.connectionDuration = n;
        this.rxBytes = l;
        this.rxBytesSinceReset = l2;
        this.txBytes = l3;
        this.txBytesSinceReset = l4;
        this.lastResetDate = dateTime;
    }

    public int getConnectionDuration() {
        return this.connectionDuration;
    }

    public long getRxBytes() {
        return this.rxBytes;
    }

    public long getRxBytesSinceReset() {
        return this.rxBytesSinceReset;
    }

    public long getTxBytes() {
        return this.txBytes;
    }

    public long getTxBytesSinceReset() {
        return this.txBytesSinceReset;
    }

    public DateTime getLastResetDate() {
        return this.lastResetDate;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1450);
        stringBuffer.append("CPacketCounter");
        stringBuffer.append('(');
        stringBuffer.append("connectionDuration");
        stringBuffer.append('=');
        stringBuffer.append(this.connectionDuration);
        stringBuffer.append(',');
        stringBuffer.append("rxBytes");
        stringBuffer.append('=');
        stringBuffer.append(this.rxBytes);
        stringBuffer.append(',');
        stringBuffer.append("rxBytesSinceReset");
        stringBuffer.append('=');
        stringBuffer.append(this.rxBytesSinceReset);
        stringBuffer.append(',');
        stringBuffer.append("txBytes");
        stringBuffer.append('=');
        stringBuffer.append(this.txBytes);
        stringBuffer.append(',');
        stringBuffer.append("txBytesSinceReset");
        stringBuffer.append('=');
        stringBuffer.append(this.txBytesSinceReset);
        stringBuffer.append(',');
        stringBuffer.append("lastResetDate");
        stringBuffer.append('=');
        stringBuffer.append(this.lastResetDate);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

