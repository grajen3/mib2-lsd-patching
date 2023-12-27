/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.effect.shader.particle;

import de.vw.mib.graphics.effect.EffectPerformanceMetrics;
import de.vw.mib.graphics.effect.particle.ParticleEffect;
import de.vw.mib.graphics.internal.effect.shader.ShaderEffectManager;
import de.vw.mib.graphics.internal.effect.shader.TransformColorShaderEffect;
import de.vw.mib.graphics.internal.effect.shader.variable.FloatShaderEffectVariable;
import de.vw.mib.graphics.mesh.VertexFormat;
import de.vw.mib.graphics.shader.VertexAttributeBinding;
import java.util.List;

public final class ParticleShaderEffect
extends TransformColorShaderEffect
implements ParticleEffect {
    private static String[] VERTEX_SHADER_FILE_NAMES = new String[]{"Point"};
    private static String[] FRAGMENT_SHADER_FILE_NAMES = new String[]{"Point"};
    private static final String ATTRIBUTE_NAME_POINT_SIZE;
    private static final String UNIFORM_NAME_POINT_SIZE;
    private FloatShaderEffectVariable pointSize;

    public ParticleShaderEffect(ShaderEffectManager shaderEffectManager) {
        super(shaderEffectManager);
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    protected void updateAllocationStatistics(EffectPerformanceMetrics effectPerformanceMetrics, boolean bl) {
        effectPerformanceMetrics.allocatedParticleEffects = effectPerformanceMetrics.allocatedParticleEffects + (bl ? 1 : -1);
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
    protected void getVertexFormat(VertexFormat vertexFormat) {
        super.getVertexFormat(vertexFormat);
    }

    @Override
    protected void getVertexAttributeBinding(VertexAttributeBinding vertexAttributeBinding) {
        super.getVertexAttributeBinding(vertexAttributeBinding);
    }

    @Override
    protected void registerShaderEffectVariables() {
        super.registerShaderEffectVariables();
        this.pointSize = this.addFloatShaderEffectVariable("u_pointSize");
    }

    @Override
    public float getParticleSize() {
        return this.pointSize.getValue();
    }

    @Override
    public void setParticleSize(float f2) {
        this.pointSize.setValue(f2);
    }
}

