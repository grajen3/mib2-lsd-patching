/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.messenger.start;

import de.vw.mib.asl.internal.speechengine.messenger.start.SpeechMessengerServices;

public interface SpeechMessengerCallback {
    default public void onRouterReady(SpeechMessengerServices speechMessengerServices) {
    }
}

