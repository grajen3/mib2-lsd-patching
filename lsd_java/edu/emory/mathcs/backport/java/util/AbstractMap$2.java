/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util;

import edu.emory.mathcs.backport.java.util.AbstractMap$1;
import java.util.Iterator;
import java.util.Map$Entry;

class AbstractMap$2
implements Iterator {
    final Iterator itr;
    private final /* synthetic */ AbstractMap$1 this$1;

    AbstractMap$2(AbstractMap$1 abstractMap$1) {
        this.this$1 = abstractMap$1;
        this.itr = AbstractMap$1.access$000(this.this$1).entrySet().iterator();
    }

    @Override
    public boolean hasNext() {
        return this.itr.hasNext();
    }

    @Override
    public Object next() {
        return ((Map$Entry)this.itr.next()).getKey();
    }

    @Override
    public void remove() {
        this.itr.remove();
    }
}

