/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.careco.impl;

import de.esolutions.fw.comm.dsi.careco.impl.BCmEConfigurationSerializer;
import de.esolutions.fw.comm.dsi.global.impl.CarViewOptionSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.careco.BCmEConfiguration;
import org.dsi.ifc.careco.BCmEViewOptions;
import org.dsi.ifc.global.CarViewOption;

public class BCmEViewOptionsSerializer {
    public static void putOptionalBCmEViewOptions(ISerializer iSerializer, BCmEViewOptions bCmEViewOptions) {
        boolean bl = bCmEViewOptions == null;
        iSerializer.putBool(bl);
        if (!bl) {
            CarViewOption carViewOption = bCmEViewOptions.getConsumerList();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption);
            CarViewOption carViewOption2 = bCmEViewOptions.getConsumption();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption2);
            CarViewOption carViewOption3 = bCmEViewOptions.getLiveTip();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption3);
            CarViewOption carViewOption4 = bCmEViewOptions.getEnergyFlowComfort();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption4);
            CarViewOption carViewOption5 = bCmEViewOptions.getRangeGainTotal();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption5);
            CarViewOption carViewOption6 = bCmEViewOptions.getConsumerListConsumption();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption6);
            CarViewOption carViewOption7 = bCmEViewOptions.getConsumerListRange();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption7);
            CarViewOption carViewOption8 = bCmEViewOptions.getCurrentRange();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption8);
            CarViewOption carViewOption9 = bCmEViewOptions.getBcmeSetFactoryDefault();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption9);
            BCmEConfiguration bCmEConfiguration = bCmEViewOptions.getConfiguration();
            BCmEConfigurationSerializer.putOptionalBCmEConfiguration(iSerializer, bCmEConfiguration);
            CarViewOption carViewOption10 = bCmEViewOptions.getCurrentRangeSOC();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption10);
            CarViewOption carViewOption11 = bCmEViewOptions.getCatalogueRange();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption11);
        }
    }

    public static void putOptionalBCmEViewOptionsVarArray(ISerializer iSerializer, BCmEViewOptions[] bCmEViewOptionsArray) {
        boolean bl = bCmEViewOptionsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(bCmEViewOptionsArray.length);
            for (int i2 = 0; i2 < bCmEViewOptionsArray.length; ++i2) {
                BCmEViewOptionsSerializer.putOptionalBCmEViewOptions(iSerializer, bCmEViewOptionsArray[i2]);
            }
        }
    }

    public static BCmEViewOptions getOptionalBCmEViewOptions(IDeserializer iDeserializer) {
        BCmEViewOptions bCmEViewOptions = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            CarViewOption carViewOption;
            CarViewOption carViewOption2;
            BCmEConfiguration bCmEConfiguration;
            CarViewOption carViewOption3;
            CarViewOption carViewOption4;
            CarViewOption carViewOption5;
            CarViewOption carViewOption6;
            CarViewOption carViewOption7;
            CarViewOption carViewOption8;
            CarViewOption carViewOption9;
            CarViewOption carViewOption10;
            CarViewOption carViewOption11;
            bCmEViewOptions = new BCmEViewOptions();
            bCmEViewOptions.consumerList = carViewOption11 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            bCmEViewOptions.consumption = carViewOption10 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            bCmEViewOptions.liveTip = carViewOption9 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            bCmEViewOptions.energyFlowComfort = carViewOption8 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            bCmEViewOptions.rangeGainTotal = carViewOption7 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            bCmEViewOptions.consumerListConsumption = carViewOption6 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            bCmEViewOptions.consumerListRange = carViewOption5 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            bCmEViewOptions.currentRange = carViewOption4 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            bCmEViewOptions.bcmeSetFactoryDefault = carViewOption3 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            bCmEViewOptions.configuration = bCmEConfiguration = BCmEConfigurationSerializer.getOptionalBCmEConfiguration(iDeserializer);
            bCmEViewOptions.currentRangeSOC = carViewOption2 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            bCmEViewOptions.catalogueRange = carViewOption = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
        }
        return bCmEViewOptions;
    }

    public static BCmEViewOptions[] getOptionalBCmEViewOptionsVarArray(IDeserializer iDeserializer) {
        BCmEViewOptions[] bCmEViewOptionsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            bCmEViewOptionsArray = new BCmEViewOptions[n];
            for (int i2 = 0; i2 < n; ++i2) {
                bCmEViewOptionsArray[i2] = BCmEViewOptionsSerializer.getOptionalBCmEViewOptions(iDeserializer);
            }
        }
        return bCmEViewOptionsArray;
    }
}

