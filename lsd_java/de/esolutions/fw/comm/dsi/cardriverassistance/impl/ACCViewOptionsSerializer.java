/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cardriverassistance.impl;

import de.esolutions.fw.comm.dsi.cardriverassistance.impl.ACCConfigurationSerializer;
import de.esolutions.fw.comm.dsi.global.impl.CarViewOptionSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.cardriverassistance.ACCConfiguration;
import org.dsi.ifc.cardriverassistance.ACCViewOptions;
import org.dsi.ifc.global.CarViewOption;

public class ACCViewOptionsSerializer {
    public static void putOptionalACCViewOptions(ISerializer iSerializer, ACCViewOptions aCCViewOptions) {
        boolean bl = aCCViewOptions == null;
        iSerializer.putBool(bl);
        if (!bl) {
            CarViewOption carViewOption = aCCViewOptions.getGongState();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption);
            CarViewOption carViewOption2 = aCCViewOptions.getGongVolume();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption2);
            CarViewOption carViewOption3 = aCCViewOptions.getTimegap();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption3);
            CarViewOption carViewOption4 = aCCViewOptions.getDrivingProgram();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption4);
            CarViewOption carViewOption5 = aCCViewOptions.getDefaultMode();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption5);
            CarViewOption carViewOption6 = aCCViewOptions.getCurveAssist();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption6);
            CarViewOption carViewOption7 = aCCViewOptions.getSpeedLimitAdoption();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption7);
            CarViewOption carViewOption8 = aCCViewOptions.getSpeedLimitOffset();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption8);
            CarViewOption carViewOption9 = aCCViewOptions.getTrafficJamAssist();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption9);
            CarViewOption carViewOption10 = aCCViewOptions.getDistanceWarning();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption10);
            CarViewOption carViewOption11 = aCCViewOptions.getSetFactoryDefault();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption11);
            ACCConfiguration aCCConfiguration = aCCViewOptions.getConfiguration();
            ACCConfigurationSerializer.putOptionalACCConfiguration(iSerializer, aCCConfiguration);
            CarViewOption carViewOption12 = aCCViewOptions.getPaccSensibility();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption12);
            CarViewOption carViewOption13 = aCCViewOptions.getPaccMaxSpeed();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption13);
            CarViewOption carViewOption14 = aCCViewOptions.getPaccMeanVelocity();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption14);
            CarViewOption carViewOption15 = aCCViewOptions.getPaccMeanConsumption();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption15);
            CarViewOption carViewOption16 = aCCViewOptions.getPaccCoastingPercentage();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption16);
            CarViewOption carViewOption17 = aCCViewOptions.getPaccDrivingProgram();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption17);
            CarViewOption carViewOption18 = aCCViewOptions.getPaccSystemState();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption18);
        }
    }

    public static void putOptionalACCViewOptionsVarArray(ISerializer iSerializer, ACCViewOptions[] aCCViewOptionsArray) {
        boolean bl = aCCViewOptionsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(aCCViewOptionsArray.length);
            for (int i2 = 0; i2 < aCCViewOptionsArray.length; ++i2) {
                ACCViewOptionsSerializer.putOptionalACCViewOptions(iSerializer, aCCViewOptionsArray[i2]);
            }
        }
    }

    public static ACCViewOptions getOptionalACCViewOptions(IDeserializer iDeserializer) {
        ACCViewOptions aCCViewOptions = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            CarViewOption carViewOption;
            CarViewOption carViewOption2;
            CarViewOption carViewOption3;
            CarViewOption carViewOption4;
            CarViewOption carViewOption5;
            CarViewOption carViewOption6;
            CarViewOption carViewOption7;
            ACCConfiguration aCCConfiguration;
            CarViewOption carViewOption8;
            CarViewOption carViewOption9;
            CarViewOption carViewOption10;
            CarViewOption carViewOption11;
            CarViewOption carViewOption12;
            CarViewOption carViewOption13;
            CarViewOption carViewOption14;
            CarViewOption carViewOption15;
            CarViewOption carViewOption16;
            CarViewOption carViewOption17;
            CarViewOption carViewOption18;
            aCCViewOptions = new ACCViewOptions();
            aCCViewOptions.gongState = carViewOption18 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            aCCViewOptions.gongVolume = carViewOption17 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            aCCViewOptions.timegap = carViewOption16 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            aCCViewOptions.drivingProgram = carViewOption15 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            aCCViewOptions.defaultMode = carViewOption14 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            aCCViewOptions.curveAssist = carViewOption13 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            aCCViewOptions.speedLimitAdoption = carViewOption12 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            aCCViewOptions.speedLimitOffset = carViewOption11 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            aCCViewOptions.trafficJamAssist = carViewOption10 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            aCCViewOptions.distanceWarning = carViewOption9 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            aCCViewOptions.setFactoryDefault = carViewOption8 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            aCCViewOptions.configuration = aCCConfiguration = ACCConfigurationSerializer.getOptionalACCConfiguration(iDeserializer);
            aCCViewOptions.paccSensibility = carViewOption7 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            aCCViewOptions.paccMaxSpeed = carViewOption6 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            aCCViewOptions.paccMeanVelocity = carViewOption5 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            aCCViewOptions.paccMeanConsumption = carViewOption4 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            aCCViewOptions.paccCoastingPercentage = carViewOption3 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            aCCViewOptions.paccDrivingProgram = carViewOption2 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            aCCViewOptions.paccSystemState = carViewOption = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
        }
        return aCCViewOptions;
    }

    public static ACCViewOptions[] getOptionalACCViewOptionsVarArray(IDeserializer iDeserializer) {
        ACCViewOptions[] aCCViewOptionsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            aCCViewOptionsArray = new ACCViewOptions[n];
            for (int i2 = 0; i2 < n; ++i2) {
                aCCViewOptionsArray[i2] = ACCViewOptionsSerializer.getOptionalACCViewOptions(iDeserializer);
            }
        }
        return aCCViewOptionsArray;
    }
}

