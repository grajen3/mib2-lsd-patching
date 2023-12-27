/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carvehiclestates.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carvehiclestates.SemiStaticVehicleData;

public class SemiStaticVehicleDataSerializer {
    public static void putOptionalSemiStaticVehicleData(ISerializer iSerializer, SemiStaticVehicleData semiStaticVehicleData) {
        boolean bl = semiStaticVehicleData == null;
        iSerializer.putBool(bl);
        if (!bl) {
            float f2 = semiStaticVehicleData.getMaxChargingAirPressure();
            iSerializer.putFloat(f2);
            int n = semiStaticVehicleData.getMaxOutputPower();
            iSerializer.putInt32(n);
            int n2 = semiStaticVehicleData.getMaxTorque();
            iSerializer.putInt32(n2);
            float f3 = semiStaticVehicleData.getEngineDisplacement();
            iSerializer.putFloat(f3);
            int n3 = semiStaticVehicleData.getTypeOfInjectionSystem();
            iSerializer.putInt32(n3);
        }
    }

    public static void putOptionalSemiStaticVehicleDataVarArray(ISerializer iSerializer, SemiStaticVehicleData[] semiStaticVehicleDataArray) {
        boolean bl = semiStaticVehicleDataArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(semiStaticVehicleDataArray.length);
            for (int i2 = 0; i2 < semiStaticVehicleDataArray.length; ++i2) {
                SemiStaticVehicleDataSerializer.putOptionalSemiStaticVehicleData(iSerializer, semiStaticVehicleDataArray[i2]);
            }
        }
    }

    public static SemiStaticVehicleData getOptionalSemiStaticVehicleData(IDeserializer iDeserializer) {
        SemiStaticVehicleData semiStaticVehicleData = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            float f2;
            int n2;
            int n3;
            float f3;
            semiStaticVehicleData = new SemiStaticVehicleData();
            semiStaticVehicleData.maxChargingAirPressure = f3 = iDeserializer.getFloat();
            semiStaticVehicleData.maxOutputPower = n3 = iDeserializer.getInt32();
            semiStaticVehicleData.maxTorque = n2 = iDeserializer.getInt32();
            semiStaticVehicleData.engineDisplacement = f2 = iDeserializer.getFloat();
            semiStaticVehicleData.typeOfInjectionSystem = n = iDeserializer.getInt32();
        }
        return semiStaticVehicleData;
    }

    public static SemiStaticVehicleData[] getOptionalSemiStaticVehicleDataVarArray(IDeserializer iDeserializer) {
        SemiStaticVehicleData[] semiStaticVehicleDataArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            semiStaticVehicleDataArray = new SemiStaticVehicleData[n];
            for (int i2 = 0; i2 < n; ++i2) {
                semiStaticVehicleDataArray[i2] = SemiStaticVehicleDataSerializer.getOptionalSemiStaticVehicleData(iDeserializer);
            }
        }
        return semiStaticVehicleDataArray;
    }
}

