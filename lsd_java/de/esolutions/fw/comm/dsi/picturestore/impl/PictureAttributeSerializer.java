/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.picturestore.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.picturestore.PictureAttribute;

public class PictureAttributeSerializer {
    public static void putOptionalPictureAttribute(ISerializer iSerializer, PictureAttribute pictureAttribute) {
        boolean bl = pictureAttribute == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = pictureAttribute.getKey();
            iSerializer.putOptionalString(string);
            String string2 = pictureAttribute.getValue();
            iSerializer.putOptionalString(string2);
        }
    }

    public static void putOptionalPictureAttributeVarArray(ISerializer iSerializer, PictureAttribute[] pictureAttributeArray) {
        boolean bl = pictureAttributeArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(pictureAttributeArray.length);
            for (int i2 = 0; i2 < pictureAttributeArray.length; ++i2) {
                PictureAttributeSerializer.putOptionalPictureAttribute(iSerializer, pictureAttributeArray[i2]);
            }
        }
    }

    public static PictureAttribute getOptionalPictureAttribute(IDeserializer iDeserializer) {
        PictureAttribute pictureAttribute = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            String string2;
            pictureAttribute = new PictureAttribute();
            pictureAttribute.key = string2 = iDeserializer.getOptionalString();
            pictureAttribute.value = string = iDeserializer.getOptionalString();
        }
        return pictureAttribute;
    }

    public static PictureAttribute[] getOptionalPictureAttributeVarArray(IDeserializer iDeserializer) {
        PictureAttribute[] pictureAttributeArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            pictureAttributeArray = new PictureAttribute[n];
            for (int i2 = 0; i2 < n; ++i2) {
                pictureAttributeArray[i2] = PictureAttributeSerializer.getOptionalPictureAttribute(iDeserializer);
            }
        }
        return pictureAttributeArray;
    }
}

