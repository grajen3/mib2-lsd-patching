/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.sdars.impl;

import de.esolutions.fw.comm.dsi.global.impl.ResourceLocatorSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.sdars.ImageInformation;

public class ImageInformationSerializer {
    public static void putOptionalImageInformation(ISerializer iSerializer, ImageInformation imageInformation) {
        boolean bl = imageInformation == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = imageInformation.getSID();
            iSerializer.putInt32(n);
            ResourceLocator resourceLocator = imageInformation.getImage();
            ResourceLocatorSerializer.putOptionalResourceLocator(iSerializer, resourceLocator);
        }
    }

    public static void putOptionalImageInformationVarArray(ISerializer iSerializer, ImageInformation[] imageInformationArray) {
        boolean bl = imageInformationArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(imageInformationArray.length);
            for (int i2 = 0; i2 < imageInformationArray.length; ++i2) {
                ImageInformationSerializer.putOptionalImageInformation(iSerializer, imageInformationArray[i2]);
            }
        }
    }

    public static ImageInformation getOptionalImageInformation(IDeserializer iDeserializer) {
        ImageInformation imageInformation = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            ResourceLocator resourceLocator;
            int n;
            imageInformation = new ImageInformation();
            imageInformation.sID = n = iDeserializer.getInt32();
            imageInformation.image = resourceLocator = ResourceLocatorSerializer.getOptionalResourceLocator(iDeserializer);
        }
        return imageInformation;
    }

    public static ImageInformation[] getOptionalImageInformationVarArray(IDeserializer iDeserializer) {
        ImageInformation[] imageInformationArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            imageInformationArray = new ImageInformation[n];
            for (int i2 = 0; i2 < n; ++i2) {
                imageInformationArray[i2] = ImageInformationSerializer.getOptionalImageInformation(iDeserializer);
            }
        }
        return imageInformationArray;
    }
}

