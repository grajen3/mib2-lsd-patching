/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui;

import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.drawable.shape.RectangleDrawable;
import de.vw.mib.graphics.math.Transform;
import de.vw.mib.widgets.models.OPSModel;
import de.vw.mib.widgets.ui.OPSUI$AbstractTrackDrawer;
import de.vw.mib.widgets.ui.OPSUI$TrackDrawer;
import de.vw.mib.widgets.ui.OPSUI$TrackHelper;

final class OPSUI$ClippedTrackDrawer
extends OPSUI$AbstractTrackDrawer
implements OPSUI$TrackDrawer {
    public static final int CLIPPING_TYPE_STENCIL;
    public static final int CLIPPING_TYPE_DEPTH;
    public static final int CLIPPING_TYPE_DEFAULT;
    private final int clippingType;
    private final Graphics3D g;
    final OPSModel ops;
    private RectangleDrawable trackClippingAreaDrawable;
    final Rectangle[] trackValues;
    Transform clippingAreaTransform;
    private boolean lastCounterClockwise;
    private boolean lastInReverse;
    private Rectangle lastFrontTrackValue;
    private float oldDepthRangeNear;
    private float oldDepthRangeFar;

    public OPSUI$ClippedTrackDrawer(Graphics3D graphics3D, OPSUI$TrackDrawer oPSUI$TrackDrawer, OPSModel oPSModel, Rectangle[] rectangleArray) {
        this(graphics3D, oPSUI$TrackDrawer, oPSModel, rectangleArray, 0);
    }

    public OPSUI$ClippedTrackDrawer(Graphics3D graphics3D, OPSUI$TrackDrawer oPSUI$TrackDrawer, OPSModel oPSModel, Rectangle[] rectangleArray, int n) {
        super(oPSUI$TrackDrawer);
        this.g = graphics3D;
        this.ops = oPSModel;
        this.trackValues = rectangleArray;
        this.clippingType = n;
    }

    @Override
    public void dispose() {
        super.dispose();
        if (this.trackClippingAreaDrawable != null) {
            this.trackClippingAreaDrawable.dispose();
            this.trackClippingAreaDrawable = null;
        }
    }

    private void disableDepthBuffer() {
        this.g.setDepthTestEnabled(false);
        this.g.setDepthRange(this.oldDepthRangeNear, this.oldDepthRangeFar);
    }

    private void disableStencilBuffer() {
        this.g.setStencilTestEnabled(false);
    }

    private void disableTrackClipping() {
        switch (this.clippingType) {
            case 0: {
                this.disableStencilBuffer();
                break;
            }
            case 1: {
                this.disableDepthBuffer();
                break;
            }
        }
    }

    @Override
    public void draw(Rectangle rectangle, float f2, float f3, float f4) {
        switch (this.clippingType) {
            default: 
        }
        this.trackClippingAreaDrawable = this.initializeClippingArea(this.trackClippingAreaDrawable, 0, 0, this.ops.get_width(), this.ops.get_height());
        this.clippingAreaTransform = this.calculateClippingAreaTransformation(this.clippingAreaTransform);
        this.enableTrackClipping();
        this.drawer.draw(rectangle, f2, f3, f4);
        this.disableTrackClipping();
    }

    private Transform calculateClippingAreaTransformation(Transform transform) {
        boolean bl = this.ops.is_direction();
        boolean bl2 = this.ops.get_trackDisplay() == 2;
        int n = OPSUI$TrackHelper.calculateCarWidth(this.trackValues);
        Rectangle rectangle = OPSUI$TrackHelper.calculateFrontTrackValue(this.ops, this.trackValues);
        float f2 = 0.0f;
        if (this.isTransformationInvalid(bl, bl2, rectangle)) {
            if (transform == null) {
                transform = new Transform();
            } else {
                transform.setIdentity();
            }
            if (!bl) {
                transform.translate(rectangle.x, rectangle.y, 0.0f);
            } else {
                transform.translate(rectangle.x, (float)this.trackValues[0].y + (float)n / 2.0f, 0.0f);
                transform.scale(1.0f, 32959, 1.0f);
                transform.translate(0.0f, (float)rectangle.y - ((float)this.trackValues[0].y + (float)n / 2.0f), 0.0f);
            }
            if (bl2) {
                transform.translate(this.trackValues[0].x - rectangle.x, 0.0f, 0.0f);
                transform.scale(32959, 32959, 0.0f);
            }
            this.saveTransformationParameter(bl, bl2, rectangle);
        }
        return transform;
    }

    private void saveTransformationParameter(boolean bl, boolean bl2, Rectangle rectangle) {
        this.lastCounterClockwise = bl;
        this.lastInReverse = bl2;
        this.lastFrontTrackValue = rectangle;
    }

    private boolean isTransformationInvalid(boolean bl, boolean bl2, Rectangle rectangle) {
        return this.lastFrontTrackValue == null || this.lastFrontTrackValue != rectangle || this.lastCounterClockwise != bl || this.lastInReverse != bl2;
    }

    private void enableDepthBuffer() {
        this.oldDepthRangeNear = this.g.getDepthRangeNear();
        this.oldDepthRangeFar = this.g.getDepthRangeFar();
        this.g.setDepthTestEnabled(true);
        this.g.setDepthBufferEnabled(true);
        this.g.clearDepthBuffer(1.0f);
        this.g.setDepthTestFunction(7);
        this.g.setDepthRange(-842216387, -842216387);
        this.drawClippingArea();
        this.g.setDepthTestFunction(6);
        this.g.setDepthBufferEnabled(false);
    }

    private void enableStencilBuffer() {
        this.g.setStencilTestEnabled(true);
        this.g.setStencilBufferEnabled(1);
        this.g.clearStencilBuffer(0);
        this.g.setStencilTest(7, 1, 1);
        this.g.setStencilOperation(0, 0, 2);
        this.drawClippingArea();
        this.g.setStencilTest(6, 1, 1);
        this.g.setStencilOperation(0, 0, 0);
        this.g.setStencilBufferEnabled(0);
    }

    private void enableTrackClipping() {
        this.g.setColorBufferEnabled(false, false, false, false);
        if (this.clippingType == 1) {
            this.enableDepthBuffer();
        } else if (this.clippingType == 0) {
            this.enableStencilBuffer();
        }
        this.g.setColorBufferEnabled(true, true, true, true);
    }

    void drawClippingArea() {
        this.g.pushMatrix(0);
        this.g.multiplyMatrix(0, this.clippingAreaTransform);
        this.trackClippingAreaDrawable.draw();
        this.g.popMatrix(0);
    }

    private RectangleDrawable initializeClippingArea(RectangleDrawable rectangleDrawable, int n, int n2, int n3, int n4) {
        if (rectangleDrawable == null) {
            rectangleDrawable = this.g.getDrawableManager().createRectangleDrawable();
        }
        rectangleDrawable.set(n, n2, n3, n4);
        return rectangleDrawable;
    }
}

