/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.effect.shader;

import de.vw.mib.graphics.effect.NormalTransformationEffect;
import de.vw.mib.graphics.internal.effect.shader.ShaderEffectManager;
import de.vw.mib.graphics.internal.effect.shader.TransformShaderEffect;
import de.vw.mib.graphics.internal.effect.shader.variable.BooleanShaderEffectVariable;
import de.vw.mib.graphics.internal.effect.shader.variable.FloatShaderEffectVariable;
import de.vw.mib.graphics.internal.effect.shader.variable.Matrix3ShaderEffectVariable;
import de.vw.mib.graphics.math.algebra.Matrix3f;
import de.vw.mib.graphics.mesh.VertexFormat;
import de.vw.mib.graphics.shader.VertexAttributeBinding;
import java.util.List;

public abstract class TransformNormalShaderEffect
extends TransformShaderEffect
implements NormalTransformationEffect {
    protected static final String FILE_NAME_TRANSFORM_NORMAL_VERTEX_SHADER;
    private static final String ATTRIBUTE_NAME_NORMAL;
    private static final String UNIFORM_NAME_NORMAL_MATRIX;
    private static final String UNIFORM_NAME_NORMALIZE_NORMAL;
    private static final String UNIFORM_NAME_RESCALE_NORMAL;
    private static final String UNIFORM_NAME_RESCALE_NORMAL_FACTOR;
    private Matrix3ShaderEffectVariable normalMatrix;
    private BooleanShaderEffectVariable normalizeNormal;
    private BooleanShaderEffectVariable rescaleNormal;
    private FloatShaderEffectVariable rescaleNormalFactor;

    public TransformNormalShaderEffect(ShaderEffectManager shaderEffectManager) {
        super(shaderEffectManager);
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    protected void getVertexShaderDefines(List list) {
        super.getVertexShaderDefines(list);
    }

    @Override
    protected abstract void getVertexShaderFilenames(List list) {
    }

    @Override
    protected void getFragmentShaderDefines(List list) {
        super.getFragmentShaderDefines(list);
    }

    @Override
    protected abstract void getFragmentShaderFilenames(List list) {
    }

    @Override
    protected void getVertexFormat(VertexFormat vertexFormat) {
        super.getVertexFormat(vertexFormat);
        vertexFormat.addVertexAttribute(3, 3, 1);
    }

    @Override
    protected void getVertexAttributeBinding(VertexAttributeBinding vertexAttributeBinding) {
        super.getVertexAttributeBinding(vertexAttributeBinding);
        vertexAttributeBinding.addBinding(1, "a_normal");
    }

    @Override
    protected void registerShaderEffectVariables() {
        super.registerShaderEffectVariables();
        this.normalMatrix = this.addMatrix3ShaderEffectVariable("u_normalMatrix");
        this.normalizeNormal = this.addBooleanShaderEffectVariable("u_normalizeNormal");
        this.rescaleNormal = this.addBooleanShaderEffectVariable("u_rescaleNormal");
        this.rescaleNormalFactor = this.addFloatShaderEffectVariable("u_rescaleNormalFactor");
    }

    @Override
    public final Matrix3f getNormalMatrix() {
        return this.normalMatrix.getMatrix();
    }

    @Override
    public final void setNormalMatrix(Matrix3f matrix3f) {
        this.normalMatrix.setMatrix(matrix3f);
    }

    @Override
    public final boolean getNormalizeNormal() {
        return this.normalizeNormal.getValue();
    }

    @Override
    public final void setNormalizeNormal(boolean bl) {
        this.normalizeNormal.setValue(bl);
    }

    @Override
    public final boolean getRescaleNormal() {
        return this.rescaleNormal.getValue();
    }

    @Override
    public final void setRescaleNormal(boolean bl) {
        this.rescaleNormal.setValue(bl);
    }

    @Override
    public final float getRescaleNormalFactor() {
        return this.rescaleNormalFactor.getValue();
    }

    @Override
    public final void setRescaleNormalFactor(float f2) {
        this.rescaleNormalFactor.setValue(f2);
    }
}

