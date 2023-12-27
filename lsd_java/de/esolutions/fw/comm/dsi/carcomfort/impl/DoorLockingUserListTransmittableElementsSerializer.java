/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carcomfort.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carcomfort.DoorLockingUserListTransmittableElements;

public class DoorLockingUserListTransmittableElementsSerializer {
    public static void putOptionalDoorLockingUserListTransmittableElements(ISerializer iSerializer, DoorLockingUserListTransmittableElements doorLockingUserListTransmittableElements) {
        boolean bl = doorLockingUserListTransmittableElements == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = doorLockingUserListTransmittableElements.getRa1();
            iSerializer.putInt32(n);
            int n2 = doorLockingUserListTransmittableElements.getRaF();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalDoorLockingUserListTransmittableElementsVarArray(ISerializer iSerializer, DoorLockingUserListTransmittableElements[] doorLockingUserListTransmittableElementsArray) {
        boolean bl = doorLockingUserListTransmittableElementsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(doorLockingUserListTransmittableElementsArray.length);
            for (int i2 = 0; i2 < doorLockingUserListTransmittableElementsArray.length; ++i2) {
                DoorLockingUserListTransmittableElementsSerializer.putOptionalDoorLockingUserListTransmittableElements(iSerializer, doorLockingUserListTransmittableElementsArray[i2]);
            }
        }
    }

    public static DoorLockingUserListTransmittableElements getOptionalDoorLockingUserListTransmittableElements(IDeserializer iDeserializer) {
        DoorLockingUserListTransmittableElements doorLockingUserListTransmittableElements = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            doorLockingUserListTransmittableElements = new DoorLockingUserListTransmittableElements();
            doorLockingUserListTransmittableElements.ra1 = n2 = iDeserializer.getInt32();
            doorLockingUserListTransmittableElements.raF = n = iDeserializer.getInt32();
        }
        return doorLockingUserListTransmittableElements;
    }

    public static DoorLockingUserListTransmittableElements[] getOptionalDoorLockingUserListTransmittableElementsVarArray(IDeserializer iDeserializer) {
        DoorLockingUserListTransmittableElements[] doorLockingUserListTransmittableElementsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            doorLockingUserListTransmittableElementsArray = new DoorLockingUserListTransmittableElements[n];
            for (int i2 = 0; i2 < n; ++i2) {
                doorLockingUserListTransmittableElementsArray[i2] = DoorLockingUserListTransmittableElementsSerializer.getOptionalDoorLockingUserListTransmittableElements(iDeserializer);
            }
        }
        return doorLockingUserListTransmittableElementsArray;
    }
}

