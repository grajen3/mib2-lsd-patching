/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.diagtypes.impl;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sTestStatus;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class sTestStatusSerializer {
    public static void putOptionalsTestStatus(ISerializer iSerializer, sTestStatus sTestStatus2) {
        boolean bl = sTestStatus2 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = sTestStatus2.getInternalDtc();
            iSerializer.putUInt32(l);
            int n = sTestStatus2.getTestResult();
            iSerializer.putEnum(n);
            short[] sArray = sTestStatus2.getEnvData();
            iSerializer.putOptionalUInt8VarArray(sArray);
        }
    }

    public static void putOptionalsTestStatusVarArray(ISerializer iSerializer, sTestStatus[] sTestStatusArray) {
        boolean bl = sTestStatusArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sTestStatusArray.length);
            for (int i2 = 0; i2 < sTestStatusArray.length; ++i2) {
                sTestStatusSerializer.putOptionalsTestStatus(iSerializer, sTestStatusArray[i2]);
            }
        }
    }

    public static sTestStatus getOptionalsTestStatus(IDeserializer iDeserializer) {
        sTestStatus sTestStatus2 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            long l;
            sTestStatus2 = new sTestStatus();
            sTestStatus2.internalDtc = l = iDeserializer.getUInt32();
            sTestStatus2.testResult = n = iDeserializer.getEnum();
            short[] sArray = iDeserializer.getOptionalUInt8VarArray();
            sTestStatus2.envData = sArray;
        }
        return sTestStatus2;
    }

    public static sTestStatus[] getOptionalsTestStatusVarArray(IDeserializer iDeserializer) {
        sTestStatus[] sTestStatusArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sTestStatusArray = new sTestStatus[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sTestStatusArray[i2] = sTestStatusSerializer.getOptionalsTestStatus(iDeserializer);
            }
        }
        return sTestStatusArray;
    }
}

