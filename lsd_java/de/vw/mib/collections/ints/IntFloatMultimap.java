/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.ints;

import de.vw.mib.collections.ObjectIterator;
import de.vw.mib.collections.floats.FloatArrayList;
import de.vw.mib.collections.floats.FloatCollection;
import de.vw.mib.collections.floats.FloatIterator;
import de.vw.mib.collections.floats.FloatReadOnlyArrayList;
import de.vw.mib.collections.ints.IntFloatMap;
import de.vw.mib.collections.ints.IntFloatMap$Entry;
import de.vw.mib.collections.ints.IntFloatMultimap$1;
import de.vw.mib.collections.ints.IntFloatMultimap$2;
import de.vw.mib.collections.ints.IntFloatMultimap$3;
import de.vw.mib.collections.ints.IntFloatMultimap$4;
import de.vw.mib.collections.ints.IntFloatMultimap$5;
import de.vw.mib.collections.ints.IntIterator;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectMap$Entry;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.collections.ints.IntSet;
import de.vw.mib.collections.ints.SyncIntFloatOptHashMap;
import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Set;

public class IntFloatMultimap
implements IntFloatMap {
    final FloatArrayList empty = new FloatArrayList(0);
    private static final int NEUTRAL_KEY;
    private static final float NEUTRAL_VALUE;
    final IntObjectMap backingMap = new IntObjectOptHashMap();
    private final int neutralKey;
    final float neutralValue;
    private int writes = 0;
    private int cachedSizeWritesCount;
    private int size;

    public IntFloatMultimap() {
        this.neutralValue = 0.0f;
        this.neutralKey = 0;
    }

    @Override
    public float put(int n, float f2) {
        float f3;
        FloatArrayList floatArrayList;
        if (!this.backingMap.containsKey(n)) {
            floatArrayList = new FloatArrayList();
            f3 = this.neutralValue;
        } else {
            floatArrayList = this.getValuesList(n);
            f3 = floatArrayList.last();
        }
        floatArrayList.add(f2);
        this.backingMap.put(n, floatArrayList);
        ++this.writes;
        return f3;
    }

    private FloatArrayList getValuesList(int n) {
        return (FloatArrayList)this.backingMap.get(n);
    }

    @Override
    public float get(int n) {
        if (this.backingMap.containsKey(n)) {
            return this.getValuesList(n).last();
        }
        return this.neutralValue;
    }

    public FloatCollection getAll(int n) {
        if (this.backingMap.containsKey(n)) {
            FloatArrayList floatArrayList = this.getValuesList(n);
            return new FloatReadOnlyArrayList(floatArrayList);
        }
        return FloatReadOnlyArrayList.EMPTY;
    }

    @Override
    public boolean containsKey(int n) {
        return this.backingMap.containsKey(n);
    }

    public boolean containsKeyValuePair(int n, float f2) {
        if (this.backingMap.containsKey(n)) {
            FloatArrayList floatArrayList = this.getValuesList(n);
            return floatArrayList.contains(f2);
        }
        return false;
    }

    @Override
    public float remove(int n) {
        FloatArrayList floatArrayList = (FloatArrayList)this.backingMap.remove(n);
        if (null != floatArrayList) {
            ++this.writes;
            return floatArrayList.last();
        }
        return this.neutralValue;
    }

    public float removeValue(int n, float f2) {
        FloatArrayList floatArrayList = this.getValuesList(n);
        if (null == floatArrayList) {
            return this.neutralValue;
        }
        boolean bl = floatArrayList.removeValue(f2);
        if (floatArrayList.size() == 0) {
            this.backingMap.remove(n);
        } else {
            this.backingMap.put(n, floatArrayList);
        }
        if (bl) {
            ++this.writes;
            return f2;
        }
        return this.neutralValue;
    }

    @Override
    public IntIterator keyIterator() {
        return this.backingMap.keyIterator();
    }

    @Override
    public int size() {
        if (this.cachedSizeWritesCount != this.writes) {
            this.cachedSizeWritesCount = this.writes;
            this.size = this.calcSize();
        }
        return this.size;
    }

    private int calcSize() {
        int n = 0;
        ObjectIterator objectIterator = (ObjectIterator)this.backingMap.valueIterator();
        while (objectIterator.hasNext()) {
            FloatArrayList floatArrayList = (FloatArrayList)objectIterator.next();
            if (null == floatArrayList) continue;
            n += floatArrayList.size();
        }
        return n;
    }

    @Override
    public boolean isEmpty() {
        return this.backingMap.isEmpty();
    }

    @Override
    public boolean containsValue(float f2) {
        ObjectIterator objectIterator = (ObjectIterator)this.backingMap.valueIterator();
        while (objectIterator.hasNext()) {
            FloatArrayList floatArrayList = (FloatArrayList)objectIterator.next();
            for (int i2 = floatArrayList.size() - 1; i2 >= 0; --i2) {
                if (floatArrayList.get(i2) != f2) continue;
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        if (!this.backingMap.isEmpty()) {
            this.backingMap.clear();
            ++this.writes;
        }
    }

    @Override
    public void ensureAvailableSpaceAndAvoidFurtherRehashes(int n) {
        this.backingMap.ensureAvailableSpaceAndAvoidFurtherRehashes(n);
    }

    @Override
    public Iterator entryIterator() {
        Iterator iterator = this.backingMap.entryIterator();
        return new IntFloatMultimap$1(this, iterator);
    }

    @Override
    public Set entrySet() {
        return new IntFloatMultimap$2(this);
    }

    @Override
    public IntSet keySet() {
        return new IntFloatMultimap$3(this);
    }

    @Override
    public FloatCollection values() {
        return new IntFloatMultimap$4(this);
    }

    @Override
    public FloatIterator valueIterator() {
        Iterator iterator = this.backingMap.entryIterator();
        return new IntFloatMultimap$5(this, iterator);
    }

    @Override
    public float replaceKey(int n, int n2) {
        Object object = this.backingMap.replaceKey(n, n2);
        if (null != object) {
            ++this.writes;
            return ((FloatArrayList)object).last();
        }
        return this.neutralValue;
    }

    @Override
    public int replaceOneValue(float f2, float f3) {
        Iterator iterator = this.backingMap.entryIterator();
        while (iterator.hasNext()) {
            IntObjectMap$Entry intObjectMap$Entry = (IntObjectMap$Entry)iterator.next();
            int n = intObjectMap$Entry.getKey();
            FloatArrayList floatArrayList = (FloatArrayList)intObjectMap$Entry.getValue();
            for (int i2 = 0; i2 < floatArrayList.size(); ++i2) {
                float f4 = floatArrayList.get(i2);
                if (f4 != f2) continue;
                floatArrayList.set(i2, f3);
                this.backingMap.put(n, floatArrayList);
                ++this.writes;
                return n;
            }
        }
        return this.neutralKey;
    }

    @Override
    public int getOneKeyByValue(float f2) {
        Iterator iterator = this.backingMap.entryIterator();
        while (iterator.hasNext()) {
            IntObjectMap$Entry intObjectMap$Entry = (IntObjectMap$Entry)iterator.next();
            int n = intObjectMap$Entry.getKey();
            FloatArrayList floatArrayList = (FloatArrayList)intObjectMap$Entry.getValue();
            for (int i2 = 0; i2 < floatArrayList.size(); ++i2) {
                if (f2 != floatArrayList.get(i2)) continue;
                ++this.writes;
                return n;
            }
        }
        return this.neutralKey;
    }

    @Override
    public float[] valuesToArray() {
        return this.valuesToArray(new float[this.size()]);
    }

    @Override
    public float[] valuesToArray(float[] fArray) {
        float[] fArray2 = fArray;
        if (fArray.length < this.size()) {
            fArray2 = (float[])Array.newInstance(super.getClass().getComponentType(), this.size());
        }
        FloatIterator floatIterator = this.valueIterator();
        int n = 0;
        while (floatIterator.hasNext()) {
            fArray2[n] = floatIterator.next();
            ++n;
        }
        return fArray2;
    }

    @Override
    public int[] keysToArray() {
        return this.keysToArray(new int[this.backingMap.size()]);
    }

    @Override
    public int[] keysToArray(int[] nArray) {
        int[] nArray2 = nArray;
        if (nArray.length < this.backingMap.size()) {
            nArray2 = (int[])Array.newInstance(super.getClass().getComponentType(), this.backingMap.size());
        }
        IntIterator intIterator = this.keyIterator();
        int n = 0;
        while (intIterator.hasNext()) {
            nArray2[n] = intIterator.next();
            ++n;
        }
        return nArray2;
    }

    @Override
    public IntFloatMap synchronize() {
        return new SyncIntFloatOptHashMap(this);
    }

    @Override
    public void putAll(IntFloatMap intFloatMap) {
        Iterator iterator = intFloatMap.entrySet().iterator();
        while (iterator.hasNext()) {
            IntFloatMap$Entry intFloatMap$Entry = (IntFloatMap$Entry)iterator.next();
            this.put(intFloatMap$Entry.getKey(), intFloatMap$Entry.getValue());
        }
    }

    static /* synthetic */ int access$000(IntFloatMultimap intFloatMultimap) {
        return intFloatMultimap.neutralKey;
    }
}

