/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.kombifastlist;

public class DataReceptionList {
    public long pos;
    public int elementType;
    public int type;
    public long attributes;
    public int presetID;
    public int fmREGCode;
    public int category;
    public String nameReceptionList;
    public String frequency;

    public DataReceptionList() {
        this.pos = 0L;
        this.elementType = 0;
        this.type = 0;
        this.attributes = 0L;
        this.presetID = 0;
        this.fmREGCode = 0;
        this.category = 0;
        this.nameReceptionList = "";
        this.frequency = "";
    }

    public DataReceptionList(long l, int n, int n2, long l2, int n3, int n4, int n5, String string, String string2) {
        this.pos = l;
        this.elementType = n;
        this.type = n2;
        this.attributes = l2;
        this.presetID = n3;
        this.fmREGCode = n4;
        this.category = n5;
        this.nameReceptionList = string;
        this.frequency = string2;
    }

    public long getPos() {
        return this.pos;
    }

    public int getElementType() {
        return this.elementType;
    }

    public int getType() {
        return this.type;
    }

    public long getAttributes() {
        return this.attributes;
    }

    public int getPresetID() {
        return this.presetID;
    }

    public int getFmREGCode() {
        return this.fmREGCode;
    }

    public int getCategory() {
        return this.category;
    }

    public String getNameReceptionList() {
        return this.nameReceptionList;
    }

    public String getFrequency() {
        return this.frequency;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(550);
        stringBuffer.append("DataReceptionList");
        stringBuffer.append('(');
        stringBuffer.append("pos");
        stringBuffer.append('=');
        stringBuffer.append(this.pos);
        stringBuffer.append(',');
        stringBuffer.append("elementType");
        stringBuffer.append('=');
        stringBuffer.append(this.elementType);
        stringBuffer.append(',');
        stringBuffer.append("type");
        stringBuffer.append('=');
        stringBuffer.append(this.type);
        stringBuffer.append(',');
        stringBuffer.append("attributes");
        stringBuffer.append('=');
        stringBuffer.append(this.attributes);
        stringBuffer.append(',');
        stringBuffer.append("presetID");
        stringBuffer.append('=');
        stringBuffer.append(this.presetID);
        stringBuffer.append(',');
        stringBuffer.append("fmREGCode");
        stringBuffer.append('=');
        stringBuffer.append(this.fmREGCode);
        stringBuffer.append(',');
        stringBuffer.append("category");
        stringBuffer.append('=');
        stringBuffer.append(this.category);
        stringBuffer.append(',');
        stringBuffer.append("nameReceptionList");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.nameReceptionList);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("frequency");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.frequency);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

