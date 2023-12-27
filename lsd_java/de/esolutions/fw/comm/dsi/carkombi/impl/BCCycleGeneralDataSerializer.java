/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carkombi.impl;

import de.esolutions.fw.comm.dsi.global.impl.CarBCDistanceSerializer;
import de.esolutions.fw.comm.dsi.global.impl.CarBCSpeedSerializer;
import de.esolutions.fw.comm.dsi.global.impl.CarBCTimeSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carkombi.BCCycleGeneralData;
import org.dsi.ifc.global.CarBCDistance;
import org.dsi.ifc.global.CarBCSpeed;
import org.dsi.ifc.global.CarBCTime;

public class BCCycleGeneralDataSerializer {
    public static void putOptionalBCCycleGeneralData(ISerializer iSerializer, BCCycleGeneralData bCCycleGeneralData) {
        boolean bl = bCCycleGeneralData == null;
        iSerializer.putBool(bl);
        if (!bl) {
            CarBCDistance carBCDistance = bCCycleGeneralData.getDistance();
            CarBCDistanceSerializer.putOptionalCarBCDistance(iSerializer, carBCDistance);
            CarBCSpeed carBCSpeed = bCCycleGeneralData.getSpeed();
            CarBCSpeedSerializer.putOptionalCarBCSpeed(iSerializer, carBCSpeed);
            CarBCTime carBCTime = bCCycleGeneralData.getTimeValue();
            CarBCTimeSerializer.putOptionalCarBCTime(iSerializer, carBCTime);
        }
    }

    public static void putOptionalBCCycleGeneralDataVarArray(ISerializer iSerializer, BCCycleGeneralData[] bCCycleGeneralDataArray) {
        boolean bl = bCCycleGeneralDataArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(bCCycleGeneralDataArray.length);
            for (int i2 = 0; i2 < bCCycleGeneralDataArray.length; ++i2) {
                BCCycleGeneralDataSerializer.putOptionalBCCycleGeneralData(iSerializer, bCCycleGeneralDataArray[i2]);
            }
        }
    }

    public static BCCycleGeneralData getOptionalBCCycleGeneralData(IDeserializer iDeserializer) {
        BCCycleGeneralData bCCycleGeneralData = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            CarBCTime carBCTime;
            CarBCSpeed carBCSpeed;
            CarBCDistance carBCDistance;
            bCCycleGeneralData = new BCCycleGeneralData();
            bCCycleGeneralData.distance = carBCDistance = CarBCDistanceSerializer.getOptionalCarBCDistance(iDeserializer);
            bCCycleGeneralData.speed = carBCSpeed = CarBCSpeedSerializer.getOptionalCarBCSpeed(iDeserializer);
            bCCycleGeneralData.timeValue = carBCTime = CarBCTimeSerializer.getOptionalCarBCTime(iDeserializer);
        }
        return bCCycleGeneralData;
    }

    public static BCCycleGeneralData[] getOptionalBCCycleGeneralDataVarArray(IDeserializer iDeserializer) {
        BCCycleGeneralData[] bCCycleGeneralDataArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            bCCycleGeneralDataArray = new BCCycleGeneralData[n];
            for (int i2 = 0; i2 < n; ++i2) {
                bCCycleGeneralDataArray[i2] = BCCycleGeneralDataSerializer.getOptionalBCCycleGeneralData(iDeserializer);
            }
        }
        return bCCycleGeneralDataArray;
    }
}

