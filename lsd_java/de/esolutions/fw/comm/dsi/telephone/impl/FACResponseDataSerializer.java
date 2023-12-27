/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.telephone.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.telephone.FACResponseData;

public class FACResponseDataSerializer {
    public static void putOptionalFACResponseData(ISerializer iSerializer, FACResponseData fACResponseData) {
        boolean bl = fACResponseData == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = fACResponseData.getTelFACStatus();
            iSerializer.putInt32(n);
            int n2 = fACResponseData.getTelFacility();
            iSerializer.putInt32(n2);
            short s = fACResponseData.getTelClass();
            iSerializer.putInt16(s);
        }
    }

    public static void putOptionalFACResponseDataVarArray(ISerializer iSerializer, FACResponseData[] fACResponseDataArray) {
        boolean bl = fACResponseDataArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(fACResponseDataArray.length);
            for (int i2 = 0; i2 < fACResponseDataArray.length; ++i2) {
                FACResponseDataSerializer.putOptionalFACResponseData(iSerializer, fACResponseDataArray[i2]);
            }
        }
    }

    public static FACResponseData getOptionalFACResponseData(IDeserializer iDeserializer) {
        FACResponseData fACResponseData = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            short s;
            int n;
            int n2;
            fACResponseData = new FACResponseData();
            fACResponseData.telFACStatus = n2 = iDeserializer.getInt32();
            fACResponseData.telFacility = n = iDeserializer.getInt32();
            fACResponseData.telClass = s = iDeserializer.getInt16();
        }
        return fACResponseData;
    }

    public static FACResponseData[] getOptionalFACResponseDataVarArray(IDeserializer iDeserializer) {
        FACResponseData[] fACResponseDataArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            fACResponseDataArray = new FACResponseData[n];
            for (int i2 = 0; i2 < n; ++i2) {
                fACResponseDataArray[i2] = FACResponseDataSerializer.getOptionalFACResponseData(iDeserializer);
            }
        }
        return fACResponseDataArray;
    }
}

