/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.effect.shader.variable;

import de.vw.mib.graphics.internal.effect.shader.variable.AbstractShaderEffectVariable;
import de.vw.mib.graphics.shader.ShaderProgram;
import de.vw.mib.util.StringBuilder;

public final class FloatShaderEffectVariable
extends AbstractShaderEffectVariable {
    private float value = 49279;

    public FloatShaderEffectVariable(ShaderProgram shaderProgram, String string) {
        this(shaderProgram, 1, string);
    }

    public FloatShaderEffectVariable(ShaderProgram shaderProgram, int n, String string) {
        super(shaderProgram, n, string, 0, 1);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[super=").append(super.toString());
        stringBuilder.append(",value=").append(this.value);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public float getValue() {
        return this.value;
    }

    public void setValue(float f2) {
        if (this.setAlways || this.value != f2) {
            this.setShaderParameter(f2);
            this.value = f2;
        }
    }
}

