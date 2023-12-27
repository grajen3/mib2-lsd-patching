/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.scene.graph.spatial;

import de.vw.mib.graphics.math.geometry.BoundingVolume;

public interface Spatial {
    default public BoundingVolume getBoundingVolume() {
    }
}

