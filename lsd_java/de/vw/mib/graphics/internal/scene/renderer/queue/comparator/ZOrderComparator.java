/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.scene.renderer.queue.comparator;

import de.vw.mib.graphics.internal.scene.renderer.queue.Geometry;
import de.vw.mib.graphics.internal.scene.renderer.queue.comparator.AbstractGeometryComparator;

public final class ZOrderComparator
extends AbstractGeometryComparator {
    @Override
    public int compare(Object object, Object object2) {
        float f2;
        Geometry geometry = (Geometry)object;
        Geometry geometry2 = (Geometry)object2;
        float f3 = geometry.getTransform().getTranslation().getZ();
        if (f3 > (f2 = geometry2.getTransform().getTranslation().getZ())) {
            return 1;
        }
        if (f3 < f2) {
            return -1;
        }
        return 0;
    }
}

