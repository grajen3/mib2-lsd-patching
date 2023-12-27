/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.generated.eni.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.stream.BitStream;

public final class OnlineUpdateState_Deprecated_UpdateInfo
implements BAPEntity {
    private static final int MAX_TEXT_LENGTH;
    public final BAPString text = new BAPString(3074);
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

    public OnlineUpdateState_Deprecated_UpdateInfo() {
        this.internalReset();
        this.customInitialization();
    }

    public OnlineUpdateState_Deprecated_UpdateInfo(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.language = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.text.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        OnlineUpdateState_Deprecated_UpdateInfo onlineUpdateState_Deprecated_UpdateInfo = (OnlineUpdateState_Deprecated_UpdateInfo)bAPEntity;
        return this.text.equalTo(onlineUpdateState_Deprecated_UpdateInfo.text) && this.language == onlineUpdateState_Deprecated_UpdateInfo.language;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "OnlineUpdateState_Deprecated_Empty:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        this.text.serialize(bitStream);
        bitStream.pushByte((byte)this.language);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.text.deserialize(bitStream);
        this.language = bitStream.popFrontByte();
    }
}

