/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.scene.animation.keyframe;

import de.vw.mib.NotYetImplementedException;
import de.vw.mib.graphics.internal.scene.animation.AbstractAnimation;
import de.vw.mib.graphics.internal.scene.animation.keyframe.UnpooledKeyframe;
import de.vw.mib.graphics.math.Util;
import de.vw.mib.graphics.math.function.curve.bezier.CubicBezierCurve2f;
import de.vw.mib.graphics.math.geometry.Point2f;
import de.vw.mib.graphics.scene.animation.keyframe.Keyframe;
import de.vw.mib.graphics.scene.animation.keyframe.KeyframeAnimation;
import de.vw.mib.graphics.scene.animation.target.AnimationTarget;
import de.vw.mib.util.StringBuilder;
import java.util.ArrayList;
import java.util.List;

public final class UnpooledKeyframeAnimation
extends AbstractAnimation
implements KeyframeAnimation {
    private List keyframes;
    private float startTime;
    private float endTime;
    private Point2f p0 = new Point2f();
    private Point2f p1 = new Point2f();
    private Point2f c0 = new Point2f();
    private Point2f c1 = new Point2f();
    private CubicBezierCurve2f bezierCurve = new CubicBezierCurve2f();
    private Point2f p = new Point2f();
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$graphics$internal$scene$animation$keyframe$UnpooledKeyframeAnimation;

    public UnpooledKeyframeAnimation() {
        this.keyframes = new ArrayList();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[super=").append(super.toString());
        stringBuilder.append(",keyframes=").append(this.keyframes);
        stringBuilder.append(",startTime=").append(this.startTime);
        stringBuilder.append(",endTime=").append(this.endTime);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public void animate(float f2) {
        int n = this.getKeyframeCount();
        if (n < 1) {
            // empty if block
        }
        if (n >= 2) {
            AnimationTarget animationTarget;
            Keyframe keyframe;
            Keyframe keyframe2;
            int n2 = 0;
            do {
                keyframe = (Keyframe)this.keyframes.get(n2);
            } while ((keyframe2 = (Keyframe)this.keyframes.get(++n2)).getTime() < f2);
            float f3 = keyframe.getTime();
            float f4 = keyframe2.getTime();
            float f5 = f4 - f3;
            float f6 = f2 - f3;
            float f7 = Util.saturate(f6 / f5);
            boolean bl = false;
            boolean bl2 = true;
            boolean bl3 = false;
            switch (0) {
                case 0: {
                    break;
                }
                case 1: {
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Invalid animation play mode");
                }
            }
            float[] fArray = keyframe.getAnimationValue();
            float[] fArray2 = keyframe2.getAnimationValue();
            if (!$assertionsDisabled && fArray.length != fArray2.length) {
                throw new AssertionError();
            }
            float[] fArray3 = new float[fArray.length];
            switch (keyframe.getInterpolationType()) {
                case 0: {
                    int n3;
                    for (n3 = 0; n3 < fArray3.length; ++n3) {
                        fArray3[n3] = f7 < f5 ? fArray[n3] : fArray2[n3];
                    }
                    break;
                }
                case 1: {
                    int n3;
                    for (n3 = 0; n3 < fArray3.length; ++n3) {
                        fArray3[n3] = Util.interpolate(fArray[n3], fArray2[n3], f7);
                    }
                    break;
                }
                case 2: {
                    int n3;
                    this.c0.set(keyframe.getOutTangent());
                    this.c1.set(keyframe2.getInTangent());
                    for (n3 = 0; n3 < fArray3.length; ++n3) {
                        this.p0.set(f3, fArray[n3]);
                        this.p1.set(f4, fArray2[n3]);
                        this.bezierCurve.set(this.p0, this.c0, this.c1, this.p1);
                        this.bezierCurve.evaluate(f7, this.p);
                        fArray3[n3] = this.p.y;
                    }
                    break;
                }
                case 3: 
                case 4: 
                case 5: {
                    throw new NotYetImplementedException();
                }
                default: {
                    throw new IllegalArgumentException("Invalid keyframe interpolation type");
                }
            }
            if ((animationTarget = this.getAnimationTarget()) != null) {
                animationTarget.setValue(fArray3);
            }
        }
    }

    @Override
    public float getStartTime() {
        return this.startTime;
    }

    @Override
    public float getEndTime() {
        return this.endTime;
    }

    @Override
    public Keyframe createKeyframe() {
        return new UnpooledKeyframe();
    }

    @Override
    public int getKeyframeCount() {
        return this.keyframes.size();
    }

    @Override
    public Keyframe getKeyframe(int n) {
        return (Keyframe)this.keyframes.get(n);
    }

    @Override
    public Keyframe getKeyframeAt(float f2) {
        throw new NotYetImplementedException();
    }

    @Override
    public void setKeyframe(int n, Keyframe keyframe) {
        this.keyframes.set(n, keyframe);
        this.updateTimes();
    }

    @Override
    public void addKeyframe(Keyframe keyframe) {
        this.keyframes.add(keyframe);
        this.updateTimes();
    }

    @Override
    public void removeKeyframe(int n) {
        this.keyframes.remove(n);
        this.updateTimes();
    }

    private void updateTimes() {
        if (!this.keyframes.isEmpty()) {
            this.startTime = ((Keyframe)this.keyframes.get(0)).getTime();
            this.endTime = ((Keyframe)this.keyframes.get(this.keyframes.size() - 1)).getTime();
        } else {
            this.startTime = 0.0f;
            this.endTime = 0.0f;
        }
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
        $assertionsDisabled = !(class$de$vw$mib$graphics$internal$scene$animation$keyframe$UnpooledKeyframeAnimation == null ? (class$de$vw$mib$graphics$internal$scene$animation$keyframe$UnpooledKeyframeAnimation = UnpooledKeyframeAnimation.class$("de.vw.mib.graphics.internal.scene.animation.keyframe.UnpooledKeyframeAnimation")) : class$de$vw$mib$graphics$internal$scene$animation$keyframe$UnpooledKeyframeAnimation).desiredAssertionStatus();
    }
}

