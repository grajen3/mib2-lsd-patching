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
import de.vw.mib.collections.ints.IntIterator;
import de.vw.mib.collections.ints.IntOptHashSet$IntIteratorImpl;
import de.vw.mib.collections.ints.IntSet;
import de.vw.mib.collections.ints.SyncIntSet;
import de.vw.mib.util.StringBuilder;
import java.lang.reflect.Array;
import java.util.Arrays;

public class IntOptHashSet
implements CollectionWithExpansionPoint,
IntSet {
    private static final int MAP_TO_POSITIVE;
    private static final byte NOT_SET;
    private static final byte DELETED;
    private static final byte FILLED;
    private static final int NOT_FOUND_POS;
    int[] keys;
    byte[] keyStates;
    int size;
    private int fill;
    private int threshold;
    private int arraySize;
    final float loadFactor;
    final float resizeThreshold;
    int lastFoundWhere;
    int sizeWarningThreshold;
    int modifications;
    private final float rehashStrategy;
    private int hashCodeModifications;
    private int hashCode;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$collections$ints$IntOptHashSet;

    public IntOptHashSet() {
        this(3, 63, 63, 49215);
    }

    public IntOptHashSet(int n) {
        this(n, 63, 63, 49215);
    }

    public IntOptHashSet(int n, float f2, float f3) {
        this(n, f2, f3, 49215);
    }

    private IntOptHashSet(int n, float f2, float f3, float f4) {
        if (!($assertionsDisabled || f2 >= 0.0f && f2 <= 1.0f)) {
            throw new AssertionError();
        }
        if (!($assertionsDisabled || f3 >= 0.0f && f3 <= 1.0f)) {
            throw new AssertionError();
        }
        this.arraySize = OptHashMapHelper.capacityAtLeast(n, f2);
        this.keys = new int[this.arraySize];
        this.keyStates = new byte[this.arraySize];
        this.size = 0;
        this.modifications = 0;
        this.hashCodeModifications = -1;
        this.lastFoundWhere = 0;
        this.fill = 0;
        this.loadFactor = f2;
        this.resizeThreshold = f3;
        this.threshold = (int)(f2 * (float)this.arraySize);
        this.rehashStrategy = f4;
        this.sizeWarningThreshold = n * 2 > CollectionsHelper.DEFAULT_SIZE_WARNING_THRESHOLD ? n * 2 : CollectionsHelper.DEFAULT_SIZE_WARNING_THRESHOLD;
    }

    public IntOptHashSet(IntOptHashSet intOptHashSet) {
        this.keys = new int[intOptHashSet.arraySize];
        System.arraycopy((Object)intOptHashSet.keys, 0, (Object)this.keys, 0, intOptHashSet.arraySize);
        this.keyStates = new byte[intOptHashSet.arraySize];
        System.arraycopy((Object)intOptHashSet.keyStates, 0, (Object)this.keyStates, 0, intOptHashSet.arraySize);
        this.size = intOptHashSet.size;
        this.fill = intOptHashSet.fill;
        this.threshold = intOptHashSet.threshold;
        this.arraySize = intOptHashSet.arraySize;
        this.loadFactor = intOptHashSet.loadFactor;
        this.resizeThreshold = intOptHashSet.resizeThreshold;
        this.rehashStrategy = intOptHashSet.rehashStrategy;
        this.lastFoundWhere = intOptHashSet.lastFoundWhere;
        this.modifications = intOptHashSet.modifications;
        this.hashCodeModifications = intOptHashSet.hashCodeModifications;
        this.hashCode = intOptHashSet.hashCode;
        this.sizeWarningThreshold = intOptHashSet.sizeWarningThreshold;
    }

    public static IntOptHashSet createSlowlyGrowingHashset(int n, float f2, float f3) {
        return new IntOptHashSet(n, f2, f3, -842232769);
    }

    public void setSizeWarningThreshold(int n) {
        this.sizeWarningThreshold = n;
    }

    @Override
    public boolean add(int n) {
        int n2 = this.calcHash(n);
        int n3 = -1;
        switch (this.keyStates[n2]) {
            case 0: {
                this.keys[n2] = n;
                this.keyStates[n2] = 2;
                ++this.size;
                ++this.modifications;
                ++this.fill;
                if (this.fill > this.threshold) {
                    this.rehash();
                }
                this.onCollectionChanged();
                return true;
            }
            case 1: {
                if (n == this.keys[n2]) {
                    this.keyStates[n2] = 2;
                    ++this.size;
                    ++this.modifications;
                    this.onCollectionChanged();
                    return true;
                }
                n3 = n2;
                break;
            }
            case 2: {
                if (n != this.keys[n2]) break;
                return false;
            }
        }
        int n4 = n2;
        int n5 = n2;
        block15: for (int i2 = 1; i2 < this.arraySize; i2 += 2) {
            if ((n4 += i2) >= this.arraySize) {
                n4 -= this.arraySize;
            }
            switch (this.keyStates[n4]) {
                case 0: {
                    if (n3 < 0) {
                        n3 = n4;
                        ++this.fill;
                    }
                    this.keys[n3] = n;
                    this.keyStates[n3] = 2;
                    ++this.size;
                    ++this.modifications;
                    if (this.fill > this.threshold) {
                        this.rehash();
                    }
                    this.onCollectionChanged();
                    return true;
                }
                case 1: {
                    if (n3 >= 0) break;
                    n3 = n4;
                    break;
                }
                case 2: {
                    if (n != this.keys[n4]) break;
                    return false;
                }
            }
            if ((n5 -= i2) < 0) {
                n5 += this.arraySize;
            }
            switch (this.keyStates[n5]) {
                case 0: {
                    if (n3 < 0) {
                        n3 = n5;
                        ++this.fill;
                    }
                    this.keys[n3] = n;
                    this.keyStates[n3] = 2;
                    ++this.size;
                    ++this.modifications;
                    if (this.fill > this.threshold) {
                        this.rehash();
                    }
                    this.onCollectionChanged();
                    return true;
                }
                case 1: {
                    if (n3 >= 0) continue block15;
                    n3 = n5;
                    continue block15;
                }
                case 2: {
                    if (n != this.keys[n5]) continue block15;
                    return false;
                }
            }
        }
        throw new CollectionOverflowException(new StringBuffer().append("Map overflow on adding (").append(n).append(").").toString());
    }

    @Override
    public int get(int n) {
        int n2 = this.find(n);
        return n2 != 128 ? this.keys[n2] : 0;
    }

    @Override
    public boolean contains(int n) {
        return this.find(n) != 128;
    }

    @Override
    public boolean remove(int n) {
        return this.removePosition(this.find(n));
    }

    boolean removePosition(int n) {
        if (n != 128) {
            this.keyStates[n] = 1;
            --this.size;
            ++this.modifications;
            this.onCollectionChanged();
            return true;
        }
        return false;
    }

    private int find(int n) {
        if (this.keyStates[this.lastFoundWhere] == 2 && n == this.keys[this.lastFoundWhere]) {
            return this.lastFoundWhere;
        }
        int n2 = this.calcHash(n);
        switch (this.keyStates[n2]) {
            case 0: {
                return 128;
            }
            case 1: {
                if (n != this.keys[n2]) break;
                return 128;
            }
            case 2: {
                if (n != this.keys[n2]) break;
                this.lastFoundWhere = n2;
                return this.lastFoundWhere;
            }
        }
        int n3 = n2;
        int n4 = n2;
        block15: for (int i2 = 1; i2 < this.arraySize; i2 += 2) {
            if ((n3 += i2) >= this.arraySize) {
                n3 -= this.arraySize;
            }
            switch (this.keyStates[n3]) {
                case 0: {
                    return 128;
                }
                case 1: {
                    if (n != this.keys[n3]) break;
                    return 128;
                }
                case 2: {
                    if (n != this.keys[n3]) break;
                    this.lastFoundWhere = n3;
                    return this.lastFoundWhere;
                }
            }
            if ((n4 -= i2) < 0) {
                n4 += this.arraySize;
            }
            switch (this.keyStates[n4]) {
                case 0: {
                    return 128;
                }
                case 1: {
                    if (n != this.keys[n4]) continue block15;
                    return 128;
                }
                case 2: {
                    if (n != this.keys[n4]) continue block15;
                    this.lastFoundWhere = n4;
                    return this.lastFoundWhere;
                }
            }
        }
        return 128;
    }

    private int calcHash(int n) {
        return (n & 0xFFFFFF7F) % this.arraySize;
    }

    private void rehash() {
        int[] nArray = this.keys;
        byte[] byArray = this.keyStates;
        if ((float)this.size > (float)this.fill * this.resizeThreshold) {
            this.arraySize = OptHashMapHelper.capacityAtLeast((int)((float)this.arraySize * this.rehashStrategy + 1.0f));
            this.threshold = (int)(this.loadFactor * (float)this.arraySize);
        }
        this.keys = new int[this.arraySize];
        this.keyStates = new byte[this.arraySize];
        this.size = 0;
        this.fill = 0;
        for (int i2 = nArray.length - 1; i2 >= 0; --i2) {
            if (byArray[i2] != 2) continue;
            this.add(nArray[i2]);
        }
        if (this.size > this.sizeWarningThreshold) {
            CollectionsHelper.writeSizeWarning("IntOptHashSet", this.arraySize, 5);
        }
    }

    @Override
    public void clear() {
        Arrays.fill(this.keyStates, (byte)0);
        this.size = 0;
        this.fill = 0;
        ++this.modifications;
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
        for (int i2 = 0; i2 < this.arraySize; ++i2) {
            int n = this.keys[i2];
            if (this.keyStates[i2] != 2) continue;
            stringBuilder.append(string).append(n);
            string = ", ";
        }
        return stringBuilder.append("]").toString();
    }

    @Override
    public IntIterator iterator() {
        return new IntOptHashSet$IntIteratorImpl(this);
    }

    @Override
    public boolean addAll(IntCollection intCollection) {
        if (intCollection.isEmpty()) {
            return false;
        }
        boolean bl = false;
        IntIterator intIterator = intCollection.iterator();
        while (intIterator.hasNext()) {
            bl |= this.add(intIterator.next());
        }
        return bl;
    }

    @Override
    public boolean containsAll(IntCollection intCollection) {
        if (intCollection.isEmpty()) {
            return true;
        }
        boolean bl = true;
        IntIterator intIterator = intCollection.iterator();
        while (intIterator.hasNext()) {
            bl &= this.contains(intIterator.next());
        }
        return bl;
    }

    @Override
    public boolean removeAll(IntCollection intCollection) {
        if (intCollection.isEmpty()) {
            return false;
        }
        boolean bl = false;
        IntIterator intIterator = intCollection.iterator();
        while (intIterator.hasNext()) {
            bl |= this.remove(intIterator.next());
        }
        return bl;
    }

    @Override
    public boolean retainAll(IntCollection intCollection) {
        if (intCollection.isEmpty()) {
            if (this.isEmpty()) {
                return false;
            }
            this.clear();
            return true;
        }
        boolean bl = false;
        for (int i2 = this.arraySize - 1; i2 >= 0; --i2) {
            if (this.keyStates[i2] != 2 || intCollection.contains(this.keys[i2])) continue;
            bl |= this.remove(this.keys[i2]);
        }
        return bl;
    }

    @Override
    public int[] toArray() {
        return this.toArray(new int[this.size]);
    }

    @Override
    public int[] toArray(int[] nArray) {
        int[] nArray2 = nArray.length < this.size ? (int[])Array.newInstance(super.getClass().getComponentType(), this.size) : nArray;
        int n = 0;
        for (int i2 = this.arraySize - 1; i2 >= 0; --i2) {
            if (this.keyStates[i2] != 2) continue;
            nArray2[n] = this.keys[i2];
            ++n;
        }
        while (n < nArray2.length) {
            nArray2[n] = 0;
            ++n;
        }
        return nArray2;
    }

    @Override
    public IntSet synchronize() {
        return new SyncIntSet(this);
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object == null || super.getClass() != object.getClass()) {
            return false;
        }
        IntOptHashSet intOptHashSet = (IntOptHashSet)object;
        if (this.size != intOptHashSet.size) {
            return false;
        }
        if (this.hashCodeModifications == this.modifications && intOptHashSet.hashCodeModifications == intOptHashSet.modifications && this.hashCode != intOptHashSet.hashCode) {
            return false;
        }
        for (int i2 = this.arraySize - 1; i2 >= 0; --i2) {
            if (this.keyStates[i2] != 2 || intOptHashSet.contains(this.keys[i2])) continue;
            return false;
        }
        return true;
    }

    public int hashCode() {
        if (this.hashCodeModifications != this.modifications) {
            this.hashCode = (int)HashCodeBuilder.hash(this.size);
            for (int i2 = this.arraySize - 1; i2 >= 0; --i2) {
                if (this.keyStates[i2] != 2) continue;
                this.hashCode ^= (int)HashCodeBuilder.hash(this.keys[i2]);
            }
            this.hashCodeModifications = this.modifications;
        }
        return this.hashCode;
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
        $assertionsDisabled = !(class$de$vw$mib$collections$ints$IntOptHashSet == null ? (class$de$vw$mib$collections$ints$IntOptHashSet = IntOptHashSet.class$("de.vw.mib.collections.ints.IntOptHashSet")) : class$de$vw$mib$collections$ints$IntOptHashSet).desiredAssertionStatus();
    }
}

