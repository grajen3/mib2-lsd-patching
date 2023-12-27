/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.effect.shader.image;

import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.collections.longs.LongObjectMap;
import de.vw.mib.collections.longs.LongObjectOptHashMap;
import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.effect.EffectPerformanceMetrics;
import de.vw.mib.graphics.effect.image.ImageCompositionEffect;
import de.vw.mib.graphics.internal.effect.shader.AbstractShaderEffect;
import de.vw.mib.graphics.internal.effect.shader.ShaderEffectManager;
import de.vw.mib.graphics.internal.effect.shader.TransformShaderEffect;
import de.vw.mib.graphics.internal.effect.shader.image.ImageCompositionShaderEffect$OptimizedImageCompositionShaderEffect;
import de.vw.mib.graphics.internal.state.GraphicsState;
import de.vw.mib.graphics.internal.state.TextureUnitState;
import de.vw.mib.graphics.math.algebra.Matrix4f;
import de.vw.mib.graphics.shader.ShaderProgram;

public final class ImageCompositionShaderEffect
extends AbstractShaderEffect
implements ImageCompositionEffect {
    protected static final int DEFAULT_IMAGE_BLENDING;
    protected static final Color4f DEFAULT_IMAGE_BLENDING_COLOR;
    private static final int MAX_IMAGE_COUNT;
    private static final int SHADERPROGRAM_MAP_INITIAL_CAPACITY;
    private LongObjectMap shaderProgramMap = new LongObjectOptHashMap(20);
    private ImageCompositionShaderEffect$OptimizedImageCompositionShaderEffect currentShaderProgram;
    private HashCodeBuilder hcb = new HashCodeBuilder();
    private Matrix4f modelViewMatrix = new Matrix4f();
    private Matrix4f projectionMatrix = new Matrix4f();
    private Matrix4f modelViewProjectionMatrix = new Matrix4f();
    private Color4f color = new Color4f(Color4f.BLACK_TRANSPARENT);
    private int[] imageSampler = new int[2];
    private Matrix4f imageTransformation;
    private int imageBlending;
    private Color4f imageBlendingColor;

    public ImageCompositionShaderEffect(ShaderEffectManager shaderEffectManager) {
        super(shaderEffectManager);
        for (int i2 = 0; i2 < 2; ++i2) {
            this.imageSampler[i2] = -1;
        }
        this.imageTransformation = new Matrix4f();
        this.imageBlendingColor = new Color4f(Color4f.BLACK_TRANSPARENT);
        this.imageBlending = 0;
    }

    @Override
    public void dispose() {
        Object[] objectArray = this.shaderProgramMap.valuesToArray();
        for (int i2 = 0; i2 < objectArray.length; ++i2) {
            ((ShaderProgram)objectArray[i2]).dispose();
        }
        super.dispose();
    }

    @Override
    protected void updateAllocationStatistics(EffectPerformanceMetrics effectPerformanceMetrics, boolean bl) {
        effectPerformanceMetrics.allocatedImageCompositionEffects = effectPerformanceMetrics.allocatedImageCompositionEffects + (bl ? 1 : -1);
    }

    @Override
    public void initialize() {
    }

    @Override
    public ShaderProgram getShaderProgram() {
        this.updateShader();
        return this.currentShaderProgram.getShaderProgram();
    }

    @Override
    public Color4f getColor() {
        return this.color;
    }

    @Override
    public void setColor(Color4f color4f) {
        this.color.set(color4f);
    }

    @Override
    public Matrix4f getModelViewMatrix() {
        return this.modelViewMatrix;
    }

    @Override
    public void setModelViewMatrix(Matrix4f matrix4f) {
        if (!this.modelViewMatrix.equals(matrix4f)) {
            this.modelViewMatrix.set(matrix4f);
        }
    }

    @Override
    public Matrix4f getProjectionMatrix() {
        return this.projectionMatrix;
    }

    @Override
    public void setProjectionMatrix(Matrix4f matrix4f) {
        if (!this.projectionMatrix.equals(matrix4f)) {
            this.projectionMatrix.set(matrix4f);
        }
    }

    @Override
    public Matrix4f getModelViewProjectionMatrix() {
        return this.modelViewProjectionMatrix;
    }

    @Override
    public void setModelViewProjectionMatrix(Matrix4f matrix4f) {
        if (!this.modelViewProjectionMatrix.equals(matrix4f)) {
            this.modelViewProjectionMatrix.set(matrix4f);
        }
    }

    @Override
    public int getImageSampler() {
        return this.getImageSampler(0);
    }

    @Override
    public void setImageSampler(int n) {
        this.setImageSampler(0, n);
    }

    @Override
    public Matrix4f getImageTransformation() {
        return this.imageTransformation;
    }

    @Override
    public void setImageTransformation(Matrix4f matrix4f) {
        if (!this.imageTransformation.equals(matrix4f)) {
            this.imageTransformation.set(matrix4f);
        }
    }

    @Override
    public int getImageBlending() {
        return this.imageBlending;
    }

    @Override
    public void setImageBlending(int n) {
        if (this.imageBlending != n) {
            this.imageBlending = n;
        }
    }

    @Override
    public Color4f getImageBlendingColor() {
        return this.imageBlendingColor;
    }

    @Override
    public void setImageBlendingColor(Color4f color4f) {
        if (!this.imageBlendingColor.equals(color4f)) {
            this.imageBlendingColor.set(color4f);
        }
    }

    @Override
    public int getMaximumImageLayerCount() {
        return 2;
    }

    @Override
    public int getImageSampler(int n) {
        return this.imageSampler[n];
    }

    @Override
    public void setImageSampler(int n, int n2) {
        if (this.imageSampler[n] != n2) {
            this.imageSampler[n] = n2;
        }
    }

    private void updateShader() {
        ShaderEffectManager shaderEffectManager = this.getShaderEffectManager();
        GraphicsState graphicsState = shaderEffectManager.getGraphicsState();
        TextureUnitState textureUnitState = graphicsState.texturingState.textureUnitStates[0];
        int n = textureUnitState.texture.getTextureFormat();
        boolean bl = this.imageSampler[1] != -1;
        boolean bl2 = graphicsState.frameBufferState.colorBufferState.alphaTestEnable;
        this.getOptimizedShaderEffect(n, this.imageBlending, bl, bl2, graphicsState.frameBufferState.colorBufferState.alphaTestFunc);
        if (bl2) {
            this.currentShaderProgram.setAlphaTestReferenceValue(graphicsState.frameBufferState.colorBufferState.alphaTestReferenceValue);
        }
        for (int i2 = 0; i2 < this.imageSampler.length; ++i2) {
            if (this.imageSampler[i2] == -1) continue;
            this.currentShaderProgram.setImageSampler(i2, this.imageSampler[i2]);
        }
        this.currentShaderProgram.setImageTransformation(this.imageTransformation);
        this.currentShaderProgram.setImageBlendingColor(this.imageBlendingColor);
        this.currentShaderProgram.setColor(this.color);
        if (TransformShaderEffect.GENERATE_MVP_MATRIX) {
            this.currentShaderProgram.setModelViewProjectionMatrix(this.modelViewProjectionMatrix);
        } else {
            this.currentShaderProgram.setModelViewMatrix(this.modelViewMatrix);
            this.currentShaderProgram.setProjectionMatrix(this.projectionMatrix);
        }
    }

    private void getOptimizedShaderEffect(int n, int n2, boolean bl, boolean bl2, int n3) {
        if (this.currentShaderProgram == null || this.currentShaderProgram.getImageTextureFormat() != n || this.currentShaderProgram.getImageBlendingMode() != n2 || this.currentShaderProgram.getImage1Enabled() != bl || this.currentShaderProgram.getAlphaTestEnabled() != bl2 || this.currentShaderProgram.getAlphaTestFunction() != n3) {
            this.hcb.reset();
            this.hcb.append(n);
            this.hcb.append(n2);
            this.hcb.append(bl);
            this.hcb.append(bl2);
            this.hcb.append(n3);
            long l = this.hcb.longHashCode();
            if (this.currentShaderProgram == null || this.currentShaderProgram.getID() != l) {
                this.currentShaderProgram = (ImageCompositionShaderEffect$OptimizedImageCompositionShaderEffect)this.shaderProgramMap.get(l);
                if (this.currentShaderProgram == null) {
                    this.currentShaderProgram = new ImageCompositionShaderEffect$OptimizedImageCompositionShaderEffect(this.getShaderEffectManager(), l, n, n2, bl, bl2, n3);
                    this.currentShaderProgram.initialize();
                    this.shaderProgramMap.put(l, this.currentShaderProgram);
                }
            }
        }
    }

    static {
        DEFAULT_IMAGE_BLENDING_COLOR = Color4f.BLACK_TRANSPARENT;
    }
}

