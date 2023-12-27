/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.scene.graph.spatial.bvh;

import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.internal.scene.AbstractScene;
import de.vw.mib.graphics.internal.scene.graph.spatial.bvh.BVHSceneNode;
import de.vw.mib.graphics.internal.scene.graph.spatial.bvh.query.BVHAxisAlignedBoxIntersectionQuery;
import de.vw.mib.graphics.internal.scene.graph.spatial.bvh.query.BVHFrustumIntersectionQuery;
import de.vw.mib.graphics.internal.scene.graph.spatial.bvh.query.BVHPlaneBoundedVolumeIntersectionQuery;
import de.vw.mib.graphics.internal.scene.graph.spatial.bvh.query.BVHPlaneIntersectionQuery;
import de.vw.mib.graphics.internal.scene.graph.spatial.bvh.query.BVHRayIntersectionQuery;
import de.vw.mib.graphics.internal.scene.graph.spatial.bvh.query.BVHSceneQuery;
import de.vw.mib.graphics.internal.scene.graph.spatial.bvh.query.BVHSphereIntersectionQuery;
import de.vw.mib.graphics.math.geometry.Plane3f;
import de.vw.mib.graphics.math.geometry.Ray3f;
import de.vw.mib.graphics.math.geometry.polytope.polyhedron.AxisAlignedBox;
import de.vw.mib.graphics.math.geometry.polytope.polyhedron.Frustumf;
import de.vw.mib.graphics.math.geometry.quadric.Sphere3f;
import de.vw.mib.graphics.scene.SceneManager;
import de.vw.mib.graphics.scene.graph.SceneNode;
import de.vw.mib.graphics.scene.query.AxisAlignedBoxIntersectionQuery;
import de.vw.mib.graphics.scene.query.FrustumIntersectionQuery;
import de.vw.mib.graphics.scene.query.PlaneBoundedVolumeIntersectionQuery;
import de.vw.mib.graphics.scene.query.PlaneIntersectionQuery;
import de.vw.mib.graphics.scene.query.RayIntersectionQuery;
import de.vw.mib.graphics.scene.query.SceneQuery;
import de.vw.mib.graphics.scene.query.SphereIntersectionQuery;
import de.vw.mib.log4mib.Logger;

public class BVHScene
extends AbstractScene {
    private static final long serialVersionUID;

    public BVHScene(Graphics3D graphics3D, Logger logger, SceneManager sceneManager) {
        super(graphics3D, logger, sceneManager);
    }

    @Override
    public SceneNode createSceneNode() {
        return new BVHSceneNode();
    }

    @Override
    public SceneQuery createSceneQuery(int n) {
        return new BVHSceneQuery(this, n);
    }

    @Override
    public RayIntersectionQuery createRayIntersectionQuery(Ray3f ray3f, int n) {
        return new BVHRayIntersectionQuery(this, n, ray3f);
    }

    @Override
    public PlaneIntersectionQuery createPlaneIntersectionQuery(Plane3f plane3f, int n) {
        return new BVHPlaneIntersectionQuery(this, n, plane3f);
    }

    @Override
    public PlaneBoundedVolumeIntersectionQuery createPlaneBoundedVolumeIntersectionQuery(Plane3f[] plane3fArray, int n) {
        return new BVHPlaneBoundedVolumeIntersectionQuery(this, n, plane3fArray);
    }

    @Override
    public FrustumIntersectionQuery createFrustumIntersectionQuery(Frustumf frustumf, int n) {
        return new BVHFrustumIntersectionQuery(this, n, frustumf);
    }

    @Override
    public AxisAlignedBoxIntersectionQuery createAxisAlignedBoxIntersectionQuery(AxisAlignedBox axisAlignedBox, int n) {
        return new BVHAxisAlignedBoxIntersectionQuery(this, n, axisAlignedBox);
    }

    @Override
    public SphereIntersectionQuery createSphereIntersectionQuery(Sphere3f sphere3f, int n) {
        return new BVHSphereIntersectionQuery(this, n, sphere3f);
    }
}

