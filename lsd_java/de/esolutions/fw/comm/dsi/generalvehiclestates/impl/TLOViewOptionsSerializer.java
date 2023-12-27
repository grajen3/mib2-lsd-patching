/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.generalvehiclestates.impl;

import de.esolutions.fw.comm.dsi.global.impl.CarViewOptionSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.generalvehiclestates.TLOViewOptions;
import org.dsi.ifc.global.CarViewOption;

public class TLOViewOptionsSerializer {
    public static void putOptionalTLOViewOptions(ISerializer iSerializer, TLOViewOptions tLOViewOptions) {
        boolean bl = tLOViewOptions == null;
        iSerializer.putBool(bl);
        if (!bl) {
            CarViewOption carViewOption = tLOViewOptions.getHmiState();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption);
            CarViewOption carViewOption2 = tLOViewOptions.getStartStopInfo();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption2);
            CarViewOption carViewOption3 = tLOViewOptions.getInfoList();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption3);
        }
    }

    public static void putOptionalTLOViewOptionsVarArray(ISerializer iSerializer, TLOViewOptions[] tLOViewOptionsArray) {
        boolean bl = tLOViewOptionsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(tLOViewOptionsArray.length);
            for (int i2 = 0; i2 < tLOViewOptionsArray.length; ++i2) {
                TLOViewOptionsSerializer.putOptionalTLOViewOptions(iSerializer, tLOViewOptionsArray[i2]);
            }
        }
    }

    public static TLOViewOptions getOptionalTLOViewOptions(IDeserializer iDeserializer) {
        TLOViewOptions tLOViewOptions = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            CarViewOption carViewOption;
            CarViewOption carViewOption2;
            CarViewOption carViewOption3;
            tLOViewOptions = new TLOViewOptions();
            tLOViewOptions.hmiState = carViewOption3 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            tLOViewOptions.startStopInfo = carViewOption2 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            tLOViewOptions.infoList = carViewOption = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
        }
        return tLOViewOptions;
    }

    public static TLOViewOptions[] getOptionalTLOViewOptionsVarArray(IDeserializer iDeserializer) {
        TLOViewOptions[] tLOViewOptionsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            tLOViewOptionsArray = new TLOViewOptions[n];
            for (int i2 = 0; i2 < n; ++i2) {
                tLOViewOptionsArray[i2] = TLOViewOptionsSerializer.getOptionalTLOViewOptions(iDeserializer);
            }
        }
        return tLOViewOptionsArray;
    }
}

