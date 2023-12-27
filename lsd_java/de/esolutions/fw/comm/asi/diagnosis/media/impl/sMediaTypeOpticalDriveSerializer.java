/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.media.impl;

import de.esolutions.fw.comm.asi.diagnosis.media.sMediaTypeOpticalDrive;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class sMediaTypeOpticalDriveSerializer {
    public static void putOptionalsMediaTypeOpticalDrive(ISerializer iSerializer, sMediaTypeOpticalDrive sMediaTypeOpticalDrive2) {
        boolean bl = sMediaTypeOpticalDrive2 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = sMediaTypeOpticalDrive2.getMsg_id();
            iSerializer.putUInt32(l);
            int n = sMediaTypeOpticalDrive2.getType();
            iSerializer.putEnum(n);
        }
    }

    public static void putOptionalsMediaTypeOpticalDriveVarArray(ISerializer iSerializer, sMediaTypeOpticalDrive[] sMediaTypeOpticalDriveArray) {
        boolean bl = sMediaTypeOpticalDriveArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sMediaTypeOpticalDriveArray.length);
            for (int i2 = 0; i2 < sMediaTypeOpticalDriveArray.length; ++i2) {
                sMediaTypeOpticalDriveSerializer.putOptionalsMediaTypeOpticalDrive(iSerializer, sMediaTypeOpticalDriveArray[i2]);
            }
        }
    }

    public static sMediaTypeOpticalDrive getOptionalsMediaTypeOpticalDrive(IDeserializer iDeserializer) {
        sMediaTypeOpticalDrive sMediaTypeOpticalDrive2 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            long l;
            sMediaTypeOpticalDrive2 = new sMediaTypeOpticalDrive();
            sMediaTypeOpticalDrive2.msg_id = l = iDeserializer.getUInt32();
            sMediaTypeOpticalDrive2.type = n = iDeserializer.getEnum();
        }
        return sMediaTypeOpticalDrive2;
    }

    public static sMediaTypeOpticalDrive[] getOptionalsMediaTypeOpticalDriveVarArray(IDeserializer iDeserializer) {
        sMediaTypeOpticalDrive[] sMediaTypeOpticalDriveArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sMediaTypeOpticalDriveArray = new sMediaTypeOpticalDrive[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sMediaTypeOpticalDriveArray[i2] = sMediaTypeOpticalDriveSerializer.getOptionalsMediaTypeOpticalDrive(iDeserializer);
            }
        }
        return sMediaTypeOpticalDriveArray;
    }
}

