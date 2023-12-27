/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.map.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.map.MapFlag;

public class MapFlagSerializer {
    public static void putOptionalMapFlag(ISerializer iSerializer, MapFlag mapFlag) {
        boolean bl = mapFlag == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = mapFlag.getGeoX();
            iSerializer.putInt32(n);
            int n2 = mapFlag.getGeoY();
            iSerializer.putInt32(n2);
            int n3 = mapFlag.getStyleIndex();
            iSerializer.putInt32(n3);
            long l = mapFlag.getHandle();
            iSerializer.putInt64(l);
        }
    }

    public static void putOptionalMapFlagVarArray(ISerializer iSerializer, MapFlag[] mapFlagArray) {
        boolean bl = mapFlagArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(mapFlagArray.length);
            for (int i2 = 0; i2 < mapFlagArray.length; ++i2) {
                MapFlagSerializer.putOptionalMapFlag(iSerializer, mapFlagArray[i2]);
            }
        }
    }

    public static MapFlag getOptionalMapFlag(IDeserializer iDeserializer) {
        MapFlag mapFlag = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            long l;
            int n;
            int n2;
            int n3;
            mapFlag = new MapFlag();
            mapFlag.geoX = n3 = iDeserializer.getInt32();
            mapFlag.geoY = n2 = iDeserializer.getInt32();
            mapFlag.styleIndex = n = iDeserializer.getInt32();
            mapFlag.handle = l = iDeserializer.getInt64();
        }
        return mapFlag;
    }

    public static MapFlag[] getOptionalMapFlagVarArray(IDeserializer iDeserializer) {
        MapFlag[] mapFlagArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            mapFlagArray = new MapFlag[n];
            for (int i2 = 0; i2 < n; ++i2) {
                mapFlagArray[i2] = MapFlagSerializer.getOptionalMapFlag(iDeserializer);
            }
        }
        return mapFlagArray;
    }
}

