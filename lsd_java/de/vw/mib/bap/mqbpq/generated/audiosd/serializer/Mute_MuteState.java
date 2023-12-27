/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class Mute_MuteState
implements BAPEntity {
    private static final int RESERVED_BIT_2__7_BITSIZE;
    public boolean dabDvbSdarsMuting;
    public boolean muting;

    public Mute_MuteState() {
        this.internalReset();
        this.customInitialization();
    }

    public Mute_MuteState(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.dabDvbSdarsMuting = false;
        this.muting = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        Mute_MuteState mute_MuteState = (Mute_MuteState)bAPEntity;
        return this.dabDvbSdarsMuting == mute_MuteState.dabDvbSdarsMuting && this.muting == mute_MuteState.muting;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "Mute_MuteState:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.resetBits(6);
        bitStream.pushBoolean(this.dabDvbSdarsMuting);
        bitStream.pushBoolean(this.muting);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(6);
        this.dabDvbSdarsMuting = bitStream.popFrontBoolean();
        this.muting = bitStream.popFrontBoolean();
    }
}

