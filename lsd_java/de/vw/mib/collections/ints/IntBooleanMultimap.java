/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.ints;

import de.vw.mib.collections.ObjectIterator;
import de.vw.mib.collections.booleans.BooleanArrayList;
import de.vw.mib.collections.booleans.BooleanCollection;
import de.vw.mib.collections.booleans.BooleanIterator;
import de.vw.mib.collections.booleans.BooleanReadOnlyArrayList;
import de.vw.mib.collections.ints.IntBooleanMap;
import de.vw.mib.collections.ints.IntBooleanMap$Entry;
import de.vw.mib.collections.ints.IntBooleanMultimap$1;
import de.vw.mib.collections.ints.IntBooleanMultimap$2;
import de.vw.mib.collections.ints.IntBooleanMultimap$3;
import de.vw.mib.collections.ints.IntBooleanMultimap$4;
import de.vw.mib.collections.ints.IntBooleanMultimap$5;
import de.vw.mib.collections.ints.IntIterator;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectMap$Entry;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.collections.ints.IntSet;
import de.vw.mib.collections.ints.SyncIntBooleanOptHashMap;
import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Set;

public class IntBooleanMultimap
implements IntBooleanMap {
    final BooleanArrayList empty = new BooleanArrayList(0);
    private static final int NEUTRAL_KEY;
    private static final boolean NEUTRAL_VALUE;
    final IntObjectMap backingMap = new IntObjectOptHashMap();
    private final int neutralKey;
    final boolean neutralValue;
    private int writes = 0;
    private int cachedSizeWritesCount;
    private int size;

    public IntBooleanMultimap() {
        this.neutralValue = false;
        this.neutralKey = 0;
    }

    @Override
    public boolean put(int n, boolean bl) {
        boolean bl2;
        BooleanArrayList booleanArrayList;
        if (!this.backingMap.containsKey(n)) {
            booleanArrayList = new BooleanArrayList();
            bl2 = this.neutralValue;
        } else {
            booleanArrayList = this.getValuesList(n);
            bl2 = booleanArrayList.last();
        }
        booleanArrayList.add(bl);
        this.backingMap.put(n, booleanArrayList);
        ++this.writes;
        return bl2;
    }

    private BooleanArrayList getValuesList(int n) {
        return (BooleanArrayList)this.backingMap.get(n);
    }

    @Override
    public boolean get(int n) {
        if (this.backingMap.containsKey(n)) {
            return this.getValuesList(n).last();
        }
        return this.neutralValue;
    }

    public BooleanCollection getAll(int n) {
        if (this.backingMap.containsKey(n)) {
            BooleanArrayList booleanArrayList = this.getValuesList(n);
            return new BooleanReadOnlyArrayList(booleanArrayList);
        }
        return BooleanReadOnlyArrayList.EMPTY;
    }

    @Override
    public boolean containsKey(int n) {
        return this.backingMap.containsKey(n);
    }

    public boolean containsKeyValuePair(int n, boolean bl) {
        if (this.backingMap.containsKey(n)) {
            BooleanArrayList booleanArrayList = this.getValuesList(n);
            return booleanArrayList.contains(bl);
        }
        return false;
    }

    @Override
    public boolean remove(int n) {
        BooleanArrayList booleanArrayList = (BooleanArrayList)this.backingMap.remove(n);
        if (null != booleanArrayList) {
            ++this.writes;
            return booleanArrayList.last();
        }
        return this.neutralValue;
    }

    public boolean removeValue(int n, boolean bl) {
        BooleanArrayList booleanArrayList = this.getValuesList(n);
        if (null == booleanArrayList) {
            return this.neutralValue;
        }
        boolean bl2 = booleanArrayList.removeValue(bl);
        if (booleanArrayList.size() == 0) {
            this.backingMap.remove(n);
        } else {
            this.backingMap.put(n, booleanArrayList);
        }
        if (bl2) {
            ++this.writes;
            return bl;
        }
        return this.neutralValue;
    }

    @Override
    public IntIterator keyIterator() {
        return this.backingMap.keyIterator();
    }

    @Override
    public int size() {
        if (this.cachedSizeWritesCount != this.writes) {
            this.cachedSizeWritesCount = this.writes;
            this.size = this.calcSize();
        }
        return this.size;
    }

    private int calcSize() {
        int n = 0;
        ObjectIterator objectIterator = (ObjectIterator)this.backingMap.valueIterator();
        while (objectIterator.hasNext()) {
            BooleanArrayList booleanArrayList = (BooleanArrayList)objectIterator.next();
            if (null == booleanArrayList) continue;
            n += booleanArrayList.size();
        }
        return n;
    }

    @Override
    public boolean isEmpty() {
        return this.backingMap.isEmpty();
    }

    @Override
    public boolean containsValue(boolean bl) {
        ObjectIterator objectIterator = (ObjectIterator)this.backingMap.valueIterator();
        while (objectIterator.hasNext()) {
            BooleanArrayList booleanArrayList = (BooleanArrayList)objectIterator.next();
            for (int i2 = booleanArrayList.size() - 1; i2 >= 0; --i2) {
                if (booleanArrayList.get(i2) != bl) continue;
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        if (!this.backingMap.isEmpty()) {
            this.backingMap.clear();
            ++this.writes;
        }
    }

    @Override
    public void ensureAvailableSpaceAndAvoidFurtherRehashes(int n) {
        this.backingMap.ensureAvailableSpaceAndAvoidFurtherRehashes(n);
    }

    @Override
    public Iterator entryIterator() {
        Iterator iterator = this.backingMap.entryIterator();
        return new IntBooleanMultimap$1(this, iterator);
    }

    @Override
    public Set entrySet() {
        return new IntBooleanMultimap$2(this);
    }

    @Override
    public IntSet keySet() {
        return new IntBooleanMultimap$3(this);
    }

    @Override
    public BooleanCollection values() {
        return new IntBooleanMultimap$4(this);
    }

    @Override
    public BooleanIterator valueIterator() {
        Iterator iterator = this.backingMap.entryIterator();
        return new IntBooleanMultimap$5(this, iterator);
    }

    @Override
    public boolean replaceKey(int n, int n2) {
        Object object = this.backingMap.replaceKey(n, n2);
        if (null != object) {
            ++this.writes;
            return ((BooleanArrayList)object).last();
        }
        return this.neutralValue;
    }

    @Override
    public int replaceOneValue(boolean bl, boolean bl2) {
        Iterator iterator = this.backingMap.entryIterator();
        while (iterator.hasNext()) {
            IntObjectMap$Entry intObjectMap$Entry = (IntObjectMap$Entry)iterator.next();
            int n = intObjectMap$Entry.getKey();
            BooleanArrayList booleanArrayList = (BooleanArrayList)intObjectMap$Entry.getValue();
            for (int i2 = 0; i2 < booleanArrayList.size(); ++i2) {
                boolean bl3 = booleanArrayList.get(i2);
                if (bl3 != bl) continue;
                booleanArrayList.set(i2, bl2);
                this.backingMap.put(n, booleanArrayList);
                ++this.writes;
                return n;
            }
        }
        return this.neutralKey;
    }

    @Override
    public int getOneKeyByValue(boolean bl) {
        Iterator iterator = this.backingMap.entryIterator();
        while (iterator.hasNext()) {
            IntObjectMap$Entry intObjectMap$Entry = (IntObjectMap$Entry)iterator.next();
            int n = intObjectMap$Entry.getKey();
            BooleanArrayList booleanArrayList = (BooleanArrayList)intObjectMap$Entry.getValue();
            for (int i2 = 0; i2 < booleanArrayList.size(); ++i2) {
                if (bl != booleanArrayList.get(i2)) continue;
                ++this.writes;
                return n;
            }
        }
        return this.neutralKey;
    }

    @Override
    public boolean[] valuesToArray() {
        return this.valuesToArray(new boolean[this.size()]);
    }

    @Override
    public boolean[] valuesToArray(boolean[] blArray) {
        boolean[] blArray2 = blArray;
        if (blArray.length < this.size()) {
            blArray2 = (boolean[])Array.newInstance(super.getClass().getComponentType(), this.size());
        }
        BooleanIterator booleanIterator = this.valueIterator();
        int n = 0;
        while (booleanIterator.hasNext()) {
            blArray2[n] = booleanIterator.next();
            ++n;
        }
        return blArray2;
    }

    @Override
    public int[] keysToArray() {
        return this.keysToArray(new int[this.backingMap.size()]);
    }

    @Override
    public int[] keysToArray(int[] nArray) {
        int[] nArray2 = nArray;
        if (nArray.length < this.backingMap.size()) {
            nArray2 = (int[])Array.newInstance(super.getClass().getComponentType(), this.backingMap.size());
        }
        IntIterator intIterator = this.keyIterator();
        int n = 0;
        while (intIterator.hasNext()) {
            nArray2[n] = intIterator.next();
            ++n;
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

    static /* synthetic */ int access$000(IntBooleanMultimap intBooleanMultimap) {
        return intBooleanMultimap.neutralKey;
    }
}

