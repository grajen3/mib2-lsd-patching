/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.teleprompter;

import de.vw.mib.asl.internal.speechengine.config.SpeechConfiguratorFactory;
import de.vw.mib.asl.internal.speechengine.teleprompter.TeleprompterManagerCallback;

public interface TeleprompterManagerActivator {
    public static final String TELEPROMPTER_MANAGER_ACTIVATOR;

    default public void activate(TeleprompterManagerCallback teleprompterManagerCallback, SpeechConfiguratorFactory speechConfiguratorFactory) {
    }
}

