/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cardriverassistance.impl;

import de.esolutions.fw.comm.dsi.cardriverassistance.impl.AWVConfigurationSerializer;
import de.esolutions.fw.comm.dsi.global.impl.CarViewOptionSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.cardriverassistance.AWVConfiguration;
import org.dsi.ifc.cardriverassistance.AWVViewOptions;
import org.dsi.ifc.global.CarViewOption;

public class AWVViewOptionsSerializer {
    public static void putOptionalAWVViewOptions(ISerializer iSerializer, AWVViewOptions aWVViewOptions) {
        boolean bl = aWVViewOptions == null;
        iSerializer.putBool(bl);
        if (!bl) {
            CarViewOption carViewOption = aWVViewOptions.getSystem();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption);
            CarViewOption carViewOption2 = aWVViewOptions.getWarning();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption2);
            CarViewOption carViewOption3 = aWVViewOptions.getGong();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption3);
            CarViewOption carViewOption4 = aWVViewOptions.getGongVolume();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption4);
            CarViewOption carViewOption5 = aWVViewOptions.getBrakeJerk();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption5);
            CarViewOption carViewOption6 = aWVViewOptions.getEmergencyBrake();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption6);
            CarViewOption carViewOption7 = aWVViewOptions.getDistanceWarning();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption7);
            CarViewOption carViewOption8 = aWVViewOptions.getWarningTimegap();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption8);
            CarViewOption carViewOption9 = aWVViewOptions.getSetFactoryDefault();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption9);
            AWVConfiguration aWVConfiguration = aWVViewOptions.getConfiguration();
            AWVConfigurationSerializer.putOptionalAWVConfiguration(iSerializer, aWVConfiguration);
        }
    }

    public static void putOptionalAWVViewOptionsVarArray(ISerializer iSerializer, AWVViewOptions[] aWVViewOptionsArray) {
        boolean bl = aWVViewOptionsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(aWVViewOptionsArray.length);
            for (int i2 = 0; i2 < aWVViewOptionsArray.length; ++i2) {
                AWVViewOptionsSerializer.putOptionalAWVViewOptions(iSerializer, aWVViewOptionsArray[i2]);
            }
        }
    }

    public static AWVViewOptions getOptionalAWVViewOptions(IDeserializer iDeserializer) {
        AWVViewOptions aWVViewOptions = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            AWVConfiguration aWVConfiguration;
            CarViewOption carViewOption;
            CarViewOption carViewOption2;
            CarViewOption carViewOption3;
            CarViewOption carViewOption4;
            CarViewOption carViewOption5;
            CarViewOption carViewOption6;
            CarViewOption carViewOption7;
            CarViewOption carViewOption8;
            CarViewOption carViewOption9;
            aWVViewOptions = new AWVViewOptions();
            aWVViewOptions.system = carViewOption9 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            aWVViewOptions.warning = carViewOption8 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            aWVViewOptions.gong = carViewOption7 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            aWVViewOptions.gongVolume = carViewOption6 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            aWVViewOptions.brakeJerk = carViewOption5 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            aWVViewOptions.emergencyBrake = carViewOption4 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            aWVViewOptions.distanceWarning = carViewOption3 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            aWVViewOptions.warningTimegap = carViewOption2 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            aWVViewOptions.setFactoryDefault = carViewOption = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            aWVViewOptions.configuration = aWVConfiguration = AWVConfigurationSerializer.getOptionalAWVConfiguration(iDeserializer);
        }
        return aWVViewOptions;
    }

    public static AWVViewOptions[] getOptionalAWVViewOptionsVarArray(IDeserializer iDeserializer) {
        AWVViewOptions[] aWVViewOptionsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            aWVViewOptionsArray = new AWVViewOptions[n];
            for (int i2 = 0; i2 < n; ++i2) {
                aWVViewOptionsArray[i2] = AWVViewOptionsSerializer.getOptionalAWVViewOptions(iDeserializer);
            }
        }
        return aWVViewOptionsArray;
    }
}

