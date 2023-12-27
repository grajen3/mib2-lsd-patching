/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.scene.animation;

import de.vw.mib.NotYetImplementedException;
import de.vw.mib.graphics.internal.scene.animation.target.UnpooledCameraAnimationTarget;
import de.vw.mib.graphics.internal.scene.animation.target.UnpooledLightAnimationTarget;
import de.vw.mib.graphics.internal.scene.animation.target.UnpooledMaterialAnimationTarget;
import de.vw.mib.graphics.internal.scene.animation.target.UnpooledNodeAnimationTarget;
import de.vw.mib.graphics.material.Material;
import de.vw.mib.graphics.scene.animation.Animation;
import de.vw.mib.graphics.scene.animation.AnimationTrack;
import de.vw.mib.graphics.scene.animation.target.AnimationTarget;
import de.vw.mib.graphics.scene.animation.target.CameraAnimationTarget;
import de.vw.mib.graphics.scene.animation.target.LightAnimationTarget;
import de.vw.mib.graphics.scene.animation.target.MaterialAnimationTarget;
import de.vw.mib.graphics.scene.animation.target.NodeAnimationTarget;
import de.vw.mib.graphics.scene.graph.SceneNode;
import de.vw.mib.graphics.scene.graph.visual.camera.CameraEntity;
import de.vw.mib.graphics.scene.graph.visual.light.LightEntity;
import de.vw.mib.util.StringBuilder;

public abstract class AbstractAnimation
implements Animation {
    private String name;
    private AnimationTarget animationTarget;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[name=").append(this.name);
        stringBuilder.append(",animationTarget=").append(this.animationTarget);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public abstract void animate(float f2) {
    }

    @Override
    public final String getName() {
        return this.name;
    }

    @Override
    public final void setName(String string) {
        this.name = string;
    }

    @Override
    public final AnimationTrack getParent() {
        throw new NotYetImplementedException();
    }

    @Override
    public abstract float getStartTime() {
    }

    @Override
    public abstract float getEndTime() {
    }

    @Override
    public final CameraAnimationTarget createCameraAnimationTarget(int n, int n2, CameraEntity cameraEntity) {
        return new UnpooledCameraAnimationTarget(n, n2, cameraEntity);
    }

    @Override
    public final LightAnimationTarget createLightAnimationTarget(int n, int n2, LightEntity lightEntity) {
        return new UnpooledLightAnimationTarget(n, n2, lightEntity);
    }

    @Override
    public final MaterialAnimationTarget createMaterialAnimationTarget(int n, int n2, Material material) {
        return new UnpooledMaterialAnimationTarget(n, n2, material);
    }

    @Override
    public final NodeAnimationTarget createNodeAnimationTarget(int n, int n2, int n3, SceneNode sceneNode) {
        return new UnpooledNodeAnimationTarget(n, n2, n3, sceneNode);
    }

    @Override
    public final AnimationTarget getAnimationTarget() {
        return this.animationTarget;
    }

    @Override
    public final void setAnimationTarget(AnimationTarget animationTarget) {
        this.animationTarget = animationTarget;
    }
}

