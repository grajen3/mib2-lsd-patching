/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.online.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.online.PoiOnlineSearchValuelistElement;

public class PoiOnlineSearchValuelistElementSerializer {
    public static void putOptionalPoiOnlineSearchValuelistElement(ISerializer iSerializer, PoiOnlineSearchValuelistElement poiOnlineSearchValuelistElement) {
        boolean bl = poiOnlineSearchValuelistElement == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = poiOnlineSearchValuelistElement.getLongitude();
            iSerializer.putInt32(n);
            int n2 = poiOnlineSearchValuelistElement.getLatitude();
            iSerializer.putInt32(n2);
            String string = poiOnlineSearchValuelistElement.getName();
            iSerializer.putOptionalString(string);
            String string2 = poiOnlineSearchValuelistElement.getStreet();
            iSerializer.putOptionalString(string2);
            String string3 = poiOnlineSearchValuelistElement.getPostal();
            iSerializer.putOptionalString(string3);
            String string4 = poiOnlineSearchValuelistElement.getCity();
            iSerializer.putOptionalString(string4);
            String string5 = poiOnlineSearchValuelistElement.getRegion();
            iSerializer.putOptionalString(string5);
            String string6 = poiOnlineSearchValuelistElement.getCountry();
            iSerializer.putOptionalString(string6);
            String string7 = poiOnlineSearchValuelistElement.getPhone();
            iSerializer.putOptionalString(string7);
            String string8 = poiOnlineSearchValuelistElement.getUrl();
            iSerializer.putOptionalString(string8);
            String string9 = poiOnlineSearchValuelistElement.getDescription();
            iSerializer.putOptionalString(string9);
            byte by = poiOnlineSearchValuelistElement.getType();
            iSerializer.putInt8(by);
            String string10 = poiOnlineSearchValuelistElement.getStatusurl();
            iSerializer.putOptionalString(string10);
            String string11 = poiOnlineSearchValuelistElement.getImageUrl();
            iSerializer.putOptionalString(string11);
            int n3 = poiOnlineSearchValuelistElement.getCategory();
            iSerializer.putInt32(n3);
            String string12 = poiOnlineSearchValuelistElement.getAdditionalData();
            iSerializer.putOptionalString(string12);
        }
    }

    public static void putOptionalPoiOnlineSearchValuelistElementVarArray(ISerializer iSerializer, PoiOnlineSearchValuelistElement[] poiOnlineSearchValuelistElementArray) {
        boolean bl = poiOnlineSearchValuelistElementArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(poiOnlineSearchValuelistElementArray.length);
            for (int i2 = 0; i2 < poiOnlineSearchValuelistElementArray.length; ++i2) {
                PoiOnlineSearchValuelistElementSerializer.putOptionalPoiOnlineSearchValuelistElement(iSerializer, poiOnlineSearchValuelistElementArray[i2]);
            }
        }
    }

    public static PoiOnlineSearchValuelistElement getOptionalPoiOnlineSearchValuelistElement(IDeserializer iDeserializer) {
        PoiOnlineSearchValuelistElement poiOnlineSearchValuelistElement = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            int n;
            String string2;
            String string3;
            byte by;
            String string4;
            String string5;
            String string6;
            String string7;
            String string8;
            String string9;
            String string10;
            String string11;
            String string12;
            int n2;
            int n3;
            poiOnlineSearchValuelistElement = new PoiOnlineSearchValuelistElement();
            poiOnlineSearchValuelistElement.longitude = n3 = iDeserializer.getInt32();
            poiOnlineSearchValuelistElement.latitude = n2 = iDeserializer.getInt32();
            poiOnlineSearchValuelistElement.name = string12 = iDeserializer.getOptionalString();
            poiOnlineSearchValuelistElement.street = string11 = iDeserializer.getOptionalString();
            poiOnlineSearchValuelistElement.postal = string10 = iDeserializer.getOptionalString();
            poiOnlineSearchValuelistElement.city = string9 = iDeserializer.getOptionalString();
            poiOnlineSearchValuelistElement.region = string8 = iDeserializer.getOptionalString();
            poiOnlineSearchValuelistElement.country = string7 = iDeserializer.getOptionalString();
            poiOnlineSearchValuelistElement.phone = string6 = iDeserializer.getOptionalString();
            poiOnlineSearchValuelistElement.url = string5 = iDeserializer.getOptionalString();
            poiOnlineSearchValuelistElement.description = string4 = iDeserializer.getOptionalString();
            poiOnlineSearchValuelistElement.type = by = iDeserializer.getInt8();
            poiOnlineSearchValuelistElement.statusurl = string3 = iDeserializer.getOptionalString();
            poiOnlineSearchValuelistElement.imageUrl = string2 = iDeserializer.getOptionalString();
            poiOnlineSearchValuelistElement.category = n = iDeserializer.getInt32();
            poiOnlineSearchValuelistElement.additionalData = string = iDeserializer.getOptionalString();
        }
        return poiOnlineSearchValuelistElement;
    }

    public static PoiOnlineSearchValuelistElement[] getOptionalPoiOnlineSearchValuelistElementVarArray(IDeserializer iDeserializer) {
        PoiOnlineSearchValuelistElement[] poiOnlineSearchValuelistElementArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            poiOnlineSearchValuelistElementArray = new PoiOnlineSearchValuelistElement[n];
            for (int i2 = 0; i2 < n; ++i2) {
                poiOnlineSearchValuelistElementArray[i2] = PoiOnlineSearchValuelistElementSerializer.getOptionalPoiOnlineSearchValuelistElement(iDeserializer);
            }
        }
        return poiOnlineSearchValuelistElementArray;
    }
}

