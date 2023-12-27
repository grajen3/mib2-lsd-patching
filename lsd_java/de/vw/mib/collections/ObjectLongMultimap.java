/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections;

import de.vw.mib.collections.ObjectIterator;
import de.vw.mib.collections.ObjectLongMap;
import de.vw.mib.collections.ObjectLongMap$Entry;
import de.vw.mib.collections.ObjectLongMultimap$1;
import de.vw.mib.collections.ObjectLongMultimap$2;
import de.vw.mib.collections.ObjectLongMultimap$3;
import de.vw.mib.collections.ObjectLongMultimap$4;
import de.vw.mib.collections.ObjectLongMultimap$5;
import de.vw.mib.collections.ObjectObjectMap;
import de.vw.mib.collections.ObjectObjectMap$Entry;
import de.vw.mib.collections.ObjectObjectOptHashMap;
import de.vw.mib.collections.SyncObjectLongOptHashMap;
import de.vw.mib.collections.longs.LongArrayList;
import de.vw.mib.collections.longs.LongCollection;
import de.vw.mib.collections.longs.LongIterator;
import de.vw.mib.collections.longs.LongReadOnlyArrayList;
import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Set;

public class ObjectLongMultimap
implements ObjectLongMap {
    final LongArrayList empty = new LongArrayList(0);
    private static final Object NEUTRAL_KEY = null;
    private static final long NEUTRAL_VALUE;
    final ObjectObjectMap backingMap;
    private final Object neutralKey = NEUTRAL_KEY;
    final long neutralValue;
    private int writes = 0;
    private int cachedSizeWritesCount;
    private int size;

    public ObjectLongMultimap() {
        this.neutralValue = 0L;
        this.backingMap = new ObjectObjectOptHashMap();
    }

    @Override
    public long put(Object object, long l) {
        long l2;
        LongArrayList longArrayList;
        if (!this.backingMap.containsKey(object)) {
            longArrayList = new LongArrayList();
            l2 = this.neutralValue;
        } else {
            longArrayList = this.getValuesList(object);
            l2 = longArrayList.last();
        }
        longArrayList.add(l);
        this.backingMap.put(object, longArrayList);
        ++this.writes;
        return l2;
    }

    private LongArrayList getValuesList(Object object) {
        return (LongArrayList)this.backingMap.get(object);
    }

    @Override
    public long get(Object object) {
        if (this.backingMap.containsKey(object)) {
            return this.getValuesList(object).last();
        }
        return this.neutralValue;
    }

    public LongCollection getAll(Object object) {
        if (this.backingMap.containsKey(object)) {
            LongArrayList longArrayList = this.getValuesList(object);
            return new LongReadOnlyArrayList(longArrayList);
        }
        return LongReadOnlyArrayList.EMPTY;
    }

    @Override
    public boolean containsKey(Object object) {
        return this.backingMap.containsKey(object);
    }

    public boolean containsKeyValuePair(Object object, long l) {
        if (this.backingMap.containsKey(object)) {
            LongArrayList longArrayList = this.getValuesList(object);
            return longArrayList.contains(l);
        }
        return false;
    }

    @Override
    public long remove(Object object) {
        LongArrayList longArrayList = (LongArrayList)this.backingMap.remove(object);
        if (null != longArrayList) {
            ++this.writes;
            return longArrayList.last();
        }
        return this.neutralValue;
    }

    public long removeValue(Object object, long l) {
        LongArrayList longArrayList = this.getValuesList(object);
        if (null == longArrayList) {
            return this.neutralValue;
        }
        boolean bl = longArrayList.removeValue(l);
        if (longArrayList.size() == 0) {
            this.backingMap.remove(object);
        } else {
            this.backingMap.put(object, longArrayList);
        }
        if (bl) {
            ++this.writes;
            return l;
        }
        return this.neutralValue;
    }

    @Override
    public Iterator keyIterator() {
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
        return new ObjectLongMultimap$1(this, iterator);
    }

    @Override
    public Set entrySet() {
        return new ObjectLongMultimap$2(this);
    }

    @Override
    public Set keySet() {
        return new ObjectLongMultimap$3(this);
    }

    @Override
    public LongCollection values() {
        return new ObjectLongMultimap$4(this);
    }

    @Override
    public LongIterator valueIterator() {
        Iterator iterator = this.backingMap.entryIterator();
        return new ObjectLongMultimap$5(this, iterator);
    }

    @Override
    public long replaceKey(Object object, Object object2) {
        Object object3 = this.backingMap.replaceKey(object, object2);
        if (null != object3) {
            ++this.writes;
            return ((LongArrayList)object3).last();
        }
        return this.neutralValue;
    }

    @Override
    public Object replaceOneValue(long l, long l2) {
        Iterator iterator = this.backingMap.entryIterator();
        while (iterator.hasNext()) {
            ObjectObjectMap$Entry objectObjectMap$Entry = (ObjectObjectMap$Entry)iterator.next();
            Object object = objectObjectMap$Entry.getKey();
            LongArrayList longArrayList = (LongArrayList)objectObjectMap$Entry.getValue();
            for (int i2 = 0; i2 < longArrayList.size(); ++i2) {
                long l3 = longArrayList.get(i2);
                if (l3 != l) continue;
                longArrayList.set(i2, l2);
                this.backingMap.put(object, longArrayList);
                ++this.writes;
                return object;
            }
        }
        return this.neutralKey;
    }

    @Override
    public Object getOneKeyByValue(long l) {
        Iterator iterator = this.backingMap.entryIterator();
        while (iterator.hasNext()) {
            ObjectObjectMap$Entry objectObjectMap$Entry = (ObjectObjectMap$Entry)iterator.next();
            Object object = objectObjectMap$Entry.getKey();
            LongArrayList longArrayList = (LongArrayList)objectObjectMap$Entry.getValue();
            for (int i2 = 0; i2 < longArrayList.size(); ++i2) {
                if (l != longArrayList.get(i2)) continue;
                ++this.writes;
                return object;
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
    public Object[] keysToArray() {
        return this.keysToArray(new Object[this.backingMap.size()]);
    }

    @Override
    public Object[] keysToArray(Object[] objectArray) {
        Object[] objectArray2 = objectArray;
        if (objectArray.length < this.backingMap.size()) {
            objectArray2 = (Object[])Array.newInstance(super.getClass().getComponentType(), this.backingMap.size());
        }
        Iterator iterator = this.keyIterator();
        int n = 0;
        while (iterator.hasNext()) {
            objectArray2[n] = iterator.next();
            ++n;
        }
        return objectArray2;
    }

    @Override
    public ObjectLongMap synchronize() {
        return new SyncObjectLongOptHashMap(this);
    }

    @Override
    public void putAll(ObjectLongMap objectLongMap) {
        Iterator iterator = objectLongMap.entrySet().iterator();
        while (iterator.hasNext()) {
            ObjectLongMap$Entry objectLongMap$Entry = (ObjectLongMap$Entry)iterator.next();
            this.put(objectLongMap$Entry.getKey(), objectLongMap$Entry.getValue());
        }
    }

    static /* synthetic */ Object access$000(ObjectLongMultimap objectLongMultimap) {
        return objectLongMultimap.neutralKey;
    }
}

