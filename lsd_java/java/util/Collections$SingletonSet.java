/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Collections$2;
import java.util.Iterator;

final class Collections$SingletonSet
extends AbstractSet
implements Serializable {
    private static final long serialVersionUID;
    final Object element;

    Collections$SingletonSet(Object object) {
        this.element = object;
    }

    @Override
    public boolean contains(Object object) {
        return this.element == null ? object == null : this.element.equals(object);
    }

    @Override
    public int size() {
        return 1;
    }

    @Override
    public Iterator iterator() {
        return new Collections$2(this);
    }
}

