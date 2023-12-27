/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.ncfs.impl;

import de.esolutions.fw.comm.asi.navigation.ncfs.sRestriction;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class sRestrictionSerializer {
    public static void putOptionalsRestriction(ISerializer iSerializer, sRestriction sRestriction2) {
        boolean bl = sRestriction2 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = sRestriction2.getId();
            iSerializer.putInt64(l);
            long l2 = sRestriction2.getEdgeId();
            iSerializer.putInt64(l2);
            int n = sRestriction2.getStartAt();
            iSerializer.putInt32(n);
            int n2 = sRestriction2.getEndAt();
            iSerializer.putInt32(n2);
            int n3 = sRestriction2.getType();
            iSerializer.putEnum(n3);
            short s = sRestriction2.getValue();
            iSerializer.putUInt8(s);
            int n4 = sRestriction2.getAddSignType();
            iSerializer.putEnum(n4);
            String string = sRestriction2.getAddSignValue();
            iSerializer.putOptionalString(string);
        }
    }

    public static void putOptionalsRestrictionVarArray(ISerializer iSerializer, sRestriction[] sRestrictionArray) {
        boolean bl = sRestrictionArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sRestrictionArray.length);
            for (int i2 = 0; i2 < sRestrictionArray.length; ++i2) {
                sRestrictionSerializer.putOptionalsRestriction(iSerializer, sRestrictionArray[i2]);
            }
        }
    }

    public static sRestriction getOptionalsRestriction(IDeserializer iDeserializer) {
        sRestriction sRestriction2 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            int n;
            short s;
            int n2;
            int n3;
            int n4;
            long l;
            long l2;
            sRestriction2 = new sRestriction();
            sRestriction2.id = l2 = iDeserializer.getInt64();
            sRestriction2.edgeId = l = iDeserializer.getInt64();
            sRestriction2.startAt = n4 = iDeserializer.getInt32();
            sRestriction2.endAt = n3 = iDeserializer.getInt32();
            sRestriction2.type = n2 = iDeserializer.getEnum();
            sRestriction2.value = s = iDeserializer.getUInt8();
            sRestriction2.addSignType = n = iDeserializer.getEnum();
            sRestriction2.addSignValue = string = iDeserializer.getOptionalString();
        }
        return sRestriction2;
    }

    public static sRestriction[] getOptionalsRestrictionVarArray(IDeserializer iDeserializer) {
        sRestriction[] sRestrictionArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sRestrictionArray = new sRestriction[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sRestrictionArray[i2] = sRestrictionSerializer.getOptionalsRestriction(iDeserializer);
            }
        }
        return sRestrictionArray;
    }
}

