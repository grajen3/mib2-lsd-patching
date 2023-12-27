/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.navigation.NavNextWayPointInfo;

public class NavNextWayPointInfoSerializer {
    public static void putOptionalNavNextWayPointInfo(ISerializer iSerializer, NavNextWayPointInfo navNextWayPointInfo) {
        boolean bl = navNextWayPointInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = navNextWayPointInfo.getLongitude();
            iSerializer.putInt32(n);
            int n2 = navNextWayPointInfo.getLatitude();
            iSerializer.putInt32(n2);
            long l = navNextWayPointInfo.getDistanceToDestination();
            iSerializer.putInt64(l);
            long l2 = navNextWayPointInfo.getTimeToDestination();
            iSerializer.putInt64(l2);
            int n3 = navNextWayPointInfo.getRemainingWaypoints();
            iSerializer.putInt32(n3);
        }
    }

    public static void putOptionalNavNextWayPointInfoVarArray(ISerializer iSerializer, NavNextWayPointInfo[] navNextWayPointInfoArray) {
        boolean bl = navNextWayPointInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(navNextWayPointInfoArray.length);
            for (int i2 = 0; i2 < navNextWayPointInfoArray.length; ++i2) {
                NavNextWayPointInfoSerializer.putOptionalNavNextWayPointInfo(iSerializer, navNextWayPointInfoArray[i2]);
            }
        }
    }

    public static NavNextWayPointInfo getOptionalNavNextWayPointInfo(IDeserializer iDeserializer) {
        NavNextWayPointInfo navNextWayPointInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            long l;
            long l2;
            int n2;
            int n3;
            navNextWayPointInfo = new NavNextWayPointInfo();
            navNextWayPointInfo.longitude = n3 = iDeserializer.getInt32();
            navNextWayPointInfo.latitude = n2 = iDeserializer.getInt32();
            navNextWayPointInfo.distanceToDestination = l2 = iDeserializer.getInt64();
            navNextWayPointInfo.timeToDestination = l = iDeserializer.getInt64();
            navNextWayPointInfo.remainingWaypoints = n = iDeserializer.getInt32();
        }
        return navNextWayPointInfo;
    }

    public static NavNextWayPointInfo[] getOptionalNavNextWayPointInfoVarArray(IDeserializer iDeserializer) {
        NavNextWayPointInfo[] navNextWayPointInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            navNextWayPointInfoArray = new NavNextWayPointInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                navNextWayPointInfoArray[i2] = NavNextWayPointInfoSerializer.getOptionalNavNextWayPointInfo(iDeserializer);
            }
        }
        return navNextWayPointInfoArray;
    }
}

