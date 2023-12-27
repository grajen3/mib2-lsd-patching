/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.scene.graph.transform;

import de.vw.mib.graphics.math.algebra.Vector3f;
import de.vw.mib.graphics.math.geometry.Point3f;

public interface Positionable {
    default public void getPosition(Point3f point3f) {
    }

    default public void setPosition(Point3f point3f) {
    }

    default public void setPosition(float f2, float f3, float f4) {
    }

    default public Positionable translate(Vector3f vector3f) {
    }

    default public Positionable translate(float f2, float f3, float f4) {
    }
}

