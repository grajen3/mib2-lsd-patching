/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.longs;

import de.vw.mib.collections.CollectionOverflowException;
import de.vw.mib.collections.CollectionWithExpansionPoint;
import de.vw.mib.collections.CollectionsHelper;
import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.collections.OptHashMapHelper;
import de.vw.mib.collections.ints.IntCollection;
import de.vw.mib.collections.ints.IntIterator;
import de.vw.mib.collections.longs.LongIntMap;
import de.vw.mib.collections.longs.LongIntMap$Entry;
import de.vw.mib.collections.longs.LongIntOptHashMap$Entry;
import de.vw.mib.collections.longs.LongIntOptHashMap$EntryIterator;
import de.vw.mib.collections.longs.LongIntOptHashMap$EntrySet;
import de.vw.mib.collections.longs.LongIntOptHashMap$KeyIterator;
import de.vw.mib.collections.longs.LongIntOptHashMap$KeySet;
import de.vw.mib.collections.longs.LongIntOptHashMap$ValueCollection;
import de.vw.mib.collections.longs.LongIntOptHashMap$ValueIterator;
import de.vw.mib.collections.longs.LongIterator;
import de.vw.mib.collections.longs.LongSet;
import de.vw.mib.collections.longs.SyncLongIntOptHashMap;
import de.vw.mib.util.StringBuilder;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

