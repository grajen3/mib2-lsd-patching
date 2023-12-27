/*
 * Decompiled with CFR 0.152.
 */
package java.lang;

import java.io.Serializable;
import java.util.Comparator;

final class String$CaseInsensitiveComparator
implements Comparator,
Serializable {
    static final long serialVersionUID;

    String$CaseInsensitiveComparator() {
    }

    @Override
    public int compare(Object object, Object object2) {
        return ((String)object).compareToIgnoreCase((String)object2);
    }
}

