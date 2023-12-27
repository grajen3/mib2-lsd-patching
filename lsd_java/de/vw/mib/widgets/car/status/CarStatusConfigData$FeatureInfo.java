/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.car.status;

import de.vw.mib.graphics.Point;

final class CarStatusConfigData$FeatureInfo {
    Point position;
    Point alternativePosition;
    int id;

    CarStatusConfigData$FeatureInfo(int n) {
        this.id = n;
    }

    void setPosition(Point point, boolean bl) {
        if (!bl) {
            this.position = point;
        } else {
            this.alternativePosition = point;
        }
    }
}

