/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.audio;

import de.vw.mib.asl.internal.speechengine.audio.AudioConnectionProviderImpl;
import de.vw.mib.asl.internal.speechengine.audio.AudioManagementAdapterTarget;
import de.vw.mib.asl.internal.speechengine.audio.start.AudioProviderActivator;
import de.vw.mib.asl.internal.speechengine.audio.start.AudioProviderParameters;
import de.vw.mib.log4mib.Logger;

public class AudioProviderActivatorImpl
implements AudioProviderActivator {
    @Override
    public void activate(AudioProviderParameters audioProviderParameters) {
        AudioManagementAdapterTarget audioManagementAdapterTarget = null;
        try {
            audioManagementAdapterTarget = new AudioManagementAdapterTarget(audioProviderParameters);
            AudioConnectionProviderImpl audioConnectionProviderImpl = new AudioConnectionProviderImpl(audioProviderParameters, audioManagementAdapterTarget);
            audioProviderParameters.getSpeechEngineStarter().onAudioProviderReady(audioConnectionProviderImpl);
        }
        catch (Exception exception) {
            Logger logger = audioProviderParameters.getLogger();
            logger.fatal(2048, "AudioConnectionProvider could not be created! ", exception);
        }
    }
}

