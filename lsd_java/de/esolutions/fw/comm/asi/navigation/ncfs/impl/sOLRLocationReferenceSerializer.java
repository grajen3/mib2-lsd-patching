/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.ncfs.impl;

import de.esolutions.fw.comm.asi.navigation.ncfs.sOLRLocationReference;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class sOLRLocationReferenceSerializer {
    public static void putOptionalsOLRLocationReference(ISerializer iSerializer, sOLRLocationReference sOLRLocationReference2) {
        boolean bl = sOLRLocationReference2 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            byte[] byArray = sOLRLocationReference2.getLocation();
            iSerializer.putOptionalInt8VarArray(byArray);
        }
    }

    public static void putOptionalsOLRLocationReferenceVarArray(ISerializer iSerializer, sOLRLocationReference[] sOLRLocationReferenceArray) {
        boolean bl = sOLRLocationReferenceArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sOLRLocationReferenceArray.length);
            for (int i2 = 0; i2 < sOLRLocationReferenceArray.length; ++i2) {
                sOLRLocationReferenceSerializer.putOptionalsOLRLocationReference(iSerializer, sOLRLocationReferenceArray[i2]);
            }
        }
    }

    public static sOLRLocationReference getOptionalsOLRLocationReference(IDeserializer iDeserializer) {
        sOLRLocationReference sOLRLocationReference2 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            sOLRLocationReference2 = new sOLRLocationReference();
            byte[] byArray = iDeserializer.getOptionalInt8VarArray();
            sOLRLocationReference2.location = byArray;
        }
        return sOLRLocationReference2;
    }

    public static sOLRLocationReference[] getOptionalsOLRLocationReferenceVarArray(IDeserializer iDeserializer) {
        sOLRLocationReference[] sOLRLocationReferenceArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sOLRLocationReferenceArray = new sOLRLocationReference[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sOLRLocationReferenceArray[i2] = sOLRLocationReferenceSerializer.getOptionalsOLRLocationReference(iDeserializer);
            }
        }
        return sOLRLocationReferenceArray;
    }
}

