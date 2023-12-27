/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.global.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.StringAttribute;

public class StringAttributeSerializer {
    public static void putOptionalStringAttribute(ISerializer iSerializer, StringAttribute stringAttribute) {
        boolean bl = stringAttribute == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = stringAttribute.getKey();
            iSerializer.putOptionalString(string);
            String string2 = stringAttribute.getValue();
            iSerializer.putOptionalString(string2);
        }
    }

    public static void putOptionalStringAttributeVarArray(ISerializer iSerializer, StringAttribute[] stringAttributeArray) {
        boolean bl = stringAttributeArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(stringAttributeArray.length);
            for (int i2 = 0; i2 < stringAttributeArray.length; ++i2) {
                StringAttributeSerializer.putOptionalStringAttribute(iSerializer, stringAttributeArray[i2]);
            }
        }
    }

    public static StringAttribute getOptionalStringAttribute(IDeserializer iDeserializer) {
        StringAttribute stringAttribute = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            String string2;
            stringAttribute = new StringAttribute();
            stringAttribute.key = string2 = iDeserializer.getOptionalString();
            stringAttribute.value = string = iDeserializer.getOptionalString();
        }
        return stringAttribute;
    }

    public static StringAttribute[] getOptionalStringAttributeVarArray(IDeserializer iDeserializer) {
        StringAttribute[] stringAttributeArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            stringAttributeArray = new StringAttribute[n];
            for (int i2 = 0; i2 < n; ++i2) {
                stringAttributeArray[i2] = StringAttributeSerializer.getOptionalStringAttribute(iDeserializer);
            }
        }
        return stringAttributeArray;
    }
}

