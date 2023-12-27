/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui;

import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.drawable.shape.RectangleDrawable;
import de.vw.mib.util.StringBuilder;
import de.vw.mib.widgets.models.TouchAreaModel;
import de.vw.mib.widgets.models.TouchAreaModel$ProximityDataStorage;
import de.vw.mib.widgets.models.TouchAreaModel$TouchDataStorage;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.models.WidgetModel;
import de.vw.mib.widgets.ui.TouchAreaUI;

public class TouchAreaDiagUI
extends TouchAreaUI {
    private static final int TEXTUAL_TOUCH_METRICS_Y;
    private static final int TEXTUAL_TOUCH_METRICS_COUNT;
    private static final int TEXTUAL_PROXIMITY_METRICS_Y;
    private static final int TEXTUAL_PROXIMITY_METRICS_COUNT;
    private static final int INDICATOR_TOUCH_SIZE;
    private static final int INDICATOR_PROXIMITY_SIZE;
    private static final Color4f INDICATOR_TOUCH_COLOR;
    private static final Color4f INDICATOR_PROXIMITY_COLOR;
    private static final Color4f TEXTUAL_TOUCH_METRICS_COLOR;
    private static final Color4f TEXTUAL_PROXIMITY_METRICS_COLOR;
    private static String TYPE_TEXT_TOUCH_PRESS;
    private static String TYPE_TEXT_TOUCH_RELEASE;
    private static String TYPE_TEXT_TOUCH_CLICK;
    private static String TYPE_TEXT_TOUCH_DRAG;
    private static String TYPE_TEXT_TOUCH_FLICK;
    private static String TYPE_TEXT_TOUCH_PRESS2;
    private static String TYPE_TEXT_TOUCH_ROTATE;
    private static String TYPE_TEXT_TOUCH_DRAG2;
    private static String TYPE_TEXT_TOUCH_FLICK2;
    private static String TYPE_TEXT_TOUCH_ZOOM;
    private static String TYPE_TEXT_TOUCH_RIGHTCLICK;
    private static String TYPE_TEXT_TOUCH_NONE;
    private static String TYPE_TEXT_PROXIMITY_APPEAR;
    private static String TYPE_TEXT_PROXIMITY_DISAPPEAR;
    private static String TYPE_TEXT_PROXIMITY_MOVE;
    private static String TYPE_TEXT_PROXIMITY_SWIPE_LEFT;
    private static String TYPE_TEXT_PROXIMITY_SWIPE_RIGHT;
    private static String TYPE_TEXT_PROXIMITY_NONE;
    private RectangleDrawable lineHorizonalTouch;
    private RectangleDrawable lineVerticalTouch;
    private RectangleDrawable lineHorizonalProximity;
    private RectangleDrawable lineVerticalProximity;
    private StringBuilder stringBuilder;

    @Override
    public void init() {
        super.init();
        this.stringBuilder = new StringBuilder();
        TouchAreaModel touchAreaModel = (TouchAreaModel)this.getWidget();
        touchAreaModel.setStoreTouchData(true);
        touchAreaModel.setStoreProximityData(true);
    }

    @Override
    public void deInit() {
        this.stringBuilder = null;
        TouchAreaModel touchAreaModel = (TouchAreaModel)this.getWidget();
        touchAreaModel.setStoreTouchData(false);
        touchAreaModel.setStoreProximityData(false);
        super.deInit();
    }

    @Override
    public void paint(Graphics3D graphics3D, ViewModel viewModel, WidgetModel widgetModel, Rectangle rectangle, Rectangle rectangle2, float f2) {
        super.paint(graphics3D, viewModel, widgetModel, rectangle, rectangle2, f2);
        TouchAreaModel touchAreaModel = (TouchAreaModel)widgetModel;
        this.paintTouchIndicator(graphics3D, touchAreaModel, rectangle2, f2);
        this.paintProximityIndicator(graphics3D, touchAreaModel, rectangle2, f2);
        this.paintTouchMetrics(graphics3D, touchAreaModel, rectangle2, f2);
        this.paintProximityMetrics(graphics3D, touchAreaModel, rectangle2, f2);
    }

    private void paintTouchIndicator(Graphics3D graphics3D, TouchAreaModel touchAreaModel, Rectangle rectangle, float f2) {
        TouchAreaModel$TouchDataStorage touchAreaModel$TouchDataStorage = touchAreaModel.getTouchDataStorage();
        int n = touchAreaModel$TouchDataStorage.x - 1;
        int n2 = touchAreaModel$TouchDataStorage.y - 1;
        if (touchAreaModel.isInvalid() || this.lineHorizonalTouch == null || this.lineVerticalTouch == null) {
            this.lineHorizonalTouch = TouchAreaDiagUI.updateRectangleDrawable(graphics3D, this.getWidget(), this.lineHorizonalTouch, touchAreaModel.get_x() - rectangle.x, n2 - rectangle.y, touchAreaModel.get_width(), 2);
            this.lineVerticalTouch = TouchAreaDiagUI.updateRectangleDrawable(graphics3D, this.getWidget(), this.lineVerticalTouch, n - rectangle.x, touchAreaModel.get_y() - rectangle.y, 2, touchAreaModel.get_height());
            this.lineHorizonalTouch.setColor(INDICATOR_TOUCH_COLOR);
            this.lineVerticalTouch.setColor(INDICATOR_TOUCH_COLOR);
        }
        if (this.lineHorizonalTouch != null && this.lineVerticalTouch != null) {
            this.lineHorizonalTouch.draw();
            this.lineVerticalTouch.draw();
        }
    }

    private void paintProximityIndicator(Graphics3D graphics3D, TouchAreaModel touchAreaModel, Rectangle rectangle, float f2) {
        int n;
        boolean bl;
        TouchAreaModel$ProximityDataStorage touchAreaModel$ProximityDataStorage = touchAreaModel.getProximityDataStorage();
        boolean bl2 = touchAreaModel$ProximityDataStorage.y >= 0.0f && touchAreaModel$ProximityDataStorage.y <= 1.0f;
        boolean bl3 = bl = touchAreaModel$ProximityDataStorage.x >= 0.0f && touchAreaModel$ProximityDataStorage.x <= 1.0f;
        if (bl2) {
            if (touchAreaModel.isInvalid() || this.lineHorizonalProximity == null) {
                n = (int)(touchAreaModel$ProximityDataStorage.y * (float)touchAreaModel.get_height()) - 5;
                this.lineHorizonalProximity = TouchAreaDiagUI.updateRectangleDrawable(graphics3D, this.getWidget(), this.lineHorizonalProximity, touchAreaModel.get_x() - rectangle.x, n, touchAreaModel.get_width(), 10);
                this.lineHorizonalProximity.setColor(INDICATOR_PROXIMITY_COLOR);
            }
            if (this.lineHorizonalProximity != null) {
                this.lineHorizonalProximity.draw();
            }
        }
        if (bl) {
            if (touchAreaModel.isInvalid() || this.lineVerticalProximity == null) {
                n = (int)(touchAreaModel$ProximityDataStorage.x * (float)touchAreaModel.get_width()) - 5;
                this.lineVerticalProximity = TouchAreaDiagUI.updateRectangleDrawable(graphics3D, this.getWidget(), this.lineVerticalProximity, n, touchAreaModel.get_y() - rectangle.y, 10, touchAreaModel.get_height());
                this.lineVerticalProximity.setColor(INDICATOR_PROXIMITY_COLOR);
            }
            if (this.lineVerticalProximity != null && touchAreaModel$ProximityDataStorage.x >= 0.0f) {
                this.lineVerticalProximity.draw();
            }
        }
    }

    private void paintTouchMetrics(Graphics3D graphics3D, TouchAreaModel touchAreaModel, Rectangle rectangle, float f2) {
        TouchAreaModel$TouchDataStorage touchAreaModel$TouchDataStorage = touchAreaModel.getTouchDataStorage();
        int n = touchAreaModel.get_width() / 7;
        int n2 = 0;
        this.drawDebugText(graphics3D, n2, 20, "TOUCH INPUT", TEXTUAL_TOUCH_METRICS_COLOR);
        this.paintMetricsKeyValue(graphics3D, "TYPE: ", this.getTypeTextTouch(touchAreaModel$TouchDataStorage.type), n2 += n, 20, TEXTUAL_TOUCH_METRICS_COLOR);
        this.paintMetricsKeyValue(graphics3D, "X: ", touchAreaModel$TouchDataStorage.x, n2 += n, 20, TEXTUAL_TOUCH_METRICS_COLOR);
        this.paintMetricsKeyValue(graphics3D, "Y: ", touchAreaModel$TouchDataStorage.y, n2 += n, 20, TEXTUAL_TOUCH_METRICS_COLOR);
        this.paintMetricsKeyValue(graphics3D, "PARAM1: ", touchAreaModel$TouchDataStorage.gestureParam1, n2 += n, 20, TEXTUAL_TOUCH_METRICS_COLOR);
        this.paintMetricsKeyValue(graphics3D, "PARAM2: ", touchAreaModel$TouchDataStorage.gestureParam2, n2 += n, 20, TEXTUAL_TOUCH_METRICS_COLOR);
        this.paintMetricsKeyValue(graphics3D, "TIME: ", touchAreaModel$TouchDataStorage.time, n2 += n, 20, TEXTUAL_TOUCH_METRICS_COLOR);
    }

    public void paintProximityMetrics(Graphics3D graphics3D, TouchAreaModel touchAreaModel, Rectangle rectangle, float f2) {
        TouchAreaModel$ProximityDataStorage touchAreaModel$ProximityDataStorage = touchAreaModel.getProximityDataStorage();
        int n = touchAreaModel.get_width() / 7;
        int n2 = 0;
        this.drawDebugText(graphics3D, n2, 40, "PROXIMITY INPUT", TEXTUAL_PROXIMITY_METRICS_COLOR);
        this.paintMetricsKeyValue(graphics3D, "TYPE: ", this.getTypeTextProximity(touchAreaModel$ProximityDataStorage.type), n2 += n, 40, TEXTUAL_PROXIMITY_METRICS_COLOR);
        this.paintMetricsKeyValue(graphics3D, "X: ", touchAreaModel$ProximityDataStorage.x, n2 += n, 40, TEXTUAL_PROXIMITY_METRICS_COLOR);
        this.paintMetricsKeyValue(graphics3D, "Y: ", touchAreaModel$ProximityDataStorage.y, n2 += n, 40, TEXTUAL_PROXIMITY_METRICS_COLOR);
        this.paintMetricsKeyValue(graphics3D, "AREA: ", touchAreaModel$ProximityDataStorage.proximityArea, n2 += n, 40, TEXTUAL_PROXIMITY_METRICS_COLOR);
        this.paintMetricsKeyValue(graphics3D, "DISTANCE: ", touchAreaModel$ProximityDataStorage.distance, n2 += n, 40, TEXTUAL_PROXIMITY_METRICS_COLOR);
        this.paintMetricsKeyValue(graphics3D, "TIME: ", touchAreaModel$ProximityDataStorage.time, n2 += n, 40, TEXTUAL_PROXIMITY_METRICS_COLOR);
    }

    private void paintMetricsKeyValue(Graphics3D graphics3D, String string, float f2, int n, int n2, Color4f color4f) {
        this.stringBuilder.clear();
        this.stringBuilder.append(string).append(f2);
        this.drawDebugText(graphics3D, n, n2, this.stringBuilder.toString(), color4f);
    }

    private void paintMetricsKeyValue(Graphics3D graphics3D, String string, String string2, int n, int n2, Color4f color4f) {
        this.stringBuilder.clear();
        this.stringBuilder.append(string).append(string2);
        this.drawDebugText(graphics3D, n, n2, this.stringBuilder.toString(), color4f);
    }

    private String getTypeTextTouch(int n) {
        switch (n) {
            case 1: {
                return TYPE_TEXT_TOUCH_PRESS;
            }
            case 0: {
                return TYPE_TEXT_TOUCH_RELEASE;
            }
            case 2: {
                return TYPE_TEXT_TOUCH_CLICK;
            }
            case 3: {
                return TYPE_TEXT_TOUCH_DRAG;
            }
            case 4: {
                return TYPE_TEXT_TOUCH_FLICK;
            }
            case 6: {
                return TYPE_TEXT_TOUCH_PRESS2;
            }
            case 5: {
                return TYPE_TEXT_TOUCH_ROTATE;
            }
            case 7: {
                return TYPE_TEXT_TOUCH_DRAG2;
            }
            case 8: {
                return TYPE_TEXT_TOUCH_FLICK2;
            }
            case 9: {
                return TYPE_TEXT_TOUCH_ZOOM;
            }
            case 10: {
                return TYPE_TEXT_TOUCH_RIGHTCLICK;
            }
        }
        return TYPE_TEXT_TOUCH_NONE;
    }

    private String getTypeTextProximity(int n) {
        switch (n) {
            case 0: {
                return TYPE_TEXT_PROXIMITY_APPEAR;
            }
            case 1: {
                return TYPE_TEXT_PROXIMITY_DISAPPEAR;
            }
            case 2: {
                return TYPE_TEXT_PROXIMITY_MOVE;
            }
            case 3: {
                return TYPE_TEXT_PROXIMITY_SWIPE_LEFT;
            }
            case 4: {
                return TYPE_TEXT_PROXIMITY_SWIPE_RIGHT;
            }
        }
        return TYPE_TEXT_PROXIMITY_NONE;
    }

    static {
        INDICATOR_TOUCH_COLOR = Color4f.WHITE;
        INDICATOR_PROXIMITY_COLOR = new Color4f(1.0f, 0.0f, 0.0f, (float)63);
        TEXTUAL_TOUCH_METRICS_COLOR = Color4f.WHITE;
        TEXTUAL_PROXIMITY_METRICS_COLOR = Color4f.RED;
        TYPE_TEXT_TOUCH_PRESS = "PRESS";
        TYPE_TEXT_TOUCH_RELEASE = "RELEASE";
        TYPE_TEXT_TOUCH_CLICK = "CLICK";
        TYPE_TEXT_TOUCH_DRAG = "DRAG";
        TYPE_TEXT_TOUCH_FLICK = "FLICK";
        TYPE_TEXT_TOUCH_PRESS2 = "PRESS2";
        TYPE_TEXT_TOUCH_ROTATE = "ROTATE";
        TYPE_TEXT_TOUCH_DRAG2 = "DRAG2";
        TYPE_TEXT_TOUCH_FLICK2 = "FLICK2";
        TYPE_TEXT_TOUCH_ZOOM = "ZOOM";
        TYPE_TEXT_TOUCH_RIGHTCLICK = "RIGHTCLICK";
        TYPE_TEXT_TOUCH_NONE = "N/A";
        TYPE_TEXT_PROXIMITY_APPEAR = "APPEAR";
        TYPE_TEXT_PROXIMITY_DISAPPEAR = "DISAPPEAR";
        TYPE_TEXT_PROXIMITY_MOVE = "MOVE";
        TYPE_TEXT_PROXIMITY_SWIPE_LEFT = "SWIPE_LEFT";
        TYPE_TEXT_PROXIMITY_SWIPE_RIGHT = "SWIPE_RIGHT";
        TYPE_TEXT_PROXIMITY_NONE = "N/A";
    }
}

