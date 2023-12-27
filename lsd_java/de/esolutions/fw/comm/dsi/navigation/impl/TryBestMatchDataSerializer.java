/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.comm.dsi.navigation.impl.NavPhoneDataSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.navigation.NavPhoneData;
import org.dsi.ifc.navigation.TryBestMatchData;

public class TryBestMatchDataSerializer {
    public static void putOptionalTryBestMatchData(ISerializer iSerializer, TryBestMatchData tryBestMatchData) {
        boolean bl = tryBestMatchData == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = tryBestMatchData.getStreedAndOrHouseNumber();
            iSerializer.putOptionalString(string);
            String string2 = tryBestMatchData.getLocality();
            iSerializer.putOptionalString(string2);
            String string3 = tryBestMatchData.getCountry();
            iSerializer.putOptionalString(string3);
            NavPhoneData[] navPhoneDataArray = tryBestMatchData.getPhoneNumbers();
            NavPhoneDataSerializer.putOptionalNavPhoneDataVarArray(iSerializer, navPhoneDataArray);
            String string4 = tryBestMatchData.getPostOfficeBox();
            iSerializer.putOptionalString(string4);
            String string5 = tryBestMatchData.getRegion();
            iSerializer.putOptionalString(string5);
            String string6 = tryBestMatchData.getPostalCode();
            iSerializer.putOptionalString(string6);
            String string7 = tryBestMatchData.getUnstructured();
            iSerializer.putOptionalString(string7);
        }
    }

    public static void putOptionalTryBestMatchDataVarArray(ISerializer iSerializer, TryBestMatchData[] tryBestMatchDataArray) {
        boolean bl = tryBestMatchDataArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(tryBestMatchDataArray.length);
            for (int i2 = 0; i2 < tryBestMatchDataArray.length; ++i2) {
                TryBestMatchDataSerializer.putOptionalTryBestMatchData(iSerializer, tryBestMatchDataArray[i2]);
            }
        }
    }

    public static TryBestMatchData getOptionalTryBestMatchData(IDeserializer iDeserializer) {
        TryBestMatchData tryBestMatchData = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            String string2;
            String string3;
            String string4;
            String string5;
            String string6;
            String string7;
            tryBestMatchData = new TryBestMatchData();
            tryBestMatchData.streedAndOrHouseNumber = string7 = iDeserializer.getOptionalString();
            tryBestMatchData.locality = string6 = iDeserializer.getOptionalString();
            tryBestMatchData.country = string5 = iDeserializer.getOptionalString();
            NavPhoneData[] navPhoneDataArray = NavPhoneDataSerializer.getOptionalNavPhoneDataVarArray(iDeserializer);
            tryBestMatchData.phoneNumbers = navPhoneDataArray;
            tryBestMatchData.postOfficeBox = string4 = iDeserializer.getOptionalString();
            tryBestMatchData.region = string3 = iDeserializer.getOptionalString();
            tryBestMatchData.postalCode = string2 = iDeserializer.getOptionalString();
            tryBestMatchData.unstructured = string = iDeserializer.getOptionalString();
        }
        return tryBestMatchData;
    }

    public static TryBestMatchData[] getOptionalTryBestMatchDataVarArray(IDeserializer iDeserializer) {
        TryBestMatchData[] tryBestMatchDataArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            tryBestMatchDataArray = new TryBestMatchData[n];
            for (int i2 = 0; i2 < n; ++i2) {
                tryBestMatchDataArray[i2] = TryBestMatchDataSerializer.getOptionalTryBestMatchData(iDeserializer);
            }
        }
        return tryBestMatchDataArray;
    }
}

