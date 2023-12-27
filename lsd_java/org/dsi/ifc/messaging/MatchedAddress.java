/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.messaging;

import org.dsi.ifc.global.ResourceLocator;

public class MatchedAddress {
    public String address;
    public String name;
    public long adbEntryID;
    public ResourceLocator adbPictureID;

    public MatchedAddress() {
        this.address = "";
        this.name = "";
        this.adbEntryID = -1L;
        this.adbPictureID = new ResourceLocator();
    }

    public MatchedAddress(String string, String string2, long l, ResourceLocator resourceLocator) {
        this.address = string;
        this.name = string2;
        this.adbEntryID = l;
        this.adbPictureID = resourceLocator;
    }

    public String getAddress() {
        return this.address;
    }

    public String getName() {
        return this.name;
    }

    public long getAdbEntryID() {
        return this.adbEntryID;
    }

    public ResourceLocator getAdbPictureID() {
        return this.adbPictureID;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1250);
        stringBuffer.append("MatchedAddress");
        stringBuffer.append('(');
        stringBuffer.append("address");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.address);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("name");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.name);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("adbEntryID");
        stringBuffer.append('=');
        stringBuffer.append(this.adbEntryID);
        stringBuffer.append(',');
        stringBuffer.append("adbPictureID");
        stringBuffer.append('=');
        stringBuffer.append(this.adbPictureID);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

