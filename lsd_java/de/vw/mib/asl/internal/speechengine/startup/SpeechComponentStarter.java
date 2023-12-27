/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.startup;

import de.vw.mib.asl.internal.util.AbstractClassifiedLogger;

abstract class SpeechComponentStarter {
    private final AbstractClassifiedLogger logger;

    SpeechComponentStarter(AbstractClassifiedLogger abstractClassifiedLogger) {
        this.logger = abstractClassifiedLogger;
    }

    protected Object getActivatorViaReflection(String string) {
        try {
            Class clazz = Class.forName(string);
            return clazz.newInstance();
        }
        catch (Exception exception) {
            this.logger.error().append(exception.getMessage()).log();
            return null;
        }
    }

    protected final AbstractClassifiedLogger getStartupLogger() {
        return this.logger;
    }
}

