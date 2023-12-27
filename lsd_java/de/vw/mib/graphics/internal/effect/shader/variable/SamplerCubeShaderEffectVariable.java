/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.effect.shader.variable;

import de.vw.mib.graphics.internal.effect.shader.variable.AbstractShaderEffectVariable;
import de.vw.mib.graphics.internal.effect.shader.variable.SamplerShaderEffectVariable;
import de.vw.mib.graphics.shader.ShaderProgram;
import de.vw.mib.util.StringBuilder;

public final class SamplerCubeShaderEffectVariable
extends AbstractShaderEffectVariable
implements SamplerShaderEffectVariable {
    private int sampler = -1;

    public SamplerCubeShaderEffectVariable(ShaderProgram shaderProgram, String string) {
        super(shaderProgram, 1, string, 16, 1);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[super=").append(super.toString());
        stringBuilder.append(",sampler=").append(this.sampler);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public int getSampler() {
        return this.sampler;
    }

    public void setSampler(int n) {
        if (this.setAlways || this.sampler != n) {
            this.setShaderParameter(n);
            this.sampler = n;
        }
    }
}

