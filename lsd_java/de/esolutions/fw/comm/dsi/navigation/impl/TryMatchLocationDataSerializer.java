/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.comm.dsi.navigation.impl.NavPhoneDataSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.navigation.NavPhoneData;
import org.dsi.ifc.navigation.TryMatchLocationData;

public class TryMatchLocationDataSerializer {
    public static void putOptionalTryMatchLocationData(ISerializer iSerializer, TryMatchLocationData tryMatchLocationData) {
        boolean bl = tryMatchLocationData == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = tryMatchLocationData.getLatitude();
            iSerializer.putInt32(n);
            int n2 = tryMatchLocationData.getLongitude();
            iSerializer.putInt32(n2);
            String string = tryMatchLocationData.getHouseNumber();
            iSerializer.putOptionalString(string);
            String string2 = tryMatchLocationData.getJunction();
            iSerializer.putOptionalString(string2);
            String string3 = tryMatchLocationData.getStreet();
            iSerializer.putOptionalString(string3);
            String string4 = tryMatchLocationData.getTown();
            iSerializer.putOptionalString(string4);
            String string5 = tryMatchLocationData.getCountry();
            iSerializer.putOptionalString(string5);
            NavPhoneData[] navPhoneDataArray = tryMatchLocationData.getPhoneNumbers();
            NavPhoneDataSerializer.putOptionalNavPhoneDataVarArray(iSerializer, navPhoneDataArray);
            String string6 = tryMatchLocationData.getState();
            iSerializer.putOptionalString(string6);
            String string7 = tryMatchLocationData.getPoiName();
            iSerializer.putOptionalString(string7);
            int n3 = tryMatchLocationData.getPoiCategory();
            iSerializer.putInt32(n3);
            String string8 = tryMatchLocationData.getPostalCode();
            iSerializer.putOptionalString(string8);
            String string9 = tryMatchLocationData.getUnstructured();
            iSerializer.putOptionalString(string9);
            int n4 = tryMatchLocationData.getOrigin();
            iSerializer.putInt32(n4);
            String string10 = tryMatchLocationData.getDbVersion();
            iSerializer.putOptionalString(string10);
            String string11 = tryMatchLocationData.getTownPart();
            iSerializer.putOptionalString(string11);
        }
    }

    public static void putOptionalTryMatchLocationDataVarArray(ISerializer iSerializer, TryMatchLocationData[] tryMatchLocationDataArray) {
        boolean bl = tryMatchLocationDataArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(tryMatchLocationDataArray.length);
            for (int i2 = 0; i2 < tryMatchLocationDataArray.length; ++i2) {
                TryMatchLocationDataSerializer.putOptionalTryMatchLocationData(iSerializer, tryMatchLocationDataArray[i2]);
            }
        }
    }

    public static TryMatchLocationData getOptionalTryMatchLocationData(IDeserializer iDeserializer) {
        TryMatchLocationData tryMatchLocationData = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            String string2;
            int n;
            String string3;
            String string4;
            int n2;
            String string5;
            String string6;
            String string7;
            String string8;
            String string9;
            String string10;
            String string11;
            int n3;
            int n4;
            tryMatchLocationData = new TryMatchLocationData();
            tryMatchLocationData.latitude = n4 = iDeserializer.getInt32();
            tryMatchLocationData.longitude = n3 = iDeserializer.getInt32();
            tryMatchLocationData.houseNumber = string11 = iDeserializer.getOptionalString();
            tryMatchLocationData.junction = string10 = iDeserializer.getOptionalString();
            tryMatchLocationData.street = string9 = iDeserializer.getOptionalString();
            tryMatchLocationData.town = string8 = iDeserializer.getOptionalString();
            tryMatchLocationData.country = string7 = iDeserializer.getOptionalString();
            NavPhoneData[] navPhoneDataArray = NavPhoneDataSerializer.getOptionalNavPhoneDataVarArray(iDeserializer);
            tryMatchLocationData.phoneNumbers = navPhoneDataArray;
            tryMatchLocationData.state = string6 = iDeserializer.getOptionalString();
            tryMatchLocationData.poiName = string5 = iDeserializer.getOptionalString();
            tryMatchLocationData.poiCategory = n2 = iDeserializer.getInt32();
            tryMatchLocationData.postalCode = string4 = iDeserializer.getOptionalString();
            tryMatchLocationData.unstructured = string3 = iDeserializer.getOptionalString();
            tryMatchLocationData.origin = n = iDeserializer.getInt32();
            tryMatchLocationData.dbVersion = string2 = iDeserializer.getOptionalString();
            tryMatchLocationData.townPart = string = iDeserializer.getOptionalString();
        }
        return tryMatchLocationData;
    }

    public static TryMatchLocationData[] getOptionalTryMatchLocationDataVarArray(IDeserializer iDeserializer) {
        TryMatchLocationData[] tryMatchLocationDataArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            tryMatchLocationDataArray = new TryMatchLocationData[n];
            for (int i2 = 0; i2 < n; ++i2) {
                tryMatchLocationDataArray[i2] = TryMatchLocationDataSerializer.getOptionalTryMatchLocationData(iDeserializer);
            }
        }
        return tryMatchLocationDataArray;
    }
}

