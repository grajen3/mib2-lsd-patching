/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.scene.graph.visual.light;

import de.vw.mib.graphics.math.algebra.Vector3f;
import de.vw.mib.graphics.scene.graph.visual.light.ReflectiveLight;

public interface DirectionalLight
extends ReflectiveLight {
    default public Vector3f getDirection() {
    }

    default public void setDirection(Vector3f vector3f) {
    }
}

