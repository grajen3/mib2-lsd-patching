/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.osgi;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.IServiceInstanceListener;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.util.tracing.TraceChannel;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class AgentServiceInstanceListenerTracker
implements ServiceTrackerCustomizer {
    public static final String SERVICE_INSTANCE_ID_PROPERTY = (class$de$esolutions$fw$comm$core$ServiceInstanceID == null ? (class$de$esolutions$fw$comm$core$ServiceInstanceID = AgentServiceInstanceListenerTracker.class$("de.esolutions.fw.comm.core.ServiceInstanceID")) : class$de$esolutions$fw$comm$core$ServiceInstanceID).getName();
    private static final TraceChannel trace = new TraceChannel("comm.agent.osgi.ServiceInstanceListenerTracker");
    private final Agent agent;
    private final BundleContext bundleContext;
    private final ServiceTracker tracker;
    static /* synthetic */ Class class$de$esolutions$fw$comm$core$ServiceInstanceID;
    static /* synthetic */ Class class$de$esolutions$fw$comm$core$IServiceInstanceListener;

    public AgentServiceInstanceListenerTracker(Agent agent, BundleContext bundleContext) {
        this.agent = agent;
        this.bundleContext = bundleContext;
        this.tracker = new ServiceTracker(bundleContext, (class$de$esolutions$fw$comm$core$IServiceInstanceListener == null ? (class$de$esolutions$fw$comm$core$IServiceInstanceListener = AgentServiceInstanceListenerTracker.class$("de.esolutions.fw.comm.core.IServiceInstanceListener")) : class$de$esolutions$fw$comm$core$IServiceInstanceListener).getName(), (ServiceTrackerCustomizer)this);
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
        if (object instanceof IServiceInstanceListener) {
            Object object2 = serviceReference.getProperty(SERVICE_INSTANCE_ID_PROPERTY);
            if (object2 instanceof ServiceInstanceID) {
                ServiceInstanceID serviceInstanceID = (ServiceInstanceID)object2;
                IServiceInstanceListener iServiceInstanceListener = (IServiceInstanceListener)object;
                trace.log((short)0, "+ registering IServiceInstanceListener for %1", serviceInstanceID);
                try {
                    this.agent.registerServiceInstanceListener(serviceInstanceID, iServiceInstanceListener);
                }
                catch (Exception exception) {
                    trace.log((short)4, "Failed ServiceInstanceListener Registration: %1", exception);
                }
                trace.log((short)0, "- registering IServiceInstanceListener for %1", serviceInstanceID);
            } else {
                trace.log((short)4, "can't register listener: No ServiceInstanceID property found: %1", (Object)SERVICE_INSTANCE_ID_PROPERTY);
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
        if (object instanceof IServiceInstanceListener) {
            Object object2 = serviceReference.getProperty(SERVICE_INSTANCE_ID_PROPERTY);
            if (object2 instanceof ServiceInstanceID) {
                ServiceInstanceID serviceInstanceID = (ServiceInstanceID)object2;
                IServiceInstanceListener iServiceInstanceListener = (IServiceInstanceListener)object;
                trace.log((short)0, "+ unregistering IServiceInstanceListener for %1", serviceInstanceID);
                try {
                    this.agent.unregisterServiceInstanceListener(serviceInstanceID, iServiceInstanceListener);
                }
                catch (Exception exception) {
                    trace.log((short)4, "Failed ServiceInstanceListener Unregistration: %1", exception);
                }
                trace.log((short)0, "- unregistering IServiceInstanceListener for %1", serviceInstanceID);
            } else {
                trace.log((short)4, "can't unregister listener: No IService property found: %1", (Object)SERVICE_INSTANCE_ID_PROPERTY);
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

