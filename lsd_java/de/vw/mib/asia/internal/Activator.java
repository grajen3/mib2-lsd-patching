/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asia.internal;

import de.vw.mib.asia.ASLAsiaInput;
import de.vw.mib.asia.internal.AsiaInputFw;
import de.vw.mib.asia.internal.AsiaInputListenerFw;
import de.vw.mib.threads.AsyncServiceFactory;
import de.vw.mib.util.StringBuilder;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

public final class Activator
implements BundleActivator,
ServiceListener {
    private static final String UI_THREAD_ID = String.valueOf(2);
    private ASLAsiaInput aslAsiaInput;
    private AsyncServiceFactory asyncServiceFactory;
    private BundleContext bundleContext;
    private ServiceRegistration registration;
    static /* synthetic */ Class class$de$vw$mib$asia$ASLAsiaInput;
    static /* synthetic */ Class class$de$vw$mib$threads$AsyncServiceFactory;
    static /* synthetic */ Class class$de$vw$mib$asia$AsiaInput;

    @Override
    public void serviceChanged(ServiceEvent serviceEvent) {
        Object object = this.bundleContext.getService(serviceEvent.getServiceReference());
        if (serviceEvent.getType() == 1) {
            String string;
            if (object instanceof ASLAsiaInput) {
                this.aslAsiaInput = (ASLAsiaInput)object;
            } else if (object instanceof AsyncServiceFactory && UI_THREAD_ID.equals(string = (String)serviceEvent.getServiceReference().getProperty("MIBThreadId"))) {
                this.asyncServiceFactory = (AsyncServiceFactory)object;
            }
            this.initIfAllServicesAvailable();
        } else if (serviceEvent.getType() == 4) {
            String string;
            if (object instanceof ASLAsiaInput) {
                this.aslAsiaInput = null;
            } else if (object instanceof AsyncServiceFactory && UI_THREAD_ID.equals(string = (String)serviceEvent.getServiceReference().getProperty("MIBThreadId"))) {
                this.asyncServiceFactory = null;
            }
            this.unregisterServiceIfAvailable();
        }
    }

    @Override
    public void start(BundleContext bundleContext) {
        this.bundleContext = bundleContext;
        StringBuilder stringBuilder = new StringBuilder(100);
        stringBuilder.append("(|");
        stringBuilder.append("(").append("objectClass").append("=").append((class$de$vw$mib$asia$ASLAsiaInput == null ? (class$de$vw$mib$asia$ASLAsiaInput = Activator.class$("de.vw.mib.asia.ASLAsiaInput")) : class$de$vw$mib$asia$ASLAsiaInput).getName()).append(")");
        stringBuilder.append("(").append("objectClass").append("=").append((class$de$vw$mib$threads$AsyncServiceFactory == null ? (class$de$vw$mib$threads$AsyncServiceFactory = Activator.class$("de.vw.mib.threads.AsyncServiceFactory")) : class$de$vw$mib$threads$AsyncServiceFactory).getName()).append(")");
        stringBuilder.append(")");
        String string = stringBuilder.toString();
        bundleContext.addServiceListener(this, string);
        ServiceReference[] serviceReferenceArray = bundleContext.getServiceReferences(null, string);
        for (int i2 = 0; serviceReferenceArray != null && i2 < serviceReferenceArray.length; ++i2) {
            this.serviceChanged(new ServiceEvent(1, serviceReferenceArray[i2]));
        }
    }

    @Override
    public void stop(BundleContext bundleContext) {
        this.unregisterServiceIfAvailable();
    }

    private void initIfAllServicesAvailable() {
        if (this.registration != null) {
            return;
        }
        if (this.aslAsiaInput == null) {
            return;
        }
        if (this.asyncServiceFactory == null) {
            return;
        }
        AsiaInputFw asiaInputFw = new AsiaInputFw(this.aslAsiaInput, new AsiaInputListenerFw(), this.asyncServiceFactory);
        this.registration = this.bundleContext.registerService((class$de$vw$mib$asia$AsiaInput == null ? (class$de$vw$mib$asia$AsiaInput = Activator.class$("de.vw.mib.asia.AsiaInput")) : class$de$vw$mib$asia$AsiaInput).getName(), (Object)asiaInputFw, null);
    }

    private void unregisterServiceIfAvailable() {
        if (this.registration == null) {
            return;
        }
        this.registration.unregister();
        this.registration = null;
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

