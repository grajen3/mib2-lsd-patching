/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections;

import de.vw.mib.collections.ObjectReadOnlyCollection;
import de.vw.mib.collections.ObjectSet;

public class ObjectReadOnlySet
extends ObjectReadOnlyCollection
implements ObjectSet {
    public ObjectReadOnlySet(ObjectSet objectSet) {
        super(objectSet);
    }

    @Override
    public ObjectSet synchronize() {
        return new ObjectReadOnlySet(((ObjectSet)this.backing).synchronize());
    }

    @Override
    public Object get(Object object) {
        return ((ObjectSet)this.backing).get(object);
    }
}

