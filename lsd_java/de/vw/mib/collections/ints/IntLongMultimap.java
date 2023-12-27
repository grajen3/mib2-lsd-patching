/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.ints;

import de.vw.mib.collections.ObjectIterator;
import de.vw.mib.collections.ints.IntIterator;
import de.vw.mib.collections.ints.IntLongMap;
import de.vw.mib.collections.ints.IntLongMap$Entry;
import de.vw.mib.collections.ints.IntLongMultimap$1;
import de.vw.mib.collections.ints.IntLongMultimap$2;
import de.vw.mib.collections.ints.IntLongMultimap$3;
import de.vw.mib.collections.ints.IntLongMultimap$4;
import de.vw.mib.collections.ints.IntLongMultimap$5;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectMap$Entry;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.collections.ints.IntSet;
import de.vw.mib.collections.ints.SyncIntLongOptHashMap;
import de.vw.mib.collections.longs.LongArrayList;
import de.vw.mib.collections.longs.LongCollection;
import de.vw.mib.collections.longs.LongIterator;
import de.vw.mib.collections.longs.LongReadOnlyArrayList;
import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Set;

public class IntLongMultimap
implements IntLongMap {
    final LongArrayList empty = new LongArrayList(0);
    private static final int NEUTRAL_KEY;
    private static final long NEUTRAL_VALUE;
    final IntObjectMap backingMap = new IntObjectOptHashMap();
    private final int neutralKey;
    final long neutralValue;
    private int writes = 0;
    private int cachedSizeWritesCount;
    private int size;

    public IntLongMultimap() {
        this.neutralValue = 0L;
        this.neutralKey = 0;
    }

    @Override
    public long put(int n, long l) {
        long l2;
        LongArrayList longArrayList;
        if (!this.backingMap.containsKey(n)) {
            longArrayList = new LongArrayList();
            l2 = this.neutralValue;
        } else {
            longArrayList = this.getValuesList(n);
            l2 = longArrayList.last();
        }
        longArrayList.add(l);
        this.backingMap.put(n, longArrayList);
        ++this.writes;
        return l2;
    }

    private LongArrayList getValuesList(int n) {
        return (LongArrayList)this.backingMap.get(n);
    }

    @Override
    public long get(int n) {
        if (this.backingMap.containsKey(n)) {
            return this.getValuesList(n).last();
        }
        return this.neutralValue;
    }

    public LongCollection getAll(int n) {
        if (this.backingMap.containsKey(n)) {
            LongArrayList longArrayList = this.getValuesList(n);
            return new LongReadOnlyArrayList(longArrayList);
        }
        return LongReadOnlyArrayList.EMPTY;
    }

    @Override
    public boolean containsKey(int n) {
        return this.backingMap.containsKey(n);
    }

    public boolean containsKeyValuePair(int n, long l) {
        if (this.backingMap.containsKey(n)) {
            LongArrayList longArrayList = this.getValuesList(n);
            return longArrayList.contains(l);
        }
        return false;
    }

    @Override
    public long remove(int n) {
        LongArrayList longArrayList = (LongArrayList)this.backingMap.remove(n);
        if (null != longArrayList) {
            ++this.writes;
            return longArrayList.last();
        }
        return this.neutralValue;
    }

    public long removeValue(int n, long l) {
        LongArrayList longArrayList = this.getValuesList(n);
        if (null == longArrayList) {
            return this.neutralValue;
        }
        boolean bl = longArrayList.removeValue(l);
        if (longArrayList.size() == 0) {
            this.backingMap.remove(n);
        } else {
            this.backingMap.put(n, longArrayList);
        }
        if (bl) {
            ++this.writes;
            return l;
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
            LongArrayList longArrayList = (LongArrayList)objectIterator.next();
            if (null == longArrayList) continue;
            n += longArrayList.size();
        }
        return n;
    }

    @Override
    public boolean isEmpty() {
        return this.backingMap.isEmpty();
    }

    @Override
    public boolean containsValue(long l) {
        ObjectIterator objectIterator = (ObjectIterator)this.backingMap.valueIterator();
        while (objectIterator.hasNext()) {
            LongArrayList longArrayList = (LongArrayList)objectIterator.next();
            for (int i2 = longArrayList.size() - 1; i2 >= 0; --i2) {
                if (longArrayList.get(i2) != l) continue;
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
        return new IntLongMultimap$1(this, iterator);
    }

    @Override
    public Set entrySet() {
        return new IntLongMultimap$2(this);
    }

    @Override
    public IntSet keySet() {
        return new IntLongMultimap$3(this);
    }

    @Override
    public LongCollection values() {
        return new IntLongMultimap$4(this);
    }

    @Override
    public LongIterator valueIterator() {
        Iterator iterator = this.backingMap.entryIterator();
        return new IntLongMultimap$5(this, iterator);
    }

    @Override
    public long replaceKey(int n, int n2) {
        Object object = this.backingMap.replaceKey(n, n2);
        if (null != object) {
            ++this.writes;
            return ((LongArrayList)object).last();
        }
        return this.neutralValue;
    }

    @Override
    public int replaceOneValue(long l, long l2) {
        Iterator iterator = this.backingMap.entryIterator();
        while (iterator.hasNext()) {
            IntObjectMap$Entry intObjectMap$Entry = (IntObjectMap$Entry)iterator.next();
            int n = intObjectMap$Entry.getKey();
            LongArrayList longArrayList = (LongArrayList)intObjectMap$Entry.getValue();
            for (int i2 = 0; i2 < longArrayList.size(); ++i2) {
                long l3 = longArrayList.get(i2);
                if (l3 != l) continue;
                longArrayList.set(i2, l2);
                this.backingMap.put(n, longArrayList);
                ++this.writes;
                return n;
            }
        }
        return this.neutralKey;
    }

    @Override
    public int getOneKeyByValue(long l) {
        Iterator iterator = this.backingMap.entryIterator();
        while (iterator.hasNext()) {
            IntObjectMap$Entry intObjectMap$Entry = (IntObjectMap$Entry)iterator.next();
            int n = intObjectMap$Entry.getKey();
            LongArrayList longArrayList = (LongArrayList)intObjectMap$Entry.getValue();
            for (int i2 = 0; i2 < longArrayList.size(); ++i2) {
                if (l != longArrayList.get(i2)) continue;
                ++this.writes;
                return n;
            }
        }
        return this.neutralKey;
    }

    @Override
    public long[] valuesToArray() {
        return this.valuesToArray(new long[this.size()]);
    }

    @Override
    public long[] valuesToArray(long[] lArray) {
        long[] lArray2 = lArray;
        if (lArray.length < this.size()) {
            lArray2 = (long[])Array.newInstance(super.getClass().getComponentType(), this.size());
        }
        LongIterator longIterator = this.valueIterator();
        int n = 0;
        while (longIterator.hasNext()) {
            lArray2[n] = longIterator.next();
            ++n;
        }
        return lArray2;
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
    public IntLongMap synchronize() {
        return new SyncIntLongOptHashMap(this);
    }

    @Override
    public void putAll(IntLongMap intLongMap) {
        Iterator iterator = intLongMap.entrySet().iterator();
        while (iterator.hasNext()) {
            IntLongMap$Entry intLongMap$Entry = (IntLongMap$Entry)iterator.next();
            this.put(intLongMap$Entry.getKey(), intLongMap$Entry.getValue());
        }
    }

    static /* synthetic */ int access$000(IntLongMultimap intLongMultimap) {
        return intLongMultimap.neutralKey;
    }
}

