/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.models;

import de.vw.mib.graphics.Color;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.widgets.models.AbstractSliderModel;
import de.vw.mib.widgets.models.StaticImageModel;

public interface SliderModel
extends AbstractSliderModel {
    public static final int PID_BASE;
    public static final int PID_IMAGES_SLIDER;
    public static final int PID_COLORS_SLIDER;
    public static final int PID_IMAGE_SLIDER_REF;
    public static final int PID_IMAGES_PROGRESS;
    public static final int PID_COLORS_PROGRESS;
    public static final int PID_IMAGE_PROGRESS_REF;
    public static final int PID_IMAGE_PROGRESS_INDICATOR_REFS;
    public static final int PID_IMAGES_PROGRESS_INDICATOR_ACTIVE;
    public static final int PID_IMAGES_PROGRESS_INDICATOR_PASSIVE;
    public static final int PID_IMAGE_SLIDER_VALUE_POINT_X;
    public static final int PID_IMAGE_SLIDER_VALUE_POINT_Y;
    public static final int PID_PROGRESS_MODE;
    public static final int PID_VALUE_CHANGE_ONLY_ON_RELEASE;
    public static final int PID_VALUE_CHANGE_INSTANTLY;
    public static final int PID_FIRE_EVENT_TIMER;
    public static final int PID_COUNT_SLIDER;
    public static final int EASING_INDEX_BASE;
    public static final int EASING_INDEX_SLIDING_ANIMATION;
    public static final int EASING_INDEX_PROGRESS_ANIMATION;
    public static final int EASING_INDEX_COUNT_SLIDER;
    public static final int SID_BASE;
    public static final int SID_PROGRESS_MODE;
    public static final int SID_VALUE_CHANGE_ONLY_ON_RELEASE;
    public static final int SID_COUNT_SLIDER;

    default public Image[] get_imagesSlider() {
    }

    default public void set_imagesSlider(Image[] imageArray) {
    }

    default public Color[] get_colorsSlider() {
    }

    default public void set_colorsSlider(Color[] colorArray) {
    }

    default public StaticImageModel get_imageSliderRef() {
    }

    default public void set_imageSliderRef(StaticImageModel staticImageModel) {
    }

    default public Image[] get_imagesProgress() {
    }

    default public void set_imagesProgress(Image[] imageArray) {
    }

    default public Color[] get_colorsProgress() {
    }

    default public void set_colorsProgress(Color[] colorArray) {
    }

    default public StaticImageModel get_imageProgressRef() {
    }

    default public void set_imageProgressRef(StaticImageModel staticImageModel) {
    }

    default public StaticImageModel[] get_imageProgressIndicatorRefs() {
    }

    default public void set_imageProgressIndicatorRefs(StaticImageModel[] staticImageModelArray) {
    }

    default public Image[] get_imagesProgressIndicatorActive() {
    }

    default public void set_imagesProgressIndicatorActive(Image[] imageArray) {
    }

    default public Image[] get_imagesProgressIndicatorPassive() {
    }

    default public void set_imagesProgressIndicatorPassive(Image[] imageArray) {
    }

    default public void updateProgressImageGeometry() {
    }

    default public int get_imageSliderValuePointX() {
    }

    default public void set_imageSliderValuePointX(int n) {
    }

    default public int get_fireEventTimer() {
    }

    default public void set_fireEventTimer(int n) {
    }

    default public int get_imageSliderValuePointY() {
    }

    default public void set_imageSliderValuePointY(int n) {
    }

    default public boolean is_progressMode() {
    }

    default public void set_progressMode(boolean bl) {
    }

    default public boolean is_valueChangeOnlyOnRelease() {
    }

    default public void set_valueChangeOnlyOnRelease(boolean bl) {
    }

    default public boolean is_valueChangeInstantly() {
    }

    default public void set_valueChangeInstantly(boolean bl) {
    }
}

