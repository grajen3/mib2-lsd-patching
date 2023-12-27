/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections;

import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.collections.ObjectIntMap$Entry;
import de.vw.mib.collections.ObjectIntMultimap$1;

class ObjectIntMultimap$1$1
implements ObjectIntMap$Entry {
    Object key;
    int val;
    private final /* synthetic */ ObjectIntMultimap$1 this$1;

    ObjectIntMultimap$1$1(ObjectIntMultimap$1 objectIntMultimap$1) {
        this.this$1 = objectIntMultimap$1;
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
    public Object getKey() {
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
        if (!(object instanceof ObjectIntMap$Entry)) {
            return false;
        }
        ObjectIntMap$Entry objectIntMap$Entry = (ObjectIntMap$Entry)object;
        if (objectIntMap$Entry.getValue() != this.val) {
            return false;
        }
        return objectIntMap$Entry.getKey() == this.key;
    }
}

