/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.tpegservices.impl;

import de.esolutions.fw.comm.dsi.global.impl.DateTimeSerializer;
import de.esolutions.fw.comm.dsi.tpegservices.impl.FuelPriceSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.DateTime;
import org.dsi.ifc.tpegservices.FuelPrice;
import org.dsi.ifc.tpegservices.FuelPriceInformation;

public class FuelPriceInformationSerializer {
    public static void putOptionalFuelPriceInformation(ISerializer iSerializer, FuelPriceInformation fuelPriceInformation) {
        boolean bl = fuelPriceInformation == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = fuelPriceInformation.getName();
            iSerializer.putOptionalString(string);
            DateTime dateTime = fuelPriceInformation.getLastUpdate();
            DateTimeSerializer.putOptionalDateTime(iSerializer, dateTime);
            FuelPrice fuelPrice = fuelPriceInformation.getPriceInformation();
            FuelPriceSerializer.putOptionalFuelPrice(iSerializer, fuelPrice);
            int n = fuelPriceInformation.getLatitude();
            iSerializer.putInt32(n);
            int n2 = fuelPriceInformation.getLongitude();
            iSerializer.putInt32(n2);
            int n3 = fuelPriceInformation.getContentId();
            iSerializer.putInt32(n3);
            int n4 = fuelPriceInformation.getNavLocationId();
            iSerializer.putInt32(n4);
        }
    }

    public static void putOptionalFuelPriceInformationVarArray(ISerializer iSerializer, FuelPriceInformation[] fuelPriceInformationArray) {
        boolean bl = fuelPriceInformationArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(fuelPriceInformationArray.length);
            for (int i2 = 0; i2 < fuelPriceInformationArray.length; ++i2) {
                FuelPriceInformationSerializer.putOptionalFuelPriceInformation(iSerializer, fuelPriceInformationArray[i2]);
            }
        }
    }

    public static FuelPriceInformation getOptionalFuelPriceInformation(IDeserializer iDeserializer) {
        FuelPriceInformation fuelPriceInformation = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            FuelPrice fuelPrice;
            DateTime dateTime;
            String string;
            fuelPriceInformation = new FuelPriceInformation();
            fuelPriceInformation.name = string = iDeserializer.getOptionalString();
            fuelPriceInformation.lastUpdate = dateTime = DateTimeSerializer.getOptionalDateTime(iDeserializer);
            fuelPriceInformation.priceInformation = fuelPrice = FuelPriceSerializer.getOptionalFuelPrice(iDeserializer);
            fuelPriceInformation.latitude = n4 = iDeserializer.getInt32();
            fuelPriceInformation.longitude = n3 = iDeserializer.getInt32();
            fuelPriceInformation.contentId = n2 = iDeserializer.getInt32();
            fuelPriceInformation.navLocationId = n = iDeserializer.getInt32();
        }
        return fuelPriceInformation;
    }

    public static FuelPriceInformation[] getOptionalFuelPriceInformationVarArray(IDeserializer iDeserializer) {
        FuelPriceInformation[] fuelPriceInformationArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            fuelPriceInformationArray = new FuelPriceInformation[n];
            for (int i2 = 0; i2 < n; ++i2) {
                fuelPriceInformationArray[i2] = FuelPriceInformationSerializer.getOptionalFuelPriceInformation(iDeserializer);
            }
        }
        return fuelPriceInformationArray;
    }
}

