/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.effect.shader.variable;

import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.internal.effect.shader.variable.AbstractShaderEffectVariable;
import de.vw.mib.graphics.shader.ShaderProgram;
import de.vw.mib.util.StringBuilder;

public final class ColorShaderEffectVariable
extends AbstractShaderEffectVariable {
    private Color4f color = new Color4f(Color4f.BLACK_TRANSPARENT);

    public ColorShaderEffectVariable(ShaderProgram shaderProgram, String string) {
        this(shaderProgram, 1, string);
    }

    public ColorShaderEffectVariable(ShaderProgram shaderProgram, int n, String string) {
        super(shaderProgram, n, string, 3, 1);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[super=").append(super.toString());
        stringBuilder.append(",color=").append(this.color);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public Color4f getColor() {
        return this.color;
    }

    public void setColor(Color4f color4f) {
        if (this.setAlways || !this.color.equals(color4f)) {
            this.setShaderParameter(color4f);
            this.color.set(color4f);
        }
    }
}

