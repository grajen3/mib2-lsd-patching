/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.ints;

import de.vw.mib.collections.ints.MultiIntegerTupleList$Iterator;

public final class MultiIntegerTupleList {
    public static final int NO_BLOCK;
    public static final int EMPTY_CHAIN;
    private static final int NOT_FOUND;
    private static final int[] EMPTY_ARRAY;
    private static final int DEFAULT_INITIAL_TUPLE_NUMBER;
    private final int blockSize;
    int nextFreeBlockId;
    private int length;
    int modifications;
    private int[] array;

    public MultiIntegerTupleList(int n) {
        this(n, 10);
    }

    public MultiIntegerTupleList(int n, int n2) {
        this.blockSize = n + 1;
        this.array = EMPTY_ARRAY;
        this.resize(n2);
        this.modifications = 0;
        this.nextFreeBlockId = 0;
    }

    private void resize(int n) {
        this.length = n;
        int[] nArray = this.array;
        this.array = new int[this.length * this.blockSize];
        System.arraycopy((Object)nArray, 0, (Object)this.array, 0, nArray.length);
    }

    public synchronized int getNewBlock(int n) {
        return this.addBlockToChain(n, this.getBufferId());
    }

    private int getBufferId() {
        if (this.nextFreeBlockId >= this.length) {
            this.resize(this.nextFreeBlockId * 2 + 1);
        }
        return this.nextFreeBlockId;
    }

    private int addBlockToChain(int n, int n2) {
        if (n2 >= this.nextFreeBlockId) {
            this.nextFreeBlockId = n2 + 1;
        }
        this.setPredecessorId(n2, n);
        return n2;
    }

    public boolean hasPredecessor(int n) {
        return this.getPredecessorId(n) != -1;
    }

    public synchronized int getPredecessorId(int n) {
        return this.array[(n + 1) * this.blockSize - 1];
    }

    private void setPredecessorId(int n, int n2) {
        this.array[(n + 1) * this.blockSize - 1] = n2;
        ++this.modifications;
    }

    public synchronized void setValueAt(int n, int n2, int n3) {
        this.checkBlockId(n);
        this.checkIndex(n2);
        this.array[n * this.blockSize + n2] = n3;
        ++this.modifications;
    }

    private void checkIndex(int n) {
        if (n < 0 || n > this.blockSize - 2) {
            throw new IndexOutOfBoundsException(new StringBuffer().append("idx=").append(n).append(", but tupleSize=").append(this.blockSize - 1).toString());
        }
    }

    void checkBlockId(int n) {
        if ((n < 0 || n >= this.nextFreeBlockId) && n != -1) {
            throw new IllegalStateException(new StringBuffer().append("Illegal block ID: ").append(n).toString());
        }
    }

    public synchronized int getValueAt(int n, int n2) {
        this.checkBlockId(n);
        this.checkIndex(n2);
        return this.array[n * this.blockSize + n2];
    }

    public int chainLength(int n) {
        int n2 = 0;
        int n3 = n;
        while (n3 != -1) {
            ++n2;
            n3 = this.getPredecessorId(n3);
        }
        return n2;
    }

    public synchronized int addValue1(int n, int n2) {
        this.checkBlockId(n);
        this.checkTupleSize(1);
        int n3 = this.getNewBlock(n);
        int n4 = n3 * this.blockSize;
        this.array[n4] = n2;
        return n3;
    }

    public synchronized int addValue1NoDuplicates(int n, int n2) {
        this.checkBlockId(n);
        this.checkTupleSize(1);
        if (!this.containsValue1(n, n2)) {
            return this.addBlockToChain(n, this.getBufferId());
        }
        return n;
    }

    public synchronized boolean containsValue1(int n, int n2) {
        this.checkBlockId(n);
        this.checkTupleSizeAtLeast(1);
        int n3 = this.getBufferId();
        int n4 = n3 * this.blockSize;
        this.array[n4] = n2;
        return this.findSuccessorOf(n, n3, 1) != -2;
    }

