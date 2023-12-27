/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.scene.graph.transform;

import de.vw.mib.graphics.math.Transform;

public interface Transformable {
    default public Transform getTransform() {
    }

    default public void setTransform(Transform transform) {
    }

    default public Transformable transform(Transform transform) {
    }
}

