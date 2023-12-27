/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.ints;

import de.vw.mib.collections.ObjectIterator;
import de.vw.mib.collections.ints.IntArrayList;
import de.vw.mib.collections.ints.IntCollection;
import de.vw.mib.collections.ints.IntIntMap;
import de.vw.mib.collections.ints.IntIntMap$Entry;
import de.vw.mib.collections.ints.IntIntMultimap$1;
import de.vw.mib.collections.ints.IntIntMultimap$2;
import de.vw.mib.collections.ints.IntIntMultimap$3;
import de.vw.mib.collections.ints.IntIntMultimap$4;
import de.vw.mib.collections.ints.IntIntMultimap$5;
import de.vw.mib.collections.ints.IntIterator;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectMap$Entry;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.collections.ints.IntReadOnlyArrayList;
import de.vw.mib.collections.ints.IntSet;
import de.vw.mib.collections.ints.SyncIntIntOptHashMap;
import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Set;

public class IntIntMultimap
implements IntIntMap {
    final IntArrayList empty = new IntArrayList(0);
    private static final int NEUTRAL_KEY;
    private static final int NEUTRAL_VALUE;
    final IntObjectMap backingMap = new IntObjectOptHashMap();
    private final int neutralKey;
    final int neutralValue;
    private int writes = 0;
    private int cachedSizeWritesCount;
    private int size;

    public IntIntMultimap() {
        this.neutralValue = 0;
        this.neutralKey = 0;
    }

    @Override
    public int put(int n, int n2) {
        int n3;
        IntArrayList intArrayList;
        if (!this.backingMap.containsKey(n)) {
            intArrayList = new IntArrayList();
            n3 = this.neutralValue;
        } else {
            intArrayList = this.getValuesList(n);
            n3 = intArrayList.last();
        }
        intArrayList.add(n2);
        this.backingMap.put(n, intArrayList);
        ++this.writes;
        return n3;
    }

    private IntArrayList getValuesList(int n) {
        return (IntArrayList)this.backingMap.get(n);
    }

    @Override
    public int get(int n) {
        if (this.backingMap.containsKey(n)) {
            return this.getValuesList(n).last();
        }
        return this.neutralValue;
    }

    public IntCollection getAll(int n) {
        if (this.backingMap.containsKey(n)) {
            IntArrayList intArrayList = this.getValuesList(n);
            return new IntReadOnlyArrayList(intArrayList);
        }
        return IntReadOnlyArrayList.EMPTY;
    }

    @Override
    public boolean containsKey(int n) {
        return this.backingMap.containsKey(n);
    }

    public boolean containsKeyValuePair(int n, int n2) {
        if (this.backingMap.containsKey(n)) {
            IntArrayList intArrayList = this.getValuesList(n);
            return intArrayList.contains(n2);
        }
        return false;
    }

    @Override
    public int remove(int n) {
        IntArrayList intArrayList = (IntArrayList)this.backingMap.remove(n);
        if (null != intArrayList) {
            ++this.writes;
            return intArrayList.last();
        }
        return this.neutralValue;
    }

    public int removeValue(int n, int n2) {
        IntArrayList intArrayList = this.getValuesList(n);
        if (null == intArrayList) {
            return this.neutralValue;
        }
        boolean bl = intArrayList.removeValue(n2);
        if (intArrayList.size() == 0) {
            this.backingMap.remove(n);
        } else {
            this.backingMap.put(n, intArrayList);
        }
        if (bl) {
            ++this.writes;
            return n2;
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
            IntArrayList intArrayList = (IntArrayList)objectIterator.next();
            if (null == intArrayList) continue;
            n += intArrayList.size();
        }
        return n;
    }

    @Override
    public boolean isEmpty() {
        return this.backingMap.isEmpty();
    }

    @Override
    public boolean containsValue(int n) {
        ObjectIterator objectIterator = (ObjectIterator)this.backingMap.valueIterator();
        while (objectIterator.hasNext()) {
            IntArrayList intArrayList = (IntArrayList)objectIterator.next();
            for (int i2 = intArrayList.size() - 1; i2 >= 0; --i2) {
                if (intArrayList.get(i2) != n) continue;
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
        return new IntIntMultimap$1(this, iterator);
    }

    @Override
    public Set entrySet() {
        return new IntIntMultimap$2(this);
    }

    @Override
    public IntSet keySet() {
        return new IntIntMultimap$3(this);
    }

    @Override
    public IntCollection values() {
        return new IntIntMultimap$4(this);
    }

    @Override
    public IntIterator valueIterator() {
        Iterator iterator = this.backingMap.entryIterator();
        return new IntIntMultimap$5(this, iterator);
    }

    @Override
    public int replaceKey(int n, int n2) {
        Object object = this.backingMap.replaceKey(n, n2);
        if (null != object) {
            ++this.writes;
            return ((IntArrayList)object).last();
        }
        return this.neutralValue;
    }

    @Override
    public int replaceOneValue(int n, int n2) {
        Iterator iterator = this.backingMap.entryIterator();
        while (iterator.hasNext()) {
            IntObjectMap$Entry intObjectMap$Entry = (IntObjectMap$Entry)iterator.next();
            int n3 = intObjectMap$Entry.getKey();
            IntArrayList intArrayList = (IntArrayList)intObjectMap$Entry.getValue();
            for (int i2 = 0; i2 < intArrayList.size(); ++i2) {
                int n4 = intArrayList.get(i2);
                if (n4 != n) continue;
                intArrayList.set(i2, n2);
                this.backingMap.put(n3, intArrayList);
                ++this.writes;
                return n3;
            }
        }
        return this.neutralKey;
    }

    @Override
    public int getOneKeyByValue(int n) {
        Iterator iterator = this.backingMap.entryIterator();
        while (iterator.hasNext()) {
            IntObjectMap$Entry intObjectMap$Entry = (IntObjectMap$Entry)iterator.next();
            int n2 = intObjectMap$Entry.getKey();
            IntArrayList intArrayList = (IntArrayList)intObjectMap$Entry.getValue();
            for (int i2 = 0; i2 < intArrayList.size(); ++i2) {
                if (n != intArrayList.get(i2)) continue;
                ++this.writes;
                return n2;
            }
        }
        return this.neutralKey;
    }

    @Override
    public int[] valuesToArray() {
        return this.valuesToArray(new int[this.size()]);
    }

    @Override
    public int[] valuesToArray(int[] nArray) {
        int[] nArray2 = nArray;
        if (nArray.length < this.size()) {
            nArray2 = (int[])Array.newInstance(super.getClass().getComponentType(), this.size());
        }
        IntIterator intIterator = this.valueIterator();
        int n = 0;
        while (intIterator.hasNext()) {
            nArray2[n] = intIterator.next();
            ++n;
        }
        return nArray2;
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
    public IntIntMap synchronize() {
        return new SyncIntIntOptHashMap(this);
    }

    @Override
    public void putAll(IntIntMap intIntMap) {
        Iterator iterator = intIntMap.entrySet().iterator();
        while (iterator.hasNext()) {
            IntIntMap$Entry intIntMap$Entry = (IntIntMap$Entry)iterator.next();
            this.put(intIntMap$Entry.getKey(), intIntMap$Entry.getValue());
        }
    }

    static /* synthetic */ int access$000(IntIntMultimap intIntMultimap) {
        return intIntMultimap.neutralKey;
    }
}

