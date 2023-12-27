/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.ols.impl;

import de.esolutions.fw.comm.asi.diagnosis.ols.sActivationState;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class sActivationStateSerializer {
    public static void putOptionalsActivationState(ISerializer iSerializer, sActivationState sActivationState2) {
        boolean bl = sActivationState2 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = sActivationState2.getMsg_id();
            iSerializer.putUInt32(l);
            short s = sActivationState2.getServiceCounter();
            iSerializer.putUInt8(s);
            short[] sArray = sActivationState2.getServiceID();
            iSerializer.putOptionalUInt8VarArray(sArray);
            int[] nArray = sActivationState2.getStatusCode();
            iSerializer.putOptionalUInt16VarArray(nArray);
            short[] sArray2 = sActivationState2.getActivationYear();
            iSerializer.putOptionalUInt8VarArray(sArray2);
            short[] sArray3 = sActivationState2.getActivationMonth();
            iSerializer.putOptionalUInt8VarArray(sArray3);
            short[] sArray4 = sActivationState2.getActivationDay();
            iSerializer.putOptionalUInt8VarArray(sArray4);
            short[] sArray5 = sActivationState2.getActivationHour();
            iSerializer.putOptionalUInt8VarArray(sArray5);
            short[] sArray6 = sActivationState2.getActivationMinute();
            iSerializer.putOptionalUInt8VarArray(sArray6);
            int[] nArray2 = sActivationState2.getActivationState();
            iSerializer.putOptionalEnumVarArray(nArray2);
            short[] sArray7 = sActivationState2.getExptLicenceYear();
            iSerializer.putOptionalUInt8VarArray(sArray7);
            short[] sArray8 = sActivationState2.getExptLicenceMonth();
            iSerializer.putOptionalUInt8VarArray(sArray8);
            short[] sArray9 = sActivationState2.getExptLicenceDay();
            iSerializer.putOptionalUInt8VarArray(sArray9);
        }
    }

    public static void putOptionalsActivationStateVarArray(ISerializer iSerializer, sActivationState[] sActivationStateArray) {
        boolean bl = sActivationStateArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sActivationStateArray.length);
            for (int i2 = 0; i2 < sActivationStateArray.length; ++i2) {
                sActivationStateSerializer.putOptionalsActivationState(iSerializer, sActivationStateArray[i2]);
            }
        }
    }

    public static sActivationState getOptionalsActivationState(IDeserializer iDeserializer) {
        sActivationState sActivationState2 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            short s;
            long l;
            sActivationState2 = new sActivationState();
            sActivationState2.msg_id = l = iDeserializer.getUInt32();
            sActivationState2.serviceCounter = s = iDeserializer.getUInt8();
            short[] sArray = iDeserializer.getOptionalUInt8VarArray();
            sActivationState2.serviceID = sArray;
            int[] nArray = iDeserializer.getOptionalUInt16VarArray();
            sActivationState2.statusCode = nArray;
            short[] sArray2 = iDeserializer.getOptionalUInt8VarArray();
            sActivationState2.activationYear = sArray2;
            short[] sArray3 = iDeserializer.getOptionalUInt8VarArray();
            sActivationState2.activationMonth = sArray3;
            short[] sArray4 = iDeserializer.getOptionalUInt8VarArray();
            sActivationState2.activationDay = sArray4;
            short[] sArray5 = iDeserializer.getOptionalUInt8VarArray();
            sActivationState2.activationHour = sArray5;
            short[] sArray6 = iDeserializer.getOptionalUInt8VarArray();
            sActivationState2.activationMinute = sArray6;
            int[] nArray2 = iDeserializer.getOptionalEnumVarArray();
            sActivationState2.activationState = nArray2;
            short[] sArray7 = iDeserializer.getOptionalUInt8VarArray();
            sActivationState2.exptLicenceYear = sArray7;
            short[] sArray8 = iDeserializer.getOptionalUInt8VarArray();
            sActivationState2.exptLicenceMonth = sArray8;
            short[] sArray9 = iDeserializer.getOptionalUInt8VarArray();
            sActivationState2.exptLicenceDay = sArray9;
        }
        return sActivationState2;
    }

    public static sActivationState[] getOptionalsActivationStateVarArray(IDeserializer iDeserializer) {
        sActivationState[] sActivationStateArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sActivationStateArray = new sActivationState[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sActivationStateArray[i2] = sActivationStateSerializer.getOptionalsActivationState(iDeserializer);
            }
        }
        return sActivationStateArray;
    }
}

