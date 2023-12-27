/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.comm.dsi.global.impl.NavLocationSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.TryMatchLocationResultData;

public class TryMatchLocationResultDataSerializer {
    public static void putOptionalTryMatchLocationResultData(ISerializer iSerializer, TryMatchLocationResultData tryMatchLocationResultData) {
        boolean bl = tryMatchLocationResultData == null;
        iSerializer.putBool(bl);
        if (!bl) {
            NavLocation navLocation = tryMatchLocationResultData.getLocation();
            NavLocationSerializer.putOptionalNavLocation(iSerializer, navLocation);
            int n = tryMatchLocationResultData.getMatchLevel();
            iSerializer.putInt32(n);
        }
    }

    public static void putOptionalTryMatchLocationResultDataVarArray(ISerializer iSerializer, TryMatchLocationResultData[] tryMatchLocationResultDataArray) {
        boolean bl = tryMatchLocationResultDataArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(tryMatchLocationResultDataArray.length);
            for (int i2 = 0; i2 < tryMatchLocationResultDataArray.length; ++i2) {
                TryMatchLocationResultDataSerializer.putOptionalTryMatchLocationResultData(iSerializer, tryMatchLocationResultDataArray[i2]);
            }
        }
    }

    public static TryMatchLocationResultData getOptionalTryMatchLocationResultData(IDeserializer iDeserializer) {
        TryMatchLocationResultData tryMatchLocationResultData = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            NavLocation navLocation;
            tryMatchLocationResultData = new TryMatchLocationResultData();
            tryMatchLocationResultData.location = navLocation = NavLocationSerializer.getOptionalNavLocation(iDeserializer);
            tryMatchLocationResultData.matchLevel = n = iDeserializer.getInt32();
        }
        return tryMatchLocationResultData;
    }

    public static TryMatchLocationResultData[] getOptionalTryMatchLocationResultDataVarArray(IDeserializer iDeserializer) {
        TryMatchLocationResultData[] tryMatchLocationResultDataArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            tryMatchLocationResultDataArray = new TryMatchLocationResultData[n];
            for (int i2 = 0; i2 < n; ++i2) {
                tryMatchLocationResultDataArray[i2] = TryMatchLocationResultDataSerializer.getOptionalTryMatchLocationResultData(iDeserializer);
            }
        }
        return tryMatchLocationResultDataArray;
    }
}

