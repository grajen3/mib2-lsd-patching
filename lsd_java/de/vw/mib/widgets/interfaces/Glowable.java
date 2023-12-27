/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.interfaces;

import de.vw.mib.graphics.Color;

public interface Glowable {
    public static final int GLOW_DISABLED;
    public static final int GLOW_TYPE_1;
    public static final int GLOW_TYPE_2;
    public static final int GLOW_TYPE_3;
    public static final int GLOW_TYPE_4;
    public static final int GLOW_TYPE_5;

    default public int get_glowType() {
    }

    default public void set_glowType(int n) {
    }

    default public void set_glowColor(Color color) {
    }

    default public Color get_glowColor() {
    }

    default public boolean is_glowVisible() {
    }

    default public void set_glowVisible(boolean bl) {
    }

    default public float getGlowAlpha() {
    }
}

