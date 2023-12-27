/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carkombi.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carkombi.BCZeroEmissionAbsoluteDistance;

public class BCZeroEmissionAbsoluteDistanceSerializer {
    public static void putOptionalBCZeroEmissionAbsoluteDistance(ISerializer iSerializer, BCZeroEmissionAbsoluteDistance bCZeroEmissionAbsoluteDistance) {
        boolean bl = bCZeroEmissionAbsoluteDistance == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = bCZeroEmissionAbsoluteDistance.getState();
            iSerializer.putInt32(n);
            int n2 = bCZeroEmissionAbsoluteDistance.getValue();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalBCZeroEmissionAbsoluteDistanceVarArray(ISerializer iSerializer, BCZeroEmissionAbsoluteDistance[] bCZeroEmissionAbsoluteDistanceArray) {
        boolean bl = bCZeroEmissionAbsoluteDistanceArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(bCZeroEmissionAbsoluteDistanceArray.length);
            for (int i2 = 0; i2 < bCZeroEmissionAbsoluteDistanceArray.length; ++i2) {
                BCZeroEmissionAbsoluteDistanceSerializer.putOptionalBCZeroEmissionAbsoluteDistance(iSerializer, bCZeroEmissionAbsoluteDistanceArray[i2]);
            }
        }
    }

    public static BCZeroEmissionAbsoluteDistance getOptionalBCZeroEmissionAbsoluteDistance(IDeserializer iDeserializer) {
        BCZeroEmissionAbsoluteDistance bCZeroEmissionAbsoluteDistance = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            bCZeroEmissionAbsoluteDistance = new BCZeroEmissionAbsoluteDistance();
            bCZeroEmissionAbsoluteDistance.state = n2 = iDeserializer.getInt32();
            bCZeroEmissionAbsoluteDistance.value = n = iDeserializer.getInt32();
        }
        return bCZeroEmissionAbsoluteDistance;
    }

    public static BCZeroEmissionAbsoluteDistance[] getOptionalBCZeroEmissionAbsoluteDistanceVarArray(IDeserializer iDeserializer) {
        BCZeroEmissionAbsoluteDistance[] bCZeroEmissionAbsoluteDistanceArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            bCZeroEmissionAbsoluteDistanceArray = new BCZeroEmissionAbsoluteDistance[n];
            for (int i2 = 0; i2 < n; ++i2) {
                bCZeroEmissionAbsoluteDistanceArray[i2] = BCZeroEmissionAbsoluteDistanceSerializer.getOptionalBCZeroEmissionAbsoluteDistance(iDeserializer);
            }
        }
        return bCZeroEmissionAbsoluteDistanceArray;
    }
}

