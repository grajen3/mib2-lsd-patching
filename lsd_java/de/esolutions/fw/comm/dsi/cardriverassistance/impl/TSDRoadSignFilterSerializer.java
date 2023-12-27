/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cardriverassistance.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.cardriverassistance.TSDRoadSignFilter;

public class TSDRoadSignFilterSerializer {
    public static void putOptionalTSDRoadSignFilter(ISerializer iSerializer, TSDRoadSignFilter tSDRoadSignFilter) {
        boolean bl = tSDRoadSignFilter == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = tSDRoadSignFilter.isTrailerLimits();
            iSerializer.putBool(bl2);
        }
    }

    public static void putOptionalTSDRoadSignFilterVarArray(ISerializer iSerializer, TSDRoadSignFilter[] tSDRoadSignFilterArray) {
        boolean bl = tSDRoadSignFilterArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(tSDRoadSignFilterArray.length);
            for (int i2 = 0; i2 < tSDRoadSignFilterArray.length; ++i2) {
                TSDRoadSignFilterSerializer.putOptionalTSDRoadSignFilter(iSerializer, tSDRoadSignFilterArray[i2]);
            }
        }
    }

    public static TSDRoadSignFilter getOptionalTSDRoadSignFilter(IDeserializer iDeserializer) {
        TSDRoadSignFilter tSDRoadSignFilter = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            tSDRoadSignFilter = new TSDRoadSignFilter();
            tSDRoadSignFilter.trailerLimits = bl2 = iDeserializer.getBool();
        }
        return tSDRoadSignFilter;
    }

    public static TSDRoadSignFilter[] getOptionalTSDRoadSignFilterVarArray(IDeserializer iDeserializer) {
        TSDRoadSignFilter[] tSDRoadSignFilterArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            tSDRoadSignFilterArray = new TSDRoadSignFilter[n];
            for (int i2 = 0; i2 < n; ++i2) {
                tSDRoadSignFilterArray[i2] = TSDRoadSignFilterSerializer.getOptionalTSDRoadSignFilter(iDeserializer);
            }
        }
        return tSDRoadSignFilterArray;
    }
}

