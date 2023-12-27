/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.navigation.DirectionToWaypoint;

public class DirectionToWaypointSerializer {
    public static void putOptionalDirectionToWaypoint(ISerializer iSerializer, DirectionToWaypoint directionToWaypoint) {
        boolean bl = directionToWaypoint == null;
        iSerializer.putBool(bl);
        if (!bl) {
            short s = directionToWaypoint.getDirectionRelative();
            iSerializer.putInt16(s);
            short s2 = directionToWaypoint.getDirectionAbsolute();
            iSerializer.putInt16(s2);
        }
    }

    public static void putOptionalDirectionToWaypointVarArray(ISerializer iSerializer, DirectionToWaypoint[] directionToWaypointArray) {
        boolean bl = directionToWaypointArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(directionToWaypointArray.length);
            for (int i2 = 0; i2 < directionToWaypointArray.length; ++i2) {
                DirectionToWaypointSerializer.putOptionalDirectionToWaypoint(iSerializer, directionToWaypointArray[i2]);
            }
        }
    }

    public static DirectionToWaypoint getOptionalDirectionToWaypoint(IDeserializer iDeserializer) {
        DirectionToWaypoint directionToWaypoint = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            short s;
            short s2;
            directionToWaypoint = new DirectionToWaypoint();
            directionToWaypoint.directionRelative = s2 = iDeserializer.getInt16();
            directionToWaypoint.directionAbsolute = s = iDeserializer.getInt16();
        }
        return directionToWaypoint;
    }

    public static DirectionToWaypoint[] getOptionalDirectionToWaypointVarArray(IDeserializer iDeserializer) {
        DirectionToWaypoint[] directionToWaypointArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            directionToWaypointArray = new DirectionToWaypoint[n];
            for (int i2 = 0; i2 < n; ++i2) {
                directionToWaypointArray[i2] = DirectionToWaypointSerializer.getOptionalDirectionToWaypoint(iDeserializer);
            }
        }
        return directionToWaypointArray;
    }
}

