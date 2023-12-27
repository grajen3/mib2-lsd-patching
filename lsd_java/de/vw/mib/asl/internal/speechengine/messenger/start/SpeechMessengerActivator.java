/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.messenger.start;

import de.vw.mib.asl.internal.speechengine.messenger.start.SpeechMessengerCallback;
import de.vw.mib.asl.internal.speechengine.messenger.start.SpeechMessengerParameters;

public interface SpeechMessengerActivator {
    public static final String SPEECH_ROUTER_ACTIVATOR;

    default public void activate(SpeechMessengerCallback speechMessengerCallback, SpeechMessengerParameters speechMessengerParameters) {
    }
}

