/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.global;

public class NavSegmentID {
    public int[] elements;

    public NavSegmentID() {
        this.elements = null;
    }

    public NavSegmentID(int[] nArray) {
        this.elements = nArray;
    }

    public int[] getElements() {
        return this.elements;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(50);
        stringBuffer.append("SegmentID");
        stringBuffer.append('(');
        stringBuffer.append("elements");
        stringBuffer.append('[');
        if (this.elements != null) {
            stringBuffer.append(this.elements.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.elements != null) {
            int n = this.elements.length;
            int n2 = n - 1;
            for (int i2 = 0; i2 < n; ++i2) {
                stringBuffer.append(this.elements[i2]);
                if (i2 >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.elements);
        }
        stringBuffer.append('}');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

