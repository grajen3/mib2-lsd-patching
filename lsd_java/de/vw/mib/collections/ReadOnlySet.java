/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections;

import de.vw.mib.collections.ReadOnlyCollection;
import java.util.Collection;
import java.util.Set;

public class ReadOnlySet
extends ReadOnlyCollection
implements Set {
    public ReadOnlySet(Collection collection) {
        super(collection);
    }
}

