/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.generated.eni.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class OnlineUpdateState_Deprecated_CurrentStates0
implements BAPEntity {
    private static final int RESERVED_BIT_1__7_BITSIZE;
    public boolean standstill;

    public OnlineUpdateState_Deprecated_CurrentStates0() {
        this.internalReset();
        this.customInitialization();
    }

    public OnlineUpdateState_Deprecated_CurrentStates0(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.standstill = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        OnlineUpdateState_Deprecated_CurrentStates0 onlineUpdateState_Deprecated_CurrentStates0 = (OnlineUpdateState_Deprecated_CurrentStates0)bAPEntity;
        return this.standstill == onlineUpdateState_Deprecated_CurrentStates0.standstill;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "OnlineUpdateState_Deprecated_Empty:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.resetBits(7);
        bitStream.pushBoolean(this.standstill);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(7);
        this.standstill = bitStream.popFrontBoolean();
    }
}

