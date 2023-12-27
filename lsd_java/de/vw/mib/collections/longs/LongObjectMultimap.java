/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.longs;

import de.vw.mib.collections.ObjectArrayList;
import de.vw.mib.collections.ObjectCollection;
import de.vw.mib.collections.ObjectIterator;
import de.vw.mib.collections.ObjectReadOnlyArrayList;
import de.vw.mib.collections.longs.LongIterator;
import de.vw.mib.collections.longs.LongObjectMap;
import de.vw.mib.collections.longs.LongObjectMap$Entry;
import de.vw.mib.collections.longs.LongObjectMultimap$1;
import de.vw.mib.collections.longs.LongObjectMultimap$2;
import de.vw.mib.collections.longs.LongObjectMultimap$3;
import de.vw.mib.collections.longs.LongObjectMultimap$4;
import de.vw.mib.collections.longs.LongObjectMultimap$5;
import de.vw.mib.collections.longs.LongObjectOptHashMap;
import de.vw.mib.collections.longs.LongSet;
import de.vw.mib.collections.longs.SyncLongObjectOptHashMap;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class LongObjectMultimap
implements LongObjectMap {
    final ObjectArrayList empty = new ObjectArrayList(0);
    private static final long NEUTRAL_KEY;
    private static final Object NEUTRAL_VALUE;
    final LongObjectMap backingMap;
    private final long neutralKey;
    final Object neutralValue = NEUTRAL_VALUE;
    private int writes = 0;
    private int cachedSizeWritesCount;
    private int size;

    public LongObjectMultimap() {
        this.neutralKey = 0L;
        this.backingMap = new LongObjectOptHashMap();
    }

    @Override
    public Object put(long l, Object object) {
        Object object2;
        ObjectArrayList objectArrayList;
        if (!this.backingMap.containsKey(l)) {
            objectArrayList = new ObjectArrayList();
            object2 = this.neutralValue;
        } else {
            objectArrayList = this.getValuesList(l);
            object2 = objectArrayList.last();
        }
        objectArrayList.add(object);
        this.backingMap.put(l, objectArrayList);
        ++this.writes;
        return object2;
    }

    private ObjectArrayList getValuesList(long l) {
        return (ObjectArrayList)this.backingMap.get(l);
    }

    @Override
    public Object get(long l) {
        if (this.backingMap.containsKey(l)) {
            return this.getValuesList(l).last();
        }
        return this.neutralValue;
    }

    public ObjectCollection getAll(long l) {
        if (this.backingMap.containsKey(l)) {
            ObjectArrayList objectArrayList = this.getValuesList(l);
            return new ObjectReadOnlyArrayList(objectArrayList);
        }
        return ObjectReadOnlyArrayList.EMPTY;
    }

    @Override
    public boolean containsKey(long l) {
        return this.backingMap.containsKey(l);
    }

    public boolean containsKeyValuePair(long l, Object object) {
        if (this.backingMap.containsKey(l)) {
            ObjectArrayList objectArrayList = this.getValuesList(l);
            return objectArrayList.contains(object);
        }
        return false;
    }

    @Override
    public Object remove(long l) {
        ObjectArrayList objectArrayList = (ObjectArrayList)this.backingMap.remove(l);
        if (null != objectArrayList) {
            ++this.writes;
            return objectArrayList.last();
        }
        return this.neutralValue;
    }

    public Object removeValue(long l, Object object) {
        ObjectArrayList objectArrayList = this.getValuesList(l);
        if (null == objectArrayList) {
            return this.neutralValue;
        }
        boolean bl = objectArrayList.removeValue(object);
        if (objectArrayList.size() == 0) {
            this.backingMap.remove(l);
        } else {
            this.backingMap.put(l, objectArrayList);
        }
        if (bl) {
            ++this.writes;
            return object;
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
            ObjectArrayList objectArrayList = (ObjectArrayList)objectIterator.next();
            if (null == objectArrayList) continue;
            n += objectArrayList.size();
        }
        return n;
    }

    @Override
    public boolean isEmpty() {
        return this.backingMap.isEmpty();
    }

    @Override
    public boolean containsValue(Object object) {
        ObjectIterator objectIterator = (ObjectIterator)this.backingMap.valueIterator();
        while (objectIterator.hasNext()) {
            ObjectArrayList objectArrayList = (ObjectArrayList)objectIterator.next();
            for (int i2 = objectArrayList.size() - 1; i2 >= 0; --i2) {
                if (objectArrayList.get(i2) != object) continue;
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
        return new LongObjectMultimap$1(this, iterator);
    }

    @Override
    public Set entrySet() {
        return new LongObjectMultimap$2(this);
    }

    @Override
    public LongSet keySet() {
        return new LongObjectMultimap$3(this);
    }

    @Override
    public Collection values() {
        return new LongObjectMultimap$4(this);
    }

    @Override
    public Iterator valueIterator() {
        Iterator iterator = this.backingMap.entryIterator();
        return new LongObjectMultimap$5(this, iterator);
    }

    @Override
    public Object replaceKey(long l, long l2) {
        Object object = this.backingMap.replaceKey(l, l2);
        if (null != object) {
            ++this.writes;
            return ((ObjectArrayList)object).last();
        }
        return this.neutralValue;
    }

    @Override
    public long replaceOneValue(Object object, Object object2) {
        Iterator iterator = this.backingMap.entryIterator();
        while (iterator.hasNext()) {
            LongObjectMap$Entry longObjectMap$Entry = (LongObjectMap$Entry)iterator.next();
            long l = longObjectMap$Entry.getKey();
            ObjectArrayList objectArrayList = (ObjectArrayList)longObjectMap$Entry.getValue();
            for (int i2 = 0; i2 < objectArrayList.size(); ++i2) {
                Object object3 = objectArrayList.get(i2);
                if (object3 != object) continue;
                objectArrayList.set(i2, object2);
                this.backingMap.put(l, objectArrayList);
                ++this.writes;
                return l;
            }
        }
        return this.neutralKey;
    }

    @Override
    public long getOneKeyByValue(Object object) {
        Iterator iterator = this.backingMap.entryIterator();
        while (iterator.hasNext()) {
            LongObjectMap$Entry longObjectMap$Entry = (LongObjectMap$Entry)iterator.next();
            long l = longObjectMap$Entry.getKey();
            ObjectArrayList objectArrayList = (ObjectArrayList)longObjectMap$Entry.getValue();
            for (int i2 = 0; i2 < objectArrayList.size(); ++i2) {
                if (object != objectArrayList.get(i2)) continue;
                ++this.writes;
                return l;
            }
        }
        return this.neutralKey;
    }

    @Override
    public Object[] valuesToArray() {
        return this.valuesToArray(new Object[this.size()]);
    }

    @Override
    public Object[] valuesToArray(Object[] objectArray) {
        Object[] objectArray2 = objectArray;
        if (objectArray.length < this.size()) {
            objectArray2 = (Object[])Array.newInstance(super.getClass().getComponentType(), this.size());
        }
        Iterator iterator = this.valueIterator();
        int n = 0;
        while (iterator.hasNext()) {
            objectArray2[n] = iterator.next();
            ++n;
        }
        return objectArray2;
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
    public LongObjectMap synchronize() {
        return new SyncLongObjectOptHashMap(this);
    }

    @Override
    public void putAll(LongObjectMap longObjectMap) {
        Iterator iterator = longObjectMap.entrySet().iterator();
        while (iterator.hasNext()) {
            LongObjectMap$Entry longObjectMap$Entry = (LongObjectMap$Entry)iterator.next();
            this.put(longObjectMap$Entry.getKey(), longObjectMap$Entry.getValue());
        }
    }

    static /* synthetic */ long access$000(LongObjectMultimap longObjectMultimap) {
        return longObjectMultimap.neutralKey;
    }

    static {
        NEUTRAL_VALUE = null;
    }
}

