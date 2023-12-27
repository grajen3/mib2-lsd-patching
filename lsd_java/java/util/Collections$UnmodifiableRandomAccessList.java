/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.Collections$UnmodifiableList;
import java.util.List;
import java.util.RandomAccess;

class Collections$UnmodifiableRandomAccessList
extends Collections$UnmodifiableList
implements RandomAccess {
    private static final long serialVersionUID;

    Collections$UnmodifiableRandomAccessList(List list) {
        super(list);
    }

    @Override
    public List subList(int n, int n2) {
        return new Collections$UnmodifiableRandomAccessList(this.list.subList(n, n2));
    }

    private Object writeReplace() {
        return new Collections$UnmodifiableList(this.list);
    }
}

