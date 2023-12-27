/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.effect.shader.variable;

import de.vw.mib.graphics.internal.effect.shader.variable.AbstractShaderEffectVariable;
import de.vw.mib.graphics.math.Tuple3f;
import de.vw.mib.graphics.math.Util;
import de.vw.mib.graphics.shader.ShaderProgram;
import de.vw.mib.util.StringBuilder;

public final class Float3ShaderEffectVariable
extends AbstractShaderEffectVariable {
    private Tuple3f value = new Tuple3f();

    public Float3ShaderEffectVariable(ShaderProgram shaderProgram, String string) {
        this(shaderProgram, 1, string);
    }

    public Float3ShaderEffectVariable(ShaderProgram shaderProgram, int n, String string) {
        super(shaderProgram, n, string, 2, 1);
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

    public Tuple3f getValue() {
        return this.value;
    }

    public void setValue(Tuple3f tuple3f) {
        if (this.setAlways || !this.value.equals(tuple3f)) {
            this.setShaderParameter(tuple3f);
            this.value.set(tuple3f);
        }
    }

    public void setValue(float f2, float f3, float f4) {
        if (this.setAlways || !Util.equalsEpsilon(this.value.x, f2) || !Util.equalsEpsilon(this.value.y, f3) || !Util.equalsEpsilon(this.value.z, f4)) {
            this.setShaderParameter(f2, f3, f4);
            this.value.set(f2, f3, f4);
        }
    }
}

