/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.osgi;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.IService;
import de.esolutions.fw.util.tracing.TraceChannel;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class AgentServiceTracker
implements ServiceTrackerCustomizer {
    private static final TraceChannel trace = new TraceChannel("comm.agent.osgi.ServiceTracker");
    private final Agent agent;
    private final BundleContext bundleContext;
    private final ServiceTracker tracker;
    static /* synthetic */ Class class$de$esolutions$fw$comm$core$IService;

    public AgentServiceTracker(Agent agent, BundleContext bundleContext) {
        this.agent = agent;
        this.bundleContext = bundleContext;
        this.tracker = new ServiceTracker(bundleContext, (class$de$esolutions$fw$comm$core$IService == null ? (class$de$esolutions$fw$comm$core$IService = AgentServiceTracker.class$("de.esolutions.fw.comm.core.IService")) : class$de$esolutions$fw$comm$core$IService).getName(), (ServiceTrackerCustomizer)this);
    }

    public void open() {
        this.tracker.open();
    }

    public void close() {
        this.tracker.close();
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = this.bundleContext.getService(serviceReference);
        if (object instanceof IService) {
            IService iService = (IService)object;
            trace.log((short)0, "+ registering IService %1", iService.getInstanceID());
            try {
                this.agent.registerService(iService);
            }
            catch (Exception exception) {
                trace.log((short)4, "Failed Service Registration for IService %1: %2", iService.getInstanceID(), (Object)exception);
            }
            trace.log((short)0, "- registering IService %1", iService.getInstanceID());
        }
        return object;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        this.bundleContext.ungetService(serviceReference);
        if (object instanceof IService) {
            IService iService = (IService)object;
            trace.log((short)0, "+ unregistering IService %1", iService.getInstanceID());
            try {
                this.agent.unregisterService(iService);
            }
            catch (Exception exception) {
                trace.log((short)4, "Failed Service Unregistration for IService %1: %2", iService.getInstanceID(), (Object)exception);
            }
            trace.log((short)0, "- unregistering IService %1", iService.getInstanceID());
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

