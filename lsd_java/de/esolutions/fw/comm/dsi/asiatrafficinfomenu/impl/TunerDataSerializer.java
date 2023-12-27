/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.asiatrafficinfomenu.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.asiatrafficinfomenu.TunerData;

public class TunerDataSerializer {
    public static void putOptionalTunerData(ISerializer iSerializer, TunerData tunerData) {
        boolean bl = tunerData == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = tunerData.getStationName();
            iSerializer.putOptionalString(string);
            long l = tunerData.getFrequency();
            iSerializer.putInt64(l);
        }
    }

    public static void putOptionalTunerDataVarArray(ISerializer iSerializer, TunerData[] tunerDataArray) {
        boolean bl = tunerDataArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(tunerDataArray.length);
            for (int i2 = 0; i2 < tunerDataArray.length; ++i2) {
                TunerDataSerializer.putOptionalTunerData(iSerializer, tunerDataArray[i2]);
            }
        }
    }

    public static TunerData getOptionalTunerData(IDeserializer iDeserializer) {
        TunerData tunerData = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            long l;
            String string;
            tunerData = new TunerData();
            tunerData.stationName = string = iDeserializer.getOptionalString();
            tunerData.frequency = l = iDeserializer.getInt64();
        }
        return tunerData;
    }

    public static TunerData[] getOptionalTunerDataVarArray(IDeserializer iDeserializer) {
        TunerData[] tunerDataArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            tunerDataArray = new TunerData[n];
            for (int i2 = 0; i2 < n; ++i2) {
                tunerDataArray[i2] = TunerDataSerializer.getOptionalTunerData(iDeserializer);
            }
        }
        return tunerDataArray;
    }
}

