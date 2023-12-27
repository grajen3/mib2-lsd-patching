/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui.util.decoration.internal;

import de.vw.mib.graphics.Color4b;
import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.Dimension;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.drawable.offscreen.OffscreenDrawable;
import de.vw.mib.graphics.math.Util;
import de.vw.mib.graphics.math.function.convolution.FilterKernel;
import de.vw.mib.widgets.interfaces.DecoratableUI;
import de.vw.mib.widgets.ui.util.decoration.ConvolutionDecoration;
import de.vw.mib.widgets.ui.util.decoration.internal.AbstractDecoration;

public final class ConvolutionDecorationImpl
extends AbstractDecoration
implements ConvolutionDecoration {
    private static final int DEFAULT_KERNEL_TYPE;
    private static final boolean DEFAULT_GLOW_ENABLED;
    private static final int DEFAULT_KERNEL_WIDTH;
    private static final int DEFAULT_KERNEL_HEIGHT;
    private static final float DEFAULT_INTENSITY;
    private static final Color4f DEFAULT_GLOW_COLOR;
    private int filterType = 1;
    private int kernelWidth = 3;
    private int kernelHeight = 3;
    private float intensity = 1.0f;
    private float[] kernelHorizontal;
    private float[] kernelVertical;
    private boolean glowEnabled = false;
    private Color4f glowColor = DEFAULT_GLOW_COLOR;
    private OffscreenDrawable filterFirstTier;
    private OffscreenDrawable filterSecondTier;

    public ConvolutionDecorationImpl(AbstractDecoration abstractDecoration) {
        super(abstractDecoration);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    protected void createDecoration(Graphics3D graphics3D, DecoratableUI decoratableUI, Rectangle rectangle, Rectangle rectangle2, OffscreenDrawable offscreenDrawable, OffscreenDrawable offscreenDrawable2) {
        int n = offscreenDrawable != null ? offscreenDrawable.getWidth() + this.kernelWidth : rectangle.getWidth() + this.kernelWidth;
        int n2 = offscreenDrawable != null ? offscreenDrawable.getHeight() + this.kernelHeight : rectangle.getHeight() + this.kernelHeight;
        this.filterFirstTier = ConvolutionDecorationImpl.createOrUpdateDrawable(graphics3D, this.filterFirstTier, n, n2);
        if (this.kernelWidth > 0) {
            this.filterFirstTier.setFilterParams(this.getKernelHorizontal(), this.kernelWidth, 1, this.glowEnabled, this.glowColor);
        } else if (this.kernelHeight > 0) {
            this.filterFirstTier.setFilterParams(this.getKernelVertical(), 1, this.kernelHeight, this.glowEnabled, this.glowColor);
        }
        this.filterFirstTier.prepareGraphics(graphics3D, rectangle, 0);
        try {
            graphics3D.translateMatrix(0, ConvolutionDecorationImpl.bisectCeil(this.kernelWidth), ConvolutionDecorationImpl.bisectCeil(this.kernelHeight), 0.0f);
            if (offscreenDrawable != null) {
                offscreenDrawable.draw();
            } else {
                rectangle.translate(this.filterFirstTier.getWidth() - rectangle.width >> 1, this.filterFirstTier.getHeight() - rectangle.height >> 1);
                graphics3D.setBlendingEnabled(true);
                decoratableUI.drawDecoratableContent(graphics3D, rectangle2, rectangle);
                graphics3D.setBlendingEnabled(false);
            }
        }
        finally {
            this.filterFirstTier.restoreGraphics(graphics3D, rectangle);
        }
        if (this.kernelHeight > 0) {
            this.filterSecondTier = ConvolutionDecorationImpl.createOrUpdateDrawable(graphics3D, this.filterSecondTier, n, n2);
            this.filterSecondTier.setFilterParams(this.getKernelVertical(), 1, this.kernelHeight, this.glowEnabled, this.glowColor);
            this.filterSecondTier.prepareGraphics(graphics3D, rectangle, 0);
            try {
                this.filterFirstTier.draw();
            }
            finally {
                this.filterSecondTier.restoreGraphics(graphics3D, rectangle);
            }
            offscreenDrawable2.prepareGraphics(graphics3D, rectangle, 0);
            this.filterSecondTier.draw((float)(offscreenDrawable2.getWidth() - n) / 2.0f, (float)(offscreenDrawable2.getHeight() - n2) / 2.0f);
            offscreenDrawable2.restoreGraphics(graphics3D, rectangle);
        } else {
            offscreenDrawable2.prepareGraphics(graphics3D, rectangle, 0);
            this.filterFirstTier.draw((float)(offscreenDrawable2.getWidth() - n) / 2.0f, (float)(offscreenDrawable2.getHeight() - n2) / 2.0f);
            offscreenDrawable2.restoreGraphics(graphics3D, rectangle);
        }
    }

    @Override
    public void resize(Dimension dimension) {
        if (this.glowEnabled) {
            dimension.width += this.kernelWidth;
            dimension.height += this.kernelHeight;
        }
    }

    @Override
    public void dispose() {
        super.dispose();
        if (this.filterFirstTier != null) {
            this.filterFirstTier.dispose();
            this.filterFirstTier = null;
        }
        if (this.filterSecondTier != null) {
            this.filterSecondTier.dispose();
            this.filterSecondTier = null;
        }
    }

    @Override
    public void setFilterSize(int n, int n2) {
        if (this.kernelWidth != n || this.kernelHeight != n2) {
            this.kernelWidth = n;
            this.kernelHeight = n2;
            this.resetKernel();
            this.invalidateNext();
        }
    }

    @Override
    public void setGlowColor(Color4b color4b) {
        this.setGlowColor(new Color4f(color4b.getRGBA()));
    }

    public void setGlowColor(Color4f color4f) {
        if (this.glowColor == null || !this.glowColor.equals(color4f)) {
            this.glowColor = color4f;
            this.invalidateNext();
        }
    }

    @Override
    public void setIntensity(float f2) {
        if (!Util.equalsEpsilon(f2, this.intensity)) {
            this.intensity = f2;
            this.resetKernel();
            this.invalidateNext();
        }
    }

    @Override
    public void setGlowEnabled(boolean bl) {
        if (this.glowEnabled != bl) {
            this.glowEnabled = bl;
            this.invalidateNext();
        }
    }

    @Override
    public void setFilterType(int n) {
        if (this.filterType != n) {
            this.filterType = n;
            this.resetKernel();
            this.invalidateNext();
        }
    }

    private void resetKernel() {
        this.kernelHorizontal = null;
        this.kernelVertical = null;
    }

    private static float calculateSigma(int n, int n2) {
        int n3 = (Math.max(n, n2) >> 1) + 1;
        return (float)Math.sqrt((float)(n3 * n3) / -1056662976);
    }

    private float[] getKernelHorizontal() {
        if (this.kernelHorizontal == null) {
            this.kernelHorizontal = ConvolutionDecorationImpl.calculateKernel(this.filterType, this.kernelWidth, 1, this.intensity);
        }
        return this.kernelHorizontal;
    }

    private float[] getKernelVertical() {
        if (this.kernelVertical == null) {
            this.kernelVertical = ConvolutionDecorationImpl.calculateKernel(this.filterType, 1, this.kernelHeight, 1.0f);
        }
        return this.kernelVertical;
    }

    private static float[] calculateKernel(int n, int n2, int n3, float f2) {
        switch (n) {
            case 1: {
                float f3 = ConvolutionDecorationImpl.calculateSigma(n2, n3);
                if (n2 == 1 || n3 == 1) {
                    return FilterKernel.createGaussKernel1D(Math.max(n2, n3), f3, f2);
                }
                return FilterKernel.createGaussKernel2D(n2, n3, f3 * f3, f2);
            }
        }
        return FilterKernel.createBoxKernel2D(n2, n3, f2);
    }

    static {
        DEFAULT_GLOW_COLOR = Color4f.WHITE;
    }
}

