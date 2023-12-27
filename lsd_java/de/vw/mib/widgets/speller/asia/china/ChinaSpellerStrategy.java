/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia.china;

import de.vw.mib.properties.values.SpellerData;
import de.vw.mib.widgets.AsiaSpeller;
import de.vw.mib.widgets.FeatureToggles;
import de.vw.mib.widgets.speller.asia.AsiaInputInitializer;
import de.vw.mib.widgets.speller.asia.DefaultAsiaSpellerStrategy;
import de.vw.mib.widgets.speller.asia.china.ChinaAsiaInputInitializer;
import de.vw.mib.widgets.speller.asia.china.ChinaAsiaInputInitializer$Builder;

public final class ChinaSpellerStrategy
extends DefaultAsiaSpellerStrategy {
    private ChinaAsiaInputInitializer asiaInputInitializer;

    public ChinaSpellerStrategy(AsiaSpeller asiaSpeller) {
        super(asiaSpeller);
    }

    @Override
    public void alphabetIndexChanged(int n) {
        if (this.asiaInputInitializer != null) {
            ChinaAsiaInputInitializer$Builder chinaAsiaInputInitializer$Builder = (ChinaAsiaInputInitializer$Builder)new ChinaAsiaInputInitializer$Builder(this.asiaInputInitializer).firstLetter(this.asiaSpeller.is_firstLetterInput()).nameInput(this.asiaSpeller.is_nameInput()).userDatabase(this.asiaSpeller.is_userDatabaseEnabled()).wordDatabaseNames(this.asiaSpeller.getWordDatabaseNames());
            this.asiaInputInitializer = this.initBuilder(chinaAsiaInputInitializer$Builder).renew();
        }
    }

    @Override
    public void firstLetterInputChanged(boolean bl) {
        if (this.asiaInputInitializer != null) {
            this.asiaInputInitializer = new ChinaAsiaInputInitializer$Builder(this.asiaInputInitializer).firstLetter(this.asiaSpeller.is_firstLetterInput()).renew();
        }
    }

    @Override
    public AsiaInputInitializer getAsiaInputInitializer() {
        if (this.asiaInputInitializer == null) {
            ChinaAsiaInputInitializer$Builder chinaAsiaInputInitializer$Builder = (ChinaAsiaInputInitializer$Builder)new ChinaAsiaInputInitializer$Builder().firstLetter(this.asiaSpeller.is_firstLetterInput()).nameInput(this.asiaSpeller.is_nameInput()).userDatabase(this.asiaSpeller.is_userDatabaseEnabled()).wordDatabaseNames(this.asiaSpeller.getWordDatabaseNames());
            this.asiaInputInitializer = this.initBuilder(chinaAsiaInputInitializer$Builder).build();
        }
        return this.asiaInputInitializer;
    }

    private ChinaAsiaInputInitializer$Builder initBuilder(ChinaAsiaInputInitializer$Builder chinaAsiaInputInitializer$Builder) {
        if (this.asiaSpeller.isInPinyinAlphabet() || !FeatureToggles.isFeatureToggleEnabled("de.vw.mib.widgets.asiaspeller.permanent.conversion.disabled") && this.asiaSpeller.isInLatinAlphabet() && this.asiaSpeller.isSpellerLanguage("zh_CN")) {
            chinaAsiaInputInitializer$Builder.inputMode(2);
        } else if (this.asiaSpeller.isInZhuyinAlphabet() || !FeatureToggles.isFeatureToggleEnabled("de.vw.mib.widgets.asiaspeller.permanent.conversion.disabled") && this.asiaSpeller.isInLatinAlphabet() && this.asiaSpeller.isSpellerLanguage("zh_TW")) {
            chinaAsiaInputInitializer$Builder.inputMode(0);
        }
        if (this.asiaSpeller.isInPinyinAlphabet() && this.asiaSpeller.isSpellerLanguage("zh_HK")) {
            chinaAsiaInputInitializer$Builder.type(1);
        } else if (this.asiaSpeller.isInZhuyinAlphabet() || this.asiaSpeller.isInSpecialAlphabet(5) || this.asiaSpeller.isInLatinAlphabet() && this.asiaSpeller.isSpellerLanguage("zh_TW")) {
            chinaAsiaInputInitializer$Builder.type(4);
        }
        return chinaAsiaInputInitializer$Builder;
    }

    @Override
    public void nameInputChanged(boolean bl) {
        if (this.asiaInputInitializer != null) {
            this.asiaInputInitializer = new ChinaAsiaInputInitializer$Builder(this.asiaInputInitializer).nameInput(this.asiaSpeller.is_nameInput()).renew();
        }
    }

    @Override
    public void spellerDataChanged(SpellerData spellerData) {
        SpellerData spellerData2 = this.asiaSpeller.get_spellerData();
        if (spellerData2 != null) {
            this.asiaSpeller.setWordDatabaseNames(spellerData2.getWordDatabaseNames());
        }
    }

    @Override
    public void userDatabaseEnabledChanged(boolean bl) {
        if (this.asiaInputInitializer != null) {
            this.asiaInputInitializer = ((ChinaAsiaInputInitializer$Builder)new ChinaAsiaInputInitializer$Builder(this.asiaInputInitializer).userDatabase(this.asiaSpeller.is_userDatabaseEnabled())).renew();
        }
    }

    @Override
    public void wordDatabaseNamesChanged(String[] stringArray) {
        if (this.asiaInputInitializer != null) {
            this.asiaInputInitializer = ((ChinaAsiaInputInitializer$Builder)new ChinaAsiaInputInitializer$Builder(this.asiaInputInitializer).wordDatabaseNames(this.asiaSpeller.getWordDatabaseNames())).renew();
        }
    }
}

