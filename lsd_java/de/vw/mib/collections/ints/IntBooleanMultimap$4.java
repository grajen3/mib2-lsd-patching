/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.ints;

import de.vw.mib.collections.booleans.BooleanCollection;
import de.vw.mib.collections.booleans.BooleanIterator;
import de.vw.mib.collections.ints.IntBooleanMultimap;

class IntBooleanMultimap$4
implements BooleanCollection {
    private final /* synthetic */ IntBooleanMultimap this$0;

    IntBooleanMultimap$4(IntBooleanMultimap intBooleanMultimap) {
        this.this$0 = intBooleanMultimap;
    }

    @Override
    public boolean[] toArray(boolean[] blArray) {
        return this.this$0.valuesToArray(blArray);
    }

    @Override
    public boolean[] toArray() {
        return this.this$0.valuesToArray();
    }

    @Override
    public int size() {
        return this.this$0.size();
    }

    @Override
    public boolean retainAll(BooleanCollection booleanCollection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(BooleanCollection booleanCollection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(boolean bl) {
        throw new UnsupportedOperationException();
    }

    @Override
    public BooleanIterator iterator() {
        return this.this$0.valueIterator();
    }

    @Override
    public boolean isEmpty() {
        return this.this$0.isEmpty();
    }

    @Override
    public boolean containsAll(BooleanCollection booleanCollection) {
        BooleanIterator booleanIterator = booleanCollection.iterator();
        while (booleanIterator.hasNext()) {
            if (this.contains(booleanIterator.next())) continue;
            return false;
        }
        return true;
    }

    @Override
    public boolean contains(boolean bl) {
        return this.this$0.containsValue(bl);
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(BooleanCollection booleanCollection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(boolean bl) {
        throw new UnsupportedOperationException();
    }
}

