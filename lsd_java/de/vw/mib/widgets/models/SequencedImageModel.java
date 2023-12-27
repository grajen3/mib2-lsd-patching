/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.models;

import de.vw.mib.graphics.image.Image;
import de.vw.mib.widgets.event.AdjustmentListener;
import de.vw.mib.widgets.interfaces.Adjustable;
import de.vw.mib.widgets.models.AbstractImageModel;

public interface SequencedImageModel
extends AbstractImageModel,
Adjustable,
AdjustmentListener {
    public static final int PID_BASE;
    public static final int PID_REPEAT;
    public static final int PID_SEQUENCE_IMAGES;
    public static final int PID_VALUE;
    public static final int PID_VALUE_MAX;
    public static final int PID_VALUE_MIN;
    public static final int PID_COUNT_SEQUENCED_IMAGE;
    public static final int EASING_INDEX_BASE;
    public static final int EASING_INDEX_SEQUENCE_ANIMATION;
    public static final int EASING_INDEX_VALUE_CHANGE;
    public static final int EASING_INDEX_VALUE_CHANGE_INCREMENTAL;
    public static final int EASING_INDEX_IMAGE_FADE_OUT;
    public static final int EASING_INDEX_IMAGE_FADE_IN;
    public static final int EASING_INDEX_COUNT_SEQUENCED_IMAGE;
    public static final int SID_BASE;
    public static final int SID_REPEAT;
    public static final int SID_COUNT_SEQUENCED_IMAGE;

    default public void set_repeat(boolean bl) {
    }

    default public boolean is_repeat() {
    }

    default public void set_sequenceImages(Image[] imageArray) {
    }

    default public Image[] get_sequenceImages() {
    }

    default public void set_value(int n) {
    }

    default public int get_value() {
    }

    default public void set_valueMax(int n) {
    }

    default public int get_valueMax() {
    }

    default public void set_valueMin(int n) {
    }

    default public int get_valueMin() {
    }

    default public int getActiveImageIndex() {
    }

    default public boolean isImagefadingActive() {
    }

    default public float[] getAlphas() {
    }
}

