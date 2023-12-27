/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.generated.eni.serializer;

import de.vw.mib.bap.array.requests.BAPGetArray;
import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class AlertList_GetArray
implements BAPGetArray {
    public int asg_Id;
    public static final int ASG_ID_HEAD_UNIT_TO_BE_EVALUATED_BY_ALL_ASGS;
    public static final int ASG_ID_HEAD_UNIT;
    public static final int ASG_ID_DEFAULT_ASG_ANY_ASG_SPONTANEOUS_FSG_MESSAGE;
    private static final int ASG_ID_BITSIZE;
    public int taid;
    public static final int TAID_MIN;
    private static final int TAID_BITSIZE;
    public ArrayHeader arrayHeader = new ArrayHeader();

    public AlertList_GetArray() {
        this.internalReset();
        this.customInitialization();
    }

    public AlertList_GetArray(BitStream bitStream) {
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
        AlertList_GetArray alertList_GetArray = (AlertList_GetArray)bAPEntity;
        return this.asg_Id == alertList_GetArray.asg_Id && this.taid == alertList_GetArray.taid && this.arrayHeader.equalTo(alertList_GetArray.arrayHeader);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "AlertList_GetArray:";
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
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.asg_Id = bitStream.popFrontBits(4);
        this.taid = bitStream.popFrontBits(4);
        this.arrayHeader.deserialize(bitStream);
    }

    public static int functionId() {
        return 25;
    }

    @Override
    public int getFunctionId() {
        return AlertList_GetArray.functionId();
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

