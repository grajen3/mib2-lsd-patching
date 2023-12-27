/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.telephone.impl;

import de.esolutions.fw.comm.asi.diagnosis.telephone.sSimState;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class sSimStateSerializer {
    public static void putOptionalsSimState(ISerializer iSerializer, sSimState sSimState2) {
        boolean bl = sSimState2 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = sSimState2.getMsg_id();
            iSerializer.putUInt32(l);
            int n = sSimState2.getActiveSimLocation();
            iSerializer.putEnum(n);
            short s = sSimState2.getAvailableSimCards();
            iSerializer.putUInt8(s);
            String string = sSimState2.getSimID();
            iSerializer.putOptionalString(string);
            String string2 = sSimState2.getSimIMSI();
            iSerializer.putOptionalString(string2);
        }
    }

    public static void putOptionalsSimStateVarArray(ISerializer iSerializer, sSimState[] sSimStateArray) {
        boolean bl = sSimStateArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sSimStateArray.length);
            for (int i2 = 0; i2 < sSimStateArray.length; ++i2) {
                sSimStateSerializer.putOptionalsSimState(iSerializer, sSimStateArray[i2]);
            }
        }
    }

    public static sSimState getOptionalsSimState(IDeserializer iDeserializer) {
        sSimState sSimState2 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            String string2;
            short s;
            int n;
            long l;
            sSimState2 = new sSimState();
            sSimState2.msg_id = l = iDeserializer.getUInt32();
            sSimState2.activeSimLocation = n = iDeserializer.getEnum();
            sSimState2.availableSimCards = s = iDeserializer.getUInt8();
            sSimState2.simID = string2 = iDeserializer.getOptionalString();
            sSimState2.simIMSI = string = iDeserializer.getOptionalString();
        }
        return sSimState2;
    }

    public static sSimState[] getOptionalsSimStateVarArray(IDeserializer iDeserializer) {
        sSimState[] sSimStateArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sSimStateArray = new sSimState[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sSimStateArray[i2] = sSimStateSerializer.getOptionalsSimState(iDeserializer);
            }
        }
        return sSimStateArray;
    }
}

