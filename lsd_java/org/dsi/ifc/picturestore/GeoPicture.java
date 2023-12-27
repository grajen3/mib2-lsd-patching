/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.picturestore;

import org.dsi.ifc.global.ResourceLocator;

public class GeoPicture {
    public ResourceLocator pictureResource;
    public float latitudeDecimalDegrees;
    public float longitudeDecimalDegrees;

    public GeoPicture() {
        this.pictureResource = null;
        this.latitudeDecimalDegrees = 0.0f;
        this.longitudeDecimalDegrees = 0.0f;
    }

    public GeoPicture(ResourceLocator resourceLocator, float f2, float f3) {
        this.pictureResource = resourceLocator;
        this.latitudeDecimalDegrees = f2;
        this.longitudeDecimalDegrees = f3;
    }

    public ResourceLocator getPictureResource() {
        return this.pictureResource;
    }

    public float getLatitudeDecimalDegrees() {
        return this.latitudeDecimalDegrees;
    }

    public float getLongitudeDecimalDegrees() {
        return this.longitudeDecimalDegrees;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1200);
        stringBuffer.append("GeoPicture");
        stringBuffer.append('(');
        stringBuffer.append("pictureResource");
        stringBuffer.append('=');
        stringBuffer.append(this.pictureResource);
        stringBuffer.append(',');
        stringBuffer.append("latitudeDecimalDegrees");
        stringBuffer.append('=');
        stringBuffer.append(this.latitudeDecimalDegrees);
        stringBuffer.append(',');
        stringBuffer.append("longitudeDecimalDegrees");
        stringBuffer.append('=');
        stringBuffer.append(this.longitudeDecimalDegrees);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

