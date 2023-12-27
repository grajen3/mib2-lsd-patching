/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.effect.shader.variable;

import de.vw.mib.graphics.internal.effect.shader.variable.AbstractShaderEffectVariable;
import de.vw.mib.graphics.math.algebra.Matrix2f;
import de.vw.mib.graphics.shader.ShaderProgram;
import de.vw.mib.util.StringBuilder;

public final class Matrix2ShaderEffectVariable
extends AbstractShaderEffectVariable {
    private Matrix2f matrix = new Matrix2f(false);

    public Matrix2ShaderEffectVariable(ShaderProgram shaderProgram, String string) {
        super(shaderProgram, 1, string, 4, 1);
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

    public Matrix2f getMatrix() {
        return this.matrix;
    }

    public void setMatrix(Matrix2f matrix2f) {
        if (this.setAlways || !this.matrix.equals(matrix2f)) {
            this.setShaderParameter(matrix2f);
            this.matrix.set(matrix2f);
        }
    }
}

