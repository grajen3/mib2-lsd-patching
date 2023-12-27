/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.AbstractSet;
import java.util.Hashtable;
import java.util.Hashtable$2;
import java.util.Hashtable$Entry;
import java.util.Hashtable$HashIterator;
import java.util.Iterator;
import java.util.Map$Entry;

final class Hashtable$1
extends AbstractSet {
    final /* synthetic */ Hashtable this$0;

    Hashtable$1(Hashtable hashtable) {
        this.this$0 = hashtable;
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
        if (this.contains(object)) {
            this.this$0.remove(((Map$Entry)object).getKey());
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(Object object) {
        if (object instanceof Map$Entry) {
            Hashtable$Entry hashtable$Entry = this.this$0.getEntry(((Map$Entry)object).getKey());
            return object.equals(hashtable$Entry);
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return new Hashtable$HashIterator(this.this$0, new Hashtable$2(this));
    }
}

