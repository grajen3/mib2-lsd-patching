/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.picturestore.impl;

import de.esolutions.fw.comm.dsi.global.impl.ResourceLocatorSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.picturestore.GeoPicture;

public class GeoPictureSerializer {
    public static void putOptionalGeoPicture(ISerializer iSerializer, GeoPicture geoPicture) {
        boolean bl = geoPicture == null;
        iSerializer.putBool(bl);
        if (!bl) {
            ResourceLocator resourceLocator = geoPicture.getPictureResource();
            ResourceLocatorSerializer.putOptionalResourceLocator(iSerializer, resourceLocator);
            float f2 = geoPicture.getLatitudeDecimalDegrees();
            iSerializer.putFloat(f2);
            float f3 = geoPicture.getLongitudeDecimalDegrees();
            iSerializer.putFloat(f3);
        }
    }

    public static void putOptionalGeoPictureVarArray(ISerializer iSerializer, GeoPicture[] geoPictureArray) {
        boolean bl = geoPictureArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(geoPictureArray.length);
            for (int i2 = 0; i2 < geoPictureArray.length; ++i2) {
                GeoPictureSerializer.putOptionalGeoPicture(iSerializer, geoPictureArray[i2]);
            }
        }
    }

    public static GeoPicture getOptionalGeoPicture(IDeserializer iDeserializer) {
        GeoPicture geoPicture = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            float f2;
            float f3;
            ResourceLocator resourceLocator;
            geoPicture = new GeoPicture();
            geoPicture.pictureResource = resourceLocator = ResourceLocatorSerializer.getOptionalResourceLocator(iDeserializer);
            geoPicture.latitudeDecimalDegrees = f3 = iDeserializer.getFloat();
            geoPicture.longitudeDecimalDegrees = f2 = iDeserializer.getFloat();
        }
        return geoPicture;
    }

    public static GeoPicture[] getOptionalGeoPictureVarArray(IDeserializer iDeserializer) {
        GeoPicture[] geoPictureArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            geoPictureArray = new GeoPicture[n];
            for (int i2 = 0; i2 < n; ++i2) {
                geoPictureArray[i2] = GeoPictureSerializer.getOptionalGeoPicture(iDeserializer);
            }
        }
        return geoPictureArray;
    }
}

