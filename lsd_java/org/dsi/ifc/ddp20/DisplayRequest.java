/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.ddp20;

import org.dsi.ifc.ddp20.FrameRequest;

public class DisplayRequest {
    public int numFrames;
    public FrameRequest[] frameRequest;

    public DisplayRequest() {
        this.numFrames = 0;
        this.frameRequest = null;
    }

    public DisplayRequest(int n, FrameRequest[] frameRequestArray) {
        this.numFrames = n;
        this.frameRequest = frameRequestArray;
    }

    public int getNumFrames() {
        return this.numFrames;
    }

    public FrameRequest[] getFrameRequest() {
        return this.frameRequest;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("DisplayRequest");
        stringBuffer.append('(');
        stringBuffer.append("numFrames");
        stringBuffer.append('=');
        stringBuffer.append(this.numFrames);
        stringBuffer.append(',');
        stringBuffer.append("frameRequest");
        stringBuffer.append('[');
        if (this.frameRequest != null) {
            stringBuffer.append(this.frameRequest.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.frameRequest != null) {
            int n = this.frameRequest.length;
            int n2 = n - 1;
            for (int i2 = 0; i2 < n; ++i2) {
                stringBuffer.append(this.frameRequest[i2]);
                if (i2 >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.frameRequest);
        }
        stringBuffer.append('}');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

