/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.sdssd.serializer;

import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.stream.BitStream;

public final class ResultList_Data
implements BAPArrayElement {
    private ArrayHeader arrayHeader;
    public static final int RECORD_ADDRESS_RESULT_TYPE_RESULT_TEXT;
    public static final int RECORD_ADDRESS_RESULT_TEXT;
    public static final int RECORD_ADDRESS_POS;
    private int pos;
    public int resultType;
    public static final int RESULT_TYPE_ANY_TYPE_UNKNOWN;
    public static final int RESULT_TYPE_ADDRESS;
    public static final int RESULT_TYPE_POI;
    public static final int RESULT_TYPE_HOME_ADDRESS;
    public static final int RESULT_TYPE_CONTACT_NAME;
    public static final int RESULT_TYPE_TELEPHONE_NUMBER;
    public static final int RESULT_TYPE_ALBUM;
    public static final int RESULT_TYPE_TRACK_TITEL;
    public static final int RESULT_TYPE_RADIO_STATION;
    public final BAPString resultText;
    private static final int MAX_RESULT_TEXT_LENGTH;
    public final BAPString extension;
    private static final int MAX_EXTENSION_LENGTH;

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

    public ResultList_Data(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
        this.resultText = new BAPString(171);
        this.extension = new BAPString(2);
        this.internalReset();
        this.customInitialization();
    }

    public ResultList_Data(BitStream bitStream, ArrayHeader arrayHeader) {
        this(arrayHeader);
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.pos = 0;
        this.resultType = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.arrayHeader.reset();
        this.resultText.reset();
        this.extension.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        ResultList_Data resultList_Data = (ResultList_Data)bAPEntity;
        return this.arrayHeader.equalTo(resultList_Data.arrayHeader) && this.pos == resultList_Data.pos && this.resultType == resultList_Data.resultType && this.resultText.equalTo(resultList_Data.resultText) && this.extension.equalTo(resultList_Data.extension);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "ResultList_Data:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        switch (this.arrayHeader.getSerializationRecordAddress()) {
            case 1: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                bitStream.pushByte((byte)this.resultType);
                this.resultText.serialize(bitStream);
                break;
            }
            case 2: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                this.resultText.serialize(bitStream);
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
    }
}

