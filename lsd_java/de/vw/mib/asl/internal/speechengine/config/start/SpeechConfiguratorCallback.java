/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.config.start;

import de.vw.mib.asl.internal.speechengine.config.SpeechConfiguratorFactory;

public interface SpeechConfiguratorCallback {
    default public void onSpeechConfigurationReady(SpeechConfiguratorFactory speechConfiguratorFactory) {
    }
}

