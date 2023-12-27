/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.cio.internal;

import de.vw.mib.cio.internal.AbstractCio;
import java.util.Comparator;

final class Dictionary$DictionaryEntry$1
implements Comparator {
    Dictionary$DictionaryEntry$1() {
    }

    @Override
    public int compare(Object object, Object object2) {
        if (object == null || object2 == null) {
            return 0;
        }
        int n = ((AbstractCio)object).getRank();
        int n2 = ((AbstractCio)object2).getRank();
        if (n == -1) {
            if (n2 == -1) {
                return 0;
            }
            return 1;
        }
        if (n2 == -1) {
            return -1;
        }
        return n - n2;
    }
}

