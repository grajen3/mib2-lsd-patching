/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.radio;

public class IntellitextSubmenu {
    public String name;
    public String[] dataList;

    public IntellitextSubmenu() {
        this.name = "";
        this.dataList = null;
    }

    public IntellitextSubmenu(String string, String[] stringArray) {
        this.dataList = stringArray;
        this.name = string;
    }

    public String getName() {
        return this.name;
    }

    public String[] getDataList() {
        return this.dataList;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("IntellitextSubmenu");
        stringBuffer.append('(');
        stringBuffer.append("name");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.name);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("dataList");
        stringBuffer.append('[');
        if (this.dataList != null) {
            stringBuffer.append(this.dataList.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.dataList != null) {
            int n = this.dataList.length;
            int n2 = n - 1;
            for (int i2 = 0; i2 < n; ++i2) {
                stringBuffer.append('\"');
                stringBuffer.append(this.dataList[i2]);
                stringBuffer.append('\"');
                if (i2 >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.dataList);
        }
        stringBuffer.append('}');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

