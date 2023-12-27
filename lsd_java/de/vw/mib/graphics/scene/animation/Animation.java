/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.scene.animation;

import de.vw.mib.graphics.material.Material;
import de.vw.mib.graphics.scene.animation.Animatable;
import de.vw.mib.graphics.scene.animation.AnimationTrack;
import de.vw.mib.graphics.scene.animation.target.AnimationTarget;
import de.vw.mib.graphics.scene.animation.target.CameraAnimationTarget;
import de.vw.mib.graphics.scene.animation.target.LightAnimationTarget;
import de.vw.mib.graphics.scene.animation.target.MaterialAnimationTarget;
import de.vw.mib.graphics.scene.animation.target.NodeAnimationTarget;
import de.vw.mib.graphics.scene.graph.SceneNode;
import de.vw.mib.graphics.scene.graph.visual.camera.CameraEntity;
import de.vw.mib.graphics.scene.graph.visual.light.LightEntity;

public interface Animation
extends Animatable {
    default public String getName() {
    }

    default public void setName(String string) {
    }

    default public AnimationTrack getParent() {
    }

    default public float getStartTime() {
    }

    default public float getEndTime() {
    }

    default public CameraAnimationTarget createCameraAnimationTarget(int n, int n2, CameraEntity cameraEntity) {
    }

    default public LightAnimationTarget createLightAnimationTarget(int n, int n2, LightEntity lightEntity) {
    }

    default public MaterialAnimationTarget createMaterialAnimationTarget(int n, int n2, Material material) {
    }

    default public NodeAnimationTarget createNodeAnimationTarget(int n, int n2, int n3, SceneNode sceneNode) {
    }

    default public AnimationTarget getAnimationTarget() {
    }

    default public void setAnimationTarget(AnimationTarget animationTarget) {
    }
}

