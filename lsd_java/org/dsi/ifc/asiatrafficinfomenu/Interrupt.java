/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.asiatrafficinfomenu;

public class Interrupt {
    public int interruptId;
    public int interruptType;
    public int[] contentID;

    public Interrupt() {
        this.interruptId = 0;
        this.interruptType = 0;
        this.contentID = null;
    }

    public Interrupt(int n, int n2, int[] nArray) {
        this.interruptId = n;
        this.interruptType = n2;
        this.contentID = nArray;
    }

    public int getInterruptId() {
        return this.interruptId;
    }

    public int getInterruptType() {
        return this.interruptType;
    }

    public int[] getContentID() {
        return this.contentID;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("Interrupt");
        stringBuffer.append('(');
        stringBuffer.append("interruptId");
        stringBuffer.append('=');
        stringBuffer.append(this.interruptId);
        stringBuffer.append(',');
        stringBuffer.append("interruptType");
        stringBuffer.append('=');
        stringBuffer.append(this.interruptType);
        stringBuffer.append(',');
        stringBuffer.append("contentID");
        stringBuffer.append('[');
        if (this.contentID != null) {
            stringBuffer.append(this.contentID.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.contentID != null) {
            int n = this.contentID.length;
            int n2 = n - 1;
            for (int i2 = 0; i2 < n; ++i2) {
                stringBuffer.append(this.contentID[i2]);
                if (i2 >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.contentID);
        }
        stringBuffer.append('}');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

