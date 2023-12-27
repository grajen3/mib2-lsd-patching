/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.scene;

import de.vw.mib.cache.Cacheable;
import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.Resource;
import de.vw.mib.graphics.math.geometry.Plane3f;
import de.vw.mib.graphics.math.geometry.Ray3f;
import de.vw.mib.graphics.math.geometry.polytope.polyhedron.AxisAlignedBox;
import de.vw.mib.graphics.math.geometry.polytope.polyhedron.Frustumf;
import de.vw.mib.graphics.math.geometry.quadric.Sphere3f;
import de.vw.mib.graphics.scene.SceneListener;
import de.vw.mib.graphics.scene.animation.AnimationClip;
import de.vw.mib.graphics.scene.graph.SceneNode;
import de.vw.mib.graphics.scene.graph.visual.ModelEntity;
import de.vw.mib.graphics.scene.graph.visual.camera.CameraEntity;
import de.vw.mib.graphics.scene.graph.visual.camera.FrustumCamera;
import de.vw.mib.graphics.scene.graph.visual.camera.OrthographicCamera;
import de.vw.mib.graphics.scene.graph.visual.camera.PerspectiveCamera;
import de.vw.mib.graphics.scene.graph.visual.light.DirectionalLight;
import de.vw.mib.graphics.scene.graph.visual.light.PointLight;
import de.vw.mib.graphics.scene.graph.visual.light.SpotLight;
import de.vw.mib.graphics.scene.query.AxisAlignedBoxIntersectionQuery;
import de.vw.mib.graphics.scene.query.FrustumIntersectionQuery;
import de.vw.mib.graphics.scene.query.PlaneBoundedVolumeIntersectionQuery;
import de.vw.mib.graphics.scene.query.PlaneIntersectionQuery;
import de.vw.mib.graphics.scene.query.RayIntersectionQuery;
import de.vw.mib.graphics.scene.query.SceneQuery;
import de.vw.mib.graphics.scene.query.SphereIntersectionQuery;
import java.io.Serializable;
import java.util.List;

public interface Scene
extends Cloneable,
Serializable,
Resource,
Cacheable {
    default public Object clone() {
    }

    default public String getName() {
    }

    default public void setName(String string) {
    }

    default public void addListener(SceneListener sceneListener) {
    }

    default public void removeListener(SceneListener sceneListener) {
    }

    default public SceneNode getRootNode() {
    }

    default public void setRootNode(SceneNode sceneNode) {
    }

    default public SceneNode createSceneNode() {
    }

    default public SceneNode findNode(String string) {
    }

    default public SceneNode findNode(Class clazz) {
    }

    default public SceneQuery createSceneQuery(int n) {
    }

    default public RayIntersectionQuery createRayIntersectionQuery(Ray3f ray3f, int n) {
    }

    default public PlaneIntersectionQuery createPlaneIntersectionQuery(Plane3f plane3f, int n) {
    }

    default public PlaneBoundedVolumeIntersectionQuery createPlaneBoundedVolumeIntersectionQuery(Plane3f[] plane3fArray, int n) {
    }

    default public FrustumIntersectionQuery createFrustumIntersectionQuery(Frustumf frustumf, int n) {
    }

    default public AxisAlignedBoxIntersectionQuery createAxisAlignedBoxIntersectionQuery(AxisAlignedBox axisAlignedBox, int n) {
    }

    default public SphereIntersectionQuery createSphereIntersectionQuery(Sphere3f sphere3f, int n) {
    }

    default public ModelEntity createModelEntity() {
    }

    default public DirectionalLight createDirectionalLight() {
    }

    default public PointLight createPointLight() {
    }

    default public SpotLight createSpotLight() {
    }

    default public Color4f getAmbientLight() {
    }

    default public void setAmbientLight(Color4f color4f) {
    }

    default public List getLights() {
    }

    default public FrustumCamera createFrustumCamera() {
    }

    default public OrthographicCamera createOrthographicCamera() {
    }

    default public PerspectiveCamera createPerspectiveCamera() {
    }

    default public List getCameras() {
    }

    default public CameraEntity getDefaultCamera() {
    }

    default public void setDefaultCamera(CameraEntity cameraEntity) {
    }

    default public AnimationClip createAnimationClip() {
    }

    default public void addAnimationClip(AnimationClip animationClip) {
    }

    default public void removeAnimationClip(AnimationClip animationClip) {
    }

    default public List getAnimationClips() {
    }
}

