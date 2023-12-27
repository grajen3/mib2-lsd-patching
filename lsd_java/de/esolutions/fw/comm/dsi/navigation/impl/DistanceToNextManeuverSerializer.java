/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.navigation.DistanceToNextManeuver;

public class DistanceToNextManeuverSerializer {
    public static void putOptionalDistanceToNextManeuver(ISerializer iSerializer, DistanceToNextManeuver distanceToNextManeuver) {
        boolean bl = distanceToNextManeuver == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = distanceToNextManeuver.isShowDistance();
            iSerializer.putBool(bl2);
            int n = distanceToNextManeuver.getDistance();
            iSerializer.putInt32(n);
            boolean bl3 = distanceToNextManeuver.isShowBargraph();
            iSerializer.putBool(bl3);
            int n2 = distanceToNextManeuver.getBargraph();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalDistanceToNextManeuverVarArray(ISerializer iSerializer, DistanceToNextManeuver[] distanceToNextManeuverArray) {
        boolean bl = distanceToNextManeuverArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(distanceToNextManeuverArray.length);
            for (int i2 = 0; i2 < distanceToNextManeuverArray.length; ++i2) {
                DistanceToNextManeuverSerializer.putOptionalDistanceToNextManeuver(iSerializer, distanceToNextManeuverArray[i2]);
            }
        }
    }

    public static DistanceToNextManeuver getOptionalDistanceToNextManeuver(IDeserializer iDeserializer) {
        DistanceToNextManeuver distanceToNextManeuver = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            boolean bl2;
            int n2;
            boolean bl3;
            distanceToNextManeuver = new DistanceToNextManeuver();
            distanceToNextManeuver.showDistance = bl3 = iDeserializer.getBool();
            distanceToNextManeuver.distance = n2 = iDeserializer.getInt32();
            distanceToNextManeuver.showBargraph = bl2 = iDeserializer.getBool();
            distanceToNextManeuver.bargraph = n = iDeserializer.getInt32();
        }
        return distanceToNextManeuver;
    }

    public static DistanceToNextManeuver[] getOptionalDistanceToNextManeuverVarArray(IDeserializer iDeserializer) {
        DistanceToNextManeuver[] distanceToNextManeuverArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            distanceToNextManeuverArray = new DistanceToNextManeuver[n];
            for (int i2 = 0; i2 < n; ++i2) {
                distanceToNextManeuverArray[i2] = DistanceToNextManeuverSerializer.getOptionalDistanceToNextManeuver(iDeserializer);
            }
        }
        return distanceToNextManeuverArray;
    }
}

