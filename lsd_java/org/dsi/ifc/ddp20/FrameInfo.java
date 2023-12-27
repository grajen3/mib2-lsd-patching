/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.ddp20;

public class FrameInfo {
    public int frameID;
    public int eventFocus;
    public int offset;

    public FrameInfo() {
        this.frameID = 0;
        this.eventFocus = 0;
        this.offset = 0;
    }

    public FrameInfo(int n, int n2, int n3) {
        this.frameID = n;
        this.eventFocus = n2;
        this.offset = n3;
    }

    public int getFrameID() {
        return this.frameID;
    }

    public int getEventFocus() {
        return this.eventFocus;
    }

    public int getOffset() {
        return this.offset;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("FrameInfo");
        stringBuffer.append('(');
        stringBuffer.append("frameID");
        stringBuffer.append('=');
        stringBuffer.append(this.frameID);
        stringBuffer.append(',');
        stringBuffer.append("eventFocus");
        stringBuffer.append('=');
        stringBuffer.append(this.eventFocus);
        stringBuffer.append(',');
        stringBuffer.append("offset");
        stringBuffer.append('=');
        stringBuffer.append(this.offset);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

