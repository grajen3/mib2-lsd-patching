/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.diagtypes.impl;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sApplicationSoftwareVersionNumber;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class sApplicationSoftwareVersionNumberSerializer {
    public static void putOptionalsApplicationSoftwareVersionNumber(ISerializer iSerializer, sApplicationSoftwareVersionNumber sApplicationSoftwareVersionNumber2) {
        boolean bl = sApplicationSoftwareVersionNumber2 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = sApplicationSoftwareVersionNumber2.getMsg_id();
            iSerializer.putUInt32(l);
            String string = sApplicationSoftwareVersionNumber2.getNumber();
            iSerializer.putOptionalString(string);
        }
    }

    public static void putOptionalsApplicationSoftwareVersionNumberVarArray(ISerializer iSerializer, sApplicationSoftwareVersionNumber[] sApplicationSoftwareVersionNumberArray) {
        boolean bl = sApplicationSoftwareVersionNumberArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sApplicationSoftwareVersionNumberArray.length);
            for (int i2 = 0; i2 < sApplicationSoftwareVersionNumberArray.length; ++i2) {
                sApplicationSoftwareVersionNumberSerializer.putOptionalsApplicationSoftwareVersionNumber(iSerializer, sApplicationSoftwareVersionNumberArray[i2]);
            }
        }
    }

    public static sApplicationSoftwareVersionNumber getOptionalsApplicationSoftwareVersionNumber(IDeserializer iDeserializer) {
        sApplicationSoftwareVersionNumber sApplicationSoftwareVersionNumber2 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            long l;
            sApplicationSoftwareVersionNumber2 = new sApplicationSoftwareVersionNumber();
            sApplicationSoftwareVersionNumber2.msg_id = l = iDeserializer.getUInt32();
            sApplicationSoftwareVersionNumber2.number = string = iDeserializer.getOptionalString();
        }
        return sApplicationSoftwareVersionNumber2;
    }

    public static sApplicationSoftwareVersionNumber[] getOptionalsApplicationSoftwareVersionNumberVarArray(IDeserializer iDeserializer) {
        sApplicationSoftwareVersionNumber[] sApplicationSoftwareVersionNumberArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sApplicationSoftwareVersionNumberArray = new sApplicationSoftwareVersionNumber[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sApplicationSoftwareVersionNumberArray[i2] = sApplicationSoftwareVersionNumberSerializer.getOptionalsApplicationSoftwareVersionNumber(iDeserializer);
            }
        }
        return sApplicationSoftwareVersionNumberArray;
    }
}

