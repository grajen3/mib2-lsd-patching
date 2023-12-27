/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.Phonebook_Data$AdressIndication;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.Phonebook_Data$AnyVoiceTag;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.Phonebook_Data$Reserve;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.Phonebook_Data$VoiceTag;
import de.vw.mib.bap.stream.BitStream;

public final class Phonebook_Data
implements BAPArrayElement {
    private ArrayHeader arrayHeader;
    public static final int RECORD_ADDRESS_PB_NAME_STORAGE_ANY_VOICE_TAG_TEL_NUMBER_QUANTITY_TEL_NUMBER_VOICE_TAG_RESERVE_NUMBER_TYPE_ADRESS_INDICATION;
    public static final int RECORD_ADDRESS_PB_NAME_STORAGE_ANY_VOICE_TAG_TEL_NUMBER_QUANTITY_ADRESS_INDICATION;
    public static final int RECORD_ADDRESS_TEL_NUMBERN_VOICE_TAGN_RESERVEN_NUMBER_TYPEN;
    public static final int RECORD_ADDRESS_PB_NAME_ANY_VOICE_TAG_TEL_NUMBER_QUANTITY_VOICE_TAG_RESERVE_NUMBER_TYPE;
    public static final int RECORD_ADDRESS_ANY_VOICE_TAG_TEL_NUMBER_QUANTITY_TEL_NUMBER_VOICE_TAG_RESERVE_NUMBER_TYPE;
    public static final int RECORD_ADDRESS_POS;
    private int pos;
    public final BAPString pbName;
    private static final int MAX_PB_NAME_LENGTH;
    public int storage;
    public static final int STORAGE_UNDEFINED;
    public static final int STORAGE_SIM;
    public static final int STORAGE_MOBILE_EQUIPMENT;
    public static final int STORAGE_LOCAL_PUBLIC;
    public static final int STORAGE_LOCAL_PRIVATE;
    public Phonebook_Data$AnyVoiceTag anyVoiceTag;
    public int telNumberQuantity;
    private static final int TEL_NUMBER_QUANTITY_BITSIZE;
    public BAPString[] telNumberN;
    private static final int MAX_TEL_NUMBERN_LENGTH;
    private static final int MAX_TEL_NUMBERN_PER_ELEMENT;
    public Phonebook_Data$VoiceTag[] voiceTagN;
    public Phonebook_Data$Reserve[] reserveN;
    public int[] numberTypeN;
    public static final int NUMBER_TYPEN_UNKNOWN_NUMBER_TYPE;
    public static final int NUMBER_TYPEN_GENERAL;
    public static final int NUMBER_TYPEN_MOBILE;
    public static final int NUMBER_TYPEN_OFFICE;
    public static final int NUMBER_TYPEN_HOME;
    public static final int NUMBER_TYPEN_FAX;
    public static final int NUMBER_TYPEN_PAGER;
    public static final int NUMBER_TYPEN_CAR;
    public static final int NUMBER_TYPEN_SIM;
    public static final int NUMBER_TYPEN_MAIN_OFFICE;
    public static final int NUMBER_TYPEN_MAIN_HOME;
    public static final int NUMBER_TYPEN_CELL_OFFICE;
    public static final int NUMBER_TYPEN_CELL_HOME;
    public static final int NUMBER_TYPEN_FAX_OFFICE;
    public static final int NUMBER_TYPEN_FAX_HOME;
    public Phonebook_Data$AdressIndication adressIndication;

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

    public Phonebook_Data(ArrayHeader arrayHeader, int n) {
        this.arrayHeader = arrayHeader;
        this.pbName = new BAPString(100);
        this.anyVoiceTag = new Phonebook_Data$AnyVoiceTag();
        this.telNumberN = null;
        this.numberTypeN = null;
        this.voiceTagN = null;
        this.reserveN = null;
        this.adressIndication = new Phonebook_Data$AdressIndication();
        this.telNumberQuantity = n;
        this.internalReset();
        this.customInitialization();
    }

    public Phonebook_Data(ArrayHeader arrayHeader) {
        this(arrayHeader, 0);
    }

    public Phonebook_Data(BitStream bitStream, ArrayHeader arrayHeader) {
        this(arrayHeader, 0);
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.pos = 0;
        this.storage = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.arrayHeader.reset();
        this.pbName.reset();
        this.anyVoiceTag.reset();
        for (int i2 = 0; i2 < this.telNumberQuantity; ++i2) {
            this.telNumberN[i2].reset();
            this.voiceTagN[i2].reset();
            this.reserveN[i2].reset();
            this.numberTypeN[i2] = 0;
        }
        this.adressIndication.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        boolean bl;
        Phonebook_Data phonebook_Data = (Phonebook_Data)bAPEntity;
        boolean bl2 = bl = this.arrayHeader.equalTo(phonebook_Data.arrayHeader) && this.pos == phonebook_Data.pos && this.pbName.equalTo(phonebook_Data.pbName) && this.storage == phonebook_Data.storage && this.anyVoiceTag.equalTo(phonebook_Data.anyVoiceTag) && this.telNumberQuantity == phonebook_Data.telNumberQuantity && this.adressIndication.equalTo(phonebook_Data.adressIndication);
        if (bl) {
            for (int i2 = 0; i2 < this.telNumberQuantity; ++i2) {
                if (this.telNumberN[i2].equalTo(phonebook_Data.telNumberN[i2]) && this.voiceTagN[i2].equals(phonebook_Data.voiceTagN[i2]) && this.reserveN[i2].equals(phonebook_Data.reserveN[i2]) && this.numberTypeN[i2] == phonebook_Data.numberTypeN[i2]) continue;
                bl = false;
                break;
            }
        }
        return bl;
    }

    private void customInitialization() {
        this.telNumberN = new BAPString[this.telNumberQuantity];
        this.voiceTagN = new Phonebook_Data$VoiceTag[this.telNumberQuantity];
        this.reserveN = new Phonebook_Data$Reserve[this.telNumberQuantity];
        this.numberTypeN = new int[this.telNumberQuantity];
        for (int i2 = 0; i2 < this.telNumberQuantity; ++i2) {
            this.telNumberN[i2] = new BAPString(41);
            this.voiceTagN[i2] = new Phonebook_Data$VoiceTag();
            this.reserveN[i2] = new Phonebook_Data$Reserve();
            this.numberTypeN[i2] = 0;
        }
    }

    @Override
    public String toString() {
        return "Phonebook_Data:";
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
                bitStream.pushByte((byte)this.storage);
                this.anyVoiceTag.serialize(bitStream);
                bitStream.pushBits(4, this.telNumberQuantity);
                for (int i2 = 0; i2 < this.telNumberQuantity; ++i2) {
                    this.telNumberN[i2].serialize(bitStream);
                    this.voiceTagN[i2].serialize(bitStream);
                    this.reserveN[i2].serialize(bitStream);
                    bitStream.pushByte((byte)this.numberTypeN[i2]);
                }
                this.adressIndication.serialize(bitStream);
                break;
            }
            case 1: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                this.pbName.serialize(bitStream);
                bitStream.pushByte((byte)this.storage);
                this.anyVoiceTag.serialize(bitStream);
                bitStream.pushBits(4, this.telNumberQuantity);
                this.adressIndication.serialize(bitStream);
                break;
            }
            case 2: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                for (int i3 = 0; i3 < this.telNumberQuantity; ++i3) {
                    this.telNumberN[i3].serialize(bitStream);
                    this.voiceTagN[i3].serialize(bitStream);
                    this.reserveN[i3].serialize(bitStream);
                    bitStream.pushByte((byte)this.numberTypeN[i3]);
                }
                break;
            }
            case 3: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                this.pbName.serialize(bitStream);
                this.anyVoiceTag.serialize(bitStream);
                bitStream.pushBits(4, this.telNumberQuantity);
                for (int i4 = 0; i4 < this.telNumberQuantity; ++i4) {
                    this.voiceTagN[i4].serialize(bitStream);
                    this.reserveN[i4].serialize(bitStream);
                    bitStream.pushByte((byte)this.numberTypeN[i4]);
                }
                break;
            }
            case 4: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                this.anyVoiceTag.serialize(bitStream);
                bitStream.pushBits(4, this.telNumberQuantity);
                for (int i5 = 0; i5 < this.telNumberQuantity; ++i5) {
                    this.telNumberN[i5].serialize(bitStream);
                    this.voiceTagN[i5].serialize(bitStream);
                    this.reserveN[i5].serialize(bitStream);
                    bitStream.pushByte((byte)this.numberTypeN[i5]);
                }
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

