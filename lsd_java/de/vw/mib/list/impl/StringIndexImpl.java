/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.list.impl;

import de.vw.mib.list.StringIndex;
import de.vw.mib.pool.PoorMansPool;

class StringIndexImpl
implements StringIndex {
    private static final int MAX_POOL_SIZE;
    private static final PoorMansPool POOL;
    static final StringIndexImpl NOT_USED;
    static final StringIndexImpl INVALID;
    private int[] rowIndexes;
    private String[] stringIndexes;

    private StringIndexImpl() {
    }

    static StringIndexImpl borrow(int[] nArray, String[] stringArray) {
        StringIndexImpl stringIndexImpl;
        if (null == nArray || null == stringArray || nArray.length != stringArray.length) {
            stringIndexImpl = INVALID;
        } else {
            stringIndexImpl = (StringIndexImpl)POOL.borrow();
            if (null == stringIndexImpl) {
                stringIndexImpl = new StringIndexImpl();
            }
            stringIndexImpl.rowIndexes = nArray;
            stringIndexImpl.stringIndexes = stringArray;
        }
        return stringIndexImpl;
    }

    private static void release(StringIndexImpl stringIndexImpl) {
        stringIndexImpl.rowIndexes = null;
        stringIndexImpl.stringIndexes = null;
        POOL.release(stringIndexImpl);
    }

    @Override
    public int[] getRowIndexes() {
        return this.rowIndexes;
    }

    @Override
    public String[] getStringIndexes() {
        return this.stringIndexes;
    }

    @Override
    public int getStatus() {
        int n = this == NOT_USED ? 0 : (this == INVALID ? 1 : 2);
        return n;
    }

    void release() {
        if (this != INVALID && this != NOT_USED) {
            StringIndexImpl.release(this);
        }
    }

    public String toString() {
        switch (this.getStatus()) {
            case 1: {
                return "INVALID";
            }
            case 0: {
                return "NOT_USED";
            }
        }
        int[] nArray = this.rowIndexes;
        String[] stringArray = this.stringIndexes;
        if (null == nArray || null == stringArray) {
            return "INVALID";
        }
        int n = nArray.length;
        StringBuffer stringBuffer = new StringBuffer(15 + 10 * n);
        stringBuffer.append("READY[len=").append(n);
        for (int i2 = 0; i2 < n; ++i2) {
            stringBuffer.append(", \"").append(stringArray[i2]).append("\"=").append(nArray[i2]);
        }
        stringBuffer.append(']');
        return stringBuffer.toString();
    }

    static {
        POOL = new PoorMansPool("HMIList.StringIndex", 3);
        NOT_USED = new StringIndexImpl();
        INVALID = new StringIndexImpl();
    }
}

