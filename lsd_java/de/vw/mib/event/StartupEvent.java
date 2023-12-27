/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event;

import de.vw.mib.event.Event;

public interface StartupEvent
extends Event {
    public static final int START_GUI_SM;
    public static final int START_ENABLE_DPUPDATE;
    public static final int STARTUP_SKIN_READY;
    public static final int STARTUP_LUM_READY;
    public static final int START_EVENT_DISPATCHER;
    public static final int STARTUP_SPEECH_DSI_READY;
    public static final int STARTUP_SPEECH_BUNDLES_READY;
    public static final int STARTUP_SPEECH_UI_READY;
    public static final int STARTUP_GUI_READY;
    public static final int STARTUP_LATELOAD_FINISHED;
    public static final int START_APPS;
    public static final int STARTUP_DESKTOP_APP_READY;

    default public int getEventId() {
    }
}

