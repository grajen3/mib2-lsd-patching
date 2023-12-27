/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.longs;

import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.collections.longs.LongIntMap$Entry;
import de.vw.mib.collections.longs.LongIntMultimap$1;

class LongIntMultimap$1$1
implements LongIntMap$Entry {
    long key;
    int val;
    private final /* synthetic */ LongIntMultimap$1 this$1;

    LongIntMultimap$1$1(LongIntMultimap$1 longIntMultimap$1) {
        this.this$1 = longIntMultimap$1;
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
    public long getKey() {
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
        if (!(object instanceof LongIntMap$Entry)) {
            return false;
        }
        LongIntMap$Entry longIntMap$Entry = (LongIntMap$Entry)object;
        if (longIntMap$Entry.getValue() != this.val) {
            return false;
        }
        return longIntMap$Entry.getKey() == this.key;
    }
}

