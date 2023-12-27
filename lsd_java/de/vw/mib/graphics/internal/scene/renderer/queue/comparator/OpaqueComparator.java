/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.scene.renderer.queue.comparator;

import de.vw.mib.graphics.internal.scene.renderer.queue.Geometry;
import de.vw.mib.graphics.internal.scene.renderer.queue.comparator.AbstractGeometryComparator;
import de.vw.mib.graphics.material.Material;

public final class OpaqueComparator
extends AbstractGeometryComparator {
    @Override
    public int compare(Object object, Object object2) {
        Geometry geometry = (Geometry)object;
        Geometry geometry2 = (Geometry)object2;
        Material material = geometry.getMaterial();
        Material material2 = geometry2.getMaterial();
        int n = material2.getComplexity() - material.getComplexity();
        if (n == 0) {
            float f2;
            float f3 = this.distanceToCamera(geometry);
            if (f3 == (f2 = this.distanceToCamera(geometry2))) {
                return 0;
            }
            if (f3 < f2) {
                return -1;
            }
            return 1;
        }
        return n;
    }
}

