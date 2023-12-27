/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.radio;

import org.dsi.ifc.global.ResourceLocator;

public class EPGLogoDescriptor {
    public String logoType;
    public String mimeType;
    public int widthX;
    public int heightY;
    public ResourceLocator picture;

    public EPGLogoDescriptor() {
        this.logoType = null;
        this.mimeType = null;
        this.widthX = 0;
        this.heightY = 0;
        this.picture = null;
    }

    public EPGLogoDescriptor(String string, String string2, int n, int n2, ResourceLocator resourceLocator) {
        this.logoType = string;
        this.mimeType = string2;
        this.widthX = n;
        this.heightY = n2;
        this.picture = resourceLocator;
    }

    public String getLogoType() {
        return this.logoType;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public int getWidthX() {
        return this.widthX;
    }

    public int getHeightY() {
        return this.heightY;
    }

    public ResourceLocator getPicture() {
        return this.picture;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1300);
        stringBuffer.append("EPGLogoDescriptor");
        stringBuffer.append('(');
        stringBuffer.append("logoType");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.logoType);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("mimeType");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.mimeType);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("widthX");
        stringBuffer.append('=');
        stringBuffer.append(this.widthX);
        stringBuffer.append(',');
        stringBuffer.append("heightY");
        stringBuffer.append('=');
        stringBuffer.append(this.heightY);
        stringBuffer.append(',');
        stringBuffer.append("picture");
        stringBuffer.append('=');
        stringBuffer.append(this.picture);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

