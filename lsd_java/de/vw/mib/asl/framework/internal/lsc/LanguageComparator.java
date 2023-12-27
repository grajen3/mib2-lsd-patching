/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.lsc;

import de.vw.mib.collections.ObjectIntMap;
import de.vw.mib.collections.ObjectIntOptHashMap;
import java.util.Comparator;

public final class LanguageComparator
implements Comparator {
    public static final Comparator LANGUAGE_COMPARATOR = new LanguageComparator();
    private final ObjectIntMap languageOrder = new ObjectIntOptHashMap();

    private LanguageComparator() {
        this.addLanguage("ar_SA");
        this.addLanguage("bg_BG");
        this.addLanguage("bs_BA");
        this.addLanguage("cs_CZ");
        this.addLanguage("da_DK");
        this.addLanguage("de_DE");
        this.addLanguage("et_EE");
        this.addLanguage("el_GR");
        this.addLanguage("en_GB");
        this.addLanguage("en_US");
        this.addLanguage("en_SA");
        this.addLanguage("es_ES");
        this.addLanguage("es_MX");
        this.addLanguage("fr_FR");
        this.addLanguage("fr_CA");
        this.addLanguage("ko_KR");
        this.addLanguage("hi_IN");
        this.addLanguage("hr_HR");
        this.addLanguage("it_IT");
        this.addLanguage("he_IL");
        this.addLanguage("lv_LV");
        this.addLanguage("lt_LT");
        this.addLanguage("hu_HU");
        this.addLanguage("nl_NL");
        this.addLanguage("ja_JP");
        this.addLanguage("no_NO");
        this.addLanguage("th_TH");
        this.addLanguage("pl_PL");
        this.addLanguage("pt_PT");
        this.addLanguage("pt_BR");
        this.addLanguage("ro_RO");
        this.addLanguage("ru_RU");
        this.addLanguage("sk_SK");
        this.addLanguage("sl_SI");
        this.addLanguage("sr_RS");
        this.addLanguage("fi_FI");
        this.addLanguage("sv_SE");
        this.addLanguage("tr_TR");
        this.addLanguage("uk_UA");
        this.addLanguage("zh_CN");
        this.addLanguage("zh_TW");
        this.addLanguage("zh_HK");
    }

    @Override
    public int compare(Object object, Object object2) {
        int n = this.languageOrder.get(object);
        int n2 = this.languageOrder.get(object2);
        return n - n2;
    }

    private void addLanguage(String string) {
        this.languageOrder.put(string, this.languageOrder.size());
    }
}

