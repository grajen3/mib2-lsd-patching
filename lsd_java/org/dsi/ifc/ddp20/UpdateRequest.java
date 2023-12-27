/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.ddp20;

import org.dsi.ifc.ddp20.FrameUpdate;

public class UpdateRequest {
    public int numFrames;
    public FrameUpdate[] frameUpdate;

    public UpdateRequest() {
        this.numFrames = 0;
        this.frameUpdate = null;
    }

    public UpdateRequest(int n, FrameUpdate[] frameUpdateArray) {
        this.numFrames = n;
        this.frameUpdate = frameUpdateArray;
    }

    public int getNumFrames() {
        return this.numFrames;
    }

    public FrameUpdate[] getFrameUpdate() {
        return this.frameUpdate;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("UpdateRequest");
        stringBuffer.append('(');
        stringBuffer.append("numFrames");
        stringBuffer.append('=');
        stringBuffer.append(this.numFrames);
        stringBuffer.append(',');
        stringBuffer.append("frameUpdate");
        stringBuffer.append('[');
        if (this.frameUpdate != null) {
            stringBuffer.append(this.frameUpdate.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.frameUpdate != null) {
            int n = this.frameUpdate.length;
            int n2 = n - 1;
            for (int i2 = 0; i2 < n; ++i2) {
                stringBuffer.append(this.frameUpdate[i2]);
                if (i2 >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.frameUpdate);
        }
        stringBuffer.append('}');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

