/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.diagtypes.impl;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sRoutineResponse;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class sRoutineResponseSerializer {
    public static void putOptionalsRoutineResponse(ISerializer iSerializer, sRoutineResponse sRoutineResponse2) {
        boolean bl = sRoutineResponse2 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = sRoutineResponse2.getMsg_id();
            iSerializer.putUInt32(l);
            int n = sRoutineResponse2.getAction();
            iSerializer.putEnum(n);
            int n2 = sRoutineResponse2.getStatus();
            iSerializer.putEnum(n2);
            int n3 = sRoutineResponse2.getResults();
            iSerializer.putEnum(n3);
        }
    }

    public static void putOptionalsRoutineResponseVarArray(ISerializer iSerializer, sRoutineResponse[] sRoutineResponseArray) {
        boolean bl = sRoutineResponseArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sRoutineResponseArray.length);
            for (int i2 = 0; i2 < sRoutineResponseArray.length; ++i2) {
                sRoutineResponseSerializer.putOptionalsRoutineResponse(iSerializer, sRoutineResponseArray[i2]);
            }
        }
    }

    public static sRoutineResponse getOptionalsRoutineResponse(IDeserializer iDeserializer) {
        sRoutineResponse sRoutineResponse2 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            long l;
            sRoutineResponse2 = new sRoutineResponse();
            sRoutineResponse2.msg_id = l = iDeserializer.getUInt32();
            sRoutineResponse2.action = n3 = iDeserializer.getEnum();
            sRoutineResponse2.status = n2 = iDeserializer.getEnum();
            sRoutineResponse2.results = n = iDeserializer.getEnum();
        }
        return sRoutineResponse2;
    }

    public static sRoutineResponse[] getOptionalsRoutineResponseVarArray(IDeserializer iDeserializer) {
        sRoutineResponse[] sRoutineResponseArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sRoutineResponseArray = new sRoutineResponse[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sRoutineResponseArray[i2] = sRoutineResponseSerializer.getOptionalsRoutineResponse(iDeserializer);
            }
        }
        return sRoutineResponseArray;
    }
}

