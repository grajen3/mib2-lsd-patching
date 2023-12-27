/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.generated.ecall.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class CallState_AdditionalStates
implements BAPEntity {
    private static final int RESERVED_BIT_1__3_BITSIZE;
    public boolean hangupCallAllowedDf3_1;

    public CallState_AdditionalStates() {
        this.internalReset();
        this.customInitialization();
    }

    public CallState_AdditionalStates(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.hangupCallAllowedDf3_1 = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        CallState_AdditionalStates callState_AdditionalStates = (CallState_AdditionalStates)bAPEntity;
        return this.hangupCallAllowedDf3_1 == callState_AdditionalStates.hangupCallAllowedDf3_1;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "CallState_Empty:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.resetBits(3);
        bitStream.pushBoolean(this.hangupCallAllowedDf3_1);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(3);
        this.hangupCallAllowedDf3_1 = bitStream.popFrontBoolean();
    }
}

