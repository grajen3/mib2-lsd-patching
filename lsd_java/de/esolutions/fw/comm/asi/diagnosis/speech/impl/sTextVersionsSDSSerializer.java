/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.speech.impl;

import de.esolutions.fw.comm.asi.diagnosis.speech.sTextVersionsSDS;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class sTextVersionsSDSSerializer {
    public static void putOptionalsTextVersionsSDS(ISerializer iSerializer, sTextVersionsSDS sTextVersionsSDS2) {
        boolean bl = sTextVersionsSDS2 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = sTextVersionsSDS2.getMsg_id();
            iSerializer.putUInt32(l);
            long l2 = sTextVersionsSDS2.getVersion_1();
            iSerializer.putUInt32(l2);
            long l3 = sTextVersionsSDS2.getVersion_2();
            iSerializer.putUInt32(l3);
        }
    }

    public static void putOptionalsTextVersionsSDSVarArray(ISerializer iSerializer, sTextVersionsSDS[] sTextVersionsSDSArray) {
        boolean bl = sTextVersionsSDSArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sTextVersionsSDSArray.length);
            for (int i2 = 0; i2 < sTextVersionsSDSArray.length; ++i2) {
                sTextVersionsSDSSerializer.putOptionalsTextVersionsSDS(iSerializer, sTextVersionsSDSArray[i2]);
            }
        }
    }

    public static sTextVersionsSDS getOptionalsTextVersionsSDS(IDeserializer iDeserializer) {
        sTextVersionsSDS sTextVersionsSDS2 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            long l;
            long l2;
            long l3;
            sTextVersionsSDS2 = new sTextVersionsSDS();
            sTextVersionsSDS2.msg_id = l3 = iDeserializer.getUInt32();
            sTextVersionsSDS2.version_1 = l2 = iDeserializer.getUInt32();
            sTextVersionsSDS2.version_2 = l = iDeserializer.getUInt32();
        }
        return sTextVersionsSDS2;
    }

    public static sTextVersionsSDS[] getOptionalsTextVersionsSDSVarArray(IDeserializer iDeserializer) {
        sTextVersionsSDS[] sTextVersionsSDSArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sTextVersionsSDSArray = new sTextVersionsSDS[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sTextVersionsSDSArray[i2] = sTextVersionsSDSSerializer.getOptionalsTextVersionsSDS(iDeserializer);
            }
        }
        return sTextVersionsSDSArray;
    }
}

