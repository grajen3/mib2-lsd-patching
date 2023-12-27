/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.admin;

import de.esolutions.fw.dsi.AdapterActivator;
import de.esolutions.fw.dsi.tracing.Channels;
import de.esolutions.fw.util.tracing.TraceChannel;
import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;

public class ProviderTracker {
    private static ProviderTracker providerTracker;
    private TraceChannel tracer = Channels.PROVIDER_TRACKER;

    private ProviderTracker() {
    }

    public static ProviderTracker getInstance() {
        if (providerTracker == null) {
            providerTracker = new ProviderTracker();
        }
        return providerTracker;
    }

    public ServiceReference getDSIProvider(String string, int n) {
        this.tracer.log((short)0, "Search provider for: serviceName=%1, serviceInstance=%2", (Object)string, (Object)String.valueOf(n));
        BundleContext bundleContext = AdapterActivator.bundleContext;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("(").append("DEVICE_INSTANCE").append("=").append(n).append(")");
        ServiceReference serviceReference = null;
        try {
            ServiceReference[] serviceReferenceArray = bundleContext.getServiceReferences(string, stringBuffer.toString());
            if (serviceReferenceArray.length == 1) {
                serviceReference = serviceReferenceArray[0];
                this.tracer.log((short)0, "Provider found for: serviceName=%1, serviceInstance=%2 -> ref=%3", (Object)string, (Object)String.valueOf(n), (Object)serviceReference);
            } else if (serviceReferenceArray.length > 1) {
                serviceReference = serviceReferenceArray[0];
                this.tracer.log((short)3, "More then one providers found for: serviceName=%1, serviceInstance=%2 -> providers=%3, ref=%4", (Object)string, (Object)String.valueOf(n), (Object)String.valueOf(serviceReferenceArray.length), (Object)serviceReference);
            } else {
                this.tracer.log((short)0, "No providers found for: serviceName=%1, serviceInstance=%2", (Object)string, (Object)String.valueOf(n));
            }
        }
        catch (InvalidSyntaxException invalidSyntaxException) {
            this.tracer.log((short)4, "Error during search of provider references: message=%1", (Object)invalidSyntaxException.getMessage());
        }
        return serviceReference;
    }
}

