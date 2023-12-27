/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.TpMemoList_Attributes;
import de.vw.mib.bap.stream.BitStream;

public final class TpMemoList_Data
implements BAPArrayElement {
    private ArrayHeader arrayHeader;
    public static final int RECORD_ADDRESS_ATTRIBUTES_MESSAGE_TIME_HOUR_MESSAGE_TIME_MINUTE_STATION_NAME;
    public static final int RECORD_ADDRESS_ATTRIBUTES_MESSAGE_TIME_HOUR_MESSAGE_TIME_MINUTE;
    public static final int RECORD_ADDRESS_POS;
    public static final int POS_MIN;
    public int pos;
    public TpMemoList_Attributes attributes;
    public static final int MESSAGE_TIME_HOUR_MIN;
    public int messageTime_Hour;
    public static final int MESSAGE_TIME_MINUTE_MIN;
    public int messageTime_Minute;
    private static final int MAX_STATIONNAME_LENGTH;
    public final BAPString stationName;

    @Override
    public void setArrayHeader(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
    }

    @Override
    public ArrayHeader getArrayHeader() {
        return this.arrayHeader;
    }

    public TpMemoList_Data(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
        this.attributes = new TpMemoList_Attributes();
        this.stationName = new BAPString(49);
        this.internalReset();
        this.customInitialization();
    }

    public TpMemoList_Data(BitStream bitStream, ArrayHeader arrayHeader) {
        this(arrayHeader);
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.pos = 0;
        this.messageTime_Hour = 0;
        this.messageTime_Minute = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.arrayHeader.reset();
        this.attributes.reset();
        this.stationName.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        TpMemoList_Data tpMemoList_Data = (TpMemoList_Data)bAPEntity;
        return this.arrayHeader.equalTo(tpMemoList_Data.arrayHeader) && this.pos == tpMemoList_Data.pos && this.attributes.equalTo(tpMemoList_Data.attributes) && this.messageTime_Hour == tpMemoList_Data.messageTime_Hour && this.messageTime_Minute == tpMemoList_Data.messageTime_Minute && this.stationName.equalTo(tpMemoList_Data.stationName);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "TpMemoList_Empty:";
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
                this.attributes.serialize(bitStream);
                bitStream.pushByte((byte)this.messageTime_Hour);
                bitStream.pushByte((byte)this.messageTime_Minute);
                break;
            }
            case 0: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                this.attributes.serialize(bitStream);
                bitStream.pushByte((byte)this.messageTime_Hour);
                bitStream.pushByte((byte)this.messageTime_Minute);
                this.stationName.serialize(bitStream);
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
                this.attributes.deserialize(bitStream);
                this.messageTime_Hour = bitStream.popFrontByte();
                this.messageTime_Minute = bitStream.popFrontByte();
                break;
            }
            case 0: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                this.attributes.deserialize(bitStream);
                this.messageTime_Hour = bitStream.popFrontByte();
                this.messageTime_Minute = bitStream.popFrontByte();
                this.stationName.deserialize(bitStream);
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

