/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.ints;

import de.vw.mib.collections.CollectionOverflowException;
import de.vw.mib.collections.CollectionWithExpansionPoint;
import de.vw.mib.collections.CollectionsHelper;
import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.collections.OptHashMapHelper;
import de.vw.mib.collections.floats.FloatCollection;
import de.vw.mib.collections.floats.FloatIterator;
import de.vw.mib.collections.ints.IntFloatMap;
import de.vw.mib.collections.ints.IntFloatMap$Entry;
import de.vw.mib.collections.ints.IntFloatOptHashMap$Entry;
import de.vw.mib.collections.ints.IntFloatOptHashMap$EntryIterator;
import de.vw.mib.collections.ints.IntFloatOptHashMap$EntrySet;
import de.vw.mib.collections.ints.IntFloatOptHashMap$KeyIterator;
import de.vw.mib.collections.ints.IntFloatOptHashMap$KeySet;
import de.vw.mib.collections.ints.IntFloatOptHashMap$ValueCollection;
import de.vw.mib.collections.ints.IntFloatOptHashMap$ValueIterator;
import de.vw.mib.collections.ints.IntIterator;
import de.vw.mib.collections.ints.IntSet;
import de.vw.mib.collections.ints.SyncIntFloatOptHashMap;
import de.vw.mib.util.StringBuilder;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

