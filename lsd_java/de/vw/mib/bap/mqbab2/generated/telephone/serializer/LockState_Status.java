/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class LockState_Status
implements StatusProperty {
    public int lockState;
    public static final int LOCK_STATE_NO_LOCK;
    public static final int LOCK_STATE_REQUIRE_PIN;
    public static final int LOCK_STATE_REQUIRE_PIN2;
    public static final int LOCK_STATE_PI_NBLOCKED_REQUIRE_PUK;
    public static final int LOCK_STATE_PIN2BLOCKED_REQUIRE_PUK2;
    public static final int LOCK_STATE_PU_KBLOCKED;
    public static final int LOCK_STATE_PUK2BLOCKED;
    public static final int LOCK_STATE_KEYPAD_BLOCKED;
    public static final int LOCK_STATE_SIM_NOT_AVAILABLE_NOT_PLUGGED_IN;
    public static final int LOCK_STATE_PI_NINVALID;
    public static final int LOCK_STATE_PIN2INVALID;
    public static final int LOCK_STATE_SI_MNOT_FUNCTIONAL_NOT_READABLE_OR_NOT_FUNCTIONAL;
    public static final int LOCK_STATE_SI_MNOT_READY_CHECKING_SIM_CARD;
    public static final int LOCK_STATE_REQUIRE_LOCK_CODE_CDMA_TDMA;
    public static final int LOCK_STATE_REQUIRE_SECURITY_CODE;
    public static final int LOCK_STATE_SECURITY_CODE_BLOCKED;

    public LockState_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public LockState_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.lockState = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        LockState_Status lockState_Status = (LockState_Status)bAPEntity;
        return this.lockState == lockState_Status.lockState;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "LockState_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.lockState);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 19;
    }

    @Override
    public int getFunctionId() {
        return LockState_Status.functionId();
    }
}

