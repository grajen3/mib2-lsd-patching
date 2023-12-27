/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia.japan;

import de.vw.mib.properties.values.SpellerData;
import de.vw.mib.widgets.AsiaSpeller;
import de.vw.mib.widgets.FeatureToggles;
import de.vw.mib.widgets.speller.asia.AsiaInputInitializer;
import de.vw.mib.widgets.speller.asia.DefaultAsiaSpellerStrategy;
import de.vw.mib.widgets.speller.asia.japan.JapanAsiaInputInitializer;
import de.vw.mib.widgets.speller.asia.japan.JapanAsiaInputInitializer$Builder;

public final class JapanSpellerStrategy
extends DefaultAsiaSpellerStrategy {
    private JapanAsiaInputInitializer asiaInputInitializer;

    public JapanSpellerStrategy(AsiaSpeller asiaSpeller) {
        super(asiaSpeller);
    }

    @Override
    public void alphabetIndexChanged(int n) {
        if (this.asiaInputInitializer != null) {
            JapanAsiaInputInitializer$Builder japanAsiaInputInitializer$Builder = (JapanAsiaInputInitializer$Builder)new JapanAsiaInputInitializer$Builder(this.asiaInputInitializer).userDatabase(this.asiaSpeller.is_userDatabaseEnabled()).wordDatabaseNames(this.asiaSpeller.getWordDatabaseNames());
            this.asiaInputInitializer = this.initBuilder(japanAsiaInputInitializer$Builder).renew();
        }
    }

    @Override
    public AsiaInputInitializer getAsiaInputInitializer() {
        if (this.asiaInputInitializer == null) {
            JapanAsiaInputInitializer$Builder japanAsiaInputInitializer$Builder = (JapanAsiaInputInitializer$Builder)new JapanAsiaInputInitializer$Builder().userDatabase(this.asiaSpeller.is_userDatabaseEnabled()).wordDatabaseNames(this.asiaSpeller.getWordDatabaseNames());
            this.asiaInputInitializer = this.initBuilder(japanAsiaInputInitializer$Builder).build();
        }
        return this.asiaInputInitializer;
    }

    private JapanAsiaInputInitializer$Builder initBuilder(JapanAsiaInputInitializer$Builder japanAsiaInputInitializer$Builder) {
        if (this.asiaSpeller.isInHiraganaAlphabet() || !FeatureToggles.isFeatureToggleEnabled("de.vw.mib.widgets.asiaspeller.permanent.conversion.disabled") && this.asiaSpeller.isInLatinAlphabet() && this.asiaSpeller.isSpellerLanguage("ja_JP")) {
            japanAsiaInputInitializer$Builder.inputMode(9);
        }
        return japanAsiaInputInitializer$Builder;
    }

    @Override
    public void nameInputChanged(boolean bl) {
        if (this.asiaInputInitializer != null) {
            this.asiaInputInitializer = new JapanAsiaInputInitializer$Builder(this.asiaInputInitializer).nameInput(this.asiaSpeller.is_nameInput()).renew();
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
            this.asiaInputInitializer = ((JapanAsiaInputInitializer$Builder)new JapanAsiaInputInitializer$Builder(this.asiaInputInitializer).userDatabase(this.asiaSpeller.is_userDatabaseEnabled())).renew();
        }
    }

    @Override
    public void wordDatabaseNamesChanged(String[] stringArray) {
        if (this.asiaInputInitializer != null) {
            this.asiaInputInitializer = ((JapanAsiaInputInitializer$Builder)new JapanAsiaInputInitializer$Builder(this.asiaInputInitializer).wordDatabaseNames(this.asiaSpeller.getWordDatabaseNames())).renew();
        }
    }
}

