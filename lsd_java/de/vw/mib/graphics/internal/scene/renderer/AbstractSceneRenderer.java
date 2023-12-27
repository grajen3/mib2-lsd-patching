/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.scene.renderer;

import de.vw.mib.graphics.Camera;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Viewport;
import de.vw.mib.graphics.effect.Effect;
import de.vw.mib.graphics.internal.AbstractResource;
import de.vw.mib.graphics.internal.scene.renderer.GeometryRenderer;
import de.vw.mib.graphics.internal.scene.renderer.culler.ViewFrustumCuller;
import de.vw.mib.graphics.internal.scene.renderer.queue.RenderQueue;
import de.vw.mib.graphics.light.Light;
import de.vw.mib.graphics.material.Material;
import de.vw.mib.graphics.math.Transform;
import de.vw.mib.graphics.math.Tuple3f;
import de.vw.mib.graphics.math.algebra.Matrix4f;
import de.vw.mib.graphics.math.algebra.Vector3f;
import de.vw.mib.graphics.math.algebra.Vector4f;
import de.vw.mib.graphics.math.geometry.BoundingVolume;
import de.vw.mib.graphics.math.geometry.polytope.polyhedron.Box;
import de.vw.mib.graphics.math.geometry.quadric.Sphere3f;
import de.vw.mib.graphics.mesh.Mesh;
import de.vw.mib.graphics.mesh.Primitives;
import de.vw.mib.graphics.scene.Scene;
import de.vw.mib.graphics.scene.graph.SceneEntity;
import de.vw.mib.graphics.scene.graph.SceneNode;
import de.vw.mib.graphics.scene.graph.visual.ModelEntity;
import de.vw.mib.graphics.scene.graph.visual.camera.CameraEntity;
import de.vw.mib.graphics.scene.graph.visual.light.DirectionalLight;
import de.vw.mib.graphics.scene.graph.visual.light.LightEntity;
import de.vw.mib.graphics.scene.graph.visual.light.PointLight;
import de.vw.mib.graphics.scene.graph.visual.light.SpotLight;
import de.vw.mib.graphics.scene.query.SceneQuery;
import de.vw.mib.graphics.scene.renderer.SceneRenderer;
import de.vw.mib.log4mib.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public abstract class AbstractSceneRenderer
extends AbstractResource
implements SceneRenderer,
GeometryRenderer {
    private static final boolean RENDER_QUEUE = System.getProperty("de.vw.mib.graphics.renderer.disabledepthmaterialsorting") == null;
    private static final boolean BACKFACE_CULLING = System.getProperty("de.vw.mib.graphics.renderer.disablebackfaceculling") == null;
    private static final boolean VIEWFRUSTUM_CULLING = System.getProperty("de.vw.mib.graphics.renderer.disableviewfrustumculling") == null;
    private static final boolean CORRECT_VERTEX_WINDING_ON_NEGATIVE_SCALE;
    private final RenderQueue renderQueue;
    private final ViewFrustumCuller viewFrustumCuller;
    private CameraEntity camera;
    private Viewport viewport;
    private Effect overrideEffect;
    private Material overrideMaterial;
    private boolean renderBoundingVolumes = false;
    private boolean backFaceCulling;
    private boolean viewFrustumCulling;
    private Transform viewTransform = new Transform();
    private List transformedLights = new ArrayList();
    private Camera tempCamera = new Camera();

    public AbstractSceneRenderer(Graphics3D graphics3D, Logger logger) {
        super(graphics3D, logger);
        this.renderQueue = RENDER_QUEUE ? new RenderQueue(this) : null;
        this.viewFrustumCuller = new ViewFrustumCuller();
        this.viewport = new Viewport();
        this.backFaceCulling = BACKFACE_CULLING;
        this.viewFrustumCulling = VIEWFRUSTUM_CULLING;
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    public final CameraEntity getCamera() {
        return this.camera;
    }

    @Override
    public final void setCamera(CameraEntity cameraEntity) {
        CameraEntity cameraEntity2 = this.camera;
        if (cameraEntity2 == null || !cameraEntity2.equals(cameraEntity)) {
            this.camera = cameraEntity;
            this.cameraChanged(cameraEntity2, cameraEntity);
        }
    }

    protected void cameraChanged(CameraEntity cameraEntity, CameraEntity cameraEntity2) {
        this.updateCameraViewport();
    }

    @Override
    public final Viewport getViewport() {
        return this.viewport;
    }

    @Override
    public final void setViewport(Viewport viewport) {
        Viewport viewport2 = this.viewport;
        if (!viewport2.equals(viewport)) {
            this.viewport.set(viewport);
            this.viewportChanged(viewport2, viewport);
        }
    }

    protected void viewportChanged(Viewport viewport, Viewport viewport2) {
        this.updateCameraViewport();
    }

    private void updateCameraViewport() {
        if (this.camera != null) {
            this.camera.setViewport(this.viewport);
        }
    }

    @Override
    public final Effect getOverrideEfect() {
        return this.overrideEffect;
    }

    @Override
    public final void setOverrideEffect(Effect effect) {
        this.overrideEffect = effect;
    }

    @Override
    public final Material getOverrideMaterial() {
        return this.overrideMaterial;
    }

    @Override
    public final void setOverrideMaterial(Material material) {
        this.overrideMaterial = material;
    }

    @Override
    public final boolean isRenderBoundingVolumes() {
        return this.renderBoundingVolumes;
    }

    @Override
    public final void setRenderBoundingVolumes(boolean bl) {
        this.renderBoundingVolumes = bl;
    }

    @Override
    public final boolean isBackFaceCulling() {
        return this.backFaceCulling;
    }

    @Override
    public final void setBackFaceCulling(boolean bl) {
        this.backFaceCulling = bl;
    }

    @Override
    public final boolean isViewFrustumCulling() {
        return this.viewFrustumCulling;
    }

    @Override
    public final void setViewFrustumCulling(boolean bl) {
        this.viewFrustumCulling = bl;
    }

    @Override
    public void render(Scene scene) {
        Set set;
        Transform transform = this.camera.getParent().getGlobalTransform();
        transform.invert(this.viewTransform);
        Matrix4f matrix4f = this.camera.getProjection();
        List list = scene.getLights();
        int n = list.size();
        this.transformedLights.clear();
        for (int i2 = 0; i2 < n; ++i2) {
            Light light = this.convertLight((LightEntity)list.get(i2), this.viewTransform);
            this.transformedLights.add(i2, light);
        }
        SceneNode sceneNode = scene.getRootNode();
        boolean bl = false;
        this.tempCamera.setProjection(matrix4f);
        this.tempCamera.setView(transform);
        if (this.viewFrustumCulling) {
            this.viewFrustumCuller.setCamera(this.tempCamera);
            this.viewFrustumCuller.determinePossibleVisibleSet(scene);
            set = this.viewFrustumCuller.getPossibleVisibleSet();
        } else {
            SceneQuery sceneQuery = scene.createSceneQuery(0);
            set = sceneQuery.execute();
        }
        int n2 = 0;
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            SceneEntity sceneEntity = (SceneEntity)iterator.next();
            if (!(sceneEntity instanceof ModelEntity)) continue;
            ModelEntity modelEntity = (ModelEntity)sceneEntity;
            this.render(modelEntity, this.viewTransform, matrix4f, this.transformedLights);
            if (this.renderBoundingVolumes) {
                this.drawBoundingVolume(modelEntity.getParent().getGlobalTransform(), this.viewTransform, matrix4f, modelEntity.getBoundingVolume());
            }
            ++n2;
        }
        boolean bl2 = false;
        if (this.renderQueue != null) {
            this.renderQueue.flushQueue(this.tempCamera);
        }
    }

    private Light convertLight(LightEntity lightEntity, Transform transform) {
        SceneNode sceneNode = lightEntity.getParent();
        Transform transform2 = sceneNode.getGlobalTransform();
        Transform transform3 = new Transform();
        transform.transform(transform2, transform3);
        Light light = new Light();
        switch (lightEntity.getType()) {
            case 0: {
                DirectionalLight directionalLight = (DirectionalLight)lightEntity;
                Vector3f vector3f = new Vector3f(transform3.getTranslation());
                vector3f.normalize();
                light.setPosition(new Vector4f(vector3f, 0.0f));
                light.setAmbientColor(directionalLight.getAmbientColor());
                light.setDiffuseColor(directionalLight.getDiffuseColor());
                light.setSpecularColor(directionalLight.getSpecularColor());
                break;
            }
            case 1: {
                PointLight pointLight = (PointLight)lightEntity;
                light.setPosition(new Vector4f(transform3.getTranslation(), 1.0f));
                light.setAmbientColor(pointLight.getAmbientColor());
                light.setDiffuseColor(pointLight.getDiffuseColor());
                light.setSpecularColor(pointLight.getSpecularColor());
                light.setConstantAttenuation(pointLight.getConstantAttenuation());
                light.setLinearAttenuation(pointLight.getLinearAttenuation());
                light.setQuadraticAttenuation(pointLight.getQuadraticAttenuation());
                break;
            }
            case 2: {
                SpotLight spotLight = (SpotLight)lightEntity;
                light.setPosition(new Vector4f(transform3.getTranslation(), 1.0f));
                light.setSpotDirection(spotLight.getDirection());
                light.setSpotExponent(spotLight.getSpotExponent());
                light.setSpotCutoffAngle(spotLight.getSpotCutoffAngle());
                light.setAmbientColor(spotLight.getAmbientColor());
                light.setDiffuseColor(spotLight.getDiffuseColor());
                light.setSpecularColor(spotLight.getSpecularColor());
                light.setConstantAttenuation(spotLight.getConstantAttenuation());
                light.setLinearAttenuation(spotLight.getLinearAttenuation());
                light.setQuadraticAttenuation(spotLight.getQuadraticAttenuation());
                break;
            }
            default: {
                throw new IllegalArgumentException("Invalid light type");
            }
        }
        return light;
    }

    public final void renderRecursive(SceneNode sceneNode, Transform transform, Matrix4f matrix4f, List list) {
        int n;
        int n2;
        int n3 = sceneNode.getEntityCount();
        for (n2 = 0; n2 < n3; ++n2) {
            SceneEntity sceneEntity = sceneNode.getEntity(n2);
            if (sceneEntity == null || !(sceneEntity instanceof ModelEntity)) continue;
            this.render((ModelEntity)sceneEntity, transform, matrix4f, list);
        }
        n2 = sceneNode.getChildCount();
        for (n = 0; n < n2; ++n) {
            SceneNode sceneNode2 = sceneNode.getChild(n);
            this.renderRecursive(sceneNode2, transform, matrix4f, list);
        }
        n = 0;
        if (this.renderBoundingVolumes) {
            this.drawBoundingVolume(sceneNode.getGlobalTransform(), transform, matrix4f, sceneNode.getBoundingVolume());
        }
    }

    public final void render(ModelEntity modelEntity, Transform transform, Matrix4f matrix4f, List list) {
        Transform transform2 = modelEntity.getParent().getGlobalTransform();
        Transform transform3 = new Transform();
        transform.transform(transform2, transform3);
        boolean bl = true;
        Object object = transform3.getScale();
        bl ^= ((Tuple3f)object).x * ((Tuple3f)object).y * ((Tuple3f)object).z < 0.0f;
        object = modelEntity.getModel();
        Mesh mesh = object.getMesh();
        Effect effect = this.overrideEffect != null ? this.overrideEffect : object.getEffect();
        List list2 = object.getMaterials();
        int n = mesh.getPrimitivesCount();
        for (int i2 = 0; i2 < n; ++i2) {
            Material material;
            Primitives primitives = mesh.getPrimitives(i2);
            Material material2 = material = this.overrideMaterial != null ? this.overrideMaterial : (Material)list2.get(i2);
            if (this.renderQueue != null) {
                this.renderQueue.queueGeometry(mesh, primitives, effect, material, transform3, matrix4f, list, bl);
                continue;
            }
            this.render(mesh, primitives, effect, material, transform3, matrix4f, list, bl);
        }
    }

    @Override
    public abstract void render(Mesh mesh, Primitives primitives, Effect effect, Material material, Transform transform, Matrix4f matrix4f, List list, boolean bl) {
    }

    protected final void drawBoundingVolume(Transform transform, Transform transform2, Matrix4f matrix4f, BoundingVolume boundingVolume) {
        if (boundingVolume instanceof Sphere3f) {
            this.drawBoundingSphere(transform, transform2, matrix4f, (Sphere3f)boundingVolume);
        } else if (boundingVolume instanceof Box) {
            this.drawBoundingBox(transform, transform2, matrix4f, (Box)((Object)boundingVolume));
        }
    }

    protected abstract void drawBoundingSphere(Transform transform, Transform transform2, Matrix4f matrix4f, Sphere3f sphere3f) {
    }

    protected abstract void drawBoundingBox(Transform transform, Transform transform2, Matrix4f matrix4f, Box box) {
    }

    protected abstract void drawViewFrustum(Matrix4f matrix4f) {
    }

    protected abstract void drawCoordinateSystem(float f2) {
    }
}

