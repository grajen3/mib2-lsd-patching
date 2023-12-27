/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.SetGetProperty;
import de.vw.mib.bap.stream.BitStream;

public final class MissedCallIndication_SetGet
implements SetGetProperty {
    public int missedCalls;
    public int missedNumbers;

    public MissedCallIndication_SetGet() {
        this.internalReset();
        this.customInitialization();
    }

    public MissedCallIndication_SetGet(BitStream bitStream) {
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
        MissedCallIndication_SetGet missedCallIndication_SetGet = (MissedCallIndication_SetGet)bAPEntity;
        return this.missedCalls == missedCallIndication_SetGet.missedCalls && this.missedNumbers == missedCallIndication_SetGet.missedNumbers;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "MissedCallIndication_SetGet:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.missedCalls = bitStream.popFrontShort();
        this.missedNumbers = bitStream.popFrontShort();
    }

    public static int functionId() {
        return 45;
    }

    @Override
    public int getFunctionId() {
        return MissedCallIndication_SetGet.functionId();
    }
}

