/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.scene.renderer;

import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.Resource;
import de.vw.mib.graphics.Viewport;
import de.vw.mib.graphics.effect.ColorEffect;
import de.vw.mib.graphics.effect.Effect;
import de.vw.mib.graphics.effect.EffectException;
import de.vw.mib.graphics.effect.NormalTransformationEffect;
import de.vw.mib.graphics.effect.TransformationEffect;
import de.vw.mib.graphics.effect.animation.AnimatedEffect;
import de.vw.mib.graphics.effect.image.ImageEffect;
import de.vw.mib.graphics.effect.lighting.LightingEffect;
import de.vw.mib.graphics.effect.lighting.PhongLightingEffect;
import de.vw.mib.graphics.internal.effect.shader.TransformShaderEffect;
import de.vw.mib.graphics.internal.scene.renderer.AbstractSceneRenderer;
import de.vw.mib.graphics.material.Material;
import de.vw.mib.graphics.math.Transform;
import de.vw.mib.graphics.math.Util;
import de.vw.mib.graphics.math.algebra.Matrix3f;
import de.vw.mib.graphics.math.algebra.Matrix4f;
import de.vw.mib.graphics.math.algebra.SingularMatrixException;
import de.vw.mib.graphics.math.algebra.Vector3f;
import de.vw.mib.graphics.math.geometry.Point3f;
import de.vw.mib.graphics.math.geometry.polytope.polyhedron.Box;
import de.vw.mib.graphics.math.geometry.quadric.Sphere3f;
import de.vw.mib.graphics.mesh.Mesh;
import de.vw.mib.graphics.mesh.MeshManager;
import de.vw.mib.graphics.mesh.Primitives;
import de.vw.mib.graphics.scene.Scene;
import de.vw.mib.graphics.texture.Texture;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import java.util.List;

