/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections;

import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.collections.ObjectLongMap$Entry;
import de.vw.mib.collections.ObjectLongMultimap$1;

class ObjectLongMultimap$1$1
implements ObjectLongMap$Entry {
    Object key;
    long val;
    private final /* synthetic */ ObjectLongMultimap$1 this$1;

    ObjectLongMultimap$1$1(ObjectLongMultimap$1 objectLongMultimap$1) {
        this.this$1 = objectLongMultimap$1;
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
        if (!(object instanceof ObjectLongMap$Entry)) {
            return false;
        }
        ObjectLongMap$Entry objectLongMap$Entry = (ObjectLongMap$Entry)object;
        if (objectLongMap$Entry.getValue() != this.val) {
            return false;
        }
        return objectLongMap$Entry.getKey() == this.key;
    }
}

