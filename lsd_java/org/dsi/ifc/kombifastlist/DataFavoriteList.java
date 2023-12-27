/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.kombifastlist;

public class DataFavoriteList {
    public int pos;
    public String pbName;
    public int numberType;
    public String telNumber;

    public DataFavoriteList() {
        this.pos = 0;
        this.pbName = "";
        this.numberType = 0;
        this.telNumber = "";
    }

    public DataFavoriteList(int n, String string, int n2, String string2) {
        this.pos = n;
        this.pbName = string;
        this.numberType = n2;
        this.telNumber = string2;
    }

    public int getPos() {
        return this.pos;
    }

    public String getPbName() {
        return this.pbName;
    }

    public String getTelNumber() {
        return this.telNumber;
    }

    public int getNumberType() {
        return this.numberType;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(250);
        stringBuffer.append("DataFavoriteList");
        stringBuffer.append('(');
        stringBuffer.append("pos");
        stringBuffer.append('=');
        stringBuffer.append(this.pos);
        stringBuffer.append(',');
        stringBuffer.append("pbName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.pbName);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("numberType");
        stringBuffer.append('=');
        stringBuffer.append(this.numberType);
        stringBuffer.append(',');
        stringBuffer.append("telNumber");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.telNumber);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

