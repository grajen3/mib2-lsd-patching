/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.models;

import de.vw.mib.graphics.Color;
import de.vw.mib.widgets.models.WidgetModel;

public interface AbstractImageModel
extends WidgetModel {
    public static final int PID_BASE;
    public static final int PID_BLEND_MODE;
    public static final int PID_COLOR;
    public static final int PID_BLEND_COLOR;
    public static final int PID_COLOR_ENABLED;
    public static final int PID_COUNT_ABSTRACT_IMAGE;
    public static final int EASING_INDEX_BASE;
    public static final int EASING_INDEX_COUNT_ABSTRACT_IMAGE;
    public static final int SID_BASE;
    public static final int SID_COUNT_ABSTRACT_IMAGE;
    public static final int BLEND_MODE_MODULATE;
    public static final int BLEND_MODE_REPLACE;
    public static final int BLEND_MODE_DECAL;
    public static final int BLEND_MODE_BLEND;
    public static final int BLEND_MODE_ADD;
    public static final int BLEND_MODE_DEFAULT;

    default public int get_blendMode() {
    }

    default public void set_blendMode(int n) {
    }

    default public Color get_color() {
    }

    default public void set_color(Color color) {
    }

    default public Color get_blendColor() {
    }

    default public void set_blendColor(Color color) {
    }

    default public boolean is_colorEnabled() {
    }

    default public void set_colorEnabled(boolean bl) {
    }
}

