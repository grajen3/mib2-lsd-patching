/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.navigation.NavRmRouteListData;

public class NavRmRouteListDataSerializer {
    public static void putOptionalNavRmRouteListData(ISerializer iSerializer, NavRmRouteListData navRmRouteListData) {
        boolean bl = navRmRouteListData == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = navRmRouteListData.getRouteId();
            iSerializer.putInt64(l);
            String string = navRmRouteListData.getName();
            iSerializer.putOptionalString(string);
        }
    }

    public static void putOptionalNavRmRouteListDataVarArray(ISerializer iSerializer, NavRmRouteListData[] navRmRouteListDataArray) {
        boolean bl = navRmRouteListDataArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(navRmRouteListDataArray.length);
            for (int i2 = 0; i2 < navRmRouteListDataArray.length; ++i2) {
                NavRmRouteListDataSerializer.putOptionalNavRmRouteListData(iSerializer, navRmRouteListDataArray[i2]);
            }
        }
    }

    public static NavRmRouteListData getOptionalNavRmRouteListData(IDeserializer iDeserializer) {
        NavRmRouteListData navRmRouteListData = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            long l;
            navRmRouteListData = new NavRmRouteListData();
            navRmRouteListData.routeId = l = iDeserializer.getInt64();
            navRmRouteListData.name = string = iDeserializer.getOptionalString();
        }
        return navRmRouteListData;
    }

    public static NavRmRouteListData[] getOptionalNavRmRouteListDataVarArray(IDeserializer iDeserializer) {
        NavRmRouteListData[] navRmRouteListDataArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            navRmRouteListDataArray = new NavRmRouteListData[n];
            for (int i2 = 0; i2 < n; ++i2) {
                navRmRouteListDataArray[i2] = NavRmRouteListDataSerializer.getOptionalNavRmRouteListData(iDeserializer);
            }
        }
        return navRmRouteListDataArray;
    }
}

