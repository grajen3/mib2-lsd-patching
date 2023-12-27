/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.ints;

import de.vw.mib.collections.booleans.BooleanCollection;
import de.vw.mib.collections.booleans.BooleanIterator;
import de.vw.mib.collections.ints.IntBooleanOptHashMap;
import de.vw.mib.collections.ints.IntBooleanOptHashMap$ValueIterator;
import java.lang.reflect.Array;

class IntBooleanOptHashMap$ValueCollection
implements BooleanCollection {
    private final /* synthetic */ IntBooleanOptHashMap this$0;

    public IntBooleanOptHashMap$ValueCollection(IntBooleanOptHashMap intBooleanOptHashMap) {
        this.this$0 = intBooleanOptHashMap;
    }

    @Override
    public boolean add(boolean bl) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        this.this$0.clear();
    }

    @Override
    public boolean contains(boolean bl) {
        return this.this$0.containsValue(bl);
    }

    @Override
    public boolean isEmpty() {
        return this.this$0.isEmpty();
    }

    @Override
    public BooleanIterator iterator() {
        return new IntBooleanOptHashMap$ValueIterator(this.this$0);
    }

    @Override
    public boolean remove(boolean bl) {
        int n = this.this$0.findOneValuePos(bl);
        if (128 != n) {
            this.this$0.removePos(n);
            this.this$0.onCollectionChanged();
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return this.this$0.size;
    }

    @Override
    public boolean addAll(BooleanCollection booleanCollection) {
        throw new UnsupportedOperationException();
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
    public boolean removeAll(BooleanCollection booleanCollection) {
        boolean bl = false;
        BooleanIterator booleanIterator = booleanCollection.iterator();
        while (booleanIterator.hasNext()) {
            bl |= this.remove(booleanIterator.next());
        }
        return bl;
    }

    @Override
    public boolean retainAll(BooleanCollection booleanCollection) {
        boolean bl = false;
        BooleanIterator booleanIterator = this.iterator();
        while (booleanIterator.hasNext()) {
            if (booleanCollection.contains(booleanIterator.next())) continue;
            booleanIterator.remove();
            bl = true;
        }
        return bl;
    }

    @Override
    public boolean[] toArray() {
        return this.toArray(new boolean[this.this$0.size]);
    }

    @Override
    public boolean[] toArray(boolean[] blArray) {
        boolean[] blArray2 = blArray;
        if (blArray.length < this.this$0.size) {
            blArray2 = (boolean[])Array.newInstance(super.getClass().getComponentType(), this.this$0.size);
        }
        BooleanIterator booleanIterator = this.iterator();
        for (int i2 = 0; i2 < this.this$0.size; ++i2) {
            blArray2[i2] = booleanIterator.next();
        }
        return blArray2;
    }
}

