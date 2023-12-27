/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.scene.animation.skin;

import de.vw.mib.graphics.math.Transform;

public interface Bone {
    default public String getName() {
    }

    default public void setName(String string) {
    }

    default public Bone getParent() {
    }

    default public Transform getTransform() {
    }

    default public void setTransform(Transform transform) {
    }

    default public Transform getGlobalTransform() {
    }
}

