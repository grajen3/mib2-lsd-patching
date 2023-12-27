/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.ReceptionList_Attributes;
import de.vw.mib.bap.stream.BitStream;

public final class ReceptionList_Data
implements BAPArrayElement {
    private ArrayHeader arrayHeader;
    public static final int RECORD_ADDRESS_TYPE_ATTRIBUTES_PRESET_ID_FM_REG_CODE_CATEGORY_NAME_FREQUENCY;
    public static final int RECORD_ADDRESS_TYPE_ATTRIBUTES_PRESET_ID_FM_REG_CODE_CATEGORY_NAME;
    public static final int RECORD_ADDRESS_TYPE_ATTRIBUTES;
    public static final int RECORD_ADDRESS_PRESET_ID_FM_REG_CODE_CATEGORY_NAME;
    public static final int RECORD_ADDRESS_NAME;
    public static final int RECORD_ADDRESS_FREQUENCY;
    public static final int RECORD_ADDRESS_TYPE_ATTRIBUTES_CATEGORY_NAME;
    public static final int RECORD_ADDRESS_POS;
    public static final int POS_MIN;
    public int pos;
    public static final int TYPE_ANY_STRING_UNKNOWN;
    public static final int TYPE_STATION_NAME;
    public static final int TYPE_DAB_ENSEMBLE_NAME;
    public static final int TYPE_DAB_PRIMARY_SERVICE_NAME;
    public static final int TYPE_DAB_SECONDARY_SERVICE_NAME;
    public static final int TYPE_IBOC_PRIMARY_SERVICE_NAME_IBOC_CHANNEL_CAN_BE_DECODED;
    public static final int TYPE_IBOC_SECONDARY_SERVICE_NAME;
    public static final int TYPE_DVB_SERVICE_NAME;
    public static final int TYPE_SDARS_STATION_NAME;
    public static final int TYPE_ONLINE_RADIO_PRIMARY_SERVICE_NAME_DF4_1;
    public static final int TYPE_ONLINE_RADIO_SECONDARY_SERVICE_NAME_DF4_1;
    public int type;
    public ReceptionList_Attributes attributes;
    public static final int PRESET_ID_MIN;
    public int presetId;
    public static final int FM_REG_CODE_MIN;
    public int fmReg_Code;
    public static final int CATEGORY_UNKNOWN_NONE_CATEGORY;
    public static final int CATEGORY_NEWS;
    public static final int CATEGORY_CURRENT_AFFAIRS;
    public static final int CATEGORY_INFORMATION;
    public static final int CATEGORY_SPORTS;
    public static final int CATEGORY_EDUCATION;
    public static final int CATEGORY_DRAMA;
    public static final int CATEGORY_CULTURE;
    public static final int CATEGORY_SCIENCE;
    public static final int CATEGORY_VARIED;
    public static final int CATEGORY_POP_MUSIC;
    public static final int CATEGORY_ROCK_MUSIC;
    public static final int CATEGORY_EASY_LISTENING_MUSIC;
    public static final int CATEGORY_SERIOUS_CLASSICAL;
    public static final int CATEGORY_LIGHT_CLASSICAL;
    public static final int CATEGORY_OTHER_MUSIC;
    public static final int CATEGORY_WEATHER;
    public static final int CATEGORY_FINANCE;
    public static final int CATEGORY_CHILDRENSS_PROGRAMMES;
    public static final int CATEGORY_SOCIAL_AFFAIRS;
    public static final int CATEGORY_RELIGION;
    public static final int CATEGORY_PHONE_IN;
    public static final int CATEGORY_TRAVEL;
    public static final int CATEGORY_LEISURE;
    public static final int CATEGORY_JAZZ_MUSIC;
    public static final int CATEGORY_COUNTRY_MUSIC;
    public static final int CATEGORY_NATIONAL_MUSIC;
    public static final int CATEGORY_OLDIES_MUSIC;
    public static final int CATEGORY_FOLK_MUSIC;
    public static final int CATEGORY_DOCUMENTARY;
    public static final int CATEGORY_ALARM_TEST;
    public static final int CATEGORY_ALARM;
    public static final int CATEGORY_TALK;
    public static final int CATEGORY_CLASSIC_ROCK;
    public static final int CATEGORY_ADULT_HITS;
    public static final int CATEGORY_SOFT_ROCK;
    public static final int CATEGORY_TOP_40;
    public static final int CATEGORY_OLDIES;
    public static final int CATEGORY_SOFT;
    public static final int CATEGORY_NOSTALGIA;
    public static final int CATEGORY_CLASSICAL;
    public static final int CATEGORY_RHYTHM_AND_BLUES;
    public static final int CATEGORY_SOFT_RHYTHM_AND_BLUES;
    public static final int CATEGORY_FOREIGN_LANGUAGE;
    public static final int CATEGORY_RELIGIOUS_MUSIC;
    public static final int CATEGORY_RELEGIOUS_TALK;
    public static final int CATEGORY_PERSONALITY;
    public static final int CATEGORY_PUBLIC;
    public static final int CATEGORY_COLLEGE;
    public int category;
    private static final int MAX_NAME_LENGTH;
    public final BAPString name;
    private static final int MAX_FREQUENCY_LENGTH;
    public final BAPString frequency;

    @Override
    public void setArrayHeader(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
    }

    @Override
    public ArrayHeader getArrayHeader() {
        return this.arrayHeader;
    }

    public ReceptionList_Data(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
        this.attributes = new ReceptionList_Attributes();
        this.name = new BAPString(49);
        this.frequency = new BAPString(31);
        this.internalReset();
        this.customInitialization();
    }

    public ReceptionList_Data(BitStream bitStream, ArrayHeader arrayHeader) {
        this(arrayHeader);
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.pos = 0;
        this.type = 0;
        this.presetId = 0;
        this.fmReg_Code = 0;
        this.category = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.arrayHeader.reset();
        this.attributes.reset();
        this.name.reset();
        this.frequency.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        ReceptionList_Data receptionList_Data = (ReceptionList_Data)bAPEntity;
        return this.arrayHeader.equalTo(receptionList_Data.arrayHeader) && this.pos == receptionList_Data.pos && this.type == receptionList_Data.type && this.attributes.equalTo(receptionList_Data.attributes) && this.presetId == receptionList_Data.presetId && this.fmReg_Code == receptionList_Data.fmReg_Code && this.category == receptionList_Data.category && this.name.equalTo(receptionList_Data.name) && this.frequency.equalTo(receptionList_Data.frequency);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "ReceptionList_Empty:";
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
            case 6: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                bitStream.pushByte((byte)this.type);
                this.attributes.serialize(bitStream);
                bitStream.pushByte((byte)this.category);
                this.name.serialize(bitStream);
                break;
            }
            case 5: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                this.frequency.serialize(bitStream);
                break;
            }
            case 4: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                this.name.serialize(bitStream);
                break;
            }
            case 3: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                bitStream.pushByte((byte)this.presetId);
                bitStream.pushByte((byte)this.fmReg_Code);
                bitStream.pushByte((byte)this.category);
                this.name.serialize(bitStream);
                break;
            }
            case 2: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                bitStream.pushByte((byte)this.type);
                this.attributes.serialize(bitStream);
                break;
            }
            case 1: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                bitStream.pushByte((byte)this.type);
                this.attributes.serialize(bitStream);
                bitStream.pushByte((byte)this.presetId);
                bitStream.pushByte((byte)this.fmReg_Code);
                bitStream.pushByte((byte)this.category);
                this.name.serialize(bitStream);
                break;
            }
            case 0: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                bitStream.pushByte((byte)this.type);
                this.attributes.serialize(bitStream);
                bitStream.pushByte((byte)this.presetId);
                bitStream.pushByte((byte)this.fmReg_Code);
                bitStream.pushByte((byte)this.category);
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
            case 6: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                this.type = bitStream.popFrontByte();
                this.attributes.deserialize(bitStream);
                this.category = bitStream.popFrontByte();
                this.name.deserialize(bitStream);
                break;
            }
            case 5: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                this.frequency.deserialize(bitStream);
                break;
            }
            case 4: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                this.name.deserialize(bitStream);
                break;
            }
            case 3: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                this.presetId = bitStream.popFrontByte();
                this.fmReg_Code = bitStream.popFrontByte();
                this.category = bitStream.popFrontByte();
                this.name.deserialize(bitStream);
                break;
            }
            case 2: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                this.type = bitStream.popFrontByte();
                this.attributes.deserialize(bitStream);
                break;
            }
            case 1: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                this.type = bitStream.popFrontByte();
                this.attributes.deserialize(bitStream);
                this.presetId = bitStream.popFrontByte();
                this.fmReg_Code = bitStream.popFrontByte();
                this.category = bitStream.popFrontByte();
                this.name.deserialize(bitStream);
                break;
            }
            case 0: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                this.type = bitStream.popFrontByte();
                this.attributes.deserialize(bitStream);
                this.presetId = bitStream.popFrontByte();
                this.fmReg_Code = bitStream.popFrontByte();
                this.category = bitStream.popFrontByte();
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

