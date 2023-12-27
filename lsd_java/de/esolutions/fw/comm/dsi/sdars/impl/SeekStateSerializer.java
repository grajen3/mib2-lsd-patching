/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.sdars.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.sdars.SeekState;

public class SeekStateSerializer {
    public static void putOptionalSeekState(ISerializer iSerializer, SeekState seekState) {
        boolean bl = seekState == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = seekState.getSeekType();
            iSerializer.putInt32(n);
            int n2 = seekState.getState();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalSeekStateVarArray(ISerializer iSerializer, SeekState[] seekStateArray) {
        boolean bl = seekStateArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(seekStateArray.length);
            for (int i2 = 0; i2 < seekStateArray.length; ++i2) {
                SeekStateSerializer.putOptionalSeekState(iSerializer, seekStateArray[i2]);
            }
        }
    }

    public static SeekState getOptionalSeekState(IDeserializer iDeserializer) {
        SeekState seekState = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            seekState = new SeekState();
            seekState.seekType = n2 = iDeserializer.getInt32();
            seekState.state = n = iDeserializer.getInt32();
        }
        return seekState;
    }

    public static SeekState[] getOptionalSeekStateVarArray(IDeserializer iDeserializer) {
        SeekState[] seekStateArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            seekStateArray = new SeekState[n];
            for (int i2 = 0; i2 < n; ++i2) {
                seekStateArray[i2] = SeekStateSerializer.getOptionalSeekState(iDeserializer);
            }
        }
        return seekStateArray;
    }
}

