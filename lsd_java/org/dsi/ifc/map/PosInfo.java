/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.map;

import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.map.Rect;

public class PosInfo {
    public int eInfoType;
    public long objectId;
    public NavLocation tLocation;
    public Rect displayPosition;
    public String infoTxt;
    public String url;
    public ResourceLocator resourceLocator;
    public int numberOfObjects;

    public PosInfo() {
        this.eInfoType = 0;
        this.objectId = 0L;
        this.tLocation = null;
        this.displayPosition = null;
        this.infoTxt = null;
        this.url = null;
        this.resourceLocator = null;
    }

    public PosInfo(int n, long l, NavLocation navLocation, Rect rect, String string, String string2, ResourceLocator resourceLocator, int n2) {
        this.eInfoType = n;
        this.objectId = l;
        this.tLocation = navLocation;
        this.displayPosition = rect;
        this.infoTxt = string;
        this.url = string2;
        this.resourceLocator = resourceLocator;
        this.numberOfObjects = n2;
    }

    public int getEInfoType() {
        return this.eInfoType;
    }

    public long getObjectId() {
        return this.objectId;
    }

    public NavLocation getTLocation() {
        return this.tLocation;
    }

    public Rect getDisplayPosition() {
        return this.displayPosition;
    }

    public String getInfoTxt() {
        return this.infoTxt;
    }

    public String getUrl() {
        return this.url;
    }

    public ResourceLocator getResourceLocator() {
        return this.resourceLocator;
    }

    public int getNumberOfObjects() {
        return this.numberOfObjects;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(3450);
        stringBuffer.append("PosInfo");
        stringBuffer.append('(');
        stringBuffer.append("eInfoType");
        stringBuffer.append('=');
        stringBuffer.append(this.eInfoType);
        stringBuffer.append(',');
        stringBuffer.append("objectId");
        stringBuffer.append('=');
        stringBuffer.append(this.objectId);
        stringBuffer.append(',');
        stringBuffer.append("tLocation");
        stringBuffer.append('=');
        stringBuffer.append(this.tLocation);
        stringBuffer.append(',');
        stringBuffer.append("displayPosition");
        stringBuffer.append('=');
        stringBuffer.append(this.displayPosition);
        stringBuffer.append(',');
        stringBuffer.append("infoTxt");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.infoTxt);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("url");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.url);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("resourceLocator");
        stringBuffer.append('=');
        stringBuffer.append(this.resourceLocator);
        stringBuffer.append(',');
        stringBuffer.append("numberOfObjects");
        stringBuffer.append('=');
        stringBuffer.append(this.numberOfObjects);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

