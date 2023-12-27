/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.startup;

import de.vw.mib.asl.framework.api.framework.Services;
import de.vw.mib.asl.internal.speechengine.audio.start.AudioProviderActivator;
import de.vw.mib.asl.internal.speechengine.audio.start.AudioProviderCallback;
import de.vw.mib.asl.internal.speechengine.audio.start.AudioProviderParameters;
import de.vw.mib.asl.internal.speechengine.startup.SpeechComponentStarter;
import de.vw.mib.asl.internal.util.AbstractClassifiedLogger;
import de.vw.mib.genericevents.EventFactory;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.ThreadSwitchingTarget;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.timer.TimerManager;

public class AudioProviderHandler
extends SpeechComponentStarter
implements AudioProviderParameters {
    private final AudioProviderActivator audioActivator;
    private final Services aslServices;
    private final Logger logger;
    private final AudioProviderCallback engineStarter;
    private final String taskId;
    private final TimerManager timerManager;

    AudioProviderHandler(AbstractClassifiedLogger abstractClassifiedLogger, AudioProviderCallback audioProviderCallback, Services services, Logger logger, String string, TimerManager timerManager) {
        super(abstractClassifiedLogger);
        this.engineStarter = audioProviderCallback;
        this.taskId = string;
        this.aslServices = services;
        this.logger = logger;
        this.timerManager = timerManager;
        this.audioActivator = (AudioProviderActivator)super.getActivatorViaReflection("de.vw.mib.asl.internal.speechengine.audio.AudioProviderActivatorImpl");
        this.audioActivator.activate(this);
    }

    @Override
    public ThreadSwitchingTarget getThreadSwitchingTarget() {
        return this.aslServices.getASLThreadSwitch();
    }

    @Override
    public GenericEvents getGenericEvents() {
        return this.aslServices.getGenericEvents();
    }

    @Override
    public EventFactory getEventFactory() {
        return this.aslServices.getEventFactory();
    }

    @Override
    public String getTaskId() {
        return this.taskId;
    }

    @Override
    public int getTargetId() {
        return 462493696;
    }

    @Override
    public Logger getLogger() {
        return this.logger;
    }

    @Override
    public int getSubClassifier() {
        return 2048;
    }

    @Override
    public AudioProviderCallback getSpeechEngineStarter() {
        return this.engineStarter;
    }

    @Override
    public TimerManager getTimerManager() {
        return this.timerManager;
    }
}

