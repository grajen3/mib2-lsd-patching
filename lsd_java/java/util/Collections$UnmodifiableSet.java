/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.Collections$UnmodifiableCollection;
import java.util.Set;

class Collections$UnmodifiableSet
extends Collections$UnmodifiableCollection
implements Set {
    private static final long serialVersionUID;

    Collections$UnmodifiableSet(Set set) {
        super(set);
    }

    @Override
    public boolean equals(Object object) {
        return this.c.equals(object);
    }

    @Override
    public int hashCode() {
        return this.c.hashCode();
    }
}

