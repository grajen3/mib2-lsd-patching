/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.speechrec;

public class NBestSlot {
    public int id;
    public String recognizedString;
    public long objectId;
    public int index;
    public String objectStringId;

    public NBestSlot() {
        this.id = -1;
        this.recognizedString = "";
        this.objectId = 0L;
        this.index = -1;
        this.objectStringId = null;
    }

    public NBestSlot(int n, String string, long l, int n2, String string2) {
        this.id = n;
        this.recognizedString = string;
        this.objectId = l;
        this.index = n2;
        this.objectStringId = string2;
    }

    public int getId() {
        return this.id;
    }

    public String getRecognizedString() {
        return this.recognizedString;
    }

    public long getObjectId() {
        return this.objectId;
    }

    public int getIndex() {
        return this.index;
    }

    public String getObjectStringId() {
        return this.objectStringId;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(350);
        stringBuffer.append("NBestSlot");
        stringBuffer.append('(');
        stringBuffer.append("id");
        stringBuffer.append('=');
        stringBuffer.append(this.id);
        stringBuffer.append(',');
        stringBuffer.append("recognizedString");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.recognizedString);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("objectId");
        stringBuffer.append('=');
        stringBuffer.append(this.objectId);
        stringBuffer.append(',');
        stringBuffer.append("index");
        stringBuffer.append('=');
        stringBuffer.append(this.index);
        stringBuffer.append(',');
        stringBuffer.append("objectStringId");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.objectStringId);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

