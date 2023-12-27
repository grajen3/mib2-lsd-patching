/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.models;

import de.vw.mib.graphics.Color;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.widgets.models.ContainerModel;

public interface SpeechIndicatorModel
extends ContainerModel {
    public static final int PID_BASE;
    public static final int PID_INDICATOR_IMAGES;
    public static final int PID_RECOGNIZER_STATE;
    public static final int PID_REMAINING_RECOGNITION_TIME;
    public static final int PID_RECOGNIZER_ACTIVE_COLOR;
    public static final int PID_RECOGNIZER_INACTIVE_COLOR;
    public static final int PID_COUNT_SPEECHINDICATOR;
    public static final int EASING_INDEX_BASE;
    public static final int EASING_INDEX_COUNT_SPEECHINDICATOR;
    public static final int SID_BASE;
    public static final int SID_COUNT_SPEECHINDICATOR;
    public static final int RECOGNIZER_STATE_ON;
    public static final int RECOGNIZER_STATE_OFF;
    public static final int RECOGNIZER_STATE_PAUSE;
    public static final int RECOGNIZER_STATE_VOICE_OUT;
    public static final int RRCOGNIZER_STATE_BUSY;

    default public Image[] get_indicatorImages() {
    }

    default public void set_indicatorImages(Image[] imageArray) {
    }

    default public int get_recognizerState() {
    }

    default public void set_recognizerState(int n) {
    }

    default public int get_remainingRecognitionTime() {
    }

    default public void set_remainingRecognitionTime(int n) {
    }

    default public Color get_recognizerActiveColor() {
    }

    default public void set_recognizerActiveColor(Color color) {
    }

    default public Color get_recognizerInactiveColor() {
    }

    default public void set_recognizerInactiveColor(Color color) {
    }
}

