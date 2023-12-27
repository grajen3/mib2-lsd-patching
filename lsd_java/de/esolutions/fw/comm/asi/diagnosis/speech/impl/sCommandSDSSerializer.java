/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.speech.impl;

import de.esolutions.fw.comm.asi.diagnosis.speech.sCommandSDS;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class sCommandSDSSerializer {
    public static void putOptionalsCommandSDS(ISerializer iSerializer, sCommandSDS sCommandSDS2) {
        boolean bl = sCommandSDS2 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = sCommandSDS2.getMsg_id();
            iSerializer.putUInt32(l);
            short s = sCommandSDS2.getConfidence_level();
            iSerializer.putUInt8(s);
            short s2 = sCommandSDS2.getSignal_quality();
            iSerializer.putUInt8(s2);
            String string = sCommandSDS2.getLast_command();
            iSerializer.putOptionalString(string);
        }
    }

    public static void putOptionalsCommandSDSVarArray(ISerializer iSerializer, sCommandSDS[] sCommandSDSArray) {
        boolean bl = sCommandSDSArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sCommandSDSArray.length);
            for (int i2 = 0; i2 < sCommandSDSArray.length; ++i2) {
                sCommandSDSSerializer.putOptionalsCommandSDS(iSerializer, sCommandSDSArray[i2]);
            }
        }
    }

    public static sCommandSDS getOptionalsCommandSDS(IDeserializer iDeserializer) {
        sCommandSDS sCommandSDS2 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            short s;
            short s2;
            long l;
            sCommandSDS2 = new sCommandSDS();
            sCommandSDS2.msg_id = l = iDeserializer.getUInt32();
            sCommandSDS2.confidence_level = s2 = iDeserializer.getUInt8();
            sCommandSDS2.signal_quality = s = iDeserializer.getUInt8();
            sCommandSDS2.last_command = string = iDeserializer.getOptionalString();
        }
        return sCommandSDS2;
    }

    public static sCommandSDS[] getOptionalsCommandSDSVarArray(IDeserializer iDeserializer) {
        sCommandSDS[] sCommandSDSArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sCommandSDSArray = new sCommandSDS[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sCommandSDSArray[i2] = sCommandSDSSerializer.getOptionalsCommandSDS(iDeserializer);
            }
        }
        return sCommandSDSArray;
    }
}

