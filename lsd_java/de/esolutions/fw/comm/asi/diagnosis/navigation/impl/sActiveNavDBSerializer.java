/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.navigation.impl;

import de.esolutions.fw.comm.asi.diagnosis.navigation.sActiveNavDB;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class sActiveNavDBSerializer {
    public static void putOptionalsActiveNavDB(ISerializer iSerializer, sActiveNavDB sActiveNavDB2) {
        boolean bl = sActiveNavDB2 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = sActiveNavDB2.getMsg_id();
            iSerializer.putUInt32(l);
            int n = sActiveNavDB2.getDb();
            iSerializer.putEnum(n);
        }
    }

    public static void putOptionalsActiveNavDBVarArray(ISerializer iSerializer, sActiveNavDB[] sActiveNavDBArray) {
        boolean bl = sActiveNavDBArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sActiveNavDBArray.length);
            for (int i2 = 0; i2 < sActiveNavDBArray.length; ++i2) {
                sActiveNavDBSerializer.putOptionalsActiveNavDB(iSerializer, sActiveNavDBArray[i2]);
            }
        }
    }

    public static sActiveNavDB getOptionalsActiveNavDB(IDeserializer iDeserializer) {
        sActiveNavDB sActiveNavDB2 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            long l;
            sActiveNavDB2 = new sActiveNavDB();
            sActiveNavDB2.msg_id = l = iDeserializer.getUInt32();
            sActiveNavDB2.db = n = iDeserializer.getEnum();
        }
        return sActiveNavDB2;
    }

    public static sActiveNavDB[] getOptionalsActiveNavDBVarArray(IDeserializer iDeserializer) {
        sActiveNavDB[] sActiveNavDBArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sActiveNavDBArray = new sActiveNavDB[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sActiveNavDBArray[i2] = sActiveNavDBSerializer.getOptionalsActiveNavDB(iDeserializer);
            }
        }
        return sActiveNavDBArray;
    }
}

