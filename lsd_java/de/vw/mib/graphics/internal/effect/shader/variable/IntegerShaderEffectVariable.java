/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.effect.shader.variable;

import de.vw.mib.graphics.internal.effect.shader.variable.AbstractShaderEffectVariable;
import de.vw.mib.graphics.shader.ShaderProgram;
import de.vw.mib.util.StringBuilder;

public final class IntegerShaderEffectVariable
extends AbstractShaderEffectVariable {
    private int value = -129;

    public IntegerShaderEffectVariable(ShaderProgram shaderProgram, String string) {
        this(shaderProgram, 1, string);
    }

    public IntegerShaderEffectVariable(ShaderProgram shaderProgram, int n, String string) {
        super(shaderProgram, n, string, 7, 1);
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

    public int getValue() {
        return this.value;
    }

    public void setValue(int n) {
        if (this.setAlways || this.value != n) {
            this.setShaderParameter(n);
            this.value = n;
        }
    }
}

