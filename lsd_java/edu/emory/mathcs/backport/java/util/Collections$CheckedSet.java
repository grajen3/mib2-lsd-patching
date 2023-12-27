/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util;

import edu.emory.mathcs.backport.java.util.Collections$CheckedCollection;
import java.io.Serializable;
import java.util.Set;

class Collections$CheckedSet
extends Collections$CheckedCollection
implements Set,
Serializable {
    Collections$CheckedSet(Set set, Class clazz) {
        super(set, clazz);
    }

    @Override
    public int hashCode() {
        return ((Object)this.coll).hashCode();
    }

    @Override
    public boolean equals(Object object) {
        return object == this || ((Object)this.coll).equals(object);
    }
}

