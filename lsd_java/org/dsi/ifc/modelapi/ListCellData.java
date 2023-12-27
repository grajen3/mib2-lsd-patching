/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.modelapi;

public class ListCellData {
    public long longListCellData;
    public String textListCellData;

    public ListCellData() {
        this.longListCellData = 0L;
        this.textListCellData = null;
    }

    public ListCellData(long l, String string) {
        this.longListCellData = l;
        this.textListCellData = string;
    }

    public long getLongListCellData() {
        return this.longListCellData;
    }

    public String getTextListCellData() {
        return this.textListCellData;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("ListCellData");
        stringBuffer.append('(');
        stringBuffer.append("longListCellData");
        stringBuffer.append('=');
        stringBuffer.append(this.longListCellData);
        stringBuffer.append(',');
        stringBuffer.append("textListCellData");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.textListCellData);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

