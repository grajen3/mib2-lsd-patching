/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carseat.impl;

import de.esolutions.fw.comm.dsi.carseat.impl.SeatPneumaticConfigSerializer;
import de.esolutions.fw.comm.dsi.global.impl.CarViewOptionSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carseat.SeatPneumaticConfig;
import org.dsi.ifc.carseat.SeatPneumaticViewOptions;
import org.dsi.ifc.global.CarViewOption;

public class SeatPneumaticViewOptionsSerializer {
    public static void putOptionalSeatPneumaticViewOptions(ISerializer iSerializer, SeatPneumaticViewOptions seatPneumaticViewOptions) {
        boolean bl = seatPneumaticViewOptions == null;
        iSerializer.putBool(bl);
        if (!bl) {
            CarViewOption carViewOption = seatPneumaticViewOptions.getSeatPneumaticCoDriverSettingsFromDriver();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption);
            CarViewOption carViewOption2 = seatPneumaticViewOptions.getSeatPneumaticSetFactoryDefault();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption2);
            SeatPneumaticConfig seatPneumaticConfig = seatPneumaticViewOptions.getSeatPneumaticConfig();
            SeatPneumaticConfigSerializer.putOptionalSeatPneumaticConfig(iSerializer, seatPneumaticConfig);
        }
    }

    public static void putOptionalSeatPneumaticViewOptionsVarArray(ISerializer iSerializer, SeatPneumaticViewOptions[] seatPneumaticViewOptionsArray) {
        boolean bl = seatPneumaticViewOptionsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(seatPneumaticViewOptionsArray.length);
            for (int i2 = 0; i2 < seatPneumaticViewOptionsArray.length; ++i2) {
                SeatPneumaticViewOptionsSerializer.putOptionalSeatPneumaticViewOptions(iSerializer, seatPneumaticViewOptionsArray[i2]);
            }
        }
    }

    public static SeatPneumaticViewOptions getOptionalSeatPneumaticViewOptions(IDeserializer iDeserializer) {
        SeatPneumaticViewOptions seatPneumaticViewOptions = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            SeatPneumaticConfig seatPneumaticConfig;
            CarViewOption carViewOption;
            CarViewOption carViewOption2;
            seatPneumaticViewOptions = new SeatPneumaticViewOptions();
            seatPneumaticViewOptions.seatPneumaticCoDriverSettingsFromDriver = carViewOption2 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            seatPneumaticViewOptions.seatPneumaticSetFactoryDefault = carViewOption = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            seatPneumaticViewOptions.seatPneumaticConfig = seatPneumaticConfig = SeatPneumaticConfigSerializer.getOptionalSeatPneumaticConfig(iDeserializer);
        }
        return seatPneumaticViewOptions;
    }

    public static SeatPneumaticViewOptions[] getOptionalSeatPneumaticViewOptionsVarArray(IDeserializer iDeserializer) {
        SeatPneumaticViewOptions[] seatPneumaticViewOptionsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            seatPneumaticViewOptionsArray = new SeatPneumaticViewOptions[n];
            for (int i2 = 0; i2 < n; ++i2) {
                seatPneumaticViewOptionsArray[i2] = SeatPneumaticViewOptionsSerializer.getOptionalSeatPneumaticViewOptions(iDeserializer);
            }
        }
        return seatPneumaticViewOptionsArray;
    }
}

