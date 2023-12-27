/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carhybrid.impl;

import de.esolutions.fw.comm.dsi.carhybrid.impl.HybridConfigurationSerializer;
import de.esolutions.fw.comm.dsi.global.impl.CarViewOptionSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carhybrid.HybridConfiguration;
import org.dsi.ifc.carhybrid.HybridViewOptions;
import org.dsi.ifc.global.CarViewOption;

public class HybridViewOptionsSerializer {
    public static void putOptionalHybridViewOptions(ISerializer iSerializer, HybridViewOptions hybridViewOptions) {
        boolean bl = hybridViewOptions == null;
        iSerializer.putBool(bl);
        if (!bl) {
            CarViewOption carViewOption = hybridViewOptions.getHybridEnergyFlowState();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption);
            CarViewOption carViewOption2 = hybridViewOptions.getHybridCharge();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption2);
            CarViewOption carViewOption3 = hybridViewOptions.getHybridRecoveredEnergy();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption3);
            CarViewOption carViewOption4 = hybridViewOptions.getHybridEnergyFlow();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption4);
            HybridConfiguration hybridConfiguration = hybridViewOptions.getHybridConfiguration();
            HybridConfigurationSerializer.putOptionalHybridConfiguration(iSerializer, hybridConfiguration);
            CarViewOption carViewOption5 = hybridViewOptions.getHybridTargetRange();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption5);
            CarViewOption carViewOption6 = hybridViewOptions.getHybridEnergyAssistControl();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption6);
            CarViewOption carViewOption7 = hybridViewOptions.getHybridEnergyAssistState();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption7);
            CarViewOption carViewOption8 = hybridViewOptions.getHybridActivePedal();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption8);
            CarViewOption carViewOption9 = hybridViewOptions.getHybridInhibitReason();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption9);
        }
    }

    public static void putOptionalHybridViewOptionsVarArray(ISerializer iSerializer, HybridViewOptions[] hybridViewOptionsArray) {
        boolean bl = hybridViewOptionsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(hybridViewOptionsArray.length);
            for (int i2 = 0; i2 < hybridViewOptionsArray.length; ++i2) {
                HybridViewOptionsSerializer.putOptionalHybridViewOptions(iSerializer, hybridViewOptionsArray[i2]);
            }
        }
    }

    public static HybridViewOptions getOptionalHybridViewOptions(IDeserializer iDeserializer) {
        HybridViewOptions hybridViewOptions = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            CarViewOption carViewOption;
            CarViewOption carViewOption2;
            CarViewOption carViewOption3;
            CarViewOption carViewOption4;
            CarViewOption carViewOption5;
            HybridConfiguration hybridConfiguration;
            CarViewOption carViewOption6;
            CarViewOption carViewOption7;
            CarViewOption carViewOption8;
            CarViewOption carViewOption9;
            hybridViewOptions = new HybridViewOptions();
            hybridViewOptions.hybridEnergyFlowState = carViewOption9 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            hybridViewOptions.hybridCharge = carViewOption8 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            hybridViewOptions.hybridRecoveredEnergy = carViewOption7 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            hybridViewOptions.hybridEnergyFlow = carViewOption6 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            hybridViewOptions.hybridConfiguration = hybridConfiguration = HybridConfigurationSerializer.getOptionalHybridConfiguration(iDeserializer);
            hybridViewOptions.hybridTargetRange = carViewOption5 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            hybridViewOptions.hybridEnergyAssistControl = carViewOption4 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            hybridViewOptions.hybridEnergyAssistState = carViewOption3 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            hybridViewOptions.hybridActivePedal = carViewOption2 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            hybridViewOptions.hybridInhibitReason = carViewOption = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
        }
        return hybridViewOptions;
    }

    public static HybridViewOptions[] getOptionalHybridViewOptionsVarArray(IDeserializer iDeserializer) {
        HybridViewOptions[] hybridViewOptionsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            hybridViewOptionsArray = new HybridViewOptions[n];
            for (int i2 = 0; i2 < n; ++i2) {
                hybridViewOptionsArray[i2] = HybridViewOptionsSerializer.getOptionalHybridViewOptions(iDeserializer);
            }
        }
        return hybridViewOptionsArray;
    }
}

