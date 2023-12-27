/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carcomfort.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carcomfort.RDKSpeedLimitAvailability;

public class RDKSpeedLimitAvailabilitySerializer {
    public static void putOptionalRDKSpeedLimitAvailability(ISerializer iSerializer, RDKSpeedLimitAvailability rDKSpeedLimitAvailability) {
        boolean bl = rDKSpeedLimitAvailability == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = rDKSpeedLimitAvailability.isSpeedLimit1();
            iSerializer.putBool(bl2);
            boolean bl3 = rDKSpeedLimitAvailability.isSpeedLimit2();
            iSerializer.putBool(bl3);
            boolean bl4 = rDKSpeedLimitAvailability.isSpeedLimit3();
            iSerializer.putBool(bl4);
        }
    }

    public static void putOptionalRDKSpeedLimitAvailabilityVarArray(ISerializer iSerializer, RDKSpeedLimitAvailability[] rDKSpeedLimitAvailabilityArray) {
        boolean bl = rDKSpeedLimitAvailabilityArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(rDKSpeedLimitAvailabilityArray.length);
            for (int i2 = 0; i2 < rDKSpeedLimitAvailabilityArray.length; ++i2) {
                RDKSpeedLimitAvailabilitySerializer.putOptionalRDKSpeedLimitAvailability(iSerializer, rDKSpeedLimitAvailabilityArray[i2]);
            }
        }
    }

    public static RDKSpeedLimitAvailability getOptionalRDKSpeedLimitAvailability(IDeserializer iDeserializer) {
        RDKSpeedLimitAvailability rDKSpeedLimitAvailability = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            boolean bl4;
            rDKSpeedLimitAvailability = new RDKSpeedLimitAvailability();
            rDKSpeedLimitAvailability.speedLimit1 = bl4 = iDeserializer.getBool();
            rDKSpeedLimitAvailability.speedLimit2 = bl3 = iDeserializer.getBool();
            rDKSpeedLimitAvailability.speedLimit3 = bl2 = iDeserializer.getBool();
        }
        return rDKSpeedLimitAvailability;
    }

    public static RDKSpeedLimitAvailability[] getOptionalRDKSpeedLimitAvailabilityVarArray(IDeserializer iDeserializer) {
        RDKSpeedLimitAvailability[] rDKSpeedLimitAvailabilityArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            rDKSpeedLimitAvailabilityArray = new RDKSpeedLimitAvailability[n];
            for (int i2 = 0; i2 < n; ++i2) {
                rDKSpeedLimitAvailabilityArray[i2] = RDKSpeedLimitAvailabilitySerializer.getOptionalRDKSpeedLimitAvailability(iDeserializer);
            }
        }
        return rDKSpeedLimitAvailabilityArray;
    }
}

