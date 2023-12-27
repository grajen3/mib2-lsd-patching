/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.floats;

import de.vw.mib.collections.CollectionOverflowException;
import de.vw.mib.collections.CollectionWithExpansionPoint;
import de.vw.mib.collections.CollectionsHelper;
import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.collections.OptHashMapHelper;
import de.vw.mib.collections.floats.FloatCollection;
import de.vw.mib.collections.floats.FloatIterator;
import de.vw.mib.collections.floats.FloatOptHashSet$FloatIteratorImpl;
import de.vw.mib.collections.floats.FloatSet;
import de.vw.mib.collections.floats.SyncFloatSet;
import de.vw.mib.util.StringBuilder;
import java.lang.reflect.Array;
import java.util.Arrays;

public class FloatOptHashSet
implements CollectionWithExpansionPoint,
FloatSet {
    private static final int MAP_TO_POSITIVE;
    private static final byte NOT_SET;
    private static final byte DELETED;
    private static final byte FILLED;
    private static final int NOT_FOUND_POS;
    float[] keys;
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
    static /* synthetic */ Class class$de$vw$mib$collections$floats$FloatOptHashSet;

    public FloatOptHashSet() {
        this(3, 63, 63, 49215);
    }

    public FloatOptHashSet(int n) {
        this(n, 63, 63, 49215);
    }

    public FloatOptHashSet(int n, float f2, float f3) {
        this(n, f2, f3, 49215);
    }

    private FloatOptHashSet(int n, float f2, float f3, float f4) {
        if (!($assertionsDisabled || f2 >= 0.0f && f2 <= 1.0f)) {
            throw new AssertionError();
        }
        if (!($assertionsDisabled || f3 >= 0.0f && f3 <= 1.0f)) {
            throw new AssertionError();
        }
        this.arraySize = OptHashMapHelper.capacityAtLeast(n, f2);
        this.keys = new float[this.arraySize];
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

    public FloatOptHashSet(FloatOptHashSet floatOptHashSet) {
        this.keys = new float[floatOptHashSet.arraySize];
        System.arraycopy((Object)floatOptHashSet.keys, 0, (Object)this.keys, 0, floatOptHashSet.arraySize);
        this.keyStates = new byte[floatOptHashSet.arraySize];
        System.arraycopy((Object)floatOptHashSet.keyStates, 0, (Object)this.keyStates, 0, floatOptHashSet.arraySize);
        this.size = floatOptHashSet.size;
        this.fill = floatOptHashSet.fill;
        this.threshold = floatOptHashSet.threshold;
        this.arraySize = floatOptHashSet.arraySize;
        this.loadFactor = floatOptHashSet.loadFactor;
        this.resizeThreshold = floatOptHashSet.resizeThreshold;
        this.rehashStrategy = floatOptHashSet.rehashStrategy;
        this.lastFoundWhere = floatOptHashSet.lastFoundWhere;
        this.modifications = floatOptHashSet.modifications;
        this.hashCodeModifications = floatOptHashSet.hashCodeModifications;
        this.hashCode = floatOptHashSet.hashCode;
        this.sizeWarningThreshold = floatOptHashSet.sizeWarningThreshold;
    }

    public static FloatOptHashSet createSlowlyGrowingHashset(int n, float f2, float f3) {
        return new FloatOptHashSet(n, f2, f3, -842232769);
    }

    public void setSizeWarningThreshold(int n) {
        this.sizeWarningThreshold = n;
    }

    @Override
    public boolean add(float f2) {
        int n = this.calcHash(f2);
        int n2 = -1;
        switch (this.keyStates[n]) {
            case 0: {
                this.keys[n] = f2;
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
                if (f2 == this.keys[n]) {
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
                if (f2 != this.keys[n]) break;
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
                    this.keys[n2] = f2;
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
                    if (f2 != this.keys[n3]) break;
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
                    this.keys[n2] = f2;
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
                    if (f2 != this.keys[n4]) continue block15;
                    return false;
                }
            }
        }
        throw new CollectionOverflowException(new StringBuffer().append("Map overflow on adding (").append(f2).append(").").toString());
    }

    @Override
    public float get(float f2) {
        int n = this.find(f2);
        return n != 128 ? this.keys[n] : 0.0f;
    }

    @Override
    public boolean contains(float f2) {
        return this.find(f2) != 128;
    }

    @Override
    public boolean remove(float f2) {
        return this.removePosition(this.find(f2));
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

    private int find(float f2) {
        if (this.keyStates[this.lastFoundWhere] == 2 && f2 == this.keys[this.lastFoundWhere]) {
            return this.lastFoundWhere;
        }
        int n = this.calcHash(f2);
        switch (this.keyStates[n]) {
            case 0: {
                return 128;
            }
            case 1: {
                if (f2 != this.keys[n]) break;
                return 128;
            }
            case 2: {
                if (f2 != this.keys[n]) break;
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
                    if (f2 != this.keys[n2]) break;
                    return 128;
                }
                case 2: {
                    if (f2 != this.keys[n2]) break;
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
                    if (f2 != this.keys[n3]) continue block15;
                    return 128;
                }
                case 2: {
                    if (f2 != this.keys[n3]) continue block15;
                    this.lastFoundWhere = n3;
                    return this.lastFoundWhere;
                }
            }
        }
        return 128;
    }

    private int calcHash(float f2) {
        return (Float.floatToIntBits(f2) & 0xFFFFFF7F) % this.arraySize;
    }

    private void rehash() {
        float[] fArray = this.keys;
        byte[] byArray = this.keyStates;
        if ((float)this.size > (float)this.fill * this.resizeThreshold) {
            this.arraySize = OptHashMapHelper.capacityAtLeast((int)((float)this.arraySize * this.rehashStrategy + 1.0f));
            this.threshold = (int)(this.loadFactor * (float)this.arraySize);
        }
        this.keys = new float[this.arraySize];
        this.keyStates = new byte[this.arraySize];
        this.size = 0;
        this.fill = 0;
        for (int i2 = fArray.length - 1; i2 >= 0; --i2) {
            if (byArray[i2] != 2) continue;
            this.add(fArray[i2]);
        }
        if (this.size > this.sizeWarningThreshold) {
            CollectionsHelper.writeSizeWarning("FloatOptHashSet", this.arraySize, 5);
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
            float f2 = this.keys[i2];
            if (this.keyStates[i2] != 2) continue;
            stringBuilder.append(string).append(f2);
            string = ", ";
        }
        return stringBuilder.append("]").toString();
    }

    @Override
    public FloatIterator iterator() {
        return new FloatOptHashSet$FloatIteratorImpl(this);
    }

    @Override
    public boolean addAll(FloatCollection floatCollection) {
        if (floatCollection.isEmpty()) {
            return false;
        }
        boolean bl = false;
        FloatIterator floatIterator = floatCollection.iterator();
        while (floatIterator.hasNext()) {
            bl |= this.add(floatIterator.next());
        }
        return bl;
    }

    @Override
    public boolean containsAll(FloatCollection floatCollection) {
        if (floatCollection.isEmpty()) {
            return true;
        }
        boolean bl = true;
        FloatIterator floatIterator = floatCollection.iterator();
        while (floatIterator.hasNext()) {
            bl &= this.contains(floatIterator.next());
        }
        return bl;
    }

    @Override
    public boolean removeAll(FloatCollection floatCollection) {
        if (floatCollection.isEmpty()) {
            return false;
        }
        boolean bl = false;
        FloatIterator floatIterator = floatCollection.iterator();
        while (floatIterator.hasNext()) {
            bl |= this.remove(floatIterator.next());
        }
        return bl;
    }

    @Override
    public boolean retainAll(FloatCollection floatCollection) {
        if (floatCollection.isEmpty()) {
            if (this.isEmpty()) {
                return false;
            }
            this.clear();
            return true;
        }
        boolean bl = false;
        for (int i2 = this.arraySize - 1; i2 >= 0; --i2) {
            if (this.keyStates[i2] != 2 || floatCollection.contains(this.keys[i2])) continue;
            bl |= this.remove(this.keys[i2]);
        }
        return bl;
    }

    @Override
    public float[] toArray() {
        return this.toArray(new float[this.size]);
    }

    @Override
    public float[] toArray(float[] fArray) {
        float[] fArray2 = fArray.length < this.size ? (float[])Array.newInstance(super.getClass().getComponentType(), this.size) : fArray;
        int n = 0;
        for (int i2 = this.arraySize - 1; i2 >= 0; --i2) {
            if (this.keyStates[i2] != 2) continue;
            fArray2[n] = this.keys[i2];
            ++n;
        }
        while (n < fArray2.length) {
            fArray2[n] = 0.0f;
            ++n;
        }
        return fArray2;
    }

    @Override
    public FloatSet synchronize() {
        return new SyncFloatSet(this);
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object == null || super.getClass() != object.getClass()) {
            return false;
        }
        FloatOptHashSet floatOptHashSet = (FloatOptHashSet)object;
        if (this.size != floatOptHashSet.size) {
            return false;
        }
        if (this.hashCodeModifications == this.modifications && floatOptHashSet.hashCodeModifications == floatOptHashSet.modifications && this.hashCode != floatOptHashSet.hashCode) {
            return false;
        }
        for (int i2 = this.arraySize - 1; i2 >= 0; --i2) {
            if (this.keyStates[i2] != 2 || floatOptHashSet.contains(this.keys[i2])) continue;
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
        $assertionsDisabled = !(class$de$vw$mib$collections$floats$FloatOptHashSet == null ? (class$de$vw$mib$collections$floats$FloatOptHashSet = FloatOptHashSet.class$("de.vw.mib.collections.floats.FloatOptHashSet")) : class$de$vw$mib$collections$floats$FloatOptHashSet).desiredAssertionStatus();
    }
}

