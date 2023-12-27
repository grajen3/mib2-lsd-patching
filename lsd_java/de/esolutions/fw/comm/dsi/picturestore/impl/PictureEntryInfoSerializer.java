/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.picturestore.impl;

import de.esolutions.fw.comm.dsi.global.impl.ResourceLocatorSerializer;
import de.esolutions.fw.comm.dsi.picturestore.impl.PictureAttributeSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.picturestore.PictureAttribute;
import org.dsi.ifc.picturestore.PictureEntryInfo;

public class PictureEntryInfoSerializer {
    public static void putOptionalPictureEntryInfo(ISerializer iSerializer, PictureEntryInfo pictureEntryInfo) {
        boolean bl = pictureEntryInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = pictureEntryInfo.getType();
            iSerializer.putInt32(n);
            PictureAttribute[] pictureAttributeArray = pictureEntryInfo.getAttributes();
            PictureAttributeSerializer.putOptionalPictureAttributeVarArray(iSerializer, pictureAttributeArray);
            String string = pictureEntryInfo.getFilename();
            iSerializer.putOptionalString(string);
            boolean bl2 = pictureEntryInfo.isSelected();
            iSerializer.putBool(bl2);
            ResourceLocator resourceLocator = pictureEntryInfo.getResourceLocator();
            ResourceLocatorSerializer.putOptionalResourceLocator(iSerializer, resourceLocator);
        }
    }

    public static void putOptionalPictureEntryInfoVarArray(ISerializer iSerializer, PictureEntryInfo[] pictureEntryInfoArray) {
        boolean bl = pictureEntryInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(pictureEntryInfoArray.length);
            for (int i2 = 0; i2 < pictureEntryInfoArray.length; ++i2) {
                PictureEntryInfoSerializer.putOptionalPictureEntryInfo(iSerializer, pictureEntryInfoArray[i2]);
            }
        }
    }

    public static PictureEntryInfo getOptionalPictureEntryInfo(IDeserializer iDeserializer) {
        PictureEntryInfo pictureEntryInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            ResourceLocator resourceLocator;
            boolean bl2;
            String string;
            int n;
            pictureEntryInfo = new PictureEntryInfo();
            pictureEntryInfo.type = n = iDeserializer.getInt32();
            PictureAttribute[] pictureAttributeArray = PictureAttributeSerializer.getOptionalPictureAttributeVarArray(iDeserializer);
            pictureEntryInfo.attributes = pictureAttributeArray;
            pictureEntryInfo.filename = string = iDeserializer.getOptionalString();
            pictureEntryInfo.selected = bl2 = iDeserializer.getBool();
            pictureEntryInfo.resourceLocator = resourceLocator = ResourceLocatorSerializer.getOptionalResourceLocator(iDeserializer);
        }
        return pictureEntryInfo;
    }

    public static PictureEntryInfo[] getOptionalPictureEntryInfoVarArray(IDeserializer iDeserializer) {
        PictureEntryInfo[] pictureEntryInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            pictureEntryInfoArray = new PictureEntryInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                pictureEntryInfoArray[i2] = PictureEntryInfoSerializer.getOptionalPictureEntryInfo(iDeserializer);
            }
        }
        return pictureEntryInfoArray;
    }
}

