/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.travellink;

import org.dsi.ifc.travellink.Values;

public class GenericPropertyContainer {
    public int[] keys;
    public Values[] values;

    public GenericPropertyContainer() {
        this.keys = new int[0];
        this.values = new Values[0];
    }

    public GenericPropertyContainer(int[] nArray, Values[] valuesArray) {
        this.keys = nArray;
        this.values = valuesArray;
    }

    public int[] getKeys() {
        return this.keys;
    }

    public Values[] getValues() {
        return this.values;
    }

    public String toString() {
        int n;
        int n2;
        int n3;
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("GenericPropertyContainer");
        stringBuffer.append('(');
        stringBuffer.append("keys");
        stringBuffer.append('[');
        if (this.keys != null) {
            stringBuffer.append(this.keys.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.keys != null) {
            n3 = this.keys.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append(this.keys[n]);
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.keys);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("values");
        stringBuffer.append('[');
        if (this.values != null) {
            stringBuffer.append(this.values.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.values != null) {
            n3 = this.values.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append(this.values[n]);
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.values);
        }
        stringBuffer.append('}');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

