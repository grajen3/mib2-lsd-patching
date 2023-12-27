/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.models;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.graphics.Color;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.widgets.models.ContainerModel;
import de.vw.mib.widgets.models.StaticImageModel;

public interface AbstractButtonModel
extends ContainerModel {
    public static final int PID_BASE;
    public static final int PID_INTERACTIVE;
    public static final int PID_SELECTED;
    public static final int PID_IMAGES_BACKGROUND;
    public static final int PID_COLORS_BACKGROUND;
    public static final int PID_IMAGE_BACKGROUND_REF;
    public static final int PID_IMAGES_FOREGROUND;
    public static final int PID_COLORS_FOREGROUND;
    public static final int PID_IMAGE_FOREGROUND_REF;
    public static final int PID_STATE;
    public static final int PID_SPEAKABLE;
    public static final int PID_GLOW_COLORS;
    public static final int PID_EASING_STATES;
    public static final int PID_COUNT_ABSTRACT_BUTTON;
    public static final int VISUAL_STATE_DISABLED_NONINTERACTIVE_DEACTIVATED;
    public static final int VISUAL_STATE_DISABLED_NONINTERACTIVE_ACTIVATED;
    public static final int VISUAL_STATE_DISABLED_INTERACTIVE_DEACTIVATED;
    public static final int VISUAL_STATE_DISABLED_INTERACTIVE_ACTIVATED;
    public static final int VISUAL_STATE_ENABLED_NONINTERACTIVE_DEACTIVATED;
    public static final int VISUAL_STATE_ENABLED_NONINTERACTIVE_ACTIVATED;
    public static final int VISUAL_STATE_ENABLED_INTERACTIVE_DEACTIVATED_DESELECTED_RELEASED;
    public static final int VISUAL_STATE_ENABLED_INTERACTIVE_DEACTIVATED_DESELECTED_PRESSED;
    public static final int VISUAL_STATE_ENABLED_INTERACTIVE_DEACTIVATED_SELECTED_RELEASED;
    public static final int VISUAL_STATE_ENABLED_INTERACTIVE_DEACTIVATED_SELECTED_PRESSED;
    public static final int VISUAL_STATE_ENABLED_INTERACTIVE_ACTIVATED_DESELECTED_RELEASED;
    public static final int VISUAL_STATE_ENABLED_INTERACTIVE_ACTIVATED_DESELECTED_PRESSED;
    public static final int VISUAL_STATE_ENABLED_INTERACTIVE_ACTIVATED_SELECTED_RELEASED;
    public static final int VISUAL_STATE_ENABLED_INTERACTIVE_ACTIVATED_SELECTED_PRESSED;
    public static final int VISUAL_STATE_ENABLED_INTERACTIVE_DEACTIVATED_DESELECTED_RELEASED_SPEAKABLE;
    public static final int VISUAL_STATE_ENABLED_INTERACTIVE_DEACTIVATED_SELECTED_RELEASED_SPEAKABLE;
    public static final int VISUAL_STATE_ENABLED_INTERACTIVE_ACTIVATED_DESELECTED_RELEASED_SPEAKABLE;
    public static final int VISUAL_STATE_ENABLED_INTERACTIVE_ACTIVATED_SELECTED_RELEASED_SPEAKABLE;
    public static final int VISUAL_STATE_COUNT;
    public static final int EASING_INDEX_BASE;
    public static final int EASING_INDEX_COUNT_ABSTRACT_BUTTON;
    public static final int SID_BASE;
    public static final int SID_INTERACTIVE;
    public static final int SID_PRESSED;
    public static final int SID_SELECTED;
    public static final int SID_SPEAKABLE;
    public static final int SID_COUNT_ABSTRACT_BUTTON;

    default public boolean is_interactive() {
    }

    default public void set_interactive(boolean bl) {
    }

    default public boolean isPressed() {
    }

    default public void setPressed(boolean bl) {
    }

    default public boolean is_selected() {
    }

    default public void set_selected(boolean bl) {
    }

    default public Image[] get_imagesBackground() {
    }

    default public void set_imagesBackground(Image[] imageArray) {
    }

    default public Color[] get_colorsBackground() {
    }

    default public void set_colorsBackground(Color[] colorArray) {
    }

    default public StaticImageModel get_imageBackgroundRef() {
    }

    default public void set_imageBackgroundRef(StaticImageModel staticImageModel) {
    }

    default public Image[] get_imagesForeground() {
    }

    default public void set_imagesForeground(Image[] imageArray) {
    }

    default public Color[] get_colorsForeground() {
    }

    default public void set_colorsForeground(Color[] colorArray) {
    }

    default public StaticImageModel get_imageForegroundRef() {
    }

    default public void set_imageForegroundRef(StaticImageModel staticImageModel) {
    }

    default public int get_state() {
    }

    default public void set_state(int n) {
    }

    default public Color[] get_glowColors() {
    }

    default public void set_glowColors(Color[] colorArray) {
    }

    default public void setDelayedPressed() {
    }

    default public void setDelayedReleased() {
    }

    default public void set_easingStates(EasingParams[] easingParamsArray) {
    }

    default public EasingParams[] get_easingStates() {
    }

    default public boolean isActivatedInternal() {
    }

    default public void setActivatedInternal(boolean bl) {
    }
}

