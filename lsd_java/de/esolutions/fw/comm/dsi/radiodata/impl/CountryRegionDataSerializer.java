/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.radiodata.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.radiodata.CountryRegionData;

public class CountryRegionDataSerializer {
    public static void putOptionalCountryRegionData(ISerializer iSerializer, CountryRegionData countryRegionData) {
        boolean bl = countryRegionData == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = countryRegionData.getCrId();
            iSerializer.putInt32(n);
            int n2 = countryRegionData.getMacroRegionId();
            iSerializer.putInt32(n2);
            String string = countryRegionData.getIoc();
            iSerializer.putOptionalString(string);
            int n3 = countryRegionData.getCountryId();
            iSerializer.putInt32(n3);
            String string2 = countryRegionData.getCountryNameInternational();
            iSerializer.putOptionalString(string2);
            String string3 = countryRegionData.getCountryNameOriginal();
            iSerializer.putOptionalString(string3);
            String string4 = countryRegionData.getIocCountryNameInternational();
            iSerializer.putOptionalString(string4);
            int n4 = countryRegionData.getCountryEcc();
            iSerializer.putInt32(n4);
            int n5 = countryRegionData.getCountryPi();
            iSerializer.putInt32(n5);
            int[] nArray = countryRegionData.getCountryNeighborPi();
            iSerializer.putOptionalInt32VarArray(nArray);
            String string5 = countryRegionData.getGpsMode();
            iSerializer.putOptionalString(string5);
            String[] stringArray = countryRegionData.getGpsp();
            iSerializer.putOptionalStringVarArray(stringArray);
            int n6 = countryRegionData.getFlagId();
            iSerializer.putInt32(n6);
            int n7 = countryRegionData.getAmSupport();
            iSerializer.putInt32(n7);
            int n8 = countryRegionData.getFmSupport();
            iSerializer.putInt32(n8);
            int n9 = countryRegionData.getDabSupport();
            iSerializer.putInt32(n9);
            int n10 = countryRegionData.getSpeechSupport();
            iSerializer.putInt32(n10);
            int n11 = countryRegionData.getNurGenehmigteLogos();
            iSerializer.putInt32(n11);
            int n12 = countryRegionData.getRequestStrategy();
            iSerializer.putInt32(n12);
            int n13 = countryRegionData.getUseDatabaseNameInHmi();
            iSerializer.putInt32(n13);
            String string6 = countryRegionData.getNativeLanguage();
            iSerializer.putOptionalString(string6);
            String[] stringArray2 = countryRegionData.getExtraString();
            iSerializer.putOptionalStringVarArray(stringArray2);
            int[] nArray2 = countryRegionData.getExtraInt();
            iSerializer.putOptionalInt32VarArray(nArray2);
        }
    }

    public static void putOptionalCountryRegionDataVarArray(ISerializer iSerializer, CountryRegionData[] countryRegionDataArray) {
        boolean bl = countryRegionDataArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(countryRegionDataArray.length);
            for (int i2 = 0; i2 < countryRegionDataArray.length; ++i2) {
                CountryRegionDataSerializer.putOptionalCountryRegionData(iSerializer, countryRegionDataArray[i2]);
            }
        }
    }

    public static CountryRegionData getOptionalCountryRegionData(IDeserializer iDeserializer) {
        CountryRegionData countryRegionData = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            int n;
            int n2;
            int n3;
            int n4;
            int n5;
            int n6;
            int n7;
            int n8;
            String string2;
            int n9;
            int n10;
            String string3;
            String string4;
            String string5;
            int n11;
            String string6;
            int n12;
            int n13;
            countryRegionData = new CountryRegionData();
            countryRegionData.crId = n13 = iDeserializer.getInt32();
            countryRegionData.macroRegionId = n12 = iDeserializer.getInt32();
            countryRegionData.ioc = string6 = iDeserializer.getOptionalString();
            countryRegionData.countryId = n11 = iDeserializer.getInt32();
            countryRegionData.countryNameInternational = string5 = iDeserializer.getOptionalString();
            countryRegionData.countryNameOriginal = string4 = iDeserializer.getOptionalString();
            countryRegionData.iocCountryNameInternational = string3 = iDeserializer.getOptionalString();
            countryRegionData.countryEcc = n10 = iDeserializer.getInt32();
            countryRegionData.countryPi = n9 = iDeserializer.getInt32();
            int[] nArray = iDeserializer.getOptionalInt32VarArray();
            countryRegionData.countryNeighborPi = nArray;
            countryRegionData.gpsMode = string2 = iDeserializer.getOptionalString();
            String[] stringArray = iDeserializer.getOptionalStringVarArray();
            countryRegionData.gpsp = stringArray;
            countryRegionData.flagId = n8 = iDeserializer.getInt32();
            countryRegionData.amSupport = n7 = iDeserializer.getInt32();
            countryRegionData.fmSupport = n6 = iDeserializer.getInt32();
            countryRegionData.dabSupport = n5 = iDeserializer.getInt32();
            countryRegionData.speechSupport = n4 = iDeserializer.getInt32();
            countryRegionData.nurGenehmigteLogos = n3 = iDeserializer.getInt32();
            countryRegionData.requestStrategy = n2 = iDeserializer.getInt32();
            countryRegionData.useDatabaseNameInHmi = n = iDeserializer.getInt32();
            countryRegionData.nativeLanguage = string = iDeserializer.getOptionalString();
            String[] stringArray2 = iDeserializer.getOptionalStringVarArray();
            countryRegionData.extraString = stringArray2;
            int[] nArray2 = iDeserializer.getOptionalInt32VarArray();
            countryRegionData.extraInt = nArray2;
        }
        return countryRegionData;
    }

    public static CountryRegionData[] getOptionalCountryRegionDataVarArray(IDeserializer iDeserializer) {
        CountryRegionData[] countryRegionDataArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            countryRegionDataArray = new CountryRegionData[n];
            for (int i2 = 0; i2 < n; ++i2) {
                countryRegionDataArray[i2] = CountryRegionDataSerializer.getOptionalCountryRegionData(iDeserializer);
            }
        }
        return countryRegionDataArray;
    }
}

