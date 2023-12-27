/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.ints;

import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.collections.ints.IntFloatMap$Entry;
import de.vw.mib.collections.ints.IntFloatOptHashMap;

class IntFloatOptHashMap$Entry
implements IntFloatMap$Entry {
    int where;
    int key;
    float value;
    int writescount;
    boolean isBound;
    private final /* synthetic */ IntFloatOptHashMap this$0;

    public IntFloatOptHashMap$Entry(IntFloatOptHashMap intFloatOptHashMap, int n) {
        this.this$0 = intFloatOptHashMap;
        byte by = intFloatOptHashMap.valueStates[n];
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
    public float getValue() {
        if (this.writescount != this.this$0.writes) {
            this.updateInternalState(this.this$0.findKey(this.key));
        }
        return this.value;
    }

    @Override
    public float setValue(float f2) {
        if (this.writescount != this.this$0.writes) {
            this.updateInternalState(this.this$0.findKey(this.key));
        }
        float f3 = this.value;
        if (this.isBound) {
            this.this$0.values[this.where] = f2;
        }
        this.value = f2;
        return f3;
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
        IntFloatOptHashMap$Entry intFloatOptHashMap$Entry = (IntFloatOptHashMap$Entry)object;
        if (this.key != intFloatOptHashMap$Entry.key) {
            return false;
        }
        return this.value == intFloatOptHashMap$Entry.value;
    }
}

