/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.online.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.online.LocatablePosition;

public class LocatablePositionSerializer {
    public static void putOptionalLocatablePosition(ISerializer iSerializer, LocatablePosition locatablePosition) {
        boolean bl = locatablePosition == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = locatablePosition.getLongitude();
            iSerializer.putInt64(l);
            long l2 = locatablePosition.getLatitude();
            iSerializer.putInt64(l2);
            String string = locatablePosition.getCountry();
            iSerializer.putOptionalString(string);
            int n = locatablePosition.getBearing();
            iSerializer.putInt32(n);
            String string2 = locatablePosition.getRoadNumber();
            iSerializer.putOptionalString(string2);
            int n2 = locatablePosition.getFunctionalRoadClass();
            iSerializer.putInt32(n2);
            int n3 = locatablePosition.getFormOfWay();
            iSerializer.putInt32(n3);
            boolean bl2 = locatablePosition.isIsStopOver();
            iSerializer.putBool(bl2);
            String[] stringArray = locatablePosition.getRouteCriteria();
            iSerializer.putOptionalStringVarArray(stringArray);
        }
    }

    public static void putOptionalLocatablePositionVarArray(ISerializer iSerializer, LocatablePosition[] locatablePositionArray) {
        boolean bl = locatablePositionArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(locatablePositionArray.length);
            for (int i2 = 0; i2 < locatablePositionArray.length; ++i2) {
                LocatablePositionSerializer.putOptionalLocatablePosition(iSerializer, locatablePositionArray[i2]);
            }
        }
    }

    public static LocatablePosition getOptionalLocatablePosition(IDeserializer iDeserializer) {
        LocatablePosition locatablePosition = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            int n;
            int n2;
            String string;
            int n3;
            String string2;
            long l;
            long l2;
            locatablePosition = new LocatablePosition();
            locatablePosition.longitude = l2 = iDeserializer.getInt64();
            locatablePosition.latitude = l = iDeserializer.getInt64();
            locatablePosition.country = string2 = iDeserializer.getOptionalString();
            locatablePosition.bearing = n3 = iDeserializer.getInt32();
            locatablePosition.roadNumber = string = iDeserializer.getOptionalString();
            locatablePosition.functionalRoadClass = n2 = iDeserializer.getInt32();
            locatablePosition.formOfWay = n = iDeserializer.getInt32();
            locatablePosition.isStopOver = bl2 = iDeserializer.getBool();
            String[] stringArray = iDeserializer.getOptionalStringVarArray();
            locatablePosition.routeCriteria = stringArray;
        }
        return locatablePosition;
    }

    public static LocatablePosition[] getOptionalLocatablePositionVarArray(IDeserializer iDeserializer) {
        LocatablePosition[] locatablePositionArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            locatablePositionArray = new LocatablePosition[n];
            for (int i2 = 0; i2 < n; ++i2) {
                locatablePositionArray[i2] = LocatablePositionSerializer.getOptionalLocatablePosition(iDeserializer);
            }
        }
        return locatablePositionArray;
    }
}

