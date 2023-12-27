/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui;

import de.vw.mib.graphics.Camera;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.math.algebra.Matrix4f;
import de.vw.mib.graphics.math.geometry.Point3f;
import de.vw.mib.widgets.AbstractWidget;
import de.vw.mib.widgets.models.TransformContainerModel;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.models.WidgetModel;
import de.vw.mib.widgets.ui.ContainerUI;

public class TransformContainerUI
extends ContainerUI {
    public static final boolean PERSPECTIVE_PROJECTION;
    public static final float PERSPECTIVE_PROJECTION_NEAR;
    public static final float PERSPECTIVE_PROJECTION_FAR;
    public static final float PERSPECTIVE_PROJECTION_FOV;
    private static final Point3f ZERO;
    private static final Point3f X_AXIS;
    private static final Point3f Y_AXIS;
    private static final Point3f Z_AXIS;
    private static final boolean DRAW_COORDINATE_SYSTEM;
    private Rectangle viewport;
    private Matrix4f projectionMatrixBackup;
    private Matrix4f projectionMatrix;

    @Override
    public void deInit() {
        super.deInit();
        this.projectionMatrix = null;
        this.projectionMatrixBackup = null;
        this.projectionMatrixBackup = null;
        this.viewport = null;
    }

    @Override
    public void paint(Graphics3D graphics3D, ViewModel viewModel, WidgetModel widgetModel, Rectangle rectangle, Rectangle rectangle2, float f2) {
        TransformContainerModel transformContainerModel = (TransformContainerModel)widgetModel;
        int n = transformContainerModel.get_projectionType();
        boolean bl = false;
        transformContainerModel.validateLayout();
        if (transformContainerModel.getParent() == null || n != 0) {
            if (transformContainerModel.getParent() != null) {
                if (this.projectionMatrixBackup == null) {
                    this.projectionMatrixBackup = new Matrix4f();
                }
                graphics3D.getProjectionTransformation(this.projectionMatrixBackup);
                bl = true;
            }
            if (transformContainerModel.isInvalid() || this.projectionMatrix == null) {
                this.updateProjection(viewModel, transformContainerModel);
            }
            graphics3D.setProjectionTransformation(this.projectionMatrix);
            if (transformContainerModel.get_projectionType() != 1 || !AbstractWidget.CACHE_TRANSFORM) {
                // empty if block
            }
        }
        Rectangle rectangle3 = rectangle2;
        if (n == 3) {
            if (this.viewport == null) {
                this.viewport = new Rectangle();
            }
            graphics3D.getViewport(this.viewport);
            graphics3D.setViewport(this.viewport.x + rectangle2.x, this.viewport.y + this.viewport.height - rectangle2.y - rectangle2.height, rectangle2.width, rectangle2.height);
            rectangle2 = new Rectangle(0, 0, rectangle2.getWidth(), transformContainerModel.get_height());
        }
        this.updateOffscreenDrawables(graphics3D, viewModel, transformContainerModel, rectangle, rectangle3, transformContainerModel.getParent() != null ? transformContainerModel.getParent().getAbsZ() : 0);
        boolean bl2 = transformContainerModel.isTransformationRequired();
        if (bl2 || transformContainerModel.get_projectionType() == 3) {
            graphics3D.pushMatrix(0);
            if (!AbstractWidget.CACHE_TRANSFORM) {
                if (n == 3) {
                    graphics3D.resetMatrix(0);
                }
                if (bl2) {
                    graphics3D.translateMatrix(0, 0.0f, 0.0f, transformContainerModel.get_z());
                    float f3 = (float)transformContainerModel.get_width() * transformContainerModel.get_pivotX();
                    float f4 = (float)transformContainerModel.get_height() * transformContainerModel.get_pivotY();
                    float f5 = (float)transformContainerModel.get_depth() * transformContainerModel.get_pivotZ();
                    graphics3D.translateMatrix(0, f3, f4, f5);
                    graphics3D.rotateMatrix(0, transformContainerModel.get_rotationZ(), 0.0f, 0.0f, 1.0f);
                    graphics3D.rotateMatrix(0, transformContainerModel.get_rotationY(), 0.0f, 1.0f, 0.0f);
                    graphics3D.rotateMatrix(0, transformContainerModel.get_rotationX(), 1.0f, 0.0f, 0.0f);
                    graphics3D.scaleMatrix(0, transformContainerModel.get_scalingX(), transformContainerModel.get_scalingY(), transformContainerModel.get_scalingZ());
                    graphics3D.translateMatrix(0, -f3, -f4, -f5);
                }
            }
            super.paint(graphics3D, viewModel, transformContainerModel, rectangle, rectangle2, f2);
            graphics3D.popMatrix(0);
        } else {
            super.paint(graphics3D, viewModel, transformContainerModel, rectangle, rectangle2, f2);
        }
        if (n == 3) {
            graphics3D.setViewport(this.viewport);
        }
        if (bl) {
            graphics3D.setProjectionTransformation(this.projectionMatrixBackup);
        }
    }

    private void updateProjection(ViewModel viewModel, TransformContainerModel transformContainerModel) {
        if (this.projectionMatrix == null) {
            this.projectionMatrix = new Matrix4f();
        }
        float f2 = transformContainerModel.get_projectionNear();
        float f3 = transformContainerModel.get_projectionFar();
        float f4 = transformContainerModel.get_projectionFOV();
        float f5 = transformContainerModel.getProjectionDistance();
        switch (transformContainerModel.get_projectionType()) {
            case 0: 
            case 1: {
                Camera.setOrtographicProjection(this.projectionMatrix, 0.0f, viewModel.get_width(), viewModel.get_height(), 0.0f, 0.0f, f3);
                this.projectionMatrix.translate(0.0f, 0.0f, -f3 * 63);
                break;
            }
            case 2: {
                Camera.setPerspectiveProjection(this.projectionMatrix, f4, (float)viewModel.get_width() / (float)viewModel.get_height(), f2, f3);
                this.projectionMatrix.scale(1.0f, 32959, 1.0f);
                this.projectionMatrix.translate(-viewModel.get_width() >> 1, -viewModel.get_height() >> 1, f5);
                break;
            }
            case 3: {
                Camera.setPerspectiveProjection(this.projectionMatrix, f4, (float)transformContainerModel.get_width() / (float)transformContainerModel.get_height(), f2, f3);
                this.projectionMatrix.scale(1.0f, 32959, 1.0f);
                this.projectionMatrix.translate((float)(-transformContainerModel.get_width()) / 2.0f, (float)(-transformContainerModel.get_height()) / 2.0f, f5);
                break;
            }
            default: {
                this.projectionMatrix.setIdentity();
                throw new IllegalArgumentException(new StringBuffer().append("Widget '").append(transformContainerModel.getQualifiedName()).append("': Unsupported projection type: ").append(transformContainerModel.get_projectionType()).toString());
            }
        }
    }

    protected final void drawCoordinateSystem(Graphics3D graphics3D, float f2) {
    }

    static {
        ZERO = new Point3f(0.0f, 0.0f, 0.0f);
        X_AXIS = new Point3f(1.0f, 0.0f, 0.0f);
        Y_AXIS = new Point3f(0.0f, 1.0f, 0.0f);
        Z_AXIS = new Point3f(0.0f, 0.0f, 1.0f);
    }
}

