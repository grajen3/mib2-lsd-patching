/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.browser;

import org.dsi.ifc.global.DateTime;

public class HistoryEntry {
    public DateTime time;
    public String url;

    public HistoryEntry(DateTime dateTime, String string) {
        this.time = dateTime;
        this.url = string;
    }

    public HistoryEntry() {
        this.time = null;
        this.url = null;
    }

    public DateTime getTime() {
        return this.time;
    }

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1100);
        stringBuffer.append("HistoryEntry");
        stringBuffer.append('(');
        stringBuffer.append("time");
        stringBuffer.append('=');
        stringBuffer.append(this.time);
        stringBuffer.append(',');
        stringBuffer.append("url");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.url);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

