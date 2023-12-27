/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.navigation.PosPosition;

public class PosPositionSerializer {
    public static void putOptionalPosPosition(ISerializer iSerializer, PosPosition posPosition) {
        boolean bl = posPosition == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = posPosition.getState();
            iSerializer.putInt32(n);
            double d2 = posPosition.getVdop();
            iSerializer.putDouble(d2);
            double d3 = posPosition.getHdop();
            iSerializer.putDouble(d3);
            double d4 = posPosition.getPdop();
            iSerializer.putDouble(d4);
            int n2 = posPosition.getLongitude();
            iSerializer.putInt32(n2);
            int n3 = posPosition.getLatitude();
            iSerializer.putInt32(n3);
            int n4 = posPosition.getDirectionSymbolic();
            iSerializer.putInt32(n4);
            int n5 = posPosition.getDirectionAngle();
            iSerializer.putInt32(n5);
            int n6 = posPosition.getSpeed();
            iSerializer.putInt32(n6);
            int n7 = posPosition.getReliability();
            iSerializer.putInt32(n7);
            int n8 = posPosition.getHeight();
            iSerializer.putInt32(n8);
            short s = posPosition.getVisibleSatellites();
            iSerializer.putInt16(s);
            short s2 = posPosition.getUsedSatellites();
            iSerializer.putInt16(s2);
            int n9 = posPosition.getRoadClass();
            iSerializer.putInt32(n9);
        }
    }

    public static void putOptionalPosPositionVarArray(ISerializer iSerializer, PosPosition[] posPositionArray) {
        boolean bl = posPositionArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(posPositionArray.length);
            for (int i2 = 0; i2 < posPositionArray.length; ++i2) {
                PosPositionSerializer.putOptionalPosPosition(iSerializer, posPositionArray[i2]);
            }
        }
    }

    public static PosPosition getOptionalPosPosition(IDeserializer iDeserializer) {
        PosPosition posPosition = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            short s;
            short s2;
            int n2;
            int n3;
            int n4;
            int n5;
            int n6;
            int n7;
            int n8;
            double d2;
            double d3;
            double d4;
            int n9;
            posPosition = new PosPosition();
            posPosition.state = n9 = iDeserializer.getInt32();
            posPosition.vdop = d4 = iDeserializer.getDouble();
            posPosition.hdop = d3 = iDeserializer.getDouble();
            posPosition.pdop = d2 = iDeserializer.getDouble();
            posPosition.longitude = n8 = iDeserializer.getInt32();
            posPosition.latitude = n7 = iDeserializer.getInt32();
            posPosition.directionSymbolic = n6 = iDeserializer.getInt32();
            posPosition.directionAngle = n5 = iDeserializer.getInt32();
            posPosition.speed = n4 = iDeserializer.getInt32();
            posPosition.reliability = n3 = iDeserializer.getInt32();
            posPosition.height = n2 = iDeserializer.getInt32();
            posPosition.visibleSatellites = s2 = iDeserializer.getInt16();
            posPosition.usedSatellites = s = iDeserializer.getInt16();
            posPosition.roadClass = n = iDeserializer.getInt32();
        }
        return posPosition;
    }

    public static PosPosition[] getOptionalPosPositionVarArray(IDeserializer iDeserializer) {
        PosPosition[] posPositionArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            posPositionArray = new PosPosition[n];
            for (int i2 = 0; i2 < n; ++i2) {
                posPositionArray[i2] = PosPositionSerializer.getOptionalPosPosition(iDeserializer);
            }
        }
        return posPositionArray;
    }
}

