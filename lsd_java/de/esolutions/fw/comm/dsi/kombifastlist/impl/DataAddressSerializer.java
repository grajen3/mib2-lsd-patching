/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.kombifastlist.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.kombifastlist.DataAddress;

public class DataAddressSerializer {
    public static void putOptionalDataAddress(ISerializer iSerializer, DataAddress dataAddress) {
        boolean bl = dataAddress == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = dataAddress.getPos();
            iSerializer.putInt32(n);
            String string = dataAddress.getLastName();
            iSerializer.putOptionalString(string);
            String string2 = dataAddress.getFirstName();
            iSerializer.putOptionalString(string2);
            String string3 = dataAddress.getStreet();
            iSerializer.putOptionalString(string3);
            String string4 = dataAddress.getCity();
            iSerializer.putOptionalString(string4);
            String string5 = dataAddress.getRegion();
            iSerializer.putOptionalString(string5);
            String string6 = dataAddress.getPostalCode();
            iSerializer.putOptionalString(string6);
            String string7 = dataAddress.getCountry();
            iSerializer.putOptionalString(string7);
            String string8 = dataAddress.getCoordinates();
            iSerializer.putOptionalString(string8);
            String string9 = dataAddress.getPoiDescription();
            iSerializer.putOptionalString(string9);
            int n2 = dataAddress.getPoiType();
            iSerializer.putInt32(n2);
            int n3 = dataAddress.getAddressType();
            iSerializer.putInt32(n3);
        }
    }

    public static void putOptionalDataAddressVarArray(ISerializer iSerializer, DataAddress[] dataAddressArray) {
        boolean bl = dataAddressArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(dataAddressArray.length);
            for (int i2 = 0; i2 < dataAddressArray.length; ++i2) {
                DataAddressSerializer.putOptionalDataAddress(iSerializer, dataAddressArray[i2]);
            }
        }
    }

    public static DataAddress getOptionalDataAddress(IDeserializer iDeserializer) {
        DataAddress dataAddress = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            String string;
            String string2;
            String string3;
            String string4;
            String string5;
            String string6;
            String string7;
            String string8;
            String string9;
            int n3;
            dataAddress = new DataAddress();
            dataAddress.pos = n3 = iDeserializer.getInt32();
            dataAddress.lastName = string9 = iDeserializer.getOptionalString();
            dataAddress.firstName = string8 = iDeserializer.getOptionalString();
            dataAddress.street = string7 = iDeserializer.getOptionalString();
            dataAddress.city = string6 = iDeserializer.getOptionalString();
            dataAddress.region = string5 = iDeserializer.getOptionalString();
            dataAddress.postalCode = string4 = iDeserializer.getOptionalString();
            dataAddress.country = string3 = iDeserializer.getOptionalString();
            dataAddress.coordinates = string2 = iDeserializer.getOptionalString();
            dataAddress.poiDescription = string = iDeserializer.getOptionalString();
            dataAddress.poiType = n2 = iDeserializer.getInt32();
            dataAddress.addressType = n = iDeserializer.getInt32();
        }
        return dataAddress;
    }

    public static DataAddress[] getOptionalDataAddressVarArray(IDeserializer iDeserializer) {
        DataAddress[] dataAddressArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            dataAddressArray = new DataAddress[n];
            for (int i2 = 0; i2 < n; ++i2) {
                dataAddressArray[i2] = DataAddressSerializer.getOptionalDataAddress(iDeserializer);
            }
        }
        return dataAddressArray;
    }
}

