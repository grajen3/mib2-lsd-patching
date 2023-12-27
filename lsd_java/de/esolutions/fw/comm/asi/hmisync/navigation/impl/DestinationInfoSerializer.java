/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.navigation.impl;

import de.esolutions.fw.comm.asi.hmisync.navigation.DestinationInfo;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class DestinationInfoSerializer {
    public static void putOptionalDestinationInfo(ISerializer iSerializer, DestinationInfo destinationInfo) {
        boolean bl = destinationInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            double d2 = destinationInfo.getLongitude();
            iSerializer.putDouble(d2);
            double d3 = destinationInfo.getLatitude();
            iSerializer.putDouble(d3);
            String string = destinationInfo.getCountry();
            iSerializer.putOptionalString(string);
            String string2 = destinationInfo.getCity();
            iSerializer.putOptionalString(string2);
            String string3 = destinationInfo.getStreet();
            iSerializer.putOptionalString(string3);
            String string4 = destinationInfo.getJunction();
            iSerializer.putOptionalString(string4);
            String string5 = destinationInfo.getHousenumber();
            iSerializer.putOptionalString(string5);
            String string6 = destinationInfo.getPoiName();
            iSerializer.putOptionalString(string6);
            String[] stringArray = destinationInfo.getFormattedDestination();
            iSerializer.putOptionalStringVarArray(stringArray);
            int n = destinationInfo.getDistanceFromStartOfDestinationToFinalDestination();
            iSerializer.putInt32(n);
            int n2 = destinationInfo.getDistanceFromEndOfDestinationToFinalDestination();
            iSerializer.putInt32(n2);
            double d4 = destinationInfo.getRemainingTravelTimeToFinalDestination();
            iSerializer.putDouble(d4);
        }
    }

    public static void putOptionalDestinationInfoVarArray(ISerializer iSerializer, DestinationInfo[] destinationInfoArray) {
        boolean bl = destinationInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(destinationInfoArray.length);
            for (int i2 = 0; i2 < destinationInfoArray.length; ++i2) {
                DestinationInfoSerializer.putOptionalDestinationInfo(iSerializer, destinationInfoArray[i2]);
            }
        }
    }

    public static DestinationInfo getOptionalDestinationInfo(IDeserializer iDeserializer) {
        DestinationInfo destinationInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            double d2;
            int n;
            int n2;
            String string;
            String string2;
            String string3;
            String string4;
            String string5;
            String string6;
            double d3;
            double d4;
            destinationInfo = new DestinationInfo();
            destinationInfo.longitude = d4 = iDeserializer.getDouble();
            destinationInfo.latitude = d3 = iDeserializer.getDouble();
            destinationInfo.country = string6 = iDeserializer.getOptionalString();
            destinationInfo.city = string5 = iDeserializer.getOptionalString();
            destinationInfo.street = string4 = iDeserializer.getOptionalString();
            destinationInfo.junction = string3 = iDeserializer.getOptionalString();
            destinationInfo.housenumber = string2 = iDeserializer.getOptionalString();
            destinationInfo.poiName = string = iDeserializer.getOptionalString();
            String[] stringArray = iDeserializer.getOptionalStringVarArray();
            destinationInfo.formattedDestination = stringArray;
            destinationInfo.distanceFromStartOfDestinationToFinalDestination = n2 = iDeserializer.getInt32();
            destinationInfo.distanceFromEndOfDestinationToFinalDestination = n = iDeserializer.getInt32();
            destinationInfo.remainingTravelTimeToFinalDestination = d2 = iDeserializer.getDouble();
        }
        return destinationInfo;
    }

    public static DestinationInfo[] getOptionalDestinationInfoVarArray(IDeserializer iDeserializer) {
        DestinationInfo[] destinationInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            destinationInfoArray = new DestinationInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                destinationInfoArray[i2] = DestinationInfoSerializer.getOptionalDestinationInfo(iDeserializer);
            }
        }
        return destinationInfoArray;
    }
}

