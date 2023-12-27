/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.longs;

import de.vw.mib.collections.ObjectIterator;
import de.vw.mib.collections.longs.LongArrayList;
import de.vw.mib.collections.longs.LongCollection;
import de.vw.mib.collections.longs.LongIterator;
import de.vw.mib.collections.longs.LongLongMap;
import de.vw.mib.collections.longs.LongLongMap$Entry;
import de.vw.mib.collections.longs.LongLongMultimap$1;
import de.vw.mib.collections.longs.LongLongMultimap$2;
import de.vw.mib.collections.longs.LongLongMultimap$3;
import de.vw.mib.collections.longs.LongLongMultimap$4;
import de.vw.mib.collections.longs.LongLongMultimap$5;
import de.vw.mib.collections.longs.LongObjectMap;
import de.vw.mib.collections.longs.LongObjectMap$Entry;
import de.vw.mib.collections.longs.LongObjectOptHashMap;
import de.vw.mib.collections.longs.LongReadOnlyArrayList;
import de.vw.mib.collections.longs.LongSet;
import de.vw.mib.collections.longs.SyncLongLongOptHashMap;
import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Set;

public class LongLongMultimap
implements LongLongMap {
    final LongArrayList empty = new LongArrayList(0);
    private static final long NEUTRAL_KEY;
    private static final long NEUTRAL_VALUE;
    final LongObjectMap backingMap = new LongObjectOptHashMap();
    private final long neutralKey;
    final long neutralValue;
    private int writes = 0;
    private int cachedSizeWritesCount;
    private int size;

    public LongLongMultimap() {
        this.neutralValue = 0L;
        this.neutralKey = 0L;
    }

    @Override
    public long put(long l, long l2) {
        long l3;
        LongArrayList longArrayList;
        if (!this.backingMap.containsKey(l)) {
            longArrayList = new LongArrayList();
            l3 = this.neutralValue;
        } else {
            longArrayList = this.getValuesList(l);
            l3 = longArrayList.last();
        }
        longArrayList.add(l2);
        this.backingMap.put(l, longArrayList);
        ++this.writes;
        return l3;
    }

    private LongArrayList getValuesList(long l) {
        return (LongArrayList)this.backingMap.get(l);
    }

    @Override
    public long get(long l) {
        if (this.backingMap.containsKey(l)) {
            return this.getValuesList(l).last();
        }
        return this.neutralValue;
    }

    public LongCollection getAll(long l) {
        if (this.backingMap.containsKey(l)) {
            LongArrayList longArrayList = this.getValuesList(l);
            return new LongReadOnlyArrayList(longArrayList);
        }
        return LongReadOnlyArrayList.EMPTY;
    }

    @Override
    public boolean containsKey(long l) {
        return this.backingMap.containsKey(l);
    }

    public boolean containsKeyValuePair(long l, long l2) {
        if (this.backingMap.containsKey(l)) {
            LongArrayList longArrayList = this.getValuesList(l);
            return longArrayList.contains(l2);
        }
        return false;
    }

    @Override
    public long remove(long l) {
        LongArrayList longArrayList = (LongArrayList)this.backingMap.remove(l);
        if (null != longArrayList) {
            ++this.writes;
            return longArrayList.last();
        }
        return this.neutralValue;
    }

    public long removeValue(long l, long l2) {
        LongArrayList longArrayList = this.getValuesList(l);
        if (null == longArrayList) {
            return this.neutralValue;
        }
        boolean bl = longArrayList.removeValue(l2);
        if (longArrayList.size() == 0) {
            this.backingMap.remove(l);
        } else {
            this.backingMap.put(l, longArrayList);
        }
        if (bl) {
            ++this.writes;
            return l2;
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
        return new LongLongMultimap$1(this, iterator);
    }

    @Override
    public Set entrySet() {
        return new LongLongMultimap$2(this);
    }

    @Override
    public LongSet keySet() {
        return new LongLongMultimap$3(this);
    }

    @Override
    public LongCollection values() {
        return new LongLongMultimap$4(this);
    }

    @Override
    public LongIterator valueIterator() {
        Iterator iterator = this.backingMap.entryIterator();
        return new LongLongMultimap$5(this, iterator);
    }

    @Override
    public long replaceKey(long l, long l2) {
        Object object = this.backingMap.replaceKey(l, l2);
        if (null != object) {
            ++this.writes;
            return ((LongArrayList)object).last();
        }
        return this.neutralValue;
    }

    @Override
    public long replaceOneValue(long l, long l2) {
        Iterator iterator = this.backingMap.entryIterator();
        while (iterator.hasNext()) {
            LongObjectMap$Entry longObjectMap$Entry = (LongObjectMap$Entry)iterator.next();
            long l3 = longObjectMap$Entry.getKey();
            LongArrayList longArrayList = (LongArrayList)longObjectMap$Entry.getValue();
            for (int i2 = 0; i2 < longArrayList.size(); ++i2) {
                long l4 = longArrayList.get(i2);
                if (l4 != l) continue;
                longArrayList.set(i2, l2);
                this.backingMap.put(l3, longArrayList);
                ++this.writes;
                return l3;
            }
        }
        return this.neutralKey;
    }

    @Override
    public long getOneKeyByValue(long l) {
        Iterator iterator = this.backingMap.entryIterator();
        while (iterator.hasNext()) {
            LongObjectMap$Entry longObjectMap$Entry = (LongObjectMap$Entry)iterator.next();
            long l2 = longObjectMap$Entry.getKey();
            LongArrayList longArrayList = (LongArrayList)longObjectMap$Entry.getValue();
            for (int i2 = 0; i2 < longArrayList.size(); ++i2) {
                if (l != longArrayList.get(i2)) continue;
                ++this.writes;
                return l2;
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
    public LongLongMap synchronize() {
        return new SyncLongLongOptHashMap(this);
    }

    @Override
    public void putAll(LongLongMap longLongMap) {
        Iterator iterator = longLongMap.entrySet().iterator();
        while (iterator.hasNext()) {
            LongLongMap$Entry longLongMap$Entry = (LongLongMap$Entry)iterator.next();
            this.put(longLongMap$Entry.getKey(), longLongMap$Entry.getValue());
        }
    }

    static /* synthetic */ long access$000(LongLongMultimap longLongMultimap) {
        return longLongMultimap.neutralKey;
    }
}

