/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.animation.animations;

import de.vw.mib.animation.animations.AbstractAnimation;
import de.vw.mib.animation.easing.EasingFacade;
import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.util.StringBuilder;

public abstract class EasingAnimation
extends AbstractAnimation {
    private EasingParams easing;
    private float startValue;
    private float deltaValue;
    private float currentValue;

    public EasingAnimation(EasingParams easingParams) {
        this(false, easingParams);
    }

    public EasingAnimation(boolean bl, EasingParams easingParams) {
        super(bl);
        this.easing = easingParams;
    }

    @Override
    public Object clone() {
        try {
            EasingAnimation easingAnimation = (EasingAnimation)super.clone();
            easingAnimation.easing = (EasingParams)this.easing.clone();
            return easingAnimation;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new RuntimeException(cloneNotSupportedException);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[super=").append(super.toString());
        stringBuilder.append(",easing=").append(this.easing);
        stringBuilder.append(",startValue=").append(this.startValue);
        stringBuilder.append(",deltaValue=").append(this.deltaValue);
        stringBuilder.append(",currentValue=").append(this.currentValue);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public int getDuration() {
        return this.easing.getDuration();
    }

    public EasingParams getEasingParams() {
        return this.easing;
    }

    public void setEasingParams(EasingParams easingParams) {
        this.easing = easingParams;
    }

    public float getStartValue() {
        return this.startValue;
    }

    public void setStartValue(float f2) {
        this.startValue = f2;
    }

    public float getDeltaValue() {
        return this.deltaValue;
    }

    public void setDeltaValue(float f2) {
        this.deltaValue = f2;
    }

    public float getCurrentValue() {
        return this.currentValue;
    }

    protected void setCurrentValue(float f2) {
        this.currentValue = f2;
    }

    @Override
    public void start(long l) {
        this.currentValue = this.startValue;
        if (this.deltaValue == 0.0f && LOGGER.isTraceEnabled(2)) {
            LogMessage logMessage = LOGGER.warn(2);
            logMessage.append(super.getClass().getName());
            logMessage.append(".start(): delta == 0");
            logMessage.log();
        }
        super.start(l + (long)this.easing.getStartDelay());
    }

    @Override
    public final void animate(long l, long l2) {
        long l3 = l2 - (long)this.getAnimationInterval();
        long l4 = this.isLooped() ? (l - this.getStartTime()) % (long)this.easing.getDuration() : l - this.getStartTime();
        boolean bl = l4 < (long)this.easing.getDuration();
        this.currentValue = bl ? EasingFacade.calculate(l4, this.startValue, this.deltaValue, this.easing) : this.startValue + this.deltaValue;
        if (LOGGER.isTraceEnabled(2)) {
            LogMessage logMessage = LOGGER.trace(2);
            logMessage.append(super.getClass().getName());
            logMessage.append(".animate(): currentTime ").append(l);
            logMessage.append(" deltaTime ").append(l2);
            logMessage.append(" jitter ").append(l3);
            logMessage.append(" startTime ").append(this.getStartTime());
            logMessage.append(" relativeTime ").append(l - this.getStartTime());
            logMessage.append(" duration ").append(this.easing.getDuration());
            logMessage.append(" startValue ").append(this.startValue);
            logMessage.append(" deltaValue ").append(this.deltaValue);
            logMessage.append(" currentValue ").append(this.currentValue);
            logMessage.log();
        }
        this.animate(this.currentValue, l, l2);
        this.notifyProgress(l);
        if (!bl) {
            this.stop();
        }
    }

    public abstract void animate(float f2, long l, long l2) {
    }
}

