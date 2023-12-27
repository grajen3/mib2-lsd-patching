/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.navigationAW.impl;

import de.esolutions.fw.comm.asi.diagnosis.navigationAW.sAntennaStateVICS;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class sAntennaStateVICSSerializer {
    public static void putOptionalsAntennaStateVICS(ISerializer iSerializer, sAntennaStateVICS sAntennaStateVICS2) {
        boolean bl = sAntennaStateVICS2 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = sAntennaStateVICS2.getMsg_id();
            iSerializer.putUInt32(l);
            int n = sAntennaStateVICS2.getAntennaState();
            iSerializer.putEnum(n);
        }
    }

    public static void putOptionalsAntennaStateVICSVarArray(ISerializer iSerializer, sAntennaStateVICS[] sAntennaStateVICSArray) {
        boolean bl = sAntennaStateVICSArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sAntennaStateVICSArray.length);
            for (int i2 = 0; i2 < sAntennaStateVICSArray.length; ++i2) {
                sAntennaStateVICSSerializer.putOptionalsAntennaStateVICS(iSerializer, sAntennaStateVICSArray[i2]);
            }
        }
    }

    public static sAntennaStateVICS getOptionalsAntennaStateVICS(IDeserializer iDeserializer) {
        sAntennaStateVICS sAntennaStateVICS2 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            long l;
            sAntennaStateVICS2 = new sAntennaStateVICS();
            sAntennaStateVICS2.msg_id = l = iDeserializer.getUInt32();
            sAntennaStateVICS2.antennaState = n = iDeserializer.getEnum();
        }
        return sAntennaStateVICS2;
    }

    public static sAntennaStateVICS[] getOptionalsAntennaStateVICSVarArray(IDeserializer iDeserializer) {
        sAntennaStateVICS[] sAntennaStateVICSArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sAntennaStateVICSArray = new sAntennaStateVICS[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sAntennaStateVICSArray[i2] = sAntennaStateVICSSerializer.getOptionalsAntennaStateVICS(iDeserializer);
            }
        }
        return sAntennaStateVICSArray;
    }
}

