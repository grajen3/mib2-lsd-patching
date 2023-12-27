/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carcomfort.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carcomfort.DoorLockingUserListUpdateInfo;

public class DoorLockingUserListUpdateInfoSerializer {
    public static void putOptionalDoorLockingUserListUpdateInfo(ISerializer iSerializer, DoorLockingUserListUpdateInfo doorLockingUserListUpdateInfo) {
        boolean bl = doorLockingUserListUpdateInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = doorLockingUserListUpdateInfo.getArrayContent();
            iSerializer.putInt32(n);
            int n2 = doorLockingUserListUpdateInfo.getRecordContent();
            iSerializer.putInt32(n2);
            int n3 = doorLockingUserListUpdateInfo.getTransactionID();
            iSerializer.putInt32(n3);
            int n4 = doorLockingUserListUpdateInfo.getStartElement();
            iSerializer.putInt32(n4);
            int n5 = doorLockingUserListUpdateInfo.getNumOfElements();
            iSerializer.putInt32(n5);
            int n6 = doorLockingUserListUpdateInfo.getAsgID();
            iSerializer.putInt32(n6);
        }
    }

    public static void putOptionalDoorLockingUserListUpdateInfoVarArray(ISerializer iSerializer, DoorLockingUserListUpdateInfo[] doorLockingUserListUpdateInfoArray) {
        boolean bl = doorLockingUserListUpdateInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(doorLockingUserListUpdateInfoArray.length);
            for (int i2 = 0; i2 < doorLockingUserListUpdateInfoArray.length; ++i2) {
                DoorLockingUserListUpdateInfoSerializer.putOptionalDoorLockingUserListUpdateInfo(iSerializer, doorLockingUserListUpdateInfoArray[i2]);
            }
        }
    }

    public static DoorLockingUserListUpdateInfo getOptionalDoorLockingUserListUpdateInfo(IDeserializer iDeserializer) {
        DoorLockingUserListUpdateInfo doorLockingUserListUpdateInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            int n5;
            int n6;
            doorLockingUserListUpdateInfo = new DoorLockingUserListUpdateInfo();
            doorLockingUserListUpdateInfo.arrayContent = n6 = iDeserializer.getInt32();
            doorLockingUserListUpdateInfo.recordContent = n5 = iDeserializer.getInt32();
            doorLockingUserListUpdateInfo.transactionID = n4 = iDeserializer.getInt32();
            doorLockingUserListUpdateInfo.startElement = n3 = iDeserializer.getInt32();
            doorLockingUserListUpdateInfo.numOfElements = n2 = iDeserializer.getInt32();
            doorLockingUserListUpdateInfo.asgID = n = iDeserializer.getInt32();
        }
        return doorLockingUserListUpdateInfo;
    }

    public static DoorLockingUserListUpdateInfo[] getOptionalDoorLockingUserListUpdateInfoVarArray(IDeserializer iDeserializer) {
        DoorLockingUserListUpdateInfo[] doorLockingUserListUpdateInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            doorLockingUserListUpdateInfoArray = new DoorLockingUserListUpdateInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                doorLockingUserListUpdateInfoArray[i2] = DoorLockingUserListUpdateInfoSerializer.getOptionalDoorLockingUserListUpdateInfo(iDeserializer);
            }
        }
        return doorLockingUserListUpdateInfoArray;
    }
}

