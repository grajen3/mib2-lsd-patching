/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.speller.internal;

import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.LoggerFactory;
import de.vw.mib.speller.hwr.HWRManager;
import de.vw.mib.speller.internal.Log;
import de.vw.mib.speller.internal.ServiceManager;
import de.vw.mib.speller.internal.SpellerControllerImpl;
import de.vw.mib.speller.internal.SpellerFilterRegistry;
import de.vw.mib.threads.AsyncServiceFactory;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

public class Activator
implements BundleActivator,
ServiceListener {
    private static final String MIB_THREAD_ID_MAIN = String.valueOf(2);
    private static final String MIB_THREAD_ID_HSM = String.valueOf(3);
    private BundleContext bundleContext;
    private ServiceRegistration spellerControllerRegistration;
    private SpellerFilterRegistry filterRegistry;
    static /* synthetic */ Class class$de$vw$mib$speller$hwr$HWRManager;
    static /* synthetic */ Class class$de$vw$mib$threads$AsyncServiceFactory;
    static /* synthetic */ Class class$de$vw$mib$log4mib$LoggerFactory;
    static /* synthetic */ Class class$de$vw$mib$speller$SpellerController;

    @Override
    public void serviceChanged(ServiceEvent serviceEvent) {
        if (serviceEvent.getType() != 1) {
            return;
        }
        ServiceReference serviceReference = serviceEvent.getServiceReference();
        String[] stringArray = (String[])serviceReference.getProperty("objectClass");
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            String string = stringArray[i2];
            if ((class$de$vw$mib$speller$hwr$HWRManager == null ? Activator.class$("de.vw.mib.speller.hwr.HWRManager") : class$de$vw$mib$speller$hwr$HWRManager).getName().equals(string)) {
                ServiceManager.hwrManager = (HWRManager)this.bundleContext.getService(serviceReference);
                LogMessage logMessage = Log.normal();
                if (null == logMessage) continue;
                logMessage.append("Received HWRManager.").log();
                continue;
            }
            if (!(class$de$vw$mib$threads$AsyncServiceFactory == null ? Activator.class$("de.vw.mib.threads.AsyncServiceFactory") : class$de$vw$mib$threads$AsyncServiceFactory).getName().equals(string)) continue;
            this.registeredAsyncServiceFactory(serviceReference);
        }
    }

    private void registeredAsyncServiceFactory(ServiceReference serviceReference) {
        String string = (String)serviceReference.getProperty("MIBThreadId");
        LogMessage logMessage = Log.normal();
        if (null != logMessage) {
            logMessage.append("Received AsyncServiceFactory, threadId=").append(string).log();
        }
        if (MIB_THREAD_ID_MAIN.equals(string)) {
            ServiceManager.asyncServiceFactoryMain = (AsyncServiceFactory)this.bundleContext.getService(serviceReference);
        } else if (MIB_THREAD_ID_HSM.equals(string)) {
            ServiceManager.asyncServiceFactoryHSM = (AsyncServiceFactory)this.bundleContext.getService(serviceReference);
        }
    }

    @Override
    public void start(BundleContext bundleContext) {
        LogMessage logMessage;
        this.bundleContext = bundleContext;
        ServiceManager.loggerFactory = (LoggerFactory)this.bundleContext.getService(this.bundleContext.getServiceReference((class$de$vw$mib$log4mib$LoggerFactory == null ? (class$de$vw$mib$log4mib$LoggerFactory = Activator.class$("de.vw.mib.log4mib.LoggerFactory")) : class$de$vw$mib$log4mib$LoggerFactory).getName()));
        if (null != ServiceManager.loggerFactory) {
            ServiceManager.logger = ServiceManager.loggerFactory.getLogger(16384);
        }
        if (null != (logMessage = Log.normal())) {
            logMessage.append("Starting bundle.").log();
        }
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("(|");
        stringBuffer.append("(").append("objectClass").append("=").append((class$de$vw$mib$speller$hwr$HWRManager == null ? (class$de$vw$mib$speller$hwr$HWRManager = Activator.class$("de.vw.mib.speller.hwr.HWRManager")) : class$de$vw$mib$speller$hwr$HWRManager).getName()).append(")");
        stringBuffer.append("(").append("objectClass").append("=").append((class$de$vw$mib$threads$AsyncServiceFactory == null ? (class$de$vw$mib$threads$AsyncServiceFactory = Activator.class$("de.vw.mib.threads.AsyncServiceFactory")) : class$de$vw$mib$threads$AsyncServiceFactory).getName()).append(")");
        stringBuffer.append(")");
        String string = stringBuffer.toString();
        bundleContext.addServiceListener(this, string);
        ServiceReference[] serviceReferenceArray = bundleContext.getServiceReferences(null, string);
        for (int i2 = 0; serviceReferenceArray != null && i2 < serviceReferenceArray.length; ++i2) {
            this.serviceChanged(new ServiceEvent(1, serviceReferenceArray[i2]));
        }
        this.filterRegistry = new SpellerFilterRegistry(bundleContext);
        this.filterRegistry.bind();
        ServiceManager.spellerController = new SpellerControllerImpl(this.filterRegistry);
        this.spellerControllerRegistration = bundleContext.registerService((class$de$vw$mib$speller$SpellerController == null ? (class$de$vw$mib$speller$SpellerController = Activator.class$("de.vw.mib.speller.SpellerController")) : class$de$vw$mib$speller$SpellerController).getName(), (Object)ServiceManager.spellerController, null);
    }

    @Override
    public void stop(BundleContext bundleContext) {
        LogMessage logMessage = Log.normal();
        if (null != logMessage) {
            logMessage.append("Stopping bundle.").log();
        }
        bundleContext.removeServiceListener(this);
        if (null != this.filterRegistry) {
            this.filterRegistry.unbind();
            this.filterRegistry = null;
        }
        if (null != this.spellerControllerRegistration) {
            this.spellerControllerRegistration.unregister();
            this.spellerControllerRegistration = null;
        }
        ServiceManager.spellerController = null;
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

