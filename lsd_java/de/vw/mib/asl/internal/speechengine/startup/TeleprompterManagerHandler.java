/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.startup;

import de.vw.mib.asl.framework.api.framework.Services;
import de.vw.mib.asl.internal.speechengine.config.SpeechConfiguratorFactory;
import de.vw.mib.asl.internal.speechengine.startup.FrameworkServices;
import de.vw.mib.asl.internal.speechengine.startup.SpeechComponentStarter;
import de.vw.mib.asl.internal.speechengine.teleprompter.TeleprompterManagerActivator;
import de.vw.mib.asl.internal.speechengine.teleprompter.TeleprompterManagerCallback;
import de.vw.mib.asl.internal.util.AbstractClassifiedLogger;

public class TeleprompterManagerHandler
extends SpeechComponentStarter {
    private SpeechConfiguratorFactory speechConfiguratorFactory = null;
    private final TeleprompterManagerCallback speechEngineStartup;

    TeleprompterManagerHandler(AbstractClassifiedLogger abstractClassifiedLogger, TeleprompterManagerCallback teleprompterManagerCallback, FrameworkServices frameworkServices, Services services) {
        super(abstractClassifiedLogger);
        this.speechEngineStartup = teleprompterManagerCallback;
    }

    private TeleprompterManagerActivator getTeleprompterManagerActivator() {
        return (TeleprompterManagerActivator)this.getActivatorViaReflection("de.vw.mib.asl.internal.speechengine.teleprompter.TeleprompterManagerStartup");
    }

    void update(SpeechConfiguratorFactory speechConfiguratorFactory) {
        this.speechConfiguratorFactory = speechConfiguratorFactory;
        this.serviceChanged();
    }

    private void serviceChanged() {
        if (this.speechConfiguratorFactory != null) {
            this.getTeleprompterManagerActivator().activate(this.speechEngineStartup, this.speechConfiguratorFactory);
        }
    }
}

