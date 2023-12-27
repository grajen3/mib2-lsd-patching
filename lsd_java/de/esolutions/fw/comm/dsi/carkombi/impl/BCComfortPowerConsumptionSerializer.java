/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carkombi.impl;

import de.esolutions.fw.comm.dsi.global.impl.CarBCConsumptionSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carkombi.BCComfortPowerConsumption;
import org.dsi.ifc.global.CarBCConsumption;

public class BCComfortPowerConsumptionSerializer {
    public static void putOptionalBCComfortPowerConsumption(ISerializer iSerializer, BCComfortPowerConsumption bCComfortPowerConsumption) {
        boolean bl = bCComfortPowerConsumption == null;
        iSerializer.putBool(bl);
        if (!bl) {
            CarBCConsumption carBCConsumption = bCComfortPowerConsumption.getComfortConsumptionST();
            CarBCConsumptionSerializer.putOptionalCarBCConsumption(iSerializer, carBCConsumption);
            CarBCConsumption carBCConsumption2 = bCComfortPowerConsumption.getComfortConsumptionLT();
            CarBCConsumptionSerializer.putOptionalCarBCConsumption(iSerializer, carBCConsumption2);
            CarBCConsumption carBCConsumption3 = bCComfortPowerConsumption.getComfortConsumptionCY();
            CarBCConsumptionSerializer.putOptionalCarBCConsumption(iSerializer, carBCConsumption3);
        }
    }

    public static void putOptionalBCComfortPowerConsumptionVarArray(ISerializer iSerializer, BCComfortPowerConsumption[] bCComfortPowerConsumptionArray) {
        boolean bl = bCComfortPowerConsumptionArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(bCComfortPowerConsumptionArray.length);
            for (int i2 = 0; i2 < bCComfortPowerConsumptionArray.length; ++i2) {
                BCComfortPowerConsumptionSerializer.putOptionalBCComfortPowerConsumption(iSerializer, bCComfortPowerConsumptionArray[i2]);
            }
        }
    }

    public static BCComfortPowerConsumption getOptionalBCComfortPowerConsumption(IDeserializer iDeserializer) {
        BCComfortPowerConsumption bCComfortPowerConsumption = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            CarBCConsumption carBCConsumption;
            CarBCConsumption carBCConsumption2;
            CarBCConsumption carBCConsumption3;
            bCComfortPowerConsumption = new BCComfortPowerConsumption();
            bCComfortPowerConsumption.comfortConsumptionST = carBCConsumption3 = CarBCConsumptionSerializer.getOptionalCarBCConsumption(iDeserializer);
            bCComfortPowerConsumption.comfortConsumptionLT = carBCConsumption2 = CarBCConsumptionSerializer.getOptionalCarBCConsumption(iDeserializer);
            bCComfortPowerConsumption.comfortConsumptionCY = carBCConsumption = CarBCConsumptionSerializer.getOptionalCarBCConsumption(iDeserializer);
        }
        return bCComfortPowerConsumption;
    }

    public static BCComfortPowerConsumption[] getOptionalBCComfortPowerConsumptionVarArray(IDeserializer iDeserializer) {
        BCComfortPowerConsumption[] bCComfortPowerConsumptionArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            bCComfortPowerConsumptionArray = new BCComfortPowerConsumption[n];
            for (int i2 = 0; i2 < n; ++i2) {
                bCComfortPowerConsumptionArray[i2] = BCComfortPowerConsumptionSerializer.getOptionalBCComfortPowerConsumption(iDeserializer);
            }
        }
        return bCComfortPowerConsumptionArray;
    }
}

