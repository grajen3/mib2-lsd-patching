/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.service.impl;

import de.esolutions.fw.comm.asi.hmisync.car.service.TireDisplayData;
import de.esolutions.fw.comm.asi.hmisync.car.service.WheelPressures;
import de.esolutions.fw.comm.asi.hmisync.car.service.WheelStates;
import de.esolutions.fw.comm.asi.hmisync.car.service.WheelTemperatures;
import de.esolutions.fw.comm.asi.hmisync.car.service.impl.WheelPressuresSerializer;
import de.esolutions.fw.comm.asi.hmisync.car.service.impl.WheelStatesSerializer;
import de.esolutions.fw.comm.asi.hmisync.car.service.impl.WheelTemperaturesSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class TireDisplayDataSerializer {
    public static void putOptionalTireDisplayData(ISerializer iSerializer, TireDisplayData tireDisplayData) {
        boolean bl = tireDisplayData == null;
        iSerializer.putBool(bl);
        if (!bl) {
            WheelStates wheelStates = tireDisplayData.getWheelStates();
            WheelStatesSerializer.putOptionalWheelStates(iSerializer, wheelStates);
            WheelPressures wheelPressures = tireDisplayData.getWheelPressures();
            WheelPressuresSerializer.putOptionalWheelPressures(iSerializer, wheelPressures);
            WheelPressures wheelPressures2 = tireDisplayData.getRequiredWheelPressures();
            WheelPressuresSerializer.putOptionalWheelPressures(iSerializer, wheelPressures2);
            WheelTemperatures wheelTemperatures = tireDisplayData.getWheelTemperatures();
            WheelTemperaturesSerializer.putOptionalWheelTemperatures(iSerializer, wheelTemperatures);
        }
    }

    public static void putOptionalTireDisplayDataVarArray(ISerializer iSerializer, TireDisplayData[] tireDisplayDataArray) {
        boolean bl = tireDisplayDataArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(tireDisplayDataArray.length);
            for (int i2 = 0; i2 < tireDisplayDataArray.length; ++i2) {
                TireDisplayDataSerializer.putOptionalTireDisplayData(iSerializer, tireDisplayDataArray[i2]);
            }
        }
    }

    public static TireDisplayData getOptionalTireDisplayData(IDeserializer iDeserializer) {
        TireDisplayData tireDisplayData = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            WheelTemperatures wheelTemperatures;
            WheelPressures wheelPressures;
            WheelPressures wheelPressures2;
            WheelStates wheelStates;
            tireDisplayData = new TireDisplayData();
            tireDisplayData.wheelStates = wheelStates = WheelStatesSerializer.getOptionalWheelStates(iDeserializer);
            tireDisplayData.wheelPressures = wheelPressures2 = WheelPressuresSerializer.getOptionalWheelPressures(iDeserializer);
            tireDisplayData.requiredWheelPressures = wheelPressures = WheelPressuresSerializer.getOptionalWheelPressures(iDeserializer);
            tireDisplayData.wheelTemperatures = wheelTemperatures = WheelTemperaturesSerializer.getOptionalWheelTemperatures(iDeserializer);
        }
        return tireDisplayData;
    }

    public static TireDisplayData[] getOptionalTireDisplayDataVarArray(IDeserializer iDeserializer) {
        TireDisplayData[] tireDisplayDataArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            tireDisplayDataArray = new TireDisplayData[n];
            for (int i2 = 0; i2 < n; ++i2) {
                tireDisplayDataArray[i2] = TireDisplayDataSerializer.getOptionalTireDisplayData(iDeserializer);
            }
        }
        return tireDisplayDataArray;
    }
}

