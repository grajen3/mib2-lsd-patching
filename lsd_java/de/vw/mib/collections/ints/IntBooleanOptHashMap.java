/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.ints;

import de.vw.mib.collections.CollectionOverflowException;
import de.vw.mib.collections.CollectionWithExpansionPoint;
import de.vw.mib.collections.CollectionsHelper;
import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.collections.OptHashMapHelper;
import de.vw.mib.collections.booleans.BooleanCollection;
import de.vw.mib.collections.booleans.BooleanIterator;
import de.vw.mib.collections.ints.IntBooleanMap;
import de.vw.mib.collections.ints.IntBooleanMap$Entry;
import de.vw.mib.collections.ints.IntBooleanOptHashMap$Entry;
import de.vw.mib.collections.ints.IntBooleanOptHashMap$EntryIterator;
import de.vw.mib.collections.ints.IntBooleanOptHashMap$EntrySet;
import de.vw.mib.collections.ints.IntBooleanOptHashMap$KeyIterator;
import de.vw.mib.collections.ints.IntBooleanOptHashMap$KeySet;
import de.vw.mib.collections.ints.IntBooleanOptHashMap$ValueCollection;
import de.vw.mib.collections.ints.IntBooleanOptHashMap$ValueIterator;
import de.vw.mib.collections.ints.IntIterator;
import de.vw.mib.collections.ints.IntSet;
import de.vw.mib.collections.ints.SyncIntBooleanOptHashMap;
import de.vw.mib.util.StringBuilder;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

