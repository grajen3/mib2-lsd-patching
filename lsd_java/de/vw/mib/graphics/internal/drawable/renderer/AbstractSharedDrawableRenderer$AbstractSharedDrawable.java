/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.drawable.renderer;

import de.vw.mib.cache.Cacheable;
import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.Dimension;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.drawable.DrawablePerformanceMetrics;
import de.vw.mib.graphics.effect.ColorEffect;
import de.vw.mib.graphics.effect.Effect;
import de.vw.mib.graphics.effect.EffectException;
import de.vw.mib.graphics.effect.TransformationEffect;
import de.vw.mib.graphics.image.UnsupportedImageFormatException;
import de.vw.mib.graphics.image.UnsupportedImageSizeException;
import de.vw.mib.graphics.internal.InsufficientSpaceException;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractPooledDrawableRenderer$AbstractPooledDrawable;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractSharedDrawableRenderer;
import de.vw.mib.graphics.internal.effect.shader.TransformShaderEffect;
import de.vw.mib.graphics.internal.mesh.MeshHeap$SubMesh;
import de.vw.mib.graphics.internal.state.GraphicsState;
import de.vw.mib.graphics.internal.texture.TextureAtlas$SubTexture;
import de.vw.mib.graphics.math.Tuple4f;
import de.vw.mib.graphics.math.algebra.Matrix4f;
import de.vw.mib.graphics.texture.Texture;
import de.vw.mib.graphics.texture.Texture2D;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.pool.ObjectPool;
import de.vw.mib.util.StringBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class AbstractSharedDrawableRenderer$AbstractSharedDrawable
extends AbstractPooledDrawableRenderer$AbstractPooledDrawable
implements Cacheable {
    private boolean geometryValid;
    private MeshHeap$SubMesh subMesh;
    private Texture[] textures;
    private List subTextures;
    private Effect effect;
    protected static HashCodeBuilder hcb = new HashCodeBuilder();
    private static Color4f tempColor = new Color4f(Color4f.BLACK_TRANSPARENT);
    private static Matrix4f tempMatrix = new Matrix4f();

    public AbstractSharedDrawableRenderer$AbstractSharedDrawable(AbstractSharedDrawableRenderer abstractSharedDrawableRenderer, ObjectPool objectPool) {
        super(abstractSharedDrawableRenderer, objectPool);
        Graphics3D graphics3D = this.getGraphics3D();
        this.geometryValid = false;
        this.textures = new Texture[graphics3D.getTextureManager().getMaxTextureUnits()];
        this.subTextures = new ArrayList(1);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[geometryValid=").append(this.geometryValid);
        stringBuilder.append(",subMesh=").append(this.subMesh);
        stringBuilder.append(",subTextures=").append(this.subTextures);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public void dispose() {
        this.invalidateGeometry();
        this.clearEffect();
        super.dispose();
    }

    @Override
    public int getByteSize() {
        return 0;
    }

    private MeshHeap$SubMesh getSubMesh() {
        return this.subMesh;
    }

    private void setSubMesh(MeshHeap$SubMesh meshHeap$SubMesh) {
        this.subMesh = meshHeap$SubMesh;
    }

    private List getSubTextures() {
        return this.subTextures;
    }

    private void setSubTextures(List list) {
        this.subTextures = list;
    }

    private Effect getEffect() {
        if (this.effect == null) {
            this.effect = this.createEffect(this.getGraphics3D());
        }
        return this.effect;
    }

    protected abstract Effect createEffect(Graphics3D graphics3D) {
    }

    protected final void clearEffect() {
        this.effect = null;
    }

    private boolean isGeometryValid() {
        return this.geometryValid;
    }

    private void setGeometryValid(boolean bl) {
        this.geometryValid = bl;
    }

    protected final void invalidateGeometry() {
        this.setGeometryValid(false);
        if (this.subMesh != null) {
            AbstractSharedDrawableRenderer abstractSharedDrawableRenderer = (AbstractSharedDrawableRenderer)this.getDrawableRenderer();
            abstractSharedDrawableRenderer.removeSubMeshReference(this.subMesh, this);
            this.subMesh = null;
        }
        this.invalidateTextures();
    }

    private void invalidateTextures() {
        Arrays.fill(this.textures, null);
        this.subTextures.clear();
    }

    @Override
    public void draw() {
        Graphics3D graphics3D = this.getGraphics3D();
        Logger logger = this.getLogger();
        AbstractSharedDrawableRenderer abstractSharedDrawableRenderer = (AbstractSharedDrawableRenderer)this.getDrawableRenderer();
        try {
            Object object;
            if (!this.isGeometryValid()) {
                try {
                    this.subMesh = this.updateMesh(this.textures, this.subTextures);
                    if (this.subMesh != null) {
                        abstractSharedDrawableRenderer.addSubMeshReference(this.subMesh, this);
                        if (!this.subTextures.isEmpty()) {
                            abstractSharedDrawableRenderer.addMapping(this.subTextures, this.subMesh);
                        }
                    }
                    if (logger.isTraceEnabled(512)) {
                        LogMessage logMessage = logger.trace(512);
                        logMessage.append(super.getClass().getName());
                        logMessage.append(".update(");
                        if (logger.isTraceEnabled(64)) {
                            logMessage.append(this);
                        }
                        logMessage.append(")");
                        logMessage.log();
                    }
                }
                catch (UnsupportedImageSizeException unsupportedImageSizeException) {
                    object = logger.error(512);
                    object.append(super.getClass().getName());
                    object.append(".update() image size too large: ").append(unsupportedImageSizeException.getWidth()).append("x").append(unsupportedImageSizeException.getHeight()).log();
                }
                catch (UnsupportedImageFormatException unsupportedImageFormatException) {
                    object = logger.error(512);
                    object.append(super.getClass().getName());
                    object.append(".update() invalid image format: ").append(unsupportedImageFormatException.getFormat()).log();
                }
                this.setGeometryValid(true);
            }
            if (this.subMesh != null) {
                if (AbstractSharedDrawableRenderer.LOCKING) {
                    abstractSharedDrawableRenderer.lockSubTextures(this.subTextures);
                }
                for (int i2 = 0; i2 < this.textures.length; ++i2) {
                    object = this.textures[i2];
                    graphics3D.setTexture(i2, (Texture)object);
                    if (object == null) continue;
                    this.updateTexture(i2, (Texture)object);
                }
                Effect effect = this.getEffect();
                if (effect != null) {
                    this.updateEffect(effect);
                    effect.bind();
                }
                graphics3D.setMesh(abstractSharedDrawableRenderer.getMeshHeap().getMesh());
                graphics3D.draw(this.subMesh);
                if (AbstractSharedDrawableRenderer.LOCKING) {
                    abstractSharedDrawableRenderer.lockSubMesh(this.subMesh);
                }
                super.draw();
            }
        }
        catch (InsufficientSpaceException insufficientSpaceException) {
            LogMessage logMessage = logger.error(512);
            logMessage.append(super.getClass().getName());
            logMessage.append(".draw(): Could not allocate sub mesh or sub texture (MeshHeap or TextureAtlas exhausted?)");
            if (AbstractSharedDrawableRenderer.LOCKING) {
                logMessage.append(" - Synchronizing rendering");
            }
            logMessage.log();
            if (AbstractSharedDrawableRenderer.LOCKING) {
                abstractSharedDrawableRenderer.waitLocks();
                this.draw();
            }
        }
        catch (EffectException effectException) {
            LogMessage logMessage = logger.error(512);
            logMessage.append(super.getClass().getName());
            logMessage.append(".draw() unrecoverable effect error:");
            logMessage.attachThrowable(effectException);
            logMessage.log();
        }
    }

    protected void updateTexture(int n, Texture texture) {
    }

    protected abstract void updateEffect(Effect effect) {
    }

    protected final void updateTransformationEffect(TransformationEffect transformationEffect) {
        GraphicsState graphicsState = this.getDrawableRenderer().getGraphicsState();
        Matrix4f matrix4f = graphicsState.vertexState.viewTransform.peek();
        Matrix4f matrix4f2 = graphicsState.projectionState.projectionTransform.peek();
        transformationEffect.setModelViewMatrix(matrix4f);
        if (TransformShaderEffect.GENERATE_MVP_MATRIX) {
            matrix4f2.mul(matrix4f, tempMatrix);
            transformationEffect.setModelViewProjectionMatrix(tempMatrix);
        } else {
            transformationEffect.setProjectionMatrix(matrix4f2);
        }
    }

    protected final void updateColorEffect(ColorEffect colorEffect) {
        this.getColor().modulateAlpha(this.getAlpha(), tempColor);
        colorEffect.setColor(tempColor);
    }

    @Override
    protected abstract void updateDrawingStatistics(DrawablePerformanceMetrics drawablePerformanceMetrics) {
    }

    protected abstract MeshHeap$SubMesh updateMesh(Texture[] textureArray, List list) {
    }

    protected static final void setSubTextureRectangle(Tuple4f tuple4f, TextureAtlas$SubTexture textureAtlas$SubTexture, int n, int n2) {
        Texture2D texture2D = textureAtlas$SubTexture.getTexture();
        Dimension dimension = texture2D.getSize();
        Rectangle rectangle = textureAtlas$SubTexture.getRectangle();
        tuple4f.set((float)rectangle.x / (float)dimension.width, (float)rectangle.y / (float)dimension.height, (float)rectangle.width / (float)dimension.width / (float)n, (float)rectangle.height / (float)dimension.height / (float)n2);
    }
}

