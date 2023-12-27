/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechgeneral.startup;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.api.speechengine.SpeechEngineMaster;
import de.vw.mib.asl.api.system.ASLSystemAPI;
import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.framework.api.framework.Services;
import de.vw.mib.asl.internal.speechgeneral.events.framework.EventDispatcher;
import de.vw.mib.asl.internal.speechgeneral.events.framework.EventHandler;
import de.vw.mib.asl.internal.speechgeneral.startup.SpeechGeneralActivator;
import de.vw.mib.asl.internal.speechgeneral.startup.SpeechGeneralStartTarget$1;
import de.vw.mib.asl.internal.speechgeneral.startup.SpeechGeneralStartTarget$2;
import de.vw.mib.asl.internal.speechgeneral.startup.SpeechGeneralStartTarget$3;
import de.vw.mib.asl.internal.speechgeneral.utils.SpeechGeneralLogger;
import de.vw.mib.asl.internal.speechgeneral.utils.SpeechGeneralServiceManager;
import de.vw.mib.cio.CioDictionary;
import de.vw.mib.cio.CioDispatcher;
import de.vw.mib.configuration.ConfigurationManagerDiag;
import de.vw.mib.event.dispatcher.SystemEventDispatcher;
import de.vw.mib.genericevents.AbstractTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.threads.AsyncServiceFactory;
import java.util.HashSet;
import java.util.Iterator;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class SpeechGeneralStartTarget
extends AbstractTarget
implements EventHandler,
EventDispatcher {
    private SpeechGeneralLogger logger;
    BundleContext bundleContext;
    protected SpeechEngineMaster speechEngineMaster;
    protected CioDictionary cioDictionary;
    protected CioDispatcher cioDispatcher;
    private HashSet eventHandlerSet;
    private ServiceTrackerCustomizer speechEngineTracker = new SpeechGeneralStartTarget$1(this);
    private ServiceTrackerCustomizer cioDictionaryTracker = new SpeechGeneralStartTarget$2(this);
    private ServiceTrackerCustomizer cioDispatcherTracker = new SpeechGeneralStartTarget$3(this);
    static /* synthetic */ Class class$de$vw$mib$asl$api$speechengine$SpeechEngineMaster;
    static /* synthetic */ Class class$de$vw$mib$cio$CioDictionary;
    static /* synthetic */ Class class$de$vw$mib$cio$CioDispatcher;

    public SpeechGeneralStartTarget(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
        this.logger = new SpeechGeneralLogger("[SpeechGeneralStartTarget] ", 4096);
        this.eventHandlerSet = new HashSet();
        this.registerHandler(this);
    }

    private void onPowerOn() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace().append("SpeechGeneral POWER_ON").log();
        }
        this.bundleContext = SpeechGeneralServiceManager.getBundleContext();
        ServiceTracker serviceTracker = new ServiceTracker(this.bundleContext, (class$de$vw$mib$asl$api$speechengine$SpeechEngineMaster == null ? (class$de$vw$mib$asl$api$speechengine$SpeechEngineMaster = SpeechGeneralStartTarget.class$("de.vw.mib.asl.api.speechengine.SpeechEngineMaster")) : class$de$vw$mib$asl$api$speechengine$SpeechEngineMaster).getName(), this.speechEngineTracker);
        serviceTracker.open();
        ServiceTracker serviceTracker2 = new ServiceTracker(this.bundleContext, (class$de$vw$mib$cio$CioDictionary == null ? (class$de$vw$mib$cio$CioDictionary = SpeechGeneralStartTarget.class$("de.vw.mib.cio.CioDictionary")) : class$de$vw$mib$cio$CioDictionary).getName(), this.cioDictionaryTracker);
        serviceTracker2.open();
        ServiceTracker serviceTracker3 = new ServiceTracker(this.bundleContext, (class$de$vw$mib$cio$CioDispatcher == null ? (class$de$vw$mib$cio$CioDispatcher = SpeechGeneralStartTarget.class$("de.vw.mib.cio.CioDispatcher")) : class$de$vw$mib$cio$CioDispatcher).getName(), this.cioDispatcherTracker);
        serviceTracker3.open();
    }

    protected void checkServices() {
        if (this.speechEngineMaster == null || this.cioDictionary == null || this.cioDispatcher == null) {
            return;
        }
        if (this.logger.isTraceEnabled()) {
            this.logger.trace().append("All services for SpeechGeneral ready.").log();
        }
        Services services = SpeechGeneralServiceManager.getAslApiServices();
        ConfigurationManagerDiag configurationManagerDiag = SpeechGeneralServiceManager.getAslApiServices().getConfigurationManagerDiag();
        SystemEventDispatcher systemEventDispatcher = SpeechGeneralServiceManager.getSystemEventDispatcher();
        ASLSystemAPI aSLSystemAPI = ASLSystemFactory.getSystemApi();
        ASLPropertyManager aSLPropertyManager = SpeechGeneralServiceManager.getAslApiServices().getASLPropertyManager();
        AsyncServiceFactory asyncServiceFactory = SpeechGeneralServiceManager.getAslApiServices().getASLAsyncServiceFactory();
        SpeechGeneralActivator speechGeneralActivator = new SpeechGeneralActivator(this.logger);
        speechGeneralActivator.activate(this.bundleContext, this.speechEngineMaster, configurationManagerDiag, systemEventDispatcher, aSLSystemAPI, this, aSLPropertyManager, this.mEventContext, asyncServiceFactory, this.cioDictionary, this.cioDispatcher, services);
    }

    @Override
    public void registerHandler(EventHandler eventHandler) {
        if (eventHandler != null) {
            this.eventHandlerSet.add(eventHandler);
            this.addObservers(eventHandler.getHandleEvents());
        }
    }

    @Override
    public int[] getHandleEvents() {
        return new int[]{106};
    }

    @Override
    public void handleEvent(EventGeneric eventGeneric) {
        if (eventGeneric.getReceiverEventId() == 106) {
            this.onPowerOn();
        }
    }

    @Override
    public int getDefaultTargetId() {
        return 582490112;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        int n = eventGeneric.getReceiverEventId();
        switch (n) {
            case 8: {
                break;
            }
            default: {
                this.dispatchEvent(eventGeneric);
            }
        }
    }

    private void dispatchEvent(EventGeneric eventGeneric) {
        HashSet hashSet = (HashSet)this.eventHandlerSet.clone();
        Iterator iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            EventHandler eventHandler = (EventHandler)iterator.next();
            int[] nArray = eventHandler.getHandleEvents();
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                int n = eventGeneric.getReceiverEventId();
                if (nArray[i2] != n) continue;
                eventHandler.handleEvent(eventGeneric);
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

