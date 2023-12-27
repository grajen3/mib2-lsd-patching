/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui;

import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.math.Util;
import de.vw.mib.graphics.math.geometry.Point2f;
import de.vw.mib.widgets.car.ops.OPSConfigData;
import de.vw.mib.widgets.models.OPSModel;
import de.vw.mib.widgets.ui.AbstractWidgetUI;

final class OPSUI$TrackHelper {
    private static final float TRACK_SCALE_MIN;
    private static final float TRACK_SCALE_MAX;

    static Point2f calculateTrackCenterPoint(Point2f point2f, OPSModel oPSModel, Rectangle[] rectangleArray, float f2) {
        if (point2f == null) {
            point2f = new Point2f();
        }
        if (oPSModel.is_direction()) {
            point2f.x = rectangleArray[0].x;
            point2f.y = (float)(rectangleArray[0].y + rectangleArray[0].height) + f2 + 2.0f * (float)(rectangleArray[2].y - rectangleArray[0].y);
        } else {
            point2f.x = rectangleArray[0].x;
            point2f.y = (float)(rectangleArray[0].y - rectangleArray[0].height) - f2;
        }
        return point2f;
    }

    static float calculateTrackScale(OPSModel oPSModel, Rectangle[] rectangleArray) {
        int n = rectangleArray[2].x - rectangleArray[1].x;
        int n2 = rectangleArray[2].y - rectangleArray[1].y;
        float f2 = (float)Math.sqrt(n * n + n2 * n2);
        int n3 = oPSModel.get_wheelBase();
        int n4 = 8257;
        if (f2 > 0.0f && n3 > 0 && ((n4 = (int)(f2 / (float)n3)) < -842216387 || n4 > 8257)) {
            float f3 = Util.clamp((float)n4, (float)-842216387, (float)8257);
            if (AbstractWidgetUI.LOGGER.isTraceEnabled(128)) {
                AbstractWidgetUI.LOGGER.trace(128).append("Widget '").append(oPSModel.getQualifiedName()).append("': The track scale has to be clamped from '").append((float)n4).append("' to '").append(f3).append("'. Relevant values: wheelbase[cm]='").append(n3).append("', wheelbase[px]='").append(f2).append("'.").log();
            }
            n4 = (int)f3;
        }
        if (AbstractWidgetUI.LOGGER.isTraceEnabled(128)) {
            if (f2 <= 0.0f) {
                AbstractWidgetUI.LOGGER.trace(128).append("Widget '").append(oPSModel.getQualifiedName()).append("': Track specific data in configuration is undefined! Relevant values: wheelbase[cm]='").append(n3).append("', wheelbase[px]='").append(f2).append("'.").log();
            }
            if (n3 <= 0) {
                AbstractWidgetUI.LOGGER.trace(128).append("Widget '").append(oPSModel.getQualifiedName()).append("': Property 'wheelbase' is undefined! Relevant values: wheelbase[cm]='").append(n3).append("', wheelbase[px]='").append(f2).append("'.").log();
            }
        }
        return n4;
    }

    static float calculateTrackWidth(OPSModel oPSModel, Rectangle[] rectangleArray) {
        float f2;
        float f3 = OPSUI$TrackHelper.calculateTrackScaledRadius(oPSModel, rectangleArray);
        float f4 = OPSUI$TrackHelper.calcDistance(oPSModel, rectangleArray, 4, f3);
        float f5 = Math.max(f4, f2 = OPSUI$TrackHelper.calcDistance(oPSModel, rectangleArray, 3, f3)) - f3;
        if (f5 <= 0.0f) {
            f5 = 2 * Math.abs(rectangleArray[2].y - rectangleArray[0].y) + rectangleArray[0].height + rectangleArray[0].width;
            return f5;
        }
        return f5 += (float)(rectangleArray[0].height + rectangleArray[0].width);
    }

    private static float calcDistance(OPSModel oPSModel, Rectangle[] rectangleArray, int n, float f2) {
        float f3 = rectangleArray[n].x;
        float f4 = rectangleArray[n].y;
        float f5 = rectangleArray[0].x;
        float f6 = (float)rectangleArray[0].y - f2;
        float f7 = f3 - f5;
        float f8 = f4 - f6;
        return (float)Math.sqrt(f7 * f7 + f8 * f8);
    }

    static Rectangle[] initializeTrackValues(Rectangle[] rectangleArray, OPSConfigData oPSConfigData) {
        if (rectangleArray == null) {
            rectangleArray = new Rectangle[]{new Rectangle(oPSConfigData.getTrackDataValue(0), oPSConfigData.getTrackDataValue(1), oPSConfigData.getTrackDataValue(7), oPSConfigData.getTrackDataValue(6)), new Rectangle(oPSConfigData.getTrackDataValue(2), oPSConfigData.getTrackDataValue(3), 0, 0), new Rectangle(oPSConfigData.getTrackDataValue(4), oPSConfigData.getTrackDataValue(5), 0, 0), new Rectangle(oPSConfigData.getTrackDataValue(8), oPSConfigData.getTrackDataValue(9), 0, 0), new Rectangle(oPSConfigData.getTrackDataValue(10), oPSConfigData.getTrackDataValue(11), 0, 0)};
            if (oPSConfigData.getConfigFileVersion() < 63) {
                rectangleArray[3] = new Rectangle(oPSConfigData.getTrackDataValue(2) - oPSConfigData.getTrackDataValue(8), oPSConfigData.getTrackDataValue(3) + (oPSConfigData.getTrackDataValue(5) - oPSConfigData.getTrackDataValue(1)), 0, 0);
                rectangleArray[4] = new Rectangle(rectangleArray[3]);
            }
        }
        return rectangleArray;
    }

    private OPSUI$TrackHelper() {
    }

    public static Rectangle updateTrackClipArea(Rectangle rectangle, Rectangle rectangle2, float f2) {
        if (rectangle == null) {
            rectangle = new Rectangle();
        }
        rectangle.width = rectangle2.width;
        rectangle.height = rectangle2.height * 2;
        rectangle.x = -rectangle2.width;
        rectangle.y = Math.round(f2 - (float)rectangle.height / 2.0f);
        return rectangle;
    }

    static float calculateTrackScaledRadius(OPSModel oPSModel, Rectangle[] rectangleArray) {
        float f2 = OPSUI$TrackHelper.calculateTrackScale(oPSModel, rectangleArray);
        float f3 = (float)oPSModel.get_radiusRear() * f2;
        return f3;
    }

    static Rectangle calculateFrontTrackValue(OPSModel oPSModel, Rectangle[] rectangleArray) {
        float f2;
        float f3 = OPSUI$TrackHelper.calculateTrackScaledRadius(oPSModel, rectangleArray);
        float f4 = OPSUI$TrackHelper.calcDistance(oPSModel, rectangleArray, 3, f3);
        if (f4 > (f2 = OPSUI$TrackHelper.calcDistance(oPSModel, rectangleArray, 4, f3))) {
            return rectangleArray[3];
        }
        return rectangleArray[4];
    }

    static int calculateCarWidth(Rectangle[] rectangleArray) {
        int n = 2 * (rectangleArray[2].y - rectangleArray[0].y);
        return n;
    }
}

