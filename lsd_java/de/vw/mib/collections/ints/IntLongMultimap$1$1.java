/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.ints;

import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.collections.ints.IntLongMap$Entry;
import de.vw.mib.collections.ints.IntLongMultimap$1;

class IntLongMultimap$1$1
implements IntLongMap$Entry {
    int key;
    long val;
    private final /* synthetic */ IntLongMultimap$1 this$1;

    IntLongMultimap$1$1(IntLongMultimap$1 intLongMultimap$1) {
        this.this$1 = intLongMultimap$1;
        this.key = this.this$1.currKey;
        this.val = this.this$1.currList.get(this.this$1.currIdx);
    }

    @Override
    public long setValue(long l) {
        throw new UnsupportedOperationException();
    }

    @Override
    public long getValue() {
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
        if (!(object instanceof IntLongMap$Entry)) {
            return false;
        }
        IntLongMap$Entry intLongMap$Entry = (IntLongMap$Entry)object;
        if (intLongMap$Entry.getValue() != this.val) {
            return false;
        }
        return intLongMap$Entry.getKey() == this.key;
    }
}

