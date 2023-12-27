/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections;

import de.vw.mib.collections.ObjectArrayList;
import de.vw.mib.collections.ObjectCollection;
import de.vw.mib.collections.ObjectIterator;
import de.vw.mib.collections.ObjectObjectMap;
import de.vw.mib.collections.ObjectObjectMap$Entry;
import de.vw.mib.collections.ObjectObjectMultimap$1;
import de.vw.mib.collections.ObjectObjectMultimap$2;
import de.vw.mib.collections.ObjectObjectMultimap$3;
import de.vw.mib.collections.ObjectObjectMultimap$4;
import de.vw.mib.collections.ObjectObjectMultimap$5;
import de.vw.mib.collections.ObjectObjectOptHashMap;
import de.vw.mib.collections.ObjectReadOnlyArrayList;
import de.vw.mib.collections.SyncObjectObjectOptHashMap;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ObjectObjectMultimap
implements ObjectObjectMap {
    final ObjectArrayList empty = new ObjectArrayList(0);
    private static final Object NEUTRAL_KEY = null;
    private static final Object NEUTRAL_VALUE = null;
    final ObjectObjectMap backingMap;
    private final Object neutralKey;
    final Object neutralValue = NEUTRAL_VALUE;
    private int writes = 0;
    private int cachedSizeWritesCount;
    private int size;

    public ObjectObjectMultimap() {
        this.neutralKey = NEUTRAL_KEY;
        this.backingMap = new ObjectObjectOptHashMap();
    }

    @Override
    public Object put(Object object, Object object2) {
        Object object3;
        ObjectArrayList objectArrayList;
        if (!this.backingMap.containsKey(object)) {
            objectArrayList = new ObjectArrayList();
            object3 = this.neutralValue;
        } else {
            objectArrayList = this.getValuesList(object);
            object3 = objectArrayList.last();
        }
        objectArrayList.add(object2);
        this.backingMap.put(object, objectArrayList);
        ++this.writes;
        return object3;
    }

    private ObjectArrayList getValuesList(Object object) {
        return (ObjectArrayList)this.backingMap.get(object);
    }

    @Override
    public Object get(Object object) {
        if (this.backingMap.containsKey(object)) {
            return this.getValuesList(object).last();
        }
        return this.neutralValue;
    }

    public ObjectCollection getAll(Object object) {
        if (this.backingMap.containsKey(object)) {
            ObjectArrayList objectArrayList = this.getValuesList(object);
            return new ObjectReadOnlyArrayList(objectArrayList);
        }
        return ObjectReadOnlyArrayList.EMPTY;
    }

    @Override
    public boolean containsKey(Object object) {
        return this.backingMap.containsKey(object);
    }

    public boolean containsKeyValuePair(Object object, Object object2) {
        if (this.backingMap.containsKey(object)) {
            ObjectArrayList objectArrayList = this.getValuesList(object);
            return objectArrayList.contains(object2);
        }
        return false;
    }

    @Override
    public Object remove(Object object) {
        ObjectArrayList objectArrayList = (ObjectArrayList)this.backingMap.remove(object);
        if (null != objectArrayList) {
            ++this.writes;
            return objectArrayList.last();
        }
        return this.neutralValue;
    }

    public Object removeValue(Object object, Object object2) {
        ObjectArrayList objectArrayList = this.getValuesList(object);
        if (null == objectArrayList) {
            return this.neutralValue;
        }
        boolean bl = objectArrayList.removeValue(object2);
        if (objectArrayList.size() == 0) {
            this.backingMap.remove(object);
        } else {
            this.backingMap.put(object, objectArrayList);
        }
        if (bl) {
            ++this.writes;
            return object2;
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
        return new ObjectObjectMultimap$1(this, iterator);
    }

    @Override
    public Set entrySet() {
        return new ObjectObjectMultimap$2(this);
    }

    @Override
    public Set keySet() {
        return new ObjectObjectMultimap$3(this);
    }

    @Override
    public Collection values() {
        return new ObjectObjectMultimap$4(this);
    }

    @Override
    public Iterator valueIterator() {
        Iterator iterator = this.backingMap.entryIterator();
        return new ObjectObjectMultimap$5(this, iterator);
    }

    @Override
    public Object replaceKey(Object object, Object object2) {
        Object object3 = this.backingMap.replaceKey(object, object2);
        if (null != object3) {
            ++this.writes;
            return ((ObjectArrayList)object3).last();
        }
        return this.neutralValue;
    }

    @Override
    public Object replaceOneValue(Object object, Object object2) {
        Iterator iterator = this.backingMap.entryIterator();
        while (iterator.hasNext()) {
            ObjectObjectMap$Entry objectObjectMap$Entry = (ObjectObjectMap$Entry)iterator.next();
            Object object3 = objectObjectMap$Entry.getKey();
            ObjectArrayList objectArrayList = (ObjectArrayList)objectObjectMap$Entry.getValue();
            for (int i2 = 0; i2 < objectArrayList.size(); ++i2) {
                Object object4 = objectArrayList.get(i2);
                if (object4 != object) continue;
                objectArrayList.set(i2, object2);
                this.backingMap.put(object3, objectArrayList);
                ++this.writes;
                return object3;
            }
        }
        return this.neutralKey;
    }

    @Override
    public Object getOneKeyByValue(Object object) {
        Iterator iterator = this.backingMap.entryIterator();
        while (iterator.hasNext()) {
            ObjectObjectMap$Entry objectObjectMap$Entry = (ObjectObjectMap$Entry)iterator.next();
            Object object2 = objectObjectMap$Entry.getKey();
            ObjectArrayList objectArrayList = (ObjectArrayList)objectObjectMap$Entry.getValue();
            for (int i2 = 0; i2 < objectArrayList.size(); ++i2) {
                if (object != objectArrayList.get(i2)) continue;
                ++this.writes;
                return object2;
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
    public ObjectObjectMap synchronize() {
        return new SyncObjectObjectOptHashMap(this);
    }

    @Override
    public void putAll(Map map) {
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            ObjectObjectMap$Entry objectObjectMap$Entry = (ObjectObjectMap$Entry)iterator.next();
            this.put(objectObjectMap$Entry.getKey(), objectObjectMap$Entry.getValue());
        }
    }

    static /* synthetic */ Object access$000(ObjectObjectMultimap objectObjectMultimap) {
        return objectObjectMultimap.neutralKey;
    }
}

