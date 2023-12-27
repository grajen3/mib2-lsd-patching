/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cardrivingcharacteristics.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.cardrivingcharacteristics.SpoilerState;

public class SpoilerStateSerializer {
    public static void putOptionalSpoilerState(ISerializer iSerializer, SpoilerState spoilerState) {
        boolean bl = spoilerState == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = spoilerState.getState();
            iSerializer.putInt32(n);
            int n2 = spoilerState.getCurrentPosition();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalSpoilerStateVarArray(ISerializer iSerializer, SpoilerState[] spoilerStateArray) {
        boolean bl = spoilerStateArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(spoilerStateArray.length);
            for (int i2 = 0; i2 < spoilerStateArray.length; ++i2) {
                SpoilerStateSerializer.putOptionalSpoilerState(iSerializer, spoilerStateArray[i2]);
            }
        }
    }

    public static SpoilerState getOptionalSpoilerState(IDeserializer iDeserializer) {
        SpoilerState spoilerState = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            spoilerState = new SpoilerState();
            spoilerState.state = n2 = iDeserializer.getInt32();
            spoilerState.currentPosition = n = iDeserializer.getInt32();
        }
        return spoilerState;
    }

    public static SpoilerState[] getOptionalSpoilerStateVarArray(IDeserializer iDeserializer) {
        SpoilerState[] spoilerStateArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            spoilerStateArray = new SpoilerState[n];
            for (int i2 = 0; i2 < n; ++i2) {
                spoilerStateArray[i2] = SpoilerStateSerializer.getOptionalSpoilerState(iDeserializer);
            }
        }
        return spoilerStateArray;
    }
}

