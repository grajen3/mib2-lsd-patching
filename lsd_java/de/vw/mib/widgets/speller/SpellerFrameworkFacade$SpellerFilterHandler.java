/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller;

import de.vw.mib.speller.filter.SpellerFilterListenerAdapter;
import de.vw.mib.widgets.controller.AsiaSpellerController;
import de.vw.mib.widgets.speller.SpellerFrameworkFacade;
import java.util.Arrays;

final class SpellerFrameworkFacade$SpellerFilterHandler
extends SpellerFilterListenerAdapter {
    private final AsiaSpellerController controller;
    private String[] noneFilteredCharacters;
    private final /* synthetic */ SpellerFrameworkFacade this$0;

    public SpellerFrameworkFacade$SpellerFilterHandler(SpellerFrameworkFacade spellerFrameworkFacade, AsiaSpellerController asiaSpellerController) {
        this.this$0 = spellerFrameworkFacade;
        this.controller = asiaSpellerController;
        this.noneFilteredCharacters = new String[0];
    }

    @Override
    public void setFilteredCharacters(String[] stringArray) {
        if (this.this$0.isTraceEnabled()) {
            this.this$0.trace().append("Filtered characters [").append(edu.emory.mathcs.backport.java.util.Arrays.toString(stringArray)).append("] out of [").append(edu.emory.mathcs.backport.java.util.Arrays.toString(this.noneFilteredCharacters)).append("]").log();
        }
        if (this.controller != null) {
            this.controller.onCharactersFiltered(stringArray, this.noneFilteredCharacters, !Arrays.equals(stringArray, this.noneFilteredCharacters));
        } else {
            this.this$0.warn().append("Unable to notify about filtered characters.").log();
        }
    }

    public void setNoneFilteredCharacters(String[] stringArray) {
        this.noneFilteredCharacters = stringArray;
    }
}

