/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.generated.eni.serializer;

import de.vw.mib.asl.internal.ocu.generated.eni.serializer.DestinationsList_Data;
import de.vw.mib.bap.array.requests.BAPSetGetArray;
import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayData;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class DestinationsList_SetGetArray
implements BAPSetGetArray {
    public int asg_Id;
    public static final int ASG_ID_HEAD_UNIT_TO_BE_EVALUATED_BY_ALL_ASGS;
    public static final int ASG_ID_HEAD_UNIT;
    public static final int ASG_ID_DEFAULT_ASG_ANY_ASG_SPONTAENOUS_FSG_MESSAGE;
    private static final int ASG_ID_BITSIZE;
    public int taid;
    public static final int TAID_MIN;
    private static final int TAID_BITSIZE;
    public ArrayHeader arrayHeader = new ArrayHeader();
    private static final int MAX_DATA_ELEMENTS;
    public BAPArrayData data = new BAPArrayData(-65536, this.arrayHeader);

    @Override
    public BAPArrayElement createArrayElement() {
        return new DestinationsList_Data(this.getArrayHeader());
    }

    public DestinationsList_SetGetArray() {
        this.internalReset();
        this.customInitialization();
    }

    public DestinationsList_SetGetArray(BitStream bitStream) {
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
        this.data.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        DestinationsList_SetGetArray destinationsList_SetGetArray = (DestinationsList_SetGetArray)bAPEntity;
        return this.asg_Id == destinationsList_SetGetArray.asg_Id && this.taid == destinationsList_SetGetArray.taid && this.arrayHeader.equalTo(destinationsList_SetGetArray.arrayHeader) && this.data.equalTo(destinationsList_SetGetArray.data);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "DestinationsList_SetGetArray:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushBits(4, this.asg_Id);
        bitStream.pushBits(4, this.taid);
        this.arrayHeader.serialize(bitStream);
        this.data.serialize(bitStream);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.asg_Id = bitStream.popFrontBits(4);
        this.taid = bitStream.popFrontBits(4);
        this.arrayHeader.deserialize(bitStream);
        this.data.reset();
        if (!this.arrayHeader.isFullRangeUpdate()) {
            int n = this.arrayHeader.getNumberOfElements();
            for (int i2 = 0; i2 < n; ++i2) {
                this.data.add(new DestinationsList_Data(bitStream, this.arrayHeader));
            }
        }
    }

    public static int functionId() {
        return 16;
    }

    @Override
    public int getFunctionId() {
        return DestinationsList_SetGetArray.functionId();
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
    public void setArrayHeader(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
    }

    @Override
    public ArrayHeader getArrayHeader() {
        return this.arrayHeader;
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
}

