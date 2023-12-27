/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

public class LinkedHashSet
extends HashSet
implements Set,
Cloneable,
Serializable {
    private static final long serialVersionUID;

    public LinkedHashSet() {
        super(new LinkedHashMap());
    }

    public LinkedHashSet(int n) {
        super(new LinkedHashMap(n));
    }

    public LinkedHashSet(int n, float f2) {
        super(new LinkedHashMap(n, f2));
    }

    public LinkedHashSet(Collection collection) {
        super(new LinkedHashMap(collection.size() < 6 ? 11 : collection.size() * 2));
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            this.add(iterator.next());
        }
    }

    @Override
    HashMap createBackingMap(int n, float f2) {
        return new LinkedHashMap(n, f2);
    }
}

