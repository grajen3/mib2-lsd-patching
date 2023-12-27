/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.stream.BitStream;

public final class FavoriteList_Data
implements BAPArrayElement {
    private ArrayHeader arrayHeader;
    public static final int RECORD_ADDRESS_NAME_NUMBER_TYPE_TEL_NUMBER;
    public static final int RECORD_ADDRESS_NAME_NUMBER_TYPE;
    public static final int RECORD_ADDRESS_NAME_TEL_NUMBER;
    public static final int RECORD_ADDRESS_POS;
    private int pos;
    public final BAPString name;
    private static final int MAX_NAME_LENGTH;
    public int numberType;
    public static final int NUMBER_TYPE_UNKNOWN_NUMBER_TYPE;
    public static final int NUMBER_TYPE_GENERAL;
    public static final int NUMBER_TYPE_MOBILE;
    public static final int NUMBER_TYPE_OFFICE;
    public static final int NUMBER_TYPE_HOME;
    public static final int NUMBER_TYPE_FAX;
    public static final int NUMBER_TYPE_PAGER;
    public static final int NUMBER_TYPE_CAR;
    public static final int NUMBER_TYPE_SIM;
    public static final int NUMBER_TYPE_MAIN_OFFICE;
    public static final int NUMBER_TYPE_MAIN_HOME;
    public static final int NUMBER_TYPE_CELL_OFFICE;
    public static final int NUMBER_TYPE_CELL_HOME;
    public static final int NUMBER_TYPE_FAX_OFFICE;
    public static final int NUMBER_TYPE_FAX_HOME;
    public final BAPString telNumber;
    private static final int MAX_TEL_NUMBER_LENGTH;

    @Override
    public void setArrayHeader(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
    }

    @Override
    public ArrayHeader getArrayHeader() {
        return this.arrayHeader;
    }

    @Override
    public void setPos(int n) {
        this.pos = n;
    }

    @Override
    public int getPos() {
        return this.pos;
    }

    public FavoriteList_Data(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
        this.name = new BAPString(100);
        this.telNumber = new BAPString(41);
        this.internalReset();
        this.customInitialization();
    }

    public FavoriteList_Data(BitStream bitStream, ArrayHeader arrayHeader) {
        this(arrayHeader);
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.pos = 0;
        this.numberType = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.arrayHeader.reset();
        this.name.reset();
        this.telNumber.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        FavoriteList_Data favoriteList_Data = (FavoriteList_Data)bAPEntity;
        return this.arrayHeader.equalTo(favoriteList_Data.arrayHeader) && this.pos == favoriteList_Data.pos && this.name.equalTo(favoriteList_Data.name) && this.numberType == favoriteList_Data.numberType && this.telNumber.equalTo(favoriteList_Data.telNumber);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "FavoriteList_Data:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        switch (this.arrayHeader.getSerializationRecordAddress()) {
            case 0: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                this.name.serialize(bitStream);
                bitStream.pushByte((byte)this.numberType);
                this.telNumber.serialize(bitStream);
                break;
            }
            case 1: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                this.name.serialize(bitStream);
                bitStream.pushByte((byte)this.numberType);
                break;
            }
            case 2: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                this.name.serialize(bitStream);
                this.telNumber.serialize(bitStream);
                break;
            }
            case 15: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                break;
            }
        }
    }

    @Override
    public void deserialize(BitStream bitStream) {
        switch (this.arrayHeader.getSerializationRecordAddress()) {
            case 0: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                this.name.deserialize(bitStream);
                this.numberType = bitStream.popFrontByte();
                this.telNumber.deserialize(bitStream);
                break;
            }
            case 1: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                this.name.deserialize(bitStream);
                this.numberType = bitStream.popFrontByte();
                break;
            }
            case 2: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                this.name.deserialize(bitStream);
                this.telNumber.deserialize(bitStream);
                break;
            }
            case 15: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                break;
            }
        }
    }
}

