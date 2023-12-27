/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.sportchrono.impl;

import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.SCRefLapHeader;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class SCRefLapHeaderSerializer {
    public static void putOptionalSCRefLapHeader(ISerializer iSerializer, SCRefLapHeader sCRefLapHeader) {
        boolean bl = sCRefLapHeader == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = sCRefLapHeader.getUid();
            iSerializer.putInt32(n);
            int n2 = sCRefLapHeader.getNumOfRecords();
            iSerializer.putInt32(n2);
            byte[] byArray = sCRefLapHeader.getHeader();
            iSerializer.putOptionalInt8VarArray(byArray);
        }
    }

    public static void putOptionalSCRefLapHeaderVarArray(ISerializer iSerializer, SCRefLapHeader[] sCRefLapHeaderArray) {
        boolean bl = sCRefLapHeaderArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sCRefLapHeaderArray.length);
            for (int i2 = 0; i2 < sCRefLapHeaderArray.length; ++i2) {
                SCRefLapHeaderSerializer.putOptionalSCRefLapHeader(iSerializer, sCRefLapHeaderArray[i2]);
            }
        }
    }

    public static SCRefLapHeader getOptionalSCRefLapHeader(IDeserializer iDeserializer) {
        SCRefLapHeader sCRefLapHeader = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            sCRefLapHeader = new SCRefLapHeader();
            sCRefLapHeader.uid = n2 = iDeserializer.getInt32();
            sCRefLapHeader.numOfRecords = n = iDeserializer.getInt32();
            byte[] byArray = iDeserializer.getOptionalInt8VarArray();
            sCRefLapHeader.header = byArray;
        }
        return sCRefLapHeader;
    }

    public static SCRefLapHeader[] getOptionalSCRefLapHeaderVarArray(IDeserializer iDeserializer) {
        SCRefLapHeader[] sCRefLapHeaderArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sCRefLapHeaderArray = new SCRefLapHeader[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sCRefLapHeaderArray[i2] = SCRefLapHeaderSerializer.getOptionalSCRefLapHeader(iDeserializer);
            }
        }
        return sCRefLapHeaderArray;
    }
}

