/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carkombi.impl;

import de.esolutions.fw.comm.dsi.global.impl.CarBCAccelerationSerializer;
import de.esolutions.fw.comm.dsi.global.impl.CarBCSpeedSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carkombi.BCMaxValues;
import org.dsi.ifc.global.CarBCAcceleration;
import org.dsi.ifc.global.CarBCSpeed;

public class BCMaxValuesSerializer {
    public static void putOptionalBCMaxValues(ISerializer iSerializer, BCMaxValues bCMaxValues) {
        boolean bl = bCMaxValues == null;
        iSerializer.putBool(bl);
        if (!bl) {
            CarBCAcceleration carBCAcceleration = bCMaxValues.getMaxLeftLateralAcceleration();
            CarBCAccelerationSerializer.putOptionalCarBCAcceleration(iSerializer, carBCAcceleration);
            CarBCAcceleration carBCAcceleration2 = bCMaxValues.getMaxRightLateralAcceleration();
            CarBCAccelerationSerializer.putOptionalCarBCAcceleration(iSerializer, carBCAcceleration2);
            CarBCAcceleration carBCAcceleration3 = bCMaxValues.getMaxPosLongitudinalAcceleration();
            CarBCAccelerationSerializer.putOptionalCarBCAcceleration(iSerializer, carBCAcceleration3);
            CarBCAcceleration carBCAcceleration4 = bCMaxValues.getMaxNegLongitudinalAcceleration();
            CarBCAccelerationSerializer.putOptionalCarBCAcceleration(iSerializer, carBCAcceleration4);
            CarBCSpeed carBCSpeed = bCMaxValues.getMaxSpeed();
            CarBCSpeedSerializer.putOptionalCarBCSpeed(iSerializer, carBCSpeed);
        }
    }

    public static void putOptionalBCMaxValuesVarArray(ISerializer iSerializer, BCMaxValues[] bCMaxValuesArray) {
        boolean bl = bCMaxValuesArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(bCMaxValuesArray.length);
            for (int i2 = 0; i2 < bCMaxValuesArray.length; ++i2) {
                BCMaxValuesSerializer.putOptionalBCMaxValues(iSerializer, bCMaxValuesArray[i2]);
            }
        }
    }

    public static BCMaxValues getOptionalBCMaxValues(IDeserializer iDeserializer) {
        BCMaxValues bCMaxValues = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            CarBCSpeed carBCSpeed;
            CarBCAcceleration carBCAcceleration;
            CarBCAcceleration carBCAcceleration2;
            CarBCAcceleration carBCAcceleration3;
            CarBCAcceleration carBCAcceleration4;
            bCMaxValues = new BCMaxValues();
            bCMaxValues.maxLeftLateralAcceleration = carBCAcceleration4 = CarBCAccelerationSerializer.getOptionalCarBCAcceleration(iDeserializer);
            bCMaxValues.maxRightLateralAcceleration = carBCAcceleration3 = CarBCAccelerationSerializer.getOptionalCarBCAcceleration(iDeserializer);
            bCMaxValues.maxPosLongitudinalAcceleration = carBCAcceleration2 = CarBCAccelerationSerializer.getOptionalCarBCAcceleration(iDeserializer);
            bCMaxValues.maxNegLongitudinalAcceleration = carBCAcceleration = CarBCAccelerationSerializer.getOptionalCarBCAcceleration(iDeserializer);
            bCMaxValues.maxSpeed = carBCSpeed = CarBCSpeedSerializer.getOptionalCarBCSpeed(iDeserializer);
        }
        return bCMaxValues;
    }

    public static BCMaxValues[] getOptionalBCMaxValuesVarArray(IDeserializer iDeserializer) {
        BCMaxValues[] bCMaxValuesArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            bCMaxValuesArray = new BCMaxValues[n];
            for (int i2 = 0; i2 < n; ++i2) {
                bCMaxValuesArray[i2] = BCMaxValuesSerializer.getOptionalBCMaxValues(iDeserializer);
            }
        }
        return bCMaxValuesArray;
    }
}

