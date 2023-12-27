/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.navigationAW.impl;

import de.esolutions.fw.comm.asi.diagnosis.navigationAW.sSubsystemStates;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class sSubsystemStatesSerializer {
    public static void putOptionalsSubsystemStates(ISerializer iSerializer, sSubsystemStates sSubsystemStates2) {
        boolean bl = sSubsystemStates2 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = sSubsystemStates2.getMsg_id();
            iSerializer.putUInt32(l);
            int n = sSubsystemStates2.getStateNavDB();
            iSerializer.putEnum(n);
            int n2 = sSubsystemStates2.getStateVICS();
            iSerializer.putEnum(n2);
            int n3 = sSubsystemStates2.getStateDSRC();
            iSerializer.putEnum(n3);
        }
    }

    public static void putOptionalsSubsystemStatesVarArray(ISerializer iSerializer, sSubsystemStates[] sSubsystemStatesArray) {
        boolean bl = sSubsystemStatesArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sSubsystemStatesArray.length);
            for (int i2 = 0; i2 < sSubsystemStatesArray.length; ++i2) {
                sSubsystemStatesSerializer.putOptionalsSubsystemStates(iSerializer, sSubsystemStatesArray[i2]);
            }
        }
    }

    public static sSubsystemStates getOptionalsSubsystemStates(IDeserializer iDeserializer) {
        sSubsystemStates sSubsystemStates2 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            long l;
            sSubsystemStates2 = new sSubsystemStates();
            sSubsystemStates2.msg_id = l = iDeserializer.getUInt32();
            sSubsystemStates2.stateNavDB = n3 = iDeserializer.getEnum();
            sSubsystemStates2.stateVICS = n2 = iDeserializer.getEnum();
            sSubsystemStates2.stateDSRC = n = iDeserializer.getEnum();
        }
        return sSubsystemStates2;
    }

    public static sSubsystemStates[] getOptionalsSubsystemStatesVarArray(IDeserializer iDeserializer) {
        sSubsystemStates[] sSubsystemStatesArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sSubsystemStatesArray = new sSubsystemStates[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sSubsystemStatesArray[i2] = sSubsystemStatesSerializer.getOptionalsSubsystemStates(iDeserializer);
            }
        }
        return sSubsystemStatesArray;
    }
}

