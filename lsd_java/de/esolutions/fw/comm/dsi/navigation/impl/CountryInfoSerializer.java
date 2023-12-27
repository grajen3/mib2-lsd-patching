/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.navigation.CountryInfo;

public class CountryInfoSerializer {
    public static void putOptionalCountryInfo(ISerializer iSerializer, CountryInfo countryInfo) {
        boolean bl = countryInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = countryInfo.getName();
            iSerializer.putOptionalString(string);
            String string2 = countryInfo.getCountryAbbreviation();
            iSerializer.putOptionalString(string2);
            int n = countryInfo.getIconIndex();
            iSerializer.putInt32(n);
            boolean bl2 = countryInfo.isRightHandTraffic();
            iSerializer.putBool(bl2);
            String[] stringArray = countryInfo.getAdditionalInfo();
            iSerializer.putOptionalStringVarArray(stringArray);
            int[] nArray = countryInfo.getAdditionalIcons();
            iSerializer.putOptionalInt32VarArray(nArray);
        }
    }

    public static void putOptionalCountryInfoVarArray(ISerializer iSerializer, CountryInfo[] countryInfoArray) {
        boolean bl = countryInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(countryInfoArray.length);
            for (int i2 = 0; i2 < countryInfoArray.length; ++i2) {
                CountryInfoSerializer.putOptionalCountryInfo(iSerializer, countryInfoArray[i2]);
            }
        }
    }

    public static CountryInfo getOptionalCountryInfo(IDeserializer iDeserializer) {
        CountryInfo countryInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            int n;
            String string;
            String string2;
            countryInfo = new CountryInfo();
            countryInfo.name = string2 = iDeserializer.getOptionalString();
            countryInfo.countryAbbreviation = string = iDeserializer.getOptionalString();
            countryInfo.iconIndex = n = iDeserializer.getInt32();
            countryInfo.rightHandTraffic = bl2 = iDeserializer.getBool();
            String[] stringArray = iDeserializer.getOptionalStringVarArray();
            countryInfo.additionalInfo = stringArray;
            int[] nArray = iDeserializer.getOptionalInt32VarArray();
            countryInfo.additionalIcons = nArray;
        }
        return countryInfo;
    }

    public static CountryInfo[] getOptionalCountryInfoVarArray(IDeserializer iDeserializer) {
        CountryInfo[] countryInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            countryInfoArray = new CountryInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                countryInfoArray[i2] = CountryInfoSerializer.getOptionalCountryInfo(iDeserializer);
            }
        }
        return countryInfoArray;
    }
}

