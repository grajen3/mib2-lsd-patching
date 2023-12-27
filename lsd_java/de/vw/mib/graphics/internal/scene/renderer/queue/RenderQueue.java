/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.scene.renderer.queue;

import de.vw.mib.graphics.Camera;
import de.vw.mib.graphics.effect.Effect;
import de.vw.mib.graphics.internal.scene.renderer.GeometryRenderer;
import de.vw.mib.graphics.internal.scene.renderer.queue.Geometry;
import de.vw.mib.graphics.internal.scene.renderer.queue.GeometryList;
import de.vw.mib.graphics.internal.scene.renderer.queue.RenderQueue$GeometryPool;
import de.vw.mib.graphics.internal.scene.renderer.queue.RenderQueue$PooledGeometry;
import de.vw.mib.graphics.internal.scene.renderer.queue.SortedGeometryList;
import de.vw.mib.graphics.internal.scene.renderer.queue.comparator.NullComparator;
import de.vw.mib.graphics.internal.scene.renderer.queue.comparator.OpaqueComparator;
import de.vw.mib.graphics.internal.scene.renderer.queue.comparator.TransparentComparator;
import de.vw.mib.graphics.internal.scene.renderer.queue.comparator.ZOrderComparator;
import de.vw.mib.graphics.material.Material;
import de.vw.mib.graphics.math.Transform;
import de.vw.mib.graphics.math.algebra.Matrix4f;
import de.vw.mib.graphics.mesh.Mesh;
import de.vw.mib.graphics.mesh.Primitives;
import java.util.List;

public final class RenderQueue {
    public static final int BUCKET_OPAQUE;
    public static final int BUCKET_TRANSPARENT;
    public static final int BUCKET_TRANSLUCENT;
    public static final int BUCKET_BACKGROUND;
    public static final int BUCKET_FOREGROUND;
    public static final int SHADOW_MODE_OFF;
    public static final int SHADOW_MODE_CAST;
    public static final int SHADOW_MODE_RECEIVE;
    public static final int SHADOW_MODE_CAST_AND_RECEIVE;
    private final GeometryRenderer renderer;
    private final GeometryList opaqueQueue;
    private final GeometryList transparentQueue;
    private final GeometryList translucentQueue;
    private final GeometryList backgroundQueue;
    private final GeometryList foregroundQueue;
    private static final int GEOMETRY_POOL_MAXIMUM_CAPACITY;
    private final RenderQueue$GeometryPool geometryPool;

    public RenderQueue(GeometryRenderer geometryRenderer) {
        this.renderer = geometryRenderer;
        this.opaqueQueue = new SortedGeometryList(new OpaqueComparator());
        this.transparentQueue = new SortedGeometryList(new TransparentComparator());
        this.translucentQueue = new SortedGeometryList(new TransparentComparator());
        this.backgroundQueue = new SortedGeometryList(new NullComparator());
        this.foregroundQueue = new SortedGeometryList(new ZOrderComparator());
        this.geometryPool = new RenderQueue$GeometryPool(100);
    }

    public void clear() {
        this.opaqueQueue.clear();
        this.transparentQueue.clear();
        this.translucentQueue.clear();
        this.backgroundQueue.clear();
        this.backgroundQueue.clear();
    }

    public boolean isQueueEmpty(int n) {
        switch (n) {
            case 0: {
                return this.opaqueQueue.isEmpty();
            }
            case 1: {
                return this.transparentQueue.isEmpty();
            }
            case 2: {
                return this.translucentQueue.isEmpty();
            }
            case 3: {
                return this.backgroundQueue.isEmpty();
            }
            case 4: {
                return this.foregroundQueue.isEmpty();
            }
        }
        throw new IllegalArgumentException("Invalid bucket");
    }

    public void queueGeometry(Mesh mesh, Primitives primitives, Effect effect, Material material, Transform transform, Matrix4f matrix4f, List list, boolean bl) {
        Geometry geometry = this.createGeometry();
        geometry.setMesh(mesh);
        geometry.setPrimitives(primitives);
        geometry.setEffect(effect);
        geometry.setMaterial(material);
        geometry.setTransform(transform);
        geometry.setProjection(matrix4f);
        geometry.setLights(list);
        geometry.setFrontFaceWindingCCW(bl);
        geometry.setSortingDistance(32895);
        if (material.hasTransparency()) {
            this.transparentQueue.add(geometry);
        } else {
            this.opaqueQueue.add(geometry);
        }
    }

    private Geometry createGeometry() {
        return (Geometry)((Object)this.geometryPool.borrowObject());
    }

    private void disposeGeometry(Geometry geometry) {
        this.geometryPool.releaseObject((RenderQueue$PooledGeometry)geometry);
    }

    public void flushQueue(Camera camera) {
        this.renderQueues(camera, true);
    }

    private void renderQueues(Camera camera, boolean bl) {
        this.renderQueue(0, camera, bl);
        if (!this.isQueueEmpty(1)) {
            this.renderQueue(1, camera, bl);
        }
    }

    private void queueGeometry(int n, Geometry geometry) {
        switch (n) {
            case 0: {
                this.opaqueQueue.add(geometry);
                break;
            }
            case 1: {
                this.transparentQueue.add(geometry);
                break;
            }
            case 2: {
                this.translucentQueue.add(geometry);
                break;
            }
            case 3: {
                this.backgroundQueue.add(geometry);
                break;
            }
            case 4: {
                this.foregroundQueue.add(geometry);
                break;
            }
            default: {
                throw new IllegalArgumentException("Invalid bucket");
            }
        }
    }

    private void renderQueue(int n, Camera camera, boolean bl) {
        switch (n) {
            case 0: {
                this.renderGeometryList(this.opaqueQueue, camera, bl);
                break;
            }
            case 1: {
                this.renderGeometryList(this.transparentQueue, camera, bl);
                break;
            }
            case 2: {
                this.renderGeometryList(this.translucentQueue, camera, bl);
                break;
            }
            case 3: {
                this.renderGeometryList(this.backgroundQueue, camera, bl);
                break;
            }
            case 4: {
                this.renderGeometryList(this.foregroundQueue, camera, bl);
                break;
            }
            default: {
                throw new IllegalArgumentException("Invalid bucket");
            }
        }
    }

    private void renderGeometryList(GeometryList geometryList, Camera camera, boolean bl) {
        geometryList.setCamera(camera);
        geometryList.sort();
        int n = geometryList.size();
        for (int i2 = 0; i2 < n; ++i2) {
            Geometry geometry = (Geometry)geometryList.get(i2);
            Mesh mesh = geometry.getMesh();
            Primitives primitives = geometry.getPrimitives();
            Effect effect = geometry.getEffect();
            Material material = geometry.getMaterial();
            Transform transform = geometry.getTransform();
            Matrix4f matrix4f = geometry.getProjection();
            List list = geometry.getLights();
            boolean bl2 = geometry.getFrontFaceWindingCCW();
            this.renderer.render(mesh, primitives, effect, material, transform, matrix4f, list, bl2);
            this.disposeGeometry(geometry);
        }
        if (bl) {
            geometryList.clear();
        }
    }
}

