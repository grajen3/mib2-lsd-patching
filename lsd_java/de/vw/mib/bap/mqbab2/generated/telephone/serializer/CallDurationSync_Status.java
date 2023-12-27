/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class CallDurationSync_Status
implements StatusProperty {
    public int timeStampCall0;
    public int timeStampCall1;
    public int timeStampCall2;
    public int timeStampCall3;
    public int timeStampCall4;
    public int timeStampCall5;
    public int timeStampCall6;

    public CallDurationSync_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public CallDurationSync_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.timeStampCall0 = 0;
        this.timeStampCall1 = 0;
        this.timeStampCall2 = 0;
        this.timeStampCall3 = 0;
        this.timeStampCall4 = 0;
        this.timeStampCall5 = 0;
        this.timeStampCall6 = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        CallDurationSync_Status callDurationSync_Status = (CallDurationSync_Status)bAPEntity;
        return this.timeStampCall0 == callDurationSync_Status.timeStampCall0 && this.timeStampCall1 == callDurationSync_Status.timeStampCall1 && this.timeStampCall2 == callDurationSync_Status.timeStampCall2 && this.timeStampCall3 == callDurationSync_Status.timeStampCall3 && this.timeStampCall4 == callDurationSync_Status.timeStampCall4 && this.timeStampCall5 == callDurationSync_Status.timeStampCall5 && this.timeStampCall6 == callDurationSync_Status.timeStampCall6;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "CallDurationSync_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushShort((short)this.timeStampCall0);
        bitStream.pushShort((short)this.timeStampCall1);
        bitStream.pushShort((short)this.timeStampCall2);
        bitStream.pushShort((short)this.timeStampCall3);
        bitStream.pushShort((short)this.timeStampCall4);
        bitStream.pushShort((short)this.timeStampCall5);
        bitStream.pushShort((short)this.timeStampCall6);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 24;
    }

    @Override
    public int getFunctionId() {
        return CallDurationSync_Status.functionId();
    }
}