public class LongIntOptHashMap
implements CollectionWithExpansionPoint,
LongIntMap {
    private static final int MAP_TO_POSITIVE;
    private static final byte NOT_SET;
    private static final byte DELETED;
    private static final byte FILLED;
    private static final int NOT_FOUND_POS;
    private static final int NEUTRAL_VALUE;
    long[] keys;
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
    static /* synthetic */ Class class$de$vw$mib$collections$longs$LongIntOptHashMap;

    public static void copy(LongIntOptHashMap longIntOptHashMap, LongIntOptHashMap longIntOptHashMap2) {
        Iterator iterator = longIntOptHashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            LongIntOptHashMap$Entry longIntOptHashMap$Entry = (LongIntOptHashMap$Entry)iterator.next();
            longIntOptHashMap2.put(longIntOptHashMap$Entry.key, longIntOptHashMap$Entry.value);
        }
    }

    public LongIntOptHashMap() {
        this(3, 63, 63, 49215, 0);
    }

    public LongIntOptHashMap(int n) {
        this(n, 63, 63, 49215, 0);
    }

    public LongIntOptHashMap(int n, float f2, float f3) {
        this(n, f2, f3, 49215, 0);
    }

    public LongIntOptHashMap(LongIntOptHashMap longIntOptHashMap) {
        this.loadFactor = longIntOptHashMap.loadFactor;
        this.resizeFactor = longIntOptHashMap.resizeFactor;
        this.rehashStrategy = longIntOptHashMap.rehashStrategy;
        this.neutralValue = longIntOptHashMap.neutralValue;
        this.sizeWarningThreshold = longIntOptHashMap.sizeWarningThreshold;
        long[] lArray = new long[longIntOptHashMap.arraySize];
        System.arraycopy((Object)longIntOptHashMap.keys, 0, (Object)lArray, 0, longIntOptHashMap.arraySize);
        int[] nArray = new int[longIntOptHashMap.arraySize];
        System.arraycopy((Object)longIntOptHashMap.values, 0, (Object)nArray, 0, longIntOptHashMap.arraySize);
        byte[] byArray = new byte[longIntOptHashMap.arraySize];
        System.arraycopy((Object)longIntOptHashMap.valueStates, 0, (Object)byArray, 0, longIntOptHashMap.arraySize);
        this.init(lArray, nArray, byArray, longIntOptHashMap.size, longIntOptHashMap.fill);
        this.writes = longIntOptHashMap.writes;
    }

    private LongIntOptHashMap(int n, float f2, float f3, float f4, int n2) {
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
        this.init(new long[n3], new int[n3], new byte[n3], 0, 0);
        this.writes = 0;
    }

    private LongIntOptHashMap(long[] lArray, int[] nArray, byte[] byArray, int n, int n2, float f2, float f3, float f4, int n3) {
        this.loadFactor = f2;
        this.resizeFactor = f3;
        this.rehashStrategy = f4;
        this.neutralValue = n3;
        this.sizeWarningThreshold = n * 2 > CollectionsHelper.DEFAULT_SIZE_WARNING_THRESHOLD ? n * 2 : CollectionsHelper.DEFAULT_SIZE_WARNING_THRESHOLD;
        this.init(lArray, nArray, byArray, n, n2);
        this.writes = 0;
    }

    private void init(long[] lArray, int[] nArray, byte[] byArray, int n, int n2) {
        this.keys = lArray;
        this.values = nArray;
        this.valueStates = byArray;
        this.size = n;
        this.fill = n2;
        this.arraySize = this.keys.length;
        this.rehashThreshold = (int)(this.loadFactor * (float)this.arraySize);
    }

    public static LongIntOptHashMap createFromInternalData(Object[] objectArray) {
        return LongIntOptHashMap.createFromInternalData(objectArray, 0);
    }

    public static LongIntOptHashMap createFromInternalData(Object[] objectArray, int n) {
        int[] nArray = (int[])objectArray[3 + n];
        return new LongIntOptHashMap((long[])objectArray[0 + n], (int[])objectArray[1 + n], (byte[])objectArray[2 + n], nArray[0], nArray[1], Float.intBitsToFloat(nArray[2]), Float.intBitsToFloat(nArray[3]), Float.intBitsToFloat(nArray[4]), ((int[])objectArray[4 + n])[0]);
    }

    public static LongIntOptHashMap createSlowlyGrowingHashmap(int n, float f2, float f3) {
        return new LongIntOptHashMap(n, f2, f3, -842232769, 0);
    }

    public static LongIntOptHashMap createWithNeutralValue(int n, float f2, float f3, int n2) {
        return new LongIntOptHashMap(n, f2, f3, 49215, n2);
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
        long[] lArray = this.keys;
        int[] nArray = this.values;
        byte[] byArray = this.valueStates;
        this.init(new long[n], new int[n], new byte[n], 0, 0);
        for (int i2 = lArray.length - 1; i2 >= 0; --i2) {
            if (byArray[i2] != 2) continue;
            this.put(lArray[i2], nArray[i2]);
        }
        if (this.size > this.sizeWarningThreshold) {
            CollectionsHelper.writeSizeWarning("LongIntOptHashMap", this.arraySize, 5);
        }
    }

    @Override
    public int put(long l, int n) {
        int n2 = this.calcHash(l);
        int n3 = -1;
        ++this.writes;
        switch (this.valueStates[n2]) {
            case 0: {
                this.keys[n2] = l;
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
                if (this.keys[n2] == l) {
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
                if (this.keys[n2] != l) break;
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
                    this.keys[n3] = l;
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
                    if (this.keys[n5] != l) break;
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
                    this.keys[n3] = l;
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
                    if (this.keys[n6] != l) continue block15;
                    int n8 = this.values[n6];
                    this.values[n6] = n;
                    this.onCollectionChanged();
                    return n8;
                }
            }
        }
        throw new CollectionOverflowException(new StringBuffer().append("Map overflow on adding (").append(l).append(",").append(n).append(").").toString());
    }

    @Override
    public int get(long l) {
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
    public int remove(long l) {
        int n = this.removePos(this.findKey(l));
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
            long l = this.keys[i2];
            if (this.valueStates[i2] != 2) continue;
            int n = this.get(l);
            stringBuilder.append(string).append(l).append("<-").append(n);
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
        return new LongIntOptHashMap$EntryIterator(this);
    }

    @Override
    public Set entrySet() {
        return new LongIntOptHashMap$EntrySet(this);
    }

    @Override
    public LongIterator keyIterator() {
        return new LongIntOptHashMap$KeyIterator(this);
    }

    @Override
    public LongSet keySet() {
        return new LongIntOptHashMap$KeySet(this);
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (null == object || object.getClass() != super.getClass()) {
            return false;
        }
        LongIntOptHashMap longIntOptHashMap = (LongIntOptHashMap)object;
        if (longIntOptHashMap.size != this.size) {
            return false;
        }
        if (longIntOptHashMap.neutralValue != this.neutralValue) {
            return false;
        }
        Iterator iterator = this.entrySet().iterator();
        while (iterator.hasNext()) {
            LongIntOptHashMap$Entry longIntOptHashMap$Entry = (LongIntOptHashMap$Entry)iterator.next();
            if (!longIntOptHashMap.containsKey(longIntOptHashMap$Entry.key)) {
                return false;
            }
            int n = longIntOptHashMap.get(longIntOptHashMap$Entry.key);
            if (n == longIntOptHashMap$Entry.value) continue;
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
    public long getOneKeyByValue(int n) {
        int n2 = this.findOneValuePos(n);
        if (128 == n2) {
            return 0L;
        }
        return this.keys[n2];
    }

    @Override
    public int replaceKey(long l, long l2) {
        int n = this.findKey(l);
        if (128 == n) {
            return this.neutralValue;
        }
        int n2 = this.removePos(n);
        return this.put(l2, n2);
    }

    @Override
    public long replaceOneValue(int n, int n2) {
        int n3 = this.findOneValuePos(n);
        if (128 == n3) {
            return 0L;
        }
        ++this.writes;
        this.values[n3] = n2;
        this.onCollectionChanged();
        return this.keys[n3];
    }

    @Override
    public IntIterator valueIterator() {
        return new LongIntOptHashMap$ValueIterator(this);
    }

    @Override
    public IntCollection values() {
        return new LongIntOptHashMap$ValueCollection(this);
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
    public LongIntMap synchronize() {
        return new SyncLongIntOptHashMap(this);
    }

    @Override
    public void putAll(LongIntMap longIntMap) {
        Iterator iterator = longIntMap.entrySet().iterator();
        while (iterator.hasNext()) {
            LongIntMap$Entry longIntMap$Entry = (LongIntMap$Entry)iterator.next();
            this.put(longIntMap$Entry.getKey(), longIntMap$Entry.getValue());
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
        $assertionsDisabled = !(class$de$vw$mib$collections$longs$LongIntOptHashMap == null ? (class$de$vw$mib$collections$longs$LongIntOptHashMap = LongIntOptHashMap.class$("de.vw.mib.collections.longs.LongIntOptHashMap")) : class$de$vw$mib$collections$longs$LongIntOptHashMap).desiredAssertionStatus();
    }
}

