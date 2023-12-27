/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.scene.animation;

import de.vw.mib.graphics.internal.scene.animation.UnpooledAnimationTrack;
import de.vw.mib.graphics.scene.animation.AnimationClip;
import de.vw.mib.graphics.scene.animation.AnimationTrack;
import de.vw.mib.util.StringBuilder;
import java.util.ArrayList;
import java.util.List;

public final class UnpooledAnimationClip
implements AnimationClip {
    private String name;
    private List animationTracks = new ArrayList();
    private float startTime;
    private float endTime;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[name=").append(this.name);
        stringBuilder.append(",animationTracks=").append(this.animationTracks);
        stringBuilder.append(",startTime=").append(this.startTime);
        stringBuilder.append(",endTime=").append(this.endTime);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public void animate(float f2) {
        for (int i2 = this.animationTracks.size() - 1; i2 >= 0; --i2) {
            AnimationTrack animationTrack = (AnimationTrack)this.animationTracks.get(i2);
            animationTrack.animate(f2);
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
    public float getDuration() {
        return this.endTime - this.startTime;
    }

    @Override
    public AnimationTrack createAnimationTrack() {
        return new UnpooledAnimationTrack();
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
        this.startTime = 0x1000000;
        this.endTime = -32897;
        for (int i2 = this.animationTracks.size() - 1; i2 >= 0; --i2) {
            AnimationTrack animationTrack = (AnimationTrack)this.animationTracks.get(i2);
            this.startTime = Math.max(this.startTime, animationTrack.getStartTime());
            this.endTime = Math.min(this.endTime, animationTrack.getEndTime());
        }
    }
}

