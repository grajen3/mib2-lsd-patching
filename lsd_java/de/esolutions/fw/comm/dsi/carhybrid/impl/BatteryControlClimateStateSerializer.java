/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carhybrid.impl;

import de.esolutions.fw.comm.dsi.carhybrid.impl.BatteryControlClimateModeSerializer;
import de.esolutions.fw.comm.dsi.carhybrid.impl.BatteryControlSeatheaterActivitySerializer;
import de.esolutions.fw.comm.dsi.carhybrid.impl.BatteryControlWindowheaterActivitySerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carhybrid.BatteryControlClimateMode;
import org.dsi.ifc.carhybrid.BatteryControlClimateState;
import org.dsi.ifc.carhybrid.BatteryControlSeatheaterActivity;
import org.dsi.ifc.carhybrid.BatteryControlWindowheaterActivity;

public class BatteryControlClimateStateSerializer {
    public static void putOptionalBatteryControlClimateState(ISerializer iSerializer, BatteryControlClimateState batteryControlClimateState) {
        boolean bl = batteryControlClimateState == null;
        iSerializer.putBool(bl);
        if (!bl) {
            BatteryControlClimateMode batteryControlClimateMode = batteryControlClimateState.getClimateMode();
            BatteryControlClimateModeSerializer.putOptionalBatteryControlClimateMode(iSerializer, batteryControlClimateMode);
            float f2 = batteryControlClimateState.getCurrentTemperature();
            iSerializer.putFloat(f2);
            int n = batteryControlClimateState.getTemperatureUnit();
            iSerializer.putInt32(n);
            int n2 = batteryControlClimateState.getClimatingTime();
            iSerializer.putInt32(n2);
            int n3 = batteryControlClimateState.getClimateState();
            iSerializer.putInt32(n3);
            int n4 = batteryControlClimateState.getSeatheaterWindowState();
            iSerializer.putInt32(n4);
            BatteryControlSeatheaterActivity batteryControlSeatheaterActivity = batteryControlClimateState.getSeatheaterMode();
            BatteryControlSeatheaterActivitySerializer.putOptionalBatteryControlSeatheaterActivity(iSerializer, batteryControlSeatheaterActivity);
            BatteryControlWindowheaterActivity batteryControlWindowheaterActivity = batteryControlClimateState.getWindowheaterMode();
            BatteryControlWindowheaterActivitySerializer.putOptionalBatteryControlWindowheaterActivity(iSerializer, batteryControlWindowheaterActivity);
        }
    }

    public static void putOptionalBatteryControlClimateStateVarArray(ISerializer iSerializer, BatteryControlClimateState[] batteryControlClimateStateArray) {
        boolean bl = batteryControlClimateStateArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(batteryControlClimateStateArray.length);
            for (int i2 = 0; i2 < batteryControlClimateStateArray.length; ++i2) {
                BatteryControlClimateStateSerializer.putOptionalBatteryControlClimateState(iSerializer, batteryControlClimateStateArray[i2]);
            }
        }
    }

    public static BatteryControlClimateState getOptionalBatteryControlClimateState(IDeserializer iDeserializer) {
        BatteryControlClimateState batteryControlClimateState = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            BatteryControlWindowheaterActivity batteryControlWindowheaterActivity;
            BatteryControlSeatheaterActivity batteryControlSeatheaterActivity;
            int n;
            int n2;
            int n3;
            int n4;
            float f2;
            BatteryControlClimateMode batteryControlClimateMode;
            batteryControlClimateState = new BatteryControlClimateState();
            batteryControlClimateState.climateMode = batteryControlClimateMode = BatteryControlClimateModeSerializer.getOptionalBatteryControlClimateMode(iDeserializer);
            batteryControlClimateState.currentTemperature = f2 = iDeserializer.getFloat();
            batteryControlClimateState.temperatureUnit = n4 = iDeserializer.getInt32();
            batteryControlClimateState.climatingTime = n3 = iDeserializer.getInt32();
            batteryControlClimateState.climateState = n2 = iDeserializer.getInt32();
            batteryControlClimateState.seatheaterWindowState = n = iDeserializer.getInt32();
            batteryControlClimateState.seatheaterMode = batteryControlSeatheaterActivity = BatteryControlSeatheaterActivitySerializer.getOptionalBatteryControlSeatheaterActivity(iDeserializer);
            batteryControlClimateState.windowheaterMode = batteryControlWindowheaterActivity = BatteryControlWindowheaterActivitySerializer.getOptionalBatteryControlWindowheaterActivity(iDeserializer);
        }
        return batteryControlClimateState;
    }

    public static BatteryControlClimateState[] getOptionalBatteryControlClimateStateVarArray(IDeserializer iDeserializer) {
        BatteryControlClimateState[] batteryControlClimateStateArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            batteryControlClimateStateArray = new BatteryControlClimateState[n];
            for (int i2 = 0; i2 < n; ++i2) {
                batteryControlClimateStateArray[i2] = BatteryControlClimateStateSerializer.getOptionalBatteryControlClimateState(iDeserializer);
            }
        }
        return batteryControlClimateStateArray;
    }
}

