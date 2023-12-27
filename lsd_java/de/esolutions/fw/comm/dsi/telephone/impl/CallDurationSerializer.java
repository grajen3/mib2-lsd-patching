/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.telephone.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.telephone.CallDuration;

public class CallDurationSerializer {
    public static void putOptionalCallDuration(ISerializer iSerializer, CallDuration callDuration) {
        boolean bl = callDuration == null;
        iSerializer.putBool(bl);
        if (!bl) {
            short s = callDuration.getTelCallID();
            iSerializer.putInt16(s);
            int n = callDuration.getTelElapsedTime();
            iSerializer.putInt32(n);
        }
    }

    public static void putOptionalCallDurationVarArray(ISerializer iSerializer, CallDuration[] callDurationArray) {
        boolean bl = callDurationArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(callDurationArray.length);
            for (int i2 = 0; i2 < callDurationArray.length; ++i2) {
                CallDurationSerializer.putOptionalCallDuration(iSerializer, callDurationArray[i2]);
            }
        }
    }

    public static CallDuration getOptionalCallDuration(IDeserializer iDeserializer) {
        CallDuration callDuration = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            short s;
            callDuration = new CallDuration();
            callDuration.telCallID = s = iDeserializer.getInt16();
            callDuration.telElapsedTime = n = iDeserializer.getInt32();
        }
        return callDuration;
    }

    public static CallDuration[] getOptionalCallDurationVarArray(IDeserializer iDeserializer) {
        CallDuration[] callDurationArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            callDurationArray = new CallDuration[n];
            for (int i2 = 0; i2 < n; ++i2) {
                callDurationArray[i2] = CallDurationSerializer.getOptionalCallDuration(iDeserializer);
            }
        }
        return callDurationArray;
    }
}

