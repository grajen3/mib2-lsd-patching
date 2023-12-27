/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carcomfort.impl;

import de.esolutions.fw.comm.dsi.carcomfort.impl.RDKWheelPressuresSerializer;
import de.esolutions.fw.comm.dsi.carcomfort.impl.RDKWheelStatesSerializer;
import de.esolutions.fw.comm.dsi.carcomfort.impl.RDKWheelTemperaturesSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carcomfort.RDKTireDisplayData;
import org.dsi.ifc.carcomfort.RDKWheelPressures;
import org.dsi.ifc.carcomfort.RDKWheelStates;
import org.dsi.ifc.carcomfort.RDKWheelTemperatures;

public class RDKTireDisplayDataSerializer {
    public static void putOptionalRDKTireDisplayData(ISerializer iSerializer, RDKTireDisplayData rDKTireDisplayData) {
        boolean bl = rDKTireDisplayData == null;
        iSerializer.putBool(bl);
        if (!bl) {
            RDKWheelStates rDKWheelStates = rDKTireDisplayData.getWheelStates();
            RDKWheelStatesSerializer.putOptionalRDKWheelStates(iSerializer, rDKWheelStates);
            RDKWheelPressures rDKWheelPressures = rDKTireDisplayData.getWheelPressures();
            RDKWheelPressuresSerializer.putOptionalRDKWheelPressures(iSerializer, rDKWheelPressures);
            RDKWheelPressures rDKWheelPressures2 = rDKTireDisplayData.getRequiredWheelPressures();
            RDKWheelPressuresSerializer.putOptionalRDKWheelPressures(iSerializer, rDKWheelPressures2);
            RDKWheelTemperatures rDKWheelTemperatures = rDKTireDisplayData.getWheelTemperatures();
            RDKWheelTemperaturesSerializer.putOptionalRDKWheelTemperatures(iSerializer, rDKWheelTemperatures);
        }
    }

    public static void putOptionalRDKTireDisplayDataVarArray(ISerializer iSerializer, RDKTireDisplayData[] rDKTireDisplayDataArray) {
        boolean bl = rDKTireDisplayDataArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(rDKTireDisplayDataArray.length);
            for (int i2 = 0; i2 < rDKTireDisplayDataArray.length; ++i2) {
                RDKTireDisplayDataSerializer.putOptionalRDKTireDisplayData(iSerializer, rDKTireDisplayDataArray[i2]);
            }
        }
    }

    public static RDKTireDisplayData getOptionalRDKTireDisplayData(IDeserializer iDeserializer) {
        RDKTireDisplayData rDKTireDisplayData = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            RDKWheelTemperatures rDKWheelTemperatures;
            RDKWheelPressures rDKWheelPressures;
            RDKWheelPressures rDKWheelPressures2;
            RDKWheelStates rDKWheelStates;
            rDKTireDisplayData = new RDKTireDisplayData();
            rDKTireDisplayData.wheelStates = rDKWheelStates = RDKWheelStatesSerializer.getOptionalRDKWheelStates(iDeserializer);
            rDKTireDisplayData.wheelPressures = rDKWheelPressures2 = RDKWheelPressuresSerializer.getOptionalRDKWheelPressures(iDeserializer);
            rDKTireDisplayData.requiredWheelPressures = rDKWheelPressures = RDKWheelPressuresSerializer.getOptionalRDKWheelPressures(iDeserializer);
            rDKTireDisplayData.wheelTemperatures = rDKWheelTemperatures = RDKWheelTemperaturesSerializer.getOptionalRDKWheelTemperatures(iDeserializer);
        }
        return rDKTireDisplayData;
    }

    public static RDKTireDisplayData[] getOptionalRDKTireDisplayDataVarArray(IDeserializer iDeserializer) {
        RDKTireDisplayData[] rDKTireDisplayDataArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            rDKTireDisplayDataArray = new RDKTireDisplayData[n];
            for (int i2 = 0; i2 < n; ++i2) {
                rDKTireDisplayDataArray[i2] = RDKTireDisplayDataSerializer.getOptionalRDKTireDisplayData(iDeserializer);
            }
        }
        return rDKTireDisplayDataArray;
    }
}

