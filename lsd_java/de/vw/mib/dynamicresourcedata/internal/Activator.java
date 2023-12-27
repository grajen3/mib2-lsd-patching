/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dynamicresourcedata.internal;

import de.vw.mib.dynamicresourcedata.internal.DynamicResourceDataFactoryImpl;
import de.vw.mib.file.FileManager;
import de.vw.mib.log4mib.LoggerFactory;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class Activator
implements BundleActivator {
    private BundleContext bundleContext;
    static /* synthetic */ Class class$de$vw$mib$dynamicresourcedata$DynamicResourceDataFactory;

    @Override
    public void start(BundleContext bundleContext) {
        this.bundleContext = bundleContext;
        LoggerFactory loggerFactory = (LoggerFactory)this.getService("de.vw.mib.log4mib.LoggerFactory");
        if (loggerFactory == null) {
            throw new IllegalStateException("Service 'de.vw.mib.log4mib.LoggerFactory' not available.");
        }
        FileManager fileManager = (FileManager)this.getService("de.vw.mib.file.FileManager");
        if (fileManager == null) {
            throw new IllegalStateException("Service 'de.vw.mib.file.FileManager' not available.");
        }
        this.bundleContext.registerService((class$de$vw$mib$dynamicresourcedata$DynamicResourceDataFactory == null ? (class$de$vw$mib$dynamicresourcedata$DynamicResourceDataFactory = Activator.class$("de.vw.mib.dynamicresourcedata.DynamicResourceDataFactory")) : class$de$vw$mib$dynamicresourcedata$DynamicResourceDataFactory).getName(), (Object)new DynamicResourceDataFactoryImpl(loggerFactory, fileManager), null);
    }

    @Override
    public void stop(BundleContext bundleContext) {
    }

    private Object getService(String string) {
        ServiceReference serviceReference = this.bundleContext.getServiceReference(string);
        if (serviceReference == null) {
            throw new NullPointerException(new StringBuffer().append("Missing Service ").append(string).toString());
        }
        Object object = this.bundleContext.getService(serviceReference);
        if (object == null) {
            throw new NullPointerException(new StringBuffer().append("Missing Service ").append(string).toString());
        }
        return object;
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

