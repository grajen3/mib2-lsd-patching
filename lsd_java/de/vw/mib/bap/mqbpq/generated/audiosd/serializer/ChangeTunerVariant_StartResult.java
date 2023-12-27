/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StartResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class ChangeTunerVariant_StartResult
implements StartResultMethod {
    public int tunerVariant;
    public static final int TUNER_VARIANT_DEFAULT_VARIANT;
    public static final int TUNER_VARIANT_NAR;
    public static final int TUNER_VARIANT_EUR;
    public static final int TUNER_VARIANT_JAPAN;

    public ChangeTunerVariant_StartResult() {
        this.internalReset();
        this.customInitialization();
    }

    public ChangeTunerVariant_StartResult(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.tunerVariant = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        ChangeTunerVariant_StartResult changeTunerVariant_StartResult = (ChangeTunerVariant_StartResult)bAPEntity;
        return this.tunerVariant == changeTunerVariant_StartResult.tunerVariant;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "ChangeTunerVariant_StartResult:";
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
        this.tunerVariant = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 33;
    }

    @Override
    public int getFunctionId() {
        return ChangeTunerVariant_StartResult.functionId();
    }
}

