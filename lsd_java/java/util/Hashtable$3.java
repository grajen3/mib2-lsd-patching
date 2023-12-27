/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.AbstractSet;
import java.util.Hashtable;
import java.util.Hashtable$4;
import java.util.Hashtable$HashIterator;
import java.util.Iterator;

final class Hashtable$3
extends AbstractSet {
    final /* synthetic */ Hashtable this$0;

    Hashtable$3(Hashtable hashtable) {
        this.this$0 = hashtable;
    }

    @Override
    public boolean contains(Object object) {
        return this.this$0.containsKey(object);
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
    public boolean remove(Object object) {
        if (this.this$0.containsKey(object)) {
            this.this$0.remove(object);
            return true;
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return new Hashtable$HashIterator(this.this$0, new Hashtable$4(this));
    }
}

