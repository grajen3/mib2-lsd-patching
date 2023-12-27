/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.diagtypes.impl;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sSubsystemState;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class sSubsystemStateSerializer {
    public static void putOptionalsSubsystemState(ISerializer iSerializer, sSubsystemState sSubsystemState2) {
        boolean bl = sSubsystemState2 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = sSubsystemState2.getMsg_id();
            iSerializer.putUInt32(l);
            int n = sSubsystemState2.getState();
            iSerializer.putEnum(n);
        }
    }

    public static void putOptionalsSubsystemStateVarArray(ISerializer iSerializer, sSubsystemState[] sSubsystemStateArray) {
        boolean bl = sSubsystemStateArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sSubsystemStateArray.length);
            for (int i2 = 0; i2 < sSubsystemStateArray.length; ++i2) {
                sSubsystemStateSerializer.putOptionalsSubsystemState(iSerializer, sSubsystemStateArray[i2]);
            }
        }
    }

    public static sSubsystemState getOptionalsSubsystemState(IDeserializer iDeserializer) {
        sSubsystemState sSubsystemState2 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            long l;
            sSubsystemState2 = new sSubsystemState();
            sSubsystemState2.msg_id = l = iDeserializer.getUInt32();
            sSubsystemState2.state = n = iDeserializer.getEnum();
        }
        return sSubsystemState2;
    }

    public static sSubsystemState[] getOptionalsSubsystemStateVarArray(IDeserializer iDeserializer) {
        sSubsystemState[] sSubsystemStateArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sSubsystemStateArray = new sSubsystemState[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sSubsystemStateArray[i2] = sSubsystemStateSerializer.getOptionalsSubsystemState(iDeserializer);
            }
        }
        return sSubsystemStateArray;
    }
}

