/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.graphics.math.geometry.Point2f;
import de.vw.mib.widgets.Instruments;

final class Instruments$HaloOutputValues {
    Point2f[] halo;
    int pointer;
    private final /* synthetic */ Instruments this$0;

    public Instruments$HaloOutputValues(Instruments instruments) {
        this.this$0 = instruments;
        this.halo = new Point2f[instruments.getHaloAlphasInternal().length];
        for (int i2 = this.halo.length - 1; i2 >= 0; --i2) {
            this.halo[i2] = new Point2f(79, 79);
        }
        this.pointer = 0;
    }

    public Point2f[] getPositions() {
        return this.halo;
    }

    void addPosition(float f2, float f3) {
        this.halo[this.pointer].x = f2;
        this.halo[this.pointer].y = f3;
        this.incrementPointer();
    }

    void updateWithoutNewPosition() {
        Point2f point2f = this.lastPosition();
        this.halo[this.pointer].x = point2f.x;
        this.halo[this.pointer].y = point2f.y;
        point2f.x = 79;
        point2f.y = 79;
        this.incrementPointer();
        this.this$0.trace(new StringBuffer().append("HaloKindFreePositioning#run() : no new input using old values: x=").append(point2f.x).append(" and y=").append(point2f.y).append(" haloPointer=").append(this.previousPointer()).append(" widget: ").append(this.this$0.getQualifiedName()).toString());
    }

    private void incrementPointer() {
        this.pointer = this.pointer + 1 != this.halo.length ? this.pointer + 1 : 0;
    }

    Point2f lastPosition() {
        return this.halo[this.previousPointer()];
    }

    int size() {
        return this.halo.length;
    }

    private int previousPointer() {
        return this.pointer == 0 ? this.halo.length - 1 : this.pointer - 1;
    }

    boolean isHaloCollapsed() {
        return this.halo[this.pointer].x == 79;
    }
}

