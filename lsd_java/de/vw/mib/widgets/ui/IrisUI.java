/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui;

import de.vw.mib.graphics.Color;
import de.vw.mib.graphics.Color4b;
import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.drawable.Drawable;
import de.vw.mib.graphics.drawable.image.ColorGradientDrawable;
import de.vw.mib.graphics.drawable.image.ScaleImageDrawable;
import de.vw.mib.graphics.drawable.offscreen.OffscreenDrawable;
import de.vw.mib.graphics.drawable.shape.CircleGraphDrawable;
import de.vw.mib.graphics.drawable.shape.CircularSectorDrawable;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.widgets.models.ContainerModel;
import de.vw.mib.widgets.models.IrisModel;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.ui.AbstractWidgetUI$OffscreenDrawableHelper;
import de.vw.mib.widgets.ui.ContainerUI;
import de.vw.mib.widgets.ui.IrisUI$ErrorLogHelper;
import java.io.IOException;

public final class IrisUI
extends ContainerUI {
    private static final int SEGMENTS_IMAGE_COUNT;
    private static final int SEGMENTS_BACKGROUND_IMAGE_IDX;
    private static final int SEGMENTS_MAIN_IMAGE_IDX;
    private static final int SEGMENTS_FOREGROUND_IMAGE_IDX;
    private static final int SEGMENTS_BACKGROUND_DRAWABLE_IDX;
    private static final int SEGMENTS_FOREGROUND_DRAWABLE_IDX;
    private static final int GLOW_IMAGE_DRAWABLE_COUNT;
    private static final int GLOW_DRAWABLE_IMAGE_IDX;
    private static final int GLOW_DRAWABLE_ALPHA_IDX;
    private static final int VALUES_DRAWABLE_COUNT;
    private static final int VALUES_DRAWABLE_OFFSET_IDX;
    private static final int VALUES_DRAWABLE_NORMAL_IDX;
    private static final int ACCELERATION_INDICATOR_DRAWABLE_COUNT;
    private static final int ACCELERATION_INDICATOR_DRAWBALE_LEFT_IDX;
    private static final int ACCELERATION_INDICATOR_DRAWBALE_RIGHT_IDX;
    private static final boolean DEBUG_IRIS_MASKING;
    private static final Color4b COLOR_VALUES;
    private static final int CIRCULAR_SECTOR_SLICES;
    private static final float CIRCULAR_SECTOR_RADIUS;
    private static final boolean USE_OFFSCREEN_DRAWABLE;
    private static final boolean ANTI_ALIASING;
    private static final float ANTI_ALIASING_SCALE_X;
    private static final float ANTI_ALIASING_SCALE_Y;
    private static final int SCALE_CORRECTION;
    private static final boolean WITH_OFFSET;
    private static final int STENCIL_BUFFER_MASK_ON;
    private static final int STENCIL_BUFFER_MASK_OFF;
    private static final int STENCIL_BUFFER_CLEAR_VALUE;
    private static final int LOG_INDEX_ERROR_BACKGROUND;
    private static final int LOG_INDEX_ERROR_ACCELERATION_INDICATOR;
    private static final int LOG_INDEX_ERROR_SEGMENTS;
    private static final int LOG_INDEX_ERROR_GLOW;
    private static final int LOG_INDEX_COUNT;
    private static final int CIRCULAR_SECTOR_COLORS;
    private Rectangle drawingBounds;
    private CircleGraphDrawable[] valuesDrawables;
    private CircularSectorDrawable circularSectorDrawable;
    private ColorGradientDrawable[] indicatorColorGradientDrawables;
    private ColorGradientDrawable segmentsColorGradientDrawable;
    private ScaleImageDrawable[] glowImageDrawables;
    private ScaleImageDrawable[] segmentsImageDrawables;
    private ScaleImageDrawable backgroundDrawable;
    private OffscreenDrawable offscreenDrawable;
    private IrisUI$ErrorLogHelper errorHelper;

    @Override
    protected void reset() {
        super.reset();
        this.drawingBounds = new Rectangle();
    }

    @Override
    public void deInit() {
        this.disposeDrawableAndLog(this.backgroundDrawable, "background drawable");
        this.backgroundDrawable = null;
        this.disposeDrawableAndLog(this.circularSectorDrawable, "circular sector drawable");
        this.circularSectorDrawable = null;
        this.disposeDrawablesAndLog(this.glowImageDrawables, "glow drawable");
        this.glowImageDrawables = null;
        this.disposeDrawablesAndLog(this.indicatorColorGradientDrawables, "indicator drawable");
        this.indicatorColorGradientDrawables = null;
        this.disposeDrawableAndLog(this.offscreenDrawable, "Disposed offscreen texture");
        this.offscreenDrawable = null;
        this.disposeDrawableAndLog(this.segmentsColorGradientDrawable, "segments color gradient drawable");
        this.segmentsColorGradientDrawable = null;
        this.disposeDrawablesAndLog(this.segmentsImageDrawables, "segments drawable");
        this.segmentsImageDrawables = null;
        this.disposeDrawablesAndLog(this.valuesDrawables, "values drawable");
        this.valuesDrawables = null;
        this.errorHelper = null;
        super.deInit();
    }

    private void disposeDrawablesAndLog(Drawable[] drawableArray, String string) {
        if (drawableArray != null) {
            for (int i2 = drawableArray.length - 1; i2 >= 0; --i2) {
                this.disposeDrawableAndLog(drawableArray[i2], string);
            }
        }
    }

    private void disposeDrawableAndLog(Drawable drawable, String string) {
        if (drawable != null) {
            drawable.dispose();
            if (LOGGER.isTraceEnabled(128)) {
                LogMessage logMessage = LOGGER.trace(128);
                logMessage.append("Iris '").append(this.getWidget().getQualifiedName()).append("'': Disposed ").append(string).log();
            }
        }
    }

    @Override
    public void paintContent(Graphics3D graphics3D, ViewModel viewModel, ContainerModel containerModel, Rectangle rectangle, Rectangle rectangle2, float f2) {
        IrisModel irisModel = (IrisModel)containerModel;
        this.drawBackground(graphics3D, irisModel, f2);
        this.drawAccelerationIndicators(graphics3D, irisModel, f2);
        this.drawIrisSegments(graphics3D, irisModel, f2);
        this.drawCurrentSegmentGlow(graphics3D, irisModel, f2);
        super.paintContent(graphics3D, viewModel, containerModel, rectangle, rectangle2, f2);
        irisModel.setIrisSegmentsInvalid(false);
        irisModel.setActiveSegmentInvalid(false);
    }

    protected void drawBackground(Graphics3D graphics3D, IrisModel irisModel, float f2) {
        try {
            this.updateBackgroundDrawable(graphics3D, irisModel);
        }
        catch (IOException iOException) {
            this.logImageError(0, iOException.getLocalizedMessage(), irisModel);
            return;
        }
        if (this.backgroundDrawable != null) {
            this.backgroundDrawable.setAlpha(f2);
            this.backgroundDrawable.draw();
        }
    }

    private void drawIrisSegments(Graphics3D graphics3D, IrisModel irisModel, float f2) {
        try {
            this.updateSegmentsImageDrawables(graphics3D, irisModel);
            this.updateSegmentsColorGradientDrawable(graphics3D, irisModel);
        }
        catch (IOException iOException) {
            this.logImageError(2, iOException.getLocalizedMessage(), irisModel);
            return;
        }
        this.updateCircleGraphDrawables(graphics3D, irisModel);
        this.updateCircularSectorDrawable(graphics3D, irisModel);
        if (irisModel.getSegmentsRotation() != 0.0f) {
            this.drawIrisSegmentDrawablesRotated(graphics3D, irisModel, f2);
        } else {
            this.drawIrisSegmentDrawables(graphics3D, irisModel, f2);
        }
    }

    private void drawIrisSegmentDrawablesRotated(Graphics3D graphics3D, IrisModel irisModel, float f2) {
        graphics3D.pushMatrix(0);
        graphics3D.translateMatrix(0, irisModel.get_width() >> 1, irisModel.get_height() >> 1, 0.0f);
        graphics3D.rotateMatrix(0, irisModel.getSegmentsRotation(), 0.0f, 0.0f, 1.0f);
        graphics3D.translateMatrix(0, -(irisModel.get_width() >> 1), -(irisModel.get_height() >> 1), 0.0f);
        this.drawIrisSegmentDrawables(graphics3D, irisModel, f2);
        graphics3D.popMatrix(0);
    }

    private void drawIrisSegmentDrawables(Graphics3D graphics3D, IrisModel irisModel, float f2) {
        if (this.segmentsImageDrawables != null && this.segmentsImageDrawables[0] != null) {
            this.segmentsImageDrawables[0].draw();
        }
        this.drawIrisSegmentDrawablesOffscreen(graphics3D, irisModel, f2);
        if (this.segmentsImageDrawables != null && this.segmentsImageDrawables[1] != null) {
            this.segmentsImageDrawables[1].setAlpha(f2);
            this.segmentsImageDrawables[1].draw();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void drawIrisSegmentDrawablesOffscreen(Graphics3D graphics3D, IrisModel irisModel, float f2) {
        if (irisModel.areIrisSegmentsInvalid() || irisModel.isActiveSegmentInvalid() || this.offscreenDrawable == null || !this.offscreenDrawable.isValid()) {
            this.drawingBounds.width = Math.round((float)irisModel.get_width() * 2.0f);
            this.drawingBounds.height = Math.round((float)irisModel.get_height() * 49215);
            if (!AbstractWidgetUI$OffscreenDrawableHelper.isOffscreenDrawableValid(this.offscreenDrawable, this.drawingBounds.width, this.drawingBounds.height)) {
                AbstractWidgetUI$OffscreenDrawableHelper.disposeOffscreenDrawable(this.offscreenDrawable);
                this.offscreenDrawable = AbstractWidgetUI$OffscreenDrawableHelper.createOffscreenDrawable(graphics3D, this.drawingBounds.width, this.drawingBounds.height, false);
            }
            if (this.offscreenDrawable != null) {
                AbstractWidgetUI$OffscreenDrawableHelper.prepare(graphics3D, this.offscreenDrawable, this.drawingBounds);
            }
            try {
                graphics3D.pushMatrix(0);
                graphics3D.scaleMatrix(0, 2.0f, 49215, 1.0f);
                this.drawIrisSegmentsDrawableMain(graphics3D, irisModel, Color4f.WHITE, 1.0f);
                boolean bl = graphics3D.isBlendingEnabled();
                int n = graphics3D.getBlendFactorDestinationAlpha();
                int n2 = graphics3D.getBlendFactorDestinationRGB();
                int n3 = graphics3D.getBlendFactorSourceAlpha();
                int n4 = graphics3D.getBlendFactorSourceRGB();
                graphics3D.setBlendingEnabled(false);
                this.drawSegmentsValues(graphics3D, irisModel, true, Color4b.BLACK_TRANSPARENT);
                graphics3D.setBlendingEnabled(true);
                graphics3D.setBlendFactorsSeparate(0, 1, 8, 0);
                this.drawSegmentsValues(graphics3D, irisModel, false, COLOR_VALUES);
                this.drawCurrentIrisSegment(graphics3D, irisModel);
                graphics3D.setBlendFactorsSeparate(n4, n2, n3, n);
                graphics3D.setBlendingEnabled(bl);
                graphics3D.popMatrix(0);
            }
            finally {
                if (this.offscreenDrawable != null) {
                    AbstractWidgetUI$OffscreenDrawableHelper.restore(graphics3D, this.offscreenDrawable, this.drawingBounds);
                }
            }
        }
        if (this.offscreenDrawable != null) {
            graphics3D.pushMatrix(0);
            graphics3D.scaleMatrix(0, 63, -1414911425, 1.0f);
            this.offscreenDrawable.setAlpha(f2);
            this.offscreenDrawable.draw();
            graphics3D.popMatrix(0);
        }
    }

    private void drawIrisSegmentDrawablesStenciled(Graphics3D graphics3D, IrisModel irisModel, float f2) {
        graphics3D.setStencilBufferEnabled(1);
        graphics3D.clearStencilBuffer(0);
        graphics3D.setColorBufferEnabled(false, false, false, false);
        graphics3D.setStencilTestEnabled(true);
        graphics3D.setStencilTest(7, 1, 1);
        graphics3D.setStencilOperation(2, 2, 2);
        this.drawSegmentsValues(graphics3D, irisModel, false, Color4b.WHITE);
        graphics3D.setColorBufferEnabled(true, true, true, true);
        graphics3D.setStencilBufferEnabled(0);
        graphics3D.setStencilTest(6, 1, 1);
        this.drawCurrentIrisSegment(graphics3D, irisModel);
        this.drawIrisSegmentsDrawableMain(graphics3D, irisModel, Color4f.WHITE, 1.0f);
        this.drawCurrentIrisSegment(graphics3D, irisModel);
        graphics3D.setStencilTestEnabled(false);
    }

    private void drawCurrentIrisSegment(Graphics3D graphics3D, IrisModel irisModel) {
        int n = irisModel.getActiveSegmentChecked();
        float f2 = irisModel.getSpanAngleForOneSegment();
        int[] nArray = irisModel.get_irisRadii();
        Color[] colorArray = irisModel.get_irisColors();
        if (nArray == null || nArray.length < 2 || n == -1) {
            return;
        }
        boolean bl = graphics3D.isBlendingEnabled();
        int n2 = graphics3D.getBlendFactorDestinationAlpha();
        int n3 = graphics3D.getBlendFactorDestinationRGB();
        int n4 = graphics3D.getBlendFactorSourceAlpha();
        int n5 = graphics3D.getBlendFactorSourceRGB();
        if (irisModel.getScaledActiveSegmentSize() == 0.0f) {
            return;
        }
        graphics3D.setBlendingEnabled(false);
        float f3 = f2 * (float)(n + 1) - 63;
        float f4 = irisModel.getScaledActiveSegmentSize();
        this.drawCircularSector(graphics3D, irisModel, f3, f4, Color4b.BLACK_TRANSPARENT);
        graphics3D.setBlendingEnabled(true);
        graphics3D.setBlendFactorsSeparate(1, 0, 0, 1);
        for (int i2 = 0; i2 < 4; ++i2) {
            int n6 = 6 + i2;
            f3 = f2 * (float)(n + 1 + i2) - 63;
            f4 = nArray[1] + 2;
            Color4b color4b = colorArray.length > n6 ? colorArray[n6].getCurrentColor() : Color4b.WHITE;
            this.drawCircularSector(graphics3D, irisModel, f3, f4, color4b);
            if (n5 == graphics3D.getBlendFactorSourceRGB() && n3 == graphics3D.getBlendFactorDestinationRGB() && n4 == graphics3D.getBlendFactorSourceAlpha() && n2 == graphics3D.getBlendFactorDestinationAlpha()) continue;
            graphics3D.setBlendFactorsSeparate(n5, n3, n4, n2);
        }
        graphics3D.setBlendingEnabled(bl);
    }

    private void drawCircularSector(Graphics3D graphics3D, IrisModel irisModel, float f2, float f3, Color4b color4b) {
        graphics3D.pushMatrix(0);
        graphics3D.translateMatrix(0, irisModel.get_width() >> 1, irisModel.get_height() >> 1, 0.0f);
        graphics3D.rotateMatrix(0, f2, 0.0f, 0.0f, 1.0f);
        graphics3D.scaleMatrix(0, f3, f3, 1.0f);
        this.circularSectorDrawable.setColor(color4b);
        this.circularSectorDrawable.draw();
        graphics3D.popMatrix(0);
    }

    private void drawIrisSegmentsDrawableMain(Graphics3D graphics3D, IrisModel irisModel, Color4f color4f, float f2) {
        this.segmentsColorGradientDrawable.setColor(color4f);
        this.segmentsColorGradientDrawable.setAlpha(f2);
        this.segmentsColorGradientDrawable.setColorStart(irisModel.getStartColorSegment());
        this.segmentsColorGradientDrawable.setColorEnd(irisModel.getEndColorSegment());
        this.segmentsColorGradientDrawable.draw();
    }

    private void drawAccelerationIndicators(Graphics3D graphics3D, IrisModel irisModel, float f2) {
        try {
            this.updateAccelerationIndicatorDrawables(graphics3D, irisModel);
        }
        catch (IOException iOException) {
            this.logImageError(1, iOException.getLocalizedMessage(), irisModel);
            return;
        }
        if (this.indicatorColorGradientDrawables != null) {
            float f3 = irisModel.getIndicatorRotation();
            this.drawAccelerationIndicator(graphics3D, irisModel, this.indicatorColorGradientDrawables[0], f3, f2);
            this.drawAccelerationIndicator(graphics3D, irisModel, this.indicatorColorGradientDrawables[1], -f3, f2);
        }
    }

    private void drawAccelerationIndicator(Graphics3D graphics3D, IrisModel irisModel, ColorGradientDrawable colorGradientDrawable, float f2, float f3) {
        int n = colorGradientDrawable.getImage().getWidth();
        int n2 = colorGradientDrawable.getImage().getHeight();
        int n3 = n >> 1;
        int n4 = n2 >> 1;
        graphics3D.pushMatrix(0);
        graphics3D.translateMatrix(0, n3, n4, 0.0f);
        graphics3D.rotateMatrix(0, f2, 0.0f, 0.0f, 1.0f);
        graphics3D.translateMatrix(0, -n3, -n4, 0.0f);
        colorGradientDrawable.setColorStart(irisModel.getStartColorIndicator());
        colorGradientDrawable.setColorEnd(irisModel.getEndColorIndicator());
        colorGradientDrawable.draw();
        graphics3D.popMatrix(0);
    }

    private void drawSegmentsValues(Graphics3D graphics3D, IrisModel irisModel, boolean bl, Color4b color4b) {
        if (irisModel.areIrisSegmentsInvalid()) {
            float[] fArray = irisModel.getScaledValues();
            if (fArray == null) {
                return;
            }
            if (LOGGER.isTraceEnabled(128)) {
                LOGGER.trace(128).append("IrisUI '").append(this.getWidget().getQualifiedName()).append("': creating new mesh").log();
            }
            this.valuesDrawables[0].setSectorRadii(fArray);
            this.valuesDrawables[1].setSectorRadii(fArray);
            irisModel.setIrisSegmentsInvalid(false);
        }
        if (this.valuesDrawables[1].getSectorRadii() == null) {
            return;
        }
        graphics3D.pushMatrix(0);
        graphics3D.translateMatrix(0, irisModel.get_width() >> 1, irisModel.get_height() >> 1, 0.0f);
        graphics3D.scaleMatrix(0, 32959, 1.0f, 1.0f);
        try {
            if (bl) {
                this.valuesDrawables[0].setColor(color4b);
                this.valuesDrawables[0].draw();
            } else {
                this.valuesDrawables[1].setColor(color4b);
                this.valuesDrawables[1].draw();
            }
        }
        catch (Exception exception) {
            LOGGER.error(128).append(new StringBuffer().append(irisModel.getQualifiedName()).append(". Setting or Drawing of segments values has failed. ").append(exception.getMessage()).toString()).log();
        }
        graphics3D.popMatrix(0);
    }

    private void drawCurrentSegmentGlow(Graphics3D graphics3D, IrisModel irisModel, float f2) {
        if (irisModel.getGlowVisible()) {
            try {
                this.updateGlowImageDrawables(graphics3D, irisModel);
            }
            catch (IOException iOException) {
                this.logImageError(3, iOException.getLocalizedMessage(), irisModel);
                return;
            }
            if (this.glowImageDrawables != null && this.glowImageDrawables[1] != null && this.glowImageDrawables[0] != null) {
                graphics3D.pushMatrix(0);
                graphics3D.setDepthBufferEnabled(true);
                graphics3D.setDepthTestEnabled(true);
                graphics3D.clearDepthBuffer(1.0f);
                graphics3D.setDepthTestFunction(7);
                graphics3D.setAlphaTestEnabled(true);
                graphics3D.setAlphaTest(4, -842216387);
                graphics3D.setColorBufferEnabled(false, false, false, false);
                this.glowImageDrawables[1].draw();
                graphics3D.setColorBufferEnabled(true, true, true, true);
                graphics3D.setDepthTestFunction(2);
                float f3 = irisModel.getGlowSize();
                int n = this.glowImageDrawables[0].getWidth() >> 1;
                int n2 = this.glowImageDrawables[0].getHeight() >> 1;
                graphics3D.translateMatrix(0, irisModel.get_width() >> 1, irisModel.get_height() >> 1, 0.0f);
                graphics3D.rotateMatrix(0, irisModel.getGlowAngle(), 0.0f, 0.0f, 1.0f);
                graphics3D.translateMatrix(0, 0.0f, irisModel.get_indicatorGlowOffset(), 0.0f);
                graphics3D.scaleMatrix(0, f3, f3, 1.0f);
                graphics3D.translateMatrix(0, -n, -n2, 0.0f);
                this.glowImageDrawables[0].setAlpha(irisModel.getGlowAlpha());
                this.glowImageDrawables[0].draw();
                graphics3D.setDepthBufferEnabled(false);
                graphics3D.setDepthTestEnabled(false);
                graphics3D.setAlphaTestEnabled(false);
                graphics3D.popMatrix(0);
            }
        }
    }

    private void logImageError(int n, String string, IrisModel irisModel) {
        if (this.errorHelper == null) {
            this.errorHelper = new IrisUI$ErrorLogHelper(4);
        }
        if (!this.errorHelper.isAlreadyLogged(n)) {
            LOGGER.error(128).append(irisModel.getQualifiedName()).append(": can't load image: ").append(string).log();
            this.errorHelper.markAlreadyLogged(n);
        }
    }

    private void updateBackgroundDrawable(Graphics3D graphics3D, IrisModel irisModel) {
        this.backgroundDrawable = IrisUI.updateScaleImageDrawable(graphics3D, irisModel, this.backgroundDrawable, irisModel.get_irisBackgroundImage(), true);
    }

    private void updateSegmentsImageDrawables(Graphics3D graphics3D, IrisModel irisModel) {
        Image[] imageArray = irisModel.get_irisSegmentsImages();
        if (this.segmentsImageDrawables == null) {
            this.segmentsImageDrawables = new ScaleImageDrawable[2];
        }
        if (imageArray == null || imageArray.length != 3) {
            throw new IOException("Iris segments images are not complete! Three segments images have to be defined!");
        }
        this.segmentsImageDrawables[0] = IrisUI.updateScaleImageDrawable(graphics3D, irisModel, this.segmentsImageDrawables[0], imageArray[0], true);
        this.segmentsImageDrawables[1] = IrisUI.updateScaleImageDrawable(graphics3D, irisModel, this.segmentsImageDrawables[1], imageArray[2], true);
    }

    private void updateGlowImageDrawables(Graphics3D graphics3D, IrisModel irisModel) {
        Image[] imageArray = irisModel.get_indicatorImages();
        if (imageArray == null || imageArray.length != 2) {
            throw new IOException("Glow images are not complete! Two glow images have to be defined!");
        }
        this.glowImageDrawables = IrisUI.updateScaleImageDrawables(graphics3D, irisModel, this.glowImageDrawables, imageArray, true);
    }

    private void updateSegmentsColorGradientDrawable(Graphics3D graphics3D, IrisModel irisModel) {
        Image[] imageArray = irisModel.get_irisSegmentsImages();
        if (imageArray == null || imageArray.length != 3) {
            throw new IOException("Iris segments images are not complete! Three segments images have to be defined!");
        }
        this.segmentsColorGradientDrawable = IrisUI.updateColorGradientDrawable(graphics3D, irisModel, this.segmentsColorGradientDrawable, imageArray[1]);
        if (this.segmentsColorGradientDrawable != null) {
            this.segmentsColorGradientDrawable.setImageFilter(1);
        }
    }

    private void updateAccelerationIndicatorDrawables(Graphics3D graphics3D, IrisModel irisModel) {
        Image[] imageArray = irisModel.get_acceleratorImages();
        if (imageArray != null && imageArray.length == 2) {
            this.indicatorColorGradientDrawables = IrisUI.updateColorGradientDrawables(graphics3D, irisModel, this.indicatorColorGradientDrawables, imageArray);
            if (this.indicatorColorGradientDrawables != null) {
                if (this.indicatorColorGradientDrawables[0] != null) {
                    this.indicatorColorGradientDrawables[0].setImageFilter(1);
                }
                if (this.indicatorColorGradientDrawables[1] != null) {
                    this.indicatorColorGradientDrawables[1].setImageFilter(1);
                }
            }
        } else {
            throw new IOException("Acceleration indicator images are not complete! Two images have to be defined!");
        }
    }

    private CircularSectorDrawable updateCircularSectorDrawable(Graphics3D graphics3D, IrisModel irisModel) {
        if (this.circularSectorDrawable == null) {
            float f2 = irisModel.getSpanAngleForOneSegment();
            this.circularSectorDrawable = graphics3D.getDrawableManager().createCircularSectorDrawable();
            if (this.circularSectorDrawable != null) {
                this.circularSectorDrawable.setRadius(1.0f);
                this.circularSectorDrawable.setStartAngle(0.0f);
                this.circularSectorDrawable.setEndAngle(f2);
                this.circularSectorDrawable.setSlices(1);
            }
        }
        return this.circularSectorDrawable;
    }

    private CircleGraphDrawable[] updateCircleGraphDrawables(Graphics3D graphics3D, IrisModel irisModel) {
        if (this.valuesDrawables == null) {
            this.valuesDrawables = new CircleGraphDrawable[2];
            for (int i2 = this.valuesDrawables.length - 1; i2 >= 0; --i2) {
                this.valuesDrawables[i2] = graphics3D.getDrawableManager().createCircleGraphDrawable();
                this.valuesDrawables[i2].setOffset(32959 + (float)i2);
                this.valuesDrawables[i2].setSlices(1);
            }
        }
        return this.valuesDrawables;
    }

    static {
        COLOR_VALUES = new Color4b(110, 0, 0, 150);
    }
}

