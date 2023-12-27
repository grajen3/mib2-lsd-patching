/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.effect.shader.procedural;

import de.vw.mib.graphics.effect.EffectPerformanceMetrics;
import de.vw.mib.graphics.effect.procedural.CheckerboardEffect;
import de.vw.mib.graphics.internal.effect.shader.ShaderEffectManager;
import de.vw.mib.graphics.internal.effect.shader.TransformColorShaderEffect;
import java.util.List;

public final class CheckerboardShaderEffect
extends TransformColorShaderEffect
implements CheckerboardEffect {
    private static String[] VERTEX_SHADER_FILE_NAMES = new String[]{"TransformTexture"};
    private static String[] FRAGMENT_SHADER_FILE_NAMES = new String[]{"Checkerboard"};

    public CheckerboardShaderEffect(ShaderEffectManager shaderEffectManager) {
        super(shaderEffectManager);
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    protected void updateAllocationStatistics(EffectPerformanceMetrics effectPerformanceMetrics, boolean bl) {
        effectPerformanceMetrics.allocatedCheckerboardEffects = effectPerformanceMetrics.allocatedCheckerboardEffects + (bl ? 1 : -1);
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
    }
}

