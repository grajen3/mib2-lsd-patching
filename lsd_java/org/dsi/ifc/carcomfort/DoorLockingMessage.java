/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carcomfort;

public class DoorLockingMessage {
    public boolean remoteKeyBatteryLow;
    public boolean secondKeyInVehicle;
    public boolean keyDetectedInVehicle;
    public boolean keyInBoot;
    public boolean immobilizerActive;
    public boolean keyNotFound;
    public boolean removeKey;
    public boolean depressBrakePedal;
    public boolean depressClutch;
    public boolean steeringLockDefective;
    public boolean steeringNotUnlocked;
    public boolean steeringLockWorkshop;
    public boolean moveSteeringWheel;
    public boolean moveSelectorToPositionN;
    public boolean moveSelectorToPositionP;
    public boolean startEngine;
    public boolean immobilizerAdjustmentActive;
    public boolean immobilizerAdjustmentFault;
    public boolean immobilizerEndOfLineFault;
    public boolean immobilizerAdjustmentOk;

    public DoorLockingMessage() {
        this.remoteKeyBatteryLow = false;
        this.secondKeyInVehicle = false;
        this.keyDetectedInVehicle = false;
        this.keyInBoot = false;
        this.immobilizerActive = false;
        this.keyNotFound = false;
        this.removeKey = false;
        this.depressBrakePedal = false;
        this.depressClutch = false;
        this.steeringLockDefective = false;
        this.steeringNotUnlocked = false;
        this.steeringLockWorkshop = false;
        this.moveSteeringWheel = false;
        this.moveSelectorToPositionN = false;
        this.moveSelectorToPositionP = false;
        this.startEngine = false;
        this.immobilizerAdjustmentActive = false;
        this.immobilizerAdjustmentFault = false;
        this.immobilizerEndOfLineFault = false;
        this.immobilizerAdjustmentOk = false;
    }

    public DoorLockingMessage(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, boolean bl8, boolean bl9, boolean bl10, boolean bl11, boolean bl12, boolean bl13, boolean bl14, boolean bl15, boolean bl16, boolean bl17, boolean bl18, boolean bl19, boolean bl20) {
        this.remoteKeyBatteryLow = bl;
        this.secondKeyInVehicle = bl2;
        this.keyDetectedInVehicle = bl3;
        this.keyInBoot = bl4;
        this.immobilizerActive = bl5;
        this.keyNotFound = bl6;
        this.removeKey = bl7;
        this.depressBrakePedal = bl8;
        this.depressClutch = bl9;
        this.steeringLockDefective = bl10;
        this.steeringNotUnlocked = bl11;
        this.steeringLockWorkshop = bl12;
        this.moveSteeringWheel = bl13;
        this.moveSelectorToPositionN = bl14;
        this.moveSelectorToPositionP = bl15;
        this.startEngine = bl16;
        this.immobilizerAdjustmentActive = bl17;
        this.immobilizerAdjustmentFault = bl18;
        this.immobilizerEndOfLineFault = bl19;
        this.immobilizerAdjustmentOk = bl20;
    }

    public boolean isRemoteKeyBatteryLow() {
        return this.remoteKeyBatteryLow;
    }

    public boolean isSecondKeyInVehicle() {
        return this.secondKeyInVehicle;
    }

    public boolean isKeyDetectedInVehicle() {
        return this.keyDetectedInVehicle;
    }

    public boolean isKeyInBoot() {
        return this.keyInBoot;
    }

    public boolean isImmobilizerActive() {
        return this.immobilizerActive;
    }

    public boolean isKeyNotFound() {
        return this.keyNotFound;
    }

    public boolean isRemoveKey() {
        return this.removeKey;
    }

    public boolean isDepressBrakePedal() {
        return this.depressBrakePedal;
    }

    public boolean isDepressClutch() {
        return this.depressClutch;
    }

    public boolean isSteeringLockDefective() {
        return this.steeringLockDefective;
    }

    public boolean isSteeringNotUnlocked() {
        return this.steeringNotUnlocked;
    }

    public boolean isSteeringLockWorkshop() {
        return this.steeringLockWorkshop;
    }

    public boolean isMoveSteeringWheel() {
        return this.moveSteeringWheel;
    }

    public boolean isMoveSelectorToPositionN() {
        return this.moveSelectorToPositionN;
    }

