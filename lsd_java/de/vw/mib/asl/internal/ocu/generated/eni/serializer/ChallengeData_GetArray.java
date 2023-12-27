/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.generated.eni.serializer;

import de.vw.mib.bap.array.requests.BAPGetArray;
import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class ChallengeData_GetArray
implements BAPGetArray {
    public int asg_Id;
    public static final int ASG_ID_HEAD_UNIT_TO_BE_EVALUATED_BY_ALL_ASGS;
    public static final int ASG_ID_HEAD_UNIT;
    public static final int ASG_ID_DEFAULT_ASG_ANY_ASG_SPONTANEOUS_FSG_MESSAGE;
    private static final int ASG_ID_BITSIZE;
    public int taid;
    public static final int TAID_MIN;
    private static final int TAID_BITSIZE;
    public int authorizationType;
    public static final int AUTHORIZATION_TYPE_SPIN_CHALLENGE;
    public static final int AUTHORIZATION_TYPE_UNKNOWN_DEFAULT;
    public ArrayHeader arrayHeader = new ArrayHeader();

    public ChallengeData_GetArray() {
        this.internalReset();
        this.customInitialization();
    }

    public ChallengeData_GetArray(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.asg_Id = 0;
        this.taid = 0;
        this.authorizationType = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.arrayHeader.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        ChallengeData_GetArray challengeData_GetArray = (ChallengeData_GetArray)bAPEntity;
        return this.asg_Id == challengeData_GetArray.asg_Id && this.taid == challengeData_GetArray.taid && this.authorizationType == challengeData_GetArray.authorizationType && this.arrayHeader.equalTo(challengeData_GetArray.arrayHeader);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "ChallengeData_GetArray:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushBits(4, this.asg_Id);
        bitStream.pushBits(4, this.taid);
        bitStream.pushByte((byte)this.authorizationType);
        this.arrayHeader.serialize(bitStream);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.asg_Id = bitStream.popFrontBits(4);
        this.taid = bitStream.popFrontBits(4);
        this.authorizationType = bitStream.popFrontByte();
        this.arrayHeader.deserialize(bitStream);
    }

    public static int functionId() {
        return 30;
    }

    @Override
    public int getFunctionId() {
        return ChallengeData_GetArray.functionId();
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

