/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.ncfs.impl;

import de.esolutions.fw.comm.asi.navigation.ncfs.sTmcLocationReference;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class sTmcLocationReferenceSerializer {
    public static void putOptionalsTmcLocationReference(ISerializer iSerializer, sTmcLocationReference sTmcLocationReference2) {
        boolean bl = sTmcLocationReference2 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = sTmcLocationReference2.getLocation();
            iSerializer.putUInt16(n);
            short s = sTmcLocationReference2.getCountryCode();
            iSerializer.putUInt8(s);
            short s2 = sTmcLocationReference2.getLtn();
            iSerializer.putUInt8(s2);
            short s3 = sTmcLocationReference2.getExtent();
            iSerializer.putUInt8(s3);
            short s4 = sTmcLocationReference2.getDirection();
            iSerializer.putUInt8(s4);
            long l = sTmcLocationReference2.getOffset();
            iSerializer.putUInt32(l);
            long l2 = sTmcLocationReference2.getHzd();
            iSerializer.putUInt32(l2);
        }
    }

    public static void putOptionalsTmcLocationReferenceVarArray(ISerializer iSerializer, sTmcLocationReference[] sTmcLocationReferenceArray) {
        boolean bl = sTmcLocationReferenceArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sTmcLocationReferenceArray.length);
            for (int i2 = 0; i2 < sTmcLocationReferenceArray.length; ++i2) {
                sTmcLocationReferenceSerializer.putOptionalsTmcLocationReference(iSerializer, sTmcLocationReferenceArray[i2]);
            }
        }
    }

    public static sTmcLocationReference getOptionalsTmcLocationReference(IDeserializer iDeserializer) {
        sTmcLocationReference sTmcLocationReference2 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            long l;
            long l2;
            short s;
            short s2;
            short s3;
            short s4;
            int n;
            sTmcLocationReference2 = new sTmcLocationReference();
            sTmcLocationReference2.location = n = iDeserializer.getUInt16();
            sTmcLocationReference2.countryCode = s4 = iDeserializer.getUInt8();
            sTmcLocationReference2.ltn = s3 = iDeserializer.getUInt8();
            sTmcLocationReference2.extent = s2 = iDeserializer.getUInt8();
            sTmcLocationReference2.direction = s = iDeserializer.getUInt8();
            sTmcLocationReference2.offset = l2 = iDeserializer.getUInt32();
            sTmcLocationReference2.hzd = l = iDeserializer.getUInt32();
        }
        return sTmcLocationReference2;
    }

    public static sTmcLocationReference[] getOptionalsTmcLocationReferenceVarArray(IDeserializer iDeserializer) {
        sTmcLocationReference[] sTmcLocationReferenceArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sTmcLocationReferenceArray = new sTmcLocationReference[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sTmcLocationReferenceArray[i2] = sTmcLocationReferenceSerializer.getOptionalsTmcLocationReference(iDeserializer);
            }
        }
        return sTmcLocationReferenceArray;
    }
}

