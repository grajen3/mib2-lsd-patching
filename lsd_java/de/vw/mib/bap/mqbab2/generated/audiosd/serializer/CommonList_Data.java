/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.CommonList_Data$Attributes;
import de.vw.mib.bap.stream.BitStream;

public final class CommonList_Data
implements BAPArrayElement {
    private ArrayHeader arrayHeader;
    public static final int RECORD_ADDRESS_SOURCE_TYPE_ATTRIBUTES_PRESET_ID_CATEGORY_NAME_FREQUENCY;
    public static final int RECORD_ADDRESS_SOURCE_TYPE_ATTRIBUTES_PRESET_ID_CATEGORY_NAME;
    public static final int RECORD_ADDRESS_NAME;
    public static final int RECORD_ADDRESS_ATTRIBUTES_FREQUENCY;
    public static final int RECORD_ADDRESS_POS;
    private int pos;
    public int sourceType;
    public static final int SOURCE_TYPE_NO_SOURCE_INVALID;
    public static final int SOURCE_TYPE_FM;
    public static final int SOURCE_TYPE_AM_MW_MITTELWELLE;
    public static final int SOURCE_TYPE_DAB;
    public static final int SOURCE_TYPE_SDARS_XM;
    public static final int SOURCE_TYPE_SDARS_SIRIUS;
    public static final int SOURCE_TYPE_TV;
    public static final int SOURCE_TYPE_AM_TI_JAPAN;
    public static final int SOURCE_TYPE_AM_SW_KURZWELLE_SHORT_WAVE;
    public static final int SOURCE_TYPE_AM_LW_LANGWELLE_LONG_WAVE;
    public static final int SOURCE_TYPE_ONLINE_RADIO;
    public static final int SOURCE_TYPE_UNKNOWN_SOURCE;
    public final CommonList_Data$Attributes attributes;
    public int presetId;
    public int category;
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
    public static final int CATEGORY_LIGHT_CLASSICAL;
    public static final int CATEGORY_SERIOUS_CLASSICAL;
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
    public final BAPString name;
    private static final int MAX_NAME_LENGTH;
    public final BAPString frequency;
    private static final int MAX_FREQUENCY_LENGTH;

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

    public CommonList_Data(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
        this.attributes = new CommonList_Data$Attributes();
        this.name = new BAPString(49);
        this.frequency = new BAPString(31);
        this.internalReset();
        this.customInitialization();
    }

    public CommonList_Data(BitStream bitStream, ArrayHeader arrayHeader) {
        this(arrayHeader);
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.pos = 0;
        this.sourceType = 0;
        this.presetId = 0;
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
        CommonList_Data commonList_Data = (CommonList_Data)bAPEntity;
        return this.arrayHeader.equalTo(commonList_Data.arrayHeader) && this.pos == commonList_Data.pos && this.sourceType == commonList_Data.sourceType && this.attributes.equalTo(commonList_Data.attributes) && this.presetId == commonList_Data.presetId && this.category == commonList_Data.category && this.name.equalTo(commonList_Data.name) && this.frequency.equalTo(commonList_Data.frequency);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "CommonList_Data:";
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
                bitStream.pushByte((byte)this.sourceType);
                this.attributes.serialize(bitStream);
                bitStream.pushByte((byte)this.presetId);
                bitStream.pushByte((byte)this.category);
                this.name.serialize(bitStream);
                this.frequency.serialize(bitStream);
                break;
            }
            case 1: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                bitStream.pushByte((byte)this.sourceType);
                this.attributes.serialize(bitStream);
                bitStream.pushByte((byte)this.presetId);
                bitStream.pushByte((byte)this.category);
                this.name.serialize(bitStream);
                break;
            }
            case 2: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                this.name.serialize(bitStream);
                break;
            }
            case 3: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                this.attributes.serialize(bitStream);
                this.frequency.serialize(bitStream);
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

