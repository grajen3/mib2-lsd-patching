/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.generalvehiclestates.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.generalvehiclestates.ESPData;

public class ESPDataSerializer {
    public static void putOptionalESPData(ISerializer iSerializer, ESPData eSPData) {
        boolean bl = eSPData == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = eSPData.getVelocity();
            iSerializer.putInt32(n);
            boolean bl2 = eSPData.isStandstill();
            iSerializer.putBool(bl2);
        }
    }

    public static void putOptionalESPDataVarArray(ISerializer iSerializer, ESPData[] eSPDataArray) {
        boolean bl = eSPDataArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(eSPDataArray.length);
            for (int i2 = 0; i2 < eSPDataArray.length; ++i2) {
                ESPDataSerializer.putOptionalESPData(iSerializer, eSPDataArray[i2]);
            }
        }
    }

    public static ESPData getOptionalESPData(IDeserializer iDeserializer) {
        ESPData eSPData = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            int n;
            eSPData = new ESPData();
            eSPData.velocity = n = iDeserializer.getInt32();
            eSPData.standstill = bl2 = iDeserializer.getBool();
        }
        return eSPData;
    }

    public static ESPData[] getOptionalESPDataVarArray(IDeserializer iDeserializer) {
        ESPData[] eSPDataArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            eSPDataArray = new ESPData[n];
            for (int i2 = 0; i2 < n; ++i2) {
                eSPDataArray[i2] = ESPDataSerializer.getOptionalESPData(iDeserializer);
            }
        }
        return eSPDataArray;
    }
}

