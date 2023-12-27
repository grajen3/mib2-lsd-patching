/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carcomfort.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carcomfort.UGDOOpenDoor;

public class UGDOOpenDoorSerializer {
    public static void putOptionalUGDOOpenDoor(ISerializer iSerializer, UGDOOpenDoor uGDOOpenDoor) {
        boolean bl = uGDOOpenDoor == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = uGDOOpenDoor.getDoorState();
            iSerializer.putInt32(n);
            int n2 = uGDOOpenDoor.getSoftkey();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalUGDOOpenDoorVarArray(ISerializer iSerializer, UGDOOpenDoor[] uGDOOpenDoorArray) {
        boolean bl = uGDOOpenDoorArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(uGDOOpenDoorArray.length);
            for (int i2 = 0; i2 < uGDOOpenDoorArray.length; ++i2) {
                UGDOOpenDoorSerializer.putOptionalUGDOOpenDoor(iSerializer, uGDOOpenDoorArray[i2]);
            }
        }
    }

    public static UGDOOpenDoor getOptionalUGDOOpenDoor(IDeserializer iDeserializer) {
        UGDOOpenDoor uGDOOpenDoor = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            uGDOOpenDoor = new UGDOOpenDoor();
            uGDOOpenDoor.doorState = n2 = iDeserializer.getInt32();
            uGDOOpenDoor.softkey = n = iDeserializer.getInt32();
        }
        return uGDOOpenDoor;
    }

    public static UGDOOpenDoor[] getOptionalUGDOOpenDoorVarArray(IDeserializer iDeserializer) {
        UGDOOpenDoor[] uGDOOpenDoorArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            uGDOOpenDoorArray = new UGDOOpenDoor[n];
            for (int i2 = 0; i2 < n; ++i2) {
                uGDOOpenDoorArray[i2] = UGDOOpenDoorSerializer.getOptionalUGDOOpenDoor(iDeserializer);
            }
        }
        return uGDOOpenDoorArray;
    }
}

