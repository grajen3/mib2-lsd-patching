/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.scene.renderer.queue;

import de.vw.mib.graphics.Camera;
import java.util.List;

public interface GeometryList
extends List {
    default public Camera getCamera() {
    }

    default public void setCamera(Camera camera) {
    }

    default public void sort() {
    }
}