    public synchronized int removeAllValues1(int n, int n2) {
        this.checkBlockId(n);
        this.checkTupleSizeAtLeast(1);
        int n3 = this.getBufferId();
        int n4 = n3 * this.blockSize;
        this.array[n4] = n2;
        int n5 = n;
        int n6 = this.findSuccessorOf(n, n3, 1);
        while (n6 != -2) {
            n5 = this.removeBlock(n, n6);
            n6 = this.findSuccessorOf(n5, n3, 1);
        }
        return n5;
    }

    public synchronized int addValue2(int n, int n2, int n3) {
        this.checkBlockId(n);
        this.checkTupleSize(2);
        int n4 = this.getNewBlock(n);
        int n5 = n4 * this.blockSize;
        this.array[n5] = n2;
        this.array[n5 + 1] = n3;
        return n4;
    }

    public synchronized int addValue2NoDuplicates(int n, int n2, int n3) {
        this.checkBlockId(n);
        this.checkTupleSize(2);
        if (!this.containsValue2(n, n2, n3)) {
            return this.addBlockToChain(n, this.getBufferId());
        }
        return n;
    }

    public synchronized boolean containsValue2(int n, int n2, int n3) {
        this.checkBlockId(n);
        this.checkTupleSizeAtLeast(2);
        int n4 = this.getBufferId();
        int n5 = n4 * this.blockSize;
        this.array[n5] = n2;
        this.array[n5 + 1] = n3;
        return this.findSuccessorOf(n, n4, 2) != -2;
    }

    public synchronized int removeAllValues2(int n, int n2, int n3) {
        this.checkBlockId(n);
        this.checkTupleSizeAtLeast(2);
        int n4 = this.getBufferId();
        int n5 = n4 * this.blockSize;
        this.array[n5] = n2;
        this.array[n5 + 1] = n3;
        int n6 = n;
        int n7 = this.findSuccessorOf(n, n4, 2);
        while (n7 != -2) {
            n6 = this.removeBlock(n, n7);
            n7 = this.findSuccessorOf(n6, n4, 2);
        }
        return n6;
    }

    public synchronized int addValue3(int n, int n2, int n3, int n4) {
        this.checkBlockId(n);
        this.checkTupleSize(3);
        int n5 = this.getNewBlock(n);
        int n6 = n5 * this.blockSize;
        this.array[n6] = n2;
        this.array[n6 + 1] = n3;
        this.array[n6 + 2] = n4;
        return n5;
    }

    public synchronized int addValue3NoDuplicates(int n, int n2, int n3, int n4) {
        this.checkBlockId(n);
        this.checkTupleSize(3);
        if (!this.containsValue3(n, n2, n3, n4)) {
            return this.addBlockToChain(n, this.getBufferId());
        }
        return n;
    }

    public synchronized boolean containsValue3(int n, int n2, int n3, int n4) {
        this.checkBlockId(n);
        this.checkTupleSizeAtLeast(3);
        int n5 = this.getBufferId();
        int n6 = n5 * this.blockSize;
        this.array[n6] = n2;
        this.array[n6 + 1] = n3;
        this.array[n6 + 2] = n4;
        return this.findSuccessorOf(n, n5, 3) != -2;
    }

    public synchronized int removeAllValues3(int n, int n2, int n3, int n4) {
        this.checkBlockId(n);
        this.checkTupleSizeAtLeast(3);
        int n5 = this.getBufferId();
        int n6 = n5 * this.blockSize;
        this.array[n6] = n2;
        this.array[n6 + 1] = n3;
        this.array[n6 + 2] = n4;
        int n7 = n;
        int n8 = this.findSuccessorOf(n, n5, 3);
        while (n8 != -2) {
            n7 = this.removeBlock(n, n8);
            n8 = this.findSuccessorOf(n7, n5, 3);
        }
        return n7;
    }

