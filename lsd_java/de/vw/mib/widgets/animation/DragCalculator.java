/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.animation;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.graphics.Point;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.math.Util;
import de.vw.mib.graphics.math.function.Function1f;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.widgets.animation.EasingFunction;
import de.vw.mib.widgets.interfaces.Draggable;
import de.vw.mib.widgets.interfaces.Draggable$DragDataStorage;
import de.vw.mib.widgets.internal.ServiceManager;

public final class DragCalculator {
    private static final int MIN_DURATION;
    private static final int MAX_DURATION;
    private static final float DAMPING_FACTOR;
    public static final int DRAG_THRESHOLD;
    private static final int SPEED_MEASURE_INTERVAL;
    private static final Function1f DAMPING_CURVE_QUINTIC;
    private static final Function1f SNAP_DURATION;
    public static final EasingParams EASING_SNAP;
    private static final int TIMESTAMP_SUPPORT_UNKNOWN;
    private static final int TIMESTAMP_SUPPORT_TRUE;
    private static final int TIMESTAMP_SUPPORT_FALSE;
    private static int timestampSupport;
    private static boolean thresholdExceeded;
    private static int speedX;
    private static int speedY;
    private static int eventCount;
    private static int tmpX;
    private static int tmpY;
    private static int tmpTime;
    private static int tmpACCTime;
    private static Rectangle viewPort;
    private static Rectangle visualAreaBounds;
    protected static Logger LOGGER;

    private DragCalculator() {
    }

    private static Logger getLogger() {
        if (null == LOGGER) {
            LOGGER = ServiceManager.loggerFactory.getLogger(2048);
        }
        return LOGGER;
    }

    public static void startDrag(Draggable draggable, int n, int n2, float f2) {
        Draggable$DragDataStorage draggable$DragDataStorage = draggable.getDragDataStorage();
        draggable.getViewPort(viewPort);
        thresholdExceeded = false;
        draggable$DragDataStorage.initialTouchPoint.setLocation(n, n2);
        draggable$DragDataStorage.initialViewportLocation.setLocation(DragCalculator.viewPort.x, DragCalculator.viewPort.y);
        draggable$DragDataStorage.dragMultiplier = f2;
        DragCalculator.initSpeedMeasurement(draggable$DragDataStorage, n, n2);
        if (DragCalculator.getLogger().isTraceEnabled(1)) {
            LogMessage logMessage = DragCalculator.getLogger().trace(32);
            logMessage.append("DragCalculator: startDrag() at position x=").append(n).append(" | y=").append(n2).log();
        }
    }

    public static void stopDrag(Draggable draggable) {
        Draggable$DragDataStorage draggable$DragDataStorage = draggable.getDragDataStorage();
        draggable$DragDataStorage.dragActive = false;
    }

    public static boolean drag(Draggable draggable, int n, int n2, int n3) {
        Draggable$DragDataStorage draggable$DragDataStorage = draggable.getDragDataStorage();
        DragCalculator.updateSpeedMeasurement(draggable$DragDataStorage, n, n2, n3);
        draggable.getViewPort(viewPort);
        draggable.getVisualAreaBounds(visualAreaBounds);
        int n4 = draggable$DragDataStorage.initialViewportLocation.x;
        int n5 = draggable$DragDataStorage.initialViewportLocation.y;
        int n6 = DragCalculator.calculateDragPosition(draggable, DragCalculator.visualAreaBounds.x, DragCalculator.visualAreaBounds.width - DragCalculator.viewPort.width, DragCalculator.viewPort.x, DragCalculator.viewPort.width, (int)((float)(draggable$DragDataStorage.initialTouchPoint.x - n) * draggable$DragDataStorage.dragMultiplier), n4);
        int n7 = DragCalculator.calculateDragPosition(draggable, DragCalculator.visualAreaBounds.y, DragCalculator.visualAreaBounds.height - DragCalculator.viewPort.height, DragCalculator.viewPort.y, DragCalculator.viewPort.height, (int)((float)(draggable$DragDataStorage.initialTouchPoint.y - n2) * draggable$DragDataStorage.dragMultiplier), n5);
        if (thresholdExceeded |= !draggable$DragDataStorage.useThreshold || Math.abs(n6 - n4) > 15 || Math.abs(n7 - n5) > 15) {
            draggable.setViewportPosition(n6, n7);
            if (!draggable$DragDataStorage.dragActive) {
                draggable.startDragging();
            }
        }
        draggable$DragDataStorage.dragActive = thresholdExceeded;
        return thresholdExceeded;
    }

