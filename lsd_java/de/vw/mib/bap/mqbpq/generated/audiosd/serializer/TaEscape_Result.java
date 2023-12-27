/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.ResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class TaEscape_Result
implements ResultMethod {
    public int taEscapeResult;
    public static final int TA_ESCAPE_RESULT_SUCCESSFUL;
    public static final int TA_ESCAPE_RESULT_NOT_SUCCESSFUL;
    public static final int TA_ESCAPE_RESULT_ABORT_SUCCESSFUL;
    public static final int TA_ESCAPE_RESULT_ABORT_NOT_SUCCESSFUL;
    public static final int TA_ESCAPE_RESULT_TA_NOT_ACTIVE;

    @Override
    public int getResultCode() {
        return this.taEscapeResult;
    }

    public TaEscape_Result() {
        this.internalReset();
        this.customInitialization();
    }

    public TaEscape_Result(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.taEscapeResult = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        TaEscape_Result taEscape_Result = (TaEscape_Result)bAPEntity;
        return this.taEscapeResult == taEscape_Result.taEscapeResult;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "TaEscape_Result:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.taEscapeResult);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 27;
    }

    @Override
    public int getFunctionId() {
        return TaEscape_Result.functionId();
    }
}

