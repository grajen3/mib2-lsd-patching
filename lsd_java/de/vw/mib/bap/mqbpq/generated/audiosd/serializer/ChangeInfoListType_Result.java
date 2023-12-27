/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.ResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class ChangeInfoListType_Result
implements ResultMethod {
    public int changeInfoListTypeResult;
    public static final int CHANGE_INFO_LIST_TYPE_RESULT_SUCCESSFUL;
    public static final int CHANGE_INFO_LIST_TYPE_RESULT_NOT_SUCCESSFUL;
    public static final int CHANGE_INFO_LIST_TYPE_RESULT_ABORT_SUCCESSFUL;
    public static final int CHANGE_INFO_LIST_TYPE_RESULT_ABORT_NOT_SUCCESSFUL;

    @Override
    public int getResultCode() {
        return this.changeInfoListTypeResult;
    }

    public ChangeInfoListType_Result() {
        this.internalReset();
        this.customInitialization();
    }

    public ChangeInfoListType_Result(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.changeInfoListTypeResult = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        ChangeInfoListType_Result changeInfoListType_Result = (ChangeInfoListType_Result)bAPEntity;
        return this.changeInfoListTypeResult == changeInfoListType_Result.changeInfoListTypeResult;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "ChangeInfoListType_Result:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.changeInfoListTypeResult);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 31;
    }

    @Override
    public int getFunctionId() {
        return ChangeInfoListType_Result.functionId();
    }
}

