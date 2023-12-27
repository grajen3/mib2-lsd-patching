/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.generated.eni.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.ResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class TriggerRemoteProcess_Result
implements ResultMethod {
    public int triggerResult;
    public static final int TRIGGER_RESULT_NOT_SUCCESSFUL_COMMAND_TYPE_NOT_SUPPORTED;
    public static final int TRIGGER_RESULT_NOT_SUCCESSFUL;
    public static final int TRIGGER_RESULT_SUCCESSFUL;

    public TriggerRemoteProcess_Result() {
        this.internalReset();
        this.customInitialization();
    }

    public TriggerRemoteProcess_Result(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.triggerResult = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        TriggerRemoteProcess_Result triggerRemoteProcess_Result = (TriggerRemoteProcess_Result)bAPEntity;
        return this.triggerResult == triggerRemoteProcess_Result.triggerResult;
    }

    private void customInitialization() {
    }

    @Override
    public int getResultCode() {
        return this.triggerResult;
    }

    @Override
    public String toString() {
        return "TriggerRemoteProcess_Result:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.triggerResult);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.triggerResult = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 18;
    }

    @Override
    public int getFunctionId() {
        return TriggerRemoteProcess_Result.functionId();
    }
}

