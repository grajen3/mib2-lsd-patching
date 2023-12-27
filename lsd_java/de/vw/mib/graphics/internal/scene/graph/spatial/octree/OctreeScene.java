/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.scene.graph.spatial.octree;

import de.vw.mib.NotYetImplementedException;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.internal.scene.AbstractScene;
import de.vw.mib.graphics.internal.scene.graph.spatial.octree.OctreeSceneNode;
import de.vw.mib.graphics.internal.spatial.octree.Octree;
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

public final class OctreeScene
extends AbstractScene {
    private static final long serialVersionUID;
    private Octree octree = new Octree();

    public OctreeScene(Graphics3D graphics3D, Logger logger, SceneManager sceneManager) {
        super(graphics3D, logger, sceneManager);
    }

    @Override
    public SceneNode createSceneNode() {
        return new OctreeSceneNode();
    }

    @Override
    public SceneQuery createSceneQuery(int n) {
        throw new NotYetImplementedException();
    }

    @Override
    public RayIntersectionQuery createRayIntersectionQuery(Ray3f ray3f, int n) {
        throw new NotYetImplementedException();
    }

    @Override
    public PlaneIntersectionQuery createPlaneIntersectionQuery(Plane3f plane3f, int n) {
        throw new NotYetImplementedException();
    }

    @Override
    public PlaneBoundedVolumeIntersectionQuery createPlaneBoundedVolumeIntersectionQuery(Plane3f[] plane3fArray, int n) {
        throw new NotYetImplementedException();
    }

    @Override
    public FrustumIntersectionQuery createFrustumIntersectionQuery(Frustumf frustumf, int n) {
        throw new NotYetImplementedException();
    }

    @Override
    public AxisAlignedBoxIntersectionQuery createAxisAlignedBoxIntersectionQuery(AxisAlignedBox axisAlignedBox, int n) {
        throw new NotYetImplementedException();
    }

    @Override
    public SphereIntersectionQuery createSphereIntersectionQuery(Sphere3f sphere3f, int n) {
        throw new NotYetImplementedException();
    }
}

