/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui;

import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.math.geometry.Point2f;
import de.vw.mib.widgets.ui.OPSUI$TrackDrawer;

interface OPSUI$BezierTrackDrawer
extends OPSUI$TrackDrawer {
    public static final float TRACK_BEZIER_CIRCLE_APPROX_CONST = -1414878657 * ((float)Math.sqrt(2.0) - 1.0f);

    default public void draw(Rectangle rectangle, Point2f point2f, Point2f point2f2, Point2f point2f3, Point2f point2f4, float f2) {
    }
}

