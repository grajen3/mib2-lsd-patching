/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia;

import de.vw.mib.properties.values.SpellerData;
import de.vw.mib.util.StringBuilder;
import de.vw.mib.widgets.AsiaSpeller;
import de.vw.mib.widgets.speller.asia.AsiaInputInitializer;

public class DefaultAsiaSpellerStrategy {
    protected final AsiaSpeller asiaSpeller;

    public DefaultAsiaSpellerStrategy(AsiaSpeller asiaSpeller) {
        this.asiaSpeller = asiaSpeller;
    }

    public void alphabetIndexChanged(int n) {
    }

    public void firstLetterInputChanged(boolean bl) {
    }

    public AsiaInputInitializer getAsiaInputInitializer() {
        return null;
    }

    public int getCursorPosition() {
        int n = 0;
        SpellerData spellerData = this.asiaSpeller.get_spellerData();
        if (spellerData != null) {
            n = this.asiaSpeller.getSpelling() != null && this.asiaSpeller.getSpelling().length() > 0 ? this.asiaSpeller.getSpellingPosition() + this.asiaSpeller.getSpelling().length() : spellerData.getCursorPosition();
        }
        return n;
    }

    public String getEnteredText() {
        SpellerData spellerData = this.asiaSpeller.get_spellerData();
        StringBuilder stringBuilder = new StringBuilder();
        if (spellerData != null) {
            String string = spellerData.getEnteredText();
            if (string != null && string.length() > 0) {
                stringBuilder.append(string.substring(0, Math.min(this.asiaSpeller.getSpellingPosition(), string.length())));
                stringBuilder.append(this.asiaSpeller.getSpelling());
                stringBuilder.append(string.substring(Math.min(this.asiaSpeller.getSpellingPosition(), string.length())));
            } else {
                stringBuilder.append(this.asiaSpeller.getSpelling());
            }
        }
        return stringBuilder.toString();
    }

    public int getSelectionEnd() {
        int n = 0;
        SpellerData spellerData = this.asiaSpeller.get_spellerData();
        if (spellerData != null) {
            if (spellerData.isSelectionActive()) {
                n = spellerData.getSelectionEnd();
            } else if (this.asiaSpeller.getSpelling() != null && this.asiaSpeller.getSpelling().length() > 0) {
                n = this.asiaSpeller.getSpellingPosition() + this.asiaSpeller.getSpelling().length();
            }
        }
        return n;
    }

    public int getSelectionStart() {
        int n = 0;
        SpellerData spellerData = this.asiaSpeller.get_spellerData();
        if (spellerData != null) {
            if (spellerData.isSelectionActive()) {
                n = spellerData.getSelectionStart();
            } else if (this.asiaSpeller.getSpelling() != null && this.asiaSpeller.getSpelling().length() > 0) {
                n = this.asiaSpeller.getSpellingPosition();
            }
        }
        return n;
    }

    public void nameInputChanged(boolean bl) {
    }

    public void spellerDataChanged(SpellerData spellerData) {
    }

    public void userDatabaseEnabledChanged(boolean bl) {
    }

    public void wordDatabaseNamesChanged(String[] stringArray) {
    }
}

