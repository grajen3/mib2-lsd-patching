/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StartResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class DialService_StartResult
implements StartResultMethod {
    public int serviceType;
    public static final int SERVICE_TYPE_VOICE_MAILBOX;
    public static final int SERVICE_TYPE_INFO_CALL;
    public static final int SERVICE_TYPE_SERVICE_CALL;
    public static final int SERVICE_TYPE_EMERGENCY_CALL;

    public DialService_StartResult() {
        this.internalReset();
        this.customInitialization();
    }

    public DialService_StartResult(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.serviceType = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        DialService_StartResult dialService_StartResult = (DialService_StartResult)bAPEntity;
        return this.serviceType == dialService_StartResult.serviceType;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "DialService_StartResult:";
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
        this.serviceType = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 27;
    }

    @Override
    public int getFunctionId() {
        return DialService_StartResult.functionId();
    }
}

