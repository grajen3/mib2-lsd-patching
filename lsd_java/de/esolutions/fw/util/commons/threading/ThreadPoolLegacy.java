/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons.threading;

import de.esolutions.fw.util.commons.threading.ObjectQueue;
import de.esolutions.fw.util.commons.threading.ThreadPoolWorker;
import java.util.HashMap;
import java.util.Map;

public class ThreadPoolLegacy {
    private String name;
    private ObjectQueue idleWorkers;
    private Map busyWorkers;
    private ThreadPoolWorker[] workerList;

    public ThreadPoolLegacy(String string, int n) {
        this.name = string;
        n = Math.max(1, n);
        this.idleWorkers = new ObjectQueue(n);
        this.busyWorkers = new HashMap(n);
        this.workerList = new ThreadPoolWorker[n];
        for (int i2 = 0; i2 < this.workerList.length; ++i2) {
            this.workerList[i2] = new ThreadPoolWorker(string, this.idleWorkers, this.busyWorkers);
        }
    }

    public String getName() {
        return this.name;
    }

    public void execute(Runnable runnable) {
        ThreadPoolWorker threadPoolWorker = (ThreadPoolWorker)this.idleWorkers.remove();
        threadPoolWorker.process(runnable);
    }

    public void execute(Runnable runnable, Object object) {
        ThreadPoolWorker threadPoolWorker = (ThreadPoolWorker)this.busyWorkers.get(object);
        if (threadPoolWorker != null) {
            threadPoolWorker.process(runnable);
        } else {
            threadPoolWorker = (ThreadPoolWorker)this.idleWorkers.remove();
            this.busyWorkers.put(object, threadPoolWorker);
            threadPoolWorker.process(runnable);
        }
    }

    public void stopRequestIdleWorkers() {
        try {
            Object[] objectArray = this.idleWorkers.removeAll();
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                ((ThreadPoolWorker)objectArray[i2]).stopRequest();
            }
        }
        catch (InterruptedException interruptedException) {
            Thread.currentThread().interrupt();
        }
    }

    public void stopRequestAllWorkers() {
        this.stopRequestIdleWorkers();
        try {
            Thread.sleep(0);
        }
        catch (InterruptedException interruptedException) {
            // empty catch block
        }
        for (int i2 = 0; i2 < this.workerList.length; ++i2) {
            if (!this.workerList[i2].isAlive()) continue;
            this.workerList[i2].stopRequest();
        }
    }
}

