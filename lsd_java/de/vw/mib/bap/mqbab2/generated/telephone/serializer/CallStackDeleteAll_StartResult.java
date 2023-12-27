/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.CallStackDeleteAll_StartResult$Storage;
import de.vw.mib.bap.requests.StartResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class CallStackDeleteAll_StartResult
implements StartResultMethod {
    public final CallStackDeleteAll_StartResult$Storage storage = new CallStackDeleteAll_StartResult$Storage();

    public CallStackDeleteAll_StartResult() {
        this.internalReset();
        this.customInitialization();
    }

    public CallStackDeleteAll_StartResult(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
    }

    @Override
    public void reset() {
        this.internalReset();
        this.storage.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        CallStackDeleteAll_StartResult callStackDeleteAll_StartResult = (CallStackDeleteAll_StartResult)bAPEntity;
        return this.storage.equalTo(callStackDeleteAll_StartResult.storage);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "CallStackDeleteAll_StartResult:";
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
        this.storage.deserialize(bitStream);
    }

    public static int functionId() {
        return 50;
    }

    @Override
    public int getFunctionId() {
        return CallStackDeleteAll_StartResult.functionId();
    }
}

