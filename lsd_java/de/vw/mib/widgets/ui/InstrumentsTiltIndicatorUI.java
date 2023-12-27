/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui;

import de.vw.mib.graphics.Color;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.drawable.image.ScaleImageDrawable;
import de.vw.mib.graphics.drawable.offscreen.OffscreenDrawable;
import de.vw.mib.graphics.drawable.shape.RectangleDrawable;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.widgets.models.InstrumentsModel;
import de.vw.mib.widgets.ui.AbstractInstrumentsUI;
import de.vw.mib.widgets.ui.AbstractWidgetUI$OffscreenDrawableHelper;
import java.io.IOException;

public final class InstrumentsTiltIndicatorUI
extends AbstractInstrumentsUI {
    private static final int COUNT_ERROR;
    private static final int ERROR_POINTER;
    private static final int ERROR_TILTINDICATOR;
    private final boolean[] errorAlreadyLogged = new boolean[2];
    private OffscreenDrawable tiltZoneOffscreenTexture;
    private RectangleDrawable rectangleDrawable;
    private ScaleImageDrawable tiltIndicatorDrawable;
    private ScaleImageDrawable pointerDrawable;
    private float lastValue = 0x1000000;

    @Override
    public void reset() {
        super.reset();
        if (this.errorAlreadyLogged != null) {
            for (int i2 = this.errorAlreadyLogged.length - 1; i2 >= 0; --i2) {
                this.errorAlreadyLogged[i2] = false;
            }
        }
        this.lastValue = 0x1000000;
    }

    @Override
    public void deInit() {
        InstrumentsTiltIndicatorUI.disposeDrawable(this.tiltZoneOffscreenTexture);
        this.tiltZoneOffscreenTexture = null;
        InstrumentsTiltIndicatorUI.disposeDrawable(this.rectangleDrawable);
        this.rectangleDrawable = null;
        InstrumentsTiltIndicatorUI.disposeDrawable(this.tiltIndicatorDrawable);
        this.tiltIndicatorDrawable = null;
        InstrumentsTiltIndicatorUI.disposeDrawable(this.pointerDrawable);
        this.pointerDrawable = null;
        super.deInit();
    }

    @Override
    protected void paintSpecialContent(Graphics3D graphics3D, InstrumentsModel instrumentsModel, Rectangle rectangle, float f2) {
        this.paintTiltIndicatorZoneOffscreen(graphics3D, instrumentsModel);
        this.paintPointer(graphics3D, instrumentsModel);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void paintTiltIndicatorZoneOffscreen(Graphics3D graphics3D, InstrumentsModel instrumentsModel) {
        if (this.hasValueChanged(instrumentsModel) || instrumentsModel.isScaleInvalid() || this.tiltZoneOffscreenTexture == null || !this.tiltZoneOffscreenTexture.isValid()) {
            if (!AbstractWidgetUI$OffscreenDrawableHelper.isOffscreenDrawableValid(this.tiltZoneOffscreenTexture, this.origBounds.width, this.origBounds.height)) {
                AbstractWidgetUI$OffscreenDrawableHelper.disposeOffscreenDrawable(this.tiltZoneOffscreenTexture);
                this.tiltZoneOffscreenTexture = AbstractWidgetUI$OffscreenDrawableHelper.createOffscreenDrawable(graphics3D, this.origBounds.width, this.origBounds.height, false);
            }
            if (this.tiltZoneOffscreenTexture != null) {
                AbstractWidgetUI$OffscreenDrawableHelper.prepare(graphics3D, this.tiltZoneOffscreenTexture, this.origBounds);
            }
            try {
                this.paintTiltIndicatorZone(graphics3D, instrumentsModel);
            }
            finally {
                AbstractWidgetUI$OffscreenDrawableHelper.restore(graphics3D, this.tiltZoneOffscreenTexture, this.origBounds);
            }
        }
        if (this.tiltZoneOffscreenTexture != null) {
            this.tiltZoneOffscreenTexture.draw();
        }
        instrumentsModel.setScaleInvalid(false);
    }

    private boolean hasValueChanged(InstrumentsModel instrumentsModel) {
        boolean bl;
        boolean bl2 = bl = this.lastValue != (float)instrumentsModel.get_value();
        if (bl) {
            this.lastValue = instrumentsModel.get_value();
        }
        return bl;
    }

    private void paintTiltIndicatorZone(Graphics3D graphics3D, InstrumentsModel instrumentsModel) {
        if (!this.areTiltZoneParamsComplete(instrumentsModel)) {
            if (!this.errorAlreadyLogged[1]) {
                LOGGER.error(1, "InstrumentsTiltIndicatorUI: params for drawing tilt zone not complete! Check warningZoneImage and scaleStrokeColors");
                this.errorAlreadyLogged[1] = true;
            }
            return;
        }
        Color color = instrumentsModel.get_scaleStrokeColors()[1];
        try {
            this.updateTiltIndicatorDrawable(graphics3D, instrumentsModel);
            if (this.tiltIndicatorDrawable != null) {
                this.tiltIndicatorDrawable.setColor(color.getCurrentColor());
                this.tiltIndicatorDrawable.draw();
            }
            int n = graphics3D.getBlendFactorDestinationAlpha();
            int n2 = graphics3D.getBlendFactorDestinationRGB();
            int n3 = graphics3D.getBlendFactorSourceAlpha();
            int n4 = graphics3D.getBlendFactorSourceRGB();
            boolean bl = graphics3D.isAlphaTestEnabled();
            graphics3D.setAlphaTestEnabled(false);
            graphics3D.setBlendFactorsSeparate(1, 0, 0, 0);
            int n5 = this.origBounds.width >> 1;
            int n6 = this.origBounds.height >> 1;
            float f2 = instrumentsModel.getInternalAngle();
            boolean bl2 = false;
            if (13379 < f2 && f2 < 46147 || f2 < 0.0f) {
                f2 = 46147 - f2;
                bl2 = true;
            }
            this.updateRectangleDrawable(graphics3D, instrumentsModel, this.origBounds.width >> 1, this.origBounds.height >> 1);
            graphics3D.pushMatrix(0);
            if (bl2) {
                graphics3D.translateMatrix(0, n5, n6, 0.0f);
                graphics3D.scaleMatrix(0, 32959, 1.0f, 1.0f);
                graphics3D.translateMatrix(0, -n5, -n6, 0.0f);
            }
            this.rectangleDrawable.setColor(CLIP_COLOR);
            this.rectangleDrawable.draw();
            this.rectangleDrawable.draw(n5, n6);
            graphics3D.translateMatrix(0, n5, n6, 0.0f);
            graphics3D.rotateMatrix(0, f2, 0.0f, 0.0f, 1.0f);
            graphics3D.translateMatrix(0, -n5, -n6, 0.0f);
            this.rectangleDrawable.draw(n5, 0.0f);
            this.rectangleDrawable.draw(0.0f, n6);
            graphics3D.popMatrix(0);
            graphics3D.setBlendFactorsSeparate(n4, n2, n3, n);
            graphics3D.setAlphaTestEnabled(bl);
            this.errorAlreadyLogged[1] = false;
        }
        catch (IOException iOException) {
            LOGGER.error(1).append("InstrumentsTiltIndicatorUI: Could not load image: ").append(iOException.getMessage());
            this.errorAlreadyLogged[1] = true;
        }
    }

    private void paintPointer(Graphics3D graphics3D, InstrumentsModel instrumentsModel) {
        block5: {
            int n = this.origBounds.width >> 1;
            int n2 = this.origBounds.height >> 1;
            float f2 = instrumentsModel.getInternalAngle();
            int n3 = instrumentsModel.get_pointerIdx();
            Image[] imageArray = instrumentsModel.get_pointerImages();
            if (n3 < 0 || n3 >= imageArray.length) {
                if (!this.errorAlreadyLogged[0]) {
                    LOGGER.error(1, new StringBuffer().append("InstrumentsTiltIndicatorUI : no image for pointer index: ").append(n3).toString());
                    this.errorAlreadyLogged[0] = true;
                }
                return;
            }
            try {
                this.updatePointerDrawable(graphics3D, instrumentsModel);
                if (this.pointerDrawable != null) {
                    int n4 = this.pointerDrawable.getWidth() >> 1;
                    int n5 = this.pointerDrawable.getHeight() >> 1;
                    graphics3D.pushMatrix(0);
                    graphics3D.translateMatrix(0, n, n2, 0.0f);
                    graphics3D.rotateMatrix(0, f2, 0.0f, 0.0f, 1.0f);
                    graphics3D.translateMatrix(0, -n4, -n5, 0.0f);
                    this.pointerDrawable.setColor(InstrumentsTiltIndicatorUI.getColor(instrumentsModel.get_pointerColors(), instrumentsModel.get_pointerIdx()));
                    this.pointerDrawable.draw();
                    graphics3D.popMatrix(0);
                    this.errorAlreadyLogged[0] = false;
                }
            }
            catch (IOException iOException) {
                if (this.errorAlreadyLogged[0]) break block5;
                LOGGER.error(1, new StringBuffer().append("InstrumentsTiltIndicatorUI : pointer image not found: ").append(iOException.getMessage()).toString());
                this.errorAlreadyLogged[0] = true;
            }
        }
    }

    private boolean areTiltZoneParamsComplete(InstrumentsModel instrumentsModel) {
        if (instrumentsModel.get_warningZoneImage() == null) {
            return false;
        }
        return instrumentsModel.get_scaleStrokeColors() != null && instrumentsModel.get_scaleStrokeColors().length >= 2;
    }

    private void updateTiltIndicatorDrawable(Graphics3D graphics3D, InstrumentsModel instrumentsModel) {
        Image image = instrumentsModel.get_warningZoneImage();
        this.tiltIndicatorDrawable = InstrumentsTiltIndicatorUI.updateScaleImageDrawable(graphics3D, instrumentsModel, this.tiltIndicatorDrawable, image);
    }

    private void updatePointerDrawable(Graphics3D graphics3D, InstrumentsModel instrumentsModel) {
        Image[] imageArray = instrumentsModel.get_pointerImages();
        int n = instrumentsModel.get_pointerIdx();
        Image image = imageArray.length != 0 ? imageArray[n] : null;
        this.pointerDrawable = InstrumentsTiltIndicatorUI.updateScaleImageDrawable(graphics3D, instrumentsModel, this.pointerDrawable, image);
    }

    private void updateRectangleDrawable(Graphics3D graphics3D, InstrumentsModel instrumentsModel, int n, int n2) {
        this.rectangleDrawable = InstrumentsTiltIndicatorUI.updateRectangleDrawable(graphics3D, instrumentsModel, this.rectangleDrawable, 0, 0, n, n2);
    }
}

