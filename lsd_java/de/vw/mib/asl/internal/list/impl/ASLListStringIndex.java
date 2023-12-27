/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.list.impl;

import de.vw.mib.list.StringIndex;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Loggable;
import de.vw.mib.pool.PoorMansPool;

final class ASLListStringIndex
implements StringIndex,
Loggable {
    private static final int MAX_POOL_SIZE;
    private static final PoorMansPool POOL;
    static final ASLListStringIndex NOT_USED;
    static final ASLListStringIndex INVALID;
    private int[] rowIndexes;
    private String[] stringIndexes;

    private ASLListStringIndex() {
    }

    static ASLListStringIndex borrow(int[] nArray, String[] stringArray) {
        ASLListStringIndex aSLListStringIndex;
        if (null == nArray || null == stringArray || nArray.length != stringArray.length) {
            aSLListStringIndex = INVALID;
        } else {
            aSLListStringIndex = (ASLListStringIndex)POOL.borrow();
            if (null == aSLListStringIndex) {
                aSLListStringIndex = new ASLListStringIndex();
            }
            aSLListStringIndex.rowIndexes = nArray;
            aSLListStringIndex.stringIndexes = stringArray;
        }
        return aSLListStringIndex;
    }

    private static void release(ASLListStringIndex aSLListStringIndex) {
        aSLListStringIndex.rowIndexes = null;
        aSLListStringIndex.stringIndexes = null;
        POOL.release(aSLListStringIndex);
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
            ASLListStringIndex.release(this);
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

    @Override
    public void toString(LogMessage logMessage) {
        logMessage.append(this.toString());
    }

    static {
        POOL = new PoorMansPool("ASLListStringIndex", 3);
        NOT_USED = new ASLListStringIndex();
        INVALID = new ASLListStringIndex();
    }
}

