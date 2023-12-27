/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.longs;

import de.vw.mib.collections.CollectionOverflowException;
import de.vw.mib.collections.CollectionWithExpansionPoint;
import de.vw.mib.collections.CollectionsHelper;
import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.collections.OptHashMapHelper;
import de.vw.mib.collections.longs.LongCollection;
import de.vw.mib.collections.longs.LongIterator;
import de.vw.mib.collections.longs.LongLongMap;
import de.vw.mib.collections.longs.LongLongMap$Entry;
import de.vw.mib.collections.longs.LongLongOptHashMap$Entry;
import de.vw.mib.collections.longs.LongLongOptHashMap$EntryIterator;
import de.vw.mib.collections.longs.LongLongOptHashMap$EntrySet;
import de.vw.mib.collections.longs.LongLongOptHashMap$KeyIterator;
import de.vw.mib.collections.longs.LongLongOptHashMap$KeySet;
import de.vw.mib.collections.longs.LongLongOptHashMap$ValueCollection;
import de.vw.mib.collections.longs.LongLongOptHashMap$ValueIterator;
import de.vw.mib.collections.longs.LongSet;
import de.vw.mib.collections.longs.SyncLongLongOptHashMap;
import de.vw.mib.util.StringBuilder;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

public class LongLongOptHashMap
implements CollectionWithExpansionPoint,
LongLongMap {
    private static final int MAP_TO_POSITIVE;
    private static final byte NOT_SET;
    private static final byte DELETED;
    private static final byte FILLED;
    private static final int NOT_FOUND_POS;
    private static final long NEUTRAL_VALUE;
    long[] keys;
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
    static /* synthetic */ Class class$de$vw$mib$collections$longs$LongLongOptHashMap;

    public static void copy(LongLongOptHashMap longLongOptHashMap, LongLongOptHashMap longLongOptHashMap2) {
        Iterator iterator = longLongOptHashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            LongLongOptHashMap$Entry longLongOptHashMap$Entry = (LongLongOptHashMap$Entry)iterator.next();
            longLongOptHashMap2.put(longLongOptHashMap$Entry.key, longLongOptHashMap$Entry.value);
        }
    }

    public LongLongOptHashMap() {
        this(3, 63, 63, 49215, 0L);
    }

    public LongLongOptHashMap(int n) {
        this(n, 63, 63, 49215, 0L);
    }

    public LongLongOptHashMap(int n, float f2, float f3) {
        this(n, f2, f3, 49215, 0L);
    }

    public LongLongOptHashMap(LongLongOptHashMap longLongOptHashMap) {
        this.loadFactor = longLongOptHashMap.loadFactor;
        this.resizeFactor = longLongOptHashMap.resizeFactor;
        this.rehashStrategy = longLongOptHashMap.rehashStrategy;
        this.neutralValue = longLongOptHashMap.neutralValue;
        this.sizeWarningThreshold = longLongOptHashMap.sizeWarningThreshold;
        long[] lArray = new long[longLongOptHashMap.arraySize];
        System.arraycopy((Object)longLongOptHashMap.keys, 0, (Object)lArray, 0, longLongOptHashMap.arraySize);
        long[] lArray2 = new long[longLongOptHashMap.arraySize];
        System.arraycopy((Object)longLongOptHashMap.values, 0, (Object)lArray2, 0, longLongOptHashMap.arraySize);
        byte[] byArray = new byte[longLongOptHashMap.arraySize];
        System.arraycopy((Object)longLongOptHashMap.valueStates, 0, (Object)byArray, 0, longLongOptHashMap.arraySize);
        this.init(lArray, lArray2, byArray, longLongOptHashMap.size, longLongOptHashMap.fill);
        this.writes = longLongOptHashMap.writes;
    }

    private LongLongOptHashMap(int n, float f2, float f3, float f4, long l) {
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
        this.init(new long[n2], new long[n2], new byte[n2], 0, 0);
        this.writes = 0;
    }

    private LongLongOptHashMap(long[] lArray, long[] lArray2, byte[] byArray, int n, int n2, float f2, float f3, float f4, long l) {
        this.loadFactor = f2;
        this.resizeFactor = f3;
        this.rehashStrategy = f4;
        this.neutralValue = l;
        this.sizeWarningThreshold = n * 2 > CollectionsHelper.DEFAULT_SIZE_WARNING_THRESHOLD ? n * 2 : CollectionsHelper.DEFAULT_SIZE_WARNING_THRESHOLD;
        this.init(lArray, lArray2, byArray, n, n2);
        this.writes = 0;
    }

    private void init(long[] lArray, long[] lArray2, byte[] byArray, int n, int n2) {
        this.keys = lArray;
        this.values = lArray2;
        this.valueStates = byArray;
        this.size = n;
        this.fill = n2;
        this.arraySize = this.keys.length;
        this.rehashThreshold = (int)(this.loadFactor * (float)this.arraySize);
    }

    public static LongLongOptHashMap createFromInternalData(Object[] objectArray) {
        return LongLongOptHashMap.createFromInternalData(objectArray, 0);
    }

    public static LongLongOptHashMap createFromInternalData(Object[] objectArray, int n) {
        int[] nArray = (int[])objectArray[3 + n];
        return new LongLongOptHashMap((long[])objectArray[0 + n], (long[])objectArray[1 + n], (byte[])objectArray[2 + n], nArray[0], nArray[1], Float.intBitsToFloat(nArray[2]), Float.intBitsToFloat(nArray[3]), Float.intBitsToFloat(nArray[4]), ((long[])objectArray[4 + n])[0]);
    }

    public static LongLongOptHashMap createSlowlyGrowingHashmap(int n, float f2, float f3) {
        return new LongLongOptHashMap(n, f2, f3, -842232769, 0L);
    }

    public static LongLongOptHashMap createWithNeutralValue(int n, float f2, float f3, long l) {
        return new LongLongOptHashMap(n, f2, f3, 49215, l);
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
        long[] lArray = this.keys;
        long[] lArray2 = this.values;
        byte[] byArray = this.valueStates;
        this.init(new long[n], new long[n], new byte[n], 0, 0);
        for (int i2 = lArray.length - 1; i2 >= 0; --i2) {
            if (byArray[i2] != 2) continue;
            this.put(lArray[i2], lArray2[i2]);
        }
        if (this.size > this.sizeWarningThreshold) {
            CollectionsHelper.writeSizeWarning("LongLongOptHashMap", this.arraySize, 5);
        }
    }

    @Override
    public long put(long l, long l2) {
        int n = this.calcHash(l);
        int n2 = -1;
        ++this.writes;
        switch (this.valueStates[n]) {
            case 0: {
                this.keys[n] = l;
                this.values[n] = l2;
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
                    this.values[n] = l2;
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
                long l3 = this.values[n];
                this.values[n] = l2;
                this.onCollectionChanged();
                return l3;
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
                    this.values[n2] = l2;
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
                    long l4 = this.values[n3];
                    this.values[n3] = l2;
                    this.onCollectionChanged();
                    return l4;
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
                    this.values[n2] = l2;
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
                    long l5 = this.values[n4];
                    this.values[n4] = l2;
                    this.onCollectionChanged();
                    return l5;
                }
            }
        }
        throw new CollectionOverflowException(new StringBuffer().append("Map overflow on adding (").append(l).append(",").append(l2).append(").").toString());
    }

    @Override
    public long get(long l) {
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
    public long remove(long l) {
        long l2 = this.removePos(this.findKey(l));
        this.onCollectionChanged();
        return l2;
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
            long l = this.keys[i2];
            if (this.valueStates[i2] != 2) continue;
            long l2 = this.get(l);
            stringBuilder.append(string).append(l).append("<-").append(l2);
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
        return new LongLongOptHashMap$EntryIterator(this);
    }

    @Override
    public Set entrySet() {
        return new LongLongOptHashMap$EntrySet(this);
    }

    @Override
    public LongIterator keyIterator() {
        return new LongLongOptHashMap$KeyIterator(this);
    }

    @Override
    public LongSet keySet() {
        return new LongLongOptHashMap$KeySet(this);
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (null == object || object.getClass() != super.getClass()) {
            return false;
        }
        LongLongOptHashMap longLongOptHashMap = (LongLongOptHashMap)object;
        if (longLongOptHashMap.size != this.size) {
            return false;
        }
        if (longLongOptHashMap.neutralValue != this.neutralValue) {
            return false;
        }
        Iterator iterator = this.entrySet().iterator();
        while (iterator.hasNext()) {
            LongLongOptHashMap$Entry longLongOptHashMap$Entry = (LongLongOptHashMap$Entry)iterator.next();
            if (!longLongOptHashMap.containsKey(longLongOptHashMap$Entry.key)) {
                return false;
            }
            long l = longLongOptHashMap.get(longLongOptHashMap$Entry.key);
            if (l == longLongOptHashMap$Entry.value) continue;
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
    public long getOneKeyByValue(long l) {
        int n = this.findOneValuePos(l);
        if (128 == n) {
            return 0L;
        }
        return this.keys[n];
    }

    @Override
    public long replaceKey(long l, long l2) {
        int n = this.findKey(l);
        if (128 == n) {
            return this.neutralValue;
        }
        long l3 = this.removePos(n);
        return this.put(l2, l3);
    }

    @Override
    public long replaceOneValue(long l, long l2) {
        int n = this.findOneValuePos(l);
        if (128 == n) {
            return 0L;
        }
        ++this.writes;
        this.values[n] = l2;
        this.onCollectionChanged();
        return this.keys[n];
    }

    @Override
    public LongIterator valueIterator() {
        return new LongLongOptHashMap$ValueIterator(this);
    }

    @Override
    public LongCollection values() {
        return new LongLongOptHashMap$ValueCollection(this);
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
        $assertionsDisabled = !(class$de$vw$mib$collections$longs$LongLongOptHashMap == null ? (class$de$vw$mib$collections$longs$LongLongOptHashMap = LongLongOptHashMap.class$("de.vw.mib.collections.longs.LongLongOptHashMap")) : class$de$vw$mib$collections$longs$LongLongOptHashMap).desiredAssertionStatus();
    }
}

