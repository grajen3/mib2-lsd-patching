/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.AbstractCollection;
import java.util.Hashtable;
import java.util.Hashtable$6;
import java.util.Hashtable$HashIterator;
import java.util.Iterator;

final class Hashtable$5
extends AbstractCollection {
    final /* synthetic */ Hashtable this$0;

    Hashtable$5(Hashtable hashtable) {
        this.this$0 = hashtable;
    }

    @Override
    public boolean contains(Object object) {
        return this.this$0.contains(object);
    }

    @Override
    public int size() {
        return this.this$0.elementCount;
    }

    @Override
    public void clear() {
        this.this$0.clear();
    }

    @Override
    public Iterator iterator() {
        return new Hashtable$HashIterator(this.this$0, new Hashtable$6(this));
    }
}

