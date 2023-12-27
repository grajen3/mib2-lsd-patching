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
import de.vw.mib.collections.longs.LongOptHashSet$LongIteratorImpl;
import de.vw.mib.collections.longs.LongSet;
import de.vw.mib.collections.longs.SyncLongSet;
import de.vw.mib.util.StringBuilder;
import java.lang.reflect.Array;
import java.util.Arrays;

public class LongOptHashSet
implements CollectionWithExpansionPoint,
LongSet {
    private static final int MAP_TO_POSITIVE;
    private static final byte NOT_SET;
    private static final byte DELETED;
    private static final byte FILLED;
    private static final int NOT_FOUND_POS;
    long[] keys;
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
    static /* synthetic */ Class class$de$vw$mib$collections$longs$LongOptHashSet;

    public LongOptHashSet() {
        this(3, 63, 63, 49215);
    }

    public LongOptHashSet(int n) {
        this(n, 63, 63, 49215);
    }

    public LongOptHashSet(int n, float f2, float f3) {
        this(n, f2, f3, 49215);
    }

    private LongOptHashSet(int n, float f2, float f3, float f4) {
        if (!($assertionsDisabled || f2 >= 0.0f && f2 <= 1.0f)) {
            throw new AssertionError();
        }
        if (!($assertionsDisabled || f3 >= 0.0f && f3 <= 1.0f)) {
            throw new AssertionError();
        }
        this.arraySize = OptHashMapHelper.capacityAtLeast(n, f2);
        this.keys = new long[this.arraySize];
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

    public LongOptHashSet(LongOptHashSet longOptHashSet) {
        this.keys = new long[longOptHashSet.arraySize];
        System.arraycopy((Object)longOptHashSet.keys, 0, (Object)this.keys, 0, longOptHashSet.arraySize);
        this.keyStates = new byte[longOptHashSet.arraySize];
        System.arraycopy((Object)longOptHashSet.keyStates, 0, (Object)this.keyStates, 0, longOptHashSet.arraySize);
        this.size = longOptHashSet.size;
        this.fill = longOptHashSet.fill;
        this.threshold = longOptHashSet.threshold;
        this.arraySize = longOptHashSet.arraySize;
        this.loadFactor = longOptHashSet.loadFactor;
        this.resizeThreshold = longOptHashSet.resizeThreshold;
        this.rehashStrategy = longOptHashSet.rehashStrategy;
        this.lastFoundWhere = longOptHashSet.lastFoundWhere;
        this.modifications = longOptHashSet.modifications;
        this.hashCodeModifications = longOptHashSet.hashCodeModifications;
        this.hashCode = longOptHashSet.hashCode;
        this.sizeWarningThreshold = longOptHashSet.sizeWarningThreshold;
    }

    public static LongOptHashSet createSlowlyGrowingHashset(int n, float f2, float f3) {
        return new LongOptHashSet(n, f2, f3, -842232769);
    }

    public void setSizeWarningThreshold(int n) {
        this.sizeWarningThreshold = n;
    }

    @Override
    public boolean add(long l) {
        int n = this.calcHash(l);
        int n2 = -1;
        switch (this.keyStates[n]) {
            case 0: {
                this.keys[n] = l;
                this.keyStates[n] = 2;
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
                if (l == this.keys[n]) {
                    this.keyStates[n] = 2;
                    ++this.size;
                    ++this.modifications;
                    this.onCollectionChanged();
                    return true;
                }
                n2 = n;
                break;
            }
            case 2: {
                if (l != this.keys[n]) break;
                return false;
            }
        }
        int n3 = n;
        int n4 = n;
        block15: for (int i2 = 1; i2 < this.arraySize; i2 += 2) {
            if ((n3 += i2) >= this.arraySize) {
                n3 -= this.arraySize;
            }
            switch (this.keyStates[n3]) {
                case 0: {
                    if (n2 < 0) {
                        n2 = n3;
                        ++this.fill;
                    }
                    this.keys[n2] = l;
                    this.keyStates[n2] = 2;
                    ++this.size;
                    ++this.modifications;
                    if (this.fill > this.threshold) {
                        this.rehash();
                    }
                    this.onCollectionChanged();
                    return true;
                }
                case 1: {
                    if (n2 >= 0) break;
                    n2 = n3;
                    break;
                }
                case 2: {
                    if (l != this.keys[n3]) break;
                    return false;
                }
            }
            if ((n4 -= i2) < 0) {
                n4 += this.arraySize;
            }
            switch (this.keyStates[n4]) {
                case 0: {
                    if (n2 < 0) {
                        n2 = n4;
                        ++this.fill;
                    }
                    this.keys[n2] = l;
                    this.keyStates[n2] = 2;
                    ++this.size;
                    ++this.modifications;
                    if (this.fill > this.threshold) {
                        this.rehash();
                    }
                    this.onCollectionChanged();
                    return true;
                }
                case 1: {
                    if (n2 >= 0) continue block15;
                    n2 = n4;
                    continue block15;
                }
                case 2: {
                    if (l != this.keys[n4]) continue block15;
                    return false;
                }
            }
        }
        throw new CollectionOverflowException(new StringBuffer().append("Map overflow on adding (").append(l).append(").").toString());
    }

    @Override
    public long get(long l) {
        int n = this.find(l);
        return n != 128 ? this.keys[n] : 0L;
    }

    @Override
    public boolean contains(long l) {
        return this.find(l) != 128;
    }

    @Override
    public boolean remove(long l) {
        return this.removePosition(this.find(l));
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

    private int find(long l) {
        if (this.keyStates[this.lastFoundWhere] == 2 && l == this.keys[this.lastFoundWhere]) {
            return this.lastFoundWhere;
        }
        int n = this.calcHash(l);
        switch (this.keyStates[n]) {
            case 0: {
                return 128;
            }
            case 1: {
                if (l != this.keys[n]) break;
                return 128;
            }
            case 2: {
                if (l != this.keys[n]) break;
                this.lastFoundWhere = n;
                return this.lastFoundWhere;
            }
        }
        int n2 = n;
        int n3 = n;
        block15: for (int i2 = 1; i2 < this.arraySize; i2 += 2) {
            if ((n2 += i2) >= this.arraySize) {
                n2 -= this.arraySize;
            }
            switch (this.keyStates[n2]) {
                case 0: {
                    return 128;
                }
                case 1: {
                    if (l != this.keys[n2]) break;
                    return 128;
                }
                case 2: {
                    if (l != this.keys[n2]) break;
                    this.lastFoundWhere = n2;
                    return this.lastFoundWhere;
                }
            }
            if ((n3 -= i2) < 0) {
                n3 += this.arraySize;
            }
            switch (this.keyStates[n3]) {
                case 0: {
                    return 128;
                }
                case 1: {
                    if (l != this.keys[n3]) continue block15;
                    return 128;
                }
                case 2: {
                    if (l != this.keys[n3]) continue block15;
                    this.lastFoundWhere = n3;
                    return this.lastFoundWhere;
                }
            }
        }
        return 128;
    }

    private int calcHash(long l) {
        return ((int)(l ^ l >>> 32) & 0xFFFFFF7F) % this.arraySize;
    }

    private void rehash() {
        long[] lArray = this.keys;
        byte[] byArray = this.keyStates;
        if ((float)this.size > (float)this.fill * this.resizeThreshold) {
            this.arraySize = OptHashMapHelper.capacityAtLeast((int)((float)this.arraySize * this.rehashStrategy + 1.0f));
            this.threshold = (int)(this.loadFactor * (float)this.arraySize);
        }
        this.keys = new long[this.arraySize];
        this.keyStates = new byte[this.arraySize];
        this.size = 0;
        this.fill = 0;
        for (int i2 = lArray.length - 1; i2 >= 0; --i2) {
            if (byArray[i2] != 2) continue;
            this.add(lArray[i2]);
        }
        if (this.size > this.sizeWarningThreshold) {
            CollectionsHelper.writeSizeWarning("LongOptHashSet", this.arraySize, 5);
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
            long l = this.keys[i2];
            if (this.keyStates[i2] != 2) continue;
            stringBuilder.append(string).append(l);
            string = ", ";
        }
        return stringBuilder.append("]").toString();
    }

    @Override
    public LongIterator iterator() {
        return new LongOptHashSet$LongIteratorImpl(this);
    }

    @Override
    public boolean addAll(LongCollection longCollection) {
        if (longCollection.isEmpty()) {
            return false;
        }
        boolean bl = false;
        LongIterator longIterator = longCollection.iterator();
        while (longIterator.hasNext()) {
            bl |= this.add(longIterator.next());
        }
        return bl;
    }

    @Override
    public boolean containsAll(LongCollection longCollection) {
        if (longCollection.isEmpty()) {
            return true;
        }
        boolean bl = true;
        LongIterator longIterator = longCollection.iterator();
        while (longIterator.hasNext()) {
            bl &= this.contains(longIterator.next());
        }
        return bl;
    }

    @Override
    public boolean removeAll(LongCollection longCollection) {
        if (longCollection.isEmpty()) {
            return false;
        }
        boolean bl = false;
        LongIterator longIterator = longCollection.iterator();
        while (longIterator.hasNext()) {
            bl |= this.remove(longIterator.next());
        }
        return bl;
    }

    @Override
    public boolean retainAll(LongCollection longCollection) {
        if (longCollection.isEmpty()) {
            if (this.isEmpty()) {
                return false;
            }
            this.clear();
            return true;
        }
        boolean bl = false;
        for (int i2 = this.arraySize - 1; i2 >= 0; --i2) {
            if (this.keyStates[i2] != 2 || longCollection.contains(this.keys[i2])) continue;
            bl |= this.remove(this.keys[i2]);
        }
        return bl;
    }

    @Override
    public long[] toArray() {
        return this.toArray(new long[this.size]);
    }

    @Override
    public long[] toArray(long[] lArray) {
        long[] lArray2 = lArray.length < this.size ? (long[])Array.newInstance(super.getClass().getComponentType(), this.size) : lArray;
        int n = 0;
        for (int i2 = this.arraySize - 1; i2 >= 0; --i2) {
            if (this.keyStates[i2] != 2) continue;
            lArray2[n] = this.keys[i2];
            ++n;
        }
        while (n < lArray2.length) {
            lArray2[n] = 0L;
            ++n;
        }
        return lArray2;
    }

    @Override
    public LongSet synchronize() {
        return new SyncLongSet(this);
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object == null || super.getClass() != object.getClass()) {
            return false;
        }
        LongOptHashSet longOptHashSet = (LongOptHashSet)object;
        if (this.size != longOptHashSet.size) {
            return false;
        }
        if (this.hashCodeModifications == this.modifications && longOptHashSet.hashCodeModifications == longOptHashSet.modifications && this.hashCode != longOptHashSet.hashCode) {
            return false;
        }
        for (int i2 = this.arraySize - 1; i2 >= 0; --i2) {
            if (this.keyStates[i2] != 2 || longOptHashSet.contains(this.keys[i2])) continue;
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
        $assertionsDisabled = !(class$de$vw$mib$collections$longs$LongOptHashSet == null ? (class$de$vw$mib$collections$longs$LongOptHashSet = LongOptHashSet.class$("de.vw.mib.collections.longs.LongOptHashSet")) : class$de$vw$mib$collections$longs$LongOptHashSet).desiredAssertionStatus();
    }
}

