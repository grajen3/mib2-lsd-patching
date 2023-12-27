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

final class SynchronousTask
implements TaskInterface {
    private static Logger logger = ServiceManager.loggerFactory.getLogger(128);
    private final GenericEvents eventContext;
    private final boolean forwardExceptions;
    private final String taskId;

    SynchronousTask(GenericEvents genericEvents, String string, boolean bl) {
        this.eventContext = genericEvents;
        this.taskId = string;
        this.forwardExceptions = bl;
    }

    @Override
    public synchronized void dispatch(EventGeneric eventGeneric) {
        try {
            ((EventDispatcherImpl)this.eventContext.getEventDispatcher()).dispatch(eventGeneric, (byte)0);
            this.eventContext.getEventDispatcher().sendBack(eventGeneric);
        }
        catch (Exception exception) {
            if (this.forwardExceptions) {
                throw new RuntimeException(exception);
            }
            logger.error(1).attachThrowable(exception).log();
            this.sendBack(eventGeneric, 3);
        }
    }

    @Override
    public String getId() {
        return this.taskId;
    }

    @Override
    public int getQueueSize() {
        return 0;
    }

    public Thread getThread() {
        return Thread.currentThread();
    }

    @Override
    public boolean isInCurrentMIBThread() {
        return true;
    }

    @Override
    public boolean isQueueOverloaded() {
        return false;
    }

    @Override
    public void start() {
    }

    @Override
    public void stop() {
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

