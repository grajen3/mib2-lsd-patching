/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.media.impl;

import de.esolutions.fw.comm.asi.diagnosis.media.sPmlState;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class sPmlStateSerializer {
    public static void putOptionalsPmlState(ISerializer iSerializer, sPmlState sPmlState2) {
        boolean bl = sPmlState2 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = sPmlState2.getMsg_id();
            iSerializer.putUInt32(l);
            short s = sPmlState2.getLevelSystem();
            iSerializer.putUInt8(s);
            short s2 = sPmlState2.getLevelMedium();
            iSerializer.putUInt8(s2);
        }
    }

    public static void putOptionalsPmlStateVarArray(ISerializer iSerializer, sPmlState[] sPmlStateArray) {
        boolean bl = sPmlStateArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sPmlStateArray.length);
            for (int i2 = 0; i2 < sPmlStateArray.length; ++i2) {
                sPmlStateSerializer.putOptionalsPmlState(iSerializer, sPmlStateArray[i2]);
            }
        }
    }

    public static sPmlState getOptionalsPmlState(IDeserializer iDeserializer) {
        sPmlState sPmlState2 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            short s;
            short s2;
            long l;
            sPmlState2 = new sPmlState();
            sPmlState2.msg_id = l = iDeserializer.getUInt32();
            sPmlState2.levelSystem = s2 = iDeserializer.getUInt8();
            sPmlState2.levelMedium = s = iDeserializer.getUInt8();
        }
        return sPmlState2;
    }

    public static sPmlState[] getOptionalsPmlStateVarArray(IDeserializer iDeserializer) {
        sPmlState[] sPmlStateArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sPmlStateArray = new sPmlState[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sPmlStateArray[i2] = sPmlStateSerializer.getOptionalsPmlState(iDeserializer);
            }
        }
        return sPmlStateArray;
    }
}

