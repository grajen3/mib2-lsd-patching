/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navigation;

import org.dsi.ifc.global.DateTime;
import org.dsi.ifc.global.ResourceLocator;

public class PoiExtendedInfo {
    public int longitude;
    public int latitude;
    public DateTime timestamp;
    public String description;
    public ResourceLocator[] pictureReferences;
    public String unstructuredAddress;
    public String emailAddress;

    public PoiExtendedInfo() {
        this.longitude = 0;
        this.latitude = 0;
        this.timestamp = null;
        this.description = null;
        this.pictureReferences = null;
        this.unstructuredAddress = null;
        this.emailAddress = null;
    }

    public PoiExtendedInfo(int n, int n2, DateTime dateTime, String string, ResourceLocator[] resourceLocatorArray, String string2) {
        this.longitude = n;
        this.latitude = n2;
        this.timestamp = dateTime;
        this.description = string;
        this.pictureReferences = resourceLocatorArray;
        this.unstructuredAddress = string2;
        this.emailAddress = null;
    }

    public PoiExtendedInfo(int n, int n2, DateTime dateTime, String string, ResourceLocator[] resourceLocatorArray, String string2, String string3) {
        this.longitude = n;
        this.latitude = n2;
        this.timestamp = dateTime;
        this.description = string;
        this.pictureReferences = resourceLocatorArray;
        this.unstructuredAddress = string2;
        this.emailAddress = string3;
    }

    public int getLongitude() {
        return this.longitude;
    }

    public int getLatitude() {
        return this.latitude;
    }

    public DateTime getTimestamp() {
        return this.timestamp;
    }

    public String getDescription() {
        return this.description;
    }

    public ResourceLocator[] getPictureReferences() {
        return this.pictureReferences;
    }

    public String getUnstructuredAddress() {
        return this.unstructuredAddress;
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1500);
        stringBuffer.append("PoiExtendedInfo");
        stringBuffer.append('(');
        stringBuffer.append("longitude");
        stringBuffer.append('=');
        stringBuffer.append(this.longitude);
        stringBuffer.append(',');
        stringBuffer.append("latitude");
        stringBuffer.append('=');
        stringBuffer.append(this.latitude);
        stringBuffer.append(',');
        stringBuffer.append("timestamp");
        stringBuffer.append('=');
        stringBuffer.append(this.timestamp);
        stringBuffer.append(',');
        stringBuffer.append("description");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.description);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("pictureReferences");
        stringBuffer.append('[');
        if (this.pictureReferences != null) {
            stringBuffer.append(this.pictureReferences.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.pictureReferences != null) {
            int n = this.pictureReferences.length;
            int n2 = n - 1;
            for (int i2 = 0; i2 < n; ++i2) {
                stringBuffer.append(this.pictureReferences[i2]);
                if (i2 >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.pictureReferences);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("unstructuredAddress");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.unstructuredAddress);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("emailAddress");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.emailAddress);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

