/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.telephone.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.telephone.NADTemperatureStruct;

public class NADTemperatureStructSerializer {
    public static void putOptionalNADTemperatureStruct(ISerializer iSerializer, NADTemperatureStruct nADTemperatureStruct) {
        boolean bl = nADTemperatureStruct == null;
        iSerializer.putBool(bl);
        if (!bl) {
            short s = nADTemperatureStruct.getTelNADTemperature();
            iSerializer.putInt16(s);
            int n = nADTemperatureStruct.getTelNADTemperatureLevel();
            iSerializer.putInt32(n);
        }
    }

    public static void putOptionalNADTemperatureStructVarArray(ISerializer iSerializer, NADTemperatureStruct[] nADTemperatureStructArray) {
        boolean bl = nADTemperatureStructArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(nADTemperatureStructArray.length);
            for (int i2 = 0; i2 < nADTemperatureStructArray.length; ++i2) {
                NADTemperatureStructSerializer.putOptionalNADTemperatureStruct(iSerializer, nADTemperatureStructArray[i2]);
            }
        }
    }

    public static NADTemperatureStruct getOptionalNADTemperatureStruct(IDeserializer iDeserializer) {
        NADTemperatureStruct nADTemperatureStruct = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            short s;
            nADTemperatureStruct = new NADTemperatureStruct();
            nADTemperatureStruct.telNADTemperature = s = iDeserializer.getInt16();
            nADTemperatureStruct.telNADTemperatureLevel = n = iDeserializer.getInt32();
        }
        return nADTemperatureStruct;
    }

    public static NADTemperatureStruct[] getOptionalNADTemperatureStructVarArray(IDeserializer iDeserializer) {
        NADTemperatureStruct[] nADTemperatureStructArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            nADTemperatureStructArray = new NADTemperatureStruct[n];
            for (int i2 = 0; i2 < n; ++i2) {
                nADTemperatureStructArray[i2] = NADTemperatureStructSerializer.getOptionalNADTemperatureStruct(iDeserializer);
            }
        }
        return nADTemperatureStructArray;
    }
}

