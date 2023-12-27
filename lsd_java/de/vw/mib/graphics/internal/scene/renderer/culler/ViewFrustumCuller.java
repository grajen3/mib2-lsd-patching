/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.scene.renderer.culler;

import de.vw.mib.graphics.Camera;
import de.vw.mib.graphics.internal.scene.renderer.culler.Culler;
import de.vw.mib.graphics.math.Transform;
import de.vw.mib.graphics.math.algebra.Matrix4f;
import de.vw.mib.graphics.math.geometry.polytope.polyhedron.Frustumf;
import de.vw.mib.graphics.scene.Scene;
import java.util.Set;

public final class ViewFrustumCuller
implements Culler {
    private Camera camera;
    private Set visibleSet;

    public ViewFrustumCuller() {
    }

    public ViewFrustumCuller(Camera camera) {
        this();
        this.camera = camera;
    }

    public Camera getCamera() {
        return this.camera;
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    public void determinePossibleVisibleSet(Scene scene) {
        Transform transform = this.camera.getView();
        Matrix4f matrix4f = this.camera.getProjection();
        Frustumf frustumf = null;
        Object object = new Matrix4f();
        Transform transform2 = new Transform();
        transform.invert(transform2);
        matrix4f.mul(transform2.getAsMatrix(), (Matrix4f)object);
        frustumf = Camera.getViewFrustumFromClippingSpaceMatrix((Matrix4f)object);
        object = scene.createFrustumIntersectionQuery(frustumf, 0);
        this.visibleSet = object.execute();
    }

    public Set getPossibleVisibleSet() {
        return this.visibleSet;
    }
}

