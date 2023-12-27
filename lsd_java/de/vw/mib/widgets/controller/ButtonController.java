/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.widgets.controller.WidgetController;

public interface ButtonController
extends WidgetController {
    public static final int SPEECH_COMMAND_PUSH;
    public static final int SPEECH_COMMAND_LONGPUSH;
    public static final int SPEECH_PROMPT_PUSH;
    public static final int SPEECH_PROMPT_PUSH_FAIL;
    public static final int SPEECH_PROMPT_LONGPUSH;
    public static final int SPEECH_PROMPT_LONGPUSH_FAIL;
    public static final String IN_PRESS_NAME;
    public static final String IN_RELEASE_NAME;
    public static final String OUT_PRESSED_NAME;
    public static final String OUT_RELEASED_NAME;
    public static final String OUT_CANCELLED_NAME;

    default public void fire_press() {
    }

    default public void fire_release() {
    }

    default public void fire_pressed() {
    }

    default public void fire_released() {
    }

    default public void fire_cancelled() {
    }
}

