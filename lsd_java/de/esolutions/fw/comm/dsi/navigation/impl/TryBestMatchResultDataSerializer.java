/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.comm.dsi.global.impl.NavLocationSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.TryBestMatchResultData;

public class TryBestMatchResultDataSerializer {
    public static void putOptionalTryBestMatchResultData(ISerializer iSerializer, TryBestMatchResultData tryBestMatchResultData) {
        boolean bl = tryBestMatchResultData == null;
        iSerializer.putBool(bl);
        if (!bl) {
            NavLocation navLocation = tryBestMatchResultData.getLocation();
            NavLocationSerializer.putOptionalNavLocation(iSerializer, navLocation);
        }
    }

    public static void putOptionalTryBestMatchResultDataVarArray(ISerializer iSerializer, TryBestMatchResultData[] tryBestMatchResultDataArray) {
        boolean bl = tryBestMatchResultDataArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(tryBestMatchResultDataArray.length);
            for (int i2 = 0; i2 < tryBestMatchResultDataArray.length; ++i2) {
                TryBestMatchResultDataSerializer.putOptionalTryBestMatchResultData(iSerializer, tryBestMatchResultDataArray[i2]);
            }
        }
    }

    public static TryBestMatchResultData getOptionalTryBestMatchResultData(IDeserializer iDeserializer) {
        TryBestMatchResultData tryBestMatchResultData = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            NavLocation navLocation;
            tryBestMatchResultData = new TryBestMatchResultData();
            tryBestMatchResultData.location = navLocation = NavLocationSerializer.getOptionalNavLocation(iDeserializer);
        }
        return tryBestMatchResultData;
    }

    public static TryBestMatchResultData[] getOptionalTryBestMatchResultDataVarArray(IDeserializer iDeserializer) {
        TryBestMatchResultData[] tryBestMatchResultDataArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            tryBestMatchResultDataArray = new TryBestMatchResultData[n];
            for (int i2 = 0; i2 < n; ++i2) {
                tryBestMatchResultDataArray[i2] = TryBestMatchResultDataSerializer.getOptionalTryBestMatchResultData(iDeserializer);
            }
        }
        return tryBestMatchResultDataArray;
    }
}

