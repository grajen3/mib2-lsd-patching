/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event;

import de.vw.mib.event.Event;

public interface SpeechStateEvent
extends Event {
    public static final int SPEECH_ASL_NOT_READY;
    public static final int SPEECH_ASL_READY;

    default public int getState() {
    }
}

