/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.effect.shader.variable;

import de.vw.mib.graphics.internal.effect.shader.variable.AbstractShaderEffectVariable;
import de.vw.mib.graphics.math.algebra.Matrix3f;
import de.vw.mib.graphics.shader.ShaderProgram;
import de.vw.mib.util.StringBuilder;

public final class Matrix3ShaderEffectVariable
extends AbstractShaderEffectVariable {
    private Matrix3f matrix = new Matrix3f(false);

    public Matrix3ShaderEffectVariable(ShaderProgram shaderProgram, String string) {
        super(shaderProgram, 1, string, 5, 1);
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

    public Matrix3f getMatrix() {
        return this.matrix;
    }

    public void setMatrix(Matrix3f matrix3f) {
        if (this.setAlways || !this.matrix.equals(matrix3f)) {
            this.setShaderParameter(matrix3f);
            this.matrix.set(matrix3f);
        }
    }
}

