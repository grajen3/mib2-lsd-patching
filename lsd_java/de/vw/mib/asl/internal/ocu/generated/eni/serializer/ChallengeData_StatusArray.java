/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.generated.eni.serializer;

import de.vw.mib.asl.internal.ocu.generated.eni.serializer.ChallengeData_Data;
import de.vw.mib.bap.array.requests.BAPStatusArray;
import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayData;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class ChallengeData_StatusArray
implements BAPStatusArray {
    public int asg_Id;
    public static final int ASG_ID_HEAD_UNIT_TO_BE_EVALUATED_BY_ALL_ASGS;
    public static final int ASG_ID_HEAD_UNIT;
    public static final int ASG_ID_DEFAULT_ASG_ANY_ASG_SPONTANEOUS_FSG_MESSAGE;
    private static final int ASG_ID_BITSIZE;
    public int taid;
    public static final int TAID_MIN;
    private static final int TAID_BITSIZE;
    public int totalNumListElements;
    public static final int TOTAL_NUM_LIST_ELEMENTS_MIN;
    public int authorizationType;
    public static final int AUTHORIZATION_TYPE_SPIN_CHALLENGE;
    public static final int AUTHORIZATION_TYPE_UNKNOWN_DEFAULT;
    public int hashProcedureVersion;
    public static final int HASH_PROCEDURE_VERSION_MIN;
    public ArrayHeader arrayHeader = new ArrayHeader();
    private static final int MAX_DATA_ELEMENTS;
    public BAPArrayData data = new BAPArrayData(255, this.arrayHeader);

    @Override
    public BAPArrayElement createArrayElement() {
        return new ChallengeData_Data(this.getArrayHeader());
    }

    public ChallengeData_StatusArray() {
        this.internalReset();
        this.customInitialization();
    }

    public ChallengeData_StatusArray(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.asg_Id = 0;
        this.taid = 0;
        this.totalNumListElements = 0;
        this.authorizationType = 0;
        this.hashProcedureVersion = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.arrayHeader.reset();
        this.data.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        ChallengeData_StatusArray challengeData_StatusArray = (ChallengeData_StatusArray)bAPEntity;
        return this.asg_Id == challengeData_StatusArray.asg_Id && this.taid == challengeData_StatusArray.taid && this.totalNumListElements == challengeData_StatusArray.totalNumListElements && this.authorizationType == challengeData_StatusArray.authorizationType && this.hashProcedureVersion == challengeData_StatusArray.hashProcedureVersion && this.arrayHeader.equalTo(challengeData_StatusArray.arrayHeader) && this.data.equalTo(challengeData_StatusArray.data);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "ChallengeData_StatusArray:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushBits(4, this.asg_Id);
        bitStream.pushBits(4, this.taid);
        bitStream.pushByte((byte)this.totalNumListElements);
        bitStream.pushByte((byte)this.authorizationType);
        bitStream.pushByte((byte)this.hashProcedureVersion);
        this.arrayHeader.serialize(bitStream);
        this.data.serialize(bitStream);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.asg_Id = bitStream.popFrontBits(4);
        this.taid = bitStream.popFrontBits(4);
        this.totalNumListElements = bitStream.popFrontByte();
        this.authorizationType = bitStream.popFrontByte();
        this.hashProcedureVersion = bitStream.popFrontByte();
        this.arrayHeader.deserialize(bitStream);
        this.data.reset();
        if (!this.arrayHeader.isFullRangeUpdate()) {
            int n = this.arrayHeader.getNumberOfElements();
            for (int i2 = 0; i2 < n; ++i2) {
                this.data.add(new ChallengeData_Data(bitStream, this.arrayHeader));
            }
        }
    }

    public static int functionId() {
        return 30;
    }

    @Override
    public int getFunctionId() {
        return ChallengeData_StatusArray.functionId();
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

    @Override
    public boolean isBroadcast() {
        return this.asg_Id >>> 3 == 1;
    }

    @Override
    public void setBroadcast(boolean bl) {
        this.asg_Id = bl ? this.asg_Id | 8 : this.asg_Id & 7;
    }

    @Override
    public int getNumberOfElements() {
        return this.totalNumListElements;
    }

    @Override
    public void setNumberOfElements(int n) {
        this.totalNumListElements = n;
    }
}

