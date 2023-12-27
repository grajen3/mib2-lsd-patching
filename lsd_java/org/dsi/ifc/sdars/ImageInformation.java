/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.sdars;

import org.dsi.ifc.global.ResourceLocator;

public class ImageInformation {
    public int sID;
    public ResourceLocator image;

    public ImageInformation() {
        this.sID = 0;
        this.image = null;
    }

    public ImageInformation(int n, ResourceLocator resourceLocator) {
        this.sID = n;
        this.image = resourceLocator;
    }

    public int getSID() {
        return this.sID;
    }

    public ResourceLocator getImage() {
        return this.image;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1100);
        stringBuffer.append("ImageInformation");
        stringBuffer.append('(');
        stringBuffer.append("sID");
        stringBuffer.append('=');
        stringBuffer.append(this.sID);
        stringBuffer.append(',');
        stringBuffer.append("image");
        stringBuffer.append('=');
        stringBuffer.append(this.image);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

