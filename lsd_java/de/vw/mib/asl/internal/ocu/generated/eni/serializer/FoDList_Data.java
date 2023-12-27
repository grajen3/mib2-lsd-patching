/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.generated.eni.serializer;

import de.vw.mib.asl.internal.ocu.generated.eni.serializer.FoDList_FunctionProperties;
import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class FoDList_Data
implements BAPArrayElement {
    private ArrayHeader arrayHeader;
    public static final int RECORD_ADDRESS_FS_ID_ACTIVATION_STATE_FUNCTION_PROPERTIES_VALIDITY_TYPE_START_VALIDITY_STOP_VALIDITY;
    public static final int RECORD_ADDRESS_FS_ID_ACTIVATION_STATE;
    public static final int RECORD_ADDRESS_POS;
    public static final int POS_MIN;
    public int pos;
    public static final int FS_ID_MIN;
    public int fs_Id;
    public static final int ACTIVATION_STATE_ACTIVATED;
    public static final int ACTIVATION_STATE_ACTIVATION_PENDING;
    public static final int ACTIVATION_STATE_ACTIVATED_BUT_LICENSE_EXPIRES_SOON_SEE_VALIDITY_TYPE_START_VALIDITY_STOP_VALIDITY;
    public static final int ACTIVATION_STATE_LICENSE_EXPIRED_BUT_STAYS_ACTIVATED_UNTIL_NEXT_CLAMP_CHANGE;
    public static final int ACTIVATION_STATE_LICENSE_EXPIRED_CONFIRMATION_REQUIRED;
    public static final int ACTIVATION_STATE_LICENSE_EXPIRED_AND_DEACTIVATED;
    public static final int ACTIVATION_STATE_NOT_ACTIVATED;
    public static final int ACTIVATION_STATE_DEFECTIVE;
    public static final int ACTIVATION_STATE_BLOCKED;
    public int activationState;
    public FoDList_FunctionProperties functionProperties;
    public static final int VALIDITY_TYPE_UNLIMITED;
    public static final int VALIDITY_TYPE_TIME_LIMITED_FROM_TO_;
    public static final int VALIDITY_TYPE_TIME_LIMITED_FROM_;
    public static final int VALIDITY_TYPE_TIME_LIMITED_TO_;
    public static final int VALIDITY_TYPE_TIME_LIMITED_IN_SECONDS_FROM_ACTIVATION;
    public static final int VALIDITY_TYPE_OPERATING_TIME_FROM_TO_;
    public static final int VALIDITY_TYPE_OPERATING_TIME_FROM_;
    public static final int VALIDITY_TYPE_OPERATING_TIME_TO_;
    public static final int VALIDITY_TYPE_OPERATING_TIME_IN_SECONDS_FROM_ACTIVATION;
    public static final int VALIDITY_TYPE_MILEAGE_FROM_TO_;
    public static final int VALIDITY_TYPE_MILEAGE_FROM_;
    public static final int VALIDITY_TYPE_MILEAGE_TO_;
    public static final int VALIDITY_TYPE_KILOMETERS_FROM_ACTIVATION;
    public int validityType;
    public static final int START_VALIDITY_MIN;
    public int startValidity;
    public static final int STOP_VALIDITY_MIN;
    public int stopValidity;

    @Override
    public void setArrayHeader(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
    }

    @Override
    public ArrayHeader getArrayHeader() {
        return this.arrayHeader;
    }

    public FoDList_Data(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
        this.functionProperties = new FoDList_FunctionProperties();
        this.internalReset();
        this.customInitialization();
    }

    public FoDList_Data(BitStream bitStream, ArrayHeader arrayHeader) {
        this(arrayHeader);
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.pos = 0;
        this.fs_Id = 1;
        this.activationState = 0;
        this.validityType = 0;
        this.startValidity = 0;
        this.stopValidity = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.arrayHeader.reset();
        this.functionProperties.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        FoDList_Data foDList_Data = (FoDList_Data)bAPEntity;
        return this.arrayHeader.equalTo(foDList_Data.arrayHeader) && this.pos == foDList_Data.pos && this.fs_Id == foDList_Data.fs_Id && this.activationState == foDList_Data.activationState && this.functionProperties.equalTo(foDList_Data.functionProperties) && this.validityType == foDList_Data.validityType && this.startValidity == foDList_Data.startValidity && this.stopValidity == foDList_Data.stopValidity;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "FoDList_Empty:";
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
            case 2: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                bitStream.pushInt(this.fs_Id);
                bitStream.pushByte((byte)this.activationState);
                break;
            }
            case 1: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                bitStream.pushInt(this.fs_Id);
                bitStream.pushByte((byte)this.activationState);
                this.functionProperties.serialize(bitStream);
                bitStream.pushByte((byte)this.validityType);
                bitStream.pushInt(this.startValidity);
                bitStream.pushInt(this.stopValidity);
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
            case 2: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                this.fs_Id = bitStream.popFrontInt();
                this.activationState = bitStream.popFrontByte();
                break;
            }
            case 1: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                this.fs_Id = bitStream.popFrontInt();
                this.activationState = bitStream.popFrontByte();
                this.functionProperties.deserialize(bitStream);
                this.validityType = bitStream.popFrontByte();
                this.startValidity = bitStream.popFrontInt();
                this.stopValidity = bitStream.popFrontInt();
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

