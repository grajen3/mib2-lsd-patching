/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.scene.animation;

import de.vw.mib.NotYetImplementedException;
import de.vw.mib.graphics.internal.scene.animation.keyframe.UnpooledKeyframeAnimation;
import de.vw.mib.graphics.scene.animation.Animatable;
import de.vw.mib.graphics.scene.animation.Animation;
import de.vw.mib.graphics.scene.animation.AnimationClip;
import de.vw.mib.graphics.scene.animation.AnimationTrack;
import de.vw.mib.graphics.scene.animation.keyframe.KeyframeAnimation;
import de.vw.mib.util.StringBuilder;
import java.util.ArrayList;
import java.util.List;

public final class UnpooledAnimationTrack
implements AnimationTrack {
    private String name;
    private List animations = new ArrayList();
    private List animationTracks = new ArrayList();
    private float startTime;
    private float endTime;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[name=").append(this.name);
        stringBuilder.append(",animations=").append(this.animations);
        stringBuilder.append(",animationTracks=").append(this.animationTracks);
        stringBuilder.append(",startTime=").append(this.startTime);
        stringBuilder.append(",endTime=").append(this.endTime);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public void animate(float f2) {
        Animatable animatable;
        int n;
        for (n = this.animations.size() - 1; n >= 0; --n) {
            animatable = (Animation)this.animations.get(n);
            animatable.animate(f2);
        }
        for (n = this.animationTracks.size() - 1; n >= 0; --n) {
            animatable = (AnimationTrack)this.animationTracks.get(n);
            animatable.animate(f2);
        }
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String string) {
        this.name = string;
    }

    @Override
    public AnimationClip getParent() {
        throw new NotYetImplementedException();
    }

    @Override
    public float getStartTime() {
        this.updateTimes();
        return this.startTime;
    }

    @Override
    public float getEndTime() {
        this.updateTimes();
        return this.endTime;
    }

    @Override
    public KeyframeAnimation createKeyframeAnimation() {
        return new UnpooledKeyframeAnimation();
    }

    @Override
    public int getAnimationCount() {
        return this.animations.size();
    }

    @Override
    public Animation getAnimation(int n) {
        return (Animation)this.animations.get(n);
    }

    @Override
    public void setAnimation(int n, Animation animation) {
        this.animations.set(n, animation);
    }

    @Override
    public void addAnimation(Animation animation) {
        this.animations.add(animation);
    }

    @Override
    public void removeAnimation(int n) {
        this.animations.remove(n);
    }

    @Override
    public List getAnimations() {
        return this.animations;
    }

    @Override
    public int getAnimationTrackCount() {
        return this.animationTracks.size();
    }

    @Override
    public AnimationTrack getAnimationTrack(int n) {
        return (AnimationTrack)this.animationTracks.get(n);
    }

    @Override
    public void setAnimationTrack(int n, AnimationTrack animationTrack) {
        this.animationTracks.set(n, animationTrack);
        this.updateTimes();
    }

    @Override
    public void addAnimationTrack(AnimationTrack animationTrack) {
        this.animationTracks.add(animationTrack);
        this.updateTimes();
    }

    @Override
    public void removeAnimationTrack(int n) {
        this.animationTracks.remove(n);
        this.updateTimes();
    }

    @Override
    public List getAnimationTracks() {
        return this.animationTracks;
    }

    private void updateTimes() {
        Animatable animatable;
        int n;
        this.startTime = 0x1000000;
        this.endTime = -32897;
        for (n = this.animations.size() - 1; n >= 0; --n) {
            animatable = (Animation)this.animations.get(n);
            this.startTime = Math.max(this.startTime, animatable.getStartTime());
            this.endTime = Math.min(this.endTime, animatable.getEndTime());
        }
        for (n = this.animationTracks.size() - 1; n >= 0; --n) {
            animatable = (AnimationTrack)this.animationTracks.get(n);
            this.startTime = Math.max(this.startTime, animatable.getStartTime());
            this.endTime = Math.min(this.endTime, animatable.getEndTime());
        }
    }
}

