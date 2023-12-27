/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.framework.persistence;

import de.vw.mib.asl.framework.api.persistence.Persistable;
import de.vw.mib.asl.framework.api.persistence.PersistenceInputStream;
import de.vw.mib.asl.framework.api.persistence.PersistenceOutputStream;
import de.vw.mib.collections.ints.IntArrayList;

public class RecuperationData
implements Persistable {
    private static final int NUMBER_OF_RECUPERATION_VALUES;
    private IntArrayList _recuperationData = null;
    private int _initialValue;

    public RecuperationData(int n) {
        this._initialValue = n;
    }

    public RecuperationData() {
        this(0);
    }

    private void _initializeIntArrayList(IntArrayList intArrayList, int n) {
        for (int i2 = 0; i2 < 30; ++i2) {
            intArrayList.add(n);
        }
    }

    private IntArrayList getRecuperationData() {
        if (this._recuperationData == null) {
            this._recuperationData = new IntArrayList(30);
            this._initializeIntArrayList(this._recuperationData, this.getInitialValue());
        }
        return this._recuperationData;
    }

    private void setRecuperationData(IntArrayList intArrayList) {
        this._recuperationData = intArrayList;
    }

    private int getInitialValue() {
        return this._initialValue;
    }

    public int[] getData() {
        return this.getRecuperationData().toArray();
    }

    public void addValue(int n) {
        this.getRecuperationData().removeLast();
        this.getRecuperationData().add(0, n);
    }

    public void resetAllData(int n) {
        this.getRecuperationData().clear();
        for (int i2 = 0; i2 < 30; ++i2) {
            this.getRecuperationData().add(i2, n);
        }
    }

    @Override
    public void fromStream(PersistenceInputStream persistenceInputStream) {
        IntArrayList intArrayList = new IntArrayList(30);
        for (int i2 = 0; i2 < 30; ++i2) {
            intArrayList.add(persistenceInputStream.readInt());
        }
        this.setRecuperationData(intArrayList);
    }

    @Override
    public void toStream(PersistenceOutputStream persistenceOutputStream) {
        IntArrayList intArrayList = this.getRecuperationData();
        int n = intArrayList.size();
        for (int i2 = 0; i2 < n; ++i2) {
            persistenceOutputStream.writeInt(intArrayList.get(i2));
        }
    }

    @Override
    public void clear() {
        this.setRecuperationData(null);
    }

    public String toString() {
        return this.getRecuperationData().toString();
    }
}

