/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.imageserver.impl;

import de.esolutions.fw.comm.asi.imageserver.Image;
import de.esolutions.fw.comm.asi.imageserver.ImageInfo;
import de.esolutions.fw.comm.asi.imageserver.impl.ImageInfoSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class ImageSerializer {
    public static void putOptionalImage(ISerializer iSerializer, Image image) {
        boolean bl = image == null;
        iSerializer.putBool(bl);
        if (!bl) {
            ImageInfo imageInfo = image.getInfo();
            ImageInfoSerializer.putOptionalImageInfo(iSerializer, imageInfo);
            boolean bl2 = image.isConverted();
            iSerializer.putBool(bl2);
            byte[] byArray = image.getData();
            iSerializer.putOptionalInt8VarArray(byArray);
            int n = image.getDataSize();
            iSerializer.putInt32(n);
        }
    }

    public static void putOptionalImageVarArray(ISerializer iSerializer, Image[] imageArray) {
        boolean bl = imageArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(imageArray.length);
            for (int i2 = 0; i2 < imageArray.length; ++i2) {
                ImageSerializer.putOptionalImage(iSerializer, imageArray[i2]);
            }
        }
    }

    public static Image getOptionalImage(IDeserializer iDeserializer) {
        Image image = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            boolean bl2;
            ImageInfo imageInfo;
            image = new Image();
            image.info = imageInfo = ImageInfoSerializer.getOptionalImageInfo(iDeserializer);
            image.converted = bl2 = iDeserializer.getBool();
            byte[] byArray = iDeserializer.getOptionalInt8VarArray();
            image.data = byArray;
            image.dataSize = n = iDeserializer.getInt32();
        }
        return image;
    }

    public static Image[] getOptionalImageVarArray(IDeserializer iDeserializer) {
        Image[] imageArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            imageArray = new Image[n];
            for (int i2 = 0; i2 < n; ++i2) {
                imageArray[i2] = ImageSerializer.getOptionalImage(iDeserializer);
            }
        }
        return imageArray;
    }
}

