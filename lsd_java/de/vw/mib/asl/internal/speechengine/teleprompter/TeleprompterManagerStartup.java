/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.teleprompter;

import de.vw.mib.asl.internal.speechengine.config.SpeechConfiguratorFactory;
import de.vw.mib.asl.internal.speechengine.teleprompter.TeleprompterManagerActivator;
import de.vw.mib.asl.internal.speechengine.teleprompter.TeleprompterManagerCallback;
import de.vw.mib.asl.internal.speechengine.teleprompter.TeleprompterManagerImpl;

public class TeleprompterManagerStartup
implements TeleprompterManagerActivator {
    @Override
    public void activate(TeleprompterManagerCallback teleprompterManagerCallback, SpeechConfiguratorFactory speechConfiguratorFactory) {
        teleprompterManagerCallback.onTeleprompterManagerReady(new TeleprompterManagerImpl(speechConfiguratorFactory));
    }
}

