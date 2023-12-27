/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.longs;

import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.collections.longs.LongLongMap$Entry;
import de.vw.mib.collections.longs.LongLongMultimap$1;

class LongLongMultimap$1$1
implements LongLongMap$Entry {
    long key;
    long val;
    private final /* synthetic */ LongLongMultimap$1 this$1;

    LongLongMultimap$1$1(LongLongMultimap$1 longLongMultimap$1) {
        this.this$1 = longLongMultimap$1;
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
        if (!(object instanceof LongLongMap$Entry)) {
            return false;
        }
        LongLongMap$Entry longLongMap$Entry = (LongLongMap$Entry)object;
        if (longLongMap$Entry.getValue() != this.val) {
            return false;
        }
        return longLongMap$Entry.getKey() == this.key;
    }
}

