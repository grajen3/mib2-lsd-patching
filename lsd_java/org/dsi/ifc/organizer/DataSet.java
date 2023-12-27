/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.organizer;

import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.organizer.Highlight;

public class DataSet {
    public long entryId;
    public int entryPosition;
    public int entryType;
    public String generalDescription1;
    public String generalDescription2;
    public int voiceTagId;
    public int phoneCount;
    public int probNavigable;
    public int navigable;
    public int topDestination;
    public ResourceLocator contactPicture;
    public int webAddressCount;
    public int emailCount;
    public int numberType;
    public Highlight[] highlight;

    public DataSet() {
        this.entryId = 0L;
        this.entryPosition = 0;
        this.entryType = 0;
        this.generalDescription1 = null;
        this.generalDescription2 = null;
        this.voiceTagId = 0;
        this.phoneCount = 0;
        this.navigable = 0;
        this.topDestination = 0;
        this.contactPicture = null;
        this.webAddressCount = 0;
        this.emailCount = 0;
        this.numberType = 0;
        this.highlight = null;
    }

    public DataSet(long l, int n, int n2, String string, String string2, int n3, int n4, int n5, int n6, int n7, ResourceLocator resourceLocator, int n8, int n9, int n10, Highlight[] highlightArray) {
        this.entryId = l;
        this.entryPosition = n;
        this.entryType = n2;
        this.generalDescription1 = string;
        this.generalDescription2 = string2;
        this.voiceTagId = n3;
        this.phoneCount = n4;
        this.probNavigable = n5;
        this.navigable = n6;
        this.topDestination = n7;
        this.contactPicture = resourceLocator;
        this.webAddressCount = n8;
        this.emailCount = n9;
        this.numberType = n10;
        this.highlight = highlightArray;
    }

    public long getEntryId() {
        return this.entryId;
    }

    public int getEntryPosition() {
        return this.entryPosition;
    }

    public int getEntryType() {
        return this.entryType;
    }

    public String getGeneralDescription1() {
        return this.generalDescription1;
    }

    public String getGeneralDescription2() {
        return this.generalDescription2;
    }

    public int getVoiceTagId() {
        return this.voiceTagId;
    }

    public int getPhoneCount() {
        return this.phoneCount;
    }

    public int getProbNavigable() {
        return this.probNavigable;
    }

    public int getNavigable() {
        return this.navigable;
    }

    public int getTopDestination() {
        return this.topDestination;
    }

    public ResourceLocator getContactPicture() {
        return this.contactPicture;
    }

    public int getWebAddressCount() {
        return this.webAddressCount;
    }

    public int getEmailCount() {
        return this.emailCount;
    }

    public int getNumberType() {
        return this.numberType;
    }

    public Highlight[] getHighlight() {
        return this.highlight;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1900);
        stringBuffer.append("DataSet");
        stringBuffer.append('(');
        stringBuffer.append("entryId");
        stringBuffer.append('=');
        stringBuffer.append(this.entryId);
        stringBuffer.append(',');
        stringBuffer.append("entryPosition");
        stringBuffer.append('=');
        stringBuffer.append(this.entryPosition);
        stringBuffer.append(',');
        stringBuffer.append("entryType");
        stringBuffer.append('=');
        stringBuffer.append(this.entryType);
        stringBuffer.append(',');
        stringBuffer.append("generalDescription1");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.generalDescription1);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("generalDescription2");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.generalDescription2);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("voiceTagId");
        stringBuffer.append('=');
        stringBuffer.append(this.voiceTagId);
        stringBuffer.append(',');
        stringBuffer.append("phoneCount");
        stringBuffer.append('=');
        stringBuffer.append(this.phoneCount);
        stringBuffer.append(',');
        stringBuffer.append("probNavigable");
        stringBuffer.append('=');
        stringBuffer.append(this.probNavigable);
        stringBuffer.append(',');
        stringBuffer.append("navigable");
        stringBuffer.append('=');
        stringBuffer.append(this.navigable);
        stringBuffer.append(',');
        stringBuffer.append("topDestination");
        stringBuffer.append('=');
        stringBuffer.append(this.topDestination);
        stringBuffer.append(',');
        stringBuffer.append("contactPicture");
        stringBuffer.append('=');
        stringBuffer.append(this.contactPicture);
        stringBuffer.append(',');
        stringBuffer.append("webAddressCount");
        stringBuffer.append('=');
        stringBuffer.append(this.webAddressCount);
        stringBuffer.append(',');
        stringBuffer.append("emailCount");
        stringBuffer.append('=');
        stringBuffer.append(this.emailCount);
        stringBuffer.append(',');
        stringBuffer.append("numberType");
        stringBuffer.append('=');
        stringBuffer.append(this.numberType);
        stringBuffer.append(',');
        stringBuffer.append("highlight");
        stringBuffer.append('[');
        if (this.highlight != null) {
            stringBuffer.append(this.highlight.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.highlight != null) {
            int n = this.highlight.length;
            int n2 = n - 1;
            for (int i2 = 0; i2 < n; ++i2) {
                stringBuffer.append(this.highlight[i2]);
                if (i2 >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.highlight);
        }
        stringBuffer.append('}');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

