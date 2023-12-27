/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.audio.start;

import de.vw.mib.asl.internal.speechengine.audio.start.AudioProviderParameters;

public interface AudioProviderActivator {
    public static final String AUDIO_PROVIDER_ACTIVATOR;

    default public void activate(AudioProviderParameters audioProviderParameters) {
    }
}

