/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.generated.eni.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class CurrentOnlineUpdateState_CurrentPreconditionStates
implements BAPEntity {
    private static final int RESERVED_BIT_1__7_BITSIZE;
    public boolean standstill;

    public CurrentOnlineUpdateState_CurrentPreconditionStates() {
        this.internalReset();
        this.customInitialization();
    }

    public CurrentOnlineUpdateState_CurrentPreconditionStates(BitStream bitStream) {
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
        CurrentOnlineUpdateState_CurrentPreconditionStates currentOnlineUpdateState_CurrentPreconditionStates = (CurrentOnlineUpdateState_CurrentPreconditionStates)bAPEntity;
        return this.standstill == currentOnlineUpdateState_CurrentPreconditionStates.standstill;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "CurrentOnlineUpdateState_Empty:";
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

