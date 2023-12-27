/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class MobileBatteryLevel_Status$WarningLevel
implements BAPEntity {
    private static final int RESERVED_BIT_4__7_BITSIZE;
    public boolean handset2ChargeLevelCritical;
    public boolean handset1ChargeLevelCritical;
    public boolean mobile2ChargeLevelCritical;
    public boolean mobile1ChargeLevelCritical;

    public MobileBatteryLevel_Status$WarningLevel() {
        this.internalReset();
        this.customInitialization();
    }

    public MobileBatteryLevel_Status$WarningLevel(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.handset2ChargeLevelCritical = false;
        this.handset1ChargeLevelCritical = false;
        this.mobile2ChargeLevelCritical = false;
        this.mobile1ChargeLevelCritical = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        MobileBatteryLevel_Status$WarningLevel mobileBatteryLevel_Status$WarningLevel = (MobileBatteryLevel_Status$WarningLevel)bAPEntity;
        return this.handset2ChargeLevelCritical == mobileBatteryLevel_Status$WarningLevel.handset2ChargeLevelCritical && this.handset1ChargeLevelCritical == mobileBatteryLevel_Status$WarningLevel.handset1ChargeLevelCritical && this.mobile2ChargeLevelCritical == mobileBatteryLevel_Status$WarningLevel.mobile2ChargeLevelCritical && this.mobile1ChargeLevelCritical == mobileBatteryLevel_Status$WarningLevel.mobile1ChargeLevelCritical;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "WarningLevel:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.resetBits(4);
        bitStream.pushBoolean(this.handset2ChargeLevelCritical);
        bitStream.pushBoolean(this.handset1ChargeLevelCritical);
        bitStream.pushBoolean(this.mobile2ChargeLevelCritical);
        bitStream.pushBoolean(this.mobile1ChargeLevelCritical);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }
}

