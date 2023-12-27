/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.config.start;

import de.vw.mib.asl.internal.speechengine.config.start.SpeechConfiguratorCallback;
import de.vw.mib.asl.internal.speechengine.config.start.SpeechConfiguratorParameters;
import de.vw.mib.asl.internal.util.AbstractClassifiedLogger;

public interface SpeechConfiguratorActivator {
    public static final String SPEECH_CONFIGURATOR_ACTIVATOR;

    default public void prewarm(AbstractClassifiedLogger abstractClassifiedLogger) {
    }

    default public void activate(SpeechConfiguratorCallback speechConfiguratorCallback, SpeechConfiguratorParameters speechConfiguratorParameters) {
    }
}