    public static void snap(Draggable draggable, int n, int n2, int n3) {
        Draggable$DragDataStorage draggable$DragDataStorage = draggable.getDragDataStorage();
        if (!draggable$DragDataStorage.dragActive) {
            DragCalculator.initSpeedMeasurement(draggable$DragDataStorage, n, n2);
        }
        int n4 = draggable.getMaxDraggingSpeed();
        draggable.getViewPort(viewPort);
        draggable.getVisualAreaBounds(visualAreaBounds);
        boolean bl = DragCalculator.viewPort.width < DragCalculator.visualAreaBounds.width;
        boolean bl2 = DragCalculator.viewPort.height < DragCalculator.visualAreaBounds.height;
        draggable$DragDataStorage.dragActive = false;
        DragCalculator.stopSpeedMeasurement(draggable$DragDataStorage, n, n2, n3);
        int n5 = Math.abs(speedX) > Math.abs(speedY) ? (int)SNAP_DURATION.evaluate(Math.min(1.0f, (float)Math.abs(speedX) / (float)n4)) : (int)SNAP_DURATION.evaluate(Math.min(1.0f, (float)Math.abs(speedY) / (float)n4));
        int n6 = bl ? speedX : speedY;
        int n7 = 0;
        if (n6 < 0) {
            n7 = 1;
        } else if (n6 > 0) {
            n7 = 2;
        }
        Point point = new Point();
        point.x = bl ? DragCalculator.viewPort.x - DragCalculator.calculateSnapDistance(speedX, n5) : DragCalculator.viewPort.x;
        int n8 = point.y = bl2 ? DragCalculator.viewPort.y - DragCalculator.calculateSnapDistance(speedY, n5) : DragCalculator.viewPort.y;
        if (draggable.useDragDeceleration()) {
            point.x = Util.clamp(point.x, DragCalculator.visualAreaBounds.x, Math.max(0, DragCalculator.visualAreaBounds.width - DragCalculator.viewPort.width));
            point.y = Util.clamp(point.y, DragCalculator.visualAreaBounds.y, Math.max(0, DragCalculator.visualAreaBounds.height - DragCalculator.viewPort.height));
        }
        if (!draggable.adaptSnapPosition(point, n7)) {
            int n9 = speedX != 0 ? Math.min(2000, Math.abs((DragCalculator.viewPort.x - point.x << 10) / speedX << 1)) : 0;
            int n10 = speedY != 0 ? Math.min(2000, Math.abs((DragCalculator.viewPort.y - point.y << 10) / speedY << 1)) : 0;
            n5 = Math.max(300, n10 > 0 && n9 > 0 ? Math.min(n10, n9) : Math.max(n10, n9));
        } else {
            n5 = 300;
        }
        if (DragCalculator.viewPort.x != point.x || DragCalculator.viewPort.y != point.y) {
            draggable$DragDataStorage.easingSnap.setDuration(n5);
            draggable.startSnapAnimation(point.x, point.y, draggable$DragDataStorage.easingSnap);
        }
        draggable.stopDragging();
        if (DragCalculator.getLogger().isTraceEnabled(1)) {
            LogMessage logMessage = DragCalculator.getLogger().trace(32);
            logMessage.append("DragCalculator: snap() at position x=").append(n).append(" | y=").append(n2);
            logMessage.append(" | speedX=").append(speedX).append(" | speedY=").append(speedY);
            logMessage.append(" | snapDuration=").append(n5);
            logMessage.append(" | snapDestX=").append(point.x).append(" | snapDestY=").append(point.y);
            logMessage.append(" | timestamps=").append(n3).log();
        }
    }

    private static int calculateSnapDistance(int n, int n2) {
        int n3 = n * n2 >> 1;
        return n3 >> 10;
    }

