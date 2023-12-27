/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carstopwatch.impl;

import de.esolutions.fw.comm.dsi.global.impl.CarViewOptionSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carstopwatch.StopWatchViewOptions;
import org.dsi.ifc.global.CarViewOption;

public class StopWatchViewOptionsSerializer {
    public static void putOptionalStopWatchViewOptions(ISerializer iSerializer, StopWatchViewOptions stopWatchViewOptions) {
        boolean bl = stopWatchViewOptions == null;
        iSerializer.putBool(bl);
        if (!bl) {
            CarViewOption carViewOption = stopWatchViewOptions.getState();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption);
            CarViewOption carViewOption2 = stopWatchViewOptions.getControl();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption2);
            CarViewOption carViewOption3 = stopWatchViewOptions.getCurrentLapNumber();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption3);
            CarViewOption carViewOption4 = stopWatchViewOptions.getTotalTime();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption4);
            CarViewOption carViewOption5 = stopWatchViewOptions.getLastSplitTime();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption5);
            CarViewOption carViewOption6 = stopWatchViewOptions.getCurrentLapTime();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption6);
            CarViewOption carViewOption7 = stopWatchViewOptions.getLastLapTime();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption7);
            CarViewOption carViewOption8 = stopWatchViewOptions.getFastestLapTime();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption8);
            CarViewOption carViewOption9 = stopWatchViewOptions.getLapRating();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption9);
            CarViewOption carViewOption10 = stopWatchViewOptions.getLapProgress();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption10);
            CarViewOption carViewOption11 = stopWatchViewOptions.getLapGPSTrigger();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption11);
            CarViewOption carViewOption12 = stopWatchViewOptions.getSlowestLapTime();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption12);
        }
    }

    public static void putOptionalStopWatchViewOptionsVarArray(ISerializer iSerializer, StopWatchViewOptions[] stopWatchViewOptionsArray) {
        boolean bl = stopWatchViewOptionsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(stopWatchViewOptionsArray.length);
            for (int i2 = 0; i2 < stopWatchViewOptionsArray.length; ++i2) {
                StopWatchViewOptionsSerializer.putOptionalStopWatchViewOptions(iSerializer, stopWatchViewOptionsArray[i2]);
            }
        }
    }

    public static StopWatchViewOptions getOptionalStopWatchViewOptions(IDeserializer iDeserializer) {
        StopWatchViewOptions stopWatchViewOptions = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            CarViewOption carViewOption;
            CarViewOption carViewOption2;
            CarViewOption carViewOption3;
            CarViewOption carViewOption4;
            CarViewOption carViewOption5;
            CarViewOption carViewOption6;
            CarViewOption carViewOption7;
            CarViewOption carViewOption8;
            CarViewOption carViewOption9;
            CarViewOption carViewOption10;
            CarViewOption carViewOption11;
            CarViewOption carViewOption12;
            stopWatchViewOptions = new StopWatchViewOptions();
            stopWatchViewOptions.state = carViewOption12 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            stopWatchViewOptions.control = carViewOption11 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            stopWatchViewOptions.currentLapNumber = carViewOption10 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            stopWatchViewOptions.totalTime = carViewOption9 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            stopWatchViewOptions.lastSplitTime = carViewOption8 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            stopWatchViewOptions.currentLapTime = carViewOption7 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            stopWatchViewOptions.lastLapTime = carViewOption6 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            stopWatchViewOptions.fastestLapTime = carViewOption5 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            stopWatchViewOptions.lapRating = carViewOption4 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            stopWatchViewOptions.lapProgress = carViewOption3 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            stopWatchViewOptions.lapGPSTrigger = carViewOption2 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            stopWatchViewOptions.slowestLapTime = carViewOption = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
        }
        return stopWatchViewOptions;
    }

    public static StopWatchViewOptions[] getOptionalStopWatchViewOptionsVarArray(IDeserializer iDeserializer) {
        StopWatchViewOptions[] stopWatchViewOptionsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            stopWatchViewOptionsArray = new StopWatchViewOptions[n];
            for (int i2 = 0; i2 < n; ++i2) {
                stopWatchViewOptionsArray[i2] = StopWatchViewOptionsSerializer.getOptionalStopWatchViewOptions(iDeserializer);
            }
        }
        return stopWatchViewOptionsArray;
    }
}

