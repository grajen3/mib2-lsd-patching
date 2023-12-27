/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.ResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class NbSpeller_Result
implements ResultMethod {
    public int nbSpeller_Result;
    public static final int NB_SPELLER_RESULT_SUCCESSFUL;
    public static final int NB_SPELLER_RESULT_NOT_SUCCESSFUL;
    public static final int NB_SPELLER_RESULT_ABORT_SUCCESSFUL;
    public static final int NB_SPELLER_RESULT_ABORT_NOT_SUCCESSFUL;
    public int matchingEntries;
    public int pos;

    @Override
    public int getResultCode() {
        return this.nbSpeller_Result;
    }

    public NbSpeller_Result() {
        this.internalReset();
        this.customInitialization();
    }

    public NbSpeller_Result(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.nbSpeller_Result = 0;
        this.matchingEntries = 0;
        this.pos = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        NbSpeller_Result nbSpeller_Result = (NbSpeller_Result)bAPEntity;
        return this.nbSpeller_Result == nbSpeller_Result.nbSpeller_Result && this.matchingEntries == nbSpeller_Result.matchingEntries && this.pos == nbSpeller_Result.pos;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "NbSpeller_Result:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.nbSpeller_Result);
        bitStream.pushShort((short)this.matchingEntries);
        bitStream.pushShort((short)this.pos);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 42;
    }

    @Override
    public int getFunctionId() {
        return NbSpeller_Result.functionId();
    }
}

