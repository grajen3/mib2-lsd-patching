/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.longs;

import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.collections.longs.LongObjectMap$Entry;
import de.vw.mib.collections.longs.LongObjectMultimap$1;

class LongObjectMultimap$1$1
implements LongObjectMap$Entry {
    long key;
    Object val;
    private final /* synthetic */ LongObjectMultimap$1 this$1;

    LongObjectMultimap$1$1(LongObjectMultimap$1 longObjectMultimap$1) {
        this.this$1 = longObjectMultimap$1;
        this.key = this.this$1.currKey;
        this.val = this.this$1.currList.get(this.this$1.currIdx);
    }

    @Override
    public Object setValue(Object object) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object getValue() {
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
        if (!(object instanceof LongObjectMap$Entry)) {
            return false;
        }
        LongObjectMap$Entry longObjectMap$Entry = (LongObjectMap$Entry)object;
        if (longObjectMap$Entry.getValue() != this.val) {
            return false;
        }
        return longObjectMap$Entry.getKey() == this.key;
    }
}

