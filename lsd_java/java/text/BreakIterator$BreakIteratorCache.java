/*
 * Decompiled with CFR 0.152.
 */
package java.text;

import java.text.BreakIterator;
import java.util.Locale;

final class BreakIterator$BreakIteratorCache {
    private BreakIterator iter;
    private Locale where;

    BreakIterator$BreakIteratorCache(Locale locale, BreakIterator breakIterator) {
        this.where = locale;
        this.iter = (BreakIterator)breakIterator.clone();
    }

    Locale getLocale() {
        return this.where;
    }

    BreakIterator createBreakInstance() {
        return (BreakIterator)this.iter.clone();
    }
}

