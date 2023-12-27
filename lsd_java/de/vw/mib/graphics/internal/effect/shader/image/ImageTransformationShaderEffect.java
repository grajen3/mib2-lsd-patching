/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.effect.shader.image;

import de.vw.mib.graphics.effect.EffectPerformanceMetrics;
import de.vw.mib.graphics.effect.image.ImageTransformationEffect;
import de.vw.mib.graphics.internal.effect.shader.ShaderEffectManager;
import de.vw.mib.graphics.internal.effect.shader.image.ImageShaderEffect;
import de.vw.mib.graphics.internal.effect.shader.variable.Matrix4ShaderEffectVariable;
import de.vw.mib.graphics.math.algebra.Matrix4f;
import java.util.List;

public class ImageTransformationShaderEffect
extends ImageShaderEffect
implements ImageTransformationEffect {
    protected static final String FILE_NAME_TRANSFORM_TEXTUREMATRIX_VERTEX_SHADER;
    private static String[] VERTEX_SHADER_FILE_NAMES;
    private static String[] FRAGMENT_SHADER_FILE_NAMES;
    public static final String UNIFORM_NAME_IMAGE_MATRIX;
    private Matrix4ShaderEffectVariable imageTransformation;

    public ImageTransformationShaderEffect(ShaderEffectManager shaderEffectManager) {
        super(shaderEffectManager);
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    protected void updateAllocationStatistics(EffectPerformanceMetrics effectPerformanceMetrics, boolean bl) {
        effectPerformanceMetrics.allocatedImageTransformationEffects = effectPerformanceMetrics.allocatedImageTransformationEffects + (bl ? 1 : -1);
    }

    @Override
    protected void getVertexShaderFilenames(List list) {
        for (int i2 = 0; i2 < VERTEX_SHADER_FILE_NAMES.length; ++i2) {
            list.add(VERTEX_SHADER_FILE_NAMES[i2]);
        }
    }

    @Override
    protected void getFragmentShaderFilenames(List list) {
        for (int i2 = 0; i2 < FRAGMENT_SHADER_FILE_NAMES.length; ++i2) {
            list.add(FRAGMENT_SHADER_FILE_NAMES[i2]);
        }
    }

    @Override
    protected void registerShaderEffectVariables() {
        super.registerShaderEffectVariables();
        this.imageTransformation = this.addMatrix4ShaderEffectVariable("u_imageMatrix");
    }

    @Override
    public final Matrix4f getImageTransformation() {
        return this.imageTransformation.getMatrix();
    }

    @Override
    public final void setImageTransformation(Matrix4f matrix4f) {
        this.imageTransformation.setMatrix(matrix4f);
    }

    static {
        VERTEX_SHADER_FILE_NAMES = new String[]{"TransformTextureMatrix"};
        FRAGMENT_SHADER_FILE_NAMES = new String[]{"image/Image"};
    }
}

