/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

final class Collections$EmptyMap
extends AbstractMap
implements Serializable {
    private static final long serialVersionUID;

    Collections$EmptyMap() {
    }

    @Override
    public boolean containsKey(Object object) {
        return false;
    }

    @Override
    public boolean containsValue(Object object) {
        return false;
    }

    @Override
    public Set entrySet() {
        return Collections.EMPTY_SET;
    }

    @Override
    public Object get(Object object) {
        return null;
    }

    @Override
    public Set keySet() {
        return Collections.EMPTY_SET;
    }

    @Override
    public Collection values() {
        return Collections.EMPTY_LIST;
    }
}

