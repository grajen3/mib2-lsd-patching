/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.messaging;

public class ExtractedItem {
    public int type;
    public String value;
    public int offset;
    public int length;

    public ExtractedItem() {
        this.type = -1;
        this.value = "";
        this.offset = -1;
        this.length = 0;
    }

    public ExtractedItem(int n, String string, int n2, int n3) {
        this.type = n;
        this.value = string;
        this.offset = n2;
        this.length = n3;
    }

    public int getType() {
        return this.type;
    }

    public String getValue() {
        return this.value;
    }

    public int getOffset() {
        return this.offset;
    }

    public int getLength() {
        return this.length;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("ExtractedItem");
        stringBuffer.append('(');
        stringBuffer.append("type");
        stringBuffer.append('=');
        stringBuffer.append(this.type);
        stringBuffer.append(',');
        stringBuffer.append("value");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.value);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("offset");
        stringBuffer.append('=');
        stringBuffer.append(this.offset);
        stringBuffer.append(',');
        stringBuffer.append("length");
        stringBuffer.append('=');
        stringBuffer.append(this.length);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

