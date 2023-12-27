/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.navigation.impl;

import de.esolutions.fw.comm.asi.diagnosis.navigation.sNavCalibrationState;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class sNavCalibrationStateSerializer {
    public static void putOptionalsNavCalibrationState(ISerializer iSerializer, sNavCalibrationState sNavCalibrationState2) {
        boolean bl = sNavCalibrationState2 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = sNavCalibrationState2.getMsg_id();
            iSerializer.putUInt32(l);
            int n = sNavCalibrationState2.getCalibrationState();
            iSerializer.putEnum(n);
            int n2 = sNavCalibrationState2.getMileageCalibrationValue();
            iSerializer.putUInt16(n2);
        }
    }

    public static void putOptionalsNavCalibrationStateVarArray(ISerializer iSerializer, sNavCalibrationState[] sNavCalibrationStateArray) {
        boolean bl = sNavCalibrationStateArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sNavCalibrationStateArray.length);
            for (int i2 = 0; i2 < sNavCalibrationStateArray.length; ++i2) {
                sNavCalibrationStateSerializer.putOptionalsNavCalibrationState(iSerializer, sNavCalibrationStateArray[i2]);
            }
        }
    }

    public static sNavCalibrationState getOptionalsNavCalibrationState(IDeserializer iDeserializer) {
        sNavCalibrationState sNavCalibrationState2 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            long l;
            sNavCalibrationState2 = new sNavCalibrationState();
            sNavCalibrationState2.msg_id = l = iDeserializer.getUInt32();
            sNavCalibrationState2.calibrationState = n2 = iDeserializer.getEnum();
            sNavCalibrationState2.mileageCalibrationValue = n = iDeserializer.getUInt16();
        }
        return sNavCalibrationState2;
    }

    public static sNavCalibrationState[] getOptionalsNavCalibrationStateVarArray(IDeserializer iDeserializer) {
        sNavCalibrationState[] sNavCalibrationStateArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sNavCalibrationStateArray = new sNavCalibrationState[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sNavCalibrationStateArray[i2] = sNavCalibrationStateSerializer.getOptionalsNavCalibrationState(iDeserializer);
            }
        }
        return sNavCalibrationStateArray;
    }
}

