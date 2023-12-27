/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections;

import de.vw.mib.collections.ObjectCollection;
import java.util.Set;

public interface ObjectSet
extends ObjectCollection,
Set {
    default public ObjectSet synchronize() {
    }

    default public Object get(Object object) {
    }
}

