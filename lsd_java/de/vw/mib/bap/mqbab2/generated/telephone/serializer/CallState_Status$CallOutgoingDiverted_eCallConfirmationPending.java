/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class CallState_Status$CallOutgoingDiverted_eCallConfirmationPending
implements BAPEntity {
    public boolean eCallConfirmationPending;
    public boolean call6Diverted;
    public boolean call5Diverted;
    public boolean call4Diverted;
    public boolean call3Diverted;
    public boolean call2Diverted;
    public boolean call1Diverted;
    public boolean call0Diverted;

    public CallState_Status$CallOutgoingDiverted_eCallConfirmationPending() {
        this.internalReset();
        this.customInitialization();
    }

    public CallState_Status$CallOutgoingDiverted_eCallConfirmationPending(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.eCallConfirmationPending = false;
        this.call6Diverted = false;
        this.call5Diverted = false;
        this.call4Diverted = false;
        this.call3Diverted = false;
        this.call2Diverted = false;
        this.call1Diverted = false;
        this.call0Diverted = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        CallState_Status$CallOutgoingDiverted_eCallConfirmationPending callState_Status$CallOutgoingDiverted_eCallConfirmationPending = (CallState_Status$CallOutgoingDiverted_eCallConfirmationPending)bAPEntity;
        return this.eCallConfirmationPending == callState_Status$CallOutgoingDiverted_eCallConfirmationPending.eCallConfirmationPending && this.call6Diverted == callState_Status$CallOutgoingDiverted_eCallConfirmationPending.call6Diverted && this.call5Diverted == callState_Status$CallOutgoingDiverted_eCallConfirmationPending.call5Diverted && this.call4Diverted == callState_Status$CallOutgoingDiverted_eCallConfirmationPending.call4Diverted && this.call3Diverted == callState_Status$CallOutgoingDiverted_eCallConfirmationPending.call3Diverted && this.call2Diverted == callState_Status$CallOutgoingDiverted_eCallConfirmationPending.call2Diverted && this.call1Diverted == callState_Status$CallOutgoingDiverted_eCallConfirmationPending.call1Diverted && this.call0Diverted == callState_Status$CallOutgoingDiverted_eCallConfirmationPending.call0Diverted;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "CallOutgoingDiverted_eCallConfirmationPending:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushBoolean(this.eCallConfirmationPending);
        bitStream.pushBoolean(this.call6Diverted);
        bitStream.pushBoolean(this.call5Diverted);
        bitStream.pushBoolean(this.call4Diverted);
        bitStream.pushBoolean(this.call3Diverted);
        bitStream.pushBoolean(this.call2Diverted);
        bitStream.pushBoolean(this.call1Diverted);
        bitStream.pushBoolean(this.call0Diverted);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }
}

