/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.esoposproviderfull.impl;

import de.esolutions.fw.comm.asi.navigation.esoposproviderfull.sPosition;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class sPositionSerializer {
    public static void putOptionalsPosition(ISerializer iSerializer, sPosition sPosition2) {
        boolean bl = sPosition2 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = sPosition2.getTimeStamp();
            iSerializer.putInt32(n);
            long l = sPosition2.getUtcTimestamp();
            iSerializer.putInt64(l);
            double d2 = sPosition2.getLatitude();
            iSerializer.putDouble(d2);
            double d3 = sPosition2.getLongitude();
            iSerializer.putDouble(d3);
            double d4 = sPosition2.getMercatorX();
            iSerializer.putDouble(d4);
            double d5 = sPosition2.getMercatorY();
            iSerializer.putDouble(d5);
            short s = sPosition2.getHeading();
            iSerializer.putInt16(s);
            short s2 = sPosition2.getBearing();
            iSerializer.putInt16(s2);
        }
    }

    public static void putOptionalsPositionVarArray(ISerializer iSerializer, sPosition[] sPositionArray) {
        boolean bl = sPositionArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sPositionArray.length);
            for (int i2 = 0; i2 < sPositionArray.length; ++i2) {
                sPositionSerializer.putOptionalsPosition(iSerializer, sPositionArray[i2]);
            }
        }
    }

    public static sPosition getOptionalsPosition(IDeserializer iDeserializer) {
        sPosition sPosition2 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            short s;
            short s2;
            double d2;
            double d3;
            double d4;
            double d5;
            long l;
            int n;
            sPosition2 = new sPosition();
            sPosition2.timeStamp = n = iDeserializer.getInt32();
            sPosition2.utcTimestamp = l = iDeserializer.getInt64();
            sPosition2.latitude = d5 = iDeserializer.getDouble();
            sPosition2.longitude = d4 = iDeserializer.getDouble();
            sPosition2.mercatorX = d3 = iDeserializer.getDouble();
            sPosition2.mercatorY = d2 = iDeserializer.getDouble();
            sPosition2.heading = s2 = iDeserializer.getInt16();
            sPosition2.bearing = s = iDeserializer.getInt16();
        }
        return sPosition2;
    }

    public static sPosition[] getOptionalsPositionVarArray(IDeserializer iDeserializer) {
        sPosition[] sPositionArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sPositionArray = new sPosition[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sPositionArray[i2] = sPositionSerializer.getOptionalsPosition(iDeserializer);
            }
        }
        return sPositionArray;
    }
}

