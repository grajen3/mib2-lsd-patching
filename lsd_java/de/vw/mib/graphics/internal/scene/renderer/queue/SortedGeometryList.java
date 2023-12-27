/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.scene.renderer.queue;

import de.vw.mib.collections.ObjectArrayList;
import de.vw.mib.graphics.Camera;
import de.vw.mib.graphics.internal.scene.renderer.queue.GeometryList;
import de.vw.mib.graphics.internal.scene.renderer.queue.comparator.GeometryComparator;

public class SortedGeometryList
extends ObjectArrayList
implements GeometryList {
    private static final int BACKING_LIST_INITIAL_CAPACITY;
    protected final GeometryComparator comparator;

    public SortedGeometryList(GeometryComparator geometryComparator) {
        super(100);
        this.comparator = geometryComparator;
    }

    @Override
    public final Camera getCamera() {
        return this.comparator.getCamera();
    }

    @Override
    public final void setCamera(Camera camera) {
        this.comparator.setCamera(camera);
    }

    @Override
    public void sort() {
        this.sort(this.comparator);
    }
}

