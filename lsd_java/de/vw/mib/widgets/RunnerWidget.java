/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.graphics.Insets;
import de.vw.mib.timer.Timer;
import de.vw.mib.widgets.AbstractWidget;
import de.vw.mib.widgets.RunnerWidget$ValueChanger;
import de.vw.mib.widgets.interfaces.Adjustable;
import de.vw.mib.widgets.internal.ServiceManager;
import de.vw.mib.widgets.models.RunnerWidgetModel;
import de.vw.mib.widgets.models.ViewModel;
import java.util.Arrays;

public final class RunnerWidget
extends AbstractWidget
implements RunnerWidgetModel {
    private static final int INTERVAL_MILLIS_MIN;
    private static final String TIMER_NAME;
    private int mode;
    private Adjustable[] outputReferences;
    private int[] syncTimes;
    private int updateInterval;
    private int value;
    private int valueMax;
    private int valueMin;
    private int timeSpan;
    private float valueChangeRate;
    private int systimeOnTimerStop;
    private Timer runnerTimer;
    private long internalTime;

    @Override
    protected void reset() {
        super.reset();
        this.internalTime = 0L;
        this.setInternalStateFlag(10, true);
    }

    public void init(boolean bl, int n, boolean bl2, EasingParams[] easingParamsArray, boolean bl3, int n2, boolean bl4, int n3, String string, Adjustable[] adjustableArray, int[] nArray, int n4, int n5, Insets insets, boolean bl5, int n6, int n7, int n8, int n9, boolean bl6, int n10, int n11, int n12) {
        super.init(bl, n, bl2, easingParamsArray, bl3, n2, bl4, string, n4, insets, bl6, n10, n11, n12);
        this.mode = n3;
        this.outputReferences = adjustableArray;
        this.syncTimes = nArray;
        this.timeSpan = n5;
        this.updateInterval = n6;
        this.value = n7;
        this.valueMax = n8;
        this.valueMin = n9;
        this.setInternalStateFlag(9, bl5);
        if (nArray != null && nArray.length == 3) {
            this.internalTime = nArray[1];
            this.updateInternalTimeAndTimer();
        }
        this.updateValueChangeRate();
    }

    @Override
    public void init(ViewModel viewModel) {
        super.init(viewModel);
    }

    @Override
    public void deInit() {
        this.stopValueChangeTimer();
        this.internalTime = 0L;
        if (this.syncTimes != null) {
            Arrays.fill(this.syncTimes, 0);
        }
        super.deInit();
    }

    @Override
    public boolean is_unbounded() {
        return this.getInternalStateFlag(9);
    }

    @Override
    public void set_unbounded(boolean bl) {
        boolean bl2 = this.getInternalStateFlag(9);
        if (bl2 != bl) {
            this.setInternalStateFlag(9, bl);
            this.propertyChanged(20);
        }
    }

    @Override
    public int get_mode() {
        return this.mode;
    }

    @Override
    public void set_mode(int n) {
        int n2 = this.mode;
        if (n2 != n) {
            this.mode = n;
            this.propertyChanged(15);
        }
    }

    @Override
    public Adjustable[] get_outputReferences() {
        return this.outputReferences;
    }

    @Override
    public void set_outputReferences(Adjustable[] adjustableArray) {
        Object[] objectArray = this.outputReferences;
        if (objectArray == null || !Arrays.equals(objectArray, adjustableArray)) {
            this.outputReferences = adjustableArray;
            this.propertyChanged(16);
        }
    }

    @Override
    public int[] get_syncTimes() {
        return this.syncTimes;
    }

    @Override
    public void set_syncTimes(int[] nArray) {
        int[] nArray2 = this.syncTimes;
        if (nArray2 == null || !Arrays.equals(nArray2, nArray)) {
            this.syncTimes = nArray;
            this.syncTimesChanged(nArray2);
            this.propertyChanged(17);
        }
    }

    @Override
    public int get_timeSpan() {
        return this.timeSpan;
    }

    @Override
    public void set_timeSpan(int n) {
        int n2 = this.timeSpan;
        if (n2 != n) {
            this.timeSpan = n;
            this.timeSpanChanged(n2);
            this.propertyChanged(18);
        }
    }

    @Override
    public int get_updateInterval() {
        return this.updateInterval;
    }

    @Override
    public void set_updateInterval(int n) {
        int n2 = this.updateInterval;
        if (n2 != n) {
            this.updateInterval = n;
            this.propertyChanged(19);
        }
    }

    @Override
    public int get_value() {
        return this.value;
    }

    @Override
    public void set_value(int n) {
        int n2 = this.value;
        if (n2 != n) {
            this.value = n;
            this.valueChanged(n2);
            this.propertyChanged(21);
        }
    }

    @Override
    public int get_valueMax() {
        return this.valueMax;
    }

    @Override
    public void set_valueMax(int n) {
        int n2 = this.valueMax;
        if (n2 != n) {
            this.valueMax = n;
            this.valueMaxChanged(n2);
            this.propertyChanged(22);
        }
    }

    @Override
    public int get_valueMin() {
        return this.valueMin;
    }

    @Override
    public void set_valueMin(int n) {
        int n2 = this.valueMin;
        if (n2 != n) {
            this.valueMin = n;
            this.valueMinChanged(n2);
            this.propertyChanged(23);
        }
    }

    public float getValueChangeRate() {
        return this.valueChangeRate;
    }

    public void setValueChangeRate(float f2) {
        float f3 = this.valueChangeRate;
        if (f3 != f2) {
            this.valueChangeRate = f2;
        }
    }

    @Override
    public int getInternalTime() {
        return (int)this.internalTime;
    }

    public void setInternalTime(long l) {
        this.internalTime = l;
    }

    @Override
    public int getSystimeOnTimerStop() {
        return this.systimeOnTimerStop;
    }

    @Override
    public boolean isTimeRunning() {
        return this.runnerTimer != null && this.runnerTimer.isStarted();
    }

    @Override
    public void setPropagateValueChange(boolean bl) {
        boolean bl2 = this.getInternalStateFlag(10);
        if (bl2 != bl) {
            this.setInternalStateFlag(10, bl);
            this.propagateValueChangeChanged(bl2);
        }
    }

    protected boolean getPropagateValueChange() {
        return this.getInternalStateFlag(10);
    }

    protected boolean doUpdate() {
        return this.runnerTimer != null && this.runnerTimer.isStarted();
    }

    private void syncTimesChanged(int[] nArray) {
        if (this.syncTimes == null || this.syncTimes.length < 3) {
            return;
        }
        this.updateInternalTimeAndTimer();
    }

    private void timeSpanChanged(int n) {
        this.updateValueChangeRate();
        this.updateValue();
    }

    private void valueChanged(int n) {
        if (this.outputReferences == null || this.outputReferences.length == 0 || !this.getPropagateValueChange()) {
            return;
        }
        for (int i2 = this.outputReferences.length - 1; i2 >= 0; --i2) {
            if (this.outputReferences[i2] == null) continue;
            this.outputReferences[i2].setValue(this.value);
        }
    }

    private void valueMaxChanged(int n) {
        this.updateValueChangeRate();
        this.updateValue();
    }

    private void valueMinChanged(int n) {
        this.updateValueChangeRate();
        this.updateValue();
    }

    private void propagateValueChangeChanged(boolean bl) {
        if (this.getInternalStateFlag(10)) {
            int n = this.calculateValueFromTime(this.internalTime);
            this.set_value(n);
        }
    }

    private void updateValueChangeRate() {
        if (this.timeSpan > 0) {
            float f2 = this.valueMax - this.valueMin;
            this.valueChangeRate = f2 / (float)this.timeSpan;
        } else {
            this.valueChangeRate = 1.0f;
        }
    }

    private void updateValue() {
        int n = this.calculateValueFromTime(this.internalTime);
        if (this.is_unbounded() || n >= this.get_valueMin() && n <= this.get_valueMax()) {
            this.disableAnimations();
            this.set_value(n);
            this.enableAnimations();
        }
    }

    private void updateInternalTimeAndTimer() {
        long l = this.syncTimes[1];
        int n = this.syncTimes[0];
        if (n == 1) {
            int n2 = this.syncTimes[2];
            long l2 = ServiceManager.timerManager.getSystemTimeMillis();
            int n3 = (int)l2;
            long l3 = n3 < n2 ? this.calcSystemTimeDiffCorrected(l2, n2) : l2 - (long)n2;
            this.setInternalTime(l += l3);
            this.startValueChangeTimer();
        } else {
            int n4 = this.calculateValueFromTime(l);
            if (this.getPropagateValueChange()) {
                this.set_value(n4);
            }
            this.setInternalTime(l);
        }
    }

    @Override
    public void resetValue() {
        this.stop();
        this.set_value(this.get_valueMin());
        this.setInternalTime(0L);
    }

    @Override
    public void start() {
        this.startValueChangeTimer();
    }

    @Override
    public void stop() {
        this.stopValueChangeTimer();
    }

    protected int calculateValueFromTime(long l) {
        return this.get_valueMin() + (int)Math.floor(this.getValueChangeRate() * (float)l);
    }

    private long calcSystemTimeDiffCorrected(long l, long l2) {
        LOGGER.info(1).append("RunnerWidget: Current System Time is smaller than last System Time. Performing correction!");
        long l3 = l >> 32 << 32;
        long l4 = l - (l2 + l3);
        LOGGER.info(1).append("RunnerWidget: current system time = ").append(l).append("\tlast system time = ").append(l2).append("\tcorrected diff = ").append(l4);
        return l4;
    }

    private boolean startValueChangeTimer() {
        if (this.runnerTimer != null && this.runnerTimer.isStarted()) {
            return true;
        }
        int n = this.get_updateInterval();
        if (n < 30) {
            n = 30;
        }
        this.runnerTimer = ServiceManager.timerManager.createTimer("RunnerWidget.RunnerTimer", n, true, new RunnerWidget$ValueChanger(this, this, this.internalTime), ServiceManager.eventDispatcher);
        this.runnerTimer.start();
        return true;
    }

    private void stopValueChangeTimer() {
        if (this.runnerTimer != null) {
            if (this.runnerTimer.isStarted()) {
                this.runnerTimer.stop();
            }
            this.runnerTimer = null;
            this.storeSystimeOnTimerStop();
        }
    }

    protected void storeSystimeOnTimerStop() {
        this.systimeOnTimerStop = (int)ServiceManager.timerManager.getSystemTimeMillis();
    }
}

