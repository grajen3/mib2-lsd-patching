/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections;

import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.collections.ObjectObjectMap$Entry;
import de.vw.mib.collections.ObjectObjectMultimap$1;

class ObjectObjectMultimap$1$1
implements ObjectObjectMap$Entry {
    Object key;
    Object val;
    private final /* synthetic */ ObjectObjectMultimap$1 this$1;

    ObjectObjectMultimap$1$1(ObjectObjectMultimap$1 objectObjectMultimap$1) {
        this.this$1 = objectObjectMultimap$1;
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
        if (!(object instanceof ObjectObjectMap$Entry)) {
            return false;
        }
        ObjectObjectMap$Entry objectObjectMap$Entry = (ObjectObjectMap$Entry)object;
        if (objectObjectMap$Entry.getValue() != this.val) {
            return false;
        }
        return objectObjectMap$Entry.getKey() == this.key;
    }
}

