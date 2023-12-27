/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cardriverassistance.impl;

import de.esolutions.fw.comm.dsi.cardriverassistance.impl.TSDConfigurationSerializer;
import de.esolutions.fw.comm.dsi.global.impl.CarViewOptionSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.cardriverassistance.TSDConfiguration;
import org.dsi.ifc.cardriverassistance.TSDViewOptions;
import org.dsi.ifc.global.CarViewOption;

public class TSDViewOptionsSerializer {
    public static void putOptionalTSDViewOptions(ISerializer iSerializer, TSDViewOptions tSDViewOptions) {
        boolean bl = tSDViewOptions == null;
        iSerializer.putBool(bl);
        if (!bl) {
            CarViewOption carViewOption = tSDViewOptions.getSystemOnOff();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption);
            CarViewOption carViewOption2 = tSDViewOptions.getTrailerDetection();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption2);
            CarViewOption carViewOption3 = tSDViewOptions.getRoadSign();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption3);
            CarViewOption carViewOption4 = tSDViewOptions.getRoadSignFilter();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption4);
            CarViewOption carViewOption5 = tSDViewOptions.getTsdSetFactoryDefault();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption5);
            CarViewOption carViewOption6 = tSDViewOptions.getSpeedWarningThreshold();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption6);
            CarViewOption carViewOption7 = tSDViewOptions.getTrailerSpeedLimit();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption7);
            CarViewOption carViewOption8 = tSDViewOptions.getSystemMessages();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption8);
            CarViewOption carViewOption9 = tSDViewOptions.getSpeedWarnAcoustics();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption9);
            TSDConfiguration tSDConfiguration = tSDViewOptions.getConfiguration();
            TSDConfigurationSerializer.putOptionalTSDConfiguration(iSerializer, tSDConfiguration);
        }
    }

    public static void putOptionalTSDViewOptionsVarArray(ISerializer iSerializer, TSDViewOptions[] tSDViewOptionsArray) {
        boolean bl = tSDViewOptionsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(tSDViewOptionsArray.length);
            for (int i2 = 0; i2 < tSDViewOptionsArray.length; ++i2) {
                TSDViewOptionsSerializer.putOptionalTSDViewOptions(iSerializer, tSDViewOptionsArray[i2]);
            }
        }
    }

    public static TSDViewOptions getOptionalTSDViewOptions(IDeserializer iDeserializer) {
        TSDViewOptions tSDViewOptions = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            TSDConfiguration tSDConfiguration;
            CarViewOption carViewOption;
            CarViewOption carViewOption2;
            CarViewOption carViewOption3;
            CarViewOption carViewOption4;
            CarViewOption carViewOption5;
            CarViewOption carViewOption6;
            CarViewOption carViewOption7;
            CarViewOption carViewOption8;
            CarViewOption carViewOption9;
            tSDViewOptions = new TSDViewOptions();
            tSDViewOptions.systemOnOff = carViewOption9 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            tSDViewOptions.trailerDetection = carViewOption8 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            tSDViewOptions.roadSign = carViewOption7 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            tSDViewOptions.roadSignFilter = carViewOption6 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            tSDViewOptions.tsdSetFactoryDefault = carViewOption5 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            tSDViewOptions.speedWarningThreshold = carViewOption4 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            tSDViewOptions.trailerSpeedLimit = carViewOption3 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            tSDViewOptions.systemMessages = carViewOption2 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            tSDViewOptions.speedWarnAcoustics = carViewOption = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            tSDViewOptions.configuration = tSDConfiguration = TSDConfigurationSerializer.getOptionalTSDConfiguration(iDeserializer);
        }
        return tSDViewOptions;
    }

    public static TSDViewOptions[] getOptionalTSDViewOptionsVarArray(IDeserializer iDeserializer) {
        TSDViewOptions[] tSDViewOptionsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            tSDViewOptionsArray = new TSDViewOptions[n];
            for (int i2 = 0; i2 < n; ++i2) {
                tSDViewOptionsArray[i2] = TSDViewOptionsSerializer.getOptionalTSDViewOptions(iDeserializer);
            }
        }
        return tSDViewOptionsArray;
    }
}

