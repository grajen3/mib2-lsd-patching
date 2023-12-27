/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.comm.dsi.global.impl.NavSegmentIDSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.NavSegmentID;
import org.dsi.ifc.navigation.NavTraceListData;

public class NavTraceListDataSerializer {
    public static void putOptionalNavTraceListData(ISerializer iSerializer, NavTraceListData navTraceListData) {
        boolean bl = navTraceListData == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = navTraceListData.getName();
            iSerializer.putOptionalString(string);
            NavSegmentID navSegmentID = navTraceListData.getTraceID();
            NavSegmentIDSerializer.putOptionalNavSegmentID(iSerializer, navSegmentID);
            int n = navTraceListData.getStartLongitude();
            iSerializer.putInt32(n);
            int n2 = navTraceListData.getStartLatitude();
            iSerializer.putInt32(n2);
            int n3 = navTraceListData.getEndLongitude();
            iSerializer.putInt32(n3);
            int n4 = navTraceListData.getEndLatitude();
            iSerializer.putInt32(n4);
            long l = navTraceListData.getLength();
            iSerializer.putInt64(l);
            int n5 = navTraceListData.getNumberOfTrackPoints();
            iSerializer.putInt32(n5);
        }
    }

    public static void putOptionalNavTraceListDataVarArray(ISerializer iSerializer, NavTraceListData[] navTraceListDataArray) {
        boolean bl = navTraceListDataArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(navTraceListDataArray.length);
            for (int i2 = 0; i2 < navTraceListDataArray.length; ++i2) {
                NavTraceListDataSerializer.putOptionalNavTraceListData(iSerializer, navTraceListDataArray[i2]);
            }
        }
    }

    public static NavTraceListData getOptionalNavTraceListData(IDeserializer iDeserializer) {
        NavTraceListData navTraceListData = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            long l;
            int n2;
            int n3;
            int n4;
            int n5;
            NavSegmentID navSegmentID;
            String string;
            navTraceListData = new NavTraceListData();
            navTraceListData.name = string = iDeserializer.getOptionalString();
            navTraceListData.traceID = navSegmentID = NavSegmentIDSerializer.getOptionalNavSegmentID(iDeserializer);
            navTraceListData.startLongitude = n5 = iDeserializer.getInt32();
            navTraceListData.startLatitude = n4 = iDeserializer.getInt32();
            navTraceListData.endLongitude = n3 = iDeserializer.getInt32();
            navTraceListData.endLatitude = n2 = iDeserializer.getInt32();
            navTraceListData.length = l = iDeserializer.getInt64();
            navTraceListData.numberOfTrackPoints = n = iDeserializer.getInt32();
        }
        return navTraceListData;
    }

    public static NavTraceListData[] getOptionalNavTraceListDataVarArray(IDeserializer iDeserializer) {
        NavTraceListData[] navTraceListDataArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            navTraceListDataArray = new NavTraceListData[n];
            for (int i2 = 0; i2 < n; ++i2) {
                navTraceListDataArray[i2] = NavTraceListDataSerializer.getOptionalNavTraceListData(iDeserializer);
            }
        }
        return navTraceListDataArray;
    }
}

