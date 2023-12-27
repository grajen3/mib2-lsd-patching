/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.media.impl;

import de.esolutions.fw.comm.asi.diagnosis.media.sDTCPState;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class sDTCPStateSerializer {
    public static void putOptionalsDTCPState(ISerializer iSerializer, sDTCPState sDTCPState2) {
        boolean bl = sDTCPState2 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = sDTCPState2.getSdisSerialNumber();
            iSerializer.putOptionalString(string);
            int n = sDTCPState2.getEncryption_state();
            iSerializer.putEnum(n);
        }
    }

    public static void putOptionalsDTCPStateVarArray(ISerializer iSerializer, sDTCPState[] sDTCPStateArray) {
        boolean bl = sDTCPStateArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sDTCPStateArray.length);
            for (int i2 = 0; i2 < sDTCPStateArray.length; ++i2) {
                sDTCPStateSerializer.putOptionalsDTCPState(iSerializer, sDTCPStateArray[i2]);
            }
        }
    }

    public static sDTCPState getOptionalsDTCPState(IDeserializer iDeserializer) {
        sDTCPState sDTCPState2 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            String string;
            sDTCPState2 = new sDTCPState();
            sDTCPState2.sdisSerialNumber = string = iDeserializer.getOptionalString();
            sDTCPState2.encryption_state = n = iDeserializer.getEnum();
        }
        return sDTCPState2;
    }

    public static sDTCPState[] getOptionalsDTCPStateVarArray(IDeserializer iDeserializer) {
        sDTCPState[] sDTCPStateArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sDTCPStateArray = new sDTCPState[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sDTCPStateArray[i2] = sDTCPStateSerializer.getOptionalsDTCPState(iDeserializer);
            }
        }
        return sDTCPStateArray;
    }
}

