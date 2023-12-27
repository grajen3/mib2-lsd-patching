/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons;

import de.esolutions.fw.util.commons.AbstractSimpleIntMap;
import java.util.Arrays;

public class SimpleIntObjectMap
extends AbstractSimpleIntMap {
    private Object[] values;

    public SimpleIntObjectMap() {
        this(25);
    }

    public SimpleIntObjectMap(int n) {
        super(n);
        this.values = new Object[n];
        Arrays.fill(this.values, null);
    }

    @Override
    protected void resizeValueArray(int n) {
        Object[] objectArray = new Object[n];
        if (n > this.values.length) {
            System.arraycopy((Object)this.values, 0, (Object)objectArray, 0, this.values.length);
            Arrays.fill(objectArray, this.values.length, objectArray.length, null);
            this.values = objectArray;
        } else if (n < this.values.length) {
            System.arraycopy((Object)this.values, 0, (Object)objectArray, 0, objectArray.length);
            this.values = objectArray;
        }
    }

    @Override
    protected void clearValues() {
        Arrays.fill(this.values, null);
    }

    @Override
    protected void clearValue(int n) {
        this.values[n] = null;
    }

    public void add(int n, Object object) {
        this.checkFreeEntryMarker(n);
        int n2 = this.addKey(n);
        this.values[n2] = object;
    }

    public Object get(int n) {
        this.checkFreeEntryMarker(n);
        int n2 = this.getKeyIndex(n);
        return n2 == -1 ? null : this.values[n2];
    }

    public Object[] getValues() {
        Object[] objectArray = new Object[this.size()];
        int n = 0;
        for (int i2 = 0; i2 < this.keys.length; ++i2) {
            if (this.keys[i2] == 128) continue;
            objectArray[n] = this.values[i2];
            ++n;
        }
        return objectArray;
    }

    public void valuesToArray(Object[] objectArray) {
        if (this.size() != objectArray.length) {
            throw new IllegalArgumentException(new StringBuffer().append("Array size ").append(objectArray.length).append(" does not match number of values ").append(this.size()).toString());
        }
        int n = 0;
        for (int i2 = 0; i2 < this.keys.length; ++i2) {
            if (this.keys[i2] == 128) continue;
            objectArray[n] = this.values[i2];
            ++n;
        }
    }
}

