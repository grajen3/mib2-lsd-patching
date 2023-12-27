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

public final class InstrumentsPointerUI
extends AbstractInstrumentsUI {
    private boolean isWarningPrinted;
    private OffscreenDrawable scaleOffscreenTexture;
    private ScaleImageDrawable pointerImageDrawable;
    private ScaleImageDrawable[] scaleStrokeImageDrawables;
    private ScaleImageDrawable warningZoneDrawable;
    private RectangleDrawable rectangleDrawable;
    private boolean errorAlreadyLogged;

    @Override
    public void deInit() {
        InstrumentsPointerUI.disposeDrawable(this.scaleOffscreenTexture);
        this.scaleOffscreenTexture = null;
        InstrumentsPointerUI.disposeDrawable(this.pointerImageDrawable);
        this.pointerImageDrawable = null;
        InstrumentsPointerUI.disposeDrawable(this.warningZoneDrawable);
        this.warningZoneDrawable = null;
        InstrumentsPointerUI.disposeDrawables(this.scaleStrokeImageDrawables);
        this.scaleStrokeImageDrawables = null;
        InstrumentsPointerUI.disposeDrawable(this.rectangleDrawable);
        this.rectangleDrawable = null;
        this.errorAlreadyLogged = false;
        this.isWarningPrinted = false;
        super.deInit();
    }

    @Override
    protected void paintSpecialContent(Graphics3D graphics3D, InstrumentsModel instrumentsModel, Rectangle rectangle, float f2) {
        this.paintScaleAndWarningZoneOffscreen(graphics3D, instrumentsModel, f2);
        this.paintPointer(graphics3D, instrumentsModel, f2);
    }

    private void paintPointer(Graphics3D graphics3D, InstrumentsModel instrumentsModel, float f2) {
        block3: {
            int n = this.origBounds.width >> 1;
            int n2 = this.origBounds.height >> 1;
            float f3 = instrumentsModel.getInternalAngle();
            try {
                this.updatePointerDrawable(graphics3D, instrumentsModel);
                if (this.pointerImageDrawable != null) {
                    int n3 = this.pointerImageDrawable.getWidth() >> 1;
                    int n4 = this.pointerImageDrawable.getHeight() >> 1;
                    graphics3D.pushMatrix(0);
                    graphics3D.translateMatrix(0, n, n2, 0.0f);
                    graphics3D.rotateMatrix(0, f3, 0.0f, 0.0f, 1.0f);
                    graphics3D.translateMatrix(0, -n3, -n4, 0.0f);
                    this.pointerImageDrawable.setColor(InstrumentsPointerUI.getColor(instrumentsModel.get_pointerColors(), instrumentsModel.get_pointerIdx()));
                    this.pointerImageDrawable.setAlpha(f2);
                    this.pointerImageDrawable.draw();
                    graphics3D.popMatrix(0);
                    this.errorAlreadyLogged = false;
                }
            }
            catch (IOException iOException) {
                if (this.errorAlreadyLogged) break block3;
                LOGGER.error(1, new StringBuffer().append("InstrumentsPointerUI : pointer image not found: ").append(iOException.getMessage()).toString());
                this.errorAlreadyLogged = true;
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void paintScaleAndWarningZoneOffscreen(Graphics3D graphics3D, InstrumentsModel instrumentsModel, float f2) {
        if (instrumentsModel.isScaleInvalid() || this.scaleOffscreenTexture == null || !this.scaleOffscreenTexture.isValid()) {
            if (!AbstractWidgetUI$OffscreenDrawableHelper.isOffscreenDrawableValid(this.scaleOffscreenTexture, this.origBounds.width, this.origBounds.height)) {
                AbstractWidgetUI$OffscreenDrawableHelper.disposeOffscreenDrawable(this.scaleOffscreenTexture);
                this.scaleOffscreenTexture = AbstractWidgetUI$OffscreenDrawableHelper.createOffscreenDrawable(graphics3D, this.origBounds.width, this.origBounds.height, false);
            }
            if (this.scaleOffscreenTexture != null) {
                AbstractWidgetUI$OffscreenDrawableHelper.prepare(graphics3D, this.scaleOffscreenTexture, this.origBounds);
            }
            try {
                this.paintWarningZone(graphics3D, instrumentsModel);
                this.paintScale(graphics3D, instrumentsModel);
            }
            finally {
                AbstractWidgetUI$OffscreenDrawableHelper.restore(graphics3D, this.scaleOffscreenTexture, this.origBounds);
            }
        }
        if (this.scaleOffscreenTexture != null) {
            this.scaleOffscreenTexture.setAlpha(f2);
            this.scaleOffscreenTexture.draw();
        }
        instrumentsModel.setScaleInvalid(false);
    }

    private void paintScale(Graphics3D graphics3D, InstrumentsModel instrumentsModel) {
        if (!this.checkIfScaleParamsAreComplete(instrumentsModel)) {
            if (LOGGER.isTraceEnabled(1) && !this.isWarningPrinted) {
                LOGGER.trace(1).append("InstrumentsPointerUI: Parameters for scale are not complete or do not correspond (Widget: ").append(instrumentsModel.getQualifiedName()).append(")!").log();
                this.isWarningPrinted = true;
            }
            return;
        }
        this.isWarningPrinted = false;
        int[] nArray = instrumentsModel.get_scaleStrokeAngles();
        int[] nArray2 = instrumentsModel.get_scaleStrokeTypes();
        Color[] colorArray = instrumentsModel.get_scaleStrokeColors();
        int[] nArray3 = instrumentsModel.get_warningZoneAngles();
        try {
            this.updateScaleStrokeImageDrawables(graphics3D, instrumentsModel);
            int n = -1;
            int n2 = this.origBounds.width >> 1;
            int n3 = this.origBounds.height >> 1;
            int n4 = 0;
            int n5 = 0;
            int n6 = nArray3.length == 0 ? 128 : nArray3[0] - nArray3[1];
            int n7 = nArray3.length == 0 ? 128 : nArray3[0];
            for (int i2 = nArray.length - 1; i2 >= 0; --i2) {
                n = nArray2[i2];
                if (n >= 0 && n < this.scaleStrokeImageDrawables.length && this.scaleStrokeImageDrawables[n] != null) {
                    n4 = this.scaleStrokeImageDrawables[n].getWidth() >> 1;
                    n5 = this.scaleStrokeImageDrawables[n].getHeight() >> 1;
                    Color color = n6 <= nArray[i2] && nArray[i2] < n7 ? colorArray[1] : colorArray[0];
                    graphics3D.pushMatrix(0);
                    graphics3D.translateMatrix(0, n2, n3, 0.0f);
                    graphics3D.rotateMatrix(0, nArray[i2], 0.0f, 0.0f, 1.0f);
                    graphics3D.translateMatrix(0, -n4, -n5, 0.0f);
                    this.scaleStrokeImageDrawables[n].setColor(color.getCurrentColor());
                    this.scaleStrokeImageDrawables[n].draw();
                    graphics3D.popMatrix(0);
                    continue;
                }
                LOGGER.error(1).append("InstrumentsPointerUI: Could not draw scale completely because scaleStrokeTypesProperties[").append(n).append("] points to non existing scale stroke image.");
            }
        }
        catch (IOException iOException) {
            LOGGER.error(1).append("InstrumentsPointerUI: image for scale: ").append(iOException.getMessage());
        }
    }

    private void paintWarningZone(Graphics3D graphics3D, InstrumentsModel instrumentsModel) {
        if (!this.checkIfWarningZoneParamsAreComplete(instrumentsModel)) {
            if (LOGGER.isTraceEnabled(1)) {
                LOGGER.info(1).append("InstrumentsPointerUI: Properties required for painting the warning zone are not complete (Widget: ").append(instrumentsModel.getQualifiedName()).append(").").log();
            }
            return;
        }
        int n = instrumentsModel.get_warningZoneAngles()[0];
        int n2 = instrumentsModel.get_warningZoneAngles()[1];
        Color color = instrumentsModel.get_scaleStrokeColors()[1];
        try {
            this.updateWarningZoneImageDrawable(graphics3D, instrumentsModel);
            if (this.warningZoneDrawable != null) {
                int n3 = this.warningZoneDrawable.getWidth();
                int n4 = this.warningZoneDrawable.getHeight();
                int n5 = n3 >> 1;
                int n6 = n4 >> 1;
                this.updateRectangleDrawable(graphics3D, instrumentsModel, n3 >> 1, n4);
                graphics3D.pushMatrix(0);
                graphics3D.translateMatrix(0, this.origBounds.width >> 1, this.origBounds.height >> 1, 0.0f);
                graphics3D.rotateMatrix(0, n, 0.0f, 0.0f, 1.0f);
                graphics3D.translateMatrix(0, -n5, -n6, 0.0f);
                this.warningZoneDrawable.setColor(color.getCurrentColor());
                this.warningZoneDrawable.draw();
                int n7 = graphics3D.getBlendFactorDestinationAlpha();
                int n8 = graphics3D.getBlendFactorDestinationRGB();
                int n9 = graphics3D.getBlendFactorSourceAlpha();
                int n10 = graphics3D.getBlendFactorSourceRGB();
                boolean bl = graphics3D.isAlphaTestEnabled();
                graphics3D.setAlphaTestEnabled(false);
                graphics3D.setBlendFactorsSeparate(1, 0, 0, 0);
                this.rectangleDrawable.setColor(CLIP_COLOR);
                this.rectangleDrawable.draw(n5, 0.0f);
                graphics3D.translateMatrix(0, n5, n6, 0.0f);
                graphics3D.rotateMatrix(0, -n2, 0.0f, 0.0f, 1.0f);
                graphics3D.translateMatrix(0, -n5, -n6, 0.0f);
                this.rectangleDrawable.draw();
                graphics3D.setBlendFactorsSeparate(n10, n8, n9, n7);
                graphics3D.setAlphaTestEnabled(bl);
                graphics3D.popMatrix(0);
            }
        }
        catch (IOException iOException) {
            LOGGER.error(1, new StringBuffer().append("InstrumentsUI: warning zone image not found: ").append(iOException.getMessage()).toString());
        }
    }

    private void updatePointerDrawable(Graphics3D graphics3D, InstrumentsModel instrumentsModel) {
        Image[] imageArray = instrumentsModel.get_pointerImages();
        int n = instrumentsModel.get_pointerIdx();
        Image image = imageArray.length != 0 ? imageArray[n] : null;
        this.pointerImageDrawable = InstrumentsPointerUI.updateScaleImageDrawable(graphics3D, instrumentsModel, this.pointerImageDrawable, image, true);
    }

    private void updateScaleStrokeImageDrawables(Graphics3D graphics3D, InstrumentsModel instrumentsModel) {
        Image[] imageArray = instrumentsModel.get_scaleStrokeImages();
        this.scaleStrokeImageDrawables = InstrumentsPointerUI.updateScaleImageDrawables(graphics3D, instrumentsModel, this.scaleStrokeImageDrawables, imageArray, true);
    }

    private void updateRectangleDrawable(Graphics3D graphics3D, InstrumentsModel instrumentsModel, int n, int n2) {
        this.rectangleDrawable = InstrumentsPointerUI.updateRectangleDrawable(graphics3D, instrumentsModel, this.rectangleDrawable, 0, 0, n, n2);
    }

    private void updateWarningZoneImageDrawable(Graphics3D graphics3D, InstrumentsModel instrumentsModel) {
        Image image = instrumentsModel.get_warningZoneImage();
        this.warningZoneDrawable = InstrumentsPointerUI.updateScaleImageDrawable(graphics3D, instrumentsModel, this.warningZoneDrawable, image);
    }

    private boolean checkIfWarningZoneParamsAreComplete(InstrumentsModel instrumentsModel) {
        Image image = instrumentsModel.get_warningZoneImage();
        int[] nArray = instrumentsModel.get_warningZoneAngles();
        Color[] colorArray = instrumentsModel.get_scaleStrokeColors();
        return image != null && nArray != null && colorArray != null && colorArray.length == 2 && nArray.length == 2;
    }

    private boolean checkIfScaleParamsAreComplete(InstrumentsModel instrumentsModel) {
        Image[] imageArray = instrumentsModel.get_scaleStrokeImages();
        int[] nArray = instrumentsModel.get_scaleStrokeAngles();
        int[] nArray2 = instrumentsModel.get_scaleStrokeTypes();
        Color[] colorArray = instrumentsModel.get_scaleStrokeColors();
        return imageArray != null && nArray != null && nArray2 != null && colorArray != null && imageArray.length == 3 && colorArray.length == 2 && nArray.length == nArray2.length && nArray.length != 0;
    }
}

