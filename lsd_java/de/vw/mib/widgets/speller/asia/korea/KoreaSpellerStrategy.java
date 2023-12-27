/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia.korea;

import de.vw.mib.widgets.AsiaSpeller;
import de.vw.mib.widgets.speller.asia.DefaultAsiaSpellerStrategy;
import de.vw.mib.widgets.speller.asia.korea.Jamo;

public final class KoreaSpellerStrategy
extends DefaultAsiaSpellerStrategy {
    public KoreaSpellerStrategy(AsiaSpeller asiaSpeller) {
        super(asiaSpeller);
    }

    @Override
    public int getCursorPosition() {
        String string = this.asiaSpeller.get_spellerData() != null ? this.asiaSpeller.get_spellerData().getEnteredText() : "";
        int n = this.asiaSpeller.get_spellerData() != null ? this.asiaSpeller.get_spellerData().getCursorPosition() : 0;
        return Jamo.asHangeuls(string.substring(0, n), "").length();
    }

    @Override
    public String getEnteredText() {
        String string = this.asiaSpeller.get_spellerData() != null ? this.asiaSpeller.get_spellerData().getEnteredText() : "";
        return Jamo.asCompatibilityJamos(Jamo.asHangeuls(string, ""));
    }
}

