/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carlight.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carlight.ExtLightSensorErrorDetectionState;

public class ExtLightSensorErrorDetectionStateSerializer {
    public static void putOptionalExtLightSensorErrorDetectionState(ISerializer iSerializer, ExtLightSensorErrorDetectionState extLightSensorErrorDetectionState) {
        boolean bl = extLightSensorErrorDetectionState == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = extLightSensorErrorDetectionState.getSensor();
            iSerializer.putInt32(n);
            int n2 = extLightSensorErrorDetectionState.getState();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalExtLightSensorErrorDetectionStateVarArray(ISerializer iSerializer, ExtLightSensorErrorDetectionState[] extLightSensorErrorDetectionStateArray) {
        boolean bl = extLightSensorErrorDetectionStateArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(extLightSensorErrorDetectionStateArray.length);
            for (int i2 = 0; i2 < extLightSensorErrorDetectionStateArray.length; ++i2) {
                ExtLightSensorErrorDetectionStateSerializer.putOptionalExtLightSensorErrorDetectionState(iSerializer, extLightSensorErrorDetectionStateArray[i2]);
            }
        }
    }

    public static ExtLightSensorErrorDetectionState getOptionalExtLightSensorErrorDetectionState(IDeserializer iDeserializer) {
        ExtLightSensorErrorDetectionState extLightSensorErrorDetectionState = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            extLightSensorErrorDetectionState = new ExtLightSensorErrorDetectionState();
            extLightSensorErrorDetectionState.sensor = n2 = iDeserializer.getInt32();
            extLightSensorErrorDetectionState.state = n = iDeserializer.getInt32();
        }
        return extLightSensorErrorDetectionState;
    }

    public static ExtLightSensorErrorDetectionState[] getOptionalExtLightSensorErrorDetectionStateVarArray(IDeserializer iDeserializer) {
        ExtLightSensorErrorDetectionState[] extLightSensorErrorDetectionStateArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            extLightSensorErrorDetectionStateArray = new ExtLightSensorErrorDetectionState[n];
            for (int i2 = 0; i2 < n; ++i2) {
                extLightSensorErrorDetectionStateArray[i2] = ExtLightSensorErrorDetectionStateSerializer.getOptionalExtLightSensorErrorDetectionState(iDeserializer);
            }
        }
        return extLightSensorErrorDetectionStateArray;
    }
}

