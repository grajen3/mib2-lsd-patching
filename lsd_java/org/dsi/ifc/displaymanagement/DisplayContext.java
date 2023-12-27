/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.displaymanagement;

public class DisplayContext {
    public int id;
    public int[] displayableList;

    public DisplayContext() {
        this.id = 0;
        this.displayableList = null;
    }

    public DisplayContext(int n, int[] nArray) {
        this.id = n;
        this.displayableList = nArray;
    }

    public int getId() {
        return this.id;
    }

    public int[] getDisplayableList() {
        return this.displayableList;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("DisplayContext");
        stringBuffer.append('(');
        stringBuffer.append("id");
        stringBuffer.append('=');
        stringBuffer.append(this.id);
        stringBuffer.append(',');
        stringBuffer.append("displayableList");
        stringBuffer.append('[');
        if (this.displayableList != null) {
            stringBuffer.append(this.displayableList.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.displayableList != null) {
            int n = this.displayableList.length;
            int n2 = n - 1;
            for (int i2 = 0; i2 < n; ++i2) {
                stringBuffer.append(this.displayableList[i2]);
                if (i2 >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.displayableList);
        }
        stringBuffer.append('}');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

