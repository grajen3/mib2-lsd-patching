/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.swap.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.swap.SFscImportStatus;

public class SFscImportStatusSerializer {
    public static void putOptionalSFscImportStatus(ISerializer iSerializer, SFscImportStatus sFscImportStatus) {
        boolean bl = sFscImportStatus == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = sFscImportStatus.getSwid();
            iSerializer.putInt32(n);
            int n2 = sFscImportStatus.getState();
            iSerializer.putInt32(n2);
            int n3 = sFscImportStatus.getSuppinfo();
            iSerializer.putInt32(n3);
            int n4 = sFscImportStatus.getIndex();
            iSerializer.putInt32(n4);
        }
    }

    public static void putOptionalSFscImportStatusVarArray(ISerializer iSerializer, SFscImportStatus[] sFscImportStatusArray) {
        boolean bl = sFscImportStatusArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sFscImportStatusArray.length);
            for (int i2 = 0; i2 < sFscImportStatusArray.length; ++i2) {
                SFscImportStatusSerializer.putOptionalSFscImportStatus(iSerializer, sFscImportStatusArray[i2]);
            }
        }
    }

    public static SFscImportStatus getOptionalSFscImportStatus(IDeserializer iDeserializer) {
        SFscImportStatus sFscImportStatus = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            sFscImportStatus = new SFscImportStatus();
            sFscImportStatus.swid = n4 = iDeserializer.getInt32();
            sFscImportStatus.state = n3 = iDeserializer.getInt32();
            sFscImportStatus.suppinfo = n2 = iDeserializer.getInt32();
            sFscImportStatus.index = n = iDeserializer.getInt32();
        }
        return sFscImportStatus;
    }

    public static SFscImportStatus[] getOptionalSFscImportStatusVarArray(IDeserializer iDeserializer) {
        SFscImportStatus[] sFscImportStatusArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sFscImportStatusArray = new SFscImportStatus[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sFscImportStatusArray[i2] = SFscImportStatusSerializer.getOptionalSFscImportStatus(iDeserializer);
            }
        }
        return sFscImportStatusArray;
    }
}

