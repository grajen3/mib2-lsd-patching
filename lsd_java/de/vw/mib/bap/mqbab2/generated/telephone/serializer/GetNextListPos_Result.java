/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.ResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class GetNextListPos_Result
implements ResultMethod {
    public int getNextListPos_Result;
    public static final int GET_NEXT_LIST_POS_RESULT_SUCCESSFUL;
    public static final int GET_NEXT_LIST_POS_RESULT_NOT_SUCCESSFUL;
    public static final int GET_NEXT_LIST_POS_RESULT_ABORT_SUCCESSFUL;
    public static final int GET_NEXT_LIST_POS_RESULT_ABORT_NOT_SUCCESSFUL;
    public int currentPos;
    public int nextPos;
    public int absoluteListPos;

    @Override
    public int getResultCode() {
        return this.getNextListPos_Result;
    }

    public GetNextListPos_Result() {
        this.internalReset();
        this.customInitialization();
    }

    public GetNextListPos_Result(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.getNextListPos_Result = 0;
        this.currentPos = 0;
        this.nextPos = 0;
        this.absoluteListPos = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        GetNextListPos_Result getNextListPos_Result = (GetNextListPos_Result)bAPEntity;
        return this.getNextListPos_Result == getNextListPos_Result.getNextListPos_Result && this.currentPos == getNextListPos_Result.currentPos && this.nextPos == getNextListPos_Result.nextPos && this.absoluteListPos == getNextListPos_Result.absoluteListPos;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "GetNextListPos_Result:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.getNextListPos_Result);
        bitStream.pushShort((short)this.currentPos);
        bitStream.pushShort((short)this.nextPos);
        bitStream.pushShort((short)this.absoluteListPos);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 54;
    }

    @Override
    public int getFunctionId() {
        return GetNextListPos_Result.functionId();
    }
}

