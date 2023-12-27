/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carvehiclestates.impl;

import de.esolutions.fw.comm.dsi.global.impl.CarViewOptionSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carvehiclestates.VehicleInfoViewOptions;
import org.dsi.ifc.global.CarViewOption;

public class VehicleInfoViewOptionsSerializer {
    public static void putOptionalVehicleInfoViewOptions(ISerializer iSerializer, VehicleInfoViewOptions vehicleInfoViewOptions) {
        boolean bl = vehicleInfoViewOptions == null;
        iSerializer.putBool(bl);
        if (!bl) {
            CarViewOption carViewOption = vehicleInfoViewOptions.getDrvSchoolSystem();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption);
            CarViewOption carViewOption2 = vehicleInfoViewOptions.getScrInfo();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption2);
        }
    }

    public static void putOptionalVehicleInfoViewOptionsVarArray(ISerializer iSerializer, VehicleInfoViewOptions[] vehicleInfoViewOptionsArray) {
        boolean bl = vehicleInfoViewOptionsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(vehicleInfoViewOptionsArray.length);
            for (int i2 = 0; i2 < vehicleInfoViewOptionsArray.length; ++i2) {
                VehicleInfoViewOptionsSerializer.putOptionalVehicleInfoViewOptions(iSerializer, vehicleInfoViewOptionsArray[i2]);
            }
        }
    }

    public static VehicleInfoViewOptions getOptionalVehicleInfoViewOptions(IDeserializer iDeserializer) {
        VehicleInfoViewOptions vehicleInfoViewOptions = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            CarViewOption carViewOption;
            CarViewOption carViewOption2;
            vehicleInfoViewOptions = new VehicleInfoViewOptions();
            vehicleInfoViewOptions.drvSchoolSystem = carViewOption2 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            vehicleInfoViewOptions.scrInfo = carViewOption = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
        }
        return vehicleInfoViewOptions;
    }

    public static VehicleInfoViewOptions[] getOptionalVehicleInfoViewOptionsVarArray(IDeserializer iDeserializer) {
        VehicleInfoViewOptions[] vehicleInfoViewOptionsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            vehicleInfoViewOptionsArray = new VehicleInfoViewOptions[n];
            for (int i2 = 0; i2 < n; ++i2) {
                vehicleInfoViewOptionsArray[i2] = VehicleInfoViewOptionsSerializer.getOptionalVehicleInfoViewOptions(iDeserializer);
            }
        }
        return vehicleInfoViewOptionsArray;
    }
}

