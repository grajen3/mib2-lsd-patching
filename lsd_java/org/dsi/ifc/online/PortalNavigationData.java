/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.online;

import org.dsi.ifc.online.PortalLocation;

public class PortalNavigationData {
    public long naviType;
    public boolean topDestination;
    public PortalLocation naviLocation;
    public long version;
    public String geoPosition;
    public String street;
    public String locality;

    public PortalNavigationData() {
        this.naviType = 0L;
        this.topDestination = false;
        this.naviLocation = null;
        this.version = 0L;
        this.geoPosition = null;
        this.street = null;
        this.locality = null;
    }

    public PortalNavigationData(long l, boolean bl, PortalLocation portalLocation, long l2, String string, String string2, String string3) {
        this.naviType = l;
        this.topDestination = bl;
        this.naviLocation = portalLocation;
        this.version = l2;
        this.geoPosition = string;
        this.street = string2;
        this.locality = string3;
    }

    public long getNaviType() {
        return this.naviType;
    }

    public boolean isTopDestination() {
        return this.topDestination;
    }

    public PortalLocation getNaviLocation() {
        return this.naviLocation;
    }

    public long getVersion() {
        return this.version;
    }

    public String getGeoPosition() {
        return this.geoPosition;
    }

    public String getStreet() {
        return this.street;
    }

    public String getLocality() {
        return this.locality;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1450);
        stringBuffer.append("PortalNavigationData");
        stringBuffer.append('(');
        stringBuffer.append("naviType");
        stringBuffer.append('=');
        stringBuffer.append(this.naviType);
        stringBuffer.append(',');
        stringBuffer.append("topDestination");
        stringBuffer.append('=');
        stringBuffer.append(this.topDestination);
        stringBuffer.append(',');
        stringBuffer.append("naviLocation");
        stringBuffer.append('=');
        stringBuffer.append(this.naviLocation);
        stringBuffer.append(',');
        stringBuffer.append("version");
        stringBuffer.append('=');
        stringBuffer.append(this.version);
        stringBuffer.append(',');
        stringBuffer.append("geoPosition");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.geoPosition);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("street");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.street);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("locality");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.locality);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

