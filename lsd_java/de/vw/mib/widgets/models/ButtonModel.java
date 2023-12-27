/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.models;

import de.vw.mib.graphics.Color;
import de.vw.mib.graphics.Point;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.widgets.models.AbstractButtonModel;
import de.vw.mib.widgets.models.StaticImageModel;
import de.vw.mib.widgets.models.TextAreaModel;

public interface ButtonModel
extends AbstractButtonModel {
    public static final int PID_BASE;
    public static final int PID_BUTTON_MODE;
    public static final int PID_IMAGES_STATE;
    public static final int PID_IMAGE_STATE_REF;
    public static final int PID_IMAGES_STATE_SECONDARY;
    public static final int PID_IMAGE_STATE_SECONDARY_REF;
    public static final int PID_IMAGE_STATE_COLORS;
    public static final int PID_START_TIME_PRIMARY;
    public static final int PID_REPEAT_TIME_PRIMARY;
    public static final int PID_START_TIME_SECONDARY;
    public static final int PID_TEXT_COLORS;
    public static final int PID_TEXT_GLOW_COLORS;
    public static final int PID_TEXT_AREA_REFS;
    public static final int PID_REPEAT_TIME_SECONDARY;
    public static final int PID_EVENT_SENDER;
    public static final int PID_SPEECH_ROLE_PUSH;
    public static final int PID_SPEECH_ROLE_LONG_PUSH;
    public static final int PID_VERTICES;
    public static final int PID_TEXT_AREA_NON_SPEAKABLE_REFS;
    public static final int PID_PREDICTIVE_ACTIVATION;
    public static final int PID_COUNT_BUTTON;
    public static final int EASING_INDEX_BASE;
    public static final int EASING_INDEX_COUNT_BUTTON;
    public static final int BUTTONMODE_DEFAULT;
    public static final int BUTTONMODE_REPEAT;
    public static final int BUTTONMODE_LONGPRESS;
    public static final int SPEECH_PROMPT_PUSH;
    public static final int SPEECH_PROMPT_PUSH_FAIL;
    public static final int SPEECH_PROMPT_LONGPUSH;
    public static final int SPEECH_PROMPT_LONGPUSH_FAIL;
    public static final int SPEECH_PROMPT_SPEAKOUT_PUSH;
    public static final int SPEECH_PROMPT_SPEAKOUT_LONGPUSH;
    public static final int SID_BASE;
    public static final int SID_PREDICTIVE_ACTIVATION;
    public static final int SID_ACTIVATED_INTERNAL;
    public static final int SID_COUNT_BUTTON;
    public static final int MIN_VERTICES_COUNT;

    default public Color[] get_textColors() {
    }

    default public void set_textColors(Color[] colorArray) {
    }

    default public Color[] get_textGlowColors() {
    }

    default public void set_textGlowColors(Color[] colorArray) {
    }

    default public void set_textAreaRefs(TextAreaModel[] textAreaModelArray) {
    }

    default public TextAreaModel[] get_textAreaRefs() {
    }

    default public void set_textAreaNonSpeakableRefs(TextAreaModel[] textAreaModelArray) {
    }

    default public TextAreaModel[] get_textAreaNonSpeakableRefs() {
    }

    default public int get_buttonMode() {
    }

    default public void set_buttonMode(int n) {
    }

    default public Image[] get_imagesState() {
    }

    default public void set_imagesState(Image[] imageArray) {
    }

    default public Image[] get_imagesStateSecondary() {
    }

    default public void set_imagesStateSecondary(Image[] imageArray) {
    }

    default public StaticImageModel get_imageStateRef() {
    }

    default public void set_imageStateRef(StaticImageModel staticImageModel) {
    }

    default public StaticImageModel get_imageStateSecondaryRef() {
    }

    default public void set_imageStateSecondaryRef(StaticImageModel staticImageModel) {
    }

    default public void set_imageStateColors(Color[] colorArray) {
    }

    default public Color[] get_imageStateColors() {
    }

    default public int get_startTimePrimary() {
    }

    default public void set_startTimePrimary(int n) {
    }

    default public int get_repeatTimePrimary() {
    }

    default public void set_repeatTimePrimary(int n) {
    }

    default public int get_startTimeSecondary() {
    }

    default public void set_startTimeSecondary(int n) {
    }

    default public int get_repeatTimeSecondary() {
    }

    default public void set_repeatTimeSecondary(int n) {
    }

    default public void set_eventSender(String string) {
    }

    default public String get_eventSender() {
    }

    default public Point[] get_vertices() {
    }

    default public void set_vertices(Point[] pointArray) {
    }

    default public boolean is_predictiveActivation() {
    }

    default public void set_predictiveActivation(boolean bl) {
    }

    default public boolean hasVertices() {
    }

    default public boolean isTimerChanged() {
    }

    default public void setTimerChanged(boolean bl) {
    }
}

