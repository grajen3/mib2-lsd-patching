/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.ints;

import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.collections.ints.IntFloatMap$Entry;
import de.vw.mib.collections.ints.IntFloatMultimap$1;

class IntFloatMultimap$1$1
implements IntFloatMap$Entry {
    int key;
    float val;
    private final /* synthetic */ IntFloatMultimap$1 this$1;

    IntFloatMultimap$1$1(IntFloatMultimap$1 intFloatMultimap$1) {
        this.this$1 = intFloatMultimap$1;
        this.key = this.this$1.currKey;
        this.val = this.this$1.currList.get(this.this$1.currIdx);
    }

    @Override
    public float setValue(float f2) {
        throw new UnsupportedOperationException();
    }

    @Override
    public float getValue() {
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
        if (!(object instanceof IntFloatMap$Entry)) {
            return false;
        }
        IntFloatMap$Entry intFloatMap$Entry = (IntFloatMap$Entry)object;
        if (intFloatMap$Entry.getValue() != this.val) {
            return false;
        }
        return intFloatMap$Entry.getKey() == this.key;
    }
}

