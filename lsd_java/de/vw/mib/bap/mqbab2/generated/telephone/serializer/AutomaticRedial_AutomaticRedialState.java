/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class AutomaticRedial_AutomaticRedialState
implements BAPEntity {
    private static final int RESERVED_BIT_1__7_BITSIZE;
    public boolean automaticRedialActive;

    public AutomaticRedial_AutomaticRedialState() {
        this.internalReset();
        this.customInitialization();
    }

    public AutomaticRedial_AutomaticRedialState(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.automaticRedialActive = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        AutomaticRedial_AutomaticRedialState automaticRedial_AutomaticRedialState = (AutomaticRedial_AutomaticRedialState)bAPEntity;
        return this.automaticRedialActive == automaticRedial_AutomaticRedialState.automaticRedialActive;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "AutomaticRedial_AutomaticRedialState:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.resetBits(7);
        bitStream.pushBoolean(this.automaticRedialActive);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(7);
        this.automaticRedialActive = bitStream.popFrontBoolean();
    }
}

