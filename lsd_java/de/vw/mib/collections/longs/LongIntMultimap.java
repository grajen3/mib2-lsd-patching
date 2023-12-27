/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.longs;

import de.vw.mib.collections.ObjectIterator;
import de.vw.mib.collections.ints.IntArrayList;
import de.vw.mib.collections.ints.IntCollection;
import de.vw.mib.collections.ints.IntIterator;
import de.vw.mib.collections.ints.IntReadOnlyArrayList;
import de.vw.mib.collections.longs.LongIntMap;
import de.vw.mib.collections.longs.LongIntMap$Entry;
import de.vw.mib.collections.longs.LongIntMultimap$1;
import de.vw.mib.collections.longs.LongIntMultimap$2;
import de.vw.mib.collections.longs.LongIntMultimap$3;
import de.vw.mib.collections.longs.LongIntMultimap$4;
import de.vw.mib.collections.longs.LongIntMultimap$5;
import de.vw.mib.collections.longs.LongIterator;
import de.vw.mib.collections.longs.LongObjectMap;
import de.vw.mib.collections.longs.LongObjectMap$Entry;
import de.vw.mib.collections.longs.LongObjectOptHashMap;
import de.vw.mib.collections.longs.LongSet;
import de.vw.mib.collections.longs.SyncLongIntOptHashMap;
import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Set;

public class LongIntMultimap
implements LongIntMap {
    final IntArrayList empty = new IntArrayList(0);
    private static final long NEUTRAL_KEY;
    private static final int NEUTRAL_VALUE;
    final LongObjectMap backingMap = new LongObjectOptHashMap();
    private final long neutralKey;
    final int neutralValue;
    private int writes = 0;
    private int cachedSizeWritesCount;
    private int size;

    public LongIntMultimap() {
        this.neutralValue = 0;
        this.neutralKey = 0L;
    }

    @Override
    public int put(long l, int n) {
        int n2;
        IntArrayList intArrayList;
        if (!this.backingMap.containsKey(l)) {
            intArrayList = new IntArrayList();
            n2 = this.neutralValue;
        } else {
            intArrayList = this.getValuesList(l);
            n2 = intArrayList.last();
        }
        intArrayList.add(n);
        this.backingMap.put(l, intArrayList);
        ++this.writes;
        return n2;
    }

    private IntArrayList getValuesList(long l) {
        return (IntArrayList)this.backingMap.get(l);
    }

    @Override
    public int get(long l) {
        if (this.backingMap.containsKey(l)) {
            return this.getValuesList(l).last();
        }
        return this.neutralValue;
    }

    public IntCollection getAll(long l) {
        if (this.backingMap.containsKey(l)) {
            IntArrayList intArrayList = this.getValuesList(l);
            return new IntReadOnlyArrayList(intArrayList);
        }
        return IntReadOnlyArrayList.EMPTY;
    }

    @Override
    public boolean containsKey(long l) {
        return this.backingMap.containsKey(l);
    }

    public boolean containsKeyValuePair(long l, int n) {
        if (this.backingMap.containsKey(l)) {
            IntArrayList intArrayList = this.getValuesList(l);
            return intArrayList.contains(n);
        }
        return false;
    }

    @Override
    public int remove(long l) {
        IntArrayList intArrayList = (IntArrayList)this.backingMap.remove(l);
        if (null != intArrayList) {
            ++this.writes;
            return intArrayList.last();
        }
        return this.neutralValue;
    }

    public int removeValue(long l, int n) {
        IntArrayList intArrayList = this.getValuesList(l);
        if (null == intArrayList) {
            return this.neutralValue;
        }
        boolean bl = intArrayList.removeValue(n);
        if (intArrayList.size() == 0) {
            this.backingMap.remove(l);
        } else {
            this.backingMap.put(l, intArrayList);
        }
        if (bl) {
            ++this.writes;
            return n;
        }
        return this.neutralValue;
    }

    @Override
    public LongIterator keyIterator() {
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
        return new LongIntMultimap$1(this, iterator);
    }

    @Override
    public Set entrySet() {
        return new LongIntMultimap$2(this);
    }

    @Override
    public LongSet keySet() {
        return new LongIntMultimap$3(this);
    }

    @Override
    public IntCollection values() {
        return new LongIntMultimap$4(this);
    }

    @Override
    public IntIterator valueIterator() {
        Iterator iterator = this.backingMap.entryIterator();
        return new LongIntMultimap$5(this, iterator);
    }

    @Override
    public int replaceKey(long l, long l2) {
        Object object = this.backingMap.replaceKey(l, l2);
        if (null != object) {
            ++this.writes;
            return ((IntArrayList)object).last();
        }
        return this.neutralValue;
    }

    @Override
    public long replaceOneValue(int n, int n2) {
        Iterator iterator = this.backingMap.entryIterator();
        while (iterator.hasNext()) {
            LongObjectMap$Entry longObjectMap$Entry = (LongObjectMap$Entry)iterator.next();
            long l = longObjectMap$Entry.getKey();
            IntArrayList intArrayList = (IntArrayList)longObjectMap$Entry.getValue();
            for (int i2 = 0; i2 < intArrayList.size(); ++i2) {
                int n3 = intArrayList.get(i2);
                if (n3 != n) continue;
                intArrayList.set(i2, n2);
                this.backingMap.put(l, intArrayList);
                ++this.writes;
                return l;
            }
        }
        return this.neutralKey;
    }

    @Override
    public long getOneKeyByValue(int n) {
        Iterator iterator = this.backingMap.entryIterator();
        while (iterator.hasNext()) {
            LongObjectMap$Entry longObjectMap$Entry = (LongObjectMap$Entry)iterator.next();
            long l = longObjectMap$Entry.getKey();
            IntArrayList intArrayList = (IntArrayList)longObjectMap$Entry.getValue();
            for (int i2 = 0; i2 < intArrayList.size(); ++i2) {
                if (n != intArrayList.get(i2)) continue;
                ++this.writes;
                return l;
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
    public long[] keysToArray() {
        return this.keysToArray(new long[this.backingMap.size()]);
    }

    @Override
    public long[] keysToArray(long[] lArray) {
        long[] lArray2 = lArray;
        if (lArray.length < this.backingMap.size()) {
            lArray2 = (long[])Array.newInstance(super.getClass().getComponentType(), this.backingMap.size());
        }
        LongIterator longIterator = this.keyIterator();
        int n = 0;
        while (longIterator.hasNext()) {
            lArray2[n] = longIterator.next();
            ++n;
        }
        return lArray2;
    }

    @Override
    public LongIntMap synchronize() {
        return new SyncLongIntOptHashMap(this);
    }

    @Override
    public void putAll(LongIntMap longIntMap) {
        Iterator iterator = longIntMap.entrySet().iterator();
        while (iterator.hasNext()) {
            LongIntMap$Entry longIntMap$Entry = (LongIntMap$Entry)iterator.next();
            this.put(longIntMap$Entry.getKey(), longIntMap$Entry.getValue());
        }
    }

    static /* synthetic */ long access$000(LongIntMultimap longIntMultimap) {
        return longIntMultimap.neutralKey;
    }
}

