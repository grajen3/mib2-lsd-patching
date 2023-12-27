/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.processor;

import de.vw.mib.asl.api.system.contentprocessor.ContentProcessorManager;
import de.vw.mib.asl.internal.system.SystemServices;
import de.vw.mib.asl.internal.system.processor.ContentProcessorManagerFactory$1;
import de.vw.mib.asl.internal.system.processor.ContentProcessorManagerImpl;
import de.vw.mib.asl.internal.system.processor.ContentRequestTarget;
import de.vw.mib.asl.internal.system.processor.DisplayOffClockContentProcessor;
import de.vw.mib.asl.internal.system.processor.DisplayOffClockRequestTarget;
import de.vw.mib.asl.internal.system.processor.SpeechContentProcessor;
import de.vw.mib.asl.internal.system.processor.StaticContentProcessor;
import de.vw.mib.asl.internal.system.processor.manager.AudibleContentManager;
import de.vw.mib.configuration.ConfigurationManagerDiag;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.log4mib.Logger;
import org.osgi.framework.BundleContext;

public class ContentProcessorManagerFactory {
    private SystemServices systemServices;
    static /* synthetic */ Class class$de$vw$mib$asl$api$speechengine$SpeechEngine;

    public ContentProcessorManager create(SystemServices systemServices) {
        this.systemServices = systemServices;
        return this.createContentManager();
    }

    private ContentProcessorManager createContentManager() {
        Logger logger = this.systemServices.getAsl1Logger();
        ConfigurationManagerDiag configurationManagerDiag = this.systemServices.getConfigManagerDiag();
        GenericEvents genericEvents = this.systemServices.getGenericEvents();
        new AudibleContentManager(this.systemServices);
        ContentProcessorManagerImpl contentProcessorManagerImpl = new ContentProcessorManagerImpl(this.systemServices);
        DisplayOffClockContentProcessor displayOffClockContentProcessor = new DisplayOffClockContentProcessor(this.systemServices);
        contentProcessorManagerImpl.registerContentProcessor(new StaticContentProcessor(logger, "ScreenAreaStatus", "HMI_STATUS_BAR"));
        contentProcessorManagerImpl.registerContentProcessor(new StaticContentProcessor(logger, "ScreenAreaMenu", "HMI_GRIDMENU"));
        contentProcessorManagerImpl.registerContentProcessor(new StaticContentProcessor(logger, "ScreenAreaSpaceGesture", "HMI_SPACEGESTUREINDICATOR"));
        if (configurationManagerDiag.isFeatureFlagSet(383)) {
            contentProcessorManagerImpl.registerContentProcessor(new StaticContentProcessor(logger, "ScreenAreaParticleBackground", "HMI_BACKGROUND"));
        }
        SpeechContentProcessor speechContentProcessor = new SpeechContentProcessor(logger);
        contentProcessorManagerImpl.registerContentProcessor(speechContentProcessor);
        contentProcessorManagerImpl.registerContentProcessor(displayOffClockContentProcessor);
        ContentRequestTarget contentRequestTarget = new ContentRequestTarget(this.systemServices);
        DisplayOffClockRequestTarget displayOffClockRequestTarget = new DisplayOffClockRequestTarget(this.systemServices, displayOffClockContentProcessor);
        try {
            genericEvents.getEventDispatcher().registerTarget(-274066176, contentRequestTarget, "hsmtask");
            genericEvents.getEventDispatcher().registerTarget(-89516800, displayOffClockRequestTarget, "hsmtask");
            EventGeneric eventGeneric = genericEvents.getEventFactory().newEvent(-1, -274066176, 106);
            EventGeneric eventGeneric2 = genericEvents.getEventFactory().newEvent(-1, -89516800, 106);
            genericEvents.getEventDispatcher().send(eventGeneric);
            genericEvents.getEventDispatcher().send(eventGeneric2);
        }
        catch (Exception exception) {
            logger.error(2048, "Could not register the content register targets.");
        }
        this.trackSpeechEngine(this.systemServices, speechContentProcessor);
        return contentProcessorManagerImpl;
    }

    private void trackSpeechEngine(SystemServices systemServices, SpeechContentProcessor speechContentProcessor) {
        BundleContext bundleContext = systemServices.getBundleContext();
        SpeechContentProcessor speechContentProcessor2 = speechContentProcessor;
        new ContentProcessorManagerFactory$1(this, bundleContext, (class$de$vw$mib$asl$api$speechengine$SpeechEngine == null ? (class$de$vw$mib$asl$api$speechengine$SpeechEngine = ContentProcessorManagerFactory.class$("de.vw.mib.asl.api.speechengine.SpeechEngine")) : class$de$vw$mib$asl$api$speechengine$SpeechEngine).getName(), null, speechContentProcessor2).open();
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

