/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.genericevents.impl;

import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventException;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.TaskInterface;
import de.vw.mib.genericevents.impl.EventDispatcherImpl;
import de.vw.mib.genericevents.internal.ServiceManager;
import de.vw.mib.log4mib.Logger;
import edu.emory.mathcs.backport.java.util.concurrent.BlockingQueue;
import edu.emory.mathcs.backport.java.util.concurrent.LinkedBlockingQueue;

final class Task
implements Runnable,
TaskInterface {
    private static Logger logger = ServiceManager.loggerFactory.getLogger(128);
    private final GenericEvents eventContext;
    private final BlockingQueue messageQueue = new LinkedBlockingQueue();
    private boolean running = false;
    private boolean stop = true;
    private final String taskId;
    private Thread thread = null;
    private final int threadPriority;

    Task(GenericEvents genericEvents, String string, int n) {
        this.eventContext = genericEvents;
        this.taskId = string;
        this.threadPriority = n;
    }

    @Override
    public void dispatch(EventGeneric eventGeneric) {
        this.messageQueue.offer(eventGeneric);
    }

    @Override
    public String getId() {
        return this.taskId;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int getQueueSize() {
        BlockingQueue blockingQueue = this.messageQueue;
        synchronized (blockingQueue) {
            return this.messageQueue.size();
        }
    }

    public Thread getThread() {
        return this.thread;
    }

    @Override
    public boolean isInCurrentMIBThread() {
        return Thread.currentThread().equals(this.thread);
    }

    @Override
    public boolean isQueueOverloaded() {
        return false;
    }

    @Override
    public void run() {
        while (!this.stop) {
            try {
                EventGeneric eventGeneric = (EventGeneric)this.messageQueue.take();
                if (this.stop) continue;
                if (this.messageQueue.size() > 100 && logger.isTraceEnabled(16)) {
                    logger.trace(16).append("Task=").append(this.taskId).append(", QueueSize=").append(this.messageQueue.size()).log();
                }
                try {
                    ((EventDispatcherImpl)this.eventContext.getEventDispatcher()).dispatch(eventGeneric, (byte)0);
                    this.eventContext.getEventDispatcher().sendBack(eventGeneric);
                }
                catch (GenericEventException genericEventException) {
                    logger.error(16).append("Uncaught exception in EventDispatcher.").attachThrowable(genericEventException).log();
                    this.sendBack(eventGeneric, genericEventException.getCode());
                }
                catch (Exception exception) {
                    logger.error(16).append("Uncaught exception in EventDispatcher.").attachThrowable(exception).log();
                    this.sendBack(eventGeneric, 3);
                }
            }
            catch (Throwable throwable) {
                logger.error(16).append("error in task ").append(this.taskId).attachThrowable(throwable);
            }
        }
        this.running = false;
    }

    @Override
    public void start() {
        if (this.running) {
            return;
        }
        this.running = true;
        this.stop = false;
        this.thread = new Thread(this, new StringBuffer().append("GenericEventTask_").append(this.taskId).toString());
        this.thread.start();
        this.thread.setPriority(this.threadPriority);
        this.eventContext.getEventDispatcher().registerTask(this.taskId, this);
    }

    @Override
    public void stop() {
        this.eventContext.getEventDispatcher().unregisterTask(this.taskId);
        this.stop = true;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(70);
        stringBuffer.append("Task ");
        stringBuffer.append(this.taskId);
        if (this.stop) {
            stringBuffer.append(" [priority=");
        }
        stringBuffer.append(this.threadPriority);
        stringBuffer.append("][queue=");
        stringBuffer.append(this.messageQueue.size());
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    private void sendBack(EventGeneric eventGeneric, int n) {
        eventGeneric.setResult(n);
        try {
            this.eventContext.getEventDispatcher().sendBack(eventGeneric);
        }
        catch (GenericEventException genericEventException) {
            // empty catch block
        }
    }
}

