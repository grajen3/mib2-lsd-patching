/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons.threading;

import de.esolutions.fw.util.commons.threading.ObjectQueue;
import de.esolutions.fw.util.commons.threading.ThreadPoolWorker$1;
import java.util.Map;

public class ThreadPoolWorker {
    private static int nextWorkerID = 0;
    private ObjectQueue idleWorkers;
    private Map busyWorkers;
    private int workerID;
    private ObjectQueue jobQueue;
    private Thread internalThread;
    private volatile boolean noStopRequested;

    public ThreadPoolWorker(String string, ObjectQueue objectQueue, Map map) {
        this.idleWorkers = objectQueue;
        this.busyWorkers = map;
        this.workerID = ThreadPoolWorker.getNextWorkerID();
        this.jobQueue = new ObjectQueue(10);
        this.noStopRequested = true;
        ThreadPoolWorker$1 threadPoolWorker$1 = new ThreadPoolWorker$1(this);
        this.internalThread = new Thread(threadPoolWorker$1, new StringBuffer().append("adapter:poolName[").append(string).append("]:threadID[").append(String.valueOf(this.workerID)).append("]").toString());
        this.internalThread.start();
    }

    private static synchronized int getNextWorkerID() {
        int n = nextWorkerID++;
        return n;
    }

    public void process(Runnable runnable) {
        this.jobQueue.add(runnable);
    }

    private void runWork() {
        while (this.noStopRequested) {
            try {
                if (this.jobQueue.isEmpty()) {
                    this.idleWorkers.add(this);
                    this.busyWorkers.values().remove(this);
                }
                Runnable runnable = (Runnable)this.jobQueue.remove();
                this.runJob(runnable);
            }
            catch (InterruptedException interruptedException) {
                Thread.currentThread().interrupt();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void runJob(Runnable runnable) {
        try {
            runnable.run();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        finally {
            Thread.interrupted();
        }
    }

    public void stopRequest() {
        this.noStopRequested = false;
        this.internalThread.interrupt();
    }

    public boolean isAlive() {
        return this.internalThread.isAlive();
    }

    static /* synthetic */ void access$000(ThreadPoolWorker threadPoolWorker) {
        threadPoolWorker.runWork();
    }
}

