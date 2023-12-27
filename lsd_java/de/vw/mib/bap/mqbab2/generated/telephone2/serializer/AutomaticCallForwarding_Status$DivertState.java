/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.telephone2.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class AutomaticCallForwarding_Status$DivertState
implements BAPEntity {
    public boolean forwardingStateValid;
    public boolean forwardingIfBusy;
    public boolean forwardingIfNotAnswered;
    public boolean forwardingIfOutOfReach;
    public boolean forwardingIfNotAvailable;
    public boolean forwardingAllVoiceCalls;
    public boolean forwardingAllFaxCalls;
    public boolean fowardingAllDataCalls;
    private static final int RESERVED_BIT_8__15_BITSIZE;

    public AutomaticCallForwarding_Status$DivertState() {
        this.internalReset();
        this.customInitialization();
    }

    public AutomaticCallForwarding_Status$DivertState(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.forwardingStateValid = false;
        this.forwardingIfBusy = false;
        this.forwardingIfNotAnswered = false;
        this.forwardingIfOutOfReach = false;
        this.forwardingIfNotAvailable = false;
        this.forwardingAllVoiceCalls = false;
        this.forwardingAllFaxCalls = false;
        this.fowardingAllDataCalls = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        AutomaticCallForwarding_Status$DivertState automaticCallForwarding_Status$DivertState = (AutomaticCallForwarding_Status$DivertState)bAPEntity;
        return this.forwardingStateValid == automaticCallForwarding_Status$DivertState.forwardingStateValid && this.forwardingIfBusy == automaticCallForwarding_Status$DivertState.forwardingIfBusy && this.forwardingIfNotAnswered == automaticCallForwarding_Status$DivertState.forwardingIfNotAnswered && this.forwardingIfOutOfReach == automaticCallForwarding_Status$DivertState.forwardingIfOutOfReach && this.forwardingIfNotAvailable == automaticCallForwarding_Status$DivertState.forwardingIfNotAvailable && this.forwardingAllVoiceCalls == automaticCallForwarding_Status$DivertState.forwardingAllVoiceCalls && this.forwardingAllFaxCalls == automaticCallForwarding_Status$DivertState.forwardingAllFaxCalls && this.fowardingAllDataCalls == automaticCallForwarding_Status$DivertState.fowardingAllDataCalls;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "DivertState:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushBoolean(this.forwardingStateValid);
        bitStream.pushBoolean(this.forwardingIfBusy);
        bitStream.pushBoolean(this.forwardingIfNotAnswered);
        bitStream.pushBoolean(this.forwardingIfOutOfReach);
        bitStream.pushBoolean(this.forwardingIfNotAvailable);
        bitStream.pushBoolean(this.forwardingAllVoiceCalls);
        bitStream.pushBoolean(this.forwardingAllFaxCalls);
        bitStream.pushBoolean(this.fowardingAllDataCalls);
        bitStream.resetBits(8);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }
}

