/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.comm.dsi.global.impl.NavRectangleSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.navigation.RouteSectionInfo;

public class RouteSectionInfoSerializer {
    public static void putOptionalRouteSectionInfo(ISerializer iSerializer, RouteSectionInfo routeSectionInfo) {
        boolean bl = routeSectionInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = routeSectionInfo.getStartDistanceToDestination();
            iSerializer.putInt64(l);
            long l2 = routeSectionInfo.getLength();
            iSerializer.putInt64(l2);
            long l3 = routeSectionInfo.getStartTimeToDestination();
            iSerializer.putInt64(l3);
            NavRectangle navRectangle = routeSectionInfo.getBoundingRectangle();
            NavRectangleSerializer.putOptionalNavRectangle(iSerializer, navRectangle);
        }
    }

    public static void putOptionalRouteSectionInfoVarArray(ISerializer iSerializer, RouteSectionInfo[] routeSectionInfoArray) {
        boolean bl = routeSectionInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(routeSectionInfoArray.length);
            for (int i2 = 0; i2 < routeSectionInfoArray.length; ++i2) {
                RouteSectionInfoSerializer.putOptionalRouteSectionInfo(iSerializer, routeSectionInfoArray[i2]);
            }
        }
    }

    public static RouteSectionInfo getOptionalRouteSectionInfo(IDeserializer iDeserializer) {
        RouteSectionInfo routeSectionInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            NavRectangle navRectangle;
            long l;
            long l2;
            long l3;
            routeSectionInfo = new RouteSectionInfo();
            routeSectionInfo.startDistanceToDestination = l3 = iDeserializer.getInt64();
            routeSectionInfo.length = l2 = iDeserializer.getInt64();
            routeSectionInfo.startTimeToDestination = l = iDeserializer.getInt64();
            routeSectionInfo.boundingRectangle = navRectangle = NavRectangleSerializer.getOptionalNavRectangle(iDeserializer);
        }
        return routeSectionInfo;
    }

    public static RouteSectionInfo[] getOptionalRouteSectionInfoVarArray(IDeserializer iDeserializer) {
        RouteSectionInfo[] routeSectionInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            routeSectionInfoArray = new RouteSectionInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                routeSectionInfoArray[i2] = RouteSectionInfoSerializer.getOptionalRouteSectionInfo(iDeserializer);
            }
        }
        return routeSectionInfoArray;
    }
}

