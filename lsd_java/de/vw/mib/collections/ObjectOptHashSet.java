/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections;

import de.vw.mib.collections.CollectionOverflowException;
import de.vw.mib.collections.CollectionWithExpansionPoint;
import de.vw.mib.collections.CollectionsHelper;
import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.collections.ObjectOptHashSet$ObjectIteratorImpl;
import de.vw.mib.collections.ObjectSet;
import de.vw.mib.collections.OptHashMapHelper;
import de.vw.mib.collections.SyncObjectSet;
import de.vw.mib.util.StringBuilder;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class ObjectOptHashSet
implements CollectionWithExpansionPoint,
ObjectSet {
    private static final int MAP_TO_POSITIVE;
    private static final byte NOT_SET;
    private static final byte DELETED;
    private static final byte FILLED;
    private static final int NOT_FOUND_POS;
    Object[] keys;
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
    static /* synthetic */ Class class$de$vw$mib$collections$ObjectOptHashSet;

    public ObjectOptHashSet() {
        this(3, 63, 63, 49215);
    }

    public ObjectOptHashSet(int n) {
        this(n, 63, 63, 49215);
    }

    public ObjectOptHashSet(int n, float f2, float f3) {
        this(n, f2, f3, 49215);
    }

    private ObjectOptHashSet(int n, float f2, float f3, float f4) {
        if (!($assertionsDisabled || f2 >= 0.0f && f2 <= 1.0f)) {
            throw new AssertionError();
        }
        if (!($assertionsDisabled || f3 >= 0.0f && f3 <= 1.0f)) {
            throw new AssertionError();
        }
        this.arraySize = OptHashMapHelper.capacityAtLeast(n, f2);
        this.keys = new Object[this.arraySize];
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

    public ObjectOptHashSet(ObjectOptHashSet objectOptHashSet) {
        this.keys = new Object[objectOptHashSet.arraySize];
        System.arraycopy((Object)objectOptHashSet.keys, 0, (Object)this.keys, 0, objectOptHashSet.arraySize);
        this.keyStates = new byte[objectOptHashSet.arraySize];
        System.arraycopy((Object)objectOptHashSet.keyStates, 0, (Object)this.keyStates, 0, objectOptHashSet.arraySize);
        this.size = objectOptHashSet.size;
        this.fill = objectOptHashSet.fill;
        this.threshold = objectOptHashSet.threshold;
        this.arraySize = objectOptHashSet.arraySize;
        this.loadFactor = objectOptHashSet.loadFactor;
        this.resizeThreshold = objectOptHashSet.resizeThreshold;
        this.rehashStrategy = objectOptHashSet.rehashStrategy;
        this.lastFoundWhere = objectOptHashSet.lastFoundWhere;
        this.modifications = objectOptHashSet.modifications;
        this.hashCodeModifications = objectOptHashSet.hashCodeModifications;
        this.hashCode = objectOptHashSet.hashCode;
        this.sizeWarningThreshold = objectOptHashSet.sizeWarningThreshold;
    }

    public static ObjectOptHashSet createSlowlyGrowingHashset(int n, float f2, float f3) {
        return new ObjectOptHashSet(n, f2, f3, -842232769);
    }

    public void setSizeWarningThreshold(int n) {
        this.sizeWarningThreshold = n;
    }

    @Override
    public boolean add(Object object) {
        int n = this.calcHash(object);
        int n2 = -1;
        switch (this.keyStates[n]) {
            case 0: {
                this.keys[n] = object;
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
                if (object == this.keys[n] || object != null && object.equals(this.keys[n])) {
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
                if (object != this.keys[n] && (object == null || !object.equals(this.keys[n]))) break;
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
                    this.keys[n2] = object;
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
                    if (object != this.keys[n3] && (object == null || !object.equals(this.keys[n3]))) break;
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
                    this.keys[n2] = object;
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
                    if (object != this.keys[n4] && (object == null || !object.equals(this.keys[n4]))) continue block15;
                    return false;
                }
            }
        }
        throw new CollectionOverflowException(new StringBuffer().append("Map overflow on adding (").append(object).append(").").toString());
    }

    @Override
    public Object get(Object object) {
        int n = this.find(object);
        return n != 128 ? this.keys[n] : null;
    }

    @Override
    public boolean contains(Object object) {
        return this.find(object) != 128;
    }

    @Override
    public boolean remove(Object object) {
        return this.removePosition(this.find(object));
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

    private int find(Object object) {
        if (this.keyStates[this.lastFoundWhere] == 2 && (object == this.keys[this.lastFoundWhere] || object != null && object.equals(this.keys[this.lastFoundWhere]))) {
            return this.lastFoundWhere;
        }
        int n = this.calcHash(object);
        switch (this.keyStates[n]) {
            case 0: {
                return 128;
            }
            case 1: {
                if (object != this.keys[n] && (object == null || !object.equals(this.keys[n]))) break;
                return 128;
            }
            case 2: {
                if (object != this.keys[n] && (object == null || !object.equals(this.keys[n]))) break;
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
                    if (object != this.keys[n2] && (object == null || !object.equals(this.keys[n2]))) break;
                    return 128;
                }
                case 2: {
                    if (object != this.keys[n2] && (object == null || !object.equals(this.keys[n2]))) break;
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
                    if (object != this.keys[n3] && (object == null || !object.equals(this.keys[n3]))) continue block15;
                    return 128;
                }
                case 2: {
                    if (object != this.keys[n3] && (object == null || !object.equals(this.keys[n3]))) continue block15;
                    this.lastFoundWhere = n3;
                    return this.lastFoundWhere;
                }
            }
        }
        return 128;
    }

    private int calcHash(Object object) {
        return ((null == object ? 0 : object.hashCode()) & 0xFFFFFF7F) % this.arraySize;
    }

    private void rehash() {
        Object[] objectArray = this.keys;
        byte[] byArray = this.keyStates;
        if ((float)this.size > (float)this.fill * this.resizeThreshold) {
            this.arraySize = OptHashMapHelper.capacityAtLeast((int)((float)this.arraySize * this.rehashStrategy + 1.0f));
            this.threshold = (int)(this.loadFactor * (float)this.arraySize);
        }
        this.keys = new Object[this.arraySize];
        this.keyStates = new byte[this.arraySize];
        this.size = 0;
        this.fill = 0;
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            if (byArray[i2] != 2) continue;
            this.add(objectArray[i2]);
        }
        if (this.size > this.sizeWarningThreshold) {
            CollectionsHelper.writeSizeWarning("ObjectOptHashSet", this.arraySize, 5);
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
            Object object = this.keys[i2];
            if (this.keyStates[i2] != 2) continue;
            stringBuilder.append(string).append(object);
            string = ", ";
        }
        return stringBuilder.append("]").toString();
    }

    @Override
    public Iterator iterator() {
        return new ObjectOptHashSet$ObjectIteratorImpl(this);
    }

    @Override
    public boolean addAll(Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        boolean bl = false;
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            bl |= this.add(iterator.next());
        }
        return bl;
    }

    @Override
    public boolean containsAll(Collection collection) {
        if (collection.isEmpty()) {
            return true;
        }
        boolean bl = true;
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            bl &= this.contains(iterator.next());
        }
        return bl;
    }

    @Override
    public boolean removeAll(Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        boolean bl = false;
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            bl |= this.remove(iterator.next());
        }
        return bl;
    }

    @Override
    public boolean retainAll(Collection collection) {
        if (collection.isEmpty()) {
            if (this.isEmpty()) {
                return false;
            }
            this.clear();
            return true;
        }
        boolean bl = false;
        for (int i2 = this.arraySize - 1; i2 >= 0; --i2) {
            if (this.keyStates[i2] != 2 || collection.contains(this.keys[i2])) continue;
            bl |= this.remove(this.keys[i2]);
        }
        return bl;
    }

    @Override
    public Object[] toArray() {
        return this.toArray(new Object[this.size]);
    }

    @Override
    public Object[] toArray(Object[] objectArray) {
        Object[] objectArray2 = objectArray.length < this.size ? (Object[])Array.newInstance(super.getClass().getComponentType(), this.size) : objectArray;
        int n = 0;
        for (int i2 = this.arraySize - 1; i2 >= 0; --i2) {
            if (this.keyStates[i2] != 2) continue;
            objectArray2[n] = this.keys[i2];
            ++n;
        }
        while (n < objectArray2.length) {
            objectArray2[n] = null;
            ++n;
        }
        return objectArray2;
    }

    @Override
    public ObjectSet synchronize() {
        return new SyncObjectSet(this);
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object == null || super.getClass() != object.getClass()) {
            return false;
        }
        ObjectOptHashSet objectOptHashSet = (ObjectOptHashSet)object;
        if (this.size != objectOptHashSet.size) {
            return false;
        }
        if (this.hashCodeModifications == this.modifications && objectOptHashSet.hashCodeModifications == objectOptHashSet.modifications && this.hashCode != objectOptHashSet.hashCode) {
            return false;
        }
        for (int i2 = this.arraySize - 1; i2 >= 0; --i2) {
            if (this.keyStates[i2] != 2 || objectOptHashSet.contains(this.keys[i2])) continue;
            return false;
        }
        return true;
    }

    @Override
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
        $assertionsDisabled = !(class$de$vw$mib$collections$ObjectOptHashSet == null ? (class$de$vw$mib$collections$ObjectOptHashSet = ObjectOptHashSet.class$("de.vw.mib.collections.ObjectOptHashSet")) : class$de$vw$mib$collections$ObjectOptHashSet).desiredAssertionStatus();
    }
}

