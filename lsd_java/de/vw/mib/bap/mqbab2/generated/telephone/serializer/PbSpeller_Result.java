/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.ResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class PbSpeller_Result
implements ResultMethod {
    public int pbSpeller_Result;
    public static final int PB_SPELLER_RESULT_SUCCESSFUL;
    public static final int PB_SPELLER_RESULT_NOT_SUCCESSFUL;
    public static final int PB_SPELLER_RESULT_ABORT_SUCCESSFUL;
    public static final int PB_SPELLER_RESULT_ABORT_NOT_SUCCESSFUL;
    public static final int PB_SPELLER_RESULT_NOT_SUCCESSFUL_FIRST_CHARACTER_REACHED;
    public static final int PB_SPELLER_RESULT_NOT_SUCCESSFUL_LAST_CHARACTER_REACHED;
    public int matchingEntries;
    public int pos;

    @Override
    public int getResultCode() {
        return this.pbSpeller_Result;
    }

    public PbSpeller_Result() {
        this.internalReset();
        this.customInitialization();
    }

    public PbSpeller_Result(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.pbSpeller_Result = 0;
        this.matchingEntries = 0;
        this.pos = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        PbSpeller_Result pbSpeller_Result = (PbSpeller_Result)bAPEntity;
        return this.pbSpeller_Result == pbSpeller_Result.pbSpeller_Result && this.matchingEntries == pbSpeller_Result.matchingEntries && this.pos == pbSpeller_Result.pos;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "PbSpeller_Result:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.pbSpeller_Result);
        bitStream.pushShort((short)this.matchingEntries);
        bitStream.pushShort((short)this.pos);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 53;
    }

    @Override
    public int getFunctionId() {
        return PbSpeller_Result.functionId();
    }
}

