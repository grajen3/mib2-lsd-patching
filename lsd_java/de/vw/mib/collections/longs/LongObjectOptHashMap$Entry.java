/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.longs;

import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.collections.longs.LongObjectMap$Entry;
import de.vw.mib.collections.longs.LongObjectOptHashMap;

class LongObjectOptHashMap$Entry
implements LongObjectMap$Entry {
    int where;
    long key;
    Object value;
    int writescount;
    boolean isBound;
    private final /* synthetic */ LongObjectOptHashMap this$0;

    public LongObjectOptHashMap$Entry(LongObjectOptHashMap longObjectOptHashMap, int n) {
        this.this$0 = longObjectOptHashMap;
        byte by = longObjectOptHashMap.valueStates[n];
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
    public long getKey() {
        if (this.writescount != this.this$0.writes) {
            this.updateInternalState(this.this$0.findKey(this.key));
        }
        return this.key;
    }

    @Override
    public Object getValue() {
        if (this.writescount != this.this$0.writes) {
            this.updateInternalState(this.this$0.findKey(this.key));
        }
        return this.value;
    }

    @Override
    public Object setValue(Object object) {
        if (this.writescount != this.this$0.writes) {
            this.updateInternalState(this.this$0.findKey(this.key));
        }
        Object object2 = this.value;
        if (this.isBound) {
            this.this$0.values[this.where] = object;
        }
        this.value = object;
        return object2;
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
        LongObjectOptHashMap$Entry longObjectOptHashMap$Entry = (LongObjectOptHashMap$Entry)object;
        if (this.key != longObjectOptHashMap$Entry.key) {
            return false;
        }
        return this.value == longObjectOptHashMap$Entry.value;
    }
}

