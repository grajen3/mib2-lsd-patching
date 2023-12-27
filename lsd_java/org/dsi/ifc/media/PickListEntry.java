/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.media;

public class PickListEntry {
    public long entryID;
    public String name;
    public String additionalInfo;
    public int additionalInfoEntryFlags;

    public PickListEntry() {
        this.entryID = 0L;
        this.name = null;
        this.additionalInfo = null;
        this.additionalInfoEntryFlags = 0;
    }

    public PickListEntry(long l, String string, String string2, int n) {
        this.entryID = l;
        this.name = string;
        this.additionalInfo = string2;
        this.additionalInfoEntryFlags = n;
    }

    public long getEntryID() {
        return this.entryID;
    }

    public String getName() {
        return this.name;
    }

    public String getAdditionalInfo() {
        return this.additionalInfo;
    }

    public int getAdditionalInfoEntryFlags() {
        return this.additionalInfoEntryFlags;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(350);
        stringBuffer.append("PickListEntry");
        stringBuffer.append('(');
        stringBuffer.append("entryID");
        stringBuffer.append('=');
        stringBuffer.append(this.entryID);
        stringBuffer.append(',');
        stringBuffer.append("name");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.name);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("additionalInfo");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.additionalInfo);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("additionalInfoEntryFlags");
        stringBuffer.append('=');
        stringBuffer.append(this.additionalInfoEntryFlags);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

