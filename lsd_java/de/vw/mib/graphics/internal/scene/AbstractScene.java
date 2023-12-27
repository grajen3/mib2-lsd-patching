/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.scene;

import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.collections.copyonwrite.CowList;
import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.internal.AbstractResource;
import de.vw.mib.graphics.internal.scene.AbstractScene$CameraAttachmentListener;
import de.vw.mib.graphics.internal.scene.AbstractScene$LightAttachmentListener;
import de.vw.mib.graphics.internal.scene.animation.UnpooledAnimationClip;
import de.vw.mib.graphics.internal.scene.graph.visual.camera.UnpooledCameraEntity;
import de.vw.mib.graphics.internal.scene.graph.visual.light.UnpooledLightEntity;
import de.vw.mib.graphics.internal.scene.graph.visual.model.UnpooledModelEntity;
import de.vw.mib.graphics.math.geometry.Plane3f;
import de.vw.mib.graphics.math.geometry.Ray3f;
import de.vw.mib.graphics.math.geometry.polytope.polyhedron.AxisAlignedBox;
import de.vw.mib.graphics.math.geometry.polytope.polyhedron.Frustumf;
import de.vw.mib.graphics.math.geometry.quadric.Sphere3f;
import de.vw.mib.graphics.scene.Scene;
import de.vw.mib.graphics.scene.SceneListener;
import de.vw.mib.graphics.scene.SceneManager;
import de.vw.mib.graphics.scene.animation.AnimationClip;
import de.vw.mib.graphics.scene.graph.SceneEntity;
import de.vw.mib.graphics.scene.graph.SceneEntityListener;
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
import de.vw.mib.log4mib.Logger;
import de.vw.mib.util.StringBuilder;
import edu.emory.mathcs.backport.java.util.concurrent.CopyOnWriteArrayList;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractScene
extends AbstractResource
implements Scene {
    private static final long serialVersionUID;
    private static HashCodeBuilder hcb;
    private final SceneManager sceneManager;
    private String name;
    private transient CowList listeners;
    private SceneNode rootNode;
    private Color4f ambientLight;
    protected CopyOnWriteArrayList lights;
    private SceneEntityListener lightAttachmentListener;
    protected CopyOnWriteArrayList cameras;
    private SceneEntityListener cameraAttachmentListener;
    private CameraEntity defaultCamera;
    private List animationClips;

    public AbstractScene(Graphics3D graphics3D, Logger logger, SceneManager sceneManager) {
        super(graphics3D, logger);
        this.sceneManager = sceneManager;
        this.listeners = CowList.EMPTY;
        this.ambientLight = new Color4f(Color4f.BLACK);
        this.lights = new CopyOnWriteArrayList();
        this.lightAttachmentListener = new AbstractScene$LightAttachmentListener(this.lights);
        this.cameras = new CopyOnWriteArrayList();
        this.cameraAttachmentListener = new AbstractScene$CameraAttachmentListener(this.cameras);
        this.animationClips = new ArrayList();
    }

    @Override
    public Object clone() {
        try {
            AbstractScene abstractScene = (AbstractScene)super.clone();
            abstractScene.rootNode = (SceneNode)this.rootNode.clone();
            return abstractScene;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new RuntimeException(cloneNotSupportedException);
        }
    }

    public int hashCode() {
        if (hcb == null) {
            hcb = new HashCodeBuilder();
        }
        hcb.reset();
        hcb.append(this.name);
        hcb.append(this.rootNode);
        return hcb.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[root=").append(this.rootNode);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public void dispose() {
        this.rootNode.dispose();
    }

    @Override
    public int getByteSize() {
        return 0;
    }

    protected final SceneManager getSceneManager() {
        return this.sceneManager;
    }

    @Override
    public final String getName() {
        return this.name;
    }

    @Override
    public final void setName(String string) {
        this.name = string;
    }

    @Override
    public final void addListener(SceneListener sceneListener) {
        this.listeners = this.listeners.addIfAbsent(sceneListener);
    }

    @Override
    public final void removeListener(SceneListener sceneListener) {
        this.listeners = this.listeners.remove(sceneListener);
    }

    @Override
    public final SceneNode getRootNode() {
        return this.rootNode;
    }

    @Override
    public final void setRootNode(SceneNode sceneNode) {
        this.rootNode = sceneNode;
    }

    @Override
    public abstract SceneNode createSceneNode() {
    }

    @Override
    public final SceneNode findNode(String string) {
        return AbstractScene.findFirstNode(this.rootNode, string);
    }

    private static SceneNode findFirstNode(SceneNode sceneNode, String string) {
        if (string.equals(sceneNode.getName())) {
            return sceneNode;
        }
        int n = sceneNode.getChildCount();
        for (int i2 = 0; i2 < n; ++i2) {
            SceneNode sceneNode2 = AbstractScene.findFirstNode(sceneNode.getChild(i2), string);
            if (sceneNode2 == null) continue;
            return sceneNode2;
        }
        return null;
    }

    @Override
    public final SceneNode findNode(Class clazz) {
        return this.findFirstEntity(this.rootNode, clazz);
    }

    private SceneNode findFirstEntity(SceneNode sceneNode, Class clazz) {
        int n;
        int n2 = sceneNode.getEntityCount();
        for (n = 0; n < n2; ++n) {
            SceneEntity sceneEntity = sceneNode.getEntity(n);
            if (!clazz.isInstance(sceneEntity)) continue;
            return sceneNode;
        }
        n = sceneNode.getChildCount();
        for (int i2 = 0; i2 < n; ++i2) {
            SceneNode sceneNode2 = this.findFirstEntity(sceneNode.getChild(i2), clazz);
            if (sceneNode2 == null) continue;
            return sceneNode2;
        }
        return null;
    }

    @Override
    public abstract SceneQuery createSceneQuery(int n) {
    }

    @Override
    public abstract RayIntersectionQuery createRayIntersectionQuery(Ray3f ray3f, int n) {
    }

    @Override
    public abstract PlaneIntersectionQuery createPlaneIntersectionQuery(Plane3f plane3f, int n) {
    }

    @Override
    public abstract PlaneBoundedVolumeIntersectionQuery createPlaneBoundedVolumeIntersectionQuery(Plane3f[] plane3fArray, int n) {
    }

    @Override
    public abstract FrustumIntersectionQuery createFrustumIntersectionQuery(Frustumf frustumf, int n) {
    }

    @Override
    public abstract AxisAlignedBoxIntersectionQuery createAxisAlignedBoxIntersectionQuery(AxisAlignedBox axisAlignedBox, int n) {
    }

    @Override
    public abstract SphereIntersectionQuery createSphereIntersectionQuery(Sphere3f sphere3f, int n) {
    }

    @Override
    public final ModelEntity createModelEntity() {
        return new UnpooledModelEntity();
    }

    @Override
    public final DirectionalLight createDirectionalLight() {
        UnpooledLightEntity unpooledLightEntity = new UnpooledLightEntity(0);
        unpooledLightEntity.addListener(this.lightAttachmentListener);
        return unpooledLightEntity;
    }

    @Override
    public final PointLight createPointLight() {
        UnpooledLightEntity unpooledLightEntity = new UnpooledLightEntity(1);
        unpooledLightEntity.addListener(this.lightAttachmentListener);
        return unpooledLightEntity;
    }

    @Override
    public final SpotLight createSpotLight() {
        UnpooledLightEntity unpooledLightEntity = new UnpooledLightEntity(2);
        unpooledLightEntity.addListener(this.lightAttachmentListener);
        return unpooledLightEntity;
    }

    @Override
    public final Color4f getAmbientLight() {
        return this.ambientLight;
    }

    @Override
    public final void setAmbientLight(Color4f color4f) {
        this.ambientLight.set(color4f);
    }

    @Override
    public final List getLights() {
        return this.lights;
    }

    @Override
    public final FrustumCamera createFrustumCamera() {
        UnpooledCameraEntity unpooledCameraEntity = new UnpooledCameraEntity(0);
        unpooledCameraEntity.addListener(this.cameraAttachmentListener);
        return unpooledCameraEntity;
    }

    @Override
    public final OrthographicCamera createOrthographicCamera() {
        UnpooledCameraEntity unpooledCameraEntity = new UnpooledCameraEntity(1);
        unpooledCameraEntity.addListener(this.cameraAttachmentListener);
        return unpooledCameraEntity;
    }

    @Override
    public final PerspectiveCamera createPerspectiveCamera() {
        UnpooledCameraEntity unpooledCameraEntity = new UnpooledCameraEntity(2);
        unpooledCameraEntity.addListener(this.cameraAttachmentListener);
        return unpooledCameraEntity;
    }

    @Override
    public final List getCameras() {
        return this.cameras;
    }

    @Override
    public final CameraEntity getDefaultCamera() {
        return this.defaultCamera;
    }

    @Override
    public final void setDefaultCamera(CameraEntity cameraEntity) {
        this.defaultCamera = cameraEntity;
    }

    @Override
    public final AnimationClip createAnimationClip() {
        return new UnpooledAnimationClip();
    }

    @Override
    public final void addAnimationClip(AnimationClip animationClip) {
        this.animationClips.add(animationClip);
    }

    @Override
    public final void removeAnimationClip(AnimationClip animationClip) {
        this.animationClips.remove(animationClip);
    }

    @Override
    public final List getAnimationClips() {
        return this.animationClips;
    }
}

