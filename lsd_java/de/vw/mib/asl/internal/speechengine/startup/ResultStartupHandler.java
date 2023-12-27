/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.startup;

import de.vw.mib.asl.internal.speechengine.result.start.ResultHandlerActivator;
import de.vw.mib.asl.internal.speechengine.result.start.ResultHandlerParameters;
import de.vw.mib.asl.internal.speechengine.startup.FrameworkServices;
import de.vw.mib.asl.internal.speechengine.startup.SpeechComponentStarter;
import de.vw.mib.asl.internal.speechengine.startup.SpeechEngineStartup;
import de.vw.mib.asl.internal.util.AbstractClassifiedLogger;
import de.vw.mib.log4mib.Logger;

public class ResultStartupHandler
extends SpeechComponentStarter
implements ResultHandlerParameters {
    private final FrameworkServices frameworkServices;

    ResultStartupHandler(AbstractClassifiedLogger abstractClassifiedLogger, SpeechEngineStartup speechEngineStartup, FrameworkServices frameworkServices) {
        super(abstractClassifiedLogger);
        this.frameworkServices = frameworkServices;
        this.getResultHandlerActivator().activate(speechEngineStartup, this);
    }

    private ResultHandlerActivator getResultHandlerActivator() {
        return (ResultHandlerActivator)this.getActivatorViaReflection("de.vw.mib.asl.internal.speechengine.result.ResultHandlerActivatorStartup");
    }

    @Override
    public Logger getSpeechLogger() {
        return this.frameworkServices.getSpeechLogger();
    }
}

