/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.scene.graph.visual.light;

import de.vw.mib.graphics.math.geometry.Point3f;
import de.vw.mib.graphics.scene.graph.visual.light.ReflectiveLight;

public interface PointLight
extends ReflectiveLight {
    default public Point3f getPosition() {
    }

    default public void setPosition(Point3f point3f) {
    }

    default public float getConstantAttenuation() {
    }

    default public void setConstantAttenuation(float f2) {
    }

    default public float getLinearAttenuation() {
    }

    default public void setLinearAttenuation(float f2) {
    }

    default public float getQuadraticAttenuation() {
    }

    default public void setQuadraticAttenuation(float f2) {
    }
}

