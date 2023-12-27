/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.ints;

import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.collections.ints.IntIntMap$Entry;
import de.vw.mib.collections.ints.IntIntOptHashMap;

class IntIntOptHashMap$Entry
implements IntIntMap$Entry {
    int where;
    int key;
    int value;
    int writescount;
    boolean isBound;
    private final /* synthetic */ IntIntOptHashMap this$0;

    public IntIntOptHashMap$Entry(IntIntOptHashMap intIntOptHashMap, int n) {
        this.this$0 = intIntOptHashMap;
        byte by = intIntOptHashMap.valueStates[n];
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
    public int getKey() {
        if (this.writescount != this.this$0.writes) {
            this.updateInternalState(this.this$0.findKey(this.key));
        }
        return this.key;
    }

    @Override
    public int getValue() {
        if (this.writescount != this.this$0.writes) {
            this.updateInternalState(this.this$0.findKey(this.key));
        }
        return this.value;
    }

    @Override
    public int setValue(int n) {
        if (this.writescount != this.this$0.writes) {
            this.updateInternalState(this.this$0.findKey(this.key));
        }
        int n2 = this.value;
        if (this.isBound) {
            this.this$0.values[this.where] = n;
        }
        this.value = n;
        return n2;
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
        IntIntOptHashMap$Entry intIntOptHashMap$Entry = (IntIntOptHashMap$Entry)object;
        if (this.key != intIntOptHashMap$Entry.key) {
            return false;
        }
        return this.value == intIntOptHashMap$Entry.value;
    }
}

