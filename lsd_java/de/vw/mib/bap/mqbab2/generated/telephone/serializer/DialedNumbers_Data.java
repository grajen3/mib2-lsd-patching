/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.stream.BitStream;

public final class DialedNumbers_Data
implements BAPArrayElement {
    private ArrayHeader arrayHeader;
    public static final int RECORD_ADDRESS_PB_NAME_NUMBER_TYPE_TEL_NUMBER_DAY_MONTH_YEAR_HOUR_MINUTE_SECOND;
    public static final int RECORD_ADDRESS_PB_NAME_NUMBER_TYPE;
    public static final int RECORD_ADDRESS_TEL_NUMBER_DAY_MONTH_YEAR_HOUR_MINUTE_SECOND;
    public static final int RECORD_ADDRESS_POS;
    private int pos;
    public final BAPString pbName;
    private static final int MAX_PB_NAME_LENGTH;
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
    public int day;
    public int month;
    public int year;
    public int hour;
    public int minute;
    public int second;

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

    public DialedNumbers_Data(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
        this.pbName = new BAPString(100);
        this.telNumber = new BAPString(41);
        this.internalReset();
        this.customInitialization();
    }

    public DialedNumbers_Data(BitStream bitStream, ArrayHeader arrayHeader) {
        this(arrayHeader);
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.pos = 0;
        this.numberType = 0;
        this.day = 0;
        this.month = 0;
        this.year = 0;
        this.hour = 0;
        this.minute = 0;
        this.second = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.arrayHeader.reset();
        this.pbName.reset();
        this.telNumber.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        DialedNumbers_Data dialedNumbers_Data = (DialedNumbers_Data)bAPEntity;
        return this.arrayHeader.equalTo(dialedNumbers_Data.arrayHeader) && this.pos == dialedNumbers_Data.pos && this.pbName.equalTo(dialedNumbers_Data.pbName) && this.numberType == dialedNumbers_Data.numberType && this.telNumber.equalTo(dialedNumbers_Data.telNumber) && this.day == dialedNumbers_Data.day && this.month == dialedNumbers_Data.month && this.year == dialedNumbers_Data.year && this.hour == dialedNumbers_Data.hour && this.minute == dialedNumbers_Data.minute && this.second == dialedNumbers_Data.second;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "DialedNumbers_Data:";
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
                this.pbName.serialize(bitStream);
                bitStream.pushByte((byte)this.numberType);
                this.telNumber.serialize(bitStream);
                bitStream.pushByte((byte)this.day);
                bitStream.pushByte((byte)this.month);
                bitStream.pushByte((byte)this.year);
                bitStream.pushByte((byte)this.hour);
                bitStream.pushByte((byte)this.minute);
                bitStream.pushByte((byte)this.second);
                break;
            }
            case 1: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                this.pbName.serialize(bitStream);
                bitStream.pushByte((byte)this.numberType);
                break;
            }
            case 2: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                this.telNumber.serialize(bitStream);
                bitStream.pushByte((byte)this.day);
                bitStream.pushByte((byte)this.month);
                bitStream.pushByte((byte)this.year);
                bitStream.pushByte((byte)this.hour);
                bitStream.pushByte((byte)this.minute);
                bitStream.pushByte((byte)this.second);
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
                this.pbName.deserialize(bitStream);
                this.numberType = bitStream.popFrontByte();
                this.telNumber.deserialize(bitStream);
                this.day = bitStream.popFrontByte();
                this.month = bitStream.popFrontByte();
                this.year = bitStream.popFrontByte();
                this.hour = bitStream.popFrontByte();
                this.minute = bitStream.popFrontByte();
                this.second = bitStream.popFrontByte();
                break;
            }
            case 1: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                this.pbName.deserialize(bitStream);
                this.numberType = bitStream.popFrontByte();
                break;
            }
            case 2: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                this.telNumber.deserialize(bitStream);
                this.day = bitStream.popFrontByte();
                this.month = bitStream.popFrontByte();
                this.year = bitStream.popFrontByte();
                this.hour = bitStream.popFrontByte();
                this.minute = bitStream.popFrontByte();
                this.second = bitStream.popFrontByte();
                break;
            }
            case 15: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                break;
            }
        }
    }
}

