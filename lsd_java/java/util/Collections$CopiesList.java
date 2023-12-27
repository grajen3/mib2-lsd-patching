/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.io.Serializable;
import java.util.AbstractList;

final class Collections$CopiesList
extends AbstractList
implements Serializable {
    private static final long serialVersionUID;
    private final int n;
    private final Object element;

    Collections$CopiesList(int n, Object object) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        this.n = n;
        this.element = object;
    }

    @Override
    public boolean contains(Object object) {
        return this.element == null ? object == null : this.element.equals(object);
    }

    @Override
    public int size() {
        return this.n;
    }

    @Override
    public Object get(int n) {
        if (n >= 0 && n < this.n) {
            return this.element;
        }
        throw new IndexOutOfBoundsException();
    }
}

