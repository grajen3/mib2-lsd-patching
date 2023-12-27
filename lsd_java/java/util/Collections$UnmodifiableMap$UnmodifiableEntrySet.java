/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.lang.reflect.Array;
import java.util.Collections$8;
import java.util.Collections$UnmodifiableSet;
import java.util.Iterator;
import java.util.Set;

class Collections$UnmodifiableMap$UnmodifiableEntrySet
extends Collections$UnmodifiableSet {
    private static final long serialVersionUID;

    Collections$UnmodifiableMap$UnmodifiableEntrySet(Set set) {
        super(set);
    }

    @Override
    public Iterator iterator() {
        return new Collections$8(this);
    }

    @Override
    public Object[] toArray() {
        int n = this.c.size();
        Object[] objectArray = new Object[n];
        Iterator iterator = this.iterator();
        int n2 = n;
        while (--n2 >= 0) {
            objectArray[n2] = iterator.next();
        }
        return objectArray;
    }

    @Override
    public Object[] toArray(Object[] objectArray) {
        int n = this.c.size();
        int n2 = 0;
        Iterator iterator = this.iterator();
        if (n > objectArray.length) {
            objectArray = (Object[])Array.newInstance(super.getClass().getComponentType(), n);
        }
        while (n2 < n) {
            objectArray[n2++] = iterator.next();
        }
        if (n2 < objectArray.length) {
            objectArray[n2] = null;
        }
        return objectArray;
    }
}

