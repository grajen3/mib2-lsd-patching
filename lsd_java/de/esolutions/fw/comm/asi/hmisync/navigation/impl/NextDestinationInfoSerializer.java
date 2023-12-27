/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.navigation.impl;

import de.esolutions.fw.comm.asi.hmisync.navigation.NextDestinationInfo;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class NextDestinationInfoSerializer {
    public static void putOptionalNextDestinationInfo(ISerializer iSerializer, NextDestinationInfo nextDestinationInfo) {
        boolean bl = nextDestinationInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = nextDestinationInfo.getDestinationIndex();
            iSerializer.putInt32(n);
            double d2 = nextDestinationInfo.getDistanceToNextDestination();
            iSerializer.putDouble(d2);
            double d3 = nextDestinationInfo.getTimeToNextDestiantion();
            iSerializer.putDouble(d3);
        }
    }

    public static void putOptionalNextDestinationInfoVarArray(ISerializer iSerializer, NextDestinationInfo[] nextDestinationInfoArray) {
        boolean bl = nextDestinationInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(nextDestinationInfoArray.length);
            for (int i2 = 0; i2 < nextDestinationInfoArray.length; ++i2) {
                NextDestinationInfoSerializer.putOptionalNextDestinationInfo(iSerializer, nextDestinationInfoArray[i2]);
            }
        }
    }

    public static NextDestinationInfo getOptionalNextDestinationInfo(IDeserializer iDeserializer) {
        NextDestinationInfo nextDestinationInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            double d2;
            double d3;
            int n;
            nextDestinationInfo = new NextDestinationInfo();
            nextDestinationInfo.destinationIndex = n = iDeserializer.getInt32();
            nextDestinationInfo.distanceToNextDestination = d3 = iDeserializer.getDouble();
            nextDestinationInfo.timeToNextDestiantion = d2 = iDeserializer.getDouble();
        }
        return nextDestinationInfo;
    }

    public static NextDestinationInfo[] getOptionalNextDestinationInfoVarArray(IDeserializer iDeserializer) {
        NextDestinationInfo[] nextDestinationInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            nextDestinationInfoArray = new NextDestinationInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                nextDestinationInfoArray[i2] = NextDestinationInfoSerializer.getOptionalNextDestinationInfo(iDeserializer);
            }
        }
        return nextDestinationInfoArray;
    }
}

