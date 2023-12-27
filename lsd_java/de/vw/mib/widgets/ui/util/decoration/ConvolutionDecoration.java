/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui.util.decoration;

import de.vw.mib.graphics.Color4b;
import de.vw.mib.widgets.ui.util.decoration.Decoration;

public interface ConvolutionDecoration
extends Decoration {
    public static final int FILTER_TYPE_BLUR_BOX;
    public static final int FILTER_TYPE_BLUR_GAUSSIAN;

    default public void setFilterType(int n) {
    }

    default public void setFilterSize(int n, int n2) {
    }

    default public void setGlowColor(Color4b color4b) {
    }

    default public void setIntensity(float f2) {
    }

    default public void setGlowEnabled(boolean bl) {
    }
}

