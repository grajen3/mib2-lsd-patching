/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.generated.eni.serializer;

import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.stream.BitStream;

public final class ChallengeData_Data
implements BAPArrayElement {
    private ArrayHeader arrayHeader;
    public static final int RECORD_ADDRESS_CHALLENGE_TYPE_CHALLENGE;
    public static final int RECORD_ADDRESS_POS;
    public static final int POS_MIN;
    public int pos;
    public static final int CHALLENGE_TYPE_SESSION_CHALLENGE;
    public static final int CHALLENGE_TYPE_USER_CHALLENGE;
    public int challengeType;
    private static final int MAX_CHALLENGE_LENGTH;
    public final BAPString challenge;

    @Override
    public void setArrayHeader(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
    }

    @Override
    public ArrayHeader getArrayHeader() {
        return this.arrayHeader;
    }

    public ChallengeData_Data(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
        this.challenge = new BAPString(129);
        this.internalReset();
        this.customInitialization();
    }

    public ChallengeData_Data(BitStream bitStream, ArrayHeader arrayHeader) {
        this(arrayHeader);
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.pos = 0;
        this.challengeType = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.arrayHeader.reset();
        this.challenge.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        ChallengeData_Data challengeData_Data = (ChallengeData_Data)bAPEntity;
        return this.arrayHeader.equalTo(challengeData_Data.arrayHeader) && this.pos == challengeData_Data.pos && this.challengeType == challengeData_Data.challengeType && this.challenge.equalTo(challengeData_Data.challenge);
    }

    private void customInitialization() {
        this.challenge.setRawContent();
    }

    @Override
    public String toString() {
        return "ChallengeData_Empty:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        switch (this.arrayHeader.getSerializationRecordAddress()) {
            case 15: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                break;
            }
            case 1: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                bitStream.pushByte((byte)this.challengeType);
                this.challenge.serialize(bitStream);
                break;
            }
        }
    }

    @Override
    public void deserialize(BitStream bitStream) {
        switch (this.arrayHeader.getSerializationRecordAddress()) {
            case 15: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                break;
            }
            case 1: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                this.challengeType = bitStream.popFrontByte();
                this.challenge.deserialize(bitStream);
                break;
            }
        }
    }

    @Override
    public void setPos(int n) {
        this.pos = n;
    }

    @Override
    public int getPos() {
        return this.pos;
    }
}

