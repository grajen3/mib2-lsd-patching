/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.datatypes;

import de.vw.mib.bap.datatypes.ArrayHeader$Mode;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class ArrayHeader
implements BAPEntity {
    public final ArrayHeader$Mode mode = new ArrayHeader$Mode();
    private int recordAddress;
    private int serializationRecordAddress;
    public static final int RECORD_ADDRESS_POS;
    public static final int RECORD_ADDRESS_COMPLETE;
    private static final int RECORD_ADDRESS_BITSIZE;
    public int start;
    public static final int FIRST_BAP_POS;
    private static final int START_BITSIZE;
    private static final int START_LONG_BITSIZE;
    public int elements;
    private static final int ELEMENTS_BITSIZE;
    private static final int ELEMENTS_LONG_BITSIZE;
    private static final int POS_BITSIZE;
    private static final int POS_LONG_BITSIZE;
    private static final int FULL_RANGE_UPDATE_ELEMENTS;
    private static final int ONE_ELEMENT_CHANGE_NUMBER;
    private int _setGetRequestType;
    public static final int REQUEST_TYPE_UNKNOWN;
    public static final int REQUEST_TYPE_MODIFY;
    public static final int REQUEST_TYPE_INSERT;
    public static final int REQUEST_TYPE_DELETE;

    public ArrayHeader() {
        this.internalReset();
    }

    public ArrayHeader(ArrayHeader arrayHeader) {
        this();
        this.copy(arrayHeader);
    }

    public ArrayHeader(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.recordAddress = 0;
        this.serializationRecordAddress = 0;
        this.start = 0;
        this.elements = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.mode.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        ArrayHeader arrayHeader = (ArrayHeader)bAPEntity;
        return this.recordAddress == arrayHeader.recordAddress && this.serializationRecordAddress == arrayHeader.serializationRecordAddress && this.start == arrayHeader.start && this.elements == arrayHeader.elements && this.mode.equalTo(arrayHeader.mode);
    }

    public int getNumberOfElements() {
        return this.elements;
    }

    public boolean isFullRangeUpdate() {
        return this.mode.is16BitsIndexSize() ? this.elements == -65536 : this.elements == 255;
    }

    public void setFullRangeUpdate(boolean bl) {
        this.start = 0;
        this.mode.shift = false;
        this.mode.arrayDirectionIsBackward = false;
        this.mode.arrayPositionIsTransmitted = false;
        this.setRecordAddress(0);
        this.elements = bl ? -65536 : 255;
        this.mode.indexSize16BitForStartElements = bl;
    }

    public boolean dataElementsExists() {
        return !this.isFullRangeUpdate() && this.mode.arrayPositionIsTransmitted;
    }

    public void setElementsChangedBlockRequest(int n, int n2, boolean bl, int n3) {
        this.start = n;
        this.elements = n2;
        this.mode.shift = false;
        this.mode.arrayDirectionIsBackward = false;
        this.mode.arrayPositionIsTransmitted = true;
        this.mode.indexSize16BitForStartElements = bl;
        this.setRecordAddress(n3, 15);
    }

    public boolean isElementsChangedBlockRequest() {
        return !this.mode.shift && !this.mode.arrayDirectionIsBackward && this.mode.arrayPositionIsTransmitted && this.getRecordAddress() != 15;
    }

    public void setElementChangedRequest(int n, boolean bl, int n2) {
        this.start = n;
        this.elements = 1;
        this.mode.shift = false;
        this.mode.arrayDirectionIsBackward = false;
        this.mode.arrayPositionIsTransmitted = false;
        this.mode.indexSize16BitForStartElements = bl;
        this.setRecordAddress(n2, 15);
    }

    public boolean isElementChangedRequest() {
        return !this.mode.shift && !this.mode.arrayPositionIsTransmitted && this.elements == 1 && this.getRecordAddress() != 15;
    }

    public void setElementsDeleteBlockRequest(int n, int n2, boolean bl) {
        this.start = n;
        this.elements = n2;
        this.mode.shift = true;
        this.mode.arrayDirectionIsBackward = true;
        this.mode.arrayPositionIsTransmitted = true;
        this.mode.indexSize16BitForStartElements = bl;
        this.setRecordAddress(15);
    }

    public boolean isElementsDeleteBlockRequest() {
        return this.mode.shift && this.mode.arrayDirectionIsBackward && this.mode.arrayPositionIsTransmitted && this.getRecordAddress() == 15;
    }

    public void setElementsDeleteRangeRequest(int n, int n2, boolean bl) {
        this.start = n;
        this.elements = n2;
        this.mode.shift = true;
        this.mode.arrayDirectionIsBackward = true;
        this.mode.arrayPositionIsTransmitted = false;
        this.mode.indexSize16BitForStartElements = bl;
        this.setRecordAddress(0);
    }

    public boolean isElementsDeleteRangeRequest() {
        return this.mode.shift && this.mode.arrayDirectionIsBackward && !this.mode.arrayPositionIsTransmitted && this.getRecordAddress() == 0;
    }

    public void setElementsInsertedBlockRequest(int n, int n2, boolean bl) {
        this.start = n;
        this.elements = n2;
        this.mode.shift = true;
        this.mode.arrayDirectionIsBackward = false;
        this.mode.arrayPositionIsTransmitted = true;
        this.mode.indexSize16BitForStartElements = bl;
        this.setRecordAddress(15);
    }

    public boolean isElementsInsertedBlockRequest() {
        return this.mode.shift && !this.mode.arrayDirectionIsBackward && this.mode.arrayPositionIsTransmitted && this.getRecordAddress() == 15;
    }

    public void setElementInsertedRequest(int n, boolean bl) {
        this.start = n;
        this.elements = 1;
        this.mode.shift = true;
        this.mode.arrayDirectionIsBackward = false;
        this.mode.arrayPositionIsTransmitted = false;
        this.mode.indexSize16BitForStartElements = bl;
        this.setRecordAddress(0);
    }

    public boolean isElementInsertedRequest() {
        return this.elements == 1 && this.mode.shift && !this.mode.arrayDirectionIsBackward && !this.mode.arrayPositionIsTransmitted && this.getRecordAddress() == 0;
    }

    public void setSetGetRequestChangeType(int n) {
        this._setGetRequestType = n;
    }

    public boolean isSetGetModifyRequest() {
        return this._setGetRequestType == 1;
    }

    public boolean isSetGetInsertRequest() {
        return this._setGetRequestType == 2;
    }

    public boolean isSetGetDeleteRequest() {
        return this._setGetRequestType == 3;
    }

    public int getRecordAddress() {
        return this.recordAddress;
    }

    public void setRecordAddress(int n) {
        this.recordAddress = n;
        this.serializationRecordAddress = n;
    }

    public void setRecordAddress(int n, int n2) {
        this.recordAddress = n;
        this.serializationRecordAddress = n2;
    }

    public int getSerializationRecordAddress() {
        return this.serializationRecordAddress;
    }

    public void serializePosOfArrayElement(BitStream bitStream, BAPArrayElement bAPArrayElement) {
        if (this.mode.arrayPositionIsTransmitted || this.serializationRecordAddress == 15) {
            if (this.mode.is16BitsIndexSize()) {
                bitStream.pushShort((short)bAPArrayElement.getPos());
            } else {
                bitStream.pushByte((byte)bAPArrayElement.getPos());
            }
        }
    }

    public void deserializePosOfArrayElement(BitStream bitStream, BAPArrayElement bAPArrayElement) {
        if (this.mode.arrayPositionIsTransmitted || this.serializationRecordAddress == 15) {
            if (this.mode.is16BitsIndexSize()) {
                bAPArrayElement.setPos(bitStream.popFrontShort());
            } else {
                bAPArrayElement.setPos(bitStream.popFrontByte());
            }
        }
    }

    public int bitSizeOfPosArrayElement() {
        return this.mode.is16BitsIndexSize() ? 16 : 8;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ArrayHeader:");
        stringBuffer.append("\n - Mode - ");
        stringBuffer.append(this.mode.toString());
        stringBuffer.append("\n - RecordAddress: ");
        stringBuffer.append(this.recordAddress);
        stringBuffer.append("\n - Start - ");
        stringBuffer.append(this.start);
        stringBuffer.append("\n - Elements - ");
        stringBuffer.append(this.elements);
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        int n = 0;
        n += this.mode.bitSize();
        n += 4;
        if (this.mode.is16BitsIndexSize()) {
            n += 16;
            n += 16;
        } else {
            n += 8;
            n += 8;
        }
        return n;
    }

    @Override
    public void serialize(BitStream bitStream) {
        this.mode.serialize(bitStream);
        bitStream.pushBits(4, this.recordAddress);
        if (this.mode.is16BitsIndexSize()) {
            bitStream.pushShort((short)this.start);
            bitStream.pushShort((short)this.elements);
        } else {
            bitStream.pushByte((byte)this.start);
            bitStream.pushByte((byte)this.elements);
        }
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.mode.deserialize(bitStream);
        this.setRecordAddress(bitStream.popFrontBits(4));
        if (this.mode.is16BitsIndexSize()) {
            this.start = bitStream.popFrontShort();
            this.elements = bitStream.popFrontShort();
        } else {
            this.start = bitStream.popFrontByte();
            this.elements = bitStream.popFrontByte();
        }
    }

    public void evaluateRecordAddressPosForChangedArray() {
        this.setRecordAddress(this.getRecordAddress(), 15);
    }

    public void copy(ArrayHeader arrayHeader) {
        this._setGetRequestType = arrayHeader._setGetRequestType;
        this.elements = arrayHeader.elements;
        this.recordAddress = arrayHeader.recordAddress;
        this.serializationRecordAddress = arrayHeader.serializationRecordAddress;
        this.start = arrayHeader.start;
        this.mode.copy(arrayHeader.mode);
    }
}

