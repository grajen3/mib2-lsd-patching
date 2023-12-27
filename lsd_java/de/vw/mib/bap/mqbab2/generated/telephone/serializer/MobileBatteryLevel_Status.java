/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.MobileBatteryLevel_Status$WarningLevel;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class MobileBatteryLevel_Status
implements StatusProperty {
    public int chargeLevel_Mobile1;
    public int chargeLevel_Mobile2;
    public int chargeLevel_Handset1;
    public int chargeLevel_Handset2;
    public final MobileBatteryLevel_Status$WarningLevel warningLevel = new MobileBatteryLevel_Status$WarningLevel();

    public MobileBatteryLevel_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public MobileBatteryLevel_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.chargeLevel_Mobile1 = 0;
        this.chargeLevel_Mobile2 = 0;
        this.chargeLevel_Handset1 = 0;
        this.chargeLevel_Handset2 = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.warningLevel.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        MobileBatteryLevel_Status mobileBatteryLevel_Status = (MobileBatteryLevel_Status)bAPEntity;
        return this.chargeLevel_Mobile1 == mobileBatteryLevel_Status.chargeLevel_Mobile1 && this.chargeLevel_Mobile2 == mobileBatteryLevel_Status.chargeLevel_Mobile2 && this.chargeLevel_Handset1 == mobileBatteryLevel_Status.chargeLevel_Handset1 && this.chargeLevel_Handset2 == mobileBatteryLevel_Status.chargeLevel_Handset2 && this.warningLevel.equalTo(mobileBatteryLevel_Status.warningLevel);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "MobileBatteryLevel_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.chargeLevel_Mobile1);
        bitStream.pushByte((byte)this.chargeLevel_Mobile2);
        bitStream.pushByte((byte)this.chargeLevel_Handset1);
        bitStream.pushByte((byte)this.chargeLevel_Handset2);
        this.warningLevel.serialize(bitStream);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 43;
    }

    @Override
    public int getFunctionId() {
        return MobileBatteryLevel_Status.functionId();
    }
}

