/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carcomfort.impl;

import de.esolutions.fw.comm.dsi.carcomfort.impl.RDKBatteryStateSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carcomfort.RDKBatteryState;
import org.dsi.ifc.carcomfort.RDKResidualBatteryLifetime;

public class RDKResidualBatteryLifetimeSerializer {
    public static void putOptionalRDKResidualBatteryLifetime(ISerializer iSerializer, RDKResidualBatteryLifetime rDKResidualBatteryLifetime) {
        boolean bl = rDKResidualBatteryLifetime == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = rDKResidualBatteryLifetime.getLifetimeUnit();
            iSerializer.putInt32(n);
            int n2 = rDKResidualBatteryLifetime.getLifetimeFrontLeft();
            iSerializer.putInt32(n2);
            int n3 = rDKResidualBatteryLifetime.getLifetimeFrontRight();
            iSerializer.putInt32(n3);
            int n4 = rDKResidualBatteryLifetime.getLifetimeRearLeft();
            iSerializer.putInt32(n4);
            int n5 = rDKResidualBatteryLifetime.getLifetimeRearRight();
            iSerializer.putInt32(n5);
            int n6 = rDKResidualBatteryLifetime.getLifetimeSpareWheel();
            iSerializer.putInt32(n6);
            RDKBatteryState rDKBatteryState = rDKResidualBatteryLifetime.getBatteryState();
            RDKBatteryStateSerializer.putOptionalRDKBatteryState(iSerializer, rDKBatteryState);
        }
    }

    public static void putOptionalRDKResidualBatteryLifetimeVarArray(ISerializer iSerializer, RDKResidualBatteryLifetime[] rDKResidualBatteryLifetimeArray) {
        boolean bl = rDKResidualBatteryLifetimeArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(rDKResidualBatteryLifetimeArray.length);
            for (int i2 = 0; i2 < rDKResidualBatteryLifetimeArray.length; ++i2) {
                RDKResidualBatteryLifetimeSerializer.putOptionalRDKResidualBatteryLifetime(iSerializer, rDKResidualBatteryLifetimeArray[i2]);
            }
        }
    }

    public static RDKResidualBatteryLifetime getOptionalRDKResidualBatteryLifetime(IDeserializer iDeserializer) {
        RDKResidualBatteryLifetime rDKResidualBatteryLifetime = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            RDKBatteryState rDKBatteryState;
            int n;
            int n2;
            int n3;
            int n4;
            int n5;
            int n6;
            rDKResidualBatteryLifetime = new RDKResidualBatteryLifetime();
            rDKResidualBatteryLifetime.lifetimeUnit = n6 = iDeserializer.getInt32();
            rDKResidualBatteryLifetime.lifetimeFrontLeft = n5 = iDeserializer.getInt32();
            rDKResidualBatteryLifetime.lifetimeFrontRight = n4 = iDeserializer.getInt32();
            rDKResidualBatteryLifetime.lifetimeRearLeft = n3 = iDeserializer.getInt32();
            rDKResidualBatteryLifetime.lifetimeRearRight = n2 = iDeserializer.getInt32();
            rDKResidualBatteryLifetime.lifetimeSpareWheel = n = iDeserializer.getInt32();
            rDKResidualBatteryLifetime.batteryState = rDKBatteryState = RDKBatteryStateSerializer.getOptionalRDKBatteryState(iDeserializer);
        }
        return rDKResidualBatteryLifetime;
    }

    public static RDKResidualBatteryLifetime[] getOptionalRDKResidualBatteryLifetimeVarArray(IDeserializer iDeserializer) {
        RDKResidualBatteryLifetime[] rDKResidualBatteryLifetimeArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            rDKResidualBatteryLifetimeArray = new RDKResidualBatteryLifetime[n];
            for (int i2 = 0; i2 < n; ++i2) {
                rDKResidualBatteryLifetimeArray[i2] = RDKResidualBatteryLifetimeSerializer.getOptionalRDKResidualBatteryLifetime(iDeserializer);
            }
        }
        return rDKResidualBatteryLifetimeArray;
    }
}

