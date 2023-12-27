/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class MissedCallIndication_Status
implements StatusProperty {
    public int missedCalls;
    public int missedNumbers;

    public MissedCallIndication_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public MissedCallIndication_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.missedCalls = 0;
        this.missedNumbers = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        MissedCallIndication_Status missedCallIndication_Status = (MissedCallIndication_Status)bAPEntity;
        return this.missedCalls == missedCallIndication_Status.missedCalls && this.missedNumbers == missedCallIndication_Status.missedNumbers;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "MissedCallIndication_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushShort((short)this.missedCalls);
        bitStream.pushShort((short)this.missedNumbers);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 45;
    }

    @Override
    public int getFunctionId() {
        return MissedCallIndication_Status.functionId();
    }
}

