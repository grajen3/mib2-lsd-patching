/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl;

import de.vw.mib.graphics.Dimension;

public interface ASLDisplayManagerTarget {
    public static final int SCALE_MODE_ASPECT_RATIO;
    public static final int SCALE_MODE_FIT_HORIZONTAL;
    public static final int SCALE_MODE_FIT_VERTICAL;
    public static final int SCALE_MODE_CLIP_TOP_LEFT;
    public static final int SCALE_MODE_CLIP_MIDDLE;

    default public void setOpacity(int n, int n2, int n3) {
    }

    default public Dimension getExtents(int n) {
    }

    default public void setPosition(int n, int n2, int n3, int n4) {
    }

    default public void beginDisplayContextSwitch(int n) {
    }

    default public void endDisplayContextSwitch(int n) {
    }

    default public void enableDisplayable(int n, int n2) {
    }

    default public void disableDisplayable(int n, int n2) {
    }

    default public void setCropping(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10) {
    }

    default public void setDimension(int n, int n2, int n3, int n4) {
    }

    default public void setScaleMode(int n, int n2, int n3) {
    }
}

