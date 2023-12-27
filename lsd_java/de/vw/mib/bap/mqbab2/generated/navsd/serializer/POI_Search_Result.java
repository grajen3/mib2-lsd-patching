/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.ResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class POI_Search_Result
implements ResultMethod {
    public int amountOfFoundEntries;
    public int poi_Search_Result;
    public static final int POI_SEARCH_RESULT_SUCCESSFUL;
    public static final int POI_SEARCH_RESULT_NOT_SUCCESSFUL;
    public static final int POI_SEARCH_RESULT_ABORT_SUCCESSFUL;
    public static final int POI_SEARCH_RESULT_ABORT_NOT_SUCCESSFUL;
    public static final int POI_SEARCH_RESULT_NOT_SUCCESSFUL_ENTRY_NOT_FOUND;
    public static final int POI_SEARCH_RESULT_NOT_SUCCESSFUL_POI_TYPE_DOES_NOT_MATCH_TO_FSG_INTERNAL_VALUE;

    public POI_Search_Result() {
        this.internalReset();
        this.customInitialization();
    }

    public POI_Search_Result(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.amountOfFoundEntries = 0;
        this.poi_Search_Result = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        POI_Search_Result pOI_Search_Result = (POI_Search_Result)bAPEntity;
        return this.amountOfFoundEntries == pOI_Search_Result.amountOfFoundEntries && this.poi_Search_Result == pOI_Search_Result.poi_Search_Result;
    }

    private void customInitialization() {
    }

    @Override
    public int getResultCode() {
        return this.poi_Search_Result;
    }

    @Override
    public String toString() {
        return "POI_Search_Result:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.amountOfFoundEntries);
        bitStream.pushByte((byte)this.poi_Search_Result);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 51;
    }

    @Override
    public int getFunctionId() {
        return POI_Search_Result.functionId();
    }
}

