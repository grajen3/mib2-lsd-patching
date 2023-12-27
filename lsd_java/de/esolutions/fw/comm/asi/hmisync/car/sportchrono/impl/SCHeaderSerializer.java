/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.sportchrono.impl;

import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.SCHeader;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class SCHeaderSerializer {
    public static void putOptionalSCHeader(ISerializer iSerializer, SCHeader sCHeader) {
        boolean bl = sCHeader == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = sCHeader.getUid();
            iSerializer.putInt32(n);
            int n2 = sCHeader.getNumOfRecords();
            iSerializer.putInt32(n2);
            byte[] byArray = sCHeader.getHeader();
            iSerializer.putOptionalInt8VarArray(byArray);
        }
    }

    public static void putOptionalSCHeaderVarArray(ISerializer iSerializer, SCHeader[] sCHeaderArray) {
        boolean bl = sCHeaderArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sCHeaderArray.length);
            for (int i2 = 0; i2 < sCHeaderArray.length; ++i2) {
                SCHeaderSerializer.putOptionalSCHeader(iSerializer, sCHeaderArray[i2]);
            }
        }
    }

    public static SCHeader getOptionalSCHeader(IDeserializer iDeserializer) {
        SCHeader sCHeader = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            sCHeader = new SCHeader();
            sCHeader.uid = n2 = iDeserializer.getInt32();
            sCHeader.numOfRecords = n = iDeserializer.getInt32();
            byte[] byArray = iDeserializer.getOptionalInt8VarArray();
            sCHeader.header = byArray;
        }
        return sCHeader;
    }

    public static SCHeader[] getOptionalSCHeaderVarArray(IDeserializer iDeserializer) {
        SCHeader[] sCHeaderArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sCHeaderArray = new SCHeader[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sCHeaderArray[i2] = SCHeaderSerializer.getOptionalSCHeader(iDeserializer);
            }
        }
        return sCHeaderArray;
    }
}

