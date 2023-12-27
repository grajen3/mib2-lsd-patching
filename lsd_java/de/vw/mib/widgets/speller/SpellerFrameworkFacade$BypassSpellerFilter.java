/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller;

import de.vw.mib.speller.filter.SpellerFilterAdapter;
import de.vw.mib.speller.filter.SpellerFilterListener;

final class SpellerFrameworkFacade$BypassSpellerFilter
extends SpellerFilterAdapter {
    private SpellerFilterListener listener;

    @Override
    public void filterCharacters(String[] stringArray) {
        this.listener.setFilteredCharacters(stringArray);
    }

    @Override
    public void initFilter(SpellerFilterListener spellerFilterListener) {
        this.listener = spellerFilterListener;
    }

    @Override
    public void releaseFilter() {
        this.listener = null;
    }
}

