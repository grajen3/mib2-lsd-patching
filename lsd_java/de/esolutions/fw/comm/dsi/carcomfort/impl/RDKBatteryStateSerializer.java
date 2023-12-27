/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carcomfort.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carcomfort.RDKBatteryState;

public class RDKBatteryStateSerializer {
    public static void putOptionalRDKBatteryState(ISerializer iSerializer, RDKBatteryState rDKBatteryState) {
        boolean bl = rDKBatteryState == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = rDKBatteryState.isOkFrontLeft();
            iSerializer.putBool(bl2);
            boolean bl3 = rDKBatteryState.isOkFrontRight();
            iSerializer.putBool(bl3);
            boolean bl4 = rDKBatteryState.isOkRearLeft();
            iSerializer.putBool(bl4);
            boolean bl5 = rDKBatteryState.isOkRearRight();
            iSerializer.putBool(bl5);
            boolean bl6 = rDKBatteryState.isOkSpareWheel();
            iSerializer.putBool(bl6);
        }
    }

    public static void putOptionalRDKBatteryStateVarArray(ISerializer iSerializer, RDKBatteryState[] rDKBatteryStateArray) {
        boolean bl = rDKBatteryStateArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(rDKBatteryStateArray.length);
            for (int i2 = 0; i2 < rDKBatteryStateArray.length; ++i2) {
                RDKBatteryStateSerializer.putOptionalRDKBatteryState(iSerializer, rDKBatteryStateArray[i2]);
            }
        }
    }

    public static RDKBatteryState getOptionalRDKBatteryState(IDeserializer iDeserializer) {
        RDKBatteryState rDKBatteryState = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            boolean bl6;
            rDKBatteryState = new RDKBatteryState();
            rDKBatteryState.okFrontLeft = bl6 = iDeserializer.getBool();
            rDKBatteryState.okFrontRight = bl5 = iDeserializer.getBool();
            rDKBatteryState.okRearLeft = bl4 = iDeserializer.getBool();
            rDKBatteryState.okRearRight = bl3 = iDeserializer.getBool();
            rDKBatteryState.okSpareWheel = bl2 = iDeserializer.getBool();
        }
        return rDKBatteryState;
    }

    public static RDKBatteryState[] getOptionalRDKBatteryStateVarArray(IDeserializer iDeserializer) {
        RDKBatteryState[] rDKBatteryStateArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            rDKBatteryStateArray = new RDKBatteryState[n];
            for (int i2 = 0; i2 < n; ++i2) {
                rDKBatteryStateArray[i2] = RDKBatteryStateSerializer.getOptionalRDKBatteryState(iDeserializer);
            }
        }
        return rDKBatteryStateArray;
    }
}

