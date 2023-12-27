/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.tpegservices;

import org.dsi.ifc.global.DateTime;

public class SimpleMapData {
    public int id;
    public int contentId;
    public boolean subCategory;
    public boolean isBookmark;
    public String description;
    public DateTime timestamp;

    public SimpleMapData() {
        this.id = 0;
        this.contentId = 0;
        this.subCategory = false;
        this.isBookmark = false;
        this.description = null;
        this.timestamp = null;
    }

    public SimpleMapData(int n, int n2, boolean bl, boolean bl2, String string) {
        this.id = n;
        this.contentId = n2;
        this.subCategory = bl;
        this.isBookmark = bl2;
        this.description = string;
        this.timestamp = null;
    }

    public SimpleMapData(int n, int n2, boolean bl, boolean bl2, String string, DateTime dateTime) {
        this.id = n;
        this.contentId = n2;
        this.subCategory = bl;
        this.isBookmark = bl2;
        this.description = string;
        this.timestamp = dateTime;
    }

    public int getId() {
        return this.id;
    }

    public int getContentId() {
        return this.contentId;
    }

    public boolean isSubCategory() {
        return this.subCategory;
    }

    public boolean isIsBookmark() {
        return this.isBookmark;
    }

    public String getDescription() {
        return this.description;
    }

    public DateTime getTimestamp() {
        return this.timestamp;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1300);
        stringBuffer.append("SimpleMapData");
        stringBuffer.append('(');
        stringBuffer.append("id");
        stringBuffer.append('=');
        stringBuffer.append(this.id);
        stringBuffer.append(',');
        stringBuffer.append("contentId");
        stringBuffer.append('=');
        stringBuffer.append(this.contentId);
        stringBuffer.append(',');
        stringBuffer.append("subCategory");
        stringBuffer.append('=');
        stringBuffer.append(this.subCategory);
        stringBuffer.append(',');
        stringBuffer.append("isBookmark");
        stringBuffer.append('=');
        stringBuffer.append(this.isBookmark);
        stringBuffer.append(',');
        stringBuffer.append("description");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.description);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("timestamp");
        stringBuffer.append('=');
        stringBuffer.append(this.timestamp);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

