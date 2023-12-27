/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.search.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.search.Country;

public class CountrySerializer {
    public static void putOptionalCountry(ISerializer iSerializer, Country country) {
        boolean bl = country == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = country.getCountryID();
            iSerializer.putInt32(n);
            String string = country.getName();
            iSerializer.putOptionalString(string);
            String string2 = country.getCode();
            iSerializer.putOptionalString(string2);
            int n2 = country.getHouseNumberFormatting();
            iSerializer.putInt32(n2);
            String string3 = country.getStateName();
            iSerializer.putOptionalString(string3);
            String string4 = country.getStateAbbreviation();
            iSerializer.putOptionalString(string4);
        }
    }

    public static void putOptionalCountryVarArray(ISerializer iSerializer, Country[] countryArray) {
        boolean bl = countryArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(countryArray.length);
            for (int i2 = 0; i2 < countryArray.length; ++i2) {
                CountrySerializer.putOptionalCountry(iSerializer, countryArray[i2]);
            }
        }
    }

    public static Country getOptionalCountry(IDeserializer iDeserializer) {
        Country country = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            String string2;
            int n;
            String string3;
            String string4;
            int n2;
            country = new Country();
            country.countryID = n2 = iDeserializer.getInt32();
            country.name = string4 = iDeserializer.getOptionalString();
            country.code = string3 = iDeserializer.getOptionalString();
            country.houseNumberFormatting = n = iDeserializer.getInt32();
            country.stateName = string2 = iDeserializer.getOptionalString();
            country.stateAbbreviation = string = iDeserializer.getOptionalString();
        }
        return country;
    }

    public static Country[] getOptionalCountryVarArray(IDeserializer iDeserializer) {
        Country[] countryArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            countryArray = new Country[n];
            for (int i2 = 0; i2 < n; ++i2) {
                countryArray[i2] = CountrySerializer.getOptionalCountry(iDeserializer);
            }
        }
        return countryArray;
    }
}

