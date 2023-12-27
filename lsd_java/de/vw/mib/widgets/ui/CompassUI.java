/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui;

import de.vw.mib.graphics.Camera;
import de.vw.mib.graphics.Color4b;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.drawable.image.ImageDrawable;
import de.vw.mib.graphics.image.BufferImage;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.graphics.math.Transform;
import de.vw.mib.graphics.math.Util;
import de.vw.mib.graphics.math.algebra.Matrix4f;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.widgets.internal.ServiceManager;
import de.vw.mib.widgets.models.CompassModel;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.models.WidgetModel;
import de.vw.mib.widgets.ui.AbstractImageUI;
import java.io.IOException;

public final class CompassUI
extends AbstractImageUI {
    public static final float PERSPECTIVE_PROJECTION_NEAR;
    public static final float PERSPECTIVE_PROJECTION_FAR;
    public static final float PERSPECTIVE_PROJECTION_FOV;
    private final Rectangle viewport = new Rectangle();
    private ImageDrawable roseImageDrawable;
    private Transform viewTransformation;
    private Matrix4f projectionMatrix;
    private Matrix4f projectionMatrixOld = new Matrix4f();

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void deInit() {
        if (this.roseImageDrawable != null) {
            this.roseImageDrawable.dispose();
            this.roseImageDrawable = null;
        }
        super.deInit();
    }

    private static ImageDrawable updateImageDrawable(Graphics3D graphics3D, WidgetModel widgetModel, Image image, ImageDrawable imageDrawable) {
        try {
            BufferImage bufferImage = ServiceManager.imageManager.getImageFromCurrentSkin(image);
            if (imageDrawable == null) {
                imageDrawable = graphics3D.getDrawableManager().createImageDrawable();
            }
            int n = bufferImage.getWidth();
            int n2 = bufferImage.getHeight();
            boolean bl = true;
            imageDrawable.setImage(bufferImage);
            imageDrawable.setImageFilter(1);
            imageDrawable.setSourceWidth(n);
            imageDrawable.setSourceHeight(n2);
            imageDrawable.setDestinationX(-(n >> 1));
            imageDrawable.setDestinationY(-(n2 >> 1));
            imageDrawable.setDestinationWidth(n);
            imageDrawable.setDestinationHeight(n2);
        }
        catch (IOException iOException) {
            LogMessage logMessage = LOGGER.error(256);
            logMessage.append("Widget '").append(widgetModel.getQualifiedName()).append("': Unable to load image: ").attachThrowable(iOException).log();
        }
        return imageDrawable;
    }

    @Override
    public void paintImage(Graphics3D graphics3D, ViewModel viewModel, WidgetModel widgetModel, Rectangle rectangle, Rectangle rectangle2, Color4b color4b, float f2) {
        CompassModel compassModel = (CompassModel)widgetModel;
        Image image = compassModel.get_roseImage();
        if (image != null && !image.getCurrentImage().isEmpty()) {
            if (compassModel.isInvalid()) {
                this.viewTransformation = CompassUI.updateViewTransformation(compassModel, this.viewTransformation);
                this.projectionMatrix = CompassUI.updateProjectionMatrix(compassModel, this.projectionMatrix);
                this.roseImageDrawable = CompassUI.updateImageDrawable(graphics3D, (WidgetModel)compassModel, image, this.roseImageDrawable);
            }
            if (this.roseImageDrawable != null) {
                graphics3D.getProjectionTransformation(this.projectionMatrixOld);
                graphics3D.setProjectionTransformation(this.projectionMatrix);
                graphics3D.getViewport(this.viewport);
                graphics3D.setViewport(this.viewport.x + -viewModel.getAbsX() + compassModel.getAbsX(), this.viewport.y + viewModel.getAbsY() + viewModel.get_height() - compassModel.getAbsY() - compassModel.get_height(), compassModel.get_width(), compassModel.get_height());
                graphics3D.pushMatrix(0);
                graphics3D.setViewTransformation(this.viewTransformation);
                this.roseImageDrawable.setAlpha(f2);
                this.roseImageDrawable.draw();
                graphics3D.setViewport(this.viewport);
                graphics3D.popMatrix(0);
                graphics3D.setProjectionTransformation(this.projectionMatrixOld);
            }
        }
    }

    private static Transform updateViewTransformation(CompassModel compassModel, Transform transform) {
        if (transform == null) {
            transform = new Transform();
        }
        float f2 = Util.calculateOptimalDistanceByFOV(61505, compassModel.get_height());
        transform.setIdentity();
        transform.translate(0.0f, 0.0f, f2 - (float)compassModel.get_distance());
        transform.rotate(Util.toRadians(compassModel.get_rotation()), 1.0f, 0.0f, 0.0f);
        transform.rotate(Util.toRadians(compassModel.getHeadingToDraw()), 0.0f, 0.0f, 1.0f);
        return transform;
    }

    private static Matrix4f updateProjectionMatrix(CompassModel compassModel, Matrix4f matrix4f) {
        if (matrix4f == null) {
            matrix4f = new Matrix4f();
        }
        float f2 = (float)compassModel.get_width() / (float)compassModel.get_height();
        Camera.setPerspectiveProjection(matrix4f, 61505, f2, -842216387, 14723909);
        matrix4f.scale(1.0f, 32959, 1.0f);
        return matrix4f;
    }
}