public class IntBooleanOptHashMap
implements CollectionWithExpansionPoint,
IntBooleanMap {
    private static final int MAP_TO_POSITIVE;
    private static final byte NOT_SET;
    private static final byte DELETED;
    private static final byte FILLED;
    private static final int NOT_FOUND_POS;
    private static final boolean NEUTRAL_VALUE;
    int[] keys;
    boolean[] values;
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
    final boolean neutralValue;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$collections$ints$IntBooleanOptHashMap;

    public static void copy(IntBooleanOptHashMap intBooleanOptHashMap, IntBooleanOptHashMap intBooleanOptHashMap2) {
        Iterator iterator = intBooleanOptHashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            IntBooleanOptHashMap$Entry intBooleanOptHashMap$Entry = (IntBooleanOptHashMap$Entry)iterator.next();
            intBooleanOptHashMap2.put(intBooleanOptHashMap$Entry.key, intBooleanOptHashMap$Entry.value);
        }
    }

    public IntBooleanOptHashMap() {
        this(3, 63, 63, 49215, false);
    }

    public IntBooleanOptHashMap(int n) {
        this(n, 63, 63, 49215, false);
    }

    public IntBooleanOptHashMap(int n, float f2, float f3) {
        this(n, f2, f3, 49215, false);
    }

    public IntBooleanOptHashMap(IntBooleanOptHashMap intBooleanOptHashMap) {
        this.loadFactor = intBooleanOptHashMap.loadFactor;
        this.resizeFactor = intBooleanOptHashMap.resizeFactor;
        this.rehashStrategy = intBooleanOptHashMap.rehashStrategy;
        this.neutralValue = intBooleanOptHashMap.neutralValue;
        this.sizeWarningThreshold = intBooleanOptHashMap.sizeWarningThreshold;
        int[] nArray = new int[intBooleanOptHashMap.arraySize];
        System.arraycopy((Object)intBooleanOptHashMap.keys, 0, (Object)nArray, 0, intBooleanOptHashMap.arraySize);
        boolean[] blArray = new boolean[intBooleanOptHashMap.arraySize];
        System.arraycopy((Object)intBooleanOptHashMap.values, 0, (Object)blArray, 0, intBooleanOptHashMap.arraySize);
        byte[] byArray = new byte[intBooleanOptHashMap.arraySize];
        System.arraycopy((Object)intBooleanOptHashMap.valueStates, 0, (Object)byArray, 0, intBooleanOptHashMap.arraySize);
        this.init(nArray, blArray, byArray, intBooleanOptHashMap.size, intBooleanOptHashMap.fill);
        this.writes = intBooleanOptHashMap.writes;
    }

    private IntBooleanOptHashMap(int n, float f2, float f3, float f4, boolean bl) {
        if (!($assertionsDisabled || f2 >= 0.0f && f2 <= 1.0f)) {
            throw new AssertionError();
        }
        if (!($assertionsDisabled || f3 >= 0.0f && f3 <= 1.0f)) {
            throw new AssertionError();
        }
        this.loadFactor = f2;
        this.resizeFactor = f3;
        this.rehashStrategy = f4;
        this.neutralValue = bl;
        this.sizeWarningThreshold = n * 2 > CollectionsHelper.DEFAULT_SIZE_WARNING_THRESHOLD ? n * 2 : CollectionsHelper.DEFAULT_SIZE_WARNING_THRESHOLD;
        int n2 = OptHashMapHelper.capacityAtLeast(n, f2);
        this.init(new int[n2], new boolean[n2], new byte[n2], 0, 0);
        this.writes = 0;
    }

    private IntBooleanOptHashMap(int[] nArray, boolean[] blArray, byte[] byArray, int n, int n2, float f2, float f3, float f4, boolean bl) {
        this.loadFactor = f2;
        this.resizeFactor = f3;
        this.rehashStrategy = f4;
        this.neutralValue = bl;
        this.sizeWarningThreshold = n * 2 > CollectionsHelper.DEFAULT_SIZE_WARNING_THRESHOLD ? n * 2 : CollectionsHelper.DEFAULT_SIZE_WARNING_THRESHOLD;
        this.init(nArray, blArray, byArray, n, n2);
        this.writes = 0;
    }

    private void init(int[] nArray, boolean[] blArray, byte[] byArray, int n, int n2) {
        this.keys = nArray;
        this.values = blArray;
        this.valueStates = byArray;
        this.size = n;
        this.fill = n2;
        this.arraySize = this.keys.length;
        this.rehashThreshold = (int)(this.loadFactor * (float)this.arraySize);
    }

    public static IntBooleanOptHashMap createFromInternalData(Object[] objectArray) {
        return IntBooleanOptHashMap.createFromInternalData(objectArray, 0);
    }

    public static IntBooleanOptHashMap createFromInternalData(Object[] objectArray, int n) {
        int[] nArray = (int[])objectArray[3 + n];
        return new IntBooleanOptHashMap((int[])objectArray[0 + n], (boolean[])objectArray[1 + n], (byte[])objectArray[2 + n], nArray[0], nArray[1], Float.intBitsToFloat(nArray[2]), Float.intBitsToFloat(nArray[3]), Float.intBitsToFloat(nArray[4]), ((boolean[])objectArray[4 + n])[0]);
    }

    public static IntBooleanOptHashMap createSlowlyGrowingHashmap(int n, float f2, float f3) {
        return new IntBooleanOptHashMap(n, f2, f3, -842232769, false);
    }

    public static IntBooleanOptHashMap createWithNeutralValue(int n, float f2, float f3, boolean bl) {
        return new IntBooleanOptHashMap(n, f2, f3, 49215, bl);
    }

    public Object[] getInternalData() {
        this.pack();
        Object[] objectArray = new Object[OptHashMapHelper.getLengthOfOptHashMapInternalData()];
        objectArray[0] = this.keys;
        objectArray[1] = this.values;
        objectArray[2] = this.valueStates;
        objectArray[3] = new int[]{this.size, this.fill, Float.floatToIntBits(this.loadFactor), Float.floatToIntBits(this.resizeFactor), Float.floatToIntBits(this.rehashStrategy)};
        objectArray[4] = new boolean[]{this.neutralValue};
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
        boolean[] blArray = this.values;
        byte[] byArray = this.valueStates;
        this.init(new int[n], new boolean[n], new byte[n], 0, 0);
        for (int i2 = nArray.length - 1; i2 >= 0; --i2) {
            if (byArray[i2] != 2) continue;
            this.put(nArray[i2], blArray[i2]);
        }
        if (this.size > this.sizeWarningThreshold) {
            CollectionsHelper.writeSizeWarning("IntBooleanOptHashMap", this.arraySize, 5);
        }
    }

    @Override
    public boolean put(int n, boolean bl) {
        int n2 = this.calcHash(n);
        int n3 = -1;
        ++this.writes;
        switch (this.valueStates[n2]) {
            case 0: {
                this.keys[n2] = n;
                this.values[n2] = bl;
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
                    this.values[n2] = bl;
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
                boolean bl2 = this.values[n2];
                this.values[n2] = bl;
                this.onCollectionChanged();
                return bl2;
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
                    this.values[n3] = bl;
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
                    boolean bl3 = this.values[n4];
                    this.values[n4] = bl;
                    this.onCollectionChanged();
                    return bl3;
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
                    this.values[n3] = bl;
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
                    boolean bl4 = this.values[n5];
                    this.values[n5] = bl;
                    this.onCollectionChanged();
                    return bl4;
                }
            }
        }
        throw new CollectionOverflowException(new StringBuffer().append("Map overflow on adding (").append(n).append(",").append(bl).append(").").toString());
    }

    @Override
    public boolean get(int n) {
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
    public boolean remove(int n) {
        boolean bl = this.removePos(this.findKey(n));
        this.onCollectionChanged();
        return bl;
    }

    boolean removePos(int n) {
        if (n == 128) {
            return this.neutralValue;
        }
        boolean bl = this.values[n];
        this.valueStates[n] = 1;
        --this.size;
        ++this.writes;
        return bl;
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
    public boolean containsValue(boolean bl) {
        return this.findOneValuePos(bl) != 128;
    }

    int findOneValuePos(boolean bl) {
        int n;
        int n2 = this.lastFoundWhere;
        if (this.valueStates[n2] == 2 && bl == this.values[n2]) {
            return n2;
        }
        for (n = n2 + 1; n < this.values.length; ++n) {
            if (this.valueStates[n] != 2 || this.values[n] != bl) continue;
            this.lastFoundWhere = n;
            return n;
        }
        for (n = 0; n < n2; ++n) {
            if (this.valueStates[n] != 2 || this.values[n] != bl) continue;
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
            boolean bl = this.get(n);
            stringBuilder.append(string).append(n).append("<-").append(bl);
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
        return new IntBooleanOptHashMap$EntryIterator(this);
    }

    @Override
    public Set entrySet() {
        return new IntBooleanOptHashMap$EntrySet(this);
    }

    @Override
    public IntIterator keyIterator() {
        return new IntBooleanOptHashMap$KeyIterator(this);
    }

    @Override
    public IntSet keySet() {
        return new IntBooleanOptHashMap$KeySet(this);
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (null == object || object.getClass() != super.getClass()) {
            return false;
        }
        IntBooleanOptHashMap intBooleanOptHashMap = (IntBooleanOptHashMap)object;
        if (intBooleanOptHashMap.size != this.size) {
            return false;
        }
        if (intBooleanOptHashMap.neutralValue != this.neutralValue) {
            return false;
        }
        Iterator iterator = this.entrySet().iterator();
        while (iterator.hasNext()) {
            IntBooleanOptHashMap$Entry intBooleanOptHashMap$Entry = (IntBooleanOptHashMap$Entry)iterator.next();
            if (!intBooleanOptHashMap.containsKey(intBooleanOptHashMap$Entry.key)) {
                return false;
            }
            boolean bl = intBooleanOptHashMap.get(intBooleanOptHashMap$Entry.key);
            if (bl == intBooleanOptHashMap$Entry.value) continue;
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
    public int getOneKeyByValue(boolean bl) {
        int n = this.findOneValuePos(bl);
        if (128 == n) {
            return 0;
        }
        return this.keys[n];
    }

    @Override
    public boolean replaceKey(int n, int n2) {
        int n3 = this.findKey(n);
        if (128 == n3) {
            return this.neutralValue;
        }
        boolean bl = this.removePos(n3);
        return this.put(n2, bl);
    }

    @Override
    public int replaceOneValue(boolean bl, boolean bl2) {
        int n = this.findOneValuePos(bl);
        if (128 == n) {
            return 0;
        }
        ++this.writes;
        this.values[n] = bl2;
        this.onCollectionChanged();
        return this.keys[n];
    }

    @Override
    public BooleanIterator valueIterator() {
        return new IntBooleanOptHashMap$ValueIterator(this);
    }

    @Override
    public BooleanCollection values() {
        return new IntBooleanOptHashMap$ValueCollection(this);
    }

    @Override
    public boolean[] valuesToArray() {
        return this.valuesToArray(new boolean[this.size]);
    }

    @Override
    public boolean[] valuesToArray(boolean[] blArray) {
        boolean[] blArray2 = blArray;
        if (blArray.length < this.size) {
            blArray2 = (boolean[])Array.newInstance(super.getClass().getComponentType(), this.size);
        }
        int n = this.arraySize;
        for (int i2 = this.size - 1; i2 >= 0; --i2) {
            while (this.valueStates[--n] == 0 || this.valueStates[n] == 1) {
            }
            blArray2[i2] = this.values[n];
        }
        return blArray2;
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
    public IntBooleanMap synchronize() {
        return new SyncIntBooleanOptHashMap(this);
    }

    @Override
    public void putAll(IntBooleanMap intBooleanMap) {
        Iterator iterator = intBooleanMap.entrySet().iterator();
        while (iterator.hasNext()) {
            IntBooleanMap$Entry intBooleanMap$Entry = (IntBooleanMap$Entry)iterator.next();
            this.put(intBooleanMap$Entry.getKey(), intBooleanMap$Entry.getValue());
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
        $assertionsDisabled = !(class$de$vw$mib$collections$ints$IntBooleanOptHashMap == null ? (class$de$vw$mib$collections$ints$IntBooleanOptHashMap = IntBooleanOptHashMap.class$("de.vw.mib.collections.ints.IntBooleanOptHashMap")) : class$de$vw$mib$collections$ints$IntBooleanOptHashMap).desiredAssertionStatus();
    }
}

