/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.io.Serializable;
import java.util.AbstractList;

final class Collections$EmptyList
extends AbstractList
implements Serializable {
    private static final long serialVersionUID;

    Collections$EmptyList() {
    }

    @Override
    public boolean contains(Object object) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Object get(int n) {
        throw new IndexOutOfBoundsException();
    }
}

