/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.scene.renderer.queue.comparator;

import de.vw.mib.graphics.Camera;
import java.util.Comparator;

public interface GeometryComparator
extends Comparator {
    default public Camera getCamera() {
    }

    default public void setCamera(Camera camera) {
    }
}

