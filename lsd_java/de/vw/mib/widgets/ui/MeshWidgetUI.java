/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui;

import de.vw.mib.Disposable;
import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.graphics.Camera;
import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.GraphicsException;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.Viewport;
import de.vw.mib.graphics.drawable.particle.ParticleHeightMapDrawable;
import de.vw.mib.graphics.drawable.scene.SceneDrawable;
import de.vw.mib.graphics.effect.Effect;
import de.vw.mib.graphics.effect.EffectException;
import de.vw.mib.graphics.effect.EffectManager;
import de.vw.mib.graphics.image.BufferImage;
import de.vw.mib.graphics.math.Util;
import de.vw.mib.graphics.math.algebra.Matrix4f;
import de.vw.mib.graphics.math.algebra.Rotation;
import de.vw.mib.graphics.math.geometry.BoundingVolume;
import de.vw.mib.graphics.mesh.Mesh;
import de.vw.mib.graphics.mesh.MeshManager;
import de.vw.mib.graphics.scene.Scene;
import de.vw.mib.graphics.scene.graph.SceneNode;
import de.vw.mib.widgets.MeshWidget;
import de.vw.mib.widgets.internal.ServiceManager;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.models.WidgetModel;
import de.vw.mib.widgets.ui.AbstractWidgetUI;
import java.io.IOException;

