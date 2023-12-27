/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.SiriusAlertList_Attributes;
import de.vw.mib.bap.stream.BitStream;

public final class SiriusAlertList_Data
implements BAPArrayElement {
    private ArrayHeader arrayHeader;
    public static final int RECORD_ADDRESS_ATTRIBUTES_PRESET_ID_NAME_FREQUENCY;
    public static final int RECORD_ADDRESS_ATTRIBUTES_PRESET_ID_NAME;
    public static final int RECORD_ADDRESS_NAME;
    public static final int RECORD_ADDRESS_ATTRIBUTES_FREQUENCY;
    public static final int RECORD_ADDRESS_POS;
    public static final int POS_MIN;
    public int pos;
    public SiriusAlertList_Attributes attributes;
    public static final int PRESET_ID_MIN;
    public int presetId;
    private static final int MAX_NAME_LENGTH;
    public final BAPString name;
    private static final int MAX_FREQUENCY_LENGTH;
    public final BAPString frequency;
    private static final int MAX_EXTENSION_LENGTH;
    public final BAPString extension;

    @Override
    public void setArrayHeader(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
    }

    @Override
    public ArrayHeader getArrayHeader() {
        return this.arrayHeader;
    }

    public SiriusAlertList_Data(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
        this.attributes = new SiriusAlertList_Attributes();
        this.name = new BAPString(49);
        this.frequency = new BAPString(31);
        this.extension = new BAPString(2);
        this.internalReset();
        this.customInitialization();
    }

    public SiriusAlertList_Data(BitStream bitStream, ArrayHeader arrayHeader) {
        this(arrayHeader);
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.pos = 0;
        this.presetId = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.arrayHeader.reset();
        this.attributes.reset();
        this.name.reset();
        this.frequency.reset();
        this.extension.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        SiriusAlertList_Data siriusAlertList_Data = (SiriusAlertList_Data)bAPEntity;
        return this.arrayHeader.equalTo(siriusAlertList_Data.arrayHeader) && this.pos == siriusAlertList_Data.pos && this.attributes.equalTo(siriusAlertList_Data.attributes) && this.presetId == siriusAlertList_Data.presetId && this.name.equalTo(siriusAlertList_Data.name) && this.frequency.equalTo(siriusAlertList_Data.frequency) && this.extension.equalTo(siriusAlertList_Data.extension);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "SiriusAlertList_Empty:";
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
            case 4: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                this.attributes.serialize(bitStream);
                this.frequency.serialize(bitStream);
                break;
            }
            case 3: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                this.name.serialize(bitStream);
                break;
            }
            case 2: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                this.attributes.serialize(bitStream);
                bitStream.pushByte((byte)this.presetId);
                this.name.serialize(bitStream);
                break;
            }
            case 1: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                this.attributes.serialize(bitStream);
                bitStream.pushByte((byte)this.presetId);
                this.name.serialize(bitStream);
                this.frequency.serialize(bitStream);
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
            case 4: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                this.attributes.deserialize(bitStream);
                this.frequency.deserialize(bitStream);
                break;
            }
            case 3: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                this.name.deserialize(bitStream);
                break;
            }
            case 2: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                this.attributes.deserialize(bitStream);
                this.presetId = bitStream.popFrontByte();
                this.name.deserialize(bitStream);
                break;
            }
            case 1: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                this.attributes.deserialize(bitStream);
                this.presetId = bitStream.popFrontByte();
                this.name.deserialize(bitStream);
                this.frequency.deserialize(bitStream);
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

