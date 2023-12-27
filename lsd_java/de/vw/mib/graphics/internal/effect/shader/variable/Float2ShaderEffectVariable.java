/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.effect.shader.variable;

import de.vw.mib.graphics.internal.effect.shader.variable.AbstractShaderEffectVariable;
import de.vw.mib.graphics.math.Tuple2f;
import de.vw.mib.graphics.math.Util;
import de.vw.mib.graphics.shader.ShaderProgram;
import de.vw.mib.util.StringBuilder;

public final class Float2ShaderEffectVariable
extends AbstractShaderEffectVariable {
    private Tuple2f value = new Tuple2f();

    public Float2ShaderEffectVariable(ShaderProgram shaderProgram, String string) {
        this(shaderProgram, 1, string);
    }

    public Float2ShaderEffectVariable(ShaderProgram shaderProgram, int n, String string) {
        super(shaderProgram, n, string, 1, 1);
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

    public Tuple2f getValue() {
        return this.value;
    }

    public void setValue(Tuple2f tuple2f) {
        if (this.setAlways || !this.value.equals(tuple2f)) {
            this.setShaderParameter(tuple2f);
            this.value.set(tuple2f);
        }
    }

    public void setValue(float f2, float f3) {
        if (this.setAlways || !Util.equalsEpsilon(this.value.x, f2) || !Util.equalsEpsilon(this.value.y, f3)) {
            this.setShaderParameter(f2, f3);
            this.value.set(f2, f3);
        }
    }
}

