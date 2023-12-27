/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class Mute_MuteState
implements BAPEntity {
    public boolean onlineRadioMutingLowSignalDf4_1;
    public boolean ibocMutingLowSignal;
    public boolean mutingDueToActivePhoneCall;
    public boolean ibocIsNotInSyncDigitalSignalCannotBeDecoded;
    public boolean sdarsMutingLowSignal;
    public boolean dvbTvMutingLowSignal;
    public boolean dabMutingLowSignal;
    public boolean _entertainmentMuting;

    public Mute_MuteState() {
        this.internalReset();
        this.customInitialization();
    }

    public Mute_MuteState(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.onlineRadioMutingLowSignalDf4_1 = false;
        this.ibocMutingLowSignal = false;
        this.mutingDueToActivePhoneCall = false;
        this.ibocIsNotInSyncDigitalSignalCannotBeDecoded = false;
        this.sdarsMutingLowSignal = false;
        this.dvbTvMutingLowSignal = false;
        this.dabMutingLowSignal = false;
        this._entertainmentMuting = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        Mute_MuteState mute_MuteState = (Mute_MuteState)bAPEntity;
        return this.onlineRadioMutingLowSignalDf4_1 == mute_MuteState.onlineRadioMutingLowSignalDf4_1 && this.ibocMutingLowSignal == mute_MuteState.ibocMutingLowSignal && this.mutingDueToActivePhoneCall == mute_MuteState.mutingDueToActivePhoneCall && this.ibocIsNotInSyncDigitalSignalCannotBeDecoded == mute_MuteState.ibocIsNotInSyncDigitalSignalCannotBeDecoded && this.sdarsMutingLowSignal == mute_MuteState.sdarsMutingLowSignal && this.dvbTvMutingLowSignal == mute_MuteState.dvbTvMutingLowSignal && this.dabMutingLowSignal == mute_MuteState.dabMutingLowSignal && this._entertainmentMuting == mute_MuteState._entertainmentMuting;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "Mute_Empty:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushBoolean(this.onlineRadioMutingLowSignalDf4_1);
        bitStream.pushBoolean(this.ibocMutingLowSignal);
        bitStream.pushBoolean(this.mutingDueToActivePhoneCall);
        bitStream.pushBoolean(this.ibocIsNotInSyncDigitalSignalCannotBeDecoded);
        bitStream.pushBoolean(this.sdarsMutingLowSignal);
        bitStream.pushBoolean(this.dvbTvMutingLowSignal);
        bitStream.pushBoolean(this.dabMutingLowSignal);
        bitStream.pushBoolean(this._entertainmentMuting);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.onlineRadioMutingLowSignalDf4_1 = bitStream.popFrontBoolean();
        this.ibocMutingLowSignal = bitStream.popFrontBoolean();
        this.mutingDueToActivePhoneCall = bitStream.popFrontBoolean();
        this.ibocIsNotInSyncDigitalSignalCannotBeDecoded = bitStream.popFrontBoolean();
        this.sdarsMutingLowSignal = bitStream.popFrontBoolean();
        this.dvbTvMutingLowSignal = bitStream.popFrontBoolean();
        this.dabMutingLowSignal = bitStream.popFrontBoolean();
        this._entertainmentMuting = bitStream.popFrontBoolean();
    }
}

