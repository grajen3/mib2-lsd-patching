/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.ints;

import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.collections.ints.IntBooleanMap$Entry;
import de.vw.mib.collections.ints.IntBooleanMultimap$1;

class IntBooleanMultimap$1$1
implements IntBooleanMap$Entry {
    int key;
    boolean val;
    private final /* synthetic */ IntBooleanMultimap$1 this$1;

    IntBooleanMultimap$1$1(IntBooleanMultimap$1 intBooleanMultimap$1) {
        this.this$1 = intBooleanMultimap$1;
        this.key = this.this$1.currKey;
        this.val = this.this$1.currList.get(this.this$1.currIdx);
    }

    @Override
    public boolean setValue(boolean bl) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean getValue() {
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
        if (!(object instanceof IntBooleanMap$Entry)) {
            return false;
        }
        IntBooleanMap$Entry intBooleanMap$Entry = (IntBooleanMap$Entry)object;
        if (intBooleanMap$Entry.getValue() != this.val) {
            return false;
        }
        return intBooleanMap$Entry.getKey() == this.key;
    }
}