    public boolean isMoveSelectorToPositionP() {
        return this.moveSelectorToPositionP;
    }

    public boolean isStartEngine() {
        return this.startEngine;
    }

    public boolean isImmobilizerAdjustmentActive() {
        return this.immobilizerAdjustmentActive;
    }

    public boolean isImmobilizerAdjustmentFault() {
        return this.immobilizerAdjustmentFault;
    }

    public boolean isImmobilizerEndOfLineFault() {
        return this.immobilizerEndOfLineFault;
    }

    public boolean isImmobilizerAdjustmentOk() {
        return this.immobilizerAdjustmentOk;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1150);
        stringBuffer.append("DoorLockingMessage");
        stringBuffer.append('(');
        stringBuffer.append("remoteKeyBatteryLow");
        stringBuffer.append('=');
        stringBuffer.append(this.remoteKeyBatteryLow);
        stringBuffer.append(',');
        stringBuffer.append("secondKeyInVehicle");
        stringBuffer.append('=');
        stringBuffer.append(this.secondKeyInVehicle);
        stringBuffer.append(',');
        stringBuffer.append("keyDetectedInVehicle");
        stringBuffer.append('=');
        stringBuffer.append(this.keyDetectedInVehicle);
        stringBuffer.append(',');
        stringBuffer.append("keyInBoot");
        stringBuffer.append('=');
        stringBuffer.append(this.keyInBoot);
        stringBuffer.append(',');
        stringBuffer.append("immobilizerActive");
        stringBuffer.append('=');
        stringBuffer.append(this.immobilizerActive);
        stringBuffer.append(',');
        stringBuffer.append("keyNotFound");
        stringBuffer.append('=');
        stringBuffer.append(this.keyNotFound);
        stringBuffer.append(',');
        stringBuffer.append("removeKey");
        stringBuffer.append('=');
        stringBuffer.append(this.removeKey);
        stringBuffer.append(',');
        stringBuffer.append("depressBrakePedal");
        stringBuffer.append('=');
        stringBuffer.append(this.depressBrakePedal);
        stringBuffer.append(',');
        stringBuffer.append("depressClutch");
        stringBuffer.append('=');
        stringBuffer.append(this.depressClutch);
        stringBuffer.append(',');
        stringBuffer.append("steeringLockDefective");
        stringBuffer.append('=');
        stringBuffer.append(this.steeringLockDefective);
        stringBuffer.append(',');
        stringBuffer.append("steeringNotUnlocked");
        stringBuffer.append('=');
        stringBuffer.append(this.steeringNotUnlocked);
        stringBuffer.append(',');
        stringBuffer.append("steeringLockWorkshop");
        stringBuffer.append('=');
        stringBuffer.append(this.steeringLockWorkshop);
        stringBuffer.append(',');
        stringBuffer.append("moveSteeringWheel");
        stringBuffer.append('=');
        stringBuffer.append(this.moveSteeringWheel);
        stringBuffer.append(',');
        stringBuffer.append("moveSelectorToPositionN");
        stringBuffer.append('=');
        stringBuffer.append(this.moveSelectorToPositionN);
        stringBuffer.append(',');
        stringBuffer.append("moveSelectorToPositionP");
        stringBuffer.append('=');
        stringBuffer.append(this.moveSelectorToPositionP);
        stringBuffer.append(',');
        stringBuffer.append("startEngine");
        stringBuffer.append('=');
        stringBuffer.append(this.startEngine);
        stringBuffer.append(',');
        stringBuffer.append("immobilizerAdjustmentActive");
        stringBuffer.append('=');
        stringBuffer.append(this.immobilizerAdjustmentActive);
        stringBuffer.append(',');
        stringBuffer.append("immobilizerAdjustmentFault");
        stringBuffer.append('=');
        stringBuffer.append(this.immobilizerAdjustmentFault);
        stringBuffer.append(',');
        stringBuffer.append("immobilizerEndOfLineFault");
        stringBuffer.append('=');
        stringBuffer.append(this.immobilizerEndOfLineFault);
        stringBuffer.append(',');
        stringBuffer.append("immobilizerAdjustmentOk");
        stringBuffer.append('=');
        stringBuffer.append(this.immobilizerAdjustmentOk);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

