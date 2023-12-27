/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi;

import de.esolutions.fw.comm.agent.doctor.command.DoctorCommandRegistry;
import de.esolutions.fw.dsi.AdapterDumpInfoProvider;
import de.esolutions.fw.dsi.admin.DSIAdmin;
import de.esolutions.fw.dsi.admin.ListenerTracker;
import de.esolutions.fw.dsi.diag.doctor.DSIAdapterDispatcherErrorCommand;
import de.esolutions.fw.dsi.diag.doctor.DSIAdapterDispatcherInfoCommand;
import de.esolutions.fw.dsi.diag.doctor.DSIAdapterProviderErrorCommand;
import de.esolutions.fw.dsi.diag.doctor.DSIAdapterProviderInfoCommand;
import de.esolutions.fw.dsi.diag.doctor.DSIAdapterReportCommand;
import de.esolutions.fw.dsi.diag.doctor.DSIAdapterSnapshotCommand;
import de.esolutions.fw.dsi.tracing.Channels;
import de.esolutions.fw.util.commons.job.IDispatcherManager;
import de.esolutions.fw.util.tracing.TraceClient;
import java.util.Dictionary;
import java.util.Properties;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

public class AdapterActivator
implements BundleActivator {
    private static final String TRACECLIENT;
    public static BundleContext bundleContext;
    private DSIAdmin admin;
    private ServiceRegistration dumpInfoProviderServiceReg;
    private ServiceReference dispatcherManagerRef;
    private IDispatcherManager dispatcherManager;
    static /* synthetic */ Class class$de$esolutions$fw$util$commons$job$IDispatcherManager;
    static /* synthetic */ Class class$de$esolutions$fw$util$commons$error$DumpInfoProvider;

    @Override
    public void start(BundleContext bundleContext) {
        AdapterActivator.bundleContext = bundleContext;
        TraceClient.init("DSI Adapter");
        Channels.DSI_ADMIN.log((short)1, "-> Start DSI Adapter.");
        Channels.DSI_ADMIN.log((short)1, "Retrieving the IDispatcherManager.");
        try {
            this.dispatcherManagerRef = bundleContext.getServiceReference((class$de$esolutions$fw$util$commons$job$IDispatcherManager == null ? (class$de$esolutions$fw$util$commons$job$IDispatcherManager = AdapterActivator.class$("de.esolutions.fw.util.commons.job.IDispatcherManager")) : class$de$esolutions$fw$util$commons$job$IDispatcherManager).getName());
            if (this.dispatcherManagerRef != null) {
                this.dispatcherManager = (IDispatcherManager)bundleContext.getService(this.dispatcherManagerRef);
            }
        }
        catch (Throwable throwable) {
            Channels.DSI_ADMIN.log((short)4, new StringBuffer().append("Error retrieving an IDispatcherManager instance ").append(throwable.getMessage()).toString());
        }
        if (this.dispatcherManager == null) {
            Channels.DSI_ADMIN.log((short)5, "Can't continue without an IDispatcherManager");
            throw new RuntimeException("DSIAdmin: Can't continue without an IDispatcherManager");
        }
        Channels.DSI_ADMIN.log((short)1, "Got the IDispatcherManager.");
        this.admin = new DSIAdmin(bundleContext, this.dispatcherManager);
        Channels.DSI_ADMIN.log((short)1, "<- DSI Adapter started.");
        ListenerTracker.getInstance().setDSIAdmin(this.admin);
        ListenerTracker.getInstance().open();
        Channels.DSI_ADMIN.log((short)0, "+ registering COMM Doctor Commands");
        DoctorCommandRegistry.getInstance().registerCommand(new DSIAdapterSnapshotCommand(this.admin));
        DoctorCommandRegistry.getInstance().registerCommand(new DSIAdapterReportCommand(this.admin));
        DoctorCommandRegistry.getInstance().registerCommand(new DSIAdapterProviderInfoCommand(this.admin));
        DoctorCommandRegistry.getInstance().registerCommand(new DSIAdapterDispatcherInfoCommand(this.admin));
        DoctorCommandRegistry.getInstance().registerCommand(new DSIAdapterProviderErrorCommand(this.admin));
        DoctorCommandRegistry.getInstance().registerCommand(new DSIAdapterDispatcherErrorCommand(this.admin));
        Channels.DSI_ADMIN.log((short)0, "- registering COMM Doctor Commands");
        Channels.DSI_ADMIN.log((short)0, "+ registering DSIAdapterDumpInfoProvider");
        AdapterDumpInfoProvider adapterDumpInfoProvider = new AdapterDumpInfoProvider(this.admin);
        Properties properties = new Properties();
        this.dumpInfoProviderServiceReg = bundleContext.registerService((class$de$esolutions$fw$util$commons$error$DumpInfoProvider == null ? (class$de$esolutions$fw$util$commons$error$DumpInfoProvider = AdapterActivator.class$("de.esolutions.fw.util.commons.error.DumpInfoProvider")) : class$de$esolutions$fw$util$commons$error$DumpInfoProvider).getName(), (Object)adapterDumpInfoProvider, (Dictionary)properties);
        Channels.DSI_ADMIN.log((short)0, "- registering DSIAdapterDumpInfoProvider");
    }

    @Override
    public void stop(BundleContext bundleContext) {
        Channels.DSI_ADMIN.log((short)1, "-> Stop DSI Adapter.");
        ListenerTracker.getInstance().close();
        if (this.admin != null) {
            this.admin.stop(bundleContext);
            this.admin = null;
        }
        if (this.dispatcherManagerRef != null) {
            this.dispatcherManager = null;
            bundleContext.ungetService(this.dispatcherManagerRef);
            Channels.DSI_ADMIN.log((short)1, "Released the IDispatcherManager.");
        }
        if (this.dumpInfoProviderServiceReg != null) {
            Channels.DSI_ADMIN.log((short)0, "+ unregistering DSIAdapterDumpInfoProvider");
            this.dumpInfoProviderServiceReg.unregister();
            Channels.DSI_ADMIN.log((short)0, "- unregistering DSIAdapterDumpInfoProvider");
        }
        Channels.DSI_ADMIN.log((short)1, "<- DSI Adapter stopped.");
        TraceClient.exit();
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

