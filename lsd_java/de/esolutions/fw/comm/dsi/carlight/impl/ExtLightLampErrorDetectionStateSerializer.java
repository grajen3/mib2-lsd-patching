/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carlight.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carlight.ExtLightLampErrorDetectionState;

public class ExtLightLampErrorDetectionStateSerializer {
    public static void putOptionalExtLightLampErrorDetectionState(ISerializer iSerializer, ExtLightLampErrorDetectionState extLightLampErrorDetectionState) {
        boolean bl = extLightLampErrorDetectionState == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = extLightLampErrorDetectionState.getLamp();
            iSerializer.putInt32(n);
            int n2 = extLightLampErrorDetectionState.getState();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalExtLightLampErrorDetectionStateVarArray(ISerializer iSerializer, ExtLightLampErrorDetectionState[] extLightLampErrorDetectionStateArray) {
        boolean bl = extLightLampErrorDetectionStateArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(extLightLampErrorDetectionStateArray.length);
            for (int i2 = 0; i2 < extLightLampErrorDetectionStateArray.length; ++i2) {
                ExtLightLampErrorDetectionStateSerializer.putOptionalExtLightLampErrorDetectionState(iSerializer, extLightLampErrorDetectionStateArray[i2]);
            }
        }
    }

    public static ExtLightLampErrorDetectionState getOptionalExtLightLampErrorDetectionState(IDeserializer iDeserializer) {
        ExtLightLampErrorDetectionState extLightLampErrorDetectionState = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            extLightLampErrorDetectionState = new ExtLightLampErrorDetectionState();
            extLightLampErrorDetectionState.lamp = n2 = iDeserializer.getInt32();
            extLightLampErrorDetectionState.state = n = iDeserializer.getInt32();
        }
        return extLightLampErrorDetectionState;
    }

    public static ExtLightLampErrorDetectionState[] getOptionalExtLightLampErrorDetectionStateVarArray(IDeserializer iDeserializer) {
        ExtLightLampErrorDetectionState[] extLightLampErrorDetectionStateArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            extLightLampErrorDetectionStateArray = new ExtLightLampErrorDetectionState[n];
            for (int i2 = 0; i2 < n; ++i2) {
                extLightLampErrorDetectionStateArray[i2] = ExtLightLampErrorDetectionStateSerializer.getOptionalExtLightLampErrorDetectionState(iDeserializer);
            }
        }
        return extLightLampErrorDetectionStateArray;
    }
}

