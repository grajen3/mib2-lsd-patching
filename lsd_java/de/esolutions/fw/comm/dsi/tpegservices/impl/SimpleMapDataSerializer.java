/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.tpegservices.impl;

import de.esolutions.fw.comm.dsi.global.impl.DateTimeSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.DateTime;
import org.dsi.ifc.tpegservices.SimpleMapData;

public class SimpleMapDataSerializer {
    public static void putOptionalSimpleMapData(ISerializer iSerializer, SimpleMapData simpleMapData) {
        boolean bl = simpleMapData == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = simpleMapData.getId();
            iSerializer.putInt32(n);
            int n2 = simpleMapData.getContentId();
            iSerializer.putInt32(n2);
            boolean bl2 = simpleMapData.isSubCategory();
            iSerializer.putBool(bl2);
            boolean bl3 = simpleMapData.isIsBookmark();
            iSerializer.putBool(bl3);
            String string = simpleMapData.getDescription();
            iSerializer.putOptionalString(string);
            DateTime dateTime = simpleMapData.getTimestamp();
            DateTimeSerializer.putOptionalDateTime(iSerializer, dateTime);
        }
    }

    public static void putOptionalSimpleMapDataVarArray(ISerializer iSerializer, SimpleMapData[] simpleMapDataArray) {
        boolean bl = simpleMapDataArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(simpleMapDataArray.length);
            for (int i2 = 0; i2 < simpleMapDataArray.length; ++i2) {
                SimpleMapDataSerializer.putOptionalSimpleMapData(iSerializer, simpleMapDataArray[i2]);
            }
        }
    }

    public static SimpleMapData getOptionalSimpleMapData(IDeserializer iDeserializer) {
        SimpleMapData simpleMapData = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            DateTime dateTime;
            String string;
            boolean bl2;
            boolean bl3;
            int n;
            int n2;
            simpleMapData = new SimpleMapData();
            simpleMapData.id = n2 = iDeserializer.getInt32();
            simpleMapData.contentId = n = iDeserializer.getInt32();
            simpleMapData.subCategory = bl3 = iDeserializer.getBool();
            simpleMapData.isBookmark = bl2 = iDeserializer.getBool();
            simpleMapData.description = string = iDeserializer.getOptionalString();
            simpleMapData.timestamp = dateTime = DateTimeSerializer.getOptionalDateTime(iDeserializer);
        }
        return simpleMapData;
    }

    public static SimpleMapData[] getOptionalSimpleMapDataVarArray(IDeserializer iDeserializer) {
        SimpleMapData[] simpleMapDataArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            simpleMapDataArray = new SimpleMapData[n];
            for (int i2 = 0; i2 < n; ++i2) {
                simpleMapDataArray[i2] = SimpleMapDataSerializer.getOptionalSimpleMapData(iDeserializer);
            }
        }
        return simpleMapDataArray;
    }
}

