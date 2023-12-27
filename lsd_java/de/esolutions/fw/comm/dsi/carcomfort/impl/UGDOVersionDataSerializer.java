/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carcomfort.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carcomfort.UGDOVersionData;

public class UGDOVersionDataSerializer {
    public static void putOptionalUGDOVersionData(ISerializer iSerializer, UGDOVersionData uGDOVersionData) {
        boolean bl = uGDOVersionData == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = uGDOVersionData.getCountryCode();
            iSerializer.putInt32(n);
            int n2 = uGDOVersionData.getState();
            iSerializer.putInt32(n2);
            int n3 = uGDOVersionData.getVersion();
            iSerializer.putInt32(n3);
        }
    }

    public static void putOptionalUGDOVersionDataVarArray(ISerializer iSerializer, UGDOVersionData[] uGDOVersionDataArray) {
        boolean bl = uGDOVersionDataArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(uGDOVersionDataArray.length);
            for (int i2 = 0; i2 < uGDOVersionDataArray.length; ++i2) {
                UGDOVersionDataSerializer.putOptionalUGDOVersionData(iSerializer, uGDOVersionDataArray[i2]);
            }
        }
    }

    public static UGDOVersionData getOptionalUGDOVersionData(IDeserializer iDeserializer) {
        UGDOVersionData uGDOVersionData = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            uGDOVersionData = new UGDOVersionData();
            uGDOVersionData.countryCode = n3 = iDeserializer.getInt32();
            uGDOVersionData.state = n2 = iDeserializer.getInt32();
            uGDOVersionData.version = n = iDeserializer.getInt32();
        }
        return uGDOVersionData;
    }

    public static UGDOVersionData[] getOptionalUGDOVersionDataVarArray(IDeserializer iDeserializer) {
        UGDOVersionData[] uGDOVersionDataArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            uGDOVersionDataArray = new UGDOVersionData[n];
            for (int i2 = 0; i2 < n; ++i2) {
                uGDOVersionDataArray[i2] = UGDOVersionDataSerializer.getOptionalUGDOVersionData(iDeserializer);
            }
        }
        return uGDOVersionDataArray;
    }
}

