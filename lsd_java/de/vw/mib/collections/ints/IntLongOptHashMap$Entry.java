/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.ints;

import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.collections.ints.IntLongMap$Entry;
import de.vw.mib.collections.ints.IntLongOptHashMap;

class IntLongOptHashMap$Entry
implements IntLongMap$Entry {
    int where;
    int key;
    long value;
    int writescount;
    boolean isBound;
    private final /* synthetic */ IntLongOptHashMap this$0;

    public IntLongOptHashMap$Entry(IntLongOptHashMap intLongOptHashMap, int n) {
        this.this$0 = intLongOptHashMap;
        byte by = intLongOptHashMap.valueStates[n];
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
        IntLongOptHashMap$Entry intLongOptHashMap$Entry = (IntLongOptHashMap$Entry)object;
        if (this.key != intLongOptHashMap$Entry.key) {
            return false;
        }
        return this.value == intLongOptHashMap$Entry.value;
    }
}

