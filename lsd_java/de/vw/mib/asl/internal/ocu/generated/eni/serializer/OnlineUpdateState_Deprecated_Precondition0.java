/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.generated.eni.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class OnlineUpdateState_Deprecated_Precondition0
implements BAPEntity {
    private static final int RESERVED_BIT_1__7_BITSIZE;
    public boolean standstillRequired;

    public OnlineUpdateState_Deprecated_Precondition0() {
        this.internalReset();
        this.customInitialization();
    }

    public OnlineUpdateState_Deprecated_Precondition0(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.standstillRequired = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        OnlineUpdateState_Deprecated_Precondition0 onlineUpdateState_Deprecated_Precondition0 = (OnlineUpdateState_Deprecated_Precondition0)bAPEntity;
        return this.standstillRequired == onlineUpdateState_Deprecated_Precondition0.standstillRequired;
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
        bitStream.pushBoolean(this.standstillRequired);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(7);
        this.standstillRequired = bitStream.popFrontBoolean();
    }
}

