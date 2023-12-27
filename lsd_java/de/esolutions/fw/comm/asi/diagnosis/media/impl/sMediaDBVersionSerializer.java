/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.media.impl;

import de.esolutions.fw.comm.asi.diagnosis.media.sMediaDBVersion;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class sMediaDBVersionSerializer {
    public static void putOptionalsMediaDBVersion(ISerializer iSerializer, sMediaDBVersion sMediaDBVersion2) {
        boolean bl = sMediaDBVersion2 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = sMediaDBVersion2.getMsg_id();
            iSerializer.putUInt32(l);
            int n = sMediaDBVersion2.getVersion();
            iSerializer.putUInt16(n);
        }
    }

    public static void putOptionalsMediaDBVersionVarArray(ISerializer iSerializer, sMediaDBVersion[] sMediaDBVersionArray) {
        boolean bl = sMediaDBVersionArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sMediaDBVersionArray.length);
            for (int i2 = 0; i2 < sMediaDBVersionArray.length; ++i2) {
                sMediaDBVersionSerializer.putOptionalsMediaDBVersion(iSerializer, sMediaDBVersionArray[i2]);
            }
        }
    }

    public static sMediaDBVersion getOptionalsMediaDBVersion(IDeserializer iDeserializer) {
        sMediaDBVersion sMediaDBVersion2 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            long l;
            sMediaDBVersion2 = new sMediaDBVersion();
            sMediaDBVersion2.msg_id = l = iDeserializer.getUInt32();
            sMediaDBVersion2.version = n = iDeserializer.getUInt16();
        }
        return sMediaDBVersion2;
    }

    public static sMediaDBVersion[] getOptionalsMediaDBVersionVarArray(IDeserializer iDeserializer) {
        sMediaDBVersion[] sMediaDBVersionArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sMediaDBVersionArray = new sMediaDBVersion[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sMediaDBVersionArray[i2] = sMediaDBVersionSerializer.getOptionalsMediaDBVersion(iDeserializer);
            }
        }
        return sMediaDBVersionArray;
    }
}

