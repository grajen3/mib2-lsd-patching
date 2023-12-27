/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.bluetooth.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.bluetooth.MasterRoleRequestStruct;

public class MasterRoleRequestStructSerializer {
    public static void putOptionalMasterRoleRequestStruct(ISerializer iSerializer, MasterRoleRequestStruct masterRoleRequestStruct) {
        boolean bl = masterRoleRequestStruct == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = masterRoleRequestStruct.getBtDeviceAddress();
            iSerializer.putOptionalString(string);
            String string2 = masterRoleRequestStruct.getBtDeviceName();
            iSerializer.putOptionalString(string2);
            boolean bl2 = masterRoleRequestStruct.isRequested();
            iSerializer.putBool(bl2);
        }
    }

    public static void putOptionalMasterRoleRequestStructVarArray(ISerializer iSerializer, MasterRoleRequestStruct[] masterRoleRequestStructArray) {
        boolean bl = masterRoleRequestStructArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(masterRoleRequestStructArray.length);
            for (int i2 = 0; i2 < masterRoleRequestStructArray.length; ++i2) {
                MasterRoleRequestStructSerializer.putOptionalMasterRoleRequestStruct(iSerializer, masterRoleRequestStructArray[i2]);
            }
        }
    }

    public static MasterRoleRequestStruct getOptionalMasterRoleRequestStruct(IDeserializer iDeserializer) {
        MasterRoleRequestStruct masterRoleRequestStruct = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            String string;
            String string2;
            masterRoleRequestStruct = new MasterRoleRequestStruct();
            masterRoleRequestStruct.btDeviceAddress = string2 = iDeserializer.getOptionalString();
            masterRoleRequestStruct.btDeviceName = string = iDeserializer.getOptionalString();
            masterRoleRequestStruct.requested = bl2 = iDeserializer.getBool();
        }
        return masterRoleRequestStruct;
    }

    public static MasterRoleRequestStruct[] getOptionalMasterRoleRequestStructVarArray(IDeserializer iDeserializer) {
        MasterRoleRequestStruct[] masterRoleRequestStructArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            masterRoleRequestStructArray = new MasterRoleRequestStruct[n];
            for (int i2 = 0; i2 < n; ++i2) {
                masterRoleRequestStructArray[i2] = MasterRoleRequestStructSerializer.getOptionalMasterRoleRequestStruct(iDeserializer);
            }
        }
        return masterRoleRequestStructArray;
    }
}

