/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.speller.filter;

import de.vw.mib.speller.filter.SpellerFilterListener;

public interface SpellerFilter {
    public static final String OSGI_PROPERTY_FILTERID;

    default public void filterCharacters(String[] stringArray) {
    }

    default public void initFilter(SpellerFilterListener spellerFilterListener) {
    }

    default public void releaseFilter() {
    }
}

