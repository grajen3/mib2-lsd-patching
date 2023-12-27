/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.ResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class ChangeTunerVariant_Result
implements ResultMethod {
    public int changeTunerVariantResult;
    public static final int CHANGE_TUNER_VARIANT_RESULT_SUCCESSFUL;
    public static final int CHANGE_TUNER_VARIANT_RESULT_NOT_SUCCESSFUL;
    public static final int CHANGE_TUNER_VARIANT_RESULT_ABORT_SUCCESSFUL;
    public static final int CHANGE_TUNER_VARIANT_RESULT_ABORT_NOT_SUCCESSFUL;

    @Override
    public int getResultCode() {
        return this.changeTunerVariantResult;
    }

    public ChangeTunerVariant_Result() {
        this.internalReset();
        this.customInitialization();
    }

    public ChangeTunerVariant_Result(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.changeTunerVariantResult = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        ChangeTunerVariant_Result changeTunerVariant_Result = (ChangeTunerVariant_Result)bAPEntity;
        return this.changeTunerVariantResult == changeTunerVariant_Result.changeTunerVariantResult;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "ChangeTunerVariant_Result:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.changeTunerVariantResult);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 33;
    }

    @Override
    public int getFunctionId() {
        return ChangeTunerVariant_Result.functionId();
    }
}

