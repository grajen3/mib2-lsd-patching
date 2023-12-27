/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.ResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class SaveStation_Result
implements ResultMethod {
    public int saveStationResult;
    public static final int SAVE_STATION_RESULT_SUCCESSFUL;
    public static final int SAVE_STATION_RESULT_NOT_SUCCESSFUL;
    public static final int SAVE_STATION_RESULT_ABORT_SUCCESSFUL;
    public static final int SAVE_STATION_RESULT_ABORT_NOT_SUCCESSFUL;

    @Override
    public int getResultCode() {
        return this.saveStationResult;
    }

    public SaveStation_Result() {
        this.internalReset();
        this.customInitialization();
    }

    public SaveStation_Result(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.saveStationResult = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        SaveStation_Result saveStation_Result = (SaveStation_Result)bAPEntity;
        return this.saveStationResult == saveStation_Result.saveStationResult;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "SaveStation_Result:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.saveStationResult);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 32;
    }

    @Override
    public int getFunctionId() {
        return SaveStation_Result.functionId();
    }
}

