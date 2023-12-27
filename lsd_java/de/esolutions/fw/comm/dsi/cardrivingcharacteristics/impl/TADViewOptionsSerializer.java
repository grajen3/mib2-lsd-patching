/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cardrivingcharacteristics.impl;

import de.esolutions.fw.comm.dsi.cardrivingcharacteristics.impl.TADConfigurationSerializer;
import de.esolutions.fw.comm.dsi.global.impl.CarViewOptionSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.cardrivingcharacteristics.TADConfiguration;
import org.dsi.ifc.cardrivingcharacteristics.TADViewOptions;
import org.dsi.ifc.global.CarViewOption;

public class TADViewOptionsSerializer {
    public static void putOptionalTADViewOptions(ISerializer iSerializer, TADViewOptions tADViewOptions) {
        boolean bl = tADViewOptions == null;
        iSerializer.putBool(bl);
        if (!bl) {
            CarViewOption carViewOption = tADViewOptions.getMaxMinAnglesReset();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption);
            TADConfiguration tADConfiguration = tADViewOptions.getConfiguration();
            TADConfigurationSerializer.putOptionalTADConfiguration(iSerializer, tADConfiguration);
            CarViewOption carViewOption2 = tADViewOptions.getAngleDisplay();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption2);
        }
    }

    public static void putOptionalTADViewOptionsVarArray(ISerializer iSerializer, TADViewOptions[] tADViewOptionsArray) {
        boolean bl = tADViewOptionsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(tADViewOptionsArray.length);
            for (int i2 = 0; i2 < tADViewOptionsArray.length; ++i2) {
                TADViewOptionsSerializer.putOptionalTADViewOptions(iSerializer, tADViewOptionsArray[i2]);
            }
        }
    }

    public static TADViewOptions getOptionalTADViewOptions(IDeserializer iDeserializer) {
        TADViewOptions tADViewOptions = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            CarViewOption carViewOption;
            TADConfiguration tADConfiguration;
            CarViewOption carViewOption2;
            tADViewOptions = new TADViewOptions();
            tADViewOptions.maxMinAnglesReset = carViewOption2 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            tADViewOptions.configuration = tADConfiguration = TADConfigurationSerializer.getOptionalTADConfiguration(iDeserializer);
            tADViewOptions.angleDisplay = carViewOption = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
        }
        return tADViewOptions;
    }

    public static TADViewOptions[] getOptionalTADViewOptionsVarArray(IDeserializer iDeserializer) {
        TADViewOptions[] tADViewOptionsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            tADViewOptionsArray = new TADViewOptions[n];
            for (int i2 = 0; i2 < n; ++i2) {
                tADViewOptionsArray[i2] = TADViewOptionsSerializer.getOptionalTADViewOptions(iDeserializer);
            }
        }
        return tADViewOptionsArray;
    }
}

