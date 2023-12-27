/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.osgi;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.agent.config.CommConfig;
import de.esolutions.fw.comm.agent.config.CommConfigDoctor;
import de.esolutions.fw.comm.agent.doctor.SocketDoctorShellServer;
import de.esolutions.fw.comm.agent.osgi.AgentCallbacks;
import de.esolutions.fw.comm.agent.osgi.AgentDumpInfoProvider;
import de.esolutions.fw.comm.agent.osgi.AgentServiceInstanceListenerTracker;
import de.esolutions.fw.comm.agent.osgi.AgentServiceListenerTracker;
import de.esolutions.fw.comm.agent.osgi.AgentServiceTracker;
import de.esolutions.fw.comm.core.ILifecycleListener;
import de.esolutions.fw.comm.core.Lifecycle;
import de.esolutions.fw.util.commons.error.IFatalErrorHandler;
import de.esolutions.fw.util.tracing.TraceChannel;
import de.esolutions.fw.util.tracing.TraceClient;
import java.util.Dictionary;
import java.util.Properties;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

public class AgentActivator
implements BundleActivator,
ILifecycleListener {
    protected static final TraceChannel trace = TraceClient.createTraceChannel("comm.agent.osgi.Activator");
    protected ServiceRegistration agentServiceReg;
    protected BundleContext bundleContext;
    private AgentCallbacks callbacks;
    private ServiceRegistration dipServiceReg;
    private SocketDoctorShellServer doctorShellServer;
    private ServiceReference fatalErrorHandlerService;
    private IFatalErrorHandler fatalErrorHandler;
    private AgentServiceTracker agentServiceTracker;
    private AgentServiceListenerTracker agentServiceListenerTracker;
    private AgentServiceInstanceListenerTracker agentServiceInstanceListenerTracker;
    static /* synthetic */ Class class$de$esolutions$fw$util$commons$error$IFatalErrorHandler;
    static /* synthetic */ Class class$de$esolutions$fw$util$commons$error$DumpInfoProvider;
    static /* synthetic */ Class class$de$esolutions$fw$comm$agent$Agent;

    @Override
    public void start(BundleContext bundleContext) {
        Object object;
        this.bundleContext = bundleContext;
        TraceClient.init("hmi");
        trace.log((short)2, "+ start comm Agent bundle");
        this.fatalErrorHandlerService = bundleContext.getServiceReference((class$de$esolutions$fw$util$commons$error$IFatalErrorHandler == null ? (class$de$esolutions$fw$util$commons$error$IFatalErrorHandler = AgentActivator.class$("de.esolutions.fw.util.commons.error.IFatalErrorHandler")) : class$de$esolutions$fw$util$commons$error$IFatalErrorHandler).getName());
        if (this.fatalErrorHandlerService != null) {
            object = bundleContext.getService(this.fatalErrorHandlerService);
            if (object instanceof IFatalErrorHandler) {
                this.fatalErrorHandler = (IFatalErrorHandler)object;
                Agent.setFatalErrorHandler(this.fatalErrorHandler);
                trace.log((short)2, "fatal errror handler: got registered service: %1", this.fatalErrorHandler);
            } else {
                trace.log((short)4, "fatal error handler: no IFatalErrorHandler: %1", object);
            }
        } else {
            trace.log((short)3, "fatal error handler: not found in OSGi. using own default");
        }
        trace.log((short)0, "+ starting agent");
        Agent.start(this);
        trace.log((short)0, "- starting agent");
        object = Agent.getAgent();
        trace.log((short)0, "+ starting trackers");
        this.agentServiceInstanceListenerTracker = new AgentServiceInstanceListenerTracker((Agent)object, bundleContext);
        this.agentServiceInstanceListenerTracker.open();
        this.agentServiceListenerTracker = new AgentServiceListenerTracker((Agent)object, bundleContext);
        this.agentServiceListenerTracker.open();
        this.agentServiceTracker = new AgentServiceTracker((Agent)object, bundleContext);
        this.agentServiceTracker.open();
        trace.log((short)0, "- starting trackers");
        this.callbacks = new AgentCallbacks();
        this.callbacks.register();
        trace.log((short)0, "+ registering AgentDumpInfoProvider");
        AgentDumpInfoProvider agentDumpInfoProvider = new AgentDumpInfoProvider();
        Properties properties = new Properties();
        this.dipServiceReg = bundleContext.registerService((class$de$esolutions$fw$util$commons$error$DumpInfoProvider == null ? (class$de$esolutions$fw$util$commons$error$DumpInfoProvider = AgentActivator.class$("de.esolutions.fw.util.commons.error.DumpInfoProvider")) : class$de$esolutions$fw$util$commons$error$DumpInfoProvider).getName(), (Object)agentDumpInfoProvider, (Dictionary)properties);
        trace.log((short)0, "- registering AgentDumpInfoProvider");
        CommConfig commConfig = CommConfig.getInstance();
        CommConfigDoctor commConfigDoctor = null;
        if (commConfig != null) {
            commConfigDoctor = commConfig.getDoctorConfig();
        }
        if (commConfigDoctor != null && commConfigDoctor.isEnabled()) {
            trace.log((short)0, "+ start AgentDoctor");
            this.doctorShellServer = new SocketDoctorShellServer();
            this.doctorShellServer.setup(commConfigDoctor.getHost(), commConfigDoctor.getPort());
            this.doctorShellServer.start();
            trace.log((short)0, "- start AgentDoctor");
        }
        trace.log((short)2, "- start comm Agent bundle");
    }

    @Override
    public void stop(BundleContext bundleContext) {
        trace.log((short)2, "+ stop comm Agent bundle");
        this.callbacks.unregister();
        this.callbacks = null;
        if (this.doctorShellServer != null) {
            trace.log((short)0, "+ stop AgentDoctor");
            this.doctorShellServer.stop();
            this.doctorShellServer = null;
            trace.log((short)0, "- stop AgentDoctor");
        }
        trace.log((short)0, "+ stopping trackers");
        if (this.agentServiceTracker != null) {
            this.agentServiceTracker.close();
            this.agentServiceTracker = null;
        }
        if (this.agentServiceListenerTracker != null) {
            this.agentServiceListenerTracker.close();
            this.agentServiceListenerTracker = null;
        }
        if (this.agentServiceInstanceListenerTracker != null) {
            this.agentServiceInstanceListenerTracker.close();
            this.agentServiceInstanceListenerTracker = null;
        }
        trace.log((short)0, "- stopping trackers");
        Agent agent = Agent.getAgent();
        if (agent != null) {
            trace.log((short)0, "+ stopping agent");
            Agent.stop();
            trace.log((short)0, "- stopping agent");
        }
        if (this.dipServiceReg != null) {
            trace.log((short)0, "+ unregistering AgentDumpInfoProvider");
            this.dipServiceReg.unregister();
            trace.log((short)0, "- unregistering AgentDumpInfoProvider");
        }
        if (this.fatalErrorHandler != null) {
            trace.log((short)2, "unget fatal error handler service");
            this.bundleContext.ungetService(this.fatalErrorHandlerService);
            this.fatalErrorHandler = null;
            this.fatalErrorHandlerService = null;
        }
        trace.log((short)2, "- stop comm Agent bundle");
        TraceClient.exit();
    }

    @Override
    public void lifecycleChanged(Lifecycle lifecycle, Object object) {
        if (lifecycle.isAlive()) {
            trace.log((short)2, "+ registering agent service");
            if (this.agentServiceReg == null) {
                Agent agent = Agent.getAgent();
                this.agentServiceReg = this.bundleContext.registerService((class$de$esolutions$fw$comm$agent$Agent == null ? (class$de$esolutions$fw$comm$agent$Agent = AgentActivator.class$("de.esolutions.fw.comm.agent.Agent")) : class$de$esolutions$fw$comm$agent$Agent).getName(), (Object)agent, null);
            }
            trace.log((short)2, "- registering agent service");
        } else if (lifecycle.isDead()) {
            trace.log((short)2, "+ unregistering agent service");
            if (this.agentServiceReg != null) {
                this.agentServiceReg.unregister();
                this.agentServiceReg = null;
            }
            trace.log((short)2, "- unregisterung agent service");
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

