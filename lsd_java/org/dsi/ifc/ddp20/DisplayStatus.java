/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.ddp20;

import org.dsi.ifc.ddp20.FrameInfo;

public class DisplayStatus {
    public int contextID;
    public int reason;
    public int numVisible;
    public FrameInfo[] frameInfo;

    public DisplayStatus() {
        this.contextID = 0;
        this.reason = 0;
        this.numVisible = 0;
        this.frameInfo = null;
    }

    public DisplayStatus(int n, int n2, int n3, FrameInfo[] frameInfoArray) {
        this.contextID = n;
        this.reason = n2;
        this.numVisible = n3;
        this.frameInfo = frameInfoArray;
    }

    public int getContextID() {
        return this.contextID;
    }

    public int getReason() {
        return this.reason;
    }

    public int getNumVisible() {
        return this.numVisible;
    }

    public FrameInfo[] getFrameInfo() {
        return this.frameInfo;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("DisplayStatus");
        stringBuffer.append('(');
        stringBuffer.append("contextID");
        stringBuffer.append('=');
        stringBuffer.append(this.contextID);
        stringBuffer.append(',');
        stringBuffer.append("reason");
        stringBuffer.append('=');
        stringBuffer.append(this.reason);
        stringBuffer.append(',');
        stringBuffer.append("numVisible");
        stringBuffer.append('=');
        stringBuffer.append(this.numVisible);
        stringBuffer.append(',');
        stringBuffer.append("frameInfo");
        stringBuffer.append('[');
        if (this.frameInfo != null) {
            stringBuffer.append(this.frameInfo.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.frameInfo != null) {
            int n = this.frameInfo.length;
            int n2 = n - 1;
            for (int i2 = 0; i2 < n; ++i2) {
                stringBuffer.append(this.frameInfo[i2]);
                if (i2 >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.frameInfo);
        }
        stringBuffer.append('}');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

