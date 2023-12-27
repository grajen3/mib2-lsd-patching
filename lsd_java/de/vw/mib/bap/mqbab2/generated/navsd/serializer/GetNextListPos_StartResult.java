/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StartResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class GetNextListPos_StartResult
implements StartResultMethod {
    public int currentPos;
    public int offset;
    public int listType;
    public static final int LIST_TYPE_LAST_DESTINATIONS_LIST;
    public static final int LIST_TYPE_FAVORITE_DESTINATIONS_LIST;
    public static final int LIST_TYPE_NAV_BOOK;
    public static final int LIST_TYPE_ADDRESS_LIST;
    public static final int LIST_TYPE_POI_LIST_DF4_1;

    public GetNextListPos_StartResult() {
        this.internalReset();
        this.customInitialization();
    }

    public GetNextListPos_StartResult(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.currentPos = 0;
        this.offset = 0;
        this.listType = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        GetNextListPos_StartResult getNextListPos_StartResult = (GetNextListPos_StartResult)bAPEntity;
        return this.currentPos == getNextListPos_StartResult.currentPos && this.offset == getNextListPos_StartResult.offset && this.listType == getNextListPos_StartResult.listType;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "GetNextListPos_StartResult:";
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
        this.currentPos = bitStream.popFrontShort();
        this.offset = (short)bitStream.popFrontShort();
        this.listType = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 41;
    }

    @Override
    public int getFunctionId() {
        return GetNextListPos_StartResult.functionId();
    }
}