    public synchronized int addValue4(int n, int n2, int n3, int n4, int n5) {
        this.checkBlockId(n);
        this.checkTupleSize(4);
        int n6 = this.getNewBlock(n);
        int n7 = n6 * this.blockSize;
        this.array[n7] = n2;
        this.array[n7 + 1] = n3;
        this.array[n7 + 2] = n4;
        this.array[n7 + 3] = n5;
        return n6;
    }

    public synchronized int addValue4NoDuplicates(int n, int n2, int n3, int n4, int n5) {
        this.checkBlockId(n);
        this.checkTupleSize(4);
        if (!this.containsValue4(n, n2, n3, n4, n5)) {
            return this.addBlockToChain(n, this.getBufferId());
        }
        return n;
    }

    public synchronized boolean containsValue4(int n, int n2, int n3, int n4, int n5) {
        this.checkBlockId(n);
        this.checkTupleSizeAtLeast(4);
        int n6 = this.getBufferId();
        int n7 = n6 * this.blockSize;
        this.array[n7] = n2;
        this.array[n7 + 1] = n3;
        this.array[n7 + 2] = n4;
        this.array[n7 + 3] = n5;
        return this.findSuccessorOf(n, n6, 4) != -2;
    }

    public synchronized int removeAllValues4(int n, int n2, int n3, int n4, int n5) {
        this.checkBlockId(n);
        this.checkTupleSizeAtLeast(4);
        int n6 = this.getBufferId();
        int n7 = n6 * this.blockSize;
        this.array[n7] = n2;
        this.array[n7 + 1] = n3;
        this.array[n7 + 2] = n4;
        this.array[n7 + 3] = n5;
        int n8 = n;
        int n9 = this.findSuccessorOf(n, n6, 4);
        while (n9 != -2) {
            n8 = this.removeBlock(n, n9);
            n9 = this.findSuccessorOf(n8, n6, 4);
        }
        return n8;
    }

    private int findSuccessorOf(int n, int n2, int n3) {
        int n4 = n;
        int n5 = -1;
        while (n4 != -1) {
            if (this.tuplesEquals(n4, n2, n3)) {
                return n5;
            }
            n5 = n4;
            n4 = this.getPredecessorId(n5);
        }
        return -2;
    }

    synchronized int removeBlock(int n, int n2) {
        if (n2 == -1) {
            if (this.nextFreeBlockId - 1 == n) {
                this.nextFreeBlockId = n;
            }
            ++this.modifications;
            return this.getPredecessorId(n);
        }
        int n3 = this.getPredecessorId(n2);
        int n4 = this.getPredecessorId(n3);
        this.setPredecessorId(n2, n4);
        ++this.modifications;
        return n;
    }

    private boolean tuplesEquals(int n, int n2, int n3) {
        int n4 = n * this.blockSize;
        int n5 = n2 * this.blockSize;
        for (int i2 = n3 - 1; i2 >= 0; --i2) {
            if (this.array[n4 + i2] == this.array[n5 + i2]) continue;
            return false;
        }
        return true;
    }

    private void checkTupleSize(int n) {
        if (this.blockSize != n + 1) {
            throw new UnsupportedOperationException(new StringBuffer().append("tupleSize=").append(this.blockSize - 1).append(" != ").append(n).toString());
        }
    }

    private void checkTupleSizeAtLeast(int n) {
        if (this.blockSize < n) {
            throw new UnsupportedOperationException(new StringBuffer().append("tupleSize=").append(this.blockSize - 1).append(" < ").append(n).toString());
        }
    }

    public MultiIntegerTupleList$Iterator iterator(int n) {
        return new MultiIntegerTupleList$Iterator(this, n);
    }

    synchronized int getModifications() {
        return this.modifications;
    }

    static {
        EMPTY_ARRAY = new int[0];
    }
}

