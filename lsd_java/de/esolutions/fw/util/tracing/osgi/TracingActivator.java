/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.osgi;

import de.esolutions.fw.util.tracing.TraceClient;
import de.esolutions.fw.util.tracing.frontend.TraceFrontend;
import de.esolutions.fw.util.tracing.osgi.DumpTraceEntityModelCallback;
import de.esolutions.fw.util.tracing.osgi.InjectErrorCallback;
import java.util.Dictionary;
import java.util.Hashtable;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class TracingActivator
implements BundleActivator {
    private ServiceRegistration clientService;
    private ServiceRegistration frontendService;
    private TraceClient client;
    private TraceFrontend frontend;
    private int dumpModelCB;
    private int injectErrorCB;
    static /* synthetic */ Class class$de$esolutions$fw$util$tracing$TraceClient;
    static /* synthetic */ Class class$de$esolutions$fw$util$tracing$frontend$TraceFrontend;

    @Override
    public void start(BundleContext bundleContext) {
        TraceClient.init("hmi", "client", true);
        this.client = TraceClient.getTraceClient();
        if (this.client == null) {
            System.out.println("TracingActivator disabled. No client activated! Config problem?");
            return;
        }
        this.frontend = this.client.getFrontend();
        if (this.frontend != null && this.frontend.isEnabled()) {
            this.clientService = bundleContext.registerService((class$de$esolutions$fw$util$tracing$TraceClient == null ? (class$de$esolutions$fw$util$tracing$TraceClient = TracingActivator.class$("de.esolutions.fw.util.tracing.TraceClient")) : class$de$esolutions$fw$util$tracing$TraceClient).getName(), (Object)TraceClient.getTraceClient(), (Dictionary)new Hashtable());
            this.frontendService = bundleContext.registerService((class$de$esolutions$fw$util$tracing$frontend$TraceFrontend == null ? (class$de$esolutions$fw$util$tracing$frontend$TraceFrontend = TracingActivator.class$("de.esolutions.fw.util.tracing.frontend.TraceFrontend")) : class$de$esolutions$fw$util$tracing$frontend$TraceFrontend).getName(), (Object)this.frontend, (Dictionary)new Hashtable());
        } else {
            System.out.println("TracingActivator disabled");
        }
        this.dumpModelCB = this.client.registerCallback("Dump trace entity model", new DumpTraceEntityModelCallback("/tmp"));
        this.injectErrorCB = this.client.registerCallback("Inject Trace Error", new InjectErrorCallback(this.frontend));
    }

    @Override
    public void stop(BundleContext bundleContext) {
        if (this.client != null) {
            this.client.unregisterCallback(this.dumpModelCB);
            this.client.unregisterCallback(this.injectErrorCB);
        }
        if (this.frontend != null && this.frontend.isEnabled()) {
            if (this.clientService != null) {
                bundleContext.ungetService(this.clientService.getReference());
            }
            if (this.frontendService != null) {
                bundleContext.ungetService(this.frontendService.getReference());
            }
        }
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

