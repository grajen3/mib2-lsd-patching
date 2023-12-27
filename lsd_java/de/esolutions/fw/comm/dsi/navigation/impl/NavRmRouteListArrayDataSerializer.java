/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.comm.dsi.navigation.impl.NavRmRouteListDataSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.navigation.NavRmRouteListArrayData;
import org.dsi.ifc.navigation.NavRmRouteListData;

public class NavRmRouteListArrayDataSerializer {
    public static void putOptionalNavRmRouteListArrayData(ISerializer iSerializer, NavRmRouteListArrayData navRmRouteListArrayData) {
        boolean bl = navRmRouteListArrayData == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = navRmRouteListArrayData.getRmId();
            iSerializer.putInt32(n);
            NavRmRouteListData[] navRmRouteListDataArray = navRmRouteListArrayData.getRouteList();
            NavRmRouteListDataSerializer.putOptionalNavRmRouteListDataVarArray(iSerializer, navRmRouteListDataArray);
            int n2 = navRmRouteListArrayData.getTotalSlots();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalNavRmRouteListArrayDataVarArray(ISerializer iSerializer, NavRmRouteListArrayData[] navRmRouteListArrayDataArray) {
        boolean bl = navRmRouteListArrayDataArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(navRmRouteListArrayDataArray.length);
            for (int i2 = 0; i2 < navRmRouteListArrayDataArray.length; ++i2) {
                NavRmRouteListArrayDataSerializer.putOptionalNavRmRouteListArrayData(iSerializer, navRmRouteListArrayDataArray[i2]);
            }
        }
    }

    public static NavRmRouteListArrayData getOptionalNavRmRouteListArrayData(IDeserializer iDeserializer) {
        NavRmRouteListArrayData navRmRouteListArrayData = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            navRmRouteListArrayData = new NavRmRouteListArrayData();
            navRmRouteListArrayData.rmId = n2 = iDeserializer.getInt32();
            NavRmRouteListData[] navRmRouteListDataArray = NavRmRouteListDataSerializer.getOptionalNavRmRouteListDataVarArray(iDeserializer);
            navRmRouteListArrayData.routeList = navRmRouteListDataArray;
            navRmRouteListArrayData.totalSlots = n = iDeserializer.getInt32();
        }
        return navRmRouteListArrayData;
    }

    public static NavRmRouteListArrayData[] getOptionalNavRmRouteListArrayDataVarArray(IDeserializer iDeserializer) {
        NavRmRouteListArrayData[] navRmRouteListArrayDataArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            navRmRouteListArrayDataArray = new NavRmRouteListArrayData[n];
            for (int i2 = 0; i2 < n; ++i2) {
                navRmRouteListArrayDataArray[i2] = NavRmRouteListArrayDataSerializer.getOptionalNavRmRouteListArrayData(iDeserializer);
            }
        }
        return navRmRouteListArrayDataArray;
    }
}

