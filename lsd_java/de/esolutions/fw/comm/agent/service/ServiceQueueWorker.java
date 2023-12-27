/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.service;

import de.esolutions.fw.comm.agent.service.ServiceQueueWorker$ServiceTimeOutHandler;
import de.esolutions.fw.comm.agent.tracing.CommAgentTracing;
import de.esolutions.fw.comm.core.IMethod;
import de.esolutions.fw.comm.core.IService;
import de.esolutions.fw.comm.core.IServiceWorker;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.commons.error.IRunnableWrapper;
import de.esolutions.fw.util.commons.queue.QueueShutdownException;
import de.esolutions.fw.util.commons.queue.QueueWorker;
import de.esolutions.fw.util.commons.timeout.ITimeSource;
import de.esolutions.fw.util.commons.timeout.TimeOutTimer;
import de.esolutions.fw.util.commons.timeout.TimeOutTimer$TimeOutTask;

public class ServiceQueueWorker
extends QueueWorker
implements IServiceWorker {
    protected String name;
    protected boolean lazyStartup;
    protected int serviceCount;
    protected int maxMethodTime;
    protected TimeOutTimer timer;
    private int threadPrio;
    private final ITimeSource monoTime;

    public ServiceQueueWorker(String string, int n, int n2, boolean bl, int n3, ITimeSource iTimeSource, IRunnableWrapper iRunnableWrapper) {
        super(string, n, iRunnableWrapper);
        this.name = string;
        this.lazyStartup = bl;
        this.maxMethodTime = n2;
        this.threadPrio = n3;
        this.monoTime = iTimeSource;
    }

    @Override
    public synchronized void registerService(IService iService) {
        ++this.serviceCount;
        if (!this.lazyStartup && this.serviceCount == 1) {
            CommAgentTracing.SERVICE.log((short)1, "  starting service worker %1 (prio=%2)", (Object)this.name, (Object)new Integer(this.threadPrio));
            if (this.maxMethodTime > 0) {
                this.timer = new TimeOutTimer();
            }
            this.start(this.threadPrio);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void unregisterService(IService iService) {
        boolean bl = false;
        ServiceQueueWorker serviceQueueWorker = this;
        synchronized (serviceQueueWorker) {
            --this.serviceCount;
            if (this.serviceCount == 0) {
                if (this.maxMethodTime > 0) {
                    this.timer.cancel();
                    this.timer = null;
                }
                bl = true;
            }
        }
        if (bl) {
            CommAgentTracing.SERVICE.log((short)1, "  stopping service worker %1", (Object)this.name);
            this.stop();
        }
    }

    @Override
    public void stubCountChanged(IService iService, int n) {
    }

    @Override
    public synchronized void enqueueCall(IMethod iMethod) {
        if (this.lazyStartup && !this.isRunning()) {
            CommAgentTracing.SERVICE.log((short)1, "  lazy starting service worker %1 (prio=%2)", (Object)this.name, (Object)new Integer(this.threadPrio));
            this.start(this.threadPrio);
        }
        try {
            if (this.addToQueue(iMethod)) {
                CommAgentTracing.SERVICE.log((short)3, "  enqueueing method in high water range. queue size=%1", new Integer(this.queueSize()));
            }
        }
        catch (QueueShutdownException queueShutdownException) {
            CommAgentTracing.SERVICE.log((short)2, "  enqueueing method failed: %1", (Object)queueShutdownException.getMessage());
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    protected void handleQueuedObject(Object object) {
        IMethod iMethod = (IMethod)object;
        TimeOutTimer$TimeOutTask timeOutTimer$TimeOutTask = null;
        ServiceQueueWorker$ServiceTimeOutHandler serviceQueueWorker$ServiceTimeOutHandler = null;
        try {
            CommAgentTracing.SERVICE.log((short)1, "  + invoke %1 on worker %2", iMethod, (Object)this.name);
            ServiceQueueWorker serviceQueueWorker = this;
            synchronized (serviceQueueWorker) {
                if (this.timer != null) {
                    serviceQueueWorker$ServiceTimeOutHandler = new ServiceQueueWorker$ServiceTimeOutHandler(this, iMethod.toString());
                    timeOutTimer$TimeOutTask = this.timer.schedule(serviceQueueWorker$ServiceTimeOutHandler, this.maxMethodTime);
                }
            }
            long l = this.monoTime.getCurrentTime();
            iMethod.invoke();
            long l2 = this.monoTime.getCurrentTime();
            CommAgentTracing.SERVICE.log((short)1, "  - invoke %1 on worker %2: duration %3 ms", iMethod, (Object)this.name, (Object)new Long(l2 - l));
        }
        catch (MethodException methodException) {
            CommAgentTracing.SERVICE.log((short)4, "invocation of method %1 on worker %2 failed: %3", iMethod, (Object)this.name, (Object)methodException);
            this.methodExceptionHandler(methodException);
        }
        catch (Exception exception) {
            CommAgentTracing.SERVICE.log((short)4, "invocation of method %1 on worker %2 failed: %3", iMethod, (Object)this.name, (Object)exception);
            this.otherExceptionHandler(exception);
        }
        finally {
            if (timeOutTimer$TimeOutTask != null) {
                timeOutTimer$TimeOutTask.disarm();
                timeOutTimer$TimeOutTask = null;
            }
            if (serviceQueueWorker$ServiceTimeOutHandler != null) {
                serviceQueueWorker$ServiceTimeOutHandler.disarm();
                serviceQueueWorker$ServiceTimeOutHandler = null;
            }
        }
    }

    protected void methodExceptionHandler(MethodException methodException) {
    }

    protected void otherExceptionHandler(Exception exception) {
    }
}

