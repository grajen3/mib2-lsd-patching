/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.media;

import org.dsi.ifc.media.MediaCapabilities;

public class MediaInfo {
    public long deviceID;
    public long mediaID;
    public int mediaType;
    public String uniqueMediaID;
    public String name;
    public String mountPoint;
    public int flags;
    public MediaCapabilities mediaCaps;

    public MediaInfo() {
        this.deviceID = 0L;
        this.mediaID = 0L;
        this.mediaType = 0;
        this.uniqueMediaID = null;
        this.name = null;
        this.mountPoint = null;
        this.flags = 0;
        this.mediaCaps = null;
    }

    public MediaInfo(long l, long l2, int n, String string, String string2, String string3, int n2, MediaCapabilities mediaCapabilities) {
        this.deviceID = l;
        this.mediaID = l2;
        this.mediaType = n;
        this.uniqueMediaID = string;
        this.name = string2;
        this.mountPoint = string3;
        this.flags = n2;
        this.mediaCaps = mediaCapabilities;
    }

    public long getDeviceID() {
        return this.deviceID;
    }

    public long getMediaID() {
        return this.mediaID;
    }

    public int getMediaType() {
        return this.mediaType;
    }

    public String getUniqueMediaID() {
        return this.uniqueMediaID;
    }

    public String getName() {
        return this.name;
    }

    public String getMountPoint() {
        return this.mountPoint;
    }

    public int getFlags() {
        return this.flags;
    }

    public MediaCapabilities getMediaCaps() {
        return this.mediaCaps;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1500);
        stringBuffer.append("MediaInfo");
        stringBuffer.append('(');
        stringBuffer.append("deviceID");
        stringBuffer.append('=');
        stringBuffer.append(this.deviceID);
        stringBuffer.append(',');
        stringBuffer.append("mediaID");
        stringBuffer.append('=');
        stringBuffer.append(this.mediaID);
        stringBuffer.append(',');
        stringBuffer.append("mediaType");
        stringBuffer.append('=');
        stringBuffer.append(this.mediaType);
        stringBuffer.append(',');
        stringBuffer.append("uniqueMediaID");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.uniqueMediaID);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("name");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.name);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("mountPoint");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.mountPoint);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("flags");
        stringBuffer.append('=');
        stringBuffer.append(this.flags);
        stringBuffer.append(',');
        stringBuffer.append("mediaCaps");
        stringBuffer.append('=');
        stringBuffer.append(this.mediaCaps);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

