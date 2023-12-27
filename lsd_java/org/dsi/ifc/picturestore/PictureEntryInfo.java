/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.picturestore;

import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.picturestore.PictureAttribute;

public class PictureEntryInfo {
    public int type;
    public PictureAttribute[] attributes;
    public String filename;
    public boolean selected;
    public ResourceLocator resourceLocator;

    public PictureEntryInfo() {
        this.type = 0;
        this.attributes = null;
        this.filename = null;
        this.selected = false;
        this.resourceLocator = null;
    }

    public PictureEntryInfo(int n, PictureAttribute[] pictureAttributeArray, String string, boolean bl, ResourceLocator resourceLocator) {
        this.type = n;
        this.attributes = pictureAttributeArray;
        this.filename = string;
        this.selected = bl;
        this.resourceLocator = resourceLocator;
    }

    public int getType() {
        return this.type;
    }

    public PictureAttribute[] getAttributes() {
        return this.attributes;
    }

    public String getFilename() {
        return this.filename;
    }

    public boolean isSelected() {
        return this.selected;
    }

    public ResourceLocator getResourceLocator() {
        return this.resourceLocator;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1250);
        stringBuffer.append("PictureEntryInfo");
        stringBuffer.append('(');
        stringBuffer.append("type");
        stringBuffer.append('=');
        stringBuffer.append(this.type);
        stringBuffer.append(',');
        stringBuffer.append("attributes");
        stringBuffer.append('[');
        if (this.attributes != null) {
            stringBuffer.append(this.attributes.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.attributes != null) {
            int n = this.attributes.length;
            int n2 = n - 1;
            for (int i2 = 0; i2 < n; ++i2) {
                stringBuffer.append(this.attributes[i2]);
                if (i2 >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.attributes);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("filename");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.filename);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("selected");
        stringBuffer.append('=');
        stringBuffer.append(this.selected);
        stringBuffer.append(',');
        stringBuffer.append("resourceLocator");
        stringBuffer.append('=');
        stringBuffer.append(this.resourceLocator);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

