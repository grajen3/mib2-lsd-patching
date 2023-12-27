/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.diagtypes.impl;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sHardwareVersionNumber;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class sHardwareVersionNumberSerializer {
    public static void putOptionalsHardwareVersionNumber(ISerializer iSerializer, sHardwareVersionNumber sHardwareVersionNumber2) {
        boolean bl = sHardwareVersionNumber2 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = sHardwareVersionNumber2.getMsg_id();
            iSerializer.putUInt32(l);
            String string = sHardwareVersionNumber2.getNumber();
            iSerializer.putOptionalString(string);
        }
    }

    public static void putOptionalsHardwareVersionNumberVarArray(ISerializer iSerializer, sHardwareVersionNumber[] sHardwareVersionNumberArray) {
        boolean bl = sHardwareVersionNumberArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sHardwareVersionNumberArray.length);
            for (int i2 = 0; i2 < sHardwareVersionNumberArray.length; ++i2) {
                sHardwareVersionNumberSerializer.putOptionalsHardwareVersionNumber(iSerializer, sHardwareVersionNumberArray[i2]);
            }
        }
    }

    public static sHardwareVersionNumber getOptionalsHardwareVersionNumber(IDeserializer iDeserializer) {
        sHardwareVersionNumber sHardwareVersionNumber2 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            long l;
            sHardwareVersionNumber2 = new sHardwareVersionNumber();
            sHardwareVersionNumber2.msg_id = l = iDeserializer.getUInt32();
            sHardwareVersionNumber2.number = string = iDeserializer.getOptionalString();
        }
        return sHardwareVersionNumber2;
    }

    public static sHardwareVersionNumber[] getOptionalsHardwareVersionNumberVarArray(IDeserializer iDeserializer) {
        sHardwareVersionNumber[] sHardwareVersionNumberArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sHardwareVersionNumberArray = new sHardwareVersionNumber[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sHardwareVersionNumberArray[i2] = sHardwareVersionNumberSerializer.getOptionalsHardwareVersionNumber(iDeserializer);
            }
        }
        return sHardwareVersionNumberArray;
    }
}

