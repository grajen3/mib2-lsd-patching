/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carcomfort.impl;

import de.esolutions.fw.comm.dsi.carcomfort.impl.DoorLockingConfigurationSerializer;
import de.esolutions.fw.comm.dsi.global.impl.CarViewOptionSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carcomfort.DoorLockingConfiguration;
import org.dsi.ifc.carcomfort.DoorLockingViewOptions;
import org.dsi.ifc.global.CarViewOption;

public class DoorLockingViewOptionsSerializer {
    public static void putOptionalDoorLockingViewOptions(ISerializer iSerializer, DoorLockingViewOptions doorLockingViewOptions) {
        boolean bl = doorLockingViewOptions == null;
        iSerializer.putBool(bl);
        if (!bl) {
            CarViewOption carViewOption = doorLockingViewOptions.getMessage();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption);
            CarViewOption carViewOption2 = doorLockingViewOptions.getLockStatus();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption2);
            CarViewOption carViewOption3 = doorLockingViewOptions.getWindowStatus();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption3);
            CarViewOption carViewOption4 = doorLockingViewOptions.getUnlockingMode();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption4);
            CarViewOption carViewOption5 = doorLockingViewOptions.getAutoLock();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption5);
            CarViewOption carViewOption6 = doorLockingViewOptions.getClBootLock();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption6);
            CarViewOption carViewOption7 = doorLockingViewOptions.getMirrorProtection();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption7);
            CarViewOption carViewOption8 = doorLockingViewOptions.getLockingConfirmation();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption8);
            CarViewOption carViewOption9 = doorLockingViewOptions.getComfortOpen();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption9);
            CarViewOption carViewOption10 = doorLockingViewOptions.getRainClosing();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption10);
            CarViewOption carViewOption11 = doorLockingViewOptions.getRearBlind();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption11);
            CarViewOption carViewOption12 = doorLockingViewOptions.getTheftWarning();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption12);
            CarViewOption carViewOption13 = doorLockingViewOptions.getAutoUnlock();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption13);
            CarViewOption carViewOption14 = doorLockingViewOptions.getDoorLockingSetFactoryDefault();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption14);
            CarViewOption carViewOption15 = doorLockingViewOptions.getClBootOpen();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption15);
            CarViewOption carViewOption16 = doorLockingViewOptions.getBootOpen();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption16);
            CarViewOption carViewOption17 = doorLockingViewOptions.getBootClose();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption17);
            CarViewOption carViewOption18 = doorLockingViewOptions.getRemoteLockUnlock();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption18);
            CarViewOption carViewOption19 = doorLockingViewOptions.getRemoteBlinking();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption19);
            CarViewOption carViewOption20 = doorLockingViewOptions.getRemoteHorn();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption20);
            CarViewOption carViewOption21 = doorLockingViewOptions.getUserList();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption21);
            CarViewOption carViewOption22 = doorLockingViewOptions.getActiveUser();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption22);
            CarViewOption carViewOption23 = doorLockingViewOptions.getUserProfileOnOff();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption23);
            CarViewOption carViewOption24 = doorLockingViewOptions.getUserProfileControl();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption24);
            CarViewOption carViewOption25 = doorLockingViewOptions.getWindowAutoClose();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption25);
            CarViewOption carViewOption26 = doorLockingViewOptions.getBlindsControl();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption26);
            CarViewOption carViewOption27 = doorLockingViewOptions.getBlindsControlExtended();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption27);
            CarViewOption carViewOption28 = doorLockingViewOptions.getLeftSideBlindControl();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption28);
            CarViewOption carViewOption29 = doorLockingViewOptions.getRightSideBlindControl();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption29);
            CarViewOption carViewOption30 = doorLockingViewOptions.getPrompt();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption30);
            CarViewOption carViewOption31 = doorLockingViewOptions.getTurnIndRepeat();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption31);
            CarViewOption carViewOption32 = doorLockingViewOptions.getKeyless();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption32);
            DoorLockingConfiguration doorLockingConfiguration = doorLockingViewOptions.getConfiguration();
            DoorLockingConfigurationSerializer.putOptionalDoorLockingConfiguration(iSerializer, doorLockingConfiguration);
        }
    }

    public static void putOptionalDoorLockingViewOptionsVarArray(ISerializer iSerializer, DoorLockingViewOptions[] doorLockingViewOptionsArray) {
        boolean bl = doorLockingViewOptionsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(doorLockingViewOptionsArray.length);
            for (int i2 = 0; i2 < doorLockingViewOptionsArray.length; ++i2) {
                DoorLockingViewOptionsSerializer.putOptionalDoorLockingViewOptions(iSerializer, doorLockingViewOptionsArray[i2]);
            }
        }
    }

    public static DoorLockingViewOptions getOptionalDoorLockingViewOptions(IDeserializer iDeserializer) {
        DoorLockingViewOptions doorLockingViewOptions = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            DoorLockingConfiguration doorLockingConfiguration;
            CarViewOption carViewOption;
            CarViewOption carViewOption2;
            CarViewOption carViewOption3;
            CarViewOption carViewOption4;
            CarViewOption carViewOption5;
            CarViewOption carViewOption6;
            CarViewOption carViewOption7;
            CarViewOption carViewOption8;
            CarViewOption carViewOption9;
            CarViewOption carViewOption10;
            CarViewOption carViewOption11;
            CarViewOption carViewOption12;
            CarViewOption carViewOption13;
            CarViewOption carViewOption14;
            CarViewOption carViewOption15;
            CarViewOption carViewOption16;
            CarViewOption carViewOption17;
            CarViewOption carViewOption18;
            CarViewOption carViewOption19;
            CarViewOption carViewOption20;
            CarViewOption carViewOption21;
            CarViewOption carViewOption22;
            CarViewOption carViewOption23;
            CarViewOption carViewOption24;
            CarViewOption carViewOption25;
            CarViewOption carViewOption26;
            CarViewOption carViewOption27;
            CarViewOption carViewOption28;
            CarViewOption carViewOption29;
            CarViewOption carViewOption30;
            CarViewOption carViewOption31;
            CarViewOption carViewOption32;
            doorLockingViewOptions = new DoorLockingViewOptions();
            doorLockingViewOptions.message = carViewOption32 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            doorLockingViewOptions.lockStatus = carViewOption31 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            doorLockingViewOptions.windowStatus = carViewOption30 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            doorLockingViewOptions.unlockingMode = carViewOption29 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            doorLockingViewOptions.autoLock = carViewOption28 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            doorLockingViewOptions.clBootLock = carViewOption27 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            doorLockingViewOptions.mirrorProtection = carViewOption26 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            doorLockingViewOptions.lockingConfirmation = carViewOption25 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            doorLockingViewOptions.comfortOpen = carViewOption24 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            doorLockingViewOptions.rainClosing = carViewOption23 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            doorLockingViewOptions.rearBlind = carViewOption22 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            doorLockingViewOptions.theftWarning = carViewOption21 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            doorLockingViewOptions.autoUnlock = carViewOption20 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            doorLockingViewOptions.doorLockingSetFactoryDefault = carViewOption19 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            doorLockingViewOptions.clBootOpen = carViewOption18 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            doorLockingViewOptions.bootOpen = carViewOption17 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            doorLockingViewOptions.bootClose = carViewOption16 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            doorLockingViewOptions.remoteLockUnlock = carViewOption15 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            doorLockingViewOptions.remoteBlinking = carViewOption14 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            doorLockingViewOptions.remoteHorn = carViewOption13 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            doorLockingViewOptions.userList = carViewOption12 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            doorLockingViewOptions.activeUser = carViewOption11 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            doorLockingViewOptions.userProfileOnOff = carViewOption10 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            doorLockingViewOptions.userProfileControl = carViewOption9 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            doorLockingViewOptions.windowAutoClose = carViewOption8 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            doorLockingViewOptions.blindsControl = carViewOption7 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            doorLockingViewOptions.blindsControlExtended = carViewOption6 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            doorLockingViewOptions.leftSideBlindControl = carViewOption5 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            doorLockingViewOptions.rightSideBlindControl = carViewOption4 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            doorLockingViewOptions.prompt = carViewOption3 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            doorLockingViewOptions.turnIndRepeat = carViewOption2 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            doorLockingViewOptions.keyless = carViewOption = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            doorLockingViewOptions.configuration = doorLockingConfiguration = DoorLockingConfigurationSerializer.getOptionalDoorLockingConfiguration(iDeserializer);
        }
        return doorLockingViewOptions;
    }

    public static DoorLockingViewOptions[] getOptionalDoorLockingViewOptionsVarArray(IDeserializer iDeserializer) {
        DoorLockingViewOptions[] doorLockingViewOptionsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            doorLockingViewOptionsArray = new DoorLockingViewOptions[n];
            for (int i2 = 0; i2 < n; ++i2) {
                doorLockingViewOptionsArray[i2] = DoorLockingViewOptionsSerializer.getOptionalDoorLockingViewOptions(iDeserializer);
            }
        }
        return doorLockingViewOptionsArray;
    }
}

