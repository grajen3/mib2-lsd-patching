/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.ResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class RepeatLastNavAnnouncement_Result
implements ResultMethod {
    public int repeatLna_Result;
    public static final int REPEAT_LNA_RESULT_SUCCESSFUL;
    public static final int REPEAT_LNA_RESULT_NOT_SUCCESSFUL;
    public static final int REPEAT_LNA_RESULT_ABORT_SUCCESSFUL;
    public static final int REPEAT_LNA_RESULT_ABORT_NOT_SUCCESSFUL;

    @Override
    public int getResultCode() {
        return this.repeatLna_Result;
    }

    public RepeatLastNavAnnouncement_Result() {
        this.internalReset();
        this.customInitialization();
    }

    public RepeatLastNavAnnouncement_Result(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.repeatLna_Result = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        RepeatLastNavAnnouncement_Result repeatLastNavAnnouncement_Result = (RepeatLastNavAnnouncement_Result)bAPEntity;
        return this.repeatLna_Result == repeatLastNavAnnouncement_Result.repeatLna_Result;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "RepeatLastNavAnnouncement_Result:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.repeatLna_Result);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 35;
    }

    @Override
    public int getFunctionId() {
        return RepeatLastNavAnnouncement_Result.functionId();
    }
}

