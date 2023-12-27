/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.RadioTV_PresetList_Attributes;
import de.vw.mib.bap.stream.BitStream;

public final class RadioTV_PresetList_Data
implements BAPArrayElement {
    private ArrayHeader arrayHeader;
    public static final int RECORD_ADDRESS_PRESET_INDEX_WAVEBAND_ATTRIBUTES_NAME;
    public static final int RECORD_ADDRESS_PRESET_INDEX_WAVEBAND_NAME;
    public static final int RECORD_ADDRESS_PRESET_INDEX_NAME;
    public static final int RECORD_ADDRESS_POS;
    public static final int POS_MIN;
    public int pos;
    public static final int PRESET_INDEX_MIN;
    public int presetIndex;
    public static final int WAVEBAND_UNKNOWN_INVALID;
    public static final int WAVEBAND_FM;
    public static final int WAVEBAND_AM_MW_MITTELWELLE;
    public static final int WAVEBAND_AM_SW_KURZWELLE;
    public static final int WAVEBAND_AM_LW_LANGWELLE;
    public static final int WAVEBAND_SDARS_XM;
    public static final int WAVEBAND_SDARS_SIRIUS;
    public static final int WAVEBAND_DAB;
    public static final int WAVEBAND_DVB;
    public static final int WAVEBAND_TV;
    public static final int WAVEBAND_ONLINE_RADIO_DF4_1;
    public static final int WAVEBAND_COMMON_LIST_DF4_4;
    public int waveband;
    public RadioTV_PresetList_Attributes attributes;
    private static final int MAX_NAME_LENGTH;
    public final BAPString name;

    @Override
    public void setArrayHeader(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
    }

    @Override
    public ArrayHeader getArrayHeader() {
        return this.arrayHeader;
    }

    public RadioTV_PresetList_Data(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
        this.attributes = new RadioTV_PresetList_Attributes();
        this.name = new BAPString(49);
        this.internalReset();
        this.customInitialization();
    }

    public RadioTV_PresetList_Data(BitStream bitStream, ArrayHeader arrayHeader) {
        this(arrayHeader);
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.pos = 0;
        this.presetIndex = 0;
        this.waveband = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.arrayHeader.reset();
        this.attributes.reset();
        this.name.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        RadioTV_PresetList_Data radioTV_PresetList_Data = (RadioTV_PresetList_Data)bAPEntity;
        return this.arrayHeader.equalTo(radioTV_PresetList_Data.arrayHeader) && this.pos == radioTV_PresetList_Data.pos && this.presetIndex == radioTV_PresetList_Data.presetIndex && this.waveband == radioTV_PresetList_Data.waveband && this.attributes.equalTo(radioTV_PresetList_Data.attributes) && this.name.equalTo(radioTV_PresetList_Data.name);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "RadioTV_PresetList_Empty:";
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
                bitStream.pushByte((byte)this.presetIndex);
                this.name.serialize(bitStream);
                break;
            }
            case 1: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                bitStream.pushByte((byte)this.presetIndex);
                bitStream.pushByte((byte)this.waveband);
                this.name.serialize(bitStream);
                break;
            }
            case 0: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                bitStream.pushByte((byte)this.presetIndex);
                bitStream.pushByte((byte)this.waveband);
                this.attributes.serialize(bitStream);
                this.name.serialize(bitStream);
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
                this.presetIndex = bitStream.popFrontByte();
                this.name.deserialize(bitStream);
                break;
            }
            case 1: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                this.presetIndex = bitStream.popFrontByte();
                this.waveband = bitStream.popFrontByte();
                this.name.deserialize(bitStream);
                break;
            }
            case 0: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                this.presetIndex = bitStream.popFrontByte();
                this.waveband = bitStream.popFrontByte();
                this.attributes.deserialize(bitStream);
                this.name.deserialize(bitStream);
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

