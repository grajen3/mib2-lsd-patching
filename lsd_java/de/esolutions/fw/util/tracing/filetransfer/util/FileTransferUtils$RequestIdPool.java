/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.filetransfer.util;

import java.util.HashMap;

public class FileTransferUtils$RequestIdPool {
    private final HashMap requestMap = new HashMap();
    private static final int usedId;

    public int getId(byte by) {
        int n = 0;
        while (this.isIdInUse(++n)) {
        }
        this.requestMap.put(new Integer(n), new Byte(by));
        return n;
    }

    public byte getOperation(int n) {
        byte by = -1;
        if (this.isIdInUse(n)) {
            by = (Byte)this.requestMap.get(new Integer(n));
        }
        return by;
    }

    public boolean isIdInUse(int n) {
        return this.requestMap.containsKey(new Integer(n));
    }

    public void releaseId(int n) {
        if (this.requestMap.containsKey(new Integer(n))) {
            this.requestMap.remove(new Integer(n));
        }
    }
}

