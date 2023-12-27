/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.models;

import de.vw.mib.graphics.math.algebra.Rotation;
import de.vw.mib.widgets.models.WidgetModel;

public interface MeshWidgetModel
extends WidgetModel {
    public static final int PID_BASE;
    public static final int PID_MODEL;
    public static final int PID_COUNT_MESH_WIDGET;
    public static final int EASING_INDEX_BASE;
    public static final int EASING_INDEX_COUNT_MESHWIDGET;
    public static final int SID_BASE;
    public static final int SID_COUNT_MESH_WIDGET;
    public static final int ANIMATION_MODE_ROTATE_LEFT;
    public static final int ANIMATION_MODE_ROTATE_RIGHT;
    public static final int ANIMATION_MODE_MANUAL;
    public static final int ANIMATION_MODE_AUTO;

    default public void set_model(String string) {
    }

    default public String get_model() {
    }

    default public int getAnimationMode() {
    }

    default public void setAnimationMode(int n) {
    }

    default public float getAnimatedValue() {
    }

    default public void setAnimatedValue(float f2) {
    }

    default public Rotation getRotationStart() {
    }

    default public void setRotationStart(Rotation rotation) {
    }

    default public Rotation getRotationEnd() {
    }

    default public void setRotationEnd(Rotation rotation) {
    }

    default public Rotation getRotationCurrent() {
    }

    default public void setRotationCurrent(Rotation rotation) {
    }

    default public float getZoom() {
    }

    default public void setZoom(float f2) {
    }
}

