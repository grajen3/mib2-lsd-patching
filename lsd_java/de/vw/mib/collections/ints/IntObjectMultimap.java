/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.ints;

import de.vw.mib.collections.ObjectArrayList;
import de.vw.mib.collections.ObjectCollection;
import de.vw.mib.collections.ObjectIterator;
import de.vw.mib.collections.ObjectReadOnlyArrayList;
import de.vw.mib.collections.ints.IntIterator;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectMap$Entry;
import de.vw.mib.collections.ints.IntObjectMultimap$1;
import de.vw.mib.collections.ints.IntObjectMultimap$2;
import de.vw.mib.collections.ints.IntObjectMultimap$3;
import de.vw.mib.collections.ints.IntObjectMultimap$4;
import de.vw.mib.collections.ints.IntObjectMultimap$5;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.collections.ints.IntSet;
import de.vw.mib.collections.ints.SyncIntObjectOptHashMap;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class IntObjectMultimap
implements IntObjectMap {
    final ObjectArrayList empty = new ObjectArrayList(0);
    private static final int NEUTRAL_KEY;
    private static final Object NEUTRAL_VALUE;
    final IntObjectMap backingMap;
    private final int neutralKey;
    final Object neutralValue = NEUTRAL_VALUE;
    private int writes = 0;
    private int cachedSizeWritesCount;
    private int size;

    public IntObjectMultimap() {
        this.neutralKey = 0;
        this.backingMap = new IntObjectOptHashMap();
    }

    @Override
    public Object put(int n, Object object) {
        Object object2;
        ObjectArrayList objectArrayList;
        if (!this.backingMap.containsKey(n)) {
            objectArrayList = new ObjectArrayList();
            object2 = this.neutralValue;
        } else {
            objectArrayList = this.getValuesList(n);
            object2 = objectArrayList.last();
        }
        objectArrayList.add(object);
        this.backingMap.put(n, objectArrayList);
        ++this.writes;
        return object2;
    }

    private ObjectArrayList getValuesList(int n) {
        return (ObjectArrayList)this.backingMap.get(n);
    }

    @Override
    public Object get(int n) {
        if (this.backingMap.containsKey(n)) {
            return this.getValuesList(n).last();
        }
        return this.neutralValue;
    }

    public ObjectCollection getAll(int n) {
        if (this.backingMap.containsKey(n)) {
            ObjectArrayList objectArrayList = this.getValuesList(n);
            return new ObjectReadOnlyArrayList(objectArrayList);
        }
        return ObjectReadOnlyArrayList.EMPTY;
    }

    @Override
    public boolean containsKey(int n) {
        return this.backingMap.containsKey(n);
    }

    public boolean containsKeyValuePair(int n, Object object) {
        if (this.backingMap.containsKey(n)) {
            ObjectArrayList objectArrayList = this.getValuesList(n);
            return objectArrayList.contains(object);
        }
        return false;
    }

    @Override
    public Object remove(int n) {
        ObjectArrayList objectArrayList = (ObjectArrayList)this.backingMap.remove(n);
        if (null != objectArrayList) {
            ++this.writes;
            return objectArrayList.last();
        }
        return this.neutralValue;
    }

    public Object removeValue(int n, Object object) {
        ObjectArrayList objectArrayList = this.getValuesList(n);
        if (null == objectArrayList) {
            return this.neutralValue;
        }
        boolean bl = objectArrayList.removeValue(object);
        if (objectArrayList.size() == 0) {
            this.backingMap.remove(n);
        } else {
            this.backingMap.put(n, objectArrayList);
        }
        if (bl) {
            ++this.writes;
            return object;
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
        return new IntObjectMultimap$1(this, iterator);
    }

    @Override
    public Set entrySet() {
        return new IntObjectMultimap$2(this);
    }

    @Override
    public IntSet keySet() {
        return new IntObjectMultimap$3(this);
    }

    @Override
    public Collection values() {
        return new IntObjectMultimap$4(this);
    }

    @Override
    public Iterator valueIterator() {
        Iterator iterator = this.backingMap.entryIterator();
        return new IntObjectMultimap$5(this, iterator);
    }

    @Override
    public Object replaceKey(int n, int n2) {
        Object object = this.backingMap.replaceKey(n, n2);
        if (null != object) {
            ++this.writes;
            return ((ObjectArrayList)object).last();
        }
        return this.neutralValue;
    }

    @Override
    public int replaceOneValue(Object object, Object object2) {
        Iterator iterator = this.backingMap.entryIterator();
        while (iterator.hasNext()) {
            IntObjectMap$Entry intObjectMap$Entry = (IntObjectMap$Entry)iterator.next();
            int n = intObjectMap$Entry.getKey();
            ObjectArrayList objectArrayList = (ObjectArrayList)intObjectMap$Entry.getValue();
            for (int i2 = 0; i2 < objectArrayList.size(); ++i2) {
                Object object3 = objectArrayList.get(i2);
                if (object3 != object) continue;
                objectArrayList.set(i2, object2);
                this.backingMap.put(n, objectArrayList);
                ++this.writes;
                return n;
            }
        }
        return this.neutralKey;
    }

    @Override
    public int getOneKeyByValue(Object object) {
        Iterator iterator = this.backingMap.entryIterator();
        while (iterator.hasNext()) {
            IntObjectMap$Entry intObjectMap$Entry = (IntObjectMap$Entry)iterator.next();
            int n = intObjectMap$Entry.getKey();
            ObjectArrayList objectArrayList = (ObjectArrayList)intObjectMap$Entry.getValue();
            for (int i2 = 0; i2 < objectArrayList.size(); ++i2) {
                if (object != objectArrayList.get(i2)) continue;
                ++this.writes;
                return n;
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
    public IntObjectMap synchronize() {
        return new SyncIntObjectOptHashMap(this);
    }

    @Override
    public void putAll(IntObjectMap intObjectMap) {
        Iterator iterator = intObjectMap.entrySet().iterator();
        while (iterator.hasNext()) {
            IntObjectMap$Entry intObjectMap$Entry = (IntObjectMap$Entry)iterator.next();
            this.put(intObjectMap$Entry.getKey(), intObjectMap$Entry.getValue());
        }
    }

    static /* synthetic */ int access$000(IntObjectMultimap intObjectMultimap) {
        return intObjectMultimap.neutralKey;
    }

    static {
        NEUTRAL_VALUE = null;
    }
}

