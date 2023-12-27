/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui;

import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.drawable.offscreen.OffscreenDrawable;

public final class AbstractWidgetUI$OffscreenDrawableHelper {
    private static final Color4f CLEAR_COLOR = Color4f.BLACK_TRANSPARENT;

    public static OffscreenDrawable createOffscreenDrawable(Graphics3D graphics3D, int n, int n2, boolean bl) {
        OffscreenDrawable offscreenDrawable = graphics3D.getDrawableManager().createOffscreenDrawable(n, n2, bl);
        return offscreenDrawable;
    }

    public static void disposeOffscreenDrawable(OffscreenDrawable offscreenDrawable) {
        if (offscreenDrawable != null) {
            offscreenDrawable.dispose();
        }
    }

    public static boolean isOffscreenDrawableValid(OffscreenDrawable offscreenDrawable, int n, int n2) {
        if (offscreenDrawable == null) {
            return false;
        }
        return offscreenDrawable.getWidth() == n && offscreenDrawable.getHeight() == n2 && offscreenDrawable.isValid();
    }

    public static void prepare(Graphics3D graphics3D, OffscreenDrawable offscreenDrawable, Rectangle rectangle) {
        offscreenDrawable.prepareGraphics(graphics3D, rectangle, 0, CLEAR_COLOR);
    }

    public static void restore(Graphics3D graphics3D, OffscreenDrawable offscreenDrawable, Rectangle rectangle) {
        offscreenDrawable.restoreGraphics(graphics3D, rectangle);
    }

    private AbstractWidgetUI$OffscreenDrawableHelper() {
    }
}