    private static int calculateDragPosition(Draggable draggable, int n, int n2, int n3, int n4, int n5, int n6) {
        if (n >= n2) {
            return n3;
        }
        int n7 = n6 + n5;
        if (!draggable.useDragDeceleration() || n7 >= n && n7 <= n2) {
            return n7;
        }
        Function1f function1f = DAMPING_CURVE_QUINTIC;
        int n8 = n7 < n ? n - n7 : n7 - n2;
        int n9 = Math.min(n8, (int)((float)n4 * -842249154 * function1f.evaluate(Math.min(1.0f, (float)n8 / (float)n4))));
        return n7 < n ? n - n9 : n2 + n9;
    }

    private static void initSpeedMeasurement(Draggable$DragDataStorage draggable$DragDataStorage, int n, int n2) {
        eventCount = 4;
        if (timestampSupport == 1) {
            draggable$DragDataStorage.deltaTime = 0;
            draggable$DragDataStorage.deltaX = 0;
            draggable$DragDataStorage.deltaY = 0;
            draggable$DragDataStorage.x = n;
            draggable$DragDataStorage.y = n2;
        } else {
            tmpX = n;
            tmpY = n2;
            draggable$DragDataStorage.lastDragEventTime = tmpTime = (int)ServiceManager.timerManager.getSystemTimeMillis();
            draggable$DragDataStorage.x = tmpX;
            draggable$DragDataStorage.y = tmpY;
        }
    }

    private static void updateSpeedMeasurement(Draggable$DragDataStorage draggable$DragDataStorage, int n, int n2, int n3) {
        if (timestampSupport == 1) {
            if (eventCount == 0) {
                eventCount = 4;
                draggable$DragDataStorage.deltaX /= 4;
                draggable$DragDataStorage.deltaY /= 4;
                draggable$DragDataStorage.deltaTime /= 4;
            }
            draggable$DragDataStorage.deltaX += n - draggable$DragDataStorage.x;
            draggable$DragDataStorage.deltaY += n2 - draggable$DragDataStorage.y;
            draggable$DragDataStorage.deltaTime += n3;
            draggable$DragDataStorage.x = n;
            draggable$DragDataStorage.y = n2;
        } else if (eventCount == 0) {
            eventCount = 4;
            draggable$DragDataStorage.x = tmpX;
            draggable$DragDataStorage.y = tmpY;
            draggable$DragDataStorage.lastDragEventTime = tmpTime;
            tmpX = n;
            tmpY = n2;
            tmpTime = (int)ServiceManager.timerManager.getSystemTimeMillis();
        }
        --eventCount;
        if (timestampSupport == 0) {
            tmpACCTime += n3;
        }
    }

    private static void stopSpeedMeasurement(Draggable$DragDataStorage draggable$DragDataStorage, int n, int n2, int n3) {
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        if (timestampSupport == 1) {
            draggable$DragDataStorage.deltaX += n - draggable$DragDataStorage.x;
            draggable$DragDataStorage.deltaY += n2 - draggable$DragDataStorage.y;
            draggable$DragDataStorage.deltaTime += n3;
            n5 = draggable$DragDataStorage.deltaX;
            n6 = draggable$DragDataStorage.deltaY;
            n4 = Math.max(1, draggable$DragDataStorage.deltaTime);
        } else {
            n5 = n - draggable$DragDataStorage.x;
            n6 = n2 - draggable$DragDataStorage.y;
            n4 = Math.max(1, (int)ServiceManager.timerManager.getSystemTimeMillis() - draggable$DragDataStorage.lastDragEventTime);
        }
        speedX = (n5 << 10) / n4;
        speedY = (n6 << 10) / n4;
        if (timestampSupport == 0) {
            if (tmpACCTime > 0) {
                timestampSupport = 1;
                DragCalculator.getLogger().normal(1, "DragCalculator: Time stamps provided by gesture events. Optimized drag speed messurement activated.");
            } else {
                timestampSupport = 2;
                DragCalculator.getLogger().normal(1, "DragCalculator: Time stamps not provided by gesture events. Legacy drag speed messurement activated.");
            }
        }
    }

    static {
        DAMPING_CURVE_QUINTIC = new EasingFunction(5, 1, 0.0f, 1.0f);
        SNAP_DURATION = new EasingFunction(10, 0, 0.0f, 64068);
        EASING_SNAP = new EasingParams(1, 10, 0, 0);
        timestampSupport = 0;
        viewPort = new Rectangle();
        visualAreaBounds = new Rectangle();
    }
}

