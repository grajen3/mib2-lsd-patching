/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.comm;

import de.esolutions.fw.comm.core.IMethod;
import de.esolutions.fw.comm.core.IService;
import de.esolutions.fw.dsi.comm.DSIServiceWorker$ServiceJob;
import de.esolutions.fw.dsi.comm.IDSIServiceWorker;
import de.esolutions.fw.dsi.tracing.Channels;
import de.esolutions.fw.dsi.tracing.JobLogger;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import de.esolutions.fw.util.commons.job.IDispatcherManager;

public class DSIServiceWorker
implements IDSIServiceWorker {
    private DispatcherBase jobDispatcher;
    private final IDispatcherManager jobDispatcherManager;
    private final String name;
    private int useCount = 0;
    private Object jobDispatcherLock = new Object();
    private static final JobLogger jobLogger = new JobLogger();

    public DSIServiceWorker(String string, IDispatcherManager iDispatcherManager) {
        this.name = string;
        this.jobDispatcherManager = iDispatcherManager;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void start() {
        int n = 0;
        Object object = this;
        synchronized (object) {
            n = ++this.useCount;
        }
        if (n == 1) {
            object = this.jobDispatcherLock;
            synchronized (object) {
                Channels.DSI_ADMIN.log((short)1, "creating dispatcher \"%1\"", (Object)this.name);
                this.jobDispatcher = this.jobDispatcherManager.createDispatcher(this.name, jobLogger);
                Channels.DSI_ADMIN.log((short)2, "starting service worker \"%1\" with dispatcher \"%2\"", (Object)this.name, (Object)this.jobDispatcher.getName());
                this.jobDispatcher.start();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void stop() {
        int n = 0;
        Object object = this;
        synchronized (object) {
            --this.useCount;
            if (this.useCount < 0) {
                this.useCount = 0;
            }
            n = this.useCount;
        }
        if (n == 0) {
            object = this.jobDispatcherLock;
            synchronized (object) {
                if (this.jobDispatcher != null) {
                    Channels.DSI_ADMIN.log((short)1, "Stopping ServiceWorker \"%1\"", (Object)this.name);
                    this.jobDispatcher.stop();
                    this.jobDispatcherManager.destroyDispatcher(this.name);
                    this.jobDispatcher = null;
                }
            }
        }
    }

    @Override
    public synchronized int getUseCount() {
        return this.useCount;
    }

    @Override
    public String getName() {
        return this.name;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void enqueueCall(IMethod iMethod) {
        Channels.SERVICEWORKER.log((short)0, "-> Enqueing method call job to job dispatcher: name=%1, method=%2", (Object)this.name, (Object)iMethod);
        Object object = this.jobDispatcherLock;
        synchronized (object) {
            if (this.jobDispatcher != null) {
                this.jobDispatcher.execute(new DSIServiceWorker$ServiceJob(iMethod));
            }
        }
        Channels.SERVICEWORKER.log((short)0, "<- Done enqueing method call job to job dispatcher: name=%1, method=%2", (Object)this.name, (Object)iMethod);
    }

    @Override
    public void registerService(IService iService) {
    }

    @Override
    public void stubCountChanged(IService iService, int n) {
    }

    @Override
    public void unregisterService(IService iService) {
    }

    public String toString() {
        return new StringBuffer().append("ServiceWorker [name=").append(this.name).append("]").toString();
    }
}

