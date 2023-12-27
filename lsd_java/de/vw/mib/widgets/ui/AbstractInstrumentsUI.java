/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui;

import de.vw.mib.graphics.Color;
import de.vw.mib.graphics.Color4b;
import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.drawable.image.ScaleImageDrawable;
import de.vw.mib.graphics.image.BufferImage;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.graphics.image.ScaleImage;
import de.vw.mib.graphics.math.Transform;
import de.vw.mib.widgets.internal.ServiceManager;
import de.vw.mib.widgets.models.ContainerModel;
import de.vw.mib.widgets.models.InstrumentsModel;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.ui.TransformContainerUI;
import java.io.IOException;

public abstract class AbstractInstrumentsUI
extends TransformContainerUI {
    private static final int LOG_INDEX_ERROR_BACKGROUND;
    private static final int LOG_INDEX_ERROR_FOREGROUND;
    private static final int LOG_INDEX_WARNING_SCALE;
    private static final int LOG_INDEX_COUNT;
    static final Color4f CLIP_COLOR;
    protected Rectangle origBounds;
    private boolean[] errorAlreadyLogged = new boolean[3];
    private Transform scaleTransform;
    private ScaleImageDrawable backgroundImageDrawable;
    private ScaleImageDrawable foregroundImageDrawable;

    @Override
    public void deInit() {
        AbstractInstrumentsUI.disposeDrawable(this.backgroundImageDrawable);
        this.backgroundImageDrawable = null;
        AbstractInstrumentsUI.disposeDrawable(this.foregroundImageDrawable);
        this.foregroundImageDrawable = null;
        this.scaleTransform = null;
        this.origBounds = null;
        super.deInit();
    }

    @Override
    public void reset() {
        this.errorAlreadyLogged = new boolean[3];
    }

    protected static final Color4b getColor(Color[] colorArray, int n) {
        return colorArray == null || colorArray.length <= n || colorArray[n] == null ? Color4b.WHITE : colorArray[n].getCurrentColor();
    }

    @Override
    public void paintContent(Graphics3D graphics3D, ViewModel viewModel, ContainerModel containerModel, Rectangle rectangle, Rectangle rectangle2, float f2) {
        InstrumentsModel instrumentsModel = (InstrumentsModel)containerModel;
        this.calcScaleFactor(instrumentsModel, rectangle2);
        graphics3D.pushMatrix(0);
        graphics3D.multiplyMatrix(0, this.scaleTransform);
        this.paintBackground(graphics3D, instrumentsModel, rectangle2, f2);
        this.paintSpecialContent(graphics3D, instrumentsModel, rectangle2, f2);
        this.paintForeground(graphics3D, instrumentsModel, rectangle2, f2);
        super.paintContent(graphics3D, viewModel, containerModel, rectangle, rectangle2, f2);
        graphics3D.popMatrix(0);
    }

    private void calcScaleFactor(InstrumentsModel instrumentsModel, Rectangle rectangle) {
        if (instrumentsModel.isInvalid() || this.scaleTransform == null) {
            if (this.origBounds == null) {
                this.origBounds = new Rectangle();
            }
            if (this.scaleTransform == null) {
                this.scaleTransform = new Transform();
            }
            ScaleImage scaleImage = instrumentsModel.get_backgroundImage().getCurrentImage();
            if (instrumentsModel.get_scalingX() != 1.0f || instrumentsModel.get_scalingY() != 1.0f || scaleImage.isEmpty()) {
                this.scaleTransform.setIdentity();
                this.origBounds.width = instrumentsModel.get_width();
                this.origBounds.height = instrumentsModel.get_height();
                return;
            }
            try {
                BufferImage bufferImage = ServiceManager.imageManager.getImageFromCurrentSkin(instrumentsModel.get_backgroundImage());
                float f2 = (float)rectangle.width / (float)bufferImage.getWidth();
                float f3 = (float)rectangle.height / (float)bufferImage.getHeight();
                this.scaleTransform.setScale(f2, f3, 1.0f);
                this.origBounds.width = bufferImage.getWidth();
                this.origBounds.height = bufferImage.getHeight();
                this.errorAlreadyLogged[2] = false;
            }
            catch (IOException iOException) {
                if (!this.errorAlreadyLogged[2]) {
                    LOGGER.warn(1, "AbstractInstrumentsUI: Could not calc scale factor! Assuming scaleFactor=1.");
                    this.errorAlreadyLogged[2] = true;
                }
                this.scaleTransform.setIdentity();
                this.origBounds.width = instrumentsModel.get_width();
                this.origBounds.height = instrumentsModel.get_height();
            }
        }
    }

    protected abstract void paintSpecialContent(Graphics3D graphics3D, InstrumentsModel instrumentsModel, Rectangle rectangle, float f2) {
    }

    private void paintBackground(Graphics3D graphics3D, InstrumentsModel instrumentsModel, Rectangle rectangle, float f2) {
        block3: {
            try {
                this.updateBackgroundDrawable(graphics3D, instrumentsModel);
                if (this.backgroundImageDrawable != null) {
                    this.backgroundImageDrawable.setAlpha(f2);
                    this.backgroundImageDrawable.setColor(instrumentsModel.get_backgroundColor().getCurrentColor());
                    this.backgroundImageDrawable.draw();
                    this.errorAlreadyLogged[0] = false;
                }
            }
            catch (IOException iOException) {
                if (this.errorAlreadyLogged[0]) break block3;
                LOGGER.error(1, new StringBuffer().append("AbstractInstrumentsUI: background image not found: ").append(iOException.getMessage()).toString());
                this.errorAlreadyLogged[0] = true;
            }
        }
    }

    private void updateBackgroundDrawable(Graphics3D graphics3D, InstrumentsModel instrumentsModel) {
        Image image = instrumentsModel.get_backgroundImage();
        this.backgroundImageDrawable = AbstractInstrumentsUI.updateScaleImageDrawable(graphics3D, instrumentsModel, this.backgroundImageDrawable, image, true);
    }

    private void paintForeground(Graphics3D graphics3D, InstrumentsModel instrumentsModel, Rectangle rectangle, float f2) {
        block3: {
            try {
                this.updateForegroundDrawable(graphics3D, instrumentsModel);
                if (this.foregroundImageDrawable != null) {
                    this.foregroundImageDrawable.setAlpha(f2);
                    this.foregroundImageDrawable.setColor(instrumentsModel.get_foregroundColor().getCurrentColor());
                    this.foregroundImageDrawable.draw();
                    this.errorAlreadyLogged[1] = false;
                }
            }
            catch (IOException iOException) {
                if (this.errorAlreadyLogged[1]) break block3;
                LOGGER.error(1, new StringBuffer().append("AbstractInstrumentsUI: foreground image not found: ").append(iOException.getMessage()).toString());
                this.errorAlreadyLogged[1] = true;
            }
        }
    }

    private void updateForegroundDrawable(Graphics3D graphics3D, InstrumentsModel instrumentsModel) {
        Image image = instrumentsModel.get_foregroundImage();
        this.foregroundImageDrawable = AbstractInstrumentsUI.updateScaleImageDrawable(graphics3D, instrumentsModel, this.foregroundImageDrawable, image, true);
    }

    static {
        CLIP_COLOR = new Color4f(0, 0, 0, 0);
    }
}

