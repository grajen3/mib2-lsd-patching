/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.sdssd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.stream.BitStream;

public final class SDS_ContextState_Status$AdditionalInfo
implements BAPEntity {
    public int additionalInfoType;
    public static final int ADDITIONAL_INFO_TYPE_NO_ADDITIONAL_INFORMATION;
    public static final int ADDITIONAL_INFO_TYPE_ADDRESS;
    public static final int ADDITIONAL_INFO_TYPE_COUNTRY;
    public static final int ADDITIONAL_INFO_TYPE_STATE;
    public static final int ADDITIONAL_INFO_TYPE_CITY;
    public static final int ADDITIONAL_INFO_TYPE_ZIP_CODE;
    public static final int ADDITIONAL_INFO_TYPE_STREET;
    public static final int ADDITIONAL_INFO_TYPE_CROSSING;
    public static final int ADDITIONAL_INFO_TYPE_HOUSE_NUMBER;
    public static final int ADDITIONAL_INFO_TYPE_DESTINATION;
    public static final int ADDITIONAL_INFO_TYPE_CITY_STREET_HOUSE_NUMBER;
    public static final int ADDITIONAL_INFO_TYPE_CITY_HOUSE_NUMBER;
    public static final int ADDITIONAL_INFO_TYPE_CITY_DISTRICT;
    public static final int ADDITIONAL_INFO_TYPE_COUNTRY_STATE;
    public static final int ADDITIONAL_INFO_TYPE_STREET_HOUSENUMBER;
    public static final int ADDITIONAL_INFO_TYPE_SEARCH_AREA;
    public static final int ADDITIONAL_INFO_TYPE_NAME;
    public static final int ADDITIONAL_INFO_TYPE_CONTACT;
    public static final int ADDITIONAL_INFO_TYPE_POI;
    public static final int ADDITIONAL_INFO_TYPE_ONLINE_POI;
    public static final int ADDITIONAL_INFO_TYPE_POI_CATEGORIE;
    public static final int ADDITIONAL_INFO_TYPE_BAND;
    public static final int ADDITIONAL_INFO_TYPE_RADIO_STATION;
    public static final int ADDITIONAL_INFO_TYPE_FREQUENCY;
    public static final int ADDITIONAL_INFO_TYPE_MEDIA_SOURCE;
    public static final int ADDITIONAL_INFO_TYPE_ALBUM;
    public static final int ADDITIONAL_INFO_TYPE_ARTIST;
    public static final int ADDITIONAL_INFO_TYPE_PLAYLIST;
    public static final int ADDITIONAL_INFO_TYPE_GENRE;
    public static final int ADDITIONAL_INFO_TYPE_PARTITION;
    public static final int ADDITIONAL_INFO_TYPE_DISK;
    public static final int ADDITIONAL_INFO_TYPE_TELEPHONE_NUMBER;
    public static final int ADDITIONAL_INFO_TYPE_TELEPHONE_NUMBER_TYPE;
    public static final int ADDITIONAL_INFO_TYPE_CALL_STACK;
    public static final int ADDITIONAL_INFO_TYPE_MISSED_CALLS;
    public static final int ADDITIONAL_INFO_TYPE_DIALED_NUMBERS;
    public static final int ADDITIONAL_INFO_TYPE_ACCEPTED_CALLS;
    public static final int ADDITIONAL_INFO_TYPE_MESSAGE;
    public static final int ADDITIONAL_INFO_TYPE_MAILBOX;
    public static final int ADDITIONAL_INFO_TYPE_HOMEADDRESS;
    public static final int ADDITIONAL_INFO_TYPE_LAST_DESTINATION;
    public static final int ADDITIONAL_INFO_TYPE_ROUTE;
    public static final int ADDITIONAL_INFO_TYPE_TUTORIAL;
    public static final int ADDITIONAL_INFO_TYPE_DIALOG_CONTROL;
    public static final int ADDITIONAL_INFO_TYPE_HELP_SYSTEM;
    public static final int ADDITIONAL_INFO_TYPE_VOICE_BUTTON;
    public static final int ADDITIONAL_INFO_TYPE_MEDIA_CONTROL;
    public static final int ADDITIONAL_INFO_TYPE_MESSAGE_DICTATION;
    public static final int ADDITIONAL_INFO_TYPE_POI_SEARCH_AREA;
    public static final int ADDITIONAL_INFO_TYPE_POI_CATEGORIE_SEARCH_AREA;
    public static final int ADDITIONAL_INFO_TYPE_POI_ONLINE_SEARCH;
    public static final int ADDITIONAL_INFO_TYPE_FULL_ADDRESS;
    public static final int ADDITIONAL_INFO_TYPE_HOUSENUMBER_REQUEST;
    public static final int ADDITIONAL_INFO_TYPE_NO_HOUSENUMBER;
    public static final int ADDITIONAL_INFO_TYPE_ADDITIONAL_TEXT;
    public final BAPString additionalText = new BAPString(91);
    private static final int MAX_ADDITIONAL_TEXT_LENGTH;

    public SDS_ContextState_Status$AdditionalInfo() {
        this.internalReset();
        this.customInitialization();
    }

    public SDS_ContextState_Status$AdditionalInfo(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.additionalInfoType = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.additionalText.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        SDS_ContextState_Status$AdditionalInfo sDS_ContextState_Status$AdditionalInfo = (SDS_ContextState_Status$AdditionalInfo)bAPEntity;
        return this.additionalInfoType == sDS_ContextState_Status$AdditionalInfo.additionalInfoType && this.additionalText.equalTo(sDS_ContextState_Status$AdditionalInfo.additionalText);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "AdditionalInfo:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushShort((short)this.additionalInfoType);
        this.additionalText.serialize(bitStream);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }
}

