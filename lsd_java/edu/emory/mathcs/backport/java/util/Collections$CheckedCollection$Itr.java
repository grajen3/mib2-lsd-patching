/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util;

import edu.emory.mathcs.backport.java.util.Collections$CheckedCollection;
import java.util.Iterator;

class Collections$CheckedCollection$Itr
implements Iterator {
    final Iterator itr;
    private final /* synthetic */ Collections$CheckedCollection this$0;

    Collections$CheckedCollection$Itr(Collections$CheckedCollection collections$CheckedCollection, Iterator iterator) {
        this.this$0 = collections$CheckedCollection;
        this.itr = iterator;
    }

    @Override
    public boolean hasNext() {
        return this.itr.hasNext();
    }

    @Override
    public Object next() {
        return this.itr.next();
    }

    @Override
    public void remove() {
        this.itr.remove();
    }
}

