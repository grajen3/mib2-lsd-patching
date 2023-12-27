/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.graphics.Color;
import de.vw.mib.graphics.Insets;
import de.vw.mib.graphics.Point;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.image.BufferImage;
import de.vw.mib.graphics.image.ExifInfo;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.graphics.math.Util;
import de.vw.mib.widgets.DynamicImage;
import de.vw.mib.widgets.DynamicImage$Transition;
import de.vw.mib.widgets.PictureViewer$ImagePrefetcher;
import de.vw.mib.widgets.PictureViewer$RotationAnimation;
import de.vw.mib.widgets.PictureViewer$SnappingAnimation;
import de.vw.mib.widgets.PictureViewer$ZoomAnimation;
import de.vw.mib.widgets.controller.PictureViewerController;
import de.vw.mib.widgets.interfaces.Draggable$DragDataStorage;
import de.vw.mib.widgets.models.DynamicImageModel$Picture;
import de.vw.mib.widgets.models.PictureViewerModel;
import de.vw.mib.widgets.models.ViewModel;
import org.dsi.ifc.global.ResourceLocator;

public class PictureViewer
extends DynamicImage
implements PictureViewerModel {
    private int zoom;
    private int zoomInitial;
    private int zoomMax;
    private int zoomMin;
    private int zoomStep;
    private int rotationAngle;
    private int transitionPrevImageIn;
    private int transitionPrevImageOut;
    private int slideShowDelay;
    private PictureViewer$RotationAnimation rotationAnimation;
    private PictureViewer$ZoomAnimation zoomAnimation;
    private PictureViewer$SnappingAnimation snappingAnimation;
    private int flickDirection;
    private Point zoomCenter;
    private Draggable$DragDataStorage dragDataStorage;
    private final PictureViewer$ImagePrefetcher imagePrefetcher = new PictureViewer$ImagePrefetcher(this);
    private int prefetchCount;
    static /* synthetic */ Class class$de$vw$mib$widgets$ui$PictureViewerUI;

    @Override
    protected void reset() {
        super.reset();
        this.rotationAnimation = new PictureViewer$RotationAnimation(this);
        this.zoomAnimation = new PictureViewer$ZoomAnimation(this);
        this.zoomCenter = new Point();
        this.dragDataStorage = new Draggable$DragDataStorage();
        this.dragDataStorage.useThreshold = true;
        this.snappingAnimation = new PictureViewer$SnappingAnimation(this);
        this.setInternalStateFlag(18, false);
        this.setImmediateAnimations(true);
        this.setLimitMaxResourceSize(true);
    }

    public void init(boolean bl, int n, boolean bl2, Color color, int n2, Image image, Color color2, int n3, Insets insets, Color color3, Color color4, boolean bl3, Color color5, Color color6, EasingParams[] easingParamsArray, boolean bl4, int n4, Image image2, Image image3, Image image4, ResourceLocator resourceLocator, boolean bl5, String string, boolean bl6, int n5, Image image5, int n6, boolean bl7, int n7, int n8, boolean bl8, int n9, boolean bl9, Insets insets2, int n10, int n11, int n12, int n13, boolean bl10, boolean bl11, int n14, int n15, int n16, int n17, int n18, int n19, int n20, int n21, int n22) {
        super.init(bl, n, bl2, color, n2, image, color2, n3, insets, color3, color4, bl3, color5, color6, easingParamsArray, bl4, n4, image2, image3, image4, resourceLocator, bl5, string, bl6, n5, image5, n6, bl7, n9, bl9, insets2, n10, n11, bl10, bl11, n14, n15, n16, n22);
        this.zoomInitial = n18;
        this.zoomMax = n19;
        this.zoomMin = n20;
        this.zoomStep = n21;
        this.zoom = n17;
        this.rotationAngle = n7;
        this.transitionPrevImageIn = n12;
        this.transitionPrevImageOut = n13;
        this.slideShowDelay = n8;
        this.setInternalStateFlag(17, bl8);
    }

    @Override
    public void init(ViewModel viewModel) {
        super.init(viewModel);
        this.prefetchCount = 0;
        this.zoomCenter.setLocation(0, 0);
        this.setFlickDirection(0);
    }

    @Override
    public void deInit() {
        super.deInit();
    }

    @Override
    public Class[] getCompatibleUIClasses() {
        return new Class[]{class$de$vw$mib$widgets$ui$PictureViewerUI == null ? (class$de$vw$mib$widgets$ui$PictureViewerUI = PictureViewer.class$("de.vw.mib.widgets.ui.PictureViewerUI")) : class$de$vw$mib$widgets$ui$PictureViewerUI};
    }

    @Override
    public final int get_zoom() {
        return this.zoom;
    }

    @Override
    public final void set_zoom(int n) {
        int n2 = this.zoom;
        if (n2 != n) {
            this.zoom = n;
            this.zoomChanged(n2);
            this.propertyChanged(41);
        }
    }

    @Override
    public final void set_zoomInitial(int n) {
        int n2 = this.zoomInitial;
        if (n2 != n) {
            this.zoomInitial = n;
            this.zoomInitialChanged(n2);
            this.propertyChanged(42);
        }
    }

    @Override
    public final int get_zoomInitial() {
        return this.zoomInitial;
    }

    @Override
    public final void set_zoomStep(int n) {
        int n2 = this.zoomStep;
        if (n2 != n) {
            this.zoomStep = n;
            this.zoomStepChanged(n2);
            this.propertyChanged(45);
        }
    }

    @Override
    public final int get_zoomStep() {
        return this.zoomStep;
    }

    @Override
    public final void set_zoomMin(int n) {
        int n2 = this.zoomMin;
        if (n2 != n) {
            this.zoomMin = n;
            this.zoomMinChanged(n2);
            this.propertyChanged(43);
        }
    }

    @Override
    public final int get_zoomMin() {
        return this.zoomMin;
    }

    @Override
    public final void set_zoomMax(int n) {
        int n2 = this.zoomMax;
        if (n2 != n) {
            this.zoomMax = n;
            this.zoomMaxChanged(n2);
            this.propertyChanged(44);
        }
    }

    @Override
    public final int get_zoomMax() {
        return this.zoomMax;
    }

    @Override
    public final int get_rotationAngle() {
        return this.rotationAngle;
    }

    @Override
    public final void set_rotationAngle(int n) {
        int n2 = this.rotationAngle;
        if (n2 != n) {
            this.rotationAngle = n;
            this.rotationAngleChanged(n2);
            this.propertyChanged(46);
        }
    }

    @Override
    public final int get_transitionPrevImageIn() {
        return this.transitionPrevImageIn;
    }

    @Override
    public final void set_transitionPrevImageIn(int n) {
        int n2 = this.transitionPrevImageIn;
        if (n2 != n) {
            this.transitionPrevImageIn = n;
            this.transitionPrevImageInChanged(n2);
            this.propertyChanged(47);
        }
    }

    @Override
    public final int get_transitionPrevImageOut() {
        return this.transitionPrevImageOut;
    }

    @Override
    public final void set_transitionPrevImageOut(int n) {
        int n2 = this.transitionPrevImageOut;
        if (n2 != n) {
            this.transitionPrevImageOut = n;
            this.transitionPrevImageInChanged(n2);
            this.propertyChanged(48);
        }
    }

    @Override
    public boolean is_slideShowEnabled() {
        return this.getInternalStateFlag(17);
    }

    @Override
    public void set_slideShowEnabled(boolean bl) {
        boolean bl2 = this.is_slideShowEnabled();
        if (bl2 != bl) {
            this.setInternalStateFlag(17, bl);
            this.slideShowEnabledChanged(bl2);
            this.propertyChanged(49);
        }
    }

    @Override
    public int get_slideShowDelay() {
        return this.slideShowDelay;
    }

    @Override
    public void set_slideShowDelay(int n) {
        int n2 = this.slideShowDelay;
        if (n2 != n) {
            this.slideShowDelay = n;
            this.slideShowDelayChanged(n2);
            this.propertyChanged(50);
        }
    }

    @Override
    public void setFlickDirection(int n) {
        this.flickDirection = n;
    }

    @Override
    public int getFlickDirection() {
        return this.flickDirection;
    }

    @Override
    public boolean isInteractionAllowed() {
        return this.isImageLoadingComplete() && !this.rotationAnimation.isActive() && !this.zoomAnimation.isActive();
    }

    @Override
    public boolean isGestureFlickEnabled() {
        DynamicImageModel$Picture dynamicImageModel$Picture = this.getCurrentPicture();
        return dynamicImageModel$Picture == null || dynamicImageModel$Picture.getZoomedBoundingBoxWidth() <= this.get_width();
    }

    @Override
    protected DynamicImage$Transition getInTransition() {
        if (this.flickDirection == 0) {
            return super.getInTransition();
        }
        switch (this.get_transitionPrevImageIn()) {
            case 2: {
                return DynamicImage$Transition.FLY_IN_WEST;
            }
            case 1: {
                return DynamicImage$Transition.FLY_IN_EAST;
            }
            case 3: {
                return DynamicImage$Transition.FADE_IN;
            }
        }
        return null;
    }

    @Override
    protected DynamicImage$Transition getOutTransition() {
        if (this.flickDirection == 0) {
            return super.getOutTransition();
        }
        switch (this.get_transitionPrevImageOut()) {
            case 2: {
                return DynamicImage$Transition.FLY_OUT_WEST;
            }
            case 1: {
                return DynamicImage$Transition.FLY_OUT_EAST;
            }
            case 3: {
                return DynamicImage$Transition.FADE_OUT;
            }
        }
        return null;
    }

    @Override
    public boolean isImageCurrentlyLoading() {
        return this.getInternalStateFlag(18);
    }

    @Override
    public void setPrefetchCount(int n) {
        this.prefetchCount = n;
    }

    @Override
    protected void loadingStateChanged(int n, int n2) {
        super.loadingStateChanged(n, n2);
        PictureViewerController pictureViewerController = (PictureViewerController)this.getController();
        if (pictureViewerController != null) {
            if (n2 == 1) {
                this.setInternalStateFlag(18, true);
                ((PictureViewerController)this.getController()).fire_loadingStarted();
            } else if (n == 1) {
                this.setInternalStateFlag(18, false);
                ((PictureViewerController)this.getController()).fire_loadingFinished();
            }
        }
    }

    protected void zoomChanged(int n) {
        float f2 = (float)this.get_zoom() / 51266;
        Insets insets = this.get_borderImagePadding();
        DynamicImageModel$Picture dynamicImageModel$Picture = this.getCurrentPicture();
        if (dynamicImageModel$Picture != null && dynamicImageModel$Picture.isDynamicResource()) {
            float f3;
            float f4;
            int n2 = (int)((float)dynamicImageModel$Picture.getBoundingBoxWidth() * f2);
            int n3 = (int)((float)dynamicImageModel$Picture.getBoundingBoxHeight() * f2);
            if (n2 < this.get_width()) {
                f4 = 0.0f;
            } else {
                f4 = (float)this.zoomCenter.x + f2 / dynamicImageModel$Picture.getZoomFactor() * (dynamicImageModel$Picture.getCenterX() - (float)this.zoomCenter.x);
                f4 = PictureViewer.clampPicturePosition(this.get_width() - insets.left - insets.right, n2, f4);
            }
            if (n3 < this.get_height()) {
                f3 = 0.0f;
            } else {
                f3 = (float)this.zoomCenter.y + f2 / dynamicImageModel$Picture.getZoomFactor() * (dynamicImageModel$Picture.getCenterY() - (float)this.zoomCenter.y);
                f3 = PictureViewer.clampPicturePosition(this.get_height() - insets.top - insets.bottom, n3, f3);
            }
            if (!this.startZoomAnimation(this.get_zoom(), f4, f3)) {
                dynamicImageModel$Picture.setZoomFactor(f2);
                dynamicImageModel$Picture.setCenterX(f4);
                dynamicImageModel$Picture.setCenterY(f3);
                this.repaint();
            }
        }
    }

    protected void zoomInitialChanged(int n) {
    }

    protected void zoomMinChanged(int n) {
    }

    protected void zoomMaxChanged(int n) {
    }

    protected void zoomStepChanged(int n) {
    }

    protected void slideShowEnabledChanged(boolean bl) {
        PictureViewerController pictureViewerController = (PictureViewerController)this.getController();
        if (pictureViewerController != null) {
            if (bl) {
                pictureViewerController.cancelSelectNextImageDelayed();
            } else {
                pictureViewerController.selectNextImageDelayed(this.slideShowDelay);
            }
        }
    }

    protected void slideShowDelayChanged(int n) {
        PictureViewerController pictureViewerController = (PictureViewerController)this.getController();
        if (pictureViewerController != null) {
            pictureViewerController.cancelSelectNextImageDelayed();
            pictureViewerController.selectNextImageDelayed(this.slideShowDelay);
        }
    }

    protected void rotationAngleChanged(int n) {
        DynamicImageModel$Picture dynamicImageModel$Picture;
        this.set_zoom(this.zoomInitial);
        if (!this.startRotationAnimation() && (dynamicImageModel$Picture = this.getCurrentPicture()) != null) {
            dynamicImageModel$Picture.setRotationZ(this.rotationAngle);
            this.repaint();
        }
    }

    @Override
    protected void imageResourceChanged(ResourceLocator resourceLocator) {
        if (this.prefetchCount > 0) {
            this.imagePrefetcher.prefetchImage(this.get_imageResource(), this.is_prescaleResource());
            --this.prefetchCount;
        } else {
            super.imageResourceChanged(resourceLocator);
            this.zoom = 100;
            this.rotationAngle = 0;
        }
    }

    protected void transitionPrevImageInChanged(int n) {
    }

    protected void transitionPrevImageOutChanged(int n) {
    }

    @Override
    protected void imageLoadingSuccess(BufferImage bufferImage, ExifInfo exifInfo, int n) {
        super.imageLoadingSuccess(bufferImage, exifInfo, n);
        PictureViewerController pictureViewerController = (PictureViewerController)this.getController();
        if (this.is_slideShowEnabled()) {
            pictureViewerController.selectNextImageDelayed(this.slideShowDelay);
        }
    }

    @Override
    protected void imageLoadingFailure() {
        super.imageLoadingFailure();
        PictureViewerController pictureViewerController = (PictureViewerController)this.getController();
        if (this.is_slideShowEnabled()) {
            pictureViewerController.selectNextImageDelayed(this.slideShowDelay);
        }
    }

    @Override
    public void increaseZoom() {
        int n = Math.min(this.zoom + this.zoomStep, this.zoomMax);
        this.set_zoom(n);
    }

    @Override
    public void decreaseZoom() {
        int n = Math.max(this.zoom - this.zoomStep, this.zoomMin);
        this.set_zoom(n);
    }

    @Override
    public void resetZoom() {
        this.set_zoom(this.zoomInitial);
    }

    @Override
    public void rotateClockwise() {
        DynamicImageModel$Picture dynamicImageModel$Picture = this.getCurrentPicture();
        if (dynamicImageModel$Picture != null && dynamicImageModel$Picture.isDynamicResource()) {
            this.set_rotationAngle(this.rotationAngle + 90);
        }
    }

    @Override
    public void rotateCounterClockwise() {
        DynamicImageModel$Picture dynamicImageModel$Picture = this.getCurrentPicture();
        if (dynamicImageModel$Picture != null && dynamicImageModel$Picture.isDynamicResource()) {
            this.set_rotationAngle(this.rotationAngle - 90);
        }
    }

    @Override
    public boolean updateZoom(float f2, int n, int n2, boolean bl) {
        int n3;
        DynamicImageModel$Picture dynamicImageModel$Picture = this.getCurrentPicture();
        if (dynamicImageModel$Picture != null && dynamicImageModel$Picture.isDynamicResource() && (n3 = Util.clamp((int)f2, this.zoomMin, this.zoomMax)) != this.get_zoom()) {
            if (!bl) {
                this.disableAnimations();
            }
            this.zoomCenter.setLocation(n, n2);
            this.set_zoom(n3);
            this.zoomCenter.setLocation(0, 0);
            if (!bl) {
                this.enableAnimations();
            }
            return n3 != this.zoomMin && n3 != this.zoomMax;
        }
        return false;
    }

    private static float clampPicturePosition(int n, int n2, float f2) {
        int n3 = n2 >> 1;
        int n4 = n >> 1;
        if (n3 < n4) {
            return 0.0f;
        }
        if ((float)(n4 - n3) + f2 > 0.0f) {
            return -n4 + n3;
        }
        if ((float)(n4 + n3) + f2 < (float)n) {
            return n4 - n3;
        }
        return f2;
    }

    @Override
    public void getVisualAreaBounds(Rectangle rectangle) {
        DynamicImageModel$Picture dynamicImageModel$Picture = this.getCurrentPicture();
        if (dynamicImageModel$Picture != null) {
            if (dynamicImageModel$Picture.isDynamicResource() && this.get_borderImageMode() == 1) {
                Insets insets = this.get_borderImagePadding();
                rectangle.setBounds(insets.left, insets.top, dynamicImageModel$Picture.getZoomedBoundingBoxWidth() - insets.right, dynamicImageModel$Picture.getZoomedBoundingBoxHeight() - insets.bottom);
            } else {
                rectangle.setBounds(Math.min((dynamicImageModel$Picture.getZoomedBoundingBoxWidth() >> 1) - (this.get_width() >> 1), 0), Math.min((dynamicImageModel$Picture.getZoomedBoundingBoxHeight() >> 1) - (this.get_height() >> 1), 0), dynamicImageModel$Picture.getZoomedBoundingBoxWidth(), dynamicImageModel$Picture.getZoomedBoundingBoxHeight());
            }
        }
    }

    @Override
    public void getViewPort(Rectangle rectangle) {
        int n = this.getViewportX();
        int n2 = this.getViewportY();
        rectangle.setBounds(n, n2, this.get_width(), this.get_height());
    }

    @Override
    public void setViewportPosition(int n, int n2) {
        this.setViewportPositionX(n);
        this.setViewportPositionY(n2);
        this.repaint();
    }

    @Override
    public boolean useDragDeceleration() {
        return true;
    }

    @Override
    public int getMaxDraggingSpeed() {
        return Math.max(this.get_width(), this.get_height());
    }

    protected final int getViewportX() {
        DynamicImageModel$Picture dynamicImageModel$Picture = this.getCurrentPicture();
        return dynamicImageModel$Picture == null ? 0 : (int)((float)((dynamicImageModel$Picture.getZoomedBoundingBoxWidth() >> 1) - (this.get_width() >> 1)) - dynamicImageModel$Picture.getCenterX());
    }

    protected final int getViewportY() {
        DynamicImageModel$Picture dynamicImageModel$Picture = this.getCurrentPicture();
        return dynamicImageModel$Picture == null ? 0 : (int)((float)((dynamicImageModel$Picture.getZoomedBoundingBoxHeight() >> 1) - (this.get_height() >> 1)) - dynamicImageModel$Picture.getCenterY());
    }

    private void setViewportPositionX(int n) {
        DynamicImageModel$Picture dynamicImageModel$Picture = this.getCurrentPicture();
        if (dynamicImageModel$Picture != null) {
            int n2 = (dynamicImageModel$Picture.getZoomedBoundingBoxWidth() >> 1) - (this.get_width() >> 1) - n;
            dynamicImageModel$Picture.setCenterX(n2);
        }
    }

    private void setViewportPositionY(int n) {
        DynamicImageModel$Picture dynamicImageModel$Picture = this.getCurrentPicture();
        if (dynamicImageModel$Picture != null) {
            int n2 = (dynamicImageModel$Picture.getZoomedBoundingBoxHeight() >> 1) - (this.get_height() >> 1) - n;
            dynamicImageModel$Picture.setCenterY(n2);
        }
    }

    @Override
    public Draggable$DragDataStorage getDragDataStorage() {
        return this.dragDataStorage;
    }

    @Override
    public boolean adaptSnapPosition(Point point, int n) {
        return false;
    }

    @Override
    public void startDragging() {
    }

    @Override
    public void stopDragging() {
    }

    @Override
    public void stopInternalAnimations() {
        super.stopInternalAnimations();
        this.disableAnimations();
        this.stopSnappingAnimation();
        this.stopRotationAnimation();
        this.stopZoomAnimation();
        this.enableAnimations();
    }

    private boolean startRotationAnimation() {
        this.stopRotationAnimation();
        EasingParams easingParams = this.getEasing(9);
        DynamicImageModel$Picture dynamicImageModel$Picture = this.getCurrentPicture();
        if (easingParams == null || dynamicImageModel$Picture == null) {
            return false;
        }
        this.rotationAnimation.setAnimationParams(dynamicImageModel$Picture, easingParams, this.rotationAngle);
        return this.startInternalAnimation(this.rotationAnimation);
    }

    private void stopRotationAnimation() {
        this.stopInternalAnimation(this.rotationAnimation);
    }

    private boolean startZoomAnimation(int n, float f2, float f3) {
        this.stopZoomAnimation();
        this.stopSnappingAnimation();
        EasingParams easingParams = this.getEasing(10);
        DynamicImageModel$Picture dynamicImageModel$Picture = this.getCurrentPicture();
        if (easingParams == null || dynamicImageModel$Picture == null) {
            return false;
        }
        this.zoomAnimation.setAnimationParams(dynamicImageModel$Picture, easingParams, (float)n / 51266, f2, f3);
        return this.startInternalAnimation(this.zoomAnimation);
    }

    private void stopZoomAnimation() {
        this.stopInternalAnimation(this.zoomAnimation);
    }

    @Override
    public void startSnapAnimation(int n, int n2, EasingParams easingParams) {
        this.stopSnappingAnimation();
        DynamicImageModel$Picture dynamicImageModel$Picture = this.getCurrentPicture();
        if (easingParams == null || dynamicImageModel$Picture == null) {
            return;
        }
        this.snappingAnimation.setAnimationParams(easingParams, n, n2);
        this.startInternalAnimation(this.snappingAnimation);
    }

    @Override
    public void stopSnappingAnimation() {
        this.stopInternalAnimation(this.snappingAnimation);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

