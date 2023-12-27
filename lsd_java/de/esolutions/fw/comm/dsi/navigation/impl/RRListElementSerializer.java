/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.navigation.RRListElement;

public class RRListElementSerializer {
    public static void putOptionalRRListElement(ISerializer iSerializer, RRListElement rRListElement) {
        boolean bl = rRListElement == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = rRListElement.getId();
            iSerializer.putInt64(l);
            long l2 = rRListElement.getFlag();
            iSerializer.putInt64(l2);
            String string = rRListElement.getTitle();
            iSerializer.putOptionalString(string);
        }
    }

    public static void putOptionalRRListElementVarArray(ISerializer iSerializer, RRListElement[] rRListElementArray) {
        boolean bl = rRListElementArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(rRListElementArray.length);
            for (int i2 = 0; i2 < rRListElementArray.length; ++i2) {
                RRListElementSerializer.putOptionalRRListElement(iSerializer, rRListElementArray[i2]);
            }
        }
    }

    public static RRListElement getOptionalRRListElement(IDeserializer iDeserializer) {
        RRListElement rRListElement = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            long l;
            long l2;
            rRListElement = new RRListElement();
            rRListElement.id = l2 = iDeserializer.getInt64();
            rRListElement.flag = l = iDeserializer.getInt64();
            rRListElement.title = string = iDeserializer.getOptionalString();
        }
        return rRListElement;
    }

    public static RRListElement[] getOptionalRRListElementVarArray(IDeserializer iDeserializer) {
        RRListElement[] rRListElementArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            rRListElementArray = new RRListElement[n];
            for (int i2 = 0; i2 < n; ++i2) {
                rRListElementArray[i2] = RRListElementSerializer.getOptionalRRListElement(iDeserializer);
            }
        }
        return rRListElementArray;
    }
}

