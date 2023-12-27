/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carseat.impl;

import de.esolutions.fw.comm.dsi.global.impl.CarViewOptionSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carseat.SeatZoneViewOptions;
import org.dsi.ifc.global.CarViewOption;

public class SeatZoneViewOptionsSerializer {
    public static void putOptionalSeatZoneViewOptions(ISerializer iSerializer, SeatZoneViewOptions seatZoneViewOptions) {
        boolean bl = seatZoneViewOptions == null;
        iSerializer.putBool(bl);
        if (!bl) {
            CarViewOption carViewOption = seatZoneViewOptions.getSeatSwitcherUp();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption);
            CarViewOption carViewOption2 = seatZoneViewOptions.getSeatSwitcherDown();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption2);
            CarViewOption carViewOption3 = seatZoneViewOptions.getSeatSwitcherBackward();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption3);
            CarViewOption carViewOption4 = seatZoneViewOptions.getSeatSwitcherForward();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption4);
            CarViewOption carViewOption5 = seatZoneViewOptions.getSeatAdjustment();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption5);
            CarViewOption carViewOption6 = seatZoneViewOptions.getSeatStopButton();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption6);
            CarViewOption carViewOption7 = seatZoneViewOptions.getSeatMassage();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption7);
            CarViewOption carViewOption8 = seatZoneViewOptions.getSeatMassageSwitcher();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption8);
            CarViewOption carViewOption9 = seatZoneViewOptions.getSeatPremiumMassage();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption9);
            CarViewOption carViewOption10 = seatZoneViewOptions.getSeatPremiumMassageSwitcher();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption10);
        }
    }

    public static void putOptionalSeatZoneViewOptionsVarArray(ISerializer iSerializer, SeatZoneViewOptions[] seatZoneViewOptionsArray) {
        boolean bl = seatZoneViewOptionsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(seatZoneViewOptionsArray.length);
            for (int i2 = 0; i2 < seatZoneViewOptionsArray.length; ++i2) {
                SeatZoneViewOptionsSerializer.putOptionalSeatZoneViewOptions(iSerializer, seatZoneViewOptionsArray[i2]);
            }
        }
    }

    public static SeatZoneViewOptions getOptionalSeatZoneViewOptions(IDeserializer iDeserializer) {
        SeatZoneViewOptions seatZoneViewOptions = null;
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
            seatZoneViewOptions = new SeatZoneViewOptions();
            seatZoneViewOptions.seatSwitcherUp = carViewOption10 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            seatZoneViewOptions.seatSwitcherDown = carViewOption9 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            seatZoneViewOptions.seatSwitcherBackward = carViewOption8 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            seatZoneViewOptions.seatSwitcherForward = carViewOption7 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            seatZoneViewOptions.seatAdjustment = carViewOption6 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            seatZoneViewOptions.seatStopButton = carViewOption5 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            seatZoneViewOptions.seatMassage = carViewOption4 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            seatZoneViewOptions.seatMassageSwitcher = carViewOption3 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            seatZoneViewOptions.seatPremiumMassage = carViewOption2 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            seatZoneViewOptions.seatPremiumMassageSwitcher = carViewOption = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
        }
        return seatZoneViewOptions;
    }

    public static SeatZoneViewOptions[] getOptionalSeatZoneViewOptionsVarArray(IDeserializer iDeserializer) {
        SeatZoneViewOptions[] seatZoneViewOptionsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            seatZoneViewOptionsArray = new SeatZoneViewOptions[n];
            for (int i2 = 0; i2 < n; ++i2) {
                seatZoneViewOptionsArray[i2] = SeatZoneViewOptionsSerializer.getOptionalSeatZoneViewOptions(iDeserializer);
            }
        }
        return seatZoneViewOptionsArray;
    }
}

