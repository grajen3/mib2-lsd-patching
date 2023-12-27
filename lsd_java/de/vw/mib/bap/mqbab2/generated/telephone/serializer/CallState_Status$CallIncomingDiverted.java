/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class CallState_Status$CallIncomingDiverted
implements BAPEntity {
    public boolean reserved_bit_7;
    public boolean call6Diverted;
    public boolean call5Diverted;
    public boolean call4Diverted;
    public boolean call3Diverted;
    public boolean call2Diverted;
    public boolean call1Diverted;
    public boolean call0Diverted;

    public CallState_Status$CallIncomingDiverted() {
        this.internalReset();
        this.customInitialization();
    }

    public CallState_Status$CallIncomingDiverted(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.reserved_bit_7 = false;
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
        CallState_Status$CallIncomingDiverted callState_Status$CallIncomingDiverted = (CallState_Status$CallIncomingDiverted)bAPEntity;
        return this.reserved_bit_7 == callState_Status$CallIncomingDiverted.reserved_bit_7 && this.call6Diverted == callState_Status$CallIncomingDiverted.call6Diverted && this.call5Diverted == callState_Status$CallIncomingDiverted.call5Diverted && this.call4Diverted == callState_Status$CallIncomingDiverted.call4Diverted && this.call3Diverted == callState_Status$CallIncomingDiverted.call3Diverted && this.call2Diverted == callState_Status$CallIncomingDiverted.call2Diverted && this.call1Diverted == callState_Status$CallIncomingDiverted.call1Diverted && this.call0Diverted == callState_Status$CallIncomingDiverted.call0Diverted;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "CallIncomingDiverted:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushBoolean(this.reserved_bit_7);
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

