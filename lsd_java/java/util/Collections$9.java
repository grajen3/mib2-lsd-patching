/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;

final class Collections$9
implements Enumeration {
    Iterator it;

    Collections$9(Collection collection) {
        this.it = collection.iterator();
    }

    @Override
    public boolean hasMoreElements() {
        return this.it.hasNext();
    }

    @Override
    public Object nextElement() {
        return this.it.next();
    }
}

