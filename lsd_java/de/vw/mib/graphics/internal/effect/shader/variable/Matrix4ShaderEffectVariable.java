/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.effect.shader.variable;

import de.vw.mib.graphics.internal.effect.shader.variable.AbstractShaderEffectVariable;
import de.vw.mib.graphics.math.algebra.Matrix4f;
import de.vw.mib.graphics.shader.ShaderProgram;
import de.vw.mib.util.StringBuilder;

public final class Matrix4ShaderEffectVariable
extends AbstractShaderEffectVariable {
    private Matrix4f matrix = new Matrix4f(false);

    public Matrix4ShaderEffectVariable(ShaderProgram shaderProgram, String string) {
        super(shaderProgram, 1, string, 6, 1);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[super=").append(super.toString());
        stringBuilder.append(",matrix=").append(this.matrix);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public Matrix4f getMatrix() {
        return this.matrix;
    }

    public void setMatrix(Matrix4f matrix4f) {
        if (this.setAlways || !this.matrix.equals(matrix4f)) {
            this.setShaderParameter(matrix4f);
            this.matrix.set(matrix4f);
        }
    }
}

