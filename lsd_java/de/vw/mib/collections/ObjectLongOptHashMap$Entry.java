/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections;

import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.collections.ObjectLongMap$Entry;
import de.vw.mib.collections.ObjectLongOptHashMap;

class ObjectLongOptHashMap$Entry
implements ObjectLongMap$Entry {
    int where;
    Object key;
    long value;
    int writescount;
    boolean isBound;
    private final /* synthetic */ ObjectLongOptHashMap this$0;

    public ObjectLongOptHashMap$Entry(ObjectLongOptHashMap objectLongOptHashMap, int n) {
        this.this$0 = objectLongOptHashMap;
        byte by = objectLongOptHashMap.valueStates[n];
        if (by == 1 || by == 0) {
            throw new IllegalAccessError();
        }
        this.isBound = true;
        this.updateInternalState(n);
    }

    private void updateInternalState(int n) {
        if (this.isBound && n != 128) {
            this.where = n;
            this.key = this.this$0.keys[this.where];
            this.value = this.this$0.values[this.where];
            this.writescount = this.this$0.writes;
        } else {
            this.isBound = false;
        }
    }

    @Override
    public Object getKey() {
        if (this.writescount != this.this$0.writes) {
            this.updateInternalState(this.this$0.findKey(this.key));
        }
        return this.key;
    }

    @Override
    public long getValue() {
        if (this.writescount != this.this$0.writes) {
            this.updateInternalState(this.this$0.findKey(this.key));
        }
        return this.value;
    }

    @Override
    public long setValue(long l) {
        if (this.writescount != this.this$0.writes) {
            this.updateInternalState(this.this$0.findKey(this.key));
        }
        long l2 = this.value;
        if (this.isBound) {
            this.this$0.values[this.where] = l;
        }
        this.value = l;
        return l2;
    }

    public String toString() {
        return new StringBuffer().append("(").append(this.key).append("<-").append(this.value).append(")").toString();
    }

    public int hashCode() {
        return new HashCodeBuilder().append(this.key).append(this.value).hashCode();
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (super.getClass() != object.getClass()) {
            return false;
        }
        ObjectLongOptHashMap$Entry objectLongOptHashMap$Entry = (ObjectLongOptHashMap$Entry)object;
        if (this.key != objectLongOptHashMap$Entry.key) {
            return false;
        }
        return this.value == objectLongOptHashMap$Entry.value;
    }
}

