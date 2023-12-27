/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections;

import de.vw.mib.collections.CollectionOverflowException;
import de.vw.mib.collections.CollectionWithExpansionPoint;
import de.vw.mib.collections.CollectionsHelper;
import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.collections.ObjectLongMap;
import de.vw.mib.collections.ObjectLongMap$Entry;
import de.vw.mib.collections.ObjectLongOptHashMap$Entry;
import de.vw.mib.collections.ObjectLongOptHashMap$EntryIterator;
import de.vw.mib.collections.ObjectLongOptHashMap$EntrySet;
import de.vw.mib.collections.ObjectLongOptHashMap$KeyIterator;
import de.vw.mib.collections.ObjectLongOptHashMap$KeySet;
import de.vw.mib.collections.ObjectLongOptHashMap$ValueCollection;
import de.vw.mib.collections.ObjectLongOptHashMap$ValueIterator;
import de.vw.mib.collections.OptHashMapHelper;
import de.vw.mib.collections.SyncObjectLongOptHashMap;
import de.vw.mib.collections.longs.LongCollection;
import de.vw.mib.collections.longs.LongIterator;
import de.vw.mib.util.StringBuilder;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

public class ObjectLongOptHashMap
implements CollectionWithExpansionPoint,
ObjectLongMap {
    private static final int MAP_TO_POSITIVE;
    private static final byte NOT_SET;
    private static final byte DELETED;
    private static final byte FILLED;
    private static final int NOT_FOUND_POS;
    private static final long NEUTRAL_VALUE;
    Object[] keys;
    long[] values;
    byte[] valueStates;
    int size;
    private int fill;
    private int rehashThreshold;
    private int arraySize;
    final float loadFactor;
    final float resizeFactor;
    int lastFoundWhere;
    private int sizeWarningThreshold;
    int writes;
    private int hashCodeWrites = -1;
    private int hashCode = 0;
    private final float rehashStrategy;
    final long neutralValue;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$collections$ObjectLongOptHashMap;

    public static void copy(ObjectLongOptHashMap objectLongOptHashMap, ObjectLongOptHashMap objectLongOptHashMap2) {
        Iterator iterator = objectLongOptHashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            ObjectLongOptHashMap$Entry objectLongOptHashMap$Entry = (ObjectLongOptHashMap$Entry)iterator.next();
            objectLongOptHashMap2.put(objectLongOptHashMap$Entry.key, objectLongOptHashMap$Entry.value);
        }
    }

    public ObjectLongOptHashMap() {
        this(3, 63, 63, 49215, 0L);
    }

    public ObjectLongOptHashMap(int n) {
        this(n, 63, 63, 49215, 0L);
    }

    public ObjectLongOptHashMap(int n, float f2, float f3) {
        this(n, f2, f3, 49215, 0L);
    }

    public ObjectLongOptHashMap(ObjectLongOptHashMap objectLongOptHashMap) {
        this.loadFactor = objectLongOptHashMap.loadFactor;
        this.resizeFactor = objectLongOptHashMap.resizeFactor;
        this.rehashStrategy = objectLongOptHashMap.rehashStrategy;
        this.neutralValue = objectLongOptHashMap.neutralValue;
        this.sizeWarningThreshold = objectLongOptHashMap.sizeWarningThreshold;
        Object[] objectArray = new Object[objectLongOptHashMap.arraySize];
        System.arraycopy((Object)objectLongOptHashMap.keys, 0, (Object)objectArray, 0, objectLongOptHashMap.arraySize);
        long[] lArray = new long[objectLongOptHashMap.arraySize];
        System.arraycopy((Object)objectLongOptHashMap.values, 0, (Object)lArray, 0, objectLongOptHashMap.arraySize);
        byte[] byArray = new byte[objectLongOptHashMap.arraySize];
        System.arraycopy((Object)objectLongOptHashMap.valueStates, 0, (Object)byArray, 0, objectLongOptHashMap.arraySize);
        this.init(objectArray, lArray, byArray, objectLongOptHashMap.size, objectLongOptHashMap.fill);
        this.writes = objectLongOptHashMap.writes;
    }

    private ObjectLongOptHashMap(int n, float f2, float f3, float f4, long l) {
        if (!($assertionsDisabled || f2 >= 0.0f && f2 <= 1.0f)) {
            throw new AssertionError();
        }
        if (!($assertionsDisabled || f3 >= 0.0f && f3 <= 1.0f)) {
            throw new AssertionError();
        }
        this.loadFactor = f2;
        this.resizeFactor = f3;
        this.rehashStrategy = f4;
        this.neutralValue = l;
        this.sizeWarningThreshold = n * 2 > CollectionsHelper.DEFAULT_SIZE_WARNING_THRESHOLD ? n * 2 : CollectionsHelper.DEFAULT_SIZE_WARNING_THRESHOLD;
        int n2 = OptHashMapHelper.capacityAtLeast(n, f2);
        this.init(new Object[n2], new long[n2], new byte[n2], 0, 0);
        this.writes = 0;
    }

    private ObjectLongOptHashMap(Object[] objectArray, long[] lArray, byte[] byArray, int n, int n2, float f2, float f3, float f4, long l) {
        this.loadFactor = f2;
        this.resizeFactor = f3;
        this.rehashStrategy = f4;
        this.neutralValue = l;
        this.sizeWarningThreshold = n * 2 > CollectionsHelper.DEFAULT_SIZE_WARNING_THRESHOLD ? n * 2 : CollectionsHelper.DEFAULT_SIZE_WARNING_THRESHOLD;
        this.init(objectArray, lArray, byArray, n, n2);
        this.writes = 0;
    }

    private void init(Object[] objectArray, long[] lArray, byte[] byArray, int n, int n2) {
        this.keys = objectArray;
        this.values = lArray;
        this.valueStates = byArray;
        this.size = n;
        this.fill = n2;
        this.arraySize = this.keys.length;
        this.rehashThreshold = (int)(this.loadFactor * (float)this.arraySize);
    }

    public static ObjectLongOptHashMap createFromInternalData(Object[] objectArray) {
        return ObjectLongOptHashMap.createFromInternalData(objectArray, 0);
    }

    public static ObjectLongOptHashMap createFromInternalData(Object[] objectArray, int n) {
        int[] nArray = (int[])objectArray[3 + n];
        return new ObjectLongOptHashMap((Object[])objectArray[0 + n], (long[])objectArray[1 + n], (byte[])objectArray[2 + n], nArray[0], nArray[1], Float.intBitsToFloat(nArray[2]), Float.intBitsToFloat(nArray[3]), Float.intBitsToFloat(nArray[4]), ((long[])objectArray[4 + n])[0]);
    }

    public static ObjectLongOptHashMap createSlowlyGrowingHashmap(int n, float f2, float f3) {
        return new ObjectLongOptHashMap(n, f2, f3, -842232769, 0L);
    }

    public static ObjectLongOptHashMap createWithNeutralValue(int n, float f2, float f3, long l) {
        return new ObjectLongOptHashMap(n, f2, f3, 49215, l);
    }

    public Object[] getInternalData() {
        this.pack();
        Object[] objectArray = new Object[OptHashMapHelper.getLengthOfOptHashMapInternalData()];
        objectArray[0] = this.keys;
        objectArray[1] = this.values;
        objectArray[2] = this.valueStates;
        objectArray[3] = new int[]{this.size, this.fill, Float.floatToIntBits(this.loadFactor), Float.floatToIntBits(this.resizeFactor), Float.floatToIntBits(this.rehashStrategy)};
        objectArray[4] = new long[]{this.neutralValue};
        return objectArray;
    }

    public void setSizeWarningThreshold(int n) {
        this.sizeWarningThreshold = n;
    }

    private void pack() {
        int n;
        if (this.rehashThreshold < this.arraySize && (n = OptHashMapHelper.capacityAtLeast(this.size, this.resizeFactor)) < this.arraySize) {
            this.rehash(n);
        }
    }

    private void rehash(int n) {
        Object[] objectArray = this.keys;
        long[] lArray = this.values;
        byte[] byArray = this.valueStates;
        this.init(new Object[n], new long[n], new byte[n], 0, 0);
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            if (byArray[i2] != 2) continue;
            this.put(objectArray[i2], lArray[i2]);
        }
        if (this.size > this.sizeWarningThreshold) {
            CollectionsHelper.writeSizeWarning("ObjectLongOptHashMap", this.arraySize, 5);
        }
    }

    @Override
    public long put(Object object, long l) {
        int n = this.calcHash(object);
        int n2 = -1;
        ++this.writes;
        switch (this.valueStates[n]) {
            case 0: {
                this.keys[n] = object;
                this.values[n] = l;
                this.valueStates[n] = 2;
                ++this.size;
                ++this.fill;
                if (this.mustRehash()) {
                    this.rehash();
                }
                this.onCollectionChanged();
                return this.neutralValue;
            }
            case 1: {
                if (this.keys[n] == object || this.keys[n] != null && this.keys[n].equals(object)) {
                    this.values[n] = l;
                    this.valueStates[n] = 2;
                    ++this.size;
                    this.onCollectionChanged();
                    return this.neutralValue;
                }
                n2 = n;
                break;
            }
            case 2: {
                if (this.keys[n] != object && (this.keys[n] == null || !this.keys[n].equals(object))) break;
                long l2 = this.values[n];
                this.values[n] = l;
                this.onCollectionChanged();
                return l2;
            }
        }
        int n3 = n;
        int n4 = n;
        block15: for (int i2 = 1; i2 < this.arraySize; i2 += 2) {
            if ((n3 += i2) >= this.arraySize) {
                n3 -= this.arraySize;
            }
            switch (this.valueStates[n3]) {
                case 0: {
                    if (n2 < 0) {
                        n2 = n3;
                        ++this.fill;
                    }
                    this.keys[n2] = object;
                    this.values[n2] = l;
                    this.valueStates[n2] = 2;
                    ++this.size;
                    if (this.mustRehash()) {
                        this.rehash();
                    }
                    this.onCollectionChanged();
                    return this.neutralValue;
                }
                case 1: {
                    if (n2 >= 0) break;
                    n2 = n3;
                    break;
                }
                case 2: {
                    if (this.keys[n3] != object && (this.keys[n3] == null || !this.keys[n3].equals(object))) break;
                    long l3 = this.values[n3];
                    this.values[n3] = l;
                    this.onCollectionChanged();
                    return l3;
                }
            }
            if ((n4 -= i2) < 0) {
                n4 += this.arraySize;
            }
            switch (this.valueStates[n4]) {
                case 0: {
                    if (n2 < 0) {
                        n2 = n4;
                        ++this.fill;
                    }
                    this.keys[n2] = object;
                    this.values[n2] = l;
                    this.valueStates[n2] = 2;
                    ++this.size;
                    if (this.mustRehash()) {
                        this.rehash();
                    }
                    this.onCollectionChanged();
                    return this.neutralValue;
                }
                case 1: {
                    if (n2 >= 0) continue block15;
                    n2 = n4;
                    continue block15;
                }
                case 2: {
                    if (this.keys[n4] != object && (this.keys[n4] == null || !this.keys[n4].equals(object))) continue block15;
                    long l4 = this.values[n4];
                    this.values[n4] = l;
                    this.onCollectionChanged();
                    return l4;
                }
            }
        }
        throw new CollectionOverflowException(new StringBuffer().append("Map overflow on adding (").append(object).append(",").append(l).append(").").toString());
    }

    @Override
    public long get(Object object) {
        int n = this.findKey(object);
        if (n == 128) {
            return this.neutralValue;
        }
        return this.values[n];
    }

    @Override
    public boolean containsKey(Object object) {
        return this.findKey(object) != 128;
    }

    @Override
    public long remove(Object object) {
        long l = this.removePos(this.findKey(object));
        this.onCollectionChanged();
        return l;
    }

    long removePos(int n) {
        if (n == 128) {
            return this.neutralValue;
        }
        long l = this.values[n];
        this.valueStates[n] = 1;
        --this.size;
        ++this.writes;
        return l;
    }

    int findKey(Object object) {
        int n = this.lastFoundWhere;
        if ((object == this.keys[n] || object != null && object.equals(this.keys[n])) && this.valueStates[n] == 2) {
            return n;
        }
        int n2 = this.calcHash(object);
        switch (this.valueStates[n2]) {
            case 0: {
                return 128;
            }
            case 1: {
                if (this.keys[n2] != object && (this.keys[n2] == null || !this.keys[n2].equals(object))) break;
                return 128;
            }
            case 2: {
                if (this.keys[n2] != object && (this.keys[n2] == null || !this.keys[n2].equals(object))) break;
                this.lastFoundWhere = n2;
                return n2;
            }
        }
        int n3 = n2;
        int n4 = n2;
        block15: for (int i2 = 1; i2 < this.arraySize; i2 += 2) {
            if ((n3 += i2) >= this.arraySize) {
                n3 -= this.arraySize;
            }
            switch (this.valueStates[n3]) {
                case 0: {
                    return 128;
                }
                case 1: {
                    if (this.keys[n3] != object && (this.keys[n3] == null || !this.keys[n3].equals(object))) break;
                    return 128;
                }
                case 2: {
                    if (this.keys[n3] != object && (this.keys[n3] == null || !this.keys[n3].equals(object))) break;
                    this.lastFoundWhere = n3;
                    return n3;
                }
            }
            if ((n4 -= i2) < 0) {
                n4 += this.arraySize;
            }
            switch (this.valueStates[n4]) {
                case 0: {
                    return 128;
                }
                case 1: {
                    if (this.keys[n4] != object && (this.keys[n4] == null || !this.keys[n4].equals(object))) continue block15;
                    return 128;
                }
                case 2: {
                    if (this.keys[n4] != object && (this.keys[n4] == null || !this.keys[n4].equals(object))) continue block15;
                    this.lastFoundWhere = n4;
                    return n4;
                }
            }
        }
        return 128;
    }

    private int calcHash(Object object) {
        return ((null == object ? 0 : object.hashCode()) & 0xFFFFFF7F) % this.arraySize;
    }

    @Override
    public boolean containsValue(long l) {
        return this.findOneValuePos(l) != 128;
    }

    int findOneValuePos(long l) {
        int n;
        int n2 = this.lastFoundWhere;
        if (this.valueStates[n2] == 2 && l == this.values[n2]) {
            return n2;
        }
        for (n = n2 + 1; n < this.values.length; ++n) {
            if (this.valueStates[n] != 2 || this.values[n] != l) continue;
            this.lastFoundWhere = n;
            return n;
        }
        for (n = 0; n < n2; ++n) {
            if (this.valueStates[n] != 2 || this.values[n] != l) continue;
            this.lastFoundWhere = n;
            return n;
        }
        return 128;
    }

    private boolean mustRehash() {
        return this.fill > this.rehashThreshold || (float)this.size < (float)this.fill * this.resizeFactor;
    }

    private void rehash() {
        if ((float)this.size > (float)this.fill * this.resizeFactor) {
            this.rehash(OptHashMapHelper.capacityAtLeast((int)((float)this.arraySize * this.rehashStrategy + 1.0f)));
        } else {
            this.rehash(this.arraySize);
        }
    }

    @Override
    public void clear() {
        Arrays.fill(this.valueStates, (byte)0);
        this.size = 0;
        this.fill = 0;
        ++this.writes;
        this.onCollectionChanged();
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        String string = "";
        for (int i2 = 0; i2 < this.keys.length; ++i2) {
            Object object = this.keys[i2];
            if (this.valueStates[i2] != 2) continue;
            long l = this.get(object);
            stringBuilder.append(string).append(object).append("<-").append(l);
            string = ", ";
        }
        return stringBuilder.append("]").toString();
    }

    @Override
    public void ensureAvailableSpaceAndAvoidFurtherRehashes(int n) {
        this.rehash(OptHashMapHelper.capacityAtLeast(this.size + n));
        this.rehashThreshold = this.arraySize;
    }

    @Override
    public Iterator entryIterator() {
        return new ObjectLongOptHashMap$EntryIterator(this);
    }

    @Override
    public Set entrySet() {
        return new ObjectLongOptHashMap$EntrySet(this);
    }

    @Override
    public Iterator keyIterator() {
        return new ObjectLongOptHashMap$KeyIterator(this);
    }

    @Override
    public Set keySet() {
        return new ObjectLongOptHashMap$KeySet(this);
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (null == object || object.getClass() != super.getClass()) {
            return false;
        }
        ObjectLongOptHashMap objectLongOptHashMap = (ObjectLongOptHashMap)object;
        if (objectLongOptHashMap.size != this.size) {
            return false;
        }
        if (objectLongOptHashMap.neutralValue != this.neutralValue) {
            return false;
        }
        Iterator iterator = this.entrySet().iterator();
        while (iterator.hasNext()) {
            ObjectLongOptHashMap$Entry objectLongOptHashMap$Entry = (ObjectLongOptHashMap$Entry)iterator.next();
            if (!objectLongOptHashMap.containsKey(objectLongOptHashMap$Entry.key)) {
                return false;
            }
            long l = objectLongOptHashMap.get(objectLongOptHashMap$Entry.key);
            if (l == objectLongOptHashMap$Entry.value) continue;
            return false;
        }
        return true;
    }

    public int hashCode() {
        if (this.writes != this.hashCodeWrites) {
            long l = HashCodeBuilder.hash(this.size()) + HashCodeBuilder.hash(this.neutralValue);
            for (int i2 = this.keys.length - 1; i2 >= 0; --i2) {
                if (this.valueStates[i2] != 2) continue;
                l ^= HashCodeBuilder.hash(this.keys[i2]) + HashCodeBuilder.hash(this.values[i2]);
            }
            this.hashCodeWrites = this.writes;
            this.hashCode = (int)l;
        }
        return this.hashCode;
    }

    @Override
    public Object getOneKeyByValue(long l) {
        int n = this.findOneValuePos(l);
        if (128 == n) {
            return null;
        }
        return this.keys[n];
    }

    @Override
    public long replaceKey(Object object, Object object2) {
        int n = this.findKey(object);
        if (128 == n) {
            return this.neutralValue;
        }
        long l = this.removePos(n);
        return this.put(object2, l);
    }

    @Override
    public Object replaceOneValue(long l, long l2) {
        int n = this.findOneValuePos(l);
        if (128 == n) {
            return null;
        }
        ++this.writes;
        this.values[n] = l2;
        this.onCollectionChanged();
        return this.keys[n];
    }

    @Override
    public LongIterator valueIterator() {
        return new ObjectLongOptHashMap$ValueIterator(this);
    }

    @Override
    public LongCollection values() {
        return new ObjectLongOptHashMap$ValueCollection(this);
    }

    @Override
    public long[] valuesToArray() {
        return this.valuesToArray(new long[this.size]);
    }

    @Override
    public long[] valuesToArray(long[] lArray) {
        long[] lArray2 = lArray;
        if (lArray.length < this.size) {
            lArray2 = (long[])Array.newInstance(super.getClass().getComponentType(), this.size);
        }
        int n = this.arraySize;
        for (int i2 = this.size - 1; i2 >= 0; --i2) {
            while (this.valueStates[--n] == 0 || this.valueStates[n] == 1) {
            }
            lArray2[i2] = this.values[n];
        }
        return lArray2;
    }

    @Override
    public Object[] keysToArray() {
        return this.keysToArray(new Object[this.size]);
    }

    @Override
    public Object[] keysToArray(Object[] objectArray) {
        Object[] objectArray2 = objectArray;
        if (objectArray.length < this.size) {
            objectArray2 = (Object[])Array.newInstance(super.getClass().getComponentType(), this.size);
        }
        int n = this.arraySize;
        for (int i2 = this.size - 1; i2 >= 0; --i2) {
            while (this.valueStates[--n] == 0 || this.valueStates[n] == 1) {
            }
            objectArray2[i2] = this.keys[n];
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

    @Override
    public void onCollectionChanged() {
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        $assertionsDisabled = !(class$de$vw$mib$collections$ObjectLongOptHashMap == null ? (class$de$vw$mib$collections$ObjectLongOptHashMap = ObjectLongOptHashMap.class$("de.vw.mib.collections.ObjectLongOptHashMap")) : class$de$vw$mib$collections$ObjectLongOptHashMap).desiredAssertionStatus();
    }
}

