/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.kombifastlist;

public class DataCommonList {
    public long pos;
    public int sourceType;
    public long attributes;
    public int presetID;
    public int category;
    public String name;
    public String frequency;

    public DataCommonList() {
        this.pos = 0L;
        this.sourceType = 0;
        this.attributes = 0L;
        this.presetID = 0;
        this.category = 0;
        this.name = "";
        this.frequency = "";
    }

    public DataCommonList(long l, int n, long l2, int n2, int n3, String string, String string2) {
        this.pos = l;
        this.sourceType = n;
        this.attributes = l2;
        this.presetID = n2;
        this.category = n3;
        this.name = string;
        this.frequency = string2;
    }

    public long getPos() {
        return this.pos;
    }

    public int getSourceType() {
        return this.sourceType;
    }

    public long getAttributes() {
        return this.attributes;
    }

    public int getPresetID() {
        return this.presetID;
    }

    public int getCategory() {
        return this.category;
    }

    public String getName() {
        return this.name;
    }

    public String getFrequency() {
        return this.frequency;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(450);
        stringBuffer.append("DataCommonList");
        stringBuffer.append('(');
        stringBuffer.append("pos");
        stringBuffer.append('=');
        stringBuffer.append(this.pos);
        stringBuffer.append(',');
        stringBuffer.append("sourceType");
        stringBuffer.append('=');
        stringBuffer.append(this.sourceType);
        stringBuffer.append(',');
        stringBuffer.append("attributes");
        stringBuffer.append('=');
        stringBuffer.append(this.attributes);
        stringBuffer.append(',');
        stringBuffer.append("presetID");
        stringBuffer.append('=');
        stringBuffer.append(this.presetID);
        stringBuffer.append(',');
        stringBuffer.append("category");
        stringBuffer.append('=');
        stringBuffer.append(this.category);
        stringBuffer.append(',');
        stringBuffer.append("name");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.name);
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

