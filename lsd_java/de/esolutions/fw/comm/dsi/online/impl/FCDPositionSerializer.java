/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.online.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.online.FCDPosition;

public class FCDPositionSerializer {
    public static void putOptionalFCDPosition(ISerializer iSerializer, FCDPosition fCDPosition) {
        boolean bl = fCDPosition == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = fCDPosition.getTimestamp();
            iSerializer.putInt64(l);
            double d2 = fCDPosition.getLon();
            iSerializer.putDouble(d2);
            double d3 = fCDPosition.getLat();
            iSerializer.putDouble(d3);
            int n = fCDPosition.getFormOfWay();
            iSerializer.putInt32(n);
            int n2 = fCDPosition.getFunctionalRoadClass();
            iSerializer.putInt32(n2);
            String string = fCDPosition.getRoadNumber();
            iSerializer.putOptionalString(string);
            int n3 = fCDPosition.getHeading();
            iSerializer.putInt32(n3);
            int n4 = fCDPosition.getSpeed();
            iSerializer.putInt32(n4);
            int n5 = fCDPosition.getTemperature();
            iSerializer.putInt32(n5);
            int n6 = fCDPosition.getRain();
            iSerializer.putInt32(n6);
            long l2 = fCDPosition.getValidBitArray();
            iSerializer.putInt64(l2);
        }
    }

    public static void putOptionalFCDPositionVarArray(ISerializer iSerializer, FCDPosition[] fCDPositionArray) {
        boolean bl = fCDPositionArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(fCDPositionArray.length);
            for (int i2 = 0; i2 < fCDPositionArray.length; ++i2) {
                FCDPositionSerializer.putOptionalFCDPosition(iSerializer, fCDPositionArray[i2]);
            }
        }
    }

    public static FCDPosition getOptionalFCDPosition(IDeserializer iDeserializer) {
        FCDPosition fCDPosition = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            long l;
            int n;
            int n2;
            int n3;
            int n4;
            String string;
            int n5;
            int n6;
            double d2;
            double d3;
            long l2;
            fCDPosition = new FCDPosition();
            fCDPosition.timestamp = l2 = iDeserializer.getInt64();
            fCDPosition.lon = d3 = iDeserializer.getDouble();
            fCDPosition.lat = d2 = iDeserializer.getDouble();
            fCDPosition.formOfWay = n6 = iDeserializer.getInt32();
            fCDPosition.functionalRoadClass = n5 = iDeserializer.getInt32();
            fCDPosition.roadNumber = string = iDeserializer.getOptionalString();
            fCDPosition.heading = n4 = iDeserializer.getInt32();
            fCDPosition.speed = n3 = iDeserializer.getInt32();
            fCDPosition.temperature = n2 = iDeserializer.getInt32();
            fCDPosition.rain = n = iDeserializer.getInt32();
            fCDPosition.validBitArray = l = iDeserializer.getInt64();
        }
        return fCDPosition;
    }

    public static FCDPosition[] getOptionalFCDPositionVarArray(IDeserializer iDeserializer) {
        FCDPosition[] fCDPositionArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            fCDPositionArray = new FCDPosition[n];
            for (int i2 = 0; i2 < n; ++i2) {
                fCDPositionArray[i2] = FCDPositionSerializer.getOptionalFCDPosition(iDeserializer);
            }
        }
        return fCDPositionArray;
    }
}

