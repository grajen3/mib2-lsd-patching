/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.audiosd.serializer;

import de.vw.mib.bap.array.requests.BAPGetArray;
import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class CommonList_GetArray
implements BAPGetArray {
    public int asg_Id;
    private static final int ASG_ID_BITSIZE;
    public static final int ASG_ID_DEFAULT_ASG_ANY_ASG_SPONTAENOUS_FSG_MESSAGE;
    public static final int ASG_ID_INSTRUMENT_CLUSTER;
    public static final int ASG_ID_HEAD_UP_DISPLAY;
    public static final int ASG_ID_OPERATING_UNIT_REAR_DF4_2;
    public static final int ASG_ID_INSTRUMENT_CLUSTER_TO_BE_EVALUATED_BY_ALL_ASGS;
    public static final int ASG_ID_HEAD_UP_DISPLAY_TO_BE_EVALUATED_BY_ALL_ASGS;
    public static final int ASG_ID_OPERATING_UNIT_REAR_TO_BE_EVALUATED_BY_ALL_ASGS;
    public int taid;
    private static final int TAID_BITSIZE;
    private ArrayHeader arrayHeader = new ArrayHeader();

    @Override
    public int getAsgId() {
        return this.asg_Id & 7;
    }

    @Override
    public void setAsgId(int n) {
        this.asg_Id = this.asg_Id & 8 | n & 7;
    }

    public boolean isBroadcast() {
        return this.asg_Id >>> 3 == 1;
    }

    public void setBroadcast(boolean bl) {
        this.asg_Id = bl ? this.asg_Id | 8 : this.asg_Id & 7;
    }

    @Override
    public int getTransactionId() {
        return this.taid;
    }

    @Override
    public void setTransactionId(int n) {
        this.taid = n;
    }

    @Override
    public void setArrayHeader(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
    }

    @Override
    public ArrayHeader getArrayHeader() {
        return this.arrayHeader;
    }

    public CommonList_GetArray() {
        this.internalReset();
        this.customInitialization();
    }

    public CommonList_GetArray(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.asg_Id = 0;
        this.taid = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.arrayHeader.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        CommonList_GetArray commonList_GetArray = (CommonList_GetArray)bAPEntity;
        return this.asg_Id == commonList_GetArray.asg_Id && this.taid == commonList_GetArray.taid && this.arrayHeader.equalTo(commonList_GetArray.arrayHeader);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "CommonList_GetArray:";
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
        this.asg_Id = bitStream.popFrontBits(4);
        this.taid = bitStream.popFrontBits(4);
        this.arrayHeader.deserialize(bitStream);
    }

    public static int functionId() {
        return 50;
    }

    @Override
    public int getFunctionId() {
        return CommonList_GetArray.functionId();
    }
}

