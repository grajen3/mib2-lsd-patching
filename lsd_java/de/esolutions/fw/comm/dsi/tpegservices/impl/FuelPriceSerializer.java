/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.tpegservices.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.tpegservices.FuelPrice;

public class FuelPriceSerializer {
    public static void putOptionalFuelPrice(ISerializer iSerializer, FuelPrice fuelPrice) {
        boolean bl = fuelPrice == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = fuelPrice.getCurrency();
            iSerializer.putInt32(n);
            int n2 = fuelPrice.getGasoline();
            iSerializer.putInt32(n2);
            int n3 = fuelPrice.getDiesel();
            iSerializer.putInt32(n3);
        }
    }

    public static void putOptionalFuelPriceVarArray(ISerializer iSerializer, FuelPrice[] fuelPriceArray) {
        boolean bl = fuelPriceArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(fuelPriceArray.length);
            for (int i2 = 0; i2 < fuelPriceArray.length; ++i2) {
                FuelPriceSerializer.putOptionalFuelPrice(iSerializer, fuelPriceArray[i2]);
            }
        }
    }

    public static FuelPrice getOptionalFuelPrice(IDeserializer iDeserializer) {
        FuelPrice fuelPrice = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            fuelPrice = new FuelPrice();
            fuelPrice.currency = n3 = iDeserializer.getInt32();
            fuelPrice.gasoline = n2 = iDeserializer.getInt32();
            fuelPrice.diesel = n = iDeserializer.getInt32();
        }
        return fuelPrice;
    }

    public static FuelPrice[] getOptionalFuelPriceVarArray(IDeserializer iDeserializer) {
        FuelPrice[] fuelPriceArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            fuelPriceArray = new FuelPrice[n];
            for (int i2 = 0; i2 < n; ++i2) {
                fuelPriceArray[i2] = FuelPriceSerializer.getOptionalFuelPrice(iDeserializer);
            }
        }
        return fuelPriceArray;
    }
}

