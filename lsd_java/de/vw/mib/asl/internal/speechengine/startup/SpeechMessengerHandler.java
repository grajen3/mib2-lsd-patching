/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.startup;

import de.vw.mib.asl.framework.api.framework.Services;
import de.vw.mib.asl.internal.speechengine.messenger.start.SpeechMessengerActivator;
import de.vw.mib.asl.internal.speechengine.messenger.start.SpeechMessengerParameters;
import de.vw.mib.asl.internal.speechengine.startup.FrameworkServices;
import de.vw.mib.asl.internal.speechengine.startup.SpeechASLLogger;
import de.vw.mib.asl.internal.speechengine.startup.SpeechComponentStarter;
import de.vw.mib.asl.internal.speechengine.startup.SpeechEngineStartup;
import de.vw.mib.asl.internal.util.AbstractClassifiedLogger;
import de.vw.mib.event.dispatcher.SystemEventDispatcher;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.threads.AsyncServiceFactory;

public class SpeechMessengerHandler
extends SpeechComponentStarter
implements SpeechMessengerParameters {
    private final Services aslServices;
    private final FrameworkServices frameworkServices;
    private final AbstractClassifiedLogger aLogger;

    SpeechMessengerHandler(AbstractClassifiedLogger abstractClassifiedLogger, SpeechEngineStartup speechEngineStartup, FrameworkServices frameworkServices, Services services) {
        super(abstractClassifiedLogger);
        this.frameworkServices = frameworkServices;
        this.aslServices = services;
        this.aLogger = new SpeechASLLogger(8, "[SpeechMessenger] ", frameworkServices.getSpeechLogger());
        this.getSpeechRouterActivator().activate(speechEngineStartup, this);
    }

    private SpeechMessengerActivator getSpeechRouterActivator() {
        return (SpeechMessengerActivator)this.getActivatorViaReflection("de.vw.mib.asl.internal.speechengine.messenger.SpeechMessengerStartup");
    }

    @Override
    public int getLoggerClassifier() {
        return 8;
    }

    @Override
    public String getLoggerPrefix() {
        return "[DialogSystemRouter] ";
    }

    @Override
    public Logger getLogger() {
        return this.frameworkServices.getSpeechLogger();
    }

    @Override
    public AsyncServiceFactory getASLAsyncServiceFactory() {
        return this.aslServices.getASLAsyncServiceFactory();
    }

    @Override
    public SystemEventDispatcher getSystemEventDispatcher() {
        return this.aslServices.getSystemEventDispatcher();
    }

    @Override
    public AbstractClassifiedLogger getAbstractClassifiedLogger() {
        return this.aLogger;
    }
}

