/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.fec.impl;

import de.esolutions.fw.comm.asi.fec.SFecImportStatus;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class SFecImportStatusSerializer {
    public static void putOptionalSFecImportStatus(ISerializer iSerializer, SFecImportStatus sFecImportStatus) {
        boolean bl = sFecImportStatus == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = sFecImportStatus.getFsid();
            iSerializer.putUInt32(l);
            int n = sFecImportStatus.getState();
            iSerializer.putEnum(n);
            int n2 = sFecImportStatus.getSupplementalInfo();
            iSerializer.putEnum(n2);
        }
    }

    public static void putOptionalSFecImportStatusVarArray(ISerializer iSerializer, SFecImportStatus[] sFecImportStatusArray) {
        boolean bl = sFecImportStatusArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sFecImportStatusArray.length);
            for (int i2 = 0; i2 < sFecImportStatusArray.length; ++i2) {
                SFecImportStatusSerializer.putOptionalSFecImportStatus(iSerializer, sFecImportStatusArray[i2]);
            }
        }
    }

    public static SFecImportStatus getOptionalSFecImportStatus(IDeserializer iDeserializer) {
        SFecImportStatus sFecImportStatus = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            long l;
            sFecImportStatus = new SFecImportStatus();
            sFecImportStatus.fsid = l = iDeserializer.getUInt32();
            sFecImportStatus.state = n2 = iDeserializer.getEnum();
            sFecImportStatus.supplementalInfo = n = iDeserializer.getEnum();
        }
        return sFecImportStatus;
    }

    public static SFecImportStatus[] getOptionalSFecImportStatusVarArray(IDeserializer iDeserializer) {
        SFecImportStatus[] sFecImportStatusArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sFecImportStatusArray = new SFecImportStatus[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sFecImportStatusArray[i2] = SFecImportStatusSerializer.getOptionalSFecImportStatus(iDeserializer);
            }
        }
        return sFecImportStatusArray;
    }
}

