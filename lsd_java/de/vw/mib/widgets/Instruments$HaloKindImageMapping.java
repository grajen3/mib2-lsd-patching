/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.graphics.math.Util;
import de.vw.mib.graphics.math.geometry.Point2f;
import de.vw.mib.widgets.Instruments;
import de.vw.mib.widgets.Instruments$GMeterChangeAnimation;
import de.vw.mib.widgets.Instruments$HaloKind;

final class Instruments$HaloKindImageMapping
implements Instruments$HaloKind {
    private int[] haloImageIndices;
    private float[] haloAngles;
    private Point2f[] haloPositions;
    private final Point2f lastPosition = new Point2f();
    private int lastIndex = -1;
    private Point2f newPosition;
    private final /* synthetic */ Instruments this$0;

    public Instruments$HaloKindImageMapping(Instruments instruments) {
        this.this$0 = instruments;
        this.reinit();
    }

    private void initializeHaloAlphas() {
        int[] nArray = this.this$0.getHaloAlphasInternal();
        if (nArray == null || nArray.length != this.this$0.getPointerImageCount()) {
            nArray = new int[this.this$0.getPointerImageCount()];
        }
        this.this$0.setHaloAlphasInternal(nArray);
    }

    private void initializeHalo() {
        if (this.haloAngles == null || this.haloAngles.length != this.this$0.getPointerImageCount()) {
            this.haloAngles = new float[this.this$0.getPointerImageCount()];
            this.haloImageIndices = new int[this.this$0.getPointerImageCount()];
        }
        for (int i2 = this.haloAngles.length - 1; i2 >= 0; --i2) {
            this.haloImageIndices[i2] = 0;
            this.haloAngles[i2] = 0.0f;
        }
    }

    private void initializeHaloPositions() {
        if (this.haloPositions == null || this.haloPositions.length != this.this$0.getPointerImageCount()) {
            this.haloPositions = new Point2f[this.this$0.getPointerImageCount()];
            for (int i2 = this.haloPositions.length - 1; i2 >= 0; --i2) {
                this.haloPositions[i2] = new Point2f();
            }
        }
    }

    @Override
    public void addHaloInput(int n, float f2) {
        if (this.this$0.areGMeterPhaseTwoEnterAnimationsActive()) {
            this.interpolateHaloPosition(n, f2);
        } else {
            this.calcNewPosition(n, f2);
            if (!this.startGMeterChangeAnimation(this.newPosition)) {
                this.interpolateHaloPosition(n, f2);
            }
        }
    }

    private void interpolateHaloPosition(int n, float f2) {
        int n2 = this.mapRadiusToIdx(n);
        if ((n2 = Util.clamp(n2, 0, this.this$0.getPointerImageCount() - 1)) < 0) {
            return;
        }
        this.this$0.setHaloAlphaInternal(n2, 255);
        this.calcNewPosition(n, f2);
        this.haloPositions[n2].x = this.newPosition.x;
        this.haloPositions[n2].y = this.newPosition.y;
        this.this$0.repaint();
    }

    private Point2f calcNewPosition(int n, float f2) {
        if (this.newPosition == null) {
            this.newPosition = new Point2f();
        }
        this.newPosition.x = (float)(Math.cos(Math.toRadians(f2)) * (double)n);
        this.newPosition.y = (float)(Math.sin(Math.toRadians(f2)) * (double)n);
        return this.newPosition;
    }

    private boolean startGMeterChangeAnimation(Point2f point2f) {
        if (this.this$0.gMeterChangeAnimation != null && this.this$0.gMeterChangeAnimation.isActive() && point2f.x == this.this$0.gMeterChangeAnimation.getEndXValue() && point2f.y == this.this$0.gMeterChangeAnimation.getEndYValue()) {
            return true;
        }
        EasingParams easingParams = this.this$0.getEasing(15);
        if (easingParams == null) {
            return false;
        }
        this.this$0.stopGMeterChangeAnimation();
        this.this$0.gMeterChangeAnimation = new Instruments$GMeterChangeAnimation(this.this$0, easingParams, this, this.lastPosition, point2f);
        this.this$0.trace(new StringBuffer().append("Starting GMeterChangeAnimation to x:").append(point2f.x).append(" y:").append(point2f.y).toString());
        return this.this$0.startInternalAnimation(this.this$0.gMeterChangeAnimation);
    }

    public void addInterpolatedHaloPosition(float f2, float f3) {
        int n = (int)Math.round(Math.sqrt(f2 * f2 + f3 * f3));
        n = Util.clamp(n, this.this$0.get_valueMin(), this.this$0.get_valueMax() - 1);
        int n2 = this.mapRadiusToIdx(n);
        this.haloPositions[n2].x = f2;
        this.haloPositions[n2].y = f3;
        if (n2 != this.lastIndex) {
            this.this$0.startPointerAlphaAnimation(this.lastIndex, 0);
            this.this$0.startPointerAlphaAnimation(n2, 255);
            this.lastIndex = n2;
        } else if (n == 0) {
            this.this$0.startPointerAlphaAnimation(n2, 0);
            this.lastIndex = -1;
        }
        this.this$0.trace(new StringBuffer().append("New position x: ").append(f2).append(" y:").append(f3).append(" radius: ").append(n).toString());
        this.lastPosition.x = f2;
        this.lastPosition.y = f3;
    }

    private int mapRadiusToIdx(int n) {
        if (this.this$0.get_valueMax() == 0) {
            return 0;
        }
        return (int)((float)n / (float)this.this$0.get_valueMax() * (float)this.this$0.getPointerImageCount());
    }

    @Override
    public void reinit() {
        this.initializeHaloAlphas();
        this.initializeHalo();
        this.initializeHaloPositions();
        this.lastPosition.x = 0.0f;
        this.lastPosition.y = 0.0f;
        this.lastIndex = -1;
    }

    @Override
    public int getHaloAdditionalParam() {
        return 0;
    }

    @Override
    public Point2f[] getHaloPositions() {
        return this.haloPositions;
    }
}

