/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.navigation.impl;

import de.esolutions.fw.comm.asi.diagnosis.navigation.sVersionsNavDB;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class sVersionsNavDBSerializer {
    public static void putOptionalsVersionsNavDB(ISerializer iSerializer, sVersionsNavDB sVersionsNavDB2) {
        boolean bl = sVersionsNavDB2 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = sVersionsNavDB2.getMsg_id();
            iSerializer.putUInt32(l);
            String string = sVersionsNavDB2.getSd1();
            iSerializer.putOptionalString(string);
            String string2 = sVersionsNavDB2.getSd2();
            iSerializer.putOptionalString(string2);
            String string3 = sVersionsNavDB2.getOpticalDrive();
            iSerializer.putOptionalString(string3);
            String string4 = sVersionsNavDB2.getHdd();
            iSerializer.putOptionalString(string4);
        }
    }

    public static void putOptionalsVersionsNavDBVarArray(ISerializer iSerializer, sVersionsNavDB[] sVersionsNavDBArray) {
        boolean bl = sVersionsNavDBArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sVersionsNavDBArray.length);
            for (int i2 = 0; i2 < sVersionsNavDBArray.length; ++i2) {
                sVersionsNavDBSerializer.putOptionalsVersionsNavDB(iSerializer, sVersionsNavDBArray[i2]);
            }
        }
    }

    public static sVersionsNavDB getOptionalsVersionsNavDB(IDeserializer iDeserializer) {
        sVersionsNavDB sVersionsNavDB2 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            String string2;
            String string3;
            String string4;
            long l;
            sVersionsNavDB2 = new sVersionsNavDB();
            sVersionsNavDB2.msg_id = l = iDeserializer.getUInt32();
            sVersionsNavDB2.sd1 = string4 = iDeserializer.getOptionalString();
            sVersionsNavDB2.sd2 = string3 = iDeserializer.getOptionalString();
            sVersionsNavDB2.opticalDrive = string2 = iDeserializer.getOptionalString();
            sVersionsNavDB2.hdd = string = iDeserializer.getOptionalString();
        }
        return sVersionsNavDB2;
    }

    public static sVersionsNavDB[] getOptionalsVersionsNavDBVarArray(IDeserializer iDeserializer) {
        sVersionsNavDB[] sVersionsNavDBArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sVersionsNavDBArray = new sVersionsNavDB[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sVersionsNavDBArray[i2] = sVersionsNavDBSerializer.getOptionalsVersionsNavDB(iDeserializer);
            }
        }
        return sVersionsNavDBArray;
    }
}

