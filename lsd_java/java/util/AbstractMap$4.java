/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.AbstractMap$3;
import java.util.Iterator;
import java.util.Map$Entry;

final class AbstractMap$4
implements Iterator {
    Iterator setIterator;
    final /* synthetic */ AbstractMap$3 this$1;

    AbstractMap$4(AbstractMap$3 abstractMap$3) {
        this.this$1 = abstractMap$3;
        this.setIterator = AbstractMap$3.access$0(abstractMap$3).entrySet().iterator();
    }

    @Override
    public boolean hasNext() {
        return this.setIterator.hasNext();
    }

    @Override
    public Object next() {
        return ((Map$Entry)this.setIterator.next()).getValue();
    }

    @Override
    public void remove() {
        this.setIterator.remove();
    }
}

