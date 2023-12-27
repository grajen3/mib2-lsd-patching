/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.hmi.utils;

import de.vw.mib.hmi.utils.PerfectSlotHash;
import de.vw.mib.hmi.utils.PerfectSlotHashFactory$Item;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Random;

public class PerfectSlotHashFactory {
    private static final int[] BINARY_DATA;
    private final int slotCount;
    private int[] keys;
    private int[] data;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$hmi$utils$PerfectSlotHashFactory;

    public PerfectSlotHashFactory(int[] nArray, Random random) {
        this(nArray, random, false);
    }

    PerfectSlotHashFactory(int[] nArray, Random random, boolean bl) {
        this.slotCount = nArray.length;
        if (bl) {
            this.initBinary(nArray);
        } else {
            this.initPerfect(nArray, random);
        }
    }

    private void initPerfect(int[] nArray, Random random) {
        try {
            this.keys = new int[this.slotCount];
            this.data = new int[this.slotCount];
            if (this.slotCount > 0) {
                this.calculate(nArray, random);
            }
        }
        catch (IllegalStateException illegalStateException) {
            this.initBinary(nArray);
        }
    }

    private void initBinary(int[] nArray) {
        this.keys = new int[this.slotCount];
        this.data = BINARY_DATA;
        System.arraycopy((Object)nArray, 0, (Object)this.keys, 0, this.slotCount);
        Arrays.sort(this.keys, 0, this.slotCount);
    }

    public int getSlotCount() {
        return this.slotCount;
    }

    public int[] getKeys() {
        return this.keys;
    }

    public int[] getData() {
        return this.data;
    }

    public PerfectSlotHash getPerfectSlotHash() {
        return PerfectSlotHash.newSlotHash(this.getKeys(), this.getData());
    }

    private static int H0(int n) {
        return PerfectSlotHash.H0(n);
    }

    private static int H1(int n, int n2) {
        return PerfectSlotHash.H1(n, n2);
    }

    private void calculate(int[] nArray, Random random) {
        int n;
        int n2;
        int n3;
        PerfectSlotHashFactory$Item perfectSlotHashFactory$Item = new PerfectSlotHashFactory$Item();
        Object[] objectArray = new PerfectSlotHashFactory$Item[this.slotCount];
        Arrays.fill(objectArray, perfectSlotHashFactory$Item);
        for (n3 = 0; n3 < this.slotCount; ++n3) {
            int n4 = nArray[n3];
            objectArray[PerfectSlotHashFactory.H0((int)n4) % this.slotCount] = new PerfectSlotHashFactory$Item(n4, (PerfectSlotHashFactory$Item)objectArray[PerfectSlotHashFactory.H0(n4) % this.slotCount]);
        }
        Arrays.sort(objectArray, 0, this.slotCount);
        int[] nArray2 = new int[((PerfectSlotHashFactory$Item)objectArray[0]).count];
        BitSet bitSet = new BitSet(this.slotCount);
        for (n3 = 0; n3 < this.slotCount && ((PerfectSlotHashFactory$Item)objectArray[n3]).count > 1; ++n3) {
            Object object = objectArray[n3];
            int n5 = 10000;
            n2 = random.nextInt() & Short.MAX_VALUE;
            Object object2 = object;
            while (object2 != perfectSlotHashFactory$Item) {
                n = PerfectSlotHashFactory.H1(n2, ((PerfectSlotHashFactory$Item)object2).key) % this.slotCount;
                if (bitSet.get(n)) {
                    for (int i2 = ((PerfectSlotHashFactory$Item)object).count; i2 > ((PerfectSlotHashFactory$Item)object2).count; --i2) {
                        bitSet.clear(nArray2[i2 - 1]);
                    }
                    n2 = random.nextInt() & Short.MAX_VALUE;
                    object2 = object;
                    if (0 != n5--) continue;
                    throw new IllegalStateException("No hash function found.");
                }
                bitSet.set(n);
                nArray2[((PerfectSlotHashFactory$Item)object2).count - 1] = n;
                object2 = ((PerfectSlotHashFactory$Item)object2).next;
            }
            this.data[PerfectSlotHashFactory.H0((int)((PerfectSlotHashFactory$Item)object).key) % this.slotCount] = n2;
            object2 = object;
            while (object2 != perfectSlotHashFactory$Item) {
                this.assertSlot(((PerfectSlotHashFactory$Item)object2).key, nArray2[((PerfectSlotHashFactory$Item)object2).count - 1]);
                object2 = ((PerfectSlotHashFactory$Item)object2).next;
            }
        }
        int n6 = -1;
        while (n3 < this.slotCount && ((PerfectSlotHashFactory$Item)objectArray[n3]).count == 1) {
            Object object = objectArray[n3];
            n6 = bitSet.nextClearBit(n6 + 1);
            bitSet.set(n6);
            this.data[PerfectSlotHashFactory.H0((int)((PerfectSlotHashFactory$Item)object).key) % this.slotCount] = n6 - this.slotCount;
            this.assertSlot(((PerfectSlotHashFactory$Item)object).key, n6);
            ++n3;
        }
        if (!$assertionsDisabled && this.slotCount != bitSet.cardinality()) {
            throw new AssertionError();
        }
        for (int i3 = 0; i3 < this.slotCount; ++i3) {
            n2 = nArray[i3];
            int n7 = this.data[PerfectSlotHashFactory.H0(n2) % this.slotCount];
            n = n7 < 0 ? n7 + this.slotCount : PerfectSlotHashFactory.H1(n7, n2) % this.slotCount;
            this.keys[n] = n2;
        }
    }

    private void assertSlot(int n, int n2) {
        int n3;
        int n4 = this.data[PerfectSlotHashFactory.H0(n) % this.slotCount];
        int n5 = n3 = n4 < 0 ? n4 + this.slotCount : PerfectSlotHashFactory.H1(n4, n) % this.slotCount;
        if (!$assertionsDisabled && n3 != n2) {
            throw new AssertionError();
        }
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
        $assertionsDisabled = !(class$de$vw$mib$hmi$utils$PerfectSlotHashFactory == null ? (class$de$vw$mib$hmi$utils$PerfectSlotHashFactory = PerfectSlotHashFactory.class$("de.vw.mib.hmi.utils.PerfectSlotHashFactory")) : class$de$vw$mib$hmi$utils$PerfectSlotHashFactory).desiredAssertionStatus();
        BINARY_DATA = new int[0];
    }
}