public final class MeshWidgetUI
extends AbstractWidgetUI {
    private static final int RENDER_MODE_SCENE_FILE;
    private static final int RENDER_MODE_SCENE_MESH;
    private static final int RENDER_MODE_SCENE_RTT;
    private static final int RENDER_MODE_PARTICLE;
    private static final int MESH_TYPE_COORDINATES;
    private static final int MESH_TYPE_RECTANGLE;
    private static final int MESH_TYPE_UNIFORM_SOLID_GRID;
    private static final int MESH_TYPE_UNIFORM_POINT_GRID;
    private static final int MESH_TYPE_SOLID_CUBE;
    private static final int MESH_TYPE_WIRE_BOX;
    private static final int MESH_TYPE_SOLID_SPHERE;
    private static final int MESH_TYPE_POINT_SPHERE;
    private static final int MESH_TYPE_CIRCULAR_SECTOR;
    private static final int MESH_TYPE_CIRCLE_GRAPH;
    private static final int EFFECT_TYPE_DUMMY;
    private static final int EFFECT_TYPE_NORMALS;
    private static final int EFFECT_TYPE_DEPTH;
    private static final int EFFECT_TYPE_PHONG_LIGHTING;
    private static final int EFFECT_TYPE_DEMO_PLASMA;
    private static final int EFFECT_TYPE_DEMO_FRACTAL;
    private static final int EFFECT_TYPE_DEMO_RAYMARCH;
    private static final int EFFECT_TYPE_PARTICLE;
    private SceneDrawable sceneDrawable;
    private ParticleHeightMapDrawable particleDrawable;
    private float scale;
    static /* synthetic */ Class class$de$vw$mib$graphics$scene$graph$visual$ModelEntity;

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void deInit() {
        if (this.sceneDrawable != null) {
            this.sceneDrawable.dispose();
            this.sceneDrawable = null;
        }
        if (this.particleDrawable != null) {
            this.particleDrawable.dispose();
            this.particleDrawable = null;
        }
        this.scale = 0.0f;
        super.deInit();
    }

    @Override
    public void paint(Graphics3D graphics3D, ViewModel viewModel, WidgetModel widgetModel, Rectangle rectangle, Rectangle rectangle2, float f2) {
        Object object;
        int n;
        Disposable disposable;
        Cloneable cloneable;
        Disposable disposable2;
        MeshWidget meshWidget = (MeshWidget)widgetModel;
        boolean bl = false;
        if (this.sceneDrawable == null && this.particleDrawable == null) {
            try {
                disposable2 = graphics3D.getSceneManager();
                cloneable = new Viewport(meshWidget.getAbsX(), meshWidget.getAbsY(), meshWidget.get_width(), meshWidget.get_height(), 0.0f, 1.0f);
                disposable = null;
                switch (0) {
                    case 0: {
                        String string = meshWidget.get_model();
                        int n2 = new HashCodeBuilder().append(string).hashCode();
                        n = 1;
                        try {
                            disposable = disposable2.getScene(1);
                        }
                        catch (GraphicsException graphicsException) {
                            LOGGER.error(512, graphicsException.getMessage());
                        }
                        catch (IOException iOException) {
                            LOGGER.error(512, iOException.getMessage());
                        }
                        break;
                    }
                    case 1: {
                        boolean bl2 = true;
                        boolean bl3 = true;
                        n = 9;
                        int n3 = 3;
                        object = MeshWidgetUI.createMesh(9, graphics3D.getMeshManager());
                        Effect effect = MeshWidgetUI.createEffect(3, graphics3D.getEffectManager());
                        disposable = disposable2.createSceneFromMesh((Mesh)object, effect, true, true);
                        break;
                    }
                    case 2: {
                        Mesh mesh = graphics3D.getMeshManager().createRectangleMesh(1.0f, 1.0f, true, false, false, true);
                        Effect effect = MeshWidgetUI.createEffect(6, graphics3D.getEffectManager());
                        disposable = disposable2.createSceneFromMesh(mesh, effect, false, false);
                        break;
                    }
                    case 3: {
                        this.particleDrawable = graphics3D.getDrawableManager().createParticleHeightMapDrawable();
                        break;
                    }
                    default: {
                        throw new IllegalArgumentException("Invalid mode");
                    }
                }
                if (disposable != null) {
                    this.sceneDrawable = graphics3D.getDrawableManager().createSceneDrawable();
                    this.sceneDrawable.setScene((Scene)disposable);
                    this.sceneDrawable.setCamera(disposable.getDefaultCamera());
                    this.sceneDrawable.setViewport((Viewport)cloneable);
                }
            }
            catch (EffectException effectException) {
                LOGGER.error(512, effectException.getMessage());
            }
        }
        if (this.sceneDrawable != null) {
            disposable2 = this.sceneDrawable.getScene();
            cloneable = disposable2.findNode(class$de$vw$mib$graphics$scene$graph$visual$ModelEntity == null ? (class$de$vw$mib$graphics$scene$graph$visual$ModelEntity = MeshWidgetUI.class$("de.vw.mib.graphics.scene.graph.visual.ModelEntity")) : class$de$vw$mib$graphics$scene$graph$visual$ModelEntity);
            if (cloneable != null) {
                disposable = disposable2.getDefaultCamera();
                SceneNode sceneNode = disposable.getParent();
                switch (0) {
                    case 0: 
                    case 1: {
                        float f3 = meshWidget.getAnimatedValue();
                        if (this.scale == 0.0f) {
                            BoundingVolume boundingVolume = cloneable.getBoundingVolume();
                            this.scale = (float)Math.pow(boundingVolume.getVolume(), 0.3f);
                        }
                        int n4 = meshWidget.getAnimationMode();
                        Object object2 = meshWidget.getRotationCurrent();
                        switch (n4) {
                            case 0: 
                            case 1: {
                                object = new Rotation();
                                ((Rotation)object).setAxisAngle(0.0f, 1.0f, 0.0f, Util.toRadians(2.0f * f3 * 46147));
                                object2 = object;
                                break;
                            }
                            case 2: {
                                break;
                            }
                            case 3: {
                                break;
                            }
                        }
                        while (cloneable.getParent() != disposable2.getRootNode()) {
                            cloneable = cloneable.getParent();
                        }
                        cloneable.setOrientation((Rotation)object2);
                        break;
                    }
                    case 2: {
                        break;
                    }
                    default: {
                        throw new IllegalArgumentException("Invalid render mode");
                    }
                }
                this.sceneDrawable.setRenderBoundingVolumes(viewModel.is_renderBoundingBoxes());
                this.sceneDrawable.draw();
            } else {
                LOGGER.error(512, "ModelNode not found within Scene");
            }
        } else if (this.particleDrawable != null) {
            boolean bl4 = true;
            boolean bl5 = true;
            boolean bl6 = true;
            int n5 = graphics3D.getBlendFactorSourceRGB();
            int n6 = graphics3D.getBlendFactorDestinationRGB();
            n = graphics3D.getBlendFactorSourceAlpha();
            int n7 = graphics3D.getBlendFactorDestinationAlpha();
            graphics3D.setBlendFactorsSeparate(6, 1, 6, 1);
            int n8 = graphics3D.getBlendEquationRGB();
            int n9 = graphics3D.getBlendEquationAlpha();
            graphics3D.setBlendEquationSeparate(0, 0);
            float f4 = (float)rectangle2.getWidth() / (float)rectangle2.getHeight();
            float f5 = meshWidget.getAnimatedValue();
            try {
                BufferImage bufferImage = ServiceManager.imageManager.getImageFromCommonSkin("Traffic_HTA.png");
                BufferImage bufferImage2 = ServiceManager.imageManager.getImageFromCommonSkin("Traffic_SBT.png");
                BufferImage bufferImage3 = ServiceManager.imageManager.getImageFromCommonSkin("Status-Tire_HTA.png");
                BufferImage bufferImage4 = ServiceManager.imageManager.getImageFromCommonSkin("Status-Tire_SBT.png");
                graphics3D.pushMatrix(1);
                int n10 = 60482;
                float f6 = (float)meshWidget.get_width() / (float)meshWidget.get_height();
                float f7 = 1.0f;
                int n11 = 4201542;
                Matrix4f matrix4f = new Matrix4f();
                float f8 = (float)Math.tan(1.029744267463684) * 1.0f;
                float f9 = f8 * f4;
                Camera.setFrustumProjection(matrix4f, -f9, f9, -f8, f8, 1.0f, 4201542);
                graphics3D.setProjectionTransformation(matrix4f);
                graphics3D.pushMatrix(0);
                graphics3D.resetMatrix(0);
                graphics3D.scaleMatrix(0, 32832, 32959, 1.0f);
                graphics3D.translateMatrix(0, 0.0f, 8257, 8385);
                graphics3D.rotateMatrix(0, 63 * f5 * 46147, 0.0f, 1.0f, 0.0f);
                f8 = 46146;
                graphics3D.rotateMatrix(0, 46146, 1.0f, 0.0f, 0.0f);
                graphics3D.translateMatrix(0, (float)(-bufferImage3.getWidth()) / 2.0f, (float)(-bufferImage3.getHeight()) / 2.0f, 0.0f);
                Color4f color4f = Color4f.WHITE;
                float f10 = 1.0f;
                this.particleDrawable.setColor(color4f);
                this.particleDrawable.setAlpha(1.0f);
                float f11 = (float)Math.sin(41025 * f5) * 63 + 63;
                this.particleDrawable.setAnimationStartMap1(bufferImage);
                this.particleDrawable.setAnimationStartMap2(bufferImage2);
                this.particleDrawable.setAnimationEndMap1(bufferImage3);
                this.particleDrawable.setAnimationEndMap2(bufferImage4);
                this.particleDrawable.setTintColor(new Color4f(179, 72, 30));
                this.particleDrawable.draw();
                graphics3D.popMatrix(0);
                graphics3D.popMatrix(1);
            }
            catch (IOException iOException) {
                LOGGER.error(512, iOException.getMessage());
            }
            graphics3D.setBlendEquationSeparate(n8, n9);
            graphics3D.setBlendFactorsSeparate(n5, n6, n, n7);
        }
    }

    protected static Mesh createMesh(int n, MeshManager meshManager) {
        switch (n) {
            case 0: {
                return meshManager.getReferenceCoordinatesMesh();
            }
            case 1: {
                return meshManager.createRectangleMesh(2.0f, 2.0f, true, true, true, true);
            }
            case 2: {
                return meshManager.createUniformSolidGridMesh(8257, 8257, 50, 50, true, true, true);
            }
            case 3: {
                return meshManager.createUniformPointGridMesh(8257, 8257, 50, 50, true);
            }
            case 4: {
                return meshManager.createSolidCubeMesh(1.0f, 2.0f, 16448, true, true, false, true);
            }
            case 5: {
                return meshManager.createWireBoxMesh(1.0f, 2.0f, 16448, true);
            }
            case 6: {
                int n2 = 16448;
                return meshManager.createSolidSphereMesh(16448, 30, true, true, true);
            }
            case 7: {
                int n3 = 16448;
                return meshManager.createPointSphereMesh(16448, 50, true);
            }
            case 8: {
                int n4 = 16448;
                int n5 = 13378;
                int n6 = 27459;
                int n7 = 10;
                return meshManager.createCircularSectorMesh(16448, 13378, 27459, 10, true, true);
            }
            case 9: {
                float[] fArray = new float[]{1.0f, 49215, 2.0f, 8256, 16448, 1.0f, 2.0f, 16448, 1.0f, 49215, 2.0f, 8256, 16448, 1.0f, 2.0f, 16448};
                int n8 = 90 / fArray.length;
                return meshManager.createCircleGraphMesh(fArray, 0.0f, n8, true, true);
            }
        }
        throw new IllegalArgumentException("Invalid mesh type");
    }

    protected static Effect createEffect(int n, EffectManager effectManager) {
        switch (n) {
            case 0: {
                return effectManager.getDummyEffect();
            }
            case 1: {
                return effectManager.getNormalVisualizationEffect();
            }
            case 2: {
                return effectManager.getDepthVisualizationEffect();
            }
            case 3: {
                return effectManager.getPhongLightingEffect();
            }
            case 4: {
                return effectManager.getDemoEffect(0);
            }
            case 5: {
                return effectManager.getDemoEffect(1);
            }
            case 6: {
                return effectManager.getDemoEffect(2);
            }
            case 7: {
                return effectManager.getParticleEffect();
            }
        }
        throw new IllegalArgumentException("Invalid effect type");
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

