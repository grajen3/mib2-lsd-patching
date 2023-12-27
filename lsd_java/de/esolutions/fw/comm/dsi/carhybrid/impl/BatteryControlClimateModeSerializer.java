/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carhybrid.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carhybrid.BatteryControlClimateMode;

public class BatteryControlClimateModeSerializer {
    public static void putOptionalBatteryControlClimateMode(ISerializer iSerializer, BatteryControlClimateMode batteryControlClimateMode) {
        boolean bl = batteryControlClimateMode == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = batteryControlClimateMode.isClimating();
            iSerializer.putBool(bl2);
            boolean bl3 = batteryControlClimateMode.isAutoDefrost();
            iSerializer.putBool(bl3);
            boolean bl4 = batteryControlClimateMode.isHeating();
            iSerializer.putBool(bl4);
            boolean bl5 = batteryControlClimateMode.isCooling();
            iSerializer.putBool(bl5);
            boolean bl6 = batteryControlClimateMode.isVentilation();
            iSerializer.putBool(bl6);
            boolean bl7 = batteryControlClimateMode.isFuelBasedHeating();
            iSerializer.putBool(bl7);
        }
    }

    public static void putOptionalBatteryControlClimateModeVarArray(ISerializer iSerializer, BatteryControlClimateMode[] batteryControlClimateModeArray) {
        boolean bl = batteryControlClimateModeArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(batteryControlClimateModeArray.length);
            for (int i2 = 0; i2 < batteryControlClimateModeArray.length; ++i2) {
                BatteryControlClimateModeSerializer.putOptionalBatteryControlClimateMode(iSerializer, batteryControlClimateModeArray[i2]);
            }
        }
    }

    public static BatteryControlClimateMode getOptionalBatteryControlClimateMode(IDeserializer iDeserializer) {
        BatteryControlClimateMode batteryControlClimateMode = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            boolean bl6;
            boolean bl7;
            batteryControlClimateMode = new BatteryControlClimateMode();
            batteryControlClimateMode.climating = bl7 = iDeserializer.getBool();
            batteryControlClimateMode.autoDefrost = bl6 = iDeserializer.getBool();
            batteryControlClimateMode.heating = bl5 = iDeserializer.getBool();
            batteryControlClimateMode.cooling = bl4 = iDeserializer.getBool();
            batteryControlClimateMode.ventilation = bl3 = iDeserializer.getBool();
            batteryControlClimateMode.fuelBasedHeating = bl2 = iDeserializer.getBool();
        }
        return batteryControlClimateMode;
    }

    public static BatteryControlClimateMode[] getOptionalBatteryControlClimateModeVarArray(IDeserializer iDeserializer) {
        BatteryControlClimateMode[] batteryControlClimateModeArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            batteryControlClimateModeArray = new BatteryControlClimateMode[n];
            for (int i2 = 0; i2 < n; ++i2) {
                batteryControlClimateModeArray[i2] = BatteryControlClimateModeSerializer.getOptionalBatteryControlClimateMode(iDeserializer);
            }
        }
        return batteryControlClimateModeArray;
    }
}

