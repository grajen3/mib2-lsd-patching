/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.ints;

import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.collections.ints.IntBooleanMap$Entry;
import de.vw.mib.collections.ints.IntBooleanOptHashMap;

class IntBooleanOptHashMap$Entry
implements IntBooleanMap$Entry {
    int where;
    int key;
    boolean value;
    int writescount;
    boolean isBound;
    private final /* synthetic */ IntBooleanOptHashMap this$0;

    public IntBooleanOptHashMap$Entry(IntBooleanOptHashMap intBooleanOptHashMap, int n) {
        this.this$0 = intBooleanOptHashMap;
        byte by = intBooleanOptHashMap.valueStates[n];
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
    public boolean getValue() {
        if (this.writescount != this.this$0.writes) {
            this.updateInternalState(this.this$0.findKey(this.key));
        }
        return this.value;
    }

    @Override
    public boolean setValue(boolean bl) {
        if (this.writescount != this.this$0.writes) {
            this.updateInternalState(this.this$0.findKey(this.key));
        }
        boolean bl2 = this.value;
        if (this.isBound) {
            this.this$0.values[this.where] = bl;
        }
        this.value = bl;
        return bl2;
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
        IntBooleanOptHashMap$Entry intBooleanOptHashMap$Entry = (IntBooleanOptHashMap$Entry)object;
        if (this.key != intBooleanOptHashMap$Entry.key) {
            return false;
        }
        return this.value == intBooleanOptHashMap$Entry.value;
    }
}

