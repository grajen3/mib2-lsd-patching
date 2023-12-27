/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carkombi.impl;

import de.esolutions.fw.comm.dsi.carkombi.impl.BCCounterSerializer;
import de.esolutions.fw.comm.dsi.global.impl.CarBCDistanceSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carkombi.BCCounter;
import org.dsi.ifc.carkombi.BCStatisticsDistanceEU;
import org.dsi.ifc.global.CarBCDistance;

public class BCStatisticsDistanceEUSerializer {
    public static void putOptionalBCStatisticsDistanceEU(ISerializer iSerializer, BCStatisticsDistanceEU bCStatisticsDistanceEU) {
        boolean bl = bCStatisticsDistanceEU == null;
        iSerializer.putBool(bl);
        if (!bl) {
            BCCounter bCCounter = bCStatisticsDistanceEU.getValueCounter();
            BCCounterSerializer.putOptionalBCCounter(iSerializer, bCCounter);
            CarBCDistance carBCDistance = bCStatisticsDistanceEU.getDistancePrimary();
            CarBCDistanceSerializer.putOptionalCarBCDistance(iSerializer, carBCDistance);
            CarBCDistance carBCDistance2 = bCStatisticsDistanceEU.getDistanceSecondary();
            CarBCDistanceSerializer.putOptionalCarBCDistance(iSerializer, carBCDistance2);
            CarBCDistance carBCDistance3 = bCStatisticsDistanceEU.getDistanceEfficiency();
            CarBCDistanceSerializer.putOptionalCarBCDistance(iSerializer, carBCDistance3);
        }
    }

    public static void putOptionalBCStatisticsDistanceEUVarArray(ISerializer iSerializer, BCStatisticsDistanceEU[] bCStatisticsDistanceEUArray) {
        boolean bl = bCStatisticsDistanceEUArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(bCStatisticsDistanceEUArray.length);
            for (int i2 = 0; i2 < bCStatisticsDistanceEUArray.length; ++i2) {
                BCStatisticsDistanceEUSerializer.putOptionalBCStatisticsDistanceEU(iSerializer, bCStatisticsDistanceEUArray[i2]);
            }
        }
    }

    public static BCStatisticsDistanceEU getOptionalBCStatisticsDistanceEU(IDeserializer iDeserializer) {
        BCStatisticsDistanceEU bCStatisticsDistanceEU = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            CarBCDistance carBCDistance;
            CarBCDistance carBCDistance2;
            CarBCDistance carBCDistance3;
            BCCounter bCCounter;
            bCStatisticsDistanceEU = new BCStatisticsDistanceEU();
            bCStatisticsDistanceEU.valueCounter = bCCounter = BCCounterSerializer.getOptionalBCCounter(iDeserializer);
            bCStatisticsDistanceEU.distancePrimary = carBCDistance3 = CarBCDistanceSerializer.getOptionalCarBCDistance(iDeserializer);
            bCStatisticsDistanceEU.distanceSecondary = carBCDistance2 = CarBCDistanceSerializer.getOptionalCarBCDistance(iDeserializer);
            bCStatisticsDistanceEU.distanceEfficiency = carBCDistance = CarBCDistanceSerializer.getOptionalCarBCDistance(iDeserializer);
        }
        return bCStatisticsDistanceEU;
    }

    public static BCStatisticsDistanceEU[] getOptionalBCStatisticsDistanceEUVarArray(IDeserializer iDeserializer) {
        BCStatisticsDistanceEU[] bCStatisticsDistanceEUArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            bCStatisticsDistanceEUArray = new BCStatisticsDistanceEU[n];
            for (int i2 = 0; i2 < n; ++i2) {
                bCStatisticsDistanceEUArray[i2] = BCStatisticsDistanceEUSerializer.getOptionalBCStatisticsDistanceEU(iDeserializer);
            }
        }
        return bCStatisticsDistanceEUArray;
    }
}

