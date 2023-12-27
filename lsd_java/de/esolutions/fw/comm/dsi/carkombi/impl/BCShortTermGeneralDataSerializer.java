/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carkombi.impl;

import de.esolutions.fw.comm.dsi.global.impl.CarBCDistanceSerializer;
import de.esolutions.fw.comm.dsi.global.impl.CarBCSpeedSerializer;
import de.esolutions.fw.comm.dsi.global.impl.CarBCTimeSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carkombi.BCShortTermGeneralData;
import org.dsi.ifc.global.CarBCDistance;
import org.dsi.ifc.global.CarBCSpeed;
import org.dsi.ifc.global.CarBCTime;

public class BCShortTermGeneralDataSerializer {
    public static void putOptionalBCShortTermGeneralData(ISerializer iSerializer, BCShortTermGeneralData bCShortTermGeneralData) {
        boolean bl = bCShortTermGeneralData == null;
        iSerializer.putBool(bl);
        if (!bl) {
            CarBCDistance carBCDistance = bCShortTermGeneralData.getDistance();
            CarBCDistanceSerializer.putOptionalCarBCDistance(iSerializer, carBCDistance);
            CarBCSpeed carBCSpeed = bCShortTermGeneralData.getSpeed();
            CarBCSpeedSerializer.putOptionalCarBCSpeed(iSerializer, carBCSpeed);
            CarBCTime carBCTime = bCShortTermGeneralData.getTimeValue();
            CarBCTimeSerializer.putOptionalCarBCTime(iSerializer, carBCTime);
        }
    }

    public static void putOptionalBCShortTermGeneralDataVarArray(ISerializer iSerializer, BCShortTermGeneralData[] bCShortTermGeneralDataArray) {
        boolean bl = bCShortTermGeneralDataArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(bCShortTermGeneralDataArray.length);
            for (int i2 = 0; i2 < bCShortTermGeneralDataArray.length; ++i2) {
                BCShortTermGeneralDataSerializer.putOptionalBCShortTermGeneralData(iSerializer, bCShortTermGeneralDataArray[i2]);
            }
        }
    }

    public static BCShortTermGeneralData getOptionalBCShortTermGeneralData(IDeserializer iDeserializer) {
        BCShortTermGeneralData bCShortTermGeneralData = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            CarBCTime carBCTime;
            CarBCSpeed carBCSpeed;
            CarBCDistance carBCDistance;
            bCShortTermGeneralData = new BCShortTermGeneralData();
            bCShortTermGeneralData.distance = carBCDistance = CarBCDistanceSerializer.getOptionalCarBCDistance(iDeserializer);
            bCShortTermGeneralData.speed = carBCSpeed = CarBCSpeedSerializer.getOptionalCarBCSpeed(iDeserializer);
            bCShortTermGeneralData.timeValue = carBCTime = CarBCTimeSerializer.getOptionalCarBCTime(iDeserializer);
        }
        return bCShortTermGeneralData;
    }

    public static BCShortTermGeneralData[] getOptionalBCShortTermGeneralDataVarArray(IDeserializer iDeserializer) {
        BCShortTermGeneralData[] bCShortTermGeneralDataArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            bCShortTermGeneralDataArray = new BCShortTermGeneralData[n];
            for (int i2 = 0; i2 < n; ++i2) {
                bCShortTermGeneralDataArray[i2] = BCShortTermGeneralDataSerializer.getOptionalBCShortTermGeneralData(iDeserializer);
            }
        }
        return bCShortTermGeneralDataArray;
    }
}

