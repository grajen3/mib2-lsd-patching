/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.online.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.online.PortalAddressData;

public class PortalAddressDataSerializer {
    public static void putOptionalPortalAddressData(ISerializer iSerializer, PortalAddressData portalAddressData) {
        boolean bl = portalAddressData == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = portalAddressData.getAddressType();
            iSerializer.putInt64(l);
            String string = portalAddressData.getStreet();
            iSerializer.putOptionalString(string);
            String string2 = portalAddressData.getLocality();
            iSerializer.putOptionalString(string2);
            String string3 = portalAddressData.getCountry();
            iSerializer.putOptionalString(string3);
            String string4 = portalAddressData.getPostOfficeBox();
            iSerializer.putOptionalString(string4);
            String string5 = portalAddressData.getRegion();
            iSerializer.putOptionalString(string5);
            String string6 = portalAddressData.getPostalCode();
            iSerializer.putOptionalString(string6);
            String string7 = portalAddressData.getUnstructured();
            iSerializer.putOptionalString(string7);
        }
    }

    public static void putOptionalPortalAddressDataVarArray(ISerializer iSerializer, PortalAddressData[] portalAddressDataArray) {
        boolean bl = portalAddressDataArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(portalAddressDataArray.length);
            for (int i2 = 0; i2 < portalAddressDataArray.length; ++i2) {
                PortalAddressDataSerializer.putOptionalPortalAddressData(iSerializer, portalAddressDataArray[i2]);
            }
        }
    }

    public static PortalAddressData getOptionalPortalAddressData(IDeserializer iDeserializer) {
        PortalAddressData portalAddressData = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            String string2;
            String string3;
            String string4;
            String string5;
            String string6;
            String string7;
            long l;
            portalAddressData = new PortalAddressData();
            portalAddressData.addressType = l = iDeserializer.getInt64();
            portalAddressData.street = string7 = iDeserializer.getOptionalString();
            portalAddressData.locality = string6 = iDeserializer.getOptionalString();
            portalAddressData.country = string5 = iDeserializer.getOptionalString();
            portalAddressData.postOfficeBox = string4 = iDeserializer.getOptionalString();
            portalAddressData.region = string3 = iDeserializer.getOptionalString();
            portalAddressData.postalCode = string2 = iDeserializer.getOptionalString();
            portalAddressData.unstructured = string = iDeserializer.getOptionalString();
        }
        return portalAddressData;
    }

    public static PortalAddressData[] getOptionalPortalAddressDataVarArray(IDeserializer iDeserializer) {
        PortalAddressData[] portalAddressDataArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            portalAddressDataArray = new PortalAddressData[n];
            for (int i2 = 0; i2 < n; ++i2) {
                portalAddressDataArray[i2] = PortalAddressDataSerializer.getOptionalPortalAddressData(iDeserializer);
            }
        }
        return portalAddressDataArray;
    }
}

