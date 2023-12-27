/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carcomfort.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carcomfort.DoorLockingMessage;

public class DoorLockingMessageSerializer {
    public static void putOptionalDoorLockingMessage(ISerializer iSerializer, DoorLockingMessage doorLockingMessage) {
        boolean bl = doorLockingMessage == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = doorLockingMessage.isRemoteKeyBatteryLow();
            iSerializer.putBool(bl2);
            boolean bl3 = doorLockingMessage.isSecondKeyInVehicle();
            iSerializer.putBool(bl3);
            boolean bl4 = doorLockingMessage.isKeyDetectedInVehicle();
            iSerializer.putBool(bl4);
            boolean bl5 = doorLockingMessage.isKeyInBoot();
            iSerializer.putBool(bl5);
            boolean bl6 = doorLockingMessage.isImmobilizerActive();
            iSerializer.putBool(bl6);
            boolean bl7 = doorLockingMessage.isKeyNotFound();
            iSerializer.putBool(bl7);
            boolean bl8 = doorLockingMessage.isRemoveKey();
            iSerializer.putBool(bl8);
            boolean bl9 = doorLockingMessage.isDepressBrakePedal();
            iSerializer.putBool(bl9);
            boolean bl10 = doorLockingMessage.isDepressClutch();
            iSerializer.putBool(bl10);
            boolean bl11 = doorLockingMessage.isSteeringLockDefective();
            iSerializer.putBool(bl11);
            boolean bl12 = doorLockingMessage.isSteeringNotUnlocked();
            iSerializer.putBool(bl12);
            boolean bl13 = doorLockingMessage.isSteeringLockWorkshop();
            iSerializer.putBool(bl13);
            boolean bl14 = doorLockingMessage.isMoveSteeringWheel();
            iSerializer.putBool(bl14);
            boolean bl15 = doorLockingMessage.isMoveSelectorToPositionN();
            iSerializer.putBool(bl15);
            boolean bl16 = doorLockingMessage.isMoveSelectorToPositionP();
            iSerializer.putBool(bl16);
            boolean bl17 = doorLockingMessage.isStartEngine();
            iSerializer.putBool(bl17);
            boolean bl18 = doorLockingMessage.isImmobilizerAdjustmentActive();
            iSerializer.putBool(bl18);
            boolean bl19 = doorLockingMessage.isImmobilizerAdjustmentFault();
            iSerializer.putBool(bl19);
            boolean bl20 = doorLockingMessage.isImmobilizerEndOfLineFault();
            iSerializer.putBool(bl20);
            boolean bl21 = doorLockingMessage.isImmobilizerAdjustmentOk();
            iSerializer.putBool(bl21);
        }
    }

    public static void putOptionalDoorLockingMessageVarArray(ISerializer iSerializer, DoorLockingMessage[] doorLockingMessageArray) {
        boolean bl = doorLockingMessageArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(doorLockingMessageArray.length);
            for (int i2 = 0; i2 < doorLockingMessageArray.length; ++i2) {
                DoorLockingMessageSerializer.putOptionalDoorLockingMessage(iSerializer, doorLockingMessageArray[i2]);
            }
        }
    }

    public static DoorLockingMessage getOptionalDoorLockingMessage(IDeserializer iDeserializer) {
        DoorLockingMessage doorLockingMessage = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            boolean bl6;
            boolean bl7;
            boolean bl8;
            boolean bl9;
            boolean bl10;
            boolean bl11;
            boolean bl12;
            boolean bl13;
            boolean bl14;
            boolean bl15;
            boolean bl16;
            boolean bl17;
            boolean bl18;
            boolean bl19;
            boolean bl20;
            boolean bl21;
            doorLockingMessage = new DoorLockingMessage();
            doorLockingMessage.remoteKeyBatteryLow = bl21 = iDeserializer.getBool();
            doorLockingMessage.secondKeyInVehicle = bl20 = iDeserializer.getBool();
            doorLockingMessage.keyDetectedInVehicle = bl19 = iDeserializer.getBool();
            doorLockingMessage.keyInBoot = bl18 = iDeserializer.getBool();
            doorLockingMessage.immobilizerActive = bl17 = iDeserializer.getBool();
            doorLockingMessage.keyNotFound = bl16 = iDeserializer.getBool();
            doorLockingMessage.removeKey = bl15 = iDeserializer.getBool();
            doorLockingMessage.depressBrakePedal = bl14 = iDeserializer.getBool();
            doorLockingMessage.depressClutch = bl13 = iDeserializer.getBool();
            doorLockingMessage.steeringLockDefective = bl12 = iDeserializer.getBool();
            doorLockingMessage.steeringNotUnlocked = bl11 = iDeserializer.getBool();
            doorLockingMessage.steeringLockWorkshop = bl10 = iDeserializer.getBool();
            doorLockingMessage.moveSteeringWheel = bl9 = iDeserializer.getBool();
            doorLockingMessage.moveSelectorToPositionN = bl8 = iDeserializer.getBool();
            doorLockingMessage.moveSelectorToPositionP = bl7 = iDeserializer.getBool();
            doorLockingMessage.startEngine = bl6 = iDeserializer.getBool();
            doorLockingMessage.immobilizerAdjustmentActive = bl5 = iDeserializer.getBool();
            doorLockingMessage.immobilizerAdjustmentFault = bl4 = iDeserializer.getBool();
            doorLockingMessage.immobilizerEndOfLineFault = bl3 = iDeserializer.getBool();
            doorLockingMessage.immobilizerAdjustmentOk = bl2 = iDeserializer.getBool();
        }
        return doorLockingMessage;
    }

    public static DoorLockingMessage[] getOptionalDoorLockingMessageVarArray(IDeserializer iDeserializer) {
        DoorLockingMessage[] doorLockingMessageArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            doorLockingMessageArray = new DoorLockingMessage[n];
            for (int i2 = 0; i2 < n; ++i2) {
                doorLockingMessageArray[i2] = DoorLockingMessageSerializer.getOptionalDoorLockingMessage(iDeserializer);
            }
        }
        return doorLockingMessageArray;
    }
}

