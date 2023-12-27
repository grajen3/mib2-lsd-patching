/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.organizer.impl;

import de.esolutions.fw.comm.dsi.global.impl.ResourceLocatorSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.organizer.AddressData;

public class AddressDataSerializer {
    public static void putOptionalAddressData(ISerializer iSerializer, AddressData addressData) {
        boolean bl = addressData == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = addressData.getAddressType();
            iSerializer.putInt32(n);
            String string = addressData.getStreet();
            iSerializer.putOptionalString(string);
            String string2 = addressData.getLocality();
            iSerializer.putOptionalString(string2);
            String string3 = addressData.getLocalitySound();
            iSerializer.putOptionalString(string3);
            String string4 = addressData.getCountry();
            iSerializer.putOptionalString(string4);
            String string5 = addressData.getRegion();
            iSerializer.putOptionalString(string5);
            String string6 = addressData.getPostalCode();
            iSerializer.putOptionalString(string6);
            boolean bl2 = addressData.isTopDestination();
            iSerializer.putBool(bl2);
            String string7 = addressData.getGeoPosition();
            iSerializer.putOptionalString(string7);
            int n2 = addressData.getNavLocationVersion();
            iSerializer.putInt32(n2);
            byte[] byArray = addressData.getNavLocation();
            iSerializer.putOptionalInt8VarArray(byArray);
            ResourceLocator resourceLocator = addressData.getNavPicture();
            ResourceLocatorSerializer.putOptionalResourceLocator(iSerializer, resourceLocator);
        }
    }

    public static void putOptionalAddressDataVarArray(ISerializer iSerializer, AddressData[] addressDataArray) {
        boolean bl = addressDataArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(addressDataArray.length);
            for (int i2 = 0; i2 < addressDataArray.length; ++i2) {
                AddressDataSerializer.putOptionalAddressData(iSerializer, addressDataArray[i2]);
            }
        }
    }

    public static AddressData getOptionalAddressData(IDeserializer iDeserializer) {
        AddressData addressData = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            ResourceLocator resourceLocator;
            int n;
            String string;
            boolean bl2;
            String string2;
            String string3;
            String string4;
            String string5;
            String string6;
            String string7;
            int n2;
            addressData = new AddressData();
            addressData.addressType = n2 = iDeserializer.getInt32();
            addressData.street = string7 = iDeserializer.getOptionalString();
            addressData.locality = string6 = iDeserializer.getOptionalString();
            addressData.localitySound = string5 = iDeserializer.getOptionalString();
            addressData.country = string4 = iDeserializer.getOptionalString();
            addressData.region = string3 = iDeserializer.getOptionalString();
            addressData.postalCode = string2 = iDeserializer.getOptionalString();
            addressData.topDestination = bl2 = iDeserializer.getBool();
            addressData.geoPosition = string = iDeserializer.getOptionalString();
            addressData.navLocationVersion = n = iDeserializer.getInt32();
            byte[] byArray = iDeserializer.getOptionalInt8VarArray();
            addressData.navLocation = byArray;
            addressData.navPicture = resourceLocator = ResourceLocatorSerializer.getOptionalResourceLocator(iDeserializer);
        }
        return addressData;
    }

    public static AddressData[] getOptionalAddressDataVarArray(IDeserializer iDeserializer) {
        AddressData[] addressDataArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            addressDataArray = new AddressData[n];
            for (int i2 = 0; i2 < n; ++i2) {
                addressDataArray[i2] = AddressDataSerializer.getOptionalAddressData(iDeserializer);
            }
        }
        return addressDataArray;
    }
}

