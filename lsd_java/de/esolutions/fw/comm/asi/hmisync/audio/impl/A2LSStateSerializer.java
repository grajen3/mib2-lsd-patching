/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.audio.impl;

import de.esolutions.fw.comm.asi.hmisync.audio.A2LSState;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class A2LSStateSerializer {
    public static void putOptionalA2LSState(ISerializer iSerializer, A2LSState a2LSState) {
        boolean bl = a2LSState == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = a2LSState.getCurrentDevice();
            iSerializer.putOptionalString(string);
            String string2 = a2LSState.getRequestingDevice();
            iSerializer.putOptionalString(string2);
        }
    }

    public static void putOptionalA2LSStateVarArray(ISerializer iSerializer, A2LSState[] a2LSStateArray) {
        boolean bl = a2LSStateArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(a2LSStateArray.length);
            for (int i2 = 0; i2 < a2LSStateArray.length; ++i2) {
                A2LSStateSerializer.putOptionalA2LSState(iSerializer, a2LSStateArray[i2]);
            }
        }
    }

    public static A2LSState getOptionalA2LSState(IDeserializer iDeserializer) {
        A2LSState a2LSState = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            String string2;
            a2LSState = new A2LSState();
            a2LSState.currentDevice = string2 = iDeserializer.getOptionalString();
            a2LSState.requestingDevice = string = iDeserializer.getOptionalString();
        }
        return a2LSState;
    }

    public static A2LSState[] getOptionalA2LSStateVarArray(IDeserializer iDeserializer) {
        A2LSState[] a2LSStateArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            a2LSStateArray = new A2LSState[n];
            for (int i2 = 0; i2 < n; ++i2) {
                a2LSStateArray[i2] = A2LSStateSerializer.getOptionalA2LSState(iDeserializer);
            }
        }
        return a2LSStateArray;
    }
}

