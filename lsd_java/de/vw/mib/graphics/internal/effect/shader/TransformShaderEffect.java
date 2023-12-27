/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.effect.shader;

import de.vw.mib.graphics.effect.TransformationEffect;
import de.vw.mib.graphics.internal.effect.shader.AbstractAssembledShaderEffect;
import de.vw.mib.graphics.internal.effect.shader.ShaderEffectManager;
import de.vw.mib.graphics.internal.effect.shader.variable.Matrix4ShaderEffectVariable;
import de.vw.mib.graphics.math.algebra.Matrix4f;
import de.vw.mib.graphics.mesh.VertexFormat;
import de.vw.mib.graphics.shader.VertexAttributeBinding;
import java.util.List;

public abstract class TransformShaderEffect
extends AbstractAssembledShaderEffect
implements TransformationEffect {
    public static final boolean GENERATE_MVP_MATRIX = System.getProperty("de.vw.mib.graphics.effect.generatemvpmatrix") != null;
    protected static final String FILE_NAME_TRANSFORM_VERTEX_SHADER;
    private static final String ATTRIBUTE_NAME_POSITION;
    private static final String UNIFORM_NAME_MODELVIEW_MATRIX;
    private static final String UNIFORM_NAME_PROJECTION_MATRIX;
    private static final String UNIFORM_NAME_MODELVIEWPROJECTION_MATRIX;
    private Matrix4ShaderEffectVariable modelViewMatrix;
    private Matrix4ShaderEffectVariable projectionMatrix;
    private Matrix4ShaderEffectVariable modelViewProjectionMatrix;

    public TransformShaderEffect(ShaderEffectManager shaderEffectManager) {
        super(shaderEffectManager);
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    protected void getVertexShaderDefines(List list) {
        super.getVertexShaderDefines(list);
        if (GENERATE_MVP_MATRIX) {
            list.add(TransformShaderEffect.createDefine("USE_MVP"));
        }
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
        vertexFormat.addVertexAttribute(3, 3, 0);
    }

    @Override
    protected void getVertexAttributeBinding(VertexAttributeBinding vertexAttributeBinding) {
        vertexAttributeBinding.addBinding(0, "a_position");
    }

    @Override
    protected void registerShaderEffectVariables() {
        this.modelViewMatrix = this.addMatrix4ShaderEffectVariable("u_modelViewMatrix");
        this.projectionMatrix = this.addMatrix4ShaderEffectVariable("u_projectionMatrix");
        if (GENERATE_MVP_MATRIX) {
            this.modelViewProjectionMatrix = this.addMatrix4ShaderEffectVariable("u_modelViewProjectionMatrix");
        }
    }

    @Override
    public final Matrix4f getModelViewMatrix() {
        return this.modelViewMatrix.getMatrix();
    }

    @Override
    public final void setModelViewMatrix(Matrix4f matrix4f) {
        this.modelViewMatrix.setMatrix(matrix4f);
    }

    @Override
    public final Matrix4f getProjectionMatrix() {
        return this.projectionMatrix.getMatrix();
    }

    @Override
    public final void setProjectionMatrix(Matrix4f matrix4f) {
        this.projectionMatrix.setMatrix(matrix4f);
    }

    @Override
    public final Matrix4f getModelViewProjectionMatrix() {
        if (GENERATE_MVP_MATRIX) {
            return this.modelViewProjectionMatrix.getMatrix();
        }
        return Matrix4f.IDENTITY;
    }

    @Override
    public final void setModelViewProjectionMatrix(Matrix4f matrix4f) {
        if (GENERATE_MVP_MATRIX) {
            this.modelViewProjectionMatrix.setMatrix(matrix4f);
        }
    }
}

