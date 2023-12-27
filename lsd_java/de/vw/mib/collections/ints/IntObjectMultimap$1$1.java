/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.ints;

import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.collections.ints.IntObjectMap$Entry;
import de.vw.mib.collections.ints.IntObjectMultimap$1;

class IntObjectMultimap$1$1
implements IntObjectMap$Entry {
    int key;
    Object val;
    private final /* synthetic */ IntObjectMultimap$1 this$1;

    IntObjectMultimap$1$1(IntObjectMultimap$1 intObjectMultimap$1) {
        this.this$1 = intObjectMultimap$1;
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
        if (!(object instanceof IntObjectMap$Entry)) {
            return false;
        }
        IntObjectMap$Entry intObjectMap$Entry = (IntObjectMap$Entry)object;
        if (intObjectMap$Entry.getValue() != this.val) {
            return false;
        }
        return intObjectMap$Entry.getKey() == this.key;
    }
}

