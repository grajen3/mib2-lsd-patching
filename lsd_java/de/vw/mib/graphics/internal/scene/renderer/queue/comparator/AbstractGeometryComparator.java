/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.scene.renderer.queue.comparator;

import de.vw.mib.graphics.Camera;
import de.vw.mib.graphics.internal.scene.renderer.queue.Geometry;
import de.vw.mib.graphics.internal.scene.renderer.queue.comparator.GeometryComparator;

public abstract class AbstractGeometryComparator
implements GeometryComparator {
    private Camera camera;

    @Override
    public abstract int compare(Object object, Object object2) {
    }

    @Override
    public final Camera getCamera() {
        return this.camera;
    }

    @Override
    public final void setCamera(Camera camera) {
        this.camera = camera;
    }

    protected float distanceToCamera(Geometry geometry) {
        float f2 = geometry.getSortingDistance();
        if (Float.isInfinite(f2)) {
            f2 = geometry.getTransform().getTranslation().getZ();
            geometry.setSortingDistance(f2);
        }
        return f2;
    }
}

