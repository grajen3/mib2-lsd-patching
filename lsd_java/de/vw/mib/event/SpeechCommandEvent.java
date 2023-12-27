/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event;

import de.vw.mib.event.Event;

public interface SpeechCommandEvent
extends Event {
    public static final int ABORT;
    public static final int LISTSELECTIONBYPTT;
    public static final int PROMPTFINISHED;
    public static final int PROMPTSTARTED;
    public static final int RESUME_PAUSED_READOUT;
    public static final int PAUSE_READOUT;
    public static final int PROMPT_NOT_POSSIBLE;

    default public int getCommand() {
    }
}

