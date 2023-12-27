/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.modelapi;

public class ListCellDataFixFormat {
    public int typeFormat;
    public int[] values;

    public ListCellDataFixFormat() {
        this.typeFormat = 0;
        this.values = null;
    }

    public ListCellDataFixFormat(int n, int[] nArray) {
        this.typeFormat = n;
        this.values = nArray;
    }

    public int getTypeFormat() {
        return this.typeFormat;
    }

    public int[] getValues() {
        return this.values;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("ListCellDataFixFormat");
        stringBuffer.append('(');
        stringBuffer.append("typeFormat");
        stringBuffer.append('=');
        stringBuffer.append(this.typeFormat);
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
            int n = this.values.length;
            int n2 = n - 1;
            for (int i2 = 0; i2 < n; ++i2) {
                stringBuffer.append(this.values[i2]);
                if (i2 >= n2) continue;
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

