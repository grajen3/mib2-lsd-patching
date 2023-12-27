/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StartResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class GetNextListPos_StartResult
implements StartResultMethod {
    public int currentPos;
    public static final int CURRENT_POS_MIN;
    public int offset;
    public static final int OFFSET_MIN;
    public int listType;
    public static final int LIST_TYPE_LAST_STATION_LIST_DF4_5;
    public static final int LIST_TYPE_SIRIUS_ALERT_LIST_DF4_5;
    public static final int LIST_TYPE_MEDIA_BROWSER;
    public static final int LIST_TYPE_RADIO_TV_PRESET_LIST;
    public static final int LIST_TYPE_SOURCE_LIST;
    public static final int LIST_TYPE_TP_MEMO_LIST;
    public static final int LIST_TYPE_RECEPTION_LIST;

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
        this.offset = -32766;
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
        bitStream.pushShort((short)this.currentPos);
        bitStream.pushShort((short)this.offset);
        bitStream.pushByte((byte)this.listType);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.currentPos = bitStream.popFrontShort();
        this.offset = (short)bitStream.popFrontShort();
        this.listType = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 44;
    }

    @Override
    public int getFunctionId() {
        return GetNextListPos_StartResult.functionId();
    }
}

