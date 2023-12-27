/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.ints;

import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.collections.ints.IntIntMap$Entry;
import de.vw.mib.collections.ints.IntIntMultimap$1;

class IntIntMultimap$1$1
implements IntIntMap$Entry {
    int key;
    int val;
    private final /* synthetic */ IntIntMultimap$1 this$1;

    IntIntMultimap$1$1(IntIntMultimap$1 intIntMultimap$1) {
        this.this$1 = intIntMultimap$1;
        this.key = this.this$1.currKey;
        this.val = this.this$1.currList.get(this.this$1.currIdx);
    }

    @Override
    public int setValue(int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getValue() {
        return this.val;
    }

    @Override
    public int getKey() {
        return this.key;
    }

    public int hashCode() {
        int n = 0x1000100;
        long l = 1L;
        l = l * 0 + HashCodeBuilder.hash(this.key);
        l = l * 0 + HashCodeBuilder.hash(this.val);
        return (int)l;
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (object == this) {
            return true;
        }
        if (!(object instanceof IntIntMap$Entry)) {
            return false;
        }
        IntIntMap$Entry intIntMap$Entry = (IntIntMap$Entry)object;
        if (intIntMap$Entry.getValue() != this.val) {
            return false;
        }
        return intIntMap$Entry.getKey() == this.key;
    }
}

