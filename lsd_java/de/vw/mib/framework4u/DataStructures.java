/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.framework4u;

import de.vw.mib.collections.AvlTree;
import de.vw.mib.collections.BlockingBuffer;
import de.vw.mib.collections.Buffer;
import de.vw.mib.collections.ObjectObjectMap;
import de.vw.mib.collections.ObjectObjectOptHashMap;
import de.vw.mib.collections.RingBuffer;
import de.vw.mib.collections.SimpleBiMap;
import de.vw.mib.collections.copyonwrite.CowArray;
import de.vw.mib.collections.copyonwrite.CowList;
import de.vw.mib.collections.ints.IntArrayList;
import de.vw.mib.collections.ints.IntIntMap;
import de.vw.mib.collections.ints.IntIntOptHashMap;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.collections.ints.IntOptHashSet;
import de.vw.mib.collections.ints.IntPairArrayList;
import de.vw.mib.collections.ints.IntSet;
import de.vw.mib.collections.ints.MultiIntegerTupleList;
import de.vw.mib.collections.longs.LongIntMap;
import de.vw.mib.collections.longs.LongIntOptHashMap;
import de.vw.mib.collections.longs.LongLongMap;
import de.vw.mib.collections.longs.LongLongOptHashMap;
import de.vw.mib.collections.longs.LongObjectMap;
import de.vw.mib.collections.longs.LongObjectOptHashMap;
import java.util.Comparator;
import java.util.Map;

public final class DataStructures {
    DataStructures() {
    }

    public AvlTree createAvlTree(Comparator comparator) {
        return new AvlTree(comparator);
    }

    public Buffer createRingBuffer(int n) {
        return new RingBuffer(n);
    }

    public Buffer createBlockingBuffer(int n) {
        return new BlockingBuffer(n);
    }

    public CowArray createCopyOnWriteArray() {
        return new CowArray();
    }

    public CowArray createCopyOnWriteArray(int n) {
        return new CowArray(n);
    }

    public CowList createCopyOnWriteList() {
        return CowList.EMPTY;
    }

    public IntIntMap createIntIntMap() {
        return new IntIntOptHashMap();
    }

    public IntObjectMap createIntObjectMap() {
        return new IntObjectOptHashMap();
    }

    public LongIntMap createLongIntMap() {
        return new LongIntOptHashMap();
    }

    public LongLongMap createLongLongMap() {
        return new LongLongOptHashMap();
    }

    public LongObjectMap createLongObjectMap() {
        return new LongObjectOptHashMap();
    }

    public Map createSimpleBiMap() {
        return new SimpleBiMap();
    }

    public ObjectObjectMap createObjectObjectMap() {
        return new ObjectObjectOptHashMap();
    }

    public IntSet createIntSet() {
        return new IntOptHashSet();
    }

    public MultiIntegerTupleList createMultiIntegerTupleList(int n) {
        return new MultiIntegerTupleList(n);
    }

    public IntPairArrayList createIntPairList(int n) {
        return new IntPairArrayList(n);
    }

    public IntArrayList createIntList(int n) {
        return new IntArrayList(n);
    }
}

