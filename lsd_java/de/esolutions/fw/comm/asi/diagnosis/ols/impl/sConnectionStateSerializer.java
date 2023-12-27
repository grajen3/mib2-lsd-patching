/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.ols.impl;

import de.esolutions.fw.comm.asi.diagnosis.ols.sConnectionState;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class sConnectionStateSerializer {
    public static void putOptionalsConnectionState(ISerializer iSerializer, sConnectionState sConnectionState2) {
        boolean bl = sConnectionState2 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = sConnectionState2.getMsg_id();
            iSerializer.putUInt32(l);
            short s = sConnectionState2.getServiceCounter();
            iSerializer.putUInt8(s);
            short[] sArray = sConnectionState2.getStepID();
            iSerializer.putOptionalUInt8VarArray(sArray);
            int[] nArray = sConnectionState2.getServerHttpStatusCode();
            iSerializer.putOptionalUInt16VarArray(nArray);
            short[] sArray2 = sConnectionState2.getLastConnYear();
            iSerializer.putOptionalUInt8VarArray(sArray2);
            short[] sArray3 = sConnectionState2.getLastConnMonth();
            iSerializer.putOptionalUInt8VarArray(sArray3);
            short[] sArray4 = sConnectionState2.getLastConnDay();
            iSerializer.putOptionalUInt8VarArray(sArray4);
            short[] sArray5 = sConnectionState2.getLastConnHour();
            iSerializer.putOptionalUInt8VarArray(sArray5);
            short[] sArray6 = sConnectionState2.getLastConnMinute();
            iSerializer.putOptionalUInt8VarArray(sArray6);
        }
    }

    public static void putOptionalsConnectionStateVarArray(ISerializer iSerializer, sConnectionState[] sConnectionStateArray) {
        boolean bl = sConnectionStateArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sConnectionStateArray.length);
            for (int i2 = 0; i2 < sConnectionStateArray.length; ++i2) {
                sConnectionStateSerializer.putOptionalsConnectionState(iSerializer, sConnectionStateArray[i2]);
            }
        }
    }

    public static sConnectionState getOptionalsConnectionState(IDeserializer iDeserializer) {
        sConnectionState sConnectionState2 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            short s;
            long l;
            sConnectionState2 = new sConnectionState();
            sConnectionState2.msg_id = l = iDeserializer.getUInt32();
            sConnectionState2.serviceCounter = s = iDeserializer.getUInt8();
            short[] sArray = iDeserializer.getOptionalUInt8VarArray();
            sConnectionState2.stepID = sArray;
            int[] nArray = iDeserializer.getOptionalUInt16VarArray();
            sConnectionState2.serverHttpStatusCode = nArray;
            short[] sArray2 = iDeserializer.getOptionalUInt8VarArray();
            sConnectionState2.lastConnYear = sArray2;
            short[] sArray3 = iDeserializer.getOptionalUInt8VarArray();
            sConnectionState2.lastConnMonth = sArray3;
            short[] sArray4 = iDeserializer.getOptionalUInt8VarArray();
            sConnectionState2.lastConnDay = sArray4;
            short[] sArray5 = iDeserializer.getOptionalUInt8VarArray();
            sConnectionState2.lastConnHour = sArray5;
            short[] sArray6 = iDeserializer.getOptionalUInt8VarArray();
            sConnectionState2.lastConnMinute = sArray6;
        }
        return sConnectionState2;
    }

    public static sConnectionState[] getOptionalsConnectionStateVarArray(IDeserializer iDeserializer) {
        sConnectionState[] sConnectionStateArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sConnectionStateArray = new sConnectionState[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sConnectionStateArray[i2] = sConnectionStateSerializer.getOptionalsConnectionState(iDeserializer);
            }
        }
        return sConnectionStateArray;
    }
}

