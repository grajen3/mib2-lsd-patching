/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.diagtypes.impl;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sSystemName;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class sSystemNameSerializer {
    public static void putOptionalsSystemName(ISerializer iSerializer, sSystemName sSystemName2) {
        boolean bl = sSystemName2 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = sSystemName2.getMsg_id();
            iSerializer.putUInt32(l);
            String string = sSystemName2.getNumber();
            iSerializer.putOptionalString(string);
        }
    }

    public static void putOptionalsSystemNameVarArray(ISerializer iSerializer, sSystemName[] sSystemNameArray) {
        boolean bl = sSystemNameArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sSystemNameArray.length);
            for (int i2 = 0; i2 < sSystemNameArray.length; ++i2) {
                sSystemNameSerializer.putOptionalsSystemName(iSerializer, sSystemNameArray[i2]);
            }
        }
    }

    public static sSystemName getOptionalsSystemName(IDeserializer iDeserializer) {
        sSystemName sSystemName2 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            long l;
            sSystemName2 = new sSystemName();
            sSystemName2.msg_id = l = iDeserializer.getUInt32();
            sSystemName2.number = string = iDeserializer.getOptionalString();
        }
        return sSystemName2;
    }

    public static sSystemName[] getOptionalsSystemNameVarArray(IDeserializer iDeserializer) {
        sSystemName[] sSystemNameArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sSystemNameArray = new sSystemName[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sSystemNameArray[i2] = sSystemNameSerializer.getOptionalsSystemName(iDeserializer);
            }
        }
        return sSystemNameArray;
    }
}

