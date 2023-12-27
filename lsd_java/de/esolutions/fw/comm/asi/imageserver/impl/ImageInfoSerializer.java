/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.imageserver.impl;

import de.esolutions.fw.comm.asi.imageserver.ImageInfo;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class ImageInfoSerializer {
    public static void putOptionalImageInfo(ISerializer iSerializer, ImageInfo imageInfo) {
        boolean bl = imageInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = imageInfo.getType();
            iSerializer.putEnum(n);
            int n2 = imageInfo.getWidth();
            iSerializer.putInt32(n2);
            int n3 = imageInfo.getHeight();
            iSerializer.putInt32(n3);
            long l = imageInfo.getHash();
            iSerializer.putInt64(l);
            long l2 = imageInfo.getFileSize();
            iSerializer.putInt64(l2);
        }
    }

    public static void putOptionalImageInfoVarArray(ISerializer iSerializer, ImageInfo[] imageInfoArray) {
        boolean bl = imageInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(imageInfoArray.length);
            for (int i2 = 0; i2 < imageInfoArray.length; ++i2) {
                ImageInfoSerializer.putOptionalImageInfo(iSerializer, imageInfoArray[i2]);
            }
        }
    }

    public static ImageInfo getOptionalImageInfo(IDeserializer iDeserializer) {
        ImageInfo imageInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            long l;
            long l2;
            int n;
            int n2;
            int n3;
            imageInfo = new ImageInfo();
            imageInfo.type = n3 = iDeserializer.getEnum();
            imageInfo.width = n2 = iDeserializer.getInt32();
            imageInfo.height = n = iDeserializer.getInt32();
            imageInfo.hash = l2 = iDeserializer.getInt64();
            imageInfo.fileSize = l = iDeserializer.getInt64();
        }
        return imageInfo;
    }

    public static ImageInfo[] getOptionalImageInfoVarArray(IDeserializer iDeserializer) {
        ImageInfo[] imageInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            imageInfoArray = new ImageInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                imageInfoArray[i2] = ImageInfoSerializer.getOptionalImageInfo(iDeserializer);
            }
        }
        return imageInfoArray;
    }
}

