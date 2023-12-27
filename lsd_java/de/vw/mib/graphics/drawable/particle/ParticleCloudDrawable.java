/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.drawable.particle;

import de.vw.mib.graphics.drawable.particle.ParticleDrawable;
import de.vw.mib.graphics.math.geometry.Point3f;

public interface ParticleCloudDrawable
extends ParticleDrawable {
    default public Point3f[] getCoordinates3D() {
    }

    default public void setCoordinates3D(Point3f[] point3fArray) {
    }
}

