/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui.util.decoration.internal;

import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.Dimension;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.drawable.offscreen.OffscreenDrawable;
import de.vw.mib.graphics.math.function.convolution.FilterKernel;
import de.vw.mib.widgets.interfaces.DecoratableUI;
import de.vw.mib.widgets.ui.util.decoration.OutlineDecoration;
import de.vw.mib.widgets.ui.util.decoration.internal.AbstractDecoration;

public final class OutlineDecorationImpl
extends AbstractDecoration
implements OutlineDecoration {
    private static final int DEFAULT_OUTLINE_SIZE;
    private static final Color4f DEFAULT_OUTLINE_COLOR;
    private static final float DEFAULT_INTENSITY;
    private int outlineSize = 3;
    private Color4f outlineColor = DEFAULT_OUTLINE_COLOR;
    private float[] kernel;
    private OffscreenDrawable outlineDrawable;

    public OutlineDecorationImpl(AbstractDecoration abstractDecoration) {
        super(abstractDecoration);
    }

    @Override
    protected void createDecoration(Graphics3D graphics3D, DecoratableUI decoratableUI, Rectangle rectangle, Rectangle rectangle2, OffscreenDrawable offscreenDrawable, OffscreenDrawable offscreenDrawable2) {
        this.outlineDrawable = OutlineDecorationImpl.createOrUpdateDrawable(graphics3D, this.outlineDrawable, offscreenDrawable2.getWidth(), offscreenDrawable2.getHeight());
        if (this.outlineColor != null) {
            this.outlineDrawable.setFilterParams(this.getKernel(), this.outlineSize, this.outlineSize, true, this.outlineColor);
        } else {
            this.outlineDrawable.setFilterParams(this.getKernel(), this.outlineSize, this.outlineSize, false, Color4f.WHITE);
        }
        this.outlineDrawable.prepareGraphics(graphics3D, rectangle, 0);
        graphics3D.translateMatrix(0, OutlineDecorationImpl.bisectCeil(offscreenDrawable2.getWidth() - rectangle.getWidth()), OutlineDecorationImpl.bisectCeil(offscreenDrawable2.getHeight() - rectangle.getHeight()), 0.0f);
        decoratableUI.drawDecoratableContent(graphics3D, rectangle2, rectangle);
        this.outlineDrawable.restoreGraphics(graphics3D, rectangle);
        offscreenDrawable2.prepareGraphics(graphics3D, rectangle, 0);
        if (offscreenDrawable != null) {
            offscreenDrawable.draw();
        } else {
            decoratableUI.drawDecoratableContent(graphics3D, rectangle2, rectangle);
        }
        graphics3D.setBlendingEnabled(true);
        if (this.outlineColor != null) {
            this.outlineDrawable.draw();
        } else {
            int n = graphics3D.getBlendFactorSourceRGB();
            int n2 = graphics3D.getBlendFactorDestinationRGB();
            int n3 = graphics3D.getBlendFactorSourceAlpha();
            int n4 = graphics3D.getBlendFactorDestinationAlpha();
            int n5 = graphics3D.getBlendEquationRGB();
            int n6 = graphics3D.getBlendEquationAlpha();
            graphics3D.setBlendFactorsSeparate(0, 1, 1, 1);
            graphics3D.setBlendEquationSeparate(2, 2);
            this.outlineDrawable.draw();
            graphics3D.setBlendEquationSeparate(n5, n6);
            graphics3D.setBlendFactorsSeparate(n, n2, n3, n4);
        }
        graphics3D.setBlendingEnabled(false);
        offscreenDrawable2.restoreGraphics(graphics3D, rectangle);
    }

    public float[] getKernel() {
        if (this.kernel == null) {
            this.kernel = FilterKernel.createBoxKernel2D(this.outlineSize, this.outlineSize, 65);
        }
        return this.kernel;
    }

    @Override
    public void setOutlineSize(int n) {
        if (this.outlineSize != n) {
            this.outlineSize = n;
            this.kernel = null;
            this.invalidateNext();
        }
    }

    @Override
    public void setOutlineColor(Color4f color4f) {
        if (!(this.outlineColor == color4f || this.outlineColor != null && this.outlineColor.equals(color4f))) {
            this.outlineColor = color4f;
            this.invalidateNext();
        }
    }

    @Override
    public void resize(Dimension dimension) {
    }

    @Override
    public void dispose() {
        super.dispose();
        if (this.outlineDrawable != null) {
            this.outlineDrawable.dispose();
            this.outlineDrawable = null;
        }
    }

    static {
        DEFAULT_OUTLINE_COLOR = null;
    }
}

