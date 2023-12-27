/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.booleans;

import de.vw.mib.collections.CollectionWithExpansionPoint;
import de.vw.mib.collections.booleans.BooleanCollection;
import de.vw.mib.collections.booleans.BooleanIterator;
import de.vw.mib.collections.booleans.BooleanOptHashSet$1;
import de.vw.mib.collections.booleans.BooleanSet;
import de.vw.mib.collections.booleans.SyncBooleanSet;

public class BooleanOptHashSet
implements CollectionWithExpansionPoint,
BooleanSet {
    int bools;
    int writesCount;

    public BooleanOptHashSet() {
        this.reset();
        this.writesCount = 0;
    }

    @Override
    public boolean add(boolean bl) {
        int n = this.bools;
        this.bools = n | this.getBit(bl);
        ++this.writesCount;
        this.onCollectionChanged();
        return n != this.bools;
    }

    int getBit(boolean bl) {
        return bl ? 1 : 2;
    }

    boolean getBool(int n) {
        return n == 1;
    }

    @Override
    public void clear() {
        this.reset();
        ++this.writesCount;
        this.onCollectionChanged();
    }

    private void reset() {
        this.bools = 0;
    }

    @Override
    public boolean contains(boolean bl) {
        return (this.getBit(bl) & this.bools) != 0;
    }

    @Override
    public boolean isEmpty() {
        return this.bools == 0;
    }

    @Override
    public BooleanIterator iterator() {
        return new BooleanOptHashSet$1(this);
    }

    @Override
    public boolean remove(boolean bl) {
        int n = this.bools;
        this.bools = n & ~this.getBit(bl);
        ++this.writesCount;
        this.onCollectionChanged();
        return this.bools != n;
    }

    @Override
    public int size() {
        switch (this.bools) {
            case 0: {
                return 0;
            }
            case 1: 
            case 2: {
                return 1;
            }
        }
        return 2;
    }

    @Override
    public boolean addAll(BooleanCollection booleanCollection) {
        int n = this.bools;
        if (booleanCollection.contains(true)) {
            this.add(true);
        }
        if (booleanCollection.contains(false)) {
            this.add(false);
        }
        return n != this.bools;
    }

    @Override
    public boolean containsAll(BooleanCollection booleanCollection) {
        if (booleanCollection.contains(true) && !this.contains(true)) {
            return false;
        }
        return !booleanCollection.contains(false) || this.contains(false);
    }

    @Override
    public boolean removeAll(BooleanCollection booleanCollection) {
        int n = this.bools;
        if (this.contains(true) && booleanCollection.contains(true)) {
            this.remove(true);
        }
        if (this.contains(false) && booleanCollection.contains(false)) {
            this.remove(false);
        }
        return n != this.bools;
    }

    @Override
    public boolean retainAll(BooleanCollection booleanCollection) {
        int n = this.bools;
        if (this.contains(true) && !booleanCollection.contains(true)) {
            this.remove(true);
        }
        if (this.contains(false) && !booleanCollection.contains(false)) {
            this.remove(false);
        }
        return n != this.bools;
    }

    @Override
    public boolean[] toArray() {
        return this.toArray(new boolean[this.size()]);
    }

    @Override
    public boolean[] toArray(boolean[] blArray) {
        if (blArray.length < this.size()) {
            return this.toArray();
        }
        switch (this.bools) {
            case 0: {
                break;
            }
            case 1: 
            case 2: {
                blArray[0] = this.getBool(this.bools);
                break;
            }
            default: {
                blArray[0] = this.getBool(1);
                blArray[1] = this.getBool(2);
            }
        }
        return blArray;
    }

    public String toString() {
        switch (this.bools) {
            case 0: {
                return "[]";
            }
            case 1: 
            case 2: {
                return new StringBuffer().append("[").append(this.getBool(this.bools)).append("]").toString();
            }
        }
        return "[false, true]";
    }

    @Override
    public BooleanSet synchronize() {
        return new SyncBooleanSet(this);
    }

    @Override
    public boolean get(boolean bl) {
        return bl && this.contains(true);
    }

    @Override
    public void onCollectionChanged() {
    }
}

