/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.scene.graph.visual.camera;

import de.vw.mib.graphics.scene.graph.visual.camera.FrustumCamera;

public interface PerspectiveCamera
extends FrustumCamera {
    default public float getAspectRatio() {
    }

    default public void setAspectRatio(float f2) {
    }

    default public float getFieldOfView() {
    }

    default public void setFieldOfView(float f2) {
    }
}

