/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.travelguide;

import org.dsi.ifc.global.ResourceLocator;

public class TravelGuideMemoryListElement {
    public long uID;
    public ResourceLocator icon;
    public String title;
    public int status;
    public int progress;

    public TravelGuideMemoryListElement() {
        this.uID = 0L;
        this.icon = null;
        this.title = "";
        this.status = 0;
        this.progress = 0;
    }

    public TravelGuideMemoryListElement(long l, ResourceLocator resourceLocator, String string, int n, int n2) {
        this.uID = l;
        this.icon = resourceLocator;
        this.title = string;
        this.status = n;
        this.progress = n2;
    }

    public long getUID() {
        return this.uID;
    }

    public ResourceLocator getIcon() {
        return this.icon;
    }

    public String getTitle() {
        return this.title;
    }

    public int getStatus() {
        return this.status;
    }

    public int getProgress() {
        return this.progress;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1250);
        stringBuffer.append("TravelGuideMemoryListElement");
        stringBuffer.append('(');
        stringBuffer.append("uID");
        stringBuffer.append('=');
        stringBuffer.append(this.uID);
        stringBuffer.append(',');
        stringBuffer.append("icon");
        stringBuffer.append('=');
        stringBuffer.append(this.icon);
        stringBuffer.append(',');
        stringBuffer.append("title");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.title);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("status");
        stringBuffer.append('=');
        stringBuffer.append(this.status);
        stringBuffer.append(',');
        stringBuffer.append("progress");
        stringBuffer.append('=');
        stringBuffer.append(this.progress);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

