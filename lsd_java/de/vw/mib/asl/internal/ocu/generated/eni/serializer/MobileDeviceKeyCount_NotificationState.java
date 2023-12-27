/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.generated.eni.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class MobileDeviceKeyCount_NotificationState
implements BAPEntity {
    private static final int RESERVED_BIT_1__3_BITSIZE;
    public boolean vtanAvailableInBackendDf3_6;

    public MobileDeviceKeyCount_NotificationState() {
        this.internalReset();
        this.customInitialization();
    }

    public MobileDeviceKeyCount_NotificationState(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.vtanAvailableInBackendDf3_6 = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        MobileDeviceKeyCount_NotificationState mobileDeviceKeyCount_NotificationState = (MobileDeviceKeyCount_NotificationState)bAPEntity;
        return this.vtanAvailableInBackendDf3_6 == mobileDeviceKeyCount_NotificationState.vtanAvailableInBackendDf3_6;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "MobileDeviceKeyCount_Empty:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.resetBits(3);
        bitStream.pushBoolean(this.vtanAvailableInBackendDf3_6);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(3);
        this.vtanAvailableInBackendDf3_6 = bitStream.popFrontBoolean();
    }
}

