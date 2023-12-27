/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.view.internal.treebuilder;

import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.pool.ObjectPool;
import de.vw.mib.pool.ObjectPoolMonitor;

public class DumpingPoolSizeMonitor
implements ObjectPoolMonitor {
    private final ObjectPool pool;
    private int minSize;
    private int maxSize;

    public DumpingPoolSizeMonitor(ObjectPool objectPool) {
        this.pool = objectPool;
        this.maxSize = 0;
        this.minSize = -129;
    }

    @Override
    public void init(int n) {
        this.minSize = n;
        this.maxSize = n;
    }

    @Override
    public void addObjectToPool() {
        if (this.pool.size() > this.maxSize) {
            this.maxSize = this.pool.size();
        }
    }

    @Override
    public void removeObjectFromPool() {
        if (this.pool.size() < this.minSize) {
            this.minSize = this.pool.size();
        }
    }

    @Override
    public void clearObjectPool() {
    }

    @Override
    public void createNewObject() {
    }

    @Override
    public void dropObject() {
    }

    public LogMessage appendDump(LogMessage logMessage) {
        logMessage.append(" minSize=").append(this.minSize);
        logMessage.append(" maxSize=").append(this.maxSize);
        logMessage.append(" poolSize=").append(this.pool.size());
        return logMessage;
    }
}

