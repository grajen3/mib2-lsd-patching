/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections;

import de.vw.mib.collections.CollectionOverflowException;
import de.vw.mib.collections.CollectionWithExpansionPoint;
import de.vw.mib.collections.CollectionsHelper;
import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.collections.ObjectIntMap;
import de.vw.mib.collections.ObjectIntMap$Entry;
import de.vw.mib.collections.ObjectIntOptHashMap$Entry;
import de.vw.mib.collections.ObjectIntOptHashMap$EntryIterator;
import de.vw.mib.collections.ObjectIntOptHashMap$EntrySet;
import de.vw.mib.collections.ObjectIntOptHashMap$KeyIterator;
import de.vw.mib.collections.ObjectIntOptHashMap$KeySet;
import de.vw.mib.collections.ObjectIntOptHashMap$ValueCollection;
import de.vw.mib.collections.ObjectIntOptHashMap$ValueIterator;
import de.vw.mib.collections.OptHashMapHelper;
import de.vw.mib.collections.SyncObjectIntOptHashMap;
import de.vw.mib.collections.ints.IntCollection;
import de.vw.mib.collections.ints.IntIterator;
import de.vw.mib.util.StringBuilder;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

public class ObjectIntOptHashMap
implements CollectionWithExpansionPoint,
ObjectIntMap {
    private static final int MAP_TO_POSITIVE;
    private static final byte NOT_SET;
    private static final byte DELETED;
    private static final byte FILLED;
    private static final int NOT_FOUND_POS;
    private static final int NEUTRAL_VALUE;
    Object[] keys;
    int[] values;
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
    final int neutralValue;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$collections$ObjectIntOptHashMap;

    public static void copy(ObjectIntOptHashMap objectIntOptHashMap, ObjectIntOptHashMap objectIntOptHashMap2) {
        Iterator iterator = objectIntOptHashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            ObjectIntOptHashMap$Entry objectIntOptHashMap$Entry = (ObjectIntOptHashMap$Entry)iterator.next();
            objectIntOptHashMap2.put(objectIntOptHashMap$Entry.key, objectIntOptHashMap$Entry.value);
        }
    }

    public ObjectIntOptHashMap() {
        this(3, 63, 63, 49215, 0);
    }

    public ObjectIntOptHashMap(int n) {
        this(n, 63, 63, 49215, 0);
    }

    public ObjectIntOptHashMap(int n, float f2, float f3) {
        this(n, f2, f3, 49215, 0);
    }

    public ObjectIntOptHashMap(ObjectIntOptHashMap objectIntOptHashMap) {
        this.loadFactor = objectIntOptHashMap.loadFactor;
        this.resizeFactor = objectIntOptHashMap.resizeFactor;
        this.rehashStrategy = objectIntOptHashMap.rehashStrategy;
        this.neutralValue = objectIntOptHashMap.neutralValue;
        this.sizeWarningThreshold = objectIntOptHashMap.sizeWarningThreshold;
        Object[] objectArray = new Object[objectIntOptHashMap.arraySize];
        System.arraycopy((Object)objectIntOptHashMap.keys, 0, (Object)objectArray, 0, objectIntOptHashMap.arraySize);
        int[] nArray = new int[objectIntOptHashMap.arraySize];
        System.arraycopy((Object)objectIntOptHashMap.values, 0, (Object)nArray, 0, objectIntOptHashMap.arraySize);
        byte[] byArray = new byte[objectIntOptHashMap.arraySize];
        System.arraycopy((Object)objectIntOptHashMap.valueStates, 0, (Object)byArray, 0, objectIntOptHashMap.arraySize);
        this.init(objectArray, nArray, byArray, objectIntOptHashMap.size, objectIntOptHashMap.fill);
        this.writes = objectIntOptHashMap.writes;
    }

    private ObjectIntOptHashMap(int n, float f2, float f3, float f4, int n2) {
        if (!($assertionsDisabled || f2 >= 0.0f && f2 <= 1.0f)) {
            throw new AssertionError();
        }
        if (!($assertionsDisabled || f3 >= 0.0f && f3 <= 1.0f)) {
            throw new AssertionError();
        }
        this.loadFactor = f2;
        this.resizeFactor = f3;
        this.rehashStrategy = f4;
        this.neutralValue = n2;
        this.sizeWarningThreshold = n * 2 > CollectionsHelper.DEFAULT_SIZE_WARNING_THRESHOLD ? n * 2 : CollectionsHelper.DEFAULT_SIZE_WARNING_THRESHOLD;
        int n3 = OptHashMapHelper.capacityAtLeast(n, f2);
        this.init(new Object[n3], new int[n3], new byte[n3], 0, 0);
        this.writes = 0;
    }

    private ObjectIntOptHashMap(Object[] objectArray, int[] nArray, byte[] byArray, int n, int n2, float f2, float f3, float f4, int n3) {
        this.loadFactor = f2;
        this.resizeFactor = f3;
        this.rehashStrategy = f4;
        this.neutralValue = n3;
        this.sizeWarningThreshold = n * 2 > CollectionsHelper.DEFAULT_SIZE_WARNING_THRESHOLD ? n * 2 : CollectionsHelper.DEFAULT_SIZE_WARNING_THRESHOLD;
        this.init(objectArray, nArray, byArray, n, n2);
        this.writes = 0;
    }

    private void init(Object[] objectArray, int[] nArray, byte[] byArray, int n, int n2) {
        this.keys = objectArray;
        this.values = nArray;
        this.valueStates = byArray;
        this.size = n;
        this.fill = n2;
        this.arraySize = this.keys.length;
        this.rehashThreshold = (int)(this.loadFactor * (float)this.arraySize);
    }

    public static ObjectIntOptHashMap createFromInternalData(Object[] objectArray) {
        return ObjectIntOptHashMap.createFromInternalData(objectArray, 0);
    }

    public static ObjectIntOptHashMap createFromInternalData(Object[] objectArray, int n) {
        int[] nArray = (int[])objectArray[3 + n];
        return new ObjectIntOptHashMap((Object[])objectArray[0 + n], (int[])objectArray[1 + n], (byte[])objectArray[2 + n], nArray[0], nArray[1], Float.intBitsToFloat(nArray[2]), Float.intBitsToFloat(nArray[3]), Float.intBitsToFloat(nArray[4]), ((int[])objectArray[4 + n])[0]);
    }

    public static ObjectIntOptHashMap createSlowlyGrowingHashmap(int n, float f2, float f3) {
        return new ObjectIntOptHashMap(n, f2, f3, -842232769, 0);
    }

    public static ObjectIntOptHashMap createWithNeutralValue(int n, float f2, float f3, int n2) {
        return new ObjectIntOptHashMap(n, f2, f3, 49215, n2);
    }

    public Object[] getInternalData() {
        this.pack();
        Object[] objectArray = new Object[OptHashMapHelper.getLengthOfOptHashMapInternalData()];
        objectArray[0] = this.keys;
        objectArray[1] = this.values;
        objectArray[2] = this.valueStates;
        objectArray[3] = new int[]{this.size, this.fill, Float.floatToIntBits(this.loadFactor), Float.floatToIntBits(this.resizeFactor), Float.floatToIntBits(this.rehashStrategy)};
        objectArray[4] = new int[]{this.neutralValue};
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
        int[] nArray = this.values;
        byte[] byArray = this.valueStates;
        this.init(new Object[n], new int[n], new byte[n], 0, 0);
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            if (byArray[i2] != 2) continue;
            this.put(objectArray[i2], nArray[i2]);
        }
        if (this.size > this.sizeWarningThreshold) {
            CollectionsHelper.writeSizeWarning("ObjectIntOptHashMap", this.arraySize, 5);
        }
    }

    @Override
    public int put(Object object, int n) {
        int n2 = this.calcHash(object);
        int n3 = -1;
        ++this.writes;
        switch (this.valueStates[n2]) {
            case 0: {
                this.keys[n2] = object;
                this.values[n2] = n;
                this.valueStates[n2] = 2;
                ++this.size;
                ++this.fill;
                if (this.mustRehash()) {
                    this.rehash();
                }
                this.onCollectionChanged();
                return this.neutralValue;
            }
            case 1: {
                if (this.keys[n2] == object || this.keys[n2] != null && this.keys[n2].equals(object)) {
                    this.values[n2] = n;
                    this.valueStates[n2] = 2;
                    ++this.size;
                    this.onCollectionChanged();
                    return this.neutralValue;
                }
                n3 = n2;
                break;
            }
            case 2: {
                if (this.keys[n2] != object && (this.keys[n2] == null || !this.keys[n2].equals(object))) break;
                int n4 = this.values[n2];
                this.values[n2] = n;
                this.onCollectionChanged();
                return n4;
            }
        }
        int n5 = n2;
        int n6 = n2;
        block15: for (int i2 = 1; i2 < this.arraySize; i2 += 2) {
            if ((n5 += i2) >= this.arraySize) {
                n5 -= this.arraySize;
            }
            switch (this.valueStates[n5]) {
                case 0: {
                    if (n3 < 0) {
                        n3 = n5;
                        ++this.fill;
                    }
                    this.keys[n3] = object;
                    this.values[n3] = n;
                    this.valueStates[n3] = 2;
                    ++this.size;
                    if (this.mustRehash()) {
                        this.rehash();
                    }
                    this.onCollectionChanged();
                    return this.neutralValue;
                }
                case 1: {
                    if (n3 >= 0) break;
                    n3 = n5;
                    break;
                }
                case 2: {
                    if (this.keys[n5] != object && (this.keys[n5] == null || !this.keys[n5].equals(object))) break;
                    int n7 = this.values[n5];
                    this.values[n5] = n;
                    this.onCollectionChanged();
                    return n7;
                }
            }
            if ((n6 -= i2) < 0) {
                n6 += this.arraySize;
            }
            switch (this.valueStates[n6]) {
                case 0: {
                    if (n3 < 0) {
                        n3 = n6;
                        ++this.fill;
                    }
                    this.keys[n3] = object;
                    this.values[n3] = n;
                    this.valueStates[n3] = 2;
                    ++this.size;
                    if (this.mustRehash()) {
                        this.rehash();
                    }
                    this.onCollectionChanged();
                    return this.neutralValue;
                }
                case 1: {
                    if (n3 >= 0) continue block15;
                    n3 = n6;
                    continue block15;
                }
                case 2: {
                    if (this.keys[n6] != object && (this.keys[n6] == null || !this.keys[n6].equals(object))) continue block15;
                    int n8 = this.values[n6];
                    this.values[n6] = n;
                    this.onCollectionChanged();
                    return n8;
                }
            }
        }
        throw new CollectionOverflowException(new StringBuffer().append("Map overflow on adding (").append(object).append(",").append(n).append(").").toString());
    }

    @Override
    public int get(Object object) {
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
    public int remove(Object object) {
        int n = this.removePos(this.findKey(object));
        this.onCollectionChanged();
        return n;
    }

    int removePos(int n) {
        if (n == 128) {
            return this.neutralValue;
        }
        int n2 = this.values[n];
        this.valueStates[n] = 1;
        --this.size;
        ++this.writes;
        return n2;
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
    public boolean containsValue(int n) {
        return this.findOneValuePos(n) != 128;
    }

    int findOneValuePos(int n) {
        int n2;
        int n3 = this.lastFoundWhere;
        if (this.valueStates[n3] == 2 && n == this.values[n3]) {
            return n3;
        }
        for (n2 = n3 + 1; n2 < this.values.length; ++n2) {
            if (this.valueStates[n2] != 2 || this.values[n2] != n) continue;
            this.lastFoundWhere = n2;
            return n2;
        }
        for (n2 = 0; n2 < n3; ++n2) {
            if (this.valueStates[n2] != 2 || this.values[n2] != n) continue;
            this.lastFoundWhere = n2;
            return n2;
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
            int n = this.get(object);
            stringBuilder.append(string).append(object).append("<-").append(n);
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
        return new ObjectIntOptHashMap$EntryIterator(this);
    }

    @Override
    public Set entrySet() {
        return new ObjectIntOptHashMap$EntrySet(this);
    }

    @Override
    public Iterator keyIterator() {
        return new ObjectIntOptHashMap$KeyIterator(this);
    }

    @Override
    public Set keySet() {
        return new ObjectIntOptHashMap$KeySet(this);
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (null == object || object.getClass() != super.getClass()) {
            return false;
        }
        ObjectIntOptHashMap objectIntOptHashMap = (ObjectIntOptHashMap)object;
        if (objectIntOptHashMap.size != this.size) {
            return false;
        }
        if (objectIntOptHashMap.neutralValue != this.neutralValue) {
            return false;
        }
        Iterator iterator = this.entrySet().iterator();
        while (iterator.hasNext()) {
            ObjectIntOptHashMap$Entry objectIntOptHashMap$Entry = (ObjectIntOptHashMap$Entry)iterator.next();
            if (!objectIntOptHashMap.containsKey(objectIntOptHashMap$Entry.key)) {
                return false;
            }
            int n = objectIntOptHashMap.get(objectIntOptHashMap$Entry.key);
            if (n == objectIntOptHashMap$Entry.value) continue;
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
    public Object getOneKeyByValue(int n) {
        int n2 = this.findOneValuePos(n);
        if (128 == n2) {
            return null;
        }
        return this.keys[n2];
    }

    @Override
    public int replaceKey(Object object, Object object2) {
        int n = this.findKey(object);
        if (128 == n) {
            return this.neutralValue;
        }
        int n2 = this.removePos(n);
        return this.put(object2, n2);
    }

    @Override
    public Object replaceOneValue(int n, int n2) {
        int n3 = this.findOneValuePos(n);
        if (128 == n3) {
            return null;
        }
        ++this.writes;
        this.values[n3] = n2;
        this.onCollectionChanged();
        return this.keys[n3];
    }

    @Override
    public IntIterator valueIterator() {
        return new ObjectIntOptHashMap$ValueIterator(this);
    }

    @Override
    public IntCollection values() {
        return new ObjectIntOptHashMap$ValueCollection(this);
    }

    @Override
    public int[] valuesToArray() {
        return this.valuesToArray(new int[this.size]);
    }

    @Override
    public int[] valuesToArray(int[] nArray) {
        int[] nArray2 = nArray;
        if (nArray.length < this.size) {
            nArray2 = (int[])Array.newInstance(super.getClass().getComponentType(), this.size);
        }
        int n = this.arraySize;
        for (int i2 = this.size - 1; i2 >= 0; --i2) {
            while (this.valueStates[--n] == 0 || this.valueStates[n] == 1) {
            }
            nArray2[i2] = this.values[n];
        }
        return nArray2;
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
        $assertionsDisabled = !(class$de$vw$mib$collections$ObjectIntOptHashMap == null ? (class$de$vw$mib$collections$ObjectIntOptHashMap = ObjectIntOptHashMap.class$("de.vw.mib.collections.ObjectIntOptHashMap")) : class$de$vw$mib$collections$ObjectIntOptHashMap).desiredAssertionStatus();
    }
}

