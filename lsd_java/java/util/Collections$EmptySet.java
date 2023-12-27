/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Collections$1;
import java.util.Iterator;

final class Collections$EmptySet
extends AbstractSet
implements Serializable {
    private static final long serialVersionUID;

    Collections$EmptySet() {
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
    public Iterator iterator() {
        return new Collections$1(this);
    }
}

