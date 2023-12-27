/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.effect.shader.image;

import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.effect.EffectPerformanceMetrics;
import de.vw.mib.graphics.internal.effect.shader.ShaderEffectManager;
import de.vw.mib.graphics.internal.effect.shader.TransformColorShaderEffect;
import de.vw.mib.graphics.internal.effect.shader.variable.BooleanShaderEffectVariable;
import de.vw.mib.graphics.internal.effect.shader.variable.ColorShaderEffectVariable;
import de.vw.mib.graphics.internal.effect.shader.variable.FloatShaderEffectVariable;
import de.vw.mib.graphics.internal.effect.shader.variable.Matrix4ShaderEffectVariable;
import de.vw.mib.graphics.internal.effect.shader.variable.Sampler2DShaderEffectVariable;
import de.vw.mib.graphics.math.algebra.Matrix4f;
import de.vw.mib.graphics.mesh.VertexFormat;
import de.vw.mib.graphics.shader.VertexAttributeBinding;
import de.vw.mib.util.StringBuilder;
import java.util.List;

public final class ImageCompositionShaderEffect$OptimizedImageCompositionShaderEffect
extends TransformColorShaderEffect {
    private static final String FILE_NAME_TRANSFORM_MULTITEXTURE_VERTEX_SHADER;
    private static String[] VERTEX_SHADER_FILE_NAMES;
    private static final String UNIFORM_NAME_IMAGE1_SAMPLER;
    private static final String UNIFORM_NAME_IMAGE_MATRIX;
    private static final String UNIFORM_NAME_IMAGE_MATRIX_ENABLE;
    private static final String UNIFORM_NAME_IMAGE_BLEND_COLOR;
    private static final String UNIFORM_NAME_ALPHA_TEST_ENABLE;
    private static final String UNIFORM_NAME_ALPHA_TEST_FUNCTION;
    private static final String UNIFORM_NAME_ALPHA_TEST_REFERENCE_VALUE;
    private final long id;
    private final int imageTextureFormat;
    private final int imageBlending;
    private final boolean image1Enabled;
    private final boolean alphaTestEnabled;
    private final int alphaTestFunction;
    private Matrix4ShaderEffectVariable imageTransformation;
    private BooleanShaderEffectVariable imageTransformationEnable;
    private ColorShaderEffectVariable imageBlendingColor;
    private Sampler2DShaderEffectVariable[] imageSampler;
    private FloatShaderEffectVariable alphaTestReferenceValue;

    public ImageCompositionShaderEffect$OptimizedImageCompositionShaderEffect(ShaderEffectManager shaderEffectManager, long l, int n, int n2, boolean bl, boolean bl2, int n3) {
        super(shaderEffectManager);
        this.id = l;
        this.imageTextureFormat = n;
        this.imageBlending = n2;
        this.image1Enabled = bl;
        this.alphaTestEnabled = bl2;
        this.alphaTestFunction = n3;
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    protected void updateAllocationStatistics(EffectPerformanceMetrics effectPerformanceMetrics, boolean bl) {
        effectPerformanceMetrics.allocatedImageCompositionEffects = effectPerformanceMetrics.allocatedImageCompositionEffects + (bl ? 1 : -1);
    }

    @Override
    protected void getVertexShaderDefines(List list) {
        super.getVertexShaderDefines(list);
    }

    @Override
    protected void getVertexShaderFilenames(List list) {
        for (int i2 = 0; i2 < VERTEX_SHADER_FILE_NAMES.length; ++i2) {
            list.add(VERTEX_SHADER_FILE_NAMES[i2]);
        }
    }

    @Override
    protected void getFragmentShaderDefines(List list) {
        super.getFragmentShaderDefines(list);
        if (this.image1Enabled) {
            list.add(ImageCompositionShaderEffect$OptimizedImageCompositionShaderEffect.createDefine("IMAGE1_ENABLED"));
        }
    }

    @Override
    protected void getFragmentShaderFilenames(List list) {
        String string = "image/composition/";
        StringBuilder stringBuilder = new StringBuilder("image/composition/");
        stringBuilder.append("ImageComposition");
        list.add(stringBuilder.toString());
        stringBuilder = new StringBuilder("image/composition/");
        stringBuilder.append("TextureCombine_");
        switch (this.imageTextureFormat) {
            case 4096: {
                stringBuilder.append("Alpha");
                break;
            }
            case 4608: {
                stringBuilder.append("Luminance");
                break;
            }
            case 4097: {
                stringBuilder.append("LuminanceAlpha");
                break;
            }
            case 4355: {
                stringBuilder.append("RGB");
                break;
            }
            case 4356: {
                stringBuilder.append("RGBA");
                break;
            }
            default: {
                stringBuilder.append("None");
            }
        }
        stringBuilder.append("_");
        switch (this.imageBlending) {
            case 0: {
                stringBuilder.append("Modulate");
                break;
            }
            case 1: {
                stringBuilder.append("Replace");
                break;
            }
            case 2: {
                stringBuilder.append("Decal");
                break;
            }
            case 3: {
                stringBuilder.append("Blend");
                break;
            }
            case 4: {
                stringBuilder.append("Add");
                break;
            }
            default: {
                stringBuilder.append("None");
            }
        }
        list.add(stringBuilder.toString());
        stringBuilder = new StringBuilder("image/composition/");
        stringBuilder.append("AlphaTest_");
        if (this.alphaTestEnabled) {
            switch (this.alphaTestFunction) {
                case 0: {
                    stringBuilder.append("Never");
                    break;
                }
                case 1: {
                    stringBuilder.append("Less");
                    break;
                }
                case 2: {
                    stringBuilder.append("Equal");
                    break;
                }
                case 3: {
                    stringBuilder.append("LessEqual");
                    break;
                }
                case 4: {
                    stringBuilder.append("Greater");
                    break;
                }
                case 5: {
                    stringBuilder.append("GreaterEqual");
                    break;
                }
                case 6: {
                    stringBuilder.append("NotEqual");
                    break;
                }
                case 7: {
                    stringBuilder.append("Always");
                    break;
                }
                default: {
                    stringBuilder.append("None");
                    break;
                }
            }
        } else {
            stringBuilder.append("None");
        }
        list.add(stringBuilder.toString());
    }

    @Override
    protected void getVertexFormat(VertexFormat vertexFormat) {
        super.getVertexFormat(vertexFormat);
        if (this.image1Enabled) {
            vertexFormat.addVertexAttribute(3, 2, 3, 1);
        }
    }

    @Override
    protected void getVertexAttributeBinding(VertexAttributeBinding vertexAttributeBinding) {
        super.getVertexAttributeBinding(vertexAttributeBinding);
        if (this.image1Enabled) {
            vertexAttributeBinding.addBinding(3, 1, "a_texCoord1");
        }
    }

    @Override
    protected void registerShaderEffectVariables() {
        super.registerShaderEffectVariables();
        this.imageTransformation = this.addMatrix4ShaderEffectVariable("u_imageMatrix");
        this.imageTransformationEnable = this.addBooleanShaderEffectVariable("u_imageMatrixEnable");
        this.imageBlendingColor = this.addColorShaderEffectVariable("u_imageBlendColor");
        this.imageSampler = new Sampler2DShaderEffectVariable[2];
        this.imageSampler[0] = this.addSampler2DShaderEffectVariable("u_imageSampler");
        if (this.image1Enabled) {
            this.imageSampler[1] = this.addSampler2DShaderEffectVariable("u_image1Sampler");
        }
        if (this.alphaTestEnabled) {
            this.alphaTestReferenceValue = this.addFloatShaderEffectVariable("u_alphaTestRefValue");
        }
    }

    public long getID() {
        return this.id;
    }

    public int getImageTextureFormat() {
        return this.imageTextureFormat;
    }

    public void setImageTextureFormat(int n) {
        throw new UnsupportedOperationException();
    }

    public int getImageBlendingMode() {
        return this.imageBlending;
    }

    public void setImageBlendingMode(int n) {
        throw new UnsupportedOperationException();
    }

    public int getImageSampler(int n) {
        return this.imageSampler[n].getSampler();
    }

    public void setImageSampler(int n, int n2) {
        this.imageSampler[n].setSampler(n2);
    }

    public Matrix4f getImageTransformation() {
        return this.imageTransformation.getMatrix();
    }

    public void setImageTransformation(Matrix4f matrix4f) {
        this.imageTransformation.setMatrix(matrix4f);
        this.imageTransformationEnable.setValue(true);
    }

    public Color4f getImageBlendingColor() {
        return this.imageBlendingColor.getColor();
    }

    public void setImageBlendingColor(Color4f color4f) {
        this.imageBlendingColor.setColor(color4f);
    }

    public boolean getImage1Enabled() {
        return this.image1Enabled;
    }

    public boolean getAlphaTestEnabled() {
        return this.alphaTestEnabled;
    }

    public void setAlphaTestEnable(boolean bl) {
        throw new UnsupportedOperationException();
    }

    public int getAlphaTestFunction() {
        return this.alphaTestFunction;
    }

    public void setAlphaTestFunc(int n) {
        throw new UnsupportedOperationException();
    }

    public float getAlphaTestReferenceValue() {
        return this.alphaTestReferenceValue.getValue();
    }

    public void setAlphaTestReferenceValue(float f2) {
        this.alphaTestReferenceValue.setValue(f2);
    }

    static {
        VERTEX_SHADER_FILE_NAMES = new String[]{"TransformMultiTextureMatrix"};
    }
}

