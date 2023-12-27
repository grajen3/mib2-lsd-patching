/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechsetup;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.api.speechengine.SpeechEngine;
import de.vw.mib.asl.framework.api.framework.Services;
import de.vw.mib.asl.internal.speechsetup.SpeechLogger;
import de.vw.mib.asl.internal.speechsetup.SpeechSetupActivatorImpl;
import de.vw.mib.asl.internal.speechsetup.SpeechSetupActivatorResolver$1;
import de.vw.mib.asl.internal.speechsetup.ifc.SpeechSetupParameters;
import de.vw.mib.asl.internal.util.AbstractClassifiedLogger;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.log4mib.LoggerFactory;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class SpeechSetupActivatorResolver
implements SpeechSetupParameters {
    SpeechEngine speechEngine;
    final BundleContext bundleContext;
    final AbstractClassifiedLogger logger;
    private final Services aslServices;
    private final String taskId;
    static /* synthetic */ Class class$de$vw$mib$log4mib$LoggerFactory;
    static /* synthetic */ Class class$de$vw$mib$asl$api$speechengine$SpeechEngineMaster;

    public SpeechSetupActivatorResolver(Services services, String string) {
        this.aslServices = services;
        this.taskId = string;
        this.bundleContext = services.getBundleContext();
        ServiceReference serviceReference = this.bundleContext.getServiceReference((class$de$vw$mib$log4mib$LoggerFactory == null ? (class$de$vw$mib$log4mib$LoggerFactory = SpeechSetupActivatorResolver.class$("de.vw.mib.log4mib.LoggerFactory")) : class$de$vw$mib$log4mib$LoggerFactory).getName());
        LoggerFactory loggerFactory = (LoggerFactory)this.bundleContext.getService(serviceReference);
        this.logger = new SpeechLogger(loggerFactory.getLogger(4096), 4096, 8, "[SpeechSetup] ");
        ServiceTracker serviceTracker = new ServiceTracker(this.bundleContext, (class$de$vw$mib$asl$api$speechengine$SpeechEngineMaster == null ? (class$de$vw$mib$asl$api$speechengine$SpeechEngineMaster = SpeechSetupActivatorResolver.class$("de.vw.mib.asl.api.speechengine.SpeechEngineMaster")) : class$de$vw$mib$asl$api$speechengine$SpeechEngineMaster).getName(), (ServiceTrackerCustomizer)new SpeechSetupActivatorResolver$1(this));
        serviceTracker.open();
    }

    @Override
    public GenericEvents getGenericEvents() {
        return this.aslServices.getGenericEvents();
    }

    @Override
    public AbstractClassifiedLogger getLogger() {
        return this.logger;
    }

    @Override
    public ASLPropertyManager getAslPropertyManager() {
        return this.aslServices.getASLPropertyManager();
    }

    @Override
    public SpeechEngine getSpeechEngine() {
        return this.speechEngine;
    }

    @Override
    public String getTaskId() {
        return this.taskId;
    }

    void serviceChanged() {
        if (this.speechEngine != null) {
            this.getLogger().info().append("Activating SpeechSetup target").log();
            new SpeechSetupActivatorImpl().activate(this);
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

