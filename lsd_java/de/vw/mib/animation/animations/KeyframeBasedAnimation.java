/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.animation.animations;

import de.vw.mib.animation.animations.AbstractAnimation;
import de.vw.mib.animation.animations.Keyframe;
import de.vw.mib.animation.animations.KeyframeAnimationParams;
import de.vw.mib.animation.animations.KeyframeBasedAnimation$AnimatedPropertyPool;
import de.vw.mib.animation.animations.KeyframeBasedAnimation$PooledAnimatedProperty;
import de.vw.mib.animation.animations.references.AbstractValueReferenceMetric;
import de.vw.mib.animation.animations.references.BooleanValueReferenceMetric;
import de.vw.mib.animation.animations.references.FloatValueReferenceMetric;
import de.vw.mib.animation.animations.references.IntegerValueReferenceMetric;
import de.vw.mib.animation.animations.references.ValueReference;
import de.vw.mib.animation.animations.references.ValueReferenceMetric;
import de.vw.mib.animation.control.AnimatedPropertiesAccessor;
import de.vw.mib.animation.easing.EasingFacade;
import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.util.StringBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class KeyframeBasedAnimation
extends AbstractAnimation {
    private static final int ANIMATEDPROPERTY_POOL_MAXIMUM_CAPACITY;
    private static final KeyframeBasedAnimation$AnimatedPropertyPool ANIMATEDPROPERTY_POOL;
    private final int keyframeAnimationId;
    private final KeyframeAnimationParams keyframeAnimationParams;
    private final AnimatedPropertiesAccessor animatedPropertiesAccessor;
    private final int targetID;
    private int nextKeyframeIndex;
    private int currentFrame;
    private static final int ACTIVE_ANIMATED_PROPERTIES_LIST_INITIAL_CAPACITY;
    private List activeAnimatedProperties;
    private int startDelay;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$animation$animations$KeyframeBasedAnimation;

    public KeyframeBasedAnimation(int n, KeyframeAnimationParams keyframeAnimationParams, AnimatedPropertiesAccessor animatedPropertiesAccessor, int n2) {
        super(keyframeAnimationParams.isLooping());
        this.keyframeAnimationId = n;
        this.keyframeAnimationParams = keyframeAnimationParams;
        this.animatedPropertiesAccessor = animatedPropertiesAccessor;
        this.targetID = n2;
        this.activeAnimatedProperties = new ArrayList(20);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[super=").append(super.toString());
        stringBuilder.append(",keyframeAnimationId=").append(this.keyframeAnimationId);
        stringBuilder.append(",targetID=").append(this.targetID);
        stringBuilder.append(",nextKeyframeIndex=").append(this.nextKeyframeIndex);
        stringBuilder.append(",currentFrame=").append(this.currentFrame);
        stringBuilder.append(",startDelay=").append(this.startDelay);
        stringBuilder.append(",duration=").append(this.getDuration());
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public int getDuration() {
        return this.keyframeAnimationParams.getDuration();
    }

    public int getKeyframeAnimationId() {
        return this.keyframeAnimationId;
    }

    public KeyframeAnimationParams getKeyframeAnimationParams() {
        return this.keyframeAnimationParams;
    }

    public Keyframe[] getKeyframes() {
        return this.keyframeAnimationParams.getKeyframes();
    }

    public AnimatedPropertiesAccessor getAninmatedPropertiesAccessor() {
        return this.animatedPropertiesAccessor;
    }

    public int getTargetID() {
        return this.targetID;
    }

    public int getStartDelay() {
        return this.startDelay;
    }

    public void setStartDelay(int n) {
        this.startDelay = n;
    }

    @Override
    public void start(long l) {
        this.nextKeyframeIndex = 0;
        this.currentFrame = 0;
        super.start(l + (long)this.getStartDelay());
    }

    @Override
    public void animate(long l, long l2) {
        Keyframe[] keyframeArray = this.getKeyframes();
        if (!$assertionsDisabled && keyframeArray.length <= 0) {
            throw new AssertionError((Object)"No keyframes specified");
        }
        if (this.getNumberOfKeyframes() > 0) {
            Keyframe keyframe = null;
            if (this.nextKeyframeIndex == 0) {
                keyframe = keyframeArray[this.nextKeyframeIndex++];
                this.startKeyframe(keyframe, l, this.animatedPropertiesAccessor);
            } else if (this.getNumberOfKeyframes() > this.nextKeyframeIndex) {
                keyframe = keyframeArray[this.nextKeyframeIndex];
                if (l - this.getStartTime() >= (long)keyframe.getStartTime()) {
                    ++this.nextKeyframeIndex;
                    this.startKeyframe(keyframe, l, this.animatedPropertiesAccessor);
                }
            }
            this.animateActiveProperties(this.animatedPropertiesAccessor, l, l2);
            this.notifyProgress(l);
            if (this.activeAnimatedProperties.size() == 0 && this.getNumberOfKeyframes() <= this.nextKeyframeIndex) {
                this.stop();
            }
        }
        ++this.currentFrame;
    }

    private void startKeyframe(Keyframe keyframe, long l, AnimatedPropertiesAccessor animatedPropertiesAccessor) {
        Object object;
        Set set = keyframe.getValueReferences();
        if (LOGGER.isTraceEnabled(4)) {
            object = LOGGER.trace(4);
            object.append(this).append(": Starting keyframe #").append(this.nextKeyframeIndex - 1).log();
        }
        object = set.iterator();
        while (object.hasNext()) {
            float f2;
            float f3;
            float f4;
            Object object2;
            ValueReference valueReference = (ValueReference)object.next();
            ValueReferenceMetric valueReferenceMetric = keyframe.getMetric(valueReference);
            switch (valueReferenceMetric.getReferenceClass()) {
                case 0: {
                    object2 = (IntegerValueReferenceMetric)valueReferenceMetric;
                    f4 = animatedPropertiesAccessor.getAnimIntValue(valueReference.getPropertyID(), this.targetID);
                    f3 = ((AbstractValueReferenceMetric)object2).isRelativeValue() ? f4 : (float)((IntegerValueReferenceMetric)object2).getSourceValue();
                    f2 = ((IntegerValueReferenceMetric)object2).getTargetValue();
                    break;
                }
                case 1: {
                    object2 = (FloatValueReferenceMetric)valueReferenceMetric;
                    f4 = animatedPropertiesAccessor.getAnimFloatValue(valueReference.getPropertyID(), this.targetID);
                    f3 = ((AbstractValueReferenceMetric)object2).isRelativeValue() ? f4 : ((FloatValueReferenceMetric)object2).getSourceValue();
                    f2 = ((FloatValueReferenceMetric)object2).getTargetValue();
                    break;
                }
                case 2: {
                    object2 = (BooleanValueReferenceMetric)valueReferenceMetric;
                    float f5 = f4 = animatedPropertiesAccessor.getAnimBooleanValue(valueReference.getPropertyID(), this.targetID) ? 1.0f : 0.0f;
                    f3 = ((AbstractValueReferenceMetric)object2).isRelativeValue() ? f4 : (((BooleanValueReferenceMetric)object2).getSourceValue() ? 1.0f : 0.0f);
                    f2 = ((BooleanValueReferenceMetric)object2).getTargetValue() ? 1.0f : 0.0f;
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Invalid property reference class");
                }
            }
            if (f3 == f4 && f4 == f2) {
                if (!LOGGER.isTraceEnabled(4)) continue;
                object2 = LOGGER.trace(4);
                object2.append(this).append(": Skipping animating keyframe property ").append(valueReference).log();
                continue;
            }
            object2 = (KeyframeBasedAnimation$PooledAnimatedProperty)ANIMATEDPROPERTY_POOL.borrowObject();
            ((KeyframeBasedAnimation$PooledAnimatedProperty)object2).setRelativeStartTime(l);
            ((KeyframeBasedAnimation$PooledAnimatedProperty)object2).setValueReference(valueReference);
            ((KeyframeBasedAnimation$PooledAnimatedProperty)object2).setValueReferenceMetric(valueReferenceMetric);
            ((KeyframeBasedAnimation$PooledAnimatedProperty)object2).setStartValue(f3);
            ((KeyframeBasedAnimation$PooledAnimatedProperty)object2).setEndValue(f2);
            this.activeAnimatedProperties.add(object2);
            if (!LOGGER.isTraceEnabled(4)) continue;
            LogMessage logMessage = LOGGER.trace(4);
            logMessage.append(this).append(": Started animating keyframe property ").append(object2).log();
        }
    }

    private void animateActiveProperties(AnimatedPropertiesAccessor animatedPropertiesAccessor, long l, long l2) {
        long l3 = l2 - (long)this.getAnimationInterval();
        Iterator iterator = this.activeAnimatedProperties.iterator();
        while (iterator.hasNext()) {
            float f2;
            boolean bl;
            KeyframeBasedAnimation$PooledAnimatedProperty keyframeBasedAnimation$PooledAnimatedProperty = (KeyframeBasedAnimation$PooledAnimatedProperty)iterator.next();
            ValueReferenceMetric valueReferenceMetric = keyframeBasedAnimation$PooledAnimatedProperty.getValueReferenceMetric();
            EasingParams easingParams = valueReferenceMetric.getEasing();
            long l4 = l - keyframeBasedAnimation$PooledAnimatedProperty.getRelativeStartTime();
            boolean bl2 = bl = l4 < (long)easingParams.getDuration();
            if (bl) {
                float f3 = keyframeBasedAnimation$PooledAnimatedProperty.getStartValue();
                float f4 = keyframeBasedAnimation$PooledAnimatedProperty.getEndValue() - f3;
                f2 = EasingFacade.calculate(l4, f3, f4, easingParams);
            } else {
                f2 = keyframeBasedAnimation$PooledAnimatedProperty.getEndValue();
            }
            if (LOGGER.isTraceEnabled(4)) {
                LogMessage logMessage = LOGGER.trace(4);
                logMessage.append(this).append(": Animating keyframe property ").append(keyframeBasedAnimation$PooledAnimatedProperty);
                logMessage.append(" currentTime ").append(l);
                logMessage.append(" deltaTime ").append(l2);
                logMessage.append(" jitter ").append(l3);
                logMessage.append(" startTime ").append(this.getStartTime());
                logMessage.append(" relativeTime ").append(l - this.getStartTime());
                logMessage.append(" duration ").append(easingParams.getDuration());
                logMessage.append(" currentValue ").append(f2);
                logMessage.log();
            }
            ValueReference valueReference = keyframeBasedAnimation$PooledAnimatedProperty.getValueReference();
            int n = valueReference.getPropertyID();
            switch (valueReference.getReferenceClass()) {
                case 0: {
                    animatedPropertiesAccessor.setAnimIntValue(n, this.targetID, Math.round(f2));
                    break;
                }
                case 1: {
                    animatedPropertiesAccessor.setAnimFloatValue(n, this.targetID, f2);
                    break;
                }
                case 2: {
                    animatedPropertiesAccessor.setAnimBooleanValue(n, this.targetID, Math.round(f2) != 0);
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Invalid property reference class");
                }
            }
            if (bl) continue;
            if (LOGGER.isTraceEnabled(4)) {
                LogMessage logMessage = LOGGER.trace(4);
                logMessage.append(this).append(": Stopped animating keyframe property ").append(keyframeBasedAnimation$PooledAnimatedProperty).log();
            }
            iterator.remove();
            ANIMATEDPROPERTY_POOL.releaseObject(keyframeBasedAnimation$PooledAnimatedProperty);
        }
    }

    public int getNumberOfKeyframes() {
        Keyframe[] keyframeArray = this.getKeyframes();
        return keyframeArray != null ? keyframeArray.length : 0;
    }

    public int getCurrentKeyframe() {
        return this.nextKeyframeIndex;
    }

    public int getCurrentFrame() {
        return this.currentFrame;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        $assertionsDisabled = !(class$de$vw$mib$animation$animations$KeyframeBasedAnimation == null ? (class$de$vw$mib$animation$animations$KeyframeBasedAnimation = KeyframeBasedAnimation.class$("de.vw.mib.animation.animations.KeyframeBasedAnimation")) : class$de$vw$mib$animation$animations$KeyframeBasedAnimation).desiredAssertionStatus();
        ANIMATEDPROPERTY_POOL = new KeyframeBasedAnimation$AnimatedPropertyPool(100);
    }
}

