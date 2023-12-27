/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.navigation.RgInfoForNextDestination;

public class RgInfoForNextDestinationSerializer {
    public static void putOptionalRgInfoForNextDestination(ISerializer iSerializer, RgInfoForNextDestination rgInfoForNextDestination) {
        boolean bl = rgInfoForNextDestination == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = rgInfoForNextDestination.getAirDistanceToNextDest();
            iSerializer.putInt64(l);
            long l2 = rgInfoForNextDestination.getDistanceToNextDest();
            iSerializer.putInt64(l2);
            long l3 = rgInfoForNextDestination.getTimeToNextDest();
            iSerializer.putInt64(l3);
            int n = rgInfoForNextDestination.getTimeLagToNextDest();
            iSerializer.putInt32(n);
            short s = rgInfoForNextDestination.getDirectionToNextDest();
            iSerializer.putInt16(s);
            int n2 = rgInfoForNextDestination.getTimeToNextDestStatus();
            iSerializer.putInt32(n2);
            int n3 = rgInfoForNextDestination.getDestinationIndex();
            iSerializer.putInt32(n3);
        }
    }

    public static void putOptionalRgInfoForNextDestinationVarArray(ISerializer iSerializer, RgInfoForNextDestination[] rgInfoForNextDestinationArray) {
        boolean bl = rgInfoForNextDestinationArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(rgInfoForNextDestinationArray.length);
            for (int i2 = 0; i2 < rgInfoForNextDestinationArray.length; ++i2) {
                RgInfoForNextDestinationSerializer.putOptionalRgInfoForNextDestination(iSerializer, rgInfoForNextDestinationArray[i2]);
            }
        }
    }

    public static RgInfoForNextDestination getOptionalRgInfoForNextDestination(IDeserializer iDeserializer) {
        RgInfoForNextDestination rgInfoForNextDestination = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            short s;
            int n3;
            long l;
            long l2;
            long l3;
            rgInfoForNextDestination = new RgInfoForNextDestination();
            rgInfoForNextDestination.airDistanceToNextDest = l3 = iDeserializer.getInt64();
            rgInfoForNextDestination.distanceToNextDest = l2 = iDeserializer.getInt64();
            rgInfoForNextDestination.timeToNextDest = l = iDeserializer.getInt64();
            rgInfoForNextDestination.timeLagToNextDest = n3 = iDeserializer.getInt32();
            rgInfoForNextDestination.directionToNextDest = s = iDeserializer.getInt16();
            rgInfoForNextDestination.timeToNextDestStatus = n2 = iDeserializer.getInt32();
            rgInfoForNextDestination.destinationIndex = n = iDeserializer.getInt32();
        }
        return rgInfoForNextDestination;
    }

    public static RgInfoForNextDestination[] getOptionalRgInfoForNextDestinationVarArray(IDeserializer iDeserializer) {
        RgInfoForNextDestination[] rgInfoForNextDestinationArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            rgInfoForNextDestinationArray = new RgInfoForNextDestination[n];
            for (int i2 = 0; i2 < n; ++i2) {
                rgInfoForNextDestinationArray[i2] = RgInfoForNextDestinationSerializer.getOptionalRgInfoForNextDestination(iDeserializer);
            }
        }
        return rgInfoForNextDestinationArray;
    }
}

