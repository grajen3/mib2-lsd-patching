/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.longs;

import de.vw.mib.collections.CollectionOverflowException;
import de.vw.mib.collections.CollectionWithExpansionPoint;
import de.vw.mib.collections.CollectionsHelper;
import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.collections.OptHashMapHelper;
import de.vw.mib.collections.longs.LongIterator;
import de.vw.mib.collections.longs.LongObjectMap;
import de.vw.mib.collections.longs.LongObjectMap$Entry;
import de.vw.mib.collections.longs.LongObjectOptHashMap$Entry;
import de.vw.mib.collections.longs.LongObjectOptHashMap$EntryIterator;
import de.vw.mib.collections.longs.LongObjectOptHashMap$EntrySet;
import de.vw.mib.collections.longs.LongObjectOptHashMap$KeyIterator;
import de.vw.mib.collections.longs.LongObjectOptHashMap$KeySet;
import de.vw.mib.collections.longs.LongObjectOptHashMap$ValueCollection;
import de.vw.mib.collections.longs.LongObjectOptHashMap$ValueIterator;
import de.vw.mib.collections.longs.LongSet;
import de.vw.mib.collections.longs.SyncLongObjectOptHashMap;
import de.vw.mib.util.StringBuilder;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class LongObjectOptHashMap
implements CollectionWithExpansionPoint,
LongObjectMap {
    private static final int MAP_TO_POSITIVE;
    private static final byte NOT_SET;
    private static final byte DELETED;
    private static final byte FILLED;
    private static final int NOT_FOUND_POS;
    private static final Object NEUTRAL_VALUE;
    long[] keys;
    Object[] values;
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
    final Object neutralValue;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$collections$longs$LongObjectOptHashMap;

    public static void copy(LongObjectOptHashMap longObjectOptHashMap, LongObjectOptHashMap longObjectOptHashMap2) {
        Iterator iterator = longObjectOptHashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            LongObjectOptHashMap$Entry longObjectOptHashMap$Entry = (LongObjectOptHashMap$Entry)iterator.next();
            longObjectOptHashMap2.put(longObjectOptHashMap$Entry.key, longObjectOptHashMap$Entry.value);
        }
    }

    public LongObjectOptHashMap() {
        this(3, 63, 63, 49215, NEUTRAL_VALUE);
    }

    public LongObjectOptHashMap(int n) {
        this(n, 63, 63, 49215, NEUTRAL_VALUE);
    }

    public LongObjectOptHashMap(int n, float f2, float f3) {
        this(n, f2, f3, 49215, NEUTRAL_VALUE);
    }

    public LongObjectOptHashMap(LongObjectOptHashMap longObjectOptHashMap) {
        this.loadFactor = longObjectOptHashMap.loadFactor;
        this.resizeFactor = longObjectOptHashMap.resizeFactor;
        this.rehashStrategy = longObjectOptHashMap.rehashStrategy;
        this.neutralValue = longObjectOptHashMap.neutralValue;
        this.sizeWarningThreshold = longObjectOptHashMap.sizeWarningThreshold;
        long[] lArray = new long[longObjectOptHashMap.arraySize];
        System.arraycopy((Object)longObjectOptHashMap.keys, 0, (Object)lArray, 0, longObjectOptHashMap.arraySize);
        Object[] objectArray = new Object[longObjectOptHashMap.arraySize];
        System.arraycopy((Object)longObjectOptHashMap.values, 0, (Object)objectArray, 0, longObjectOptHashMap.arraySize);
        byte[] byArray = new byte[longObjectOptHashMap.arraySize];
        System.arraycopy((Object)longObjectOptHashMap.valueStates, 0, (Object)byArray, 0, longObjectOptHashMap.arraySize);
        this.init(lArray, objectArray, byArray, longObjectOptHashMap.size, longObjectOptHashMap.fill);
        this.writes = longObjectOptHashMap.writes;
    }

    private LongObjectOptHashMap(int n, float f2, float f3, float f4, Object object) {
        if (!($assertionsDisabled || f2 >= 0.0f && f2 <= 1.0f)) {
            throw new AssertionError();
        }
        if (!($assertionsDisabled || f3 >= 0.0f && f3 <= 1.0f)) {
            throw new AssertionError();
        }
        this.loadFactor = f2;
        this.resizeFactor = f3;
        this.rehashStrategy = f4;
        this.neutralValue = object;
        this.sizeWarningThreshold = n * 2 > CollectionsHelper.DEFAULT_SIZE_WARNING_THRESHOLD ? n * 2 : CollectionsHelper.DEFAULT_SIZE_WARNING_THRESHOLD;
        int n2 = OptHashMapHelper.capacityAtLeast(n, f2);
        this.init(new long[n2], new Object[n2], new byte[n2], 0, 0);
        this.writes = 0;
    }

    private LongObjectOptHashMap(long[] lArray, Object[] objectArray, byte[] byArray, int n, int n2, float f2, float f3, float f4, Object object) {
        this.loadFactor = f2;
        this.resizeFactor = f3;
        this.rehashStrategy = f4;
        this.neutralValue = object;
        this.sizeWarningThreshold = n * 2 > CollectionsHelper.DEFAULT_SIZE_WARNING_THRESHOLD ? n * 2 : CollectionsHelper.DEFAULT_SIZE_WARNING_THRESHOLD;
        this.init(lArray, objectArray, byArray, n, n2);
        this.writes = 0;
    }

    private void init(long[] lArray, Object[] objectArray, byte[] byArray, int n, int n2) {
        this.keys = lArray;
        this.values = objectArray;
        this.valueStates = byArray;
        this.size = n;
        this.fill = n2;
        this.arraySize = this.keys.length;
        this.rehashThreshold = (int)(this.loadFactor * (float)this.arraySize);
    }

    public static LongObjectOptHashMap createFromInternalData(Object[] objectArray) {
        return LongObjectOptHashMap.createFromInternalData(objectArray, 0);
    }

    public static LongObjectOptHashMap createFromInternalData(Object[] objectArray, int n) {
        int[] nArray = (int[])objectArray[3 + n];
        return new LongObjectOptHashMap((long[])objectArray[0 + n], (Object[])objectArray[1 + n], (byte[])objectArray[2 + n], nArray[0], nArray[1], Float.intBitsToFloat(nArray[2]), Float.intBitsToFloat(nArray[3]), Float.intBitsToFloat(nArray[4]), ((Object[])objectArray[4 + n])[0]);
    }

    public static LongObjectOptHashMap createSlowlyGrowingHashmap(int n, float f2, float f3) {
        return new LongObjectOptHashMap(n, f2, f3, -842232769, NEUTRAL_VALUE);
    }

    public static LongObjectOptHashMap createWithNeutralValue(int n, float f2, float f3, Object object) {
        return new LongObjectOptHashMap(n, f2, f3, 49215, object);
    }

    public Object[] getInternalData() {
        this.pack();
        Object[] objectArray = new Object[OptHashMapHelper.getLengthOfOptHashMapInternalData()];
        objectArray[0] = this.keys;
        objectArray[1] = this.values;
        objectArray[2] = this.valueStates;
        objectArray[3] = new int[]{this.size, this.fill, Float.floatToIntBits(this.loadFactor), Float.floatToIntBits(this.resizeFactor), Float.floatToIntBits(this.rehashStrategy)};
        objectArray[4] = new Object[]{this.neutralValue};
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
        long[] lArray = this.keys;
        Object[] objectArray = this.values;
        byte[] byArray = this.valueStates;
        this.init(new long[n], new Object[n], new byte[n], 0, 0);
        for (int i2 = lArray.length - 1; i2 >= 0; --i2) {
            if (byArray[i2] != 2) continue;
            this.put(lArray[i2], objectArray[i2]);
        }
        if (this.size > this.sizeWarningThreshold) {
            CollectionsHelper.writeSizeWarning("LongObjectOptHashMap", this.arraySize, 5);
        }
    }

    @Override
    public Object put(long l, Object object) {
        int n = this.calcHash(l);
        int n2 = -1;
        ++this.writes;
        switch (this.valueStates[n]) {
            case 0: {
                this.keys[n] = l;
                this.values[n] = object;
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
                if (this.keys[n] == l) {
                    this.values[n] = object;
                    this.valueStates[n] = 2;
                    ++this.size;
                    this.onCollectionChanged();
                    return this.neutralValue;
                }
                n2 = n;
                break;
            }
            case 2: {
                if (this.keys[n] != l) break;
                Object object2 = this.values[n];
                this.values[n] = object;
                this.onCollectionChanged();
                return object2;
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
                    this.keys[n2] = l;
                    this.values[n2] = object;
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
                    if (this.keys[n3] != l) break;
                    Object object3 = this.values[n3];
                    this.values[n3] = object;
                    this.onCollectionChanged();
                    return object3;
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
                    this.keys[n2] = l;
                    this.values[n2] = object;
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
                    if (this.keys[n4] != l) continue block15;
                    Object object4 = this.values[n4];
                    this.values[n4] = object;
                    this.onCollectionChanged();
                    return object4;
                }
            }
        }
        throw new CollectionOverflowException(new StringBuffer().append("Map overflow on adding (").append(l).append(",").append(object).append(").").toString());
    }

    @Override
    public Object get(long l) {
        int n = this.findKey(l);
        if (n == 128) {
            return this.neutralValue;
        }
        return this.values[n];
    }

    @Override
    public boolean containsKey(long l) {
        return this.findKey(l) != 128;
    }

    @Override
    public Object remove(long l) {
        Object object = this.removePos(this.findKey(l));
        this.onCollectionChanged();
        return object;
    }

    Object removePos(int n) {
        if (n == 128) {
            return this.neutralValue;
        }
        Object object = this.values[n];
        this.valueStates[n] = 1;
        --this.size;
        ++this.writes;
        return object;
    }

    int findKey(long l) {
        int n = this.lastFoundWhere;
        if (l == this.keys[n] && this.valueStates[n] == 2) {
            return n;
        }
        int n2 = this.calcHash(l);
        switch (this.valueStates[n2]) {
            case 0: {
                return 128;
            }
            case 1: {
                if (this.keys[n2] != l) break;
                return 128;
            }
            case 2: {
                if (this.keys[n2] != l) break;
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
                    if (this.keys[n3] != l) break;
                    return 128;
                }
                case 2: {
                    if (this.keys[n3] != l) break;
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
                    if (this.keys[n4] != l) continue block15;
                    return 128;
                }
                case 2: {
                    if (this.keys[n4] != l) continue block15;
                    this.lastFoundWhere = n4;
                    return n4;
                }
            }
        }
        return 128;
    }

    private int calcHash(long l) {
        return ((int)(l ^ l >>> 32) & 0xFFFFFF7F) % this.arraySize;
    }

    @Override
    public boolean containsValue(Object object) {
        return this.findOneValuePos(object) != 128;
    }

    int findOneValuePos(Object object) {
        int n;
        int n2 = this.lastFoundWhere;
        if (this.valueStates[n2] == 2 && (object == this.values[n2] || object != null && object.equals(this.values[n2]))) {
            return n2;
        }
        for (n = n2 + 1; n < this.values.length; ++n) {
            if (this.valueStates[n] != 2 || this.values[n] != object && (this.values[n] == null || !this.values[n].equals(object))) continue;
            this.lastFoundWhere = n;
            return n;
        }
        for (n = 0; n < n2; ++n) {
            if (this.valueStates[n] != 2 || this.values[n] != object && (this.values[n] == null || !this.values[n].equals(object))) continue;
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
            long l = this.keys[i2];
            if (this.valueStates[i2] != 2) continue;
            Object object = this.get(l);
            stringBuilder.append(string).append(l).append("<-").append(object);
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
        return new LongObjectOptHashMap$EntryIterator(this);
    }

    @Override
    public Set entrySet() {
        return new LongObjectOptHashMap$EntrySet(this);
    }

    @Override
    public LongIterator keyIterator() {
        return new LongObjectOptHashMap$KeyIterator(this);
    }

    @Override
    public LongSet keySet() {
        return new LongObjectOptHashMap$KeySet(this);
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (null == object || object.getClass() != super.getClass()) {
            return false;
        }
        LongObjectOptHashMap longObjectOptHashMap = (LongObjectOptHashMap)object;
        if (longObjectOptHashMap.size != this.size) {
            return false;
        }
        if (!(longObjectOptHashMap.neutralValue == this.neutralValue || longObjectOptHashMap.neutralValue != null && longObjectOptHashMap.neutralValue.equals(this.neutralValue))) {
            return false;
        }
        Iterator iterator = this.entrySet().iterator();
        while (iterator.hasNext()) {
            LongObjectOptHashMap$Entry longObjectOptHashMap$Entry = (LongObjectOptHashMap$Entry)iterator.next();
            if (!longObjectOptHashMap.containsKey(longObjectOptHashMap$Entry.key)) {
                return false;
            }
            Object object2 = longObjectOptHashMap.get(longObjectOptHashMap$Entry.key);
            if (object2 == longObjectOptHashMap$Entry.value || object2 != null && object2.equals(longObjectOptHashMap$Entry.value)) continue;
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
    public long getOneKeyByValue(Object object) {
        int n = this.findOneValuePos(object);
        if (128 == n) {
            return 0L;
        }
        return this.keys[n];
    }

    @Override
    public Object replaceKey(long l, long l2) {
        int n = this.findKey(l);
        if (128 == n) {
            return this.neutralValue;
        }
        Object object = this.removePos(n);
        return this.put(l2, object);
    }

    @Override
    public long replaceOneValue(Object object, Object object2) {
        int n = this.findOneValuePos(object);
        if (128 == n) {
            return 0L;
        }
        ++this.writes;
        this.values[n] = object2;
        this.onCollectionChanged();
        return this.keys[n];
    }

    @Override
    public Iterator valueIterator() {
        return new LongObjectOptHashMap$ValueIterator(this);
    }

    @Override
    public Collection values() {
        return new LongObjectOptHashMap$ValueCollection(this);
    }

    @Override
    public Object[] valuesToArray() {
        return this.valuesToArray(new Object[this.size]);
    }

    @Override
    public Object[] valuesToArray(Object[] objectArray) {
        Object[] objectArray2 = objectArray;
        if (objectArray.length < this.size) {
            objectArray2 = (Object[])Array.newInstance(super.getClass().getComponentType(), this.size);
        }
        int n = this.arraySize;
        for (int i2 = this.size - 1; i2 >= 0; --i2) {
            while (this.valueStates[--n] == 0 || this.valueStates[n] == 1) {
            }
            objectArray2[i2] = this.values[n];
        }
        return objectArray2;
    }

    @Override
    public long[] keysToArray() {
        return this.keysToArray(new long[this.size]);
    }

    @Override
    public long[] keysToArray(long[] lArray) {
        long[] lArray2 = lArray;
        if (lArray.length < this.size) {
            lArray2 = (long[])Array.newInstance(super.getClass().getComponentType(), this.size);
        }
        int n = this.arraySize;
        for (int i2 = this.size - 1; i2 >= 0; --i2) {
            while (this.valueStates[--n] == 0 || this.valueStates[n] == 1) {
            }
            lArray2[i2] = this.keys[n];
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
        $assertionsDisabled = !(class$de$vw$mib$collections$longs$LongObjectOptHashMap == null ? (class$de$vw$mib$collections$longs$LongObjectOptHashMap = LongObjectOptHashMap.class$("de.vw.mib.collections.longs.LongObjectOptHashMap")) : class$de$vw$mib$collections$longs$LongObjectOptHashMap).desiredAssertionStatus();
        NEUTRAL_VALUE = null;
    }
}

