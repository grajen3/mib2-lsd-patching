/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.format.internal;

import de.vw.mib.activation.BundleActivatorExtension;
import de.vw.mib.asl.ASLTimeAndDateServiceTarget;
import de.vw.mib.configuration.ConfigurationManager;
import de.vw.mib.format.internal.FixFormatImpl;
import de.vw.mib.format.internal.ServiceManager;
import de.vw.mib.log4mib.LoggerFactory;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;

public class Activator
implements BundleActivatorExtension,
ServiceListener {
    private BundleContext context;
    private boolean preloaded = false;
    static /* synthetic */ Class class$de$vw$mib$log4mib$LoggerFactory;
    static /* synthetic */ Class class$de$vw$mib$configuration$ConfigurationManager;
    static /* synthetic */ Class class$de$vw$mib$format$FixFormat;
    static /* synthetic */ Class class$de$vw$mib$format$FixFormat4Bap;
    static /* synthetic */ Class class$de$vw$mib$format$FixFormat4Asl;
    static /* synthetic */ Class class$de$vw$mib$asl$ASLTimeAndDateServiceTarget;

    @Override
    public void preload(BundleContext bundleContext) {
        this.context = bundleContext;
        ServiceManager.loggerFactory = (LoggerFactory)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$log4mib$LoggerFactory == null ? (class$de$vw$mib$log4mib$LoggerFactory = Activator.class$("de.vw.mib.log4mib.LoggerFactory")) : class$de$vw$mib$log4mib$LoggerFactory).getName()));
        ServiceManager.configurationManager = (ConfigurationManager)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$configuration$ConfigurationManager == null ? (class$de$vw$mib$configuration$ConfigurationManager = Activator.class$("de.vw.mib.configuration.ConfigurationManager")) : class$de$vw$mib$configuration$ConfigurationManager).getName()));
        bundleContext.registerService((class$de$vw$mib$format$FixFormat == null ? (class$de$vw$mib$format$FixFormat = Activator.class$("de.vw.mib.format.FixFormat")) : class$de$vw$mib$format$FixFormat).getName(), (Object)new FixFormatImpl(), null);
        bundleContext.registerService((class$de$vw$mib$format$FixFormat4Bap == null ? (class$de$vw$mib$format$FixFormat4Bap = Activator.class$("de.vw.mib.format.FixFormat4Bap")) : class$de$vw$mib$format$FixFormat4Bap).getName(), (Object)new FixFormatImpl(), null);
        bundleContext.registerService((class$de$vw$mib$format$FixFormat4Asl == null ? (class$de$vw$mib$format$FixFormat4Asl = Activator.class$("de.vw.mib.format.FixFormat4Asl")) : class$de$vw$mib$format$FixFormat4Asl).getName(), (Object)new FixFormatImpl(), null);
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("(").append("objectClass").append("=").append((class$de$vw$mib$asl$ASLTimeAndDateServiceTarget == null ? (class$de$vw$mib$asl$ASLTimeAndDateServiceTarget = Activator.class$("de.vw.mib.asl.ASLTimeAndDateServiceTarget")) : class$de$vw$mib$asl$ASLTimeAndDateServiceTarget).getName()).append(")");
        String string = stringBuffer.toString();
        this.context.addServiceListener(this, string);
        this.preloaded = true;
    }

    @Override
    public void serviceChanged(ServiceEvent serviceEvent) {
        Object object = this.context.getService(serviceEvent.getServiceReference());
        if (object instanceof ASLTimeAndDateServiceTarget) {
            ServiceManager.aslTimeAndDateService = (ASLTimeAndDateServiceTarget)object;
        }
    }

    @Override
    public void start(BundleContext bundleContext) {
        if (!this.preloaded) {
            this.preload(bundleContext);
        }
    }

    @Override
    public void stop(BundleContext bundleContext) {
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