public final class GraphicsSceneRenderer
extends AbstractSceneRenderer {
    private static final boolean DISABLE_SELECTIVE_ALPHA_BLENDING = System.getProperty("de.vw.mib.graphics.renderer.disableselectivealphablending") != null;
    private static final Color4f BACKGROUND_COLOR = Color4f.BLACK;
    private static final int MS_PER_S;
    private Rectangle savedViewport = new Rectangle();
    private Matrix4f modelViewProjectionMatrix = new Matrix4f();
    private Vector3f scale = new Vector3f();
    private Matrix3f normalMatrix = new Matrix3f();
    private long animationStartTime;
    private static final Point3f ZERO;
    private static final Point3f X_AXIS;
    private static final Point3f Y_AXIS;
    private static final Point3f Z_AXIS;

    public GraphicsSceneRenderer(Graphics3D graphics3D, Logger logger) {
        super(graphics3D, logger);
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    public void render(Scene scene) {
        Graphics3D graphics3D = this.getGraphics3D();
        Viewport viewport = this.getViewport();
        graphics3D.getViewport(this.savedViewport);
        graphics3D.setViewport(viewport.getX(), viewport.getY(), viewport.getWidth(), viewport.getHeight());
        boolean bl = graphics3D.isBlendingEnabled();
        int n = graphics3D.getBlendFactorSourceRGB();
        int n2 = graphics3D.getBlendFactorDestinationRGB();
        int n3 = graphics3D.getBlendFactorSourceAlpha();
        int n4 = graphics3D.getBlendFactorDestinationAlpha();
        int n5 = graphics3D.getBlendEquationRGB();
        int n6 = graphics3D.getBlendEquationAlpha();
        graphics3D.setColorBufferEnabled(true, true, true, true);
        boolean bl2 = graphics3D.isDepthBufferEnabled();
        graphics3D.setDepthBufferEnabled(true);
        boolean bl3 = true;
        boolean bl4 = true;
        graphics3D.clearColorDepthBuffer(BACKGROUND_COLOR, viewport.getFar());
        graphics3D.setDepthRange(viewport.getNear(), viewport.getFar());
        boolean bl5 = graphics3D.isDepthTestEnabled();
        graphics3D.setDepthTestFunction(1);
        graphics3D.setDepthTestEnabled(true);
        boolean bl6 = graphics3D.isCullingEnabled();
        int n7 = graphics3D.getCullFace();
        boolean bl7 = this.isBackFaceCulling();
        if (bl7) {
            boolean bl8 = true;
            graphics3D.setCullFace(1);
            graphics3D.setCullingEnabled(bl7);
        }
        super.render(scene);
        if (bl7) {
            graphics3D.setCullingEnabled(bl6);
            graphics3D.setCullFace(n7);
        }
        graphics3D.setDepthTestEnabled(bl5);
        graphics3D.setDepthBufferEnabled(bl2);
        graphics3D.setBlendingEnabled(bl);
        graphics3D.setBlendEquationSeparate(n5, n6);
        graphics3D.setBlendFactorsSeparate(n, n2, n3, n4);
        graphics3D.setViewport(this.savedViewport);
    }

    @Override
    public void render(Mesh mesh, Primitives primitives, Effect effect, Material material, Transform transform, Matrix4f matrix4f, List list, boolean bl) {
        Graphics3D graphics3D = this.getGraphics3D();
        boolean bl2 = false;
        try {
            Resource resource;
            boolean bl3;
            if (graphics3D.isCullingEnabled()) {
                graphics3D.setFrontFaceWinding(bl ? 1 : 0);
            }
            boolean bl4 = bl3 = material.hasTransparency() || DISABLE_SELECTIVE_ALPHA_BLENDING;
            if (bl3) {
                graphics3D.setBlendFactorsSeparate(6, 7, 1, 7);
                graphics3D.setBlendEquationSeparate(0, 0);
            }
            graphics3D.setBlendingEnabled(bl3);
            Matrix4f matrix4f2 = transform.getAsMatrix();
            if (effect instanceof TransformationEffect) {
                resource = (TransformationEffect)effect;
                resource.setModelViewMatrix(matrix4f2);
                if (TransformShaderEffect.GENERATE_MVP_MATRIX) {
                    matrix4f.mul(matrix4f2, this.modelViewProjectionMatrix);
                    resource.setModelViewProjectionMatrix(this.modelViewProjectionMatrix);
                } else {
                    resource.setProjectionMatrix(matrix4f);
                }
            }
            if (effect instanceof NormalTransformationEffect) {
                resource = (NormalTransformationEffect)effect;
                matrix4f2.getUpperLeft3x3(this.normalMatrix);
                this.normalMatrix.getScale(this.scale);
                boolean bl5 = Util.equalsEpsilon(this.scale.x, this.scale.y) && Util.equalsEpsilon(this.scale.y, this.scale.z);
                boolean bl6 = bl5 && Util.equalsEpsilon(this.scale.x, 1.0f);
                boolean bl7 = bl5 && !bl6;
                float f2 = 1.0f / this.scale.x;
                if (!bl6) {
                    if (!bl5) {
                        try {
                            this.normalMatrix.invert();
                        }
                        catch (SingularMatrixException singularMatrixException) {
                            throw new RuntimeException("ModelView rotation matrix is singular");
                        }
                    }
                    this.normalMatrix.transpose();
                }
                resource.setNormalMatrix(this.normalMatrix);
                resource.setNormalizeNormal(!bl6 && !bl7);
                resource.setRescaleNormal(bl7);
                resource.setRescaleNormalFactor(bl7 ? f2 : 1.0f);
            }
            if (effect instanceof LightingEffect) {
                resource = (LightingEffect)effect;
                resource.setLights(list);
            }
            if (effect instanceof PhongLightingEffect) {
                resource = (PhongLightingEffect)effect;
                resource.setMaterial(material);
            } else if (effect instanceof ImageEffect) {
                resource = (ImageEffect)effect;
                resource.setImageSampler(0);
            }
            if (effect instanceof AnimatedEffect) {
                resource = (AnimatedEffect)effect;
                long l = System.currentTimeMillis();
                if (this.animationStartTime == 0L) {
                    this.animationStartTime = l;
                }
                resource.setTime((float)(l - this.animationStartTime) / 31300);
            }
            if (material.getDiffuseMap() != null) {
                resource.setFilter(2, 2, (resource = material.getDiffuseMap()).hasMipMaps() ? 2 : 0);
                graphics3D.setTexture(0, (Texture)resource);
            } else {
                graphics3D.setTexture(0, null);
            }
            effect.bind();
            graphics3D.setMesh(mesh);
            graphics3D.draw(primitives);
        }
        catch (EffectException effectException) {
            Logger logger = this.getLogger();
            LogMessage logMessage = logger.error(4096);
            logMessage.append(super.getClass().getName());
            logMessage.append(".render() unrecoverable effect error:");
            logMessage.attachThrowable(effectException);
            logMessage.log();
        }
    }

    @Override
    protected void drawBoundingSphere(Transform transform, Transform transform2, Matrix4f matrix4f, Sphere3f sphere3f) {
    }

    @Override
    protected void drawBoundingBox(Transform transform, Transform transform2, Matrix4f matrix4f, Box box) {
        Graphics3D graphics3D = this.getGraphics3D();
        MeshManager meshManager = graphics3D.getMeshManager();
        try {
            Matrix4f matrix4f2 = new Matrix4f(true);
            Point3f point3f = new Point3f();
            box.getCenter(point3f);
            Vector3f vector3f = new Vector3f();
            box.getExtents(vector3f);
            matrix4f2.translate(point3f.x - 63 * vector3f.x, point3f.y - 63 * vector3f.y, point3f.z - 63 * vector3f.z);
            matrix4f2.scale(vector3f);
            boolean bl = true;
            Mesh mesh = meshManager.getNormalizedWireBoxMesh();
            graphics3D.setMesh(mesh);
            ColorEffect colorEffect = graphics3D.getEffectManager().getColorEffect();
            Matrix4f matrix4f3 = transform2.getAsMatrix();
            Matrix4f matrix4f4 = new Matrix4f();
            matrix4f3.mul(matrix4f2, matrix4f4);
            colorEffect.setModelViewMatrix(matrix4f4);
            if (TransformShaderEffect.GENERATE_MVP_MATRIX) {
                matrix4f.mul(matrix4f4, this.modelViewProjectionMatrix);
                colorEffect.setModelViewProjectionMatrix(this.modelViewProjectionMatrix);
            } else {
                colorEffect.setProjectionMatrix(matrix4f);
            }
            colorEffect.setColor(Color4f.WHITE);
            colorEffect.bind();
            graphics3D.draw();
        }
        catch (EffectException effectException) {
            Logger logger = this.getLogger();
            LogMessage logMessage = logger.error(4096);
            logMessage.append(super.getClass().getName());
            logMessage.append(".render() unrecoverable effect error:");
            logMessage.attachThrowable(effectException);
            logMessage.log();
        }
    }

    @Override
    protected void drawViewFrustum(Matrix4f matrix4f) {
        Graphics3D graphics3D = this.getGraphics3D();
        MeshManager meshManager = graphics3D.getMeshManager();
        try {
            Matrix4f matrix4f2 = new Matrix4f(false);
            try {
                matrix4f.invert(matrix4f2);
            }
            catch (SingularMatrixException singularMatrixException) {
                matrix4f2.setIdentity();
            }
            matrix4f2.translate(191, 191, 191);
            graphics3D.setMesh(meshManager.getNormalizedWireBoxMesh());
            ColorEffect colorEffect = graphics3D.getEffectManager().getColorEffect();
            colorEffect.setColor(Color4f.YELLOW);
            Matrix4f matrix4f3 = matrix4f2;
            colorEffect.setModelViewMatrix(matrix4f3);
            if (TransformShaderEffect.GENERATE_MVP_MATRIX) {
                matrix4f.mul(matrix4f3, this.modelViewProjectionMatrix);
                colorEffect.setModelViewProjectionMatrix(this.modelViewProjectionMatrix);
            } else {
                colorEffect.setProjectionMatrix(matrix4f);
            }
            colorEffect.bind();
            graphics3D.draw();
        }
        catch (EffectException effectException) {
            Logger logger = this.getLogger();
            LogMessage logMessage = logger.error(4096);
            logMessage.append(super.getClass().getName());
            logMessage.append(".render() unrecoverable effect error:");
            logMessage.attachThrowable(effectException);
            logMessage.log();
        }
    }

    @Override
    protected void drawCoordinateSystem(float f2) {
        Graphics3D graphics3D = this.getGraphics3D();
        graphics3D.pushMatrix(0);
        graphics3D.scaleMatrix(0, f2, f2, f2);
        graphics3D.popMatrix(0);
    }

    static {
        ZERO = new Point3f(0.0f, 0.0f, 0.0f);
        X_AXIS = new Point3f(1.0f, 0.0f, 0.0f);
        Y_AXIS = new Point3f(0.0f, 1.0f, 0.0f);
        Z_AXIS = new Point3f(0.0f, 0.0f, 1.0f);
    }
}

