/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.ncfs.impl;

import de.esolutions.fw.comm.asi.navigation.ncfs.impl.sOLRLocationReferenceSerializer;
import de.esolutions.fw.comm.asi.navigation.ncfs.sOLRLocationReference;
import de.esolutions.fw.comm.asi.navigation.ncfs.sRectangleSetReference;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class sRectangleSetReferenceSerializer {
    public static void putOptionalsRectangleSetReference(ISerializer iSerializer, sRectangleSetReference sRectangleSetReference2) {
        boolean bl = sRectangleSetReference2 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            sOLRLocationReference[] sOLRLocationReferenceArray = sRectangleSetReference2.getRectangle();
            sOLRLocationReferenceSerializer.putOptionalsOLRLocationReferenceVarArray(iSerializer, sOLRLocationReferenceArray);
        }
    }

    public static void putOptionalsRectangleSetReferenceVarArray(ISerializer iSerializer, sRectangleSetReference[] sRectangleSetReferenceArray) {
        boolean bl = sRectangleSetReferenceArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sRectangleSetReferenceArray.length);
            for (int i2 = 0; i2 < sRectangleSetReferenceArray.length; ++i2) {
                sRectangleSetReferenceSerializer.putOptionalsRectangleSetReference(iSerializer, sRectangleSetReferenceArray[i2]);
            }
        }
    }

    public static sRectangleSetReference getOptionalsRectangleSetReference(IDeserializer iDeserializer) {
        sRectangleSetReference sRectangleSetReference2 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            sRectangleSetReference2 = new sRectangleSetReference();
            sOLRLocationReference[] sOLRLocationReferenceArray = sOLRLocationReferenceSerializer.getOptionalsOLRLocationReferenceVarArray(iDeserializer);
            sRectangleSetReference2.rectangle = sOLRLocationReferenceArray;
        }
        return sRectangleSetReference2;
    }

    public static sRectangleSetReference[] getOptionalsRectangleSetReferenceVarArray(IDeserializer iDeserializer) {
        sRectangleSetReference[] sRectangleSetReferenceArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sRectangleSetReferenceArray = new sRectangleSetReference[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sRectangleSetReferenceArray[i2] = sRectangleSetReferenceSerializer.getOptionalsRectangleSetReference(iDeserializer);
            }
        }
        return sRectangleSetReferenceArray;
    }
}

