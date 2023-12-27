/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.audiosd.serializer;

import de.vw.mib.bap.array.requests.BAPStatusArray;
import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayData;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.CommonList_Data;
import de.vw.mib.bap.stream.BitStream;

public final class CommonList_StatusArray
implements BAPStatusArray {
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
    public int totalNumListElements;
    private ArrayHeader arrayHeader = new ArrayHeader();
    private BAPArrayData data = new BAPArrayData(-65536);
    private static final int MAX_DATA_ELEMENTS;

    @Override
    public int getAsgId() {
        return this.asg_Id & 7;
    }

    @Override
    public void setAsgId(int n) {
        this.asg_Id = this.asg_Id & 8 | n & 7;
    }

    @Override
    public boolean isBroadcast() {
        return this.asg_Id >>> 3 == 1;
    }

    @Override
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
    public int getNumberOfElements() {
        return this.totalNumListElements;
    }

    @Override
    public void setNumberOfElements(int n) {
        this.totalNumListElements = n;
    }

    @Override
    public void setArrayHeader(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
    }

    @Override
    public ArrayHeader getArrayHeader() {
        return this.arrayHeader;
    }

    @Override
    public void setArrayData(BAPArrayData bAPArrayData) {
        this.data = bAPArrayData;
    }

    @Override
    public BAPArrayData getArrayData() {
        return this.data;
    }

    @Override
    public BAPArrayElement createArrayElement() {
        return new CommonList_Data(this.getArrayHeader());
    }

    public CommonList_StatusArray() {
        this.internalReset();
        this.customInitialization();
    }

    public CommonList_StatusArray(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.asg_Id = 0;
        this.taid = 0;
        this.totalNumListElements = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.arrayHeader.reset();
        this.data.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        CommonList_StatusArray commonList_StatusArray = (CommonList_StatusArray)bAPEntity;
        return this.asg_Id == commonList_StatusArray.asg_Id && this.taid == commonList_StatusArray.taid && this.totalNumListElements == commonList_StatusArray.totalNumListElements && this.arrayHeader.equalTo(commonList_StatusArray.arrayHeader) && this.data.equalTo(commonList_StatusArray.data);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "CommonList_StatusArray:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushBits(4, this.asg_Id);
        bitStream.pushBits(4, this.taid);
        bitStream.pushShort((short)this.totalNumListElements);
        this.arrayHeader.serialize(bitStream);
        this.data.serialize(bitStream);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 50;
    }

    @Override
    public int getFunctionId() {
        return CommonList_StatusArray.functionId();
    }
}

