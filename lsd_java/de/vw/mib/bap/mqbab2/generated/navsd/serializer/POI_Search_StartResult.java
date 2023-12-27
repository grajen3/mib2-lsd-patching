/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StartResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class POI_Search_StartResult
implements StartResultMethod {
    public int searchType;
    public static final int SEARCH_TYPE_SEARCH_ALONG_THE_CURRENT_ROUTE_IN_CASE_OF_ACTIVE_RG;
    public static final int SEARCH_TYPE_SEARCH_IN_THE_CIRCUMFERENCE_TO_THE_CURRENT_LOCATION;
    public int poi_Type;
    public static final int POI_TYPE_GASSTATION_GENERAL;
    public static final int POI_TYPE_PARKING_GENERAL;

    public POI_Search_StartResult() {
        this.internalReset();
        this.customInitialization();
    }

    public POI_Search_StartResult(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.searchType = 0;
        this.poi_Type = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        POI_Search_StartResult pOI_Search_StartResult = (POI_Search_StartResult)bAPEntity;
        return this.searchType == pOI_Search_StartResult.searchType && this.poi_Type == pOI_Search_StartResult.poi_Type;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "POI_Search_StartResult:";
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
        this.searchType = bitStream.popFrontByte();
        this.poi_Type = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 51;
    }

    @Override
    public int getFunctionId() {
        return POI_Search_StartResult.functionId();
    }
}

