/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.search.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.search.NavPosition;

public class NavPositionSerializer {
    public static void putOptionalNavPosition(ISerializer iSerializer, NavPosition navPosition) {
        boolean bl = navPosition == null;
        iSerializer.putBool(bl);
        if (!bl) {
            float f2 = navPosition.getLat();
            iSerializer.putFloat(f2);
            float f3 = navPosition.getLon();
            iSerializer.putFloat(f3);
        }
    }

    public static void putOptionalNavPositionVarArray(ISerializer iSerializer, NavPosition[] navPositionArray) {
        boolean bl = navPositionArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(navPositionArray.length);
            for (int i2 = 0; i2 < navPositionArray.length; ++i2) {
                NavPositionSerializer.putOptionalNavPosition(iSerializer, navPositionArray[i2]);
            }
        }
    }

    public static NavPosition getOptionalNavPosition(IDeserializer iDeserializer) {
        NavPosition navPosition = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            float f2;
            float f3;
            navPosition = new NavPosition();
            navPosition.lat = f3 = iDeserializer.getFloat();
            navPosition.lon = f2 = iDeserializer.getFloat();
        }
        return navPosition;
    }

    public static NavPosition[] getOptionalNavPositionVarArray(IDeserializer iDeserializer) {
        NavPosition[] navPositionArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            navPositionArray = new NavPosition[n];
            for (int i2 = 0; i2 < n; ++i2) {
                navPositionArray[i2] = NavPositionSerializer.getOptionalNavPosition(iDeserializer);
            }
        }
        return navPositionArray;
    }
}

