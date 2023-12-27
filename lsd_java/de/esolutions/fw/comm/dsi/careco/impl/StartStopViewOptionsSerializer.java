/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.careco.impl;

import de.esolutions.fw.comm.dsi.global.impl.CarViewOptionSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.careco.StartStopViewOptions;
import org.dsi.ifc.global.CarViewOption;

public class StartStopViewOptionsSerializer {
    public static void putOptionalStartStopViewOptions(ISerializer iSerializer, StartStopViewOptions startStopViewOptions) {
        boolean bl = startStopViewOptions == null;
        iSerializer.putBool(bl);
        if (!bl) {
            CarViewOption carViewOption = startStopViewOptions.getState();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption);
            CarViewOption carViewOption2 = startStopViewOptions.getStartStopProhibitReasonList();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption2);
            CarViewOption carViewOption3 = startStopViewOptions.getStartStopRestartReasonList();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption3);
            CarViewOption carViewOption4 = startStopViewOptions.getStartStopRestartProhibitReasonList();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption4);
            CarViewOption carViewOption5 = startStopViewOptions.getCollectedReasons();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption5);
        }
    }

    public static void putOptionalStartStopViewOptionsVarArray(ISerializer iSerializer, StartStopViewOptions[] startStopViewOptionsArray) {
        boolean bl = startStopViewOptionsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(startStopViewOptionsArray.length);
            for (int i2 = 0; i2 < startStopViewOptionsArray.length; ++i2) {
                StartStopViewOptionsSerializer.putOptionalStartStopViewOptions(iSerializer, startStopViewOptionsArray[i2]);
            }
        }
    }

    public static StartStopViewOptions getOptionalStartStopViewOptions(IDeserializer iDeserializer) {
        StartStopViewOptions startStopViewOptions = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            CarViewOption carViewOption;
            CarViewOption carViewOption2;
            CarViewOption carViewOption3;
            CarViewOption carViewOption4;
            CarViewOption carViewOption5;
            startStopViewOptions = new StartStopViewOptions();
            startStopViewOptions.state = carViewOption5 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            startStopViewOptions.startStopProhibitReasonList = carViewOption4 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            startStopViewOptions.startStopRestartReasonList = carViewOption3 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            startStopViewOptions.startStopRestartProhibitReasonList = carViewOption2 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            startStopViewOptions.collectedReasons = carViewOption = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
        }
        return startStopViewOptions;
    }

    public static StartStopViewOptions[] getOptionalStartStopViewOptionsVarArray(IDeserializer iDeserializer) {
        StartStopViewOptions[] startStopViewOptionsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            startStopViewOptionsArray = new StartStopViewOptions[n];
            for (int i2 = 0; i2 < n; ++i2) {
                startStopViewOptionsArray[i2] = StartStopViewOptionsSerializer.getOptionalStartStopViewOptions(iDeserializer);
            }
        }
        return startStopViewOptionsArray;
    }
}

