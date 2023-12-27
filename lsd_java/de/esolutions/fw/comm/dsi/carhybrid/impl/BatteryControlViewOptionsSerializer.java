/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carhybrid.impl;

import de.esolutions.fw.comm.dsi.carhybrid.impl.BatteryControlConfigurationSerializer;
import de.esolutions.fw.comm.dsi.global.impl.CarViewOptionSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carhybrid.BatteryControlConfiguration;
import org.dsi.ifc.carhybrid.BatteryControlViewOptions;
import org.dsi.ifc.global.CarViewOption;

public class BatteryControlViewOptionsSerializer {
    public static void putOptionalBatteryControlViewOptions(ISerializer iSerializer, BatteryControlViewOptions batteryControlViewOptions) {
        boolean bl = batteryControlViewOptions == null;
        iSerializer.putBool(bl);
        if (!bl) {
            CarViewOption carViewOption = batteryControlViewOptions.getPlug();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption);
            CarViewOption carViewOption2 = batteryControlViewOptions.getChargeState();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption2);
            CarViewOption carViewOption3 = batteryControlViewOptions.getClimateState();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption3);
            CarViewOption carViewOption4 = batteryControlViewOptions.getTimerState();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption4);
            CarViewOption carViewOption5 = batteryControlViewOptions.getImmediately();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption5);
            CarViewOption carViewOption6 = batteryControlViewOptions.getTimer1();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption6);
            CarViewOption carViewOption7 = batteryControlViewOptions.getTimer2();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption7);
            CarViewOption carViewOption8 = batteryControlViewOptions.getTimer3();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption8);
            CarViewOption carViewOption9 = batteryControlViewOptions.getTimer4();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption9);
            CarViewOption carViewOption10 = batteryControlViewOptions.getProfileList();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption10);
            CarViewOption carViewOption11 = batteryControlViewOptions.getPowerProviderList();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption11);
            CarViewOption carViewOption12 = batteryControlViewOptions.getSetFactoryDefault();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption12);
            BatteryControlConfiguration batteryControlConfiguration = batteryControlViewOptions.getConfiguration();
            BatteryControlConfigurationSerializer.putOptionalBatteryControlConfiguration(iSerializer, batteryControlConfiguration);
            CarViewOption carViewOption13 = batteryControlViewOptions.getPastErrorReason();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption13);
            CarViewOption carViewOption14 = batteryControlViewOptions.getPlugDisplayState();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption14);
            CarViewOption carViewOption15 = batteryControlViewOptions.getRemainingChargeTime();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption15);
            CarViewOption carViewOption16 = batteryControlViewOptions.getLowestMaxCurrent();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption16);
        }
    }

    public static void putOptionalBatteryControlViewOptionsVarArray(ISerializer iSerializer, BatteryControlViewOptions[] batteryControlViewOptionsArray) {
        boolean bl = batteryControlViewOptionsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(batteryControlViewOptionsArray.length);
            for (int i2 = 0; i2 < batteryControlViewOptionsArray.length; ++i2) {
                BatteryControlViewOptionsSerializer.putOptionalBatteryControlViewOptions(iSerializer, batteryControlViewOptionsArray[i2]);
            }
        }
    }

    public static BatteryControlViewOptions getOptionalBatteryControlViewOptions(IDeserializer iDeserializer) {
        BatteryControlViewOptions batteryControlViewOptions = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            CarViewOption carViewOption;
            CarViewOption carViewOption2;
            CarViewOption carViewOption3;
            CarViewOption carViewOption4;
            BatteryControlConfiguration batteryControlConfiguration;
            CarViewOption carViewOption5;
            CarViewOption carViewOption6;
            CarViewOption carViewOption7;
            CarViewOption carViewOption8;
            CarViewOption carViewOption9;
            CarViewOption carViewOption10;
            CarViewOption carViewOption11;
            CarViewOption carViewOption12;
            CarViewOption carViewOption13;
            CarViewOption carViewOption14;
            CarViewOption carViewOption15;
            CarViewOption carViewOption16;
            batteryControlViewOptions = new BatteryControlViewOptions();
            batteryControlViewOptions.plug = carViewOption16 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            batteryControlViewOptions.chargeState = carViewOption15 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            batteryControlViewOptions.climateState = carViewOption14 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            batteryControlViewOptions.timerState = carViewOption13 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            batteryControlViewOptions.immediately = carViewOption12 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            batteryControlViewOptions.timer1 = carViewOption11 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            batteryControlViewOptions.timer2 = carViewOption10 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            batteryControlViewOptions.timer3 = carViewOption9 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            batteryControlViewOptions.timer4 = carViewOption8 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            batteryControlViewOptions.profileList = carViewOption7 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            batteryControlViewOptions.powerProviderList = carViewOption6 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            batteryControlViewOptions.setFactoryDefault = carViewOption5 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            batteryControlViewOptions.configuration = batteryControlConfiguration = BatteryControlConfigurationSerializer.getOptionalBatteryControlConfiguration(iDeserializer);
            batteryControlViewOptions.pastErrorReason = carViewOption4 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            batteryControlViewOptions.plugDisplayState = carViewOption3 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            batteryControlViewOptions.remainingChargeTime = carViewOption2 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            batteryControlViewOptions.lowestMaxCurrent = carViewOption = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
        }
        return batteryControlViewOptions;
    }

    public static BatteryControlViewOptions[] getOptionalBatteryControlViewOptionsVarArray(IDeserializer iDeserializer) {
        BatteryControlViewOptions[] batteryControlViewOptionsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            batteryControlViewOptionsArray = new BatteryControlViewOptions[n];
            for (int i2 = 0; i2 < n; ++i2) {
                batteryControlViewOptionsArray[i2] = BatteryControlViewOptionsSerializer.getOptionalBatteryControlViewOptions(iDeserializer);
            }
        }
        return batteryControlViewOptionsArray;
    }
}

