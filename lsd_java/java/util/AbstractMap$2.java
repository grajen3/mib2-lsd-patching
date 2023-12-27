/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.AbstractMap$1;
import java.util.Iterator;
import java.util.Map$Entry;

final class AbstractMap$2
implements Iterator {
    Iterator setIterator;
    final /* synthetic */ AbstractMap$1 this$1;

    AbstractMap$2(AbstractMap$1 abstractMap$1) {
        this.this$1 = abstractMap$1;
        this.setIterator = AbstractMap$1.access$0(abstractMap$1).entrySet().iterator();
    }

    @Override
    public boolean hasNext() {
        return this.setIterator.hasNext();
    }

    @Override
    public Object next() {
        return ((Map$Entry)this.setIterator.next()).getKey();
    }

    @Override
    public void remove() {
        this.setIterator.remove();
    }
}

