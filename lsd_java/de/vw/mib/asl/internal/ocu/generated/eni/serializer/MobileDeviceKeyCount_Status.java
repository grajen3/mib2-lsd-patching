/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.generated.eni.serializer;

import de.vw.mib.asl.internal.ocu.generated.eni.serializer.MobileDeviceKeyCount_NotificationState;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class MobileDeviceKeyCount_Status
implements StatusProperty {
    public int keyCountBackend;
    public static final int KEY_COUNT_BACKEND_MIN;
    public MobileDeviceKeyCount_NotificationState notificationState = new MobileDeviceKeyCount_NotificationState();
    public int keyCountBackendState;
    public static final int KEY_COUNT_BACKEND_STATE_DELETION_IN_PROGRESS;
    public static final int KEY_COUNT_BACKEND_STATE_NORMAL_OPERATION;
    public static final int KEY_COUNT_BACKEND_STATE_INIT_UNKNOWN;
    private static final int KEY_COUNT_BACKEND_STATE_BITSIZE;
    public int extension1;
    public static final int EXTENSION1_MIN;
    public int extension2;
    public static final int EXTENSION2_MIN;
    public int extension3;
    public static final int EXTENSION3_MIN;
    public int extension4;
    public static final int EXTENSION4_MIN;

    public MobileDeviceKeyCount_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public MobileDeviceKeyCount_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.keyCountBackend = 0;
        this.keyCountBackendState = 0;
        this.extension1 = 0;
        this.extension2 = 0;
        this.extension3 = 0;
        this.extension4 = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.notificationState.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        MobileDeviceKeyCount_Status mobileDeviceKeyCount_Status = (MobileDeviceKeyCount_Status)bAPEntity;
        return this.keyCountBackend == mobileDeviceKeyCount_Status.keyCountBackend && this.notificationState.equalTo(mobileDeviceKeyCount_Status.notificationState) && this.keyCountBackendState == mobileDeviceKeyCount_Status.keyCountBackendState && this.extension1 == mobileDeviceKeyCount_Status.extension1 && this.extension2 == mobileDeviceKeyCount_Status.extension2 && this.extension3 == mobileDeviceKeyCount_Status.extension3 && this.extension4 == mobileDeviceKeyCount_Status.extension4;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "MobileDeviceKeyCount_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.keyCountBackend);
        this.notificationState.serialize(bitStream);
        bitStream.pushBits(4, this.keyCountBackendState);
        bitStream.pushByte((byte)this.extension1);
        bitStream.pushByte((byte)this.extension2);
        bitStream.pushByte((byte)this.extension3);
        bitStream.pushByte((byte)this.extension4);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.keyCountBackend = bitStream.popFrontByte();
        this.notificationState.deserialize(bitStream);
        this.keyCountBackendState = bitStream.popFrontBits(4);
        this.extension1 = bitStream.popFrontByte();
        this.extension2 = bitStream.popFrontByte();
        this.extension3 = bitStream.popFrontByte();
        this.extension4 = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 26;
    }

    @Override
    public int getFunctionId() {
        return MobileDeviceKeyCount_Status.functionId();
    }
}

