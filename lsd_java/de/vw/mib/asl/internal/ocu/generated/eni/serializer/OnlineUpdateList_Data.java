/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.generated.eni.serializer;

import de.vw.mib.asl.internal.ocu.generated.eni.serializer.OnlineUpdateList_UpdateDomain;
import de.vw.mib.asl.internal.ocu.generated.eni.serializer.OnlineUpdateList_UpdatePrecondition;
import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.stream.BitStream;

public final class OnlineUpdateList_Data
implements BAPArrayElement {
    private ArrayHeader arrayHeader;
    public static final int RECORD_ADDRESS_UPDATE_ID_UPDATE_DOMAIN_DESCRIPTION_ONLINE_UPDATE_LANGUAGE_UPDATE_PRECONDITION_DOWNLOAD_SIZE_DOWNLOAD_SIZE_UNIT_ESTIMATED_UPDATE_DURATION;
    public static final int RECORD_ADDRESS_POS;
    public static final int POS_MIN;
    public int pos;
    private static final int MAX_UPDATEID_LENGTH;
    public final BAPString updateId;
    public OnlineUpdateList_UpdateDomain updateDomain;
    private static final int MAX_DESCRIPTIONONLINEUPDATE_LENGTH;
    public final BAPString descriptionOnlineUpdate;
    public static final int LANGUAGE_DEUTSCH_GERMAN;
    public static final int LANGUAGE_UK_ENGLISCH_UK_ENGLISH;
    public static final int LANGUAGE_US_ENGLISCH_US_ENGLISH;
    public static final int LANGUAGE_FRANZOESISCH_FRENCH;
    public static final int LANGUAGE_ITALIENISCH_ITALIAN;
    public static final int LANGUAGE_SPANISCH_SPANISH;
    public static final int LANGUAGE_PORTUGIESISCH_PORTUGUESE;
    public static final int LANGUAGE_POLNISCH_POLISH;
    public static final int LANGUAGE_TSCHECHISCH_CZECH;
    public static final int LANGUAGE_UNGARISCH_HUNGARIAN;
    public static final int LANGUAGE_DAENISCH_DANISH;
    public static final int LANGUAGE_SCHWEDISCH_SWEDISH;
    public static final int LANGUAGE_FINNISCH_FINNISH;
    public static final int LANGUAGE_NIEDERLAENDISCH_DUTCH;
    public static final int LANGUAGE_CHINESISCH_TRADITIONELL_CHINESE_TRADITONAL;
    public static final int LANGUAGE_JAPANISCH_JAPANESE;
    public static final int LANGUAGE_RUSSISCH_RUSSIAN;
    public static final int LANGUAGE_GRIECHISCH_GREEK;
    public static final int LANGUAGE_KOREANISCH_KOREAN;
    public static final int LANGUAGE_FRANZOESISCH_KANADISCH_FRENCH_CANADIAN;
    public static final int LANGUAGE_SPANISCH_US_SPANISH_US;
    public static final int LANGUAGE_PORTUGISISCH_US_PORTUGUESE_US;
    public static final int LANGUAGE_TUERKISCH_TURKISH;
    public static final int LANGUAGE_CHINESISCH_MANDARIN_CHINESE_MANDARIN;
    public static final int LANGUAGE_CHINESICH_KANTONESISCH_CHINESE_CANTONESE;
    public static final int LANGUAGE_ARABISCH_ARABIC;
    public static final int LANGUAGE_PORTUGIESISCH_BRASILIEN_PORTUGUESE_BRAZIL;
    public static final int LANGUAGE_MALAYSISCH_MALAYSIAN;
    public static final int LANGUAGE_THAILAENDISCH_THAI;
    public static final int LANGUAGE_NORWEGISCH_NORWEGIAN;
    public static final int LANGUAGE_KROATISCH_CROATIAN;
    public static final int LANGUAGE_SERBISCH_SERBIAN;
    public static final int LANGUAGE_SLOWAKISCH_SLOVAK;
    public static final int LANGUAGE_RUMAENISCH_ROMANIAN;
    public static final int LANGUAGE_HINDI_HINDI;
    public static final int LANGUAGE_INDONESISCH_INDONESIAN;
    public static final int LANGUAGE_ASERBAIDSCHANISCH_AZERBAIJANIAN;
    public static final int LANGUAGE_BOSNISCH_BOSNIAN;
    public static final int LANGUAGE_SLOWENISCH_SLOVENIAN;
    public static final int LANGUAGE_BULGARISCH_BULGARIAN;
    public static final int LANGUAGE_LETTISCH_LATVIAN;
    public static final int LANGUAGE_ESTNISCH_ESTONIAN;
    public static final int LANGUAGE_LITAUISCH_LITHUANIAN;
    public static final int LANGUAGE_UKRAINISCH_UKRAINIAN;
    public static final int LANGUAGE_HEBRAEISCH_HEBREW;
    public static final int LANGUAGE_KATALANISCH_CATALAN;
    public static final int LANGUAGE_GALICISCH_GALICIAN;
    public static final int LANGUAGE_BASKISCH_BASQUE;
    public static final int LANGUAGE_ENGLISCH_CHINA_ENGLISH_CHINA;
    public static final int LANGUAGE_ENGLISCH_JAPAN_ENGLISH_JAPAN;
    public static final int LANGUAGE_ENGLISCH_KOREA_ENGLISH_KOREA;
    public static final int LANGUAGE_ENGLISCH_TAIWAN_ENGLISH_TAIWAN;
    public int language;
    public OnlineUpdateList_UpdatePrecondition updatePrecondition;
    public static final int DOWNLOAD_SIZE_MIN;
    public int downloadSize;
    public static final int DOWNLOAD_SIZE_UNIT_NO_INFORMATION_DEFAULT_DURING_STARTUP;
    public static final int DOWNLOAD_SIZE_UNIT_BYTE;
    public static final int DOWNLOAD_SIZE_UNIT_KILOBYTE;
    public static final int DOWNLOAD_SIZE_UNIT_MEGABYTE;
    public static final int DOWNLOAD_SIZE_UNIT_GIGABYTE;
    public static final int DOWNLOAD_SIZE_UNIT_TERABYTE;
    public int downloadSizeUnit;
    public static final int ESTIMATED_UPDATE_DURATION_MIN;
    public int estimatedUpdateDuration;

    @Override
    public void setArrayHeader(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
    }

    @Override
    public ArrayHeader getArrayHeader() {
        return this.arrayHeader;
    }

    public OnlineUpdateList_Data(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
        this.updateId = new BAPString(21);
        this.updateDomain = new OnlineUpdateList_UpdateDomain();
        this.descriptionOnlineUpdate = new BAPString(3074);
        this.updatePrecondition = new OnlineUpdateList_UpdatePrecondition();
        this.internalReset();
        this.customInitialization();
    }

    public OnlineUpdateList_Data(BitStream bitStream, ArrayHeader arrayHeader) {
        this(arrayHeader);
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.pos = 0;
        this.language = 0;
        this.downloadSize = 0;
        this.downloadSizeUnit = 0;
        this.estimatedUpdateDuration = 1;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.arrayHeader.reset();
        this.updateId.reset();
        this.updateDomain.reset();
        this.descriptionOnlineUpdate.reset();
        this.updatePrecondition.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        OnlineUpdateList_Data onlineUpdateList_Data = (OnlineUpdateList_Data)bAPEntity;
        return this.arrayHeader.equalTo(onlineUpdateList_Data.arrayHeader) && this.pos == onlineUpdateList_Data.pos && this.updateId.equalTo(onlineUpdateList_Data.updateId) && this.updateDomain.equalTo(onlineUpdateList_Data.updateDomain) && this.descriptionOnlineUpdate.equalTo(onlineUpdateList_Data.descriptionOnlineUpdate) && this.language == onlineUpdateList_Data.language && this.updatePrecondition.equalTo(onlineUpdateList_Data.updatePrecondition) && this.downloadSize == onlineUpdateList_Data.downloadSize && this.downloadSizeUnit == onlineUpdateList_Data.downloadSizeUnit && this.estimatedUpdateDuration == onlineUpdateList_Data.estimatedUpdateDuration;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "OnlineUpdateList_Empty:";
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
                this.updateId.serialize(bitStream);
                this.updateDomain.serialize(bitStream);
                this.descriptionOnlineUpdate.serialize(bitStream);
                bitStream.pushByte((byte)this.language);
                this.updatePrecondition.serialize(bitStream);
                bitStream.pushShort((short)this.downloadSize);
                bitStream.pushByte((byte)this.downloadSizeUnit);
                bitStream.pushByte((byte)this.estimatedUpdateDuration);
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
                this.updateId.deserialize(bitStream);
                this.updateDomain.deserialize(bitStream);
                this.descriptionOnlineUpdate.deserialize(bitStream);
                this.language = bitStream.popFrontByte();
                this.updatePrecondition.deserialize(bitStream);
                this.downloadSize = bitStream.popFrontShort();
                this.downloadSizeUnit = bitStream.popFrontByte();
                this.estimatedUpdateDuration = bitStream.popFrontByte();
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

