/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.osgi;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.IService;
import de.esolutions.fw.comm.core.IServiceListener;
import de.esolutions.fw.util.tracing.TraceChannel;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class AgentServiceListenerTracker
implements ServiceTrackerCustomizer {
    public static final String ISERVICE_PROPERTY = (class$de$esolutions$fw$comm$core$IService == null ? (class$de$esolutions$fw$comm$core$IService = AgentServiceListenerTracker.class$("de.esolutions.fw.comm.core.IService")) : class$de$esolutions$fw$comm$core$IService).getName();
    private static final TraceChannel trace = new TraceChannel("comm.agent.osgi.ServiceListenerTracker");
    private final Agent agent;
    private final BundleContext bundleContext;
    private final ServiceTracker tracker;
    static /* synthetic */ Class class$de$esolutions$fw$comm$core$IService;
    static /* synthetic */ Class class$de$esolutions$fw$comm$core$IServiceListener;

    public AgentServiceListenerTracker(Agent agent, BundleContext bundleContext) {
        this.agent = agent;
        this.bundleContext = bundleContext;
        this.tracker = new ServiceTracker(bundleContext, (class$de$esolutions$fw$comm$core$IServiceListener == null ? (class$de$esolutions$fw$comm$core$IServiceListener = AgentServiceListenerTracker.class$("de.esolutions.fw.comm.core.IServiceListener")) : class$de$esolutions$fw$comm$core$IServiceListener).getName(), (ServiceTrackerCustomizer)this);
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
        if (object instanceof IServiceListener) {
            Object object2 = serviceReference.getProperty(ISERVICE_PROPERTY);
            if (object2 instanceof IService) {
                IService iService = (IService)object2;
                IServiceListener iServiceListener = (IServiceListener)object;
                trace.log((short)0, "+ registering IServiceListener for %1", iService.getInstanceID());
                try {
                    this.agent.registerServiceListener(iService, iServiceListener);
                }
                catch (Exception exception) {
                    trace.log((short)4, "Failed ServiceListener Registration: %1", exception);
                }
                trace.log((short)0, "- registering IServiceListener for %1", iService.getInstanceID());
            } else {
                trace.log((short)4, "can't register listener: No IService property found: %1", (Object)ISERVICE_PROPERTY);
            }
        }
        return object;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        this.bundleContext.ungetService(serviceReference);
        if (object instanceof IServiceListener) {
            Object object2 = serviceReference.getProperty(ISERVICE_PROPERTY);
            if (object2 instanceof IService) {
                IService iService = (IService)object2;
                IServiceListener iServiceListener = (IServiceListener)object;
                trace.log((short)0, "+ unregistering IServiceListener for %1", iService.getInstanceID());
                try {
                    this.agent.unregisterServiceListener(iService, iServiceListener);
                }
                catch (Exception exception) {
                    trace.log((short)4, "Failed ServiceListener Unregistration: %1", exception);
                }
                trace.log((short)0, "- unregistering IServiceListener for %1", iService.getInstanceID());
            } else {
                trace.log((short)4, "can't unregister listener: No IService property found: %1", (Object)ISERVICE_PROPERTY);
            }
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

