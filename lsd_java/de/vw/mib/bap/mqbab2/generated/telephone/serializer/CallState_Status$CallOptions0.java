/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class CallState_Status$CallOptions0
implements BAPEntity {
    public boolean ccsplit;
    public boolean ccjoin;
    public boolean mpswap;
    public boolean resumeCall;
    public boolean callHold;
    public boolean mpreleaseActiceCallAcceptWaitingCall;
    public boolean mpholdAcceptWaiting;
    public boolean acceptCall;

    public CallState_Status$CallOptions0() {
        this.internalReset();
        this.customInitialization();
    }

    public CallState_Status$CallOptions0(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.ccsplit = false;
        this.ccjoin = false;
        this.mpswap = false;
        this.resumeCall = false;
        this.callHold = false;
        this.mpreleaseActiceCallAcceptWaitingCall = false;
        this.mpholdAcceptWaiting = false;
        this.acceptCall = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        CallState_Status$CallOptions0 callState_Status$CallOptions0 = (CallState_Status$CallOptions0)bAPEntity;
        return this.ccsplit == callState_Status$CallOptions0.ccsplit && this.ccjoin == callState_Status$CallOptions0.ccjoin && this.mpswap == callState_Status$CallOptions0.mpswap && this.resumeCall == callState_Status$CallOptions0.resumeCall && this.callHold == callState_Status$CallOptions0.callHold && this.mpreleaseActiceCallAcceptWaitingCall == callState_Status$CallOptions0.mpreleaseActiceCallAcceptWaitingCall && this.mpholdAcceptWaiting == callState_Status$CallOptions0.mpholdAcceptWaiting && this.acceptCall == callState_Status$CallOptions0.acceptCall;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "CallOptions0:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushBoolean(this.ccsplit);
        bitStream.pushBoolean(this.ccjoin);
        bitStream.pushBoolean(this.mpswap);
        bitStream.pushBoolean(this.resumeCall);
        bitStream.pushBoolean(this.callHold);
        bitStream.pushBoolean(this.mpreleaseActiceCallAcceptWaitingCall);
        bitStream.pushBoolean(this.mpholdAcceptWaiting);
        bitStream.pushBoolean(this.acceptCall);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }
}

