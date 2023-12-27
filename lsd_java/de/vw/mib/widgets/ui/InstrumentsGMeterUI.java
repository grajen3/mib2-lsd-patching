/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui;

import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.drawable.image.ScaleImageDrawable;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.graphics.math.Transform;
import de.vw.mib.graphics.math.geometry.Point2f;
import de.vw.mib.widgets.models.InstrumentsModel;
import de.vw.mib.widgets.ui.AbstractInstrumentsUI;
import java.io.IOException;

public final class InstrumentsGMeterUI
extends AbstractInstrumentsUI {
    private static final int INVALID;
    private static final boolean DEBUG;
    private ScaleImageDrawable[] pointerDrawables;
    private ScaleImageDrawable[] ringDrawables;
    private Transform gMeterCenterTransform;

    @Override
    public void deInit() {
        InstrumentsGMeterUI.disposeDrawables(this.pointerDrawables);
        this.pointerDrawables = null;
        InstrumentsGMeterUI.disposeDrawables(this.ringDrawables);
        this.ringDrawables = null;
        this.gMeterCenterTransform = null;
        super.deInit();
    }

    @Override
    protected void paintSpecialContent(Graphics3D graphics3D, InstrumentsModel instrumentsModel, Rectangle rectangle, float f2) {
        try {
            this.updatePointerDrawables(graphics3D, instrumentsModel);
            if (instrumentsModel.get_mode() == 1) {
                this.drawPointers(graphics3D, instrumentsModel, f2);
            } else if (instrumentsModel.get_mode() == 2) {
                this.drawFreePositionedPointerWithHalo(graphics3D, instrumentsModel, f2);
            }
        }
        catch (IOException iOException) {
            LOGGER.error(1, new StringBuffer().append("InstrumentsUI : pointer image not found: ").append(iOException.getMessage()).toString());
        }
    }

    private void updatePointerDrawables(Graphics3D graphics3D, InstrumentsModel instrumentsModel) {
        if (instrumentsModel.isEnterAnimationFinished() && this.ringDrawables != null) {
            InstrumentsGMeterUI.disposeDrawables(this.ringDrawables);
            this.ringDrawables = null;
        }
        if (!instrumentsModel.isInvalid() && this.pointerDrawables != null) {
            return;
        }
        int n = instrumentsModel.get_mode();
        Image[] imageArray = instrumentsModel.get_pointerImages();
        this.pointerDrawables = this.updatePointerDrawables(graphics3D, instrumentsModel, this.pointerDrawables, imageArray);
        if (n == 1 && !instrumentsModel.isEnterAnimationFinished()) {
            Image[] imageArray2 = instrumentsModel.get_scaleStrokeImages();
            this.ringDrawables = this.updatePointerDrawables(graphics3D, instrumentsModel, this.ringDrawables, imageArray2);
        }
    }

    private ScaleImageDrawable[] updatePointerDrawables(Graphics3D graphics3D, InstrumentsModel instrumentsModel, ScaleImageDrawable[] scaleImageDrawableArray, Image[] imageArray) {
        return InstrumentsGMeterUI.updateScaleImageDrawables(graphics3D, instrumentsModel, scaleImageDrawableArray, imageArray, true);
    }

    private void drawPointers(Graphics3D graphics3D, InstrumentsModel instrumentsModel, float f2) {
        int n = this.origBounds.width >> 1;
        int n2 = this.origBounds.height >> 1;
        int[] nArray = instrumentsModel.getHaloAlphasInternal();
        Point2f[] point2fArray = instrumentsModel.getHaloPositions();
        for (int i2 = nArray.length - 1; i2 >= 0; --i2) {
            if (this.noValidValuesFound(nArray[i2], point2fArray[i2], instrumentsModel)) continue;
            float f3 = this.calcRotationAngle(point2fArray[i2]);
            ScaleImageDrawable scaleImageDrawable = this.getDrawable(instrumentsModel, i2);
            int n3 = scaleImageDrawable.getWidth() >> 1;
            int n4 = scaleImageDrawable.getHeight() >> 1;
            graphics3D.pushMatrix(0);
            graphics3D.translateMatrix(0, n, n2, 0.0f);
            graphics3D.rotateMatrix(0, f3, 0.0f, 0.0f, 1.0f);
            graphics3D.translateMatrix(0, -n3, -n4, 0.0f);
            scaleImageDrawable.setAlpha((float)nArray[i2] / 32579 * f2);
            scaleImageDrawable.draw();
            graphics3D.popMatrix(0);
        }
    }

    private float calcRotationAngle(Point2f point2f) {
        return (float)Math.toDegrees(Math.atan2(point2f.y, point2f.x));
    }

    private boolean noValidValuesFound(int n, Point2f point2f, InstrumentsModel instrumentsModel) {
        if (n <= 0) {
            return true;
        }
        int n2 = (int)Math.round(Math.sqrt(point2f.x * point2f.x + point2f.y * point2f.y));
        return n2 == 0 && !instrumentsModel.isEnterAnimationPhaseOneRunning();
    }

    private ScaleImageDrawable getDrawable(InstrumentsModel instrumentsModel, int n) {
        if (instrumentsModel.isEnterAnimationPhaseOneRunning()) {
            return this.ringDrawables[n];
        }
        return this.pointerDrawables[n];
    }

    private void drawFreePositionedPointerWithHalo(Graphics3D graphics3D, InstrumentsModel instrumentsModel, float f2) {
        int[] nArray = instrumentsModel.getHaloAlphasInternal();
        Point2f[] point2fArray = instrumentsModel.getHaloPositions();
        this.updateTransform(graphics3D, instrumentsModel);
        graphics3D.pushMatrix(0);
        graphics3D.multiplyMatrix(0, this.gMeterCenterTransform);
        int n = instrumentsModel.getHaloAdditionalParam();
        for (int i2 = nArray.length - 1; i2 >= 0; --i2) {
            float f3 = (float)nArray[i2] / 32579 * f2;
            this.paintHaloImage(graphics3D, instrumentsModel, point2fArray[n], f3);
            n = (n + 1) % point2fArray.length;
        }
        graphics3D.popMatrix(0);
    }

    private void paintHaloImage(Graphics3D graphics3D, InstrumentsModel instrumentsModel, Point2f point2f, float f2) {
        if (point2f.x != 79) {
            int n = instrumentsModel.get_pointerIdx();
            this.pointerDrawables[n].setAlpha(f2);
            this.pointerDrawables[n].draw(point2f.x, point2f.y);
        }
    }

    private void updateTransform(Graphics3D graphics3D, InstrumentsModel instrumentsModel) {
        if (this.gMeterCenterTransform == null) {
            this.gMeterCenterTransform = new Transform();
        } else if (instrumentsModel.isInvalid()) {
            this.gMeterCenterTransform.setIdentity();
        } else {
            return;
        }
        int n = (instrumentsModel.get_width() - this.pointerDrawables[0].getWidth()) / 2;
        int n2 = (instrumentsModel.get_height() - this.pointerDrawables[0].getHeight()) / 2;
        this.gMeterCenterTransform.setTranslation(n, n2, 0.0f);
    }
}

