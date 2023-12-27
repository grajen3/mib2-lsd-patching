/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util;

import edu.emory.mathcs.backport.java.util.Collections$CheckedMap$EntrySetView;
import edu.emory.mathcs.backport.java.util.Collections$CheckedMap$EntryView;
import java.util.Iterator;
import java.util.Map$Entry;

class Collections$1
implements Iterator {
    private final /* synthetic */ Iterator val$itr;
    private final /* synthetic */ Collections$CheckedMap$EntrySetView this$1;

    Collections$1(Collections$CheckedMap$EntrySetView entrySetView, Iterator iterator) {
        this.this$1 = entrySetView;
        this.val$itr = iterator;
    }

    @Override
    public boolean hasNext() {
        return this.val$itr.hasNext();
    }

    @Override
    public Object next() {
        return new Collections$CheckedMap$EntryView(Collections$CheckedMap$EntrySetView.access$000(this.this$1), (Map$Entry)this.val$itr.next());
    }

    @Override
    public void remove() {
        this.val$itr.remove();
    }
}

