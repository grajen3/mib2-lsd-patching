/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.ResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class DedicatedAudioControl_Result
implements ResultMethod {
    public int dedicatedAudioControlResult;
    public static final int DEDICATED_AUDIO_CONTROL_RESULT_SUCCESSFUL;
    public static final int DEDICATED_AUDIO_CONTROL_RESULT_NOT_SUCCESSFUL_NOT_SUPPORTED;
    public static final int DEDICATED_AUDIO_CONTROL_RESULT_ABORT_SUCCESSFUL;
    public static final int DEDICATED_AUDIO_CONTROL_RESULT_ABORT_NOT_SUCCESSFUL;

    @Override
    public int getResultCode() {
        return this.dedicatedAudioControlResult;
    }

    public DedicatedAudioControl_Result() {
        this.internalReset();
        this.customInitialization();
    }

    public DedicatedAudioControl_Result(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.dedicatedAudioControlResult = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        DedicatedAudioControl_Result dedicatedAudioControl_Result = (DedicatedAudioControl_Result)bAPEntity;
        return this.dedicatedAudioControlResult == dedicatedAudioControl_Result.dedicatedAudioControlResult;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "DedicatedAudioControl_Result:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.dedicatedAudioControlResult);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 23;
    }

    @Override
    public int getFunctionId() {
        return DedicatedAudioControl_Result.functionId();
    }
}

