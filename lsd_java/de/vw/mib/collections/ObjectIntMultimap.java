/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections;

import de.vw.mib.collections.ObjectIntMap;
import de.vw.mib.collections.ObjectIntMap$Entry;
import de.vw.mib.collections.ObjectIntMultimap$1;
import de.vw.mib.collections.ObjectIntMultimap$2;
import de.vw.mib.collections.ObjectIntMultimap$3;
import de.vw.mib.collections.ObjectIntMultimap$4;
import de.vw.mib.collections.ObjectIntMultimap$5;
import de.vw.mib.collections.ObjectIterator;
import de.vw.mib.collections.ObjectObjectMap;
import de.vw.mib.collections.ObjectObjectMap$Entry;
import de.vw.mib.collections.ObjectObjectOptHashMap;
import de.vw.mib.collections.SyncObjectIntOptHashMap;
import de.vw.mib.collections.ints.IntArrayList;
import de.vw.mib.collections.ints.IntCollection;
import de.vw.mib.collections.ints.IntIterator;
import de.vw.mib.collections.ints.IntReadOnlyArrayList;
import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Set;

public class ObjectIntMultimap
implements ObjectIntMap {
    final IntArrayList empty = new IntArrayList(0);
    private static final Object NEUTRAL_KEY = null;
    private static final int NEUTRAL_VALUE;
    final ObjectObjectMap backingMap;
    private final Object neutralKey = NEUTRAL_KEY;
    final int neutralValue;
    private int writes = 0;
    private int cachedSizeWritesCount;
    private int size;

    public ObjectIntMultimap() {
        this.neutralValue = 0;
        this.backingMap = new ObjectObjectOptHashMap();
    }

    @Override
    public int put(Object object, int n) {
        int n2;
        IntArrayList intArrayList;
        if (!this.backingMap.containsKey(object)) {
            intArrayList = new IntArrayList();
            n2 = this.neutralValue;
        } else {
            intArrayList = this.getValuesList(object);
            n2 = intArrayList.last();
        }
        intArrayList.add(n);
        this.backingMap.put(object, intArrayList);
        ++this.writes;
        return n2;
    }

    private IntArrayList getValuesList(Object object) {
        return (IntArrayList)this.backingMap.get(object);
    }

    @Override
    public int get(Object object) {
        if (this.backingMap.containsKey(object)) {
            return this.getValuesList(object).last();
        }
        return this.neutralValue;
    }

    public IntCollection getAll(Object object) {
        if (this.backingMap.containsKey(object)) {
            IntArrayList intArrayList = this.getValuesList(object);
            return new IntReadOnlyArrayList(intArrayList);
        }
        return IntReadOnlyArrayList.EMPTY;
    }

    @Override
    public boolean containsKey(Object object) {
        return this.backingMap.containsKey(object);
    }

    public boolean containsKeyValuePair(Object object, int n) {
        if (this.backingMap.containsKey(object)) {
            IntArrayList intArrayList = this.getValuesList(object);
            return intArrayList.contains(n);
        }
        return false;
    }

    @Override
    public int remove(Object object) {
        IntArrayList intArrayList = (IntArrayList)this.backingMap.remove(object);
        if (null != intArrayList) {
            ++this.writes;
            return intArrayList.last();
        }
        return this.neutralValue;
    }

    public int removeValue(Object object, int n) {
        IntArrayList intArrayList = this.getValuesList(object);
        if (null == intArrayList) {
            return this.neutralValue;
        }
        boolean bl = intArrayList.removeValue(n);
        if (intArrayList.size() == 0) {
            this.backingMap.remove(object);
        } else {
            this.backingMap.put(object, intArrayList);
        }
        if (bl) {
            ++this.writes;
            return n;
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
        return new ObjectIntMultimap$1(this, iterator);
    }

    @Override
    public Set entrySet() {
        return new ObjectIntMultimap$2(this);
    }

    @Override
    public Set keySet() {
        return new ObjectIntMultimap$3(this);
    }

    @Override
    public IntCollection values() {
        return new ObjectIntMultimap$4(this);
    }

    @Override
    public IntIterator valueIterator() {
        Iterator iterator = this.backingMap.entryIterator();
        return new ObjectIntMultimap$5(this, iterator);
    }

    @Override
    public int replaceKey(Object object, Object object2) {
        Object object3 = this.backingMap.replaceKey(object, object2);
        if (null != object3) {
            ++this.writes;
            return ((IntArrayList)object3).last();
        }
        return this.neutralValue;
    }

    @Override
    public Object replaceOneValue(int n, int n2) {
        Iterator iterator = this.backingMap.entryIterator();
        while (iterator.hasNext()) {
            ObjectObjectMap$Entry objectObjectMap$Entry = (ObjectObjectMap$Entry)iterator.next();
            Object object = objectObjectMap$Entry.getKey();
            IntArrayList intArrayList = (IntArrayList)objectObjectMap$Entry.getValue();
            for (int i2 = 0; i2 < intArrayList.size(); ++i2) {
                int n3 = intArrayList.get(i2);
                if (n3 != n) continue;
                intArrayList.set(i2, n2);
                this.backingMap.put(object, intArrayList);
                ++this.writes;
                return object;
            }
        }
        return this.neutralKey;
    }

    @Override
    public Object getOneKeyByValue(int n) {
        Iterator iterator = this.backingMap.entryIterator();
        while (iterator.hasNext()) {
            ObjectObjectMap$Entry objectObjectMap$Entry = (ObjectObjectMap$Entry)iterator.next();
            Object object = objectObjectMap$Entry.getKey();
            IntArrayList intArrayList = (IntArrayList)objectObjectMap$Entry.getValue();
            for (int i2 = 0; i2 < intArrayList.size(); ++i2) {
                if (n != intArrayList.get(i2)) continue;
                ++this.writes;
                return object;
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
    public ObjectIntMap synchronize() {
        return new SyncObjectIntOptHashMap(this);
    }

    @Override
    public void putAll(ObjectIntMap objectIntMap) {
        Iterator iterator = objectIntMap.entrySet().iterator();
        while (iterator.hasNext()) {
            ObjectIntMap$Entry objectIntMap$Entry = (ObjectIntMap$Entry)iterator.next();
            this.put(objectIntMap$Entry.getKey(), objectIntMap$Entry.getValue());
        }
    }

    static /* synthetic */ Object access$000(ObjectIntMultimap objectIntMultimap) {
        return objectIntMultimap.neutralKey;
    }
}

