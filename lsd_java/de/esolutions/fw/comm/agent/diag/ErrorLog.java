/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.diag;

import de.esolutions.fw.comm.agent.diag.IInfoBase;
import java.util.ArrayList;

public class ErrorLog {
    private final int maxSize;
    private final ArrayList entries;
    private int numDropped;

    public ErrorLog(int n) {
        this.maxSize = n;
        this.entries = new ArrayList();
    }

    public synchronized void clear() {
        this.entries.clear();
        this.numDropped = 0;
    }

    public synchronized void add(IInfoBase iInfoBase) {
        this.entries.add(iInfoBase);
        while (this.entries.size() > this.maxSize) {
            this.entries.remove(0);
            ++this.numDropped;
        }
    }

    public synchronized int getNumDropped() {
        return this.numDropped;
    }

    public synchronized IInfoBase[] getAllEntries() {
        if (this.entries.isEmpty()) {
            return null;
        }
        Object[] objectArray = new IInfoBase[this.entries.size()];
        this.entries.toArray(objectArray);
        return objectArray;
    }
}

