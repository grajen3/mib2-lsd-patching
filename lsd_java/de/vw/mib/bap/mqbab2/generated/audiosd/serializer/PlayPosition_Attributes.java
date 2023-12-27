/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class PlayPosition_Attributes
implements BAPEntity {
    private static final int RESERVED_BIT_1__7_BITSIZE;
    public boolean variableBitRateActive;

    public PlayPosition_Attributes() {
        this.internalReset();
        this.customInitialization();
    }

    public PlayPosition_Attributes(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.variableBitRateActive = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        PlayPosition_Attributes playPosition_Attributes = (PlayPosition_Attributes)bAPEntity;
        return this.variableBitRateActive == playPosition_Attributes.variableBitRateActive;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "PlayPosition_Empty:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.resetBits(7);
        bitStream.pushBoolean(this.variableBitRateActive);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(7);
        this.variableBitRateActive = bitStream.popFrontBoolean();
    }
}

