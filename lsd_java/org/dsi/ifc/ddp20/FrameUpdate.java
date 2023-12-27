/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.ddp20;

public class FrameUpdate {
    public int frameID;
    public int offset;

    public FrameUpdate() {
        this.frameID = 0;
        this.offset = 0;
    }

    public FrameUpdate(int n, int n2) {
        this.frameID = n;
        this.offset = n2;
    }

    public int getFrameID() {
        return this.frameID;
    }

    public int getOffset() {
        return this.offset;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("FrameUpdate");
        stringBuffer.append('(');
        stringBuffer.append("frameID");
        stringBuffer.append('=');
        stringBuffer.append(this.frameID);
        stringBuffer.append(',');
        stringBuffer.append("offset");
        stringBuffer.append('=');
        stringBuffer.append(this.offset);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

