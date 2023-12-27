/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.ints;

import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.collections.ints.IntPairObjectMap;
import de.vw.mib.collections.longs.LongIterator;
import de.vw.mib.collections.longs.LongObjectMap;
import de.vw.mib.collections.longs.LongObjectOptHashMap;
import de.vw.mib.collections.longs.LongOptHashSet;
import de.vw.mib.collections.longs.LongSet;
import java.util.Iterator;

public class IntPairObjectOptHashMap
implements IntPairObjectMap {
    private final LongObjectMap backingMap = new LongObjectOptHashMap();
    private final transient IntObjectMap backingMapA = new IntObjectOptHashMap();
    private final transient IntObjectMap backingMapB = new IntObjectOptHashMap();

    @Override
    public Object put(int n, int n2, Object object) {
        long l = this.buildKey(n, n2);
        this.addKeypart(this.backingMapA, n, l);
        this.addKeypart(this.backingMapB, n2, l);
        return this.backingMap.put(l, object);
    }

    private void addKeypart(IntObjectMap intObjectMap, int n, long l) {
        LongSet longSet = this.getPartialKeyset(intObjectMap, n);
        longSet.add(l);
    }

    @Override
    public Object get(int n, int n2) {
        return this.backingMap.get(this.buildKey(n, n2));
    }

    @Override
    public Object[] getA(int n) {
        return this.getValues(this.getPartialKeyset(this.backingMapA, n));
    }

    @Override
    public Object[] getB(int n) {
        return this.getValues(this.getPartialKeyset(this.backingMapB, n));
    }

    private Object[] getValues(LongSet longSet) {
        Object[] objectArray = new Object[longSet.size()];
        int n = 0;
        LongIterator longIterator = longSet.iterator();
        while (longIterator.hasNext()) {
            long l = longIterator.next();
            objectArray[n] = this.backingMap.get(l);
            ++n;
        }
        return objectArray;
    }

    @Override
    public Object remove(int n, int n2) {
        long l = this.buildKey(n, n2);
        this.getPartialKeyset(this.backingMapA, n).remove(l);
        this.getPartialKeyset(this.backingMapB, n2).remove(l);
        return this.backingMap.remove(l);
    }

    @Override
    public Object[] removeA(int n) {
        return this.removePartialKey(this.backingMapA, n);
    }

    @Override
    public Object[] removeB(int n) {
        return this.removePartialKey(this.backingMapB, n);
    }

    private Object[] removePartialKey(IntObjectMap intObjectMap, int n) {
        Object[] objectArray = this.removeAll(this.getPartialKeyset(intObjectMap, n));
        intObjectMap.remove(n);
        return objectArray;
    }

    private Object[] removeAll(LongSet longSet) {
        Object[] objectArray = new Object[longSet.size()];
        int n = 0;
        LongIterator longIterator = longSet.iterator();
        while (longIterator.hasNext()) {
            long l = longIterator.next();
            objectArray[n] = this.backingMap.get(l);
            this.backingMap.remove(l);
            ++n;
        }
        return objectArray;
    }

    @Override
    public int size() {
        return this.backingMap.size();
    }

    @Override
    public boolean isEmpty() {
        return this.backingMap.size() == 0;
    }

    public String toString() {
        return this.backingMap.toString();
    }

    public int hashCode() {
        return this.backingMap.hashCode();
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (object.getClass() != super.getClass()) {
            return false;
        }
        IntPairObjectOptHashMap intPairObjectOptHashMap = (IntPairObjectOptHashMap)object;
        return intPairObjectOptHashMap.backingMap.equals(this.backingMap);
    }

    private long buildKey(int n, int n2) {
        return (long)n << 32 | (long)n2;
    }

    private LongSet getPartialKeyset(IntObjectMap intObjectMap, int n) {
        LongSet longSet = (LongSet)intObjectMap.get(n);
        if (null == longSet) {
            longSet = new LongOptHashSet(1);
            intObjectMap.put(n, longSet);
        }
        return longSet;
    }

    @Override
    public Iterator valueIterator() {
        return this.backingMap.valueIterator();
    }
}

