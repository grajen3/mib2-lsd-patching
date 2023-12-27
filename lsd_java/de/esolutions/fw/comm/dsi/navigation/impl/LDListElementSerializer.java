/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.navigation.LDListElement;

public class LDListElementSerializer {
    public static void putOptionalLDListElement(ISerializer iSerializer, LDListElement lDListElement) {
        boolean bl = lDListElement == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = lDListElement.getId();
            iSerializer.putInt64(l);
            long l2 = lDListElement.getFlag();
            iSerializer.putInt64(l2);
            String string = lDListElement.getTitle();
            iSerializer.putOptionalString(string);
            String string2 = lDListElement.getCodedTitle();
            iSerializer.putOptionalString(string2);
        }
    }

    public static void putOptionalLDListElementVarArray(ISerializer iSerializer, LDListElement[] lDListElementArray) {
        boolean bl = lDListElementArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(lDListElementArray.length);
            for (int i2 = 0; i2 < lDListElementArray.length; ++i2) {
                LDListElementSerializer.putOptionalLDListElement(iSerializer, lDListElementArray[i2]);
            }
        }
    }

    public static LDListElement getOptionalLDListElement(IDeserializer iDeserializer) {
        LDListElement lDListElement = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            String string2;
            long l;
            long l2;
            lDListElement = new LDListElement();
            lDListElement.id = l2 = iDeserializer.getInt64();
            lDListElement.flag = l = iDeserializer.getInt64();
            lDListElement.title = string2 = iDeserializer.getOptionalString();
            lDListElement.codedTitle = string = iDeserializer.getOptionalString();
        }
        return lDListElement;
    }

    public static LDListElement[] getOptionalLDListElementVarArray(IDeserializer iDeserializer) {
        LDListElement[] lDListElementArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            lDListElementArray = new LDListElement[n];
            for (int i2 = 0; i2 < n; ++i2) {
                lDListElementArray[i2] = LDListElementSerializer.getOptionalLDListElement(iDeserializer);
            }
        }
        return lDListElementArray;
    }
}

