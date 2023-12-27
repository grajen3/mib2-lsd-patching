/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui;

import de.vw.mib.graphics.Color4b;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.drawable.image.ImageDrawable;
import de.vw.mib.graphics.drawable.offscreen.OffscreenDrawable;
import de.vw.mib.util.StringBuilder;
import de.vw.mib.widgets.models.PureAirModel;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.models.WidgetModel;
import de.vw.mib.widgets.ui.AbstractImageUI;
import de.vw.mib.widgets.ui.AbstractWidgetUI$OffscreenDrawableHelper;
import java.io.IOException;

public final class PureAirUI
extends AbstractImageUI {
    private OffscreenDrawable offscreenDrawable;
    private ImageDrawable bgCarDrawable;
    private ImageDrawable cleanFgDrawable;
    private ImageDrawable cleanThresholdMaskDrawable;
    private ImageDrawable ionisationOverlayDrawable;
    private ImageDrawable ionisationAlphaDrawable;
    private ImageDrawable ionisationFgForAlphaDrawable;
    private ImageDrawable ionisationFgForFadingDrawable;

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void deInit() {
        this.disposeDrawables();
        super.deInit();
    }

    private void disposeDrawables() {
        if (this.offscreenDrawable != null) {
            this.offscreenDrawable.dispose();
            this.offscreenDrawable = null;
        }
        if (this.bgCarDrawable != null) {
            this.bgCarDrawable.dispose();
            this.bgCarDrawable = null;
        }
        if (this.cleanFgDrawable != null) {
            this.cleanFgDrawable.dispose();
            this.cleanFgDrawable = null;
        }
        if (this.cleanThresholdMaskDrawable != null) {
            this.cleanThresholdMaskDrawable.dispose();
            this.cleanThresholdMaskDrawable = null;
        }
        if (this.ionisationFgForAlphaDrawable != null) {
            this.ionisationFgForAlphaDrawable.dispose();
            this.ionisationFgForAlphaDrawable = null;
        }
        if (this.ionisationFgForFadingDrawable != null) {
            this.ionisationFgForFadingDrawable.dispose();
            this.ionisationFgForFadingDrawable = null;
        }
        if (this.ionisationAlphaDrawable != null) {
            this.ionisationAlphaDrawable.dispose();
            this.ionisationAlphaDrawable = null;
        }
        if (this.ionisationOverlayDrawable != null) {
            this.ionisationOverlayDrawable.dispose();
            this.ionisationOverlayDrawable = null;
        }
    }

    private ImageDrawable loadImageDrawable(Graphics3D graphics3D, String string) {
        StringBuilder stringBuilder = new StringBuilder("/");
        stringBuilder.append(string).append(".png");
        return PureAirUI.createImageDrawableFromSkin0(graphics3D, stringBuilder.toString(), 6);
    }

    private void createDrawables(Graphics3D graphics3D, PureAirModel pureAirModel) {
        if (this.offscreenDrawable == null) {
            this.offscreenDrawable = AbstractWidgetUI$OffscreenDrawableHelper.createOffscreenDrawable(graphics3D, pureAirModel.get_width(), pureAirModel.get_height(), false);
        }
        if (this.bgCarDrawable == null) {
            this.bgCarDrawable = this.loadImageDrawable(graphics3D, "Ionisation_BG");
        }
        switch (pureAirModel.get_airMode()) {
            case 1: {
                if (this.ionisationFgForAlphaDrawable == null) {
                    this.ionisationFgForAlphaDrawable = this.loadImageDrawable(graphics3D, "Ionisation_FG_For_Alpha");
                }
                if (this.ionisationFgForFadingDrawable == null) {
                    this.ionisationFgForFadingDrawable = this.loadImageDrawable(graphics3D, "Ionisation_FG_For_Fading");
                }
                if (this.ionisationAlphaDrawable == null) {
                    this.ionisationAlphaDrawable = this.loadImageDrawable(graphics3D, "Ionisation_Alpha");
                }
                if (this.ionisationOverlayDrawable != null) break;
                this.ionisationOverlayDrawable = this.loadImageDrawable(graphics3D, "Ionisation_Overlay");
                break;
            }
            case 0: {
                if (this.cleanFgDrawable == null) {
                    this.cleanFgDrawable = this.loadImageDrawable(graphics3D, "Clean_Air_FG");
                }
                if (this.cleanThresholdMaskDrawable != null) break;
                this.cleanThresholdMaskDrawable = this.loadImageDrawable(graphics3D, "Clean_Air_Threshhold_Mask");
                break;
            }
        }
    }

    private void drawBgCar(Graphics3D graphics3D, PureAirModel pureAirModel) {
        this.bgCarDrawable.draw();
    }

    private void drawIonisationIonisationFgForFading(Graphics3D graphics3D, PureAirModel pureAirModel) {
        this.ionisationFgForFadingDrawable.setAlpha(pureAirModel.getIonisationAlphaForFading());
        this.ionisationFgForFadingDrawable.draw();
    }

    private void drawIonisationFgForAlpha(Graphics3D graphics3D, PureAirModel pureAirModel) {
        this.ionisationFgForAlphaDrawable.setAlpha(pureAirModel.getIonisationAlphaForFading());
        this.ionisationFgForAlphaDrawable.draw();
    }

    private void drawIonisationAlpha(Graphics3D graphics3D, PureAirModel pureAirModel) {
        graphics3D.translateMatrix(0, pureAirModel.getIonisationAlphaX(), pureAirModel.getIonisationAlphaY(), 0.0f);
        int n = graphics3D.getBlendEquation();
        graphics3D.setBlendFactorsSeparate(6, 1, 6, 1);
        graphics3D.setBlendEquation(2);
        this.ionisationAlphaDrawable.setAlpha(pureAirModel.getIonisationAlpha());
        this.ionisationAlphaDrawable.draw();
        graphics3D.setBlendEquation(n);
        graphics3D.translateMatrix(0, -pureAirModel.getIonisationAlphaX(), -pureAirModel.getIonisationAlphaY(), 0.0f);
    }

    private void drawOverlay(Graphics3D graphics3D, PureAirModel pureAirModel) {
        if (pureAirModel.getIonisationLoopCount() - 1 <= pureAirModel.getIonisationLoop()) {
            this.ionisationOverlayDrawable.setAlpha(pureAirModel.getIonisationAlphaOverlay());
            this.ionisationOverlayDrawable.draw();
        }
    }

    private void drawCleanFg(Graphics3D graphics3D, PureAirModel pureAirModel, float f2) {
        int n = graphics3D.getStencilTestFunction();
        graphics3D.setStencilTest(2, 1, 1);
        this.cleanFgDrawable.setAlpha(f2);
        this.cleanFgDrawable.draw();
        graphics3D.setStencilTest(n, 1, 1);
    }

    private void drawCleanThreshholdMask(Graphics3D graphics3D, PureAirModel pureAirModel, float f2) {
        int n = graphics3D.getStencilTestFunction();
        graphics3D.setStencilBufferEnabled(1);
        graphics3D.clearStencilBuffer(0);
        graphics3D.setStencilTestEnabled(true);
        graphics3D.setStencilTest(2, 1, 1);
        graphics3D.setStencilOperation(2, 2, 2);
        graphics3D.setAlphaTestEnabled(true);
        graphics3D.setAlphaTest(4, f2);
        this.cleanThresholdMaskDrawable.draw();
        graphics3D.setAlphaTestEnabled(false);
        graphics3D.setStencilBufferEnabled(0);
        graphics3D.setStencilTest(n, 1, 1);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    protected void paintImage(Graphics3D graphics3D, ViewModel viewModel, WidgetModel widgetModel, Rectangle rectangle, Rectangle rectangle2, Color4b color4b, float f2) {
        PureAirModel pureAirModel = (PureAirModel)widgetModel;
        graphics3D.pushMatrix(0);
        try {
            this.createDrawables(graphics3D, pureAirModel);
            switch (pureAirModel.get_airMode()) {
                case 1: {
                    this.drawBgCar(graphics3D, pureAirModel);
                    this.drawIonisationFgForAlpha(graphics3D, pureAirModel);
                    this.drawIonisationAlpha(graphics3D, pureAirModel);
                    this.drawIonisationIonisationFgForFading(graphics3D, pureAirModel);
                    this.drawOverlay(graphics3D, pureAirModel);
                    return;
                }
                case 0: {
                    this.drawBgCar(graphics3D, pureAirModel);
                    if (pureAirModel.isAnimationRunning()) {
                        this.drawCleanThreshholdMask(graphics3D, pureAirModel, pureAirModel.getCleanThreshholdAlpha());
                        this.drawCleanFg(graphics3D, pureAirModel, 63);
                        this.drawCleanThreshholdMask(graphics3D, pureAirModel, pureAirModel.getCleanThreshholdAlphaBlur());
                        this.drawCleanFg(graphics3D, pureAirModel, 63);
                        return;
                    }
                    this.drawCleanThreshholdMask(graphics3D, pureAirModel, pureAirModel.getCleanThreshholdAlpha());
                    this.drawCleanFg(graphics3D, pureAirModel, 1.0f);
                    return;
                }
            }
            return;
        }
        catch (IOException iOException) {
            LOGGER.error(128).append("Widget '").append(pureAirModel.getQualifiedName()).append("': Unable to load area view image. '").attachThrowable(iOException).log();
            return;
        }
        finally {
            graphics3D.popMatrix(0);
        }
    }
}

