/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carcomfort.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carcomfort.RDKSpeedLimit;

public class RDKSpeedLimitSerializer {
    public static void putOptionalRDKSpeedLimit(ISerializer iSerializer, RDKSpeedLimit rDKSpeedLimit) {
        boolean bl = rDKSpeedLimit == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = rDKSpeedLimit.getState();
            iSerializer.putInt32(n);
            int n2 = rDKSpeedLimit.getSpeedValue();
            iSerializer.putInt32(n2);
            int n3 = rDKSpeedLimit.getSpeedUnit();
            iSerializer.putInt32(n3);
        }
    }

    public static void putOptionalRDKSpeedLimitVarArray(ISerializer iSerializer, RDKSpeedLimit[] rDKSpeedLimitArray) {
        boolean bl = rDKSpeedLimitArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(rDKSpeedLimitArray.length);
            for (int i2 = 0; i2 < rDKSpeedLimitArray.length; ++i2) {
                RDKSpeedLimitSerializer.putOptionalRDKSpeedLimit(iSerializer, rDKSpeedLimitArray[i2]);
            }
        }
    }

    public static RDKSpeedLimit getOptionalRDKSpeedLimit(IDeserializer iDeserializer) {
        RDKSpeedLimit rDKSpeedLimit = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            rDKSpeedLimit = new RDKSpeedLimit();
            rDKSpeedLimit.state = n3 = iDeserializer.getInt32();
            rDKSpeedLimit.speedValue = n2 = iDeserializer.getInt32();
            rDKSpeedLimit.speedUnit = n = iDeserializer.getInt32();
        }
        return rDKSpeedLimit;
    }

    public static RDKSpeedLimit[] getOptionalRDKSpeedLimitVarArray(IDeserializer iDeserializer) {
        RDKSpeedLimit[] rDKSpeedLimitArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            rDKSpeedLimitArray = new RDKSpeedLimit[n];
            for (int i2 = 0; i2 < n; ++i2) {
                rDKSpeedLimitArray[i2] = RDKSpeedLimitSerializer.getOptionalRDKSpeedLimit(iDeserializer);
            }
        }
        return rDKSpeedLimitArray;
    }
}

