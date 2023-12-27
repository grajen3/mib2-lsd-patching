/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.services.job;

import de.esolutions.fw.util.commons.job.DispatcherBase;
import de.esolutions.fw.util.commons.job.IDispatcherManager;
import de.esolutions.fw.util.commons.job.IInterceptor;
import de.esolutions.fw.util.commons.job.IJobLogger;
import de.esolutions.fw.util.commons.job.Job;
import de.esolutions.fw.util.commons.job.JobQueue;
import de.esolutions.fw.util.commons.timeout.ITimeSource;
import de.esolutions.fw.util.config.ConfigValue;
import de.esolutions.fw.util.services.job.DispatcherConfig;
import de.esolutions.fw.util.services.threading.ThreadPoolManager;
import java.util.Hashtable;
import java.util.Map;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public final class DispatcherManager
implements IDispatcherManager {
    private final ConfigValue config;
    private final ITimeSource timeSource;
    private final ThreadPoolManager threadPoolMngr;
    private final BundleContext bc;
    private final Map dispatchers = new Hashtable();
    private final Map sregs = new Hashtable();
    static /* synthetic */ Class class$de$esolutions$fw$util$commons$error$DumpInfoProvider;

    private void addDispatcher(DispatcherBase dispatcherBase, boolean bl) {
        this.destroyDispatcher(dispatcherBase.getName());
        if (bl) {
            this.registerDumpInfoProvider(dispatcherBase);
        }
        this.dispatchers.put(dispatcherBase.getName(), dispatcherBase);
    }

    public DispatcherManager(ConfigValue configValue, ITimeSource iTimeSource, ThreadPoolManager threadPoolManager, BundleContext bundleContext) {
        this.config = configValue;
        this.timeSource = iTimeSource;
        this.threadPoolMngr = threadPoolManager;
        this.bc = bundleContext;
    }

    @Override
    public ITimeSource getTimeSource() {
        return this.timeSource;
    }

    @Override
    public DispatcherBase createDispatcher(String string, IJobLogger iJobLogger) {
        DispatcherConfig dispatcherConfig = DispatcherConfig.createConfig(this.config, string);
        DispatcherBase dispatcherBase = dispatcherConfig.createDispatcher(string, this.timeSource, iJobLogger, this.threadPoolMngr);
        this.addDispatcher(dispatcherBase, dispatcherConfig.getDumpInfoProvider());
        return dispatcherBase;
    }

    @Override
    public DispatcherBase createDispatcher(String string, IJobLogger iJobLogger, JobQueue jobQueue) {
        DispatcherConfig dispatcherConfig = DispatcherConfig.createConfig(this.config, string);
        DispatcherBase dispatcherBase = dispatcherConfig.createDispatcher(string, this.timeSource, iJobLogger, jobQueue, this.threadPoolMngr);
        this.addDispatcher(dispatcherBase, dispatcherConfig.getDumpInfoProvider());
        return dispatcherBase;
    }

    @Override
    public DispatcherBase createDispatcher(String string, IJobLogger iJobLogger, JobQueue jobQueue, IInterceptor iInterceptor, Job job) {
        DispatcherConfig dispatcherConfig = DispatcherConfig.createConfig(this.config, string);
        DispatcherBase dispatcherBase = dispatcherConfig.createDispatcher(string, this.timeSource, iJobLogger, jobQueue, iInterceptor, job, this.threadPoolMngr);
        this.addDispatcher(dispatcherBase, dispatcherConfig.getDumpInfoProvider());
        return dispatcherBase;
    }

    @Override
    public void destroyDispatcher(String string) {
        DispatcherBase dispatcherBase = (DispatcherBase)this.dispatchers.remove(string);
        if (dispatcherBase != null) {
            dispatcherBase.stop();
        }
        this.unregisterDumpInfoProvider(string);
    }

    private void registerDumpInfoProvider(DispatcherBase dispatcherBase) {
        this.sregs.put(dispatcherBase.getName(), this.bc.registerService((class$de$esolutions$fw$util$commons$error$DumpInfoProvider == null ? (class$de$esolutions$fw$util$commons$error$DumpInfoProvider = DispatcherManager.class$("de.esolutions.fw.util.commons.error.DumpInfoProvider")) : class$de$esolutions$fw$util$commons$error$DumpInfoProvider).getName(), (Object)dispatcherBase, null));
    }

    private void unregisterDumpInfoProvider(String string) {
        ServiceRegistration serviceRegistration = (ServiceRegistration)this.sregs.remove(string);
        if (serviceRegistration != null) {
            serviceRegistration.unregister();
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

