/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StartResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class CCSplit_StartResult
implements StartResultMethod {
    public int callId;
    public static final int CALL_ID_CALL0;
    public static final int CALL_ID_CALL1;
    public static final int CALL_ID_CALL2;
    public static final int CALL_ID_CALL3;
    public static final int CALL_ID_CALL4;
    public static final int CALL_ID_CALL5;
    public static final int CALL_ID_CALL6;

    public CCSplit_StartResult() {
        this.internalReset();
        this.customInitialization();
    }

    public CCSplit_StartResult(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.callId = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        CCSplit_StartResult cCSplit_StartResult = (CCSplit_StartResult)bAPEntity;
        return this.callId == cCSplit_StartResult.callId;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "CCSplit_StartResult:";
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
        this.callId = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 41;
    }

    @Override
    public int getFunctionId() {
        return CCSplit_StartResult.functionId();
    }
}

