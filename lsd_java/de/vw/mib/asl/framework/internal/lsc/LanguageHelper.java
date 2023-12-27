/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.lsc;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.impl.lsc.LscServicesProvider;
import de.vw.mib.collections.ints.IntArrayList;
import de.vw.mib.configuration.ConfigurationManagerDiag;
import java.util.ArrayList;
import java.util.List;

public final class LanguageHelper {
    public static boolean initialLscWasSent = false;
    public static boolean generalLanguageSkinChangeIsPending = false;
    public static boolean initialGuiLscDoneSoCorrectLanguageIsSetInGui = false;
    public static String lastRequestedLanguageForInstrumentCluster = "";
    private static final List LANGUAGE_ISO_CODES = new ArrayList();
    private static final IntArrayList MENU_LANGUAGES = new IntArrayList();
    private static final int INDEX_FOR_EN_GB;

    private LanguageHelper() {
    }

    public static int getMenuLanguage(String string) {
        int n = LanguageHelper.getMenuLanguage(string, -1);
        if (n == -1) {
            ServiceManager.logger.warn(1).append(": A Language ISO could not be handled for integer representation: ").append(string).append(" Using en_GB for InstrumentCluster").log();
            return 1;
        }
        return n;
    }

    public static int getMenuLanguage(String string, int n) {
        int n2 = LANGUAGE_ISO_CODES.indexOf(string);
        if (n2 == -1) {
            return n;
        }
        return MENU_LANGUAGES.get(n2);
    }

    public static String getIsoCodeOfMenuLanguage(int n) {
        if (n == 24) {
            return "zh_HK";
        }
        for (int i2 = 0; i2 < MENU_LANGUAGES.size(); ++i2) {
            if (MENU_LANGUAGES.get(i2) != n) continue;
            String string = (String)LANGUAGE_ISO_CODES.get(i2);
            return LanguageHelper.overrideLanguageForEnSa(string);
        }
        ServiceManager.logger.warn(1).append(": A Language instrument cluster code could not be handled for integer representation: ").append(n).append(" Using empty string as ISO code").log();
        return "";
    }

    public static String getIsoCodeOfLanguageIndex(int n) {
        if (n < LANGUAGE_ISO_CODES.size() && n >= 0) {
            return (String)LANGUAGE_ISO_CODES.get(n);
        }
        ServiceManager.logger.warn(1).append(": A Language instrument cluster code could not be handled for unique integer index: ").append(n).append(" Using empty string as ISO code").log();
        return "";
    }

    public static int getMenuLanguageOfLanguageIndex(int n) {
        if (n < MENU_LANGUAGES.size() && n >= 0) {
            return MENU_LANGUAGES.get(n);
        }
        ServiceManager.logger.warn(1).append(": A Language instrument cluster code could not be handled for unique integer index: ").append(n).append(" Using en_GB for InstrumentCluster").log();
        return 1;
    }

    public static int getLanguageIndexOfIsoCode(String string) {
        int n = LANGUAGE_ISO_CODES.indexOf(string);
        if (n == -1) {
            ServiceManager.logger.warn(64).append(": A Language ISO could not be handled for integer representation: ").append(string).append(" Using en_GB for InstrumentCluster").log();
            return INDEX_FOR_EN_GB;
        }
        return n;
    }

    public static int getNumberOfLanguages() {
        return LANGUAGE_ISO_CODES.size();
    }

    private static void addLanguageIdPair(String string, int n) {
        LANGUAGE_ISO_CODES.add(string);
        MENU_LANGUAGES.add(n);
    }

    private static String overrideLanguageForEnSa(String string) {
        ConfigurationManagerDiag configurationManagerDiag = LscServicesProvider.getLscServices().getConfigManagerDiag();
        if (configurationManagerDiag.isArabicReplacementActive() && "ar_SA".equals(string)) {
            string = "en_SA";
        }
        return string;
    }

    static {
        LanguageHelper.addLanguageIdPair("ar_SA", 25);
        LanguageHelper.addLanguageIdPair("ms_MY", 27);
        LanguageHelper.addLanguageIdPair("cs_CZ", 8);
        LanguageHelper.addLanguageIdPair("da_DK", 10);
        LanguageHelper.addLanguageIdPair("de_DE", 0);
        LanguageHelper.addLanguageIdPair("el_GR", 17);
        LanguageHelper.addLanguageIdPair("en_GB", 1);
        LanguageHelper.addLanguageIdPair("en_KR", 1);
        LanguageHelper.addLanguageIdPair("en_CN", 1);
        LanguageHelper.addLanguageIdPair("en_JP", 1);
        LanguageHelper.addLanguageIdPair("en_SA", 25);
        LanguageHelper.addLanguageIdPair("en_TW", 1);
        LanguageHelper.addLanguageIdPair("en_US", 2);
        LanguageHelper.addLanguageIdPair("es_ES", 5);
        LanguageHelper.addLanguageIdPair("es_MX", 20);
        LanguageHelper.addLanguageIdPair("fr_FR", 3);
        LanguageHelper.addLanguageIdPair("fr_CA", 19);
        LanguageHelper.addLanguageIdPair("ko_KR", 18);
        LanguageHelper.addLanguageIdPair("it_IT", 4);
        LanguageHelper.addLanguageIdPair("hr_HR", 30);
        LanguageHelper.addLanguageIdPair("hu_HU", 9);
        LanguageHelper.addLanguageIdPair("nl_NL", 13);
        LanguageHelper.addLanguageIdPair("ja_JP", 15);
        LanguageHelper.addLanguageIdPair("no_NO", 29);
        LanguageHelper.addLanguageIdPair("th_TH", 28);
        LanguageHelper.addLanguageIdPair("pl_PL", 7);
        LanguageHelper.addLanguageIdPair("pt_PT", 6);
        LanguageHelper.addLanguageIdPair("pt_BR", 26);
        LanguageHelper.addLanguageIdPair("ru_RU", 16);
        LanguageHelper.addLanguageIdPair("fi_FI", 12);
        LanguageHelper.addLanguageIdPair("sv_SE", 11);
        LanguageHelper.addLanguageIdPair("tr_TR", 22);
        LanguageHelper.addLanguageIdPair("zh_CN", 23);
        LanguageHelper.addLanguageIdPair("zh_TW", 14);
        LanguageHelper.addLanguageIdPair("zh_MO", 24);
        LanguageHelper.addLanguageIdPair("zh_HK", 24);
        LanguageHelper.addLanguageIdPair("bs_BA", 37);
        LanguageHelper.addLanguageIdPair("ro_RO", 33);
        LanguageHelper.addLanguageIdPair("sk_SK", 32);
        LanguageHelper.addLanguageIdPair("sl_SI", 38);
        LanguageHelper.addLanguageIdPair("sr_RS", 31);
        LanguageHelper.addLanguageIdPair("bg_BG", 39);
        LanguageHelper.addLanguageIdPair("lv_LV", 40);
        LanguageHelper.addLanguageIdPair("et_EE", 41);
        LanguageHelper.addLanguageIdPair("lt_LT", 42);
        LanguageHelper.addLanguageIdPair("uk_UA", 43);
        INDEX_FOR_EN_GB = LanguageHelper.getLanguageIndexOfIsoCode("en_GB");
    }
}

