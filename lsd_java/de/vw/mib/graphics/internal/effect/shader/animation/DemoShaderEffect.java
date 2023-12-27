/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.effect.shader.animation;

import de.vw.mib.graphics.effect.EffectPerformanceMetrics;
import de.vw.mib.graphics.effect.animation.DemoEffect;
import de.vw.mib.graphics.internal.effect.shader.ShaderEffectManager;
import de.vw.mib.graphics.internal.effect.shader.TransformColorShaderEffect;
import de.vw.mib.graphics.internal.effect.shader.variable.FloatShaderEffectVariable;
import java.util.List;

public final class DemoShaderEffect
extends TransformColorShaderEffect
implements DemoEffect {
    private static String[] VERTEX_SHADER_FILE_NAMES = new String[]{"TransformTexture"};
    private static final String UNIFORM_NAME_TIME;
    private final int type;
    private FloatShaderEffectVariable time;

    public DemoShaderEffect(ShaderEffectManager shaderEffectManager, int n) {
        super(shaderEffectManager);
        this.type = n;
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    protected void updateAllocationStatistics(EffectPerformanceMetrics effectPerformanceMetrics, boolean bl) {
        effectPerformanceMetrics.allocatedDemoEffects = effectPerformanceMetrics.allocatedDemoEffects + (bl ? 1 : -1);
    }

    @Override
    protected void getVertexShaderFilenames(List list) {
        for (int i2 = 0; i2 < VERTEX_SHADER_FILE_NAMES.length; ++i2) {
            list.add(VERTEX_SHADER_FILE_NAMES[i2]);
        }
    }

    @Override
    protected void getFragmentShaderFilenames(List list) {
        switch (this.type) {
            case 1: {
                list.add("demo/Fractal");
                break;
            }
            case 0: {
                list.add("demo/Plasma");
                break;
            }
            case 2: {
                list.add("demo/Rez");
                break;
            }
            default: {
                throw new IllegalArgumentException("Invalid type");
            }
        }
    }

    @Override
    protected void registerShaderEffectVariables() {
        super.registerShaderEffectVariables();
        this.time = this.addFloatShaderEffectVariable("u_time");
    }

    @Override
    public float getTime() {
        return this.time.getValue();
    }

    @Override
    public void setTime(float f2) {
        this.time.setValue(f2);
    }
}

