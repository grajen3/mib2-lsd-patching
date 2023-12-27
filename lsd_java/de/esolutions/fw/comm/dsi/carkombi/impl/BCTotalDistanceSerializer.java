/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carkombi.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carkombi.BCTotalDistance;

public class BCTotalDistanceSerializer {
    public static void putOptionalBCTotalDistance(ISerializer iSerializer, BCTotalDistance bCTotalDistance) {
        boolean bl = bCTotalDistance == null;
        iSerializer.putBool(bl);
        if (!bl) {
            double d2 = bCTotalDistance.getDistanceValue();
            iSerializer.putDouble(d2);
            int n = bCTotalDistance.getDistanceUnit();
            iSerializer.putInt32(n);
        }
    }

    public static void putOptionalBCTotalDistanceVarArray(ISerializer iSerializer, BCTotalDistance[] bCTotalDistanceArray) {
        boolean bl = bCTotalDistanceArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(bCTotalDistanceArray.length);
            for (int i2 = 0; i2 < bCTotalDistanceArray.length; ++i2) {
                BCTotalDistanceSerializer.putOptionalBCTotalDistance(iSerializer, bCTotalDistanceArray[i2]);
            }
        }
    }

    public static BCTotalDistance getOptionalBCTotalDistance(IDeserializer iDeserializer) {
        BCTotalDistance bCTotalDistance = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            double d2;
            bCTotalDistance = new BCTotalDistance();
            bCTotalDistance.distanceValue = d2 = iDeserializer.getDouble();
            bCTotalDistance.distanceUnit = n = iDeserializer.getInt32();
        }
        return bCTotalDistance;
    }

    public static BCTotalDistance[] getOptionalBCTotalDistanceVarArray(IDeserializer iDeserializer) {
        BCTotalDistance[] bCTotalDistanceArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            bCTotalDistanceArray = new BCTotalDistance[n];
            for (int i2 = 0; i2 < n; ++i2) {
                bCTotalDistanceArray[i2] = BCTotalDistanceSerializer.getOptionalBCTotalDistance(iDeserializer);
            }
        }
        return bCTotalDistanceArray;
    }
}

