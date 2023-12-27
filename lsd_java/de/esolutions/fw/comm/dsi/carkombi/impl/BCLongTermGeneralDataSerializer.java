/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carkombi.impl;

import de.esolutions.fw.comm.dsi.global.impl.CarBCDistanceSerializer;
import de.esolutions.fw.comm.dsi.global.impl.CarBCSpeedSerializer;
import de.esolutions.fw.comm.dsi.global.impl.CarBCTimeSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carkombi.BCLongTermGeneralData;
import org.dsi.ifc.global.CarBCDistance;
import org.dsi.ifc.global.CarBCSpeed;
import org.dsi.ifc.global.CarBCTime;

public class BCLongTermGeneralDataSerializer {
    public static void putOptionalBCLongTermGeneralData(ISerializer iSerializer, BCLongTermGeneralData bCLongTermGeneralData) {
        boolean bl = bCLongTermGeneralData == null;
        iSerializer.putBool(bl);
        if (!bl) {
            CarBCDistance carBCDistance = bCLongTermGeneralData.getDistance();
            CarBCDistanceSerializer.putOptionalCarBCDistance(iSerializer, carBCDistance);
            CarBCSpeed carBCSpeed = bCLongTermGeneralData.getSpeed();
            CarBCSpeedSerializer.putOptionalCarBCSpeed(iSerializer, carBCSpeed);
            CarBCTime carBCTime = bCLongTermGeneralData.getTimeValue();
            CarBCTimeSerializer.putOptionalCarBCTime(iSerializer, carBCTime);
        }
    }

    public static void putOptionalBCLongTermGeneralDataVarArray(ISerializer iSerializer, BCLongTermGeneralData[] bCLongTermGeneralDataArray) {
        boolean bl = bCLongTermGeneralDataArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(bCLongTermGeneralDataArray.length);
            for (int i2 = 0; i2 < bCLongTermGeneralDataArray.length; ++i2) {
                BCLongTermGeneralDataSerializer.putOptionalBCLongTermGeneralData(iSerializer, bCLongTermGeneralDataArray[i2]);
            }
        }
    }

    public static BCLongTermGeneralData getOptionalBCLongTermGeneralData(IDeserializer iDeserializer) {
        BCLongTermGeneralData bCLongTermGeneralData = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            CarBCTime carBCTime;
            CarBCSpeed carBCSpeed;
            CarBCDistance carBCDistance;
            bCLongTermGeneralData = new BCLongTermGeneralData();
            bCLongTermGeneralData.distance = carBCDistance = CarBCDistanceSerializer.getOptionalCarBCDistance(iDeserializer);
            bCLongTermGeneralData.speed = carBCSpeed = CarBCSpeedSerializer.getOptionalCarBCSpeed(iDeserializer);
            bCLongTermGeneralData.timeValue = carBCTime = CarBCTimeSerializer.getOptionalCarBCTime(iDeserializer);
        }
        return bCLongTermGeneralData;
    }

    public static BCLongTermGeneralData[] getOptionalBCLongTermGeneralDataVarArray(IDeserializer iDeserializer) {
        BCLongTermGeneralData[] bCLongTermGeneralDataArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            bCLongTermGeneralDataArray = new BCLongTermGeneralData[n];
            for (int i2 = 0; i2 < n; ++i2) {
                bCLongTermGeneralDataArray[i2] = BCLongTermGeneralDataSerializer.getOptionalBCLongTermGeneralData(iDeserializer);
            }
        }
        return bCLongTermGeneralDataArray;
    }
}

