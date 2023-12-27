/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.scene.graph.visual.camera;

import de.vw.mib.graphics.math.algebra.Vector3f;
import de.vw.mib.graphics.scene.graph.visual.camera.CameraEntity;

public interface FrustumCamera
extends CameraEntity {
    default public void lookAt(Vector3f vector3f, Vector3f vector3f2, Vector3f vector3f3) {
    }

    default public float getNear() {
    }

    default public void setNear(float f2) {
    }

    default public float getFar() {
    }

    default public void setFar(float f2) {
    }
}

