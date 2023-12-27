/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.ddp20;

public class FrameRequest {
    public int frameID;
    public int request;

    public FrameRequest() {
        this.frameID = 0;
        this.request = 0;
    }

    public FrameRequest(int n, int n2) {
        this.frameID = n;
        this.request = n2;
    }

    public int getFrameID() {
        return this.frameID;
    }

    public int getRequest() {
        return this.request;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("FrameRequest");
        stringBuffer.append('(');
        stringBuffer.append("frameID");
        stringBuffer.append('=');
        stringBuffer.append(this.frameID);
        stringBuffer.append(',');
        stringBuffer.append("request");
        stringBuffer.append('=');
        stringBuffer.append(this.request);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

