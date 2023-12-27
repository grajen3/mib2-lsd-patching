/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.event.HMIEvent;
import de.vw.mib.event.TouchEvent;
import de.vw.mib.timer.Timer;
import de.vw.mib.widgets.animation.DragCalculator;
import de.vw.mib.widgets.controller.AbstractWidgetController;
import de.vw.mib.widgets.controller.DefaultPictureViewerController$1;
import de.vw.mib.widgets.controller.PictureViewerController;
import de.vw.mib.widgets.internal.ServiceManager;
import de.vw.mib.widgets.models.PictureViewerModel;

public final class DefaultPictureViewerController
extends AbstractWidgetController
implements PictureViewerController {
    private static final int FLICK_THRESHOLD;
    private static final boolean PREFETCH_DELAYED_IMAGES;
    private static final String TIMER_NAME;
    private boolean forbidFurtherEvents;
    private boolean enableFlick;
    private Timer slideshowTimer;
    private int zoomStartValue;
    private int digitDistanceStartValue;
    private boolean enableSnap;

    @Override
    protected void reset() {
        super.reset();
        this.slideshowTimer = null;
        this.forbidFurtherEvents = false;
    }

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void deActivate() {
        PictureViewerModel pictureViewerModel;
        if (this.slideshowTimer != null) {
            this.slideshowTimer.stop();
        }
        if ((pictureViewerModel = (PictureViewerModel)this.getWidget()).isImageCurrentlyLoading()) {
            this.fire_loadingFinished();
        }
        super.deActivate();
    }

    @Override
    public void activate() {
        super.activate();
        PictureViewerModel pictureViewerModel = (PictureViewerModel)this.getWidget();
        if (pictureViewerModel.isImageCurrentlyLoading()) {
            this.fire_loadingStarted();
        }
    }

    @Override
    public void selectNextImageDelayed(int n) {
        if (this.slideshowTimer == null) {
            this.slideshowTimer = ServiceManager.timerManager.createTimer("DefaultPictureViewerController.SlideshowTimer", n, false, new DefaultPictureViewerController$1(this), ServiceManager.eventDispatcher);
        } else {
            this.slideshowTimer.setDelay(n);
        }
        this.slideshowTimer.start();
    }

    @Override
    public void cancelSelectNextImageDelayed() {
        if (this.slideshowTimer != null && this.slideshowTimer.isStarted()) {
            this.slideshowTimer.stop();
        }
    }

    private void resetSlideShowTimer() {
        if (this.slideshowTimer != null && this.slideshowTimer.isStarted()) {
            PictureViewerModel pictureViewerModel = (PictureViewerModel)this.getWidget();
            this.slideshowTimer.setDelayFromNow(pictureViewerModel.get_slideShowDelay());
        }
    }

    @Override
    public boolean consumeHMIEvent(HMIEvent hMIEvent, String string) {
        PictureViewerModel pictureViewerModel = (PictureViewerModel)this.getWidget();
        this.resetSlideShowTimer();
        if (!pictureViewerModel.isInteractionAllowed()) {
            return false;
        }
        if (string == "rotateClockwise") {
            this.consume_rotateCW();
        } else if (string == "rotateCounterClockwise") {
            this.consume_rotateCCW();
        } else if (string == "setNextImage") {
            this.consume_setNextImage();
        } else if (string == "setPrevImage") {
            this.consume_setPrevImage();
        } else if (string == "increaseZoom") {
            this.consume_increaseZoom();
        } else if (string == "decreaseZoom") {
            this.consume_decreaseZoom();
        } else if (string == "resetZoom") {
            this.consume_resetZoom();
        } else {
            return false;
        }
        return true;
    }

    @Override
    public boolean consumeTouchEvent(TouchEvent touchEvent) {
        PictureViewerModel pictureViewerModel = (PictureViewerModel)this.getWidget();
        boolean bl = false;
        if (pictureViewerModel.isInteractionAllowed()) {
            this.resetSlideShowTimer();
            switch (touchEvent.getType()) {
                case 1: {
                    this.consumePress(touchEvent.getX(), touchEvent.getY(), 1.0f);
                    bl = true;
                    break;
                }
                case 6: {
                    this.consumePress(touchEvent.getX(), touchEvent.getY(), 1.0f);
                    this.digitDistanceStartValue = touchEvent.getZDelta();
                    this.zoomStartValue = pictureViewerModel.get_zoom();
                    this.enableFlick = false;
                    bl = true;
                    break;
                }
                case 3: 
                case 4: {
                    this.consumeDrag(touchEvent.getX(), touchEvent.getY(), touchEvent.getTimestamp());
                    this.enableSnap = true;
                    bl = pictureViewerModel.getDragDataStorage().dragActive;
                    break;
                }
                case 2: {
                    if (touchEvent.getGestureParam1() == 2) {
                        this.consumeClick2(touchEvent.getX(), touchEvent.getY());
                        bl = true;
                        break;
                    }
                    bl = this.consumeRelease(touchEvent.getX(), touchEvent.getY(), touchEvent.getTimestamp());
                    break;
                }
                case 0: {
                    if (this.enableSnap) {
                        bl = this.consumeRelease(touchEvent.getX(), touchEvent.getY(), touchEvent.getTimestamp());
                        break;
                    }
                    bl = true;
                    break;
                }
                case 11: {
                    break;
                }
                case 5: {
                    this.consumeRotate(touchEvent.getGestureParam1());
                    this.zoomStartValue = pictureViewerModel.get_zoom();
                    this.digitDistanceStartValue = touchEvent.getZDelta();
                    this.enableFlick = false;
                    this.enableSnap = false;
                    bl = true;
                    break;
                }
                case 7: 
                case 8: 
                case 9: {
                    this.consumeZoom(touchEvent.getX(), touchEvent.getY(), touchEvent.getTimestamp(), touchEvent.getZDelta(), touchEvent.getGestureParam1());
                    this.enableFlick = false;
                    this.enableSnap = false;
                    bl = true;
                    break;
                }
            }
        }
        return bl;
    }

    private boolean consumeFlick(int n, int n2) {
        if (!this.forbidFurtherEvents && Math.abs(n) > 15 && Math.abs(n) > Math.abs(2 * n2)) {
            this.forbidFurtherEvents = true;
            if (n < 0) {
                this.fire_requestNextImage();
            } else {
                this.fire_requestPrevImage();
            }
            return true;
        }
        return false;
    }

    private void consumeZoom(int n, int n2, int n3, int n4, int n5) {
        PictureViewerModel pictureViewerModel = (PictureViewerModel)this.getWidget();
        this.consumeDrag(n, n2, n3);
        float f2 = this.zoomStartValue != 0 && this.digitDistanceStartValue != 0 ? (float)this.zoomStartValue * ((float)n4 / (float)this.digitDistanceStartValue) : (float)pictureViewerModel.get_zoom() * ((float)n4 / (float)(n4 - n5));
        if (!pictureViewerModel.updateZoom(f2, n - pictureViewerModel.getAbsX() - (pictureViewerModel.get_width() >> 1), n2 - pictureViewerModel.getAbsY() - (pictureViewerModel.get_height() >> 1), false)) {
            this.digitDistanceStartValue = n4;
            this.zoomStartValue = pictureViewerModel.get_zoom();
        }
        this.consumePress(n, n2, 1.0f);
    }

    private void consumeClick2(int n, int n2) {
        PictureViewerModel pictureViewerModel = (PictureViewerModel)this.getWidget();
        if (pictureViewerModel.get_zoom() != pictureViewerModel.get_zoomInitial()) {
            pictureViewerModel.resetZoom();
        } else {
            pictureViewerModel.updateZoom(pictureViewerModel.get_zoomMax(), n - pictureViewerModel.getAbsX() - (pictureViewerModel.get_width() >> 1), n2 - pictureViewerModel.getAbsY() - (pictureViewerModel.get_height() >> 1), true);
        }
    }

    private void consumeRotate(int n) {
        if (n > 0) {
            this.consume_rotateCW();
        } else {
            this.consume_rotateCCW();
        }
    }

    private boolean consumeRelease(int n, int n2, int n3) {
        boolean bl = false;
        if (!this.forbidFurtherEvents) {
            PictureViewerModel pictureViewerModel = (PictureViewerModel)this.getWidget();
            int n4 = n - pictureViewerModel.getDragDataStorage().initialTouchPoint.x;
            int n5 = n2 - pictureViewerModel.getDragDataStorage().initialTouchPoint.y;
            if (!(this.enableFlick && pictureViewerModel.isGestureFlickEnabled() && this.consumeFlick(n4, n5))) {
                DragCalculator.snap(pictureViewerModel, n, n2, n3);
            } else {
                bl = true;
            }
        }
        this.enableFlick = true;
        this.forbidFurtherEvents = false;
        return bl;
    }

    private void consumePress(int n, int n2, float f2) {
        PictureViewerModel pictureViewerModel = (PictureViewerModel)this.getWidget();
        DragCalculator.startDrag(pictureViewerModel, n, n2, f2);
        pictureViewerModel.stopSnappingAnimation();
        this.forbidFurtherEvents = !pictureViewerModel.isInteractionAllowed();
    }

    private void consumeDrag(int n, int n2, int n3) {
        if (!this.forbidFurtherEvents) {
            PictureViewerModel pictureViewerModel = (PictureViewerModel)this.getWidget();
            DragCalculator.drag(pictureViewerModel, n, n2, n3);
        }
    }

    private void consume_setNextImage() {
        this.fire_requestNextImage();
    }

    private void consume_setPrevImage() {
        this.fire_requestPrevImage();
    }

    private void consume_rotateCW() {
        PictureViewerModel pictureViewerModel = (PictureViewerModel)this.getWidget();
        pictureViewerModel.rotateClockwise();
    }

    public void consume_rotateCCW() {
        PictureViewerModel pictureViewerModel = (PictureViewerModel)this.getWidget();
        pictureViewerModel.rotateCounterClockwise();
    }

    public void consume_increaseZoom() {
        PictureViewerModel pictureViewerModel = (PictureViewerModel)this.getWidget();
        pictureViewerModel.increaseZoom();
    }

    public void consume_decreaseZoom() {
        PictureViewerModel pictureViewerModel = (PictureViewerModel)this.getWidget();
        pictureViewerModel.decreaseZoom();
    }

    public void consume_resetZoom() {
        PictureViewerModel pictureViewerModel = (PictureViewerModel)this.getWidget();
        pictureViewerModel.resetZoom();
    }

    @Override
    public void fire_requestNextImage() {
        PictureViewerModel pictureViewerModel = (PictureViewerModel)this.getWidget();
        pictureViewerModel.setFlickDirection(0);
        this.fireHMIEvent("requestNextImage");
    }

    @Override
    public void fire_requestPrevImage() {
        PictureViewerModel pictureViewerModel = (PictureViewerModel)this.getWidget();
        pictureViewerModel.setFlickDirection(1);
        this.fireHMIEvent("requestPrevImage");
    }

    @Override
    public void fire_loadingFinished() {
        if (LOGGER.isTraceEnabled(512)) {
            LOGGER.trace(512, "PictureViewerController fires: Image loading finished.");
        }
        this.fireHMIEvent("loadingFinished");
    }

    @Override
    public void fire_loadingStarted() {
        if (LOGGER.isTraceEnabled(512)) {
            LOGGER.trace(512, "PictureViewerController fires: Image loading started.");
        }
        this.fireHMIEvent("loadingStarted");
    }
}

