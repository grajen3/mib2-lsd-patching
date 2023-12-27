/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public abstract class AbstractSet
extends AbstractCollection
implements Set {
    protected AbstractSet() {
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof Set) {
            Set set = (Set)object;
            return this.size() == set.size() && this.containsAll(set);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int n = 0;
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            Object object = iterator.next();
            n += object == null ? 0 : object.hashCode();
        }
        return n;
    }

    @Override
    public boolean removeAll(Collection collection) {
        boolean bl = false;
        if (this.size() <= collection.size()) {
            Iterator iterator = this.iterator();
            while (iterator.hasNext()) {
                if (!collection.contains(iterator.next())) continue;
                iterator.remove();
                bl = true;
            }
        } else {
            Iterator iterator = collection.iterator();
            while (iterator.hasNext()) {
                boolean bl2 = bl = this.remove(iterator.next()) || bl;
            }
        }
        return bl;
    }
}

