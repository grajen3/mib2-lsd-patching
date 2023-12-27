/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.scene;

import de.vw.mib.NotYetImplementedException;
import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.effect.Effect;
import de.vw.mib.graphics.material.Material;
import de.vw.mib.graphics.math.algebra.Vector3f;
import de.vw.mib.graphics.mesh.Mesh;
import de.vw.mib.graphics.model.Model;
import de.vw.mib.graphics.scene.Scene;
import de.vw.mib.graphics.scene.SceneManager;
import de.vw.mib.graphics.scene.graph.SceneNode;
import de.vw.mib.graphics.scene.graph.visual.ModelEntity;
import de.vw.mib.graphics.scene.graph.visual.camera.FrustumCamera;
import de.vw.mib.graphics.scene.graph.visual.camera.OrthographicCamera;
import de.vw.mib.graphics.scene.graph.visual.camera.PerspectiveCamera;
import de.vw.mib.graphics.scene.graph.visual.light.DirectionalLight;
import de.vw.mib.graphics.scene.graph.visual.light.PointLight;
import de.vw.mib.graphics.scene.graph.visual.light.ReflectiveLight;
import de.vw.mib.graphics.scene.graph.visual.light.SpotLight;
import de.vw.mib.log4mib.Logger;
import java.util.ArrayList;

public final class SceneFactory {
    private static SceneFactory instance;

    SceneFactory() {
    }

    public Scene createSceneFromFile(String string, Logger logger, Graphics3D graphics3D) {
        throw new NotYetImplementedException();
    }

    public Scene createScene(Graphics3D graphics3D, boolean bl, boolean bl2) {
        SceneNode sceneNode;
        SceneManager sceneManager = graphics3D.getSceneManager();
        Scene scene = sceneManager.createBVHScene();
        SceneNode sceneNode2 = scene.createSceneNode();
        scene.setRootNode(sceneNode2);
        if (bl) {
            sceneNode = scene.createSceneNode();
            boolean bl3 = false;
            ReflectiveLight reflectiveLight = null;
            switch (0) {
                case 0: {
                    DirectionalLight directionalLight = scene.createDirectionalLight();
                    reflectiveLight = directionalLight;
                    break;
                }
                case 1: {
                    PointLight pointLight = scene.createPointLight();
                    pointLight.setConstantAttenuation(1.0f);
                    pointLight.setLinearAttenuation(0.0f);
                    pointLight.setQuadraticAttenuation(0.0f);
                    reflectiveLight = pointLight;
                    break;
                }
                case 2: {
                    SpotLight spotLight = scene.createSpotLight();
                    spotLight.setDirection(new Vector3f(0.0f, 0.0f, 32959));
                    spotLight.setSpotCutoffAngle(13379);
                    spotLight.setSpotExponent(8257);
                    spotLight.setConstantAttenuation(1.0f);
                    spotLight.setLinearAttenuation(0.0f);
                    spotLight.setQuadraticAttenuation(0.0f);
                    reflectiveLight = spotLight;
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Invalid light type");
                }
            }
            reflectiveLight.setName("Light");
            reflectiveLight.setAmbientColor(Color4f.WHITE);
            reflectiveLight.setDiffuseColor(Color4f.WHITE);
            reflectiveLight.setSpecularColor(Color4f.WHITE);
            sceneNode.addEntity(reflectiveLight);
            sceneNode.setPosition(0.0f, 0.0f, 4201542);
            sceneNode2.addChild(sceneNode);
        }
        sceneNode = scene.createSceneNode();
        FrustumCamera frustumCamera = null;
        float f2 = 1.0f;
        int n = 4201542;
        if (bl2) {
            int n2 = 28738;
            int n3 = 1899866687;
            PerspectiveCamera perspectiveCamera = scene.createPerspectiveCamera();
            perspectiveCamera.setFieldOfView(28738);
            perspectiveCamera.setAspectRatio(1899866687);
            perspectiveCamera.setNear(1.0f);
            perspectiveCamera.setFar(4201542);
            frustumCamera = perspectiveCamera;
        } else {
            OrthographicCamera orthographicCamera = scene.createOrthographicCamera();
            orthographicCamera.setLeft(0.0f);
            orthographicCamera.setRight(1.0f);
            orthographicCamera.setBottom(0.0f);
            orthographicCamera.setTop(1.0f);
            orthographicCamera.setNear(1.0f);
            orthographicCamera.setFar(4201542);
            frustumCamera = orthographicCamera;
        }
        frustumCamera.setName("Camera");
        sceneNode.addEntity(frustumCamera);
        sceneNode.setPosition(0.0f, 0.0f, 8257);
        sceneNode2.addChild(sceneNode);
        scene.setDefaultCamera(frustumCamera);
        return scene;
    }

    public Scene createSceneFromMesh(Graphics3D graphics3D, Mesh mesh, Effect effect, boolean bl, boolean bl2) {
        Scene scene = this.createScene(graphics3D, bl, bl2);
        SceneNode sceneNode = scene.getRootNode();
        SceneNode sceneNode2 = scene.createSceneNode();
        ModelEntity modelEntity = scene.createModelEntity();
        modelEntity.setName("Mesh");
        Model model = graphics3D.createModel();
        model.setMesh(mesh);
        model.setEffect(effect);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Material());
        model.setMaterials(arrayList);
        modelEntity.setModel(model);
        sceneNode2.addEntity(modelEntity);
        sceneNode.addChild(sceneNode2);
        return scene;
    }
}

