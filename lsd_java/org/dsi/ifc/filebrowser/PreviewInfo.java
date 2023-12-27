/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.filebrowser;

import org.dsi.ifc.filebrowser.GPSInfo;
import org.dsi.ifc.global.ResourceLocator;

public class PreviewInfo {
    public ResourceLocator previewRL;
    public long utcTimestampCreatedOn;
    public GPSInfo gpsInfo;
    public String headline;
    public String imageDescription;
    public String copyright;

    public PreviewInfo() {
        this.previewRL = null;
        this.utcTimestampCreatedOn = 0L;
        this.gpsInfo = null;
        this.headline = null;
        this.imageDescription = null;
        this.copyright = null;
    }

    public PreviewInfo(ResourceLocator resourceLocator, long l, GPSInfo gPSInfo, String string, String string2, String string3) {
        this.previewRL = resourceLocator;
        this.utcTimestampCreatedOn = l;
        this.gpsInfo = gPSInfo;
        this.headline = string;
        this.imageDescription = string2;
        this.copyright = string3;
    }

    public ResourceLocator getPreviewRL() {
        return this.previewRL;
    }

    public long getUtcTimestampCreatedOn() {
        return this.utcTimestampCreatedOn;
    }

    public GPSInfo getGpsInfo() {
        return this.gpsInfo;
    }

    public String getHeadline() {
        return this.headline;
    }

    public String getImageDescription() {
        return this.imageDescription;
    }

    public String getCopyright() {
        return this.copyright;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(2400);
        stringBuffer.append("PreviewInfo");
        stringBuffer.append('(');
        stringBuffer.append("previewRL");
        stringBuffer.append('=');
        stringBuffer.append(this.previewRL);
        stringBuffer.append(',');
        stringBuffer.append("utcTimestampCreatedOn");
        stringBuffer.append('=');
        stringBuffer.append(this.utcTimestampCreatedOn);
        stringBuffer.append(',');
        stringBuffer.append("gpsInfo");
        stringBuffer.append('=');
        stringBuffer.append(this.gpsInfo);
        stringBuffer.append(',');
        stringBuffer.append("headline");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.headline);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("imageDescription");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.imageDescription);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("copyright");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.copyright);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

