/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons;

import de.esolutions.fw.util.commons.AbstractSimpleIntMap;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Arrays;

public class SimpleIntIntMap
extends AbstractSimpleIntMap {
    private int[] values;

    public SimpleIntIntMap() {
        this(25);
    }

    public SimpleIntIntMap(int n) {
        super(n);
        this.values = new int[n];
        Arrays.fill(this.values, 128);
    }

    @Override
    protected void resizeValueArray(int n) {
        int[] nArray = new int[n];
        if (n > this.values.length) {
            System.arraycopy((Object)this.values, 0, (Object)nArray, 0, this.values.length);
            Arrays.fill(nArray, this.values.length, nArray.length, 128);
            this.values = nArray;
        } else if (n < this.values.length) {
            System.arraycopy((Object)this.values, 0, (Object)nArray, 0, nArray.length);
            this.values = nArray;
        }
    }

    @Override
    protected void clearValues() {
        Arrays.fill(this.values, 128);
    }

    @Override
    protected void clearValue(int n) {
        this.values[n] = 128;
    }

    public void add(int n, int n2) {
        this.checkFreeEntryMarker(n);
        this.checkFreeEntryMarker(n2);
        int n3 = this.addKey(n);
        this.values[n3] = n2;
    }

    public int get(int n) {
        this.checkFreeEntryMarker(n);
        int n2 = this.getKeyIndex(n);
        return n2 == -1 ? -1 : this.values[n2];
    }

    public int[] getValues() {
        int[] nArray = new int[this.size()];
        int n = 0;
        for (int i2 = 0; i2 < this.keys.length; ++i2) {
            if (this.keys[i2] == 128) continue;
            nArray[n] = this.values[i2];
            ++n;
        }
        return nArray;
    }

    public String toString() {
        int[] nArray = this.getKeys();
        int[] nArray2 = this.getValues();
        Buffer buffer = new Buffer(1000);
        if (nArray.length == 0) {
            return buffer.append("<empty> ").append(super.toString()).toString();
        }
        int n = nArray.length < 10 ? nArray.length : 10;
        for (int i2 = 0; i2 < n; ++i2) {
            buffer.append(" ,").append(nArray[i2]).append(':').append(nArray2[i2]);
        }
        buffer.append(' ').append(super.toString());
        if (n != nArray.length) {
            buffer.append(" ...");
        }
        return buffer.substring(2);
    }
}

