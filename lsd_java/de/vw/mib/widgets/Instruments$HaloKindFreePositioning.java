/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.graphics.math.Util;
import de.vw.mib.graphics.math.geometry.Point2f;
import de.vw.mib.timer.Timer;
import de.vw.mib.widgets.Instruments;
import de.vw.mib.widgets.Instruments$HaloInputValues;
import de.vw.mib.widgets.Instruments$HaloKind;
import de.vw.mib.widgets.Instruments$HaloOutputValues;
import de.vw.mib.widgets.internal.ServiceManager;

final class Instruments$HaloKindFreePositioning
implements Instruments$HaloKind,
Runnable {
    private static final String INSTRUMENTS_HALO_TIMER;
    private static final int VIRTUAL_UPDATE_TIME;
    private static final int START_TIME_DIFF;
    private int maxTimeDelta;
    private Timer haloTimer;
    private long lastTime;
    private int interpolationCounter;
    private Instruments$HaloInputValues inputValues;
    private Instruments$HaloOutputValues outputValues;
    private final /* synthetic */ Instruments this$0;

    public Instruments$HaloKindFreePositioning(Instruments instruments) {
        this.this$0 = instruments;
        this.initalizeHalo();
    }

    private void initalizeHalo() {
        this.interpolationCounter = 1;
        if (this.outputValues == null || this.this$0.getHaloAlphasInternal().length > 0 && this.this$0.getHaloAlphasInternal().length != this.outputValues.size()) {
            this.outputValues = new Instruments$HaloOutputValues(this.this$0);
            this.maxTimeDelta = this.outputValues.size() * 50;
        }
        if (this.inputValues == null) {
            this.inputValues = new Instruments$HaloInputValues(this.this$0);
        }
        this.lastTime = ServiceManager.timerManager.getSystemTimeMillis();
    }

    @Override
    public void addHaloInput(int n, float f2) {
        if (this.outputValues.size() == 0) {
            return;
        }
        int n2 = this.calcTimeDelta();
        this.inputValues.addInput(n, f2, n2);
        this.manageOverflow();
        this.startTimer();
    }

    private int calcTimeDelta() {
        long l = ServiceManager.timerManager.getSystemTimeMillis();
        if (!this.getTimer().isStarted()) {
            this.lastTime = l;
            if (this.inputValues.previousTimeDelta() < this.maxTimeDelta) {
                return this.inputValues.previousTimeDelta();
            }
            return 100;
        }
        int n = (int)(l - this.lastTime);
        this.lastTime = l;
        return n < this.maxTimeDelta ? n : this.maxTimeDelta;
    }

    private void manageOverflow() {
        if (this.inputValues.isRingOverflow()) {
            Point2f point2f = this.outputValues.lastPosition();
            this.inputValues.adjustLastInput(point2f.x, point2f.y);
            this.interpolationCounter = 1;
        }
    }

    private void startTimer() {
        Timer timer = this.getTimer();
        if (!timer.isStarted()) {
            timer.start();
        }
    }

    @Override
    public void reinit() {
        this.initalizeHalo();
    }

    @Override
    public int getHaloAdditionalParam() {
        return this.outputValues.pointer;
    }

    @Override
    public Point2f[] getHaloPositions() {
        return this.outputValues.getPositions();
    }

    @Override
    public void run() {
        if (this.areNewValuesAvailable()) {
            this.outputValues.updateWithoutNewPosition();
            this.stopTimerIfHaloLengthIsZero();
            this.this$0.trace(new StringBuffer().append("readPointer=").append(this.inputValues.readPos).append(" writePointer=").append(this.inputValues.writePos).toString());
            this.this$0.trace(new StringBuffer().append("counter=").append(this.interpolationCounter).append(" countUpdates=").append(this.calcRequiredInterpolationSteps()).toString());
        } else {
            this.interpolateNewPosition();
            this.incrementInterpolationCounter();
        }
        this.this$0.repaint();
    }

    private boolean areNewValuesAvailable() {
        return this.inputValues.isRingOverflow();
    }

    private void stopTimerIfHaloLengthIsZero() {
        if (this.haloCycleWithoutUpdateElapsed() && this.outputValues.isHaloCollapsed()) {
            this.this$0.trace(new StringBuffer().append("now-lastTime=").append(ServiceManager.timerManager.getSystemTimeMillis() - this.lastTime).toString());
            this.stopTimer();
        }
    }

    private void incrementInterpolationCounter() {
        ++this.interpolationCounter;
        if (this.interpolationCounter > this.calcRequiredInterpolationSteps()) {
            this.inputValues.incrementReadPos();
            this.interpolationCounter = 1;
        }
    }

    private void interpolateNewPosition() {
        float f2 = this.calcRequiredInterpolationSteps();
        float f3 = this.interpolateX(f2);
        float f4 = this.interpolateY(f2);
        this.outputValues.addPosition(f3, f4);
        this.this$0.trace(new StringBuffer().append("HaloKindFreePositioning#interpolateNewPosition() : interpolated new position x=").append(f3).append(" and y=").append(f4).append(" haloPointer=").append(this.outputValues.pointer - 1).append(" timer:").append(this.getTimer()).append(" widget: ").append(this.this$0.getQualifiedName()).toString());
        this.this$0.trace(new StringBuffer().append("readPointer=").append(this.inputValues.readPos).append(" writePointer=").append(this.inputValues.writePos).toString());
        this.this$0.trace(new StringBuffer().append("counter=").append(this.interpolationCounter).append(" countUpdates=").append(f2).toString());
    }

    private int calcRequiredInterpolationSteps() {
        return Math.round(this.inputValues.currentTimeDelta() / 18498);
    }

    private void stopTimer() {
        Timer timer = this.getTimer();
        if (timer.isStarted()) {
            timer.stop();
            this.this$0.trace(new StringBuffer().append("HaloKindFreePositioning#run() : Stopped timer: ").append(timer).append(" widget: ").append(this.this$0.getQualifiedName()).toString());
        }
    }

    private Timer getTimer() {
        if (this.haloTimer == null) {
            this.haloTimer = ServiceManager.timerManager.createTimer("Instruments.HaloTimer", 0, true, this, ServiceManager.eventDispatcher);
        }
        return this.haloTimer;
    }

    private float interpolateX(float f2) {
        float f3 = this.inputValues.currentX() - this.inputValues.previousX();
        if (Util.equalsEpsilon(f2, 0.0f)) {
            return this.inputValues.currentX();
        }
        return this.inputValues.previousX() + f3 / f2 * (float)this.interpolationCounter;
    }

    private float interpolateY(float f2) {
        float f3 = this.inputValues.currentY() - this.inputValues.previousY();
        if (Util.equalsEpsilon(f2, 0.0f)) {
            return this.inputValues.currentY();
        }
        return this.inputValues.previousY() + f3 / f2 * (float)this.interpolationCounter;
    }

    private boolean haloCycleWithoutUpdateElapsed() {
        return ServiceManager.timerManager.getSystemTimeMillis() - this.lastTime > (long)this.maxTimeDelta;
    }
}

