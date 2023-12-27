/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.scene.graph.visual.camera;

import de.vw.mib.graphics.scene.graph.visual.camera.FrustumCamera;

public interface OrthographicCamera
extends FrustumCamera {
    default public float getLeft() {
    }

    default public void setLeft(float f2) {
    }

    default public float getRight() {
    }

    default public void setRight(float f2) {
    }

    default public float getTop() {
    }

    default public void setTop(float f2) {
    }

    default public float getBottom() {
    }

    default public void setBottom(float f2) {
    }
}

