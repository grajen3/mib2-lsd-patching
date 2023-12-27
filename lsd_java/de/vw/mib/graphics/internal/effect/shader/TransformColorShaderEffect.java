/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.effect.shader;

import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.effect.ColorEffect;
import de.vw.mib.graphics.internal.effect.shader.ShaderEffectManager;
import de.vw.mib.graphics.internal.effect.shader.TransformShaderEffect;
import de.vw.mib.graphics.internal.effect.shader.variable.ColorShaderEffectVariable;
import de.vw.mib.graphics.mesh.VertexFormat;
import de.vw.mib.graphics.shader.VertexAttributeBinding;
import java.util.List;

public abstract class TransformColorShaderEffect
extends TransformShaderEffect
implements ColorEffect {
    private static final boolean USE_VERTEX_COLOR;
    protected static final String FILE_NAME_TRANSFORM_COLOR_VERTEX_SHADER;
    protected static final String FILE_NAME_TRANSFORM_TEXTURE_VERTEX_SHADER;
    private static final String ATTRIBUTE_NAME_COLOR;
    private static final String ATTRIBUTE_NAME_TEXCOORD0;
    protected static final String ATTRIBUTE_NAME_TEXCOORD1;
    private static final String UNIFORM_NAME_COLOR;
    private ColorShaderEffectVariable color;

    public TransformColorShaderEffect(ShaderEffectManager shaderEffectManager) {
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
        vertexFormat.addVertexAttribute(3, 4, 2, 0);
        vertexFormat.addVertexAttribute(3, 2, 3, 0);
    }

    @Override
    protected void getVertexAttributeBinding(VertexAttributeBinding vertexAttributeBinding) {
        super.getVertexAttributeBinding(vertexAttributeBinding);
        vertexAttributeBinding.addBinding(2, 0, "a_color");
        vertexAttributeBinding.addBinding(3, 0, "a_texCoord0");
    }

    @Override
    protected void registerShaderEffectVariables() {
        super.registerShaderEffectVariables();
        this.color = this.addColorShaderEffectVariable(0, "a_color");
    }

    @Override
    public final Color4f getColor() {
        return this.color.getColor();
    }

    @Override
    public final void setColor(Color4f color4f) {
        this.color.setColor(color4f);
    }
}

