/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.ints;

import de.vw.mib.collections.CollectionOverflowException;
import de.vw.mib.collections.CollectionWithExpansionPoint;
import de.vw.mib.collections.CollectionsHelper;
import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.collections.OptHashMapHelper;
import de.vw.mib.collections.ints.IntCollection;
import de.vw.mib.collections.ints.IntIntMap;
import de.vw.mib.collections.ints.IntIntMap$Entry;
import de.vw.mib.collections.ints.IntIntOptHashMap$Entry;
import de.vw.mib.collections.ints.IntIntOptHashMap$EntryIterator;
import de.vw.mib.collections.ints.IntIntOptHashMap$EntrySet;
import de.vw.mib.collections.ints.IntIntOptHashMap$KeyIterator;
import de.vw.mib.collections.ints.IntIntOptHashMap$KeySet;
import de.vw.mib.collections.ints.IntIntOptHashMap$ValueCollection;
import de.vw.mib.collections.ints.IntIntOptHashMap$ValueIterator;
import de.vw.mib.collections.ints.IntIterator;
import de.vw.mib.collections.ints.IntSet;
import de.vw.mib.collections.ints.SyncIntIntOptHashMap;
import de.vw.mib.util.StringBuilder;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

public class IntIntOptHashMap
implements CollectionWithExpansionPoint,
IntIntMap {
    private static final int MAP_TO_POSITIVE;
    private static final byte NOT_SET;
    private static final byte DELETED;
    private static final byte FILLED;
    private static final int NOT_FOUND_POS;
    private static final int NEUTRAL_VALUE;
    int[] keys;
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
    static /* synthetic */ Class class$de$vw$mib$collections$ints$IntIntOptHashMap;

    public static void copy(IntIntOptHashMap intIntOptHashMap, IntIntOptHashMap intIntOptHashMap2) {
        Iterator iterator = intIntOptHashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            IntIntOptHashMap$Entry intIntOptHashMap$Entry = (IntIntOptHashMap$Entry)iterator.next();
            intIntOptHashMap2.put(intIntOptHashMap$Entry.key, intIntOptHashMap$Entry.value);
        }
    }

    public IntIntOptHashMap() {
        this(3, 63, 63, 49215, 0);
    }

    public IntIntOptHashMap(int n) {
        this(n, 63, 63, 49215, 0);
    }

    public IntIntOptHashMap(int n, float f2, float f3) {
        this(n, f2, f3, 49215, 0);
    }

    public IntIntOptHashMap(IntIntOptHashMap intIntOptHashMap) {
        this.loadFactor = intIntOptHashMap.loadFactor;
        this.resizeFactor = intIntOptHashMap.resizeFactor;
        this.rehashStrategy = intIntOptHashMap.rehashStrategy;
        this.neutralValue = intIntOptHashMap.neutralValue;
        this.sizeWarningThreshold = intIntOptHashMap.sizeWarningThreshold;
        int[] nArray = new int[intIntOptHashMap.arraySize];
        System.arraycopy((Object)intIntOptHashMap.keys, 0, (Object)nArray, 0, intIntOptHashMap.arraySize);
        int[] nArray2 = new int[intIntOptHashMap.arraySize];
        System.arraycopy((Object)intIntOptHashMap.values, 0, (Object)nArray2, 0, intIntOptHashMap.arraySize);
        byte[] byArray = new byte[intIntOptHashMap.arraySize];
        System.arraycopy((Object)intIntOptHashMap.valueStates, 0, (Object)byArray, 0, intIntOptHashMap.arraySize);
        this.init(nArray, nArray2, byArray, intIntOptHashMap.size, intIntOptHashMap.fill);
        this.writes = intIntOptHashMap.writes;
    }

    private IntIntOptHashMap(int n, float f2, float f3, float f4, int n2) {
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
        this.init(new int[n3], new int[n3], new byte[n3], 0, 0);
        this.writes = 0;
    }

    private IntIntOptHashMap(int[] nArray, int[] nArray2, byte[] byArray, int n, int n2, float f2, float f3, float f4, int n3) {
        this.loadFactor = f2;
        this.resizeFactor = f3;
        this.rehashStrategy = f4;
        this.neutralValue = n3;
        this.sizeWarningThreshold = n * 2 > CollectionsHelper.DEFAULT_SIZE_WARNING_THRESHOLD ? n * 2 : CollectionsHelper.DEFAULT_SIZE_WARNING_THRESHOLD;
        this.init(nArray, nArray2, byArray, n, n2);
        this.writes = 0;
    }

    private void init(int[] nArray, int[] nArray2, byte[] byArray, int n, int n2) {
        this.keys = nArray;
        this.values = nArray2;
        this.valueStates = byArray;
        this.size = n;
        this.fill = n2;
        this.arraySize = this.keys.length;
        this.rehashThreshold = (int)(this.loadFactor * (float)this.arraySize);
    }

    public static IntIntOptHashMap createFromInternalData(Object[] objectArray) {
        return IntIntOptHashMap.createFromInternalData(objectArray, 0);
    }

    public static IntIntOptHashMap createFromInternalData(Object[] objectArray, int n) {
        int[] nArray = (int[])objectArray[3 + n];
        return new IntIntOptHashMap((int[])objectArray[0 + n], (int[])objectArray[1 + n], (byte[])objectArray[2 + n], nArray[0], nArray[1], Float.intBitsToFloat(nArray[2]), Float.intBitsToFloat(nArray[3]), Float.intBitsToFloat(nArray[4]), ((int[])objectArray[4 + n])[0]);
    }

    public static IntIntOptHashMap createSlowlyGrowingHashmap(int n, float f2, float f3) {
        return new IntIntOptHashMap(n, f2, f3, -842232769, 0);
    }

    public static IntIntOptHashMap createWithNeutralValue(int n, float f2, float f3, int n2) {
        return new IntIntOptHashMap(n, f2, f3, 49215, n2);
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
        int[] nArray = this.keys;
        int[] nArray2 = this.values;
        byte[] byArray = this.valueStates;
        this.init(new int[n], new int[n], new byte[n], 0, 0);
        for (int i2 = nArray.length - 1; i2 >= 0; --i2) {
            if (byArray[i2] != 2) continue;
            this.put(nArray[i2], nArray2[i2]);
        }
        if (this.size > this.sizeWarningThreshold) {
            CollectionsHelper.writeSizeWarning("IntIntOptHashMap", this.arraySize, 5);
        }
    }

    @Override
    public int put(int n, int n2) {
        int n3 = this.calcHash(n);
        int n4 = -1;
        ++this.writes;
        switch (this.valueStates[n3]) {
            case 0: {
                this.keys[n3] = n;
                this.values[n3] = n2;
                this.valueStates[n3] = 2;
                ++this.size;
                ++this.fill;
                if (this.mustRehash()) {
                    this.rehash();
                }
                this.onCollectionChanged();
                return this.neutralValue;
            }
            case 1: {
                if (this.keys[n3] == n) {
                    this.values[n3] = n2;
                    this.valueStates[n3] = 2;
                    ++this.size;
                    this.onCollectionChanged();
                    return this.neutralValue;
                }
                n4 = n3;
                break;
            }
            case 2: {
                if (this.keys[n3] != n) break;
                int n5 = this.values[n3];
                this.values[n3] = n2;
                this.onCollectionChanged();
                return n5;
            }
        }
        int n6 = n3;
        int n7 = n3;
        block15: for (int i2 = 1; i2 < this.arraySize; i2 += 2) {
            if ((n6 += i2) >= this.arraySize) {
                n6 -= this.arraySize;
            }
            switch (this.valueStates[n6]) {
                case 0: {
                    if (n4 < 0) {
                        n4 = n6;
                        ++this.fill;
                    }
                    this.keys[n4] = n;
                    this.values[n4] = n2;
                    this.valueStates[n4] = 2;
                    ++this.size;
                    if (this.mustRehash()) {
                        this.rehash();
                    }
                    this.onCollectionChanged();
                    return this.neutralValue;
                }
                case 1: {
                    if (n4 >= 0) break;
                    n4 = n6;
                    break;
                }
                case 2: {
                    if (this.keys[n6] != n) break;
                    int n8 = this.values[n6];
                    this.values[n6] = n2;
                    this.onCollectionChanged();
                    return n8;
                }
            }
            if ((n7 -= i2) < 0) {
                n7 += this.arraySize;
            }
            switch (this.valueStates[n7]) {
                case 0: {
                    if (n4 < 0) {
                        n4 = n7;
                        ++this.fill;
                    }
                    this.keys[n4] = n;
                    this.values[n4] = n2;
                    this.valueStates[n4] = 2;
                    ++this.size;
                    if (this.mustRehash()) {
                        this.rehash();
                    }
                    this.onCollectionChanged();
                    return this.neutralValue;
                }
                case 1: {
                    if (n4 >= 0) continue block15;
                    n4 = n7;
                    continue block15;
                }
                case 2: {
                    if (this.keys[n7] != n) continue block15;
                    int n9 = this.values[n7];
                    this.values[n7] = n2;
                    this.onCollectionChanged();
                    return n9;
                }
            }
        }
        throw new CollectionOverflowException(new StringBuffer().append("Map overflow on adding (").append(n).append(",").append(n2).append(").").toString());
    }

    @Override
    public int get(int n) {
        int n2 = this.findKey(n);
        if (n2 == 128) {
            return this.neutralValue;
        }
        return this.values[n2];
    }

    @Override
    public boolean containsKey(int n) {
        return this.findKey(n) != 128;
    }

    @Override
    public int remove(int n) {
        int n2 = this.removePos(this.findKey(n));
        this.onCollectionChanged();
        return n2;
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

    int findKey(int n) {
        int n2 = this.lastFoundWhere;
        if (n == this.keys[n2] && this.valueStates[n2] == 2) {
            return n2;
        }
        int n3 = this.calcHash(n);
        switch (this.valueStates[n3]) {
            case 0: {
                return 128;
            }
            case 1: {
                if (this.keys[n3] != n) break;
                return 128;
            }
            case 2: {
                if (this.keys[n3] != n) break;
                this.lastFoundWhere = n3;
                return n3;
            }
        }
        int n4 = n3;
        int n5 = n3;
        block15: for (int i2 = 1; i2 < this.arraySize; i2 += 2) {
            if ((n4 += i2) >= this.arraySize) {
                n4 -= this.arraySize;
            }
            switch (this.valueStates[n4]) {
                case 0: {
                    return 128;
                }
                case 1: {
                    if (this.keys[n4] != n) break;
                    return 128;
                }
                case 2: {
                    if (this.keys[n4] != n) break;
                    this.lastFoundWhere = n4;
                    return n4;
                }
            }
            if ((n5 -= i2) < 0) {
                n5 += this.arraySize;
            }
            switch (this.valueStates[n5]) {
                case 0: {
                    return 128;
                }
                case 1: {
                    if (this.keys[n5] != n) continue block15;
                    return 128;
                }
                case 2: {
                    if (this.keys[n5] != n) continue block15;
                    this.lastFoundWhere = n5;
                    return n5;
                }
            }
        }
        return 128;
    }

    private int calcHash(int n) {
        return (n & 0xFFFFFF7F) % this.arraySize;
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
            int n = this.keys[i2];
            if (this.valueStates[i2] != 2) continue;
            int n2 = this.get(n);
            stringBuilder.append(string).append(n).append("<-").append(n2);
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
        return new IntIntOptHashMap$EntryIterator(this);
    }

    @Override
    public Set entrySet() {
        return new IntIntOptHashMap$EntrySet(this);
    }

    @Override
    public IntIterator keyIterator() {
        return new IntIntOptHashMap$KeyIterator(this);
    }

    @Override
    public IntSet keySet() {
        return new IntIntOptHashMap$KeySet(this);
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (null == object || object.getClass() != super.getClass()) {
            return false;
        }
        IntIntOptHashMap intIntOptHashMap = (IntIntOptHashMap)object;
        if (intIntOptHashMap.size != this.size) {
            return false;
        }
        if (intIntOptHashMap.neutralValue != this.neutralValue) {
            return false;
        }
        Iterator iterator = this.entrySet().iterator();
        while (iterator.hasNext()) {
            IntIntOptHashMap$Entry intIntOptHashMap$Entry = (IntIntOptHashMap$Entry)iterator.next();
            if (!intIntOptHashMap.containsKey(intIntOptHashMap$Entry.key)) {
                return false;
            }
            int n = intIntOptHashMap.get(intIntOptHashMap$Entry.key);
            if (n == intIntOptHashMap$Entry.value) continue;
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
    public int getOneKeyByValue(int n) {
        int n2 = this.findOneValuePos(n);
        if (128 == n2) {
            return 0;
        }
        return this.keys[n2];
    }

    @Override
    public int replaceKey(int n, int n2) {
        int n3 = this.findKey(n);
        if (128 == n3) {
            return this.neutralValue;
        }
        int n4 = this.removePos(n3);
        return this.put(n2, n4);
    }

    @Override
    public int replaceOneValue(int n, int n2) {
        int n3 = this.findOneValuePos(n);
        if (128 == n3) {
            return 0;
        }
        ++this.writes;
        this.values[n3] = n2;
        this.onCollectionChanged();
        return this.keys[n3];
    }

    @Override
    public IntIterator valueIterator() {
        return new IntIntOptHashMap$ValueIterator(this);
    }

    @Override
    public IntCollection values() {
        return new IntIntOptHashMap$ValueCollection(this);
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
    public int[] keysToArray() {
        return this.keysToArray(new int[this.size]);
    }

    @Override
    public int[] keysToArray(int[] nArray) {
        int[] nArray2 = nArray;
        if (nArray.length < this.size) {
            nArray2 = (int[])Array.newInstance(super.getClass().getComponentType(), this.size);
        }
        int n = this.arraySize;
        for (int i2 = this.size - 1; i2 >= 0; --i2) {
            while (this.valueStates[--n] == 0 || this.valueStates[n] == 1) {
            }
            nArray2[i2] = this.keys[n];
        }
        return nArray2;
    }

    @Override
    public IntIntMap synchronize() {
        return new SyncIntIntOptHashMap(this);
    }

    @Override
    public void putAll(IntIntMap intIntMap) {
        Iterator iterator = intIntMap.entrySet().iterator();
        while (iterator.hasNext()) {
            IntIntMap$Entry intIntMap$Entry = (IntIntMap$Entry)iterator.next();
            this.put(intIntMap$Entry.getKey(), intIntMap$Entry.getValue());
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
        $assertionsDisabled = !(class$de$vw$mib$collections$ints$IntIntOptHashMap == null ? (class$de$vw$mib$collections$ints$IntIntOptHashMap = IntIntOptHashMap.class$("de.vw.mib.collections.ints.IntIntOptHashMap")) : class$de$vw$mib$collections$ints$IntIntOptHashMap).desiredAssertionStatus();
    }
}

