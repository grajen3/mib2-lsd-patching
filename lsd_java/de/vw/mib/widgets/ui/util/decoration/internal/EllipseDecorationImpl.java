/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui.util.decoration.internal;

import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.Dimension;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.drawable.offscreen.OffscreenDrawable;
import de.vw.mib.graphics.drawable.shape.EllipseDrawable;
import de.vw.mib.widgets.interfaces.DecoratableUI;
import de.vw.mib.widgets.ui.util.decoration.EllipseDecoration;
import de.vw.mib.widgets.ui.util.decoration.internal.AbstractDecoration;

public final class EllipseDecorationImpl
extends AbstractDecoration
implements EllipseDecoration {
    private static final float DEFAULT_ASPECT_RATIO;
    private static final float DEFAULT_RESIZE_FACTOR;
    private static final Color4f DEFAULT_COLOR;
    private float aspectRatio = 0x3333B33F;
    private float resizeFactor = 0x3333B33F;
    private EllipseDrawable ellipseDrawable;
    private Color4f color = DEFAULT_COLOR;

    public EllipseDecorationImpl(AbstractDecoration abstractDecoration) {
        super(abstractDecoration);
    }

    @Override
    public void setAspectRatio(float f2) {
        if (this.aspectRatio != f2) {
            this.aspectRatio = f2;
            this.invalidateNext();
        }
    }

    @Override
    public void setResizeFactor(float f2) {
        if (this.resizeFactor != f2) {
            this.resizeFactor = f2;
            this.invalidateNext();
        }
    }

    @Override
    public void setColor(Color4f color4f) {
        if (!this.color.equals(color4f)) {
            this.color = color4f;
            this.invalidateNext();
        }
    }

    @Override
    public void dispose() {
        super.dispose();
        this.ellipseDrawable.dispose();
        this.ellipseDrawable = null;
    }

    @Override
    protected void createDecoration(Graphics3D graphics3D, DecoratableUI decoratableUI, Rectangle rectangle, Rectangle rectangle2, OffscreenDrawable offscreenDrawable, OffscreenDrawable offscreenDrawable2) {
        this.updateEllipseDrawable(graphics3D, rectangle.width, rectangle.height);
        offscreenDrawable2.prepareGraphics(graphics3D, rectangle, 0);
        if (offscreenDrawable != null) {
            offscreenDrawable.draw();
        }
        this.ellipseDrawable.draw(offscreenDrawable2.getWidth() - this.ellipseDrawable.getWidth() >> 1, offscreenDrawable2.getHeight() - this.ellipseDrawable.getHeight() >> 1);
        offscreenDrawable2.restoreGraphics(graphics3D, rectangle);
    }

    @Override
    protected void resize(Dimension dimension) {
        dimension.width = (int)((float)dimension.width * this.resizeFactor);
        dimension.height = (int)((float)dimension.height * this.resizeFactor);
    }

    private void updateEllipseDrawable(Graphics3D graphics3D, int n, int n2) {
        int n3;
        int n4;
        if (this.ellipseDrawable == null) {
            this.ellipseDrawable = graphics3D.getDrawableManager().createEllipseDrawable();
        }
        if ((float)n / (float)n2 < this.aspectRatio) {
            n4 = (int)((float)n * this.resizeFactor);
            n3 = (int)((float)n4 / this.aspectRatio);
        } else {
            n3 = (int)((float)n2 * this.resizeFactor);
            n4 = (int)((float)n3 * this.aspectRatio);
        }
        this.ellipseDrawable.set(0, 0, n4, n3);
        this.ellipseDrawable.setColor(this.color);
        this.ellipseDrawable.setAlpha(1.0f);
    }

    static {
        DEFAULT_COLOR = Color4f.WHITE;
    }
}

