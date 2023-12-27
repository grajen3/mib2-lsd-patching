/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.io.Serializable;
import java.util.AbstractList;

final class Collections$SingletonList
extends AbstractList
implements Serializable {
    private static final long serialVersionUID;
    final Object element;

    Collections$SingletonList(Object object) {
        this.element = object;
    }

    @Override
    public boolean contains(Object object) {
        return this.element == null ? object == null : this.element.equals(object);
    }

    @Override
    public Object get(int n) {
        if (n == 0) {
            return this.element;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public int size() {
        return 1;
    }
}

