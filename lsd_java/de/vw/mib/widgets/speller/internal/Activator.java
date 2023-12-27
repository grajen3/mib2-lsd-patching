/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.internal;

import de.vw.mib.asia.AsiaInput;
import de.vw.mib.configuration.ConfigurationManager;
import de.vw.mib.log4mib.LogManager;
import de.vw.mib.log4mib.LoggerFactory;
import de.vw.mib.speller.SpellerController;
import de.vw.mib.timer.TimerManager;
import de.vw.mib.util.StringBuilder;
import de.vw.mib.widgets.speller.internal.ServiceManager;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceReference;

public final class Activator
implements BundleActivator,
ServiceListener {
    static /* synthetic */ Class class$de$vw$mib$asia$AsiaInput;
    static /* synthetic */ Class class$de$vw$mib$configuration$ConfigurationManager;
    static /* synthetic */ Class class$de$vw$mib$log4mib$LogManager;
    static /* synthetic */ Class class$de$vw$mib$log4mib$LoggerFactory;
    static /* synthetic */ Class class$de$vw$mib$speller$SpellerController;
    static /* synthetic */ Class class$de$vw$mib$timer$TimerManager;

    @Override
    public void start(BundleContext bundleContext) {
        ServiceManager.bundleContext = bundleContext;
        ServiceReference serviceReference = bundleContext.getServiceReference((class$de$vw$mib$asia$AsiaInput == null ? (class$de$vw$mib$asia$AsiaInput = Activator.class$("de.vw.mib.asia.AsiaInput")) : class$de$vw$mib$asia$AsiaInput).getName());
        if (serviceReference != null) {
            ServiceManager.asiaInput = (AsiaInput)bundleContext.getService(serviceReference);
        } else {
            this.registerServiceListener(bundleContext, (class$de$vw$mib$asia$AsiaInput == null ? (class$de$vw$mib$asia$AsiaInput = Activator.class$("de.vw.mib.asia.AsiaInput")) : class$de$vw$mib$asia$AsiaInput).getName());
        }
        ServiceManager.configurationManager = (ConfigurationManager)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$configuration$ConfigurationManager == null ? (class$de$vw$mib$configuration$ConfigurationManager = Activator.class$("de.vw.mib.configuration.ConfigurationManager")) : class$de$vw$mib$configuration$ConfigurationManager).getName()));
        ServiceManager.logManager = (LogManager)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$log4mib$LogManager == null ? (class$de$vw$mib$log4mib$LogManager = Activator.class$("de.vw.mib.log4mib.LogManager")) : class$de$vw$mib$log4mib$LogManager).getName()));
        ServiceManager.loggerFactory = (LoggerFactory)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$log4mib$LoggerFactory == null ? (class$de$vw$mib$log4mib$LoggerFactory = Activator.class$("de.vw.mib.log4mib.LoggerFactory")) : class$de$vw$mib$log4mib$LoggerFactory).getName()));
        ServiceReference serviceReference2 = bundleContext.getServiceReference((class$de$vw$mib$speller$SpellerController == null ? (class$de$vw$mib$speller$SpellerController = Activator.class$("de.vw.mib.speller.SpellerController")) : class$de$vw$mib$speller$SpellerController).getName());
        if (serviceReference2 != null) {
            ServiceManager.spellerController = (SpellerController)bundleContext.getService(serviceReference2);
        } else {
            this.registerServiceListener(bundleContext, (class$de$vw$mib$speller$SpellerController == null ? (class$de$vw$mib$speller$SpellerController = Activator.class$("de.vw.mib.speller.SpellerController")) : class$de$vw$mib$speller$SpellerController).getName());
        }
        ServiceManager.timerManager = (TimerManager)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$timer$TimerManager == null ? (class$de$vw$mib$timer$TimerManager = Activator.class$("de.vw.mib.timer.TimerManager")) : class$de$vw$mib$timer$TimerManager).getName()));
    }

    @Override
    public void stop(BundleContext bundleContext) {
    }

    private void registerServiceListener(BundleContext bundleContext, String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(").append("objectClass").append("=").append(string).append(")");
        bundleContext.addServiceListener(this, stringBuilder.toString());
    }

    @Override
    public void serviceChanged(ServiceEvent serviceEvent) {
        switch (serviceEvent.getType()) {
            case 1: {
                Object object = ServiceManager.bundleContext.getService(serviceEvent.getServiceReference());
                if (object instanceof AsiaInput) {
                    ServiceManager.asiaInput = (AsiaInput)object;
                    break;
                }
                if (!(object instanceof SpellerController)) break;
                ServiceManager.spellerController = (SpellerController)object;
                break;
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