public class IntFloatOptHashMap
implements CollectionWithExpansionPoint,
IntFloatMap {
    private static final int MAP_TO_POSITIVE;
    private static final byte NOT_SET;
    private static final byte DELETED;
    private static final byte FILLED;
    private static final int NOT_FOUND_POS;
    private static final float NEUTRAL_VALUE;
    int[] keys;
    float[] values;
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
    final float neutralValue;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$collections$ints$IntFloatOptHashMap;

    public static void copy(IntFloatOptHashMap intFloatOptHashMap, IntFloatOptHashMap intFloatOptHashMap2) {
        Iterator iterator = intFloatOptHashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            IntFloatOptHashMap$Entry intFloatOptHashMap$Entry = (IntFloatOptHashMap$Entry)iterator.next();
            intFloatOptHashMap2.put(intFloatOptHashMap$Entry.key, intFloatOptHashMap$Entry.value);
        }
    }

    public IntFloatOptHashMap() {
        this(3, 63, 63, 49215, 0.0f);
    }

    public IntFloatOptHashMap(int n) {
        this(n, 63, 63, 49215, 0.0f);
    }

    public IntFloatOptHashMap(int n, float f2, float f3) {
        this(n, f2, f3, 49215, 0.0f);
    }

    public IntFloatOptHashMap(IntFloatOptHashMap intFloatOptHashMap) {
        this.loadFactor = intFloatOptHashMap.loadFactor;
        this.resizeFactor = intFloatOptHashMap.resizeFactor;
        this.rehashStrategy = intFloatOptHashMap.rehashStrategy;
        this.neutralValue = intFloatOptHashMap.neutralValue;
        this.sizeWarningThreshold = intFloatOptHashMap.sizeWarningThreshold;
        int[] nArray = new int[intFloatOptHashMap.arraySize];
        System.arraycopy((Object)intFloatOptHashMap.keys, 0, (Object)nArray, 0, intFloatOptHashMap.arraySize);
        float[] fArray = new float[intFloatOptHashMap.arraySize];
        System.arraycopy((Object)intFloatOptHashMap.values, 0, (Object)fArray, 0, intFloatOptHashMap.arraySize);
        byte[] byArray = new byte[intFloatOptHashMap.arraySize];
        System.arraycopy((Object)intFloatOptHashMap.valueStates, 0, (Object)byArray, 0, intFloatOptHashMap.arraySize);
        this.init(nArray, fArray, byArray, intFloatOptHashMap.size, intFloatOptHashMap.fill);
        this.writes = intFloatOptHashMap.writes;
    }

    private IntFloatOptHashMap(int n, float f2, float f3, float f4, float f5) {
        if (!($assertionsDisabled || f2 >= 0.0f && f2 <= 1.0f)) {
            throw new AssertionError();
        }
        if (!($assertionsDisabled || f3 >= 0.0f && f3 <= 1.0f)) {
            throw new AssertionError();
        }
        this.loadFactor = f2;
        this.resizeFactor = f3;
        this.rehashStrategy = f4;
        this.neutralValue = f5;
        this.sizeWarningThreshold = n * 2 > CollectionsHelper.DEFAULT_SIZE_WARNING_THRESHOLD ? n * 2 : CollectionsHelper.DEFAULT_SIZE_WARNING_THRESHOLD;
        int n2 = OptHashMapHelper.capacityAtLeast(n, f2);
        this.init(new int[n2], new float[n2], new byte[n2], 0, 0);
        this.writes = 0;
    }

    private IntFloatOptHashMap(int[] nArray, float[] fArray, byte[] byArray, int n, int n2, float f2, float f3, float f4, float f5) {
        this.loadFactor = f2;
        this.resizeFactor = f3;
        this.rehashStrategy = f4;
        this.neutralValue = f5;
        this.sizeWarningThreshold = n * 2 > CollectionsHelper.DEFAULT_SIZE_WARNING_THRESHOLD ? n * 2 : CollectionsHelper.DEFAULT_SIZE_WARNING_THRESHOLD;
        this.init(nArray, fArray, byArray, n, n2);
        this.writes = 0;
    }

    private void init(int[] nArray, float[] fArray, byte[] byArray, int n, int n2) {
        this.keys = nArray;
        this.values = fArray;
        this.valueStates = byArray;
        this.size = n;
        this.fill = n2;
        this.arraySize = this.keys.length;
        this.rehashThreshold = (int)(this.loadFactor * (float)this.arraySize);
    }

    public static IntFloatOptHashMap createFromInternalData(Object[] objectArray) {
        return IntFloatOptHashMap.createFromInternalData(objectArray, 0);
    }

    public static IntFloatOptHashMap createFromInternalData(Object[] objectArray, int n) {
        int[] nArray = (int[])objectArray[3 + n];
        return new IntFloatOptHashMap((int[])objectArray[0 + n], (float[])objectArray[1 + n], (byte[])objectArray[2 + n], nArray[0], nArray[1], Float.intBitsToFloat(nArray[2]), Float.intBitsToFloat(nArray[3]), Float.intBitsToFloat(nArray[4]), ((float[])objectArray[4 + n])[0]);
    }

    public static IntFloatOptHashMap createSlowlyGrowingHashmap(int n, float f2, float f3) {
        return new IntFloatOptHashMap(n, f2, f3, -842232769, 0.0f);
    }

    public static IntFloatOptHashMap createWithNeutralValue(int n, float f2, float f3, float f4) {
        return new IntFloatOptHashMap(n, f2, f3, 49215, f4);
    }

    public Object[] getInternalData() {
        this.pack();
        Object[] objectArray = new Object[OptHashMapHelper.getLengthOfOptHashMapInternalData()];
        objectArray[0] = this.keys;
        objectArray[1] = this.values;
        objectArray[2] = this.valueStates;
        objectArray[3] = new int[]{this.size, this.fill, Float.floatToIntBits(this.loadFactor), Float.floatToIntBits(this.resizeFactor), Float.floatToIntBits(this.rehashStrategy)};
        objectArray[4] = new float[]{this.neutralValue};
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
        float[] fArray = this.values;
        byte[] byArray = this.valueStates;
        this.init(new int[n], new float[n], new byte[n], 0, 0);
        for (int i2 = nArray.length - 1; i2 >= 0; --i2) {
            if (byArray[i2] != 2) continue;
            this.put(nArray[i2], fArray[i2]);
        }
        if (this.size > this.sizeWarningThreshold) {
            CollectionsHelper.writeSizeWarning("IntFloatOptHashMap", this.arraySize, 5);
        }
    }

    @Override
    public float put(int n, float f2) {
        int n2 = this.calcHash(n);
        int n3 = -1;
        ++this.writes;
        switch (this.valueStates[n2]) {
            case 0: {
                this.keys[n2] = n;
                this.values[n2] = f2;
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
                if (this.keys[n2] == n) {
                    this.values[n2] = f2;
                    this.valueStates[n2] = 2;
                    ++this.size;
                    this.onCollectionChanged();
                    return this.neutralValue;
                }
                n3 = n2;
                break;
            }
            case 2: {
                if (this.keys[n2] != n) break;
                float f3 = this.values[n2];
                this.values[n2] = f2;
                this.onCollectionChanged();
                return f3;
            }
        }
        int n4 = n2;
        int n5 = n2;
        block15: for (int i2 = 1; i2 < this.arraySize; i2 += 2) {
            if ((n4 += i2) >= this.arraySize) {
                n4 -= this.arraySize;
            }
            switch (this.valueStates[n4]) {
                case 0: {
                    if (n3 < 0) {
                        n3 = n4;
                        ++this.fill;
                    }
                    this.keys[n3] = n;
                    this.values[n3] = f2;
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
                    n3 = n4;
                    break;
                }
                case 2: {
                    if (this.keys[n4] != n) break;
                    float f4 = this.values[n4];
                    this.values[n4] = f2;
                    this.onCollectionChanged();
                    return f4;
                }
            }
            if ((n5 -= i2) < 0) {
                n5 += this.arraySize;
            }
            switch (this.valueStates[n5]) {
                case 0: {
                    if (n3 < 0) {
                        n3 = n5;
                        ++this.fill;
                    }
                    this.keys[n3] = n;
                    this.values[n3] = f2;
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
                    n3 = n5;
                    continue block15;
                }
                case 2: {
                    if (this.keys[n5] != n) continue block15;
                    float f5 = this.values[n5];
                    this.values[n5] = f2;
                    this.onCollectionChanged();
                    return f5;
                }
            }
        }
        throw new CollectionOverflowException(new StringBuffer().append("Map overflow on adding (").append(n).append(",").append(f2).append(").").toString());
    }

    @Override
    public float get(int n) {
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
    public float remove(int n) {
        float f2 = this.removePos(this.findKey(n));
        this.onCollectionChanged();
        return f2;
    }

    float removePos(int n) {
        if (n == 128) {
            return this.neutralValue;
        }
        float f2 = this.values[n];
        this.valueStates[n] = 1;
        --this.size;
        ++this.writes;
        return f2;
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
    public boolean containsValue(float f2) {
        return this.findOneValuePos(f2) != 128;
    }

    int findOneValuePos(float f2) {
        int n;
        int n2 = this.lastFoundWhere;
        if (this.valueStates[n2] == 2 && f2 == this.values[n2]) {
            return n2;
        }
        for (n = n2 + 1; n < this.values.length; ++n) {
            if (this.valueStates[n] != 2 || this.values[n] != f2) continue;
            this.lastFoundWhere = n;
            return n;
        }
        for (n = 0; n < n2; ++n) {
            if (this.valueStates[n] != 2 || this.values[n] != f2) continue;
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
            int n = this.keys[i2];
            if (this.valueStates[i2] != 2) continue;
            float f2 = this.get(n);
            stringBuilder.append(string).append(n).append("<-").append(f2);
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
        return new IntFloatOptHashMap$EntryIterator(this);
    }

    @Override
    public Set entrySet() {
        return new IntFloatOptHashMap$EntrySet(this);
    }

    @Override
    public IntIterator keyIterator() {
        return new IntFloatOptHashMap$KeyIterator(this);
    }

    @Override
    public IntSet keySet() {
        return new IntFloatOptHashMap$KeySet(this);
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (null == object || object.getClass() != super.getClass()) {
            return false;
        }
        IntFloatOptHashMap intFloatOptHashMap = (IntFloatOptHashMap)object;
        if (intFloatOptHashMap.size != this.size) {
            return false;
        }
        if (intFloatOptHashMap.neutralValue != this.neutralValue) {
            return false;
        }
        Iterator iterator = this.entrySet().iterator();
        while (iterator.hasNext()) {
            IntFloatOptHashMap$Entry intFloatOptHashMap$Entry = (IntFloatOptHashMap$Entry)iterator.next();
            if (!intFloatOptHashMap.containsKey(intFloatOptHashMap$Entry.key)) {
                return false;
            }
            float f2 = intFloatOptHashMap.get(intFloatOptHashMap$Entry.key);
            if (f2 == intFloatOptHashMap$Entry.value) continue;
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
    public int getOneKeyByValue(float f2) {
        int n = this.findOneValuePos(f2);
        if (128 == n) {
            return 0;
        }
        return this.keys[n];
    }

    @Override
    public float replaceKey(int n, int n2) {
        int n3 = this.findKey(n);
        if (128 == n3) {
            return this.neutralValue;
        }
        float f2 = this.removePos(n3);
        return this.put(n2, f2);
    }

    @Override
    public int replaceOneValue(float f2, float f3) {
        int n = this.findOneValuePos(f2);
        if (128 == n) {
            return 0;
        }
        ++this.writes;
        this.values[n] = f3;
        this.onCollectionChanged();
        return this.keys[n];
    }

    @Override
    public FloatIterator valueIterator() {
        return new IntFloatOptHashMap$ValueIterator(this);
    }

    @Override
    public FloatCollection values() {
        return new IntFloatOptHashMap$ValueCollection(this);
    }

    @Override
    public float[] valuesToArray() {
        return this.valuesToArray(new float[this.size]);
    }

    @Override
    public float[] valuesToArray(float[] fArray) {
        float[] fArray2 = fArray;
        if (fArray.length < this.size) {
            fArray2 = (float[])Array.newInstance(super.getClass().getComponentType(), this.size);
        }
        int n = this.arraySize;
        for (int i2 = this.size - 1; i2 >= 0; --i2) {
            while (this.valueStates[--n] == 0 || this.valueStates[n] == 1) {
            }
            fArray2[i2] = this.values[n];
        }
        return fArray2;
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
    public IntFloatMap synchronize() {
        return new SyncIntFloatOptHashMap(this);
    }

    @Override
    public void putAll(IntFloatMap intFloatMap) {
        Iterator iterator = intFloatMap.entrySet().iterator();
        while (iterator.hasNext()) {
            IntFloatMap$Entry intFloatMap$Entry = (IntFloatMap$Entry)iterator.next();
            this.put(intFloatMap$Entry.getKey(), intFloatMap$Entry.getValue());
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
        $assertionsDisabled = !(class$de$vw$mib$collections$ints$IntFloatOptHashMap == null ? (class$de$vw$mib$collections$ints$IntFloatOptHashMap = IntFloatOptHashMap.class$("de.vw.mib.collections.ints.IntFloatOptHashMap")) : class$de$vw$mib$collections$ints$IntFloatOptHashMap).desiredAssertionStatus();
    }
}

