/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.radiodata.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.radiodata.CountryRegionTranslationData;

public class CountryRegionTranslationDataSerializer {
    public static void putOptionalCountryRegionTranslationData(ISerializer iSerializer, CountryRegionTranslationData countryRegionTranslationData) {
        boolean bl = countryRegionTranslationData == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = countryRegionTranslationData.getCountryId();
            iSerializer.putInt32(n);
            int n2 = countryRegionTranslationData.getGuiLanguageId();
            iSerializer.putInt32(n2);
            String string = countryRegionTranslationData.getGuiLanguage();
            iSerializer.putOptionalString(string);
            String string2 = countryRegionTranslationData.getCountryRegionTranslation();
            iSerializer.putOptionalString(string2);
            int n3 = countryRegionTranslationData.getGuiListItemPosition();
            iSerializer.putInt32(n3);
        }
    }

    public static void putOptionalCountryRegionTranslationDataVarArray(ISerializer iSerializer, CountryRegionTranslationData[] countryRegionTranslationDataArray) {
        boolean bl = countryRegionTranslationDataArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(countryRegionTranslationDataArray.length);
            for (int i2 = 0; i2 < countryRegionTranslationDataArray.length; ++i2) {
                CountryRegionTranslationDataSerializer.putOptionalCountryRegionTranslationData(iSerializer, countryRegionTranslationDataArray[i2]);
            }
        }
    }

    public static CountryRegionTranslationData getOptionalCountryRegionTranslationData(IDeserializer iDeserializer) {
        CountryRegionTranslationData countryRegionTranslationData = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            String string;
            String string2;
            int n2;
            int n3;
            countryRegionTranslationData = new CountryRegionTranslationData();
            countryRegionTranslationData.countryId = n3 = iDeserializer.getInt32();
            countryRegionTranslationData.guiLanguageId = n2 = iDeserializer.getInt32();
            countryRegionTranslationData.guiLanguage = string2 = iDeserializer.getOptionalString();
            countryRegionTranslationData.countryRegionTranslation = string = iDeserializer.getOptionalString();
            countryRegionTranslationData.guiListItemPosition = n = iDeserializer.getInt32();
        }
        return countryRegionTranslationData;
    }

    public static CountryRegionTranslationData[] getOptionalCountryRegionTranslationDataVarArray(IDeserializer iDeserializer) {
        CountryRegionTranslationData[] countryRegionTranslationDataArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            countryRegionTranslationDataArray = new CountryRegionTranslationData[n];
            for (int i2 = 0; i2 < n; ++i2) {
                countryRegionTranslationDataArray[i2] = CountryRegionTranslationDataSerializer.getOptionalCountryRegionTranslationData(iDeserializer);
            }
        }
        return countryRegionTranslationDataArray;
    }
}

