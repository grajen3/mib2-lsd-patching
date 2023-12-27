/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.map.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.map.StreetViewThumbnail;

public class StreetViewThumbnailSerializer {
    public static void putOptionalStreetViewThumbnail(ISerializer iSerializer, StreetViewThumbnail streetViewThumbnail) {
        boolean bl = streetViewThumbnail == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = streetViewThumbnail.getGeoX();
            iSerializer.putInt32(n);
            int n2 = streetViewThumbnail.getGeoY();
            iSerializer.putInt32(n2);
            int n3 = streetViewThumbnail.getDirection();
            iSerializer.putInt32(n3);
            int n4 = streetViewThumbnail.getThumbnailWidth();
            iSerializer.putInt32(n4);
            int n5 = streetViewThumbnail.getThumbnailHeight();
            iSerializer.putInt32(n5);
            String string = streetViewThumbnail.getDescription();
            iSerializer.putOptionalString(string);
            String string2 = streetViewThumbnail.getUrl();
            iSerializer.putOptionalString(string2);
        }
    }

    public static void putOptionalStreetViewThumbnailVarArray(ISerializer iSerializer, StreetViewThumbnail[] streetViewThumbnailArray) {
        boolean bl = streetViewThumbnailArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(streetViewThumbnailArray.length);
            for (int i2 = 0; i2 < streetViewThumbnailArray.length; ++i2) {
                StreetViewThumbnailSerializer.putOptionalStreetViewThumbnail(iSerializer, streetViewThumbnailArray[i2]);
            }
        }
    }

    public static StreetViewThumbnail getOptionalStreetViewThumbnail(IDeserializer iDeserializer) {
        StreetViewThumbnail streetViewThumbnail = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            String string2;
            int n;
            int n2;
            int n3;
            int n4;
            int n5;
            streetViewThumbnail = new StreetViewThumbnail();
            streetViewThumbnail.geoX = n5 = iDeserializer.getInt32();
            streetViewThumbnail.geoY = n4 = iDeserializer.getInt32();
            streetViewThumbnail.direction = n3 = iDeserializer.getInt32();
            streetViewThumbnail.thumbnailWidth = n2 = iDeserializer.getInt32();
            streetViewThumbnail.thumbnailHeight = n = iDeserializer.getInt32();
            streetViewThumbnail.description = string2 = iDeserializer.getOptionalString();
            streetViewThumbnail.url = string = iDeserializer.getOptionalString();
        }
        return streetViewThumbnail;
    }

    public static StreetViewThumbnail[] getOptionalStreetViewThumbnailVarArray(IDeserializer iDeserializer) {
        StreetViewThumbnail[] streetViewThumbnailArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            streetViewThumbnailArray = new StreetViewThumbnail[n];
            for (int i2 = 0; i2 < n; ++i2) {
                streetViewThumbnailArray[i2] = StreetViewThumbnailSerializer.getOptionalStreetViewThumbnail(iDeserializer);
            }
        }
        return streetViewThumbnailArray;
    }
}

